package java.lang;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Random;
import jdk.internal.math.DoubleConsts;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StrictMath {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final double DEGREES_TO_RADIANS = 0.017453292519943295d;
    public static final double E = 2.718281828459045d;
    public static final double PI = 3.141592653589793d;
    private static final double RADIANS_TO_DEGREES = 57.29577951308232d;

    public static native double IEEEremainder(double d10, double d11);

    public static native double acos(double d10);

    public static native double asin(double d10);

    public static native double atan(double d10);

    public static native double atan2(double d10, double d11);

    public static native double cbrt(double d10);

    public static native double cos(double d10);

    public static native double cosh(double d10);

    public static native double exp(double d10);

    public static native double expm1(double d10);

    public static native double hypot(double d10, double d11);

    public static native double log(double d10);

    public static native double log10(double d10);

    public static native double log1p(double d10);

    public static native double pow(double d10, double d11);

    public static native double sin(double d10);

    public static native double sinh(double d10);

    public static native double sqrt(double d10);

    public static native double tan(double d10);

    public static native double tanh(double d10);

    private StrictMath() {
    }

    public static double toRadians(double angdeg) {
        return DEGREES_TO_RADIANS * angdeg;
    }

    public static double toDegrees(double angrad) {
        return RADIANS_TO_DEGREES * angrad;
    }

    public static double ceil(double a10) {
        return floorOrCeil(a10, -0.0d, 1.0d, 1.0d);
    }

    public static double floor(double a10) {
        return floorOrCeil(a10, -1.0d, ShadowDrawableWrapper.COS_45, -1.0d);
    }

    private static double floorOrCeil(double a10, double negativeBoundary, double positiveBoundary, double sign) {
        int exponent = Math.getExponent(a10);
        if (exponent < 0) {
            return a10 == ShadowDrawableWrapper.COS_45 ? a10 : a10 < ShadowDrawableWrapper.COS_45 ? negativeBoundary : positiveBoundary;
        }
        if (exponent >= 52) {
            return a10;
        }
        long doppel = Double.doubleToRawLongBits(a10);
        long mask = DoubleConsts.SIGNIF_BIT_MASK >> exponent;
        if ((mask & doppel) == 0) {
            return a10;
        }
        double result = Double.longBitsToDouble((~mask) & doppel);
        if (sign * a10 > ShadowDrawableWrapper.COS_45) {
            return result + sign;
        }
        return result;
    }

    public static double rint(double a10) {
        double sign = Math.copySign(1.0d, a10);
        double a11 = Math.abs(a10);
        if (a11 < 4.503599627370496E15d) {
            a11 = (4.503599627370496E15d + a11) - 4.503599627370496E15d;
        }
        return sign * a11;
    }

    public static int round(float a10) {
        return Math.round(a10);
    }

    public static long round(double a10) {
        return Math.round(a10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class RandomNumberGeneratorHolder {
        static final Random randomNumberGenerator = new Random();

        private RandomNumberGeneratorHolder() {
        }
    }

    public static double random() {
        return RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
    }

    public static int addExact(int x10, int y10) {
        return Math.addExact(x10, y10);
    }

    public static long addExact(long x10, long y10) {
        return Math.addExact(x10, y10);
    }

    public static int subtractExact(int x10, int y10) {
        return Math.subtractExact(x10, y10);
    }

    public static long subtractExact(long x10, long y10) {
        return Math.subtractExact(x10, y10);
    }

    public static int multiplyExact(int x10, int y10) {
        return Math.multiplyExact(x10, y10);
    }

    public static long multiplyExact(long x10, int y10) {
        return Math.multiplyExact(x10, y10);
    }

    public static long multiplyExact(long x10, long y10) {
        return Math.multiplyExact(x10, y10);
    }

    public static int incrementExact(int a10) {
        return Math.incrementExact(a10);
    }

    public static long incrementExact(long a10) {
        return Math.incrementExact(a10);
    }

    public static int decrementExact(int a10) {
        return Math.decrementExact(a10);
    }

    public static long decrementExact(long a10) {
        return Math.decrementExact(a10);
    }

    public static int negateExact(int a10) {
        return Math.negateExact(a10);
    }

    public static long negateExact(long a10) {
        return Math.negateExact(a10);
    }

    public static int toIntExact(long value) {
        return Math.toIntExact(value);
    }

    public static long multiplyFull(int x10, int y10) {
        return Math.multiplyFull(x10, y10);
    }

    public static long multiplyHigh(long x10, long y10) {
        return Math.multiplyHigh(x10, y10);
    }

    public static int floorDiv(int x10, int y10) {
        return Math.floorDiv(x10, y10);
    }

    public static long floorDiv(long x10, int y10) {
        return Math.floorDiv(x10, y10);
    }

    public static long floorDiv(long x10, long y10) {
        return Math.floorDiv(x10, y10);
    }

    public static int floorMod(int x10, int y10) {
        return Math.floorMod(x10, y10);
    }

    public static int floorMod(long x10, int y10) {
        return Math.floorMod(x10, y10);
    }

    public static long floorMod(long x10, long y10) {
        return Math.floorMod(x10, y10);
    }

    public static int abs(int a10) {
        return Math.abs(a10);
    }

    public static int absExact(int a10) {
        return Math.absExact(a10);
    }

    public static long abs(long a10) {
        return Math.abs(a10);
    }

    public static long absExact(long a10) {
        return Math.absExact(a10);
    }

    public static float abs(float a10) {
        return Math.abs(a10);
    }

    public static double abs(double a10) {
        return Math.abs(a10);
    }

    public static int max(int a10, int b4) {
        return Math.max(a10, b4);
    }

    public static long max(long a10, long b4) {
        return Math.max(a10, b4);
    }

    public static float max(float a10, float b4) {
        return Math.max(a10, b4);
    }

    public static double max(double a10, double b4) {
        return Math.max(a10, b4);
    }

    public static int min(int a10, int b4) {
        return Math.min(a10, b4);
    }

    public static long min(long a10, long b4) {
        return Math.min(a10, b4);
    }

    public static float min(float a10, float b4) {
        return Math.min(a10, b4);
    }

    public static double min(double a10, double b4) {
        return Math.min(a10, b4);
    }

    public static double fma(double a10, double b4, double c4) {
        return Math.fma(a10, b4, c4);
    }

    public static float fma(float a10, float b4, float c4) {
        return Math.fma(a10, b4, c4);
    }

    public static double ulp(double d10) {
        return Math.ulp(d10);
    }

    public static float ulp(float f10) {
        return Math.ulp(f10);
    }

    public static double signum(double d10) {
        return Math.signum(d10);
    }

    public static float signum(float f10) {
        return Math.signum(f10);
    }

    public static double copySign(double magnitude, double sign) {
        return Math.copySign(magnitude, Double.isNaN(sign) ? 1.0d : sign);
    }

    public static float copySign(float magnitude, float sign) {
        return Math.copySign(magnitude, Float.isNaN(sign) ? 1.0f : sign);
    }

    public static int getExponent(float f10) {
        return Math.getExponent(f10);
    }

    public static int getExponent(double d10) {
        return Math.getExponent(d10);
    }

    public static double nextAfter(double start, double direction) {
        return Math.nextAfter(start, direction);
    }

    public static float nextAfter(float start, double direction) {
        return Math.nextAfter(start, direction);
    }

    public static double nextUp(double d10) {
        return Math.nextUp(d10);
    }

    public static float nextUp(float f10) {
        return Math.nextUp(f10);
    }

    public static double nextDown(double d10) {
        return Math.nextDown(d10);
    }

    public static float nextDown(float f10) {
        return Math.nextDown(f10);
    }

    public static double scalb(double d10, int scaleFactor) {
        return Math.scalb(d10, scaleFactor);
    }

    public static float scalb(float f10, int scaleFactor) {
        return Math.scalb(f10, scaleFactor);
    }
}
