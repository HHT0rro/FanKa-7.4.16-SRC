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
public final class StringLatin1 {
    StringLatin1() {
    }

    public static char charAt(byte[] value, int index) {
        if (index < 0 || index >= value.length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return (char) (value[index] & 255);
    }

    public static boolean canEncode(int cp) {
        return (cp >>> 8) == 0;
    }

    public static int length(byte[] value) {
        return value.length;
    }

    public static int codePointAt(byte[] value, int index, int end) {
        return value[index] & 255;
    }

    public static int codePointBefore(byte[] value, int index) {
        return value[index - 1] & 255;
    }

    public static int codePointCount(byte[] value, int beginIndex, int endIndex) {
        return endIndex - beginIndex;
    }

    public static char[] toChars(byte[] value) {
        char[] dst = new char[value.length];
        inflate(value, 0, dst, 0, value.length);
        return dst;
    }

    public static byte[] inflate(byte[] value, int off, int len) {
        byte[] ret = StringUTF16.newBytesFor(len);
        inflate(value, off, ret, 0, len);
        return ret;
    }

    public static void getChars(byte[] value, int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        inflate(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);
    }

    public static void getBytes(byte[] value, int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        System.arraycopy((Object) value, srcBegin, (Object) dst, dstBegin, srcEnd - srcBegin);
    }

    public static boolean equals(byte[] value, byte[] other) {
        if (value.length != other.length) {
            return false;
        }
        for (int i10 = 0; i10 < value.length; i10++) {
            if (value[i10] != other[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int compareTo(byte[] value, byte[] other) {
        int len1 = value.length;
        int len2 = other.length;
        return compareTo(value, other, len1, len2);
    }

    public static int compareTo(byte[] value, byte[] other, int len1, int len2) {
        int lim = Math.min(len1, len2);
        for (int k10 = 0; k10 < lim; k10++) {
            if (value[k10] != other[k10]) {
                return getChar(value, k10) - getChar(other, k10);
            }
        }
        int k11 = len1 - len2;
        return k11;
    }

    public static int compareToUTF16(byte[] value, byte[] other) {
        int len1 = length(value);
        int len2 = StringUTF16.length(other);
        return compareToUTF16Values(value, other, len1, len2);
    }

    public static int compareToUTF16(byte[] value, byte[] other, int len1, int len2) {
        String.checkOffset(len1, length(value));
        String.checkOffset(len2, StringUTF16.length(other));
        return compareToUTF16Values(value, other, len1, len2);
    }

    private static int compareToUTF16Values(byte[] value, byte[] other, int len1, int len2) {
        int lim = Math.min(len1, len2);
        for (int k10 = 0; k10 < lim; k10++) {
            char c12 = getChar(value, k10);
            char c22 = StringUTF16.getChar(other, k10);
            if (c12 != c22) {
                return c12 - c22;
            }
        }
        int k11 = len1 - len2;
        return k11;
    }

    public static int compareToCI(byte[] value, byte[] other) {
        char c12;
        char c22;
        char c13;
        char c23;
        int len1 = value.length;
        int len2 = other.length;
        int lim = Math.min(len1, len2);
        for (int k10 = 0; k10 < lim; k10++) {
            if (value[k10] != other[k10] && (c12 = Character.toUpperCase(getChar(value, k10))) != (c22 = Character.toUpperCase(getChar(other, k10))) && (c13 = Character.toLowerCase(c12)) != (c23 = Character.toLowerCase(c22))) {
                return c13 - c23;
            }
        }
        int k11 = len1 - len2;
        return k11;
    }

    public static int compareToCI_UTF16(byte[] value, byte[] other) {
        char c12;
        char c22;
        char c13;
        char c23;
        int len1 = length(value);
        int len2 = StringUTF16.length(other);
        int lim = Math.min(len1, len2);
        for (int k10 = 0; k10 < lim; k10++) {
            char c14 = getChar(value, k10);
            char c24 = StringUTF16.getChar(other, k10);
            if (c14 != c24 && (c12 = Character.toUpperCase(c14)) != (c22 = Character.toUpperCase(c24)) && (c13 = Character.toLowerCase(c12)) != (c23 = Character.toLowerCase(c22))) {
                return c13 - c23;
            }
        }
        int k11 = len1 - len2;
        return k11;
    }

    public static int hashCode(byte[] value) {
        int h10 = 0;
        for (byte v2 : value) {
            h10 = (h10 * 31) + (v2 & 255);
        }
        return h10;
    }

    public static int indexOf(byte[] value, int ch, int fromIndex) {
        if (!canEncode(ch)) {
            return -1;
        }
        int max = value.length;
        if (fromIndex < 0) {
            fromIndex = 0;
        } else if (fromIndex >= max) {
            return -1;
        }
        byte c4 = (byte) ch;
        for (int i10 = fromIndex; i10 < max; i10++) {
            if (value[i10] == c4) {
                return i10;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        if (r2 > r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        r3 = r2 + 1;
        r4 = (r3 + r11) - 1;
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        if (r3 >= r4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r8[r3] != ((byte) r10.charAt(r5))) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        r3 = r3 + 1;
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        if (r3 != r4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (r8[r2] != r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r2 > r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r8[r2] == r0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(byte[] r8, int r9, java.lang.String r10, int r11, int r12) {
        /*
            r0 = 0
            char r0 = r10.charAt(r0)
            byte r0 = (byte) r0
            int r1 = r9 - r11
            r2 = r12
        L9:
            if (r2 > r1) goto L37
            r3 = r8[r2]
            if (r3 == r0) goto L18
        Lf:
            int r2 = r2 + 1
            if (r2 > r1) goto L18
            r3 = r8[r2]
            if (r3 == r0) goto L18
            goto Lf
        L18:
            if (r2 > r1) goto L34
            int r3 = r2 + 1
            int r4 = r3 + r11
            int r4 = r4 + (-1)
            r5 = 1
        L21:
            if (r3 >= r4) goto L31
            r6 = r8[r3]
            char r7 = r10.charAt(r5)
            byte r7 = (byte) r7
            if (r6 != r7) goto L31
            int r3 = r3 + 1
            int r5 = r5 + 1
            goto L21
        L31:
            if (r3 != r4) goto L34
            return r2
        L34:
            int r2 = r2 + 1
            goto L9
        L37:
            r2 = -1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.StringLatin1.indexOf(byte[], int, java.lang.String, int, int):int");
    }

    public static int lastIndexOf(byte[] src, int srcCount, String tgt, int tgtCount, int fromIndex) {
        int min = tgtCount - 1;
        int i10 = min + fromIndex;
        int strLastIndex = tgtCount - 1;
        char strLastChar = tgt.charAt(strLastIndex);
        while (true) {
            if (i10 >= min && (src[i10] & 255) != strLastChar) {
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
                    if ((src[j10] & 255) == (tgt.charAt(k10) & 255)) {
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
        if (!canEncode(ch)) {
            return -1;
        }
        for (int off = Math.min(fromIndex, value.length - 1); off >= 0; off--) {
            if (value[off] == ((byte) ch)) {
                return off;
            }
        }
        return -1;
    }

    public static String trim(byte[] value) {
        int len = value.length;
        int st = 0;
        while (st < len && (value[st] & 255) <= 32) {
            st++;
        }
        while (st < len && (value[len - 1] & 255) <= 32) {
            len--;
        }
        if (st > 0 || len < value.length) {
            return newString(value, st, len - st);
        }
        return null;
    }

    public static int indexOfNonWhitespace(byte[] value) {
        int length = value.length;
        int left = 0;
        while (left < length) {
            char ch = (char) (value[left] & 255);
            if (ch != ' ' && ch != '\t' && !Character.isWhitespace(ch)) {
                break;
            }
            left++;
        }
        return left;
    }

    public static int lastIndexOfNonWhitespace(byte[] value) {
        int length = value.length;
        int right = length;
        while (right > 0) {
            char ch = (char) (value[right - 1] & 255);
            if (ch != ' ' && ch != '\t' && !Character.isWhitespace(ch)) {
                break;
            }
            right--;
        }
        return right;
    }

    public static String strip(byte[] value) {
        int left = indexOfNonWhitespace(value);
        if (left == value.length) {
            return "";
        }
        int right = lastIndexOfNonWhitespace(value);
        if (left > 0 || right < value.length) {
            return newString(value, left, right - left);
        }
        return null;
    }

    public static String stripLeading(byte[] value) {
        int left = indexOfNonWhitespace(value);
        if (left == value.length) {
            return "";
        }
        if (left != 0) {
            return newString(value, left, value.length - left);
        }
        return null;
    }

    public static String stripTrailing(byte[] value) {
        int right = lastIndexOfNonWhitespace(value);
        if (right == 0) {
            return "";
        }
        if (right != value.length) {
            return newString(value, 0, right);
        }
        return null;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class LinesSpliterator implements Spliterator<String> {
        private final int fence;
        private int index;
        private byte[] value;

        LinesSpliterator(byte[] value) {
            this(value, 0, value.length);
        }

        LinesSpliterator(byte[] value, int start, int length) {
            this.value = value;
            this.index = start;
            this.fence = start + length;
        }

        private int indexOfLineSeparator(int start) {
            int current = start;
            while (true) {
                int i10 = this.fence;
                if (current < i10) {
                    byte ch = this.value[current];
                    if (ch == 10 || ch == 13) {
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
                byte[] bArr = this.value;
                if (bArr[start] == 13 && (next = start + 1) < i10 && bArr[next] == 10) {
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
            return StringLatin1.newString(this.value, start, end - start);
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

    static Stream<String> lines(byte[] value) {
        return StreamSupport.stream(new LinesSpliterator(value), false);
    }

    public static void putChar(byte[] val, int index, int c4) {
        val[index] = (byte) c4;
    }

    public static char getChar(byte[] val, int index) {
        return (char) (val[index] & 255);
    }

    public static byte[] toBytes(int[] val, int off, int len) {
        byte[] ret = new byte[len];
        int i10 = 0;
        while (i10 < len) {
            int off2 = off + 1;
            int cp = val[off];
            if (!canEncode(cp)) {
                return null;
            }
            ret[i10] = (byte) cp;
            i10++;
            off = off2;
        }
        return ret;
    }

    public static byte[] toBytes(char c4) {
        return new byte[]{(byte) c4};
    }

    public static String newString(byte[] val, int index, int len) {
        return new String(val, 0, index, len);
    }

    public static void fillNull(byte[] val, int index, int end) {
        Arrays.fill(val, index, end, (byte) 0);
    }

    public static void inflate(byte[] src, int srcOff, char[] dst, int dstOff, int len) {
        int i10 = 0;
        while (i10 < len) {
            dst[dstOff] = (char) (src[srcOff] & 255);
            i10++;
            dstOff++;
            srcOff++;
        }
    }

    public static void inflate(byte[] src, int srcOff, byte[] dst, int dstOff, int len) {
        StringUTF16.inflate(src, srcOff, dst, dstOff, len);
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
            this(array, 0, array.length, acs);
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
            int length = a10.length;
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
                        action.accept(a10[i11] & 255);
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
                byte[] bArr = this.array;
                this.index = i10 + 1;
                action.accept(bArr[i10] & 255);
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
}
