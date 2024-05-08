package com.android.framework.protobuf;

import com.android.framework.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final IntArrayList EMPTY_LIST;
    private int[] array;
    private int size;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        EMPTY_LIST = intArrayList;
        intArrayList.makeImmutable();
    }

    public static IntArrayList emptyList() {
        return EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntArrayList() {
        this(new int[10], 0);
    }

    private IntArrayList(int[] other, int size) {
        this.array = other;
        this.size = size;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        ensureIsMutable();
        if (toIndex < fromIndex) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.array;
        System.arraycopy((Object) iArr, toIndex, (Object) iArr, fromIndex, this.size - toIndex);
        this.size -= toIndex - fromIndex;
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof IntArrayList)) {
            return super.equals(o10);
        }
        IntArrayList other = (IntArrayList) o10;
        if (this.size != other.size) {
            return false;
        }
        int[] arr = other.array;
        for (int i10 = 0; i10 < this.size; i10++) {
            if (this.array[i10] != arr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.Set
    public int hashCode() {
        int result = 1;
        for (int i10 = 0; i10 < this.size; i10++) {
            result = (result * 31) + this.array[i10];
        }
        return result;
    }

    @Override // com.android.framework.protobuf.Internal.ProtobufList, com.android.framework.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int capacity) {
        if (capacity < this.size) {
            throw new IllegalArgumentException();
        }
        return new IntArrayList(Arrays.copyOf(this.array, capacity), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int index) {
        return Integer.valueOf(getInt(index));
    }

    @Override // com.android.framework.protobuf.Internal.IntList
    public int getInt(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        if (!(element instanceof Integer)) {
            return -1;
        }
        int unboxedElement = ((Integer) element).intValue();
        int numElems = size();
        for (int i10 = 0; i10 < numElems; i10++) {
            if (this.array[i10] == unboxedElement) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer set(int index, Integer element) {
        return Integer.valueOf(setInt(index, element.intValue()));
    }

    @Override // com.android.framework.protobuf.Internal.IntList
    public int setInt(int index, int element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        int[] iArr = this.array;
        int previousValue = iArr[index];
        iArr[index] = element;
        return previousValue;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Integer element) {
        addInt(element.intValue());
        return true;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int index, Integer element) {
        addInt(index, element.intValue());
    }

    @Override // com.android.framework.protobuf.Internal.IntList
    public void addInt(int element) {
        ensureIsMutable();
        int i10 = this.size;
        int[] iArr = this.array;
        if (i10 == iArr.length) {
            int length = ((i10 * 3) / 2) + 1;
            int[] newArray = new int[length];
            System.arraycopy((Object) iArr, 0, (Object) newArray, 0, i10);
            this.array = newArray;
        }
        int[] iArr2 = this.array;
        int i11 = this.size;
        this.size = i11 + 1;
        iArr2[i11] = element;
    }

    private void addInt(int index, int element) {
        int i10;
        ensureIsMutable();
        if (index < 0 || index > (i10 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
        }
        int[] iArr = this.array;
        if (i10 < iArr.length) {
            System.arraycopy((Object) iArr, index, (Object) iArr, index + 1, i10 - index);
        } else {
            int length = ((i10 * 3) / 2) + 1;
            int[] newArray = new int[length];
            System.arraycopy((Object) iArr, 0, (Object) newArray, 0, index);
            System.arraycopy((Object) this.array, index, (Object) newArray, index + 1, this.size - index);
            this.array = newArray;
        }
        this.array[index] = element;
        this.size++;
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList list = (IntArrayList) collection;
        int i10 = list.size;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.size;
        int overflow = Integer.MAX_VALUE - i11;
        if (overflow < i10) {
            throw new OutOfMemoryError();
        }
        int newSize = i11 + i10;
        int[] iArr = this.array;
        if (newSize > iArr.length) {
            this.array = Arrays.copyOf(iArr, newSize);
        }
        System.arraycopy((Object) list.array, 0, (Object) this.array, this.size, list.size);
        this.size = newSize;
        this.modCount++;
        return true;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        int[] iArr = this.array;
        int value = iArr[index];
        if (index < this.size - 1) {
            System.arraycopy((Object) iArr, index + 1, (Object) iArr, index, (r2 - index) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(value);
    }

    private void ensureIndexInRange(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int index) {
        return "Index:" + index + ", Size:" + this.size;
    }
}
