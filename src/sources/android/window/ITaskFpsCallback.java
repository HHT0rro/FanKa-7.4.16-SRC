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
public interface ITaskFpsCallback extends IInterface {
    public static final String DESCRIPTOR = "android.window.ITaskFpsCallback";

    void onFpsReported(float f10) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements ITaskFpsCallback {
        @Override // android.window.ITaskFpsCallback
        public void onFpsReported(float fps) throws RemoteException {
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
    public static abstract class Stub extends Binder implements ITaskFpsCallback {
        static final int TRANSACTION_onFpsReported = 1;

        public Stub() {
            attachInterface(this, ITaskFpsCallback.DESCRIPTOR);
        }

        public static ITaskFpsCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ITaskFpsCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof ITaskFpsCallback)) {
                return (ITaskFpsCallback) iin;
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
                    return "onFpsReported";
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
                data.enforceInterface(ITaskFpsCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(ITaskFpsCallback.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            float _arg0 = data.readFloat();
                            data.enforceNoDataAvail();
                            onFpsReported(_arg0);
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
        private static class Proxy implements ITaskFpsCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskFpsCallback.DESCRIPTOR;
            }

            @Override // android.window.ITaskFpsCallback
            public void onFpsReported(float fps) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(ITaskFpsCallback.DESCRIPTOR);
                    _data.writeFloat(fps);
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
