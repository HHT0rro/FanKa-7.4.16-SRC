package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements Parcelable.Creator<zzao> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzao createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        zzal[] zzalVarArr = null;
        zzab zzabVar = null;
        zzab zzabVar2 = null;
        String str = null;
        String str2 = null;
        float f10 = 0.0f;
        boolean z10 = false;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z11)) {
                case 2:
                    zzalVarArr = (zzal[]) SafeParcelReader.s(parcel, z11, zzal.CREATOR);
                    break;
                case 3:
                    zzabVar = (zzab) SafeParcelReader.o(parcel, z11, zzab.CREATOR);
                    break;
                case 4:
                    zzabVar2 = (zzab) SafeParcelReader.o(parcel, z11, zzab.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.p(parcel, z11);
                    break;
                case 6:
                    f10 = SafeParcelReader.y(parcel, z11);
                    break;
                case 7:
                    str2 = SafeParcelReader.p(parcel, z11);
                    break;
                case 8:
                    z10 = SafeParcelReader.w(parcel, z11);
                    break;
                default:
                    SafeParcelReader.E(parcel, z11);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzao(zzalVarArr, zzabVar, zzabVar2, str, f10, str2, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzao[] newArray(int i10) {
        return new zzao[i10];
    }
}
