package m9;

import com.huawei.appgallery.agd.core.impl.device.OaidUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static c f51945d;

    /* renamed from: a, reason: collision with root package name */
    public String f51946a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f51947b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f51948c = true;

    public static synchronized c g() {
        c cVar;
        synchronized (c.class) {
            if (f51945d == null) {
                f51945d = new c();
            }
            cVar = f51945d;
        }
        return cVar;
    }

    public String a() {
        if (!OaidUtil.getEnable()) {
            n9.a.f52175d.w("HuaweiOaidSingleton", "client not support report oaid");
            return null;
        }
        if (this.f51948c) {
            d.j();
            return g().a();
        }
        if (this.f51947b) {
            return null;
        }
        return this.f51946a;
    }

    public void b(String str) {
        this.f51946a = str;
    }

    public void c(boolean z10) {
        this.f51947b = z10;
    }

    public void d(boolean z10) {
        this.f51948c = z10;
    }

    public boolean e() {
        return this.f51948c;
    }

    public void f() {
        d.d();
    }
}
