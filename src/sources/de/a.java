package de;

import ce.l;
import com.kuaishou.weapon.p0.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.DurationUnit;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Duration.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a implements Comparable<a> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final C0722a f48693c = new C0722a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final long f48694d = g(0);

    /* renamed from: e, reason: collision with root package name */
    public static final long f48695e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f48696f;

    /* renamed from: b, reason: collision with root package name */
    public final long f48697b;

    /* compiled from: Duration.kt */
    /* renamed from: de.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class C0722a {
        public C0722a() {
        }

        public /* synthetic */ C0722a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return a.f48694d;
        }
    }

    static {
        long e2;
        long e10;
        e2 = c.e(4611686018427387903L);
        f48695e = e2;
        e10 = c.e(-4611686018427387903L);
        f48696f = e10;
    }

    public static final long A(long j10, @NotNull DurationUnit unit) {
        s.i(unit, "unit");
        if (j10 == f48695e) {
            return Long.MAX_VALUE;
        }
        if (j10 == f48696f) {
            return Long.MIN_VALUE;
        }
        return d.a(t(j10), s(j10), unit);
    }

    @NotNull
    public static String B(long j10) {
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f48695e) {
            return "Infinity";
        }
        if (j10 == f48696f) {
            return "-Infinity";
        }
        boolean z10 = z(j10);
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append('-');
        }
        long i10 = i(j10);
        long k10 = k(i10);
        int j11 = j(i10);
        int p10 = p(i10);
        int r10 = r(i10);
        int q10 = q(i10);
        int i11 = 0;
        boolean z11 = k10 != 0;
        boolean z12 = j11 != 0;
        boolean z13 = p10 != 0;
        boolean z14 = (r10 == 0 && q10 == 0) ? false : true;
        if (z11) {
            sb2.append(k10);
            sb2.append('d');
            i11 = 1;
        }
        if (z12 || (z11 && (z13 || z14))) {
            int i12 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(j11);
            sb2.append('h');
            i11 = i12;
        }
        if (z13 || (z14 && (z12 || z11))) {
            int i13 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(p10);
            sb2.append('m');
            i11 = i13;
        }
        if (z14) {
            int i14 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            if (r10 != 0 || z11 || z12 || z13) {
                b(j10, sb2, r10, q10, 9, t.f36222g, false);
            } else if (q10 >= 1000000) {
                b(j10, sb2, q10 / 1000000, q10 % 1000000, 6, "ms", false);
            } else if (q10 >= 1000) {
                b(j10, sb2, q10 / 1000, q10 % 1000, 3, "us", false);
            } else {
                sb2.append(q10);
                sb2.append("ns");
            }
            i11 = i14;
        }
        if (z10 && i11 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String sb3 = sb2.toString();
        s.h(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static final long C(long j10) {
        long d10;
        d10 = c.d(-t(j10), ((int) j10) & 1);
        return d10;
    }

    public static final void b(long j10, StringBuilder sb2, int i10, int i11, int i12, String str, boolean z10) {
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append('.');
            String i02 = StringsKt__StringsKt.i0(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = i02.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (i02.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (!z10 && i15 < 3) {
                sb2.append((CharSequence) i02, 0, i15);
                s.h(sb2, "this.append(value, startIndex, endIndex)");
            } else {
                sb2.append((CharSequence) i02, 0, ((i15 + 2) / 3) * 3);
                s.h(sb2, "this.append(value, startIndex, endIndex)");
            }
        }
        sb2.append(str);
    }

    public static int f(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return s.l(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        return z(j10) ? -i10 : i10;
    }

    public static long g(long j10) {
        if (b.a()) {
            if (x(j10)) {
                if (!new l(-4611686018426999999L, 4611686018426999999L).g(t(j10))) {
                    throw new AssertionError((Object) (t(j10) + " ns is out of nanoseconds range"));
                }
            } else if (new l(-4611686018427387903L, 4611686018427387903L).g(t(j10))) {
                if (new l(-4611686018426L, 4611686018426L).g(t(j10))) {
                    throw new AssertionError((Object) (t(j10) + " ms is denormalized"));
                }
            } else {
                throw new AssertionError((Object) (t(j10) + " ms is out of milliseconds range"));
            }
        }
        return j10;
    }

    public static boolean h(long j10, Object obj) {
        return (obj instanceof a) && j10 == ((a) obj).D();
    }

    public static final long i(long j10) {
        return z(j10) ? C(j10) : j10;
    }

    public static final int j(long j10) {
        if (y(j10)) {
            return 0;
        }
        return (int) (l(j10) % 24);
    }

    public static final long k(long j10) {
        return A(j10, DurationUnit.DAYS);
    }

    public static final long l(long j10) {
        return A(j10, DurationUnit.HOURS);
    }

    public static final long m(long j10) {
        return (w(j10) && v(j10)) ? t(j10) : A(j10, DurationUnit.MILLISECONDS);
    }

    public static final long n(long j10) {
        return A(j10, DurationUnit.MINUTES);
    }

    public static final long o(long j10) {
        return A(j10, DurationUnit.SECONDS);
    }

    public static final int p(long j10) {
        if (y(j10)) {
            return 0;
        }
        return (int) (n(j10) % 60);
    }

    public static final int q(long j10) {
        if (y(j10)) {
            return 0;
        }
        return (int) (w(j10) ? c.f(t(j10) % 1000) : t(j10) % Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
    }

    public static final int r(long j10) {
        if (y(j10)) {
            return 0;
        }
        return (int) (o(j10) % 60);
    }

    public static final DurationUnit s(long j10) {
        return x(j10) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    public static final long t(long j10) {
        return j10 >> 1;
    }

    public static int u(long j10) {
        return b2.a.a(j10);
    }

    public static final boolean v(long j10) {
        return !y(j10);
    }

    public static final boolean w(long j10) {
        return (((int) j10) & 1) == 1;
    }

    public static final boolean x(long j10) {
        return (((int) j10) & 1) == 0;
    }

    public static final boolean y(long j10) {
        return j10 == f48695e || j10 == f48696f;
    }

    public static final boolean z(long j10) {
        return j10 < 0;
    }

    public final /* synthetic */ long D() {
        return this.f48697b;
    }

    public int c(long j10) {
        return f(this.f48697b, j10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return c(aVar.D());
    }

    public boolean equals(Object obj) {
        return h(this.f48697b, obj);
    }

    public int hashCode() {
        return u(this.f48697b);
    }

    @NotNull
    public String toString() {
        return B(this.f48697b);
    }
}
