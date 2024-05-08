package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.frame.PixelFrame;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeCustomVideoProcessListener implements CustomVideoProcessListener {
    private long mNativeVideoCustomProcessListener;

    @CalledByNative
    private NativeCustomVideoProcessListener(long j10) {
        this.mNativeVideoCustomProcessListener = j10;
    }

    private native void nativeOnGLContextCreated(long j10);

    private native void nativeOnGLContextDestroy(long j10);

    private native void nativeOnProcessFrame(long j10, PixelFrame pixelFrame, PixelFrame pixelFrame2, int i10, int i11, long j11, int i12);

    @CalledByNative
    private synchronized void reset() {
        this.mNativeVideoCustomProcessListener = 0L;
    }

    @CalledByNative
    private static void shadowCopy(PixelFrame pixelFrame, PixelFrame pixelFrame2) {
        if (pixelFrame == null || pixelFrame2 == null) {
            return;
        }
        pixelFrame2.copy(pixelFrame);
    }

    @Override // com.tencent.liteav.videoproducer.producer.CustomVideoProcessListener
    public synchronized void onGLContextCreated() {
        long j10 = this.mNativeVideoCustomProcessListener;
        if (j10 != 0) {
            nativeOnGLContextCreated(j10);
        }
    }

    @Override // com.tencent.liteav.videoproducer.producer.CustomVideoProcessListener
    public synchronized void onGLContextDestroy() {
        long j10 = this.mNativeVideoCustomProcessListener;
        if (j10 != 0) {
            nativeOnGLContextDestroy(j10);
        }
    }

    @Override // com.tencent.liteav.videoproducer.producer.CustomVideoProcessListener
    public synchronized void onProcessFrame(PixelFrame pixelFrame, PixelFrame pixelFrame2) {
        long j10 = this.mNativeVideoCustomProcessListener;
        if (j10 != 0) {
            nativeOnProcessFrame(j10, pixelFrame, pixelFrame2, pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getTimestamp(), pixelFrame.getPixelFormatType().getValue());
        }
    }
}
