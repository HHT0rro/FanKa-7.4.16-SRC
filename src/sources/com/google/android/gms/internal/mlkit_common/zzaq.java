package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzaq<E> extends zzal<E> {
    public final transient E zza;
    private transient int zzb;

    public zzaq(E e2) {
        Objects.requireNonNull(e2);
        this.zza = e2;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = this.zzb;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal, com.google.android.gms.internal.mlkit_common.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final /* bridge */ /* synthetic */ Iterator iterator2() {
        return new j(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2);
        sb2.append('[');
        sb2.append(obj);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal, com.google.android.gms.internal.mlkit_common.zzag
    /* renamed from: zza */
    public final l<E> iterator2() {
        return new j(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public final int zze(Object[] objArr, int i10) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal
    public final boolean zzh() {
        return this.zzb != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal
    public final zzak<E> zzj() {
        return zzak.zzg(this.zza);
    }

    public zzaq(E e2, int i10) {
        this.zza = e2;
        this.zzb = i10;
    }
}
