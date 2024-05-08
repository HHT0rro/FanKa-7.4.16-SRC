package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i1 extends t<String> implements j1, RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final i1 f23916d;

    /* renamed from: e, reason: collision with root package name */
    public static final j1 f23917e;

    /* renamed from: c, reason: collision with root package name */
    public final List<Object> f23918c;

    static {
        i1 i1Var = new i1();
        f23916d = i1Var;
        i1Var.k();
        f23917e = i1Var;
    }

    public i1() {
        this(10);
    }

    public i1(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    public i1(ArrayList<Object> arrayList) {
        this.f23918c = arrayList;
    }

    public static String c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzbb ? ((zzbb) obj).zzz() : z0.h((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        b();
        this.f23918c.add(i10, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends String> collection) {
        b();
        if (collection instanceof j1) {
            collection = ((j1) collection).u();
        }
        boolean addAll = this.f23918c.addAll(i10, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        b();
        this.f23918c.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.c1
    public final /* synthetic */ c1 d(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f23918c);
        return new i1((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        Object obj = this.f23918c.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbb) {
            zzbb zzbbVar = (zzbb) obj;
            String zzz = zzbbVar.zzz();
            if (zzbbVar.zzaa()) {
                this.f23918c.set(i10, zzz);
            }
            return zzz;
        }
        byte[] bArr = (byte[]) obj;
        String h10 = z0.h(bArr);
        if (z0.g(bArr)) {
            this.f23918c.set(i10, h10);
        }
        return h10;
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final Object getRaw(int i10) {
        return this.f23918c.get(i10);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.clearcut.t, com.google.android.gms.internal.clearcut.c1
    public final /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        Object remove = this.f23918c.remove(i10);
        this.modCount++;
        return c(remove);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        b();
        return c(this.f23918c.set(i10, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f23918c.size();
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final List<?> u() {
        return Collections.unmodifiableList(this.f23918c);
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final j1 w() {
        return j() ? new m3(this) : this;
    }
}
