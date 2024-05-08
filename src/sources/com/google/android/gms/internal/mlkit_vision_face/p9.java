package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p9 implements Parcelable.Creator<zzn> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzn createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        float f10 = 0.0f;
        float f11 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                f10 = SafeParcelReader.y(parcel, z10);
            } else if (v2 == 3) {
                f11 = SafeParcelReader.y(parcel, z10);
            } else if (v2 != 4) {
                SafeParcelReader.E(parcel, z10);
            } else {
                i11 = SafeParcelReader.B(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzn(i10, f10, f11, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzn[] newArray(int i10) {
        return new zzn[i10];
    }
}
