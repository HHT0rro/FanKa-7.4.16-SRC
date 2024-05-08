package com.asus.msa.sdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IDIDBinderStatusListener extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class Stub extends Binder implements IDIDBinderStatusListener {
        public static final String DESCRIPTOR = "com.asus.msa.sdid.IDIDBinderStatusListener";
        public static final int TRANSACTION_onError = 2;
        public static final int TRANSACTION_onSuccess = 1;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static class Proxy implements IDIDBinderStatusListener {
            public IBinder mRemote;

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

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public void onError() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public void onSuccess(IDidAidlInterface iDidAidlInterface) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDidAidlInterface != null ? iDidAidlInterface.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDIDBinderStatusListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDIDBinderStatusListener)) ? new Proxy(iBinder) : (IDIDBinderStatusListener) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess(IDidAidlInterface.Stub.asInterface(parcel.readStrongBinder()));
            } else {
                if (i10 != 2) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onError();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onError();

    void onSuccess(IDidAidlInterface iDidAidlInterface);
}
