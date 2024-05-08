package com.hailiang.advlib.open.oaid.hl.hlc.hl.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceIdService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface a extends IInterface {

    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0252a implements a {
        @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* compiled from: IDeviceIdService.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f27167a = "com.samsung.android.deviceidservice.IDeviceIdService";

        /* renamed from: b, reason: collision with root package name */
        public static final int f27168b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f27169c = 2;

        /* renamed from: d, reason: collision with root package name */
        public static final int f27170d = 3;

        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a$b$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0253a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f27171b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f27172a;

            public C0253a(IBinder iBinder) {
                this.f27172a = iBinder;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.f27172a.transact(1, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
            public String a(String str) throws RemoteException {
                return null;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27172a;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
            public String b(String str) throws RemoteException {
                return null;
            }

            public String j() {
                return "com.samsung.android.deviceidservice.IDeviceIdService";
            }
        }

        public b() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0253a(iBinder);
        }

        public static a j() {
            return C0253a.f27171b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a10 = a();
                parcel2.writeNoException();
                parcel2.writeString(a10);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String b4 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b4);
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            }
            parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            String a11 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a11);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0253a.f27171b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0253a.f27171b = aVar;
            return true;
        }
    }
}
