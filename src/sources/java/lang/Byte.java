package java.lang;

import libcore.util.HexEncoding;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Byte extends Number implements Comparable<Byte> {
    public static final int BYTES = 1;
    public static final byte MAX_VALUE = Byte.MAX_VALUE;
    public static final byte MIN_VALUE = Byte.MIN_VALUE;
    public static final int SIZE = 8;
    public static final Class<Byte> TYPE = Class.getPrimitiveClass("byte");
    private static final long serialVersionUID = -7183698231559129828L;
    private final byte value;

    public static String toString(byte b4) {
        return Integer.toString(b4, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ByteCache {
        static Byte[] archivedCache;
        static final Byte[] cache;

        private ByteCache() {
        }

        static {
            Byte[] bArr = archivedCache;
            if (bArr == null || bArr.length != 256) {
                Byte[] c4 = new Byte[256];
                byte value = Byte.MIN_VALUE;
                int i10 = 0;
                while (i10 < 256) {
                    c4[i10] = new Byte(value);
                    i10++;
                    value = (byte) (value + 1);
                }
                archivedCache = c4;
            }
            cache = archivedCache;
        }
    }

    public static Byte valueOf(byte b4) {
        return ByteCache.cache[b4 + 128];
    }

    public static byte parseByte(String s2, int radix) throws NumberFormatException {
        int i10 = Integer.parseInt(s2, radix);
        if (i10 < -128 || i10 > 127) {
            throw new NumberFormatException("Value out of range. Value:\"" + s2 + "\" Radix:" + radix);
        }
        return (byte) i10;
    }

    public static byte parseByte(String s2) throws NumberFormatException {
        return parseByte(s2, 10);
    }

    public static Byte valueOf(String s2, int radix) throws NumberFormatException {
        return valueOf(parseByte(s2, radix));
    }

    public static Byte valueOf(String s2) throws NumberFormatException {
        return valueOf(s2, 10);
    }

    public static Byte decode(String nm) throws NumberFormatException {
        int i10 = Integer.decode(nm).intValue();
        if (i10 < -128 || i10 > 127) {
            throw new NumberFormatException("Value " + i10 + " out of range from input " + nm);
        }
        return valueOf((byte) i10);
    }

    @Deprecated(since = "9")
    public Byte(byte value) {
        this.value = value;
    }

    @Deprecated(since = "9")
    public Byte(String s2) throws NumberFormatException {
        this.value = parseByte(s2, 10);
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
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

    public String toString() {
        return Integer.toString(this.value);
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(byte value) {
        return value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Byte) && this.value == ((Byte) obj).byteValue();
    }

    @Override // java.lang.Comparable
    public int compareTo(Byte anotherByte) {
        return compare(this.value, anotherByte.value);
    }

    public static int compare(byte x10, byte y10) {
        return x10 - y10;
    }

    public static int compareUnsigned(byte x10, byte y10) {
        return toUnsignedInt(x10) - toUnsignedInt(y10);
    }

    public static int toUnsignedInt(byte x10) {
        return x10 & 255;
    }

    public static long toUnsignedLong(byte x10) {
        return x10 & 255;
    }

    public static String toHexString(byte b4, boolean upperCase) {
        return HexEncoding.encodeToString(b4, upperCase);
    }
}
