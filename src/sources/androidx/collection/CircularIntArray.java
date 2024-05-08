package androidx.collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] iArr = this.mElements;
        int length = iArr.length;
        int i10 = this.mHead;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 >= 0) {
            int[] iArr2 = new int[i12];
            System.arraycopy((Object) iArr, i10, (Object) iArr2, 0, i11);
            System.arraycopy((Object) this.mElements, 0, (Object) iArr2, i11, this.mHead);
            this.mElements = iArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i12 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(int i10) {
        int i11 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i11;
        this.mElements[i11] = i10;
        if (i11 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i10) {
        int[] iArr = this.mElements;
        int i11 = this.mTail;
        iArr[i11] = i10;
        int i12 = this.mCapacityBitmask & (i11 + 1);
        this.mTail = i12;
        if (i12 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int i10) {
        if (i10 >= 0 && i10 < size()) {
            return this.mElements[this.mCapacityBitmask & (this.mHead + i10)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        int i10 = this.mHead;
        if (i10 != this.mTail) {
            return this.mElements[i10];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i10 = this.mHead;
        int i11 = this.mTail;
        if (i10 != i11) {
            return this.mElements[(i11 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public int popFirst() {
        int i10 = this.mHead;
        if (i10 != this.mTail) {
            int i11 = this.mElements[i10];
            this.mHead = (i10 + 1) & this.mCapacityBitmask;
            return i11;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i10 = this.mHead;
        int i11 = this.mTail;
        if (i10 != i11) {
            int i12 = this.mCapacityBitmask & (i11 - 1);
            int i13 = this.mElements[i12];
            this.mTail = i12;
            return i13;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 <= size()) {
            this.mTail = this.mCapacityBitmask & (this.mTail - i10);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 <= size()) {
            this.mHead = this.mCapacityBitmask & (this.mHead + i10);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularIntArray(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i10 <= 1073741824) {
            i10 = Integer.bitCount(i10) != 1 ? Integer.highestOneBit(i10 - 1) << 1 : i10;
            this.mCapacityBitmask = i10 - 1;
            this.mElements = new int[i10];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
