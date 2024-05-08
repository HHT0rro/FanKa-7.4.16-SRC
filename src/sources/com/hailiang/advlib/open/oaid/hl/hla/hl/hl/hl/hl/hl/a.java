package com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAdvertisingIdService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface a extends IInterface {

    /* compiled from: IAdvertisingIdService.java */
    /* renamed from: com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0248a implements a {
        @Override // com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl.a
        public boolean a(boolean z10) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl.a
        public String c() throws RemoteException {
            return null;
        }
    }

    boolean a(boolean z10) throws RemoteException;

    String c() throws RemoteException;

    /* compiled from: IAdvertisingIdService.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f27158a = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

        /* renamed from: b, reason: collision with root package name */
        public static final int f27159b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f27160c = 2;

        /* compiled from: IAdvertisingIdService.java */
        /* renamed from: com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl.a$b$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0249a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f27161b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f27162a;

            public C0249a(IBinder iBinder) {
                this.f27162a = iBinder;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl.a
            public boolean a(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z10 ? 1 : 0);
                    if (!this.f27162a.transact(2, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().a(z10);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27162a;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl.a
            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.f27162a.transact(1, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().c();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String j() {
                return "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
            }
        }

        public b() {
            attachInterface(this, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0249a(iBinder);
        }

        public static a j() {
            return C0249a.f27161b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String c4 = c();
                parcel2.writeNoException();
                parcel2.writeString(c4);
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean a10 = a(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(a10 ? 1 : 0);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0249a.f27161b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0249a.f27161b = aVar;
            return true;
        }
    }
}
