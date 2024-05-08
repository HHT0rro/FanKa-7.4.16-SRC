package com.android.internal.backup;

import android.app.backup.IBackupManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IObbBackupService extends IInterface {
    void backupObbs(String str, ParcelFileDescriptor parcelFileDescriptor, int i10, IBackupManager iBackupManager) throws RemoteException;

    void restoreObbFile(String str, ParcelFileDescriptor parcelFileDescriptor, long j10, int i10, String str2, long j11, long j12, int i11, IBackupManager iBackupManager) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IObbBackupService {
        @Override // com.android.internal.backup.IObbBackupService
        public void backupObbs(String packageName, ParcelFileDescriptor data, int token, IBackupManager callbackBinder) throws RemoteException {
        }

        @Override // com.android.internal.backup.IObbBackupService
        public void restoreObbFile(String pkgName, ParcelFileDescriptor data, long fileSize, int type, String path, long mode, long mtime, int token, IBackupManager callbackBinder) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IObbBackupService {
        public static final String DESCRIPTOR = "com.android.internal.backup.IObbBackupService";
        static final int TRANSACTION_backupObbs = 1;
        static final int TRANSACTION_restoreObbFile = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IObbBackupService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IObbBackupService)) {
                return (IObbBackupService) iin;
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
                    return "backupObbs";
                case 2:
                    return "restoreObbFile";
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
                            String _arg0 = data.readString();
                            ParcelFileDescriptor _arg1 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
                            int _arg2 = data.readInt();
                            IBackupManager _arg3 = IBackupManager.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            backupObbs(_arg0, _arg1, _arg2, _arg3);
                            return true;
                        case 2:
                            String _arg02 = data.readString();
                            ParcelFileDescriptor _arg12 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
                            long _arg22 = data.readLong();
                            int _arg32 = data.readInt();
                            String _arg4 = data.readString();
                            long _arg5 = data.readLong();
                            long _arg6 = data.readLong();
                            int _arg7 = data.readInt();
                            IBackupManager _arg8 = IBackupManager.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            restoreObbFile(_arg02, _arg12, _arg22, _arg32, _arg4, _arg5, _arg6, _arg7, _arg8);
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
        private static class Proxy implements IObbBackupService {
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

            @Override // com.android.internal.backup.IObbBackupService
            public void backupObbs(String packageName, ParcelFileDescriptor data, int token, IBackupManager callbackBinder) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeTypedObject(data, 0);
                    _data.writeInt(token);
                    _data.writeStrongInterface(callbackBinder);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.android.internal.backup.IObbBackupService
            public void restoreObbFile(String pkgName, ParcelFileDescriptor data, long fileSize, int type, String path, long mode, long mtime, int token, IBackupManager callbackBinder) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeTypedObject(data, 0);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    _data.writeLong(fileSize);
                } catch (Throwable th2) {
                    th = th2;
                    _data.recycle();
                    throw th;
                }
                try {
                    _data.writeInt(type);
                    try {
                        _data.writeString(path);
                    } catch (Throwable th3) {
                        th = th3;
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeLong(mode);
                    } catch (Throwable th4) {
                        th = th4;
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeLong(mtime);
                    } catch (Throwable th5) {
                        th = th5;
                        _data.recycle();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    _data.recycle();
                    throw th;
                }
                try {
                    _data.writeInt(token);
                    try {
                        _data.writeStrongInterface(callbackBinder);
                    } catch (Throwable th7) {
                        th = th7;
                    }
                    try {
                        this.mRemote.transact(2, _data, null, 1);
                        _data.recycle();
                    } catch (Throwable th8) {
                        th = th8;
                        _data.recycle();
                        throw th;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    _data.recycle();
                    throw th;
                }
            }
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
