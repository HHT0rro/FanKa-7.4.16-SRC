package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeOnZoomListener implements com.tencent.rtmp.ui.b {
    private long mNativeHandler;

    @CalledByNative
    public NativeOnZoomListener(long j10) {
        this.mNativeHandler = j10;
    }

    private static native void nativeOnZoom(long j10, float f10);

    @Override // com.tencent.rtmp.ui.b
    public void onZoom(float f10) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnZoom(j10, f10);
        }
    }

    @CalledByNative
    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }
}
