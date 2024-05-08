package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import s7.c;
import w6.a;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new c();

    /* renamed from: b, reason: collision with root package name */
    public int f25913b;

    /* renamed from: c, reason: collision with root package name */
    public int f25914c;

    /* renamed from: d, reason: collision with root package name */
    public int f25915d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f25916e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f25917f;

    /* renamed from: g, reason: collision with root package name */
    public float f25918g;

    public zzf() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 2, this.f25913b);
        a.j(parcel, 3, this.f25914c);
        a.j(parcel, 4, this.f25915d);
        a.c(parcel, 5, this.f25916e);
        a.c(parcel, 6, this.f25917f);
        a.h(parcel, 7, this.f25918g);
        a.b(parcel, a10);
    }

    public zzf(int i10, int i11, int i12, boolean z10, boolean z11, float f10) {
        this.f25913b = i10;
        this.f25914c = i11;
        this.f25915d = i12;
        this.f25916e = z10;
        this.f25917f = z11;
        this.f25918g = f10;
    }
}
