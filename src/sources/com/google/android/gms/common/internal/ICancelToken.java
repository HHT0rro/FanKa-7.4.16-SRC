package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.common.zzb;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface ICancelToken extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements ICancelToken {

        /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static class zza extends zzb implements ICancelToken {
            public zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
            }

            @Override // com.google.android.gms.common.internal.ICancelToken
            public final void cancel() throws RemoteException {
                zzc(2, a_());
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        @RecentlyNonNull
        public static ICancelToken asInterface(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            if (queryLocalInterface instanceof ICancelToken) {
                return (ICancelToken) queryLocalInterface;
            }
            return new zza(iBinder);
        }
    }

    void cancel() throws RemoteException;
}
