package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface a extends IInterface {

    /* renamed from: com.huawei.hms.ads.uiengine.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0316a implements a {
        @Override // com.huawei.hms.ads.uiengine.a
        public long Code() {
            return 0L;
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void Code(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void Code(String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void I(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void I(String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void V() {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void V(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void V(String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void Z(Bundle bundle) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class b extends Binder implements a {
        public static final int B = 5;
        public static final int C = 6;
        public static final int Code = 1;
        public static final int D = 9;
        public static final int F = 8;
        public static final int I = 3;
        private static final String L = "com.huawei.hms.ads.uiengine.IMediaplayerAgent";
        public static final int S = 7;
        public static final int V = 2;
        public static final int Z = 4;

        /* renamed from: com.huawei.hms.ads.uiengine.a$b$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class C0317a implements a {
            public static a Code;
            private IBinder V;

            public C0317a(IBinder iBinder) {
                this.V = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public long Code() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (!this.V.transact(1, obtain, obtain2, 0) && b.I() != null) {
                        return b.I().Code();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void Code(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(2, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void Code(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    obtain.writeString(str);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String I() {
                return b.L;
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void I(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(4, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().I(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void I(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    obtain.writeString(str);
                    if (this.V.transact(9, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().I(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void V() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (this.V.transact(7, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().V();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void V(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(3, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().V(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void V(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    obtain.writeString(str);
                    if (this.V.transact(8, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().V(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void Z(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(5, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Z(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }
        }

        public b() {
            attachInterface(this, L);
        }

        public static a Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(L);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0317a(iBinder) : (a) queryLocalInterface;
        }

        public static boolean Code(a aVar) {
            if (C0317a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0317a.Code = aVar;
            return true;
        }

        public static a I() {
            return C0317a.Code;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(L);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(L);
                    long Code2 = Code();
                    parcel2.writeNoException();
                    parcel2.writeLong(Code2);
                    return true;
                case 2:
                    parcel.enforceInterface(L);
                    Code(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(L);
                    V(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(L);
                    I(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(L);
                    Z(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(L);
                    Code(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(L);
                    V();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(L);
                    V(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(L);
                    I(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    long Code();

    void Code(Bundle bundle);

    void Code(String str);

    void I(Bundle bundle);

    void I(String str);

    void V();

    void V(Bundle bundle);

    void V(String str);

    void Z(Bundle bundle);
}