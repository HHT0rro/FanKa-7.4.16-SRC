package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzu<E> extends zzq<E> {
    public static final zzu<Object> zza = new zzu<>(new Object[0], 0, null, 0, 0);
    public final transient Object[] zzb;
    public final transient Object[] zzc;
    private final transient int zzd;
    private final transient int zze;
    private final transient int zzf;

    public zzu(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.zzb = objArr;
        this.zzc = objArr2;
        this.zzd = i11;
        this.zze = i10;
        this.zzf = i12;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr == null) {
            return false;
        }
        int a10 = e7.a(obj.hashCode());
        while (true) {
            int i10 = a10 & this.zzd;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a10 = i10 + 1;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq, com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final /* bridge */ /* synthetic */ Iterator iterator2() {
        return zzi().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq, com.google.android.gms.internal.mlkit_vision_common.zzl
    /* renamed from: zza */
    public final m7<E> iterator2() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zze(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzf);
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzq
    public final zzp<E> zzj() {
        return zzp.zzh(this.zzb, this.zzf);
    }
}
