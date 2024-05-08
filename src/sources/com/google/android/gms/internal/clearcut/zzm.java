package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzm extends zzb implements zzl {
    public zzm() {
        super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    @Override // com.google.android.gms.internal.clearcut.zzb
    public final boolean dispatchTransaction(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 1:
                zza((Status) s0.a(parcel, Status.CREATOR));
                return true;
            case 2:
                zzb((Status) s0.a(parcel, Status.CREATOR));
                return true;
            case 3:
                zza((Status) s0.a(parcel, Status.CREATOR), parcel.readLong());
                return true;
            case 4:
                zzc((Status) s0.a(parcel, Status.CREATOR));
                return true;
            case 5:
                zzb((Status) s0.a(parcel, Status.CREATOR), parcel.readLong());
                return true;
            case 6:
                zza((Status) s0.a(parcel, Status.CREATOR), (zze[]) parcel.createTypedArray(zze.CREATOR));
                return true;
            case 7:
                zza((DataHolder) s0.a(parcel, DataHolder.CREATOR));
                return true;
            case 8:
                zza((Status) s0.a(parcel, Status.CREATOR), (zzc) s0.a(parcel, zzc.CREATOR));
                return true;
            case 9:
                zzb((Status) s0.a(parcel, Status.CREATOR), (zzc) s0.a(parcel, zzc.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
