package com.ishumei.smantifraud;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IService extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class l1111l111111Il extends Binder implements IService {
        private static int l1111l111111Il = 1;
        private static int l111l11111I1l = 3;
        private static final String l111l11111Il = "com.ishumei.smantifraud.ISolateDetectorS";
        private static int l111l11111lIl = 2;

        /* renamed from: com.ishumei.smantifraud.IService$l1111l111111Il$l1111l111111Il, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class C0352l1111l111111Il implements IService {
            private IBinder l1111l111111Il;

            public C0352l1111l111111Il(IBinder iBinder) {
                this.l1111l111111Il = iBinder;
            }

            private static String l1111l111111Il() {
                return l1111l111111Il.l111l11111Il;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.l1111l111111Il;
            }

            @Override // com.ishumei.smantifraud.IService
            public final boolean hasBI() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(l1111l111111Il.l111l11111Il);
                    this.l1111l111111Il.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ishumei.smantifraud.IService
            public final boolean hasF() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(l1111l111111Il.l111l11111Il);
                    this.l1111l111111Il.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ishumei.smantifraud.IService
            public final boolean hasMagiskMount() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(l1111l111111Il.l111l11111Il);
                    this.l1111l111111Il.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public l1111l111111Il() {
            attachInterface(this, l111l11111Il);
        }

        public static IService l1111l111111Il(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(l111l11111Il);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IService)) ? new C0352l1111l111111Il(iBinder) : (IService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(l111l11111Il);
                boolean hasMagiskMount = hasMagiskMount();
                parcel2.writeNoException();
                parcel2.writeInt(hasMagiskMount ? 1 : 0);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(l111l11111Il);
                boolean hasF = hasF();
                parcel2.writeNoException();
                parcel2.writeInt(hasF ? 1 : 0);
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(l111l11111Il);
                return true;
            }
            parcel.enforceInterface(l111l11111Il);
            boolean hasBI = hasBI();
            parcel2.writeNoException();
            parcel2.writeInt(hasBI ? 1 : 0);
            return true;
        }
    }

    boolean hasBI();

    boolean hasF();

    boolean hasMagiskMount();
}
