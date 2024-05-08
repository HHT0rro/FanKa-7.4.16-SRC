package java.lang;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.badge.BadgeDrawable;
import java.time.Year;
import java.util.Locale;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Integer extends Number implements Comparable<Integer> {
    public static final int BYTES = 4;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int MIN_VALUE = Integer.MIN_VALUE;
    public static final int SIZE = 32;
    private static final long serialVersionUID = 1360826667806852920L;
    private final int value;
    public static final Class<Integer> TYPE = Class.getPrimitiveClass(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
    static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z'};
    private static final String[] SMALL_NEG_VALUES = new String[100];
    private static final String[] SMALL_NONNEG_VALUES = new String[100];
    static final byte[] DigitTens = {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 56, 56, 56, 56, 56, 56, 56, 56, 56, 56, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57};
    static final byte[] DigitOnes = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
    static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, Year.MAX_VALUE, Integer.MAX_VALUE};

    public static String toString(int i10, int radix) {
        if (radix < 2 || radix > 36) {
            radix = 10;
        }
        if (radix == 10) {
            return toString(i10);
        }
        byte[] buf = new byte[33];
        boolean negative = i10 < 0;
        int charPos = 32;
        if (!negative) {
            i10 = -i10;
        }
        while (i10 <= (-radix)) {
            buf[charPos] = (byte) digits[-(i10 % radix)];
            i10 /= radix;
            charPos--;
        }
        buf[charPos] = (byte) digits[-i10];
        if (negative) {
            charPos--;
            buf[charPos] = 45;
        }
        return new String(buf, charPos, 33 - charPos);
    }

    public static String toUnsignedString(int i10, int radix) {
        return Long.toUnsignedString(toUnsignedLong(i10), radix);
    }

    public static String toHexString(int i10) {
        return toUnsignedString0(i10, 4);
    }

    public static String toOctalString(int i10) {
        return toUnsignedString0(i10, 3);
    }

    public static String toBinaryString(int i10) {
        return toUnsignedString0(i10, 1);
    }

    private static String toUnsignedString0(int val, int shift) {
        int mag = 32 - numberOfLeadingZeros(val);
        int chars = Math.max(((shift - 1) + mag) / shift, 1);
        byte[] buf = new byte[chars];
        formatUnsignedInt(val, shift, buf, 0, chars);
        return new String(buf);
    }

    static void formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
        int charPos = offset + len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            charPos--;
            buf[charPos] = digits[val & mask];
            val >>>= shift;
        } while (charPos > offset);
    }

    private static void formatUnsignedInt(int val, int shift, byte[] buf, int len) {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            charPos--;
            buf[charPos] = (byte) digits[val & mask];
            val >>>= shift;
        } while (charPos > 0);
    }

    static void formatUnsignedInt(int val, int shift, byte[] buf, int offset, int len) {
        int charPos = offset + len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            charPos--;
            buf[charPos] = (byte) digits[val & mask];
            val >>>= shift;
        } while (charPos > offset);
    }

    public static String toString(int i10) {
        String str;
        boolean negative = i10 < 0;
        boolean small = !negative ? i10 >= 100 : i10 <= -100;
        if (small) {
            String[] smallValues = negative ? SMALL_NEG_VALUES : SMALL_NONNEG_VALUES;
            if (negative) {
                i10 = -i10;
                if (smallValues[i10] == null) {
                    smallValues[i10] = i10 < 10 ? new String(new byte[]{45, DigitOnes[i10]}) : new String(new byte[]{45, DigitTens[i10], DigitOnes[i10]});
                }
            } else if (smallValues[i10] == null) {
                if (i10 < 10) {
                    str = new String(new byte[]{DigitOnes[i10]});
                } else {
                    str = new String(new byte[]{DigitTens[i10], DigitOnes[i10]});
                }
                smallValues[i10] = str;
            }
            return smallValues[i10];
        }
        int size = stringSize(i10);
        byte[] buf = new byte[size];
        getChars(i10, size, buf);
        return new String(buf);
    }

    public static String toUnsignedString(int i10) {
        return Long.toString(toUnsignedLong(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getChars(int i10, int index, byte[] buf) {
        int charPos = index;
        boolean negative = i10 < 0;
        if (!negative) {
            i10 = -i10;
        }
        while (i10 <= -100) {
            int q10 = i10 / 100;
            int r10 = (q10 * 100) - i10;
            i10 = q10;
            int charPos2 = charPos - 1;
            buf[charPos2] = DigitOnes[r10];
            charPos = charPos2 - 1;
            buf[charPos] = DigitTens[r10];
        }
        int q11 = i10 / 10;
        int charPos3 = charPos - 1;
        buf[charPos3] = (byte) (((q11 * 10) - i10) + 48);
        if (q11 < 0) {
            charPos3--;
            buf[charPos3] = (byte) (48 - q11);
        }
        if (negative) {
            int charPos4 = charPos3 - 1;
            buf[charPos4] = 45;
            return charPos4;
        }
        return charPos3;
    }

    static int getChars(int i10, int index, char[] buf) {
        int charPos = index;
        boolean negative = i10 < 0;
        if (!negative) {
            i10 = -i10;
        }
        while (i10 <= -100) {
            int q10 = i10 / 100;
            int r10 = (q10 * 100) - i10;
            i10 = q10;
            int charPos2 = charPos - 1;
            buf[charPos2] = (char) DigitOnes[r10];
            charPos = charPos2 - 1;
            buf[charPos] = (char) DigitTens[r10];
        }
        int q11 = i10 / 10;
        int charPos3 = charPos - 1;
        buf[charPos3] = (char) (((q11 * 10) - i10) + 48);
        if (q11 < 0) {
            charPos3--;
            buf[charPos3] = (char) (48 - q11);
        }
        if (negative) {
            int charPos4 = charPos3 - 1;
            buf[charPos4] = '-';
            return charPos4;
        }
        return charPos3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int stringSize(int x10) {
        int d10 = 1;
        if (x10 >= 0) {
            d10 = 0;
            x10 = -x10;
        }
        int p10 = -10;
        for (int i10 = 1; i10 < 10; i10++) {
            if (x10 > p10) {
                return i10 + d10;
            }
            p10 *= 10;
        }
        int i11 = d10 + 10;
        return i11;
    }

    public static int parseInt(String s2, int radix) throws NumberFormatException {
        if (s2 == null) {
            throw new NumberFormatException("s == null");
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
        int limit = -2147483647;
        if (len > 0) {
            char firstChar = s2.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw NumberFormatException.forInputString(s2, radix);
                }
                if (len == 1) {
                    throw NumberFormatException.forInputString(s2, radix);
                }
                i10 = 0 + 1;
            }
            int multmin = limit / radix;
            int result = 0;
            while (i10 < len) {
                int i11 = i10 + 1;
                int digit = Character.digit(s2.charAt(i10), radix);
                if (digit < 0 || result < multmin) {
                    throw NumberFormatException.forInputString(s2, radix);
                }
                int result2 = result * radix;
                if (result2 < limit + digit) {
                    throw NumberFormatException.forInputString(s2, radix);
                }
                result = result2 - digit;
                i10 = i11;
            }
            return negative ? result : -result;
        }
        throw NumberFormatException.forInputString(s2, radix);
    }

    public static int parseInt(CharSequence s2, int beginIndex, int endIndex, int radix) throws NumberFormatException {
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
        int limit = -2147483647;
        if (i10 < endIndex) {
            char firstChar = s2.charAt(i10);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw NumberFormatException.forCharSequence(s2, beginIndex, endIndex, i10);
                }
                i10++;
                if (i10 == endIndex) {
                    throw NumberFormatException.forCharSequence(s2, beginIndex, endIndex, i10);
                }
            }
            int multmin = limit / radix;
            int result = 0;
            while (i10 < endIndex) {
                int digit = Character.digit(s2.charAt(i10), radix);
                if (digit < 0 || result < multmin) {
                    throw NumberFormatException.forCharSequence(s2, beginIndex, endIndex, i10);
                }
                int result2 = result * radix;
                if (result2 < limit + digit) {
                    throw NumberFormatException.forCharSequence(s2, beginIndex, endIndex, i10);
                }
                i10++;
                result = result2 - digit;
            }
            return negative ? result : -result;
        }
        throw NumberFormatException.forInputString("", radix);
    }

    public static int parseInt(String s2) throws NumberFormatException {
        return parseInt(s2, 10);
    }

    public static int parseUnsignedInt(String s2, int radix) throws NumberFormatException {
        if (s2 == null) {
            throw new NumberFormatException("Cannot parse null string");
        }
        int len = s2.length();
        if (len > 0) {
            char firstChar = s2.charAt(0);
            if (firstChar == '-') {
                throw new NumberFormatException(String.format("Illegal leading minus sign on unsigned string %s.", s2));
            }
            if (len <= 5 || (radix == 10 && len <= 9)) {
                return parseInt(s2, radix);
            }
            long ell = Long.parseLong(s2, radix);
            if (((-4294967296L) & ell) == 0) {
                return (int) ell;
            }
            throw new NumberFormatException(String.format("String value %s exceeds range of unsigned int.", s2));
        }
        throw NumberFormatException.forInputString(s2, radix);
    }

    public static int parseUnsignedInt(CharSequence s2, int beginIndex, int endIndex, int radix) throws NumberFormatException {
        Objects.requireNonNull(s2);
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > s2.length()) {
            throw new IndexOutOfBoundsException();
        }
        int len = endIndex - beginIndex;
        if (len > 0) {
            char firstChar = s2.charAt(beginIndex);
            if (firstChar == '-') {
                throw new NumberFormatException(String.format("Illegal leading minus sign on unsigned string %s.", s2));
            }
            if (len <= 5 || (radix == 10 && len <= 9)) {
                return parseInt(s2, beginIndex, beginIndex + len, radix);
            }
            long ell = Long.parseLong(s2, beginIndex, beginIndex + len, radix);
            if (((-4294967296L) & ell) == 0) {
                return (int) ell;
            }
            throw new NumberFormatException(String.format("String value %s exceeds range of unsigned int.", s2));
        }
        throw new NumberFormatException("");
    }

    public static int parseUnsignedInt(String s2) throws NumberFormatException {
        return parseUnsignedInt(s2, 10);
    }

    public static Integer valueOf(String s2, int radix) throws NumberFormatException {
        return valueOf(parseInt(s2, radix));
    }

    public static Integer valueOf(String s2) throws NumberFormatException {
        return valueOf(parseInt(s2, 10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class IntegerCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static Integer[] archivedCache = null;
        static final Integer[] cache;
        static final int high = 127;
        static final int low = -128;

        static {
            int size = 127 + 128 + 1;
            Integer[] numArr = archivedCache;
            if (numArr == null || size > numArr.length) {
                Integer[] c4 = new Integer[size];
                int j10 = low;
                int i10 = 0;
                while (i10 < c4.length) {
                    c4[i10] = new Integer(j10);
                    i10++;
                    j10++;
                }
                archivedCache = c4;
            }
            cache = archivedCache;
        }

        private IntegerCache() {
        }
    }

    public static Integer valueOf(int i10) {
        if (i10 >= -128 && i10 <= IntegerCache.high) {
            return IntegerCache.cache[i10 + 128];
        }
        return new Integer(i10);
    }

    @Deprecated(since = "9")
    public Integer(int value) {
        this.value = value;
    }

    @Deprecated(since = "9")
    public Integer(String s2) throws NumberFormatException {
        this.value = parseInt(s2, 10);
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
        return toString(this.value);
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(int value) {
        return value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Integer) && this.value == ((Integer) obj).intValue();
    }

    public static Integer getInteger(String nm) {
        return getInteger(nm, (Integer) null);
    }

    public static Integer getInteger(String nm, int val) {
        Integer result = getInteger(nm, (Integer) null);
        return result == null ? valueOf(val) : result;
    }

    public static Integer getInteger(String nm, Integer val) {
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

    public static Integer decode(String nm) throws NumberFormatException {
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
            Integer result = valueOf(nm.substring(index), radix);
            return negative ? valueOf(-result.intValue()) : result;
        } catch (NumberFormatException e2) {
            if (negative) {
                constant = "-" + nm.substring(index);
            } else {
                constant = nm.substring(index);
            }
            return valueOf(constant, radix);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Integer anotherInteger) {
        return compare(this.value, anotherInteger.value);
    }

    public static int compare(int x10, int y10) {
        if (x10 < y10) {
            return -1;
        }
        return x10 == y10 ? 0 : 1;
    }

    public static int compareUnsigned(int x10, int y10) {
        return compare(x10 - 2147483648, Integer.MIN_VALUE + y10);
    }

    public static long toUnsignedLong(int x10) {
        return x10 & 4294967295L;
    }

    public static int divideUnsigned(int dividend, int divisor) {
        return (int) (toUnsignedLong(dividend) / toUnsignedLong(divisor));
    }

    public static int remainderUnsigned(int dividend, int divisor) {
        return (int) (toUnsignedLong(dividend) % toUnsignedLong(divisor));
    }

    public static int highestOneBit(int i10) {
        return (Integer.MIN_VALUE >>> numberOfLeadingZeros(i10)) & i10;
    }

    public static int lowestOneBit(int i10) {
        return (-i10) & i10;
    }

    public static int numberOfLeadingZeros(int i10) {
        if (i10 <= 0) {
            return i10 == 0 ? 32 : 0;
        }
        int n10 = 31;
        if (i10 >= 65536) {
            n10 = 31 - 16;
            i10 >>>= 16;
        }
        if (i10 >= 256) {
            n10 -= 8;
            i10 >>>= 8;
        }
        if (i10 >= 16) {
            n10 -= 4;
            i10 >>>= 4;
        }
        if (i10 >= 4) {
            n10 -= 2;
            i10 >>>= 2;
        }
        return n10 - (i10 >>> 1);
    }

    public static int numberOfTrailingZeros(int i10) {
        int i11 = (~i10) & (i10 - 1);
        if (i11 <= 0) {
            return i11 & 32;
        }
        int n10 = 1;
        if (i11 > 65536) {
            n10 = 1 + 16;
            i11 >>>= 16;
        }
        if (i11 > 256) {
            n10 += 8;
            i11 >>>= 8;
        }
        if (i11 > 16) {
            n10 += 4;
            i11 >>>= 4;
        }
        if (i11 > 4) {
            n10 += 2;
            i11 >>>= 2;
        }
        return (i11 >>> 1) + n10;
    }

    public static int bitCount(int i10) {
        int i11 = i10 - ((i10 >>> 1) & 1431655765);
        int i12 = (i11 & 858993459) + (858993459 & (i11 >>> 2));
        int i13 = ((i12 >>> 4) + i12) & 252645135;
        int i14 = i13 + (i13 >>> 8);
        return (i14 + (i14 >>> 16)) & 63;
    }

    public static int rotateLeft(int i10, int distance) {
        return (i10 << distance) | (i10 >>> (-distance));
    }

    public static int rotateRight(int i10, int distance) {
        return (i10 >>> distance) | (i10 << (-distance));
    }

    public static int reverse(int i10) {
        int i11 = ((i10 & 1431655765) << 1) | (1431655765 & (i10 >>> 1));
        int i12 = ((i11 & 858993459) << 2) | (858993459 & (i11 >>> 2));
        return reverseBytes(((i12 & 252645135) << 4) | (252645135 & (i12 >>> 4)));
    }

    public static int signum(int i10) {
        return (i10 >> 31) | ((-i10) >>> 31);
    }

    public static int reverseBytes(int i10) {
        return (i10 << 24) | ((i10 & 65280) << 8) | (65280 & (i10 >>> 8)) | (i10 >>> 24);
    }

    public static int sum(int a10, int b4) {
        return a10 + b4;
    }

    public static int max(int a10, int b4) {
        return Math.max(a10, b4);
    }

    public static int min(int a10, int b4) {
        return Math.min(a10, b4);
    }
}
