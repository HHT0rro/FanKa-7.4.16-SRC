package java.nio;

import java.util.Objects;
import libcore.io.Memory;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ByteBufferAsLongBuffer extends LongBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: bb, reason: collision with root package name */
    protected final ByteBuffer f50376bb;
    protected final int offset;
    private final ByteOrder order;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBufferAsLongBuffer(ByteBuffer bb2, int mark, int pos, int lim, int cap, int off, ByteOrder order) {
        super(mark, pos, lim, cap);
        ByteBuffer duplicate = bb2.duplicate();
        this.f50376bb = duplicate;
        this.isReadOnly = bb2.isReadOnly;
        if (bb2 instanceof DirectByteBuffer) {
            this.address = bb2.address + off;
        }
        duplicate.order(order);
        this.order = order;
        this.offset = off;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.LongBuffer, java.nio.Buffer
    public Object base() {
        return this.f50376bb.f50371hb;
    }

    @Override // java.nio.LongBuffer, java.nio.Buffer
    public LongBuffer slice() {
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        int off = (pos << 3) + this.offset;
        return new ByteBufferAsLongBuffer(this.f50376bb, -1, 0, rem, rem, off, this.order);
    }

    @Override // java.nio.LongBuffer, java.nio.Buffer
    public LongBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsLongBuffer(this.f50376bb, -1, 0, length, length, this.offset, this.order);
    }

    @Override // java.nio.LongBuffer, java.nio.Buffer
    public LongBuffer duplicate() {
        return new ByteBufferAsLongBuffer(this.f50376bb, markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    @Override // java.nio.LongBuffer
    public LongBuffer asReadOnlyBuffer() {
        return new ByteBufferAsLongBuffer(this.f50376bb.asReadOnlyBuffer(), markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    protected int ix(int i10) {
        return (i10 << 3) + this.offset;
    }

    @Override // java.nio.LongBuffer
    public long get() {
        return get(nextGetIndex());
    }

    @Override // java.nio.LongBuffer
    public long get(int i10) {
        return this.f50376bb.getLongUnchecked(ix(checkIndex(i10)));
    }

    @Override // java.nio.LongBuffer
    public LongBuffer get(long[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        this.f50376bb.getUnchecked(ix(this.position), dst, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(long x10) {
        put(nextPutIndex(), x10);
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(int i10, long x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50376bb.putLongUnchecked(ix(checkIndex(i10)), x10);
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer put(long[] src, int offset, int length) {
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        this.f50376bb.putUnchecked(ix(this.position), src, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.LongBuffer
    public LongBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        ByteBuffer byteBuffer = this.f50376bb;
        if (!(byteBuffer instanceof DirectByteBuffer)) {
            System.arraycopy((Object) byteBuffer.array(), ix(pos), (Object) this.f50376bb.array(), ix(0), rem << 3);
        } else {
            Memory.memmove(this, ix(0), this, ix(pos), rem << 3);
        }
        position(rem);
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.LongBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.f50376bb.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.LongBuffer
    public ByteOrder order() {
        return this.order;
    }
}
