package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
class zzad<K, V> extends zzao<K, V> implements f0<K, V> {
    public zzad(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzao
    public final Collection<V> zza(K k10, Collection<V> collection) {
        return zzg(k10, (List) collection, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.f0
    public final List<V> zzb(@NullableDecl K k10) {
        return (List<V>) super.zzf(k10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzao
    public /* bridge */ /* synthetic */ Collection zzc() {
        throw null;
    }
}
