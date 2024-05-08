package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new v4();

    /* renamed from: b, reason: collision with root package name */
    public int f25776b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25777c;

    public zzk() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 2, this.f25776b);
        w6.a.c(parcel, 3, this.f25777c);
        w6.a.b(parcel, a10);
    }

    public zzk(int i10, boolean z10) {
        this.f25776b = i10;
        this.f25777c = z10;
    }
}
