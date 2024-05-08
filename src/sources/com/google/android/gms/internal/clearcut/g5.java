package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g5 implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i10 = 0;
        int i11 = 0;
        boolean z10 = true;
        boolean z11 = false;
        int i12 = 0;
        while (parcel.dataPosition() < F) {
            int z12 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z12)) {
                case 2:
                    str = SafeParcelReader.p(parcel, z12);
                    break;
                case 3:
                    i10 = SafeParcelReader.B(parcel, z12);
                    break;
                case 4:
                    i11 = SafeParcelReader.B(parcel, z12);
                    break;
                case 5:
                    str2 = SafeParcelReader.p(parcel, z12);
                    break;
                case 6:
                    str3 = SafeParcelReader.p(parcel, z12);
                    break;
                case 7:
                    z10 = SafeParcelReader.w(parcel, z12);
                    break;
                case 8:
                    str4 = SafeParcelReader.p(parcel, z12);
                    break;
                case 9:
                    z11 = SafeParcelReader.w(parcel, z12);
                    break;
                case 10:
                    i12 = SafeParcelReader.B(parcel, z12);
                    break;
                default:
                    SafeParcelReader.E(parcel, z12);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzr(str, i10, i11, str2, str3, z10, str4, z11, i12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i10) {
        return new zzr[i10];
    }
}
