package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class DirectedAcyclicGraph<T> {
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t2, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t2)) {
            return;
        }
        if (!hashSet.contains(t2)) {
            hashSet.add(t2);
            ArrayList<T> arrayList2 = this.mGraph.get(t2);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    dfs(arrayList2.get(i10), arrayList, hashSet);
                }
            }
            hashSet.remove(t2);
            arrayList.add(t2);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t2, @NonNull T t10) {
        if (this.mGraph.containsKey(t2) && this.mGraph.containsKey(t10)) {
            ArrayList<T> arrayList = this.mGraph.get(t2);
            if (arrayList == null) {
                arrayList = getEmptyList();
                this.mGraph.put(t2, arrayList);
            }
            arrayList.add(t10);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void addNode(@NonNull T t2) {
        if (this.mGraph.containsKey(t2)) {
            return;
        }
        this.mGraph.put(t2, null);
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i10);
            if (valueAt != null) {
                poolList(valueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t2) {
        return this.mGraph.containsKey(t2);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t2) {
        return this.mGraph.get(t2);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t2) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i10);
            if (valueAt != null && valueAt.contains(t2)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i10));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i10 = 0; i10 < size; i10++) {
            dfs(this.mGraph.keyAt(i10), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t2) {
        int size = this.mGraph.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> valueAt = this.mGraph.valueAt(i10);
            if (valueAt != null && valueAt.contains(t2)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.mGraph.size();
    }
}
