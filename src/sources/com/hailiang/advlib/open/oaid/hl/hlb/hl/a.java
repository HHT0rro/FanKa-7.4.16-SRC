package com.hailiang.advlib.open.oaid.hl.hlb.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IOpenID.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface a extends IInterface {

    /* compiled from: IOpenID.java */
    /* renamed from: com.hailiang.advlib.open.oaid.hl.hlb.hl.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0250a implements a {
        @Override // com.hailiang.advlib.open.oaid.hl.hlb.hl.a
        public String a(String str, String str2, String str3) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    String a(String str, String str2, String str3) throws RemoteException;

    /* compiled from: IOpenID.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f27163a = "com.heytap.openid.IOpenID";

        /* renamed from: b, reason: collision with root package name */
        public static final int f27164b = 1;

        /* compiled from: IOpenID.java */
        /* renamed from: com.hailiang.advlib.open.oaid.hl.hlb.hl.a$b$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0251a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f27165b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f27166a;

            public C0251a(IBinder iBinder) {
                this.f27166a = iBinder;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlb.hl.a
            public String a(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.f27166a.transact(1, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().a(str, str2, str3);
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
                return this.f27166a;
            }

            public String j() {
                return "com.heytap.openid.IOpenID";
            }
        }

        public b() {
            attachInterface(this, "com.heytap.openid.IOpenID");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0251a(iBinder);
        }

        public static a j() {
            return C0251a.f27165b;
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
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String a10 = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a10);
            return true;
        }

        public static boolean a(a aVar) {
            if (C0251a.f27165b != null || aVar == null) {
                return false;
            }
            C0251a.f27165b = aVar;
            return true;
        }
    }
}
