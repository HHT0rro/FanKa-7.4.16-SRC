package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface DownloadAidlTask extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Default implements DownloadAidlTask {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IChunkCntAidlCalculator getChunkStrategy() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlDepend getDepend() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i10) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadCompleteHandlerSize() throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public DownloadInfo getDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getDownloadListenerByIndex(int i10, int i11) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadListenerSize(int i10) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getSingleDownloadListener(int i10) throws RemoteException {
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class Stub extends Binder implements DownloadAidlTask {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.model.DownloadAidlTask";
        public static final int TRANSACTION_getChunkStrategy = 2;
        public static final int TRANSACTION_getDepend = 9;
        public static final int TRANSACTION_getDiskSpaceHandler = 12;
        public static final int TRANSACTION_getDownloadCompleteAidlHandlerByIndex = 16;
        public static final int TRANSACTION_getDownloadCompleteHandlerSize = 15;
        public static final int TRANSACTION_getDownloadInfo = 1;
        public static final int TRANSACTION_getDownloadListenerByIndex = 4;
        public static final int TRANSACTION_getDownloadListenerSize = 3;
        public static final int TRANSACTION_getDownloadNotificationEventListener = 6;
        public static final int TRANSACTION_getFileProvider = 14;
        public static final int TRANSACTION_getForbiddenHandler = 10;
        public static final int TRANSACTION_getInterceptor = 8;
        public static final int TRANSACTION_getMonitorDepend = 13;
        public static final int TRANSACTION_getNotificationClickCallback = 7;
        public static final int TRANSACTION_getRetryDelayTimeCalculator = 11;
        public static final int TRANSACTION_getSingleDownloadListener = 5;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class Proxy implements DownloadAidlTask {
            public static DownloadAidlTask sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IChunkCntAidlCalculator getChunkStrategy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getChunkStrategy();
                    }
                    obtain2.readException();
                    return IChunkCntAidlCalculator.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlDepend getDepend() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDepend();
                    }
                    obtain2.readException();
                    return IDownloadAidlDepend.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDiskSpaceHandler();
                    }
                    obtain2.readException();
                    return IDownloadDiskSpaceAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadCompleteAidlHandlerByIndex(i10);
                    }
                    obtain2.readException();
                    return IDownloadCompleteAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadCompleteHandlerSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadCompleteHandlerSize();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public DownloadInfo getDownloadInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfo();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getDownloadListenerByIndex(int i10, int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadListenerByIndex(i10, i11);
                    }
                    obtain2.readException();
                    return IDownloadAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadListenerSize(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadListenerSize(i10);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadNotificationEventListener();
                    }
                    obtain2.readException();
                    return IDownloadNotificationEventAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFileProvider();
                    }
                    obtain2.readException();
                    return IDownloadAidlFileProvider.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getForbiddenHandler();
                    }
                    obtain2.readException();
                    return IDownloadForbiddenAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInterceptor();
                    }
                    obtain2.readException();
                    return IDownloadAidlInterceptor.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMonitorDepend();
                    }
                    obtain2.readException();
                    return IDownloadAidlMonitorDepend.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNotificationClickCallback();
                    }
                    obtain2.readException();
                    return INotificationClickAidlCallback.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRetryDelayTimeCalculator();
                    }
                    obtain2.readException();
                    return IRetryDelayTimeAidlCalculator.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getSingleDownloadListener(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSingleDownloadListener(i10);
                    }
                    obtain2.readException();
                    return IDownloadAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static DownloadAidlTask asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof DownloadAidlTask)) {
                return (DownloadAidlTask) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static DownloadAidlTask getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(DownloadAidlTask downloadAidlTask) {
            if (Proxy.sDefaultImpl != null || downloadAidlTask == null) {
                return false;
            }
            Proxy.sDefaultImpl = downloadAidlTask;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        DownloadInfo downloadInfo = getDownloadInfo();
                        parcel2.writeNoException();
                        if (downloadInfo != null) {
                            parcel2.writeInt(1);
                            downloadInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        IChunkCntAidlCalculator chunkStrategy = getChunkStrategy();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(chunkStrategy != null ? chunkStrategy.asBinder() : null);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int downloadListenerSize = getDownloadListenerSize(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(downloadListenerSize);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadAidlListener downloadListenerByIndex = getDownloadListenerByIndex(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(downloadListenerByIndex != null ? downloadListenerByIndex.asBinder() : null);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadAidlListener singleDownloadListener = getSingleDownloadListener(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(singleDownloadListener != null ? singleDownloadListener.asBinder() : null);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadNotificationEventAidlListener downloadNotificationEventListener = getDownloadNotificationEventListener();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(downloadNotificationEventListener != null ? downloadNotificationEventListener.asBinder() : null);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        INotificationClickAidlCallback notificationClickCallback = getNotificationClickCallback();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(notificationClickCallback != null ? notificationClickCallback.asBinder() : null);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadAidlInterceptor interceptor = getInterceptor();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(interceptor != null ? interceptor.asBinder() : null);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadAidlDepend depend = getDepend();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(depend != null ? depend.asBinder() : null);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadForbiddenAidlHandler forbiddenHandler = getForbiddenHandler();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(forbiddenHandler != null ? forbiddenHandler.asBinder() : null);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        IRetryDelayTimeAidlCalculator retryDelayTimeCalculator = getRetryDelayTimeCalculator();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(retryDelayTimeCalculator != null ? retryDelayTimeCalculator.asBinder() : null);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadDiskSpaceAidlHandler diskSpaceHandler = getDiskSpaceHandler();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(diskSpaceHandler != null ? diskSpaceHandler.asBinder() : null);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadAidlMonitorDepend monitorDepend = getMonitorDepend();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(monitorDepend != null ? monitorDepend.asBinder() : null);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadAidlFileProvider fileProvider = getFileProvider();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(fileProvider != null ? fileProvider.asBinder() : null);
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        int downloadCompleteHandlerSize = getDownloadCompleteHandlerSize();
                        parcel2.writeNoException();
                        parcel2.writeInt(downloadCompleteHandlerSize);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        IDownloadCompleteAidlHandler downloadCompleteAidlHandlerByIndex = getDownloadCompleteAidlHandlerByIndex(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(downloadCompleteAidlHandlerByIndex != null ? downloadCompleteAidlHandlerByIndex.asBinder() : null);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    IChunkCntAidlCalculator getChunkStrategy() throws RemoteException;

    IDownloadAidlDepend getDepend() throws RemoteException;

    IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException;

    IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i10) throws RemoteException;

    int getDownloadCompleteHandlerSize() throws RemoteException;

    DownloadInfo getDownloadInfo() throws RemoteException;

    IDownloadAidlListener getDownloadListenerByIndex(int i10, int i11) throws RemoteException;

    int getDownloadListenerSize(int i10) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException;

    IDownloadAidlFileProvider getFileProvider() throws RemoteException;

    IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException;

    IDownloadAidlInterceptor getInterceptor() throws RemoteException;

    IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException;

    IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws RemoteException;

    IDownloadAidlListener getSingleDownloadListener(int i10) throws RemoteException;
}
