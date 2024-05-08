package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzac extends zzb implements zzad {
    public zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final zzah[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar, zzaj zzajVar) throws RemoteException {
        Parcel a_ = a_();
        l0.b(a_, iObjectWrapper);
        l0.c(a_, zzsVar);
        l0.c(a_, zzajVar);
        Parcel zza = zza(3, a_);
        zzah[] zzahVarArr = (zzah[]) zza.createTypedArray(zzah.CREATOR);
        zza.recycle();
        return zzahVarArr;
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final void zzb() throws RemoteException {
        zzb(2, a_());
    }
}
