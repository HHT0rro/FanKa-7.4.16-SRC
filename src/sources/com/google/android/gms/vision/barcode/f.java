package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements Parcelable.Creator<Barcode.Email> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Email createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 2) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 3) {
                str = SafeParcelReader.p(parcel, z10);
            } else if (v2 == 4) {
                str2 = SafeParcelReader.p(parcel, z10);
            } else if (v2 != 5) {
                SafeParcelReader.E(parcel, z10);
            } else {
                str3 = SafeParcelReader.p(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.Email(i10, str, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Email[] newArray(int i10) {
        return new Barcode.Email[i10];
    }
}
