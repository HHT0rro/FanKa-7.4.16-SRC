package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class j implements Iterator {

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f24950b;

    /* renamed from: c, reason: collision with root package name */
    public final Collection f24951c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f24952d;

    public j(k kVar) {
        Iterator iterator2;
        this.f24952d = kVar;
        Collection collection = kVar.f24988c;
        this.f24951c = collection;
        if (collection instanceof List) {
            iterator2 = ((List) collection).listIterator();
        } else {
            iterator2 = collection.iterator2();
        }
        this.f24950b = iterator2;
    }

    public j(k kVar, Iterator it) {
        this.f24952d = kVar;
        this.f24951c = kVar.f24988c;
        this.f24950b = it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f24952d.b();
        if (this.f24952d.f24988c != this.f24951c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return this.f24950b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        a();
        return this.f24950b.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f24950b.remove();
        zzao.zzk(this.f24952d.f24991f);
        this.f24952d.zzb();
    }
}
