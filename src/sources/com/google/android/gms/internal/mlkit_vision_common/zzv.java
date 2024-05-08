package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzv<E> extends zzq<E> {
    public final transient E zza;
    private transient int zzb;

    public zzv(E e2) {
        Objects.requireNonNull(e2);
        this.zza = e2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = this.zzb;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq, com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final /* bridge */ /* synthetic */ Iterator iterator2() {
        return new k7(this.zza);
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq, com.google.android.gms.internal.mlkit_vision_common.zzl
    /* renamed from: zza */
    public final m7<E> iterator2() {
        return new k7(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zze(Object[] objArr, int i10) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq
    public final boolean zzh() {
        return this.zzb != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq
    public final zzp<E> zzj() {
        return zzp.zzg(this.zza);
    }

    public zzv(E e2, int i10) {
        this.zza = e2;
        this.zzb = i10;
    }
}
