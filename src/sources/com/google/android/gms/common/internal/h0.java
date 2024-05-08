package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h0 implements Parcelable.Creator<zzx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzx createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            if (SafeParcelReader.v(z10) != 1) {
                SafeParcelReader.E(parcel, z10);
            } else {
                i10 = SafeParcelReader.B(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzx(i10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzx[] newArray(int i10) {
        return new zzx[i10];
    }
}
