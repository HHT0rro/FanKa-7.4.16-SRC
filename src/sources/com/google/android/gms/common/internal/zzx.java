package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new h0();

    /* renamed from: b, reason: collision with root package name */
    public final int f23717b;

    public zzx(int i10) {
        this.f23717b = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23717b);
        w6.a.b(parcel, a10);
    }
}
