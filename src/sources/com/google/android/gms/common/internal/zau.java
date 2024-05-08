package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zau> CREATOR = new s();

    /* renamed from: b, reason: collision with root package name */
    public final int f23710b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23711c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23712d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    @Deprecated
    public final Scope[] f23713e;

    public zau(int i10, int i11, int i12, @Nullable Scope[] scopeArr) {
        this.f23710b = i10;
        this.f23711c = i11;
        this.f23712d = i12;
        this.f23713e = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23710b);
        w6.a.j(parcel, 2, this.f23711c);
        w6.a.j(parcel, 3, this.f23712d);
        w6.a.r(parcel, 4, this.f23713e, i10, false);
        w6.a.b(parcel, a10);
    }

    public zau(int i10, int i11, @Nullable Scope[] scopeArr) {
        this(1, i10, i11, null);
    }
}
