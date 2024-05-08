package com.tencent.liteav.videoconsumer2;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.alibaba.security.biometrics.service.build.ah;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.utils.c;
import com.tencent.liteav.videobase.utils.h;
import com.tencent.liteav.videobase.utils.j;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.t;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HardwareVideoDecoder2 implements SurfaceTexture.OnFrameAvailableListener {
    private static final int DRAIN_ERROR = -1;
    private static final int DRAIN_SUCCESS = 0;
    private static final int DRAIN_SUCCESS_MEET_END_OF_STREAM = 1;
    private final h mDecoderMediaFormatBuilder;
    private boolean mIsRealTime;
    private boolean mIsStarted;
    private long mNativeVideoDecoderImplAndroid;
    private Surface mOutputSurface;
    private SurfaceTexture mSurfaceTexture;
    private final String mTAG = "HardwareVideoDecoder2_" + hashCode();
    private final b mThrottlers = new b();
    private MediaCodec mMediaCodec = null;
    private final MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private boolean mEnableLimitMaxDecFrameBufferingInH264Sps = true;
    private final t mSPSModifier = new t();

    @CalledByNative
    public HardwareVideoDecoder2(boolean z10, boolean z11, int i10, int i11, long j10) {
        this.mIsRealTime = z10;
        this.mNativeVideoDecoderImplAndroid = j10;
        h hVar = new h();
        hVar.f43504e = z11 ? "video/hevc" : ah.f2598d;
        hVar.f43502c = i10;
        hVar.f43503d = i11;
        this.mDecoderMediaFormatBuilder = hVar;
    }

    private boolean configureDecoder(a aVar, boolean z10) {
        String str;
        h hVar = this.mDecoderMediaFormatBuilder;
        hVar.f43505f = z10;
        MediaFormat a10 = hVar.a();
        LiteavLog.i(this.mTAG, "mediaFormat:".concat(String.valueOf(a10)));
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(a10.getString(DatabaseSourceInfoStorage.COLUMN_MIME));
            aVar.f44168a = createDecoderByType;
            createDecoderByType.configure(a10, this.mOutputSurface, (MediaCrypto) null, 0);
            aVar.f44168a.setVideoScalingMode(1);
            aVar.f44168a.start();
            LiteavLog.i(this.mTAG, "Start MediaCodec(%s) success.", aVar.f44168a.getName());
            return true;
        } catch (Throwable th) {
            LiteavLog.e(this.mTAG, "Start MediaCodec failed.", th);
            destroyMediaCodec(aVar.f44168a);
            aVar.f44168a = null;
            h.c cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED;
            if (th instanceof IllegalArgumentException) {
                cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT;
                str = "VideoDecode: illegal argument, Start decoder failed";
            } else if (th instanceof IllegalStateException) {
                cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE;
                str = "VideoDecode: illegal state, Start decoder failed";
            } else {
                str = "VideoDecode: Start decoder failed";
            }
            aVar.f44169b = cVar;
            aVar.f44170c = str;
            aVar.f44171d = th;
            return false;
        }
    }

    private void destroyMediaCodec(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                try {
                    LiteavLog.i(this.mTAG, "mediaCodec stop");
                    mediaCodec.stop();
                    LiteavLog.i(this.mTAG, "mediaCodec release");
                    mediaCodec.release();
                } catch (Throwable th) {
                    LiteavLog.e(this.mTAG, "release MediaCodec failed.", th);
                }
            } catch (Throwable th2) {
                try {
                    LiteavLog.e(this.mTAG, "Stop MediaCodec failed." + th2.getMessage());
                    LiteavLog.i(this.mTAG, "mediaCodec release");
                    mediaCodec.release();
                } catch (Throwable th3) {
                    try {
                        LiteavLog.i(this.mTAG, "mediaCodec release");
                        mediaCodec.release();
                    } catch (Throwable th4) {
                        LiteavLog.e(this.mTAG, "release MediaCodec failed.", th4);
                    }
                    throw th3;
                }
            }
        }
    }

    private int drainDecodedFrameInternal() {
        int dequeueOutputBuffer;
        int i10 = 0;
        while (true) {
            if (i10 >= 3 || (dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, TimeUnit.MILLISECONDS.toMicros(10L))) == -1) {
                return -1;
            }
            if (dequeueOutputBuffer == -3) {
                LiteavLog.i(this.mTAG, "on output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                outputFormatChange();
            } else {
                if (dequeueOutputBuffer >= 0) {
                    this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                    if ((this.mBufferInfo.flags & 4) == 0) {
                        return 0;
                    }
                    LiteavLog.i(this.mTAG, "meet end of stream.");
                    return 1;
                }
                LiteavLog.d(this.mTAG, "dequeueOutputBuffer get invalid index: %d", Integer.valueOf(dequeueOutputBuffer));
            }
            i10++;
        }
    }

    private boolean feedDataToMediaCodec(EncodedVideoFrame encodedVideoFrame) {
        ByteBuffer byteBuffer;
        if (this.mMediaCodec == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            return false;
        }
        if (encodedVideoFrame != null && (encodedVideoFrame.isEosFrame || ((byteBuffer = encodedVideoFrame.data) != null && byteBuffer.remaining() != 0))) {
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            if (c.a(inputBuffers)) {
                LiteavLog.e(this.mTAG, "get invalid input buffers.");
                return false;
            }
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                return false;
            }
            if (!encodedVideoFrame.isEosFrame) {
                limitMaxDecFrameBufferingInH264Sps(encodedVideoFrame);
                int remaining = encodedVideoFrame.data.remaining();
                inputBuffers[dequeueInputBuffer].put(encodedVideoFrame.data);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, remaining, TimeUnit.MILLISECONDS.toMicros(encodedVideoFrame.pts), 0);
            } else {
                LiteavLog.i(this.mTAG, "feedDataToMediaCodec BUFFER_FLAG_END_OF_STREAM");
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            }
            return true;
        }
        LiteavLog.w(this.mTAG, "receive empty buffer.");
        return true;
    }

    private byte[] getSpsData(byte[] bArr, int[] iArr) {
        int i10 = 0;
        while (true) {
            if (i10 + 4 >= bArr.length || (i10 = EncodedVideoFrame.getNextNALHeaderPos(i10, ByteBuffer.wrap(bArr))) < 0) {
                break;
            }
            if ((bArr[i10] & 31) == 7) {
                iArr[0] = i10;
                break;
            }
        }
        if (iArr[0] < 0) {
            return null;
        }
        int length = bArr.length - iArr[0];
        int i11 = iArr[0];
        while (true) {
            int i12 = i11 + 3;
            if (i12 >= bArr.length) {
                break;
            }
            if ((bArr[i11] != 0 || bArr[i11 + 1] != 0 || bArr[i11 + 2] != 1) && (bArr[i11] != 0 || bArr[i11 + 1] != 0 || bArr[i11 + 2] != 0 || bArr[i12] != 1)) {
                i11++;
            }
        }
        length = i11 - iArr[0];
        byte[] bArr2 = new byte[length];
        System.arraycopy((Object) bArr, iArr[0], (Object) bArr2, 0, length);
        return bArr2;
    }

    private void handleDecoderError(h.c cVar, String str, Object... objArr) {
        LiteavLog.e(this.mTAG, str, objArr);
        nativeOnDecodedFrameFailed(this.mNativeVideoDecoderImplAndroid, com.tencent.liteav.videobase.videobase.h.a(cVar));
    }

    private boolean initializeSurface(int i10) {
        LiteavLog.i(this.mTAG, "initialize surface");
        synchronized (this) {
            try {
                this.mSurfaceTexture = new SurfaceTexture(i10);
                this.mOutputSurface = new Surface(this.mSurfaceTexture);
                this.mSurfaceTexture.setOnFrameAvailableListener(this);
            } catch (Surface.OutOfResourcesException e2) {
                LiteavLog.e(this.mThrottlers.a("surface"), this.mTAG, "create SurfaceTexture failed.", e2);
                handleDecoderError(h.c.WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE, "VideoDecode: insufficient resource, Start decoder failed:" + e2.getMessage(), new Object[0]);
                return false;
            }
        }
        LiteavLog.i(this.mThrottlers.a("initializeSurface"), this.mTAG, "initializeSurface", new Object[0]);
        return true;
    }

    private void limitMaxDecFrameBufferingInH264Sps(EncodedVideoFrame encodedVideoFrame) {
        byte[] a10;
        ByteBuffer b4;
        if (encodedVideoFrame.isIDRFrame() && encodedVideoFrame.codecType == CodecType.H264 && this.mEnableLimitMaxDecFrameBufferingInH264Sps && this.mIsRealTime && (a10 = j.a(encodedVideoFrame.data.remaining())) != null) {
            encodedVideoFrame.data.get(a10);
            encodedVideoFrame.data.rewind();
            int[] iArr = {-1};
            byte[] spsData = getSpsData(a10, iArr);
            if (spsData == null || iArr[0] < 0) {
                return;
            }
            byte[] bArr = null;
            try {
                bArr = this.mSPSModifier.a(spsData);
            } catch (Throwable th) {
                LiteavLog.e(this.mTAG, "modify dec buffer error ", th);
            }
            if (bArr == null || (b4 = j.b((a10.length - spsData.length) + bArr.length)) == null) {
                return;
            }
            encodedVideoFrame.data = b4;
            if (iArr[0] > 0) {
                b4.put(a10, 0, iArr[0]);
            }
            encodedVideoFrame.data.put(bArr);
            encodedVideoFrame.data.put(a10, iArr[0] + spsData.length, (a10.length - iArr[0]) - spsData.length);
            encodedVideoFrame.data.rewind();
        }
    }

    private native void nativeOnDecodedFrameFailed(long j10, int i10);

    private native void nativeOnFrameAvailable(long j10, long j11);

    private void outputFormatChange() {
        MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
        LiteavLog.i(this.mTAG, "decode output format changed: ".concat(String.valueOf(outputFormat)));
        LiteavLog.i(this.mTAG, "cropWidth: %d, cropHeight: %d, frameWidth: %d, frameHeight: %d", Integer.valueOf(Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1), Integer.valueOf(Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1), Integer.valueOf(outputFormat.getInteger("width")), Integer.valueOf(outputFormat.getInteger("height")));
    }

    private void uninitializeSurface() {
        LiteavLog.i(this.mTAG, "uninitialize surface");
        synchronized (this) {
            Surface surface = this.mOutputSurface;
            if (surface != null) {
                surface.release();
                this.mOutputSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }
    }

    @CalledByNative
    public boolean decodeFrame(EncodedVideoFrame encodedVideoFrame) {
        if (this.mMediaCodec == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            return false;
        }
        if (encodedVideoFrame == null) {
            return true;
        }
        try {
            if (!feedDataToMediaCodec(encodedVideoFrame)) {
                encodedVideoFrame.release();
                return false;
            }
        } catch (Throwable th) {
            LiteavLog.e(this.mTAG, "decode failed.", th);
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, "VideoDecode: decode error, restart decoder message:" + th.getMessage(), new Object[0]);
        }
        encodedVideoFrame.release();
        return true;
    }

    @CalledByNative
    public int drainDecodedFrame() {
        try {
            return drainDecodedFrameInternal();
        } catch (Throwable th) {
            LiteavLog.e(this.mTAG, "decode failed.", th);
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, "VideoDecode: decode error, restart decoder message:" + th.getMessage(), new Object[0]);
            return -1;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
            if (surfaceTexture2 != null && surfaceTexture2 == surfaceTexture) {
                long millis = TimeUnit.NANOSECONDS.toMillis(surfaceTexture.getTimestamp());
                if (millis == 0) {
                    millis = TimeUnit.MICROSECONDS.toMillis(this.mBufferInfo.presentationTimeUs);
                }
                nativeOnFrameAvailable(this.mNativeVideoDecoderImplAndroid, millis);
            }
        }
    }

    @CalledByNative
    public void setEnableVui(boolean z10) {
        this.mEnableLimitMaxDecFrameBufferingInH264Sps = z10;
    }

    @CalledByNative
    public boolean start(int i10) {
        if (this.mIsStarted) {
            return true;
        }
        LiteavLog.i(this.mTAG, "Start");
        byte b4 = 0;
        if (!initializeSurface(i10)) {
            return false;
        }
        a aVar = new a(b4);
        if (!configureDecoder(aVar, this.mIsRealTime) && !configureDecoder(aVar, false)) {
            handleDecoderError(aVar.f44169b, "decoder config fail, message:" + aVar.f44170c + " exception:" + aVar.f44171d.getMessage(), new Object[0]);
            return false;
        }
        this.mMediaCodec = aVar.f44168a;
        this.mIsStarted = true;
        LiteavLog.i(this.mTAG, "Start succeed");
        return true;
    }

    @CalledByNative
    public void stop() {
        LiteavLog.i(this.mTAG, "stop");
        if (this.mIsStarted) {
            destroyMediaCodec(this.mMediaCodec);
            this.mMediaCodec = null;
            uninitializeSurface();
            this.mIsStarted = false;
        }
    }

    @CalledByNative
    public float[] updateTexImage() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return null;
        }
        try {
            float[] fArr = new float[16];
            surfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(fArr);
            return fArr;
        } catch (Throwable th) {
            LiteavLog.w(this.mThrottlers.a("updateImage"), this.mTAG, "updateTexImage exception: ".concat(String.valueOf(th)), new Object[0]);
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public MediaCodec f44168a;

        /* renamed from: b, reason: collision with root package name */
        public h.c f44169b;

        /* renamed from: c, reason: collision with root package name */
        public String f44170c;

        /* renamed from: d, reason: collision with root package name */
        public Throwable f44171d;

        private a() {
            this.f44168a = null;
            this.f44169b = null;
            this.f44170c = null;
            this.f44171d = null;
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }
}
