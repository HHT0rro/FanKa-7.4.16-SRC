package java.lang;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Short extends Number implements Comparable<Short> {
    public static final int BYTES = 2;
    public static final short MAX_VALUE = Short.MAX_VALUE;
    public static final short MIN_VALUE = Short.MIN_VALUE;
    public static final int SIZE = 16;
    public static final Class<Short> TYPE = Class.getPrimitiveClass("short");
    private static final long serialVersionUID = 7515723908773894738L;
    private final short value;

    public static String toString(short s2) {
        return Integer.toString(s2, 10);
    }

    public static short parseShort(String s2, int radix) throws NumberFormatException {
        int i10 = Integer.parseInt(s2, radix);
        if (i10 < -32768 || i10 > 32767) {
            throw new NumberFormatException("Value out of range. Value:\"" + s2 + "\" Radix:" + radix);
        }
        return (short) i10;
    }

    public static short parseShort(String s2) throws NumberFormatException {
        return parseShort(s2, 10);
    }

    public static Short valueOf(String s2, int radix) throws NumberFormatException {
        return valueOf(parseShort(s2, radix));
    }

    public static Short valueOf(String s2) throws NumberFormatException {
        return valueOf(s2, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ShortCache {
        static Short[] archivedCache;
        static final Short[] cache;

        private ShortCache() {
        }

        static {
            Short[] shArr = archivedCache;
            if (shArr == null || shArr.length != 256) {
                Short[] c4 = new Short[256];
                short value = -128;
                int i10 = 0;
                while (i10 < 256) {
                    c4[i10] = new Short(value);
                    i10++;
                    value = (short) (value + 1);
                }
                archivedCache = c4;
            }
            cache = archivedCache;
        }
    }

    public static Short valueOf(short s2) {
        if (s2 >= -128 && s2 <= 127) {
            return ShortCache.cache[s2 + 128];
        }
        return new Short(s2);
    }

    public static Short decode(String nm) throws NumberFormatException {
        int i10 = Integer.decode(nm).intValue();
        if (i10 < -32768 || i10 > 32767) {
            throw new NumberFormatException("Value " + i10 + " out of range from input " + nm);
        }
        return valueOf((short) i10);
    }

    @Deprecated(since = "9")
    public Short(short value) {
        this.value = value;
    }

    @Deprecated(since = "9")
    public Short(String s2) throws NumberFormatException {
        this.value = parseShort(s2, 10);
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
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

    public static int hashCode(short value) {
        return value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Short) && this.value == ((Short) obj).shortValue();
    }

    @Override // java.lang.Comparable
    public int compareTo(Short anotherShort) {
        return compare(this.value, anotherShort.value);
    }

    public static int compare(short x10, short y10) {
        return x10 - y10;
    }

    public static int compareUnsigned(short x10, short y10) {
        return toUnsignedInt(x10) - toUnsignedInt(y10);
    }

    public static short reverseBytes(short i10) {
        return (short) (((65280 & i10) >> 8) | (i10 << 8));
    }

    public static int toUnsignedInt(short x10) {
        return 65535 & x10;
    }

    public static long toUnsignedLong(short x10) {
        return x10 & 65535;
    }
}
