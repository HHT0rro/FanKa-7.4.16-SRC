package p0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c<A, B> {

    /* renamed from: a, reason: collision with root package name */
    public final A f52726a;

    /* renamed from: b, reason: collision with root package name */
    public final B f52727b;

    public c(A a10, B b4) {
        this.f52726a = a10;
        this.f52727b = b4;
    }

    public static <A, B> c<A, B> b(A a10, B b4) {
        return new c<>(a10, b4);
    }

    public A a() {
        return this.f52726a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        A a10 = this.f52726a;
        if (a10 == null) {
            if (cVar.f52726a != null) {
                return false;
            }
        } else if (!a10.equals(cVar.f52726a)) {
            return false;
        }
        B b4 = this.f52727b;
        B b10 = cVar.f52727b;
        if (b4 == null) {
            if (b10 != null) {
                return false;
            }
        } else if (!b4.equals(b10)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a10 = this.f52726a;
        int hashCode = ((a10 == null ? 0 : a10.hashCode()) + 31) * 31;
        B b4 = this.f52727b;
        return hashCode + (b4 != null ? b4.hashCode() : 0);
    }
}
