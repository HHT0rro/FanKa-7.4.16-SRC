package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeOnTapListener implements com.tencent.rtmp.ui.a {
    private long mNativeHandler;

    @CalledByNative
    public NativeOnTapListener(long j10) {
        this.mNativeHandler = j10;
    }

    private static native void nativeOnTap(long j10, int i10, int i11, int i12, int i13);

    @Override // com.tencent.rtmp.ui.a
    public synchronized void onTap(int i10, int i11, int i12, int i13) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnTap(j10, i10, i11, i12, i13);
        }
    }

    @CalledByNative
    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }
}
