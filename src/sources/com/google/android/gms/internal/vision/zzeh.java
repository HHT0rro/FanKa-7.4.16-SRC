package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class zzeh<K, V> extends w0<K, V> implements Serializable {
    private final transient zzef<K, ? extends zzeb<V>> zza;
    private final transient int zzb;

    public zzeh(zzef<K, ? extends zzeb<V>> zzefVar, int i10) {
        this.zza = zzefVar;
        this.zzb = i10;
    }

    @Override // com.google.android.gms.internal.vision.x0
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.x0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.x0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.android.gms.internal.vision.x0
    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    @Override // com.google.android.gms.internal.vision.x0
    public final Map<K, Collection<V>> zzb() {
        throw new AssertionError((Object) "should never be called");
    }

    @Override // com.google.android.gms.internal.vision.x0, com.google.android.gms.internal.vision.l1
    public final /* synthetic */ Map zza() {
        return this.zza;
    }
}
