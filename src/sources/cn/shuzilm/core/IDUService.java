package cn.shuzilm.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.shuzilm.core.DUListener;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IDUService extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public abstract class Stub extends Binder implements IDUService {
        private static final String DESCRIPTOR = "cn.shuzilm.core.IDUService";
        public static final int TRANSACTION_getOpenAnmsIDAsyn = 9;
        public static final int TRANSACTION_getQueryID = 5;
        public static final int TRANSACTION_getQueryIDAsyn = 8;
        public static final int TRANSACTION_go = 3;
        public static final int TRANSACTION_onEvent = 6;
        public static final int TRANSACTION_onEventAsyn = 7;
        public static final int TRANSACTION_report = 4;
        public static final int TRANSACTION_setConfig = 2;
        public static final int TRANSACTION_setData = 1;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        class Proxy implements IDUService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // cn.shuzilm.core.IDUService
            public void getOpenAnmsIDAsyn(DUListener dUListener) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(dUListener != null ? dUListener.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public String getQueryID(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public Map getQueryIDAsyn(String str, String str2, DUListener dUListener) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(dUListener != null ? dUListener.asBinder() : null);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public void go(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public Map onEvent(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public Map onEventAsyn(String str, String str2, String str3, DUListener dUListener) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(dUListener != null ? dUListener.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public void report(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public int setConfig(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public int setData(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDUService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDUService)) ? new Proxy(iBinder) : (IDUService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int data = setData(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(data);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int config = setConfig(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(config);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    go(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    report(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    String queryID = getQueryID(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(queryID);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    Map onEvent = onEvent(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeMap(onEvent);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    Map onEventAsyn = onEventAsyn(parcel.readString(), parcel.readString(), parcel.readString(), DUListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeMap(onEventAsyn);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    Map queryIDAsyn = getQueryIDAsyn(parcel.readString(), parcel.readString(), DUListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeMap(queryIDAsyn);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    getOpenAnmsIDAsyn(DUListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void getOpenAnmsIDAsyn(DUListener dUListener);

    String getQueryID(String str, String str2);

    Map getQueryIDAsyn(String str, String str2, DUListener dUListener);

    void go(String str, String str2);

    Map onEvent(String str, String str2, String str3);

    Map onEventAsyn(String str, String str2, String str3, DUListener dUListener);

    void report(String str, String str2);

    int setConfig(String str, String str2);

    int setData(String str, String str2);
}
