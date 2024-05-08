package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends com.tencent.liteav.videobase.a.a implements d.a {

    /* renamed from: c, reason: collision with root package name */
    public CustomVideoProcessListener f44889c;

    /* renamed from: d, reason: collision with root package name */
    public GLConstants.PixelBufferType f44890d;

    /* renamed from: e, reason: collision with root package name */
    public GLConstants.PixelFormatType f44891e;

    /* renamed from: g, reason: collision with root package name */
    private final IVideoReporter f44893g;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.l f44898l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.liteav.videobase.videobase.d f44899m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.j f44900n;

    /* renamed from: o, reason: collision with root package name */
    private PixelFrame f44901o;

    /* renamed from: p, reason: collision with root package name */
    private PixelFrame f44902p;

    /* renamed from: q, reason: collision with root package name */
    private PixelFrame f44903q;

    /* renamed from: r, reason: collision with root package name */
    private PixelFrame f44904r;

    /* renamed from: h, reason: collision with root package name */
    private final Size f44894h = new Size(0, 0);

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.liteav.videobase.utils.d f44888b = new com.tencent.liteav.videobase.utils.d();

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.liteav.base.b.a f44895i = new com.tencent.liteav.base.b.a(1000);

    /* renamed from: j, reason: collision with root package name */
    private long f44896j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f44897k = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f44892f = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f44905s = false;

    /* renamed from: t, reason: collision with root package name */
    private int f44906t = -1;

    public a(IVideoReporter iVideoReporter) {
        this.f44893g = iVideoReporter;
    }

    private void c() {
        PixelFrame pixelFrame = this.f44902p;
        if (pixelFrame != null) {
            pixelFrame.setData(null);
            this.f44902p.setBuffer(null);
            OpenGlUtils.deleteTexture(this.f44902p.getTextureId());
            this.f44902p.setTextureId(-1);
        }
        int i10 = this.f44906t;
        if (i10 != -1) {
            OpenGlUtils.deleteTexture(i10);
            this.f44906t = -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x019c, code lost:
    
        if ((((r4.getPixelBufferType() == r6 && r4.getTextureId() == -1) || ((r4.getPixelBufferType() == com.tencent.liteav.videobase.base.GLConstants.PixelBufferType.BYTE_BUFFER && r4.getBuffer() == null) || (r4.getPixelBufferType() == com.tencent.liteav.videobase.base.GLConstants.PixelBufferType.BYTE_ARRAY && r4.getData() == null))) ? false : true) == false) goto L86;
     */
    @Override // com.tencent.liteav.videobase.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.liteav.videobase.frame.d a(long r17, com.tencent.liteav.videobase.frame.d r19) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.producer.a.a(long, com.tencent.liteav.videobase.frame.d):com.tencent.liteav.videobase.frame.d");
    }

    public final void b(CustomVideoProcessListener customVideoProcessListener) {
        if (customVideoProcessListener == null || !this.f44905s) {
            return;
        }
        customVideoProcessListener.onGLContextDestroy();
        this.f44905s = false;
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void b(com.tencent.liteav.videobase.frame.e eVar) {
        this.f44894h.set(0, 0);
        this.f44898l = new com.tencent.liteav.videobase.frame.l();
        this.f44903q = new PixelFrame();
        this.f44904r = new PixelFrame();
        this.f44902p = new PixelFrame();
        com.tencent.liteav.videobase.videobase.d dVar = new com.tencent.liteav.videobase.videobase.d();
        this.f44899m = dVar;
        dVar.a(eVar);
        this.f44888b.a(c.a(this));
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void b() {
        c();
        this.f44898l = null;
        this.f44903q = null;
        this.f44904r = null;
        this.f44901o = null;
        this.f44902p = null;
        this.f44899m.a();
        this.f44899m = null;
        boolean isValid = this.f44894h.isValid();
        this.f44894h.set(0, 0);
        if (isValid) {
            this.f44888b.a();
            b(this.f44889c);
        }
    }

    public final void a(CustomVideoProcessListener customVideoProcessListener) {
        if (customVideoProcessListener == null || this.f44905s) {
            return;
        }
        customVideoProcessListener.onGLContextCreated();
        this.f44905s = true;
    }

    @Override // com.tencent.liteav.videobase.videobase.d.a
    public final void a(int i10, PixelFrame pixelFrame) {
        if (i10 != 101) {
            LiteavLog.w("CustomVideoProcessListenerAdapter", "Receive frame converted, but identity is invalid(%d)", Integer.valueOf(i10));
        } else {
            this.f44901o = pixelFrame;
            pixelFrame.retain();
        }
    }
}
