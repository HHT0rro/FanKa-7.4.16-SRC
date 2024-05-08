package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m3 extends AbstractList<String> implements j1, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public final j1 f23956b;

    public m3(j1 j1Var) {
        this.f23956b = j1Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return (String) this.f23956b.get(i10);
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final Object getRaw(int i10) {
        return this.f23956b.getRaw(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator<String> iterator2() {
        return new o3(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i10) {
        return new n3(this, i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f23956b.size();
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final List<?> u() {
        return this.f23956b.u();
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final j1 w() {
        return this;
    }
}
