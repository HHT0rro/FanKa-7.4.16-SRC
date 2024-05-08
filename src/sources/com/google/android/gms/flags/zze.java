package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.flags.zza;
import j7.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zze extends zza implements zzc {
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    @Override // com.google.android.gms.flags.zzc
    public final boolean getBooleanFlagValue(String str, boolean z10, int i10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        a.a(zza, z10);
        zza.writeInt(i10);
        Parcel zza2 = zza(2, zza);
        boolean c4 = a.c(zza2);
        zza2.recycle();
        return c4;
    }

    @Override // com.google.android.gms.flags.zzc
    public final int getIntFlagValue(String str, int i10, int i11) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i10);
        zza.writeInt(i11);
        Parcel zza2 = zza(3, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.flags.zzc
    public final long getLongFlagValue(String str, long j10, int i10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j10);
        zza.writeInt(i10);
        Parcel zza2 = zza(4, zza);
        long readLong = zza2.readLong();
        zza2.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.flags.zzc
    public final String getStringFlagValue(String str, String str2, int i10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeInt(i10);
        Parcel zza2 = zza(5, zza);
        String readString = zza2.readString();
        zza2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.flags.zzc
    public final void init(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        a.b(zza, iObjectWrapper);
        zzb(1, zza);
    }
}
