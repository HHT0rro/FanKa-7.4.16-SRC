package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzgk extends zzb implements zzgi {
    public zzgk(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    @Override // com.google.android.gms.internal.vision.zzgi
    public final zzgh newFaceDetector(IObjectWrapper iObjectWrapper, zzgd zzgdVar) throws RemoteException {
        zzgh zzgjVar;
        Parcel a_ = a_();
        l0.b(a_, iObjectWrapper);
        l0.c(a_, zzgdVar);
        Parcel zza = zza(1, a_);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzgjVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetector");
            if (queryLocalInterface instanceof zzgh) {
                zzgjVar = (zzgh) queryLocalInterface;
            } else {
                zzgjVar = new zzgj(readStrongBinder);
            }
        }
        zza.recycle();
        return zzgjVar;
    }
}
