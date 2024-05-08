package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l9 implements Parcelable.Creator<zzlf> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzlf createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 2) {
                SafeParcelReader.E(parcel, z10);
            } else {
                arrayList = SafeParcelReader.t(parcel, z10, PointF.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzlf(i10, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzlf[] newArray(int i10) {
        return new zzlf[i10];
    }
}
