package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface IGmsCallbacks extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class zza extends com.google.android.gms.internal.common.zza implements IGmsCallbacks {
        public zza() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // com.google.android.gms.internal.common.zza
        public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) i7.b.a(parcel, Bundle.CREATOR));
            } else if (i10 == 2) {
                zza(parcel.readInt(), (Bundle) i7.b.a(parcel, Bundle.CREATOR));
            } else {
                if (i10 != 3) {
                    return false;
                }
                zza(parcel.readInt(), parcel.readStrongBinder(), (zzc) i7.b.a(parcel, zzc.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onPostInitComplete(@RecentlyNonNull int i10, @RecentlyNonNull IBinder iBinder, @RecentlyNonNull Bundle bundle) throws RemoteException;

    void zza(@RecentlyNonNull int i10, @RecentlyNonNull Bundle bundle) throws RemoteException;

    void zza(int i10, IBinder iBinder, zzc zzcVar) throws RemoteException;
}
