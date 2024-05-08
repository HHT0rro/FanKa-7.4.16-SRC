package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zaa;
import h7.b;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zaf extends zaa implements zac {
    public zaf() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zaa
    public final boolean zaa(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 3:
                zaa((ConnectionResult) b.a(parcel, ConnectionResult.CREATOR), (zab) b.a(parcel, zab.CREATOR));
                break;
            case 4:
                zaa((Status) b.a(parcel, Status.CREATOR));
                break;
            case 5:
            default:
                return false;
            case 6:
                zab((Status) b.a(parcel, Status.CREATOR));
                break;
            case 7:
                zaa((Status) b.a(parcel, Status.CREATOR), (GoogleSignInAccount) b.a(parcel, GoogleSignInAccount.CREATOR));
                break;
            case 8:
                zaa((zam) b.a(parcel, zam.CREATOR));
                break;
            case 9:
                zaa((zag) b.a(parcel, zag.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
