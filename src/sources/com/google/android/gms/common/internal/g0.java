package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g0 implements Parcelable.Creator<RootTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RootTelemetryConfiguration createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < F) {
            int z12 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z12);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z12);
            } else if (v2 == 2) {
                z10 = SafeParcelReader.w(parcel, z12);
            } else if (v2 == 3) {
                z11 = SafeParcelReader.w(parcel, z12);
            } else if (v2 == 4) {
                i11 = SafeParcelReader.B(parcel, z12);
            } else if (v2 != 5) {
                SafeParcelReader.E(parcel, z12);
            } else {
                i12 = SafeParcelReader.B(parcel, z12);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new RootTelemetryConfiguration(i10, z10, z11, i11, i12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RootTelemetryConfiguration[] newArray(int i10) {
        return new RootTelemetryConfiguration[i10];
    }
}
