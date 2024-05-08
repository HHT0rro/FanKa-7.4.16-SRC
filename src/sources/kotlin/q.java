package kotlin;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UnsignedUtils.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q {
    public static final int a(int i10, int i11) {
        return s.k(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j10, long j11) {
        return s.l(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
    }

    @NotNull
    public static final String c(long j10) {
        return d(j10, 10);
    }

    @NotNull
    public static final String d(long j10, int i10) {
        if (j10 >= 0) {
            String l10 = Long.toString(j10, kotlin.text.a.a(i10));
            s.h(l10, "toString(this, checkRadix(radix))");
            return l10;
        }
        long j11 = i10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        StringBuilder sb2 = new StringBuilder();
        String l11 = Long.toString(j12, kotlin.text.a.a(i10));
        s.h(l11, "toString(this, checkRadix(radix))");
        sb2.append(l11);
        String l12 = Long.toString(j13, kotlin.text.a.a(i10));
        s.h(l12, "toString(this, checkRadix(radix))");
        sb2.append(l12);
        return sb2.toString();
    }
}
