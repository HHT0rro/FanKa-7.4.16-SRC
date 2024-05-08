package java.nio;

import java.util.Objects;
import libcore.io.Memory;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ByteBufferAsDoubleBuffer extends DoubleBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: bb, reason: collision with root package name */
    protected final ByteBuffer f50373bb;
    protected final int offset;
    private final ByteOrder order;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBufferAsDoubleBuffer(ByteBuffer bb2, int mark, int pos, int lim, int cap, int off, ByteOrder order) {
        super(mark, pos, lim, cap);
        ByteBuffer duplicate = bb2.duplicate();
        this.f50373bb = duplicate;
        this.isReadOnly = bb2.isReadOnly;
        if (bb2 instanceof DirectByteBuffer) {
            this.address = bb2.address + off;
        }
        duplicate.order(order);
        this.order = order;
        this.offset = off;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public Object base() {
        return this.f50373bb.f50371hb;
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public DoubleBuffer slice() {
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        int off = (pos << 3) + this.offset;
        return new ByteBufferAsDoubleBuffer(this.f50373bb, -1, 0, rem, rem, off, this.order);
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public DoubleBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsDoubleBuffer(this.f50373bb, -1, 0, length, length, this.offset, this.order);
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public DoubleBuffer duplicate() {
        return new ByteBufferAsDoubleBuffer(this.f50373bb, markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer asReadOnlyBuffer() {
        return new ByteBufferAsDoubleBuffer(this.f50373bb.asReadOnlyBuffer(), markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    protected int ix(int i10) {
        return (i10 << 3) + this.offset;
    }

    @Override // java.nio.DoubleBuffer
    public double get() {
        return get(nextGetIndex());
    }

    @Override // java.nio.DoubleBuffer
    public double get(int i10) {
        return this.f50373bb.getDoubleUnchecked(ix(checkIndex(i10)));
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer get(double[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        this.f50373bb.getUnchecked(ix(this.position), dst, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(double x10) {
        put(nextPutIndex(), x10);
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(int i10, double x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50373bb.putDoubleUnchecked(ix(checkIndex(i10)), x10);
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(double[] src, int offset, int length) {
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        this.f50373bb.putUnchecked(ix(this.position), src, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        ByteBuffer byteBuffer = this.f50373bb;
        if (!(byteBuffer instanceof DirectByteBuffer)) {
            System.arraycopy((Object) byteBuffer.array(), ix(pos), (Object) this.f50373bb.array(), ix(0), rem << 3);
        } else {
            Memory.memmove(this, ix(0), this, ix(pos), rem << 3);
        }
        position(rem);
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.f50373bb.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.DoubleBuffer
    public ByteOrder order() {
        return this.order;
    }
}
