package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzj extends zza {
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    public final zzf[] zzd(IObjectWrapper iObjectWrapper, zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        p0.b(zza, iObjectWrapper);
        p0.a(zza, zzpVar);
        Parcel zzb = zzb(1, zza);
        zzf[] zzfVarArr = (zzf[]) zzb.createTypedArray(zzf.CREATOR);
        zzb.recycle();
        return zzfVarArr;
    }

    public final zzf[] zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i10, int i11, int i12, int i13, int i14, int i15, zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        p0.b(zza, iObjectWrapper);
        p0.b(zza, iObjectWrapper2);
        p0.b(zza, iObjectWrapper3);
        zza.writeInt(i10);
        zza.writeInt(i11);
        zza.writeInt(i12);
        zza.writeInt(i13);
        zza.writeInt(i14);
        zza.writeInt(i15);
        p0.a(zza, zzpVar);
        Parcel zzb = zzb(4, zza);
        zzf[] zzfVarArr = (zzf[]) zzb.createTypedArray(zzf.CREATOR);
        zzb.recycle();
        return zzfVarArr;
    }

    public final void zzf() throws RemoteException {
        zzc(3, zza());
    }
}
