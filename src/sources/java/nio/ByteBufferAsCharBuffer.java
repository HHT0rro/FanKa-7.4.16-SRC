package java.nio;

import java.util.Objects;
import libcore.io.Memory;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ByteBufferAsCharBuffer extends CharBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: bb, reason: collision with root package name */
    protected final ByteBuffer f50372bb;
    protected final int offset;
    private final ByteOrder order;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBufferAsCharBuffer(ByteBuffer bb2, int mark, int pos, int lim, int cap, int off, ByteOrder order) {
        super(mark, pos, lim, cap);
        ByteBuffer duplicate = bb2.duplicate();
        this.f50372bb = duplicate;
        this.isReadOnly = bb2.isReadOnly;
        if (bb2 instanceof DirectByteBuffer) {
            this.address = bb2.address + off;
        }
        duplicate.order(order);
        this.order = order;
        this.offset = off;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.CharBuffer, java.nio.Buffer
    public Object base() {
        return this.f50372bb.f50371hb;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer slice() {
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        int off = (pos << 1) + this.offset;
        return new ByteBufferAsCharBuffer(this.f50372bb, -1, 0, rem, rem, off, this.order);
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsCharBuffer(this.f50372bb, -1, 0, length, length, this.offset, this.order);
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public CharBuffer duplicate() {
        return new ByteBufferAsCharBuffer(this.f50372bb, markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    @Override // java.nio.CharBuffer
    public CharBuffer asReadOnlyBuffer() {
        return new ByteBufferAsCharBuffer(this.f50372bb.asReadOnlyBuffer(), markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    protected int ix(int i10) {
        return (i10 << 1) + this.offset;
    }

    @Override // java.nio.CharBuffer
    public char get() {
        return get(nextGetIndex());
    }

    @Override // java.nio.CharBuffer
    public char get(int i10) {
        return this.f50372bb.getCharUnchecked(ix(checkIndex(i10)));
    }

    @Override // java.nio.CharBuffer
    public CharBuffer get(char[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        this.f50372bb.getUnchecked(ix(this.position), dst, offset, length);
        this.position += length;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.CharBuffer
    public char getUnchecked(int i10) {
        return this.f50372bb.getCharUnchecked(ix(i10));
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(char x10) {
        put(nextPutIndex(), x10);
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(int i10, char x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50372bb.putCharUnchecked(ix(checkIndex(i10)), x10);
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(char[] src, int offset, int length) {
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        this.f50372bb.putUnchecked(ix(this.position), src, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        ByteBuffer byteBuffer = this.f50372bb;
        if (!(byteBuffer instanceof DirectByteBuffer)) {
            System.arraycopy((Object) byteBuffer.array(), ix(pos), (Object) this.f50372bb.array(), ix(0), rem << 1);
        } else {
            Memory.memmove(this, ix(0), this, ix(pos), rem << 1);
        }
        position(rem);
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.f50372bb.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.CharBuffer
    public String toString(int start, int end) {
        if (end > limit() || start > end) {
            throw new IndexOutOfBoundsException();
        }
        int len = end - start;
        try {
            char[] ca2 = new char[len];
            CharBuffer cb2 = CharBuffer.wrap(ca2);
            CharBuffer db2 = duplicate();
            db2.position(start);
            db2.limit(end);
            cb2.put(db2);
            return new String(ca2);
        } catch (StringIndexOutOfBoundsException e2) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.nio.CharBuffer, java.lang.CharSequence
    public CharBuffer subSequence(int start, int end) {
        int pos = position();
        int lim = limit();
        int pos2 = pos <= lim ? pos : lim;
        int len = lim - pos2;
        if (start < 0 || end > len || start > end) {
            throw new IndexOutOfBoundsException();
        }
        return new ByteBufferAsCharBuffer(this.f50372bb, -1, pos2 + start, pos2 + end, capacity(), this.offset, this.order);
    }

    @Override // java.nio.CharBuffer
    public ByteOrder order() {
        return this.order;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.CharBuffer
    public ByteOrder charRegionOrder() {
        return order();
    }
}
