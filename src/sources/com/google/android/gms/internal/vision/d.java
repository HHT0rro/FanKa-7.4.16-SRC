package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements Parcelable.Creator<zzal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            SafeParcelReader.v(z10);
            SafeParcelReader.E(parcel, z10);
        }
        SafeParcelReader.u(parcel, F);
        return new zzal();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i10) {
        return new zzal[i10];
    }
}
