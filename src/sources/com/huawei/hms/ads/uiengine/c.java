package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface c extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements c {
        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(long j10, long j11) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, int i10) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str, int i10) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str, long j10, long j11, int i10, int i11) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(boolean z10) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public boolean Code() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void V(String str, long j10, long j11, int i10, int i11) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public boolean V() {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class b extends Binder implements c {
        public static final int B = 1;
        public static final int C = 2;
        private static final String Code = "com.huawei.hms.ads.uiengine.INativeApi";
        public static final int D = 5;
        public static final int F = 4;
        public static final int L = 6;
        public static final int S = 3;

        /* renamed from: a, reason: collision with root package name */
        public static final int f29408a = 7;

        /* renamed from: b, reason: collision with root package name */
        public static final int f29409b = 8;

        /* renamed from: c, reason: collision with root package name */
        public static final int f29410c = 9;

        /* renamed from: d, reason: collision with root package name */
        public static final int f29411d = 10;

        /* renamed from: e, reason: collision with root package name */
        public static final int f29412e = 11;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class a implements c {
            public static c Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(long j10, long j11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeLong(j10);
                    obtain.writeLong(j11);
                    if (this.V.transact(5, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(j10, j11);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(iObjectWrapper);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeInt(i10);
                    if (this.V.transact(7, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(iObjectWrapper, i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (this.V.transact(9, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(iObjectWrapper, str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(11, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(iObjectWrapper, str, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    if (this.V.transact(1, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(str, i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str, long j10, long j11, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeString(str);
                    obtain.writeLong(j10);
                    obtain.writeLong(j11);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.V.transact(2, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.I().Code(str, j10, j11, i10, i11);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeInt(z10 ? 1 : 0);
                    if (this.V.transact(4, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                    } else {
                        b.I().Code(z10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public boolean Code() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    if (!this.V.transact(8, obtain, obtain2, 0) && b.I() != null) {
                        return b.I().Code();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String I() {
                return b.Code;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void V(String str, long j10, long j11, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    obtain.writeString(str);
                    obtain.writeLong(j10);
                    obtain.writeLong(j11);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.V.transact(3, obtain, obtain2, 0) || b.I() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.I().V(str, j10, j11, i10, i11);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public boolean V() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.Code);
                    if (!this.V.transact(10, obtain, obtain2, 0) && b.I() != null) {
                        return b.I().V();
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
                return this.V;
            }
        }

        public b() {
            attachInterface(this, Code);
        }

        public static c Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(Code);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(iBinder) : (c) queryLocalInterface;
        }

        public static boolean Code(c cVar) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (cVar == null) {
                return false;
            }
            a.Code = cVar;
            return true;
        }

        public static c I() {
            return a.Code;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(Code);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(Code);
                    Code(parcel.readString(), parcel.readInt());
                    break;
                case 2:
                    parcel.enforceInterface(Code);
                    Code(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    break;
                case 3:
                    parcel.enforceInterface(Code);
                    V(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    break;
                case 4:
                    parcel.enforceInterface(Code);
                    Code(parcel.readInt() != 0);
                    break;
                case 5:
                    parcel.enforceInterface(Code);
                    Code(parcel.readLong(), parcel.readLong());
                    break;
                case 6:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 7:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    break;
                case 8:
                    parcel.enforceInterface(Code);
                    boolean Code2 = Code();
                    parcel2.writeNoException();
                    parcel2.writeInt(Code2 ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    break;
                case 10:
                    parcel.enforceInterface(Code);
                    boolean V = V();
                    parcel2.writeNoException();
                    parcel2.writeInt(V ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void Code(long j10, long j11);

    void Code(IObjectWrapper iObjectWrapper);

    void Code(IObjectWrapper iObjectWrapper, int i10);

    void Code(IObjectWrapper iObjectWrapper, String str);

    void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    void Code(String str, int i10);

    void Code(String str, long j10, long j11, int i10, int i11);

    void Code(boolean z10);

    boolean Code();

    void V(String str, long j10, long j11, int i10, int i11);

    boolean V();
}
