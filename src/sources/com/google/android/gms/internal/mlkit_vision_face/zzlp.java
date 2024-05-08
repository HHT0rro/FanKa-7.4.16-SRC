package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzlp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlp> CREATOR = new o9();

    /* renamed from: b, reason: collision with root package name */
    public final int f25418b;

    /* renamed from: c, reason: collision with root package name */
    public final PointF f25419c;

    public zzlp(int i10, PointF pointF) {
        this.f25418b = i10;
        this.f25419c = pointF;
    }

    public final PointF f() {
        return this.f25419c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25418b);
        w6.a.n(parcel, 2, this.f25419c, i10, false);
        w6.a.b(parcel, a10);
    }

    public final int zza() {
        return this.f25418b;
    }
}
