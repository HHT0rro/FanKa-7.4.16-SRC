package java.nio;

import java.nio.DirectByteBuffer;
import jdk.internal.misc.Unsafe;
import libcore.io.Memory;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ByteBuffer extends Buffer implements Comparable<ByteBuffer> {
    boolean bigEndian;

    /* renamed from: hb, reason: collision with root package name */
    final byte[] f50371hb;
    boolean isReadOnly;
    boolean nativeByteOrder;
    final int offset;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte _get(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void _put(int i10, byte b4);

    public abstract CharBuffer asCharBuffer();

    public abstract DoubleBuffer asDoubleBuffer();

    public abstract FloatBuffer asFloatBuffer();

    public abstract IntBuffer asIntBuffer();

    public abstract LongBuffer asLongBuffer();

    public abstract ByteBuffer asReadOnlyBuffer();

    public abstract ShortBuffer asShortBuffer();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ ByteBuffer clear() {
        return (ByteBuffer) clear();
    }

    public abstract ByteBuffer compact();

    @Override // java.nio.Buffer
    public abstract ByteBuffer duplicate();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ ByteBuffer flip() {
        return (ByteBuffer) flip();
    }

    public abstract byte get();

    public abstract byte get(int i10);

    public abstract char getChar();

    public abstract char getChar(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract char getCharUnchecked(int i10);

    public abstract double getDouble();

    public abstract double getDouble(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getDoubleUnchecked(int i10);

    public abstract float getFloat();

    public abstract float getFloat(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float getFloatUnchecked(int i10);

    public abstract int getInt();

    public abstract int getInt(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getIntUnchecked(int i10);

    public abstract long getLong();

    public abstract long getLong(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getLongUnchecked(int i10);

    public abstract short getShort();

    public abstract short getShort(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract short getShortUnchecked(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void getUnchecked(int i10, char[] cArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void getUnchecked(int i10, double[] dArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void getUnchecked(int i10, float[] fArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void getUnchecked(int i10, int[] iArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void getUnchecked(int i10, long[] jArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void getUnchecked(int i10, short[] sArr, int i11, int i12);

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ ByteBuffer limit(int i10) {
        return (ByteBuffer) limit(i10);
    }

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ ByteBuffer mark() {
        return (ByteBuffer) mark();
    }

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ ByteBuffer position(int i10) {
        return (ByteBuffer) position(i10);
    }

    public abstract ByteBuffer put(byte b4);

    public abstract ByteBuffer put(int i10, byte b4);

    public abstract ByteBuffer putChar(char c4);

    public abstract ByteBuffer putChar(int i10, char c4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putCharUnchecked(int i10, char c4);

    public abstract ByteBuffer putDouble(double d10);

    public abstract ByteBuffer putDouble(int i10, double d10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putDoubleUnchecked(int i10, double d10);

    public abstract ByteBuffer putFloat(float f10);

    public abstract ByteBuffer putFloat(int i10, float f10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putFloatUnchecked(int i10, float f10);

    public abstract ByteBuffer putInt(int i10);

    public abstract ByteBuffer putInt(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putIntUnchecked(int i10, int i11);

    public abstract ByteBuffer putLong(int i10, long j10);

    public abstract ByteBuffer putLong(long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putLongUnchecked(int i10, long j10);

    public abstract ByteBuffer putShort(int i10, short s2);

    public abstract ByteBuffer putShort(short s2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putShortUnchecked(int i10, short s2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putUnchecked(int i10, char[] cArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putUnchecked(int i10, double[] dArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putUnchecked(int i10, float[] fArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putUnchecked(int i10, int[] iArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putUnchecked(int i10, long[] jArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putUnchecked(int i10, short[] sArr, int i11, int i12);

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ ByteBuffer reset() {
        return (ByteBuffer) reset();
    }

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ ByteBuffer rewind() {
        return (ByteBuffer) rewind();
    }

    @Override // java.nio.Buffer
    public abstract ByteBuffer slice();

    @Override // java.nio.Buffer
    public abstract ByteBuffer slice(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer(int mark, int pos, int lim, int cap, byte[] hb2, int offset) {
        super(mark, pos, lim, cap, 0);
        this.bigEndian = true;
        this.nativeByteOrder = Bits.byteOrder() == ByteOrder.BIG_ENDIAN;
        this.f50371hb = hb2;
        this.offset = offset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer(int mark, int pos, int lim, int cap) {
        this(mark, pos, lim, cap, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.Buffer
    public Object base() {
        return this.f50371hb;
    }

    public static ByteBuffer allocateDirect(int capacity) {
        DirectByteBuffer.MemoryRef memoryRef = new DirectByteBuffer.MemoryRef(capacity);
        return new DirectByteBuffer(capacity, memoryRef);
    }

    public static ByteBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw createCapacityException(capacity);
        }
        return new HeapByteBuffer(capacity, capacity);
    }

    public static ByteBuffer wrap(byte[] array, int offset, int length) {
        try {
            return new HeapByteBuffer(array, offset, length);
        } catch (IllegalArgumentException e2) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static ByteBuffer wrap(byte[] array) {
        return wrap(array, 0, array.length);
    }

    public ByteBuffer get(byte[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        int end = offset + length;
        for (int i10 = offset; i10 < end; i10++) {
            dst[i10] = get();
        }
        return this;
    }

    public ByteBuffer get(byte[] dst) {
        return get(dst, 0, dst.length);
    }

    public ByteBuffer put(ByteBuffer src) {
        int dstOffset;
        byte[] bArr;
        if (src == this) {
            throw createSameBufferException();
        }
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int n10 = src.remaining();
        if (n10 > remaining()) {
            throw new BufferOverflowException();
        }
        if (this.f50371hb != null && (bArr = src.f50371hb) != null) {
            System.arraycopy((Object) bArr, src.position() + src.offset, (Object) this.f50371hb, position() + this.offset, n10);
        } else {
            Object srcObject = src.isDirect() ? src : src.f50371hb;
            int srcOffset = src.position();
            if (!src.isDirect()) {
                srcOffset += src.offset;
            }
            Object dstObject = isDirect() ? this : this.f50371hb;
            int dstOffset2 = position();
            if (isDirect()) {
                dstOffset = dstOffset2;
            } else {
                dstOffset = dstOffset2 + this.offset;
            }
            Memory.memmove(dstObject, dstOffset, srcObject, srcOffset, n10);
        }
        src.position(src.limit());
        position(position() + n10);
        return this;
    }

    public ByteBuffer put(byte[] src, int offset, int length) {
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        int end = offset + length;
        for (int i10 = offset; i10 < end; i10++) {
            put(src[i10]);
        }
        return this;
    }

    public final ByteBuffer put(byte[] src) {
        return put(src, 0, src.length);
    }

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return (this.f50371hb == null || this.isReadOnly) ? false : true;
    }

    @Override // java.nio.Buffer
    public final byte[] array() {
        byte[] bArr = this.f50371hb;
        if (bArr == null) {
            throw new UnsupportedOperationException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return bArr;
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        if (this.f50371hb == null) {
            throw new UnsupportedOperationException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.offset;
    }

    @Override // java.nio.Buffer
    public Buffer position(int newPosition) {
        return super.position(newPosition);
    }

    @Override // java.nio.Buffer
    public Buffer limit(int newLimit) {
        return super.limit(newLimit);
    }

    @Override // java.nio.Buffer
    public Buffer mark() {
        return super.mark();
    }

    @Override // java.nio.Buffer
    public Buffer reset() {
        return super.reset();
    }

    @Override // java.nio.Buffer
    public Buffer clear() {
        return super.clear();
    }

    @Override // java.nio.Buffer
    public Buffer flip() {
        return super.flip();
    }

    @Override // java.nio.Buffer
    public Buffer rewind() {
        return super.rewind();
    }

    public String toString() {
        StringBuffer sb2 = new StringBuffer();
        sb2.append(getClass().getName());
        sb2.append("[pos=");
        sb2.append(position());
        sb2.append(" lim=");
        sb2.append(limit());
        sb2.append(" cap=");
        sb2.append(capacity());
        sb2.append("]");
        return sb2.toString();
    }

    public int hashCode() {
        int h10 = 1;
        int p10 = position();
        for (int i10 = limit() - 1; i10 >= p10; i10--) {
            h10 = (h10 * 31) + get(i10);
        }
        return h10;
    }

    public boolean equals(Object ob2) {
        if (this == ob2) {
            return true;
        }
        if (!(ob2 instanceof ByteBuffer)) {
            return false;
        }
        ByteBuffer that = (ByteBuffer) ob2;
        if (remaining() != that.remaining()) {
            return false;
        }
        int p10 = position();
        int i10 = limit() - 1;
        int j10 = that.limit() - 1;
        while (i10 >= p10) {
            if (!equals(get(i10), that.get(j10))) {
                return false;
            }
            i10--;
            j10--;
        }
        return true;
    }

    private static boolean equals(byte x10, byte y10) {
        return x10 == y10;
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteBuffer that) {
        int n10 = position() + Math.min(remaining(), that.remaining());
        int i10 = position();
        int j10 = that.position();
        while (i10 < n10) {
            int cmp = compare(get(i10), that.get(j10));
            if (cmp == 0) {
                i10++;
                j10++;
            } else {
                return cmp;
            }
        }
        int i11 = remaining();
        return i11 - that.remaining();
    }

    private static int compare(byte x10, byte y10) {
        return Byte.compare(x10, y10);
    }

    public int mismatch(ByteBuffer that) {
        int thisPos = position();
        int thisRem = limit() - thisPos;
        int thatPos = that.position();
        int thatRem = that.limit() - thatPos;
        int length = Math.min(thisRem, thatRem);
        if (length < 0) {
            return -1;
        }
        int r10 = BufferMismatch.mismatch(this, thisPos, that, thatPos, length);
        return (r10 != -1 || thisRem == thatRem) ? r10 : length;
    }

    public final ByteOrder order() {
        return this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
    }

    public final ByteBuffer order(ByteOrder bo) {
        boolean z10 = bo == ByteOrder.BIG_ENDIAN;
        this.bigEndian = z10;
        this.nativeByteOrder = z10 == (Bits.byteOrder() == ByteOrder.BIG_ENDIAN);
        return this;
    }

    public final int alignmentOffset(int index, int unitSize) {
        if (index < 0) {
            throw new IllegalArgumentException("Index less than zero: " + index);
        }
        if (unitSize < 1 || ((unitSize - 1) & unitSize) != 0) {
            throw new IllegalArgumentException("Unit size not a power of two: " + unitSize);
        }
        if (unitSize > 8 && !isDirect()) {
            throw new UnsupportedOperationException("Unit size unsupported for non-direct buffers: " + unitSize);
        }
        long baseAddress = isDirect() ? this.address : Unsafe.getUnsafe().arrayBaseOffset(byte[].class) + this.offset;
        long elementAddress = index + baseAddress;
        return (int) ((unitSize - 1) & elementAddress);
    }

    public final ByteBuffer alignedSlice(int unitSize) {
        int aligned_pos;
        int pos = position();
        int lim = limit();
        int pos_mod = alignmentOffset(pos, unitSize);
        int lim_mod = alignmentOffset(lim, unitSize);
        if (pos_mod > 0) {
            aligned_pos = (unitSize - pos_mod) + pos;
        } else {
            aligned_pos = pos;
        }
        int aligned_lim = lim - lim_mod;
        if (aligned_pos > lim || aligned_lim < pos) {
            aligned_lim = pos;
            aligned_pos = pos;
        }
        return slice(aligned_pos, aligned_lim - aligned_pos);
    }

    public boolean isAccessible() {
        return true;
    }

    public void setAccessible(boolean value) {
        throw new UnsupportedOperationException();
    }
}
