package com.tencent.liteav.videoconsumer.decoder;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.VideoConsumerServerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.bk;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SoftwareVideoDecoder implements bk {
    private static final String TAG = "SoftwareVideoDecoder";
    private final boolean mIsUseHevc;
    private bl mListener;
    private long mNativeVideoDecoderWrapper = 0;
    private com.tencent.liteav.videobase.frame.i mPixelFramePool;

    @NonNull
    private final IVideoReporter mReporter;

    public SoftwareVideoDecoder(@NonNull IVideoReporter iVideoReporter, boolean z10) {
        this.mReporter = iVideoReporter;
        this.mIsUseHevc = z10;
    }

    @CalledByNative
    private ByteBuffer getByteBufferFromPixelFrame(PixelFrame pixelFrame) {
        return pixelFrame.getBuffer();
    }

    private void handleDecoderError(h.c cVar, String str) {
        this.mReporter.notifyWarning(cVar, str);
        bl blVar = this.mListener;
        if (blVar != null) {
            blVar.i();
        }
    }

    private static native void nativeAbandonDecodingFrames(long j10);

    private static native long nativeCreate(SoftwareVideoDecoder softwareVideoDecoder);

    private static native int nativeDecodeFrame(long j10, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, int i10, int i11, int i12, long j11, long j12);

    private static native void nativeDestroy(long j10);

    public static native boolean nativeIsRpsDecodeSupport();

    public static native boolean nativeIsSoftwareHevcDecoderSupport();

    private static native int nativeStart(long j10, boolean z10);

    private static native int nativeStop(long j10);

    @CalledByNative
    private PixelFrame obtainPixelFrame(int i10, int i11, int i12, int i13, long j10, int i14, int i15) {
        GLConstants.PixelFormatType a10 = GLConstants.PixelFormatType.a(i10);
        if (a10 == null) {
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_ERROR_NOT_SUPPORT_PIXEL_FORMAT_TYPE, "unknown format:".concat(String.valueOf(i10)));
            LiteavLog.e(TAG, "obtainPixelFrame formatType: ".concat(String.valueOf(i10)));
            return null;
        }
        com.tencent.liteav.videobase.frame.i iVar = this.mPixelFramePool;
        if (iVar == null) {
            LiteavLog.i(TAG, "obtainPixelFrame mPixelFramePool is null.");
            return null;
        }
        PixelFrame a11 = iVar.a(i11, i12, GLConstants.PixelBufferType.BYTE_BUFFER, a10);
        a11.setRotation(Rotation.a(i13));
        a11.setTimestamp(j10);
        a11.setColorRange(GLConstants.ColorRange.a(i15));
        a11.setColorSpace(GLConstants.ColorSpace.a(i14));
        return a11;
    }

    @CalledByNative
    private void onDecodedFrame(PixelFrame pixelFrame, long j10) {
        if (j10 != 0) {
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, "VideoDecode: decode error, errCode:".concat(String.valueOf(j10)));
            LiteavLog.e(TAG, "decode failed.".concat(String.valueOf(j10)));
            if (pixelFrame != null) {
                pixelFrame.release();
                return;
            }
            return;
        }
        if (pixelFrame != null) {
            bl blVar = this.mListener;
            if (blVar != null) {
                blVar.a(pixelFrame, pixelFrame.getTimestamp());
            }
            pixelFrame.release();
        }
    }

    public void abandonDecodingFrames() {
        long j10 = this.mNativeVideoDecoderWrapper;
        if (j10 == 0) {
            LiteavLog.w(TAG, "decoder has already stopped");
            return;
        }
        nativeAbandonDecodingFrames(j10);
        bl blVar = this.mListener;
        if (blVar != null) {
            blVar.j();
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public boolean decode(EncodedVideoFrame encodedVideoFrame) {
        bl blVar;
        if (encodedVideoFrame == null) {
            return false;
        }
        if (encodedVideoFrame.isEosFrame && (blVar = this.mListener) != null) {
            blVar.k();
            return true;
        }
        ByteBuffer byteBuffer = encodedVideoFrame.data;
        if (byteBuffer == null || byteBuffer.remaining() == 0) {
            return false;
        }
        nativeDecodeFrame(this.mNativeVideoDecoderWrapper, encodedVideoFrame, encodedVideoFrame.data, encodedVideoFrame.nalType.mValue, encodedVideoFrame.codecType.mValue, encodedVideoFrame.rotation, encodedVideoFrame.pts, encodedVideoFrame.dts);
        encodedVideoFrame.release();
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public bk.a getDecoderType() {
        return bk.a.SOFTWARE;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public void initialize() {
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public void setScene(VideoDecoderDef.ConsumerScene consumerScene) {
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public void setServerConfig(VideoConsumerServerConfig videoConsumerServerConfig) {
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public void start(Object obj, bl blVar) {
        if (this.mNativeVideoDecoderWrapper != 0) {
            LiteavLog.w(TAG, "decoder is already started!");
            return;
        }
        this.mPixelFramePool = new com.tencent.liteav.videobase.frame.i();
        this.mListener = blVar;
        long nativeCreate = nativeCreate(this);
        this.mNativeVideoDecoderWrapper = nativeCreate;
        if (nativeCreate == 0) {
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_START_FAILED_OUT_OF_MEMORY, "VideoDecode: out of memory, Start decoder failed");
            LiteavLog.e(TAG, "create native instance failed.");
        } else if (nativeStart(nativeCreate, this.mIsUseHevc) != 0) {
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_START_FAILED, "VideoDecode: Start decoder failed");
            LiteavLog.e(TAG, "Start software decoder failed.");
        } else {
            this.mReporter.notifyEvent(h.b.EVT_VIDEO_DECODE_START_SUCCESS, (Object) null, "Start decoder success");
            LiteavLog.i(TAG, "decoder Start success.");
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public void stop() {
        if (this.mNativeVideoDecoderWrapper == 0) {
            LiteavLog.w(TAG, "decoder has already stopped");
            return;
        }
        com.tencent.liteav.videobase.frame.i iVar = this.mPixelFramePool;
        if (iVar != null) {
            iVar.b();
        }
        nativeStop(this.mNativeVideoDecoderWrapper);
        nativeDestroy(this.mNativeVideoDecoderWrapper);
        this.mNativeVideoDecoderWrapper = 0L;
        LiteavLog.i(TAG, "decoder stop.");
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public void uninitialize() {
    }
}
