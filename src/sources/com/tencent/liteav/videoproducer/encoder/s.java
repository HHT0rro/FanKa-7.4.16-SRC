package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.bq;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s implements bq {

    /* renamed from: a, reason: collision with root package name */
    public volatile bq.a f44699a;

    /* renamed from: b, reason: collision with root package name */
    private final String f44700b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final IVideoReporter f44701c;

    /* renamed from: e, reason: collision with root package name */
    private final am f44703e;

    /* renamed from: g, reason: collision with root package name */
    private final VideoProducerDef.StreamType f44705g;

    /* renamed from: h, reason: collision with root package name */
    private Surface f44706h;

    /* renamed from: i, reason: collision with root package name */
    private EGLCore f44707i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.j f44708j;

    /* renamed from: k, reason: collision with root package name */
    private VideoEncodeParams f44709k;

    /* renamed from: m, reason: collision with root package name */
    private volatile Handler f44711m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.liteav.videobase.egl.c f44712n;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Size f44702d = new Size(0, 0);

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f44704f = new com.tencent.liteav.base.b.b();

    /* renamed from: l, reason: collision with root package name */
    private long f44710l = 0;

    /* renamed from: p, reason: collision with root package name */
    private final bq.a f44714p = new AnonymousClass1();

    /* renamed from: o, reason: collision with root package name */
    private final com.tencent.liteav.videobase.utils.n f44713o = new com.tencent.liteav.videobase.utils.n("hwEn" + hashCode());

    public s(Bundle bundle, @NonNull IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.f44703e = new am(bundle, iVideoReporter, streamType);
        this.f44701c = iVideoReporter;
        this.f44705g = streamType;
        this.f44700b = "HardwareVideoEncoder_" + ((Object) streamType) + "_" + hashCode();
    }

    private void h() {
        if (this.f44707i == null) {
            return;
        }
        LiteavLog.d(this.f44704f.a("uninitGL"), this.f44700b, "uninitOpenGLComponents", new Object[0]);
        try {
            this.f44707i.makeCurrent();
            com.tencent.liteav.videobase.frame.j jVar = this.f44708j;
            if (jVar != null) {
                jVar.a();
                this.f44708j = null;
            }
            this.f44713o.b();
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f44704f.a("uninitError"), this.f44700b, "makeCurrent failed.", e2);
        }
        EGLCore.destroy(this.f44707i);
        this.f44707i = null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a() {
        LiteavLog.d(this.f44700b, "initialize");
        this.f44711m = new Handler(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f44712n = new com.tencent.liteav.videobase.egl.c(this.f44711m.getLooper());
        this.f44703e.a();
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(int i10) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(int i10, int i11) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void b() {
        this.f44703e.c();
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void b(int i10) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void c() {
        h();
        Surface surface = this.f44706h;
        if (surface != null) {
            surface.release();
            this.f44706h = null;
        }
        this.f44703e.d();
        this.f44699a = null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void d() {
        am amVar = this.f44703e;
        if (amVar != null) {
            amVar.b();
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void d(int i10) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final VideoEncodeParams e() {
        return new VideoEncodeParams(this.f44709k);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void f() {
        LiteavLog.d(this.f44700b, "uninitialize");
        this.f44703e.e();
        com.tencent.liteav.videobase.egl.c cVar = this.f44712n;
        cVar.f43420a.post(com.tencent.liteav.videobase.egl.d.a(cVar));
        this.f44711m = null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final VideoEncoderDef.a g() {
        return VideoEncoderDef.a.HARDWARE;
    }

    /* renamed from: com.tencent.liteav.videoproducer.encoder.s$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 extends bq.a {
        public AnonymousClass1() {
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, EncodedVideoFrame encodedVideoFrame, boolean z10) {
            bq.a aVar = s.this.f44699a;
            if (aVar != null) {
                aVar.onEncodedNAL(encodedVideoFrame, z10);
            }
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onEncodedFail(h.a aVar) {
            s.a(s.this, u.a(this, aVar));
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z10) {
            s.a(s.this, t.a(this, encodedVideoFrame, z10));
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onOutputFormatChanged(MediaFormat mediaFormat) {
            s.a(s.this, w.a(this, mediaFormat));
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, h.a aVar) {
            bq.a aVar2 = s.this.f44699a;
            if (aVar2 != null) {
                aVar2.onEncodedFail(aVar);
            }
        }

        @Override // com.tencent.liteav.videoproducer.encoder.bq.a
        public final void a() {
            s.a(s.this, v.a(this));
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1) {
            bq.a aVar = s.this.f44699a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, MediaFormat mediaFormat) {
            bq.a aVar = s.this.f44699a;
            if (aVar != null) {
                aVar.onOutputFormatChanged(mediaFormat);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f44703e.a(serverVideoProducerConfig);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final boolean a(VideoEncodeParams videoEncodeParams, bq.a aVar) {
        if (this.f44706h != null) {
            LiteavLog.e(this.f44700b, "Encoder has started");
            return false;
        }
        LiteavLog.i(this.f44700b, "Start hw video encoder. %s", videoEncodeParams);
        this.f44699a = aVar;
        Pair<Surface, Size> a10 = this.f44703e.a(videoEncodeParams, this.f44714p);
        this.f44706h = (Surface) a10.first;
        this.f44702d.set((Size) a10.second);
        this.f44709k = new VideoEncodeParams(videoEncodeParams);
        return this.f44706h != null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void c(int i10) {
        VideoEncodeParams videoEncodeParams = this.f44709k;
        if (videoEncodeParams != null) {
            videoEncodeParams.bitrate = i10;
        }
        this.f44703e.a(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[Catch: f -> 0x00d8, TryCatch #0 {f -> 0x00d8, blocks: (B:15:0x0032, B:17:0x0047, B:18:0x004e, B:20:0x0056, B:23:0x005f, B:26:0x0067, B:27:0x0076, B:29:0x0083, B:30:0x0089, B:32:0x009c, B:33:0x00bd, B:37:0x006b, B:40:0x0073), top: B:14:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[Catch: f -> 0x00d8, TryCatch #0 {f -> 0x00d8, blocks: (B:15:0x0032, B:17:0x0047, B:18:0x004e, B:20:0x0056, B:23:0x005f, B:26:0x0067, B:27:0x0076, B:29:0x0083, B:30:0x0089, B:32:0x009c, B:33:0x00bd, B:37:0x006b, B:40:0x0073), top: B:14:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c A[Catch: f -> 0x00d8, TryCatch #0 {f -> 0x00d8, blocks: (B:15:0x0032, B:17:0x0047, B:18:0x004e, B:20:0x0056, B:23:0x005f, B:26:0x0067, B:27:0x0076, B:29:0x0083, B:30:0x0089, B:32:0x009c, B:33:0x00bd, B:37:0x006b, B:40:0x0073), top: B:14:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Override // com.tencent.liteav.videoproducer.encoder.bq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.tencent.liteav.videobase.frame.PixelFrame r6) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.s.a(com.tencent.liteav.videobase.frame.PixelFrame):void");
    }

    private boolean a(Object obj, Surface surface) {
        if (surface == null) {
            LiteavLog.w(this.f44704f.a("SurfaceNull"), this.f44700b, "init opengl: surface is null.", new Object[0]);
            return false;
        }
        LiteavLog.d(this.f44704f.a("initGL"), this.f44700b, "initOpenGLComponents", new Object[0]);
        EGLCore eGLCore = new EGLCore();
        this.f44707i = eGLCore;
        try {
            Size size = this.f44702d;
            eGLCore.initialize(obj, surface, size.width, size.height);
            this.f44713o.a();
            com.tencent.liteav.videobase.utils.n nVar = this.f44713o;
            Size size2 = this.f44702d;
            nVar.a(size2.width, size2.height);
            Size size3 = this.f44702d;
            this.f44708j = new com.tencent.liteav.videobase.frame.j(size3.width, size3.height);
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            h.c cVar = h.c.WARNING_VIDEO_ENCODE_EGL_CORE_CREATE_FAILED;
            this.f44701c.notifyWarning(cVar, "VideoEncode: create EGLCore failed, EGLCode:" + e2.mErrorCode + " message:" + e2.getMessage());
            this.f44701c.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_HW_ENCODE_START_ERROR_TYPE, this.f44705g.mValue, Integer.valueOf(cVar.mValue));
            this.f44703e.a(e2.getMessage());
            LiteavLog.e(this.f44704f.a("initError"), this.f44700b, "create EGLCore failed.", e2);
            this.f44707i = null;
            return false;
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(TakeSnapshotListener takeSnapshotListener) {
        this.f44713o.a(takeSnapshotListener);
    }

    public static /* synthetic */ void a(s sVar, Runnable runnable) {
        Handler handler = sVar.f44711m;
        if (handler != null) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }
}
