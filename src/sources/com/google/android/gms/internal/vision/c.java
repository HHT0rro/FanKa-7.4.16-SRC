package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Parcelable.Creator<zzaj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaj createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        Rect rect = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            if (SafeParcelReader.v(z10) != 2) {
                SafeParcelReader.E(parcel, z10);
            } else {
                rect = (Rect) SafeParcelReader.o(parcel, z10, Rect.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzaj(rect);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaj[] newArray(int i10) {
        return new zzaj[i10];
    }
}
