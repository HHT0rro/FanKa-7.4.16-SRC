package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzs extends zzb implements zzr {
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzr
    public final boolean zza(zzj zzjVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a_ = a_();
        i7.b.c(a_, zzjVar);
        i7.b.b(a_, iObjectWrapper);
        Parcel zza = zza(5, a_);
        boolean e2 = i7.b.e(zza);
        zza.recycle();
        return e2;
    }
}
