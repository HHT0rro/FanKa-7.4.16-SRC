package com.google.common.math;

import java.math.RoundingMode;

/* compiled from: MathPreconditions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f {
    public static void a(boolean z10, double d10, RoundingMode roundingMode) {
        if (z10) {
            return;
        }
        String valueOf = String.valueOf(roundingMode);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 83);
        sb2.append("rounded value is out of range for input ");
        sb2.append(d10);
        sb2.append(" and rounding mode ");
        sb2.append(valueOf);
        throw new ArithmeticException(sb2.toString());
    }

    public static void b(boolean z10, String str, int i10, int i11) {
        if (z10) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36);
        sb2.append("overflow: ");
        sb2.append(str);
        sb2.append("(");
        sb2.append(i10);
        sb2.append(", ");
        sb2.append(i11);
        sb2.append(")");
        throw new ArithmeticException(sb2.toString());
    }

    public static void c(boolean z10, String str, long j10, long j11) {
        if (z10) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 54);
        sb2.append("overflow: ");
        sb2.append(str);
        sb2.append("(");
        sb2.append(j10);
        sb2.append(", ");
        sb2.append(j11);
        sb2.append(")");
        throw new ArithmeticException(sb2.toString());
    }

    public static int d(String str, int i10) {
        if (i10 > 0) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 26);
        sb2.append(str);
        sb2.append(" (");
        sb2.append(i10);
        sb2.append(") must be > 0");
        throw new IllegalArgumentException(sb2.toString());
    }

    public static void e(boolean z10) {
        if (!z10) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
