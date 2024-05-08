package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q implements Parcelable.Creator<zas> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zas createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < F) {
            int z12 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z12);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z12);
            } else if (v2 == 2) {
                iBinder = SafeParcelReader.A(parcel, z12);
            } else if (v2 == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.o(parcel, z12, ConnectionResult.CREATOR);
            } else if (v2 == 4) {
                z10 = SafeParcelReader.w(parcel, z12);
            } else if (v2 != 5) {
                SafeParcelReader.E(parcel, z12);
            } else {
                z11 = SafeParcelReader.w(parcel, z12);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zas(i10, iBinder, connectionResult, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zas[] newArray(int i10) {
        return new zas[i10];
    }
}
