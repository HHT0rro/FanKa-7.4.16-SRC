package com.google.android.gms.internal.vision;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g1 extends u0 {

    /* renamed from: b, reason: collision with root package name */
    @NullableDecl
    public final Object f25472b;

    /* renamed from: c, reason: collision with root package name */
    public int f25473c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzdp f25474d;

    public g1(zzdp zzdpVar, int i10) {
        this.f25474d = zzdpVar;
        this.f25472b = zzdpVar.zzb[i10];
        this.f25473c = i10;
    }

    public final void a() {
        int zza;
        int i10 = this.f25473c;
        if (i10 == -1 || i10 >= this.f25474d.size() || !k0.a(this.f25472b, this.f25474d.zzb[this.f25473c])) {
            zza = this.f25474d.zza(this.f25472b);
            this.f25473c = zza;
        }
    }

    @Override // com.google.android.gms.internal.vision.u0, java.util.Map.Entry
    @NullableDecl
    public final Object getKey() {
        return this.f25472b;
    }

    @Override // com.google.android.gms.internal.vision.u0, java.util.Map.Entry
    @NullableDecl
    public final Object getValue() {
        Map zzb = this.f25474d.zzb();
        if (zzb != null) {
            return zzb.get(this.f25472b);
        }
        a();
        int i10 = this.f25473c;
        if (i10 == -1) {
            return null;
        }
        return this.f25474d.zzc[i10];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map zzb = this.f25474d.zzb();
        if (zzb != null) {
            return zzb.put(this.f25472b, obj);
        }
        a();
        int i10 = this.f25473c;
        if (i10 == -1) {
            this.f25474d.put(this.f25472b, obj);
            return null;
        }
        Object[] objArr = this.f25474d.zzc;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }
}
