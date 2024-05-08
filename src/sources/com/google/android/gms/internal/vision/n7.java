package com.google.android.gms.internal.vision;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n7 implements ListIterator<String> {

    /* renamed from: b, reason: collision with root package name */
    public ListIterator<String> f25566b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f25567c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o7 f25568d;

    public n7(o7 o7Var, int i10) {
        o5 o5Var;
        this.f25568d = o7Var;
        this.f25567c = i10;
        o5Var = o7Var.f25575b;
        this.f25566b = o5Var.listIterator(i10);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f25566b.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f25566b.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f25566b.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f25566b.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f25566b.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f25566b.previousIndex();
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
