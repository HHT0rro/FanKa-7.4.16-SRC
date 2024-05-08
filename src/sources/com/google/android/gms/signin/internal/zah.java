package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import h7.b;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zah extends com.google.android.gms.internal.base.zab implements zae {
    public zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zae
    public final void zaa(int i10) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i10);
        zab(7, zaa);
    }

    @Override // com.google.android.gms.signin.internal.zae
    public final void zaa(IAccountAccessor iAccountAccessor, int i10, boolean z10) throws RemoteException {
        Parcel zaa = zaa();
        b.b(zaa, iAccountAccessor);
        zaa.writeInt(i10);
        b.d(zaa, z10);
        zab(9, zaa);
    }

    @Override // com.google.android.gms.signin.internal.zae
    public final void zaa(zak zakVar, zac zacVar) throws RemoteException {
        Parcel zaa = zaa();
        b.c(zaa, zakVar);
        b.b(zaa, zacVar);
        zab(12, zaa);
    }
}
