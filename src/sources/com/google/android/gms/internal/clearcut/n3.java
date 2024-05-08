package com.google.android.gms.internal.clearcut;

import java.util.ListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n3 implements ListIterator<String> {

    /* renamed from: b, reason: collision with root package name */
    public ListIterator<String> f23960b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f23961c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m3 f23962d;

    public n3(m3 m3Var, int i10) {
        j1 j1Var;
        this.f23962d = m3Var;
        this.f23961c = i10;
        j1Var = m3Var.f23956b;
        this.f23960b = j1Var.listIterator(i10);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f23960b.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f23960b.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f23960b.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f23960b.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f23960b.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f23960b.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
