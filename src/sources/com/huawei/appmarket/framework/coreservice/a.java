package com.huawei.appmarket.framework.coreservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface a extends IInterface {

    /* renamed from: com.huawei.appmarket.framework.coreservice.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class AbstractBinderC0260a extends Binder implements a {

        /* renamed from: com.huawei.appmarket.framework.coreservice.a$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0261a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f27669b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f27670a;

            public C0261a(IBinder iBinder) {
                this.f27670a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27670a;
            }

            @Override // com.huawei.appmarket.framework.coreservice.a
            public void call(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f27670a.transact(1, obtain, obtain2, 0) || AbstractBinderC0260a.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC0260a.getDefaultImpl().call(status);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0260a() {
            attachInterface(this, "com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0261a(iBinder) : (a) queryLocalInterface;
        }

        public static a getDefaultImpl() {
            return C0261a.f27669b;
        }

        public static boolean setDefaultImpl(a aVar) {
            if (C0261a.f27669b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0261a.f27669b = aVar;
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
                parcel2.writeString("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
                return true;
            }
            parcel.enforceInterface("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
            call(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void call(Status status) throws RemoteException;
}
