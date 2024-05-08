package com.huawei.appmarket.service.externalservice.distribution.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IDownloadCallback extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class Stub extends Binder implements IDownloadCallback {
        private static final String DESCRIPTOR = "com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback";
        public static final int TRANSACTION_getDownloadRegisterKey = 1;
        public static final int TRANSACTION_refreshAppStatus = 2;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a implements IDownloadCallback {

            /* renamed from: b, reason: collision with root package name */
            public static IDownloadCallback f27673b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f27674a;

            public a(IBinder iBinder) {
                this.f27674a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27674a;
            }

            @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
            public String getDownloadRegisterKey() throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.f27674a.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getDownloadRegisterKey();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
            public void refreshAppStatus(String str, int i10, int i11, int i12) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    if (this.f27674a.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().refreshAppStatus(str, i10, i11, i12);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadCallback)) ? new a(iBinder) : (IDownloadCallback) queryLocalInterface;
        }

        public static IDownloadCallback getDefaultImpl() {
            return a.f27673b;
        }

        public static boolean setDefaultImpl(IDownloadCallback iDownloadCallback) {
            if (a.f27673b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDownloadCallback == null) {
                return false;
            }
            a.f27673b = iDownloadCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String downloadRegisterKey = getDownloadRegisterKey();
                parcel2.writeNoException();
                parcel2.writeString(downloadRegisterKey);
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            refreshAppStatus(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    String getDownloadRegisterKey() throws RemoteException;

    void refreshAppStatus(String str, int i10, int i11, int i12) throws RemoteException;
}
