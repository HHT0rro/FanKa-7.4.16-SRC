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
public interface ISurfaceSyncGroupCompletedListener extends IInterface {
    public static final String DESCRIPTOR = "android.window.ISurfaceSyncGroupCompletedListener";

    void onSurfaceSyncGroupComplete() throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements ISurfaceSyncGroupCompletedListener {
        @Override // android.window.ISurfaceSyncGroupCompletedListener
        public void onSurfaceSyncGroupComplete() throws RemoteException {
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
    public static abstract class Stub extends Binder implements ISurfaceSyncGroupCompletedListener {
        static final int TRANSACTION_onSurfaceSyncGroupComplete = 1;

        public Stub() {
            attachInterface(this, ISurfaceSyncGroupCompletedListener.DESCRIPTOR);
        }

        public static ISurfaceSyncGroupCompletedListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISurfaceSyncGroupCompletedListener.DESCRIPTOR);
            if (iin != null && (iin instanceof ISurfaceSyncGroupCompletedListener)) {
                return (ISurfaceSyncGroupCompletedListener) iin;
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
                    return "onSurfaceSyncGroupComplete";
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
                data.enforceInterface(ISurfaceSyncGroupCompletedListener.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(ISurfaceSyncGroupCompletedListener.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            onSurfaceSyncGroupComplete();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public static class Proxy implements ISurfaceSyncGroupCompletedListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISurfaceSyncGroupCompletedListener.DESCRIPTOR;
            }

            @Override // android.window.ISurfaceSyncGroupCompletedListener
            public void onSurfaceSyncGroupComplete() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(ISurfaceSyncGroupCompletedListener.DESCRIPTOR);
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
