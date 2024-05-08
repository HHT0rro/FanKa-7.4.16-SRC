package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.common.zzb;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface IAccountAccessor extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IAccountAccessor {

        /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static class zza extends zzb implements IAccountAccessor {
            public zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.IAccountAccessor
            public final Account zza() throws RemoteException {
                Parcel zza = zza(2, a_());
                Account account = (Account) i7.b.a(zza, Account.CREATOR);
                zza.recycle();
                return account;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        @RecentlyNonNull
        public static IAccountAccessor asInterface(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zza
        @RecentlyNonNull
        public final boolean zza(@RecentlyNonNull int i10, @RecentlyNonNull Parcel parcel, @RecentlyNonNull Parcel parcel2, @RecentlyNonNull int i11) throws RemoteException {
            if (i10 != 2) {
                return false;
            }
            Account zza2 = zza();
            parcel2.writeNoException();
            i7.b.f(parcel2, zza2);
            return true;
        }
    }

    @RecentlyNonNull
    Account zza() throws RemoteException;
}
