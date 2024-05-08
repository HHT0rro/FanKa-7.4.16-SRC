package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z2 implements Parcelable.Creator<zzfz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfz createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        long j10 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                i11 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 3) {
                i12 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 4) {
                i13 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 5) {
                SafeParcelReader.E(parcel, z10);
            } else {
                j10 = SafeParcelReader.C(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzfz(i10, i11, i12, i13, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfz[] newArray(int i10) {
        return new zzfz[i10];
    }
}
