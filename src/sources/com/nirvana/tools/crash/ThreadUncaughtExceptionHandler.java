package com.nirvana.tools.crash;

import android.os.Looper;
import android.util.Log;
import java.lang.Thread;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class ThreadUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private CrashUcSdk mCrashUcSdk;
    private Thread.UncaughtExceptionHandler mOtherExceptionHandler;
    private StackAnalyzer mStackAnalyzer = new StackAnalyzer();
    private OnCrashCallbackProxy onCrashCallbackProxy;

    public ThreadUncaughtExceptionHandler(CrashUcSdk crashUcSdk) {
        this.mCrashUcSdk = crashUcSdk;
    }

    public void initAddSdkConfig(SdkInfo sdkInfo) {
        this.mStackAnalyzer.initAddSdkConfig(sdkInfo);
    }

    public boolean isMainThread(Thread thread) {
        return Looper.getMainLooper().getThread().getId() == thread.getId();
    }

    public void register() {
        this.mOtherExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void register(Thread thread) {
        this.mOtherExceptionHandler = thread.getUncaughtExceptionHandler();
        thread.setUncaughtExceptionHandler(this);
    }

    public void setCrashCallback(OnCrashCallbackProxy onCrashCallbackProxy) {
        this.onCrashCallbackProxy = onCrashCallbackProxy;
    }

    public void throw2OtherHandler(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mOtherExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public void unRegister() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mOtherExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean isMainThread;
        String uuid;
        String stackTraceString;
        SdkInfo checkJavaCrashInSdk;
        try {
            isMainThread = isMainThread(thread);
            uuid = UUID.randomUUID().toString();
            stackTraceString = Log.getStackTraceString(th);
            checkJavaCrashInSdk = this.mStackAnalyzer.checkJavaCrashInSdk(stackTraceString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ((isMainThread || checkJavaCrashInSdk == null) ? false : true) {
            OnCrashCallbackProxy onCrashCallbackProxy = this.onCrashCallbackProxy;
            if (onCrashCallbackProxy != null) {
                onCrashCallbackProxy.onCrashOccurred(thread.getName(), checkJavaCrashInSdk.getSdkName(), stackTraceString, uuid, true, CrashSdk.CRASH_TYPE_JAVA);
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("wk_crashid", uuid);
            this.mCrashUcSdk.uploadException(checkJavaCrashInSdk, thread, th, hashMap);
            return;
        }
        if (checkJavaCrashInSdk != null && !this.mCrashUcSdk.isUcUsable() && this.onCrashCallbackProxy != null) {
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("wk_crashid", uuid);
            this.mCrashUcSdk.generateCustomLogUploadItrace(checkJavaCrashInSdk, thread, th, hashMap2);
            this.onCrashCallbackProxy.onCrashOccurred(thread.getName(), checkJavaCrashInSdk.getSdkName(), stackTraceString, uuid, false, CrashSdk.CRASH_TYPE_JAVA);
            this.onCrashCallbackProxy.onCrashUploadFailed(checkJavaCrashInSdk.getSdkName(), stackTraceString, uuid);
        }
        throw2OtherHandler(thread, th);
    }
}
