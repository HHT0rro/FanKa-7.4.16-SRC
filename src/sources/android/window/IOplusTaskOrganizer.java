package android.window;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IOplusTaskOrganizer extends IInterface {
    public static final String DESCRIPTOR = "android.window.IOplusTaskOrganizer";

    void updateStartingWindowExtendedInfo(OplusStartingWindowExtendedInfo oplusStartingWindowExtendedInfo, IBinder iBinder) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IOplusTaskOrganizer {
        @Override // android.window.IOplusTaskOrganizer
        public void updateStartingWindowExtendedInfo(OplusStartingWindowExtendedInfo info, IBinder appToken) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IOplusTaskOrganizer {
        static final int TRANSACTION_updateStartingWindowExtendedInfo = 1;

        public Stub() {
            attachInterface(this, IOplusTaskOrganizer.DESCRIPTOR);
        }

        public static IOplusTaskOrganizer asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IOplusTaskOrganizer.DESCRIPTOR);
            if (iin != null && (iin instanceof IOplusTaskOrganizer)) {
                return (IOplusTaskOrganizer) iin;
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
                    return "updateStartingWindowExtendedInfo";
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
                data.enforceInterface(IOplusTaskOrganizer.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IOplusTaskOrganizer.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            OplusStartingWindowExtendedInfo _arg0 = (OplusStartingWindowExtendedInfo) data.readTypedObject(OplusStartingWindowExtendedInfo.CREATOR);
                            IBinder _arg1 = data.readStrongBinder();
                            data.enforceNoDataAvail();
                            updateStartingWindowExtendedInfo(_arg0, _arg1);
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
        private static class Proxy implements IOplusTaskOrganizer {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOplusTaskOrganizer.DESCRIPTOR;
            }

            @Override // android.window.IOplusTaskOrganizer
            public void updateStartingWindowExtendedInfo(OplusStartingWindowExtendedInfo info, IBinder appToken) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IOplusTaskOrganizer.DESCRIPTOR);
                    _data.writeTypedObject(info, 0);
                    _data.writeStrongBinder(appToken);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 0;
        }
    }
}
