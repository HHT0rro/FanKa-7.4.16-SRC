package java.nio;

import java.util.Objects;
import libcore.io.Memory;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ByteBufferAsFloatBuffer extends FloatBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: bb, reason: collision with root package name */
    protected final ByteBuffer f50374bb;
    protected final int offset;
    private final ByteOrder order;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBufferAsFloatBuffer(ByteBuffer bb2, int mark, int pos, int lim, int cap, int off, ByteOrder order) {
        super(mark, pos, lim, cap);
        ByteBuffer duplicate = bb2.duplicate();
        this.f50374bb = duplicate;
        this.isReadOnly = bb2.isReadOnly;
        if (bb2 instanceof DirectByteBuffer) {
            this.address = bb2.address + off;
        }
        duplicate.order(order);
        this.order = order;
        this.offset = off;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public Object base() {
        return this.f50374bb.f50371hb;
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public FloatBuffer slice() {
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        int off = (pos << 2) + this.offset;
        return new ByteBufferAsFloatBuffer(this.f50374bb, -1, 0, rem, rem, off, this.order);
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public FloatBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new ByteBufferAsFloatBuffer(this.f50374bb, -1, 0, length, length, this.offset, this.order);
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public FloatBuffer duplicate() {
        return new ByteBufferAsFloatBuffer(this.f50374bb, markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer asReadOnlyBuffer() {
        return new ByteBufferAsFloatBuffer(this.f50374bb.asReadOnlyBuffer(), markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    protected int ix(int i10) {
        return (i10 << 2) + this.offset;
    }

    @Override // java.nio.FloatBuffer
    public float get() {
        return get(nextGetIndex());
    }

    @Override // java.nio.FloatBuffer
    public float get(int i10) {
        return this.f50374bb.getFloatUnchecked(ix(checkIndex(i10)));
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer get(float[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        this.f50374bb.getUnchecked(ix(this.position), dst, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(float x10) {
        put(nextPutIndex(), x10);
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(int i10, float x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50374bb.putFloatUnchecked(ix(checkIndex(i10)), x10);
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer put(float[] src, int offset, int length) {
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        this.f50374bb.putUnchecked(ix(this.position), src, offset, length);
        this.position += length;
        return this;
    }

    @Override // java.nio.FloatBuffer
    public FloatBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        ByteBuffer byteBuffer = this.f50374bb;
        if (!(byteBuffer instanceof DirectByteBuffer)) {
            System.arraycopy((Object) byteBuffer.array(), ix(pos), (Object) this.f50374bb.array(), ix(0), rem << 2);
        } else {
            Memory.memmove(this, ix(0), this, ix(pos), rem << 2);
        }
        position(rem);
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.FloatBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.f50374bb.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.FloatBuffer
    public ByteOrder order() {
        return this.order;
    }
}
