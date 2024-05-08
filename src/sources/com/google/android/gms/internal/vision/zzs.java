package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new l8();

    /* renamed from: b, reason: collision with root package name */
    public int f25778b;

    /* renamed from: c, reason: collision with root package name */
    public int f25779c;

    /* renamed from: d, reason: collision with root package name */
    public int f25780d;

    /* renamed from: e, reason: collision with root package name */
    public long f25781e;

    /* renamed from: f, reason: collision with root package name */
    public int f25782f;

    public zzs() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 2, this.f25778b);
        w6.a.j(parcel, 3, this.f25779c);
        w6.a.j(parcel, 4, this.f25780d);
        w6.a.l(parcel, 5, this.f25781e);
        w6.a.j(parcel, 6, this.f25782f);
        w6.a.b(parcel, a10);
    }

    public zzs(int i10, int i11, int i12, long j10, int i13) {
        this.f25778b = i10;
        this.f25779c = i11;
        this.f25780d = i12;
        this.f25781e = j10;
        this.f25782f = i13;
    }
}
