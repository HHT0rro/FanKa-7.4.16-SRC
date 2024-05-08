package com.nirvana.tools.crash;

import android.content.Context;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CrashSdk {
    public static final String CRASH_TYPE_ANR = "anr";
    public static final String CRASH_TYPE_JAVA = "java";
    public static final String CRASH_TYPE_JNI = "jni";
    public static final String CRASH_TYPE_UNEXP = "unexp";
    private static volatile CrashSdk mInstance;
    private CrashUcSdk mCrashUcSdk;
    private OnCrashCallbackProxy onCrashCallbackProxy;
    private ThreadUncaughtExceptionHandler mThreadExceptionHandler = null;
    private int ucInitDelayTime = -1;
    private boolean isUcEnable = true;

    private CrashSdk() {
    }

    public static CrashSdk getInstance() {
        if (mInstance == null) {
            synchronized (CrashSdk.class) {
                if (mInstance == null) {
                    mInstance = new CrashSdk();
                }
            }
        }
        return mInstance;
    }

    private void setCrashCallback() {
        ThreadUncaughtExceptionHandler threadUncaughtExceptionHandler = this.mThreadExceptionHandler;
        if (threadUncaughtExceptionHandler != null) {
            threadUncaughtExceptionHandler.setCrashCallback(this.onCrashCallbackProxy);
        }
        CrashUcSdk crashUcSdk = this.mCrashUcSdk;
        if (crashUcSdk != null) {
            crashUcSdk.setCrashCallback(this.onCrashCallbackProxy);
        }
    }

    public void enableUC(boolean z10) {
        this.isUcEnable = z10;
        CrashUcSdk crashUcSdk = this.mCrashUcSdk;
        if (crashUcSdk == null) {
            return;
        }
        crashUcSdk.setFeatureEnable(z10);
    }

    public void init(Context context) {
        CrashUcSdk crashUcSdk = new CrashUcSdk();
        this.mCrashUcSdk = crashUcSdk;
        crashUcSdk.setFeatureEnable(this.isUcEnable);
        this.mCrashUcSdk.setUcCrashDelayTime(this.ucInitDelayTime);
        this.mCrashUcSdk.init(context);
        ThreadUncaughtExceptionHandler threadUncaughtExceptionHandler = this.mThreadExceptionHandler;
        if (threadUncaughtExceptionHandler != null) {
            threadUncaughtExceptionHandler.unRegister();
        }
        this.onCrashCallbackProxy = new OnCrashCallbackProxy();
        ThreadUncaughtExceptionHandler threadUncaughtExceptionHandler2 = new ThreadUncaughtExceptionHandler(this.mCrashUcSdk);
        this.mThreadExceptionHandler = threadUncaughtExceptionHandler2;
        threadUncaughtExceptionHandler2.register();
        setCrashCallback();
    }

    public boolean isUcUsable() {
        CrashUcSdk crashUcSdk = this.mCrashUcSdk;
        if (crashUcSdk == null) {
            return false;
        }
        return crashUcSdk.isUcUsable();
    }

    public void registerSdk(SdkInfo sdkInfo) {
        if (this.mCrashUcSdk == null && this.mThreadExceptionHandler == null) {
            return;
        }
        this.mThreadExceptionHandler.initAddSdkConfig(sdkInfo);
        this.mCrashUcSdk.registerUc(sdkInfo);
    }

    public void setCrashCallback(String str, OnCrashCallback onCrashCallback) {
        this.onCrashCallbackProxy.registerCrashCallback(str, onCrashCallback);
    }

    public void setCustomInfo(Map<String, Object> map) {
        CrashUcSdk crashUcSdk = this.mCrashUcSdk;
        if (crashUcSdk != null) {
            crashUcSdk.updateConfig(map);
        }
    }

    public void setUcCrashDelayTime(int i10) {
        this.ucInitDelayTime = i10;
    }

    public boolean uploadException(SdkInfo sdkInfo, Thread thread, Throwable th, Map<String, String> map) {
        CrashUcSdk crashUcSdk = this.mCrashUcSdk;
        if (crashUcSdk == null || sdkInfo == null) {
            return false;
        }
        return crashUcSdk.uploadException(sdkInfo, thread, th, map);
    }
}
