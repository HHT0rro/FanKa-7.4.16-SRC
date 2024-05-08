package android.view;

import android.content.ClipData;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.util.MergedConfiguration;
import android.view.IWindow;
import android.view.IWindowId;
import android.view.InsetsSourceControl;
import android.view.SurfaceControl;
import android.view.WindowManager;
import android.window.ClientWindowFrames;
import android.window.OnBackInvokedCallbackInfo;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IWindowSession extends IInterface {
    int addToDisplay(IWindow iWindow, WindowManager.LayoutParams layoutParams, int i10, int i11, int i12, InputChannel inputChannel, InsetsState insetsState, InsetsSourceControl.Array array, Rect rect, float[] fArr) throws RemoteException;

    int addToDisplayAsUser(IWindow iWindow, WindowManager.LayoutParams layoutParams, int i10, int i11, int i12, int i13, InputChannel inputChannel, InsetsState insetsState, InsetsSourceControl.Array array, Rect rect, float[] fArr) throws RemoteException;

    int addToDisplayWithoutInputChannel(IWindow iWindow, WindowManager.LayoutParams layoutParams, int i10, int i11, InsetsState insetsState, Rect rect, float[] fArr) throws RemoteException;

    void cancelDragAndDrop(IBinder iBinder, boolean z10) throws RemoteException;

    boolean cancelDraw(IWindow iWindow) throws RemoteException;

    void clearTouchableRegion(IWindow iWindow) throws RemoteException;

    void dragRecipientEntered(IWindow iWindow) throws RemoteException;

    void dragRecipientExited(IWindow iWindow) throws RemoteException;

    boolean dropForAccessibility(IWindow iWindow, int i10, int i11) throws RemoteException;

    void finishDrawing(IWindow iWindow, SurfaceControl.Transaction transaction, int i10) throws RemoteException;

    void finishMovingTask(IWindow iWindow) throws RemoteException;

    void generateDisplayHash(IWindow iWindow, Rect rect, String str, RemoteCallback remoteCallback) throws RemoteException;

    IWindowId getWindowId(IBinder iBinder) throws RemoteException;

    void grantEmbeddedWindowFocus(IWindow iWindow, IBinder iBinder, boolean z10) throws RemoteException;

    void grantInputChannel(int i10, SurfaceControl surfaceControl, IWindow iWindow, IBinder iBinder, int i11, int i12, int i13, int i14, IBinder iBinder2, IBinder iBinder3, String str, InputChannel inputChannel) throws RemoteException;

    void onRectangleOnScreenRequested(IBinder iBinder, Rect rect) throws RemoteException;

    boolean outOfMemory(IWindow iWindow) throws RemoteException;

    IBinder performDrag(IWindow iWindow, int i10, SurfaceControl surfaceControl, int i11, float f10, float f11, float f12, float f13, ClipData clipData) throws RemoteException;

    boolean performHapticFeedback(int i10, boolean z10) throws RemoteException;

    void performHapticFeedbackAsync(int i10, boolean z10) throws RemoteException;

    void pokeDrawLock(IBinder iBinder) throws RemoteException;

    int relayout(IWindow iWindow, WindowManager.LayoutParams layoutParams, int i10, int i11, int i12, int i13, int i14, int i15, ClientWindowFrames clientWindowFrames, MergedConfiguration mergedConfiguration, SurfaceControl surfaceControl, InsetsState insetsState, InsetsSourceControl.Array array, Bundle bundle) throws RemoteException;

    void relayoutAsync(IWindow iWindow, WindowManager.LayoutParams layoutParams, int i10, int i11, int i12, int i13, int i14, int i15) throws RemoteException;

    void remove(IWindow iWindow) throws RemoteException;

    void reportDropResult(IWindow iWindow, boolean z10) throws RemoteException;

    void reportKeepClearAreasChanged(IWindow iWindow, List<Rect> list, List<Rect> list2) throws RemoteException;

    void reportSystemGestureExclusionChanged(IWindow iWindow, List<Rect> list) throws RemoteException;

    Bundle sendWallpaperCommand(IBinder iBinder, String str, int i10, int i11, int i12, Bundle bundle, boolean z10) throws RemoteException;

    void setInsets(IWindow iWindow, int i10, Rect rect, Rect rect2, Region region) throws RemoteException;

    void setOnBackInvokedCallbackInfo(IWindow iWindow, OnBackInvokedCallbackInfo onBackInvokedCallbackInfo) throws RemoteException;

    void setRefreshRate(SurfaceControl surfaceControl, float f10, int i10, int i11, String str, String str2) throws RemoteException;

    void setShouldZoomOutWallpaper(IBinder iBinder, boolean z10) throws RemoteException;

    void setWallpaperDisplayOffset(IBinder iBinder, int i10, int i11) throws RemoteException;

    void setWallpaperPosition(IBinder iBinder, float f10, float f11, float f12, float f13) throws RemoteException;

    void setWallpaperZoomOut(IBinder iBinder, float f10) throws RemoteException;

    boolean startMovingTask(IWindow iWindow, float f10, float f11) throws RemoteException;

    boolean transferEmbeddedTouchFocusToHost(IWindow iWindow) throws RemoteException;

    void updateInputChannel(IBinder iBinder, int i10, SurfaceControl surfaceControl, int i11, int i12, int i13, Region region) throws RemoteException;

    void updatePointerIcon(IWindow iWindow) throws RemoteException;

    void updateRequestedVisibleTypes(IWindow iWindow, int i10) throws RemoteException;

    void updateTapExcludeRegion(IWindow iWindow, Region region) throws RemoteException;

    void wallpaperCommandComplete(IBinder iBinder, Bundle bundle) throws RemoteException;

    void wallpaperOffsetsComplete(IBinder iBinder) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Default implements IWindowSession {
        @Override // android.view.IWindowSession
        public int addToDisplay(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int layerStackId, int requestedVisibleTypes, InputChannel outInputChannel, InsetsState insetsState, InsetsSourceControl.Array activeControls, Rect attachedFrame, float[] sizeCompatScale) throws RemoteException {
            return 0;
        }

        @Override // android.view.IWindowSession
        public int addToDisplayAsUser(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int layerStackId, int userId, int requestedVisibleTypes, InputChannel outInputChannel, InsetsState insetsState, InsetsSourceControl.Array activeControls, Rect attachedFrame, float[] sizeCompatScale) throws RemoteException {
            return 0;
        }

        @Override // android.view.IWindowSession
        public int addToDisplayWithoutInputChannel(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int layerStackId, InsetsState insetsState, Rect attachedFrame, float[] sizeCompatScale) throws RemoteException {
            return 0;
        }

        @Override // android.view.IWindowSession
        public void remove(IWindow window) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public int relayout(IWindow window, WindowManager.LayoutParams attrs, int requestedWidth, int requestedHeight, int viewVisibility, int flags, int seq, int lastSyncSeqId, ClientWindowFrames outFrames, MergedConfiguration outMergedConfiguration, SurfaceControl outSurfaceControl, InsetsState insetsState, InsetsSourceControl.Array activeControls, Bundle bundle) throws RemoteException {
            return 0;
        }

        @Override // android.view.IWindowSession
        public void relayoutAsync(IWindow window, WindowManager.LayoutParams attrs, int requestedWidth, int requestedHeight, int viewVisibility, int flags, int seq, int lastSyncSeqId) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public boolean outOfMemory(IWindow window) throws RemoteException {
            return false;
        }

        @Override // android.view.IWindowSession
        public void setInsets(IWindow window, int touchableInsets, Rect contentInsets, Rect visibleInsets, Region touchableRegion) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void finishDrawing(IWindow window, SurfaceControl.Transaction postDrawTransaction, int seqId) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public boolean performHapticFeedback(int effectId, boolean always) throws RemoteException {
            return false;
        }

        @Override // android.view.IWindowSession
        public void performHapticFeedbackAsync(int effectId, boolean always) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public IBinder performDrag(IWindow window, int flags, SurfaceControl surface, int touchSource, float touchX, float touchY, float thumbCenterX, float thumbCenterY, ClipData data) throws RemoteException {
            return null;
        }

        @Override // android.view.IWindowSession
        public boolean dropForAccessibility(IWindow window, int x10, int y10) throws RemoteException {
            return false;
        }

        @Override // android.view.IWindowSession
        public void reportDropResult(IWindow window, boolean consumed) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void cancelDragAndDrop(IBinder dragToken, boolean skipAnimation) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void dragRecipientEntered(IWindow window) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void dragRecipientExited(IWindow window) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void setWallpaperPosition(IBinder windowToken, float x10, float y10, float xstep, float ystep) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void setWallpaperZoomOut(IBinder windowToken, float scale) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void setShouldZoomOutWallpaper(IBinder windowToken, boolean shouldZoom) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void wallpaperOffsetsComplete(IBinder window) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void setWallpaperDisplayOffset(IBinder windowToken, int x10, int y10) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public Bundle sendWallpaperCommand(IBinder window, String action, int x10, int y10, int z10, Bundle extras, boolean sync) throws RemoteException {
            return null;
        }

        @Override // android.view.IWindowSession
        public void wallpaperCommandComplete(IBinder window, Bundle result) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void onRectangleOnScreenRequested(IBinder token, Rect rectangle) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public IWindowId getWindowId(IBinder window) throws RemoteException {
            return null;
        }

        @Override // android.view.IWindowSession
        public void pokeDrawLock(IBinder window) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public boolean startMovingTask(IWindow window, float startX, float startY) throws RemoteException {
            return false;
        }

        @Override // android.view.IWindowSession
        public void finishMovingTask(IWindow window) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void updatePointerIcon(IWindow window) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void updateTapExcludeRegion(IWindow window, Region region) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void updateRequestedVisibleTypes(IWindow window, int requestedVisibleTypes) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void reportSystemGestureExclusionChanged(IWindow window, List<Rect> exclusionRects) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void reportKeepClearAreasChanged(IWindow window, List<Rect> restricted, List<Rect> unrestricted) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void grantInputChannel(int displayId, SurfaceControl surface, IWindow window, IBinder hostInputToken, int flags, int privateFlags, int inputFeatures, int type, IBinder windowToken, IBinder focusGrantToken, String inputHandleName, InputChannel outInputChannel) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void updateInputChannel(IBinder channelToken, int displayId, SurfaceControl surface, int flags, int privateFlags, int inputFeatures, Region region) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void grantEmbeddedWindowFocus(IWindow window, IBinder inputToken, boolean grantFocus) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void generateDisplayHash(IWindow window, Rect boundsInWindow, String hashAlgorithm, RemoteCallback callback) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void setOnBackInvokedCallbackInfo(IWindow window, OnBackInvokedCallbackInfo callbackInfo) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public void clearTouchableRegion(IWindow window) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public boolean cancelDraw(IWindow window) throws RemoteException {
            return false;
        }

        @Override // android.view.IWindowSession
        public void setRefreshRate(SurfaceControl sc2, float refreshRate, int mMSyncScenarioAction, int mMSyncScenarioType, String activityName, String packgeName) throws RemoteException {
        }

        @Override // android.view.IWindowSession
        public boolean transferEmbeddedTouchFocusToHost(IWindow embeddedWindow) throws RemoteException {
            return false;
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
    public static abstract class Stub extends Binder implements IWindowSession {
        public static final String DESCRIPTOR = "android.view.IWindowSession";
        static final int TRANSACTION_addToDisplay = 1;
        static final int TRANSACTION_addToDisplayAsUser = 2;
        static final int TRANSACTION_addToDisplayWithoutInputChannel = 3;
        static final int TRANSACTION_cancelDragAndDrop = 15;
        static final int TRANSACTION_cancelDraw = 41;
        static final int TRANSACTION_clearTouchableRegion = 40;
        static final int TRANSACTION_dragRecipientEntered = 16;
        static final int TRANSACTION_dragRecipientExited = 17;
        static final int TRANSACTION_dropForAccessibility = 13;
        static final int TRANSACTION_finishDrawing = 9;
        static final int TRANSACTION_finishMovingTask = 29;
        static final int TRANSACTION_generateDisplayHash = 38;
        static final int TRANSACTION_getWindowId = 26;
        static final int TRANSACTION_grantEmbeddedWindowFocus = 37;
        static final int TRANSACTION_grantInputChannel = 35;
        static final int TRANSACTION_onRectangleOnScreenRequested = 25;
        static final int TRANSACTION_outOfMemory = 7;
        static final int TRANSACTION_performDrag = 12;
        static final int TRANSACTION_performHapticFeedback = 10;
        static final int TRANSACTION_performHapticFeedbackAsync = 11;
        static final int TRANSACTION_pokeDrawLock = 27;
        static final int TRANSACTION_relayout = 5;
        static final int TRANSACTION_relayoutAsync = 6;
        static final int TRANSACTION_remove = 4;
        static final int TRANSACTION_reportDropResult = 14;
        static final int TRANSACTION_reportKeepClearAreasChanged = 34;
        static final int TRANSACTION_reportSystemGestureExclusionChanged = 33;
        static final int TRANSACTION_sendWallpaperCommand = 23;
        static final int TRANSACTION_setInsets = 8;
        static final int TRANSACTION_setOnBackInvokedCallbackInfo = 39;
        static final int TRANSACTION_setRefreshRate = 42;
        static final int TRANSACTION_setShouldZoomOutWallpaper = 20;
        static final int TRANSACTION_setWallpaperDisplayOffset = 22;
        static final int TRANSACTION_setWallpaperPosition = 18;
        static final int TRANSACTION_setWallpaperZoomOut = 19;
        static final int TRANSACTION_startMovingTask = 28;
        static final int TRANSACTION_transferEmbeddedTouchFocusToHost = 43;
        static final int TRANSACTION_updateInputChannel = 36;
        static final int TRANSACTION_updatePointerIcon = 30;
        static final int TRANSACTION_updateRequestedVisibleTypes = 32;
        static final int TRANSACTION_updateTapExcludeRegion = 31;
        static final int TRANSACTION_wallpaperCommandComplete = 24;
        static final int TRANSACTION_wallpaperOffsetsComplete = 21;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IWindowSession asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IWindowSession)) {
                return (IWindowSession) iin;
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
                    return "addToDisplay";
                case 2:
                    return "addToDisplayAsUser";
                case 3:
                    return "addToDisplayWithoutInputChannel";
                case 4:
                    return "remove";
                case 5:
                    return "relayout";
                case 6:
                    return "relayoutAsync";
                case 7:
                    return "outOfMemory";
                case 8:
                    return "setInsets";
                case 9:
                    return "finishDrawing";
                case 10:
                    return "performHapticFeedback";
                case 11:
                    return "performHapticFeedbackAsync";
                case 12:
                    return "performDrag";
                case 13:
                    return "dropForAccessibility";
                case 14:
                    return "reportDropResult";
                case 15:
                    return "cancelDragAndDrop";
                case 16:
                    return "dragRecipientEntered";
                case 17:
                    return "dragRecipientExited";
                case 18:
                    return "setWallpaperPosition";
                case 19:
                    return "setWallpaperZoomOut";
                case 20:
                    return "setShouldZoomOutWallpaper";
                case 21:
                    return "wallpaperOffsetsComplete";
                case 22:
                    return "setWallpaperDisplayOffset";
                case 23:
                    return "sendWallpaperCommand";
                case 24:
                    return "wallpaperCommandComplete";
                case 25:
                    return "onRectangleOnScreenRequested";
                case 26:
                    return "getWindowId";
                case 27:
                    return "pokeDrawLock";
                case 28:
                    return "startMovingTask";
                case 29:
                    return "finishMovingTask";
                case 30:
                    return "updatePointerIcon";
                case 31:
                    return "updateTapExcludeRegion";
                case 32:
                    return "updateRequestedVisibleTypes";
                case 33:
                    return "reportSystemGestureExclusionChanged";
                case 34:
                    return "reportKeepClearAreasChanged";
                case 35:
                    return "grantInputChannel";
                case 36:
                    return "updateInputChannel";
                case 37:
                    return "grantEmbeddedWindowFocus";
                case 38:
                    return "generateDisplayHash";
                case 39:
                    return "setOnBackInvokedCallbackInfo";
                case 40:
                    return "clearTouchableRegion";
                case 41:
                    return "cancelDraw";
                case 42:
                    return "setRefreshRate";
                case 43:
                    return "transferEmbeddedTouchFocusToHost";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            float[] _arg9;
            float[] _arg10;
            float[] _arg6;
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
                            IWindow _arg0 = IWindow.Stub.asInterface(data.readStrongBinder());
                            WindowManager.LayoutParams _arg1 = (WindowManager.LayoutParams) data.readTypedObject(WindowManager.LayoutParams.CREATOR);
                            int _arg2 = data.readInt();
                            int _arg3 = data.readInt();
                            int _arg4 = data.readInt();
                            InputChannel _arg5 = new InputChannel();
                            InsetsState _arg62 = new InsetsState();
                            InsetsSourceControl.Array _arg7 = new InsetsSourceControl.Array();
                            Rect _arg8 = new Rect();
                            int _arg9_length = data.readInt();
                            if (_arg9_length < 0) {
                                _arg9 = null;
                            } else {
                                float[] _arg92 = new float[_arg9_length];
                                _arg9 = _arg92;
                            }
                            data.enforceNoDataAvail();
                            float[] _arg93 = _arg9;
                            int _result = addToDisplay(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg62, _arg7, _arg8, _arg93);
                            reply.writeNoException();
                            reply.writeInt(_result);
                            reply.writeTypedObject(_arg5, 1);
                            reply.writeTypedObject(_arg62, 1);
                            reply.writeTypedObject(_arg7, 1);
                            reply.writeTypedObject(_arg8, 1);
                            reply.writeFloatArray(_arg93);
                            return true;
                        case 2:
                            IWindow _arg02 = IWindow.Stub.asInterface(data.readStrongBinder());
                            WindowManager.LayoutParams _arg12 = (WindowManager.LayoutParams) data.readTypedObject(WindowManager.LayoutParams.CREATOR);
                            int _arg22 = data.readInt();
                            int _arg32 = data.readInt();
                            int _arg42 = data.readInt();
                            int _arg52 = data.readInt();
                            InputChannel _arg63 = new InputChannel();
                            InsetsState _arg72 = new InsetsState();
                            InsetsSourceControl.Array _arg82 = new InsetsSourceControl.Array();
                            Rect _arg94 = new Rect();
                            int _arg10_length = data.readInt();
                            if (_arg10_length < 0) {
                                _arg10 = null;
                            } else {
                                float[] _arg102 = new float[_arg10_length];
                                _arg10 = _arg102;
                            }
                            data.enforceNoDataAvail();
                            float[] _arg103 = _arg10;
                            int _result2 = addToDisplayAsUser(_arg02, _arg12, _arg22, _arg32, _arg42, _arg52, _arg63, _arg72, _arg82, _arg94, _arg103);
                            reply.writeNoException();
                            reply.writeInt(_result2);
                            reply.writeTypedObject(_arg63, 1);
                            reply.writeTypedObject(_arg72, 1);
                            reply.writeTypedObject(_arg82, 1);
                            reply.writeTypedObject(_arg94, 1);
                            reply.writeFloatArray(_arg103);
                            return true;
                        case 3:
                            IWindow _arg03 = IWindow.Stub.asInterface(data.readStrongBinder());
                            WindowManager.LayoutParams _arg13 = (WindowManager.LayoutParams) data.readTypedObject(WindowManager.LayoutParams.CREATOR);
                            int _arg23 = data.readInt();
                            int _arg33 = data.readInt();
                            InsetsState _arg43 = new InsetsState();
                            Rect _arg53 = new Rect();
                            int _arg6_length = data.readInt();
                            if (_arg6_length < 0) {
                                _arg6 = null;
                            } else {
                                _arg6 = new float[_arg6_length];
                            }
                            data.enforceNoDataAvail();
                            float[] _arg64 = _arg6;
                            int _result3 = addToDisplayWithoutInputChannel(_arg03, _arg13, _arg23, _arg33, _arg43, _arg53, _arg64);
                            reply.writeNoException();
                            reply.writeInt(_result3);
                            reply.writeTypedObject(_arg43, 1);
                            reply.writeTypedObject(_arg53, 1);
                            reply.writeFloatArray(_arg64);
                            return true;
                        case 4:
                            IWindow _arg04 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            remove(_arg04);
                            reply.writeNoException();
                            return true;
                        case 5:
                            IWindow _arg05 = IWindow.Stub.asInterface(data.readStrongBinder());
                            WindowManager.LayoutParams _arg14 = (WindowManager.LayoutParams) data.readTypedObject(WindowManager.LayoutParams.CREATOR);
                            int _arg24 = data.readInt();
                            int _arg34 = data.readInt();
                            int _arg44 = data.readInt();
                            int _arg54 = data.readInt();
                            int _arg65 = data.readInt();
                            int _arg73 = data.readInt();
                            ClientWindowFrames _arg83 = new ClientWindowFrames();
                            MergedConfiguration _arg95 = new MergedConfiguration();
                            SurfaceControl _arg104 = new SurfaceControl();
                            InsetsState _arg11 = new InsetsState();
                            InsetsSourceControl.Array _arg122 = new InsetsSourceControl.Array();
                            Bundle _arg132 = new Bundle();
                            data.enforceNoDataAvail();
                            int _result4 = relayout(_arg05, _arg14, _arg24, _arg34, _arg44, _arg54, _arg65, _arg73, _arg83, _arg95, _arg104, _arg11, _arg122, _arg132);
                            reply.writeNoException();
                            reply.writeInt(_result4);
                            reply.writeTypedObject(_arg83, 1);
                            reply.writeTypedObject(_arg95, 1);
                            reply.writeTypedObject(_arg104, 1);
                            reply.writeTypedObject(_arg11, 1);
                            reply.writeTypedObject(_arg122, 1);
                            reply.writeTypedObject(_arg132, 1);
                            return true;
                        case 6:
                            IWindow _arg06 = IWindow.Stub.asInterface(data.readStrongBinder());
                            WindowManager.LayoutParams _arg15 = (WindowManager.LayoutParams) data.readTypedObject(WindowManager.LayoutParams.CREATOR);
                            int _arg25 = data.readInt();
                            int _arg35 = data.readInt();
                            int _arg45 = data.readInt();
                            int _arg55 = data.readInt();
                            int _arg66 = data.readInt();
                            int _arg74 = data.readInt();
                            data.enforceNoDataAvail();
                            relayoutAsync(_arg06, _arg15, _arg25, _arg35, _arg45, _arg55, _arg66, _arg74);
                            return true;
                        case 7:
                            IWindow _arg07 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            boolean _result5 = outOfMemory(_arg07);
                            reply.writeNoException();
                            reply.writeBoolean(_result5);
                            return true;
                        case 8:
                            IWindow _arg08 = IWindow.Stub.asInterface(data.readStrongBinder());
                            int _arg16 = data.readInt();
                            Rect _arg26 = (Rect) data.readTypedObject(Rect.CREATOR);
                            Rect _arg36 = (Rect) data.readTypedObject(Rect.CREATOR);
                            Region _arg46 = (Region) data.readTypedObject(Region.CREATOR);
                            data.enforceNoDataAvail();
                            setInsets(_arg08, _arg16, _arg26, _arg36, _arg46);
                            return true;
                        case 9:
                            IWindow _arg09 = IWindow.Stub.asInterface(data.readStrongBinder());
                            SurfaceControl.Transaction _arg17 = (SurfaceControl.Transaction) data.readTypedObject(SurfaceControl.Transaction.CREATOR);
                            int _arg27 = data.readInt();
                            data.enforceNoDataAvail();
                            finishDrawing(_arg09, _arg17, _arg27);
                            return true;
                        case 10:
                            int _arg010 = data.readInt();
                            boolean _arg18 = data.readBoolean();
                            data.enforceNoDataAvail();
                            boolean _result6 = performHapticFeedback(_arg010, _arg18);
                            reply.writeNoException();
                            reply.writeBoolean(_result6);
                            return true;
                        case 11:
                            int _arg011 = data.readInt();
                            boolean _arg19 = data.readBoolean();
                            data.enforceNoDataAvail();
                            performHapticFeedbackAsync(_arg011, _arg19);
                            return true;
                        case 12:
                            IWindow _arg012 = IWindow.Stub.asInterface(data.readStrongBinder());
                            int _arg110 = data.readInt();
                            SurfaceControl _arg28 = (SurfaceControl) data.readTypedObject(SurfaceControl.CREATOR);
                            int _arg37 = data.readInt();
                            float _arg47 = data.readFloat();
                            float _arg56 = data.readFloat();
                            float _arg67 = data.readFloat();
                            float _arg75 = data.readFloat();
                            ClipData _arg84 = (ClipData) data.readTypedObject(ClipData.CREATOR);
                            data.enforceNoDataAvail();
                            IBinder _result7 = performDrag(_arg012, _arg110, _arg28, _arg37, _arg47, _arg56, _arg67, _arg75, _arg84);
                            reply.writeNoException();
                            reply.writeStrongBinder(_result7);
                            return true;
                        case 13:
                            IWindow _arg013 = IWindow.Stub.asInterface(data.readStrongBinder());
                            int _arg111 = data.readInt();
                            int _arg29 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result8 = dropForAccessibility(_arg013, _arg111, _arg29);
                            reply.writeNoException();
                            reply.writeBoolean(_result8);
                            return true;
                        case 14:
                            IWindow _arg014 = IWindow.Stub.asInterface(data.readStrongBinder());
                            boolean _arg112 = data.readBoolean();
                            data.enforceNoDataAvail();
                            reportDropResult(_arg014, _arg112);
                            return true;
                        case 15:
                            IBinder _arg015 = data.readStrongBinder();
                            boolean _arg113 = data.readBoolean();
                            data.enforceNoDataAvail();
                            cancelDragAndDrop(_arg015, _arg113);
                            return true;
                        case 16:
                            IWindow _arg016 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            dragRecipientEntered(_arg016);
                            return true;
                        case 17:
                            IWindow _arg017 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            dragRecipientExited(_arg017);
                            return true;
                        case 18:
                            IBinder _arg018 = data.readStrongBinder();
                            float _arg114 = data.readFloat();
                            float _arg210 = data.readFloat();
                            float _arg38 = data.readFloat();
                            float _arg48 = data.readFloat();
                            data.enforceNoDataAvail();
                            setWallpaperPosition(_arg018, _arg114, _arg210, _arg38, _arg48);
                            return true;
                        case 19:
                            IBinder _arg019 = data.readStrongBinder();
                            float _arg115 = data.readFloat();
                            data.enforceNoDataAvail();
                            setWallpaperZoomOut(_arg019, _arg115);
                            return true;
                        case 20:
                            IBinder _arg020 = data.readStrongBinder();
                            boolean _arg116 = data.readBoolean();
                            data.enforceNoDataAvail();
                            setShouldZoomOutWallpaper(_arg020, _arg116);
                            return true;
                        case 21:
                            IBinder _arg021 = data.readStrongBinder();
                            data.enforceNoDataAvail();
                            wallpaperOffsetsComplete(_arg021);
                            return true;
                        case 22:
                            IBinder _arg022 = data.readStrongBinder();
                            int _arg117 = data.readInt();
                            int _arg211 = data.readInt();
                            data.enforceNoDataAvail();
                            setWallpaperDisplayOffset(_arg022, _arg117, _arg211);
                            return true;
                        case 23:
                            IBinder _arg023 = data.readStrongBinder();
                            String _arg118 = data.readString();
                            int _arg212 = data.readInt();
                            int _arg39 = data.readInt();
                            int _arg49 = data.readInt();
                            Bundle _arg57 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            boolean _arg68 = data.readBoolean();
                            data.enforceNoDataAvail();
                            Bundle _result9 = sendWallpaperCommand(_arg023, _arg118, _arg212, _arg39, _arg49, _arg57, _arg68);
                            reply.writeNoException();
                            reply.writeTypedObject(_result9, 1);
                            return true;
                        case 24:
                            IBinder _arg024 = data.readStrongBinder();
                            Bundle _arg119 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            data.enforceNoDataAvail();
                            wallpaperCommandComplete(_arg024, _arg119);
                            return true;
                        case 25:
                            IBinder _arg025 = data.readStrongBinder();
                            Rect _arg120 = (Rect) data.readTypedObject(Rect.CREATOR);
                            data.enforceNoDataAvail();
                            onRectangleOnScreenRequested(_arg025, _arg120);
                            return true;
                        case 26:
                            IBinder _arg026 = data.readStrongBinder();
                            data.enforceNoDataAvail();
                            IWindowId _result10 = getWindowId(_arg026);
                            reply.writeNoException();
                            reply.writeStrongInterface(_result10);
                            return true;
                        case 27:
                            IBinder _arg027 = data.readStrongBinder();
                            data.enforceNoDataAvail();
                            pokeDrawLock(_arg027);
                            reply.writeNoException();
                            return true;
                        case 28:
                            IWindow _arg028 = IWindow.Stub.asInterface(data.readStrongBinder());
                            float _arg121 = data.readFloat();
                            float _arg213 = data.readFloat();
                            data.enforceNoDataAvail();
                            boolean _result11 = startMovingTask(_arg028, _arg121, _arg213);
                            reply.writeNoException();
                            reply.writeBoolean(_result11);
                            return true;
                        case 29:
                            IWindow _arg029 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            finishMovingTask(_arg029);
                            return true;
                        case 30:
                            IWindow _arg030 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            updatePointerIcon(_arg030);
                            return true;
                        case 31:
                            IWindow _arg031 = IWindow.Stub.asInterface(data.readStrongBinder());
                            Region _arg123 = (Region) data.readTypedObject(Region.CREATOR);
                            data.enforceNoDataAvail();
                            updateTapExcludeRegion(_arg031, _arg123);
                            return true;
                        case 32:
                            IWindow _arg032 = IWindow.Stub.asInterface(data.readStrongBinder());
                            int _arg124 = data.readInt();
                            data.enforceNoDataAvail();
                            updateRequestedVisibleTypes(_arg032, _arg124);
                            return true;
                        case 33:
                            IWindow _arg033 = IWindow.Stub.asInterface(data.readStrongBinder());
                            List<Rect> _arg125 = data.createTypedArrayList(Rect.CREATOR);
                            data.enforceNoDataAvail();
                            reportSystemGestureExclusionChanged(_arg033, _arg125);
                            return true;
                        case 34:
                            IWindow _arg034 = IWindow.Stub.asInterface(data.readStrongBinder());
                            List<Rect> _arg126 = data.createTypedArrayList(Rect.CREATOR);
                            List<Rect> _arg214 = data.createTypedArrayList(Rect.CREATOR);
                            data.enforceNoDataAvail();
                            reportKeepClearAreasChanged(_arg034, _arg126, _arg214);
                            return true;
                        case 35:
                            int _arg035 = data.readInt();
                            SurfaceControl _arg127 = (SurfaceControl) data.readTypedObject(SurfaceControl.CREATOR);
                            IWindow _arg215 = IWindow.Stub.asInterface(data.readStrongBinder());
                            IBinder _arg310 = data.readStrongBinder();
                            int _arg410 = data.readInt();
                            int _arg58 = data.readInt();
                            int _arg69 = data.readInt();
                            int _arg76 = data.readInt();
                            IBinder _arg85 = data.readStrongBinder();
                            IBinder _arg96 = data.readStrongBinder();
                            String _arg105 = data.readString();
                            InputChannel _arg1110 = new InputChannel();
                            data.enforceNoDataAvail();
                            grantInputChannel(_arg035, _arg127, _arg215, _arg310, _arg410, _arg58, _arg69, _arg76, _arg85, _arg96, _arg105, _arg1110);
                            reply.writeNoException();
                            reply.writeTypedObject(_arg1110, 1);
                            return true;
                        case 36:
                            IBinder _arg036 = data.readStrongBinder();
                            int _arg128 = data.readInt();
                            SurfaceControl _arg216 = (SurfaceControl) data.readTypedObject(SurfaceControl.CREATOR);
                            int _arg311 = data.readInt();
                            int _arg411 = data.readInt();
                            int _arg59 = data.readInt();
                            Region _arg610 = (Region) data.readTypedObject(Region.CREATOR);
                            data.enforceNoDataAvail();
                            updateInputChannel(_arg036, _arg128, _arg216, _arg311, _arg411, _arg59, _arg610);
                            return true;
                        case 37:
                            IWindow _arg037 = IWindow.Stub.asInterface(data.readStrongBinder());
                            IBinder _arg129 = data.readStrongBinder();
                            boolean _arg217 = data.readBoolean();
                            data.enforceNoDataAvail();
                            grantEmbeddedWindowFocus(_arg037, _arg129, _arg217);
                            reply.writeNoException();
                            return true;
                        case 38:
                            IWindow _arg038 = IWindow.Stub.asInterface(data.readStrongBinder());
                            Rect _arg130 = (Rect) data.readTypedObject(Rect.CREATOR);
                            String _arg218 = data.readString();
                            RemoteCallback _arg312 = (RemoteCallback) data.readTypedObject(RemoteCallback.CREATOR);
                            data.enforceNoDataAvail();
                            generateDisplayHash(_arg038, _arg130, _arg218, _arg312);
                            return true;
                        case 39:
                            IWindow _arg039 = IWindow.Stub.asInterface(data.readStrongBinder());
                            OnBackInvokedCallbackInfo _arg131 = (OnBackInvokedCallbackInfo) data.readTypedObject(OnBackInvokedCallbackInfo.CREATOR);
                            data.enforceNoDataAvail();
                            setOnBackInvokedCallbackInfo(_arg039, _arg131);
                            return true;
                        case 40:
                            IWindow _arg040 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            clearTouchableRegion(_arg040);
                            reply.writeNoException();
                            return true;
                        case 41:
                            IWindow _arg041 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            boolean _result12 = cancelDraw(_arg041);
                            reply.writeNoException();
                            reply.writeBoolean(_result12);
                            return true;
                        case 42:
                            SurfaceControl _arg042 = (SurfaceControl) data.readTypedObject(SurfaceControl.CREATOR);
                            float _arg133 = data.readFloat();
                            int _arg219 = data.readInt();
                            int _arg313 = data.readInt();
                            String _arg412 = data.readString();
                            String _arg510 = data.readString();
                            data.enforceNoDataAvail();
                            setRefreshRate(_arg042, _arg133, _arg219, _arg313, _arg412, _arg510);
                            return true;
                        case 43:
                            IWindow _arg043 = IWindow.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            boolean _result13 = transferEmbeddedTouchFocusToHost(_arg043);
                            reply.writeNoException();
                            reply.writeBoolean(_result13);
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
        public static class Proxy implements IWindowSession {
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

            @Override // android.view.IWindowSession
            public int addToDisplay(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int layerStackId, int requestedVisibleTypes, InputChannel outInputChannel, InsetsState insetsState, InsetsSourceControl.Array activeControls, Rect attachedFrame, float[] sizeCompatScale) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedObject(attrs, 0);
                    _data.writeInt(viewVisibility);
                    _data.writeInt(layerStackId);
                    _data.writeInt(requestedVisibleTypes);
                    _data.writeInt(sizeCompatScale.length);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    if (_reply.readInt() != 0) {
                        outInputChannel.readFromParcel(_reply);
                    }
                    if (_reply.readInt() != 0) {
                        insetsState.readFromParcel(_reply);
                    }
                    if (_reply.readInt() != 0) {
                        activeControls.readFromParcel(_reply);
                    }
                    if (_reply.readInt() != 0) {
                        attachedFrame.readFromParcel(_reply);
                    }
                    _reply.readFloatArray(sizeCompatScale);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public int addToDisplayAsUser(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int layerStackId, int userId, int requestedVisibleTypes, InputChannel outInputChannel, InsetsState insetsState, InsetsSourceControl.Array activeControls, Rect attachedFrame, float[] sizeCompatScale) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    _data.writeStrongInterface(window);
                } catch (Throwable th2) {
                    th = th2;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
                try {
                    _data.writeTypedObject(attrs, 0);
                    try {
                        _data.writeInt(viewVisibility);
                    } catch (Throwable th3) {
                        th = th3;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeInt(layerStackId);
                    } catch (Throwable th4) {
                        th = th4;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeInt(userId);
                        try {
                            _data.writeInt(requestedVisibleTypes);
                            _data.writeInt(sizeCompatScale.length);
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
                try {
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    if (_reply.readInt() != 0) {
                        try {
                            outInputChannel.readFromParcel(_reply);
                        } catch (Throwable th8) {
                            th = th8;
                            _reply.recycle();
                            _data.recycle();
                            throw th;
                        }
                    }
                    if (_reply.readInt() != 0) {
                        try {
                            insetsState.readFromParcel(_reply);
                        } catch (Throwable th9) {
                            th = th9;
                            _reply.recycle();
                            _data.recycle();
                            throw th;
                        }
                    }
                    if (_reply.readInt() != 0) {
                        try {
                            activeControls.readFromParcel(_reply);
                        } catch (Throwable th10) {
                            th = th10;
                            _reply.recycle();
                            _data.recycle();
                            throw th;
                        }
                    }
                    if (_reply.readInt() != 0) {
                        try {
                            attachedFrame.readFromParcel(_reply);
                        } catch (Throwable th11) {
                            th = th11;
                            _reply.recycle();
                            _data.recycle();
                            throw th;
                        }
                    }
                    _reply.readFloatArray(sizeCompatScale);
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th12) {
                    th = th12;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
            }

            @Override // android.view.IWindowSession
            public int addToDisplayWithoutInputChannel(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int layerStackId, InsetsState insetsState, Rect attachedFrame, float[] sizeCompatScale) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedObject(attrs, 0);
                    _data.writeInt(viewVisibility);
                    _data.writeInt(layerStackId);
                    _data.writeInt(sizeCompatScale.length);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    if (_reply.readInt() != 0) {
                        insetsState.readFromParcel(_reply);
                    }
                    if (_reply.readInt() != 0) {
                        attachedFrame.readFromParcel(_reply);
                    }
                    _reply.readFloatArray(sizeCompatScale);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void remove(IWindow window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public int relayout(IWindow window, WindowManager.LayoutParams attrs, int requestedWidth, int requestedHeight, int viewVisibility, int flags, int seq, int lastSyncSeqId, ClientWindowFrames outFrames, MergedConfiguration outMergedConfiguration, SurfaceControl outSurfaceControl, InsetsState insetsState, InsetsSourceControl.Array activeControls, Bundle bundle) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    _data.writeTypedObject(attrs, 0);
                } catch (Throwable th2) {
                    th = th2;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
                try {
                    _data.writeInt(requestedWidth);
                } catch (Throwable th3) {
                    th = th3;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
                try {
                    _data.writeInt(requestedHeight);
                    try {
                        _data.writeInt(viewVisibility);
                    } catch (Throwable th4) {
                        th = th4;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeInt(flags);
                    } catch (Throwable th5) {
                        th = th5;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeInt(seq);
                        try {
                            _data.writeInt(lastSyncSeqId);
                            try {
                                this.mRemote.transact(5, _data, _reply, 0);
                                _reply.readException();
                                int _result = _reply.readInt();
                                if (_reply.readInt() != 0) {
                                    try {
                                        outFrames.readFromParcel(_reply);
                                    } catch (Throwable th6) {
                                        th = th6;
                                        _reply.recycle();
                                        _data.recycle();
                                        throw th;
                                    }
                                }
                                if (_reply.readInt() != 0) {
                                    try {
                                        outMergedConfiguration.readFromParcel(_reply);
                                    } catch (Throwable th7) {
                                        th = th7;
                                        _reply.recycle();
                                        _data.recycle();
                                        throw th;
                                    }
                                }
                                if (_reply.readInt() != 0) {
                                    try {
                                        outSurfaceControl.readFromParcel(_reply);
                                    } catch (Throwable th8) {
                                        th = th8;
                                        _reply.recycle();
                                        _data.recycle();
                                        throw th;
                                    }
                                }
                                if (_reply.readInt() != 0) {
                                    insetsState.readFromParcel(_reply);
                                }
                                if (_reply.readInt() != 0) {
                                    activeControls.readFromParcel(_reply);
                                }
                                if (_reply.readInt() != 0) {
                                    try {
                                        bundle.readFromParcel(_reply);
                                    } catch (Throwable th9) {
                                        th = th9;
                                        _reply.recycle();
                                        _data.recycle();
                                        throw th;
                                    }
                                }
                                _reply.recycle();
                                _data.recycle();
                                return _result;
                            } catch (Throwable th10) {
                                th = th10;
                                _reply.recycle();
                                _data.recycle();
                                throw th;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                } catch (Throwable th13) {
                    th = th13;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
            }

            @Override // android.view.IWindowSession
            public void relayoutAsync(IWindow window, WindowManager.LayoutParams attrs, int requestedWidth, int requestedHeight, int viewVisibility, int flags, int seq, int lastSyncSeqId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedObject(attrs, 0);
                    _data.writeInt(requestedWidth);
                    _data.writeInt(requestedHeight);
                    _data.writeInt(viewVisibility);
                    _data.writeInt(flags);
                    _data.writeInt(seq);
                    _data.writeInt(lastSyncSeqId);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public boolean outOfMemory(IWindow window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void setInsets(IWindow window, int touchableInsets, Rect contentInsets, Rect visibleInsets, Region touchableRegion) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeInt(touchableInsets);
                    _data.writeTypedObject(contentInsets, 0);
                    _data.writeTypedObject(visibleInsets, 0);
                    _data.writeTypedObject(touchableRegion, 0);
                    this.mRemote.transact(8, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void finishDrawing(IWindow window, SurfaceControl.Transaction postDrawTransaction, int seqId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedObject(postDrawTransaction, 0);
                    _data.writeInt(seqId);
                    this.mRemote.transact(9, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public boolean performHapticFeedback(int effectId, boolean always) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(effectId);
                    _data.writeBoolean(always);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void performHapticFeedbackAsync(int effectId, boolean always) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(effectId);
                    _data.writeBoolean(always);
                    this.mRemote.transact(11, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public IBinder performDrag(IWindow window, int flags, SurfaceControl surface, int touchSource, float touchX, float touchY, float thumbCenterX, float thumbCenterY, ClipData data) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeInt(flags);
                    _data.writeTypedObject(surface, 0);
                    _data.writeInt(touchSource);
                    _data.writeFloat(touchX);
                    _data.writeFloat(touchY);
                    _data.writeFloat(thumbCenterX);
                    _data.writeFloat(thumbCenterY);
                    _data.writeTypedObject(data, 0);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    IBinder _result = _reply.readStrongBinder();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public boolean dropForAccessibility(IWindow window, int x10, int y10) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeInt(x10);
                    _data.writeInt(y10);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void reportDropResult(IWindow window, boolean consumed) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeBoolean(consumed);
                    this.mRemote.transact(14, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void cancelDragAndDrop(IBinder dragToken, boolean skipAnimation) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(dragToken);
                    _data.writeBoolean(skipAnimation);
                    this.mRemote.transact(15, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void dragRecipientEntered(IWindow window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    this.mRemote.transact(16, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void dragRecipientExited(IWindow window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    this.mRemote.transact(17, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void setWallpaperPosition(IBinder windowToken, float x10, float y10, float xstep, float ystep) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(windowToken);
                    _data.writeFloat(x10);
                    _data.writeFloat(y10);
                    _data.writeFloat(xstep);
                    _data.writeFloat(ystep);
                    this.mRemote.transact(18, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void setWallpaperZoomOut(IBinder windowToken, float scale) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(windowToken);
                    _data.writeFloat(scale);
                    this.mRemote.transact(19, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void setShouldZoomOutWallpaper(IBinder windowToken, boolean shouldZoom) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(windowToken);
                    _data.writeBoolean(shouldZoom);
                    this.mRemote.transact(20, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void wallpaperOffsetsComplete(IBinder window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(window);
                    this.mRemote.transact(21, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void setWallpaperDisplayOffset(IBinder windowToken, int x10, int y10) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(windowToken);
                    _data.writeInt(x10);
                    _data.writeInt(y10);
                    this.mRemote.transact(22, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public Bundle sendWallpaperCommand(IBinder window, String action, int x10, int y10, int z10, Bundle extras, boolean sync) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(window);
                    _data.writeString(action);
                    _data.writeInt(x10);
                    _data.writeInt(y10);
                    _data.writeInt(z10);
                    _data.writeTypedObject(extras, 0);
                    _data.writeBoolean(sync);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _reply.readTypedObject(Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void wallpaperCommandComplete(IBinder window, Bundle result) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(window);
                    _data.writeTypedObject(result, 0);
                    this.mRemote.transact(24, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void onRectangleOnScreenRequested(IBinder token, Rect rectangle) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeTypedObject(rectangle, 0);
                    this.mRemote.transact(25, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public IWindowId getWindowId(IBinder window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(window);
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                    IWindowId _result = IWindowId.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void pokeDrawLock(IBinder window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(window);
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public boolean startMovingTask(IWindow window, float startX, float startY) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeFloat(startX);
                    _data.writeFloat(startY);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void finishMovingTask(IWindow window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    this.mRemote.transact(29, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void updatePointerIcon(IWindow window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    this.mRemote.transact(30, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void updateTapExcludeRegion(IWindow window, Region region) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedObject(region, 0);
                    this.mRemote.transact(31, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void updateRequestedVisibleTypes(IWindow window, int requestedVisibleTypes) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeInt(requestedVisibleTypes);
                    this.mRemote.transact(32, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void reportSystemGestureExclusionChanged(IWindow window, List<Rect> exclusionRects) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedList(exclusionRects, 0);
                    this.mRemote.transact(33, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void reportKeepClearAreasChanged(IWindow window, List<Rect> restricted, List<Rect> unrestricted) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedList(restricted, 0);
                    _data.writeTypedList(unrestricted, 0);
                    this.mRemote.transact(34, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void grantInputChannel(int displayId, SurfaceControl surface, IWindow window, IBinder hostInputToken, int flags, int privateFlags, int inputFeatures, int type, IBinder windowToken, IBinder focusGrantToken, String inputHandleName, InputChannel outInputChannel) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(displayId);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    _data.writeTypedObject(surface, 0);
                } catch (Throwable th2) {
                    th = th2;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
                try {
                    _data.writeStrongInterface(window);
                    try {
                        _data.writeStrongBinder(hostInputToken);
                    } catch (Throwable th3) {
                        th = th3;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeInt(flags);
                    } catch (Throwable th4) {
                        th = th4;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeInt(privateFlags);
                    } catch (Throwable th5) {
                        th = th5;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
                try {
                    _data.writeInt(inputFeatures);
                    try {
                        _data.writeInt(type);
                    } catch (Throwable th7) {
                        th = th7;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeStrongBinder(windowToken);
                    } catch (Throwable th8) {
                        th = th8;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                    try {
                        _data.writeStrongBinder(focusGrantToken);
                        try {
                            _data.writeString(inputHandleName);
                            try {
                                this.mRemote.transact(35, _data, _reply, 0);
                                _reply.readException();
                                if (_reply.readInt() != 0) {
                                    try {
                                        outInputChannel.readFromParcel(_reply);
                                    } catch (Throwable th9) {
                                        th = th9;
                                        _reply.recycle();
                                        _data.recycle();
                                        throw th;
                                    }
                                }
                                _reply.recycle();
                                _data.recycle();
                            } catch (Throwable th10) {
                                th = th10;
                                _reply.recycle();
                                _data.recycle();
                                throw th;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        _reply.recycle();
                        _data.recycle();
                        throw th;
                    }
                } catch (Throwable th13) {
                    th = th13;
                    _reply.recycle();
                    _data.recycle();
                    throw th;
                }
            }

            @Override // android.view.IWindowSession
            public void updateInputChannel(IBinder channelToken, int displayId, SurfaceControl surface, int flags, int privateFlags, int inputFeatures, Region region) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(channelToken);
                    _data.writeInt(displayId);
                    _data.writeTypedObject(surface, 0);
                    _data.writeInt(flags);
                    _data.writeInt(privateFlags);
                    _data.writeInt(inputFeatures);
                    _data.writeTypedObject(region, 0);
                    this.mRemote.transact(36, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void grantEmbeddedWindowFocus(IWindow window, IBinder inputToken, boolean grantFocus) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeStrongBinder(inputToken);
                    _data.writeBoolean(grantFocus);
                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void generateDisplayHash(IWindow window, Rect boundsInWindow, String hashAlgorithm, RemoteCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedObject(boundsInWindow, 0);
                    _data.writeString(hashAlgorithm);
                    _data.writeTypedObject(callback, 0);
                    this.mRemote.transact(38, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void setOnBackInvokedCallbackInfo(IWindow window, OnBackInvokedCallbackInfo callbackInfo) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    _data.writeTypedObject(callbackInfo, 0);
                    this.mRemote.transact(39, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void clearTouchableRegion(IWindow window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    this.mRemote.transact(40, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public boolean cancelDraw(IWindow window) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(window);
                    this.mRemote.transact(41, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public void setRefreshRate(SurfaceControl sc2, float refreshRate, int mMSyncScenarioAction, int mMSyncScenarioType, String activityName, String packgeName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedObject(sc2, 0);
                    _data.writeFloat(refreshRate);
                    _data.writeInt(mMSyncScenarioAction);
                    _data.writeInt(mMSyncScenarioType);
                    _data.writeString(activityName);
                    _data.writeString(packgeName);
                    this.mRemote.transact(42, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.view.IWindowSession
            public boolean transferEmbeddedTouchFocusToHost(IWindow embeddedWindow) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongInterface(embeddedWindow);
                    this.mRemote.transact(43, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 42;
        }
    }
}
