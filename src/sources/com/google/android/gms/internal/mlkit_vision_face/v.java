package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v extends n {

    /* renamed from: b, reason: collision with root package name */
    @NullableDecl
    public final Object f25252b;

    /* renamed from: c, reason: collision with root package name */
    public int f25253c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzbb f25254d;

    public v(zzbb zzbbVar, int i10) {
        this.f25254d = zzbbVar;
        this.f25252b = zzbbVar.zzb[i10];
        this.f25253c = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n, java.util.Map.Entry
    @NullableDecl
    public final Object getKey() {
        return this.f25252b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n, java.util.Map.Entry
    @NullableDecl
    public final Object getValue() {
        Map zzc = this.f25254d.zzc();
        if (zzc != null) {
            return zzc.get(this.f25252b);
        }
        j();
        int i10 = this.f25253c;
        if (i10 == -1) {
            return null;
        }
        return this.f25254d.zzc[i10];
    }

    public final void j() {
        int zzr;
        int i10 = this.f25253c;
        if (i10 == -1 || i10 >= this.f25254d.size() || !w9.a(this.f25252b, this.f25254d.zzb[this.f25253c])) {
            zzr = this.f25254d.zzr(this.f25252b);
            this.f25253c = zzr;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map zzc = this.f25254d.zzc();
        if (zzc != null) {
            return zzc.put(this.f25252b, obj);
        }
        j();
        int i10 = this.f25253c;
        if (i10 == -1) {
            this.f25254d.put(this.f25252b, obj);
            return null;
        }
        Object[] objArr = this.f25254d.zzc;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }
}
