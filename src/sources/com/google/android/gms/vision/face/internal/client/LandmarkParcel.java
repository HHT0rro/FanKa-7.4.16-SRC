package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import s7.d;
import w6.a;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
@UsedByNative("wrapper.cc")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LandmarkParcel extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<LandmarkParcel> CREATOR = new d();

    /* renamed from: b, reason: collision with root package name */
    public final int f25907b;

    /* renamed from: c, reason: collision with root package name */
    public final float f25908c;

    /* renamed from: d, reason: collision with root package name */
    public final float f25909d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25910e;

    @UsedByNative("wrapper.cc")
    public LandmarkParcel(int i10, float f10, float f11, int i11) {
        this.f25907b = i10;
        this.f25908c = f10;
        this.f25909d = f11;
        this.f25910e = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 1, this.f25907b);
        a.h(parcel, 2, this.f25908c);
        a.h(parcel, 3, this.f25909d);
        a.j(parcel, 4, this.f25910e);
        a.b(parcel, a10);
    }
}
