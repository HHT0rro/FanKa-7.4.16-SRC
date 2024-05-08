package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new u();

    /* renamed from: b, reason: collision with root package name */
    public Bundle f23714b;

    /* renamed from: c, reason: collision with root package name */
    public Feature[] f23715c;

    /* renamed from: d, reason: collision with root package name */
    public int f23716d;

    public zzc(Bundle bundle, Feature[] featureArr, int i10, @Nullable ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f23714b = bundle;
        this.f23715c = featureArr;
        this.f23716d = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.d(parcel, 1, this.f23714b, false);
        w6.a.r(parcel, 2, this.f23715c, i10, false);
        w6.a.j(parcel, 3, this.f23716d);
        w6.a.n(parcel, 4, null, i10, false);
        w6.a.b(parcel, a10);
    }

    public zzc() {
    }
}
