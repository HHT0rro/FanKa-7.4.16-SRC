package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzap<E> extends zzal<E> {
    public static final zzap<Object> zza = new zzap<>(new Object[0], 0, null, 0, 0);
    public final transient Object[] zzb;
    public final transient Object[] zzc;
    private final transient int zzd;
    private final transient int zze;
    private final transient int zzf;

    public zzap(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.zzb = objArr;
        this.zzc = objArr2;
        this.zzd = i11;
        this.zze = i10;
        this.zzf = i12;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr == null) {
            return false;
        }
        int a10 = e.a(obj.hashCode());
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

    @Override // com.google.android.gms.internal.mlkit_common.zzal, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal, com.google.android.gms.internal.mlkit_common.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final /* bridge */ /* synthetic */ Iterator iterator2() {
        return zzi().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal, com.google.android.gms.internal.mlkit_common.zzag
    /* renamed from: zza */
    public final l<E> iterator2() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public final int zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public final int zze(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzf);
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzal
    public final zzak<E> zzj() {
        return zzak.zzi(this.zzb, this.zzf);
    }
}
