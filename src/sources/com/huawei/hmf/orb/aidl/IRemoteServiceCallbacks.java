package com.huawei.hmf.orb.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IRemoteServiceCallbacks extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Default implements IRemoteServiceCallbacks {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hmf.orb.aidl.IRemoteServiceCallbacks
        public void onResult(int i10, IBinder iBinder) throws RemoteException {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class Stub extends Binder implements IRemoteServiceCallbacks {
        private static final String DESCRIPTOR = "com.huawei.hmf.orb.aidl.IRemoteServiceCallbacks";
        public static final int TRANSACTION_onResult = 1;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class Proxy implements IRemoteServiceCallbacks {
            public static IRemoteServiceCallbacks sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.huawei.hmf.orb.aidl.IRemoteServiceCallbacks
            public void onResult(int i10, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onResult(i10, iBinder);
                    } else {
                        obtain2.readException();
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

        public static IRemoteServiceCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteServiceCallbacks)) {
                return (IRemoteServiceCallbacks) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IRemoteServiceCallbacks getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteServiceCallbacks iRemoteServiceCallbacks) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteServiceCallbacks == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteServiceCallbacks;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onResult(parcel.readInt(), parcel.readStrongBinder());
            parcel2.writeNoException();
            return true;
        }
    }

    void onResult(int i10, IBinder iBinder) throws RemoteException;
}
