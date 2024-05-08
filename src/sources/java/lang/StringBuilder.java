package java.lang;

import dalvik.annotation.optimization.NeverInline;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.stream.IntStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StringBuilder extends AbstractStringBuilder implements Serializable, Comparable<StringBuilder>, CharSequence {
    static final long serialVersionUID = 4383685877147921099L;

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ char charAt(int i10) {
        return super.charAt(i10);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ IntStream chars() {
        return super.chars();
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int codePointAt(int i10) {
        return super.codePointAt(i10);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int codePointBefore(int i10) {
        return super.codePointBefore(i10);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int codePointCount(int i10, int i11) {
        return super.codePointCount(i10, i11);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ IntStream codePoints() {
        return super.codePoints();
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void ensureCapacity(int i10) {
        super.ensureCapacity(i10);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void getChars(int i10, int i11, char[] cArr, int i12) {
        super.getChars(i10, i11, cArr, i12);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    @NeverInline
    public /* bridge */ /* synthetic */ int length() {
        return super.length();
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ int offsetByCodePoints(int i10, int i11) {
        return super.offsetByCodePoints(i10, i11);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void setCharAt(int i10, char c4) {
        super.setCharAt(i10, c4);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void setLength(int i10) {
        super.setLength(i10);
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    public /* bridge */ /* synthetic */ CharSequence subSequence(int i10, int i11) {
        return super.subSequence(i10, i11);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ String substring(int i10) {
        return super.substring(i10);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ String substring(int i10, int i11) {
        return super.substring(i10, i11);
    }

    @Override // java.lang.AbstractStringBuilder
    public /* bridge */ /* synthetic */ void trimToSize() {
        super.trimToSize();
    }

    @NeverInline
    public StringBuilder() {
        super(16);
    }

    @NeverInline
    public StringBuilder(int capacity) {
        super(capacity);
    }

    @NeverInline
    public StringBuilder(String str) {
        super(str.length() + 16);
        append(str);
    }

    @NeverInline
    public StringBuilder(CharSequence seq) {
        this(seq.length() + 16);
        append(seq);
    }

    @Override // java.lang.Comparable
    public int compareTo(StringBuilder another) {
        return super.compareTo((AbstractStringBuilder) another);
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public StringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public StringBuilder append(String str) {
        super.append(str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder append(StringBuffer sb2) {
        super.append(sb2);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.Appendable
    @NeverInline
    public StringBuilder append(CharSequence s2) {
        super.append(s2);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.Appendable
    public StringBuilder append(CharSequence s2, int start, int end) {
        super.append(s2, start, end);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public StringBuilder append(char[] str) {
        super.append(str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder append(char[] str, int offset, int len) {
        super.append(str, offset, len);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public StringBuilder append(boolean b4) {
        super.append(b4);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.Appendable
    @NeverInline
    public StringBuilder append(char c4) {
        super.append(c4);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public StringBuilder append(int i10) {
        super.append(i10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public StringBuilder append(long lng) {
        super.append(lng);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public StringBuilder append(float f10) {
        super.append(f10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    @NeverInline
    public StringBuilder append(double d10) {
        super.append(d10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder appendCodePoint(int codePoint) {
        super.appendCodePoint(codePoint);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder delete(int start, int end) {
        super.delete(start, end);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder deleteCharAt(int index) {
        super.deleteCharAt(index);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder replace(int start, int end, String str) {
        super.replace(start, end, str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int index, char[] str, int offset, int len) {
        super.insert(index, str, offset, len);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, Object obj) {
        super.insert(offset, obj);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, String str) {
        super.insert(offset, str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, char[] str) {
        super.insert(offset, str);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int dstOffset, CharSequence s2) {
        super.insert(dstOffset, s2);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int dstOffset, CharSequence s2, int start, int end) {
        super.insert(dstOffset, s2, start, end);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, boolean b4) {
        super.insert(offset, b4);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, char c4) {
        super.insert(offset, c4);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, int i10) {
        super.insert(offset, i10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, long l10) {
        super.insert(offset, l10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, float f10) {
        super.insert(offset, f10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder insert(int offset, double d10) {
        super.insert(offset, d10);
        return this;
    }

    @Override // java.lang.AbstractStringBuilder
    public int indexOf(String str) {
        return super.indexOf(str);
    }

    @Override // java.lang.AbstractStringBuilder
    public int indexOf(String str, int fromIndex) {
        return super.indexOf(str, fromIndex);
    }

    @Override // java.lang.AbstractStringBuilder
    public int lastIndexOf(String str) {
        return super.lastIndexOf(str);
    }

    @Override // java.lang.AbstractStringBuilder
    public int lastIndexOf(String str, int fromIndex) {
        return super.lastIndexOf(str, fromIndex);
    }

    @Override // java.lang.AbstractStringBuilder
    public StringBuilder reverse() {
        super.reverse();
        return this;
    }

    @Override // java.lang.AbstractStringBuilder, java.lang.CharSequence
    @NeverInline
    public String toString() {
        if (this.count == 0) {
            return "";
        }
        return isLatin1() ? StringLatin1.newString(this.value, 0, this.count) : StringUTF16.newString(this.value, 0, this.count);
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeInt(this.count);
        char[] val = new char[capacity()];
        if (isLatin1()) {
            StringLatin1.getChars(this.value, 0, this.count, val, 0);
        } else {
            StringUTF16.getChars(this.value, 0, this.count, val, 0);
        }
        s2.writeObject(val);
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        this.count = s2.readInt();
        char[] val = (char[]) s2.readObject();
        initBytes(val, 0, val.length);
    }
}
