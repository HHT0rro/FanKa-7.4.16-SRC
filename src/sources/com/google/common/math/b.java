package com.google.common.math;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.math.RoundingMode;

/* compiled from: DoubleMath.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final double f26686a = Math.log(2.0d);

    /* renamed from: b, reason: collision with root package name */
    public static final double[] f26687b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* compiled from: DoubleMath.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26688a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f26688a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26688a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26688a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26688a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26688a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26688a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26688a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26688a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d10) {
        return c.c(d10) && (d10 == ShadowDrawableWrapper.COS_45 || 52 - Long.numberOfTrailingZeros(c.b(d10)) <= Math.getExponent(d10));
    }

    public static double b(double d10, RoundingMode roundingMode) {
        if (c.c(d10)) {
            switch (a.f26688a[roundingMode.ordinal()]) {
                case 1:
                    f.e(a(d10));
                    return d10;
                case 2:
                    return (d10 >= ShadowDrawableWrapper.COS_45 || a(d10)) ? d10 : ((long) d10) - 1;
                case 3:
                    return (d10 <= ShadowDrawableWrapper.COS_45 || a(d10)) ? d10 : ((long) d10) + 1;
                case 4:
                    return d10;
                case 5:
                    if (a(d10)) {
                        return d10;
                    }
                    return ((long) d10) + (d10 > ShadowDrawableWrapper.COS_45 ? 1 : -1);
                case 6:
                    return Math.rint(d10);
                case 7:
                    double rint = Math.rint(d10);
                    return Math.abs(d10 - rint) == 0.5d ? d10 + Math.copySign(0.5d, d10) : rint;
                case 8:
                    double rint2 = Math.rint(d10);
                    return Math.abs(d10 - rint2) == 0.5d ? d10 : rint2;
                default:
                    throw new AssertionError();
            }
        }
        throw new ArithmeticException("input is infinite or NaN");
    }

    public static long c(double d10, RoundingMode roundingMode) {
        double b4 = b(d10, roundingMode);
        f.a(((-9.223372036854776E18d) - b4 < 1.0d) & (b4 < 9.223372036854776E18d), d10, roundingMode);
        return (long) b4;
    }
}
