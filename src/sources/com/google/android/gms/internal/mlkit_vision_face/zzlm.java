package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzlm extends zza implements zzlo {
    public zzlm(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzlo
    public final zzll zzd(IObjectWrapper iObjectWrapper, zzlh zzlhVar) throws RemoteException {
        zzll zzllVar;
        Parcel zza = zza();
        p0.b(zza, iObjectWrapper);
        p0.a(zza, zzlhVar);
        Parcel zzb = zzb(1, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzllVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetector");
            if (queryLocalInterface instanceof zzll) {
                zzllVar = (zzll) queryLocalInterface;
            } else {
                zzllVar = new zzll(readStrongBinder);
            }
        }
        zzb.recycle();
        return zzllVar;
    }
}
