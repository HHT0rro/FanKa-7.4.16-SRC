package android.view.contentcapture;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IDataShareWriteAdapter extends IInterface {
    public static final String DESCRIPTOR = "android.view.contentcapture.IDataShareWriteAdapter";

    void error(int i10) throws RemoteException;

    void finish() throws RemoteException;

    void rejected() throws RemoteException;

    void write(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IDataShareWriteAdapter {
        @Override // android.view.contentcapture.IDataShareWriteAdapter
        public void write(ParcelFileDescriptor destination) throws RemoteException {
        }

        @Override // android.view.contentcapture.IDataShareWriteAdapter
        public void error(int errorCode) throws RemoteException {
        }

        @Override // android.view.contentcapture.IDataShareWriteAdapter
        public void rejected() throws RemoteException {
        }

        @Override // android.view.contentcapture.IDataShareWriteAdapter
        public void finish() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class Stub extends Binder implements IDataShareWriteAdapter {
        static final int TRANSACTION_error = 2;
        static final int TRANSACTION_finish = 4;
        static final int TRANSACTION_rejected = 3;
        static final int TRANSACTION_write = 1;

        public Stub() {
            attachInterface(this, IDataShareWriteAdapter.DESCRIPTOR);
        }

        public static IDataShareWriteAdapter asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IDataShareWriteAdapter.DESCRIPTOR);
            if (iin != null && (iin instanceof IDataShareWriteAdapter)) {
                return (IDataShareWriteAdapter) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "write";
                case 2:
                    return "error";
                case 3:
                    return "rejected";
                case 4:
                    return "finish";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IDataShareWriteAdapter.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IDataShareWriteAdapter.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            ParcelFileDescriptor _arg0 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
                            data.enforceNoDataAvail();
                            write(_arg0);
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            data.enforceNoDataAvail();
                            error(_arg02);
                            return true;
                        case 3:
                            rejected();
                            return true;
                        case 4:
                            finish();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        private static class Proxy implements IDataShareWriteAdapter {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDataShareWriteAdapter.DESCRIPTOR;
            }

            @Override // android.view.contentcapture.IDataShareWriteAdapter
            public void write(ParcelFileDescriptor destination) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IDataShareWriteAdapter.DESCRIPTOR);
                    _data.writeTypedObject(destination, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.contentcapture.IDataShareWriteAdapter
            public void error(int errorCode) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IDataShareWriteAdapter.DESCRIPTOR);
                    _data.writeInt(errorCode);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.contentcapture.IDataShareWriteAdapter
            public void rejected() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IDataShareWriteAdapter.DESCRIPTOR);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.contentcapture.IDataShareWriteAdapter
            public void finish() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IDataShareWriteAdapter.DESCRIPTOR);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 3;
        }
    }
}
