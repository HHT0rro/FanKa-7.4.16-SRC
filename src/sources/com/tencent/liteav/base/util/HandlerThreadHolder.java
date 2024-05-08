package com.tencent.liteav.base.util;

import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HandlerThreadHolder {

    @NonNull
    private final HandlerThread mHandlerThread;

    @CalledByNative
    public HandlerThreadHolder(String str) {
        this.mHandlerThread = new HandlerThread(str);
    }

    @CalledByNative
    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }

    @CalledByNative
    public void start() {
        this.mHandlerThread.start();
    }
}
