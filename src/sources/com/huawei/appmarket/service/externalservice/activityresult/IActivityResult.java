package com.huawei.appmarket.service.externalservice.activityresult;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IActivityResult extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements IActivityResult {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
        public void onActivityCancel(int i10) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b extends Binder implements IActivityResult {
        public static final int Code = 1;
        private static final String V = "com.huawei.appmarket.service.externalservice.activityresult.IActivityResult";

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a implements IActivityResult {
            public static IActivityResult Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.V;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
            public void onActivityCancel(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.V);
                    obtain.writeInt(i10);
                    if (this.V.transact(1, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onActivityCancel(i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, V);
        }

        public static IActivityResult Code() {
            return a.Code;
        }

        public static IActivityResult Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(V);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IActivityResult)) ? new a(iBinder) : (IActivityResult) queryLocalInterface;
        }

        public static boolean Code(IActivityResult iActivityResult) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iActivityResult == null) {
                return false;
            }
            a.Code = iActivityResult;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(V);
                return true;
            }
            parcel.enforceInterface(V);
            onActivityCancel(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onActivityCancel(int i10);
}
