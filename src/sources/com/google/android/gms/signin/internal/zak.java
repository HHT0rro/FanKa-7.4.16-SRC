package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zar;
import o7.d;
import w6.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new d();

    /* renamed from: b, reason: collision with root package name */
    public final int f25815b;

    /* renamed from: c, reason: collision with root package name */
    public final zar f25816c;

    public zak(int i10, zar zarVar) {
        this.f25815b = i10;
        this.f25816c = zarVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 1, this.f25815b);
        a.n(parcel, 2, this.f25816c, i10, false);
        a.b(parcel, a10);
    }

    public zak(zar zarVar) {
        this(1, zarVar);
    }
}
