package com.hailiang.advlib.open.oaid.hl.hl.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: MsaIdInterface.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface a extends IInterface {

    /* compiled from: MsaIdInterface.java */
    /* renamed from: com.hailiang.advlib.open.oaid.hl.hl.hl.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0246a implements a {
        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public void d() throws RemoteException {
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public String e() throws RemoteException {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public boolean f() throws RemoteException {
            return false;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public String g() throws RemoteException {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public boolean i() throws RemoteException {
            return false;
        }
    }

    String a() throws RemoteException;

    void d() throws RemoteException;

    String e() throws RemoteException;

    boolean f() throws RemoteException;

    String g() throws RemoteException;

    boolean i() throws RemoteException;

    /* compiled from: MsaIdInterface.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f27149a = "com.bun.lib.MsaIdInterface";

        /* renamed from: b, reason: collision with root package name */
        public static final int f27150b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f27151c = 2;

        /* renamed from: d, reason: collision with root package name */
        public static final int f27152d = 3;

        /* renamed from: e, reason: collision with root package name */
        public static final int f27153e = 4;

        /* renamed from: f, reason: collision with root package name */
        public static final int f27154f = 5;

        /* renamed from: g, reason: collision with root package name */
        public static final int f27155g = 6;

        /* compiled from: MsaIdInterface.java */
        /* renamed from: com.hailiang.advlib.open.oaid.hl.hl.hl.a$b$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0247a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f27156b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f27157a;

            public C0247a(IBinder iBinder) {
                this.f27157a = iBinder;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f27157a.transact(3, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27157a;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public void d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f27157a.transact(6, obtain, obtain2, 0) && b.j() != null) {
                        b.j().d();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public String e() throws RemoteException {
                return null;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public boolean f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f27157a.transact(1, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().f();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public String g() throws RemoteException {
                return null;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public boolean i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f27157a.transact(2, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().i();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String j() {
                return "com.bun.lib.MsaIdInterface";
            }
        }

        public b() {
            attachInterface(this, "com.bun.lib.MsaIdInterface");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0247a(iBinder);
        }

        public static a j() {
            return C0247a.f27156b;
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
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean f10 = f();
                        parcel2.writeNoException();
                        parcel2.writeInt(f10 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean i12 = i();
                        parcel2.writeNoException();
                        parcel2.writeInt(i12 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String a10 = a();
                        parcel2.writeNoException();
                        parcel2.writeString(a10);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String g3 = g();
                        parcel2.writeNoException();
                        parcel2.writeString(g3);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String e2 = e();
                        parcel2.writeNoException();
                        parcel2.writeString(e2);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        d();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.bun.lib.MsaIdInterface");
            return true;
        }

        public static boolean a(a aVar) {
            if (C0247a.f27156b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0247a.f27156b = aVar;
            return true;
        }
    }
}
