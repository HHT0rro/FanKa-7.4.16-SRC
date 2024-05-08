package java.lang;

import android.view.OplusBaseLayoutParams;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import dalvik.annotation.optimization.CriticalNative;
import java.math.BigDecimal;
import java.util.Random;
import jdk.internal.math.DoubleConsts;
import jdk.internal.math.FloatConsts;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Math {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final double DEGREES_TO_RADIANS = 0.017453292519943295d;
    public static final double E = 2.718281828459045d;
    public static final double PI = 3.141592653589793d;
    private static final double RADIANS_TO_DEGREES = 57.29577951308232d;
    private static final long negativeZeroFloatBits = Float.floatToRawIntBits(-0.0f);
    private static final long negativeZeroDoubleBits = Double.doubleToRawLongBits(-0.0d);
    static double twoToTheDoubleScaleUp = powerOfTwoD(512);
    static double twoToTheDoubleScaleDown = powerOfTwoD(-512);

    @CriticalNative
    public static native double IEEEremainder(double d10, double d11);

    @CriticalNative
    public static native double acos(double d10);

    @CriticalNative
    public static native double asin(double d10);

    @CriticalNative
    public static native double atan(double d10);

    @CriticalNative
    public static native double atan2(double d10, double d11);

    @CriticalNative
    public static native double cbrt(double d10);

    @CriticalNative
    public static native double ceil(double d10);

    @CriticalNative
    public static native double cos(double d10);

    @CriticalNative
    public static native double cosh(double d10);

    @CriticalNative
    public static native double exp(double d10);

    @CriticalNative
    public static native double expm1(double d10);

    @CriticalNative
    public static native double floor(double d10);

    @CriticalNative
    public static native double hypot(double d10, double d11);

    @CriticalNative
    public static native double log(double d10);

    @CriticalNative
    public static native double log10(double d10);

    @CriticalNative
    public static native double log1p(double d10);

    @CriticalNative
    public static native double pow(double d10, double d11);

    @CriticalNative
    public static native double rint(double d10);

    @CriticalNative
    public static native double sin(double d10);

    @CriticalNative
    public static native double sinh(double d10);

    @CriticalNative
    public static native double sqrt(double d10);

    @CriticalNative
    public static native double tan(double d10);

    @CriticalNative
    public static native double tanh(double d10);

    private Math() {
    }

    public static double toRadians(double angdeg) {
        return DEGREES_TO_RADIANS * angdeg;
    }

    public static double toDegrees(double angrad) {
        return RADIANS_TO_DEGREES * angrad;
    }

    public static int round(float a10) {
        int intBits = Float.floatToRawIntBits(a10);
        int biasedExp = (2139095040 & intBits) >> 23;
        int shift = 149 - biasedExp;
        if ((shift & (-32)) == 0) {
            int r10 = (8388607 & intBits) | 8388608;
            if (intBits < 0) {
                r10 = -r10;
            }
            return ((r10 >> shift) + 1) >> 1;
        }
        return (int) a10;
    }

    public static long round(double a10) {
        long longBits = Double.doubleToRawLongBits(a10);
        long biasedExp = (DoubleConsts.EXP_BIT_MASK & longBits) >> 52;
        long shift = 1074 - biasedExp;
        if (((-64) & shift) == 0) {
            long r10 = (DoubleConsts.SIGNIF_BIT_MASK & longBits) | 4503599627370496L;
            if (longBits < 0) {
                r10 = -r10;
            }
            return ((r10 >> ((int) shift)) + 1) >> 1;
        }
        return (long) a10;
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

    public static void setRandomSeedInternal(long seed) {
        RandomNumberGeneratorHolder.randomNumberGenerator.setSeed(seed);
    }

    public static int randomIntInternal() {
        return RandomNumberGeneratorHolder.randomNumberGenerator.nextInt();
    }

    public static long randomLongInternal() {
        return RandomNumberGeneratorHolder.randomNumberGenerator.nextLong();
    }

    public static int addExact(int x10, int y10) {
        int r10 = x10 + y10;
        if (((x10 ^ r10) & (y10 ^ r10)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r10;
    }

    public static long addExact(long x10, long y10) {
        long r10 = x10 + y10;
        if (((x10 ^ r10) & (y10 ^ r10)) < 0) {
            throw new ArithmeticException("long overflow");
        }
        return r10;
    }

    public static int subtractExact(int x10, int y10) {
        int r10 = x10 - y10;
        if (((x10 ^ y10) & (x10 ^ r10)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r10;
    }

    public static long subtractExact(long x10, long y10) {
        long r10 = x10 - y10;
        if (((x10 ^ y10) & (x10 ^ r10)) < 0) {
            throw new ArithmeticException("long overflow");
        }
        return r10;
    }

    public static int multiplyExact(int x10, int y10) {
        long r10 = x10 * y10;
        if (((int) r10) != r10) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) r10;
    }

    public static long multiplyExact(long x10, int y10) {
        return multiplyExact(x10, y10);
    }

    public static long multiplyExact(long x10, long y10) {
        long r10 = x10 * y10;
        long ax = abs(x10);
        long ay = abs(y10);
        if (((ax | ay) >>> 31) != 0 && ((y10 != 0 && r10 / y10 != x10) || (x10 == Long.MIN_VALUE && y10 == -1))) {
            throw new ArithmeticException("long overflow");
        }
        return r10;
    }

    public static int incrementExact(int a10) {
        if (a10 == Integer.MAX_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        return a10 + 1;
    }

    public static long incrementExact(long a10) {
        if (a10 == Long.MAX_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        return 1 + a10;
    }

    public static int decrementExact(int a10) {
        if (a10 == Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        return a10 - 1;
    }

    public static long decrementExact(long a10) {
        if (a10 == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        return a10 - 1;
    }

    public static int negateExact(int a10) {
        if (a10 == Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        return -a10;
    }

    public static long negateExact(long a10) {
        if (a10 == Long.MIN_VALUE) {
            throw new ArithmeticException("long overflow");
        }
        return -a10;
    }

    public static int toIntExact(long value) {
        if (((int) value) != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) value;
    }

    public static long multiplyFull(int x10, int y10) {
        return x10 * y10;
    }

    public static long multiplyHigh(long x10, long y10) {
        if (x10 < 0 || y10 < 0) {
            long x12 = x10 >> 32;
            long x22 = x10 & 4294967295L;
            long y1 = y10 >> 32;
            long y22 = y10 & 4294967295L;
            long z22 = x22 * y22;
            long t2 = (x12 * y22) + (z22 >>> 32);
            long z1 = t2 & 4294967295L;
            long z02 = t2 >> 32;
            return (x12 * y1) + z02 + ((z1 + (x22 * y1)) >> 32);
        }
        long x13 = x10 >>> 32;
        long y12 = y10 >>> 32;
        long x23 = x10 & 4294967295L;
        long y23 = y10 & 4294967295L;
        long A = x13 * y12;
        long B = x23 * y23;
        long C = (x13 + x23) * (y12 + y23);
        long K = (C - A) - B;
        return (((B >>> 32) + K) >>> 32) + A;
    }

    public static int floorDiv(int x10, int y10) {
        int r10 = x10 / y10;
        if ((x10 ^ y10) < 0 && r10 * y10 != x10) {
            return r10 - 1;
        }
        return r10;
    }

    public static long floorDiv(long x10, int y10) {
        return floorDiv(x10, y10);
    }

    public static long floorDiv(long x10, long y10) {
        long r10 = x10 / y10;
        if ((x10 ^ y10) < 0 && r10 * y10 != x10) {
            return r10 - 1;
        }
        return r10;
    }

    public static int floorMod(int x10, int y10) {
        int mod = x10 % y10;
        if ((mod ^ y10) < 0 && mod != 0) {
            return mod + y10;
        }
        return mod;
    }

    public static int floorMod(long x10, int y10) {
        return (int) floorMod(x10, y10);
    }

    public static long floorMod(long x10, long y10) {
        long mod = x10 % y10;
        if ((x10 ^ y10) < 0 && mod != 0) {
            return mod + y10;
        }
        return mod;
    }

    public static int abs(int a10) {
        return a10 < 0 ? -a10 : a10;
    }

    public static int absExact(int a10) {
        if (a10 == Integer.MIN_VALUE) {
            throw new ArithmeticException("Overflow to represent absolute value of Integer.MIN_VALUE");
        }
        return abs(a10);
    }

    public static long abs(long a10) {
        return a10 < 0 ? -a10 : a10;
    }

    public static long absExact(long a10) {
        if (a10 == Long.MIN_VALUE) {
            throw new ArithmeticException("Overflow to represent absolute value of Long.MIN_VALUE");
        }
        return abs(a10);
    }

    public static float abs(float a10) {
        return Float.intBitsToFloat(Integer.MAX_VALUE & Float.floatToRawIntBits(a10));
    }

    public static double abs(double a10) {
        return Double.longBitsToDouble(Long.MAX_VALUE & Double.doubleToRawLongBits(a10));
    }

    public static int max(int a10, int b4) {
        return a10 >= b4 ? a10 : b4;
    }

    public static long max(long a10, long b4) {
        return a10 >= b4 ? a10 : b4;
    }

    public static float max(float a10, float b4) {
        if (a10 != a10) {
            return a10;
        }
        if (a10 == 0.0f && b4 == 0.0f && Float.floatToRawIntBits(a10) == negativeZeroFloatBits) {
            return b4;
        }
        return a10 >= b4 ? a10 : b4;
    }

    public static double max(double a10, double b4) {
        if (a10 != a10) {
            return a10;
        }
        if (a10 == ShadowDrawableWrapper.COS_45 && b4 == ShadowDrawableWrapper.COS_45 && Double.doubleToRawLongBits(a10) == negativeZeroDoubleBits) {
            return b4;
        }
        return a10 >= b4 ? a10 : b4;
    }

    public static int min(int a10, int b4) {
        return a10 <= b4 ? a10 : b4;
    }

    public static long min(long a10, long b4) {
        return a10 <= b4 ? a10 : b4;
    }

    public static float min(float a10, float b4) {
        if (a10 != a10) {
            return a10;
        }
        if (a10 == 0.0f && b4 == 0.0f && Float.floatToRawIntBits(b4) == negativeZeroFloatBits) {
            return b4;
        }
        return a10 <= b4 ? a10 : b4;
    }

    public static double min(double a10, double b4) {
        if (a10 != a10) {
            return a10;
        }
        if (a10 == ShadowDrawableWrapper.COS_45 && b4 == ShadowDrawableWrapper.COS_45 && Double.doubleToRawLongBits(b4) == negativeZeroDoubleBits) {
            return b4;
        }
        return a10 <= b4 ? a10 : b4;
    }

    public static double fma(double a10, double b4, double c4) {
        if (Double.isNaN(a10) || Double.isNaN(b4) || Double.isNaN(c4)) {
            return Double.NaN;
        }
        boolean infiniteA = Double.isInfinite(a10);
        boolean infiniteB = Double.isInfinite(b4);
        boolean infiniteC = Double.isInfinite(c4);
        if (infiniteA || infiniteB || infiniteC) {
            if ((infiniteA && b4 == ShadowDrawableWrapper.COS_45) || (infiniteB && a10 == ShadowDrawableWrapper.COS_45)) {
                return Double.NaN;
            }
            double product = a10 * b4;
            if (Double.isInfinite(product) && !infiniteA && !infiniteB) {
                return c4;
            }
            double result = product + c4;
            return result;
        }
        BigDecimal product2 = new BigDecimal(a10).multiply(new BigDecimal(b4));
        if (c4 != ShadowDrawableWrapper.COS_45) {
            return product2.add(new BigDecimal(c4)).doubleValue();
        }
        if (a10 == ShadowDrawableWrapper.COS_45 || b4 == ShadowDrawableWrapper.COS_45) {
            return (a10 * b4) + c4;
        }
        return product2.doubleValue();
    }

    public static float fma(float a10, float b4, float c4) {
        if (!Float.isFinite(a10) || !Float.isFinite(b4) || !Float.isFinite(c4)) {
            return (float) fma(a10, b4, c4);
        }
        if (a10 == ShadowDrawableWrapper.COS_45 || b4 == ShadowDrawableWrapper.COS_45) {
            return (a10 * b4) + c4;
        }
        return new BigDecimal(a10 * b4).add(new BigDecimal(c4)).floatValue();
    }

    public static double ulp(double d10) {
        int exp = getExponent(d10);
        switch (exp) {
            case -1023:
                return Double.MIN_VALUE;
            case 1024:
                return abs(d10);
            default:
                int exp2 = exp - 52;
                if (exp2 >= -1022) {
                    return powerOfTwoD(exp2);
                }
                return Double.longBitsToDouble(1 << (exp2 + DownloadErrorCode.ERROR_BAD_URL));
        }
    }

    public static float ulp(float f10) {
        int exp = getExponent(f10);
        switch (exp) {
            case -127:
                return Float.MIN_VALUE;
            case 128:
                return abs(f10);
            default:
                int exp2 = exp - 23;
                if (exp2 >= -126) {
                    return powerOfTwoF(exp2);
                }
                return Float.intBitsToFloat(1 << (exp2 + 149));
        }
    }

    public static double signum(double d10) {
        return (d10 == ShadowDrawableWrapper.COS_45 || Double.isNaN(d10)) ? d10 : copySign(1.0d, d10);
    }

    public static float signum(float f10) {
        return (f10 == 0.0f || Float.isNaN(f10)) ? f10 : copySign(1.0f, f10);
    }

    public static double copySign(double magnitude, double sign) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(sign) & Long.MIN_VALUE) | (Double.doubleToRawLongBits(magnitude) & Long.MAX_VALUE));
    }

    public static float copySign(float magnitude, float sign) {
        return Float.intBitsToFloat((Float.floatToRawIntBits(sign) & Integer.MIN_VALUE) | (Float.floatToRawIntBits(magnitude) & Integer.MAX_VALUE));
    }

    public static int getExponent(float f10) {
        return ((Float.floatToRawIntBits(f10) & FloatConsts.EXP_BIT_MASK) >> 23) - 127;
    }

    public static int getExponent(double d10) {
        return (int) (((Double.doubleToRawLongBits(d10) & DoubleConsts.EXP_BIT_MASK) >> 52) - 1023);
    }

    public static double nextAfter(double start, double direction) {
        if (start > direction) {
            if (start != ShadowDrawableWrapper.COS_45) {
                long transducer = Double.doubleToRawLongBits(start);
                return Double.longBitsToDouble((transducer > 0 ? -1L : 1L) + transducer);
            }
            return -4.9E-324d;
        }
        if (start < direction) {
            long transducer2 = Double.doubleToRawLongBits(ShadowDrawableWrapper.COS_45 + start);
            return Double.longBitsToDouble((transducer2 < 0 ? -1L : 1L) + transducer2);
        }
        if (start == direction) {
            return direction;
        }
        return start + direction;
    }

    public static float nextAfter(float start, double direction) {
        if (start > direction) {
            if (start != 0.0f) {
                int transducer = Float.floatToRawIntBits(start);
                return Float.intBitsToFloat((transducer > 0 ? -1 : 1) + transducer);
            }
            return -1.4E-45f;
        }
        if (start < direction) {
            int transducer2 = Float.floatToRawIntBits(0.0f + start);
            return Float.intBitsToFloat((transducer2 < 0 ? -1 : 1) + transducer2);
        }
        if (start == direction) {
            return (float) direction;
        }
        return ((float) direction) + start;
    }

    public static double nextUp(double d10) {
        if (d10 < Double.POSITIVE_INFINITY) {
            long transducer = Double.doubleToRawLongBits(ShadowDrawableWrapper.COS_45 + d10);
            return Double.longBitsToDouble((transducer >= 0 ? 1L : -1L) + transducer);
        }
        return d10;
    }

    public static float nextUp(float f10) {
        if (f10 < Float.POSITIVE_INFINITY) {
            int transducer = Float.floatToRawIntBits(0.0f + f10);
            return Float.intBitsToFloat((transducer >= 0 ? 1 : -1) + transducer);
        }
        return f10;
    }

    public static double nextDown(double d10) {
        if (Double.isNaN(d10) || d10 == Double.NEGATIVE_INFINITY) {
            return d10;
        }
        if (d10 == ShadowDrawableWrapper.COS_45) {
            return -4.9E-324d;
        }
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d10) + (d10 > ShadowDrawableWrapper.COS_45 ? -1L : 1L));
    }

    public static float nextDown(float f10) {
        if (Float.isNaN(f10) || f10 == Float.NEGATIVE_INFINITY) {
            return f10;
        }
        if (f10 == 0.0f) {
            return -1.4E-45f;
        }
        return Float.intBitsToFloat(Float.floatToRawIntBits(f10) + (f10 > 0.0f ? -1 : 1));
    }

    public static double scalb(double d10, int scaleFactor) {
        int scaleFactor2;
        int scale_increment;
        double exp_delta;
        if (scaleFactor < 0) {
            scaleFactor2 = max(scaleFactor, -2099);
            scale_increment = -512;
            exp_delta = twoToTheDoubleScaleDown;
        } else {
            scaleFactor2 = min(scaleFactor, OplusBaseLayoutParams.TYPE_SYSTEM_BLACKSCREEN_OVERLAY);
            scale_increment = 512;
            exp_delta = twoToTheDoubleScaleUp;
        }
        int t2 = (scaleFactor2 >> 8) >>> 23;
        int exp_adjust = ((scaleFactor2 + t2) & 511) - t2;
        double d11 = d10 * powerOfTwoD(exp_adjust);
        for (int scaleFactor3 = scaleFactor2 - exp_adjust; scaleFactor3 != 0; scaleFactor3 -= scale_increment) {
            d11 *= exp_delta;
        }
        return d11;
    }

    public static float scalb(float f10, int scaleFactor) {
        return (float) (f10 * powerOfTwoD(max(min(scaleFactor, 278), -278)));
    }

    static double powerOfTwoD(int n10) {
        return Double.longBitsToDouble(((n10 + 1023) << 52) & DoubleConsts.EXP_BIT_MASK);
    }

    static float powerOfTwoF(int n10) {
        return Float.intBitsToFloat(((n10 + 127) << 23) & FloatConsts.EXP_BIT_MASK);
    }
}
