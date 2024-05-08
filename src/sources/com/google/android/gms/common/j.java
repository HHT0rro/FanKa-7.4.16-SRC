package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        boolean z10 = false;
        String str = null;
        IBinder iBinder = null;
        boolean z11 = false;
        while (parcel.dataPosition() < F) {
            int z12 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z12);
            if (v2 == 1) {
                str = SafeParcelReader.p(parcel, z12);
            } else if (v2 == 2) {
                iBinder = SafeParcelReader.A(parcel, z12);
            } else if (v2 == 3) {
                z10 = SafeParcelReader.w(parcel, z12);
            } else if (v2 != 4) {
                SafeParcelReader.E(parcel, z12);
            } else {
                z11 = SafeParcelReader.w(parcel, z12);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzj(str, iBinder, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i10) {
        return new zzj[i10];
    }
}
