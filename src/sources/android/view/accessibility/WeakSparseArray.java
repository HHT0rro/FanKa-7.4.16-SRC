package android.view.accessibility;

import android.util.SparseArray;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WeakSparseArray<E> {
    private final ReferenceQueue<E> mRefQueue = new ReferenceQueue<>();
    private final SparseArray<WeakReferenceWithId<E>> mSparseArray = new SparseArray<>();

    public void append(int key, E value) {
        removeUnreachableValues();
        this.mSparseArray.append(key, new WeakReferenceWithId<>(value, this.mRefQueue, key));
    }

    public void remove(int key) {
        removeUnreachableValues();
        this.mSparseArray.remove(key);
    }

    public E get(int key) {
        removeUnreachableValues();
        WeakReferenceWithId<E> ref = this.mSparseArray.get(key);
        if (ref != null) {
            return ref.get();
        }
        return null;
    }

    private void removeUnreachableValues() {
        Reference ref = this.mRefQueue.poll();
        while (ref != null) {
            this.mSparseArray.remove(((WeakReferenceWithId) ref).mId);
            ref = this.mRefQueue.poll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class WeakReferenceWithId<E> extends WeakReference<E> {
        final int mId;

        WeakReferenceWithId(E referent, ReferenceQueue<? super E> q10, int id2) {
            super(referent, q10);
            this.mId = id2;
        }
    }
}
