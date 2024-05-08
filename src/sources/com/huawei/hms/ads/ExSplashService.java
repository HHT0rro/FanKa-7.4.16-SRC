package com.huawei.hms.ads;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ExSplashService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.ExSplashService";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Default implements ExSplashService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.ExSplashService
        public void enableUserInfo(boolean z10) throws RemoteException {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class Stub extends Binder implements ExSplashService {
        public static final int TRANSACTION_enableUserInfo = 1;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class Proxy implements ExSplashService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.ads.ExSplashService
            public void enableUserInfo(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ExSplashService.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ExSplashService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, ExSplashService.DESCRIPTOR);
        }

        public static ExSplashService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ExSplashService.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ExSplashService)) {
                return (ExSplashService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ExSplashService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ExSplashService.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            enableUserInfo(parcel.readInt() != 0);
            parcel2.writeNoException();
            return true;
        }
    }

    void enableUserInfo(boolean z10) throws RemoteException;
}
