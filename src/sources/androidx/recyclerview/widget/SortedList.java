package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    public T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        public final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.mWrappedCallback.areContentsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.mWrappedCallback.areItemsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.mWrappedCallback.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.mWrappedCallback.getChangePayload(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i10, int i11) {
            this.mBatchingListUpdateCallback.onChanged(i10, i11, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i10, int i11) {
            this.mBatchingListUpdateCallback.onInserted(i10, i11);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i10, int i11) {
            this.mBatchingListUpdateCallback.onMoved(i10, i11);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i10, int i11) {
            this.mBatchingListUpdateCallback.onRemoved(i10, i11);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i10, int i11, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i10, i11, obj);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i10, int i11);

        public void onChanged(int i10, int i11, Object obj) {
            onChanged(i10, i11);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int sortAndDedup = sortAndDedup(tArr);
        if (this.mSize == 0) {
            this.mData = tArr;
            this.mSize = sortAndDedup;
            this.mCallback.onInserted(0, sortAndDedup);
            return;
        }
        merge(tArr, sortAndDedup);
    }

    private void addToData(int i10, T t2) {
        int i11 = this.mSize;
        if (i10 <= i11) {
            T[] tArr = this.mData;
            if (i11 == tArr.length) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
                System.arraycopy(this.mData, 0, tArr2, 0, i10);
                tArr2[i10] = t2;
                System.arraycopy(this.mData, i10, tArr2, i10 + 1, this.mSize - i10);
                this.mData = tArr2;
            } else {
                System.arraycopy(tArr, i10, tArr, i10 + 1, i11 - i10);
                this.mData[i10] = t2;
            }
            this.mSize++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i10 + " because size is " + this.mSize);
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t2, T[] tArr, int i10, int i11, int i12) {
        while (i10 < i11) {
            int i13 = (i10 + i11) / 2;
            T t10 = tArr[i13];
            int compare = this.mCallback.compare(t10, t2);
            if (compare < 0) {
                i10 = i13 + 1;
            } else {
                if (compare == 0) {
                    if (this.mCallback.areItemsTheSame(t10, t2)) {
                        return i13;
                    }
                    int linearEqualitySearch = linearEqualitySearch(t2, i13, i10, i11);
                    return (i12 == 1 && linearEqualitySearch == -1) ? i13 : linearEqualitySearch;
                }
                i11 = i13;
            }
        }
        if (i12 == 1) {
            return i10;
        }
        return -1;
    }

    private int findSameItem(T t2, T[] tArr, int i10, int i11) {
        while (i10 < i11) {
            if (this.mCallback.areItemsTheSame(tArr[i10], t2)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t2, int i10, int i11, int i12) {
        T t10;
        for (int i13 = i10 - 1; i13 >= i11; i13--) {
            T t11 = this.mData[i13];
            if (this.mCallback.compare(t11, t2) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(t11, t2)) {
                return i13;
            }
        }
        do {
            i10++;
            if (i10 >= i12) {
                return -1;
            }
            t10 = this.mData[i10];
            if (this.mCallback.compare(t10, t2) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t10, t2));
        return i10;
    }

    private void merge(T[] tArr, int i10) {
        boolean z10 = !(this.mCallback instanceof BatchedCallback);
        if (z10) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i11 = 0;
        this.mOldDataStart = 0;
        int i12 = this.mSize;
        this.mOldDataSize = i12;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i12 + i10 + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i13 = this.mOldDataStart;
            int i14 = this.mOldDataSize;
            if (i13 >= i14 && i11 >= i10) {
                break;
            }
            if (i13 == i14) {
                int i15 = i10 - i11;
                System.arraycopy(tArr, i11, this.mData, this.mNewDataStart, i15);
                int i16 = this.mNewDataStart + i15;
                this.mNewDataStart = i16;
                this.mSize += i15;
                this.mCallback.onInserted(i16 - i15, i15);
                break;
            }
            if (i11 == i10) {
                int i17 = i14 - i13;
                System.arraycopy(this.mOldData, i13, this.mData, this.mNewDataStart, i17);
                this.mNewDataStart += i17;
                break;
            }
            T t2 = this.mOldData[i13];
            T t10 = tArr[i11];
            int compare = this.mCallback.compare(t2, t10);
            if (compare > 0) {
                T[] tArr2 = this.mData;
                int i18 = this.mNewDataStart;
                int i19 = i18 + 1;
                this.mNewDataStart = i19;
                tArr2[i18] = t10;
                this.mSize++;
                i11++;
                this.mCallback.onInserted(i19 - 1, 1);
            } else if (compare == 0 && this.mCallback.areItemsTheSame(t2, t10)) {
                T[] tArr3 = this.mData;
                int i20 = this.mNewDataStart;
                this.mNewDataStart = i20 + 1;
                tArr3[i20] = t10;
                i11++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(t2, t10)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t2, t10));
                }
            } else {
                T[] tArr4 = this.mData;
                int i21 = this.mNewDataStart;
                this.mNewDataStart = i21 + 1;
                tArr4[i21] = t2;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z10) {
            endBatchedUpdates();
        }
    }

    private void removeItemAtIndex(int i10, boolean z10) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i10 + 1, tArr, i10, (this.mSize - i10) - 1);
        int i11 = this.mSize - 1;
        this.mSize = i11;
        this.mData[i11] = null;
        if (z10) {
            this.mCallback.onRemoved(i10, 1);
        }
    }

    private void replaceAllInsert(T t2) {
        T[] tArr = this.mData;
        int i10 = this.mNewDataStart;
        tArr[i10] = t2;
        int i11 = i10 + 1;
        this.mNewDataStart = i11;
        this.mSize++;
        this.mCallback.onInserted(i11 - 1, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z10 = !(this.mCallback instanceof BatchedCallback);
        if (z10) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int sortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, sortAndDedup));
        while (true) {
            int i10 = this.mNewDataStart;
            if (i10 >= sortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i11 = this.mOldDataStart;
            int i12 = this.mOldDataSize;
            if (i11 >= i12) {
                int i13 = sortAndDedup - i10;
                System.arraycopy(tArr, i10, this.mData, i10, i13);
                this.mNewDataStart += i13;
                this.mSize += i13;
                this.mCallback.onInserted(i10, i13);
                break;
            }
            if (i10 >= sortAndDedup) {
                int i14 = i12 - i11;
                this.mSize -= i14;
                this.mCallback.onRemoved(i10, i14);
                break;
            }
            T t2 = this.mOldData[i11];
            T t10 = tArr[i10];
            int compare = this.mCallback.compare(t2, t10);
            if (compare < 0) {
                replaceAllRemove();
            } else if (compare > 0) {
                replaceAllInsert(t10);
            } else if (!this.mCallback.areItemsTheSame(t2, t10)) {
                replaceAllRemove();
                replaceAllInsert(t10);
            } else {
                T[] tArr2 = this.mData;
                int i15 = this.mNewDataStart;
                tArr2[i15] = t10;
                this.mOldDataStart++;
                this.mNewDataStart = i15 + 1;
                if (!this.mCallback.areContentsTheSame(t2, t10)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t2, t10));
                }
            }
        }
        this.mOldData = null;
        if (z10) {
            endBatchedUpdates();
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i10 = 1;
        int i11 = 0;
        for (int i12 = 1; i12 < tArr.length; i12++) {
            T t2 = tArr[i12];
            if (this.mCallback.compare(tArr[i11], t2) == 0) {
                int findSameItem = findSameItem(t2, tArr, i11, i10);
                if (findSameItem != -1) {
                    tArr[findSameItem] = t2;
                } else {
                    if (i10 != i12) {
                        tArr[i10] = t2;
                    }
                    i10++;
                }
            } else {
                if (i10 != i12) {
                    tArr[i10] = t2;
                }
                i11 = i10;
                i10++;
            }
        }
        return i10;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t2) {
        throwIfInMutationOperation();
        return add(t2, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z10) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z10) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i10 = this.mSize;
        if (i10 == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i10, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i10);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i10) throws IndexOutOfBoundsException {
        int i11;
        if (i10 < this.mSize && i10 >= 0) {
            T[] tArr = this.mOldData;
            if (tArr != null && i10 >= (i11 = this.mNewDataStart)) {
                return tArr[(i10 - i11) + this.mOldDataStart];
            }
            return this.mData[i10];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i10 + " but size is " + this.mSize);
    }

    public int indexOf(T t2) {
        if (this.mOldData != null) {
            int findIndexOf = findIndexOf(t2, this.mData, 0, this.mNewDataStart, 4);
            if (findIndexOf != -1) {
                return findIndexOf;
            }
            int findIndexOf2 = findIndexOf(t2, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (findIndexOf2 != -1) {
                return (findIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
            }
            return -1;
        }
        return findIndexOf(t2, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int i10) {
        throwIfInMutationOperation();
        T t2 = get(i10);
        removeItemAtIndex(i10, false);
        int add = add(t2, false);
        if (i10 != add) {
            this.mCallback.onMoved(i10, add);
        }
    }

    public boolean remove(T t2) {
        throwIfInMutationOperation();
        return remove(t2, true);
    }

    public T removeItemAt(int i10) {
        throwIfInMutationOperation();
        T t2 = get(i10);
        removeItemAtIndex(i10, true);
        return t2;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z10) {
        throwIfInMutationOperation();
        if (z10) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i10, T t2) {
        throwIfInMutationOperation();
        T t10 = get(i10);
        boolean z10 = t10 == t2 || !this.mCallback.areContentsTheSame(t10, t2);
        if (t10 != t2 && this.mCallback.compare(t10, t2) == 0) {
            this.mData[i10] = t2;
            if (z10) {
                Callback callback = this.mCallback;
                callback.onChanged(i10, 1, callback.getChangePayload(t10, t2));
                return;
            }
            return;
        }
        if (z10) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i10, 1, callback2.getChangePayload(t10, t2));
        }
        removeItemAtIndex(i10, false);
        int add = add(t2, false);
        if (i10 != add) {
            this.mCallback.onMoved(i10, add);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i10) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i10));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t2, boolean z10) {
        int findIndexOf = findIndexOf(t2, this.mData, 0, this.mSize, 1);
        if (findIndexOf == -1) {
            findIndexOf = 0;
        } else if (findIndexOf < this.mSize) {
            T t10 = this.mData[findIndexOf];
            if (this.mCallback.areItemsTheSame(t10, t2)) {
                if (this.mCallback.areContentsTheSame(t10, t2)) {
                    this.mData[findIndexOf] = t2;
                    return findIndexOf;
                }
                this.mData[findIndexOf] = t2;
                Callback callback = this.mCallback;
                callback.onChanged(findIndexOf, 1, callback.getChangePayload(t10, t2));
                return findIndexOf;
            }
        }
        addToData(findIndexOf, t2);
        if (z10) {
            this.mCallback.onInserted(findIndexOf, 1);
        }
        return findIndexOf;
    }

    private boolean remove(T t2, boolean z10) {
        int findIndexOf = findIndexOf(t2, this.mData, 0, this.mSize, 2);
        if (findIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(findIndexOf, z10);
        return true;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }
}
