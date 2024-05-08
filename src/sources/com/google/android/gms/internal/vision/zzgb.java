package com.google.android.gms.internal.vision;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzgb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgb> CREATOR = new b3();

    /* renamed from: b, reason: collision with root package name */
    public final int f25748b;

    /* renamed from: c, reason: collision with root package name */
    public final List<PointF> f25749c;

    public zzgb(int i10, List<PointF> list) {
        this.f25748b = i10;
        this.f25749c = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25748b);
        w6.a.s(parcel, 2, this.f25749c, false);
        w6.a.b(parcel, a10);
    }
}
