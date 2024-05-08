package com.google.android.gms.internal.mlkit_common;

import com.huawei.quickcard.base.Attributes;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzaj extends zzak {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzak zzc;

    public zzaj(zzak zzakVar, int i10, int i11) {
        this.zzc = zzakVar;
        this.zza = i10;
        this.zzb = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        u0.a(i10, this.zzb, Attributes.Style.INDEX);
        return this.zzc.get(i10 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzak, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzak
    /* renamed from: zzf */
    public final zzak subList(int i10, int i11) {
        u0.c(i10, i11, this.zzb);
        zzak zzakVar = this.zzc;
        int i12 = this.zza;
        return zzakVar.subList(i10 + i12, i11 + i12);
    }
}
