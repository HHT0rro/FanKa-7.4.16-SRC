package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n2<E> extends t<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final n2<Object> f23958d;

    /* renamed from: c, reason: collision with root package name */
    public final List<E> f23959c;

    static {
        n2<Object> n2Var = new n2<>();
        f23958d = n2Var;
        n2Var.k();
    }

    public n2() {
        this(new ArrayList(10));
    }

    public n2(List<E> list) {
        this.f23959c = list;
    }

    public static <E> n2<E> c() {
        return (n2<E>) f23958d;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, E e2) {
        b();
        this.f23959c.add(i10, e2);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.c1
    public final /* synthetic */ c1 d(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f23959c);
        return new n2(arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i10) {
        return this.f23959c.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i10) {
        b();
        E remove = this.f23959c.remove(i10);
        this.modCount++;
        return remove;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i10, E e2) {
        b();
        E e10 = this.f23959c.set(i10, e2);
        this.modCount++;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f23959c.size();
    }
}
