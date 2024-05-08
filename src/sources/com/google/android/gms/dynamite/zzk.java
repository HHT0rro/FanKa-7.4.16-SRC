package com.google.android.gms.dynamite;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface zzk extends IInterface {
    int zza(IObjectWrapper iObjectWrapper, String str, boolean z10) throws RemoteException;

    IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i10) throws RemoteException;

    IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i10, IObjectWrapper iObjectWrapper2) throws RemoteException;

    int zzb() throws RemoteException;

    int zzb(IObjectWrapper iObjectWrapper, String str, boolean z10) throws RemoteException;

    IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i10) throws RemoteException;

    IObjectWrapper zzc(IObjectWrapper iObjectWrapper, String str, boolean z10) throws RemoteException;
}
