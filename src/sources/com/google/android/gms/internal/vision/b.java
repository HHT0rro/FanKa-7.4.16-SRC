package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Parcelable.Creator<zzah> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzah createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        zzao[] zzaoVarArr = null;
        zzab zzabVar = null;
        zzab zzabVar2 = null;
        zzab zzabVar3 = null;
        String str = null;
        String str2 = null;
        float f10 = 0.0f;
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z11)) {
                case 2:
                    zzaoVarArr = (zzao[]) SafeParcelReader.s(parcel, z11, zzao.CREATOR);
                    break;
                case 3:
                    zzabVar = (zzab) SafeParcelReader.o(parcel, z11, zzab.CREATOR);
                    break;
                case 4:
                    zzabVar2 = (zzab) SafeParcelReader.o(parcel, z11, zzab.CREATOR);
                    break;
                case 5:
                    zzabVar3 = (zzab) SafeParcelReader.o(parcel, z11, zzab.CREATOR);
                    break;
                case 6:
                    str = SafeParcelReader.p(parcel, z11);
                    break;
                case 7:
                    f10 = SafeParcelReader.y(parcel, z11);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, z11);
                    break;
                case 9:
                    i10 = SafeParcelReader.B(parcel, z11);
                    break;
                case 10:
                    z10 = SafeParcelReader.w(parcel, z11);
                    break;
                case 11:
                    i11 = SafeParcelReader.B(parcel, z11);
                    break;
                case 12:
                    i12 = SafeParcelReader.B(parcel, z11);
                    break;
                default:
                    SafeParcelReader.E(parcel, z11);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzah(zzaoVarArr, zzabVar, zzabVar2, zzabVar3, str, f10, str2, i10, z10, i11, i12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzah[] newArray(int i10) {
        return new zzah[i10];
    }
}
