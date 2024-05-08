package com.uodis.opendevice.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class Stub extends Binder implements OpenDeviceIdentifierService {
        private static final String DESCRIPTOR = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        public static final int TRANSACTION_getOaid = 1;
        public static final int TRANSACTION_isOaidTrackLimited = 2;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class a implements OpenDeviceIdentifierService {

            /* renamed from: b, reason: collision with root package name */
            public static OpenDeviceIdentifierService f46070b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f46071a;

            public a(IBinder iBinder) {
                this.f46071a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f46071a;
            }

            @Override // com.uodis.opendevice.aidl.OpenDeviceIdentifierService
            public String getOaid() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.f46071a.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOaid();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.uodis.opendevice.aidl.OpenDeviceIdentifierService
            public boolean isOaidTrackLimited() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.f46071a.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isOaidTrackLimited();
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
            attachInterface(this, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        public static OpenDeviceIdentifierService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof OpenDeviceIdentifierService)) {
                return (OpenDeviceIdentifierService) queryLocalInterface;
            }
            return new a(iBinder);
        }

        public static OpenDeviceIdentifierService getDefaultImpl() {
            return a.f46070b;
        }

        public static boolean setDefaultImpl(OpenDeviceIdentifierService openDeviceIdentifierService) {
            if (a.f46070b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (openDeviceIdentifierService == null) {
                return false;
            }
            a.f46070b = openDeviceIdentifierService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String oaid = getOaid();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean isOaidTrackLimited = isOaidTrackLimited();
            parcel2.writeNoException();
            parcel2.writeInt(isOaidTrackLimited ? 1 : 0);
            return true;
        }
    }

    String getOaid() throws RemoteException;

    boolean isOaidTrackLimited() throws RemoteException;
}
