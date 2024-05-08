package java.lang;

import com.android.internal.logging.nano.MetricsProto;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StringUTF16 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int HI_BYTE_SHIFT = 0;
    static final int LO_BYTE_SHIFT = 8;
    static final int MAX_LENGTH = 1073741823;

    StringUTF16() {
    }

    public static byte[] newBytesFor(int len) {
        if (len < 0) {
            throw new NegativeArraySizeException();
        }
        if (len > 1073741823) {
            throw new OutOfMemoryError("UTF16 String size is " + len + ", should be less than 1073741823");
        }
        return new byte[len << 1];
    }

    static void putChar(byte[] val, int index, int c4) {
        int index2 = index << 1;
        val[index2] = (byte) (c4 >> 0);
        val[index2 + 1] = (byte) (c4 >> 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char getChar(byte[] val, int index) {
        int index2 = index << 1;
        return (char) (((val[index2] & 255) << 0) | ((val[index2 + 1] & 255) << 8));
    }

    static char getChar(String val, int index) {
        return val.charAt(index);
    }

    public static int length(byte[] value) {
        return value.length >> 1;
    }

    public static int length(String value) {
        return value.length();
    }

    private static int codePointAt(byte[] value, int index, int end, boolean checked) {
        int index2;
        if (checked) {
            checkIndex(index, value);
        }
        char c12 = getChar(value, index);
        if (Character.isHighSurrogate(c12) && (index2 = index + 1) < end) {
            if (checked) {
                checkIndex(index2, value);
            }
            char c22 = getChar(value, index2);
            if (Character.isLowSurrogate(c22)) {
                return Character.toCodePoint(c12, c22);
            }
        }
        return c12;
    }

    public static int codePointAt(byte[] value, int index, int end) {
        return codePointAt(value, index, end, false);
    }

    private static int codePointBefore(byte[] value, int index, boolean checked) {
        int index2 = index - 1;
        if (checked) {
            checkIndex(index2, value);
        }
        char c22 = getChar(value, index2);
        if (Character.isLowSurrogate(c22) && index2 > 0) {
            int index3 = index2 - 1;
            if (checked) {
                checkIndex(index3, value);
            }
            char c12 = getChar(value, index3);
            if (Character.isHighSurrogate(c12)) {
                return Character.toCodePoint(c12, c22);
            }
        }
        return c22;
    }

    public static int codePointBefore(byte[] value, int index) {
        return codePointBefore(value, index, false);
    }

    private static int codePointCount(byte[] value, int beginIndex, int endIndex, boolean checked) {
        int count = endIndex - beginIndex;
        int i10 = beginIndex;
        if (checked && i10 < endIndex) {
            checkBoundsBeginEnd(i10, endIndex, value);
        }
        while (i10 < endIndex - 1) {
            int i11 = i10 + 1;
            if (!Character.isHighSurrogate(getChar(value, i10)) || !Character.isLowSurrogate(getChar(value, i11))) {
                i10 = i11;
            } else {
                count--;
                i10 = i11 + 1;
            }
        }
        return count;
    }

    public static int codePointCount(byte[] value, int beginIndex, int endIndex) {
        return codePointCount(value, beginIndex, endIndex, false);
    }

    public static char[] toChars(byte[] value) {
        char[] dst = new char[value.length >> 1];
        getChars(value, 0, dst.length, dst, 0);
        return dst;
    }

    public static byte[] toBytes(char[] value, int off, int len) {
        byte[] val = newBytesFor(len);
        for (int i10 = 0; i10 < len; i10++) {
            putChar(val, i10, value[off]);
            off++;
        }
        return val;
    }

    public static byte[] compress(char[] val, int off, int len) {
        byte[] ret = new byte[len];
        if (compress(val, off, ret, 0, len) == len) {
            return ret;
        }
        return null;
    }

    public static byte[] compress(byte[] val, int off, int len) {
        byte[] ret = new byte[len];
        if (compress(val, off, ret, 0, len) == len) {
            return ret;
        }
        return null;
    }

    public static int compress(char[] src, int srcOff, byte[] dst, int dstOff, int len) {
        for (int i10 = 0; i10 < len; i10++) {
            char c4 = src[srcOff];
            if (c4 > 255) {
                return 0;
            }
            dst[dstOff] = (byte) c4;
            srcOff++;
            dstOff++;
        }
        return len;
    }

    public static int compress(byte[] src, int srcOff, byte[] dst, int dstOff, int len) {
        checkBoundsOffCount(srcOff, len, src);
        for (int i10 = 0; i10 < len; i10++) {
            char c4 = getChar(src, srcOff);
            if (c4 > 255) {
                return 0;
            }
            dst[dstOff] = (byte) c4;
            srcOff++;
            dstOff++;
        }
        return len;
    }

    public static byte[] toBytes(int[] val, int index, int len) {
        int end = index + len;
        int n10 = len;
        for (int i10 = index; i10 < end; i10++) {
            int cp = val[i10];
            if (!Character.isBmpCodePoint(cp)) {
                if (Character.isValidCodePoint(cp)) {
                    n10++;
                } else {
                    throw new IllegalArgumentException(Integer.toString(cp));
                }
            }
        }
        byte[] buf = newBytesFor(n10);
        int i11 = index;
        int j10 = 0;
        while (i11 < end) {
            int cp2 = val[i11];
            if (Character.isBmpCodePoint(cp2)) {
                putChar(buf, j10, cp2);
            } else {
                int j11 = j10 + 1;
                putChar(buf, j10, Character.highSurrogate(cp2));
                putChar(buf, j11, Character.lowSurrogate(cp2));
                j10 = j11;
            }
            i11++;
            j10++;
        }
        return buf;
    }

    public static byte[] toBytes(char c4) {
        byte[] result = new byte[2];
        putChar(result, 0, c4);
        return result;
    }

    static byte[] toBytesSupplementary(int cp) {
        byte[] result = new byte[4];
        putChar(result, 0, Character.highSurrogate(cp));
        putChar(result, 1, Character.lowSurrogate(cp));
        return result;
    }

    public static void getChars(byte[] value, int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        if (srcBegin < srcEnd) {
            checkBoundsOffCount(srcBegin, srcEnd - srcBegin, value);
        }
        int i10 = srcBegin;
        while (i10 < srcEnd) {
            dst[dstBegin] = getChar(value, i10);
            i10++;
            dstBegin++;
        }
    }

    public static void getBytes(byte[] value, int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        int srcEnd2 = srcEnd << 1;
        int i10 = (srcBegin << 1) + 0;
        while (i10 < srcEnd2) {
            dst[dstBegin] = value[i10];
            i10 += 2;
            dstBegin++;
        }
    }

    public static boolean equals(byte[] value, byte[] other) {
        if (value.length != other.length) {
            return false;
        }
        int len = value.length >> 1;
        for (int i10 = 0; i10 < len; i10++) {
            if (getChar(value, i10) != getChar(other, i10)) {
                return false;
            }
        }
        return true;
    }

    public static int compareTo(byte[] value, byte[] other) {
        int len1 = length(value);
        int len2 = length(other);
        return compareValues(value, other, len1, len2);
    }

    public static int compareTo(byte[] value, byte[] other, int len1, int len2) {
        checkOffset(len1, value);
        checkOffset(len2, other);
        return compareValues(value, other, len1, len2);
    }

    private static int compareValues(byte[] value, byte[] other, int len1, int len2) {
        int lim = Math.min(len1, len2);
        for (int k10 = 0; k10 < lim; k10++) {
            char c12 = getChar(value, k10);
            char c22 = getChar(other, k10);
            if (c12 != c22) {
                return c12 - c22;
            }
        }
        int k11 = len1 - len2;
        return k11;
    }

    public static int compareToLatin1(byte[] value, byte[] other) {
        return -StringLatin1.compareToUTF16(other, value);
    }

    public static int compareToLatin1(byte[] value, byte[] other, int len1, int len2) {
        return -StringLatin1.compareToUTF16(other, value, len2, len1);
    }

    public static int compareToCI(byte[] value, byte[] other) {
        char c12;
        char c22;
        char c13;
        char c23;
        int len1 = length(value);
        int len2 = length(other);
        int lim = Math.min(len1, len2);
        for (int k10 = 0; k10 < lim; k10++) {
            char c14 = getChar(value, k10);
            char c24 = getChar(other, k10);
            if (c14 != c24 && (c12 = Character.toUpperCase(c14)) != (c22 = Character.toUpperCase(c24)) && (c13 = Character.toLowerCase(c12)) != (c23 = Character.toLowerCase(c22))) {
                return c13 - c23;
            }
        }
        int k11 = len1 - len2;
        return k11;
    }

    public static int compareToCI_Latin1(byte[] value, byte[] other) {
        return -StringLatin1.compareToCI_UTF16(other, value);
    }

    public static int hashCode(byte[] value) {
        int h10 = 0;
        int length = value.length >> 1;
        for (int i10 = 0; i10 < length; i10++) {
            h10 = (h10 * 31) + getChar(value, i10);
        }
        return h10;
    }

    public static int indexOf(byte[] value, int ch, int fromIndex) {
        int max = value.length >> 1;
        if (fromIndex < 0) {
            fromIndex = 0;
        } else if (fromIndex >= max) {
            return -1;
        }
        if (ch < 65536) {
            return indexOfChar(value, ch, fromIndex, max);
        }
        return indexOfSupplementary(value, ch, fromIndex, max);
    }

    public static int indexOf(byte[] value, int valueCount, String str, int strCount, int fromIndex) {
        checkBoundsBeginEnd(fromIndex, valueCount, value);
        String.checkBoundsBeginEnd(0, strCount, str.length());
        return indexOfUnsafe(value, valueCount, str, strCount, fromIndex);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r2 > r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        r3 = r2 + 1;
        r4 = (r3 + r11) - 1;
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r3 >= r4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (getChar(r8, r3) != r10.charAt(r5)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3 = r3 + 1;
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r3 != r4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (getChar(r8, r2) != r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r2 > r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if (getChar(r8, r2) == r0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int indexOfUnsafe(byte[] r8, int r9, java.lang.String r10, int r11, int r12) {
        /*
            r0 = 0
            char r0 = r10.charAt(r0)
            int r1 = r9 - r11
            r2 = r12
        Lc:
            if (r2 > r1) goto L3f
            char r3 = getChar(r8, r2)
            if (r3 == r0) goto L1f
        L14:
            int r2 = r2 + 1
            if (r2 > r1) goto L1f
            char r3 = getChar(r8, r2)
            if (r3 == r0) goto L1f
            goto L14
        L1f:
            if (r2 > r1) goto L3c
            int r3 = r2 + 1
            int r4 = r3 + r11
            int r4 = r4 + (-1)
            r5 = 1
        L28:
            if (r3 >= r4) goto L39
            char r6 = getChar(r8, r3)
            char r7 = r10.charAt(r5)
            if (r6 != r7) goto L39
            int r3 = r3 + 1
            int r5 = r5 + 1
            goto L28
        L39:
            if (r3 != r4) goto L3c
            return r2
        L3c:
            int r2 = r2 + 1
            goto Lc
        L3f:
            r2 = -1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.StringUTF16.indexOfUnsafe(byte[], int, java.lang.String, int, int):int");
    }

    public static int indexOfLatin1(byte[] src, int srcCount, String tgt, int tgtCount, int fromIndex) {
        checkBoundsBeginEnd(fromIndex, srcCount, src);
        String.checkBoundsBeginEnd(0, tgtCount, tgt.length());
        return indexOfLatin1Unsafe(src, srcCount, tgt, tgtCount, fromIndex);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r2 > r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        r3 = r2 + 1;
        r4 = (r3 + r11) - 1;
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r3 >= r4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (getChar(r8, r3) != r10.charAt(r5)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3 = r3 + 1;
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r3 != r4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (getChar(r8, r2) != r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r2 > r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if (getChar(r8, r2) == r0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOfLatin1Unsafe(byte[] r8, int r9, java.lang.String r10, int r11, int r12) {
        /*
            r0 = 0
            char r0 = r10.charAt(r0)
            int r1 = r9 - r11
            r2 = r12
        Lc:
            if (r2 > r1) goto L3f
            char r3 = getChar(r8, r2)
            if (r3 == r0) goto L1f
        L14:
            int r2 = r2 + 1
            if (r2 > r1) goto L1f
            char r3 = getChar(r8, r2)
            if (r3 == r0) goto L1f
            goto L14
        L1f:
            if (r2 > r1) goto L3c
            int r3 = r2 + 1
            int r4 = r3 + r11
            int r4 = r4 + (-1)
            r5 = 1
        L28:
            if (r3 >= r4) goto L39
            char r6 = getChar(r8, r3)
            char r7 = r10.charAt(r5)
            if (r6 != r7) goto L39
            int r3 = r3 + 1
            int r5 = r5 + 1
            goto L28
        L39:
            if (r3 != r4) goto L3c
            return r2
        L3c:
            int r2 = r2 + 1
            goto Lc
        L3f:
            r2 = -1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.StringUTF16.indexOfLatin1Unsafe(byte[], int, java.lang.String, int, int):int");
    }

    private static int indexOfChar(byte[] value, int ch, int fromIndex, int max) {
        checkBoundsBeginEnd(fromIndex, max, value);
        return indexOfCharUnsafe(value, ch, fromIndex, max);
    }

    private static int indexOfCharUnsafe(byte[] value, int ch, int fromIndex, int max) {
        for (int i10 = fromIndex; i10 < max; i10++) {
            if (getChar(value, i10) == ch) {
                return i10;
            }
        }
        return -1;
    }

    private static int indexOfSupplementary(byte[] value, int ch, int fromIndex, int max) {
        if (Character.isValidCodePoint(ch)) {
            char hi = Character.highSurrogate(ch);
            char lo = Character.lowSurrogate(ch);
            checkBoundsBeginEnd(fromIndex, max, value);
            for (int i10 = fromIndex; i10 < max - 1; i10++) {
                if (getChar(value, i10) == hi && getChar(value, i10 + 1) == lo) {
                    return i10;
                }
            }
            return -1;
        }
        return -1;
    }

    public static int lastIndexOf(byte[] src, int srcCount, String tgt, int tgtCount, int fromIndex) {
        int min = tgtCount - 1;
        int i10 = min + fromIndex;
        int strLastIndex = tgtCount - 1;
        String.checkIndex(strLastIndex, tgt.length());
        char strLastChar = tgt.charAt(strLastIndex);
        checkIndex(i10, src);
        while (true) {
            if (i10 >= min && getChar(src, i10) != strLastChar) {
                i10--;
            } else {
                if (i10 < min) {
                    return -1;
                }
                int j10 = i10 - 1;
                int start = j10 - strLastIndex;
                int k10 = strLastIndex - 1;
                while (j10 > start) {
                    int j11 = j10 - 1;
                    int k11 = k10 - 1;
                    if (getChar(src, j10) == tgt.charAt(k10)) {
                        j10 = j11;
                        k10 = k11;
                    } else {
                        i10--;
                    }
                }
                return start + 1;
            }
        }
    }

    public static int lastIndexOf(byte[] value, int ch, int fromIndex) {
        if (ch < 65536) {
            for (int i10 = Math.min(fromIndex, (value.length >> 1) - 1); i10 >= 0; i10--) {
                if (getChar(value, i10) == ch) {
                    return i10;
                }
            }
            return -1;
        }
        int i11 = lastIndexOfSupplementary(value, ch, fromIndex);
        return i11;
    }

    private static int lastIndexOfSupplementary(byte[] value, int ch, int fromIndex) {
        if (Character.isValidCodePoint(ch)) {
            char hi = Character.highSurrogate(ch);
            char lo = Character.lowSurrogate(ch);
            for (int i10 = Math.min(fromIndex, (value.length >> 1) - 2); i10 >= 0; i10--) {
                if (getChar(value, i10) == hi && getChar(value, i10 + 1) == lo) {
                    return i10;
                }
            }
            return -1;
        }
        return -1;
    }

    public static String replace(byte[] value, char oldChar, char newChar) {
        byte[] val;
        int len = value.length >> 1;
        int i10 = -1;
        do {
            i10++;
            if (i10 >= len) {
                break;
            }
        } while (getChar(value, i10) != oldChar);
        if (i10 < len) {
            byte[] buf = new byte[value.length];
            for (int j10 = 0; j10 < i10; j10++) {
                putChar(buf, j10, getChar(value, j10));
            }
            while (i10 < len) {
                char c4 = getChar(value, i10);
                putChar(buf, i10, c4 == oldChar ? newChar : c4);
                i10++;
            }
            if (!StringLatin1.canEncode(oldChar) && StringLatin1.canEncode(newChar) && (val = compress(buf, 0, len)) != null) {
                return new String(val, (byte) 0);
            }
            return new String(buf, (byte) 1);
        }
        return null;
    }

    public static String trim(byte[] value) {
        int length = value.length >> 1;
        int len = length;
        int st = 0;
        while (st < len && getChar(value, st) <= ' ') {
            st++;
        }
        while (st < len && getChar(value, len - 1) <= ' ') {
            len--;
        }
        if (st > 0 || len < length) {
            return StringFactory.newStringFromUtf16Bytes(value, st << 1, len - st);
        }
        return null;
    }

    public static int indexOfNonWhitespace(String value) {
        int length = value.length();
        int left = 0;
        while (left < length) {
            int codepoint = value.codePointAt(left);
            if (codepoint != 32 && codepoint != 9 && !Character.isWhitespace(codepoint)) {
                break;
            }
            left += Character.charCount(codepoint);
        }
        return left;
    }

    public static int lastIndexOfNonWhitespace(String value) {
        int right = value.length();
        while (right > 0) {
            int codepoint = value.codePointBefore(right);
            if (codepoint != 32 && codepoint != 9 && !Character.isWhitespace(codepoint)) {
                break;
            }
            right -= Character.charCount(codepoint);
        }
        return right;
    }

    public static String strip(String value) {
        int length = value.length();
        int left = indexOfNonWhitespace(value);
        if (left == length) {
            return "";
        }
        int right = lastIndexOfNonWhitespace(value);
        if (left > 0 || right < length) {
            return newString(value, left, right - left);
        }
        return null;
    }

    public static String stripLeading(String value) {
        int length = value.length();
        int left = indexOfNonWhitespace(value);
        if (left == length) {
            return "";
        }
        if (left != 0) {
            return newString(value, left, length - left);
        }
        return null;
    }

    public static String stripTrailing(String value) {
        int length = value.length();
        int right = lastIndexOfNonWhitespace(value);
        if (right == 0) {
            return "";
        }
        if (right != length) {
            return newString(value, 0, right);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LinesSpliterator implements Spliterator<String> {
        private final int fence;
        private int index;
        private String value;

        LinesSpliterator(String value) {
            this(value, 0, value.length());
        }

        LinesSpliterator(String value, int start, int length) {
            this.value = value;
            this.index = start;
            this.fence = start + length;
        }

        private int indexOfLineSeparator(int start) {
            int current = start;
            while (true) {
                int i10 = this.fence;
                if (current < i10) {
                    char ch = StringUTF16.getChar(this.value, current);
                    if (ch == '\n' || ch == '\r') {
                        break;
                    }
                    current++;
                } else {
                    return i10;
                }
            }
            return current;
        }

        private int skipLineSeparator(int start) {
            int next;
            int i10 = this.fence;
            if (start < i10) {
                if (StringUTF16.getChar(this.value, start) == '\r' && (next = start + 1) < this.fence && StringUTF16.getChar(this.value, next) == '\n') {
                    return next + 1;
                }
                return start + 1;
            }
            return i10;
        }

        private String next() {
            int start = this.index;
            int end = indexOfLineSeparator(start);
            this.index = skipLineSeparator(end);
            return StringUTF16.newString(this.value, start, end - start);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super String> action) {
            if (action == null) {
                throw new NullPointerException("tryAdvance action missing");
            }
            if (this.index != this.fence) {
                action.accept(next());
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super String> action) {
            if (action == null) {
                throw new NullPointerException("forEachRemaining action missing");
            }
            while (this.index != this.fence) {
                action.accept(next());
            }
        }

        @Override // java.util.Spliterator
        public Spliterator<String> trySplit() {
            int half = (this.fence + this.index) >>> 1;
            int mid = skipLineSeparator(indexOfLineSeparator(half));
            if (mid < this.fence) {
                int start = this.index;
                this.index = mid;
                return new LinesSpliterator(this.value, start, mid - start);
            }
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (this.fence - this.index) + 1;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return MetricsProto.MetricsEvent.ACTION_OUTPUT_CHOOSER_CONNECT;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Stream<String> lines(String value) {
        return StreamSupport.stream(new LinesSpliterator(value), false);
    }

    private static void putChars(byte[] val, int index, char[] str, int off, int end) {
        while (off < end) {
            putChar(val, index, str[off]);
            index++;
            off++;
        }
    }

    public static String newString(byte[] val, int index, int len) {
        return StringFactory.newStringFromUtf16Bytes(val, index << 1, len);
    }

    public static String newString(String val, int index, int len) {
        return val.substring(index, index + len);
    }

    public static void fillNull(byte[] val, int index, int end) {
        Arrays.fill(val, index << 1, end << 1, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CharsSpliterator implements Spliterator.OfInt {
        private final byte[] array;
        private final int cs;
        private final int fence;
        private int index;

        CharsSpliterator(byte[] array, int acs) {
            this(array, 0, array.length >> 1, acs);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CharsSpliterator(byte[] array, int origin, int fence, int acs) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.cs = acs | 16 | 64 | 16384;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            byte[] bArr = this.array;
            this.index = mid;
            return new CharsSpliterator(bArr, lo, mid, this.cs);
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            byte[] a10 = this.array;
            int length = a10.length >> 1;
            int hi = this.fence;
            if (length >= hi) {
                int i10 = this.index;
                int i11 = i10;
                if (i10 >= 0) {
                    this.index = hi;
                    if (i11 >= hi) {
                        return;
                    }
                    do {
                        action.accept(StringUTF16.charAt(a10, i11));
                        i11++;
                    } while (i11 < hi);
                }
            }
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int i10 = this.index;
            if (i10 >= 0 && i10 < this.fence) {
                action.accept(StringUTF16.charAt(this.array, i10));
                this.index++;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.cs;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CodePointsSpliterator implements Spliterator.OfInt {
        private final byte[] array;
        private final int cs;
        private final int fence;
        private int index;

        CodePointsSpliterator(byte[] array, int acs) {
            this(array, 0, array.length >> 1, acs);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CodePointsSpliterator(byte[] array, int origin, int fence, int acs) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.cs = acs | 16;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            if (Character.isLowSurrogate(StringUTF16.charAt(this.array, mid))) {
                int midOneLess = mid - 1;
                if (Character.isHighSurrogate(StringUTF16.charAt(this.array, midOneLess))) {
                    if (lo >= midOneLess) {
                        return null;
                    }
                    byte[] bArr = this.array;
                    this.index = midOneLess;
                    return new CodePointsSpliterator(bArr, lo, midOneLess, this.cs);
                }
            }
            byte[] bArr2 = this.array;
            this.index = mid;
            return new CodePointsSpliterator(bArr2, lo, mid, this.cs);
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            byte[] a10 = this.array;
            int length = a10.length >> 1;
            int hi = this.fence;
            if (length >= hi) {
                int i10 = this.index;
                int i11 = i10;
                if (i10 >= 0) {
                    this.index = hi;
                    if (i11 >= hi) {
                        return;
                    }
                    do {
                        i11 = advance(a10, i11, hi, action);
                    } while (i11 < hi);
                }
            }
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            int i10;
            if (action == null) {
                throw new NullPointerException();
            }
            int i11 = this.index;
            if (i11 >= 0 && i11 < (i10 = this.fence)) {
                this.index = advance(this.array, i11, i10, action);
                return true;
            }
            return false;
        }

        private static int advance(byte[] a10, int i10, int hi, IntConsumer action) {
            int i11 = i10 + 1;
            char c12 = StringUTF16.charAt(a10, i10);
            int cp = c12;
            if (Character.isHighSurrogate(c12) && i11 < hi) {
                char c22 = StringUTF16.charAt(a10, i11);
                if (Character.isLowSurrogate(c22)) {
                    i11++;
                    cp = Character.toCodePoint(c12, c22);
                }
            }
            action.accept(cp);
            return i11;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.cs;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class CharsSpliteratorForString implements Spliterator.OfInt {
        private final String array;
        private final int cs;
        private final int fence;
        private int index;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CharsSpliteratorForString(String array, int acs) {
            this(array, 0, array.length(), acs);
        }

        CharsSpliteratorForString(String array, int origin, int fence, int acs) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.cs = acs | 16 | 64 | 16384;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            String str = this.array;
            this.index = mid;
            return new CharsSpliteratorForString(str, lo, mid, this.cs);
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            String a10 = this.array;
            int length = a10.length();
            int hi = this.fence;
            if (length >= hi) {
                int i10 = this.index;
                int i11 = i10;
                if (i10 >= 0) {
                    this.index = hi;
                    if (i11 >= hi) {
                        return;
                    }
                    do {
                        action.accept(StringUTF16.charAt(a10, i11));
                        i11++;
                    } while (i11 < hi);
                }
            }
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int i10 = this.index;
            if (i10 >= 0 && i10 < this.fence) {
                action.accept(StringUTF16.charAt(this.array, i10));
                this.index++;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.cs;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class CodePointsSpliteratorForString implements Spliterator.OfInt {
        private final String array;
        private final int cs;
        private final int fence;
        private int index;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CodePointsSpliteratorForString(String array, int acs) {
            this(array, 0, array.length(), acs);
        }

        CodePointsSpliteratorForString(String array, int origin, int fence, int acs) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.cs = acs | 16;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            if (Character.isLowSurrogate(StringUTF16.charAt(this.array, mid))) {
                int midOneLess = mid - 1;
                if (Character.isHighSurrogate(StringUTF16.charAt(this.array, midOneLess))) {
                    if (lo >= midOneLess) {
                        return null;
                    }
                    String str = this.array;
                    this.index = midOneLess;
                    return new CodePointsSpliteratorForString(str, lo, midOneLess, this.cs);
                }
            }
            String str2 = this.array;
            this.index = mid;
            return new CodePointsSpliteratorForString(str2, lo, mid, this.cs);
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            String a10 = this.array;
            int length = a10.length();
            int hi = this.fence;
            if (length >= hi) {
                int i10 = this.index;
                int i11 = i10;
                if (i10 >= 0) {
                    this.index = hi;
                    if (i11 >= hi) {
                        return;
                    }
                    do {
                        i11 = advance(a10, i11, hi, action);
                    } while (i11 < hi);
                }
            }
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            int i10;
            if (action == null) {
                throw new NullPointerException();
            }
            int i11 = this.index;
            if (i11 >= 0 && i11 < (i10 = this.fence)) {
                this.index = advance(this.array, i11, i10, action);
                return true;
            }
            return false;
        }

        private static int advance(String a10, int i10, int hi, IntConsumer action) {
            int i11 = i10 + 1;
            char c12 = StringUTF16.charAt(a10, i10);
            int cp = c12;
            if (Character.isHighSurrogate(c12) && i11 < hi) {
                char c22 = StringUTF16.charAt(a10, i11);
                if (Character.isLowSurrogate(c22)) {
                    i11++;
                    cp = Character.toCodePoint(c12, c22);
                }
            }
            action.accept(cp);
            return i11;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.cs;
        }
    }

    public static void putCharSB(byte[] val, int index, int c4) {
        checkIndex(index, val);
        putChar(val, index, c4);
    }

    public static void putCharsSB(byte[] val, int index, char[] ca2, int off, int end) {
        checkBoundsBeginEnd(index, (index + end) - off, val);
        putChars(val, index, ca2, off, end);
    }

    public static void putCharsSB(byte[] val, int index, CharSequence s2, int off, int end) {
        checkBoundsBeginEnd(index, (index + end) - off, val);
        int i10 = off;
        while (i10 < end) {
            putChar(val, index, s2.charAt(i10));
            i10++;
            index++;
        }
    }

    public static int codePointAtSB(byte[] val, int index, int end) {
        return codePointAt(val, index, end, true);
    }

    public static int codePointBeforeSB(byte[] val, int index) {
        return codePointBefore(val, index, true);
    }

    public static int codePointCountSB(byte[] val, int beginIndex, int endIndex) {
        return codePointCount(val, beginIndex, endIndex, true);
    }

    public static int getChars(int i10, int begin, int end, byte[] value) {
        checkBoundsBeginEnd(begin, end, value);
        int pos = getChars(i10, end, value);
        return pos;
    }

    public static int getChars(long l10, int begin, int end, byte[] value) {
        checkBoundsBeginEnd(begin, end, value);
        int pos = getChars(l10, end, value);
        return pos;
    }

    public static boolean contentEquals(byte[] v12, byte[] v2, int len) {
        checkBoundsOffCount(0, len, v2);
        for (int i10 = 0; i10 < len; i10++) {
            if (((char) (v12[i10] & 255)) != getChar(v2, i10)) {
                return false;
            }
        }
        return true;
    }

    public static boolean contentEquals(byte[] value, CharSequence cs, int len) {
        checkOffset(len, value);
        for (int i10 = 0; i10 < len; i10++) {
            if (getChar(value, i10) != cs.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static int putCharsAt(byte[] value, int i10, char c12, char c22, char c32, char c4) {
        int end = i10 + 4;
        checkBoundsBeginEnd(i10, end, value);
        int i11 = i10 + 1;
        putChar(value, i10, c12);
        int i12 = i11 + 1;
        putChar(value, i11, c22);
        int i13 = i12 + 1;
        putChar(value, i12, c32);
        int i14 = i13 + 1;
        putChar(value, i13, c4);
        return end;
    }

    public static int putCharsAt(byte[] value, int i10, char c12, char c22, char c32, char c4, char c52) {
        int end = i10 + 5;
        checkBoundsBeginEnd(i10, end, value);
        int i11 = i10 + 1;
        putChar(value, i10, c12);
        int i12 = i11 + 1;
        putChar(value, i11, c22);
        int i13 = i12 + 1;
        putChar(value, i12, c32);
        int i14 = i13 + 1;
        putChar(value, i13, c4);
        int i15 = i14 + 1;
        putChar(value, i14, c52);
        return end;
    }

    public static char charAt(byte[] value, int index) {
        checkIndex(index, value);
        return getChar(value, index);
    }

    public static char charAt(String value, int index) {
        checkIndex(index, value);
        return getChar(value, index);
    }

    public static void reverse(byte[] val, int count) {
        checkOffset(count, val);
        int n10 = count - 1;
        boolean hasSurrogates = false;
        for (int j10 = (n10 - 1) >> 1; j10 >= 0; j10--) {
            int k10 = n10 - j10;
            char cj = getChar(val, j10);
            char ck = getChar(val, k10);
            putChar(val, j10, ck);
            putChar(val, k10, cj);
            if (Character.isSurrogate(cj) || Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        if (hasSurrogates) {
            reverseAllValidSurrogatePairs(val, count);
        }
    }

    private static void reverseAllValidSurrogatePairs(byte[] val, int count) {
        int i10 = 0;
        while (i10 < count - 1) {
            char c22 = getChar(val, i10);
            if (Character.isLowSurrogate(c22)) {
                char c12 = getChar(val, i10 + 1);
                if (Character.isHighSurrogate(c12)) {
                    int i11 = i10 + 1;
                    putChar(val, i10, c12);
                    putChar(val, i11, c22);
                    i10 = i11;
                }
            }
            i10++;
        }
    }

    public static void inflate(byte[] src, int srcOff, byte[] dst, int dstOff, int len) {
        checkBoundsOffCount(dstOff, len, dst);
        int i10 = 0;
        while (i10 < len) {
            putChar(dst, dstOff, src[srcOff] & 255);
            i10++;
            dstOff++;
            srcOff++;
        }
    }

    public static int lastIndexOfLatin1(byte[] src, int srcCount, String tgt, int tgtCount, int fromIndex) {
        int min = tgtCount - 1;
        int i10 = min + fromIndex;
        int strLastIndex = tgtCount - 1;
        char strLastChar = tgt.charAt(strLastIndex);
        checkIndex(i10, src);
        while (true) {
            if (i10 >= min && getChar(src, i10) != strLastChar) {
                i10--;
            } else {
                if (i10 < min) {
                    return -1;
                }
                int j10 = i10 - 1;
                int start = j10 - strLastIndex;
                int k10 = strLastIndex - 1;
                while (j10 > start) {
                    int j11 = j10 - 1;
                    int k11 = k10 - 1;
                    if (getChar(src, j10) == tgt.charAt(k10)) {
                        j10 = j11;
                        k10 = k11;
                    } else {
                        i10--;
                    }
                }
                return start + 1;
            }
        }
    }

    static int getChars(int i10, int index, byte[] buf) {
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
            putChar(buf, charPos2, Integer.DigitOnes[r10]);
            charPos = charPos2 - 1;
            putChar(buf, charPos, Integer.DigitTens[r10]);
        }
        int q11 = i10 / 10;
        int charPos3 = charPos - 1;
        putChar(buf, charPos3, ((q11 * 10) - i10) + 48);
        if (q11 < 0) {
            charPos3--;
            putChar(buf, charPos3, 48 - q11);
        }
        if (negative) {
            int charPos4 = charPos3 - 1;
            putChar(buf, charPos4, 45);
            return charPos4;
        }
        return charPos3;
    }

    static int getChars(long i10, int index, byte[] buf) {
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
            putChar(buf, charPos2, Integer.DigitOnes[r10]);
            charPos = charPos2 - 1;
            putChar(buf, charPos, Integer.DigitTens[r10]);
        }
        int i22 = (int) i10;
        while (i22 <= -100) {
            int q22 = i22 / 100;
            int r11 = (q22 * 100) - i22;
            i22 = q22;
            int charPos3 = charPos - 1;
            putChar(buf, charPos3, Integer.DigitOnes[r11]);
            charPos = charPos3 - 1;
            putChar(buf, charPos, Integer.DigitTens[r11]);
        }
        int q23 = i22 / 10;
        int charPos4 = charPos - 1;
        putChar(buf, charPos4, ((q23 * 10) - i22) + 48);
        if (q23 < 0) {
            charPos4--;
            putChar(buf, charPos4, 48 - q23);
        }
        if (negative) {
            int charPos5 = charPos4 - 1;
            putChar(buf, charPos5, 45);
            return charPos5;
        }
        return charPos4;
    }

    public static void checkIndex(int off, byte[] val) {
        String.checkIndex(off, length(val));
    }

    public static void checkIndex(int off, String val) {
        String.checkIndex(off, length(val));
    }

    public static void checkOffset(int off, byte[] val) {
        String.checkOffset(off, length(val));
    }

    public static void checkBoundsBeginEnd(int begin, int end, byte[] val) {
        String.checkBoundsBeginEnd(begin, end, length(val));
    }

    public static void checkBoundsOffCount(int offset, int count, byte[] val) {
        String.checkBoundsOffCount(offset, count, length(val));
    }
}
