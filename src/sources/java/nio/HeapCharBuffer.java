package java.nio;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HeapCharBuffer extends CharBuffer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapCharBuffer(int cap, int lim) {
        this(cap, lim, false);
    }

    HeapCharBuffer(int cap, int lim, boolean isReadOnly) {
        super(-1, 0, lim, cap, new char[cap], 0);
        this.isReadOnly = isReadOnly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapCharBuffer(char[] buf, int off, int len) {
        this(buf, off, len, false);
    }

    HeapCharBuffer(char[] buf, int off, int len, boolean isReadOnly) {
        super(-1, off, off + len, buf.length, buf, 0);
        this.isReadOnly = isReadOnly;
    }

    protected HeapCharBuffer(char[] buf, int mark, int pos, int lim, int cap, int off) {
        this(buf, mark, pos, lim, cap, off, false);
    }

    protected HeapCharBuffer(char[] buf, int mark, int pos, int lim, int cap, int off, boolean isReadOnly) {
        super(mark, pos, lim, cap, buf, off);
        this.isReadOnly = isReadOnly;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer slice() {
        return new HeapCharBuffer(this.f50378hb, -1, 0, remaining(), remaining(), this.offset + position(), this.isReadOnly);
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapCharBuffer(this.f50378hb, -1, 0, length, length, index + this.offset, this.isReadOnly);
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer duplicate() {
        return new HeapCharBuffer(this.f50378hb, markValue(), position(), limit(), capacity(), this.offset, this.isReadOnly);
    }

    @Override // java.nio.CharBuffer
    public CharBuffer asReadOnlyBuffer() {
        return new HeapCharBuffer(this.f50378hb, markValue(), position(), limit(), capacity(), this.offset, true);
    }

    protected int ix(int i10) {
        return this.offset + i10;
    }

    @Override // java.nio.CharBuffer
    public char get() {
        return this.f50378hb[ix(nextGetIndex())];
    }

    @Override // java.nio.CharBuffer
    public char get(int i10) {
        return this.f50378hb[ix(checkIndex(i10))];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.CharBuffer
    public char getUnchecked(int i10) {
        return this.f50378hb[ix(i10)];
    }

    @Override // java.nio.CharBuffer
    public CharBuffer get(char[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy((Object) this.f50378hb, ix(position()), (Object) dst, offset, length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(char x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50378hb[ix(nextPutIndex())] = x10;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(int i10, char x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50378hb[ix(checkIndex(i10))] = x10;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(char[] src, int offset, int length) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy((Object) src, offset, (Object) this.f50378hb, ix(position()), length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(CharBuffer src) {
        if (src == this) {
            throw createSameBufferException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (src instanceof HeapCharBuffer) {
            HeapCharBuffer sb2 = (HeapCharBuffer) src;
            int n10 = sb2.remaining();
            if (n10 > remaining()) {
                throw new BufferOverflowException();
            }
            System.arraycopy((Object) sb2.f50378hb, sb2.ix(sb2.position()), (Object) this.f50378hb, ix(position()), n10);
            sb2.position(sb2.position() + n10);
            position(position() + n10);
        } else if (src.isDirect()) {
            int n11 = src.remaining();
            if (n11 > remaining()) {
                throw new BufferOverflowException();
            }
            src.get(this.f50378hb, ix(position()), n11);
            position(position() + n11);
        } else {
            super.put(src);
        }
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy((Object) this.f50378hb, ix(position()), (Object) this.f50378hb, ix(0), remaining());
        position(remaining());
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.CharBuffer
    String toString(int start, int end) {
        try {
            return new String(this.f50378hb, this.offset + start, end - start);
        } catch (StringIndexOutOfBoundsException e2) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.nio.CharBuffer, java.lang.CharSequence
    public CharBuffer subSequence(int start, int end) {
        if (start < 0 || end > length() || start > end) {
            throw new IndexOutOfBoundsException();
        }
        int pos = position();
        return new HeapCharBuffer(this.f50378hb, -1, pos + start, pos + end, capacity(), this.offset, this.isReadOnly);
    }

    @Override // java.nio.CharBuffer
    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.CharBuffer
    public ByteOrder charRegionOrder() {
        return order();
    }
}
