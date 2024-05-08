package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    private void gc() {
        int i10 = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != DELETED) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.mGarbage = false;
        this.mSize = i11;
    }

    public void append(int i10, E e2) {
        int i11 = this.mSize;
        if (i11 != 0 && i10 <= this.mKeys[i11 - 1]) {
            put(i10, e2);
            return;
        }
        if (this.mGarbage && i11 >= this.mKeys.length) {
            gc();
        }
        int i12 = this.mSize;
        if (i12 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i12 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy((Object) iArr2, 0, (Object) iArr, 0, iArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        this.mKeys[i12] = i10;
        this.mValues[i12] = e2;
        this.mSize = i12 + 1;
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

    public boolean containsKey(int i10) {
        return indexOfKey(i10) >= 0;
    }

    public boolean containsValue(E e2) {
        return indexOfValue(e2) >= 0;
    }

    @Deprecated
    public void delete(int i10) {
        remove(i10);
    }

    @Nullable
    public E get(int i10) {
        return get(i10, null);
    }

    public int indexOfKey(int i10) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i10);
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

    public int keyAt(int i10) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i10];
    }

    public void put(int i10, E e2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i10);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e2;
            return;
        }
        int i11 = ~binarySearch;
        int i12 = this.mSize;
        if (i11 < i12) {
            Object[] objArr = this.mValues;
            if (objArr[i11] == DELETED) {
                this.mKeys[i11] = i10;
                objArr[i11] = e2;
                return;
            }
        }
        if (this.mGarbage && i12 >= this.mKeys.length) {
            gc();
            i11 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, i10);
        }
        int i13 = this.mSize;
        if (i13 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i13 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy((Object) iArr2, 0, (Object) iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i14 = this.mSize;
        if (i14 - i11 != 0) {
            int[] iArr3 = this.mKeys;
            int i15 = i11 + 1;
            System.arraycopy((Object) iArr3, i11, (Object) iArr3, i15, i14 - i11);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i11, objArr4, i15, this.mSize - i11);
        }
        this.mKeys[i11] = i10;
        this.mValues[i11] = e2;
        this.mSize++;
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i10 = 0; i10 < size; i10++) {
            put(sparseArrayCompat.keyAt(i10), sparseArrayCompat.valueAt(i10));
        }
    }

    @Nullable
    public E putIfAbsent(int i10, E e2) {
        E e10 = get(i10);
        if (e10 == null) {
            put(i10, e2);
        }
        return e10;
    }

    public void remove(int i10) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i10);
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

    public void removeAtRange(int i10, int i11) {
        int min = Math.min(this.mSize, i11 + i10);
        while (i10 < min) {
            removeAt(i10);
            i10++;
        }
    }

    @Nullable
    public E replace(int i10, E e2) {
        int indexOfKey = indexOfKey(i10);
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

    public SparseArrayCompat(int i10) {
        this.mGarbage = false;
        if (i10 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i10);
            this.mKeys = new int[idealIntArraySize];
            this.mValues = new Object[idealIntArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m1744clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E get(int i10, E e2) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i10);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            if (objArr[binarySearch] != DELETED) {
                return (E) objArr[binarySearch];
            }
        }
        return e2;
    }

    public boolean replace(int i10, E e2, E e10) {
        int indexOfKey = indexOfKey(i10);
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

    public boolean remove(int i10, Object obj) {
        int indexOfKey = indexOfKey(i10);
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
