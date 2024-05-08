package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o7 extends AbstractList<String> implements o5, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public final o5 f25575b;

    public o7(o5 o5Var) {
        this.f25575b = o5Var;
    }

    @Override // com.google.android.gms.internal.vision.o5
    public final Object a(int i10) {
        return this.f25575b.a(i10);
    }

    @Override // com.google.android.gms.internal.vision.o5
    public final void e(zzht zzhtVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return (String) this.f25575b.get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator<String> iterator2() {
        return new q7(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i10) {
        return new n7(this, i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25575b.size();
    }

    @Override // com.google.android.gms.internal.vision.o5
    public final List<?> zzd() {
        return this.f25575b.zzd();
    }

    @Override // com.google.android.gms.internal.vision.o5
    public final o5 zze() {
        return this;
    }
}
