package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f999x - diagonal2.f999x;
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i10, int i11);

        public abstract boolean areItemsTheSame(int i10, int i11);

        @Nullable
        public Object getChangePayload(int i10, int i11) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i10) {
            int[] iArr = new int[i10];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i10) {
            Arrays.fill(this.mData, i10);
        }

        public int get(int i10) {
            return this.mData[i10 + this.mMid];
        }

        public void set(int i10, int i11) {
            this.mData[i10 + this.mMid] = i11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Diagonal {
        public final int size;

        /* renamed from: x, reason: collision with root package name */
        public final int f999x;

        /* renamed from: y, reason: collision with root package name */
        public final int f1000y;

        public Diagonal(int i10, int i11, int i12) {
            this.f999x = i10;
            this.f1000y = i11;
            this.size = i12;
        }

        public int endX() {
            return this.f999x + this.size;
        }

        public int endY() {
            return this.f1000y + this.size;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z10) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z10;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f999x != 0 || diagonal.f1000y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i10) {
            int size = this.mDiagonals.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Diagonal diagonal = this.mDiagonals.get(i12);
                while (i11 < diagonal.f1000y) {
                    if (this.mNewItemStatuses[i11] == 0 && this.mCallback.areItemsTheSame(i10, i11)) {
                        int i13 = this.mCallback.areContentsTheSame(i10, i11) ? 8 : 4;
                        this.mOldItemStatuses[i10] = (i11 << 4) | i13;
                        this.mNewItemStatuses[i11] = (i10 << 4) | i13;
                        return;
                    }
                    i11++;
                }
                i11 = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i10 = 0; i10 < diagonal.size; i10++) {
                    int i11 = diagonal.f999x + i10;
                    int i12 = diagonal.f1000y + i10;
                    int i13 = this.mCallback.areContentsTheSame(i11, i12) ? 1 : 2;
                    this.mOldItemStatuses[i11] = (i12 << 4) | i13;
                    this.mNewItemStatuses[i12] = (i11 << 4) | i13;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i10 = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (i10 < diagonal.f999x) {
                    if (this.mOldItemStatuses[i10] == 0) {
                        findMatchingAddition(i10);
                    }
                    i10++;
                }
                i10 = diagonal.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i10, boolean z10) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> iterator2 = collection.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = iterator2.next();
                if (postponedUpdate.posInOwnerList == i10 && postponedUpdate.removal == z10) {
                    iterator2.remove();
                    break;
                }
            }
            while (iterator2.hasNext()) {
                PostponedUpdate next = iterator2.next();
                if (z10) {
                    next.currentPos--;
                } else {
                    next.currentPos++;
                }
            }
            return postponedUpdate;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i10) {
            if (i10 >= 0 && i10 < this.mNewListSize) {
                int i11 = this.mNewItemStatuses[i10];
                if ((i11 & 15) == 0) {
                    return -1;
                }
                return i11 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i10) {
            if (i10 >= 0 && i10 < this.mOldListSize) {
                int i11 = this.mOldItemStatuses[i10];
                if ((i11 & 15) == 0) {
                    return -1;
                }
                return i11 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i10;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i11 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.mOldListSize;
            int i13 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int endX = diagonal.endX();
                int endY = diagonal.endY();
                while (true) {
                    if (i12 <= endX) {
                        break;
                    }
                    i12--;
                    int i14 = this.mOldItemStatuses[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i15, false);
                        if (postponedUpdate != null) {
                            int i16 = (i11 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i12, i16);
                            if ((i14 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i16, 1, this.mCallback.getChangePayload(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i12, 1);
                        i11--;
                    }
                }
                while (i13 > endY) {
                    i13--;
                    int i17 = this.mNewItemStatuses[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i18, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i13, i11 - i12, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i11 - postponedUpdate2.currentPos) - 1, i12);
                            if ((i17 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i12, 1, this.mCallback.getChangePayload(i18, i13));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i12, 1);
                        i11++;
                    }
                }
                int i19 = diagonal.f999x;
                int i20 = diagonal.f1000y;
                for (i10 = 0; i10 < diagonal.size; i10++) {
                    if ((this.mOldItemStatuses[i19] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i19, 1, this.mCallback.getChangePayload(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = diagonal.f999x;
                i13 = diagonal.f1000y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t2, @NonNull T t10);

        public abstract boolean areItemsTheSame(@NonNull T t2, @NonNull T t10);

        @Nullable
        public Object getChangePayload(@NonNull T t2, @NonNull T t10) {
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class PostponedUpdate {
        public int currentPos;
        public int posInOwnerList;
        public boolean removal;

        public PostponedUpdate(int i10, int i11, boolean z10) {
            this.posInOwnerList = i10;
            this.currentPos = i11;
            this.removal = z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Range {
        public int newListEnd;
        public int newListStart;
        public int oldListEnd;
        public int oldListStart;

        public Range() {
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i10, int i11, int i12, int i13) {
            this.oldListStart = i10;
            this.oldListEnd = i11;
            this.newListStart = i12;
            this.newListEnd = i13;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        public boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @NonNull
        public Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                if (this.reverse) {
                    return new Diagonal(this.startX, this.startY, diagonalSize());
                }
                if (isAddition()) {
                    return new Diagonal(this.startX, this.startY + 1, diagonalSize());
                }
                return new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i10 = this.startX;
            return new Diagonal(i10, this.startY, this.endX - i10);
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i10) {
        int i11;
        int i12;
        int i13;
        boolean z10 = (range.oldSize() - range.newSize()) % 2 == 0;
        int oldSize = range.oldSize() - range.newSize();
        int i14 = -i10;
        for (int i15 = i14; i15 <= i10; i15 += 2) {
            if (i15 != i14 && (i15 == i10 || centeredArray2.get(i15 + 1) >= centeredArray2.get(i15 - 1))) {
                i11 = centeredArray2.get(i15 - 1);
                i12 = i11 - 1;
            } else {
                i11 = centeredArray2.get(i15 + 1);
                i12 = i11;
            }
            int i16 = range.newListEnd - ((range.oldListEnd - i12) - i15);
            int i17 = (i10 == 0 || i12 != i11) ? i16 : i16 + 1;
            while (i12 > range.oldListStart && i16 > range.newListStart && callback.areItemsTheSame(i12 - 1, i16 - 1)) {
                i12--;
                i16--;
            }
            centeredArray2.set(i15, i12);
            if (z10 && (i13 = oldSize - i15) >= i14 && i13 <= i10 && centeredArray.get(i13) >= i12) {
                Snake snake = new Snake();
                snake.startX = i12;
                snake.startY = i16;
                snake.endX = i11;
                snake.endY = i17;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i10) {
        int i11;
        int i12;
        int i13;
        boolean z10 = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int oldSize = range.oldSize() - range.newSize();
        int i14 = -i10;
        for (int i15 = i14; i15 <= i10; i15 += 2) {
            if (i15 != i14 && (i15 == i10 || centeredArray.get(i15 + 1) <= centeredArray.get(i15 - 1))) {
                i11 = centeredArray.get(i15 - 1);
                i12 = i11 + 1;
            } else {
                i11 = centeredArray.get(i15 + 1);
                i12 = i11;
            }
            int i16 = (range.newListStart + (i12 - range.oldListStart)) - i15;
            int i17 = (i10 == 0 || i12 != i11) ? i16 : i16 - 1;
            while (i12 < range.oldListEnd && i16 < range.newListEnd && callback.areItemsTheSame(i12, i16)) {
                i12++;
                i16++;
            }
            centeredArray.set(i15, i12);
            if (z10 && (i13 = oldSize - i15) >= i14 + 1 && i13 <= i10 - 1 && centeredArray2.get(i13) <= i12) {
                Snake snake = new Snake();
                snake.startX = i11;
                snake.startY = i17;
                snake.endX = i12;
                snake.endY = i16;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i10 = 0; i10 < oldSize; i10++) {
                Snake forward = forward(range, callback, centeredArray, centeredArray2, i10);
                if (forward != null) {
                    return forward;
                }
                Snake backward = backward(range, callback, centeredArray, centeredArray2, i10);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z10) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i10 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i10);
        CenteredArray centeredArray2 = new CenteredArray(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake midPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = midPoint.startX;
                range2.newListEnd = midPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = midPoint.endX;
                range.newListStart = midPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z10);
    }
}
