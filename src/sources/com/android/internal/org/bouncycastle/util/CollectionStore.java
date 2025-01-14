package com.android.internal.org.bouncycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CollectionStore<T> implements Store<T>, Iterable<T> {
    private Collection<T> _local;

    public CollectionStore(Collection<T> collection) {
        this._local = new ArrayList(collection);
    }

    @Override // com.android.internal.org.bouncycastle.util.Store
    public Collection<T> getMatches(Selector<T> selector) {
        if (selector == null) {
            return new ArrayList(this._local);
        }
        List<T> col = new ArrayList<>();
        for (T obj : this._local) {
            if (selector.match(obj)) {
                col.add(obj);
            }
        }
        return col;
    }

    @Override // com.android.internal.org.bouncycastle.util.Iterable, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<T> iterator2() {
        return getMatches(null).iterator2();
    }
}
