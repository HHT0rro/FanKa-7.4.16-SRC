package com.tencent.liteav.videobase.utils;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f43533a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.c f43534b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.j f43535c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.e f43536d;

    /* renamed from: e, reason: collision with root package name */
    public TakeSnapshotListener f43537e;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.liteav.base.util.l f43541i;

    /* renamed from: j, reason: collision with root package name */
    private EGLCore f43542j;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f43540h = new com.tencent.liteav.base.b.b();

    /* renamed from: f, reason: collision with root package name */
    public int f43538f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f43539g = 0;

    public n(String str) {
        String str2 = "SnapshotTaker_" + str + "_" + hashCode();
        this.f43533a = str2;
        this.f43541i = new com.tencent.liteav.base.util.l(15, str2);
    }

    public final void a() {
        LiteavLog.i(this.f43533a, "initialize");
    }

    public final void b() {
        LiteavLog.i(this.f43533a, "uninitialize");
        a(o.a(this));
    }

    public final void c() {
        LiteavLog.i(this.f43540h.a("uninitGL"), this.f43533a, "uninitializedEGL", new Object[0]);
        EGLCore eGLCore = this.f43542j;
        if (eGLCore != null) {
            try {
                eGLCore.makeCurrent();
            } catch (com.tencent.liteav.videobase.egl.f e2) {
                LiteavLog.e(this.f43540h.a("make"), this.f43533a, "uninitializedEGL makeCurrent error ".concat(String.valueOf(e2)), new Object[0]);
            }
        }
        com.tencent.liteav.videobase.frame.e eVar = this.f43536d;
        if (eVar != null) {
            eVar.a();
            this.f43536d.b();
            this.f43536d = null;
        }
        com.tencent.liteav.videobase.frame.j jVar = this.f43535c;
        if (jVar != null) {
            jVar.a();
            this.f43535c = null;
        }
        com.tencent.liteav.videobase.frame.c cVar = this.f43534b;
        if (cVar != null) {
            cVar.d();
            this.f43534b = null;
        }
        EGLCore.destroy(this.f43542j);
        this.f43542j = null;
    }

    public final void a(int i10, int i11) {
        a(p.a(this, i10, i11));
    }

    public final void a(TakeSnapshotListener takeSnapshotListener) {
        a(q.a(this, takeSnapshotListener));
    }

    public final void a(PixelFrame pixelFrame) {
        if (this.f43537e == null || pixelFrame == null) {
            return;
        }
        if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
            GLES20.glFinish();
        }
        pixelFrame.retain();
        a(r.a(this, pixelFrame));
    }

    public final boolean a(Object obj) {
        if (this.f43542j != null) {
            return true;
        }
        LiteavLog.i(this.f43540h.a("initGL"), this.f43533a, "initOpenGLComponents", new Object[0]);
        try {
            EGLCore eGLCore = new EGLCore();
            this.f43542j = eGLCore;
            eGLCore.initialize(obj, null, 128, 128);
            this.f43542j.makeCurrent();
            this.f43536d = new com.tencent.liteav.videobase.frame.e();
            com.tencent.liteav.videobase.frame.c cVar = new com.tencent.liteav.videobase.frame.c();
            this.f43534b = cVar;
            cVar.a();
            this.f43535c = new com.tencent.liteav.videobase.frame.j(this.f43538f, this.f43539g);
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f43540h.a("initError"), this.f43533a, "egl initialize failed.", e2);
            this.f43542j = null;
            return false;
        }
    }

    private void a(Runnable runnable) {
        com.tencent.liteav.base.util.l lVar = this.f43541i;
        if (lVar != null) {
            lVar.a(runnable);
        }
    }
}
