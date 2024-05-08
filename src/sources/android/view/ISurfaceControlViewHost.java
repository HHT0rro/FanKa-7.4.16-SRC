package android.view;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.window.ISurfaceSyncGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISurfaceControlViewHost extends IInterface {
    public static final String DESCRIPTOR = "android.view.ISurfaceControlViewHost";

    ISurfaceSyncGroup getSurfaceSyncGroup() throws RemoteException;

    void onConfigurationChanged(Configuration configuration) throws RemoteException;

    void onDispatchDetachedFromWindow() throws RemoteException;

    void onInsetsChanged(InsetsState insetsState, Rect rect) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements ISurfaceControlViewHost {
        @Override // android.view.ISurfaceControlViewHost
        public void onConfigurationChanged(Configuration newConfig) throws RemoteException {
        }

        @Override // android.view.ISurfaceControlViewHost
        public void onDispatchDetachedFromWindow() throws RemoteException {
        }

        @Override // android.view.ISurfaceControlViewHost
        public void onInsetsChanged(InsetsState state, Rect insetFrame) throws RemoteException {
        }

        @Override // android.view.ISurfaceControlViewHost
        public ISurfaceSyncGroup getSurfaceSyncGroup() throws RemoteException {
            return null;
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
    public static abstract class Stub extends Binder implements ISurfaceControlViewHost {
        static final int TRANSACTION_getSurfaceSyncGroup = 4;
        static final int TRANSACTION_onConfigurationChanged = 1;
        static final int TRANSACTION_onDispatchDetachedFromWindow = 2;
        static final int TRANSACTION_onInsetsChanged = 3;

        public Stub() {
            attachInterface(this, ISurfaceControlViewHost.DESCRIPTOR);
        }

        public static ISurfaceControlViewHost asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISurfaceControlViewHost.DESCRIPTOR);
            if (iin != null && (iin instanceof ISurfaceControlViewHost)) {
                return (ISurfaceControlViewHost) iin;
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
                    return "onConfigurationChanged";
                case 2:
                    return "onDispatchDetachedFromWindow";
                case 3:
                    return "onInsetsChanged";
                case 4:
                    return "getSurfaceSyncGroup";
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
                data.enforceInterface(ISurfaceControlViewHost.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(ISurfaceControlViewHost.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            Configuration _arg0 = (Configuration) data.readTypedObject(Configuration.CREATOR);
                            data.enforceNoDataAvail();
                            onConfigurationChanged(_arg0);
                            return true;
                        case 2:
                            onDispatchDetachedFromWindow();
                            return true;
                        case 3:
                            InsetsState _arg02 = (InsetsState) data.readTypedObject(InsetsState.CREATOR);
                            Rect _arg1 = (Rect) data.readTypedObject(Rect.CREATOR);
                            data.enforceNoDataAvail();
                            onInsetsChanged(_arg02, _arg1);
                            return true;
                        case 4:
                            ISurfaceSyncGroup _result = getSurfaceSyncGroup();
                            reply.writeNoException();
                            reply.writeStrongInterface(_result);
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
        private static class Proxy implements ISurfaceControlViewHost {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISurfaceControlViewHost.DESCRIPTOR;
            }

            @Override // android.view.ISurfaceControlViewHost
            public void onConfigurationChanged(Configuration newConfig) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    _data.writeTypedObject(newConfig, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.ISurfaceControlViewHost
            public void onDispatchDetachedFromWindow() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.ISurfaceControlViewHost
            public void onInsetsChanged(InsetsState state, Rect insetFrame) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    _data.writeTypedObject(state, 0);
                    _data.writeTypedObject(insetFrame, 0);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.ISurfaceControlViewHost
            public ISurfaceSyncGroup getSurfaceSyncGroup() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    ISurfaceSyncGroup _result = ISurfaceSyncGroup.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 3;
        }
    }
}
