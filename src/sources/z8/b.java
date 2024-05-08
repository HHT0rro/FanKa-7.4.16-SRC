package z8;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f55027b = new b(0);

    /* renamed from: c, reason: collision with root package name */
    public static final b f55028c = new b(1);

    /* renamed from: d, reason: collision with root package name */
    public static final b f55029d = new b(2);

    /* renamed from: e, reason: collision with root package name */
    public static final b f55030e = new b(3);

    /* renamed from: f, reason: collision with root package name */
    public static final b f55031f = new b(4);

    /* renamed from: a, reason: collision with root package name */
    public final int f55032a;

    public b(int i10) {
        this.f55032a = i10;
    }

    public final int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && b.class == obj.getClass() && this.f55032a == ((b) obj).f55032a;
    }

    public int hashCode() {
        return a(Integer.valueOf(this.f55032a));
    }
}
