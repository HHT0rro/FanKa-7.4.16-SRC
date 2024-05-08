package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new v();

    /* renamed from: b, reason: collision with root package name */
    public final RootTelemetryConfiguration f23607b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23608c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f23609d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final int[] f23610e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23611f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z10, boolean z11, @Nullable int[] iArr, int i10) {
        this.f23607b = rootTelemetryConfiguration;
        this.f23608c = z10;
        this.f23609d = z11;
        this.f23610e = iArr;
        this.f23611f = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.n(parcel, 1, this.f23607b, i10, false);
        w6.a.c(parcel, 2, this.f23608c);
        w6.a.c(parcel, 3, this.f23609d);
        w6.a.k(parcel, 4, this.f23610e, false);
        w6.a.j(parcel, 5, this.f23611f);
        w6.a.b(parcel, a10);
    }
}
