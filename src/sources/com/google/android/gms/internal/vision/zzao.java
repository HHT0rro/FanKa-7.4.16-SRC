package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new f();

    /* renamed from: b, reason: collision with root package name */
    public final zzal[] f25735b;

    /* renamed from: c, reason: collision with root package name */
    public final zzab f25736c;

    /* renamed from: d, reason: collision with root package name */
    public final zzab f25737d;

    /* renamed from: e, reason: collision with root package name */
    public final String f25738e;

    /* renamed from: f, reason: collision with root package name */
    public final float f25739f;

    /* renamed from: g, reason: collision with root package name */
    public final String f25740g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f25741h;

    public zzao(zzal[] zzalVarArr, zzab zzabVar, zzab zzabVar2, String str, float f10, String str2, boolean z10) {
        this.f25735b = zzalVarArr;
        this.f25736c = zzabVar;
        this.f25737d = zzabVar2;
        this.f25738e = str;
        this.f25739f = f10;
        this.f25740g = str2;
        this.f25741h = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.r(parcel, 2, this.f25735b, i10, false);
        w6.a.n(parcel, 3, this.f25736c, i10, false);
        w6.a.n(parcel, 4, this.f25737d, i10, false);
        w6.a.o(parcel, 5, this.f25738e, false);
        w6.a.h(parcel, 6, this.f25739f);
        w6.a.o(parcel, 7, this.f25740g, false);
        w6.a.c(parcel, 8, this.f25741h);
        w6.a.b(parcel, a10);
    }
}
