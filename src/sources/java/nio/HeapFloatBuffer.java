package java.nio;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HeapFloatBuffer extends FloatBuffer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapFloatBuffer(int cap, int lim) {
        this(cap, lim, false);
    }

    HeapFloatBuffer(int cap, int lim, boolean isReadOnly) {
        super(-1, 0, lim, cap, new float[cap], 0);
        this.isReadOnly = isReadOnly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapFloatBuffer(float[] buf, int off, int len) {
        this(buf, off, len, false);
    }

    HeapFloatBuffer(float[] buf, int off, int len, boolean isReadOnly) {
        super(-1, off, off + len, buf.length, buf, 0);
        this.isReadOnly = isReadOnly;
    }

    protected HeapFloatBuffer(float[] buf, int mark, int pos, int lim, int cap, int off) {
        this(buf, mark, pos, lim, cap, off, false);
    }

    protected HeapFloatBuffer(float[] buf, int mark, int pos, int lim, int cap, int off, boolean isReadOnly) {
        super(mark, pos, lim, cap, buf, off);
        this.isReadOnly = isReadOnly;
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public FloatBuffer slice() {
        return new HeapFloatBuffer(this.f50380hb, -1, 0, remaining(), remaining(), this.offset + position(), this.isReadOnly);
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public FloatBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapFloatBuffer(this.f50380hb, -1, 0, length, length, index + this.offset, this.isReadOnly);
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public FloatBuffer duplicate() {
        return new HeapFloatBuffer(this.f50380hb, markValue(), position(), limit(), capacity(), this.offset, this.isReadOnly);
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer asReadOnlyBuffer() {
        return new HeapFloatBuffer(this.f50380hb, markValue(), position(), limit(), capacity(), this.offset, true);
    }

    protected int ix(int i10) {
        return this.offset + i10;
    }

    @Override // java.nio.FloatBuffer
    public float get() {
        return this.f50380hb[ix(nextGetIndex())];
    }

    @Override // java.nio.FloatBuffer
    public float get(int i10) {
        return this.f50380hb[ix(checkIndex(i10))];
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer get(float[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy((Object) this.f50380hb, ix(position()), (Object) dst, offset, length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(float x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50380hb[ix(nextPutIndex())] = x10;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(int i10, float x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50380hb[ix(checkIndex(i10))] = x10;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(float[] src, int offset, int length) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy((Object) src, offset, (Object) this.f50380hb, ix(position()), length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(FloatBuffer src) {
        if (src == this) {
            throw createSameBufferException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (src instanceof HeapFloatBuffer) {
            HeapFloatBuffer sb2 = (HeapFloatBuffer) src;
            int n10 = sb2.remaining();
            if (n10 > remaining()) {
                throw new BufferOverflowException();
            }
            System.arraycopy((Object) sb2.f50380hb, sb2.ix(sb2.position()), (Object) this.f50380hb, ix(position()), n10);
            sb2.position(sb2.position() + n10);
            position(position() + n10);
        } else if (src.isDirect()) {
            int n11 = src.remaining();
            if (n11 > remaining()) {
                throw new BufferOverflowException();
            }
            src.get(this.f50380hb, ix(position()), n11);
            position(position() + n11);
        } else {
            super.put(src);
        }
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy((Object) this.f50380hb, ix(position()), (Object) this.f50380hb, ix(0), remaining());
        position(remaining());
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.FloatBuffer
    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }
}
