package com.google.android.gms.internal.vision;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e3 implements Parcelable.Creator<zzgn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgn createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        PointF pointF = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 2) {
                SafeParcelReader.E(parcel, z10);
            } else {
                pointF = (PointF) SafeParcelReader.o(parcel, z10, PointF.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzgn(i10, pointF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgn[] newArray(int i10) {
        return new zzgn[i10];
    }
}
