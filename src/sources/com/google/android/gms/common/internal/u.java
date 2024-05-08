package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                bundle = SafeParcelReader.f(parcel, z10);
            } else if (v2 == 2) {
                featureArr = (Feature[]) SafeParcelReader.s(parcel, z10, Feature.CREATOR);
            } else if (v2 == 3) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 4) {
                SafeParcelReader.E(parcel, z10);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.o(parcel, z10, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzc(bundle, featureArr, i10, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i10) {
        return new zzc[i10];
    }
}
