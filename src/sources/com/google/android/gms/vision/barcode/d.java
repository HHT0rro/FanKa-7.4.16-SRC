package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements Parcelable.Creator<Barcode.ContactInfo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.ContactInfo createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        Barcode.PersonName personName = null;
        String str = null;
        String str2 = null;
        Barcode.Phone[] phoneArr = null;
        Barcode.Email[] emailArr = null;
        String[] strArr = null;
        Barcode.Address[] addressArr = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z10)) {
                case 2:
                    personName = (Barcode.PersonName) SafeParcelReader.o(parcel, z10, Barcode.PersonName.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.p(parcel, z10);
                    break;
                case 4:
                    str2 = SafeParcelReader.p(parcel, z10);
                    break;
                case 5:
                    phoneArr = (Barcode.Phone[]) SafeParcelReader.s(parcel, z10, Barcode.Phone.CREATOR);
                    break;
                case 6:
                    emailArr = (Barcode.Email[]) SafeParcelReader.s(parcel, z10, Barcode.Email.CREATOR);
                    break;
                case 7:
                    strArr = SafeParcelReader.q(parcel, z10);
                    break;
                case 8:
                    addressArr = (Barcode.Address[]) SafeParcelReader.s(parcel, z10, Barcode.Address.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, z10);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.ContactInfo(personName, str, str2, phoneArr, emailArr, strArr, addressArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.ContactInfo[] newArray(int i10) {
        return new Barcode.ContactInfo[i10];
    }
}
