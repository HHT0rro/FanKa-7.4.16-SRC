package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    private void gc() {
        int i10 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != DELETED) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.mGarbage = false;
        this.mSize = i11;
    }

    public void append(long j10, E e2) {
        int i10 = this.mSize;
        if (i10 != 0 && j10 <= this.mKeys[i10 - 1]) {
            put(j10, e2);
            return;
        }
        if (this.mGarbage && i10 >= this.mKeys.length) {
            gc();
        }
        int i11 = this.mSize;
        if (i11 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i11 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy((Object) jArr2, 0, (Object) jArr, 0, jArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        this.mKeys[i11] = j10;
        this.mValues[i11] = e2;
        this.mSize = i11 + 1;
    }

    public void clear() {
        int i10 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public boolean containsKey(long j10) {
        return indexOfKey(j10) >= 0;
    }

    public boolean containsValue(E e2) {
        return indexOfValue(e2) >= 0;
    }

    @Deprecated
    public void delete(long j10) {
        remove(j10);
    }

    @Nullable
    public E get(long j10) {
        return get(j10, null);
    }

    public int indexOfKey(long j10) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j10);
    }

    public int indexOfValue(E e2) {
        if (this.mGarbage) {
            gc();
        }
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (this.mValues[i10] == e2) {
                return i10;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i10) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i10];
    }

    public void put(long j10, E e2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j10);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e2;
            return;
        }
        int i10 = ~binarySearch;
        int i11 = this.mSize;
        if (i10 < i11) {
            Object[] objArr = this.mValues;
            if (objArr[i10] == DELETED) {
                this.mKeys[i10] = j10;
                objArr[i10] = e2;
                return;
            }
        }
        if (this.mGarbage && i11 >= this.mKeys.length) {
            gc();
            i10 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, j10);
        }
        int i12 = this.mSize;
        if (i12 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i12 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy((Object) jArr2, 0, (Object) jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i13 = this.mSize;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.mKeys;
            int i14 = i10 + 1;
            System.arraycopy((Object) jArr3, i10, (Object) jArr3, i14, i13 - i10);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i10, objArr4, i14, this.mSize - i10);
        }
        this.mKeys[i10] = j10;
        this.mValues[i10] = e2;
        this.mSize++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            put(longSparseArray.keyAt(i10), longSparseArray.valueAt(i10));
        }
    }

    @Nullable
    public E putIfAbsent(long j10, E e2) {
        E e10 = get(j10);
        if (e10 == null) {
            put(j10, e2);
        }
        return e10;
    }

    public void remove(long j10) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j10);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            Object obj = objArr[binarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public void removeAt(int i10) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i10];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.mGarbage = true;
        }
    }

    @Nullable
    public E replace(long j10, E e2) {
        int indexOfKey = indexOfKey(j10);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.mValues;
        E e10 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e2;
        return e10;
    }

    public void setValueAt(int i10, E e2) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i10] = e2;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.mSize * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(keyAt(i10));
            sb2.append('=');
            E valueAt = valueAt(i10);
            if (valueAt != this) {
                sb2.append((Object) valueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public E valueAt(int i10) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i10];
    }

    public LongSparseArray(int i10) {
        this.mGarbage = false;
        if (i10 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i10);
            this.mKeys = new long[idealLongArraySize];
            this.mValues = new Object[idealLongArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m1742clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E get(long j10, E e2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j10);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            if (objArr[binarySearch] != DELETED) {
                return (E) objArr[binarySearch];
            }
        }
        return e2;
    }

    public boolean replace(long j10, E e2, E e10) {
        int indexOfKey = indexOfKey(j10);
        if (indexOfKey < 0) {
            return false;
        }
        Object obj = this.mValues[indexOfKey];
        if (obj != e2 && (e2 == null || !e2.equals(obj))) {
            return false;
        }
        this.mValues[indexOfKey] = e10;
        return true;
    }

    public boolean remove(long j10, Object obj) {
        int indexOfKey = indexOfKey(j10);
        if (indexOfKey < 0) {
            return false;
        }
        E valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
