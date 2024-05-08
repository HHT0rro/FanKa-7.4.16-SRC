package z7;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f55007a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55008b;

    /* renamed from: c, reason: collision with root package name */
    public final int f55009c;

    public m(Class<?> cls, int i10, int i11) {
        this.f55007a = (Class) q.c(cls, "Null dependency anInterface.");
        this.f55008b = i10;
        this.f55009c = i11;
    }

    public static m e(Class<?> cls) {
        return new m(cls, 1, 0);
    }

    public static m f(Class<?> cls) {
        return new m(cls, 1, 1);
    }

    public static m g(Class<?> cls) {
        return new m(cls, 2, 0);
    }

    public Class<?> a() {
        return this.f55007a;
    }

    public boolean b() {
        return this.f55009c == 0;
    }

    public boolean c() {
        return this.f55008b == 1;
    }

    public boolean d() {
        return this.f55008b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f55007a == mVar.f55007a && this.f55008b == mVar.f55008b && this.f55009c == mVar.f55009c;
    }

    public int hashCode() {
        return ((((this.f55007a.hashCode() ^ 1000003) * 1000003) ^ this.f55008b) * 1000003) ^ this.f55009c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append((Object) this.f55007a);
        sb2.append(", type=");
        int i10 = this.f55008b;
        sb2.append(i10 == 1 ? "required" : i10 == 0 ? "optional" : "set");
        sb2.append(", direct=");
        sb2.append(this.f55009c == 0);
        sb2.append(com.alipay.sdk.util.i.f4738d);
        return sb2.toString();
    }
}
