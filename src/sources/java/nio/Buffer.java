package java.nio;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Buffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int SPLITERATOR_CHARACTERISTICS = 16464;
    final int _elementSizeShift;
    long address;
    private int capacity;
    private int limit;
    private int mark;
    int position = 0;

    public abstract Object array();

    public abstract int arrayOffset();

    abstract Object base();

    public abstract Buffer duplicate();

    public abstract boolean hasArray();

    public abstract boolean isDirect();

    public abstract boolean isReadOnly();

    public abstract Buffer slice();

    public abstract Buffer slice(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Buffer(int mark, int pos, int lim, int cap, int elementSizeShift) {
        this.mark = -1;
        if (cap < 0) {
            throw new IllegalArgumentException("Negative capacity: " + cap);
        }
        this.capacity = cap;
        limit(lim);
        position(pos);
        if (mark >= 0) {
            if (mark > pos) {
                throw new IllegalArgumentException("mark > position: (" + mark + " > " + pos + ")");
            }
            this.mark = mark;
        }
        this._elementSizeShift = elementSizeShift;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException createSameBufferException() {
        return new IllegalArgumentException("The source buffer is this buffer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException createCapacityException(int capacity) {
        return new IllegalArgumentException("capacity < 0: (" + capacity + " < 0)");
    }

    public final int capacity() {
        return this.capacity;
    }

    public final int position() {
        return this.position;
    }

    public Buffer position(int newPosition) {
        if (newPosition > this.limit || newPosition < 0) {
            throw new IllegalArgumentException("Bad position " + newPosition + "/" + this.limit);
        }
        this.position = newPosition;
        if (this.mark > newPosition) {
            this.mark = -1;
        }
        return this;
    }

    private IllegalArgumentException createPositionException(int newPosition) {
        String msg;
        if (newPosition > this.limit) {
            msg = "newPosition > limit: (" + newPosition + " > " + this.limit + ")";
        } else {
            msg = "newPosition < 0: (" + newPosition + " < 0)";
        }
        return new IllegalArgumentException(msg);
    }

    public final int limit() {
        return this.limit;
    }

    public Buffer limit(int newLimit) {
        if ((newLimit > this.capacity) | (newLimit < 0)) {
            throw createLimitException(newLimit);
        }
        this.limit = newLimit;
        if (this.position > newLimit) {
            this.position = newLimit;
        }
        if (this.mark > newLimit) {
            this.mark = -1;
        }
        return this;
    }

    private IllegalArgumentException createLimitException(int newLimit) {
        String msg;
        if (newLimit > this.capacity) {
            msg = "newLimit > capacity: (" + newLimit + " > " + this.capacity + ")";
        } else {
            msg = "newLimit < 0: (" + newLimit + " < 0)";
        }
        return new IllegalArgumentException(msg);
    }

    public Buffer mark() {
        this.mark = this.position;
        return this;
    }

    public Buffer reset() {
        int m10 = this.mark;
        if (m10 < 0) {
            throw new InvalidMarkException();
        }
        this.position = m10;
        return this;
    }

    public Buffer clear() {
        this.position = 0;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    public Buffer flip() {
        this.limit = this.position;
        this.position = 0;
        this.mark = -1;
        return this;
    }

    public Buffer rewind() {
        this.position = 0;
        this.mark = -1;
        return this;
    }

    public final int remaining() {
        return this.limit - this.position;
    }

    public final boolean hasRemaining() {
        return this.position < this.limit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int nextGetIndex() {
        int i10 = this.position;
        if (i10 >= this.limit) {
            throw new BufferUnderflowException();
        }
        this.position = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int nextGetIndex(int nb2) {
        int i10 = this.limit;
        int i11 = this.position;
        if (i10 - i11 < nb2) {
            throw new BufferUnderflowException();
        }
        int p10 = this.position;
        this.position = i11 + nb2;
        return p10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int nextPutIndex() {
        int i10 = this.position;
        if (i10 >= this.limit) {
            throw new BufferOverflowException();
        }
        this.position = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int nextPutIndex(int nb2) {
        int i10 = this.limit;
        int i11 = this.position;
        if (i10 - i11 < nb2) {
            throw new BufferOverflowException();
        }
        int p10 = this.position;
        this.position = i11 + nb2;
        return p10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int checkIndex(int i10) {
        if (i10 < 0 || i10 >= this.limit) {
            throw new IndexOutOfBoundsException("index=" + i10 + " out of bounds (limit=" + this.limit + ")");
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int checkIndex(int i10, int nb2) {
        if (i10 < 0 || nb2 > this.limit - i10) {
            throw new IndexOutOfBoundsException("index=" + i10 + " out of bounds (limit=" + this.limit + ", nb=" + nb2 + ")");
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int markValue() {
        return this.mark;
    }

    final void truncate() {
        this.mark = -1;
        this.position = 0;
        this.limit = 0;
        this.capacity = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void discardMark() {
        this.mark = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkBounds(int off, int len, int size) {
        if ((off | len | (off + len) | (size - (off + len))) < 0) {
            throw new IndexOutOfBoundsException("off=" + off + ", len=" + len + " out of bounds (size=" + size + ")");
        }
    }

    public int getElementSizeShift() {
        return this._elementSizeShift;
    }
}
