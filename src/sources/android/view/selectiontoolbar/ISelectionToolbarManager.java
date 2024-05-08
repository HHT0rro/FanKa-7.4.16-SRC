package android.view.selectiontoolbar;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.selectiontoolbar.ISelectionToolbarCallback;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISelectionToolbarManager extends IInterface {
    public static final String DESCRIPTOR = "android.view.selectiontoolbar.ISelectionToolbarManager";

    void dismissToolbar(long j10, int i10) throws RemoteException;

    void hideToolbar(long j10, int i10) throws RemoteException;

    void showToolbar(ShowInfo showInfo, ISelectionToolbarCallback iSelectionToolbarCallback, int i10) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements ISelectionToolbarManager {
        @Override // android.view.selectiontoolbar.ISelectionToolbarManager
        public void showToolbar(ShowInfo showInfo, ISelectionToolbarCallback callback, int userId) throws RemoteException {
        }

        @Override // android.view.selectiontoolbar.ISelectionToolbarManager
        public void hideToolbar(long widgetToken, int userId) throws RemoteException {
        }

        @Override // android.view.selectiontoolbar.ISelectionToolbarManager
        public void dismissToolbar(long widgetToken, int userId) throws RemoteException {
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
    public static abstract class Stub extends Binder implements ISelectionToolbarManager {
        static final int TRANSACTION_dismissToolbar = 3;
        static final int TRANSACTION_hideToolbar = 2;
        static final int TRANSACTION_showToolbar = 1;

        public Stub() {
            attachInterface(this, ISelectionToolbarManager.DESCRIPTOR);
        }

        public static ISelectionToolbarManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISelectionToolbarManager.DESCRIPTOR);
            if (iin != null && (iin instanceof ISelectionToolbarManager)) {
                return (ISelectionToolbarManager) iin;
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
                    return "showToolbar";
                case 2:
                    return "hideToolbar";
                case 3:
                    return "dismissToolbar";
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
                data.enforceInterface(ISelectionToolbarManager.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(ISelectionToolbarManager.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            ShowInfo _arg0 = (ShowInfo) data.readTypedObject(ShowInfo.CREATOR);
                            ISelectionToolbarCallback _arg1 = ISelectionToolbarCallback.Stub.asInterface(data.readStrongBinder());
                            int _arg2 = data.readInt();
                            data.enforceNoDataAvail();
                            showToolbar(_arg0, _arg1, _arg2);
                            return true;
                        case 2:
                            long _arg02 = data.readLong();
                            int _arg12 = data.readInt();
                            data.enforceNoDataAvail();
                            hideToolbar(_arg02, _arg12);
                            return true;
                        case 3:
                            long _arg03 = data.readLong();
                            int _arg13 = data.readInt();
                            data.enforceNoDataAvail();
                            dismissToolbar(_arg03, _arg13);
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
        private static class Proxy implements ISelectionToolbarManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISelectionToolbarManager.DESCRIPTOR;
            }

            @Override // android.view.selectiontoolbar.ISelectionToolbarManager
            public void showToolbar(ShowInfo showInfo, ISelectionToolbarCallback callback, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(ISelectionToolbarManager.DESCRIPTOR);
                    _data.writeTypedObject(showInfo, 0);
                    _data.writeStrongInterface(callback);
                    _data.writeInt(userId);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.selectiontoolbar.ISelectionToolbarManager
            public void hideToolbar(long widgetToken, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(ISelectionToolbarManager.DESCRIPTOR);
                    _data.writeLong(widgetToken);
                    _data.writeInt(userId);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.selectiontoolbar.ISelectionToolbarManager
            public void dismissToolbar(long widgetToken, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(ISelectionToolbarManager.DESCRIPTOR);
                    _data.writeLong(widgetToken);
                    _data.writeInt(userId);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }
}
