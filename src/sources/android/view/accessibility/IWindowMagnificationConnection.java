package android.view.accessibility;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.accessibility.IRemoteMagnificationAnimationCallback;
import android.view.accessibility.IWindowMagnificationConnectionCallback;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IWindowMagnificationConnection extends IInterface {
    public static final String DESCRIPTOR = "android.view.accessibility.IWindowMagnificationConnection";

    void disableWindowMagnification(int i10, IRemoteMagnificationAnimationCallback iRemoteMagnificationAnimationCallback) throws RemoteException;

    void enableWindowMagnification(int i10, float f10, float f11, float f12, float f13, float f14, IRemoteMagnificationAnimationCallback iRemoteMagnificationAnimationCallback) throws RemoteException;

    void moveWindowMagnifier(int i10, float f10, float f11) throws RemoteException;

    void moveWindowMagnifierToPosition(int i10, float f10, float f11, IRemoteMagnificationAnimationCallback iRemoteMagnificationAnimationCallback) throws RemoteException;

    void removeMagnificationButton(int i10) throws RemoteException;

    void removeMagnificationSettingsPanel(int i10) throws RemoteException;

    void setConnectionCallback(IWindowMagnificationConnectionCallback iWindowMagnificationConnectionCallback) throws RemoteException;

    void setScale(int i10, float f10) throws RemoteException;

    void showMagnificationButton(int i10, int i11) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IWindowMagnificationConnection {
        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void enableWindowMagnification(int displayId, float scale, float centerX, float centerY, float magnificationFrameOffsetRatioX, float magnificationFrameOffsetRatioY, IRemoteMagnificationAnimationCallback callback) throws RemoteException {
        }

        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void setScale(int displayId, float scale) throws RemoteException {
        }

        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void disableWindowMagnification(int displayId, IRemoteMagnificationAnimationCallback callback) throws RemoteException {
        }

        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void moveWindowMagnifier(int displayId, float offsetX, float offsetY) throws RemoteException {
        }

        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void moveWindowMagnifierToPosition(int displayId, float positionX, float positionY, IRemoteMagnificationAnimationCallback callback) throws RemoteException {
        }

        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void showMagnificationButton(int displayId, int magnificationMode) throws RemoteException {
        }

        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void removeMagnificationButton(int displayId) throws RemoteException {
        }

        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void removeMagnificationSettingsPanel(int displayId) throws RemoteException {
        }

        @Override // android.view.accessibility.IWindowMagnificationConnection
        public void setConnectionCallback(IWindowMagnificationConnectionCallback callback) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IWindowMagnificationConnection {
        static final int TRANSACTION_disableWindowMagnification = 3;
        static final int TRANSACTION_enableWindowMagnification = 1;
        static final int TRANSACTION_moveWindowMagnifier = 4;
        static final int TRANSACTION_moveWindowMagnifierToPosition = 5;
        static final int TRANSACTION_removeMagnificationButton = 7;
        static final int TRANSACTION_removeMagnificationSettingsPanel = 8;
        static final int TRANSACTION_setConnectionCallback = 9;
        static final int TRANSACTION_setScale = 2;
        static final int TRANSACTION_showMagnificationButton = 6;

        public Stub() {
            attachInterface(this, IWindowMagnificationConnection.DESCRIPTOR);
        }

        public static IWindowMagnificationConnection asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IWindowMagnificationConnection.DESCRIPTOR);
            if (iin != null && (iin instanceof IWindowMagnificationConnection)) {
                return (IWindowMagnificationConnection) iin;
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
                    return "enableWindowMagnification";
                case 2:
                    return "setScale";
                case 3:
                    return "disableWindowMagnification";
                case 4:
                    return "moveWindowMagnifier";
                case 5:
                    return "moveWindowMagnifierToPosition";
                case 6:
                    return "showMagnificationButton";
                case 7:
                    return "removeMagnificationButton";
                case 8:
                    return "removeMagnificationSettingsPanel";
                case 9:
                    return "setConnectionCallback";
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
                data.enforceInterface(IWindowMagnificationConnection.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IWindowMagnificationConnection.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            float _arg1 = data.readFloat();
                            float _arg2 = data.readFloat();
                            float _arg3 = data.readFloat();
                            float _arg4 = data.readFloat();
                            float _arg5 = data.readFloat();
                            IRemoteMagnificationAnimationCallback _arg6 = IRemoteMagnificationAnimationCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            enableWindowMagnification(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            float _arg12 = data.readFloat();
                            data.enforceNoDataAvail();
                            setScale(_arg02, _arg12);
                            return true;
                        case 3:
                            int _arg03 = data.readInt();
                            IRemoteMagnificationAnimationCallback _arg13 = IRemoteMagnificationAnimationCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            disableWindowMagnification(_arg03, _arg13);
                            return true;
                        case 4:
                            int _arg04 = data.readInt();
                            float _arg14 = data.readFloat();
                            float _arg22 = data.readFloat();
                            data.enforceNoDataAvail();
                            moveWindowMagnifier(_arg04, _arg14, _arg22);
                            return true;
                        case 5:
                            int _arg05 = data.readInt();
                            float _arg15 = data.readFloat();
                            float _arg23 = data.readFloat();
                            IRemoteMagnificationAnimationCallback _arg32 = IRemoteMagnificationAnimationCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            moveWindowMagnifierToPosition(_arg05, _arg15, _arg23, _arg32);
                            return true;
                        case 6:
                            int _arg06 = data.readInt();
                            int _arg16 = data.readInt();
                            data.enforceNoDataAvail();
                            showMagnificationButton(_arg06, _arg16);
                            return true;
                        case 7:
                            int _arg07 = data.readInt();
                            data.enforceNoDataAvail();
                            removeMagnificationButton(_arg07);
                            return true;
                        case 8:
                            int _arg08 = data.readInt();
                            data.enforceNoDataAvail();
                            removeMagnificationSettingsPanel(_arg08);
                            return true;
                        case 9:
                            IWindowMagnificationConnectionCallback _arg09 = IWindowMagnificationConnectionCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            setConnectionCallback(_arg09);
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
        public static class Proxy implements IWindowMagnificationConnection {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IWindowMagnificationConnection.DESCRIPTOR;
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void enableWindowMagnification(int displayId, float scale, float centerX, float centerY, float magnificationFrameOffsetRatioX, float magnificationFrameOffsetRatioY, IRemoteMagnificationAnimationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeFloat(scale);
                    _data.writeFloat(centerX);
                    _data.writeFloat(centerY);
                    _data.writeFloat(magnificationFrameOffsetRatioX);
                    _data.writeFloat(magnificationFrameOffsetRatioY);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void setScale(int displayId, float scale) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeFloat(scale);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void disableWindowMagnification(int displayId, IRemoteMagnificationAnimationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void moveWindowMagnifier(int displayId, float offsetX, float offsetY) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeFloat(offsetX);
                    _data.writeFloat(offsetY);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void moveWindowMagnifierToPosition(int displayId, float positionX, float positionY, IRemoteMagnificationAnimationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeFloat(positionX);
                    _data.writeFloat(positionY);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void showMagnificationButton(int displayId, int magnificationMode) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(magnificationMode);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void removeMagnificationButton(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void removeMagnificationSettingsPanel(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(8, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.accessibility.IWindowMagnificationConnection
            public void setConnectionCallback(IWindowMagnificationConnectionCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IWindowMagnificationConnection.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(9, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 8;
        }
    }
}
