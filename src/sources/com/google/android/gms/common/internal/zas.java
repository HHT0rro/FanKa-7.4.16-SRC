package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zas> CREATOR = new q();

    /* renamed from: b, reason: collision with root package name */
    public final int f23705b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public IBinder f23706c;

    /* renamed from: d, reason: collision with root package name */
    public ConnectionResult f23707d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23708e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f23709f;

    public zas(int i10, @Nullable IBinder iBinder, ConnectionResult connectionResult, boolean z10, boolean z11) {
        this.f23705b = i10;
        this.f23706c = iBinder;
        this.f23707d = connectionResult;
        this.f23708e = z10;
        this.f23709f = z11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zas)) {
            return false;
        }
        zas zasVar = (zas) obj;
        return this.f23707d.equals(zasVar.f23707d) && g.a(f(), zasVar.f());
    }

    @Nullable
    public final IAccountAccessor f() {
        IBinder iBinder = this.f23706c;
        if (iBinder == null) {
            return null;
        }
        return IAccountAccessor.Stub.asInterface(iBinder);
    }

    public final ConnectionResult g() {
        return this.f23707d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23705b);
        w6.a.i(parcel, 2, this.f23706c, false);
        w6.a.n(parcel, 3, this.f23707d, i10, false);
        w6.a.c(parcel, 4, this.f23708e);
        w6.a.c(parcel, 5, this.f23709f);
        w6.a.b(parcel, a10);
    }
}
