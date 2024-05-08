package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzgd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgd> CREATOR = new c3();

    /* renamed from: b, reason: collision with root package name */
    public final int f25750b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25751c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25752d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25753e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f25754f;

    /* renamed from: g, reason: collision with root package name */
    public final float f25755g;

    public zzgd(int i10, int i11, int i12, int i13, boolean z10, float f10) {
        this.f25750b = i10;
        this.f25751c = i11;
        this.f25752d = i12;
        this.f25753e = i13;
        this.f25754f = z10;
        this.f25755g = f10;
    }

    public final int f() {
        return this.f25753e;
    }

    public final float g() {
        return this.f25755g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25750b);
        w6.a.j(parcel, 2, this.f25751c);
        w6.a.j(parcel, 3, this.f25752d);
        w6.a.j(parcel, 4, this.f25753e);
        w6.a.c(parcel, 5, this.f25754f);
        w6.a.h(parcel, 6, this.f25755g);
        w6.a.b(parcel, a10);
    }

    public final int zza() {
        return this.f25750b;
    }

    public final int zzb() {
        return this.f25751c;
    }

    public final int zzc() {
        return this.f25752d;
    }

    public final boolean zze() {
        return this.f25754f;
    }
}
