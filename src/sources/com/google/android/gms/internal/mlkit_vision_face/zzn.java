package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new p9();

    /* renamed from: b, reason: collision with root package name */
    public final int f25420b;

    /* renamed from: c, reason: collision with root package name */
    public final float f25421c;

    /* renamed from: d, reason: collision with root package name */
    public final float f25422d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25423e;

    public zzn(int i10, float f10, float f11, int i11) {
        this.f25420b = i10;
        this.f25421c = f10;
        this.f25422d = f11;
        this.f25423e = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25420b);
        w6.a.h(parcel, 2, this.f25421c);
        w6.a.h(parcel, 3, this.f25422d);
        w6.a.j(parcel, 4, this.f25423e);
        w6.a.b(parcel, a10);
    }
}
