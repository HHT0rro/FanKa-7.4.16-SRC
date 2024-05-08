package java.io;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Bits {
    Bits() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getBoolean(byte[] b4, int off) {
        return b4[off] != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char getChar(byte[] b4, int off) {
        return (char) ((b4[off + 1] & 255) + (b4[off] << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] b4, int off) {
        return (short) ((b4[off + 1] & 255) + (b4[off] << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] b4, int off) {
        return (b4[off + 3] & 255) + ((b4[off + 2] & 255) << 8) + ((b4[off + 1] & 255) << 16) + (b4[off] << 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getFloat(byte[] b4, int off) {
        return Float.intBitsToFloat(getInt(b4, off));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] b4, int off) {
        return (b4[off + 7] & 255) + ((b4[off + 6] & 255) << 8) + ((b4[off + 5] & 255) << 16) + ((b4[off + 4] & 255) << 24) + ((b4[off + 3] & 255) << 32) + ((b4[off + 2] & 255) << 40) + ((255 & b4[off + 1]) << 48) + (b4[off] << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double getDouble(byte[] b4, int off) {
        return Double.longBitsToDouble(getLong(b4, off));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putBoolean(byte[] bArr, int i10, boolean z10) {
        bArr[i10] = z10 ? (byte) 1 : (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putChar(byte[] b4, int off, char val) {
        b4[off + 1] = (byte) val;
        b4[off] = (byte) (val >>> '\b');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putShort(byte[] b4, int off, short val) {
        b4[off + 1] = (byte) val;
        b4[off] = (byte) (val >>> 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(byte[] b4, int off, int val) {
        b4[off + 3] = (byte) val;
        b4[off + 2] = (byte) (val >>> 8);
        b4[off + 1] = (byte) (val >>> 16);
        b4[off] = (byte) (val >>> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putFloat(byte[] b4, int off, float val) {
        putInt(b4, off, Float.floatToIntBits(val));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(byte[] b4, int off, long val) {
        b4[off + 7] = (byte) val;
        b4[off + 6] = (byte) (val >>> 8);
        b4[off + 5] = (byte) (val >>> 16);
        b4[off + 4] = (byte) (val >>> 24);
        b4[off + 3] = (byte) (val >>> 32);
        b4[off + 2] = (byte) (val >>> 40);
        b4[off + 1] = (byte) (val >>> 48);
        b4[off] = (byte) (val >>> 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putDouble(byte[] b4, int off, double val) {
        putLong(b4, off, Double.doubleToLongBits(val));
    }
}
