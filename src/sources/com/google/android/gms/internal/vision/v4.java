package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v4 implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z11);
            if (v2 == 2) {
                i10 = SafeParcelReader.B(parcel, z11);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z11);
            } else {
                z10 = SafeParcelReader.w(parcel, z11);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzk(i10, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i10) {
        return new zzk[i10];
    }
}
