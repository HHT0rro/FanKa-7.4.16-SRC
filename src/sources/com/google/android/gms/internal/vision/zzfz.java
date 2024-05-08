package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzfz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfz> CREATOR = new z2();

    /* renamed from: b, reason: collision with root package name */
    public final int f25743b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25744c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25745d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25746e;

    /* renamed from: f, reason: collision with root package name */
    public final long f25747f;

    public zzfz(int i10, int i11, int i12, int i13, long j10) {
        this.f25743b = i10;
        this.f25744c = i11;
        this.f25745d = i12;
        this.f25746e = i13;
        this.f25747f = j10;
    }

    public final int f() {
        return this.f25746e;
    }

    public final long g() {
        return this.f25747f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25743b);
        w6.a.j(parcel, 2, this.f25744c);
        w6.a.j(parcel, 3, this.f25745d);
        w6.a.j(parcel, 4, this.f25746e);
        w6.a.l(parcel, 5, this.f25747f);
        w6.a.b(parcel, a10);
    }

    public final int zza() {
        return this.f25743b;
    }

    public final int zzb() {
        return this.f25744c;
    }

    public final int zzc() {
        return this.f25745d;
    }
}
