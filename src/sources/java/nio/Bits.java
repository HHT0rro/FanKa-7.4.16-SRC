package java.nio;

import java.security.AccessController;
import sun.misc.Unsafe;
import sun.security.action.GetPropertyAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Bits {
    private static boolean unaligned;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
    private static int pageSize = -1;
    private static boolean unalignedKnown = false;

    private Bits() {
    }

    static short swap(short x10) {
        return Short.reverseBytes(x10);
    }

    static char swap(char x10) {
        return Character.reverseBytes(x10);
    }

    static int swap(int x10) {
        return Integer.reverseBytes(x10);
    }

    static long swap(long x10) {
        return Long.reverseBytes(x10);
    }

    private static char makeChar(byte b12, byte b02) {
        return (char) ((b12 << 8) | (b02 & 255));
    }

    static char getCharL(ByteBuffer bb2, int bi) {
        return makeChar(bb2._get(bi + 1), bb2._get(bi));
    }

    static char getCharL(long a10) {
        return makeChar(_get(1 + a10), _get(a10));
    }

    static char getCharB(ByteBuffer bb2, int bi) {
        return makeChar(bb2._get(bi), bb2._get(bi + 1));
    }

    static char getCharB(long a10) {
        return makeChar(_get(a10), _get(1 + a10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char getChar(ByteBuffer bb2, int bi, boolean bigEndian) {
        return bigEndian ? getCharB(bb2, bi) : getCharL(bb2, bi);
    }

    static char getChar(long a10, boolean bigEndian) {
        return bigEndian ? getCharB(a10) : getCharL(a10);
    }

    private static byte char1(char x10) {
        return (byte) (x10 >> '\b');
    }

    private static byte char0(char x10) {
        return (byte) x10;
    }

    static void putCharL(ByteBuffer bb2, int bi, char x10) {
        bb2._put(bi, char0(x10));
        bb2._put(bi + 1, char1(x10));
    }

    static void putCharL(long a10, char x10) {
        _put(a10, char0(x10));
        _put(1 + a10, char1(x10));
    }

    static void putCharB(ByteBuffer bb2, int bi, char x10) {
        bb2._put(bi, char1(x10));
        bb2._put(bi + 1, char0(x10));
    }

    static void putCharB(long a10, char x10) {
        _put(a10, char1(x10));
        _put(1 + a10, char0(x10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putChar(ByteBuffer bb2, int bi, char x10, boolean bigEndian) {
        if (bigEndian) {
            putCharB(bb2, bi, x10);
        } else {
            putCharL(bb2, bi, x10);
        }
    }

    static void putChar(long a10, char x10, boolean bigEndian) {
        if (bigEndian) {
            putCharB(a10, x10);
        } else {
            putCharL(a10, x10);
        }
    }

    private static short makeShort(byte b12, byte b02) {
        return (short) ((b12 << 8) | (b02 & 255));
    }

    static short getShortL(ByteBuffer bb2, int bi) {
        return makeShort(bb2._get(bi + 1), bb2._get(bi));
    }

    static short getShortL(long a10) {
        return makeShort(_get(1 + a10), _get(a10));
    }

    static short getShortB(ByteBuffer bb2, int bi) {
        return makeShort(bb2._get(bi), bb2._get(bi + 1));
    }

    static short getShortB(long a10) {
        return makeShort(_get(a10), _get(1 + a10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(ByteBuffer bb2, int bi, boolean bigEndian) {
        return bigEndian ? getShortB(bb2, bi) : getShortL(bb2, bi);
    }

    static short getShort(long a10, boolean bigEndian) {
        return bigEndian ? getShortB(a10) : getShortL(a10);
    }

    private static byte short1(short x10) {
        return (byte) (x10 >> 8);
    }

    private static byte short0(short x10) {
        return (byte) x10;
    }

    static void putShortL(ByteBuffer bb2, int bi, short x10) {
        bb2._put(bi, short0(x10));
        bb2._put(bi + 1, short1(x10));
    }

    static void putShortL(long a10, short x10) {
        _put(a10, short0(x10));
        _put(1 + a10, short1(x10));
    }

    static void putShortB(ByteBuffer bb2, int bi, short x10) {
        bb2._put(bi, short1(x10));
        bb2._put(bi + 1, short0(x10));
    }

    static void putShortB(long a10, short x10) {
        _put(a10, short1(x10));
        _put(1 + a10, short0(x10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putShort(ByteBuffer bb2, int bi, short x10, boolean bigEndian) {
        if (bigEndian) {
            putShortB(bb2, bi, x10);
        } else {
            putShortL(bb2, bi, x10);
        }
    }

    static void putShort(long a10, short x10, boolean bigEndian) {
        if (bigEndian) {
            putShortB(a10, x10);
        } else {
            putShortL(a10, x10);
        }
    }

    private static int makeInt(byte b32, byte b22, byte b12, byte b02) {
        return (b32 << 24) | ((b22 & 255) << 16) | ((b12 & 255) << 8) | (b02 & 255);
    }

    static int getIntL(ByteBuffer bb2, int bi) {
        return makeInt(bb2._get(bi + 3), bb2._get(bi + 2), bb2._get(bi + 1), bb2._get(bi));
    }

    static int getIntL(long a10) {
        return makeInt(_get(3 + a10), _get(2 + a10), _get(1 + a10), _get(a10));
    }

    static int getIntB(ByteBuffer bb2, int bi) {
        return makeInt(bb2._get(bi), bb2._get(bi + 1), bb2._get(bi + 2), bb2._get(bi + 3));
    }

    static int getIntB(long a10) {
        return makeInt(_get(a10), _get(1 + a10), _get(2 + a10), _get(3 + a10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(ByteBuffer bb2, int bi, boolean bigEndian) {
        return bigEndian ? getIntB(bb2, bi) : getIntL(bb2, bi);
    }

    static int getInt(long a10, boolean bigEndian) {
        return bigEndian ? getIntB(a10) : getIntL(a10);
    }

    private static byte int3(int x10) {
        return (byte) (x10 >> 24);
    }

    private static byte int2(int x10) {
        return (byte) (x10 >> 16);
    }

    private static byte int1(int x10) {
        return (byte) (x10 >> 8);
    }

    private static byte int0(int x10) {
        return (byte) x10;
    }

    static void putIntL(ByteBuffer bb2, int bi, int x10) {
        bb2._put(bi + 3, int3(x10));
        bb2._put(bi + 2, int2(x10));
        bb2._put(bi + 1, int1(x10));
        bb2._put(bi, int0(x10));
    }

    static void putIntL(long a10, int x10) {
        _put(3 + a10, int3(x10));
        _put(2 + a10, int2(x10));
        _put(1 + a10, int1(x10));
        _put(a10, int0(x10));
    }

    static void putIntB(ByteBuffer bb2, int bi, int x10) {
        bb2._put(bi, int3(x10));
        bb2._put(bi + 1, int2(x10));
        bb2._put(bi + 2, int1(x10));
        bb2._put(bi + 3, int0(x10));
    }

    static void putIntB(long a10, int x10) {
        _put(a10, int3(x10));
        _put(1 + a10, int2(x10));
        _put(2 + a10, int1(x10));
        _put(3 + a10, int0(x10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(ByteBuffer bb2, int bi, int x10, boolean bigEndian) {
        if (bigEndian) {
            putIntB(bb2, bi, x10);
        } else {
            putIntL(bb2, bi, x10);
        }
    }

    static void putInt(long a10, int x10, boolean bigEndian) {
        if (bigEndian) {
            putIntB(a10, x10);
        } else {
            putIntL(a10, x10);
        }
    }

    private static long makeLong(byte b72, byte b62, byte b52, byte b4, byte b32, byte b22, byte b12, byte b02) {
        return (b72 << 56) | ((b62 & 255) << 48) | ((b52 & 255) << 40) | ((b4 & 255) << 32) | ((b32 & 255) << 24) | ((b22 & 255) << 16) | ((b12 & 255) << 8) | (b02 & 255);
    }

    static long getLongL(ByteBuffer bb2, int bi) {
        return makeLong(bb2._get(bi + 7), bb2._get(bi + 6), bb2._get(bi + 5), bb2._get(bi + 4), bb2._get(bi + 3), bb2._get(bi + 2), bb2._get(bi + 1), bb2._get(bi));
    }

    static long getLongL(long a10) {
        return makeLong(_get(7 + a10), _get(6 + a10), _get(5 + a10), _get(4 + a10), _get(3 + a10), _get(2 + a10), _get(1 + a10), _get(a10));
    }

    static long getLongB(ByteBuffer bb2, int bi) {
        return makeLong(bb2._get(bi), bb2._get(bi + 1), bb2._get(bi + 2), bb2._get(bi + 3), bb2._get(bi + 4), bb2._get(bi + 5), bb2._get(bi + 6), bb2._get(bi + 7));
    }

    static long getLongB(long a10) {
        return makeLong(_get(a10), _get(1 + a10), _get(2 + a10), _get(3 + a10), _get(4 + a10), _get(5 + a10), _get(6 + a10), _get(7 + a10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(ByteBuffer bb2, int bi, boolean bigEndian) {
        return bigEndian ? getLongB(bb2, bi) : getLongL(bb2, bi);
    }

    static long getLong(long a10, boolean bigEndian) {
        return bigEndian ? getLongB(a10) : getLongL(a10);
    }

    private static byte long7(long x10) {
        return (byte) (x10 >> 56);
    }

    private static byte long6(long x10) {
        return (byte) (x10 >> 48);
    }

    private static byte long5(long x10) {
        return (byte) (x10 >> 40);
    }

    private static byte long4(long x10) {
        return (byte) (x10 >> 32);
    }

    private static byte long3(long x10) {
        return (byte) (x10 >> 24);
    }

    private static byte long2(long x10) {
        return (byte) (x10 >> 16);
    }

    private static byte long1(long x10) {
        return (byte) (x10 >> 8);
    }

    private static byte long0(long x10) {
        return (byte) x10;
    }

    static void putLongL(ByteBuffer bb2, int bi, long x10) {
        bb2._put(bi + 7, long7(x10));
        bb2._put(bi + 6, long6(x10));
        bb2._put(bi + 5, long5(x10));
        bb2._put(bi + 4, long4(x10));
        bb2._put(bi + 3, long3(x10));
        bb2._put(bi + 2, long2(x10));
        bb2._put(bi + 1, long1(x10));
        bb2._put(bi, long0(x10));
    }

    static void putLongL(long a10, long x10) {
        _put(7 + a10, long7(x10));
        _put(6 + a10, long6(x10));
        _put(5 + a10, long5(x10));
        _put(4 + a10, long4(x10));
        _put(3 + a10, long3(x10));
        _put(2 + a10, long2(x10));
        _put(1 + a10, long1(x10));
        _put(a10, long0(x10));
    }

    static void putLongB(ByteBuffer bb2, int bi, long x10) {
        bb2._put(bi, long7(x10));
        bb2._put(bi + 1, long6(x10));
        bb2._put(bi + 2, long5(x10));
        bb2._put(bi + 3, long4(x10));
        bb2._put(bi + 4, long3(x10));
        bb2._put(bi + 5, long2(x10));
        bb2._put(bi + 6, long1(x10));
        bb2._put(bi + 7, long0(x10));
    }

    static void putLongB(long a10, long x10) {
        _put(a10, long7(x10));
        _put(1 + a10, long6(x10));
        _put(2 + a10, long5(x10));
        _put(3 + a10, long4(x10));
        _put(4 + a10, long3(x10));
        _put(5 + a10, long2(x10));
        _put(6 + a10, long1(x10));
        _put(7 + a10, long0(x10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(ByteBuffer bb2, int bi, long x10, boolean bigEndian) {
        if (bigEndian) {
            putLongB(bb2, bi, x10);
        } else {
            putLongL(bb2, bi, x10);
        }
    }

    static void putLong(long a10, long x10, boolean bigEndian) {
        if (bigEndian) {
            putLongB(a10, x10);
        } else {
            putLongL(a10, x10);
        }
    }

    static float getFloatL(ByteBuffer bb2, int bi) {
        return Float.intBitsToFloat(getIntL(bb2, bi));
    }

    static float getFloatL(long a10) {
        return Float.intBitsToFloat(getIntL(a10));
    }

    static float getFloatB(ByteBuffer bb2, int bi) {
        return Float.intBitsToFloat(getIntB(bb2, bi));
    }

    static float getFloatB(long a10) {
        return Float.intBitsToFloat(getIntB(a10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getFloat(ByteBuffer bb2, int bi, boolean bigEndian) {
        return bigEndian ? getFloatB(bb2, bi) : getFloatL(bb2, bi);
    }

    static float getFloat(long a10, boolean bigEndian) {
        return bigEndian ? getFloatB(a10) : getFloatL(a10);
    }

    static void putFloatL(ByteBuffer bb2, int bi, float x10) {
        putIntL(bb2, bi, Float.floatToRawIntBits(x10));
    }

    static void putFloatL(long a10, float x10) {
        putIntL(a10, Float.floatToRawIntBits(x10));
    }

    static void putFloatB(ByteBuffer bb2, int bi, float x10) {
        putIntB(bb2, bi, Float.floatToRawIntBits(x10));
    }

    static void putFloatB(long a10, float x10) {
        putIntB(a10, Float.floatToRawIntBits(x10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putFloat(ByteBuffer bb2, int bi, float x10, boolean bigEndian) {
        if (bigEndian) {
            putFloatB(bb2, bi, x10);
        } else {
            putFloatL(bb2, bi, x10);
        }
    }

    static void putFloat(long a10, float x10, boolean bigEndian) {
        if (bigEndian) {
            putFloatB(a10, x10);
        } else {
            putFloatL(a10, x10);
        }
    }

    static double getDoubleL(ByteBuffer bb2, int bi) {
        return Double.longBitsToDouble(getLongL(bb2, bi));
    }

    static double getDoubleL(long a10) {
        return Double.longBitsToDouble(getLongL(a10));
    }

    static double getDoubleB(ByteBuffer bb2, int bi) {
        return Double.longBitsToDouble(getLongB(bb2, bi));
    }

    static double getDoubleB(long a10) {
        return Double.longBitsToDouble(getLongB(a10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double getDouble(ByteBuffer bb2, int bi, boolean bigEndian) {
        return bigEndian ? getDoubleB(bb2, bi) : getDoubleL(bb2, bi);
    }

    static double getDouble(long a10, boolean bigEndian) {
        return bigEndian ? getDoubleB(a10) : getDoubleL(a10);
    }

    static void putDoubleL(ByteBuffer bb2, int bi, double x10) {
        putLongL(bb2, bi, Double.doubleToRawLongBits(x10));
    }

    static void putDoubleL(long a10, double x10) {
        putLongL(a10, Double.doubleToRawLongBits(x10));
    }

    static void putDoubleB(ByteBuffer bb2, int bi, double x10) {
        putLongB(bb2, bi, Double.doubleToRawLongBits(x10));
    }

    static void putDoubleB(long a10, double x10) {
        putLongB(a10, Double.doubleToRawLongBits(x10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putDouble(ByteBuffer bb2, int bi, double x10, boolean bigEndian) {
        if (bigEndian) {
            putDoubleB(bb2, bi, x10);
        } else {
            putDoubleL(bb2, bi, x10);
        }
    }

    static void putDouble(long a10, double x10, boolean bigEndian) {
        if (bigEndian) {
            putDoubleB(a10, x10);
        } else {
            putDoubleL(a10, x10);
        }
    }

    private static byte _get(long a10) {
        return unsafe.getByte(a10);
    }

    private static void _put(long a10, byte b4) {
        unsafe.putByte(a10, b4);
    }

    static Unsafe unsafe() {
        return unsafe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteOrder byteOrder() {
        return byteOrder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int pageSize() {
        if (pageSize == -1) {
            pageSize = unsafe().pageSize();
        }
        return pageSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int pageCount(long size) {
        return ((int) ((pageSize() + size) - 1)) / pageSize();
    }

    static boolean unaligned() {
        if (unalignedKnown) {
            return unaligned;
        }
        String arch = (String) AccessController.doPrivileged(new GetPropertyAction("os.arch"));
        boolean z10 = arch.equals("i386") || arch.equals("x86") || arch.equals("amd64") || arch.equals("x86_64");
        unaligned = z10;
        unalignedKnown = true;
        return z10;
    }
}
