package com.google.android.gms.internal.mlkit_common;

import com.huawei.quickcard.base.Attributes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzao<E> extends zzak<E> {
    public static final zzak<Object> zza = new zzao(new Object[0], 0);
    public final transient Object[] zzb;
    private final transient int zzc;

    public zzao(Object[] objArr, int i10) {
        this.zzb = objArr;
        this.zzc = i10;
    }

    @Override // java.util.List
    public final E get(int i10) {
        u0.a(i10, this.zzc, Attributes.Style.INDEX);
        return (E) this.zzb[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
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
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzak, com.google.android.gms.internal.mlkit_common.zzag
    public final int zze(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}