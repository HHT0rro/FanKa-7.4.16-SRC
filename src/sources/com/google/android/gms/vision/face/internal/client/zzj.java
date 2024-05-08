package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.l0;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzs;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzj extends zzb implements zzh {
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) throws RemoteException {
        Parcel a_ = a_();
        l0.b(a_, iObjectWrapper);
        l0.c(a_, zzsVar);
        Parcel zza = zza(1, a_);
        FaceParcel[] faceParcelArr = (FaceParcel[]) zza.createTypedArray(FaceParcel.CREATOR);
        zza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i10, int i11, int i12, int i13, int i14, int i15, zzs zzsVar) throws RemoteException {
        Parcel a_ = a_();
        l0.b(a_, iObjectWrapper);
        l0.b(a_, iObjectWrapper2);
        l0.b(a_, iObjectWrapper3);
        a_.writeInt(i10);
        a_.writeInt(i11);
        a_.writeInt(i12);
        a_.writeInt(i13);
        a_.writeInt(i14);
        a_.writeInt(i15);
        l0.c(a_, zzsVar);
        Parcel zza = zza(4, a_);
        FaceParcel[] faceParcelArr = (FaceParcel[]) zza.createTypedArray(FaceParcel.CREATOR);
        zza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final boolean zza(int i10) throws RemoteException {
        Parcel a_ = a_();
        a_.writeInt(i10);
        Parcel zza = zza(2, a_);
        boolean e2 = l0.e(zza);
        zza.recycle();
        return e2;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zza() throws RemoteException {
        zzb(3, a_());
    }
}
