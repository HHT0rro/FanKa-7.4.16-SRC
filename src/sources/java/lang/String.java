package java.lang;

import dalvik.annotation.optimization.FastNative;
import dalvik.annotation.optimization.NeverInline;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.StringUTF16;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import libcore.util.CharsetUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class String implements Serializable, Comparable<String>, CharSequence {
    static final boolean COMPACT_STRINGS = true;
    static final byte LATIN1 = 0;
    static final byte UTF16 = 1;
    private static final long serialVersionUID = -6849794470754667710L;
    private final int count;
    private int hash;
    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[0];
    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();

    @FastNative
    private native String doRepeat(int i10);

    @FastNative
    private native String doReplace(char c4, char c10);

    @FastNative
    private native String fastSubstring(int i10, int i11);

    @FastNative
    private native void fillBytesLatin1(byte[] bArr, int i10);

    @FastNative
    private native void fillBytesUTF16(byte[] bArr, int i10);

    @Override // java.lang.CharSequence
    @FastNative
    public native char charAt(int i10);

    @Override // java.lang.Comparable
    @FastNative
    public native int compareTo(String str);

    @FastNative
    public native String concat(String str);

    @FastNative
    native void getCharsNoCheck(int i10, int i11, char[] cArr, int i12);

    @FastNative
    public native String intern();

    @FastNative
    public native char[] toCharArray();

    public String() {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(String original) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(char[] value) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(char[] value, int offset, int count) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(int[] codePoints, int offset, int count) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    @Deprecated(since = "1.1")
    public String(byte[] ascii, int hibyte, int offset, int count) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    @Deprecated(since = "1.1")
    public String(byte[] ascii, int hibyte) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, int offset, int length, String charsetName) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, int offset, int length, Charset charset) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, String charsetName) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, Charset charset) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, int offset, int length) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(StringBuffer buffer) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(StringBuilder builder) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    @Deprecated
    String(int offset, int count, char[] value) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.count >>> 1;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int codePointAt(int index) {
        checkIndex(index, length());
        return Character.codePointAt(this, index);
    }

    public int codePointBefore(int index) {
        int i10 = index - 1;
        if (i10 < 0 || i10 >= length()) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return Character.codePointBefore(this, index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > length()) {
            throw new IndexOutOfBoundsException();
        }
        return Character.codePointCount(this, beginIndex, endIndex);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        if (index < 0 || index > length()) {
            throw new IndexOutOfBoundsException();
        }
        return Character.offsetByCodePoints(this, index, codePointOffset);
    }

    void getChars(char[] dst, int dstBegin) {
        getCharsNoCheck(0, length(), dst, dstBegin);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        checkBoundsBeginEnd(srcBegin, srcEnd, length());
        if (dstBegin < 0) {
            throw new ArrayIndexOutOfBoundsException("dstBegin < 0. dstBegin=" + dstBegin);
        }
        if (dstBegin > dst.length) {
            throw new ArrayIndexOutOfBoundsException("dstBegin > dst.length. dstBegin=" + dstBegin + ", dst.length=" + dst.length);
        }
        int n10 = srcEnd - srcBegin;
        if (n10 > dst.length - dstBegin) {
            throw new ArrayIndexOutOfBoundsException("n > dst.length - dstBegin. n=" + n10 + ", dst.length=" + dst.length + "dstBegin=" + dstBegin);
        }
        getCharsNoCheck(srcBegin, srcEnd, dst, dstBegin);
    }

    @Deprecated(since = "1.1")
    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        checkBoundsBeginEnd(srcBegin, srcEnd, length());
        Objects.requireNonNull(dst);
        checkBoundsOffCount(dstBegin, srcEnd - srcBegin, dst.length);
        int j10 = dstBegin;
        for (int i10 = srcBegin; i10 < srcEnd; i10++) {
            dst[j10] = (byte) charAt(i10);
            j10++;
        }
    }

    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        if (charsetName == null) {
            throw new NullPointerException();
        }
        return getBytes(Charset.forNameUEE(charsetName));
    }

    public byte[] getBytes(Charset charset) {
        if (charset == null) {
            throw new NullPointerException();
        }
        int len = length();
        String name = charset.name();
        if ("UTF-8".equals(name)) {
            return CharsetUtils.toUtf8Bytes(this, 0, len);
        }
        if (CharEncoding.ISO_8859_1.equals(name)) {
            return CharsetUtils.toIsoLatin1Bytes(this, 0, len);
        }
        if (CharEncoding.US_ASCII.equals(name)) {
            return CharsetUtils.toAsciiBytes(this, 0, len);
        }
        if (CharEncoding.UTF_16BE.equals(name)) {
            return CharsetUtils.toBigEndianUtf16Bytes(this, 0, len);
        }
        ByteBuffer buffer = charset.encode(this);
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        return bytes;
    }

    public byte[] getBytes() {
        return getBytes(Charset.defaultCharset());
    }

    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String) anObject;
            int n10 = length();
            if (n10 == anotherString.length()) {
                int i10 = 0;
                while (true) {
                    int n11 = n10 - 1;
                    if (n10 == 0) {
                        return true;
                    }
                    if (charAt(i10) != anotherString.charAt(i10)) {
                        return false;
                    }
                    i10++;
                    n10 = n11;
                }
            }
        }
        return false;
    }

    public boolean contentEquals(StringBuffer sb2) {
        return contentEquals((CharSequence) sb2);
    }

    private boolean nonSyncContentEquals(AbstractStringBuilder sb2) {
        int len = length();
        if (len != sb2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < len; i10++) {
            if (charAt(i10) != sb2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public boolean contentEquals(CharSequence cs) {
        boolean nonSyncContentEquals;
        if (cs instanceof AbstractStringBuilder) {
            if (cs instanceof StringBuffer) {
                synchronized (cs) {
                    nonSyncContentEquals = nonSyncContentEquals((AbstractStringBuilder) cs);
                }
                return nonSyncContentEquals;
            }
            return nonSyncContentEquals((AbstractStringBuilder) cs);
        }
        if (cs instanceof String) {
            return equals(cs);
        }
        int n10 = cs.length();
        if (n10 != length()) {
            return false;
        }
        for (int i10 = 0; i10 < n10; i10++) {
            if (charAt(i10) != cs.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(String anotherString) {
        int len = length();
        if (this == anotherString) {
            return true;
        }
        return anotherString != null && anotherString.length() == len && regionMatches(true, 0, anotherString, 0, len);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class CaseInsensitiveComparator implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 8575799808933029326L;

        private CaseInsensitiveComparator() {
        }

        @Override // java.util.Comparator
        public int compare(String s12, String s2) {
            char c12;
            char c22;
            char c13;
            char c23;
            int n12 = s12.length();
            int n22 = s2.length();
            int min = Math.min(n12, n22);
            for (int i10 = 0; i10 < min; i10++) {
                char c14 = s12.charAt(i10);
                char c24 = s2.charAt(i10);
                if (c14 != c24 && (c12 = Character.toUpperCase(c14)) != (c22 = Character.toUpperCase(c24)) && (c13 = Character.toLowerCase(c12)) != (c23 = Character.toLowerCase(c22))) {
                    return c13 - c23;
                }
            }
            int i11 = n12 - n22;
            return i11;
        }

        private Object readResolve() {
            return String.CASE_INSENSITIVE_ORDER;
        }
    }

    public int compareToIgnoreCase(String str) {
        return CASE_INSENSITIVE_ORDER.compare(this, str);
    }

    public boolean regionMatches(int toffset, String other, int ooffset, int toffset2) {
        if (ooffset < 0 || toffset < 0 || toffset > length() - toffset2 || ooffset > other.length() - toffset2) {
            return false;
        }
        while (true) {
            int len = toffset2 - 1;
            if (toffset2 > 0) {
                int toffset3 = toffset + 1;
                int ooffset2 = ooffset + 1;
                if (charAt(toffset) != other.charAt(ooffset)) {
                    return false;
                }
                toffset = toffset3;
                toffset2 = len;
                ooffset = ooffset2;
            } else {
                return true;
            }
        }
    }

    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int toffset2) {
        char u12;
        char u22;
        if (!ignoreCase) {
            return regionMatches(toffset, other, ooffset, toffset2);
        }
        if (ooffset < 0 || toffset < 0 || toffset > length() - toffset2 || ooffset > other.length() - toffset2) {
            return false;
        }
        while (true) {
            int len = toffset2 - 1;
            if (toffset2 > 0) {
                int toffset3 = toffset + 1;
                char c12 = charAt(toffset);
                int ooffset2 = ooffset + 1;
                char c22 = other.charAt(ooffset);
                if (c12 != c22 && (!ignoreCase || ((u12 = Character.toUpperCase(c12)) != (u22 = Character.toUpperCase(c22)) && Character.toLowerCase(u12) != Character.toLowerCase(u22)))) {
                    break;
                }
                toffset = toffset3;
                toffset2 = len;
                ooffset = ooffset2;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix, int toffset) {
        int pc2 = prefix.length();
        if (toffset < 0 || toffset > length() - pc2) {
            return false;
        }
        int po = 0;
        while (true) {
            pc2--;
            if (pc2 >= 0) {
                int toffset2 = toffset + 1;
                int po2 = po + 1;
                if (charAt(toffset) != prefix.charAt(po)) {
                    return false;
                }
                toffset = toffset2;
                po = po2;
            } else {
                return true;
            }
        }
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    public boolean endsWith(String suffix) {
        return startsWith(suffix, length() - suffix.length());
    }

    public int hashCode() {
        int h10 = this.hash;
        int len = length();
        if (h10 == 0 && len > 0) {
            for (int i10 = 0; i10 < len; i10++) {
                h10 = (h10 * 31) + charAt(i10);
            }
            this.hash = h10;
        }
        return h10;
    }

    public int indexOf(int ch) {
        return indexOf(ch, 0);
    }

    public int indexOf(int ch, int fromIndex) {
        int max = length();
        if (fromIndex < 0) {
            fromIndex = 0;
        } else if (fromIndex >= max) {
            return -1;
        }
        if (ch < 65536) {
            for (int i10 = fromIndex; i10 < max; i10++) {
                if (charAt(i10) == ch) {
                    return i10;
                }
            }
            return -1;
        }
        return indexOfSupplementary(ch, fromIndex);
    }

    private int indexOfSupplementary(int ch, int fromIndex) {
        if (Character.isValidCodePoint(ch)) {
            char hi = Character.highSurrogate(ch);
            char lo = Character.lowSurrogate(ch);
            int max = length() - 1;
            for (int i10 = fromIndex; i10 < max; i10++) {
                if (charAt(i10) == hi && charAt(i10 + 1) == lo) {
                    return i10;
                }
            }
            return -1;
        }
        return -1;
    }

    public int lastIndexOf(int ch) {
        return lastIndexOf(ch, length() - 1);
    }

    public int lastIndexOf(int ch, int fromIndex) {
        if (ch < 65536) {
            for (int i10 = Math.min(fromIndex, length() - 1); i10 >= 0; i10--) {
                if (charAt(i10) == ch) {
                    return i10;
                }
            }
            return -1;
        }
        int i11 = lastIndexOfSupplementary(ch, fromIndex);
        return i11;
    }

    private int lastIndexOfSupplementary(int ch, int fromIndex) {
        if (Character.isValidCodePoint(ch)) {
            char hi = Character.highSurrogate(ch);
            char lo = Character.lowSurrogate(ch);
            for (int i10 = Math.min(fromIndex, length() - 2); i10 >= 0; i10--) {
                if (charAt(i10) == hi && charAt(i10 + 1) == lo) {
                    return i10;
                }
            }
            return -1;
        }
        return -1;
    }

    @NeverInline
    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    @NeverInline
    public int indexOf(String str, int fromIndex) {
        return indexOf(this, str, fromIndex);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        if (r11.charAt(r5) != r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r5 > r4) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        if (r11.charAt(r5) == r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        if (r5 > r4) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0032, code lost:
    
        r6 = r5 + 1;
        r7 = (r6 + r1) - 1;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        if (r6 >= r7) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if (r11.charAt(r6) != r12.charAt(r8)) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        r6 = r6 + 1;
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        if (r6 != r7) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004d, code lost:
    
        r5 = r5 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int indexOf(java.lang.String r11, java.lang.String r12, int r13) {
        /*
            int r0 = r11.length()
            int r1 = r12.length()
            r2 = -1
            if (r13 < r0) goto Lf
            if (r1 != 0) goto Le
            r2 = r0
        Le:
            return r2
        Lf:
            if (r13 >= 0) goto L12
            r13 = 0
        L12:
            if (r1 != 0) goto L15
            return r13
        L15:
            r3 = 0
            char r3 = r12.charAt(r3)
            int r4 = r0 - r1
            r5 = r13
        L1d:
            if (r5 > r4) goto L50
            char r6 = r11.charAt(r5)
            if (r6 == r3) goto L30
        L25:
            int r5 = r5 + 1
            if (r5 > r4) goto L30
            char r6 = r11.charAt(r5)
            if (r6 == r3) goto L30
            goto L25
        L30:
            if (r5 > r4) goto L4d
            int r6 = r5 + 1
            int r7 = r6 + r1
            int r7 = r7 + (-1)
            r8 = 1
        L39:
            if (r6 >= r7) goto L4a
            char r9 = r11.charAt(r6)
            char r10 = r12.charAt(r8)
            if (r9 != r10) goto L4a
            int r6 = r6 + 1
            int r8 = r8 + 1
            goto L39
        L4a:
            if (r6 != r7) goto L4d
            return r5
        L4d:
            int r5 = r5 + 1
            goto L1d
        L50:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.String.indexOf(java.lang.String, java.lang.String, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int indexOf(byte[] src, byte srcCoder, int srcCount, String tgtStr, int fromIndex) {
        byte tgtCoder = tgtStr.coder();
        int tgtCount = tgtStr.length();
        if (fromIndex >= srcCount) {
            if (tgtCount == 0) {
                return srcCount;
            }
            return -1;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (tgtCount == 0) {
            return fromIndex;
        }
        if (tgtCount > srcCount) {
            return -1;
        }
        if (srcCoder == tgtCoder) {
            if (srcCoder == 0) {
                return StringLatin1.indexOf(src, srcCount, tgtStr, tgtCount, fromIndex);
            }
            return StringUTF16.indexOf(src, srcCount, tgtStr, tgtCount, fromIndex);
        }
        if (srcCoder == 0) {
            return -1;
        }
        return StringUTF16.indexOfLatin1(src, srcCount, tgtStr, tgtCount, fromIndex);
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, length());
    }

    public int lastIndexOf(String str, int fromIndex) {
        return lastIndexOf(this, str, fromIndex);
    }

    private static int lastIndexOf(String source, String target, int fromIndex) {
        int sourceLength = source.length();
        int targetLength = target.length();
        int rightIndex = sourceLength - targetLength;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        if (targetLength == 0) {
            return fromIndex;
        }
        int strLastIndex = targetLength - 1;
        char strLastChar = target.charAt(strLastIndex);
        int min = targetLength - 1;
        int i10 = min + fromIndex;
        while (true) {
            if (i10 >= min && source.charAt(i10) != strLastChar) {
                i10--;
            } else {
                if (i10 < min) {
                    return -1;
                }
                int j10 = i10 - 1;
                int start = j10 - (targetLength - 1);
                int k10 = strLastIndex - 1;
                while (j10 > start) {
                    int j11 = j10 - 1;
                    int k11 = k10 - 1;
                    if (source.charAt(j10) == target.charAt(k10)) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int lastIndexOf(byte[] src, byte srcCoder, int srcCount, String tgtStr, int fromIndex) {
        byte tgtCoder = tgtStr.coder();
        int tgtCount = tgtStr.length();
        int rightIndex = srcCount - tgtCount;
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        if (fromIndex < 0) {
            return -1;
        }
        if (tgtCount == 0) {
            return fromIndex;
        }
        if (srcCoder == tgtCoder) {
            if (srcCoder == 0) {
                return StringLatin1.lastIndexOf(src, srcCount, tgtStr, tgtCount, fromIndex);
            }
            return StringUTF16.lastIndexOf(src, srcCount, tgtStr, tgtCount, fromIndex);
        }
        if (srcCoder == 0) {
            return -1;
        }
        return StringUTF16.lastIndexOfLatin1(src, srcCount, tgtStr, tgtCount, fromIndex);
    }

    static int lastIndexOf(char[] source, int sourceOffset, int sourceCount, char[] target, int targetOffset, int targetCount, int fromIndex) {
        int fromIndex2 = fromIndex;
        int rightIndex = sourceCount - targetCount;
        if (fromIndex2 < 0) {
            return -1;
        }
        if (fromIndex2 > rightIndex) {
            fromIndex2 = rightIndex;
        }
        if (targetCount == 0) {
            return fromIndex2;
        }
        int strLastIndex = (targetOffset + targetCount) - 1;
        char strLastChar = target[strLastIndex];
        int min = (sourceOffset + targetCount) - 1;
        int i10 = min + fromIndex2;
        while (true) {
            if (i10 >= min && source[i10] != strLastChar) {
                i10--;
            } else {
                if (i10 < min) {
                    return -1;
                }
                int j10 = i10 - 1;
                int start = j10 - (targetCount - 1);
                int k10 = strLastIndex - 1;
                while (j10 > start) {
                    int j11 = j10 - 1;
                    int k11 = k10 - 1;
                    if (source[j10] == target[k10]) {
                        j10 = j11;
                        k10 = k11;
                    } else {
                        i10--;
                    }
                }
                return (start - sourceOffset) + 1;
            }
        }
    }

    public String substring(int beginIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(this, beginIndex);
        }
        int subLen = length() - beginIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(this, beginIndex);
        }
        if (beginIndex == 0) {
            return this;
        }
        return fastSubstring(beginIndex, subLen);
    }

    public String substring(int beginIndex, int endIndex) {
        int length = length();
        checkBoundsBeginEnd(beginIndex, endIndex, length);
        int subLen = endIndex - beginIndex;
        if (beginIndex == 0 && endIndex == length) {
            return this;
        }
        return fastSubstring(beginIndex, subLen);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int beginIndex, int endIndex) {
        return substring(beginIndex, endIndex);
    }

    public String replace(char oldChar, char newChar) {
        if (oldChar != newChar) {
            int len = length();
            for (int i10 = 0; i10 < len; i10++) {
                if (charAt(i10) == oldChar) {
                    return doReplace(oldChar, newChar);
                }
            }
        }
        return this;
    }

    public boolean matches(String regex) {
        return Pattern.matches(regex, this);
    }

    public boolean contains(CharSequence s2) {
        return indexOf(s2.toString()) >= 0;
    }

    public String replaceFirst(String regex, String replacement) {
        return Pattern.compile(regex).matcher(this).replaceFirst(replacement);
    }

    public String replaceAll(String regex, String replacement) {
        return Pattern.compile(regex).matcher(this).replaceAll(replacement);
    }

    public String replace(CharSequence target, CharSequence replacement) {
        int indexOf;
        Objects.requireNonNull(target);
        Objects.requireNonNull(replacement);
        String tgtStr = target.toString();
        String replStr = replacement.toString();
        int j10 = indexOf(tgtStr);
        if (j10 < 0) {
            return this;
        }
        int tgtLen = tgtStr.length();
        int tgtLen1 = Math.max(tgtLen, 1);
        int thisLen = length();
        int newLenHint = (thisLen - tgtLen) + replStr.length();
        if (newLenHint < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(newLenHint);
        int i10 = 0;
        do {
            sb2.append((CharSequence) this, i10, j10).append(replStr);
            i10 = j10 + tgtLen;
            if (j10 >= thisLen) {
                break;
            }
            indexOf = indexOf(tgtStr, j10 + tgtLen1);
            j10 = indexOf;
        } while (indexOf > 0);
        return sb2.append((CharSequence) this, i10, thisLen).toString();
    }

    public String[] split(String regex, int limit) {
        String[] fast = Pattern.fastSplit(regex, this, limit);
        if (fast != null) {
            return fast;
        }
        return Pattern.compile(regex).split(this, limit);
    }

    public String[] split(String regex) {
        return split(regex, 0);
    }

    public static String join(CharSequence delimiter, CharSequence... elements) {
        Objects.requireNonNull(delimiter);
        Objects.requireNonNull(elements);
        StringJoiner joiner = new StringJoiner(delimiter);
        for (CharSequence cs : elements) {
            joiner.add(cs);
        }
        return joiner.toString();
    }

    public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
        Objects.requireNonNull(delimiter);
        Objects.requireNonNull(elements);
        StringJoiner joiner = new StringJoiner(delimiter);
        for (CharSequence cs : elements) {
            joiner.add(cs);
        }
        return joiner.toString();
    }

    public String toLowerCase(Locale locale) {
        return CaseMapper.toLowerCase(locale, this);
    }

    public String toLowerCase() {
        return toLowerCase(Locale.getDefault());
    }

    public String toUpperCase(Locale locale) {
        return CaseMapper.toUpperCase(locale, this, length());
    }

    public String toUpperCase() {
        return toUpperCase(Locale.getDefault());
    }

    public String trim() {
        int len = length();
        int st = 0;
        while (st < len && charAt(st) <= ' ') {
            st++;
        }
        while (st < len && charAt(len - 1) <= ' ') {
            len--;
        }
        return (st > 0 || len < length()) ? substring(st, len) : this;
    }

    public String strip() {
        String ret = StringUTF16.strip(this);
        return ret == null ? this : ret;
    }

    public String stripLeading() {
        String ret = StringUTF16.stripLeading(this);
        return ret == null ? this : ret;
    }

    public String stripTrailing() {
        String ret = StringUTF16.stripTrailing(this);
        return ret == null ? this : ret;
    }

    public boolean isBlank() {
        return indexOfNonWhitespace() == length();
    }

    public Stream<String> lines() {
        return StringUTF16.lines(this);
    }

    public String indent(final int n10) {
        if (isEmpty()) {
            return "";
        }
        Stream<String> stream = lines();
        if (n10 > 0) {
            final String spaces = " ".repeat(n10);
            stream = stream.map(new Function() { // from class: java.lang.String$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return String.lambda$indent$0(String.this, (String) obj);
                }
            });
        } else if (n10 == Integer.MIN_VALUE) {
            stream = stream.map(new Function() { // from class: java.lang.String$$ExternalSyntheticLambda2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    String stripLeading;
                    stripLeading = ((String) obj).stripLeading();
                    return stripLeading;
                }
            });
        } else if (n10 < 0) {
            stream = stream.map(new Function() { // from class: java.lang.String$$ExternalSyntheticLambda3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    String substring;
                    substring = r2.substring(Math.min(-n10, ((String) obj).indexOfNonWhitespace()));
                    return substring;
                }
            });
        }
        return (String) stream.collect(Collectors.joining("\n", "", "\n"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$indent$0(String spaces, String s2) {
        return spaces + s2;
    }

    private int indexOfNonWhitespace() {
        return StringUTF16.indexOfNonWhitespace(this);
    }

    private int lastIndexOfNonWhitespace() {
        return StringUTF16.lastIndexOfNonWhitespace(this);
    }

    public String stripIndent() {
        CharSequence charSequence;
        int length = length();
        if (length == 0) {
            return "";
        }
        char lastChar = charAt(length - 1);
        boolean optOut = lastChar == '\n' || lastChar == '\r';
        List<String> lines = lines().toList();
        final int outdent = optOut ? 0 : outdent(lines);
        Stream<R> map = lines.stream().map(new Function() { // from class: java.lang.String$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return String.lambda$stripIndent$3(outdent, (String) obj);
            }
        });
        if (!optOut) {
            charSequence = "";
        } else {
            charSequence = "\n";
        }
        return (String) map.collect(Collectors.joining("\n", "", charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$stripIndent$3(int outdent, String line) {
        int firstNonWhitespace = line.indexOfNonWhitespace();
        int lastNonWhitespace = line.lastIndexOfNonWhitespace();
        int incidentalWhitespace = Math.min(outdent, firstNonWhitespace);
        return firstNonWhitespace > lastNonWhitespace ? "" : line.substring(incidentalWhitespace, lastNonWhitespace);
    }

    private static int outdent(List<String> lines) {
        int outdent = Integer.MAX_VALUE;
        for (String line : lines) {
            int leadingWhitespace = line.indexOfNonWhitespace();
            if (leadingWhitespace != line.length()) {
                outdent = Integer.min(outdent, leadingWhitespace);
            }
        }
        String lastLine = lines.get(lines.size() - 1);
        if (lastLine.isBlank()) {
            return Integer.min(outdent, lastLine.length());
        }
        return outdent;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0026. Please report as an issue. */
    public String translateEscapes() {
        int from;
        char c4;
        if (isEmpty()) {
            return "";
        }
        char[] chars = toCharArray();
        int length = chars.length;
        int from2 = 0;
        int to = 0;
        while (from2 < length) {
            int from3 = from2 + 1;
            char ch = chars[from2];
            if (ch != '\\') {
                from = from3;
            } else {
                if (from3 < length) {
                    from = from3 + 1;
                    c4 = chars[from3];
                } else {
                    c4 = 0;
                    from = from3;
                }
                ch = c4;
                switch (ch) {
                    case '\n':
                        from2 = from;
                    case '\r':
                        if (from < length && chars[from] == '\n') {
                            from2 = from + 1;
                        }
                        from2 = from;
                        break;
                    case '\"':
                    case '\'':
                    case '\\':
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                        int limit = Integer.min((ch <= '3' ? 2 : 1) + from, length);
                        int code = ch - '0';
                        while (from < limit) {
                            char ch2 = chars[from];
                            if (ch2 >= '0' && '7' >= ch2) {
                                from++;
                                code = (code << 3) | (ch2 - '0');
                            }
                            ch = (char) code;
                            break;
                        }
                        ch = (char) code;
                        break;
                    case 'b':
                        ch = '\b';
                        break;
                    case 'f':
                        ch = '\f';
                        break;
                    case 'n':
                        ch = '\n';
                        break;
                    case 'r':
                        ch = CharUtils.CR;
                        break;
                    case 's':
                        ch = ' ';
                        break;
                    case 't':
                        ch = '\t';
                        break;
                    default:
                        String msg = format("Invalid escape sequence: \\%c \\\\u%04X", Character.valueOf(ch), Integer.valueOf(ch));
                        throw new IllegalArgumentException(msg);
                }
            }
            int from4 = to + 1;
            chars[to] = ch;
            from2 = from;
            to = from4;
        }
        return new String(chars, 0, to);
    }

    public <R> R transform(Function<? super String, ? extends R> f10) {
        return f10.apply(this);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this;
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return StreamSupport.intStream(new StringUTF16.CharsSpliteratorForString(this, 1024), false);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return StreamSupport.intStream(new StringUTF16.CodePointsSpliteratorForString(this, 1024), false);
    }

    public static String format(String format, Object... args) {
        return new Formatter().format(format, args).toString();
    }

    public static String format(Locale l10, String format, Object... args) {
        return new Formatter(l10).format(format, args).toString();
    }

    public String formatted(Object... args) {
        return new Formatter().format(this, args).toString();
    }

    public static String valueOf(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    public static String valueOf(char[] data) {
        return new String(data);
    }

    public static String valueOf(char[] data, int offset, int count) {
        return new String(data, offset, count);
    }

    public static String copyValueOf(char[] data, int offset, int count) {
        return new String(data, offset, count);
    }

    public static String copyValueOf(char[] data) {
        return new String(data);
    }

    public static String valueOf(boolean b4) {
        return b4 ? "true" : "false";
    }

    public static String valueOf(char c4) {
        return StringFactory.newStringFromChars(0, 1, new char[]{c4});
    }

    public static String valueOf(int i10) {
        return Integer.toString(i10);
    }

    public static String valueOf(long l10) {
        return Long.toString(l10);
    }

    public static String valueOf(float f10) {
        return Float.toString(f10);
    }

    public static String valueOf(double d10) {
        return Double.toString(d10);
    }

    public String repeat(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count is negative: " + count);
        }
        if (count == 1) {
            return this;
        }
        int len = length();
        if (len == 0 || count == 0) {
            return "";
        }
        if (Integer.MAX_VALUE / count < len) {
            throw new OutOfMemoryError("Repeating " + len + " bytes String " + count + " times will produce a String exceeding maximum size.");
        }
        return doRepeat(count);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getBytes(byte[] dst, int dstBegin, byte coder) {
        if (coder == 1) {
            int fromIndex = dstBegin << 1;
            checkBoundsOffCount(fromIndex, length() << 1, dst.length);
            fillBytesUTF16(dst, fromIndex);
        } else {
            if (coder() != 0) {
                throw new StringIndexOutOfBoundsException("Expect Latin-1 coder.");
            }
            checkBoundsOffCount(dstBegin, length(), dst.length);
            fillBytesLatin1(dst, dstBegin);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String(byte[] value, byte coder) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte coder() {
        return (byte) (this.count & 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkIndex(int index, int length) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException("index " + index + ",length " + length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkOffset(int offset, int length) {
        if (offset < 0 || offset > length) {
            throw new StringIndexOutOfBoundsException("offset " + offset + ",length " + length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkBoundsOffCount(int offset, int count, int length) {
        if (offset < 0 || count < 0 || offset > length - count) {
            throw new StringIndexOutOfBoundsException("offset " + offset + ", count " + count + ", length " + length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkBoundsBeginEnd(int begin, int end, int length) {
        if (begin < 0 || begin > end || end > length) {
            throw new StringIndexOutOfBoundsException("begin " + begin + ", end " + end + ", length " + length);
        }
    }
}
