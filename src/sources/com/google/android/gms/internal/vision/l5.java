package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l5 extends p3<String> implements o5, RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final l5 f25536d;

    /* renamed from: e, reason: collision with root package name */
    public static final o5 f25537e;

    /* renamed from: c, reason: collision with root package name */
    public final List<Object> f25538c;

    static {
        l5 l5Var = new l5();
        f25536d = l5Var;
        l5Var.zzb();
        f25537e = l5Var;
    }

    public l5() {
        this(10);
    }

    public static String c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzht) {
            return ((zzht) obj).zzb();
        }
        return b5.i((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.vision.o5
    public final Object a(int i10) {
        return this.f25538c.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        b();
        this.f25538c.add(i10, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        b();
        this.f25538c.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.o5
    public final void e(zzht zzhtVar) {
        b();
        this.f25538c.add(zzhtVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        Object obj = this.f25538c.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzht) {
            zzht zzhtVar = (zzht) obj;
            String zzb = zzhtVar.zzb();
            if (zzhtVar.zzc()) {
                this.f25538c.set(i10, zzb);
            }
            return zzb;
        }
        byte[] bArr = (byte[]) obj;
        String i11 = b5.i(bArr);
        if (b5.h(bArr)) {
            this.f25538c.set(i10, i11);
        }
        return i11;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        b();
        return c(this.f25538c.set(i10, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25538c.size();
    }

    @Override // com.google.android.gms.internal.vision.p3, com.google.android.gms.internal.vision.g5
    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.internal.vision.o5
    public final List<?> zzd() {
        return Collections.unmodifiableList(this.f25538c);
    }

    @Override // com.google.android.gms.internal.vision.o5
    public final o5 zze() {
        return zza() ? new o7(this) : this;
    }

    public l5(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends String> collection) {
        b();
        if (collection instanceof o5) {
            collection = ((o5) collection).zzd();
        }
        boolean addAll = this.f25538c.addAll(i10, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        Object remove = this.f25538c.remove(i10);
        this.modCount++;
        return c(remove);
    }

    @Override // com.google.android.gms.internal.vision.g5
    public final /* synthetic */ g5 zza(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.f25538c);
            return new l5((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public l5(ArrayList<Object> arrayList) {
        this.f25538c = arrayList;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
