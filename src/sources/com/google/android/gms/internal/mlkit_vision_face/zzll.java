package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzll extends zza {
    public zzll(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetector");
    }

    public final void zzd() throws RemoteException {
        zzc(1, zza());
    }

    public final void zze() throws RemoteException {
        zzc(2, zza());
    }

    public final List<zzlj> zzf(IObjectWrapper iObjectWrapper, zzld zzldVar) throws RemoteException {
        Parcel zza = zza();
        p0.b(zza, iObjectWrapper);
        p0.a(zza, zzldVar);
        Parcel zzb = zzb(3, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzlj.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }
}
