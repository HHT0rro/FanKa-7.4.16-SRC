package com.android.internal.inputmethod;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.inputmethod.EditorInfo;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IAccessibilityInputMethodSession extends IInterface {
    public static final String DESCRIPTOR = "com.android.internal.inputmethod.IAccessibilityInputMethodSession";

    void finishInput() throws RemoteException;

    void finishSession() throws RemoteException;

    void invalidateInput(EditorInfo editorInfo, IRemoteAccessibilityInputConnection iRemoteAccessibilityInputConnection, int i10) throws RemoteException;

    void updateSelection(int i10, int i11, int i12, int i13, int i14, int i15) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IAccessibilityInputMethodSession {
        @Override // com.android.internal.inputmethod.IAccessibilityInputMethodSession
        public void updateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) throws RemoteException {
        }

        @Override // com.android.internal.inputmethod.IAccessibilityInputMethodSession
        public void finishInput() throws RemoteException {
        }

        @Override // com.android.internal.inputmethod.IAccessibilityInputMethodSession
        public void finishSession() throws RemoteException {
        }

        @Override // com.android.internal.inputmethod.IAccessibilityInputMethodSession
        public void invalidateInput(EditorInfo editorInfo, IRemoteAccessibilityInputConnection connection, int sessionId) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IAccessibilityInputMethodSession {
        static final int TRANSACTION_finishInput = 2;
        static final int TRANSACTION_finishSession = 3;
        static final int TRANSACTION_invalidateInput = 4;
        static final int TRANSACTION_updateSelection = 1;

        public Stub() {
            attachInterface(this, IAccessibilityInputMethodSession.DESCRIPTOR);
        }

        public static IAccessibilityInputMethodSession asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IAccessibilityInputMethodSession.DESCRIPTOR);
            if (iin != null && (iin instanceof IAccessibilityInputMethodSession)) {
                return (IAccessibilityInputMethodSession) iin;
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
                    return "updateSelection";
                case 2:
                    return "finishInput";
                case 3:
                    return "finishSession";
                case 4:
                    return "invalidateInput";
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
                data.enforceInterface(IAccessibilityInputMethodSession.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IAccessibilityInputMethodSession.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            int _arg1 = data.readInt();
                            int _arg2 = data.readInt();
                            int _arg3 = data.readInt();
                            int _arg4 = data.readInt();
                            int _arg5 = data.readInt();
                            data.enforceNoDataAvail();
                            updateSelection(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                            return true;
                        case 2:
                            finishInput();
                            return true;
                        case 3:
                            finishSession();
                            return true;
                        case 4:
                            EditorInfo _arg02 = (EditorInfo) data.readTypedObject(EditorInfo.CREATOR);
                            IRemoteAccessibilityInputConnection _arg12 = IRemoteAccessibilityInputConnection.Stub.asInterface(data.readStrongBinder());
                            int _arg22 = data.readInt();
                            data.enforceNoDataAvail();
                            invalidateInput(_arg02, _arg12, _arg22);
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
        private static class Proxy implements IAccessibilityInputMethodSession {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAccessibilityInputMethodSession.DESCRIPTOR;
            }

            @Override // com.android.internal.inputmethod.IAccessibilityInputMethodSession
            public void updateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IAccessibilityInputMethodSession.DESCRIPTOR);
                    _data.writeInt(oldSelStart);
                    _data.writeInt(oldSelEnd);
                    _data.writeInt(newSelStart);
                    _data.writeInt(newSelEnd);
                    _data.writeInt(candidatesStart);
                    _data.writeInt(candidatesEnd);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.android.internal.inputmethod.IAccessibilityInputMethodSession
            public void finishInput() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IAccessibilityInputMethodSession.DESCRIPTOR);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.android.internal.inputmethod.IAccessibilityInputMethodSession
            public void finishSession() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IAccessibilityInputMethodSession.DESCRIPTOR);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.android.internal.inputmethod.IAccessibilityInputMethodSession
            public void invalidateInput(EditorInfo editorInfo, IRemoteAccessibilityInputConnection connection, int sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IAccessibilityInputMethodSession.DESCRIPTOR);
                    _data.writeTypedObject(editorInfo, 0);
                    _data.writeStrongInterface(connection);
                    _data.writeInt(sessionId);
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
