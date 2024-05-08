package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q9 implements Parcelable.Creator<zzp> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzp createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        long j10 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
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
                j10 = SafeParcelReader.C(parcel, z10);
            } else if (v2 != 6) {
                SafeParcelReader.E(parcel, z10);
            } else {
                i13 = SafeParcelReader.B(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzp(i10, i11, i12, j10, i13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzp[] newArray(int i10) {
        return new zzp[i10];
    }
}
