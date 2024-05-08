package com.tencent.liteav.videoproducer.encoder;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.d;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.bq;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class al implements d.a, bq {

    /* renamed from: a, reason: collision with root package name */
    private final String f44516a;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final SoftwareEncoderWrapper f44518c;

    /* renamed from: d, reason: collision with root package name */
    private VideoEncodeParams f44519d;

    /* renamed from: e, reason: collision with root package name */
    private EGLCore f44520e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.j f44521f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.e f44522g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.liteav.videobase.videobase.d f44523h;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f44517b = new com.tencent.liteav.base.b.b();

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.liteav.videobase.utils.n f44524i = new com.tencent.liteav.videobase.utils.n("softenc" + hashCode());

    public al(@NonNull IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.f44518c = new SoftwareEncoderWrapper(iVideoReporter, streamType);
        this.f44516a = "SoftwareVideoEncoder_" + ((Object) streamType) + "_" + hashCode();
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a() {
        this.f44518c.initialize();
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void b() {
        this.f44518c.signalEndOfStream();
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void c() {
        this.f44519d = null;
        this.f44518c.stopSync(2000L);
        if (this.f44520e != null) {
            LiteavLog.i(this.f44517b.a("uninitGL"), this.f44516a, "uninitializeOpenGLComponents", new Object[0]);
            try {
                this.f44520e.makeCurrent();
                this.f44523h.a(0, this);
                this.f44523h.a();
                this.f44524i.b();
                com.tencent.liteav.videobase.frame.j jVar = this.f44521f;
                if (jVar != null) {
                    jVar.a();
                    this.f44521f = null;
                }
                com.tencent.liteav.videobase.frame.e eVar = this.f44522g;
                if (eVar != null) {
                    eVar.a();
                    this.f44522g.b();
                    this.f44522g = null;
                }
            } catch (com.tencent.liteav.videobase.egl.f e2) {
                LiteavLog.e(this.f44517b.a("unintError"), this.f44516a, "makeCurrent failed.", e2);
            }
            EGLCore.destroy(this.f44520e);
            this.f44520e = null;
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void d() {
        this.f44518c.restartIDRFrame();
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final VideoEncodeParams e() {
        return new VideoEncodeParams(this.f44519d);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void f() {
        this.f44518c.uninitialize();
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final VideoEncoderDef.a g() {
        return VideoEncoderDef.a.SOFTWARE;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final boolean a(VideoEncodeParams videoEncodeParams, bq.a aVar) {
        LiteavLog.i(this.f44516a, "Start: ".concat(String.valueOf(videoEncodeParams)));
        this.f44519d = new VideoEncodeParams(videoEncodeParams);
        this.f44518c.start(videoEncodeParams, aVar);
        return true;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void b(int i10) {
        this.f44518c.setRPSNearestREFSize(i10);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void d(int i10) {
        this.f44518c.setFps(i10);
        this.f44519d.setFps(i10);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            return;
        }
        PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
        FrameMetaData metaData = pixelFrame.getMetaData();
        if (metaData != null) {
            pixelFrame2.postRotate(metaData.getEncodeRotation());
        }
        if (this.f44520e != null || a(pixelFrame2.getGLContext())) {
            try {
                this.f44520e.makeCurrent();
                com.tencent.liteav.videobase.frame.d a10 = this.f44522g.a(this.f44519d.getWidth(), this.f44519d.getHeight());
                a10.a(metaData);
                OpenGlUtils.glViewport(0, 0, a10.b(), a10.c());
                this.f44524i.a(pixelFrame2);
                this.f44521f.a(pixelFrame2, GLConstants.GLScaleType.CENTER_CROP, a10);
                this.f44523h.a(pixelFrame2.getTimestamp(), a10);
                a10.release();
            } catch (com.tencent.liteav.videobase.egl.f e2) {
                LiteavLog.e(this.f44517b.a("makeCurrentError"), this.f44516a, "makeCurrent failed.", e2);
            }
        }
    }

    private boolean a(Object obj) {
        if (this.f44519d == null) {
            return false;
        }
        EGLCore eGLCore = new EGLCore();
        this.f44520e = eGLCore;
        try {
            eGLCore.initialize(obj, null, 128, 128);
            this.f44521f = new com.tencent.liteav.videobase.frame.j(this.f44519d.getWidth(), this.f44519d.getHeight());
            this.f44522g = new com.tencent.liteav.videobase.frame.e();
            this.f44524i.a();
            this.f44524i.a(this.f44519d.getWidth(), this.f44519d.getHeight());
            com.tencent.liteav.videobase.videobase.d dVar = new com.tencent.liteav.videobase.videobase.d();
            this.f44523h = dVar;
            dVar.a(this.f44522g);
            this.f44523h.a(new com.tencent.liteav.videobase.videobase.a(this.f44519d.getWidth(), this.f44519d.getHeight()), GLConstants.PixelBufferType.BYTE_BUFFER, GLConstants.PixelFormatType.I420, 0, this);
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            this.f44520e = null;
            LiteavLog.e(this.f44517b.a("initGL"), this.f44516a, "initializeEGL failed.", e2);
            return false;
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void c(int i10) {
        this.f44518c.setBitrate(i10);
        this.f44519d.setBitrate(i10);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(int i10) {
        this.f44518c.setRPSIFrameFPS(i10);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(int i10, int i11) {
        this.f44518c.ackRPSRecvFrameIndex(i10, i11);
    }

    @Override // com.tencent.liteav.videobase.videobase.d.a
    public final void a(int i10, PixelFrame pixelFrame) {
        this.f44518c.encodeFrame(pixelFrame);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bq
    public final void a(TakeSnapshotListener takeSnapshotListener) {
        this.f44524i.a(takeSnapshotListener);
    }
}
