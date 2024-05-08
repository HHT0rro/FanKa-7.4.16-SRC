package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface zac extends IInterface {
    void zaa(ConnectionResult connectionResult, zab zabVar) throws RemoteException;

    void zaa(Status status) throws RemoteException;

    void zaa(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void zaa(zag zagVar) throws RemoteException;

    void zaa(zam zamVar) throws RemoteException;

    void zab(Status status) throws RemoteException;
}
