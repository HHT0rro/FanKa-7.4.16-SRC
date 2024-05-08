package java.nio;

import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class BufferMismatch {
    BufferMismatch() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mismatch(ByteBuffer a10, int aOff, ByteBuffer b4, int bOff, int length) {
        int i10 = 0;
        if (length > 7) {
            if (a10.get(aOff) != b4.get(bOff)) {
                return 0;
            }
            int i11 = ArraysSupport.vectorizedMismatch(a10.base(), a10.address + aOff, b4.base(), b4.address + bOff, length, ArraysSupport.LOG2_ARRAY_BYTE_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10.get(aOff + i10) == b4.get(bOff + i10)) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mismatch(CharBuffer a10, int aOff, CharBuffer b4, int bOff, int length) {
        int i10 = 0;
        if (length > 3 && a10.charRegionOrder() == b4.charRegionOrder() && a10.charRegionOrder() != null && b4.charRegionOrder() != null) {
            if (a10.get(aOff) != b4.get(bOff)) {
                return 0;
            }
            int i11 = ArraysSupport.vectorizedMismatch(a10.base(), a10.address + (aOff << ArraysSupport.LOG2_ARRAY_CHAR_INDEX_SCALE), b4.base(), b4.address + (bOff << ArraysSupport.LOG2_ARRAY_CHAR_INDEX_SCALE), length, ArraysSupport.LOG2_ARRAY_CHAR_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10.get(aOff + i10) == b4.get(bOff + i10)) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mismatch(ShortBuffer a10, int aOff, ShortBuffer b4, int bOff, int length) {
        int i10 = 0;
        if (length > 3 && a10.order() == b4.order()) {
            if (a10.get(aOff) != b4.get(bOff)) {
                return 0;
            }
            int i11 = ArraysSupport.vectorizedMismatch(a10.base(), a10.address + (aOff << ArraysSupport.LOG2_ARRAY_SHORT_INDEX_SCALE), b4.base(), b4.address + (bOff << ArraysSupport.LOG2_ARRAY_SHORT_INDEX_SCALE), length, ArraysSupport.LOG2_ARRAY_SHORT_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10.get(aOff + i10) == b4.get(bOff + i10)) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mismatch(IntBuffer a10, int aOff, IntBuffer b4, int bOff, int length) {
        int i10 = 0;
        if (length > 1 && a10.order() == b4.order()) {
            if (a10.get(aOff) != b4.get(bOff)) {
                return 0;
            }
            int i11 = ArraysSupport.vectorizedMismatch(a10.base(), a10.address + (aOff << ArraysSupport.LOG2_ARRAY_INT_INDEX_SCALE), b4.base(), b4.address + (bOff << ArraysSupport.LOG2_ARRAY_INT_INDEX_SCALE), length, ArraysSupport.LOG2_ARRAY_INT_INDEX_SCALE);
            if (i11 >= 0) {
                return i11;
            }
            i10 = length - (~i11);
        }
        while (i10 < length) {
            if (a10.get(aOff + i10) == b4.get(bOff + i10)) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mismatch(FloatBuffer a10, int aOff, FloatBuffer b4, int bOff, int length) {
        if (length > 1 && a10.order() == b4.order()) {
            i = Float.floatToRawIntBits(a10.get(aOff)) == Float.floatToRawIntBits(b4.get(bOff)) ? ArraysSupport.vectorizedMismatch(a10.base(), a10.address + (aOff << ArraysSupport.LOG2_ARRAY_FLOAT_INDEX_SCALE), b4.base(), b4.address + (bOff << ArraysSupport.LOG2_ARRAY_FLOAT_INDEX_SCALE), length, ArraysSupport.LOG2_ARRAY_FLOAT_INDEX_SCALE) : 0;
            if (i >= 0) {
                float av = a10.get(aOff + i);
                float bv = b4.get(bOff + i);
                if (av == bv || (Float.isNaN(av) && Float.isNaN(bv))) {
                    i++;
                } else {
                    return i;
                }
            } else {
                i = length - (~i);
            }
        }
        while (i < length) {
            float av2 = a10.get(aOff + i);
            float bv2 = b4.get(bOff + i);
            if (av2 == bv2 || (Float.isNaN(av2) && Float.isNaN(bv2))) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mismatch(LongBuffer a10, int aOff, LongBuffer b4, int bOff, int length) {
        if (length <= 0 || a10.order() != b4.order()) {
            for (int i10 = 0; i10 < length; i10++) {
                if (a10.get(aOff + i10) != b4.get(bOff + i10)) {
                    return i10;
                }
            }
            return -1;
        }
        if (a10.get(aOff) != b4.get(bOff)) {
            return 0;
        }
        int i11 = ArraysSupport.vectorizedMismatch(a10.base(), a10.address + (aOff << ArraysSupport.LOG2_ARRAY_LONG_INDEX_SCALE), b4.base(), b4.address + (bOff << ArraysSupport.LOG2_ARRAY_LONG_INDEX_SCALE), length, ArraysSupport.LOG2_ARRAY_LONG_INDEX_SCALE);
        if (i11 >= 0) {
            return i11;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mismatch(DoubleBuffer a10, int aOff, DoubleBuffer b4, int bOff, int length) {
        int i10 = 0;
        if (length > 0 && a10.order() == b4.order()) {
            if (Double.doubleToRawLongBits(a10.get(aOff)) == Double.doubleToRawLongBits(b4.get(bOff))) {
                i10 = ArraysSupport.vectorizedMismatch(a10.base(), a10.address + (aOff << ArraysSupport.LOG2_ARRAY_DOUBLE_INDEX_SCALE), b4.base(), b4.address + (bOff << ArraysSupport.LOG2_ARRAY_DOUBLE_INDEX_SCALE), length, ArraysSupport.LOG2_ARRAY_DOUBLE_INDEX_SCALE);
            }
            if (i10 < 0) {
                return -1;
            }
            double av = a10.get(aOff + i10);
            double bv = b4.get(bOff + i10);
            if (av != bv && (!Double.isNaN(av) || !Double.isNaN(bv))) {
                return i10;
            }
            i10++;
        }
        while (i10 < length) {
            double av2 = a10.get(aOff + i10);
            double bv2 = b4.get(bOff + i10);
            if (av2 == bv2 || (Double.isNaN(av2) && Double.isNaN(bv2))) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }
}
