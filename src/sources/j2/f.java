package j2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraProxy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public boolean f50279a = true;

    /* renamed from: b, reason: collision with root package name */
    public Context f50280b;

    /* renamed from: c, reason: collision with root package name */
    public int f50281c;

    /* renamed from: d, reason: collision with root package name */
    public d f50282d;

    /* renamed from: e, reason: collision with root package name */
    public g f50283e;

    /* renamed from: f, reason: collision with root package name */
    public List<Surface> f50284f;

    /* compiled from: CameraProxy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f50285a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f50286b;

        public a(e eVar, int i10) {
            this.f50285a = eVar;
            this.f50286b = i10;
        }

        @Override // j2.e
        public void a() {
            this.f50285a.a();
        }

        @Override // j2.e
        public void b() {
            f.this.f50282d.a();
            this.f50285a.b();
            f.this.f50281c = this.f50286b;
        }
    }

    /* compiled from: CameraProxy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b implements e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f50288a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f50289b;

        public b(e eVar, int i10) {
            this.f50288a = eVar;
            this.f50289b = i10;
        }

        @Override // j2.e
        public void a() {
            this.f50288a.a();
        }

        @Override // j2.e
        public void b() {
            f.this.f50282d.a();
            this.f50288a.b();
            f.this.f50281c = this.f50289b;
        }
    }

    public f(Context context) {
        this.f50280b = context;
        if (!c.f50278a.contains(Build.MODEL.toLowerCase())) {
            this.f50282d = new j2.b();
        } else {
            this.f50282d = new j2.a();
        }
        this.f50283e = new g();
        this.f50282d.init(context);
        this.f50284f = new ArrayList();
    }

    public void c(int i10, e eVar) {
        try {
            this.f50282d.f(i10, new b(eVar, i10));
        } catch (Exception e2) {
            this.f50282d = null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("openCamera fail msg=");
            sb2.append(e2.getMessage());
        }
    }

    public void d() {
        this.f50283e.e();
    }

    public int e() {
        return this.f50282d.getOrientation();
    }

    public int f() {
        return this.f50282d.e()[1];
    }

    public int g() {
        return this.f50283e.c();
    }

    public int h() {
        return this.f50282d.e()[0];
    }

    public long i() {
        if (this.f50283e.b() == null) {
            return System.currentTimeMillis();
        }
        return this.f50283e.b().getTimestamp();
    }

    public boolean j() {
        return this.f50282d.c();
    }

    public boolean k() {
        return this.f50281c == 1;
    }

    public final void l() {
        int i10 = 2;
        while (true) {
            n();
            if (!j()) {
                return;
            }
            int i11 = i10 - 1;
            if (i10 <= 0) {
                return;
            } else {
                i10 = i11;
            }
        }
    }

    public boolean m(int i10, e eVar) {
        try {
            l();
            this.f50282d.d(i10, new a(eVar, i10));
            return true;
        } catch (Exception e2) {
            this.f50282d = null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("openCamera fail msg=");
            sb2.append(e2.getMessage());
            return false;
        }
    }

    public void n() {
        this.f50282d.close();
        d();
        this.f50284f.clear();
    }

    public void o(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.f50283e.d(onFrameAvailableListener);
        this.f50282d.b(this.f50283e.b());
    }

    public void p() {
        this.f50283e.f();
    }
}
