package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements Parcelable.Creator<Barcode.GeoPoint> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.GeoPoint createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        double d10 = ShadowDrawableWrapper.COS_45;
        double d11 = 0.0d;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 2) {
                d10 = SafeParcelReader.x(parcel, z10);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z10);
            } else {
                d11 = SafeParcelReader.x(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.GeoPoint(d10, d11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.GeoPoint[] newArray(int i10) {
        return new Barcode.GeoPoint[i10];
    }
}
