package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzcb<E> extends zzbm<E> {
    public static final zzcb<Object> zza = new zzcb<>(new Object[0], 0, null, 0, 0);
    public final transient Object[] zzb;
    public final transient Object[] zzc;
    private final transient int zzd;
    private final transient int zze;
    private final transient int zzf;

    public zzcb(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.zzb = objArr;
        this.zzc = objArr2;
        this.zzd = i11;
        this.zze = i10;
        this.zzf = i12;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr == null) {
            return false;
        }
        int b4 = y.b(obj);
        while (true) {
            int i10 = b4 & this.zzd;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            b4 = i10 + 1;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm, com.google.android.gms.internal.mlkit_vision_face.zzbg, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final /* bridge */ /* synthetic */ Iterator iterator2() {
        return zzi().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm, com.google.android.gms.internal.mlkit_vision_face.zzbg
    /* renamed from: zza */
    public final t0<E> iterator2() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public final int zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public final int zze(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzf);
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbm
    public final zzbl<E> zzj() {
        return zzbl.zzi(this.zzb, this.zzf);
    }
}
