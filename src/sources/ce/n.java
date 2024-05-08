package ce;

import ce.h;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Ranges.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n extends m {
    public static final int b(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static final long c(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static final int d(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static final long e(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static final int f(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    @NotNull
    public static final h g(int i10, int i11) {
        return h.f1608e.a(i10, i11, -1);
    }

    @NotNull
    public static final h h(@NotNull h hVar, int i10) {
        s.i(hVar, "<this>");
        m.a(i10 > 0, Integer.valueOf(i10));
        h.a aVar = h.f1608e;
        int b4 = hVar.b();
        int c4 = hVar.c();
        if (hVar.f() <= 0) {
            i10 = -i10;
        }
        return aVar.a(b4, c4, i10);
    }

    @NotNull
    public static final IntRange i(int i10, int i11) {
        if (i11 <= Integer.MIN_VALUE) {
            return IntRange.f51055f.a();
        }
        return new IntRange(i10, i11 - 1);
    }
}
