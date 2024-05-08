package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.bq;
import com.tencent.liteav.videoproducer.encoder.c;
import com.tencent.liteav.videoproducer.encoder.y;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ax {

    /* renamed from: i, reason: collision with root package name */
    private static final PixelFrame f44567i = new PixelFrame();

    /* renamed from: a, reason: collision with root package name */
    public final String f44568a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.liteav.videobase.utils.k f44569b;

    /* renamed from: e, reason: collision with root package name */
    public CustomHandler f44572e;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f44574g;

    /* renamed from: l, reason: collision with root package name */
    private bq f44578l;

    /* renamed from: m, reason: collision with root package name */
    private VideoEncoderDef.VideoEncoderDataListener f44579m;

    /* renamed from: n, reason: collision with root package name */
    private ServerVideoProducerConfig f44580n;

    /* renamed from: o, reason: collision with root package name */
    private long f44581o;

    /* renamed from: p, reason: collision with root package name */
    private long f44582p;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    private final IVideoReporter f44586t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    private final c f44587u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    private final bp f44588v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    private final VideoProducerDef.StreamType f44589w;

    /* renamed from: j, reason: collision with root package name */
    private final Bundle f44576j = new Bundle();

    /* renamed from: c, reason: collision with root package name */
    public final r f44570c = new r();

    /* renamed from: k, reason: collision with root package name */
    private final com.tencent.liteav.base.b.a f44577k = new com.tencent.liteav.base.b.a(1000);

    /* renamed from: d, reason: collision with root package name */
    public boolean f44571d = false;

    /* renamed from: q, reason: collision with root package name */
    private long f44583q = 0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f44584r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f44585s = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f44573f = false;

    /* renamed from: h, reason: collision with root package name */
    public final b f44575h = new b();

    /* renamed from: x, reason: collision with root package name */
    private final bq.a f44590x = new AnonymousClass1();

    /* renamed from: com.tencent.liteav.videoproducer.encoder.ax$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44593a;

        static {
            int[] iArr = new int[c.d.values().length];
            f44593a = iArr;
            try {
                iArr[c.d.CONTINUE_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44593a[c.d.RESTART_ENCODER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44593a[c.d.USE_HARDWARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44593a[c.d.USE_SOFTWARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f44593a[c.d.REPORT_ENCODE_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ax(@NonNull IVideoReporter iVideoReporter, @NonNull VideoProducerDef.StreamType streamType, boolean z10) {
        this.f44568a = "VideoEncodeController_" + ((Object) streamType) + "_" + hashCode();
        this.f44586t = iVideoReporter;
        this.f44587u = new c(EncodeAbilityProvider.getInstance().isHWHevcEncodeSupport(), EncodeAbilityProvider.getInstance().isSWHevcEncodeSupport(), iVideoReporter, streamType);
        this.f44588v = new bp(iVideoReporter, streamType);
        this.f44589w = streamType;
        this.f44574g = z10;
        this.f44569b = z10 ? new com.tencent.liteav.videobase.utils.b() : new com.tencent.liteav.videobase.utils.m();
    }

    public static /* synthetic */ void c(ax axVar) {
        LiteavLog.i(axVar.f44568a, "notifyEncodeFail");
        h.a aVar = h.a.ERR_VIDEO_ENCODE_FAIL;
        axVar.f44586t.notifyError(h.a.ERR_VIDEO_ENCODE_FATALERROR, "encode fail:".concat(String.valueOf(aVar)));
        VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener = axVar.f44579m;
        if (videoEncoderDataListener != null) {
            videoEncoderDataListener.onEncodedFail(aVar);
        }
    }

    public static /* synthetic */ void d(ax axVar) {
        if (axVar.f44584r) {
            return;
        }
        LiteavLog.i(axVar.f44568a, "encoder receive first frame");
        axVar.f44583q = SystemClock.elapsedRealtime();
        axVar.f44584r = true;
    }

    public static /* synthetic */ boolean j(ax axVar) {
        axVar.f44585s = true;
        return true;
    }

    public static /* synthetic */ boolean o(ax axVar) {
        axVar.f44573f = false;
        return false;
    }

    public static /* synthetic */ CustomHandler p(ax axVar) {
        axVar.f44572e = null;
        return null;
    }

    public static /* synthetic */ void q(ax axVar) {
        PixelFrame a10 = axVar.f44569b.a();
        if (a10 != null) {
            FrameMetaData metaData = a10.getMetaData();
            if (axVar.f44589w != VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO && metaData != null) {
                Size encodeSize = metaData.getEncodeSize();
                if (!encodeSize.isValid()) {
                    LiteavLog.w(axVar.f44568a, "encode size is invalid.".concat(String.valueOf(encodeSize)));
                } else {
                    VideoEncodeParams a11 = axVar.f44587u.a();
                    int i10 = a11.width;
                    int i11 = encodeSize.width;
                    if (i10 != i11 || a11.height != encodeSize.height) {
                        a11.width = i11;
                        a11.height = encodeSize.height;
                        axVar.f44587u.a(a11);
                    }
                }
            }
            bp bpVar = axVar.f44588v;
            if (bpVar.f44631f == null) {
                com.tencent.liteav.base.util.w wVar = new com.tencent.liteav.base.util.w(Looper.myLooper(), bpVar);
                bpVar.f44631f = wVar;
                wVar.a(0, 1000);
            }
            if (bpVar.f44628c.containsKey(Long.valueOf(a10.getTimestamp()))) {
                LiteavLog.i(bpVar.f44626a, "Duplicate timestamp!" + a10.getTimestamp());
            }
            bpVar.f44628c.put(Long.valueOf(a10.getTimestamp()), Long.valueOf(SystemClock.elapsedRealtime()));
            int i12 = AnonymousClass3.f44593a[axVar.f44587u.a(a10).ordinal()];
            if (i12 == 1) {
                axVar.a(a10);
                return;
            }
            if (i12 == 2) {
                VideoEncoderDef.a e2 = axVar.e();
                if (e2 != null) {
                    axVar.a(e2);
                }
                axVar.a(a10);
                return;
            }
            if (i12 == 3) {
                axVar.a(VideoEncoderDef.a.HARDWARE);
                axVar.a(a10);
                return;
            }
            if (i12 == 4) {
                axVar.a(VideoEncoderDef.a.SOFTWARE);
                axVar.a(a10);
                return;
            }
            if (i12 != 5) {
                if (a10 != f44567i) {
                    a10.release();
                }
                LiteavLog.i(axVar.f44568a, "encode ask instruction return default.");
            } else {
                if (a10 != f44567i) {
                    bp bpVar2 = axVar.f44588v;
                    if (bpVar2.f44628c.containsKey(Long.valueOf(a10.getTimestamp()))) {
                        bpVar2.f44628c.remove(Long.valueOf(a10.getTimestamp()));
                    }
                    a10.release();
                }
                axVar.a(bh.a(axVar), "onEncodedFail");
            }
        }
    }

    public final void b() {
        this.f44571d = true;
        this.f44569b.a(f44567i);
    }

    /* renamed from: com.tencent.liteav.videoproducer.encoder.ax$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 extends bq.a {
        public AnonymousClass1() {
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onEncodedFail(h.a aVar) {
            h.a aVar2 = h.a.ERR_CODE_NONE;
            ax.this.a(bm.a(this), "onEncodedFail");
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z10) {
            if (encodedVideoFrame == null) {
                LiteavLog.d(ax.this.f44568a, "onEncodedNAL encoded frame is null.");
                return;
            }
            synchronized (this) {
                if (!ax.this.f44573f) {
                    LiteavLog.i(ax.this.f44568a, "onEncodedNAL called when uninitialized!");
                } else {
                    ax.this.a(bl.a(this, encodedVideoFrame, z10), "");
                }
            }
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onOutputFormatChanged(MediaFormat mediaFormat) {
            LiteavLog.i(ax.this.f44568a, "onOutputFormatChanged: ".concat(String.valueOf(mediaFormat)));
            VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener = ax.this.f44579m;
            if (videoEncoderDataListener != null) {
                videoEncoderDataListener.onOutputFormatChanged(mediaFormat);
            }
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, boolean z10, int i10) {
            c cVar = ax.this.f44587u;
            cVar.f44655u = z10;
            cVar.f44656v = i10;
        }

        @Override // com.tencent.liteav.videoproducer.encoder.bq.a
        public final void a(boolean z10, int i10) {
            ax.this.a(bn.a(this, z10, i10), "onRpsFrameRateChanged");
        }

        @Override // com.tencent.liteav.videoproducer.encoder.bq.a
        public final void a() {
            LiteavLog.i(ax.this.f44568a, "onRequestRestart");
            ax axVar = ax.this;
            c cVar = axVar.f44587u;
            cVar.getClass();
            axVar.a(bo.a(cVar), "onRequestRestart");
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, EncodedVideoFrame encodedVideoFrame, boolean z10) {
            if (!ax.this.f44585s) {
                ax.j(ax.this);
                LiteavLog.i(ax.this.f44568a, "encode first frame cost time: " + (SystemClock.elapsedRealtime() - ax.this.f44583q));
            }
            if (!z10) {
                ax.this.a(encodedVideoFrame.frameIndex, encodedVideoFrame.gopIndex);
                c cVar = ax.this.f44587u;
                cVar.f44636b++;
                y yVar = cVar.f44657w;
                if (encodedVideoFrame.data == null) {
                    LiteavLog.w(yVar.f44732a, "encodedVideoFrame is null.");
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (elapsedRealtime <= yVar.f44740i + yVar.f44734c) {
                        yVar.f44735d++;
                    } else {
                        double d10 = (yVar.f44735d * 1000.0d) / (elapsedRealtime - r5);
                        yVar.f44733b = d10;
                        yVar.f44735d = 1L;
                        yVar.f44734c = elapsedRealtime;
                        y.a aVar = yVar.f44739h;
                        if (aVar != null) {
                            aVar.a(d10);
                        }
                    }
                    boolean z11 = encodedVideoFrame.nalType == com.tencent.liteav.videobase.common.c.IDR;
                    long remaining = encodedVideoFrame.data.remaining();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    if (z11) {
                        if (elapsedRealtime2 > yVar.f44741j + yVar.f44737f) {
                            long j10 = (long) (((yVar.f44738g * 8000.0d) / (elapsedRealtime2 - r1)) / 1024.0d);
                            yVar.f44736e = j10;
                            yVar.f44738g = 0L;
                            yVar.f44737f = elapsedRealtime2;
                            y.a aVar2 = yVar.f44739h;
                            if (aVar2 != null) {
                                aVar2.a(j10);
                            }
                        }
                    }
                    yVar.f44738g += remaining;
                }
                bp bpVar = ax.this.f44588v;
                if (bpVar.f44628c.containsKey(Long.valueOf(encodedVideoFrame.dts))) {
                    long elapsedRealtime3 = SystemClock.elapsedRealtime() - bpVar.f44628c.remove(Long.valueOf(encodedVideoFrame.dts)).longValue();
                    bpVar.f44630e++;
                    bpVar.f44629d += elapsedRealtime3;
                    bpVar.f44627b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODER_COST, Long.valueOf(elapsedRealtime3));
                }
            } else {
                LiteavLog.i(ax.this.f44568a, "got eos");
            }
            ax.this.f44575h.a(encodedVideoFrame);
            VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener = ax.this.f44579m;
            if (videoEncoderDataListener != null) {
                videoEncoderDataListener.onEncodedNAL(encodedVideoFrame, z10);
            }
        }
    }

    private VideoEncoderDef.a e() {
        bq bqVar = this.f44578l;
        if (bqVar == null) {
            return null;
        }
        return bqVar.g();
    }

    public static /* synthetic */ void b(ax axVar) {
        LiteavLog.d(axVar.f44568a, "stop");
        axVar.d();
        axVar.f44569b.b();
        axVar.f44584r = false;
        axVar.f44585s = false;
        c cVar = axVar.f44587u;
        cVar.b();
        cVar.f44651q = null;
        cVar.f44652r = null;
        cVar.f44645k = false;
        cVar.f44646l = false;
        cVar.f44637c = 0L;
        cVar.f44638d = 0.0f;
        cVar.f44639e = 0.0f;
        cVar.f44640f = 0.0f;
        cVar.f44641g = ShadowDrawableWrapper.COS_45;
        cVar.f44642h = false;
        cVar.f44644j = VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE;
        cVar.f44643i = false;
        cVar.f44647m = null;
        cVar.f44648n = c.e.NONE;
        cVar.f44649o = 0;
        cVar.f44650p = 0;
        cVar.f44655u = false;
        cVar.f44656v = 0;
        bp bpVar = axVar.f44588v;
        bpVar.f44628c.clear();
        bpVar.f44630e = 0L;
        bpVar.f44629d = 0L;
        b bVar = axVar.f44575h;
        synchronized (bVar.f44598a) {
            bVar.f44598a.clear();
        }
    }

    public final void a() {
        a(new Runnable() { // from class: com.tencent.liteav.videoproducer.encoder.ax.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (this) {
                    if (!ax.this.f44573f) {
                        LiteavLog.i(ax.this.f44568a, "not initialized.");
                        return;
                    }
                    LiteavLog.d(ax.this.f44568a, "uninitialize");
                    CustomHandler customHandler = ax.this.f44572e;
                    ax.o(ax.this);
                    ax.p(ax.this);
                    if (customHandler != null) {
                        customHandler.quitLooper();
                    }
                }
            }
        }, "uninitialize");
    }

    public final void a(TakeSnapshotListener takeSnapshotListener) {
        a(ay.a(this, takeSnapshotListener), "snapshot");
    }

    public static /* synthetic */ void a(ax axVar, TakeSnapshotListener takeSnapshotListener) {
        bq bqVar = axVar.f44578l;
        if (bqVar != null) {
            bqVar.a(takeSnapshotListener);
        }
    }

    private void d() {
        bq bqVar = this.f44578l;
        if (bqVar != null) {
            bqVar.c();
            this.f44578l.f();
            this.f44578l = null;
            this.f44586t.notifyEvent(h.b.EVT_VIDEO_ENCODE_STOP_SUCCESS, (Object) null, "stop encoder success");
        }
    }

    public final void c() {
        a(bi.a(this), "Stop");
    }

    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
        a(bd.a(this, serverVideoProducerConfig), "setServerConfig");
    }

    private void a(PixelFrame pixelFrame) {
        if (pixelFrame == f44567i) {
            bq bqVar = this.f44578l;
            if (bqVar != null) {
                bqVar.b();
                return;
            }
            return;
        }
        bq bqVar2 = this.f44578l;
        if (bqVar2 != null) {
            bqVar2.a(pixelFrame);
        }
        if (pixelFrame != null) {
            pixelFrame.release();
        }
    }

    private void a(@NonNull VideoEncoderDef.a aVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        VideoEncoderDef.a e2 = e();
        bq bqVar = this.f44578l;
        CodecType codecType = bqVar == null ? null : bqVar.e().codecType;
        bq bqVar2 = this.f44578l;
        VideoEncoderDef.ReferenceStrategy referenceStrategy = bqVar2 == null ? null : bqVar2.e().referenceStrategy;
        d();
        ServerVideoProducerConfig serverVideoProducerConfig = this.f44580n;
        if ((serverVideoProducerConfig == null || serverVideoProducerConfig.isHardwareEncoderAllowed()) && VideoEncoderDef.a.HARDWARE == aVar) {
            this.f44578l = new s(this.f44576j, this.f44586t, this.f44589w);
            LiteavLog.i(this.f44568a, "create HardwareVideoEncoder");
        } else {
            aVar = VideoEncoderDef.a.SOFTWARE;
            this.f44578l = new al(this.f44586t, this.f44589w);
            LiteavLog.i(this.f44568a, "create SoftwareVideoEncoder");
        }
        this.f44578l.a();
        this.f44578l.a(this.f44580n);
        VideoEncodeParams a10 = this.f44587u.a();
        a10.baseGopIndex = this.f44582p + 1;
        a10.baseFrameIndex = this.f44581o + 20;
        if (this.f44578l.a(a10, this.f44590x)) {
            this.f44586t.notifyEvent(h.b.EVT_VIDEO_ENCODE_START_SUCCESS, (Object) null, "start encoder success.");
        } else {
            this.f44587u.f44642h = true;
        }
        if (aVar != e2 || a10.codecType != codecType || a10.referenceStrategy != referenceStrategy) {
            this.f44586t.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODER_TYPE, this.f44589w.mValue, new VideoEncoderDef.EncoderProperty(aVar, a10.isEnablesRps() ? VideoEncoderDef.ReferenceStrategy.RPS : VideoEncoderDef.ReferenceStrategy.FIX_GOP, a10.codecType));
        }
        LiteavLog.i(this.f44568a, "open encoder cost time: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    public static /* synthetic */ void b(ax axVar, int i10) {
        bq bqVar = axVar.f44578l;
        if (bqVar != null) {
            bqVar.a(i10);
        }
    }

    public final void a(VideoEncoderDef.EncodeStrategy encodeStrategy) {
        a(bj.a(this, encodeStrategy), "setEncodeStrategy");
    }

    public static /* synthetic */ void a(ax axVar, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        if (encodeStrategy == null) {
            return;
        }
        c cVar = axVar.f44587u;
        if (cVar.f44644j != encodeStrategy) {
            LiteavLog.i(cVar.f44635a, "strategy = ".concat(String.valueOf(encodeStrategy)));
            cVar.f44644j = encodeStrategy;
            cVar.f44645k = true;
            EncodeAbilityProvider.getInstance().setRPSEncodeSupported(encodeStrategy != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY);
            cVar.f44653s.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODER_ABILITY, cVar.f44654t.mValue, EncodeAbilityProvider.getInstance().getEncodeAbility());
        }
    }

    public static /* synthetic */ void a(ax axVar) {
        if (!axVar.f44577k.a() || axVar.f44578l == null) {
            return;
        }
        LiteavLog.i(axVar.f44568a, "restartIDRFrame");
        axVar.f44578l.d();
    }

    public static /* synthetic */ void a(ax axVar, int i10) {
        bq bqVar = axVar.f44578l;
        if (bqVar != null) {
            bqVar.b(i10);
        }
    }

    public static /* synthetic */ void a(ax axVar, int i10, int i11) {
        bq bqVar = axVar.f44578l;
        if (bqVar != null) {
            bqVar.a(i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j10, long j11) {
        this.f44581o = j10;
        this.f44582p = j11;
    }

    public final void a(Runnable runnable, String str) {
        synchronized (this) {
            if (!this.f44573f) {
                LiteavLog.w(this.f44568a, "runOnEncodeThread before initialize! ".concat(String.valueOf(str)));
                return;
            }
            CustomHandler customHandler = this.f44572e;
            if (customHandler == null) {
                LiteavLog.w(this.f44568a, "ignore runnable: ".concat(String.valueOf(str)));
            } else if (Looper.myLooper() == customHandler.getLooper()) {
                runnable.run();
            } else {
                customHandler.post(runnable);
            }
        }
    }

    public static /* synthetic */ void a(ax axVar, VideoEncodeParams videoEncodeParams) {
        if (videoEncodeParams != null) {
            axVar.f44587u.a(videoEncodeParams);
            VideoEncodeParams a10 = axVar.f44587u.a();
            axVar.f44570c.a(a10.fps);
            bq bqVar = axVar.f44578l;
            if (bqVar != null) {
                bqVar.d(a10.fps);
                axVar.f44578l.c(a10.bitrate);
            }
        }
    }

    public static /* synthetic */ void a(ax axVar, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        if (videoEncodeParams != null && videoEncodeParams.width != 0 && videoEncodeParams.height != 0 && videoEncodeParams.fps != 0 && videoEncodeParams.gop != 0 && videoEncodeParams.bitrate != 0) {
            axVar.f44579m = videoEncoderDataListener;
            axVar.f44587u.a(videoEncodeParams);
            axVar.a(videoEncodeParams.baseFrameIndex, videoEncodeParams.baseGopIndex);
            axVar.f44570c.a(videoEncodeParams.fps);
            return;
        }
        LiteavLog.e(axVar.f44568a, "invalid params, Start failed.");
    }
}
