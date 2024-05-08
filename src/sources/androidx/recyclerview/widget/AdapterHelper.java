package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    public static final int POSITION_TYPE_INVISIBLE = 0;
    public static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    public final Callback mCallback;
    public final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    public Runnable mOnItemProcessedCallback;
    public final OpReorderer mOpReorderer;
    public final ArrayList<UpdateOp> mPendingUpdates;
    public final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i10);

        void markViewHoldersUpdated(int i10, int i11, Object obj);

        void offsetPositionsForAdd(int i10, int i11);

        void offsetPositionsForMove(int i10, int i11);

        void offsetPositionsForRemovingInvisible(int i10, int i11);

        void offsetPositionsForRemovingLaidOutOrNewView(int i10, int i11);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class UpdateOp {
        public static final int ADD = 1;
        public static final int MOVE = 8;
        public static final int POOL_SIZE = 30;
        public static final int REMOVE = 2;
        public static final int UPDATE = 4;
        public int cmd;
        public int itemCount;
        public Object payload;
        public int positionStart;

        public UpdateOp(int i10, int i11, int i12, Object obj) {
            this.cmd = i10;
            this.positionStart = i11;
            this.itemCount = i12;
            this.payload = obj;
        }

        public String cmdToString() {
            int i10 = this.cmd;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : t.f36238w : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i10 = this.cmd;
            if (i10 != updateOp.cmd) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                return false;
            }
            Object obj2 = this.payload;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.payload)) {
                    return false;
                }
            } else if (updateOp.payload != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void applyAdd(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyMove(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyRemove(UpdateOp updateOp) {
        boolean z10;
        char c4;
        int i10 = updateOp.positionStart;
        int i11 = updateOp.itemCount + i10;
        char c10 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.mCallback.findViewHolder(i12) != null || canFindInPreLayout(i12)) {
                if (c10 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c4 = 1;
            } else {
                if (c10 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c4 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c10 = c4;
        }
        if (i13 != updateOp.itemCount) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i10, i13, null);
        }
        if (c10 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        int i10 = updateOp.positionStart;
        int i11 = updateOp.itemCount + i10;
        int i12 = i10;
        char c4 = 65535;
        int i13 = 0;
        while (i10 < i11) {
            if (this.mCallback.findViewHolder(i10) != null || canFindInPreLayout(i10)) {
                if (c4 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(4, i12, i13, updateOp.payload));
                    i12 = i10;
                    i13 = 0;
                }
                c4 = 1;
            } else {
                if (c4 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(4, i12, i13, updateOp.payload));
                    i12 = i10;
                    i13 = 0;
                }
                c4 = 0;
            }
            i13++;
            i10++;
        }
        if (i13 != updateOp.itemCount) {
            Object obj = updateOp.payload;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i12, i13, obj);
        }
        if (c4 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private boolean canFindInPreLayout(int i10) {
        int size = this.mPostponedList.size();
        for (int i11 = 0; i11 < size; i11++) {
            UpdateOp updateOp = this.mPostponedList.get(i11);
            int i12 = updateOp.cmd;
            if (i12 == 8) {
                if (findPositionOffset(updateOp.itemCount, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = updateOp.positionStart;
                int i14 = updateOp.itemCount + i13;
                while (i13 < i14) {
                    if (findPositionOffset(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i10;
        int i11 = updateOp.cmd;
        if (i11 != 1 && i11 != 8) {
            int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i11);
            int i12 = updateOp.positionStart;
            int i13 = updateOp.cmd;
            if (i13 == 2) {
                i10 = 0;
            } else {
                if (i13 != 4) {
                    throw new IllegalArgumentException("op should be remove or update." + ((Object) updateOp));
                }
                i10 = 1;
            }
            int i14 = 1;
            for (int i15 = 1; i15 < updateOp.itemCount; i15++) {
                int updatePositionWithPostponed2 = updatePositionWithPostponed(updateOp.positionStart + (i10 * i15), updateOp.cmd);
                int i16 = updateOp.cmd;
                if (i16 == 2 ? updatePositionWithPostponed2 == updatePositionWithPostponed : i16 == 4 && updatePositionWithPostponed2 == updatePositionWithPostponed + 1) {
                    i14++;
                } else {
                    UpdateOp obtainUpdateOp = obtainUpdateOp(i16, updatePositionWithPostponed, i14, updateOp.payload);
                    dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i12);
                    recycleUpdateOp(obtainUpdateOp);
                    if (updateOp.cmd == 4) {
                        i12 += i14;
                    }
                    updatePositionWithPostponed = updatePositionWithPostponed2;
                    i14 = 1;
                }
            }
            Object obj = updateOp.payload;
            recycleUpdateOp(updateOp);
            if (i14 > 0) {
                UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i14, obj);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i12);
                recycleUpdateOp(obtainUpdateOp2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int i10 = updateOp.cmd;
        if (i10 == 1) {
            this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            return;
        }
        if (i10 == 2) {
            this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
            return;
        }
        if (i10 == 4) {
            this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
        } else {
            if (i10 == 8) {
                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + ((Object) updateOp));
        }
    }

    private int updatePositionWithPostponed(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.mPostponedList.get(size);
            int i14 = updateOp.cmd;
            if (i14 == 8) {
                int i15 = updateOp.positionStart;
                int i16 = updateOp.itemCount;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            updateOp.positionStart = i15 + 1;
                            updateOp.itemCount = i16 + 1;
                        } else if (i11 == 2) {
                            updateOp.positionStart = i15 - 1;
                            updateOp.itemCount = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        updateOp.itemCount = i16 + 1;
                    } else if (i11 == 2) {
                        updateOp.itemCount = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        updateOp.positionStart = i15 + 1;
                    } else if (i11 == 2) {
                        updateOp.positionStart = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = updateOp.positionStart;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= updateOp.itemCount;
                    } else if (i14 == 2) {
                        i10 += updateOp.itemCount;
                    }
                } else if (i11 == 1) {
                    updateOp.positionStart = i17 + 1;
                } else if (i11 == 2) {
                    updateOp.positionStart = i17 - 1;
                }
            }
        }
        for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.mPostponedList.get(size2);
            if (updateOp2.cmd == 8) {
                int i18 = updateOp2.itemCount;
                if (i18 == updateOp2.positionStart || i18 < 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.itemCount <= 0) {
                this.mPostponedList.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i10;
    }

    public AdapterHelper addUpdateOp(UpdateOp... updateOpArr) {
        Collections.addAll(this.mPendingUpdates, updateOpArr);
        return this;
    }

    public int applyPendingUpdatesToPosition(int i10) {
        int size = this.mPendingUpdates.size();
        for (int i11 = 0; i11 < size; i11++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i11);
            int i12 = updateOp.cmd;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = updateOp.positionStart;
                    if (i13 <= i10) {
                        int i14 = updateOp.itemCount;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = updateOp.positionStart;
                    if (i15 == i10) {
                        i10 = updateOp.itemCount;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (updateOp.itemCount <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (updateOp.positionStart <= i10) {
                i10 += updateOp.itemCount;
            }
        }
        return i10;
    }

    public void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i10));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i10 = 0; i10 < size; i10++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i10);
            int i11 = updateOp.cmd;
            if (i11 == 1) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            } else if (i11 == 2) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
            } else if (i11 == 4) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            } else if (i11 == 8) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i10) {
        this.mCallback.onDispatchFirstPass(updateOp);
        int i11 = updateOp.cmd;
        if (i11 == 2) {
            this.mCallback.offsetPositionsForRemovingInvisible(i10, updateOp.itemCount);
        } else {
            if (i11 == 4) {
                this.mCallback.markViewHoldersUpdated(i10, updateOp.itemCount, updateOp.payload);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int findPositionOffset(int i10) {
        return findPositionOffset(i10, 0);
    }

    public boolean hasAnyUpdateTypes(int i10) {
        return (i10 & this.mExistingUpdateTypes) != 0;
    }

    public boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0;
    }

    public boolean hasUpdates() {
        return (this.mPostponedList.isEmpty() || this.mPendingUpdates.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i10, int i11, int i12, Object obj) {
        UpdateOp acquire = this.mUpdateOpPool.acquire();
        if (acquire == null) {
            return new UpdateOp(i10, i11, i12, obj);
        }
        acquire.cmd = i10;
        acquire.positionStart = i11;
        acquire.itemCount = i12;
        acquire.payload = obj;
        return acquire;
    }

    public boolean onItemRangeChanged(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(4, i10, i11, obj));
        this.mExistingUpdateTypes |= 4;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeInserted(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(1, i10, i11, null));
        this.mExistingUpdateTypes |= 1;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeMoved(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 == 1) {
            this.mPendingUpdates.add(obtainUpdateOp(8, i10, i11, null));
            this.mExistingUpdateTypes |= 8;
            return this.mPendingUpdates.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public boolean onItemRangeRemoved(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(2, i10, i11, null));
        this.mExistingUpdateTypes |= 2;
        return this.mPendingUpdates.size() == 1;
    }

    public void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int size = this.mPendingUpdates.size();
        for (int i10 = 0; i10 < size; i10++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i10);
            int i11 = updateOp.cmd;
            if (i11 == 1) {
                applyAdd(updateOp);
            } else if (i11 == 2) {
                applyRemove(updateOp);
            } else if (i11 == 4) {
                applyUpdate(updateOp);
            } else if (i11 == 8) {
                applyMove(updateOp);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.mPendingUpdates.clear();
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (this.mDisableRecycler) {
            return;
        }
        updateOp.payload = null;
        this.mUpdateOpPool.release(updateOp);
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            recycleUpdateOp(list.get(i10));
        }
        list.clear();
    }

    public void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public AdapterHelper(Callback callback, boolean z10) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList<>();
        this.mPostponedList = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.mCallback = callback;
        this.mDisableRecycler = z10;
        this.mOpReorderer = new OpReorderer(this);
    }

    public int findPositionOffset(int i10, int i11) {
        int size = this.mPostponedList.size();
        while (i11 < size) {
            UpdateOp updateOp = this.mPostponedList.get(i11);
            int i12 = updateOp.cmd;
            if (i12 == 8) {
                int i13 = updateOp.positionStart;
                if (i13 == i10) {
                    i10 = updateOp.itemCount;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (updateOp.itemCount <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = updateOp.positionStart;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = updateOp.itemCount;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += updateOp.itemCount;
                }
            }
            i11++;
        }
        return i10;
    }
}
