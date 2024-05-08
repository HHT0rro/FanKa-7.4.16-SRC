package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j5<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: b, reason: collision with root package name */
    public Iterator<Map.Entry<K, Object>> f25518b;

    public j5(Iterator<Map.Entry<K, Object>> it) {
        this.f25518b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25518b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f25518b.next();
        return next.getValue() instanceof i5 ? new k5(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f25518b.remove();
    }
}
