package android.view;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.IDisplayChangeWindowCallback;
import android.window.DisplayAreaInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IDisplayChangeWindowController extends IInterface {
    public static final String DESCRIPTOR = "android.view.IDisplayChangeWindowController";

    void onDisplayChange(int i10, int i11, int i12, DisplayAreaInfo displayAreaInfo, IDisplayChangeWindowCallback iDisplayChangeWindowCallback) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IDisplayChangeWindowController {
        @Override // android.view.IDisplayChangeWindowController
        public void onDisplayChange(int displayId, int fromRotation, int toRotation, DisplayAreaInfo newDisplayAreaInfo, IDisplayChangeWindowCallback callback) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IDisplayChangeWindowController {
        static final int TRANSACTION_onDisplayChange = 1;

        public Stub() {
            attachInterface(this, IDisplayChangeWindowController.DESCRIPTOR);
        }

        public static IDisplayChangeWindowController asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IDisplayChangeWindowController.DESCRIPTOR);
            if (iin != null && (iin instanceof IDisplayChangeWindowController)) {
                return (IDisplayChangeWindowController) iin;
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
                    return "onDisplayChange";
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
                data.enforceInterface(IDisplayChangeWindowController.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IDisplayChangeWindowController.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            int _arg1 = data.readInt();
                            int _arg2 = data.readInt();
                            DisplayAreaInfo _arg3 = (DisplayAreaInfo) data.readTypedObject(DisplayAreaInfo.CREATOR);
                            IDisplayChangeWindowCallback _arg4 = IDisplayChangeWindowCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            onDisplayChange(_arg0, _arg1, _arg2, _arg3, _arg4);
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
        public static class Proxy implements IDisplayChangeWindowController {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDisplayChangeWindowController.DESCRIPTOR;
            }

            @Override // android.view.IDisplayChangeWindowController
            public void onDisplayChange(int displayId, int fromRotation, int toRotation, DisplayAreaInfo newDisplayAreaInfo, IDisplayChangeWindowCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IDisplayChangeWindowController.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(fromRotation);
                    _data.writeInt(toRotation);
                    _data.writeTypedObject(newDisplayAreaInfo, 0);
                    _data.writeStrongInterface(callback);
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
