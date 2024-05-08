package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzbh<K, V> extends n<K, V> implements Serializable {

    @NullableDecl
    public final K zza;

    @NullableDecl
    public final V zzb;

    public zzbh(@NullableDecl K k10, @NullableDecl V v2) {
        this.zza = k10;
        this.zzb = v2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n, java.util.Map.Entry
    public final V setValue(V v2) {
        throw new UnsupportedOperationException();
    }
}
