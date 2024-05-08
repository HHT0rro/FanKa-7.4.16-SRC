package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zas;
import o7.e;
import w6.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new e();

    /* renamed from: b, reason: collision with root package name */
    public final int f25817b;

    /* renamed from: c, reason: collision with root package name */
    public final ConnectionResult f25818c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final zas f25819d;

    public zam(int i10, ConnectionResult connectionResult, @Nullable zas zasVar) {
        this.f25817b = i10;
        this.f25818c = connectionResult;
        this.f25819d = zasVar;
    }

    public final ConnectionResult f() {
        return this.f25818c;
    }

    @Nullable
    public final zas g() {
        return this.f25819d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 1, this.f25817b);
        a.n(parcel, 2, this.f25818c, i10, false);
        a.n(parcel, 3, this.f25819d, i10, false);
        a.b(parcel, a10);
    }

    public zam(int i10) {
        this(new ConnectionResult(8, null), null);
    }

    public zam(ConnectionResult connectionResult, @Nullable zas zasVar) {
        this(1, connectionResult, null);
    }
}
