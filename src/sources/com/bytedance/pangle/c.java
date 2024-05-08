package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface c extends IInterface {
    boolean a(String str);

    boolean a(String str, String str2);

    int b(String str);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0118a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a10 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a10 ? 1 : 0);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int b4 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b4);
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.bytedance.pangle.IPackageManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            boolean a11 = a(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(a11 ? 1 : 0);
            return true;
        }

        public static c a() {
            return C0118a.f10636a;
        }

        /* renamed from: com.bytedance.pangle.c$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static class C0118a implements c {

            /* renamed from: a, reason: collision with root package name */
            public static c f10636a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f10637b;

            public C0118a(IBinder iBinder) {
                this.f10637b = iBinder;
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f10637b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f10637b;
            }

            @Override // com.bytedance.pangle.c
            public final int b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f10637b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f10637b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
