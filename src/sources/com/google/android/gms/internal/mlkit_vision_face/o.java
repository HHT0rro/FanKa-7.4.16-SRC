package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class o<K, V> implements m0<K, V> {

    @NullableDecl
    private transient Set<K> zza;

    @NullableDecl
    private transient Map<K, Collection<V>> zzb;

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m0) {
            return zzq().equals(((m0) obj).zzq());
        }
        return false;
    }

    public final int hashCode() {
        return zzq().hashCode();
    }

    public final String toString() {
        return ((f) zzq()).f24845d.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.m0
    public boolean zzd(@NullableDecl K k10, @NullableDecl V v2) {
        throw null;
    }

    public abstract Set<K> zzh();

    public abstract Map<K, Collection<V>> zzi();

    @Override // com.google.android.gms.internal.mlkit_vision_face.m0
    public final Set<K> zzp() {
        Set<K> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<K> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.m0
    public final Map<K, Collection<V>> zzq() {
        Map<K, Collection<V>> map = this.zzb;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzi = zzi();
        this.zzb = zzi;
        return zzi;
    }
}
