package pa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f52973b = new b();

    /* renamed from: a, reason: collision with root package name */
    public boolean f52974a;

    public b() {
        try {
            Class.forName("com.huawei.appgallery.log.LogAdaptor");
            this.f52974a = true;
        } catch (ClassNotFoundException unused) {
            this.f52974a = false;
        }
    }

    public void a(String str, String str2) {
        if (this.f52974a) {
            a.f52972a.e(str, str2);
        }
    }

    public void b(String str, String str2, Throwable th) {
        if (this.f52974a) {
            a.f52972a.e(str, str2, th);
        }
    }

    public void c(String str, String str2) {
        if (this.f52974a) {
            a.f52972a.i(str, str2);
        }
    }

    public void d(String str, String str2) {
        if (this.f52974a) {
            a.f52972a.w(str, str2);
        }
    }
}
