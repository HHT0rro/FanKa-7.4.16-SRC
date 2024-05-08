package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzlj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlj> CREATOR = new n9();

    /* renamed from: b, reason: collision with root package name */
    public final int f25407b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f25408c;

    /* renamed from: d, reason: collision with root package name */
    public final float f25409d;

    /* renamed from: e, reason: collision with root package name */
    public final float f25410e;

    /* renamed from: f, reason: collision with root package name */
    public final float f25411f;

    /* renamed from: g, reason: collision with root package name */
    public final float f25412g;

    /* renamed from: h, reason: collision with root package name */
    public final float f25413h;

    /* renamed from: i, reason: collision with root package name */
    public final float f25414i;

    /* renamed from: j, reason: collision with root package name */
    public final float f25415j;

    /* renamed from: k, reason: collision with root package name */
    public final List<zzlp> f25416k;

    /* renamed from: l, reason: collision with root package name */
    public final List<zzlf> f25417l;

    public zzlj(int i10, Rect rect, float f10, float f11, float f12, float f13, float f14, float f15, float f16, List<zzlp> list, List<zzlf> list2) {
        this.f25407b = i10;
        this.f25408c = rect;
        this.f25409d = f10;
        this.f25410e = f11;
        this.f25411f = f12;
        this.f25412g = f13;
        this.f25413h = f14;
        this.f25414i = f15;
        this.f25415j = f16;
        this.f25416k = list;
        this.f25417l = list2;
    }

    public final Rect f() {
        return this.f25408c;
    }

    public final float g() {
        return this.f25409d;
    }

    public final float i() {
        return this.f25410e;
    }

    public final float j() {
        return this.f25411f;
    }

    public final float k() {
        return this.f25412g;
    }

    public final float l() {
        return this.f25413h;
    }

    public final float m() {
        return this.f25414i;
    }

    public final List<zzlp> r() {
        return this.f25416k;
    }

    public final List<zzlf> u() {
        return this.f25417l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25407b);
        w6.a.n(parcel, 2, this.f25408c, i10, false);
        w6.a.h(parcel, 3, this.f25409d);
        w6.a.h(parcel, 4, this.f25410e);
        w6.a.h(parcel, 5, this.f25411f);
        w6.a.h(parcel, 6, this.f25412g);
        w6.a.h(parcel, 7, this.f25413h);
        w6.a.h(parcel, 8, this.f25414i);
        w6.a.h(parcel, 9, this.f25415j);
        w6.a.s(parcel, 10, this.f25416k, false);
        w6.a.s(parcel, 11, this.f25417l, false);
        w6.a.b(parcel, a10);
    }

    public final int zza() {
        return this.f25407b;
    }
}
