package java.nio;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HeapIntBuffer extends IntBuffer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapIntBuffer(int cap, int lim) {
        this(cap, lim, false);
    }

    HeapIntBuffer(int cap, int lim, boolean isReadOnly) {
        super(-1, 0, lim, cap, new int[cap], 0);
        this.isReadOnly = isReadOnly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapIntBuffer(int[] buf, int off, int len) {
        this(buf, off, len, false);
    }

    HeapIntBuffer(int[] buf, int off, int len, boolean isReadOnly) {
        super(-1, off, off + len, buf.length, buf, 0);
        this.isReadOnly = isReadOnly;
    }

    protected HeapIntBuffer(int[] buf, int mark, int pos, int lim, int cap, int off) {
        this(buf, mark, pos, lim, cap, off, false);
    }

    protected HeapIntBuffer(int[] buf, int mark, int pos, int lim, int cap, int off, boolean isReadOnly) {
        super(mark, pos, lim, cap, buf, off);
        this.isReadOnly = isReadOnly;
    }

    @Override // java.nio.IntBuffer, java.nio.Buffer
    public IntBuffer slice() {
        return new HeapIntBuffer(this.f50381hb, -1, 0, remaining(), remaining(), this.offset + position(), this.isReadOnly);
    }

    @Override // java.nio.IntBuffer, java.nio.Buffer
    public IntBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapIntBuffer(this.f50381hb, -1, 0, length, length, index + this.offset, this.isReadOnly);
    }

    @Override // java.nio.IntBuffer, java.nio.Buffer
    public IntBuffer duplicate() {
        return new HeapIntBuffer(this.f50381hb, markValue(), position(), limit(), capacity(), this.offset, this.isReadOnly);
    }

    @Override // java.nio.IntBuffer
    public IntBuffer asReadOnlyBuffer() {
        return new HeapIntBuffer(this.f50381hb, markValue(), position(), limit(), capacity(), this.offset, true);
    }

    protected int ix(int i10) {
        return this.offset + i10;
    }

    @Override // java.nio.IntBuffer
    public int get() {
        return this.f50381hb[ix(nextGetIndex())];
    }

    @Override // java.nio.IntBuffer
    public int get(int i10) {
        return this.f50381hb[ix(checkIndex(i10))];
    }

    @Override // java.nio.IntBuffer
    public IntBuffer get(int[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy((Object) this.f50381hb, ix(position()), (Object) dst, offset, length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.IntBuffer, java.nio.Buffer
    public boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50381hb[ix(nextPutIndex())] = x10;
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int i10, int x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50381hb[ix(checkIndex(i10))] = x10;
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(int[] src, int offset, int length) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy((Object) src, offset, (Object) this.f50381hb, ix(position()), length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer put(IntBuffer src) {
        if (src == this) {
            throw createSameBufferException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (src instanceof HeapIntBuffer) {
            HeapIntBuffer sb2 = (HeapIntBuffer) src;
            int n10 = sb2.remaining();
            if (n10 > remaining()) {
                throw new BufferOverflowException();
            }
            System.arraycopy((Object) sb2.f50381hb, sb2.ix(sb2.position()), (Object) this.f50381hb, ix(position()), n10);
            sb2.position(sb2.position() + n10);
            position(position() + n10);
        } else if (src.isDirect()) {
            int n11 = src.remaining();
            if (n11 > remaining()) {
                throw new BufferOverflowException();
            }
            src.get(this.f50381hb, ix(position()), n11);
            position(position() + n11);
        } else {
            super.put(src);
        }
        return this;
    }

    @Override // java.nio.IntBuffer
    public IntBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy((Object) this.f50381hb, ix(position()), (Object) this.f50381hb, ix(0), remaining());
        position(remaining());
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.IntBuffer
    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }
}
