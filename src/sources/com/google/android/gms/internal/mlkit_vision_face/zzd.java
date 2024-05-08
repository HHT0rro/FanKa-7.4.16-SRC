package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new m2();

    /* renamed from: b, reason: collision with root package name */
    public final PointF[] f25371b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25372c;

    public zzd(PointF[] pointFArr, int i10) {
        this.f25371b = pointFArr;
        this.f25372c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.r(parcel, 2, this.f25371b, i10, false);
        w6.a.j(parcel, 3, this.f25372c);
        w6.a.b(parcel, a10);
    }
}
