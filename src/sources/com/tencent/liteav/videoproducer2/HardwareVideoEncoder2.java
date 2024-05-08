package com.tencent.liteav.videoproducer2;

import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.egl.f;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.j;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.am;
import com.tencent.liteav.videoproducer.encoder.bq;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HardwareVideoEncoder2 {
    private static final int MAX_WAITE_TIME_MS = 2000;
    private EGLCore mEGLCore;
    private Surface mInputSurface;
    private long mNativeHandler;
    private final VideoEncodeParams mParams;
    private j mPixelFrameRenderer;
    private HWEncoderServerConfig mServerConfig;
    private Object mSharedContext;
    private am mSurfaceInputVideoEncoder;
    private String mTAG;
    private String mTraceId;

    @NonNull
    private final Size mSurfaceSize = new Size(0, 0);
    private final AtomicBoolean mNeedRestart = new AtomicBoolean(false);
    private final Bundle mSessionStates = new Bundle();
    private final b mThrottlers = new b();
    private long mPreFrameTimeStamp = 0;
    private final bq.a mVideoEncoderListener = new bq.a() { // from class: com.tencent.liteav.videoproducer2.HardwareVideoEncoder2.1
        @Override // com.tencent.liteav.videoproducer.encoder.bq.a
        public final void a() {
            HardwareVideoEncoder2.this.mNeedRestart.set(true);
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onEncodedFail(h.a aVar) {
            h.a aVar2 = h.a.ERR_CODE_NONE;
            HardwareVideoEncoder2.this.notifyEncodeFail();
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final synchronized void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z10) {
            if (HardwareVideoEncoder2.this.mNativeHandler != 0 && !z10) {
                HardwareVideoEncoder2 hardwareVideoEncoder2 = HardwareVideoEncoder2.this;
                long j10 = hardwareVideoEncoder2.mNativeHandler;
                ByteBuffer byteBuffer = encodedVideoFrame.data;
                int i10 = encodedVideoFrame.nalType.mValue;
                int i11 = encodedVideoFrame.profileType.mValue;
                int i12 = encodedVideoFrame.codecType.mValue;
                int i13 = encodedVideoFrame.rotation;
                long j11 = encodedVideoFrame.dts;
                long j12 = encodedVideoFrame.pts;
                long j13 = encodedVideoFrame.gopIndex;
                long j14 = encodedVideoFrame.gopFrameIndex;
                long j15 = encodedVideoFrame.frameIndex;
                long j16 = encodedVideoFrame.refFrameIndex;
                int i14 = encodedVideoFrame.width;
                int i15 = encodedVideoFrame.height;
                Integer num = encodedVideoFrame.svcInfo;
                hardwareVideoEncoder2.nativeOnEncodedNAL(j10, encodedVideoFrame, byteBuffer, i10, i11, i12, i13, j11, j12, j13, j14, j15, j16, i14, i15, num != null, num == null ? 0 : num.intValue());
                return;
            }
            LiteavLog.d(HardwareVideoEncoder2.this.mTAG, "onEncodedNAL mNativeHandler=%d,isEos=%b", Long.valueOf(HardwareVideoEncoder2.this.mNativeHandler), Boolean.valueOf(z10));
        }
    };

    @CalledByNative
    public HardwareVideoEncoder2(long j10, String str, VideoEncodeParams videoEncodeParams) {
        this.mTraceId = str;
        this.mTAG = str + "HardwareVideoEncoder2_" + hashCode();
        this.mNativeHandler = j10;
        this.mParams = videoEncodeParams;
    }

    @CalledByNative
    public static PixelFrame createPixelFrameByTexture(int i10, int i11, int i12, int i13, long j10, int i14, boolean z10, boolean z11, int i15, Object obj) {
        if (i12 != GLConstants.PixelBufferType.TEXTURE_2D.mValue) {
            GLConstants.PixelBufferType pixelBufferType = GLConstants.PixelBufferType.TEXTURE_OES;
        }
        GLConstants.PixelFormatType.RGBA.getValue();
        PixelFrame pixelFrame = new PixelFrame(i10, i11, 0, i12, i13);
        pixelFrame.setMirrorHorizontal(z10);
        pixelFrame.setMirrorVertical(z11);
        pixelFrame.setTextureId(i15);
        pixelFrame.setGLContext(obj);
        pixelFrame.setRotation(Rotation.a(i14));
        pixelFrame.setTimestamp(j10);
        return pixelFrame;
    }

    @CalledByNative
    public static Object getCurrentContext() {
        return OpenGlUtils.getCurrentContext();
    }

    private ServerVideoProducerConfig getServerVideoProducerConfig(HWEncoderServerConfig hWEncoderServerConfig) {
        ServerVideoProducerConfig serverVideoProducerConfig = new ServerVideoProducerConfig();
        serverVideoProducerConfig.setHardwareEncodeType(hWEncoderServerConfig.getHardwareEncodeType());
        serverVideoProducerConfig.setHardwareEncoderHighProfileEnable(hWEncoderServerConfig.getHardwareEncoderHighProfileEnable());
        serverVideoProducerConfig.setHardwareEncoderHighProfileSupport(hWEncoderServerConfig.getHardwareEncoderHighProfileSupport());
        Boolean isHardwareEncoderBitrateModeCBRSupported = hWEncoderServerConfig.isHardwareEncoderBitrateModeCBRSupported();
        if (isHardwareEncoderBitrateModeCBRSupported != null) {
            serverVideoProducerConfig.setHardwareEncoderBitrateModeCBRSupported(isHardwareEncoderBitrateModeCBRSupported.booleanValue());
        }
        return serverVideoProducerConfig;
    }

    private boolean initOpenGLComponents(Object obj, Surface surface) {
        if (surface == null) {
            LiteavLog.w(this.mThrottlers.a("NoSurface"), this.mTAG, "init opengl: surface is null.", new Object[0]);
            return false;
        }
        LiteavLog.d(this.mThrottlers.a("initGL"), this.mTAG, "initOpenGLComponents", new Object[0]);
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            Size size = this.mSurfaceSize;
            eGLCore.initialize(obj, surface, size.width, size.height);
            this.mSharedContext = obj;
            Size size2 = this.mSurfaceSize;
            this.mPixelFrameRenderer = new j(size2.width, size2.height);
            return true;
        } catch (f e2) {
            LiteavLog.e(this.mThrottlers.a("initGLError"), this.mTAG, "create EGLCore failed. error = ".concat(String.valueOf("VideoEncode: create EGLCore failed, EGLCode:" + e2.mErrorCode + " message:" + e2.getMessage())), e2);
            notifyStartEncodedFail();
            this.mEGLCore = null;
            return false;
        }
    }

    @CalledByNative
    public static boolean isInUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private native void nativeOnEncodedFail(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnEncodedNAL(long j10, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j11, long j12, long j13, long j14, long j15, long j16, int i14, int i15, boolean z10, int i16);

    private native void nativeOnStartEncodedFail(long j10);

    private boolean restart() {
        LiteavLog.d(this.mTAG, "reStart");
        stop();
        return start();
    }

    private boolean start() {
        if (this.mSurfaceInputVideoEncoder != null) {
            return this.mInputSurface != null;
        }
        LiteavLog.i(this.mTAG, "Start hw video encoder. %s", this.mParams);
        am amVar = new am(this.mSessionStates, new com.tencent.liteav.videobase.videobase.f(), this.mTraceId);
        this.mSurfaceInputVideoEncoder = amVar;
        amVar.a();
        this.mSurfaceInputVideoEncoder.a(getServerVideoProducerConfig(this.mServerConfig));
        Pair<Surface, Size> a10 = this.mSurfaceInputVideoEncoder.a(this.mParams, this.mVideoEncoderListener);
        this.mInputSurface = (Surface) a10.first;
        this.mSurfaceSize.set((Size) a10.second);
        if (this.mInputSurface != null) {
            return true;
        }
        notifyStartEncodedFail();
        return false;
    }

    private void stop() {
        uninitOpenGLComponents();
        Surface surface = this.mInputSurface;
        if (surface != null) {
            surface.release();
            this.mInputSurface = null;
        }
        am amVar = this.mSurfaceInputVideoEncoder;
        if (amVar != null) {
            amVar.d();
            this.mSurfaceInputVideoEncoder.e();
            this.mSurfaceInputVideoEncoder = null;
        }
    }

    private void uninitOpenGLComponents() {
        if (this.mEGLCore == null) {
            return;
        }
        LiteavLog.d(this.mThrottlers.a("uninitGL"), this.mTAG, "uninitOpenGLComponents", new Object[0]);
        try {
            this.mEGLCore.makeCurrent();
            j jVar = this.mPixelFrameRenderer;
            if (jVar != null) {
                jVar.a();
                this.mPixelFrameRenderer = null;
            }
        } catch (f e2) {
            LiteavLog.e(this.mThrottlers.a("unintGLError"), this.mTAG, "makeCurrent failed.", e2);
        }
        EGLCore.destroy(this.mEGLCore);
        this.mEGLCore = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: f -> 0x00d6, TryCatch #0 {f -> 0x00d6, blocks: (B:23:0x0041, B:25:0x0054, B:28:0x005d, B:31:0x0065, B:32:0x0074, B:34:0x0081, B:35:0x0087, B:37:0x009a, B:38:0x00bb, B:42:0x0069, B:45:0x0071), top: B:22:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009a A[Catch: f -> 0x00d6, TryCatch #0 {f -> 0x00d6, blocks: (B:23:0x0041, B:25:0x0054, B:28:0x005d, B:31:0x0065, B:32:0x0074, B:34:0x0081, B:35:0x0087, B:37:0x009a, B:38:0x00bb, B:42:0x0069, B:45:0x0071), top: B:22:0x0041 }] */
    @com.tencent.liteav.base.annotations.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encodeFrame(com.tencent.liteav.videobase.frame.PixelFrame r6) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer2.HardwareVideoEncoder2.encodeFrame(com.tencent.liteav.videobase.frame.PixelFrame):void");
    }

    public synchronized void notifyEncodeFail() {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnEncodedFail(j10);
        }
    }

    public synchronized void notifyStartEncodedFail() {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnStartEncodedFail(j10);
        }
    }

    @CalledByNative
    public synchronized void release() {
        LiteavLog.d(this.mTAG, "release");
        this.mNativeHandler = 0L;
        stop();
    }

    @CalledByNative
    public void requestKeyFrame() {
        am amVar = this.mSurfaceInputVideoEncoder;
        if (amVar != null) {
            amVar.b();
        }
    }

    @CalledByNative
    public void setBitrate(int i10) {
        LiteavLog.i(this.mTAG, "SetBitrate ".concat(String.valueOf(i10)));
        am amVar = this.mSurfaceInputVideoEncoder;
        if (amVar == null) {
            this.mParams.bitrate = i10;
        } else {
            amVar.a(i10);
        }
    }

    @CalledByNative
    public void setHWEncoderServerConfig(@NonNull HWEncoderServerConfig hWEncoderServerConfig) {
        this.mServerConfig = hWEncoderServerConfig;
        am amVar = this.mSurfaceInputVideoEncoder;
        if (amVar != null) {
            amVar.a(getServerVideoProducerConfig(hWEncoderServerConfig));
        }
    }

    @CalledByNative
    public void signalEndOfStream() {
        am amVar = this.mSurfaceInputVideoEncoder;
        if (amVar != null) {
            amVar.c();
        }
    }
}
