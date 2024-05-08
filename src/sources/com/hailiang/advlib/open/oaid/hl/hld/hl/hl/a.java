package com.hailiang.advlib.open.oaid.hl.hld.hl.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: OpenDeviceIdentifierService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface a extends IInterface {

    /* compiled from: OpenDeviceIdentifierService.java */
    /* renamed from: com.hailiang.advlib.open.oaid.hl.hld.hl.hl.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0254a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hld.hl.hl.a
        public boolean b() throws RemoteException {
            return false;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hld.hl.hl.a
        public String h() throws RemoteException {
            return null;
        }
    }

    boolean b() throws RemoteException;

    String h() throws RemoteException;

    /* compiled from: OpenDeviceIdentifierService.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f27173a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

        /* renamed from: b, reason: collision with root package name */
        public static final int f27174b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f27175c = 2;

        /* compiled from: OpenDeviceIdentifierService.java */
        /* renamed from: com.hailiang.advlib.open.oaid.hl.hld.hl.hl.a$b$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0255a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f27176b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f27177a;

            public C0255a(IBinder iBinder) {
                this.f27177a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27177a;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hld.hl.hl.a
            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.f27177a.transact(2, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().b();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hld.hl.hl.a
            public String h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.f27177a.transact(1, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().h();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String j() {
                return "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            }
        }

        public b() {
            attachInterface(this, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0255a(iBinder);
        }

        public static a j() {
            return C0255a.f27176b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String h10 = h();
                parcel2.writeNoException();
                parcel2.writeString(h10);
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
            boolean b4 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b4 ? 1 : 0);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0255a.f27176b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0255a.f27176b = aVar;
            return true;
        }
    }
}
