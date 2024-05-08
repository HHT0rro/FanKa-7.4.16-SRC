package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements Parcelable.Creator<Barcode.Address> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Address createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 2) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z10);
            } else {
                strArr = SafeParcelReader.q(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.Address(i10, strArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Address[] newArray(int i10) {
        return new Barcode.Address[i10];
    }
}
