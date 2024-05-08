package java.lang;

import dalvik.annotation.optimization.NeverInline;
import java.io.ObjectStreamConstants;
import java.lang.StringLatin1;
import java.lang.StringUTF16;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;
import jdk.internal.math.FloatingDecimal;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractStringBuilder implements Appendable, CharSequence {
    private static final byte[] EMPTYVALUE = new byte[0];
    private static final int MAX_ARRAY_SIZE = 2147483639;
    byte coder;
    int count;
    byte[] value;

    @Override // java.lang.CharSequence
    public abstract String toString();

    AbstractStringBuilder() {
        this.value = EMPTYVALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractStringBuilder(int capacity) {
        this.value = new byte[capacity];
        this.coder = (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int compareTo(AbstractStringBuilder another) {
        if (this == another) {
            return 0;
        }
        byte[] val1 = this.value;
        byte[] val2 = another.value;
        int count1 = this.count;
        int count2 = another.count;
        return this.coder == another.coder ? isLatin1() ? StringLatin1.compareTo(val1, val2, count1, count2) : StringUTF16.compareTo(val1, val2, count1, count2) : isLatin1() ? StringLatin1.compareToUTF16(val1, val2, count1, count2) : StringUTF16.compareToLatin1(val1, val2, count1, count2);
    }

    @Override // java.lang.CharSequence
    @NeverInline
    public int length() {
        return this.count;
    }

    public int capacity() {
        return this.value.length >> this.coder;
    }

    public void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity > 0) {
            ensureCapacityInternal(minimumCapacity);
        }
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        byte[] bArr = this.value;
        int oldCapacity = bArr.length >> this.coder;
        if (minimumCapacity - oldCapacity > 0) {
            this.value = Arrays.copyOf(bArr, newCapacity(minimumCapacity) << this.coder);
        }
    }

    private int newCapacity(int minCapacity) {
        int length = this.value.length;
        byte b4 = this.coder;
        int oldCapacity = length >> b4;
        int newCapacity = (oldCapacity << 1) + 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        int SAFE_BOUND = 2147483639 >> b4;
        if (newCapacity <= 0 || SAFE_BOUND - newCapacity < 0) {
            return hugeCapacity(minCapacity);
        }
        return newCapacity;
    }

    private int hugeCapacity(int minCapacity) {
        byte b4 = this.coder;
        int SAFE_BOUND = 2147483639 >> b4;
        int UNSAFE_BOUND = 2147483647 >> b4;
        if (UNSAFE_BOUND - minCapacity >= 0) {
            return minCapacity > SAFE_BOUND ? minCapacity : SAFE_BOUND;
        }
        throw new OutOfMemoryError();
    }

    private void inflate() {
        if (!isLatin1()) {
            return;
        }
        byte[] buf = StringUTF16.newBytesFor(this.value.length);
        StringLatin1.inflate(this.value, 0, buf, 0, this.count);
        this.value = buf;
        this.coder = (byte) 1;
    }

    public void trimToSize() {
        int length = this.count << this.coder;
        byte[] bArr = this.value;
        if (length < bArr.length) {
            this.value = Arrays.copyOf(bArr, length);
        }
    }

    public void setLength(int newLength) {
        if (newLength < 0) {
            throw new StringIndexOutOfBoundsException(newLength);
        }
        ensureCapacityInternal(newLength);
        if (this.count < newLength) {
            if (isLatin1()) {
                StringLatin1.fillNull(this.value, this.count, newLength);
            } else {
                StringUTF16.fillNull(this.value, this.count, newLength);
            }
        }
        this.count = newLength;
    }

    @Override // java.lang.CharSequence
    public char charAt(int index) {
        String.checkIndex(index, this.count);
        if (isLatin1()) {
            return (char) (this.value[index] & 255);
        }
        return StringUTF16.charAt(this.value, index);
    }

    public int codePointAt(int index) {
        int count = this.count;
        byte[] value = this.value;
        String.checkIndex(index, count);
        if (isLatin1()) {
            return value[index] & 255;
        }
        return StringUTF16.codePointAtSB(value, index, count);
    }

    public int codePointBefore(int index) {
        int i10 = index - 1;
        if (i10 < 0 || i10 >= this.count) {
            throw new StringIndexOutOfBoundsException(index);
        }
        if (isLatin1()) {
            return this.value[i10] & 255;
        }
        return StringUTF16.codePointBeforeSB(this.value, index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > this.count || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        if (isLatin1()) {
            return endIndex - beginIndex;
        }
        return StringUTF16.codePointCountSB(this.value, beginIndex, endIndex);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        if (index < 0 || index > this.count) {
            throw new IndexOutOfBoundsException();
        }
        return Character.offsetByCodePoints(this, index, codePointOffset);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        checkRangeSIOOBE(srcBegin, srcEnd, this.count);
        int n10 = srcEnd - srcBegin;
        checkRange(dstBegin, dstBegin + n10, dst.length);
        if (isLatin1()) {
            StringLatin1.getChars(this.value, srcBegin, srcEnd, dst, dstBegin);
        } else {
            StringUTF16.getChars(this.value, srcBegin, srcEnd, dst, dstBegin);
        }
    }

    public void setCharAt(int index, char ch) {
        String.checkIndex(index, this.count);
        if (isLatin1() && StringLatin1.canEncode(ch)) {
            this.value[index] = (byte) ch;
            return;
        }
        if (isLatin1()) {
            inflate();
        }
        StringUTF16.putCharSB(this.value, index, ch);
    }

    public AbstractStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public AbstractStringBuilder append(String str) {
        if (str == null) {
            return appendNull();
        }
        int len = str.length();
        ensureCapacityInternal(this.count + len);
        putStringAt(this.count, str);
        this.count += len;
        return this;
    }

    public AbstractStringBuilder append(StringBuffer sb2) {
        return append((AbstractStringBuilder) sb2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractStringBuilder append(AbstractStringBuilder asb) {
        if (asb == null) {
            return appendNull();
        }
        int len = asb.length();
        ensureCapacityInternal(this.count + len);
        if (getCoder() != asb.getCoder()) {
            inflate();
        }
        asb.getBytes(this.value, this.count, this.coder);
        this.count += len;
        return this;
    }

    @Override // java.lang.Appendable
    public AbstractStringBuilder append(CharSequence s2) {
        if (s2 == null) {
            return appendNull();
        }
        if (s2 instanceof String) {
            return append((String) s2);
        }
        if (s2 instanceof AbstractStringBuilder) {
            return append((AbstractStringBuilder) s2);
        }
        return append(s2, 0, s2.length());
    }

    private AbstractStringBuilder appendNull() {
        int count;
        ensureCapacityInternal(this.count + 4);
        int count2 = this.count;
        byte[] val = this.value;
        if (isLatin1()) {
            int count3 = count2 + 1;
            val[count2] = 110;
            int count4 = count3 + 1;
            val[count3] = ObjectStreamConstants.TC_ARRAY;
            int count5 = count4 + 1;
            val[count4] = 108;
            count = count5 + 1;
            val[count5] = 108;
        } else {
            count = StringUTF16.putCharsAt(val, count2, 'n', 'u', 'l', 'l');
        }
        this.count = count;
        return this;
    }

    @Override // java.lang.Appendable
    public AbstractStringBuilder append(CharSequence s2, int start, int end) {
        if (s2 == null) {
            s2 = "null";
        }
        checkRange(start, end, s2.length());
        int len = end - start;
        ensureCapacityInternal(this.count + len);
        appendChars(s2, start, end);
        return this;
    }

    public AbstractStringBuilder append(char[] str) {
        int len = str.length;
        ensureCapacityInternal(this.count + len);
        appendChars(str, 0, len);
        return this;
    }

    public AbstractStringBuilder append(char[] str, int offset, int len) {
        int end = offset + len;
        checkRange(offset, end, str.length);
        ensureCapacityInternal(this.count + len);
        appendChars(str, offset, end);
        return this;
    }

    public AbstractStringBuilder append(boolean b4) {
        int count;
        ensureCapacityInternal(this.count + (b4 ? 4 : 5));
        int count2 = this.count;
        byte[] val = this.value;
        if (isLatin1()) {
            if (b4) {
                int count3 = count2 + 1;
                val[count2] = ObjectStreamConstants.TC_STRING;
                int count4 = count3 + 1;
                val[count3] = ObjectStreamConstants.TC_CLASSDESC;
                int count5 = count4 + 1;
                val[count4] = ObjectStreamConstants.TC_ARRAY;
                count = count5 + 1;
                val[count5] = 101;
            } else {
                int count6 = count2 + 1;
                val[count2] = 102;
                int count7 = count6 + 1;
                val[count6] = 97;
                int count8 = count7 + 1;
                val[count7] = 108;
                int count9 = count8 + 1;
                val[count8] = ObjectStreamConstants.TC_OBJECT;
                val[count9] = 101;
                count = count9 + 1;
            }
        } else if (b4) {
            count = StringUTF16.putCharsAt(val, count2, 't', 'r', 'u', 'e');
        } else {
            count = StringUTF16.putCharsAt(val, count2, 'f', 'a', 'l', 's', 'e');
        }
        this.count = count;
        return this;
    }

    @Override // java.lang.Appendable
    public AbstractStringBuilder append(char c4) {
        ensureCapacityInternal(this.count + 1);
        if (isLatin1() && StringLatin1.canEncode(c4)) {
            byte[] bArr = this.value;
            int i10 = this.count;
            this.count = i10 + 1;
            bArr[i10] = (byte) c4;
        } else {
            if (isLatin1()) {
                inflate();
            }
            byte[] bArr2 = this.value;
            int i11 = this.count;
            this.count = i11 + 1;
            StringUTF16.putCharSB(bArr2, i11, c4);
        }
        return this;
    }

    public AbstractStringBuilder append(int i10) {
        int count = this.count;
        int spaceNeeded = Integer.stringSize(i10) + count;
        ensureCapacityInternal(spaceNeeded);
        if (isLatin1()) {
            Integer.getChars(i10, spaceNeeded, this.value);
        } else {
            StringUTF16.getChars(i10, count, spaceNeeded, this.value);
        }
        this.count = spaceNeeded;
        return this;
    }

    public AbstractStringBuilder append(long l10) {
        int count = this.count;
        int spaceNeeded = Long.stringSize(l10) + count;
        ensureCapacityInternal(spaceNeeded);
        if (isLatin1()) {
            Long.getChars(l10, spaceNeeded, this.value);
        } else {
            StringUTF16.getChars(l10, count, spaceNeeded, this.value);
        }
        this.count = spaceNeeded;
        return this;
    }

    public AbstractStringBuilder append(float f10) {
        FloatingDecimal.appendTo(f10, (Appendable) this);
        return this;
    }

    public AbstractStringBuilder append(double d10) {
        FloatingDecimal.appendTo(d10, this);
        return this;
    }

    public AbstractStringBuilder delete(int start, int end) {
        int count = this.count;
        if (end > count) {
            end = count;
        }
        checkRangeSIOOBE(start, end, count);
        int len = end - start;
        if (len > 0) {
            shift(end, -len);
            this.count = count - len;
        }
        return this;
    }

    public AbstractStringBuilder appendCodePoint(int codePoint) {
        if (Character.isBmpCodePoint(codePoint)) {
            return append((char) codePoint);
        }
        return append(Character.toChars(codePoint));
    }

    public AbstractStringBuilder deleteCharAt(int index) {
        String.checkIndex(index, this.count);
        shift(index + 1, -1);
        this.count--;
        return this;
    }

    public AbstractStringBuilder replace(int start, int end, String str) {
        int count = this.count;
        if (end > count) {
            end = count;
        }
        checkRangeSIOOBE(start, end, count);
        int len = str.length();
        int newCount = (count + len) - (end - start);
        ensureCapacityInternal(newCount);
        shift(end, newCount - count);
        this.count = newCount;
        putStringAt(start, str);
        return this;
    }

    public String substring(int start) {
        return substring(start, this.count);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int start, int end) {
        return substring(start, end);
    }

    public String substring(int start, int end) {
        checkRangeSIOOBE(start, end, this.count);
        if (isLatin1()) {
            return StringLatin1.newString(this.value, start, end - start);
        }
        return StringUTF16.newString(this.value, start, end - start);
    }

    private void shift(int offset, int n10) {
        byte[] bArr = this.value;
        byte b4 = this.coder;
        System.arraycopy((Object) bArr, offset << b4, (Object) bArr, (offset + n10) << b4, (this.count - offset) << b4);
    }

    public AbstractStringBuilder insert(int index, char[] str, int offset, int len) {
        String.checkOffset(index, this.count);
        checkRangeSIOOBE(offset, offset + len, str.length);
        ensureCapacityInternal(this.count + len);
        shift(index, len);
        this.count += len;
        putCharsAt(index, str, offset, offset + len);
        return this;
    }

    public AbstractStringBuilder insert(int offset, Object obj) {
        return insert(offset, String.valueOf(obj));
    }

    public AbstractStringBuilder insert(int offset, String str) {
        String.checkOffset(offset, this.count);
        if (str == null) {
            str = "null";
        }
        int len = str.length();
        ensureCapacityInternal(this.count + len);
        shift(offset, len);
        this.count += len;
        putStringAt(offset, str);
        return this;
    }

    public AbstractStringBuilder insert(int offset, char[] str) {
        String.checkOffset(offset, this.count);
        int len = str.length;
        ensureCapacityInternal(this.count + len);
        shift(offset, len);
        this.count += len;
        putCharsAt(offset, str, 0, len);
        return this;
    }

    public AbstractStringBuilder insert(int dstOffset, CharSequence s2) {
        if (s2 == null) {
            s2 = "null";
        }
        if (s2 instanceof String) {
            return insert(dstOffset, (String) s2);
        }
        return insert(dstOffset, s2, 0, s2.length());
    }

    public AbstractStringBuilder insert(int dstOffset, CharSequence s2, int start, int end) {
        if (s2 == null) {
            s2 = "null";
        }
        String.checkOffset(dstOffset, this.count);
        checkRange(start, end, s2.length());
        int len = end - start;
        ensureCapacityInternal(this.count + len);
        shift(dstOffset, len);
        this.count += len;
        putCharsAt(dstOffset, s2, start, end);
        return this;
    }

    public AbstractStringBuilder insert(int offset, boolean b4) {
        return insert(offset, String.valueOf(b4));
    }

    public AbstractStringBuilder insert(int offset, char c4) {
        String.checkOffset(offset, this.count);
        ensureCapacityInternal(this.count + 1);
        shift(offset, 1);
        this.count++;
        if (isLatin1() && StringLatin1.canEncode(c4)) {
            this.value[offset] = (byte) c4;
        } else {
            if (isLatin1()) {
                inflate();
            }
            StringUTF16.putCharSB(this.value, offset, c4);
        }
        return this;
    }

    public AbstractStringBuilder insert(int offset, int i10) {
        return insert(offset, String.valueOf(i10));
    }

    public AbstractStringBuilder insert(int offset, long l10) {
        return insert(offset, String.valueOf(l10));
    }

    public AbstractStringBuilder insert(int offset, float f10) {
        return insert(offset, String.valueOf(f10));
    }

    public AbstractStringBuilder insert(int offset, double d10) {
        return insert(offset, String.valueOf(d10));
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public int indexOf(String str, int fromIndex) {
        return String.indexOf(this.value, this.coder, this.count, str, fromIndex);
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.count);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return String.lastIndexOf(this.value, this.coder, this.count, str, fromIndex);
    }

    public AbstractStringBuilder reverse() {
        byte[] val = this.value;
        int count = this.count;
        int coder = this.coder;
        int n10 = count - 1;
        if (coder == 0) {
            for (int j10 = (n10 - 1) >> 1; j10 >= 0; j10--) {
                int k10 = n10 - j10;
                byte cj = val[j10];
                val[j10] = val[k10];
                val[k10] = cj;
            }
        } else {
            StringUTF16.reverse(val, count);
        }
        return this;
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return StreamSupport.intStream(new Supplier() { // from class: java.lang.AbstractStringBuilder$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator.OfInt lambda$chars$0;
                lambda$chars$0 = AbstractStringBuilder.this.lambda$chars$0();
                return lambda$chars$0;
            }
        }, 16464, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Spliterator.OfInt lambda$chars$0() {
        byte[] val = this.value;
        int count = this.count;
        byte coder = this.coder;
        if (coder == 0) {
            return new StringLatin1.CharsSpliterator(val, 0, count, 0);
        }
        return new StringUTF16.CharsSpliterator(val, 0, count, 0);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return StreamSupport.intStream(new Supplier() { // from class: java.lang.AbstractStringBuilder$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator.OfInt lambda$codePoints$1;
                lambda$codePoints$1 = AbstractStringBuilder.this.lambda$codePoints$1();
                return lambda$codePoints$1;
            }
        }, 16, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Spliterator.OfInt lambda$codePoints$1() {
        byte[] val = this.value;
        int count = this.count;
        byte coder = this.coder;
        if (coder == 0) {
            return new StringLatin1.CharsSpliterator(val, 0, count, 0);
        }
        return new StringUTF16.CodePointsSpliterator(val, 0, count, 0);
    }

    final byte[] getValue() {
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getBytes(byte[] dst, int dstBegin, byte coder) {
        if (this.coder == coder) {
            System.arraycopy((Object) this.value, 0, (Object) dst, dstBegin << coder, this.count << coder);
        } else {
            StringLatin1.inflate(this.value, 0, dst, dstBegin, this.count);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initBytes(char[] value, int off, int len) {
        byte[] compress = StringUTF16.compress(value, off, len);
        this.value = compress;
        if (compress != null) {
            this.coder = (byte) 0;
        } else {
            this.coder = (byte) 1;
            this.value = StringUTF16.toBytes(value, off, len);
        }
    }

    final byte getCoder() {
        return this.coder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isLatin1() {
        return this.coder == 0;
    }

    private final void putCharsAt(int index, char[] s2, int off, int end) {
        if (isLatin1()) {
            byte[] val = this.value;
            int i10 = off;
            int j10 = index;
            while (i10 < end) {
                char c4 = s2[i10];
                if (StringLatin1.canEncode(c4)) {
                    val[j10] = (byte) c4;
                    i10++;
                    j10++;
                } else {
                    inflate();
                    StringUTF16.putCharsSB(this.value, j10, s2, i10, end);
                    return;
                }
            }
            return;
        }
        StringUTF16.putCharsSB(this.value, index, s2, off, end);
    }

    private final void putCharsAt(int index, CharSequence s2, int off, int end) {
        if (isLatin1()) {
            byte[] val = this.value;
            int i10 = off;
            int j10 = index;
            while (i10 < end) {
                char c4 = s2.charAt(i10);
                if (StringLatin1.canEncode(c4)) {
                    val[j10] = (byte) c4;
                    i10++;
                    j10++;
                } else {
                    inflate();
                    StringUTF16.putCharsSB(this.value, j10, s2, i10, end);
                    return;
                }
            }
            return;
        }
        StringUTF16.putCharsSB(this.value, index, s2, off, end);
    }

    private final void putStringAt(int index, String str) {
        if (getCoder() != str.coder()) {
            inflate();
        }
        str.getBytes(this.value, index, this.coder);
    }

    private final void appendChars(char[] s2, int off, int end) {
        int count = this.count;
        if (isLatin1()) {
            byte[] val = this.value;
            int i10 = off;
            int j10 = count;
            while (i10 < end) {
                char c4 = s2[i10];
                if (StringLatin1.canEncode(c4)) {
                    val[j10] = (byte) c4;
                    i10++;
                    j10++;
                } else {
                    this.count = j10;
                    inflate();
                    StringUTF16.putCharsSB(this.value, j10, s2, i10, end);
                    this.count = (j10 + end) - i10;
                    return;
                }
            }
        } else {
            StringUTF16.putCharsSB(this.value, count, s2, off, end);
        }
        this.count = (count + end) - off;
    }

    private final void appendChars(CharSequence s2, int off, int end) {
        if (isLatin1()) {
            byte[] val = this.value;
            int i10 = off;
            int j10 = this.count;
            while (i10 < end) {
                char c4 = s2.charAt(i10);
                if (StringLatin1.canEncode(c4)) {
                    val[j10] = (byte) c4;
                    i10++;
                    j10++;
                } else {
                    this.count = j10;
                    inflate();
                    StringUTF16.putCharsSB(this.value, j10, s2, i10, end);
                    this.count += end - i10;
                    return;
                }
            }
        } else {
            StringUTF16.putCharsSB(this.value, this.count, s2, off, end);
        }
        this.count += end - off;
    }

    private static void checkRange(int start, int end, int len) {
        if (start < 0 || start > end || end > len) {
            throw new IndexOutOfBoundsException("start " + start + ", end " + end + ", length " + len);
        }
    }

    private static void checkRangeSIOOBE(int start, int end, int len) {
        if (start < 0 || start > end || end > len) {
            throw new StringIndexOutOfBoundsException("start " + start + ", end " + end + ", length " + len);
        }
    }
}
