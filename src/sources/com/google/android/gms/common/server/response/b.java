package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        zaa zaaVar = null;
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        while (parcel.dataPosition() < F) {
            int z12 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z12)) {
                case 1:
                    i10 = SafeParcelReader.B(parcel, z12);
                    break;
                case 2:
                    i11 = SafeParcelReader.B(parcel, z12);
                    break;
                case 3:
                    z10 = SafeParcelReader.w(parcel, z12);
                    break;
                case 4:
                    i12 = SafeParcelReader.B(parcel, z12);
                    break;
                case 5:
                    z11 = SafeParcelReader.w(parcel, z12);
                    break;
                case 6:
                    str = SafeParcelReader.p(parcel, z12);
                    break;
                case 7:
                    i13 = SafeParcelReader.B(parcel, z12);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, z12);
                    break;
                case 9:
                    zaaVar = (zaa) SafeParcelReader.o(parcel, z12, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, z12);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new FastJsonResponse.Field(i10, i11, z10, i12, z11, str, i13, str2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i10) {
        return new FastJsonResponse.Field[i10];
    }
}
