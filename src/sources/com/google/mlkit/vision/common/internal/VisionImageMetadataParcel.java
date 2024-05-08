package com.google.mlkit.vision.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import n8.i;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class VisionImageMetadataParcel extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new i();

    /* renamed from: b, reason: collision with root package name */
    public final int f27090b;

    /* renamed from: c, reason: collision with root package name */
    public final int f27091c;

    /* renamed from: d, reason: collision with root package name */
    public final long f27092d;

    /* renamed from: e, reason: collision with root package name */
    public final int f27093e;

    /* renamed from: f, reason: collision with root package name */
    public final int f27094f;

    public VisionImageMetadataParcel(int i10, int i11, int i12, long j10, int i13) {
        this.f27090b = i10;
        this.f27091c = i11;
        this.f27094f = i12;
        this.f27092d = j10;
        this.f27093e = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f27090b);
        w6.a.j(parcel, 2, this.f27091c);
        w6.a.j(parcel, 3, this.f27094f);
        w6.a.l(parcel, 4, this.f27092d);
        w6.a.j(parcel, 5, this.f27093e);
        w6.a.b(parcel, a10);
    }
}
