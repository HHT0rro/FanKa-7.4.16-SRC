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
public final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST;
    private boolean[] array;
    private int size;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        EMPTY_LIST = booleanArrayList;
        booleanArrayList.makeImmutable();
    }

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanArrayList() {
        this(new boolean[10], 0);
    }

    private BooleanArrayList(boolean[] other, int size) {
        this.array = other;
        this.size = size;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        ensureIsMutable();
        if (toIndex < fromIndex) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.array;
        System.arraycopy((Object) zArr, toIndex, (Object) zArr, fromIndex, this.size - toIndex);
        this.size -= toIndex - fromIndex;
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof BooleanArrayList)) {
            return super.equals(o10);
        }
        BooleanArrayList other = (BooleanArrayList) o10;
        if (this.size != other.size) {
            return false;
        }
        boolean[] arr = other.array;
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
            result = (result * 31) + Internal.hashBoolean(this.array[i10]);
        }
        return result;
    }

    @Override // com.android.framework.protobuf.Internal.ProtobufList, com.android.framework.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity, reason: merged with bridge method [inline-methods] */
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int capacity) {
        if (capacity < this.size) {
            throw new IllegalArgumentException();
        }
        return new BooleanArrayList(Arrays.copyOf(this.array, capacity), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int index) {
        return Boolean.valueOf(getBoolean(index));
    }

    @Override // com.android.framework.protobuf.Internal.BooleanList
    public boolean getBoolean(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        if (!(element instanceof Boolean)) {
            return -1;
        }
        boolean unboxedElement = ((Boolean) element).booleanValue();
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
    public Boolean set(int index, Boolean element) {
        return Boolean.valueOf(setBoolean(index, element.booleanValue()));
    }

    @Override // com.android.framework.protobuf.Internal.BooleanList
    public boolean setBoolean(int index, boolean element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        boolean[] zArr = this.array;
        boolean previousValue = zArr[index];
        zArr[index] = element;
        return previousValue;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Boolean element) {
        addBoolean(element.booleanValue());
        return true;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int index, Boolean element) {
        addBoolean(index, element.booleanValue());
    }

    @Override // com.android.framework.protobuf.Internal.BooleanList
    public void addBoolean(boolean element) {
        ensureIsMutable();
        int i10 = this.size;
        boolean[] zArr = this.array;
        if (i10 == zArr.length) {
            int length = ((i10 * 3) / 2) + 1;
            boolean[] newArray = new boolean[length];
            System.arraycopy((Object) zArr, 0, (Object) newArray, 0, i10);
            this.array = newArray;
        }
        boolean[] zArr2 = this.array;
        int i11 = this.size;
        this.size = i11 + 1;
        zArr2[i11] = element;
    }

    private void addBoolean(int index, boolean element) {
        int i10;
        ensureIsMutable();
        if (index < 0 || index > (i10 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
        }
        boolean[] zArr = this.array;
        if (i10 < zArr.length) {
            System.arraycopy((Object) zArr, index, (Object) zArr, index + 1, i10 - index);
        } else {
            int length = ((i10 * 3) / 2) + 1;
            boolean[] newArray = new boolean[length];
            System.arraycopy((Object) zArr, 0, (Object) newArray, 0, index);
            System.arraycopy((Object) this.array, index, (Object) newArray, index + 1, this.size - index);
            this.array = newArray;
        }
        this.array[index] = element;
        this.size++;
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList list = (BooleanArrayList) collection;
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
        boolean[] zArr = this.array;
        if (newSize > zArr.length) {
            this.array = Arrays.copyOf(zArr, newSize);
        }
        System.arraycopy((Object) list.array, 0, (Object) this.array, this.size, list.size);
        this.size = newSize;
        this.modCount++;
        return true;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        boolean[] zArr = this.array;
        boolean value = zArr[index];
        if (index < this.size - 1) {
            System.arraycopy((Object) zArr, index + 1, (Object) zArr, index, (r2 - index) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(value);
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
