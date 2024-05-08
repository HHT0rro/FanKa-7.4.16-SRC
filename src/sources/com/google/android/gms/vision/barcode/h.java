package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h implements Parcelable.Creator<Barcode.PersonName> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.PersonName createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z10)) {
                case 2:
                    str = SafeParcelReader.p(parcel, z10);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, z10);
                    break;
                case 4:
                    str3 = SafeParcelReader.p(parcel, z10);
                    break;
                case 5:
                    str4 = SafeParcelReader.p(parcel, z10);
                    break;
                case 6:
                    str5 = SafeParcelReader.p(parcel, z10);
                    break;
                case 7:
                    str6 = SafeParcelReader.p(parcel, z10);
                    break;
                case 8:
                    str7 = SafeParcelReader.p(parcel, z10);
                    break;
                default:
                    SafeParcelReader.E(parcel, z10);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.PersonName(str, str2, str3, str4, str5, str6, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.PersonName[] newArray(int i10) {
        return new Barcode.PersonName[i10];
    }
}
