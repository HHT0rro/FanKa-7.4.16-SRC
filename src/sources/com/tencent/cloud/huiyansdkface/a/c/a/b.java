package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import android.view.SurfaceView;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b implements com.tencent.cloud.huiyansdkface.a.c.a<a> {

    /* renamed from: b, reason: collision with root package name */
    private a f40352b;

    /* renamed from: c, reason: collision with root package name */
    private int f40353c;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.e.b f40355e;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f40354d = false;

    /* renamed from: a, reason: collision with root package name */
    private f f40351a = new f();

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        return new d(this, this.f40352b).a(cVar);
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void a() {
        this.f40351a.a();
        this.f40352b = null;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void a(float f10) {
        if (f10 == -1.0f) {
            return;
        }
        new l(this.f40352b.a()).a(f10);
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void a(com.tencent.cloud.huiyansdkface.a.a.f fVar, int i10) {
        this.f40353c = i10;
        a aVar = this.f40352b;
        if (aVar != null) {
            int a10 = fVar != null ? fVar.a(aVar, i10) : -1;
            if (a10 < 0) {
                a10 = com.tencent.cloud.huiyansdkface.a.f.a.a(this.f40352b.d(), i10, this.f40352b.e());
            }
            com.tencent.cloud.huiyansdkface.a.d.a.a("CameraV1Device", "camera set display orientation:screenOrientation=" + i10 + ",camera orientation=" + this.f40352b.e() + ",\ncalc display orientation result:" + a10, new Object[0]);
            this.f40352b.a().setDisplayOrientation(a10);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void a(Object obj) {
        if (obj instanceof com.tencent.cloud.huiyansdkface.a.g.a) {
            ((com.tencent.cloud.huiyansdkface.a.g.a) obj).a(this.f40352b);
            return;
        }
        if (obj == null) {
            try {
                this.f40352b.a().setPreviewDisplay(null);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        try {
            com.tencent.cloud.huiyansdkface.a.d.a.a("CameraV1Device", "set display view :" + obj, new Object[0]);
            this.f40352b.a().setPreviewDisplay(((SurfaceView) obj).getHolder());
        } catch (Exception e10) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(3, "set preview display failed", e10));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        try {
            if (this.f40351a.a(aVar) == null) {
                com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(11, "no camera can use", null));
                return null;
            }
            a b4 = this.f40351a.b();
            this.f40352b = b4;
            b4.a(f());
            return this.f40352b;
        } catch (Exception e2) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(1, "open camera exception", e2));
            return null;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void b() {
        this.f40354d = false;
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraV1Device", "startPreview", new Object[0]);
        try {
            this.f40352b.a().startPreview();
        } catch (Throwable th) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(3, "start preview failed", th));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public synchronized void c() {
        if (this.f40352b != null) {
            com.tencent.cloud.huiyansdkface.a.d.a.a("CameraV1Device", "stopPreview", new Object[0]);
            try {
                this.f40352b.a().stopPreview();
            } catch (Throwable th) {
                com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(8, "stop preview failed", th));
            }
            this.f40354d = true;
        } else if (!this.f40354d) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(81, "you must start preview first"));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public com.tencent.cloud.huiyansdkface.a.e.b d() {
        com.tencent.cloud.huiyansdkface.a.e.b bVar = this.f40355e;
        if (bVar != null) {
            return bVar;
        }
        com.tencent.cloud.huiyansdkface.a.e.b bVar2 = new com.tencent.cloud.huiyansdkface.a.e.b();
        Camera.Parameters parameters = this.f40352b.a().getParameters();
        Camera.Size previewSize = parameters.getPreviewSize();
        com.tencent.cloud.huiyansdkface.a.e.b d10 = bVar2.a(new com.tencent.cloud.huiyansdkface.a.a.a.d(previewSize.width, previewSize.height)).a(this.f40352b.d()).c(this.f40352b.e()).b(this.f40353c).a(com.tencent.cloud.huiyansdkface.a.f.a.a(this.f40352b.d(), this.f40353c, this.f40352b.e())).d(parameters.getPreviewFormat());
        this.f40355e = d10;
        return d10;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public com.tencent.cloud.huiyansdkface.a.e.c e() {
        return new k(this, this.f40352b.a());
    }

    public com.tencent.cloud.huiyansdkface.a.a.d f() {
        a aVar = this.f40352b;
        if (aVar == null) {
            return null;
        }
        return new g(aVar).a();
    }
}
