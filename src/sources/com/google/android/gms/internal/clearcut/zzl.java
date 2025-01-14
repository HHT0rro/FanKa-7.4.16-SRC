package com.google.android.gms.internal.clearcut;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface zzl extends IInterface {
    void zza(Status status) throws RemoteException;

    void zza(Status status, long j10) throws RemoteException;

    void zza(Status status, zzc zzcVar) throws RemoteException;

    void zza(Status status, zze[] zzeVarArr) throws RemoteException;

    void zza(DataHolder dataHolder) throws RemoteException;

    void zzb(Status status) throws RemoteException;

    void zzb(Status status, long j10) throws RemoteException;

    void zzb(Status status, zzc zzcVar) throws RemoteException;

    void zzc(Status status) throws RemoteException;
}
