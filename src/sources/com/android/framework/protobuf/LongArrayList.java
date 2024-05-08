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
public final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST;
    private long[] array;
    private int size;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        EMPTY_LIST = longArrayList;
        longArrayList.makeImmutable();
    }

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongArrayList() {
        this(new long[10], 0);
    }

    private LongArrayList(long[] other, int size) {
        this.array = other;
        this.size = size;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        ensureIsMutable();
        if (toIndex < fromIndex) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.array;
        System.arraycopy((Object) jArr, toIndex, (Object) jArr, fromIndex, this.size - toIndex);
        this.size -= toIndex - fromIndex;
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof LongArrayList)) {
            return super.equals(o10);
        }
        LongArrayList other = (LongArrayList) o10;
        if (this.size != other.size) {
            return false;
        }
        long[] arr = other.array;
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
            result = (result * 31) + Internal.hashLong(this.array[i10]);
        }
        return result;
    }

    @Override // com.android.framework.protobuf.Internal.ProtobufList, com.android.framework.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Long> mutableCopyWithCapacity2(int capacity) {
        if (capacity < this.size) {
            throw new IllegalArgumentException();
        }
        return new LongArrayList(Arrays.copyOf(this.array, capacity), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int index) {
        return Long.valueOf(getLong(index));
    }

    @Override // com.android.framework.protobuf.Internal.LongList
    public long getLong(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        if (!(element instanceof Long)) {
            return -1;
        }
        long unboxedElement = ((Long) element).longValue();
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
    public Long set(int index, Long element) {
        return Long.valueOf(setLong(index, element.longValue()));
    }

    @Override // com.android.framework.protobuf.Internal.LongList
    public long setLong(int index, long element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        long[] jArr = this.array;
        long previousValue = jArr[index];
        jArr[index] = element;
        return previousValue;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Long element) {
        addLong(element.longValue());
        return true;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int index, Long element) {
        addLong(index, element.longValue());
    }

    @Override // com.android.framework.protobuf.Internal.LongList
    public void addLong(long element) {
        ensureIsMutable();
        int i10 = this.size;
        long[] jArr = this.array;
        if (i10 == jArr.length) {
            int length = ((i10 * 3) / 2) + 1;
            long[] newArray = new long[length];
            System.arraycopy((Object) jArr, 0, (Object) newArray, 0, i10);
            this.array = newArray;
        }
        long[] jArr2 = this.array;
        int i11 = this.size;
        this.size = i11 + 1;
        jArr2[i11] = element;
    }

    private void addLong(int index, long element) {
        int i10;
        ensureIsMutable();
        if (index < 0 || index > (i10 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
        }
        long[] jArr = this.array;
        if (i10 < jArr.length) {
            System.arraycopy((Object) jArr, index, (Object) jArr, index + 1, i10 - index);
        } else {
            int length = ((i10 * 3) / 2) + 1;
            long[] newArray = new long[length];
            System.arraycopy((Object) jArr, 0, (Object) newArray, 0, index);
            System.arraycopy((Object) this.array, index, (Object) newArray, index + 1, this.size - index);
            this.array = newArray;
        }
        this.array[index] = element;
        this.size++;
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList list = (LongArrayList) collection;
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
        long[] jArr = this.array;
        if (newSize > jArr.length) {
            this.array = Arrays.copyOf(jArr, newSize);
        }
        System.arraycopy((Object) list.array, 0, (Object) this.array, this.size, list.size);
        this.size = newSize;
        this.modCount++;
        return true;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        long[] jArr = this.array;
        long value = jArr[index];
        if (index < this.size - 1) {
            System.arraycopy((Object) jArr, index + 1, (Object) jArr, index, (r3 - index) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(value);
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
