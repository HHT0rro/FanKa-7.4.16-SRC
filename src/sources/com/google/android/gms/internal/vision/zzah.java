package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new b();

    /* renamed from: b, reason: collision with root package name */
    public final zzao[] f25722b;

    /* renamed from: c, reason: collision with root package name */
    public final zzab f25723c;

    /* renamed from: d, reason: collision with root package name */
    public final zzab f25724d;

    /* renamed from: e, reason: collision with root package name */
    public final zzab f25725e;

    /* renamed from: f, reason: collision with root package name */
    public final String f25726f;

    /* renamed from: g, reason: collision with root package name */
    public final float f25727g;

    /* renamed from: h, reason: collision with root package name */
    public final String f25728h;

    /* renamed from: i, reason: collision with root package name */
    public final int f25729i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f25730j;

    /* renamed from: k, reason: collision with root package name */
    public final int f25731k;

    /* renamed from: l, reason: collision with root package name */
    public final int f25732l;

    public zzah(zzao[] zzaoVarArr, zzab zzabVar, zzab zzabVar2, zzab zzabVar3, String str, float f10, String str2, int i10, boolean z10, int i11, int i12) {
        this.f25722b = zzaoVarArr;
        this.f25723c = zzabVar;
        this.f25724d = zzabVar2;
        this.f25725e = zzabVar3;
        this.f25726f = str;
        this.f25727g = f10;
        this.f25728h = str2;
        this.f25729i = i10;
        this.f25730j = z10;
        this.f25731k = i11;
        this.f25732l = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.r(parcel, 2, this.f25722b, i10, false);
        w6.a.n(parcel, 3, this.f25723c, i10, false);
        w6.a.n(parcel, 4, this.f25724d, i10, false);
        w6.a.n(parcel, 5, this.f25725e, i10, false);
        w6.a.o(parcel, 6, this.f25726f, false);
        w6.a.h(parcel, 7, this.f25727g);
        w6.a.o(parcel, 8, this.f25728h, false);
        w6.a.j(parcel, 9, this.f25729i);
        w6.a.c(parcel, 10, this.f25730j);
        w6.a.j(parcel, 11, this.f25731k);
        w6.a.j(parcel, 12, this.f25732l);
        w6.a.b(parcel, a10);
    }
}
