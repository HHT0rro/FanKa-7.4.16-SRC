package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.annotation.Annotation;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements k {

    /* renamed from: a, reason: collision with root package name */
    public final int f24322a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaj f24323b;

    public g(int i10, zzaj zzajVar) {
        this.f24322a = i10;
        this.f24323b = zzajVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class<? extends Annotation> annotationType() {
        return k.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f24322a == kVar.zza() && this.f24323b.equals(kVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f24322a ^ 14552422) + (this.f24323b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f24322a + "intEncoding=" + ((Object) this.f24323b) + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.k
    public final int zza() {
        return this.f24322a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.k
    public final zzaj zzb() {
        return this.f24323b;
    }
}
