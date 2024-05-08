package com.google.common.math;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.common.base.o;
import jdk.internal.math.DoubleConsts;

/* compiled from: DoubleUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c {
    public static double a(double d10) {
        o.d(!Double.isNaN(d10));
        return Math.max(d10, ShadowDrawableWrapper.COS_45);
    }

    public static long b(double d10) {
        o.e(c(d10), "not a normal value");
        int exponent = Math.getExponent(d10);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d10) & DoubleConsts.SIGNIF_BIT_MASK;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    public static boolean c(double d10) {
        return Math.getExponent(d10) <= 1023;
    }
}
