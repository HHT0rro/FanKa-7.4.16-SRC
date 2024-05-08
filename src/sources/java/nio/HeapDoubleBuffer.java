package java.nio;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HeapDoubleBuffer extends DoubleBuffer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapDoubleBuffer(int cap, int lim) {
        this(cap, lim, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapDoubleBuffer(double[] buf, int off, int len) {
        this(buf, off, len, false);
    }

    protected HeapDoubleBuffer(double[] buf, int mark, int pos, int lim, int cap, int off) {
        this(buf, mark, pos, lim, cap, off, false);
    }

    HeapDoubleBuffer(int cap, int lim, boolean isReadOnly) {
        super(-1, 0, lim, cap, new double[cap], 0);
        this.isReadOnly = isReadOnly;
    }

    HeapDoubleBuffer(double[] buf, int off, int len, boolean isReadOnly) {
        super(-1, off, off + len, buf.length, buf, 0);
        this.isReadOnly = isReadOnly;
    }

    protected HeapDoubleBuffer(double[] buf, int mark, int pos, int lim, int cap, int off, boolean isReadOnly) {
        super(mark, pos, lim, cap, buf, off);
        this.isReadOnly = isReadOnly;
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public DoubleBuffer slice() {
        return new HeapDoubleBuffer(this.f50379hb, -1, 0, remaining(), remaining(), this.offset + position(), this.isReadOnly);
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public DoubleBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapDoubleBuffer(this.f50379hb, -1, 0, length, length, index + this.offset, this.isReadOnly);
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public DoubleBuffer duplicate() {
        return new HeapDoubleBuffer(this.f50379hb, markValue(), position(), limit(), capacity(), this.offset, this.isReadOnly);
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer asReadOnlyBuffer() {
        return new HeapDoubleBuffer(this.f50379hb, markValue(), position(), limit(), capacity(), this.offset, true);
    }

    protected int ix(int i10) {
        return this.offset + i10;
    }

    @Override // java.nio.DoubleBuffer
    public double get() {
        return this.f50379hb[ix(nextGetIndex())];
    }

    @Override // java.nio.DoubleBuffer
    public double get(int i10) {
        return this.f50379hb[ix(checkIndex(i10))];
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer get(double[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy((Object) this.f50379hb, ix(position()), (Object) dst, offset, length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.DoubleBuffer, java.nio.Buffer
    public boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(double x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50379hb[ix(nextPutIndex())] = x10;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(int i10, double x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50379hb[ix(checkIndex(i10))] = x10;
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(double[] src, int offset, int length) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy((Object) src, offset, (Object) this.f50379hb, ix(position()), length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer put(DoubleBuffer src) {
        if (src == this) {
            throw createSameBufferException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (src instanceof HeapDoubleBuffer) {
            HeapDoubleBuffer sb2 = (HeapDoubleBuffer) src;
            int n10 = sb2.remaining();
            if (n10 > remaining()) {
                throw new BufferOverflowException();
            }
            System.arraycopy((Object) sb2.f50379hb, sb2.ix(sb2.position()), (Object) this.f50379hb, ix(position()), n10);
            sb2.position(sb2.position() + n10);
            position(position() + n10);
        } else if (src.isDirect()) {
            int n11 = src.remaining();
            if (n11 > remaining()) {
                throw new BufferOverflowException();
            }
            src.get(this.f50379hb, ix(position()), n11);
            position(position() + n11);
        } else {
            super.put(src);
        }
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public DoubleBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy((Object) this.f50379hb, ix(position()), (Object) this.f50379hb, ix(0), remaining());
        position(remaining());
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.DoubleBuffer
    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }
}
