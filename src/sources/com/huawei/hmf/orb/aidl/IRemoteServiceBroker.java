package com.huawei.hmf.orb.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hmf.orb.aidl.IRemoteServiceCallbacks;
import com.huawei.hmf.orb.aidl.impl.GetServiceRequest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IRemoteServiceBroker extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Default implements IRemoteServiceBroker {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hmf.orb.aidl.IRemoteServiceBroker
        public void getService(GetServiceRequest getServiceRequest, IRemoteServiceCallbacks iRemoteServiceCallbacks) throws RemoteException {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class Stub extends Binder implements IRemoteServiceBroker {
        private static final String DESCRIPTOR = "com.huawei.hmf.orb.aidl.IRemoteServiceBroker";
        public static final int TRANSACTION_getService = 1;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class Proxy implements IRemoteServiceBroker {
            public static IRemoteServiceBroker sDefaultImpl;
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

            @Override // com.huawei.hmf.orb.aidl.IRemoteServiceBroker
            public void getService(GetServiceRequest getServiceRequest, IRemoteServiceCallbacks iRemoteServiceCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iRemoteServiceCallbacks != null ? iRemoteServiceCallbacks.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getService(getServiceRequest, iRemoteServiceCallbacks);
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

        public static IRemoteServiceBroker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteServiceBroker)) {
                return (IRemoteServiceBroker) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IRemoteServiceBroker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteServiceBroker iRemoteServiceBroker) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteServiceBroker == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteServiceBroker;
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
            getService(parcel.readInt() != 0 ? GetServiceRequest.CREATOR.createFromParcel(parcel) : null, IRemoteServiceCallbacks.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void getService(GetServiceRequest getServiceRequest, IRemoteServiceCallbacks iRemoteServiceCallbacks) throws RemoteException;
}
