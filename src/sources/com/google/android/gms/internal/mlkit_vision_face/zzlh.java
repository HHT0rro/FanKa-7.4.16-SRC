package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzlh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlh> CREATOR = new m9();

    /* renamed from: b, reason: collision with root package name */
    public final int f25401b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25402c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25403d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25404e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f25405f;

    /* renamed from: g, reason: collision with root package name */
    public final float f25406g;

    public zzlh(int i10, int i11, int i12, int i13, boolean z10, float f10) {
        this.f25401b = i10;
        this.f25402c = i11;
        this.f25403d = i12;
        this.f25404e = i13;
        this.f25405f = z10;
        this.f25406g = f10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25401b);
        w6.a.j(parcel, 2, this.f25402c);
        w6.a.j(parcel, 3, this.f25403d);
        w6.a.j(parcel, 4, this.f25404e);
        w6.a.c(parcel, 5, this.f25405f);
        w6.a.h(parcel, 6, this.f25406g);
        w6.a.b(parcel, a10);
    }
}
