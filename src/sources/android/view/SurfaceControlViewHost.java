package android.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import android.view.ISurfaceControlViewHost;
import android.view.SurfaceControl;
import android.view.SurfaceControlViewHost;
import android.view.ViewRootImpl;
import android.view.WindowManager;
import android.view.WindowlessWindowManager;
import android.view.accessibility.IAccessibilityEmbeddedConnection;
import android.window.ISurfaceSyncGroup;
import android.window.WindowTokenClient;
import dalvik.system.CloseGuard;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SurfaceControlViewHost {
    private static final String TAG = "SurfaceControlViewHost";
    private IAccessibilityEmbeddedConnection mAccessibilityEmbeddedConnection;
    private final CloseGuard mCloseGuard;
    private ViewRootImpl.ConfigChangedCallback mConfigCallback;
    private ViewRootImpl.ConfigChangedCallback mConfigChangedCallback;
    private boolean mReleased;
    private ISurfaceControlViewHost mRemoteInterface;
    private SurfaceControl mSurfaceControl;
    private final ViewRootImpl mViewRoot;
    private WindowlessWindowManager mWm;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ISurfaceControlViewHostImpl extends ISurfaceControlViewHost.Stub {
        private ISurfaceControlViewHostImpl() {
        }

        @Override // android.view.ISurfaceControlViewHost
        public void onConfigurationChanged(final Configuration configuration) {
            if (SurfaceControlViewHost.this.mViewRoot == null) {
                return;
            }
            SurfaceControlViewHost.this.mViewRoot.mHandler.post(new Runnable() { // from class: android.view.SurfaceControlViewHost$ISurfaceControlViewHostImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceControlViewHost.ISurfaceControlViewHostImpl.this.lambda$onConfigurationChanged$0(configuration);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConfigurationChanged$0(Configuration configuration) {
            if (SurfaceControlViewHost.this.mWm != null) {
                SurfaceControlViewHost.this.mWm.setConfiguration(configuration);
            }
            if (SurfaceControlViewHost.this.mViewRoot != null) {
                SurfaceControlViewHost.this.mViewRoot.forceWmRelayout();
            }
        }

        @Override // android.view.ISurfaceControlViewHost
        public void onDispatchDetachedFromWindow() {
            if (SurfaceControlViewHost.this.mViewRoot == null) {
                return;
            }
            SurfaceControlViewHost.this.mViewRoot.mHandler.post(new Runnable() { // from class: android.view.SurfaceControlViewHost$ISurfaceControlViewHostImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceControlViewHost.ISurfaceControlViewHostImpl.this.lambda$onDispatchDetachedFromWindow$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDispatchDetachedFromWindow$1() {
            SurfaceControlViewHost.this.release();
        }

        @Override // android.view.ISurfaceControlViewHost
        public void onInsetsChanged(InsetsState state, final Rect frame) {
            if (SurfaceControlViewHost.this.mViewRoot != null) {
                SurfaceControlViewHost.this.mViewRoot.mHandler.post(new Runnable() { // from class: android.view.SurfaceControlViewHost$ISurfaceControlViewHostImpl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceControlViewHost.ISurfaceControlViewHostImpl.this.lambda$onInsetsChanged$2(frame);
                    }
                });
            }
            SurfaceControlViewHost.this.mWm.setInsetsState(state);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInsetsChanged$2(Rect frame) {
            SurfaceControlViewHost.this.mViewRoot.setOverrideInsetsFrame(frame);
        }

        @Override // android.view.ISurfaceControlViewHost
        public ISurfaceSyncGroup getSurfaceSyncGroup() {
            final CompletableFuture<ISurfaceSyncGroup> surfaceSyncGroup = new CompletableFuture<>();
            if (Thread.currentThread() == SurfaceControlViewHost.this.mViewRoot.mThread) {
                return SurfaceControlViewHost.this.mViewRoot.getOrCreateSurfaceSyncGroup().mISurfaceSyncGroup;
            }
            SurfaceControlViewHost.this.mViewRoot.mHandler.post(new Runnable() { // from class: android.view.SurfaceControlViewHost$ISurfaceControlViewHostImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceControlViewHost.ISurfaceControlViewHostImpl.this.lambda$getSurfaceSyncGroup$3(surfaceSyncGroup);
                }
            });
            try {
                return surfaceSyncGroup.get(1L, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                Log.e(SurfaceControlViewHost.TAG, "Failed to get SurfaceSyncGroup for SCVH", e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getSurfaceSyncGroup$3(CompletableFuture surfaceSyncGroup) {
            surfaceSyncGroup.complete(SurfaceControlViewHost.this.mViewRoot.getOrCreateSurfaceSyncGroup().mISurfaceSyncGroup);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class SurfacePackage implements Parcelable {
        public static final Parcelable.Creator<SurfacePackage> CREATOR = new Parcelable.Creator<SurfacePackage>() { // from class: android.view.SurfaceControlViewHost.SurfacePackage.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SurfacePackage createFromParcel(Parcel in) {
                return new SurfacePackage(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SurfacePackage[] newArray(int size) {
                return new SurfacePackage[size];
            }
        };
        private final IAccessibilityEmbeddedConnection mAccessibilityEmbeddedConnection;
        private final IBinder mInputToken;
        private final ISurfaceControlViewHost mRemoteInterface;
        private SurfaceControl mSurfaceControl;

        SurfacePackage(SurfaceControl sc2, IAccessibilityEmbeddedConnection connection, IBinder inputToken, ISurfaceControlViewHost ri) {
            this.mSurfaceControl = sc2;
            this.mAccessibilityEmbeddedConnection = connection;
            this.mInputToken = inputToken;
            this.mRemoteInterface = ri;
        }

        public SurfacePackage(SurfacePackage other) {
            SurfaceControl otherSurfaceControl = other.mSurfaceControl;
            if (otherSurfaceControl != null && otherSurfaceControl.isValid()) {
                this.mSurfaceControl = new SurfaceControl(otherSurfaceControl, "SurfacePackage");
            }
            this.mAccessibilityEmbeddedConnection = other.mAccessibilityEmbeddedConnection;
            this.mInputToken = other.mInputToken;
            this.mRemoteInterface = other.mRemoteInterface;
        }

        private SurfacePackage(Parcel in) {
            SurfaceControl surfaceControl = new SurfaceControl();
            this.mSurfaceControl = surfaceControl;
            surfaceControl.readFromParcel(in);
            this.mSurfaceControl.setUnreleasedWarningCallSite("SurfacePackage(Parcel)");
            this.mAccessibilityEmbeddedConnection = IAccessibilityEmbeddedConnection.Stub.asInterface(in.readStrongBinder());
            this.mInputToken = in.readStrongBinder();
            this.mRemoteInterface = ISurfaceControlViewHost.Stub.asInterface(in.readStrongBinder());
        }

        public SurfaceControl getSurfaceControl() {
            return this.mSurfaceControl;
        }

        public IAccessibilityEmbeddedConnection getAccessibilityEmbeddedConnection() {
            return this.mAccessibilityEmbeddedConnection;
        }

        public ISurfaceControlViewHost getRemoteInterface() {
            return this.mRemoteInterface;
        }

        public void notifyConfigurationChanged(Configuration c4) {
            try {
                getRemoteInterface().onConfigurationChanged(c4);
            } catch (RemoteException e2) {
                e2.rethrowAsRuntimeException();
            }
        }

        public void notifyDetachedFromWindow() {
            try {
                getRemoteInterface().onDispatchDetachedFromWindow();
            } catch (RemoteException e2) {
                e2.rethrowAsRuntimeException();
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            this.mSurfaceControl.writeToParcel(out, flags);
            out.writeStrongBinder(this.mAccessibilityEmbeddedConnection.asBinder());
            out.writeStrongBinder(this.mInputToken);
            out.writeStrongBinder(this.mRemoteInterface.asBinder());
        }

        public void release() {
            SurfaceControl surfaceControl = this.mSurfaceControl;
            if (surfaceControl != null) {
                surfaceControl.release();
            }
            this.mSurfaceControl = null;
        }

        public IBinder getInputToken() {
            return this.mInputToken;
        }
    }

    public SurfaceControlViewHost(Context c4, Display d10, WindowlessWindowManager wwm, String callsite) {
        CloseGuard closeGuard = CloseGuard.get();
        this.mCloseGuard = closeGuard;
        this.mReleased = false;
        this.mRemoteInterface = new ISurfaceControlViewHostImpl();
        this.mSurfaceControl = wwm.mRootSurface;
        this.mWm = wwm;
        ViewRootImpl viewRootImpl = new ViewRootImpl(c4, d10, this.mWm, new WindowlessWindowLayout());
        this.mViewRoot = viewRootImpl;
        closeGuard.openWithCallSite("release", callsite);
        setConfigCallback(c4, d10);
        WindowManagerGlobal.getInstance().addWindowlessRoot(viewRootImpl);
        this.mAccessibilityEmbeddedConnection = viewRootImpl.getAccessibilityEmbeddedConnection();
    }

    public SurfaceControlViewHost(Context context, Display display, IBinder hostToken) {
        this(context, display, hostToken, "untracked");
    }

    public SurfaceControlViewHost(Context context, Display display, IBinder hostToken, String callsite) {
        CloseGuard closeGuard = CloseGuard.get();
        this.mCloseGuard = closeGuard;
        this.mReleased = false;
        this.mRemoteInterface = new ISurfaceControlViewHostImpl();
        this.mSurfaceControl = new SurfaceControl.Builder().setContainerLayer().setName(TAG).setCallsite("SurfaceControlViewHost[" + callsite + "]").build();
        this.mWm = new WindowlessWindowManager(context.getResources().getConfiguration(), this.mSurfaceControl, hostToken);
        ViewRootImpl viewRootImpl = new ViewRootImpl(context, display, this.mWm, new WindowlessWindowLayout());
        this.mViewRoot = viewRootImpl;
        closeGuard.openWithCallSite("release", callsite);
        setConfigCallback(context, display);
        WindowManagerGlobal.getInstance().addWindowlessRoot(viewRootImpl);
        this.mAccessibilityEmbeddedConnection = viewRootImpl.getAccessibilityEmbeddedConnection();
    }

    private void setConfigCallback(Context c4, final Display d10) {
        final IBinder token = c4.getWindowContextToken();
        if (this.mConfigCallback == null) {
            ViewRootImpl.ConfigChangedCallback configChangedCallback = new ViewRootImpl.ConfigChangedCallback() { // from class: android.view.SurfaceControlViewHost$$ExternalSyntheticLambda0
                @Override // android.view.ViewRootImpl.ConfigChangedCallback
                public final void onConfigurationChanged(Configuration configuration) {
                    SurfaceControlViewHost.lambda$setConfigCallback$0(token, d10, configuration);
                }
            };
            this.mConfigCallback = configChangedCallback;
            ViewRootImpl.addConfigCallback(configChangedCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$setConfigCallback$0(IBinder iBinder, Display d10, Configuration conf) {
        if (iBinder instanceof WindowTokenClient) {
            WindowTokenClient w3 = (WindowTokenClient) iBinder;
            w3.onConfigurationChanged(conf, d10.getDisplayId(), true);
        }
    }

    protected void finalize() throws Throwable {
        if (this.mReleased) {
            return;
        }
        ViewRootImpl.ConfigChangedCallback configChangedCallback = this.mConfigCallback;
        if (configChangedCallback != null) {
            ViewRootImpl.removeConfigCallback(configChangedCallback);
            this.mConfigCallback = null;
        }
        CloseGuard closeGuard = this.mCloseGuard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        doRelease(false);
    }

    public SurfacePackage getSurfacePackage() {
        if (this.mSurfaceControl != null && this.mAccessibilityEmbeddedConnection != null) {
            return new SurfacePackage(new SurfaceControl(this.mSurfaceControl, "getSurfacePackage"), this.mAccessibilityEmbeddedConnection, getFocusGrantToken(), this.mRemoteInterface);
        }
        return null;
    }

    public AttachedSurfaceControl getRootSurfaceControl() {
        return this.mViewRoot;
    }

    public void setView(View view, int width, int height) {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(width, height, 2, 0, -2);
        setView(view, lp);
    }

    public void setView(View view, WindowManager.LayoutParams attrs) {
        Objects.requireNonNull(view);
        attrs.flags |= 16777216;
        addWindowToken(attrs);
        view.setLayoutParams(attrs);
        this.mViewRoot.setView(view, attrs, null);
    }

    public View getView() {
        return this.mViewRoot.getView();
    }

    public IWindow getWindowToken() {
        return this.mViewRoot.mWindow;
    }

    public WindowlessWindowManager getWindowlessWM() {
        return this.mWm;
    }

    public void relayout(WindowManager.LayoutParams attrs, WindowlessWindowManager.ResizeCompleteCallback callback) {
        this.mViewRoot.setLayoutParams(attrs, false);
        this.mViewRoot.setReportNextDraw(true, "scvh_relayout");
        this.mWm.setCompletionCallback(this.mViewRoot.mWindow.asBinder(), callback);
    }

    public void relayout(WindowManager.LayoutParams attrs) {
        this.mViewRoot.setLayoutParams(attrs, false);
    }

    public void relayout(int width, int height) {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(width, height, 2, 0, -2);
        relayout(lp);
    }

    public void release() {
        ViewRootImpl.ConfigChangedCallback configChangedCallback = this.mConfigCallback;
        if (configChangedCallback != null) {
            ViewRootImpl.removeConfigCallback(configChangedCallback);
            this.mConfigCallback = null;
        }
        doRelease(true);
    }

    private void doRelease(boolean immediate) {
        ViewRootImpl.ConfigChangedCallback configChangedCallback = this.mConfigChangedCallback;
        if (configChangedCallback != null) {
            ViewRootImpl.removeConfigCallback(configChangedCallback);
            this.mConfigChangedCallback = null;
        }
        this.mViewRoot.die(immediate);
        WindowManagerGlobal.getInstance().removeWindowlessRoot(this.mViewRoot);
        this.mReleased = true;
        this.mCloseGuard.close();
    }

    public IBinder getFocusGrantToken() {
        return this.mWm.getFocusGrantToken(getWindowToken().asBinder());
    }

    private void addWindowToken(WindowManager.LayoutParams attrs) {
        WindowManagerImpl wm = (WindowManagerImpl) this.mViewRoot.mContext.getSystemService("window");
        attrs.token = wm.getDefaultToken();
    }

    public boolean transferTouchGestureToHost() {
        if (this.mViewRoot == null) {
            return false;
        }
        IWindowSession realWm = WindowManagerGlobal.getWindowSession();
        try {
            return realWm.transferEmbeddedTouchFocusToHost(this.mViewRoot.mWindow);
        } catch (RemoteException e2) {
            e2.rethrowAsRuntimeException();
            return false;
        }
    }
}
