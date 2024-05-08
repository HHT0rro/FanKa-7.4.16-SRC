package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements Parcelable.Creator<Barcode.DriverLicense> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.DriverLicense createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
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
                case 9:
                    str8 = SafeParcelReader.p(parcel, z10);
                    break;
                case 10:
                    str9 = SafeParcelReader.p(parcel, z10);
                    break;
                case 11:
                    str10 = SafeParcelReader.p(parcel, z10);
                    break;
                case 12:
                    str11 = SafeParcelReader.p(parcel, z10);
                    break;
                case 13:
                    str12 = SafeParcelReader.p(parcel, z10);
                    break;
                case 14:
                    str13 = SafeParcelReader.p(parcel, z10);
                    break;
                case 15:
                    str14 = SafeParcelReader.p(parcel, z10);
                    break;
                default:
                    SafeParcelReader.E(parcel, z10);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.DriverLicense(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.DriverLicense[] newArray(int i10) {
        return new Barcode.DriverLicense[i10];
    }
}
