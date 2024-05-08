package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new n4();

    /* renamed from: b, reason: collision with root package name */
    public final int f25373b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25374c;

    /* renamed from: d, reason: collision with root package name */
    public final float f25375d;

    /* renamed from: e, reason: collision with root package name */
    public final float f25376e;

    /* renamed from: f, reason: collision with root package name */
    public final float f25377f;

    /* renamed from: g, reason: collision with root package name */
    public final float f25378g;

    /* renamed from: h, reason: collision with root package name */
    public final float f25379h;

    /* renamed from: i, reason: collision with root package name */
    public final float f25380i;

    /* renamed from: j, reason: collision with root package name */
    public final float f25381j;

    /* renamed from: k, reason: collision with root package name */
    public final zzn[] f25382k;

    /* renamed from: l, reason: collision with root package name */
    public final float f25383l;

    /* renamed from: m, reason: collision with root package name */
    public final float f25384m;

    /* renamed from: n, reason: collision with root package name */
    public final float f25385n;

    /* renamed from: o, reason: collision with root package name */
    public final zzd[] f25386o;

    /* renamed from: p, reason: collision with root package name */
    public final float f25387p;

    public zzf(int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, zzn[] zznVarArr, float f17, float f18, float f19, zzd[] zzdVarArr, float f20) {
        this.f25373b = i10;
        this.f25374c = i11;
        this.f25375d = f10;
        this.f25376e = f11;
        this.f25377f = f12;
        this.f25378g = f13;
        this.f25379h = f14;
        this.f25380i = f15;
        this.f25381j = f16;
        this.f25382k = zznVarArr;
        this.f25383l = f17;
        this.f25384m = f18;
        this.f25385n = f19;
        this.f25386o = zzdVarArr;
        this.f25387p = f20;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25373b);
        w6.a.j(parcel, 2, this.f25374c);
        w6.a.h(parcel, 3, this.f25375d);
        w6.a.h(parcel, 4, this.f25376e);
        w6.a.h(parcel, 5, this.f25377f);
        w6.a.h(parcel, 6, this.f25378g);
        w6.a.h(parcel, 7, this.f25379h);
        w6.a.h(parcel, 8, this.f25380i);
        w6.a.r(parcel, 9, this.f25382k, i10, false);
        w6.a.h(parcel, 10, this.f25383l);
        w6.a.h(parcel, 11, this.f25384m);
        w6.a.h(parcel, 12, this.f25385n);
        w6.a.r(parcel, 13, this.f25386o, i10, false);
        w6.a.h(parcel, 14, this.f25381j);
        w6.a.h(parcel, 15, this.f25387p);
        w6.a.b(parcel, a10);
    }
}
