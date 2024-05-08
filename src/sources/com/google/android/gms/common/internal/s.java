package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s implements Parcelable.Creator<zau> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zau createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        Scope[] scopeArr = null;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                i11 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 3) {
                i12 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 4) {
                SafeParcelReader.E(parcel, z10);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.s(parcel, z10, Scope.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zau(i10, i11, i12, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zau[] newArray(int i10) {
        return new zau[i10];
    }
}
