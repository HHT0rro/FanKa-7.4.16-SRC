package java.lang;

import dalvik.annotation.optimization.NeverInline;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.stream.IntStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StringBuffer extends AbstractStringBuilder implements Serializable, Comparable<StringBuffer>, CharSequence {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("value", char[].class), new ObjectStreamField("count", Integer.TYPE), new ObjectStreamField("shared", Boolean.TYPE)};
    static final long serialVersionUID = 3388685877147921107L;
    private transient String toStringCache;

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ IntStream chars() {
        return super.chars();
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ IntStream codePoints() {
        return super.codePoints();
    }

    public StringBuffer() {
        super(16);
    }

    public StringBuffer(int capacity) {
        super(capacity);
    }

    public StringBuffer(String str) {
        super(str.length() + 16);
        this.toStringCache = null;
        super.append(str);
    }

    public StringBuffer(CharSequence seq) {
        this(seq.length() + 16);
        this.toStringCache = null;
        super.append(seq);
    }

    @Override // java.lang.Comparable
    public synchronized int compareTo(StringBuffer another) {
        return super.compareTo((AbstractStringBuilder) another);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    @NeverInline
    public synchronized int length() {
        return this.count;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized int capacity() {
        return super.capacity();
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized void ensureCapacity(int minimumCapacity) {
        super.ensureCapacity(minimumCapacity);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized void trimToSize() {
        super.trimToSize();
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized void setLength(int newLength) {
        this.toStringCache = null;
        super.setLength(newLength);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public synchronized char charAt(int index) {
        return super.charAt(index);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized int codePointAt(int index) {
        return super.codePointAt(index);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized int codePointBefore(int index) {
        return super.codePointBefore(index);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized int codePointCount(int beginIndex, int endIndex) {
        return super.codePointCount(beginIndex, endIndex);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        return super.offsetByCodePoints(index, codePointOffset);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        super.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized void setCharAt(int index, char ch) {
        this.toStringCache = null;
        super.setCharAt(index, ch);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(Object obj) {
        this.toStringCache = null;
        super.append(String.valueOf(obj));
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public synchronized StringBuffer append(String str) {
        this.toStringCache = null;
        super.append(str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(StringBuffer sb2) {
        this.toStringCache = null;
        super.append(sb2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(AbstractStringBuilder asb) {
        this.toStringCache = null;
        super.append(asb);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.Appendable
    public synchronized StringBuffer append(CharSequence s2) {
        this.toStringCache = null;
        super.append(s2);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.Appendable
    public synchronized StringBuffer append(CharSequence s2, int start, int end) {
        this.toStringCache = null;
        super.append(s2, start, end);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(char[] str) {
        this.toStringCache = null;
        super.append(str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(char[] str, int offset, int len) {
        this.toStringCache = null;
        super.append(str, offset, len);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(boolean b4) {
        this.toStringCache = null;
        super.append(b4);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.Appendable
    public synchronized StringBuffer append(char c4) {
        this.toStringCache = null;
        super.append(c4);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(int i10) {
        this.toStringCache = null;
        super.append(i10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer appendCodePoint(int codePoint) {
        this.toStringCache = null;
        super.appendCodePoint(codePoint);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(long lng) {
        this.toStringCache = null;
        super.append(lng);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(float f10) {
        this.toStringCache = null;
        super.append(f10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer append(double d10) {
        this.toStringCache = null;
        super.append(d10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer delete(int start, int end) {
        this.toStringCache = null;
        super.delete(start, end);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer deleteCharAt(int index) {
        this.toStringCache = null;
        super.deleteCharAt(index);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer replace(int start, int end, String str) {
        this.toStringCache = null;
        super.replace(start, end, str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized String substring(int start) {
        return substring(start, this.count);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public synchronized CharSequence subSequence(int start, int end) {
        return super.substring(start, end);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized String substring(int start, int end) {
        return super.substring(start, end);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer insert(int index, char[] str, int offset, int len) {
        this.toStringCache = null;
        super.insert(index, str, offset, len);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer insert(int offset, Object obj) {
        this.toStringCache = null;
        super.insert(offset, String.valueOf(obj));
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer insert(int offset, String str) {
        this.toStringCache = null;
        super.insert(offset, str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer insert(int offset, char[] str) {
        this.toStringCache = null;
        super.insert(offset, str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuffer insert(int dstOffset, CharSequence s2) {
        super.insert(dstOffset, s2);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer insert(int dstOffset, CharSequence s2, int start, int end) {
        this.toStringCache = null;
        super.insert(dstOffset, s2, start, end);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuffer insert(int offset, boolean b4) {
        super.insert(offset, b4);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer insert(int offset, char c4) {
        this.toStringCache = null;
        super.insert(offset, c4);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuffer insert(int offset, int i10) {
        super.insert(offset, i10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuffer insert(int offset, long l10) {
        super.insert(offset, l10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuffer insert(int offset, float f10) {
        super.insert(offset, f10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuffer insert(int offset, double d10) {
        super.insert(offset, d10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public int indexOf(String str) {
        return super.indexOf(str);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized int indexOf(String str, int fromIndex) {
        return super.indexOf(str, fromIndex);
    }

    @Override // java.lang.AbstractStringBuilder
    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.count);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized int lastIndexOf(String str, int fromIndex) {
        return super.lastIndexOf(str, fromIndex);
    }

    @Override // java.lang.AbstractStringBuilder
    public synchronized StringBuffer reverse() {
        this.toStringCache = null;
        super.reverse();
        return this;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    @NeverInline
    public synchronized String toString() {
        if (this.toStringCache == null) {
            String newString = isLatin1() ? StringLatin1.newString(this.value, 0, this.count) : StringUTF16.newString(this.value, 0, this.count);
            this.toStringCache = newString;
            return newString;
        }
        return new String(this.toStringCache);
    }

    private synchronized void writeObject(ObjectOutputStream s2) throws IOException {
        ObjectOutputStream.PutField fields = s2.putFields();
        char[] val = new char[capacity()];
        if (isLatin1()) {
            StringLatin1.getChars(this.value, 0, this.count, val, 0);
        } else {
            StringUTF16.getChars(this.value, 0, this.count, val, 0);
        }
        fields.put("value", val);
        fields.put("count", this.count);
        fields.put("shared", false);
        s2.writeFields();
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s2.readFields();
        char[] val = (char[]) fields.get("value", (Object) null);
        initBytes(val, 0, val.length);
        this.count = fields.get("count", 0);
    }

    @Override // java.lang.AbstractStringBuilder
    synchronized void getBytes(byte[] dst, int dstBegin, byte coder) {
        super.getBytes(dst, dstBegin, coder);
    }
}
