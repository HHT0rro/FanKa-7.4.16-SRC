package com.huawei.appmarket.framework.coreservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface b extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: com.huawei.appmarket.framework.coreservice.b$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0262a implements b {

            /* renamed from: b, reason: collision with root package name */
            public static b f27671b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f27672a;

            public C0262a(IBinder iBinder) {
                this.f27672a = iBinder;
            }

            @Override // com.huawei.appmarket.framework.coreservice.b
            public void a(DataHolder dataHolder, com.huawei.appmarket.framework.coreservice.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.appmarket.framework.coreservice.IAppGalleryServiceTransport");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f27672a.transact(1, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                    } else {
                        a.a().a(dataHolder, aVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27672a;
            }
        }

        public static b a() {
            return C0262a.f27671b;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.appmarket.framework.coreservice.IAppGalleryServiceTransport");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0262a(iBinder) : (b) queryLocalInterface;
        }
    }

    void a(DataHolder dataHolder, com.huawei.appmarket.framework.coreservice.a aVar) throws RemoteException;
}
