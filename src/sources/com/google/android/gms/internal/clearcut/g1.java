package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g1<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: b, reason: collision with root package name */
    public Iterator<Map.Entry<K, Object>> f23906b;

    public g1(Iterator<Map.Entry<K, Object>> it) {
        this.f23906b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f23906b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f23906b.next();
        return next.getValue() instanceof d1 ? new f1(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f23906b.remove();
    }
}
