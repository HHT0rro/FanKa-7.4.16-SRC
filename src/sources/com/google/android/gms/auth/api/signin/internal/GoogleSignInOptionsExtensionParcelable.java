package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import s6.c;
import w6.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();

    /* renamed from: b, reason: collision with root package name */
    public final int f23305b;

    /* renamed from: c, reason: collision with root package name */
    public int f23306c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f23307d;

    public GoogleSignInOptionsExtensionParcelable(int i10, int i11, Bundle bundle) {
        this.f23305b = i10;
        this.f23306c = i11;
        this.f23307d = bundle;
    }

    @RecentlyNonNull
    public int f() {
        return this.f23306c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 1, this.f23305b);
        a.j(parcel, 2, f());
        a.d(parcel, 3, this.f23307d, false);
        a.b(parcel, a10);
    }
}
