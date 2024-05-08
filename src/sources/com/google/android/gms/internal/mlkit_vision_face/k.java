package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class k extends AbstractCollection {

    /* renamed from: b, reason: collision with root package name */
    @NullableDecl
    public final Object f24987b;

    /* renamed from: c, reason: collision with root package name */
    public Collection f24988c;

    /* renamed from: d, reason: collision with root package name */
    @NullableDecl
    public final k f24989d;

    /* renamed from: e, reason: collision with root package name */
    @NullableDecl
    public final Collection f24990e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzao f24991f;

    public k(@NullableDecl zzao zzaoVar, Object obj, @NullableDecl Collection collection, k kVar) {
        this.f24991f = zzaoVar;
        this.f24987b = obj;
        this.f24988c = collection;
        this.f24989d = kVar;
        this.f24990e = kVar == null ? null : kVar.f24988c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        b();
        boolean isEmpty = this.f24988c.isEmpty();
        boolean add = this.f24988c.add(obj);
        if (!add) {
            return add;
        }
        zzao.zzl(this.f24991f);
        if (!isEmpty) {
            return add;
        }
        c();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.f24988c.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        zzao.zzm(this.f24991f, this.f24988c.size() - size);
        if (size != 0) {
            return addAll;
        }
        c();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        Collection collection;
        k kVar = this.f24989d;
        if (kVar != null) {
            kVar.b();
            if (this.f24989d.f24988c != this.f24990e) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f24988c.isEmpty() || (collection = (Collection) zzao.zzj(this.f24991f).get(this.f24987b)) == null) {
                return;
            }
            this.f24988c = collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        k kVar = this.f24989d;
        if (kVar != null) {
            kVar.c();
        } else {
            zzao.zzj(this.f24991f).put(this.f24987b, this.f24988c);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f24988c.clear();
        zzao.zzn(this.f24991f, size);
        zzb();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        b();
        return this.f24988c.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        b();
        return this.f24988c.containsAll(collection);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        b();
        return this.f24988c.equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        b();
        return this.f24988c.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator iterator2() {
        b();
        return new j(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        b();
        boolean remove = this.f24988c.remove(obj);
        if (remove) {
            zzao.zzk(this.f24991f);
            zzb();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.f24988c.removeAll(collection);
        if (removeAll) {
            zzao.zzm(this.f24991f, this.f24988c.size() - size);
            zzb();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        int size = size();
        boolean retainAll = this.f24988c.retainAll(collection);
        if (retainAll) {
            zzao.zzm(this.f24991f, this.f24988c.size() - size);
            zzb();
        }
        return retainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        b();
        return this.f24988c.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        b();
        return this.f24988c.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        k kVar = this.f24989d;
        if (kVar != null) {
            kVar.zzb();
        } else if (this.f24988c.isEmpty()) {
            zzao.zzj(this.f24991f).remove(this.f24987b);
        }
    }
}
