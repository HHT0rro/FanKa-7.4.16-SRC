package com.google.android.gms.internal.vision;

import java.util.AbstractMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzeu extends zzee {
    private final /* synthetic */ zzer zza;

    public zzeu(zzer zzerVar) {
        this.zza = zzerVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i10) {
        int i11;
        Object[] objArr;
        Object[] objArr2;
        i11 = this.zza.zzd;
        p0.a(i10, i11);
        objArr = this.zza.zzb;
        int i12 = i10 * 2;
        Object obj = objArr[i12];
        objArr2 = this.zza.zzb;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i12 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i10;
        i10 = this.zza.zzd;
        return i10;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }
}
