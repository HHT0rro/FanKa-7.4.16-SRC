package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new l6();

    /* renamed from: b, reason: collision with root package name */
    public int f25388b;

    /* renamed from: c, reason: collision with root package name */
    public int f25389c;

    /* renamed from: d, reason: collision with root package name */
    public int f25390d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f25391e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f25392f;

    /* renamed from: g, reason: collision with root package name */
    public float f25393g;

    public zzh() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 2, this.f25388b);
        w6.a.j(parcel, 3, this.f25389c);
        w6.a.j(parcel, 4, this.f25390d);
        w6.a.c(parcel, 5, this.f25391e);
        w6.a.c(parcel, 6, this.f25392f);
        w6.a.h(parcel, 7, this.f25393g);
        w6.a.b(parcel, a10);
    }

    public zzh(int i10, int i11, int i12, boolean z10, boolean z11, float f10) {
        this.f25388b = i10;
        this.f25389c = i11;
        this.f25390d = i12;
        this.f25391e = z10;
        this.f25392f = z11;
        this.f25393g = f10;
    }
}
