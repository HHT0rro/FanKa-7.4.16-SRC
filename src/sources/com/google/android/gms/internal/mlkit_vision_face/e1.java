package com.google.android.gms.internal.mlkit_vision_face;

import java.lang.annotation.Annotation;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e1 implements i1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f24821a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcv f24822b;

    public e1(int i10, zzcv zzcvVar) {
        this.f24821a = i10;
        this.f24822b = zzcvVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class<? extends Annotation> annotationType() {
        return i1.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return this.f24821a == i1Var.zza() && this.f24822b.equals(i1Var.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f24821a ^ 14552422) + (this.f24822b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f24821a + "intEncoding=" + ((Object) this.f24822b) + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.i1
    public final int zza() {
        return this.f24821a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.i1
    public final zzcv zzb() {
        return this.f24822b;
    }
}
