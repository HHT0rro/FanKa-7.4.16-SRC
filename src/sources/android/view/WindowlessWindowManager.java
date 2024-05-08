package android.view;

import android.content.ClipData;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.util.Log;
import android.util.MergedConfiguration;
import android.view.IWindowSession;
import android.view.InsetsSourceControl;
import android.view.SurfaceControl;
import android.view.WindowManager;
import android.window.ClientWindowFrames;
import android.window.OnBackInvokedCallbackInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WindowlessWindowManager implements IWindowSession {
    private static final String TAG = "WindowlessWindowManager";
    private final Configuration mConfiguration;
    private final IBinder mHostInputToken;
    private InsetsState mInsetsState;
    protected final SurfaceControl mRootSurface;
    final HashMap<IBinder, State> mStateForWindow = new HashMap<>();
    final HashMap<IBinder, ResizeCompleteCallback> mResizeCompletionForWindow = new HashMap<>();
    private final SurfaceSession mSurfaceSession = new SurfaceSession();
    private final IBinder mFocusGrantToken = new Binder();
    private final ClientWindowFrames mTmpFrames = new ClientWindowFrames();
    private final MergedConfiguration mTmpConfig = new MergedConfiguration();
    private final WindowlessWindowLayout mLayout = new WindowlessWindowLayout();
    private final IWindowSession mRealWm = WindowManagerGlobal.getWindowSession();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ResizeCompleteCallback {
        void finished(SurfaceControl.Transaction transaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class State {
        Rect mAttachedFrame;
        IWindow mClient;
        int mDisplayId;
        IBinder mFocusGrantToken;
        Rect mFrame;
        IBinder mInputChannelToken;
        Region mInputRegion;
        SurfaceControl mLeash;
        WindowManager.LayoutParams mParams;
        SurfaceControl mSurfaceControl;

        State(SurfaceControl sc2, WindowManager.LayoutParams p10, int displayId, IWindow client, SurfaceControl leash, Rect frame) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.mParams = layoutParams;
            this.mSurfaceControl = sc2;
            layoutParams.copyFrom(p10);
            this.mDisplayId = displayId;
            this.mClient = client;
            this.mLeash = leash;
            this.mFrame = frame;
        }
    }

    public WindowlessWindowManager(Configuration c4, SurfaceControl rootSurface, IBinder hostInputToken) {
        this.mRootSurface = rootSurface;
        this.mConfiguration = new Configuration(c4);
        this.mHostInputToken = hostInputToken;
    }

    public void setConfiguration(Configuration configuration) {
        this.mConfiguration.setTo(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder getFocusGrantToken(IBinder window) {
        synchronized (this) {
            if (this.mStateForWindow.isEmpty()) {
                return this.mFocusGrantToken;
            }
            State state = this.mStateForWindow.get(window);
            if (state != null) {
                return state.mFocusGrantToken;
            }
            Log.w(TAG, "Failed to get focusGrantToken. Returning null token");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCompletionCallback(IBinder window, ResizeCompleteCallback callback) {
        if (this.mResizeCompletionForWindow.get(window) != null) {
            Log.w(TAG, "Unsupported overlapping resizes");
        }
        this.mResizeCompletionForWindow.put(window, callback);
    }

    protected void setTouchRegion(IBinder window, Region region) {
        synchronized (this) {
            State state = this.mStateForWindow.get(window);
            if (state == null) {
                return;
            }
            if (Objects.equals(region, state.mInputRegion)) {
                return;
            }
            state.mInputRegion = region != null ? new Region(region) : null;
            if (state.mInputChannelToken != null) {
                try {
                    IWindowSession iWindowSession = this.mRealWm;
                    if (iWindowSession instanceof IWindowSession.Stub) {
                        iWindowSession.updateInputChannel(state.mInputChannelToken, state.mDisplayId, new SurfaceControl(state.mSurfaceControl, "WindowlessWindowManager.setTouchRegion"), state.mParams.flags, state.mParams.privateFlags, state.mParams.inputFeatures, state.mInputRegion);
                    } else {
                        iWindowSession.updateInputChannel(state.mInputChannelToken, state.mDisplayId, state.mSurfaceControl, state.mParams.flags, state.mParams.privateFlags, state.mParams.inputFeatures, state.mInputRegion);
                    }
                } catch (RemoteException e2) {
                    Log.e(TAG, "Failed to update surface input channel: ", e2);
                }
            }
        }
    }

    protected SurfaceControl getParentSurface(IWindow window, WindowManager.LayoutParams attrs) {
        synchronized (this) {
            if (this.mStateForWindow.isEmpty()) {
                return this.mRootSurface;
            }
            return this.mStateForWindow.get(attrs.token).mLeash;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0169 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x016c A[ORIG_RETURN, RETURN] */
    @Override // android.view.IWindowSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int addToDisplay(android.view.IWindow r30, android.view.WindowManager.LayoutParams r31, int r32, int r33, int r34, android.view.InputChannel r35, android.view.InsetsState r36, android.view.InsetsSourceControl.Array r37, android.graphics.Rect r38, float[] r39) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.WindowlessWindowManager.addToDisplay(android.view.IWindow, android.view.WindowManager$LayoutParams, int, int, int, android.view.InputChannel, android.view.InsetsState, android.view.InsetsSourceControl$Array, android.graphics.Rect, float[]):int");
    }

    @Override // android.view.IWindowSession
    public int addToDisplayAsUser(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int displayId, int userId, int requestedVisibleTypes, InputChannel outInputChannel, InsetsState outInsetsState, InsetsSourceControl.Array outActiveControls, Rect outAttachedFrame, float[] outSizeCompatScale) {
        return addToDisplay(window, attrs, viewVisibility, displayId, requestedVisibleTypes, outInputChannel, outInsetsState, outActiveControls, outAttachedFrame, outSizeCompatScale);
    }

    @Override // android.view.IWindowSession
    public int addToDisplayWithoutInputChannel(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int layerStackId, InsetsState insetsState, Rect outAttachedFrame, float[] outSizeCompatScale) {
        return 0;
    }

    @Override // android.view.IWindowSession
    public void remove(IWindow window) throws RemoteException {
        State state;
        this.mRealWm.remove(window);
        synchronized (this) {
            state = this.mStateForWindow.remove(window.asBinder());
        }
        if (state == null) {
            throw new IllegalArgumentException("Invalid window token (never added or removed already)");
        }
        removeSurface(state.mSurfaceControl);
        removeSurface(state.mLeash);
    }

    protected void removeSurface(SurfaceControl sc2) {
        SurfaceControl.Transaction t2 = new SurfaceControl.Transaction();
        try {
            t2.remove(sc2).apply();
            t2.close();
        } catch (Throwable th) {
            try {
                t2.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private boolean isOpaque(WindowManager.LayoutParams attrs) {
        if ((attrs.surfaceInsets != null && attrs.surfaceInsets.left != 0) || attrs.surfaceInsets.top != 0 || attrs.surfaceInsets.right != 0 || attrs.surfaceInsets.bottom != 0) {
            return false;
        }
        return !PixelFormat.formatHasAlpha(attrs.format);
    }

    private boolean isInTouchModeInternal(int displayId) {
        try {
            return WindowManagerGlobal.getWindowManagerService().isInTouchMode(displayId);
        } catch (RemoteException e2) {
            Log.e(TAG, "Unable to check if the window is in touch mode", e2);
            return false;
        }
    }

    protected IBinder getWindowBinder(View rootView) {
        ViewRootImpl root = rootView.getViewRootImpl();
        if (root == null) {
            return null;
        }
        return root.mWindow.asBinder();
    }

    protected SurfaceControl getSurfaceControl(View rootView) {
        ViewRootImpl root = rootView.getViewRootImpl();
        if (root == null) {
            return null;
        }
        return getSurfaceControl(root.mWindow);
    }

    protected SurfaceControl getSurfaceControl(IWindow window) {
        State s2 = this.mStateForWindow.get(window.asBinder());
        if (s2 == null) {
            return null;
        }
        return s2.mSurfaceControl;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // android.view.IWindowSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int relayout(android.view.IWindow r29, android.view.WindowManager.LayoutParams r30, int r31, int r32, int r33, int r34, int r35, int r36, android.window.ClientWindowFrames r37, android.util.MergedConfiguration r38, android.view.SurfaceControl r39, android.view.InsetsState r40, android.view.InsetsSourceControl.Array r41, android.os.Bundle r42) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.WindowlessWindowManager.relayout(android.view.IWindow, android.view.WindowManager$LayoutParams, int, int, int, int, int, int, android.window.ClientWindowFrames, android.util.MergedConfiguration, android.view.SurfaceControl, android.view.InsetsState, android.view.InsetsSourceControl$Array, android.os.Bundle):int");
    }

    @Override // android.view.IWindowSession
    public void relayoutAsync(IWindow window, WindowManager.LayoutParams inAttrs, int requestedWidth, int requestedHeight, int viewFlags, int flags, int seq, int lastSyncSeqId) {
        relayout(window, inAttrs, requestedWidth, requestedHeight, viewFlags, flags, seq, lastSyncSeqId, null, null, null, null, null, null);
    }

    @Override // android.view.IWindowSession
    public boolean outOfMemory(IWindow window) {
        return false;
    }

    @Override // android.view.IWindowSession
    public void setInsets(IWindow window, int touchableInsets, Rect contentInsets, Rect visibleInsets, Region touchableRegion) {
        setTouchRegion(window.asBinder(), touchableRegion);
    }

    @Override // android.view.IWindowSession
    public void clearTouchableRegion(IWindow window) {
        setTouchRegion(window.asBinder(), null);
    }

    @Override // android.view.IWindowSession
    public void finishDrawing(IWindow window, SurfaceControl.Transaction postDrawTransaction, int seqId) {
        synchronized (this) {
            ResizeCompleteCallback c4 = this.mResizeCompletionForWindow.get(window.asBinder());
            if (c4 == null) {
                postDrawTransaction.apply();
            } else {
                c4.finished(postDrawTransaction);
                this.mResizeCompletionForWindow.remove(window.asBinder());
            }
        }
    }

    @Override // android.view.IWindowSession
    public boolean performHapticFeedback(int effectId, boolean always) {
        return false;
    }

    @Override // android.view.IWindowSession
    public void performHapticFeedbackAsync(int effectId, boolean always) {
        performHapticFeedback(effectId, always);
    }

    @Override // android.view.IWindowSession
    public IBinder performDrag(IWindow window, int flags, SurfaceControl surface, int touchSource, float touchX, float touchY, float thumbCenterX, float thumbCenterY, ClipData data) {
        return null;
    }

    @Override // android.view.IWindowSession
    public void reportDropResult(IWindow window, boolean consumed) {
    }

    @Override // android.view.IWindowSession
    public void cancelDragAndDrop(IBinder dragToken, boolean skipAnimation) {
    }

    @Override // android.view.IWindowSession
    public void dragRecipientEntered(IWindow window) {
    }

    @Override // android.view.IWindowSession
    public void dragRecipientExited(IWindow window) {
    }

    @Override // android.view.IWindowSession
    public void setWallpaperPosition(IBinder windowToken, float x10, float y10, float xstep, float ystep) {
    }

    @Override // android.view.IWindowSession
    public void setWallpaperZoomOut(IBinder windowToken, float zoom) {
    }

    @Override // android.view.IWindowSession
    public void setShouldZoomOutWallpaper(IBinder windowToken, boolean shouldZoom) {
    }

    @Override // android.view.IWindowSession
    public void wallpaperOffsetsComplete(IBinder window) {
    }

    @Override // android.view.IWindowSession
    public void setWallpaperDisplayOffset(IBinder windowToken, int x10, int y10) {
    }

    @Override // android.view.IWindowSession
    public Bundle sendWallpaperCommand(IBinder window, String action, int x10, int y10, int z10, Bundle extras, boolean sync) {
        return null;
    }

    @Override // android.view.IWindowSession
    public void wallpaperCommandComplete(IBinder window, Bundle result) {
    }

    @Override // android.view.IWindowSession
    public void onRectangleOnScreenRequested(IBinder token, Rect rectangle) {
    }

    @Override // android.view.IWindowSession
    public IWindowId getWindowId(IBinder window) {
        return null;
    }

    @Override // android.view.IWindowSession
    public void pokeDrawLock(IBinder window) {
    }

    @Override // android.view.IWindowSession
    public boolean startMovingTask(IWindow window, float startX, float startY) {
        return false;
    }

    @Override // android.view.IWindowSession
    public void finishMovingTask(IWindow window) {
    }

    @Override // android.view.IWindowSession
    public void updatePointerIcon(IWindow window) {
    }

    @Override // android.view.IWindowSession
    public void updateTapExcludeRegion(IWindow window, Region region) {
    }

    @Override // android.view.IWindowSession
    public void updateRequestedVisibleTypes(IWindow window, int requestedVisibleTypes) {
    }

    @Override // android.view.IWindowSession
    public void reportSystemGestureExclusionChanged(IWindow window, List<Rect> exclusionRects) {
    }

    @Override // android.view.IWindowSession
    public void reportKeepClearAreasChanged(IWindow window, List<Rect> restrictedRects, List<Rect> unrestrictedRects) {
    }

    @Override // android.view.IWindowSession
    public void grantInputChannel(int displayId, SurfaceControl surface, IWindow window, IBinder hostInputToken, int flags, int privateFlags, int inputFeatures, int type, IBinder windowToken, IBinder focusGrantToken, String inputHandleName, InputChannel outInputChannel) {
    }

    @Override // android.view.IWindowSession
    public void updateInputChannel(IBinder channelToken, int displayId, SurfaceControl surface, int flags, int privateFlags, int inputFeatures, Region region) {
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // android.view.IWindowSession
    public void grantEmbeddedWindowFocus(IWindow callingWindow, IBinder targetInputToken, boolean grantFocus) {
    }

    @Override // android.view.IWindowSession
    public void generateDisplayHash(IWindow window, Rect boundsInWindow, String hashAlgorithm, RemoteCallback callback) {
    }

    @Override // android.view.IWindowSession
    public void setOnBackInvokedCallbackInfo(IWindow iWindow, OnBackInvokedCallbackInfo callbackInfo) throws RemoteException {
    }

    @Override // android.view.IWindowSession
    public boolean dropForAccessibility(IWindow window, int x10, int y10) {
        return false;
    }

    public void setInsetsState(InsetsState state) {
        this.mInsetsState = state;
        for (State s2 : this.mStateForWindow.values()) {
            try {
                this.mTmpFrames.frame.set(0, 0, s2.mParams.width, s2.mParams.height);
                this.mTmpFrames.displayFrame.set(this.mTmpFrames.frame);
                MergedConfiguration mergedConfiguration = this.mTmpConfig;
                Configuration configuration = this.mConfiguration;
                mergedConfiguration.setConfiguration(configuration, configuration);
                s2.mClient.resized(this.mTmpFrames, false, this.mTmpConfig, state, false, false, s2.mDisplayId, Integer.MAX_VALUE, false);
            } catch (RemoteException e2) {
            }
        }
    }

    @Override // android.view.IWindowSession
    public boolean cancelDraw(IWindow window) {
        return false;
    }

    @Override // android.view.IWindowSession
    public void setRefreshRate(SurfaceControl sc2, float refreshRate, int mMSyncScenarioAction, int mMSyncScenarioType, String activityName, String packgeName) {
    }

    @Override // android.view.IWindowSession
    public boolean transferEmbeddedTouchFocusToHost(IWindow window) {
        Log.e(TAG, "Received request to transferEmbeddedTouch focus on WindowlessWindowManager we shouldn't get here!");
        return false;
    }
}
