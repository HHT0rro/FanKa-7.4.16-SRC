package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzgj extends zzb implements zzgh {
    public zzgj(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetector");
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final void zza() throws RemoteException {
        zzb(1, a_());
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final void zzb() throws RemoteException {
        zzb(2, a_());
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final List<zzgf> zza(IObjectWrapper iObjectWrapper, zzfz zzfzVar) throws RemoteException {
        Parcel a_ = a_();
        l0.b(a_, iObjectWrapper);
        l0.c(a_, zzfzVar);
        Parcel zza = zza(3, a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzgf.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }
}
