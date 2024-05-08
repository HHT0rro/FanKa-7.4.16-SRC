package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v implements Parcelable.Creator<ConnectionTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionTelemetryConfiguration createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArr = null;
        boolean z10 = false;
        boolean z11 = false;
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z12 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z12);
            if (v2 == 1) {
                rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.o(parcel, z12, RootTelemetryConfiguration.CREATOR);
            } else if (v2 == 2) {
                z10 = SafeParcelReader.w(parcel, z12);
            } else if (v2 == 3) {
                z11 = SafeParcelReader.w(parcel, z12);
            } else if (v2 == 4) {
                iArr = SafeParcelReader.k(parcel, z12);
            } else if (v2 != 5) {
                SafeParcelReader.E(parcel, z12);
            } else {
                i10 = SafeParcelReader.B(parcel, z12);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z10, z11, iArr, i10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionTelemetryConfiguration[] newArray(int i10) {
        return new ConnectionTelemetryConfiguration[i10];
    }
}
