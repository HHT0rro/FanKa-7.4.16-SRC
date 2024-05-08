package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p implements Parcelable.Creator<zar> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zar createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                account = (Account) SafeParcelReader.o(parcel, z10, Account.CREATOR);
            } else if (v2 == 3) {
                i11 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 4) {
                SafeParcelReader.E(parcel, z10);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.o(parcel, z10, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zar(i10, account, i11, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zar[] newArray(int i10) {
        return new zar[i10];
    }
}
