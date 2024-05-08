package com.android.internal.app;

import android.util.ArrayMap;
import android.util.SparseArray;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ProcessMap<E> {
    final ArrayMap<String, SparseArray<E>> mMap = new ArrayMap<>();

    public E get(String name, int uid) {
        SparseArray<E> uids = this.mMap.get(name);
        if (uids == null) {
            return null;
        }
        return uids.get(uid);
    }

    public E put(String name, int uid, E value) {
        SparseArray<E> uids = this.mMap.get(name);
        if (uids == null) {
            uids = new SparseArray<>(2);
            this.mMap.put(name, uids);
        }
        uids.put(uid, value);
        return value;
    }

    public E remove(String str, int i10) {
        SparseArray<E> sparseArray = this.mMap.get(str);
        if (sparseArray != null) {
            E e2 = (E) sparseArray.removeReturnOld(i10);
            if (sparseArray.size() == 0) {
                this.mMap.remove(str);
            }
            return e2;
        }
        return null;
    }

    public ArrayMap<String, SparseArray<E>> getMap() {
        return this.mMap;
    }

    public int size() {
        return this.mMap.size();
    }

    public void clear() {
        this.mMap.clear();
    }

    public void putAll(ProcessMap<E> other) {
        this.mMap.putAll((ArrayMap<? extends String, ? extends SparseArray<E>>) other.mMap);
    }
}
