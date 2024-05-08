package com.tencent.liteav.videoproducer.encoder;

import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.bq;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SoftwareEncoderWrapper {
    private static final int MAX_CACHE_SIZE = 1;
    private bq.a mListener;
    private final IVideoReporter mReporter;
    private final VideoProducerDef.StreamType mStreamType;
    private VideoEncodeParams mVideoEncodeParams;
    private CustomHandler mWorkHandler;
    private final String mTAG = "SoftwareEncoderWrapper@" + hashCode();
    private final com.tencent.liteav.videobase.utils.m mFrameQueue = new com.tencent.liteav.videobase.utils.m();
    private long mNativeEncodeWrapper = 0;

    public SoftwareEncoderWrapper(@NonNull IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.mReporter = iVideoReporter;
        this.mStreamType = streamType;
    }

    private EncodedVideoFrame createBlackFrameIDRNalu(PixelFrame pixelFrame) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.nalType = com.tencent.liteav.videobase.common.c.IDR;
        encodedVideoFrame.codecType = CodecType.H264;
        encodedVideoFrame.profileType = com.tencent.liteav.videobase.common.d.BASELINE;
        encodedVideoFrame.data = nativeCreateBlackFrameIDRBuffer();
        encodedVideoFrame.dts = pixelFrame.getTimestamp();
        encodedVideoFrame.pts = pixelFrame.getTimestamp();
        encodedVideoFrame.gopFrameIndex = 0L;
        VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
        long j10 = videoEncodeParams.baseGopIndex;
        videoEncodeParams.baseGopIndex = 1 + j10;
        encodedVideoFrame.gopIndex = j10;
        encodedVideoFrame.frameIndex = 0L;
        encodedVideoFrame.refFrameIndex = 0L;
        encodedVideoFrame.width = pixelFrame.getWidth();
        encodedVideoFrame.height = pixelFrame.getHeight();
        return encodedVideoFrame;
    }

    @CalledByNative
    private static ByteBuffer createByteBuffer(int i10) {
        return ByteBuffer.allocateDirect(i10);
    }

    @CalledByNative
    private static EncodedVideoFrame createEncodedVideoFrameCallFromNative(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j10, long j11, long j12, int i14, int i15, long j13, long j14, long j15, boolean z10, int i16) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.nalType = com.tencent.liteav.videobase.common.c.a(i10);
        encodedVideoFrame.codecType = CodecType.a(i11);
        encodedVideoFrame.profileType = com.tencent.liteav.videobase.common.d.a(i12);
        encodedVideoFrame.data = byteBuffer;
        encodedVideoFrame.dts = j10;
        encodedVideoFrame.pts = j11;
        encodedVideoFrame.rotation = i13;
        encodedVideoFrame.frameIndex = j13;
        encodedVideoFrame.gopFrameIndex = 0L;
        encodedVideoFrame.gopIndex = j14;
        encodedVideoFrame.refFrameIndex = j15;
        encodedVideoFrame.nativePtr = j12;
        encodedVideoFrame.width = i14;
        encodedVideoFrame.height = i15;
        if (z10) {
            encodedVideoFrame.svcInfo = Integer.valueOf(i16);
        } else {
            encodedVideoFrame.svcInfo = null;
        }
        return encodedVideoFrame;
    }

    public static /* synthetic */ void lambda$ackRPSRecvFrameIndex$5(SoftwareEncoderWrapper softwareEncoderWrapper, int i10, int i11) {
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeSetRPSRefBitmap(j10, i10, i11);
        }
    }

    public static /* synthetic */ void lambda$encodeFrame$2(SoftwareEncoderWrapper softwareEncoderWrapper, PixelFrame pixelFrame) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        PixelFrame a10 = softwareEncoderWrapper.mFrameQueue.a();
        if (a10 == null) {
            return;
        }
        FrameMetaData metaData = a10.getMetaData();
        if (metaData != null && metaData.isBlackFrame()) {
            softwareEncoderWrapper.onEncodedNAL(softwareEncoderWrapper.createBlackFrameIDRNalu(pixelFrame));
        } else {
            long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
            if (j10 != 0) {
                nativeEncodeFrame(j10, a10.getBuffer(), a10.getWidth(), a10.getHeight(), a10.getTimestamp());
            }
        }
        a10.release();
        softwareEncoderWrapper.mReporter.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODE_TASK_COST, softwareEncoderWrapper.mStreamType.mValue, Integer.valueOf((int) (SystemClock.elapsedRealtime() - elapsedRealtime)));
    }

    public static /* synthetic */ void lambda$initialize$0(SoftwareEncoderWrapper softwareEncoderWrapper) {
        softwareEncoderWrapper.mNativeEncodeWrapper = nativeCreate(softwareEncoderWrapper);
        LiteavLog.i(softwareEncoderWrapper.mTAG, "initialize " + softwareEncoderWrapper.mNativeEncodeWrapper);
    }

    public static /* synthetic */ void lambda$restartIDRFrame$6(SoftwareEncoderWrapper softwareEncoderWrapper) {
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeRestartIDR(j10);
        }
    }

    public static /* synthetic */ void lambda$setBitrate$7(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeSetBitrate(j10, i10);
        }
    }

    public static /* synthetic */ void lambda$setFps$8(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeSetFps(j10, i10);
        }
    }

    public static /* synthetic */ void lambda$setRPSIFrameFPS$3(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeSetRpsIdrFps(j10, i10);
        }
    }

    public static /* synthetic */ void lambda$setRPSNearestREFSize$4(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeSetNearestRPS(j10, i10);
        }
    }

    public static /* synthetic */ void lambda$signalEndOfStream$9(SoftwareEncoderWrapper softwareEncoderWrapper) {
        bq.a aVar = softwareEncoderWrapper.mListener;
        if (aVar != null) {
            aVar.onEncodedNAL(new EncodedVideoFrame(), true);
        }
    }

    public static /* synthetic */ void lambda$start$1(SoftwareEncoderWrapper softwareEncoderWrapper, bq.a aVar, VideoEncodeParams videoEncodeParams) {
        softwareEncoderWrapper.mListener = aVar;
        softwareEncoderWrapper.mVideoEncodeParams = videoEncodeParams;
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeStart(j10, videoEncodeParams);
        }
        LiteavLog.i(softwareEncoderWrapper.mTAG, "start encoder");
    }

    public static /* synthetic */ void lambda$stopSync$10(SoftwareEncoderWrapper softwareEncoderWrapper) {
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeStop(j10);
        }
        softwareEncoderWrapper.mListener = null;
        LiteavLog.i(softwareEncoderWrapper.mTAG, "stop encoder");
    }

    public static /* synthetic */ void lambda$uninitialize$11(SoftwareEncoderWrapper softwareEncoderWrapper) {
        long j10 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j10 != 0) {
            nativeDestroy(j10);
            softwareEncoderWrapper.mNativeEncodeWrapper = 0L;
        }
        LiteavLog.i(softwareEncoderWrapper.mTAG, "destroy encode wrapper");
    }

    private static native long nativeCreate(SoftwareEncoderWrapper softwareEncoderWrapper);

    private static native ByteBuffer nativeCreateBlackFrameIDRBuffer();

    private static native void nativeDestroy(long j10);

    private static native int nativeEncodeFrame(long j10, ByteBuffer byteBuffer, int i10, int i11, long j11);

    public static native boolean nativeIsSoftwareHevcEncoderSupport();

    private static native void nativeRestartIDR(long j10);

    private static native void nativeSetBitrate(long j10, int i10);

    private static native void nativeSetFps(long j10, int i10);

    private static native int nativeSetNearestRPS(long j10, int i10);

    private static native int nativeSetRPSRefBitmap(long j10, int i10, int i11);

    private static native void nativeSetRpsIdrFps(long j10, int i10);

    private static native int nativeStart(long j10, VideoEncodeParams videoEncodeParams);

    private static native int nativeStop(long j10);

    @CalledByNative
    private void onEncodedFail() {
        bq.a aVar = this.mListener;
        if (aVar != null) {
            aVar.onEncodedFail(h.a.ERR_VIDEO_ENCODE_FAIL);
        }
    }

    @CalledByNative
    private void onEncodedNAL(EncodedVideoFrame encodedVideoFrame) {
        bq.a aVar = this.mListener;
        if (aVar != null) {
            aVar.onEncodedNAL(encodedVideoFrame, false);
        }
    }

    @CalledByNative
    private void onRpsFrameRateChanged(boolean z10, int i10) {
        bq.a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(z10, i10);
        }
    }

    private void runOrPostToWorkThread(Runnable runnable) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            customHandler.runOrPost(runnable);
        }
    }

    public void ackRPSRecvFrameIndex(int i10, int i11) {
        runOrPostToWorkThread(ah.a(this, i10, i11));
    }

    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame.getPixelFormatType() == GLConstants.PixelFormatType.I420 && pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_BUFFER) {
            this.mFrameQueue.a(pixelFrame);
            runOrPostToWorkThread(ae.a(this, pixelFrame));
        } else {
            LiteavLog.d(this.mTAG, "pixelFrame pixelFormat not I420 ");
        }
    }

    public synchronized void initialize() {
        if (this.mWorkHandler != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("software-encoder");
        handlerThread.start();
        CustomHandler customHandler = new CustomHandler(handlerThread.getLooper());
        this.mWorkHandler = customHandler;
        customHandler.runOrPost(z.a(this));
    }

    public boolean isInputQueueFull() {
        return this.mFrameQueue.c() > 0;
    }

    public void restartIDRFrame() {
        runOrPostToWorkThread(ai.a(this));
    }

    public void setBitrate(int i10) {
        runOrPostToWorkThread(aj.a(this, i10));
    }

    public void setFps(int i10) {
        runOrPostToWorkThread(ak.a(this, i10));
    }

    public void setRPSIFrameFPS(int i10) {
        runOrPostToWorkThread(af.a(this, i10));
    }

    public void setRPSNearestREFSize(int i10) {
        runOrPostToWorkThread(ag.a(this, i10));
    }

    public void signalEndOfStream() {
        LiteavLog.i(this.mTAG, "signalEndOfStream");
        runOrPostToWorkThread(aa.a(this));
    }

    public void start(VideoEncodeParams videoEncodeParams, bq.a aVar) {
        runOrPostToWorkThread(ad.a(this, aVar, new VideoEncodeParams(videoEncodeParams)));
    }

    public void stopSync(long j10) {
        runOrPostToWorkThread(ab.a(this));
    }

    public synchronized void uninitialize() {
        if (this.mWorkHandler == null) {
            return;
        }
        runOrPostToWorkThread(ac.a(this));
        this.mWorkHandler.quitLooper();
        this.mWorkHandler = null;
    }
}
