package com.android.framework.protobuf.nano;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class FieldArray implements Cloneable {
    private static final FieldData DELETED = new FieldData();
    private FieldData[] mData;
    private int[] mFieldNumbers;
    private boolean mGarbage;
    private int mSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldArray() {
        this(10);
    }

    FieldArray(int initialCapacity) {
        this.mGarbage = false;
        int initialCapacity2 = idealIntArraySize(initialCapacity);
        this.mFieldNumbers = new int[initialCapacity2];
        this.mData = new FieldData[initialCapacity2];
        this.mSize = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldData get(int fieldNumber) {
        FieldData fieldData;
        int i10 = binarySearch(fieldNumber);
        if (i10 < 0 || (fieldData = this.mData[i10]) == DELETED) {
            return null;
        }
        return fieldData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(int fieldNumber) {
        int i10 = binarySearch(fieldNumber);
        if (i10 >= 0) {
            FieldData[] fieldDataArr = this.mData;
            FieldData fieldData = fieldDataArr[i10];
            FieldData fieldData2 = DELETED;
            if (fieldData != fieldData2) {
                fieldDataArr[i10] = fieldData2;
                this.mGarbage = true;
            }
        }
    }

    private void gc() {
        int n10 = this.mSize;
        int o10 = 0;
        int[] keys = this.mFieldNumbers;
        FieldData[] values = this.mData;
        for (int i10 = 0; i10 < n10; i10++) {
            FieldData val = values[i10];
            if (val != DELETED) {
                if (i10 != o10) {
                    keys[o10] = keys[i10];
                    values[o10] = val;
                    values[i10] = null;
                }
                o10++;
            }
        }
        this.mGarbage = false;
        this.mSize = o10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put(int fieldNumber, FieldData data) {
        int i10 = binarySearch(fieldNumber);
        if (i10 >= 0) {
            this.mData[i10] = data;
            return;
        }
        int i11 = ~i10;
        int i12 = this.mSize;
        if (i11 < i12) {
            FieldData[] fieldDataArr = this.mData;
            if (fieldDataArr[i11] == DELETED) {
                this.mFieldNumbers[i11] = fieldNumber;
                fieldDataArr[i11] = data;
                return;
            }
        }
        if (this.mGarbage && i12 >= this.mFieldNumbers.length) {
            gc();
            i11 = ~binarySearch(fieldNumber);
        }
        int i13 = this.mSize;
        if (i13 >= this.mFieldNumbers.length) {
            int n10 = idealIntArraySize(i13 + 1);
            int[] nkeys = new int[n10];
            FieldData[] nvalues = new FieldData[n10];
            int[] iArr = this.mFieldNumbers;
            System.arraycopy((Object) iArr, 0, (Object) nkeys, 0, iArr.length);
            FieldData[] fieldDataArr2 = this.mData;
            System.arraycopy(fieldDataArr2, 0, nvalues, 0, fieldDataArr2.length);
            this.mFieldNumbers = nkeys;
            this.mData = nvalues;
        }
        int n11 = this.mSize;
        if (n11 - i11 != 0) {
            int[] iArr2 = this.mFieldNumbers;
            System.arraycopy((Object) iArr2, i11, (Object) iArr2, i11 + 1, n11 - i11);
            FieldData[] fieldDataArr3 = this.mData;
            System.arraycopy(fieldDataArr3, i11, fieldDataArr3, i11 + 1, this.mSize - i11);
        }
        this.mFieldNumbers[i11] = fieldNumber;
        this.mData[i11] = data;
        this.mSize++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldData dataAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        return this.mData[index];
    }

    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof FieldArray)) {
            return false;
        }
        FieldArray other = (FieldArray) o10;
        if (size() != other.size()) {
            return false;
        }
        return arrayEquals(this.mFieldNumbers, other.mFieldNumbers, this.mSize) && arrayEquals(this.mData, other.mData, this.mSize);
    }

    public int hashCode() {
        if (this.mGarbage) {
            gc();
        }
        int result = 17;
        for (int i10 = 0; i10 < this.mSize; i10++) {
            result = (((result * 31) + this.mFieldNumbers[i10]) * 31) + this.mData[i10].hashCode();
        }
        return result;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private int idealByteArraySize(int need) {
        for (int i10 = 4; i10 < 32; i10++) {
            if (need <= (1 << i10) - 12) {
                return (1 << i10) - 12;
            }
        }
        return need;
    }

    private int binarySearch(int value) {
        int lo = 0;
        int hi = this.mSize - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midVal = this.mFieldNumbers[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return ~lo;
    }

    private boolean arrayEquals(int[] a10, int[] b4, int size) {
        for (int i10 = 0; i10 < size; i10++) {
            if (a10[i10] != b4[i10]) {
                return false;
            }
        }
        return true;
    }

    private boolean arrayEquals(FieldData[] a10, FieldData[] b4, int size) {
        for (int i10 = 0; i10 < size; i10++) {
            if (!a10[i10].equals(b4[i10])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final FieldArray m1999clone() {
        int size = size();
        FieldArray clone = new FieldArray(size);
        System.arraycopy((Object) this.mFieldNumbers, 0, (Object) clone.mFieldNumbers, 0, size);
        for (int i10 = 0; i10 < size; i10++) {
            FieldData fieldData = this.mData[i10];
            if (fieldData != null) {
                clone.mData[i10] = fieldData.m2000clone();
            }
        }
        clone.mSize = size;
        return clone;
    }
}
