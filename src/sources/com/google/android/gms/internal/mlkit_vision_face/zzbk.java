package com.google.android.gms.internal.mlkit_vision_face;

import com.huawei.quickcard.base.Attributes;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzbk extends zzbl {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzbl zzc;

    public zzbk(zzbl zzblVar, int i10, int i11) {
        this.zzc = zzblVar;
        this.zza = i10;
        this.zzb = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        a.b(i10, this.zzb, Attributes.Style.INDEX);
        return this.zzc.get(i10 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbl, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbl
    /* renamed from: zzf */
    public final zzbl subList(int i10, int i11) {
        a.d(i10, i11, this.zzb);
        zzbl zzblVar = this.zzc;
        int i12 = this.zza;
        return zzblVar.subList(i10 + i12, i11 + i12);
    }
}
