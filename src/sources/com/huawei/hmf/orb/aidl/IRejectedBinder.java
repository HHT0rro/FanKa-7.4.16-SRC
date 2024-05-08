package com.huawei.hmf.orb.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IRejectedBinder extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Default implements IRejectedBinder {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hmf.orb.aidl.IRejectedBinder
        public int getCode() throws RemoteException {
            return 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class Stub extends Binder implements IRejectedBinder {
        private static final String DESCRIPTOR = "com.huawei.hmf.orb.aidl.IRejectedBinder";
        public static final int TRANSACTION_getCode = 1;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class Proxy implements IRejectedBinder {
            public static IRejectedBinder sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hmf.orb.aidl.IRejectedBinder
            public int getCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRejectedBinder asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRejectedBinder)) {
                return (IRejectedBinder) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IRejectedBinder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRejectedBinder iRejectedBinder) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRejectedBinder == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRejectedBinder;
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
            int code = getCode();
            parcel2.writeNoException();
            parcel2.writeInt(code);
            return true;
        }
    }

    int getCode() throws RemoteException;
}
