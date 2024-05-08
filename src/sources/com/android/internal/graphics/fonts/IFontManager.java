package com.android.internal.graphics.fonts;

import android.app.ActivityThread;
import android.graphics.fonts.FontUpdateRequest;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.PermissionEnforcer;
import android.os.RemoteException;
import android.text.FontConfig;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IFontManager extends IInterface {
    public static final String DESCRIPTOR = "com.android.internal.graphics.fonts.IFontManager";

    FontConfig getFontConfig() throws RemoteException;

    int updateFontFamily(List<FontUpdateRequest> list, int i10) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IFontManager {
        @Override // com.android.internal.graphics.fonts.IFontManager
        public FontConfig getFontConfig() throws RemoteException {
            return null;
        }

        @Override // com.android.internal.graphics.fonts.IFontManager
        public int updateFontFamily(List<FontUpdateRequest> request, int baseVersion) throws RemoteException {
            return 0;
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
    public static abstract class Stub extends Binder implements IFontManager {
        static final int TRANSACTION_getFontConfig = 1;
        static final int TRANSACTION_updateFontFamily = 2;
        private final PermissionEnforcer mEnforcer;

        public Stub(PermissionEnforcer enforcer) {
            attachInterface(this, IFontManager.DESCRIPTOR);
            if (enforcer == null) {
                throw new IllegalArgumentException("enforcer cannot be null");
            }
            this.mEnforcer = enforcer;
        }

        @Deprecated
        public Stub() {
            this(PermissionEnforcer.fromContext(ActivityThread.currentActivityThread().getSystemContext()));
        }

        public static IFontManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IFontManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IFontManager)) {
                return (IFontManager) iin;
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
                    return "getFontConfig";
                case 2:
                    return "updateFontFamily";
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
                data.enforceInterface(IFontManager.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IFontManager.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            FontConfig _result = getFontConfig();
                            reply.writeNoException();
                            reply.writeTypedObject(_result, 1);
                            return true;
                        case 2:
                            List<FontUpdateRequest> _arg0 = data.createTypedArrayList(FontUpdateRequest.CREATOR);
                            int _arg1 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result2 = updateFontFamily(_arg0, _arg1);
                            reply.writeNoException();
                            reply.writeInt(_result2);
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
        private static class Proxy implements IFontManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFontManager.DESCRIPTOR;
            }

            @Override // com.android.internal.graphics.fonts.IFontManager
            public FontConfig getFontConfig() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IFontManager.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    FontConfig _result = (FontConfig) _reply.readTypedObject(FontConfig.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.internal.graphics.fonts.IFontManager
            public int updateFontFamily(List<FontUpdateRequest> request, int baseVersion) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IFontManager.DESCRIPTOR);
                    _data.writeTypedList(request, 0);
                    _data.writeInt(baseVersion);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        protected void getFontConfig_enforcePermission() throws SecurityException {
            this.mEnforcer.enforcePermission("android.permission.UPDATE_FONTS", getCallingPid(), getCallingUid());
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
