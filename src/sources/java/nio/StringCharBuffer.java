package java.nio;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StringCharBuffer extends CharBuffer {
    CharSequence str;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringCharBuffer(CharSequence s2, int start, int end) {
        super(-1, start, end, s2.length());
        int n10 = s2.length();
        if (start < 0 || start > n10 || end < start || end > n10) {
            throw new IndexOutOfBoundsException();
        }
        this.str = s2;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer slice() {
        return new StringCharBuffer(this.str, -1, 0, remaining(), remaining(), position() + this.offset);
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new StringCharBuffer(this.str, -1, 0, length, length, this.offset + index);
    }

    private StringCharBuffer(CharSequence s2, int mark, int pos, int limit, int cap, int offset) {
        super(mark, pos, limit, cap, null, offset);
        this.str = s2;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer duplicate() {
        return new StringCharBuffer(this.str, markValue(), position(), limit(), capacity(), this.offset);
    }

    @Override // java.nio.CharBuffer
    public CharBuffer asReadOnlyBuffer() {
        return duplicate();
    }

    @Override // java.nio.CharBuffer
    public final char get() {
        return this.str.charAt(nextGetIndex() + this.offset);
    }

    @Override // java.nio.CharBuffer
    public final char get(int index) {
        return this.str.charAt(checkIndex(index) + this.offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.CharBuffer
    public char getUnchecked(int index) {
        return this.str.charAt(this.offset + index);
    }

    @Override // java.nio.CharBuffer
    public final CharBuffer put(char c4) {
        throw new ReadOnlyBufferException();
    }

    @Override // java.nio.CharBuffer
    public final CharBuffer put(int index, char c4) {
        throw new ReadOnlyBufferException();
    }

    @Override // java.nio.CharBuffer
    public final CharBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @Override // java.nio.Buffer
    public final boolean isReadOnly() {
        return true;
    }

    @Override // java.nio.CharBuffer
    final String toString(int start, int end) {
        return this.str.toString().substring(this.offset + start, this.offset + end);
    }

    @Override // java.nio.CharBuffer, java.lang.CharSequence
    public final CharBuffer subSequence(int start, int end) {
        try {
            int pos = position();
            return new StringCharBuffer(this.str, -1, pos + checkIndex(start, pos), pos + checkIndex(end, pos), capacity(), this.offset);
        } catch (IllegalArgumentException e2) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public boolean isDirect() {
        return false;
    }

    @Override // java.nio.CharBuffer
    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.CharBuffer
    public ByteOrder charRegionOrder() {
        return null;
    }

    boolean isAddressable() {
        return false;
    }

    @Override // java.nio.CharBuffer
    public boolean equals(Object ob2) {
        if (this == ob2) {
            return true;
        }
        if (!(ob2 instanceof CharBuffer)) {
            return false;
        }
        CharBuffer that = (CharBuffer) ob2;
        int thisPos = position();
        int thisRem = limit() - thisPos;
        int thatPos = that.position();
        int thatRem = that.limit() - thatPos;
        return thisRem >= 0 && thisRem == thatRem && BufferMismatch.mismatch(this, thisPos, that, thatPos, thisRem) < 0;
    }

    @Override // java.nio.CharBuffer, java.lang.Comparable
    public int compareTo(CharBuffer that) {
        int thisPos = position();
        int thisRem = limit() - thisPos;
        int thatPos = that.position();
        int thatRem = that.limit() - thatPos;
        int length = Math.min(thisRem, thatRem);
        if (length < 0) {
            return -1;
        }
        int i10 = BufferMismatch.mismatch(this, thisPos, that, thatPos, length);
        if (i10 >= 0) {
            return Character.compare(get(thisPos + i10), that.get(thatPos + i10));
        }
        return thisRem - thatRem;
    }
}
