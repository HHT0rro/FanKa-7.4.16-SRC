package android.view;

import android.graphics.Rect;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.window.PictureInPictureSurfaceTransaction;
import android.window.TaskSnapshot;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IRecentsAnimationController extends IInterface {
    void animateNavigationBarToApp(long j10) throws RemoteException;

    void cleanupScreenshot() throws RemoteException;

    void detachNavigationBarFromApp(boolean z10) throws RemoteException;

    void enterZoomFromRecent(SurfaceControl surfaceControl, SurfaceControl surfaceControl2, Rect rect, Rect rect2, Bundle bundle) throws RemoteException;

    void finish(boolean z10, boolean z11) throws RemoteException;

    void finishPutt(int i10, int i11, Rect rect, int i12, Bundle bundle) throws RemoteException;

    void finishZoom(boolean z10, boolean z11, int i10, int i11, Rect rect, int i12, Bundle bundle) throws RemoteException;

    boolean removeTask(int i10) throws RemoteException;

    TaskSnapshot screenshotTask(int i10) throws RemoteException;

    void setAnimationTargetsBehindSystemBars(boolean z10) throws RemoteException;

    void setDeferCancelUntilNextTransition(boolean z10, boolean z11) throws RemoteException;

    void setFinishTaskTransaction(int i10, PictureInPictureSurfaceTransaction pictureInPictureSurfaceTransaction, SurfaceControl surfaceControl) throws RemoteException;

    void setInputConsumerEnabled(boolean z10) throws RemoteException;

    void setWillFinishToHome(boolean z10) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IRecentsAnimationController {
        @Override // android.view.IRecentsAnimationController
        public TaskSnapshot screenshotTask(int taskId) throws RemoteException {
            return null;
        }

        @Override // android.view.IRecentsAnimationController
        public void setFinishTaskTransaction(int taskId, PictureInPictureSurfaceTransaction finishTransaction, SurfaceControl overlay) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void finish(boolean moveHomeToTop, boolean sendUserLeaveHint) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void setInputConsumerEnabled(boolean enabled) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void setAnimationTargetsBehindSystemBars(boolean behindSystemBars) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void cleanupScreenshot() throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void setDeferCancelUntilNextTransition(boolean defer, boolean screenshot) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void setWillFinishToHome(boolean willFinishToHome) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public boolean removeTask(int taskId) throws RemoteException {
            return false;
        }

        @Override // android.view.IRecentsAnimationController
        public void detachNavigationBarFromApp(boolean moveHomeToTop) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void animateNavigationBarToApp(long duration) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void finishZoom(boolean moveHomeToTop, boolean sendUserLeaveHint, int taskId, int type, Rect rect, int orientation, Bundle bOptions) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void enterZoomFromRecent(SurfaceControl zoomRootLeash, SurfaceControl targetLeash, Rect windowCrop, Rect endRect, Bundle bOptions) throws RemoteException {
        }

        @Override // android.view.IRecentsAnimationController
        public void finishPutt(int type, int taskId, Rect rect, int orientation, Bundle bOptions) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IRecentsAnimationController {
        public static final String DESCRIPTOR = "android.view.IRecentsAnimationController";
        static final int TRANSACTION_animateNavigationBarToApp = 11;
        static final int TRANSACTION_cleanupScreenshot = 6;
        static final int TRANSACTION_detachNavigationBarFromApp = 10;
        static final int TRANSACTION_enterZoomFromRecent = 13;
        static final int TRANSACTION_finish = 3;
        static final int TRANSACTION_finishPutt = 14;
        static final int TRANSACTION_finishZoom = 12;
        static final int TRANSACTION_removeTask = 9;
        static final int TRANSACTION_screenshotTask = 1;
        static final int TRANSACTION_setAnimationTargetsBehindSystemBars = 5;
        static final int TRANSACTION_setDeferCancelUntilNextTransition = 7;
        static final int TRANSACTION_setFinishTaskTransaction = 2;
        static final int TRANSACTION_setInputConsumerEnabled = 4;
        static final int TRANSACTION_setWillFinishToHome = 8;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRecentsAnimationController asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IRecentsAnimationController)) {
                return (IRecentsAnimationController) iin;
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
                    return "screenshotTask";
                case 2:
                    return "setFinishTaskTransaction";
                case 3:
                    return "finish";
                case 4:
                    return "setInputConsumerEnabled";
                case 5:
                    return "setAnimationTargetsBehindSystemBars";
                case 6:
                    return "cleanupScreenshot";
                case 7:
                    return "setDeferCancelUntilNextTransition";
                case 8:
                    return "setWillFinishToHome";
                case 9:
                    return "removeTask";
                case 10:
                    return "detachNavigationBarFromApp";
                case 11:
                    return "animateNavigationBarToApp";
                case 12:
                    return "finishZoom";
                case 13:
                    return "enterZoomFromRecent";
                case 14:
                    return "finishPutt";
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
                            int _arg0 = data.readInt();
                            data.enforceNoDataAvail();
                            TaskSnapshot _result = screenshotTask(_arg0);
                            reply.writeNoException();
                            reply.writeTypedObject(_result, 1);
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            PictureInPictureSurfaceTransaction _arg1 = (PictureInPictureSurfaceTransaction) data.readTypedObject(PictureInPictureSurfaceTransaction.CREATOR);
                            SurfaceControl _arg2 = (SurfaceControl) data.readTypedObject(SurfaceControl.CREATOR);
                            data.enforceNoDataAvail();
                            setFinishTaskTransaction(_arg02, _arg1, _arg2);
                            reply.writeNoException();
                            return true;
                        case 3:
                            boolean _arg03 = data.readBoolean();
                            boolean _arg12 = data.readBoolean();
                            data.enforceNoDataAvail();
                            finish(_arg03, _arg12);
                            reply.writeNoException();
                            return true;
                        case 4:
                            boolean _arg04 = data.readBoolean();
                            data.enforceNoDataAvail();
                            setInputConsumerEnabled(_arg04);
                            reply.writeNoException();
                            return true;
                        case 5:
                            boolean _arg05 = data.readBoolean();
                            data.enforceNoDataAvail();
                            setAnimationTargetsBehindSystemBars(_arg05);
                            reply.writeNoException();
                            return true;
                        case 6:
                            cleanupScreenshot();
                            reply.writeNoException();
                            return true;
                        case 7:
                            boolean _arg06 = data.readBoolean();
                            boolean _arg13 = data.readBoolean();
                            data.enforceNoDataAvail();
                            setDeferCancelUntilNextTransition(_arg06, _arg13);
                            reply.writeNoException();
                            return true;
                        case 8:
                            boolean _arg07 = data.readBoolean();
                            data.enforceNoDataAvail();
                            setWillFinishToHome(_arg07);
                            reply.writeNoException();
                            return true;
                        case 9:
                            int _arg08 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result2 = removeTask(_arg08);
                            reply.writeNoException();
                            reply.writeBoolean(_result2);
                            return true;
                        case 10:
                            boolean _arg09 = data.readBoolean();
                            data.enforceNoDataAvail();
                            detachNavigationBarFromApp(_arg09);
                            reply.writeNoException();
                            return true;
                        case 11:
                            long _arg010 = data.readLong();
                            data.enforceNoDataAvail();
                            animateNavigationBarToApp(_arg010);
                            reply.writeNoException();
                            return true;
                        case 12:
                            boolean _arg011 = data.readBoolean();
                            boolean _arg14 = data.readBoolean();
                            int _arg22 = data.readInt();
                            int _arg3 = data.readInt();
                            Rect _arg4 = (Rect) data.readTypedObject(Rect.CREATOR);
                            int _arg5 = data.readInt();
                            Bundle _arg6 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            data.enforceNoDataAvail();
                            finishZoom(_arg011, _arg14, _arg22, _arg3, _arg4, _arg5, _arg6);
                            reply.writeNoException();
                            return true;
                        case 13:
                            SurfaceControl _arg012 = (SurfaceControl) data.readTypedObject(SurfaceControl.CREATOR);
                            SurfaceControl _arg15 = (SurfaceControl) data.readTypedObject(SurfaceControl.CREATOR);
                            Rect _arg23 = (Rect) data.readTypedObject(Rect.CREATOR);
                            Rect _arg32 = (Rect) data.readTypedObject(Rect.CREATOR);
                            Bundle _arg42 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            data.enforceNoDataAvail();
                            enterZoomFromRecent(_arg012, _arg15, _arg23, _arg32, _arg42);
                            return true;
                        case 14:
                            int _arg013 = data.readInt();
                            int _arg16 = data.readInt();
                            Rect _arg24 = (Rect) data.readTypedObject(Rect.CREATOR);
                            int _arg33 = data.readInt();
                            Bundle _arg43 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            data.enforceNoDataAvail();
                            finishPutt(_arg013, _arg16, _arg24, _arg33, _arg43);
                            reply.writeNoException();
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
        private static class Proxy implements IRecentsAnimationController {
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

            @Override // android.view.IRecentsAnimationController
            public TaskSnapshot screenshotTask(int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(taskId);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    TaskSnapshot _result = (TaskSnapshot) _reply.readTypedObject(TaskSnapshot.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void setFinishTaskTransaction(int taskId, PictureInPictureSurfaceTransaction finishTransaction, SurfaceControl overlay) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeTypedObject(finishTransaction, 0);
                    _data.writeTypedObject(overlay, 0);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void finish(boolean moveHomeToTop, boolean sendUserLeaveHint) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeBoolean(moveHomeToTop);
                    _data.writeBoolean(sendUserLeaveHint);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void setInputConsumerEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void setAnimationTargetsBehindSystemBars(boolean behindSystemBars) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeBoolean(behindSystemBars);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void cleanupScreenshot() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void setDeferCancelUntilNextTransition(boolean defer, boolean screenshot) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeBoolean(defer);
                    _data.writeBoolean(screenshot);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void setWillFinishToHome(boolean willFinishToHome) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeBoolean(willFinishToHome);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public boolean removeTask(int taskId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(taskId);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void detachNavigationBarFromApp(boolean moveHomeToTop) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeBoolean(moveHomeToTop);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void animateNavigationBarToApp(long duration) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(duration);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void finishZoom(boolean moveHomeToTop, boolean sendUserLeaveHint, int taskId, int type, Rect rect, int orientation, Bundle bOptions) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeBoolean(moveHomeToTop);
                    _data.writeBoolean(sendUserLeaveHint);
                    _data.writeInt(taskId);
                    _data.writeInt(type);
                    _data.writeTypedObject(rect, 0);
                    _data.writeInt(orientation);
                    _data.writeTypedObject(bOptions, 0);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void enterZoomFromRecent(SurfaceControl zoomRootLeash, SurfaceControl targetLeash, Rect windowCrop, Rect endRect, Bundle bOptions) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedObject(zoomRootLeash, 0);
                    _data.writeTypedObject(targetLeash, 0);
                    _data.writeTypedObject(windowCrop, 0);
                    _data.writeTypedObject(endRect, 0);
                    _data.writeTypedObject(bOptions, 0);
                    this.mRemote.transact(13, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IRecentsAnimationController
            public void finishPutt(int type, int taskId, Rect rect, int orientation, Bundle bOptions) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(taskId);
                    _data.writeTypedObject(rect, 0);
                    _data.writeInt(orientation);
                    _data.writeTypedObject(bOptions, 0);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 13;
        }
    }
}
