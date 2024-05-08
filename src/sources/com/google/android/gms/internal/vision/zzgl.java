package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzgl extends zza implements zzgi {
    public zzgl() {
        super("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    public static zzgi asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
        if (queryLocalInterface instanceof zzgi) {
            return (zzgi) queryLocalInterface;
        }
        return new zzgk(iBinder);
    }

    @Override // com.google.android.gms.internal.vision.zza
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        zzgh newFaceDetector = newFaceDetector(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzgd) l0.a(parcel, zzgd.CREATOR));
        parcel2.writeNoException();
        l0.b(parcel2, newFaceDetector);
        return true;
    }
}
