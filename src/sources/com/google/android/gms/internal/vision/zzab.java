package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f25717b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25718c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25719d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25720e;

    /* renamed from: f, reason: collision with root package name */
    public final float f25721f;

    public zzab(int i10, int i11, int i12, int i13, float f10) {
        this.f25717b = i10;
        this.f25718c = i11;
        this.f25719d = i12;
        this.f25720e = i13;
        this.f25721f = f10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 2, this.f25717b);
        w6.a.j(parcel, 3, this.f25718c);
        w6.a.j(parcel, 4, this.f25719d);
        w6.a.j(parcel, 5, this.f25720e);
        w6.a.h(parcel, 6, this.f25721f);
        w6.a.b(parcel, a10);
    }
}
