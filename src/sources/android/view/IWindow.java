package android.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.MergedConfiguration;
import android.view.IScrollCaptureResponseListener;
import android.view.inputmethod.ImeTracker;
import android.window.ClientWindowFrames;
import com.android.internal.os.IResultReceiver;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IWindow extends IInterface {
    void closeSystemDialogs(String str) throws RemoteException;

    void dispatchAppVisibility(boolean z10) throws RemoteException;

    void dispatchBlackScreenKeyEvent(KeyEvent keyEvent) throws RemoteException;

    void dispatchDragEvent(DragEvent dragEvent) throws RemoteException;

    void dispatchGetNewSurface() throws RemoteException;

    void dispatchWallpaperCommand(String str, int i10, int i11, int i12, Bundle bundle, boolean z10) throws RemoteException;

    void dispatchWallpaperOffsets(float f10, float f11, float f12, float f13, float f14, boolean z10) throws RemoteException;

    void dispatchWindowShown() throws RemoteException;

    void executeCommand(String str, String str2, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void hideInsets(int i10, boolean z10, ImeTracker.Token token) throws RemoteException;

    void insetsControlChanged(InsetsState insetsState, InsetsSourceControl[] insetsSourceControlArr) throws RemoteException;

    void moved(int i10, int i11) throws RemoteException;

    void requestAppKeyboardShortcuts(IResultReceiver iResultReceiver, int i10) throws RemoteException;

    void requestScrollCapture(IScrollCaptureResponseListener iScrollCaptureResponseListener) throws RemoteException;

    void resized(ClientWindowFrames clientWindowFrames, boolean z10, MergedConfiguration mergedConfiguration, InsetsState insetsState, boolean z11, boolean z12, int i10, int i11, boolean z13) throws RemoteException;

    void showInsets(int i10, boolean z10, ImeTracker.Token token) throws RemoteException;

    void updatePointerIcon(float f10, float f11) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IWindow {
        @Override // android.view.IWindow
        public void executeCommand(String command, String parameters, ParcelFileDescriptor descriptor) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void resized(ClientWindowFrames frames, boolean reportDraw, MergedConfiguration newMergedConfiguration, InsetsState insetsState, boolean forceLayout, boolean alwaysConsumeSystemBars, int displayId, int syncSeqId, boolean dragResizing) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void insetsControlChanged(InsetsState insetsState, InsetsSourceControl[] activeControls) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void showInsets(int types, boolean fromIme, ImeTracker.Token statsToken) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void hideInsets(int types, boolean fromIme, ImeTracker.Token statsToken) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void moved(int newX, int newY) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void dispatchAppVisibility(boolean visible) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void dispatchGetNewSurface() throws RemoteException {
        }

        @Override // android.view.IWindow
        public void closeSystemDialogs(String reason) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void dispatchWallpaperOffsets(float x10, float y10, float xStep, float yStep, float zoom, boolean sync) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void dispatchWallpaperCommand(String action, int x10, int y10, int z10, Bundle extras, boolean sync) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void dispatchDragEvent(DragEvent event) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void dispatchBlackScreenKeyEvent(KeyEvent event) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void updatePointerIcon(float x10, float y10) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void dispatchWindowShown() throws RemoteException {
        }

        @Override // android.view.IWindow
        public void requestAppKeyboardShortcuts(IResultReceiver receiver, int deviceId) throws RemoteException {
        }

        @Override // android.view.IWindow
        public void requestScrollCapture(IScrollCaptureResponseListener callbacks) throws RemoteException {
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
    public static abstract class Stub extends Binder implements IWindow {
        public static final String DESCRIPTOR = "android.view.IWindow";
        static final int TRANSACTION_closeSystemDialogs = 9;
        static final int TRANSACTION_dispatchAppVisibility = 7;
        static final int TRANSACTION_dispatchBlackScreenKeyEvent = 13;
        static final int TRANSACTION_dispatchDragEvent = 12;
        static final int TRANSACTION_dispatchGetNewSurface = 8;
        static final int TRANSACTION_dispatchWallpaperCommand = 11;
        static final int TRANSACTION_dispatchWallpaperOffsets = 10;
        static final int TRANSACTION_dispatchWindowShown = 15;
        static final int TRANSACTION_executeCommand = 1;
        static final int TRANSACTION_hideInsets = 5;
        static final int TRANSACTION_insetsControlChanged = 3;
        static final int TRANSACTION_moved = 6;
        static final int TRANSACTION_requestAppKeyboardShortcuts = 16;
        static final int TRANSACTION_requestScrollCapture = 17;
        static final int TRANSACTION_resized = 2;
        static final int TRANSACTION_showInsets = 4;
        static final int TRANSACTION_updatePointerIcon = 14;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IWindow asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IWindow)) {
                return (IWindow) iin;
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
                    return "executeCommand";
                case 2:
                    return "resized";
                case 3:
                    return "insetsControlChanged";
                case 4:
                    return "showInsets";
                case 5:
                    return "hideInsets";
                case 6:
                    return "moved";
                case 7:
                    return "dispatchAppVisibility";
                case 8:
                    return "dispatchGetNewSurface";
                case 9:
                    return "closeSystemDialogs";
                case 10:
                    return "dispatchWallpaperOffsets";
                case 11:
                    return "dispatchWallpaperCommand";
                case 12:
                    return "dispatchDragEvent";
                case 13:
                    return "dispatchBlackScreenKeyEvent";
                case 14:
                    return "updatePointerIcon";
                case 15:
                    return "dispatchWindowShown";
                case 16:
                    return "requestAppKeyboardShortcuts";
                case 17:
                    return "requestScrollCapture";
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
                            String _arg1 = data.readString();
                            ParcelFileDescriptor _arg2 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
                            data.enforceNoDataAvail();
                            executeCommand(_arg0, _arg1, _arg2);
                            return true;
                        case 2:
                            ClientWindowFrames _arg02 = (ClientWindowFrames) data.readTypedObject(ClientWindowFrames.CREATOR);
                            boolean _arg12 = data.readBoolean();
                            MergedConfiguration _arg22 = (MergedConfiguration) data.readTypedObject(MergedConfiguration.CREATOR);
                            InsetsState _arg3 = (InsetsState) data.readTypedObject(InsetsState.CREATOR);
                            boolean _arg4 = data.readBoolean();
                            boolean _arg5 = data.readBoolean();
                            int _arg6 = data.readInt();
                            int _arg7 = data.readInt();
                            boolean _arg8 = data.readBoolean();
                            data.enforceNoDataAvail();
                            resized(_arg02, _arg12, _arg22, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
                            return true;
                        case 3:
                            InsetsState _arg03 = (InsetsState) data.readTypedObject(InsetsState.CREATOR);
                            InsetsSourceControl[] _arg13 = (InsetsSourceControl[]) data.createTypedArray(InsetsSourceControl.CREATOR);
                            data.enforceNoDataAvail();
                            insetsControlChanged(_arg03, _arg13);
                            return true;
                        case 4:
                            int _arg04 = data.readInt();
                            boolean _arg14 = data.readBoolean();
                            ImeTracker.Token _arg23 = (ImeTracker.Token) data.readTypedObject(ImeTracker.Token.CREATOR);
                            data.enforceNoDataAvail();
                            showInsets(_arg04, _arg14, _arg23);
                            return true;
                        case 5:
                            int _arg05 = data.readInt();
                            boolean _arg15 = data.readBoolean();
                            ImeTracker.Token _arg24 = (ImeTracker.Token) data.readTypedObject(ImeTracker.Token.CREATOR);
                            data.enforceNoDataAvail();
                            hideInsets(_arg05, _arg15, _arg24);
                            return true;
                        case 6:
                            int _arg06 = data.readInt();
                            int _arg16 = data.readInt();
                            data.enforceNoDataAvail();
                            moved(_arg06, _arg16);
                            return true;
                        case 7:
                            boolean _arg07 = data.readBoolean();
                            data.enforceNoDataAvail();
                            dispatchAppVisibility(_arg07);
                            return true;
                        case 8:
                            dispatchGetNewSurface();
                            return true;
                        case 9:
                            String _arg08 = data.readString();
                            data.enforceNoDataAvail();
                            closeSystemDialogs(_arg08);
                            return true;
                        case 10:
                            float _arg09 = data.readFloat();
                            float _arg17 = data.readFloat();
                            float _arg25 = data.readFloat();
                            float _arg32 = data.readFloat();
                            float _arg42 = data.readFloat();
                            boolean _arg52 = data.readBoolean();
                            data.enforceNoDataAvail();
                            dispatchWallpaperOffsets(_arg09, _arg17, _arg25, _arg32, _arg42, _arg52);
                            return true;
                        case 11:
                            String _arg010 = data.readString();
                            int _arg18 = data.readInt();
                            int _arg26 = data.readInt();
                            int _arg33 = data.readInt();
                            Bundle _arg43 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            boolean _arg53 = data.readBoolean();
                            data.enforceNoDataAvail();
                            dispatchWallpaperCommand(_arg010, _arg18, _arg26, _arg33, _arg43, _arg53);
                            return true;
                        case 12:
                            DragEvent _arg011 = (DragEvent) data.readTypedObject(DragEvent.CREATOR);
                            data.enforceNoDataAvail();
                            dispatchDragEvent(_arg011);
                            return true;
                        case 13:
                            KeyEvent _arg012 = (KeyEvent) data.readTypedObject(KeyEvent.CREATOR);
                            data.enforceNoDataAvail();
                            dispatchBlackScreenKeyEvent(_arg012);
                            return true;
                        case 14:
                            float _arg013 = data.readFloat();
                            float _arg19 = data.readFloat();
                            data.enforceNoDataAvail();
                            updatePointerIcon(_arg013, _arg19);
                            return true;
                        case 15:
                            dispatchWindowShown();
                            return true;
                        case 16:
                            IResultReceiver _arg014 = IResultReceiver.Stub.asInterface(data.readStrongBinder());
                            int _arg110 = data.readInt();
                            data.enforceNoDataAvail();
                            requestAppKeyboardShortcuts(_arg014, _arg110);
                            return true;
                        case 17:
                            IScrollCaptureResponseListener _arg015 = IScrollCaptureResponseListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            requestScrollCapture(_arg015);
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
        public static class Proxy implements IWindow {
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

            @Override // android.view.IWindow
            public void executeCommand(String command, String parameters, ParcelFileDescriptor descriptor) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(command);
                    _data.writeString(parameters);
                    _data.writeTypedObject(descriptor, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void resized(ClientWindowFrames frames, boolean reportDraw, MergedConfiguration newMergedConfiguration, InsetsState insetsState, boolean forceLayout, boolean alwaysConsumeSystemBars, int displayId, int syncSeqId, boolean dragResizing) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedObject(frames, 0);
                    _data.writeBoolean(reportDraw);
                    _data.writeTypedObject(newMergedConfiguration, 0);
                    _data.writeTypedObject(insetsState, 0);
                    _data.writeBoolean(forceLayout);
                    _data.writeBoolean(alwaysConsumeSystemBars);
                    _data.writeInt(displayId);
                    _data.writeInt(syncSeqId);
                    _data.writeBoolean(dragResizing);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void insetsControlChanged(InsetsState insetsState, InsetsSourceControl[] activeControls) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedObject(insetsState, 0);
                    _data.writeTypedArray(activeControls, 0);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void showInsets(int types, boolean fromIme, ImeTracker.Token statsToken) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(types);
                    _data.writeBoolean(fromIme);
                    _data.writeTypedObject(statsToken, 0);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void hideInsets(int types, boolean fromIme, ImeTracker.Token statsToken) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(types);
                    _data.writeBoolean(fromIme);
                    _data.writeTypedObject(statsToken, 0);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void moved(int newX, int newY) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(newX);
                    _data.writeInt(newY);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void dispatchAppVisibility(boolean visible) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeBoolean(visible);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void dispatchGetNewSurface() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void closeSystemDialogs(String reason) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reason);
                    this.mRemote.transact(9, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void dispatchWallpaperOffsets(float x10, float y10, float xStep, float yStep, float zoom, boolean sync) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(x10);
                    _data.writeFloat(y10);
                    _data.writeFloat(xStep);
                    _data.writeFloat(yStep);
                    _data.writeFloat(zoom);
                    _data.writeBoolean(sync);
                    this.mRemote.transact(10, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void dispatchWallpaperCommand(String action, int x10, int y10, int z10, Bundle extras, boolean sync) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(action);
                    _data.writeInt(x10);
                    _data.writeInt(y10);
                    _data.writeInt(z10);
                    _data.writeTypedObject(extras, 0);
                    _data.writeBoolean(sync);
                    this.mRemote.transact(11, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void dispatchDragEvent(DragEvent event) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedObject(event, 0);
                    this.mRemote.transact(12, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void dispatchBlackScreenKeyEvent(KeyEvent event) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedObject(event, 0);
                    this.mRemote.transact(13, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void updatePointerIcon(float x10, float y10) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeFloat(x10);
                    _data.writeFloat(y10);
                    this.mRemote.transact(14, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void dispatchWindowShown() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(15, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void requestAppKeyboardShortcuts(IResultReceiver receiver, int deviceId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(receiver);
                    _data.writeInt(deviceId);
                    this.mRemote.transact(16, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindow
            public void requestScrollCapture(IScrollCaptureResponseListener callbacks) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(callbacks);
                    this.mRemote.transact(17, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 16;
        }
    }
}
