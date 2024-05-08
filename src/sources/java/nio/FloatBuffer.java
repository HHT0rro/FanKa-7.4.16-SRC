package java.nio;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FloatBuffer extends Buffer implements Comparable<FloatBuffer> {

    /* renamed from: hb, reason: collision with root package name */
    final float[] f50380hb;
    boolean isReadOnly;
    final int offset;

    public abstract FloatBuffer asReadOnlyBuffer();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ FloatBuffer clear() {
        return (FloatBuffer) clear();
    }

    public abstract FloatBuffer compact();

    @Override // java.nio.Buffer
    public abstract FloatBuffer duplicate();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ FloatBuffer flip() {
        return (FloatBuffer) flip();
    }

    public abstract float get();

    public abstract float get(int i10);

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ FloatBuffer limit(int i10) {
        return (FloatBuffer) limit(i10);
    }

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ FloatBuffer mark() {
        return (FloatBuffer) mark();
    }

    public abstract ByteOrder order();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ FloatBuffer position(int i10) {
        return (FloatBuffer) position(i10);
    }

    public abstract FloatBuffer put(float f10);

    public abstract FloatBuffer put(int i10, float f10);

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ FloatBuffer reset() {
        return (FloatBuffer) reset();
    }

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ FloatBuffer rewind() {
        return (FloatBuffer) rewind();
    }

    @Override // java.nio.Buffer
    public abstract FloatBuffer slice();

    @Override // java.nio.Buffer
    public abstract FloatBuffer slice(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatBuffer(int mark, int pos, int lim, int cap, float[] hb2, int offset) {
        super(mark, pos, lim, cap, 2);
        this.f50380hb = hb2;
        this.offset = offset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatBuffer(int mark, int pos, int lim, int cap) {
        this(mark, pos, lim, cap, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.Buffer
    public Object base() {
        return this.f50380hb;
    }

    public static FloatBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw createCapacityException(capacity);
        }
        return new HeapFloatBuffer(capacity, capacity);
    }

    public static FloatBuffer wrap(float[] array, int offset, int length) {
        try {
            return new HeapFloatBuffer(array, offset, length);
        } catch (IllegalArgumentException e2) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static FloatBuffer wrap(float[] array) {
        return wrap(array, 0, array.length);
    }

    public FloatBuffer get(float[] dst, int offset, int length) {
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

    public FloatBuffer get(float[] dst) {
        return get(dst, 0, dst.length);
    }

    public FloatBuffer put(FloatBuffer src) {
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
        for (int i10 = 0; i10 < n10; i10++) {
            put(src.get());
        }
        return this;
    }

    public FloatBuffer put(float[] src, int offset, int length) {
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

    public final FloatBuffer put(float[] src) {
        return put(src, 0, src.length);
    }

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return (this.f50380hb == null || this.isReadOnly) ? false : true;
    }

    @Override // java.nio.Buffer
    public final float[] array() {
        float[] fArr = this.f50380hb;
        if (fArr == null) {
            throw new UnsupportedOperationException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return fArr;
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        if (this.f50380hb == null) {
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
            h10 = (h10 * 31) + ((int) get(i10));
        }
        return h10;
    }

    public boolean equals(Object ob2) {
        if (this == ob2) {
            return true;
        }
        if (!(ob2 instanceof FloatBuffer)) {
            return false;
        }
        FloatBuffer that = (FloatBuffer) ob2;
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

    private static boolean equals(float x10, float y10) {
        return x10 == y10 || (Float.isNaN(x10) && Float.isNaN(y10));
    }

    @Override // java.lang.Comparable
    public int compareTo(FloatBuffer that) {
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

    private static int compare(float x10, float y10) {
        if (x10 < y10) {
            return -1;
        }
        if (x10 > y10) {
            return 1;
        }
        if (x10 == y10) {
            return 0;
        }
        if (Float.isNaN(x10)) {
            return Float.isNaN(y10) ? 0 : 1;
        }
        return -1;
    }

    public int mismatch(FloatBuffer that) {
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
}
