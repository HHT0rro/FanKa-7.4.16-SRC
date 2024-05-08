package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements Parcelable.Creator<zzab> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzab createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        float f10 = 0.0f;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 2) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 3) {
                i11 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 4) {
                i12 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 5) {
                i13 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 6) {
                SafeParcelReader.E(parcel, z10);
            } else {
                f10 = SafeParcelReader.y(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzab(i10, i11, i12, i13, f10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzab[] newArray(int i10) {
        return new zzab[i10];
    }
}
