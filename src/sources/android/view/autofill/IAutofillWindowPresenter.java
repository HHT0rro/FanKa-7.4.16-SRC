package android.view.autofill;

import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.WindowManager;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IAutofillWindowPresenter extends IInterface {
    void hide(Rect rect) throws RemoteException;

    void show(WindowManager.LayoutParams layoutParams, Rect rect, boolean z10, int i10) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IAutofillWindowPresenter {
        @Override // android.view.autofill.IAutofillWindowPresenter
        public void show(WindowManager.LayoutParams p10, Rect transitionEpicenter, boolean fitsSystemWindows, int layoutDirection) throws RemoteException {
        }

        @Override // android.view.autofill.IAutofillWindowPresenter
        public void hide(Rect transitionEpicenter) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IAutofillWindowPresenter {
        public static final String DESCRIPTOR = "android.view.autofill.IAutofillWindowPresenter";
        static final int TRANSACTION_hide = 2;
        static final int TRANSACTION_show = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAutofillWindowPresenter asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IAutofillWindowPresenter)) {
                return (IAutofillWindowPresenter) iin;
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
                    return "show";
                case 2:
                    return "hide";
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
                data.enforceInterface(DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            WindowManager.LayoutParams _arg0 = (WindowManager.LayoutParams) data.readTypedObject(WindowManager.LayoutParams.CREATOR);
                            Rect _arg1 = (Rect) data.readTypedObject(Rect.CREATOR);
                            boolean _arg2 = data.readBoolean();
                            int _arg3 = data.readInt();
                            data.enforceNoDataAvail();
                            show(_arg0, _arg1, _arg2, _arg3);
                            return true;
                        case 2:
                            Rect _arg02 = (Rect) data.readTypedObject(Rect.CREATOR);
                            data.enforceNoDataAvail();
                            hide(_arg02);
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
        public static class Proxy implements IAutofillWindowPresenter {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.view.autofill.IAutofillWindowPresenter
            public void show(WindowManager.LayoutParams p10, Rect transitionEpicenter, boolean fitsSystemWindows, int layoutDirection) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedObject(p10, 0);
                    _data.writeTypedObject(transitionEpicenter, 0);
                    _data.writeBoolean(fitsSystemWindows);
                    _data.writeInt(layoutDirection);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.autofill.IAutofillWindowPresenter
            public void hide(Rect transitionEpicenter) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedObject(transitionEpicenter, 0);
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
