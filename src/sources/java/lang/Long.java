package java.lang;

import com.google.android.material.badge.BadgeDrawable;
import java.math.BigInteger;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Long extends Number implements Comparable<Long> {
    public static final int BYTES = 8;
    public static final long MAX_VALUE = Long.MAX_VALUE;
    public static final long MIN_VALUE = Long.MIN_VALUE;
    public static final int SIZE = 64;
    public static final Class<Long> TYPE = Class.getPrimitiveClass("long");
    private static final long serialVersionUID = 4290774380558885855L;
    private final long value;

    public static String toString(long i10, int radix) {
        if (radix < 2 || radix > 36) {
            radix = 10;
        }
        if (radix == 10) {
            return toString(i10);
        }
        byte[] buf = new byte[65];
        int charPos = 64;
        boolean negative = i10 < 0;
        if (!negative) {
            i10 = -i10;
        }
        while (i10 <= (-radix)) {
            buf[charPos] = (byte) Integer.digits[(int) (-(i10 % radix))];
            i10 /= radix;
            charPos--;
        }
        buf[charPos] = (byte) Integer.digits[(int) (-i10)];
        if (negative) {
            charPos--;
            buf[charPos] = 45;
        }
        return new String(buf, charPos, 65 - charPos);
    }

    public static String toUnsignedString(long i10, int radix) {
        if (i10 >= 0) {
            return toString(i10, radix);
        }
        switch (radix) {
            case 2:
                return toBinaryString(i10);
            case 4:
                return toUnsignedString0(i10, 2);
            case 8:
                return toOctalString(i10);
            case 10:
                long quot = (i10 >>> 1) / 5;
                long rem = i10 - (10 * quot);
                return toString(quot) + rem;
            case 16:
                return toHexString(i10);
            case 32:
                return toUnsignedString0(i10, 5);
            default:
                return toUnsignedBigInteger(i10).toString(radix);
        }
    }

    private static BigInteger toUnsignedBigInteger(long i10) {
        if (i10 >= 0) {
            return BigInteger.valueOf(i10);
        }
        int upper = (int) (i10 >>> 32);
        int lower = (int) i10;
        return BigInteger.valueOf(Integer.toUnsignedLong(upper)).shiftLeft(32).add(BigInteger.valueOf(Integer.toUnsignedLong(lower)));
    }

    public static String toHexString(long i10) {
        return toUnsignedString0(i10, 4);
    }

    public static String toOctalString(long i10) {
        return toUnsignedString0(i10, 3);
    }

    public static String toBinaryString(long i10) {
        return toUnsignedString0(i10, 1);
    }

    static String toUnsignedString0(long val, int shift) {
        int mag = 64 - numberOfLeadingZeros(val);
        int chars = Math.max(((shift - 1) + mag) / shift, 1);
        byte[] buf = new byte[chars];
        formatUnsignedLong0(val, shift, buf, 0, chars);
        return new String(buf);
    }

    static void formatUnsignedLong0(long val, int shift, byte[] buf, int offset, int len) {
        int charPos = offset + len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            charPos--;
            buf[charPos] = (byte) Integer.digits[((int) val) & mask];
            val >>>= shift;
        } while (charPos > offset);
    }

    public static String toString(long i10) {
        int size = stringSize(i10);
        byte[] buf = new byte[size];
        getChars(i10, size, buf);
        return new String(buf);
    }

    public static String toUnsignedString(long i10) {
        return toUnsignedString(i10, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getChars(long i10, int index, byte[] buf) {
        int charPos = index;
        boolean negative = i10 < 0;
        if (!negative) {
            i10 = -i10;
        }
        while (i10 <= -2147483648L) {
            long q10 = i10 / 100;
            int r10 = (int) ((100 * q10) - i10);
            i10 = q10;
            int charPos2 = charPos - 1;
            buf[charPos2] = Integer.DigitOnes[r10];
            charPos = charPos2 - 1;
            buf[charPos] = Integer.DigitTens[r10];
        }
        int i22 = (int) i10;
        while (i22 <= -100) {
            int q22 = i22 / 100;
            int r11 = (q22 * 100) - i22;
            i22 = q22;
            int charPos3 = charPos - 1;
            buf[charPos3] = Integer.DigitOnes[r11];
            charPos = charPos3 - 1;
            buf[charPos] = Integer.DigitTens[r11];
        }
        int q23 = i22 / 10;
        int charPos4 = charPos - 1;
        buf[charPos4] = (byte) (((q23 * 10) - i22) + 48);
        if (q23 < 0) {
            charPos4--;
            buf[charPos4] = (byte) (48 - q23);
        }
        if (negative) {
            int charPos5 = charPos4 - 1;
            buf[charPos5] = 45;
            return charPos5;
        }
        return charPos4;
    }

    static int getChars(long i10, int index, char[] buf) {
        int charPos = index;
        boolean negative = i10 < 0;
        if (!negative) {
            i10 = -i10;
        }
        while (i10 <= -2147483648L) {
            long q10 = i10 / 100;
            int r10 = (int) ((100 * q10) - i10);
            i10 = q10;
            int charPos2 = charPos - 1;
            buf[charPos2] = (char) Integer.DigitOnes[r10];
            charPos = charPos2 - 1;
            buf[charPos] = (char) Integer.DigitTens[r10];
        }
        int i22 = (int) i10;
        while (i22 <= -100) {
            int q22 = i22 / 100;
            int r11 = (q22 * 100) - i22;
            i22 = q22;
            int charPos3 = charPos - 1;
            buf[charPos3] = (char) Integer.DigitOnes[r11];
            charPos = charPos3 - 1;
            buf[charPos] = (char) Integer.DigitTens[r11];
        }
        int q23 = i22 / 10;
        int charPos4 = charPos - 1;
        buf[charPos4] = (char) (((q23 * 10) - i22) + 48);
        if (q23 < 0) {
            charPos4--;
            buf[charPos4] = (char) (48 - q23);
        }
        if (negative) {
            int charPos5 = charPos4 - 1;
            buf[charPos5] = '-';
            return charPos5;
        }
        return charPos4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int stringSize(long x10) {
        int d10 = 1;
        if (x10 >= 0) {
            d10 = 0;
            x10 = -x10;
        }
        long p10 = -10;
        for (int i10 = 1; i10 < 19; i10++) {
            if (x10 > p10) {
                return i10 + d10;
            }
            p10 *= 10;
        }
        int i11 = d10 + 19;
        return i11;
    }

    public static long parseLong(String s2, int radix) throws NumberFormatException {
        if (s2 == null) {
            throw new NumberFormatException("Cannot parse null string");
        }
        if (radix < 2) {
            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        }
        if (radix > 36) {
            throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
        }
        boolean negative = false;
        int i10 = 0;
        int len = s2.length();
        long limit = -9223372036854775807L;
        if (len > 0) {
            char firstChar = s2.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Long.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw NumberFormatException.forInputString(s2, radix);
                }
                if (len == 1) {
                    throw NumberFormatException.forInputString(s2, radix);
                }
                i10 = 0 + 1;
            }
            long multmin = limit / radix;
            long result = 0;
            while (i10 < len) {
                int i11 = i10 + 1;
                int digit = Character.digit(s2.charAt(i10), radix);
                if (digit < 0 || result < multmin) {
                    throw NumberFormatException.forInputString(s2, radix);
                }
                long result2 = result * radix;
                if (result2 < digit + limit) {
                    throw NumberFormatException.forInputString(s2, radix);
                }
                result = result2 - digit;
                i10 = i11;
            }
            return negative ? result : -result;
        }
        throw NumberFormatException.forInputString(s2, radix);
    }

    public static long parseLong(CharSequence s2, int beginIndex, int endIndex, int radix) throws NumberFormatException {
        Objects.requireNonNull(s2);
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > s2.length()) {
            throw new IndexOutOfBoundsException();
        }
        if (radix < 2) {
            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        }
        if (radix > 36) {
            throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
        }
        boolean negative = false;
        int i10 = beginIndex;
        long limit = -9223372036854775807L;
        if (i10 < endIndex) {
            char firstChar = s2.charAt(i10);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Long.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw NumberFormatException.forCharSequence(s2, beginIndex, endIndex, i10);
                }
                i10++;
            }
            if (i10 >= endIndex) {
                throw NumberFormatException.forCharSequence(s2, beginIndex, endIndex, i10);
            }
            long multmin = limit / radix;
            long result = 0;
            while (i10 < endIndex) {
                int digit = Character.digit(s2.charAt(i10), radix);
                if (digit < 0 || result < multmin) {
                    throw NumberFormatException.forCharSequence(s2, beginIndex, endIndex, i10);
                }
                long result2 = result * radix;
                if (result2 < digit + limit) {
                    throw NumberFormatException.forCharSequence(s2, beginIndex, endIndex, i10);
                }
                i10++;
                result = result2 - digit;
            }
            return negative ? result : -result;
        }
        throw new NumberFormatException("");
    }

    public static long parseLong(String s2) throws NumberFormatException {
        return parseLong(s2, 10);
    }

    public static long parseUnsignedLong(String s2, int radix) throws NumberFormatException {
        if (s2 == null) {
            throw new NumberFormatException("Cannot parse null string");
        }
        int len = s2.length();
        if (len > 0) {
            char firstChar = s2.charAt(0);
            if (firstChar == '-') {
                throw new NumberFormatException(String.format("Illegal leading minus sign on unsigned string %s.", s2));
            }
            if (len > 12 && (radix != 10 || len > 18)) {
                long first = parseLong(s2, 0, len - 1, radix);
                int second = Character.digit(s2.charAt(len - 1), radix);
                if (second < 0) {
                    throw new NumberFormatException("Bad digit at end of " + s2);
                }
                long result = (radix * first) + second;
                int guard = ((int) (first >>> 57)) * radix;
                if (guard >= 128 || (result >= 0 && guard >= 92)) {
                    throw new NumberFormatException(String.format("String value %s exceeds range of unsigned long.", s2));
                }
                return result;
            }
            return parseLong(s2, radix);
        }
        throw NumberFormatException.forInputString(s2, radix);
    }

    public static long parseUnsignedLong(CharSequence s2, int beginIndex, int endIndex, int radix) throws NumberFormatException {
        Objects.requireNonNull(s2);
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > s2.length()) {
            throw new IndexOutOfBoundsException();
        }
        int len = endIndex - beginIndex;
        if (len > 0) {
            char firstChar = s2.charAt(beginIndex);
            if (firstChar == '-') {
                throw new NumberFormatException(String.format("Illegal leading minus sign on unsigned string %s.", s2.subSequence(beginIndex, beginIndex + len)));
            }
            if (len <= 12 || (radix == 10 && len <= 18)) {
                return parseLong(s2, beginIndex, beginIndex + len, radix);
            }
            long first = parseLong(s2, beginIndex, (beginIndex + len) - 1, radix);
            int second = Character.digit(s2.charAt((beginIndex + len) - 1), radix);
            if (second < 0) {
                throw new NumberFormatException("Bad digit at end of " + ((Object) s2.subSequence(beginIndex, beginIndex + len)));
            }
            long result = (radix * first) + second;
            int guard = ((int) (first >>> 57)) * radix;
            if (guard >= 128 || (result >= 0 && guard >= 92)) {
                throw new NumberFormatException(String.format("String value %s exceeds range of unsigned long.", s2.subSequence(beginIndex, beginIndex + len)));
            }
            return result;
        }
        throw NumberFormatException.forInputString("", radix);
    }

    public static long parseUnsignedLong(String s2) throws NumberFormatException {
        return parseUnsignedLong(s2, 10);
    }

    public static Long valueOf(String s2, int radix) throws NumberFormatException {
        return valueOf(parseLong(s2, radix));
    }

    public static Long valueOf(String s2) throws NumberFormatException {
        return valueOf(parseLong(s2, 10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class LongCache {
        static Long[] archivedCache;
        static final Long[] cache;

        private LongCache() {
        }

        static {
            Long[] lArr = archivedCache;
            if (lArr == null || lArr.length != 256) {
                Long[] c4 = new Long[256];
                long value = -128;
                int i10 = 0;
                while (i10 < 256) {
                    c4[i10] = new Long(value);
                    i10++;
                    value = 1 + value;
                }
                archivedCache = c4;
            }
            cache = archivedCache;
        }
    }

    public static Long valueOf(long l10) {
        if (l10 >= -128 && l10 <= 127) {
            return LongCache.cache[((int) l10) + 128];
        }
        return new Long(l10);
    }

    public static Long decode(String nm) throws NumberFormatException {
        String constant;
        int radix = 10;
        int index = 0;
        boolean negative = false;
        if (nm.isEmpty()) {
            throw new NumberFormatException("Zero length string");
        }
        char firstChar = nm.charAt(0);
        if (firstChar == '-') {
            negative = true;
            index = 0 + 1;
        } else if (firstChar == '+') {
            index = 0 + 1;
        }
        if (nm.startsWith("0x", index) || nm.startsWith("0X", index)) {
            index += 2;
            radix = 16;
        } else if (nm.startsWith("#", index)) {
            index++;
            radix = 16;
        } else if (nm.startsWith("0", index) && nm.length() > index + 1) {
            index++;
            radix = 8;
        }
        if (nm.startsWith("-", index) || nm.startsWith(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, index)) {
            throw new NumberFormatException("Sign character in wrong position");
        }
        try {
            Long result = valueOf(nm.substring(index), radix);
            return negative ? valueOf(-result.longValue()) : result;
        } catch (NumberFormatException e2) {
            if (negative) {
                constant = "-" + nm.substring(index);
            } else {
                constant = nm.substring(index);
            }
            return valueOf(constant, radix);
        }
    }

    @Deprecated(since = "9")
    public Long(long value) {
        this.value = value;
    }

    @Deprecated(since = "9")
    public Long(String s2) throws NumberFormatException {
        this.value = parseLong(s2, 10);
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
        return (float) this.value;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public String toString() {
        return toString(this.value);
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(long value) {
        return (int) ((value >>> 32) ^ value);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Long) && this.value == ((Long) obj).longValue();
    }

    public static Long getLong(String nm) {
        return getLong(nm, (Long) null);
    }

    public static Long getLong(String nm, long val) {
        Long result = getLong(nm, (Long) null);
        return result == null ? valueOf(val) : result;
    }

    public static Long getLong(String nm, Long val) {
        String v2 = null;
        try {
            v2 = System.getProperty(nm);
        } catch (IllegalArgumentException | NullPointerException e2) {
        }
        if (v2 != null) {
            try {
                return decode(v2);
            } catch (NumberFormatException e10) {
            }
        }
        return val;
    }

    @Override // java.lang.Comparable
    public int compareTo(Long anotherLong) {
        return compare(this.value, anotherLong.value);
    }

    public static int compare(long x10, long y10) {
        if (x10 < y10) {
            return -1;
        }
        return x10 == y10 ? 0 : 1;
    }

    public static int compareUnsigned(long x10, long y10) {
        return compare(x10 - Long.MIN_VALUE, Long.MIN_VALUE + y10);
    }

    public static long divideUnsigned(long dividend, long divisor) {
        if (divisor >= 0) {
            long q10 = ((dividend >>> 1) / divisor) << 1;
            long r10 = dividend - (q10 * divisor);
            return (((~(r10 - divisor)) | r10) >>> 63) + q10;
        }
        return ((~(dividend - divisor)) & dividend) >>> 63;
    }

    public static long remainderUnsigned(long dividend, long divisor) {
        if (divisor >= 0) {
            long q10 = ((dividend >>> 1) / divisor) << 1;
            long r10 = dividend - (q10 * divisor);
            return r10 - (((~(r10 - divisor)) >> 63) & divisor);
        }
        long q11 = dividend - divisor;
        return dividend - ((((~q11) & dividend) >> 63) & divisor);
    }

    public static long highestOneBit(long i10) {
        return ((-9223372036854775808) >>> numberOfLeadingZeros(i10)) & i10;
    }

    public static long lowestOneBit(long i10) {
        return (-i10) & i10;
    }

    public static int numberOfLeadingZeros(long i10) {
        int x10 = (int) (i10 >>> 32);
        if (x10 == 0) {
            return Integer.numberOfLeadingZeros((int) i10) + 32;
        }
        return Integer.numberOfLeadingZeros(x10);
    }

    public static int numberOfTrailingZeros(long i10) {
        int x10 = (int) i10;
        return x10 == 0 ? Integer.numberOfTrailingZeros((int) (i10 >>> 32)) + 32 : Integer.numberOfTrailingZeros(x10);
    }

    public static int bitCount(long i10) {
        long i11 = i10 - ((i10 >>> 1) & 6148914691236517205L);
        long i12 = (i11 & 3689348814741910323L) + (3689348814741910323L & (i11 >>> 2));
        long i13 = ((i12 >>> 4) + i12) & 1085102592571150095L;
        long i14 = i13 + (i13 >>> 8);
        long i15 = i14 + (i14 >>> 16);
        return ((int) (i15 + (i15 >>> 32))) & 127;
    }

    public static long rotateLeft(long i10, int distance) {
        return (i10 << distance) | (i10 >>> (-distance));
    }

    public static long rotateRight(long i10, int distance) {
        return (i10 >>> distance) | (i10 << (-distance));
    }

    public static long reverse(long i10) {
        long i11 = ((i10 & 6148914691236517205L) << 1) | (6148914691236517205L & (i10 >>> 1));
        long i12 = ((i11 & 3689348814741910323L) << 2) | (3689348814741910323L & (i11 >>> 2));
        return reverseBytes(((i12 & 1085102592571150095L) << 4) | (1085102592571150095L & (i12 >>> 4)));
    }

    public static int signum(long i10) {
        return (int) ((i10 >> 63) | ((-i10) >>> 63));
    }

    public static long reverseBytes(long i10) {
        long i11 = ((i10 & 71777214294589695L) << 8) | (71777214294589695L & (i10 >>> 8));
        return (i11 << 48) | ((i11 & 4294901760L) << 16) | (4294901760L & (i11 >>> 16)) | (i11 >>> 48);
    }

    public static long sum(long a10, long b4) {
        return a10 + b4;
    }

    public static long max(long a10, long b4) {
        return Math.max(a10, b4);
    }

    public static long min(long a10, long b4) {
        return Math.min(a10, b4);
    }
}
