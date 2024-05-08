package com.google.android.gms.vision.face.internal.client;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import s7.a;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final PointF[] f25911b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25912c;

    public zza(PointF[] pointFArr, int i10) {
        this.f25911b = pointFArr;
        this.f25912c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.r(parcel, 2, this.f25911b, i10, false);
        w6.a.j(parcel, 3, this.f25912c);
        w6.a.b(parcel, a10);
    }
}
