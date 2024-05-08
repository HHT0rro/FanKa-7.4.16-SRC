package com.google.android.gms.internal.vision;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzgn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgn> CREATOR = new e3();

    /* renamed from: b, reason: collision with root package name */
    public final int f25767b;

    /* renamed from: c, reason: collision with root package name */
    public final PointF f25768c;

    public zzgn(int i10, PointF pointF) {
        this.f25767b = i10;
        this.f25768c = pointF;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25767b);
        w6.a.n(parcel, 2, this.f25768c, i10, false);
        w6.a.b(parcel, a10);
    }
}
