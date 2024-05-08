package java.lang;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import jdk.internal.math.DoubleConsts;
import jdk.internal.math.FloatingDecimal;
import org.apache.commons.io.FileUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Double extends Number implements Comparable<Double> {
    public static final int BYTES = 8;
    public static final int MAX_EXPONENT = 1023;
    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final int MIN_EXPONENT = -1022;
    public static final double MIN_NORMAL = Double.MIN_NORMAL;
    public static final double MIN_VALUE = Double.MIN_VALUE;
    public static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    public static final double NaN = Double.NaN;
    public static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    public static final int SIZE = 64;
    public static final Class<Double> TYPE = Class.getPrimitiveClass("double");
    private static final long serialVersionUID = -9172774392245257468L;
    private final double value;

    public static native long doubleToRawLongBits(double d10);

    public static native double longBitsToDouble(long j10);

    public static String toString(double d10) {
        return FloatingDecimal.toJavaFormatString(d10);
    }

    public static String toHexString(double d10) {
        String replaceFirst;
        int exponent;
        if (!isFinite(d10)) {
            return toString(d10);
        }
        StringBuilder answer = new StringBuilder(24);
        if (Math.copySign(1.0d, d10) == -1.0d) {
            answer.append("-");
        }
        answer.append("0x");
        double d11 = Math.abs(d10);
        if (d11 == ShadowDrawableWrapper.COS_45) {
            answer.append("0.0p0");
        } else {
            boolean subnormal = d11 < Double.MIN_NORMAL;
            long signifBits = (doubleToLongBits(d11) & DoubleConsts.SIGNIF_BIT_MASK) | FileUtils.ONE_EB;
            answer.append(subnormal ? "0." : "1.");
            String signif = Long.toHexString(signifBits).substring(3, 16);
            if (signif.equals("0000000000000")) {
                replaceFirst = "0";
            } else {
                replaceFirst = signif.replaceFirst("0{1,12}$", "");
            }
            answer.append(replaceFirst);
            answer.append('p');
            if (subnormal) {
                exponent = -1022;
            } else {
                exponent = Math.getExponent(d11);
            }
            answer.append(exponent);
        }
        return answer.toString();
    }

    public static Double valueOf(String s2) throws NumberFormatException {
        return new Double(parseDouble(s2));
    }

    public static Double valueOf(double d10) {
        return new Double(d10);
    }

    public static double parseDouble(String s2) throws NumberFormatException {
        return FloatingDecimal.parseDouble(s2);
    }

    public static boolean isNaN(double v2) {
        return v2 != v2;
    }

    public static boolean isInfinite(double v2) {
        return v2 == Double.POSITIVE_INFINITY || v2 == Double.NEGATIVE_INFINITY;
    }

    public static boolean isFinite(double d10) {
        return Math.abs(d10) <= Double.MAX_VALUE;
    }

    @Deprecated(since = "9")
    public Double(double value) {
        this.value = value;
    }

    @Deprecated(since = "9")
    public Double(String s2) throws NumberFormatException {
        this.value = parseDouble(s2);
    }

    public boolean isNaN() {
        return isNaN(this.value);
    }

    public boolean isInfinite() {
        return isInfinite(this.value);
    }

    public String toString() {
        return toString(this.value);
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return (short) this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(double value) {
        long bits = doubleToLongBits(value);
        return (int) ((bits >>> 32) ^ bits);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Double) && doubleToLongBits(((Double) obj).value) == doubleToLongBits(this.value);
    }

    public static long doubleToLongBits(double value) {
        if (!isNaN(value)) {
            return doubleToRawLongBits(value);
        }
        return 9221120237041090560L;
    }

    @Override // java.lang.Comparable
    public int compareTo(Double anotherDouble) {
        return compare(this.value, anotherDouble.value);
    }

    public static int compare(double d12, double d22) {
        if (d12 < d22) {
            return -1;
        }
        if (d12 > d22) {
            return 1;
        }
        long thisBits = doubleToLongBits(d12);
        long anotherBits = doubleToLongBits(d22);
        if (thisBits == anotherBits) {
            return 0;
        }
        return thisBits < anotherBits ? -1 : 1;
    }

    public static double sum(double a10, double b4) {
        return a10 + b4;
    }

    public static double max(double a10, double b4) {
        return Math.max(a10, b4);
    }

    public static double min(double a10, double b4) {
        return Math.min(a10, b4);
    }
}
