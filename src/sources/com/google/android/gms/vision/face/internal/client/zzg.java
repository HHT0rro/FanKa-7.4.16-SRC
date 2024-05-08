package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.l0;
import com.google.android.gms.internal.vision.zzs;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzg extends com.google.android.gms.internal.vision.zza implements zzh {
    public zzg() {
        super("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.internal.vision.zza
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            FaceParcel[] zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzs) l0.a(parcel, zzs.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedArray(zza, 1);
        } else if (i10 == 2) {
            boolean zza2 = zza(parcel.readInt());
            parcel2.writeNoException();
            l0.d(parcel2, zza2);
        } else if (i10 == 3) {
            zza();
            parcel2.writeNoException();
        } else {
            if (i10 != 4) {
                return false;
            }
            FaceParcel[] zza3 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (zzs) l0.a(parcel, zzs.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedArray(zza3, 1);
        }
        return true;
    }
}
