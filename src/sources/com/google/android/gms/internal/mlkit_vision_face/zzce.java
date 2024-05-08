package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzce<E> extends zzbm<E> {
    public final transient E zza;
    private transient int zzb;

    public zzce(E e2) {
        Objects.requireNonNull(e2);
        this.zza = e2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = this.zzb;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm, com.google.android.gms.internal.mlkit_vision_face.zzbg, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final /* bridge */ /* synthetic */ Iterator iterator2() {
        return new d0(this.zza);
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

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm, com.google.android.gms.internal.mlkit_vision_face.zzbg
    /* renamed from: zza */
    public final t0<E> iterator2() {
        return new d0(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public final int zze(Object[] objArr, int i10) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm
    public final boolean zzh() {
        return this.zzb != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm
    public final zzbl<E> zzj() {
        return zzbl.zzg(this.zza);
    }

    public zzce(E e2, int i10) {
        this.zza = e2;
        this.zzb = i10;
    }
}
