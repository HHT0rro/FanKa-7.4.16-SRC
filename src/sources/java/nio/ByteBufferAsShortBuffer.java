package java.nio;

import java.util.Objects;
import libcore.io.Memory;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ByteBufferAsShortBuffer extends ShortBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: bb, reason: collision with root package name */
    protected final ByteBuffer f50377bb;
    protected final int offset;
    private final ByteOrder order;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBufferAsShortBuffer(ByteBuffer bb2, int mark, int pos, int lim, int cap, int off, ByteOrder order) {
        super(mark, pos, lim, cap);
        ByteBuffer duplicate = bb2.duplicate();
        this.f50377bb = duplicate;
        this.isReadOnly = bb2.isReadOnly;
        if (bb2 instanceof DirectByteBuffer) {
            this.address = bb2.address + off;
        }
        duplicate.order(order);
        this.order = order;
        this.offset = off;
    }

    @Override // java.nio.ShortBuffer, java.nio.Buffer
    public ShortBuffer slice() {
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        int off = (pos << 1) + this.offset;
        return new ByteBufferAsShortBuffer(this.f50377bb, -1, 0, rem, rem, off, this.order);
    }

    @Override // java.nio.ShortBuffer, java.nio.Buffer
    public ShortBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsShortBuffer(this.f50377bb, -1, 0, length, length, this.offset, this.order);
    }

    @Override // java.nio.ShortBuffer, java.nio.Buffer
    public ShortBuffer duplicate() {
        return new ByteBufferAsShortBuffer(this.f50377bb, markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer asReadOnlyBuffer() {
        return new ByteBufferAsShortBuffer(this.f50377bb.asReadOnlyBuffer(), markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    protected int ix(int i10) {
        return (i10 << 1) + this.offset;
    }

    @Override // java.nio.ShortBuffer
    public short get() {
        return get(nextGetIndex());
    }

    @Override // java.nio.ShortBuffer
    public short get(int i10) {
        return this.f50377bb.getShortUnchecked(ix(checkIndex(i10)));
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer get(short[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        this.f50377bb.getUnchecked(ix(this.position), dst, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(short x10) {
        put(nextPutIndex(), x10);
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(int i10, short x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50377bb.putShortUnchecked(ix(checkIndex(i10)), x10);
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer put(short[] src, int offset, int length) {
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        this.f50377bb.putUnchecked(ix(this.position), src, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.ShortBuffer
    public ShortBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        ByteBuffer byteBuffer = this.f50377bb;
        if (!(byteBuffer instanceof DirectByteBuffer)) {
            System.arraycopy((Object) byteBuffer.array(), ix(pos), (Object) this.f50377bb.array(), ix(0), rem << 1);
        } else {
            Memory.memmove(this, ix(0), this, ix(pos), rem << 1);
        }
        position(rem);
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.ShortBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.f50377bb.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.ShortBuffer
    public ByteOrder order() {
        return this.order;
    }
}
