package com.google.android.gms.vision.face.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzs;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface zzh extends IInterface {
    void zza() throws RemoteException;

    boolean zza(int i10) throws RemoteException;

    FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i10, int i11, int i12, int i13, int i14, int i15, zzs zzsVar) throws RemoteException;

    FaceParcel[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) throws RemoteException;
}
