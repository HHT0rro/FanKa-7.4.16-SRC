package sun.misc;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import jdk.internal.math.DoubleConsts;
import jdk.internal.math.FloatConsts;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FpUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private FpUtils() {
    }

    @Deprecated
    public static int getExponent(double d10) {
        return Math.getExponent(d10);
    }

    @Deprecated
    public static int getExponent(float f10) {
        return Math.getExponent(f10);
    }

    @Deprecated
    public static double rawCopySign(double magnitude, double sign) {
        return Math.copySign(magnitude, sign);
    }

    @Deprecated
    public static float rawCopySign(float magnitude, float sign) {
        return Math.copySign(magnitude, sign);
    }

    @Deprecated
    public static boolean isFinite(double d10) {
        return Double.isFinite(d10);
    }

    @Deprecated
    public static boolean isFinite(float f10) {
        return Float.isFinite(f10);
    }

    public static boolean isInfinite(double d10) {
        return Double.isInfinite(d10);
    }

    public static boolean isInfinite(float f10) {
        return Float.isInfinite(f10);
    }

    public static boolean isNaN(double d10) {
        return Double.isNaN(d10);
    }

    public static boolean isNaN(float f10) {
        return Float.isNaN(f10);
    }

    public static boolean isUnordered(double arg1, double arg2) {
        return isNaN(arg1) || isNaN(arg2);
    }

    public static boolean isUnordered(float arg1, float arg2) {
        return isNaN(arg1) || isNaN(arg2);
    }

    public static int ilogb(double d10) {
        int exponent = getExponent(d10);
        switch (exponent) {
            case -1023:
                if (d10 == ShadowDrawableWrapper.COS_45) {
                    return -268435456;
                }
                long transducer = Double.doubleToRawLongBits(d10);
                long transducer2 = transducer & DoubleConsts.SIGNIF_BIT_MASK;
                while (transducer2 < 4503599627370496L) {
                    transducer2 *= 2;
                    exponent--;
                }
                return exponent + 1;
            case 1024:
                if (isNaN(d10)) {
                    return 1073741824;
                }
                return 268435456;
            default:
                return exponent;
        }
    }

    public static int ilogb(float f10) {
        int exponent = getExponent(f10);
        switch (exponent) {
            case -127:
                if (f10 == 0.0f) {
                    return -268435456;
                }
                int transducer = Float.floatToRawIntBits(f10);
                int transducer2 = transducer & FloatConsts.SIGNIF_BIT_MASK;
                while (transducer2 < 8388608) {
                    transducer2 *= 2;
                    exponent--;
                }
                return exponent + 1;
            case 128:
                if (isNaN(f10)) {
                    return 1073741824;
                }
                return 268435456;
            default:
                return exponent;
        }
    }

    @Deprecated
    public static double scalb(double d10, int scale_factor) {
        return Math.scalb(d10, scale_factor);
    }

    @Deprecated
    public static float scalb(float f10, int scale_factor) {
        return Math.scalb(f10, scale_factor);
    }

    @Deprecated
    public static double nextAfter(double start, double direction) {
        return Math.nextAfter(start, direction);
    }

    @Deprecated
    public static float nextAfter(float start, double direction) {
        return Math.nextAfter(start, direction);
    }

    @Deprecated
    public static double nextUp(double d10) {
        return Math.nextUp(d10);
    }

    @Deprecated
    public static float nextUp(float f10) {
        return Math.nextUp(f10);
    }

    @Deprecated
    public static double nextDown(double d10) {
        return Math.nextDown(d10);
    }

    @Deprecated
    public static double nextDown(float f10) {
        return Math.nextDown(f10);
    }

    @Deprecated
    public static double copySign(double magnitude, double sign) {
        return StrictMath.copySign(magnitude, sign);
    }

    @Deprecated
    public static float copySign(float magnitude, float sign) {
        return StrictMath.copySign(magnitude, sign);
    }

    @Deprecated
    public static double ulp(double d10) {
        return Math.ulp(d10);
    }

    @Deprecated
    public static float ulp(float f10) {
        return Math.ulp(f10);
    }

    @Deprecated
    public static double signum(double d10) {
        return Math.signum(d10);
    }

    @Deprecated
    public static float signum(float f10) {
        return Math.signum(f10);
    }
}
