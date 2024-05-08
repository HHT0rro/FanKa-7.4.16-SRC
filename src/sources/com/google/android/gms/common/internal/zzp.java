package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzp extends zzb implements IGmsCallbacks {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int i10, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel a_ = a_();
        a_.writeInt(i10);
        a_.writeStrongBinder(iBinder);
        i7.b.c(a_, bundle);
        zzb(1, a_);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zza(int i10, Bundle bundle) throws RemoteException {
        Parcel a_ = a_();
        a_.writeInt(i10);
        i7.b.c(a_, bundle);
        zzb(2, a_);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zza(int i10, IBinder iBinder, zzc zzcVar) throws RemoteException {
        Parcel a_ = a_();
        a_.writeInt(i10);
        a_.writeStrongBinder(iBinder);
        i7.b.c(a_, zzcVar);
        zzb(3, a_);
    }
}
