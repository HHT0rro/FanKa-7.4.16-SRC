package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zze;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzo extends zza implements zzn {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    @Override // com.google.android.gms.internal.clearcut.zzn
    public final void zza(zzl zzlVar, zze zzeVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        s0.b(obtainAndWriteInterfaceToken, zzlVar);
        s0.c(obtainAndWriteInterfaceToken, zzeVar);
        transactOneway(1, obtainAndWriteInterfaceToken);
    }
}
