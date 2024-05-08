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
public interface IVisualQueryDetectionAttentionListener extends IInterface {
    public static final String DESCRIPTOR = "com.android.internal.app.IVisualQueryDetectionAttentionListener";

    void onAttentionGained() throws RemoteException;

    void onAttentionLost() throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IVisualQueryDetectionAttentionListener {
        @Override // com.android.internal.app.IVisualQueryDetectionAttentionListener
        public void onAttentionGained() throws RemoteException {
        }

        @Override // com.android.internal.app.IVisualQueryDetectionAttentionListener
        public void onAttentionLost() throws RemoteException {
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
    public static abstract class Stub extends Binder implements IVisualQueryDetectionAttentionListener {
        static final int TRANSACTION_onAttentionGained = 1;
        static final int TRANSACTION_onAttentionLost = 2;

        public Stub() {
            attachInterface(this, IVisualQueryDetectionAttentionListener.DESCRIPTOR);
        }

        public static IVisualQueryDetectionAttentionListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVisualQueryDetectionAttentionListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IVisualQueryDetectionAttentionListener)) {
                return (IVisualQueryDetectionAttentionListener) iin;
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
                    return "onAttentionGained";
                case 2:
                    return "onAttentionLost";
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
                data.enforceInterface(IVisualQueryDetectionAttentionListener.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVisualQueryDetectionAttentionListener.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            onAttentionGained();
                            return true;
                        case 2:
                            onAttentionLost();
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
        private static class Proxy implements IVisualQueryDetectionAttentionListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVisualQueryDetectionAttentionListener.DESCRIPTOR;
            }

            @Override // com.android.internal.app.IVisualQueryDetectionAttentionListener
            public void onAttentionGained() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IVisualQueryDetectionAttentionListener.DESCRIPTOR);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.android.internal.app.IVisualQueryDetectionAttentionListener
            public void onAttentionLost() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IVisualQueryDetectionAttentionListener.DESCRIPTOR);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
