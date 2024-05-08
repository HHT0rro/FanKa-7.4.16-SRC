package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new c();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f25733b;

    public zzaj() {
        this.f25733b = new Rect();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.n(parcel, 2, this.f25733b, i10, false);
        w6.a.b(parcel, a10);
    }

    public zzaj(Rect rect) {
        this.f25733b = rect;
    }
}
