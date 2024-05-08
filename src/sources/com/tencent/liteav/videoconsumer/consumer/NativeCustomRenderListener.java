package com.tencent.liteav.videoconsumer.consumer;

import androidx.annotation.Nullable;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeCustomRenderListener extends VideoRenderListener {
    public static final String TAG = "NativeCustomRenderListener";
    private long mNativeVideoCustomRenderListener;

    @CalledByNative
    private NativeCustomRenderListener(long j10) {
        this.mNativeVideoCustomRenderListener = j10;
    }

    private native void nativeOnCustomRenderFrame(long j10, PixelFrame pixelFrame, int i10, int i11, long j11, int i12);

    @CalledByNative
    private synchronized void reset() {
        this.mNativeVideoCustomRenderListener = 0L;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
    public synchronized void onRenderFrame(@Nullable PixelFrame pixelFrame, VideoRenderListener.a aVar) {
        if (pixelFrame != null) {
            if (this.mNativeVideoCustomRenderListener != 0) {
                if (pixelFrame.getPixelFormatType() == null) {
                    LiteavLog.i(TAG, "PixelFrame PixelFormatType is null.");
                    return;
                }
                nativeOnCustomRenderFrame(this.mNativeVideoCustomRenderListener, pixelFrame, pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getTimestamp(), pixelFrame.getPixelFormatType().getValue());
            }
        }
    }
}
