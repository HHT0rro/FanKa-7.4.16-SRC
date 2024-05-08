package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements Iterator {

    /* renamed from: b, reason: collision with root package name */
    @NullableDecl
    public Map.Entry f24876b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Iterator f24877c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f24878d;

    public g(h hVar, Iterator it) {
        this.f24878d = hVar;
        this.f24877c = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f24877c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f24877c.next();
        this.f24876b = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        a.a(this.f24876b != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.f24876b.getValue();
        this.f24877c.remove();
        zzao.zzn(this.f24878d.f24899c, collection.size());
        collection.clear();
        this.f24876b = null;
    }
}
