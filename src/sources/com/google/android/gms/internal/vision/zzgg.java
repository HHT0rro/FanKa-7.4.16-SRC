package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzgg extends zza implements zzgh {
    public zzgg() {
        super("com.google.mlkit.vision.face.aidls.IFaceDetector");
    }

    @Override // com.google.android.gms.internal.vision.zza
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            zza();
            parcel2.writeNoException();
        } else if (i10 == 2) {
            zzb();
            parcel2.writeNoException();
        } else {
            if (i10 != 3) {
                return false;
            }
            List<zzgf> zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzfz) l0.a(parcel, zzfz.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedList(zza);
        }
        return true;
    }
}
