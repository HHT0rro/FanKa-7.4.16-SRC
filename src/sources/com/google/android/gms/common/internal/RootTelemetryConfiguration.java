package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new g0();

    /* renamed from: b, reason: collision with root package name */
    public final int f23627b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23628c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f23629d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23630e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23631f;

    public RootTelemetryConfiguration(@RecentlyNonNull int i10, @RecentlyNonNull boolean z10, @RecentlyNonNull boolean z11, @RecentlyNonNull int i11, @RecentlyNonNull int i12) {
        this.f23627b = i10;
        this.f23628c = z10;
        this.f23629d = z11;
        this.f23630e = i11;
        this.f23631f = i12;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23627b);
        w6.a.c(parcel, 2, this.f23628c);
        w6.a.c(parcel, 3, this.f23629d);
        w6.a.j(parcel, 4, this.f23630e);
        w6.a.j(parcel, 5, this.f23631f);
        w6.a.b(parcel, a10);
    }
}
