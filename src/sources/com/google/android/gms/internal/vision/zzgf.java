package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzgf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgf> CREATOR = new d3();

    /* renamed from: b, reason: collision with root package name */
    public final int f25756b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f25757c;

    /* renamed from: d, reason: collision with root package name */
    public final float f25758d;

    /* renamed from: e, reason: collision with root package name */
    public final float f25759e;

    /* renamed from: f, reason: collision with root package name */
    public final float f25760f;

    /* renamed from: g, reason: collision with root package name */
    public final float f25761g;

    /* renamed from: h, reason: collision with root package name */
    public final float f25762h;

    /* renamed from: i, reason: collision with root package name */
    public final float f25763i;

    /* renamed from: j, reason: collision with root package name */
    public final float f25764j;

    /* renamed from: k, reason: collision with root package name */
    public final List<zzgn> f25765k;

    /* renamed from: l, reason: collision with root package name */
    public final List<zzgb> f25766l;

    public zzgf(int i10, Rect rect, float f10, float f11, float f12, float f13, float f14, float f15, float f16, List<zzgn> list, List<zzgb> list2) {
        this.f25756b = i10;
        this.f25757c = rect;
        this.f25758d = f10;
        this.f25759e = f11;
        this.f25760f = f12;
        this.f25761g = f13;
        this.f25762h = f14;
        this.f25763i = f15;
        this.f25764j = f16;
        this.f25765k = list;
        this.f25766l = list2;
    }

    public final Rect f() {
        return this.f25757c;
    }

    public final float g() {
        return this.f25758d;
    }

    public final float i() {
        return this.f25759e;
    }

    public final float j() {
        return this.f25760f;
    }

    public final float k() {
        return this.f25761g;
    }

    public final float l() {
        return this.f25762h;
    }

    public final float m() {
        return this.f25763i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25756b);
        w6.a.n(parcel, 2, this.f25757c, i10, false);
        w6.a.h(parcel, 3, this.f25758d);
        w6.a.h(parcel, 4, this.f25759e);
        w6.a.h(parcel, 5, this.f25760f);
        w6.a.h(parcel, 6, this.f25761g);
        w6.a.h(parcel, 7, this.f25762h);
        w6.a.h(parcel, 8, this.f25763i);
        w6.a.h(parcel, 9, this.f25764j);
        w6.a.s(parcel, 10, this.f25765k, false);
        w6.a.s(parcel, 11, this.f25766l, false);
        w6.a.b(parcel, a10);
    }

    public final int zza() {
        return this.f25756b;
    }
}
