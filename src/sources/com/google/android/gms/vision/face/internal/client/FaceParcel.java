package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import s7.b;
import w6.a;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
@UsedByNative("wrapper.cc")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FaceParcel extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<FaceParcel> CREATOR = new b();

    /* renamed from: b, reason: collision with root package name */
    public final int f25892b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25893c;

    /* renamed from: d, reason: collision with root package name */
    public final float f25894d;

    /* renamed from: e, reason: collision with root package name */
    public final float f25895e;

    /* renamed from: f, reason: collision with root package name */
    public final float f25896f;

    /* renamed from: g, reason: collision with root package name */
    public final float f25897g;

    /* renamed from: h, reason: collision with root package name */
    public final float f25898h;

    /* renamed from: i, reason: collision with root package name */
    public final float f25899i;

    /* renamed from: j, reason: collision with root package name */
    public final float f25900j;

    /* renamed from: k, reason: collision with root package name */
    @RecentlyNonNull
    public final LandmarkParcel[] f25901k;

    /* renamed from: l, reason: collision with root package name */
    public final float f25902l;

    /* renamed from: m, reason: collision with root package name */
    public final float f25903m;

    /* renamed from: n, reason: collision with root package name */
    public final float f25904n;

    /* renamed from: o, reason: collision with root package name */
    public final zza[] f25905o;

    /* renamed from: p, reason: collision with root package name */
    public final float f25906p;

    public FaceParcel(int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, LandmarkParcel[] landmarkParcelArr, float f17, float f18, float f19, zza[] zzaVarArr, float f20) {
        this.f25892b = i10;
        this.f25893c = i11;
        this.f25894d = f10;
        this.f25895e = f11;
        this.f25896f = f12;
        this.f25897g = f13;
        this.f25898h = f14;
        this.f25899i = f15;
        this.f25900j = f16;
        this.f25901k = landmarkParcelArr;
        this.f25902l = f17;
        this.f25903m = f18;
        this.f25904n = f19;
        this.f25905o = zzaVarArr;
        this.f25906p = f20;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 1, this.f25892b);
        a.j(parcel, 2, this.f25893c);
        a.h(parcel, 3, this.f25894d);
        a.h(parcel, 4, this.f25895e);
        a.h(parcel, 5, this.f25896f);
        a.h(parcel, 6, this.f25897g);
        a.h(parcel, 7, this.f25898h);
        a.h(parcel, 8, this.f25899i);
        a.r(parcel, 9, this.f25901k, i10, false);
        a.h(parcel, 10, this.f25902l);
        a.h(parcel, 11, this.f25903m);
        a.h(parcel, 12, this.f25904n);
        a.r(parcel, 13, this.f25905o, i10, false);
        a.h(parcel, 14, this.f25900j);
        a.h(parcel, 15, this.f25906p);
        a.b(parcel, a10);
    }

    @UsedByNative("wrapper.cc")
    public FaceParcel(int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, @RecentlyNonNull LandmarkParcel[] landmarkParcelArr, float f16, float f17, float f18) {
        this(i10, i11, f10, f11, f12, f13, f14, f15, 0.0f, landmarkParcelArr, f16, f17, f18, new zza[0], -1.0f);
    }
}
