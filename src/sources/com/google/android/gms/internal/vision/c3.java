package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c3 implements Parcelable.Creator<zzgd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgd createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        boolean z10 = false;
        float f10 = 0.0f;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z11)) {
                case 1:
                    i10 = SafeParcelReader.B(parcel, z11);
                    break;
                case 2:
                    i11 = SafeParcelReader.B(parcel, z11);
                    break;
                case 3:
                    i12 = SafeParcelReader.B(parcel, z11);
                    break;
                case 4:
                    i13 = SafeParcelReader.B(parcel, z11);
                    break;
                case 5:
                    z10 = SafeParcelReader.w(parcel, z11);
                    break;
                case 6:
                    f10 = SafeParcelReader.y(parcel, z11);
                    break;
                default:
                    SafeParcelReader.E(parcel, z11);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzgd(i10, i11, i12, i13, z10, f10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgd[] newArray(int i10) {
        return new zzgd[i10];
    }
}
