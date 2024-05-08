package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface zae extends IInterface {
    void zaa(int i10) throws RemoteException;

    void zaa(IAccountAccessor iAccountAccessor, int i10, boolean z10) throws RemoteException;

    void zaa(zak zakVar, zac zacVar) throws RemoteException;
}
