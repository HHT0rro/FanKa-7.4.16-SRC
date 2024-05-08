package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l implements Parcelable.Creator<Barcode.WiFi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.WiFi createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 2) {
                str = SafeParcelReader.p(parcel, z10);
            } else if (v2 == 3) {
                str2 = SafeParcelReader.p(parcel, z10);
            } else if (v2 != 4) {
                SafeParcelReader.E(parcel, z10);
            } else {
                i10 = SafeParcelReader.B(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.WiFi(str, str2, i10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.WiFi[] newArray(int i10) {
        return new Barcode.WiFi[i10];
    }
}
