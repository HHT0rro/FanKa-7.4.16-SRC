package android.view.contentcapture;

import android.content.ContentCaptureOptions;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IContentCaptureOptionsCallback extends IInterface {
    public static final String DESCRIPTOR = "android.view.contentcapture.IContentCaptureOptionsCallback";

    void setContentCaptureOptions(ContentCaptureOptions contentCaptureOptions) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IContentCaptureOptionsCallback {
        @Override // android.view.contentcapture.IContentCaptureOptionsCallback
        public void setContentCaptureOptions(ContentCaptureOptions options) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IContentCaptureOptionsCallback {
        static final int TRANSACTION_setContentCaptureOptions = 1;

        public Stub() {
            attachInterface(this, IContentCaptureOptionsCallback.DESCRIPTOR);
        }

        public static IContentCaptureOptionsCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IContentCaptureOptionsCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IContentCaptureOptionsCallback)) {
                return (IContentCaptureOptionsCallback) iin;
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
                    return "setContentCaptureOptions";
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
                data.enforceInterface(IContentCaptureOptionsCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IContentCaptureOptionsCallback.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            ContentCaptureOptions _arg0 = (ContentCaptureOptions) data.readTypedObject(ContentCaptureOptions.CREATOR);
                            data.enforceNoDataAvail();
                            setContentCaptureOptions(_arg0);
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
        private static class Proxy implements IContentCaptureOptionsCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IContentCaptureOptionsCallback.DESCRIPTOR;
            }

            @Override // android.view.contentcapture.IContentCaptureOptionsCallback
            public void setContentCaptureOptions(ContentCaptureOptions options) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(IContentCaptureOptionsCallback.DESCRIPTOR);
                    _data.writeTypedObject(options, 0);
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
