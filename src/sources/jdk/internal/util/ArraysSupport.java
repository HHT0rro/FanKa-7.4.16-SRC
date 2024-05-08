package jdk.internal.util;

import jdk.internal.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ArraysSupport {
    private static final boolean BIG_ENDIAN = false;
    public static final int SOFT_MAX_ARRAY_LENGTH = 2147483639;
    static final Unsafe U = Unsafe.getUnsafe();
    public static final int LOG2_ARRAY_BOOLEAN_INDEX_SCALE = exactLog2(Unsafe.ARRAY_BOOLEAN_INDEX_SCALE);
    public static final int LOG2_ARRAY_BYTE_INDEX_SCALE = exactLog2(Unsafe.ARRAY_BYTE_INDEX_SCALE);
    public static final int LOG2_ARRAY_CHAR_INDEX_SCALE = exactLog2(Unsafe.ARRAY_CHAR_INDEX_SCALE);
    public static final int LOG2_ARRAY_SHORT_INDEX_SCALE = exactLog2(Unsafe.ARRAY_SHORT_INDEX_SCALE);
    public static final int LOG2_ARRAY_INT_INDEX_SCALE = exactLog2(Unsafe.ARRAY_INT_INDEX_SCALE);
    public static final int LOG2_ARRAY_LONG_INDEX_SCALE = exactLog2(Unsafe.ARRAY_LONG_INDEX_SCALE);
    public static final int LOG2_ARRAY_FLOAT_INDEX_SCALE = exactLog2(Unsafe.ARRAY_FLOAT_INDEX_SCALE);
    public static final int LOG2_ARRAY_DOUBLE_INDEX_SCALE = exactLog2(Unsafe.ARRAY_DOUBLE_INDEX_SCALE);
    private static final int LOG2_BYTE_BIT_SIZE = exactLog2(8);

    private static int exactLog2(int scale) {
        if (((scale - 1) & scale) != 0) {
            throw new Error("data type scale not a power of two");
        }
        return Integer.numberOfTrailingZeros(scale);
    }

    private ArraysSupport() {
    }

    public static int vectorizedMismatch(Object a10, long aOffset, Object b4, long bOffset, int length, int log2ArrayIndexScale) {
        int log2ValuesPerWidth = LOG2_ARRAY_LONG_INDEX_SCALE - log2ArrayIndexScale;
        int wi = 0;
        while (wi < (length >> log2ValuesPerWidth)) {
            long bi = wi << LOG2_ARRAY_LONG_INDEX_SCALE;
            Unsafe unsafe = U;
            long av = unsafe.getLongUnaligned(a10, aOffset + bi);
            long bv = unsafe.getLongUnaligned(b4, bOffset + bi);
            if (av == bv) {
                wi++;
            } else {
                long x10 = av ^ bv;
                int o10 = Long.numberOfTrailingZeros(x10) >> (LOG2_BYTE_BIT_SIZE + log2ArrayIndexScale);
                return (wi << log2ValuesPerWidth) + o10;
            }
        }
        int tail = length - (wi << log2ValuesPerWidth);
        int i10 = LOG2_ARRAY_INT_INDEX_SCALE;
        if (log2ArrayIndexScale < i10) {
            int wordTail = 1 << (i10 - log2ArrayIndexScale);
            if (tail >= wordTail) {
                long bi2 = wi << LOG2_ARRAY_LONG_INDEX_SCALE;
                Unsafe unsafe2 = U;
                int av2 = unsafe2.getIntUnaligned(a10, aOffset + bi2);
                int bv2 = unsafe2.getIntUnaligned(b4, bOffset + bi2);
                if (av2 != bv2) {
                    int x11 = av2 ^ bv2;
                    int o11 = Integer.numberOfTrailingZeros(x11) >> (LOG2_BYTE_BIT_SIZE + log2ArrayIndexScale);
                    return (wi << log2ValuesPerWidth) + o11;
                }
                tail -= wordTail;
            }
            return ~tail;
        }
        return ~tail;
    }

    public static int mismatch(boolean[] a10, boolean[] b4, int length) {
        int i10 = 0;
        if (length > 7) {
            if (a10[0] != b4[0]) {
                return 0;
            }
            int i11 = vectorizedMismatch(a10, Unsafe.ARRAY_BOOLEAN_BASE_OFFSET, b4, Unsafe.ARRAY_BOOLEAN_BASE_OFFSET, length, LOG2_ARRAY_BOOLEAN_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10[i10] == b4[i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(boolean[] a10, int aFromIndex, boolean[] b4, int bFromIndex, int length) {
        int i10 = 0;
        if (length > 7) {
            if (a10[aFromIndex] != b4[bFromIndex]) {
                return 0;
            }
            int aOffset = Unsafe.ARRAY_BOOLEAN_BASE_OFFSET + aFromIndex;
            int bOffset = Unsafe.ARRAY_BOOLEAN_BASE_OFFSET + bFromIndex;
            int i11 = vectorizedMismatch(a10, aOffset, b4, bOffset, length, LOG2_ARRAY_BOOLEAN_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10[aFromIndex + i10] == b4[bFromIndex + i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(byte[] a10, byte[] b4, int length) {
        int i10 = 0;
        if (length > 7) {
            if (a10[0] != b4[0]) {
                return 0;
            }
            int i11 = vectorizedMismatch(a10, Unsafe.ARRAY_BYTE_BASE_OFFSET, b4, Unsafe.ARRAY_BYTE_BASE_OFFSET, length, LOG2_ARRAY_BYTE_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10[i10] == b4[i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(byte[] a10, int aFromIndex, byte[] b4, int bFromIndex, int length) {
        int i10 = 0;
        if (length > 7) {
            if (a10[aFromIndex] != b4[bFromIndex]) {
                return 0;
            }
            int aOffset = Unsafe.ARRAY_BYTE_BASE_OFFSET + aFromIndex;
            int bOffset = Unsafe.ARRAY_BYTE_BASE_OFFSET + bFromIndex;
            int i11 = vectorizedMismatch(a10, aOffset, b4, bOffset, length, LOG2_ARRAY_BYTE_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10[aFromIndex + i10] == b4[bFromIndex + i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(char[] a10, char[] b4, int length) {
        int i10 = 0;
        if (length > 3) {
            if (a10[0] != b4[0]) {
                return 0;
            }
            int i11 = vectorizedMismatch(a10, Unsafe.ARRAY_CHAR_BASE_OFFSET, b4, Unsafe.ARRAY_CHAR_BASE_OFFSET, length, LOG2_ARRAY_CHAR_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10[i10] == b4[i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(char[] a10, int aFromIndex, char[] b4, int bFromIndex, int length) {
        int i10 = 0;
        if (length > 3) {
            if (a10[aFromIndex] != b4[bFromIndex]) {
                return 0;
            }
            int i11 = Unsafe.ARRAY_CHAR_BASE_OFFSET;
            int i12 = LOG2_ARRAY_CHAR_INDEX_SCALE;
            int aOffset = i11 + (aFromIndex << i12);
            int bOffset = Unsafe.ARRAY_CHAR_BASE_OFFSET + (bFromIndex << i12);
            int i13 = vectorizedMismatch(a10, aOffset, b4, bOffset, length, i12);
            if (i13 >= 0) {
                return i13;
            }
            i10 = length - (~i13);
        }
        while (i10 < length) {
            if (a10[aFromIndex + i10] == b4[bFromIndex + i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(short[] a10, short[] b4, int length) {
        int i10 = 0;
        if (length > 3) {
            if (a10[0] != b4[0]) {
                return 0;
            }
            int i11 = vectorizedMismatch(a10, Unsafe.ARRAY_SHORT_BASE_OFFSET, b4, Unsafe.ARRAY_SHORT_BASE_OFFSET, length, LOG2_ARRAY_SHORT_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10[i10] == b4[i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(short[] a10, int aFromIndex, short[] b4, int bFromIndex, int length) {
        int i10 = 0;
        if (length > 3) {
            if (a10[aFromIndex] != b4[bFromIndex]) {
                return 0;
            }
            int i11 = Unsafe.ARRAY_SHORT_BASE_OFFSET;
            int i12 = LOG2_ARRAY_SHORT_INDEX_SCALE;
            int aOffset = i11 + (aFromIndex << i12);
            int bOffset = Unsafe.ARRAY_SHORT_BASE_OFFSET + (bFromIndex << i12);
            int i13 = vectorizedMismatch(a10, aOffset, b4, bOffset, length, i12);
            if (i13 >= 0) {
                return i13;
            }
            i10 = length - (~i13);
        }
        while (i10 < length) {
            if (a10[aFromIndex + i10] == b4[bFromIndex + i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(int[] a10, int[] b4, int length) {
        int i10 = 0;
        if (length > 1) {
            if (a10[0] != b4[0]) {
                return 0;
            }
            int i11 = vectorizedMismatch(a10, Unsafe.ARRAY_INT_BASE_OFFSET, b4, Unsafe.ARRAY_INT_BASE_OFFSET, length, LOG2_ARRAY_INT_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10[i10] == b4[i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(int[] a10, int aFromIndex, int[] b4, int bFromIndex, int length) {
        int i10 = 0;
        if (length > 1) {
            if (a10[aFromIndex] != b4[bFromIndex]) {
                return 0;
            }
            int i11 = Unsafe.ARRAY_INT_BASE_OFFSET;
            int i12 = LOG2_ARRAY_INT_INDEX_SCALE;
            int aOffset = i11 + (aFromIndex << i12);
            int bOffset = Unsafe.ARRAY_INT_BASE_OFFSET + (bFromIndex << i12);
            int i13 = vectorizedMismatch(a10, aOffset, b4, bOffset, length, i12);
            if (i13 >= 0) {
                return i13;
            }
            i10 = length - (~i13);
        }
        while (i10 < length) {
            if (a10[aFromIndex + i10] == b4[bFromIndex + i10]) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(float[] a10, float[] b4, int length) {
        return mismatch(a10, 0, b4, 0, length);
    }

    public static int mismatch(float[] a10, int aFromIndex, float[] b4, int bFromIndex, int length) {
        int i10 = 0;
        if (length > 1) {
            if (Float.floatToRawIntBits(a10[aFromIndex]) == Float.floatToRawIntBits(b4[bFromIndex])) {
                int i11 = Unsafe.ARRAY_FLOAT_BASE_OFFSET;
                int i12 = LOG2_ARRAY_FLOAT_INDEX_SCALE;
                int aOffset = i11 + (aFromIndex << i12);
                int bOffset = Unsafe.ARRAY_FLOAT_BASE_OFFSET + (bFromIndex << i12);
                i10 = vectorizedMismatch(a10, aOffset, b4, bOffset, length, i12);
            }
            if (i10 < 0) {
                i10 = length - (~i10);
            } else {
                if (!Float.isNaN(a10[aFromIndex + i10]) || !Float.isNaN(b4[bFromIndex + i10])) {
                    return i10;
                }
                i10++;
            }
        }
        while (i10 < length) {
            if (Float.floatToIntBits(a10[aFromIndex + i10]) == Float.floatToIntBits(b4[bFromIndex + i10])) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public static int mismatch(long[] a10, long[] b4, int length) {
        if (length == 0) {
            return -1;
        }
        if (a10[0] != b4[0]) {
            return 0;
        }
        int i10 = vectorizedMismatch(a10, Unsafe.ARRAY_LONG_BASE_OFFSET, b4, Unsafe.ARRAY_LONG_BASE_OFFSET, length, LOG2_ARRAY_LONG_INDEX_SCALE);
        if (i10 >= 0) {
            return i10;
        }
        return -1;
    }

    public static int mismatch(long[] a10, int aFromIndex, long[] b4, int bFromIndex, int length) {
        if (length == 0) {
            return -1;
        }
        if (a10[aFromIndex] != b4[bFromIndex]) {
            return 0;
        }
        int i10 = Unsafe.ARRAY_LONG_BASE_OFFSET;
        int i11 = LOG2_ARRAY_LONG_INDEX_SCALE;
        int aOffset = i10 + (aFromIndex << i11);
        int bOffset = Unsafe.ARRAY_LONG_BASE_OFFSET + (bFromIndex << i11);
        int i12 = vectorizedMismatch(a10, aOffset, b4, bOffset, length, i11);
        if (i12 >= 0) {
            return i12;
        }
        return -1;
    }

    public static int mismatch(double[] a10, double[] b4, int length) {
        return mismatch(a10, 0, b4, 0, length);
    }

    public static int mismatch(double[] a10, int aFromIndex, double[] b4, int bFromIndex, int length) {
        if (length == 0) {
            return -1;
        }
        int i10 = 0;
        if (Double.doubleToRawLongBits(a10[aFromIndex]) == Double.doubleToRawLongBits(b4[bFromIndex])) {
            int i11 = Unsafe.ARRAY_DOUBLE_BASE_OFFSET;
            int i12 = LOG2_ARRAY_DOUBLE_INDEX_SCALE;
            int aOffset = i11 + (aFromIndex << i12);
            int bOffset = Unsafe.ARRAY_DOUBLE_BASE_OFFSET + (bFromIndex << i12);
            i10 = vectorizedMismatch(a10, aOffset, b4, bOffset, length, i12);
        }
        if (i10 >= 0) {
            if (!Double.isNaN(a10[aFromIndex + i10]) || !Double.isNaN(b4[bFromIndex + i10])) {
                return i10;
            }
            for (int i13 = i10 + 1; i13 < length; i13++) {
                if (Double.doubleToLongBits(a10[aFromIndex + i13]) != Double.doubleToLongBits(b4[bFromIndex + i13])) {
                    return i13;
                }
            }
        }
        return -1;
    }

    public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        int prefLength = Math.max(minGrowth, prefGrowth) + oldLength;
        if (prefLength > 0 && prefLength <= 2147483639) {
            return prefLength;
        }
        return hugeLength(oldLength, minGrowth);
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) {
            throw new OutOfMemoryError("Required array length " + oldLength + " + " + minGrowth + " is too large");
        }
        if (minLength <= 2147483639) {
            return SOFT_MAX_ARRAY_LENGTH;
        }
        return minLength;
    }
}
