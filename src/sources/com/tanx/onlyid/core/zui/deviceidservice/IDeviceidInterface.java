package com.tanx.onlyid.core.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IDeviceidInterface extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Default implements IDeviceidInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public String createAAIDForPackageName(String str) throws RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public String getUDID() throws RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public String getVAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
        public boolean isSupport() throws RemoteException {
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class Stub extends Binder implements IDeviceidInterface {
        public static final String DESCRIPTOR = "com.zui.deviceidservice.IDeviceidInterface";
        public static final int TRANSACTION_createAAIDForPackageName = 6;
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupport = 3;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class Proxy implements IDeviceidInterface {
            public static IDeviceidInterface sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public String createAAIDForPackageName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createAAIDForPackageName(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public String getAAID(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.zui.deviceidservice.IDeviceidInterface";
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public String getOAID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public String getUDID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUDID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public String getVAID(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface
            public boolean isSupport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupport();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        public static IDeviceidInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceidInterface)) {
                return (IDeviceidInterface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IDeviceidInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceidInterface iDeviceidInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDeviceidInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceidInterface;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String oaid = getOAID();
                        parcel2.writeNoException();
                        parcel2.writeString(oaid);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String udid = getUDID();
                        parcel2.writeNoException();
                        parcel2.writeString(udid);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        boolean isSupport = isSupport();
                        parcel2.writeNoException();
                        parcel2.writeInt(isSupport ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String vaid = getVAID(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(vaid);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String aaid = getAAID(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(aaid);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                        String createAAIDForPackageName = createAAIDForPackageName(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(createAAIDForPackageName);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
            return true;
        }
    }

    String createAAIDForPackageName(String str) throws RemoteException;

    String getAAID(String str) throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID(String str) throws RemoteException;

    boolean isSupport() throws RemoteException;
}
