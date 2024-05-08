package java.nio;

import java.util.Objects;
import libcore.io.Memory;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class HeapByteBuffer extends ByteBuffer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapByteBuffer(int cap, int lim) {
        this(cap, lim, false);
    }

    private HeapByteBuffer(int cap, int lim, boolean isReadOnly) {
        super(-1, 0, lim, cap, new byte[cap], 0);
        this.isReadOnly = isReadOnly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapByteBuffer(byte[] buf, int off, int len) {
        this(buf, off, len, false);
    }

    private HeapByteBuffer(byte[] buf, int off, int len, boolean isReadOnly) {
        super(-1, off, off + len, buf.length, buf, 0);
        this.isReadOnly = isReadOnly;
    }

    private HeapByteBuffer(byte[] buf, int mark, int pos, int lim, int cap, int off, boolean isReadOnly) {
        super(mark, pos, lim, cap, buf, off);
        this.isReadOnly = isReadOnly;
    }

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public ByteBuffer slice() {
        return new HeapByteBuffer(this.f50371hb, -1, 0, remaining(), remaining(), this.offset + position(), this.isReadOnly);
    }

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public ByteBuffer slice(int index, int length) {
        Objects.checkFromIndexSize(index, length, limit());
        return new HeapByteBuffer(this.f50371hb, -1, 0, length, length, index + this.offset, this.isReadOnly);
    }

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public ByteBuffer duplicate() {
        return new HeapByteBuffer(this.f50371hb, markValue(), position(), limit(), capacity(), this.offset, this.isReadOnly);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer asReadOnlyBuffer() {
        return new HeapByteBuffer(this.f50371hb, markValue(), position(), limit(), capacity(), this.offset, true);
    }

    protected int ix(int i10) {
        return this.offset + i10;
    }

    @Override // java.nio.ByteBuffer
    public byte get() {
        return this.f50371hb[ix(nextGetIndex())];
    }

    @Override // java.nio.ByteBuffer
    public byte get(int i10) {
        return this.f50371hb[ix(checkIndex(i10))];
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer get(byte[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy((Object) this.f50371hb, ix(position()), (Object) dst, offset, length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(byte x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50371hb[ix(nextPutIndex())] = x10;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(int i10, byte x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50371hb[ix(checkIndex(i10))] = x10;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(byte[] src, int offset, int length) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy((Object) src, offset, (Object) this.f50371hb, ix(position()), length);
        position(position() + length);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy((Object) this.f50371hb, ix(position()), (Object) this.f50371hb, ix(0), remaining());
        position(remaining());
        limit(capacity());
        discardMark();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public byte _get(int i10) {
        return this.f50371hb[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void _put(int i10, byte b4) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.f50371hb[i10] = b4;
    }

    @Override // java.nio.ByteBuffer
    public char getChar() {
        return Bits.getChar(this, ix(nextGetIndex(2)), this.bigEndian);
    }

    @Override // java.nio.ByteBuffer
    public char getChar(int i10) {
        return Bits.getChar(this, ix(checkIndex(i10, 2)), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public char getCharUnchecked(int i10) {
        return Bits.getChar(this, ix(i10), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void getUnchecked(int pos, char[] dst, int dstOffset, int length) {
        Memory.unsafeBulkGet(dst, dstOffset, length * 2, this.f50371hb, ix(pos), 2, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putChar(char x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putChar(this, ix(nextPutIndex(2)), x10, this.bigEndian);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putChar(int i10, char x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putChar(this, ix(checkIndex(i10, 2)), x10, this.bigEndian);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putCharUnchecked(int i10, char x10) {
        Bits.putChar(this, ix(i10), x10, this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putUnchecked(int pos, char[] src, int srcOffset, int length) {
        Memory.unsafeBulkPut(this.f50371hb, ix(pos), length * 2, src, srcOffset, 2, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public CharBuffer asCharBuffer() {
        int size = remaining() >> 1;
        int off = position();
        return new ByteBufferAsCharBuffer(this, -1, 0, size, size, off, order());
    }

    @Override // java.nio.ByteBuffer
    public short getShort() {
        return Bits.getShort(this, ix(nextGetIndex(2)), this.bigEndian);
    }

    @Override // java.nio.ByteBuffer
    public short getShort(int i10) {
        return Bits.getShort(this, ix(checkIndex(i10, 2)), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public short getShortUnchecked(int i10) {
        return Bits.getShort(this, ix(i10), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void getUnchecked(int pos, short[] dst, int dstOffset, int length) {
        Memory.unsafeBulkGet(dst, dstOffset, length * 2, this.f50371hb, ix(pos), 2, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putShort(short x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putShort(this, ix(nextPutIndex(2)), x10, this.bigEndian);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putShort(int i10, short x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putShort(this, ix(checkIndex(i10, 2)), x10, this.bigEndian);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putShortUnchecked(int i10, short x10) {
        Bits.putShort(this, ix(i10), x10, this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putUnchecked(int pos, short[] src, int srcOffset, int length) {
        Memory.unsafeBulkPut(this.f50371hb, ix(pos), length * 2, src, srcOffset, 2, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public ShortBuffer asShortBuffer() {
        int size = remaining() >> 1;
        int off = position();
        return new ByteBufferAsShortBuffer(this, -1, 0, size, size, off, order());
    }

    @Override // java.nio.ByteBuffer
    public int getInt() {
        return Bits.getInt(this, ix(nextGetIndex(4)), this.bigEndian);
    }

    @Override // java.nio.ByteBuffer
    public int getInt(int i10) {
        return Bits.getInt(this, ix(checkIndex(i10, 4)), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public int getIntUnchecked(int i10) {
        return Bits.getInt(this, ix(i10), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void getUnchecked(int pos, int[] dst, int dstOffset, int length) {
        Memory.unsafeBulkGet(dst, dstOffset, length * 4, this.f50371hb, ix(pos), 4, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putInt(int x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putInt(this, ix(nextPutIndex(4)), x10, this.bigEndian);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putInt(int i10, int x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putInt(this, ix(checkIndex(i10, 4)), x10, this.bigEndian);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putIntUnchecked(int i10, int x10) {
        Bits.putInt(this, ix(i10), x10, this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putUnchecked(int pos, int[] src, int srcOffset, int length) {
        Memory.unsafeBulkPut(this.f50371hb, ix(pos), length * 4, src, srcOffset, 4, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public IntBuffer asIntBuffer() {
        int size = remaining() >> 2;
        int off = position();
        return new ByteBufferAsIntBuffer(this, -1, 0, size, size, off, order());
    }

    @Override // java.nio.ByteBuffer
    public long getLong() {
        return Bits.getLong(this, ix(nextGetIndex(8)), this.bigEndian);
    }

    @Override // java.nio.ByteBuffer
    public long getLong(int i10) {
        return Bits.getLong(this, ix(checkIndex(i10, 8)), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public long getLongUnchecked(int i10) {
        return Bits.getLong(this, ix(i10), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void getUnchecked(int pos, long[] dst, int dstOffset, int length) {
        Memory.unsafeBulkGet(dst, dstOffset, length * 8, this.f50371hb, ix(pos), 8, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putLong(long x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putLong(this, ix(nextPutIndex(8)), x10, this.bigEndian);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putLong(int i10, long x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putLong(this, ix(checkIndex(i10, 8)), x10, this.bigEndian);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putLongUnchecked(int i10, long x10) {
        Bits.putLong(this, ix(i10), x10, this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putUnchecked(int pos, long[] src, int srcOffset, int length) {
        Memory.unsafeBulkPut(this.f50371hb, ix(pos), length * 8, src, srcOffset, 8, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public LongBuffer asLongBuffer() {
        int size = remaining() >> 3;
        int off = position();
        return new ByteBufferAsLongBuffer(this, -1, 0, size, size, off, order());
    }

    @Override // java.nio.ByteBuffer
    public float getFloat() {
        return Bits.getFloat(this, ix(nextGetIndex(4)), this.bigEndian);
    }

    @Override // java.nio.ByteBuffer
    public float getFloat(int i10) {
        return Bits.getFloat(this, ix(checkIndex(i10, 4)), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public float getFloatUnchecked(int i10) {
        return Bits.getFloat(this, ix(i10), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void getUnchecked(int pos, float[] dst, int dstOffset, int length) {
        Memory.unsafeBulkGet(dst, dstOffset, length * 4, this.f50371hb, ix(pos), 4, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putFloat(float x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putFloat(this, ix(nextPutIndex(4)), x10, this.bigEndian);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putFloat(int i10, float x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putFloat(this, ix(checkIndex(i10, 4)), x10, this.bigEndian);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putFloatUnchecked(int i10, float x10) {
        Bits.putFloat(this, ix(i10), x10, this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putUnchecked(int pos, float[] src, int srcOffset, int length) {
        Memory.unsafeBulkPut(this.f50371hb, ix(pos), length * 4, src, srcOffset, 4, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public FloatBuffer asFloatBuffer() {
        int size = remaining() >> 2;
        int off = position();
        return new ByteBufferAsFloatBuffer(this, -1, 0, size, size, off, order());
    }

    @Override // java.nio.ByteBuffer
    public double getDouble() {
        return Bits.getDouble(this, ix(nextGetIndex(8)), this.bigEndian);
    }

    @Override // java.nio.ByteBuffer
    public double getDouble(int i10) {
        return Bits.getDouble(this, ix(checkIndex(i10, 8)), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public double getDoubleUnchecked(int i10) {
        return Bits.getDouble(this, ix(i10), this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void getUnchecked(int pos, double[] dst, int dstOffset, int length) {
        Memory.unsafeBulkGet(dst, dstOffset, length * 8, this.f50371hb, ix(pos), 8, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putDouble(double x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putDouble(this, ix(nextPutIndex(8)), x10, this.bigEndian);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer putDouble(int i10, double x10) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        Bits.putDouble(this, ix(checkIndex(i10, 8)), x10, this.bigEndian);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putDoubleUnchecked(int i10, double x10) {
        Bits.putDouble(this, ix(i10), x10, this.bigEndian);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putUnchecked(int pos, double[] src, int srcOffset, int length) {
        Memory.unsafeBulkPut(this.f50371hb, ix(pos), length * 8, src, srcOffset, 8, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public DoubleBuffer asDoubleBuffer() {
        int size = remaining() >> 3;
        int off = position();
        return new ByteBufferAsDoubleBuffer(this, -1, 0, size, size, off, order());
    }
}
