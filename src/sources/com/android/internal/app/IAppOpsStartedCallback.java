package com.android.internal.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IAppOpsStartedCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.internal.app.IAppOpsStartedCallback";

    void opStarted(int i10, int i11, String str, String str2, int i12, int i13, int i14, int i15, int i16) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IAppOpsStartedCallback {
        @Override // com.android.internal.app.IAppOpsStartedCallback
        public void opStarted(int op, int uid, String packageName, String attributionTag, int flags, int mode, int startedType, int attributionFlags, int attributionChainId) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IAppOpsStartedCallback {
        static final int TRANSACTION_opStarted = 1;

        public Stub() {
            attachInterface(this, IAppOpsStartedCallback.DESCRIPTOR);
        }

        public static IAppOpsStartedCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IAppOpsStartedCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IAppOpsStartedCallback)) {
                return (IAppOpsStartedCallback) iin;
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
                    return "opStarted";
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
                data.enforceInterface(IAppOpsStartedCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IAppOpsStartedCallback.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            int _arg1 = data.readInt();
                            String _arg2 = data.readString();
                            String _arg3 = data.readString();
                            int _arg4 = data.readInt();
                            int _arg5 = data.readInt();
                            int _arg6 = data.readInt();
                            int _arg7 = data.readInt();
                            int _arg8 = data.readInt();
                            data.enforceNoDataAvail();
                            opStarted(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
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
        private static class Proxy implements IAppOpsStartedCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAppOpsStartedCallback.DESCRIPTOR;
            }

            @Override // com.android.internal.app.IAppOpsStartedCallback
            public void opStarted(int op, int uid, String packageName, String attributionTag, int flags, int mode, int startedType, int attributionFlags, int attributionChainId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IAppOpsStartedCallback.DESCRIPTOR);
                    _data.writeInt(op);
                    _data.writeInt(uid);
                    _data.writeString(packageName);
                    _data.writeString(attributionTag);
                    _data.writeInt(flags);
                    _data.writeInt(mode);
                    _data.writeInt(startedType);
                    _data.writeInt(attributionFlags);
                    _data.writeInt(attributionChainId);
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