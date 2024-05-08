package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j implements Parcelable.Creator<Barcode.Sms> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Sms createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 2) {
                str = SafeParcelReader.p(parcel, z10);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z10);
            } else {
                str2 = SafeParcelReader.p(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.Sms(str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.Sms[] newArray(int i10) {
        return new Barcode.Sms[i10];
    }
}
