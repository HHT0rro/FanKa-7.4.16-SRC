package java.lang;

import jdk.internal.math.FloatingDecimal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Float extends Number implements Comparable<Float> {
    public static final int BYTES = 4;
    public static final int MAX_EXPONENT = 127;
    public static final float MAX_VALUE = Float.MAX_VALUE;
    public static final int MIN_EXPONENT = -126;
    public static final float MIN_NORMAL = Float.MIN_NORMAL;
    public static final float MIN_VALUE = Float.MIN_VALUE;
    public static final float NEGATIVE_INFINITY = Float.NEGATIVE_INFINITY;
    public static final float NaN = Float.NaN;
    public static final float POSITIVE_INFINITY = Float.POSITIVE_INFINITY;
    public static final int SIZE = 32;
    public static final Class<Float> TYPE = Class.getPrimitiveClass("float");
    private static final long serialVersionUID = -2671257302660747028L;
    private final float value;

    public static native int floatToRawIntBits(float f10);

    public static native float intBitsToFloat(int i10);

    public static String toString(float f10) {
        return FloatingDecimal.toJavaFormatString(f10);
    }

    public static String toHexString(float f10) {
        if (Math.abs(f10) < Float.MIN_NORMAL && f10 != 0.0f) {
            String s2 = Double.toHexString(Math.scalb(f10, -896));
            return s2.replaceFirst("p-1022$", "p-126");
        }
        return Double.toHexString(f10);
    }

    public static Float valueOf(String s2) throws NumberFormatException {
        return new Float(parseFloat(s2));
    }

    public static Float valueOf(float f10) {
        return new Float(f10);
    }

    public static float parseFloat(String s2) throws NumberFormatException {
        return FloatingDecimal.parseFloat(s2);
    }

    public static boolean isNaN(float v2) {
        return v2 != v2;
    }

    public static boolean isInfinite(float v2) {
        return v2 == Float.POSITIVE_INFINITY || v2 == Float.NEGATIVE_INFINITY;
    }

    public static boolean isFinite(float f10) {
        return Math.abs(f10) <= Float.MAX_VALUE;
    }

    @Deprecated(since = "9")
    public Float(float value) {
        this.value = value;
    }

    @Deprecated(since = "9")
    public Float(double value) {
        this.value = (float) value;
    }

    @Deprecated(since = "9")
    public Float(String s2) throws NumberFormatException {
        this.value = parseFloat(s2);
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
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(float value) {
        return floatToIntBits(value);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Float) && floatToIntBits(((Float) obj).value) == floatToIntBits(this.value);
    }

    public static int floatToIntBits(float value) {
        if (!isNaN(value)) {
            return floatToRawIntBits(value);
        }
        return 2143289344;
    }

    @Override // java.lang.Comparable
    public int compareTo(Float anotherFloat) {
        return compare(this.value, anotherFloat.value);
    }

    public static int compare(float f12, float f22) {
        if (f12 < f22) {
            return -1;
        }
        if (f12 > f22) {
            return 1;
        }
        int thisBits = floatToIntBits(f12);
        int anotherBits = floatToIntBits(f22);
        if (thisBits == anotherBits) {
            return 0;
        }
        return thisBits < anotherBits ? -1 : 1;
    }

    public static float sum(float a10, float b4) {
        return a10 + b4;
    }

    public static float max(float a10, float b4) {
        return Math.max(a10, b4);
    }

    public static float min(float a10, float b4) {
        return Math.min(a10, b4);
    }
}
