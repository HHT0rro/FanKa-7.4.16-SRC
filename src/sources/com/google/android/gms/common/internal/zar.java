package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zar> CREATOR = new p();

    /* renamed from: b, reason: collision with root package name */
    public final int f23701b;

    /* renamed from: c, reason: collision with root package name */
    public final Account f23702c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23703d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final GoogleSignInAccount f23704e;

    public zar(int i10, Account account, int i11, @Nullable GoogleSignInAccount googleSignInAccount) {
        this.f23701b = i10;
        this.f23702c = account;
        this.f23703d = i11;
        this.f23704e = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23701b);
        w6.a.n(parcel, 2, this.f23702c, i10, false);
        w6.a.j(parcel, 3, this.f23703d);
        w6.a.n(parcel, 4, this.f23704e, i10, false);
        w6.a.b(parcel, a10);
    }

    public zar(Account account, int i10, @Nullable GoogleSignInAccount googleSignInAccount) {
        this(2, account, i10, googleSignInAccount);
    }
}
