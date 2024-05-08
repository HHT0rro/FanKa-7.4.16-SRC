package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        int i10 = 0;
        long j10 = -1;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                str = SafeParcelReader.p(parcel, z10);
            } else if (v2 == 2) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z10);
            } else {
                j10 = SafeParcelReader.C(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Feature(str, i10, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i10) {
        return new Feature[i10];
    }
}
