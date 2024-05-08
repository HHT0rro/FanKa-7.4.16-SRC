package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l6 implements Parcelable.Creator<zzh> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzh createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        boolean z11 = false;
        float f10 = -1.0f;
        while (parcel.dataPosition() < F) {
            int z12 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z12)) {
                case 2:
                    i10 = SafeParcelReader.B(parcel, z12);
                    break;
                case 3:
                    i11 = SafeParcelReader.B(parcel, z12);
                    break;
                case 4:
                    i12 = SafeParcelReader.B(parcel, z12);
                    break;
                case 5:
                    z10 = SafeParcelReader.w(parcel, z12);
                    break;
                case 6:
                    z11 = SafeParcelReader.w(parcel, z12);
                    break;
                case 7:
                    f10 = SafeParcelReader.y(parcel, z12);
                    break;
                default:
                    SafeParcelReader.E(parcel, z12);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzh(i10, i11, i12, z10, z11, f10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzh[] newArray(int i10) {
        return new zzh[i10];
    }
}
