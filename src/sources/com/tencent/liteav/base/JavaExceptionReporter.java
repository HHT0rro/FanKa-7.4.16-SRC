package com.tencent.liteav.base;

import androidx.annotation.UiThread;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.annotations.MainDex;
import java.lang.Thread;

@JNINamespace("base::android")
@MainDex
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean mCrashAfterReport;
    private boolean mHandlingException;
    private final Thread.UncaughtExceptionHandler mParent;

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z10) {
        this.mParent = uncaughtExceptionHandler;
        this.mCrashAfterReport = z10;
    }

    @CalledByNative
    private static void installHandler(boolean z10) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), z10));
    }

    @UiThread
    public static void reportStackTrace(String str) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!this.mHandlingException) {
            this.mHandlingException = true;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mParent;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
