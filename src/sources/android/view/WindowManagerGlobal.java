package android.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.ArraySet;
import android.util.Log;
import android.view.IRotationWatcher;
import android.view.IWindowManager;
import android.view.IWindowSessionCallback;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.util.FastPrintWriter;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WindowManagerGlobal {
    public static final int ADD_APP_EXITING = -4;
    public static final int ADD_BAD_APP_TOKEN = -1;
    public static final int ADD_BAD_SUBWINDOW_TOKEN = -2;
    public static final int ADD_DUPLICATE_ADD = -5;
    public static final int ADD_FLAG_ALWAYS_CONSUME_SYSTEM_BARS = 4;
    public static final int ADD_FLAG_APP_VISIBLE = 2;
    public static final int ADD_FLAG_IN_TOUCH_MODE = 1;
    public static final int ADD_FLAG_USE_BLAST = 8;
    public static final int ADD_INVALID_DISPLAY = -9;
    public static final int ADD_INVALID_TYPE = -10;
    public static final int ADD_INVALID_USER = -11;
    public static final int ADD_MULTIPLE_SINGLETON = -7;
    public static final int ADD_NOT_APP_TOKEN = -3;
    public static final int ADD_OKAY = 0;
    public static final int ADD_PERMISSION_DENIED = -8;
    public static final int ADD_STARTING_NOT_NEEDED = -6;
    public static final int RELAYOUT_INSETS_PENDING = 1;
    public static final int RELAYOUT_RES_CANCEL_AND_REDRAW = 16;
    public static final int RELAYOUT_RES_CONSUME_ALWAYS_SYSTEM_BARS = 8;
    public static final int RELAYOUT_RES_FIRST_TIME = 1;
    public static final int RELAYOUT_RES_SURFACE_CHANGED = 2;
    public static final int RELAYOUT_RES_SURFACE_RESIZED = 4;
    private static final String TAG = "WindowManager";
    private static WindowManagerGlobal sDefaultWindowManager;
    private static boolean sUseBLASTAdapter = false;
    private static IWindowManager sWindowManagerService;
    private static IWindowSession sWindowSession;
    private WeakHashMap<IBinder, ProposedRotationListenerDelegate> mProposedRotationListenerMap;
    private Runnable mSystemPropertyUpdater;
    private final Object mLock = new Object();
    private final ArrayList<View> mViews = new ArrayList<>();
    private final ArrayList<ViewRootImpl> mRoots = new ArrayList<>();
    private final ArrayList<WindowManager.LayoutParams> mParams = new ArrayList<>();
    private final ArraySet<View> mDyingViews = new ArraySet<>();
    private final ArrayList<ViewRootImpl> mWindowlessRoots = new ArrayList<>();
    private IWindowManagerGlobalWrapper mWindowManagerGlobalWrapper = new WindowManagerGlobalWrapper();

    private WindowManagerGlobal() {
    }

    public static void initialize() {
        getWindowManagerService();
    }

    public static WindowManagerGlobal getInstance() {
        WindowManagerGlobal windowManagerGlobal;
        synchronized (WindowManagerGlobal.class) {
            if (sDefaultWindowManager == null) {
                sDefaultWindowManager = new WindowManagerGlobal();
            }
            windowManagerGlobal = sDefaultWindowManager;
        }
        return windowManagerGlobal;
    }

    public static IWindowManager getWindowManagerService() {
        IWindowManager iWindowManager;
        IWindowManager iWindowManager2 = sWindowManagerService;
        if (iWindowManager2 != null) {
            return iWindowManager2;
        }
        synchronized (WindowManagerGlobal.class) {
            if (sWindowManagerService == null) {
                IWindowManager asInterface = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
                sWindowManagerService = asInterface;
                if (asInterface != null) {
                    try {
                        ValueAnimator.setDurationScale(asInterface.getCurrentAnimatorScale());
                        sUseBLASTAdapter = sWindowManagerService.useBLAST();
                    } catch (RemoteException e2) {
                        throw e2.rethrowFromSystemServer();
                    }
                }
            }
            iWindowManager = sWindowManagerService;
        }
        return iWindowManager;
    }

    public static IWindowSession getWindowSession() {
        IWindowSession iWindowSession;
        synchronized (WindowManagerGlobal.class) {
            if (sWindowSession == null) {
                try {
                    InputMethodManager.ensureDefaultInstanceForDefaultDisplayIfNecessary();
                    IWindowManager windowManager = getWindowManagerService();
                    sWindowSession = windowManager.openSession(new IWindowSessionCallback.Stub() { // from class: android.view.WindowManagerGlobal.1
                        @Override // android.view.IWindowSessionCallback
                        public void onAnimatorScaleChanged(float scale) {
                            ValueAnimator.setDurationScale(scale);
                        }
                    });
                } catch (RemoteException e2) {
                    throw e2.rethrowFromSystemServer();
                }
            }
            iWindowSession = sWindowSession;
        }
        return iWindowSession;
    }

    public static IWindowSession peekWindowSession() {
        IWindowSession iWindowSession;
        synchronized (WindowManagerGlobal.class) {
            iWindowSession = sWindowSession;
        }
        return iWindowSession;
    }

    public static boolean useBLAST() {
        return sUseBLASTAdapter;
    }

    public String[] getViewRootNames() {
        String[] mViewRoots;
        synchronized (this.mLock) {
            int numRoots = this.mRoots.size();
            int windowlessRoots = this.mWindowlessRoots.size();
            mViewRoots = new String[numRoots + windowlessRoots];
            for (int i10 = 0; i10 < numRoots; i10++) {
                mViewRoots[i10] = getWindowName(this.mRoots.get(i10));
            }
            for (int i11 = 0; i11 < windowlessRoots; i11++) {
                mViewRoots[i11 + numRoots] = getWindowName(this.mWindowlessRoots.get(i11));
            }
        }
        return mViewRoots;
    }

    public ArrayList<ViewRootImpl> getRootViews(IBinder token) {
        ArrayList<ViewRootImpl> views = new ArrayList<>();
        synchronized (this.mLock) {
            int numRoots = this.mRoots.size();
            for (int i10 = 0; i10 < numRoots; i10++) {
                WindowManager.LayoutParams params = this.mParams.get(i10);
                if (params.token != null) {
                    if (params.token != token) {
                        boolean isChild = false;
                        if (params.type >= 1000 && params.type <= 1999) {
                            int j10 = 0;
                            while (true) {
                                if (j10 >= numRoots) {
                                    break;
                                }
                                View viewj = this.mViews.get(j10);
                                WindowManager.LayoutParams paramsj = this.mParams.get(j10);
                                if (params.token != viewj.getWindowToken() || paramsj.token != token) {
                                    j10++;
                                } else {
                                    isChild = true;
                                    break;
                                }
                            }
                        }
                        if (!isChild) {
                        }
                    }
                    views.add(this.mRoots.get(i10));
                }
            }
        }
        return views;
    }

    public ArrayList<View> getWindowViews() {
        ArrayList<View> arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList<>(this.mViews);
        }
        return arrayList;
    }

    public View getWindowView(IBinder windowToken) {
        synchronized (this.mLock) {
            int numViews = this.mViews.size();
            for (int i10 = 0; i10 < numViews; i10++) {
                View view = this.mViews.get(i10);
                if (view.getWindowToken() == windowToken) {
                    return view;
                }
            }
            return null;
        }
    }

    public View getRootView(String name) {
        synchronized (this.mLock) {
            for (int i10 = this.mRoots.size() - 1; i10 >= 0; i10--) {
                ViewRootImpl root = this.mRoots.get(i10);
                if (name.equals(getWindowName(root))) {
                    return root.getView();
                }
            }
            for (int i11 = this.mWindowlessRoots.size() - 1; i11 >= 0; i11--) {
                ViewRootImpl root2 = this.mWindowlessRoots.get(i11);
                if (name.equals(getWindowName(root2))) {
                    return root2.getView();
                }
            }
            return null;
        }
    }

    public void addView(View view, ViewGroup.LayoutParams params, Display display, Window parentWindow, int userId) {
        ViewRootImpl root;
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        if (display == null) {
            throw new IllegalArgumentException("display must not be null");
        }
        if (!(params instanceof WindowManager.LayoutParams)) {
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        }
        WindowManager.LayoutParams wparams = (WindowManager.LayoutParams) params;
        if (parentWindow != null) {
            parentWindow.adjustLayoutParamsForSubWindow(wparams);
        } else {
            Context context = view.getContext();
            if (context != null && (context.getApplicationInfo().flags & 536870912) != 0) {
                wparams.flags |= 16777216;
            }
        }
        View panelParentView = null;
        synchronized (this.mLock) {
            if (this.mSystemPropertyUpdater == null) {
                Runnable runnable = new Runnable() { // from class: android.view.WindowManagerGlobal.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (WindowManagerGlobal.this.mLock) {
                            for (int i10 = WindowManagerGlobal.this.mRoots.size() - 1; i10 >= 0; i10--) {
                                ((ViewRootImpl) WindowManagerGlobal.this.mRoots.get(i10)).loadSystemProperties();
                            }
                        }
                    }
                };
                this.mSystemPropertyUpdater = runnable;
                SystemProperties.addChangeCallback(runnable);
            }
            int index = findViewLocked(view, false);
            if (index >= 0) {
                if (this.mDyingViews.contains(view)) {
                    this.mRoots.get(index).doDie();
                } else {
                    throw new IllegalStateException("View " + ((Object) view) + " has already been added to the window manager.");
                }
            }
            if (wparams.type >= 1000 && wparams.type <= 1999) {
                int count = this.mViews.size();
                for (int i10 = 0; i10 < count; i10++) {
                    if (this.mRoots.get(i10).mWindow.asBinder() == wparams.token) {
                        panelParentView = this.mViews.get(i10);
                    }
                }
            }
            IWindowSession windowlessSession = null;
            if (wparams.token != null && panelParentView == null) {
                int i11 = 0;
                while (true) {
                    if (i11 >= this.mWindowlessRoots.size()) {
                        break;
                    }
                    ViewRootImpl maybeParent = this.mWindowlessRoots.get(i11);
                    if (maybeParent.getWindowToken() != wparams.token) {
                        i11++;
                    } else {
                        windowlessSession = maybeParent.getWindowSession();
                        break;
                    }
                }
            }
            if (windowlessSession == null) {
                root = new ViewRootImpl(view.getContext(), display);
            } else {
                root = new ViewRootImpl(view.getContext(), display, windowlessSession, new WindowlessWindowLayout());
            }
            view.setLayoutParams(wparams);
            this.mViews.add(view);
            this.mRoots.add(root);
            this.mParams.add(wparams);
            Log.d(TAG, "Add to mViews: " + ((Object) view) + ",pkg= " + wparams.packageName);
            try {
                root.setView(view, wparams, panelParentView, userId);
            } catch (RuntimeException e2) {
                int viewIndex = index >= 0 ? index : this.mViews.size() - 1;
                if (viewIndex >= 0) {
                    removeViewLocked(viewIndex, true);
                }
                throw e2;
            }
        }
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        if (!(params instanceof WindowManager.LayoutParams)) {
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        }
        WindowManager.LayoutParams wparams = (WindowManager.LayoutParams) params;
        view.setLayoutParams(wparams);
        synchronized (this.mLock) {
            int index = findViewLocked(view, true);
            ViewRootImpl root = this.mRoots.get(index);
            this.mParams.remove(index);
            this.mParams.add(index, wparams);
            root.setLayoutParams(wparams, false);
        }
    }

    public void removeView(View view, boolean immediate) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        synchronized (this.mLock) {
            int index = findViewLocked(view, true);
            View curView = this.mRoots.get(index).getView();
            removeViewLocked(index, immediate);
            if (curView != view) {
                throw new IllegalStateException("Calling with view " + ((Object) view) + " but the ViewAncestor is attached to " + ((Object) curView));
            }
        }
    }

    public void closeAll(IBinder token, String who, String what) {
        closeAllExceptView(token, null, who, what);
    }

    public void closeAllExceptView(IBinder token, View view, String who, String what) {
        synchronized (this.mLock) {
            int count = this.mViews.size();
            for (int i10 = 0; i10 < count; i10++) {
                if ((view == null || this.mViews.get(i10) != view) && (token == null || this.mParams.get(i10).token == token)) {
                    ViewRootImpl root = this.mRoots.get(i10);
                    if (who != null) {
                        WindowLeaked leak = new WindowLeaked(what + " " + who + " has leaked window " + ((Object) root.getView()) + " that was originally added here");
                        leak.setStackTrace(root.getLocation().getStackTrace());
                        Log.e(TAG, "", leak);
                    }
                    removeViewLocked(i10, false);
                }
            }
        }
    }

    private void removeViewLocked(int index, boolean immediate) {
        ViewRootImpl root = this.mRoots.get(index);
        View view = root.getView();
        if (root != null) {
            root.getImeFocusController().onWindowDismissed();
        }
        boolean deferred = root.die(immediate);
        if (view != null) {
            view.assignParent(null);
            if (deferred) {
                this.mDyingViews.add(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doRemoveView(ViewRootImpl root) {
        boolean allViewsRemoved;
        synchronized (this.mLock) {
            int index = this.mRoots.indexOf(root);
            if (index >= 0) {
                this.mRoots.remove(index);
                this.mParams.remove(index);
                View view = this.mViews.remove(index);
                this.mDyingViews.remove(view);
            }
            allViewsRemoved = this.mRoots.isEmpty();
        }
        if (allViewsRemoved) {
            InsetsAnimationThread.release();
        }
    }

    private int findViewLocked(View view, boolean required) {
        int index = this.mViews.indexOf(view);
        if (required && index < 0) {
            throw new IllegalArgumentException("View=" + ((Object) view) + " not attached to window manager");
        }
        return index;
    }

    public void trimMemory(int level) {
        if (!isAppVisible() || level <= 20) {
            ThreadedRenderer.trimMemory(level);
        }
    }

    public void trimCaches(int level) {
        if (!isAppVisible() || level <= 20) {
            ThreadedRenderer.trimCaches(level);
        }
    }

    private boolean isAppVisible() {
        synchronized (this.mLock) {
            for (int i10 = 0; i10 < this.mRoots.size(); i10++) {
                ViewRootImpl vri = this.mRoots.get(i10);
                if (vri != null && vri.mAppVisible) {
                    return true;
                }
            }
            return false;
        }
    }

    public void dumpGfxInfo(FileDescriptor fd2, String[] args) {
        char c4;
        char c10;
        FileOutputStream fout = new FileOutputStream(fd2);
        PrintWriter pw = new FastPrintWriter(fout);
        try {
            synchronized (this.mLock) {
                try {
                    int count = this.mViews.size();
                    pw.println("Profile data in ms:");
                    int i10 = 0;
                    while (true) {
                        c4 = 0;
                        c10 = 1;
                        if (i10 >= count) {
                            break;
                        }
                        ViewRootImpl root = this.mRoots.get(i10);
                        String name = getWindowName(root);
                        pw.printf("\n\t%s (visibility=%d)", name, Integer.valueOf(root.getHostVisibility()));
                        ThreadedRenderer renderer = root.getView().mAttachInfo.mThreadedRenderer;
                        if (renderer != null) {
                            try {
                                renderer.dumpGfxInfo(pw, fd2, args);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                    pw.flush();
                                    throw th;
                                }
                            }
                        }
                        i10++;
                    }
                    pw.println("\nView hierarchy:\n");
                    ViewRootImpl.GfxInfo totals = new ViewRootImpl.GfxInfo();
                    int i11 = 0;
                    while (i11 < count) {
                        ViewRootImpl root2 = this.mRoots.get(i11);
                        ViewRootImpl.GfxInfo info = root2.getGfxInfo();
                        totals.add(info);
                        String name2 = getWindowName(root2);
                        Object[] objArr = new Object[3];
                        objArr[c4] = name2;
                        objArr[c10] = Integer.valueOf(info.viewCount);
                        objArr[2] = Float.valueOf(((float) info.renderNodeMemoryUsage) / 1024.0f);
                        pw.printf("  %s\n  %d views, %.2f kB of render nodes", objArr);
                        pw.printf("\n\n", new Object[0]);
                        i11++;
                        c4 = 0;
                        c10 = 1;
                    }
                    pw.printf("\nTotal %-15s: %d\n", "ViewRootImpl", Integer.valueOf(count));
                    pw.printf("Total %-15s: %d\n", "attached Views", Integer.valueOf(totals.viewCount));
                    pw.printf("Total %-15s: %.2f kB (used) / %.2f kB (capacity)\n\n", "RenderNode", Float.valueOf(((float) totals.renderNodeMemoryUsage) / 1024.0f), Float.valueOf(((float) totals.renderNodeMemoryAllocated) / 1024.0f));
                    pw.flush();
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static String getWindowName(ViewRootImpl root) {
        return ((Object) root.mWindowAttributes.getTitle()) + "/" + root.getClass().getName() + '@' + Integer.toHexString(root.hashCode());
    }

    public void setStoppedState(IBinder token, final boolean stopped) {
        ArrayList<ViewRootImpl> nonCurrentThreadRoots = null;
        synchronized (this.mLock) {
            int count = this.mViews.size();
            for (int i10 = count - 1; i10 >= 0; i10--) {
                if (token == null || this.mParams.get(i10).token == token) {
                    ViewRootImpl root = this.mRoots.get(i10);
                    if (root.mThread == Thread.currentThread()) {
                        root.setWindowStopped(stopped);
                    } else {
                        if (nonCurrentThreadRoots == null) {
                            nonCurrentThreadRoots = new ArrayList<>();
                        }
                        nonCurrentThreadRoots.add(root);
                    }
                    setStoppedState(root.mAttachInfo.mWindowToken, stopped);
                }
            }
        }
        if (nonCurrentThreadRoots != null) {
            for (int i11 = nonCurrentThreadRoots.size() - 1; i11 >= 0; i11--) {
                final ViewRootImpl root2 = nonCurrentThreadRoots.get(i11);
                root2.mHandler.runWithScissors(new Runnable() { // from class: android.view.WindowManagerGlobal$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewRootImpl.this.setWindowStopped(stopped);
                    }
                }, 0L);
            }
        }
    }

    public void reportNewConfiguration(Configuration config) {
        synchronized (this.mLock) {
            int count = this.mViews.size();
            Configuration config2 = new Configuration(config);
            for (int i10 = 0; i10 < count; i10++) {
                ViewRootImpl root = this.mRoots.get(i10);
                root.requestUpdateConfiguration(config2);
            }
        }
    }

    public void changeCanvasOpacity(IBinder token, boolean opaque) {
        if (token == null) {
            return;
        }
        synchronized (this.mLock) {
            for (int i10 = this.mParams.size() - 1; i10 >= 0; i10--) {
                if (this.mParams.get(i10).token == token) {
                    this.mRoots.get(i10).changeCanvasOpacity(opaque);
                    return;
                }
            }
        }
    }

    public SurfaceControl mirrorWallpaperSurface(int displayId) {
        try {
            return getWindowManagerService().mirrorWallpaperSurface(displayId);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void registerProposedRotationListener(IBinder contextToken, Executor executor, final IntConsumer listener) {
        synchronized (this.mLock) {
            if (this.mProposedRotationListenerMap == null) {
                this.mProposedRotationListenerMap = new WeakHashMap<>(1);
            }
            final ProposedRotationListenerDelegate delegate = this.mProposedRotationListenerMap.get(contextToken);
            if (delegate == null) {
                WeakHashMap<IBinder, ProposedRotationListenerDelegate> weakHashMap = this.mProposedRotationListenerMap;
                ProposedRotationListenerDelegate proposedRotationListenerDelegate = new ProposedRotationListenerDelegate();
                delegate = proposedRotationListenerDelegate;
                weakHashMap.put(contextToken, proposedRotationListenerDelegate);
            }
            if (delegate.add(executor, listener)) {
                if (delegate != null) {
                    executor.execute(new Runnable() { // from class: android.view.WindowManagerGlobal$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            IntConsumer.this.accept(delegate.mLastRotation);
                        }
                    });
                    return;
                }
                try {
                    int currentRotation = getWindowManagerService().registerProposedRotationListener(contextToken, delegate);
                    delegate.onRotationChanged(currentRotation);
                } catch (RemoteException e2) {
                    throw e2.rethrowFromSystemServer();
                }
            }
        }
    }

    public void unregisterProposedRotationListener(IBinder contextToken, IntConsumer listener) {
        synchronized (this.mLock) {
            WeakHashMap<IBinder, ProposedRotationListenerDelegate> weakHashMap = this.mProposedRotationListenerMap;
            if (weakHashMap == null) {
                return;
            }
            ProposedRotationListenerDelegate delegate = weakHashMap.get(contextToken);
            if (delegate == null) {
                return;
            }
            if (delegate.remove(listener)) {
                this.mProposedRotationListenerMap.remove(contextToken);
                try {
                    getWindowManagerService().removeRotationWatcher(delegate);
                } catch (RemoteException e2) {
                    e2.rethrowFromSystemServer();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ProposedRotationListenerDelegate extends IRotationWatcher.Stub {
        int mLastRotation;
        private volatile ListenerWrapper[] mListenerArray;
        private final ArrayList<ListenerWrapper> mListeners;

        private ProposedRotationListenerDelegate() {
            this.mListeners = new ArrayList<>(1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public static class ListenerWrapper {
            final Executor mExecutor;
            final WeakReference<IntConsumer> mListener;

            ListenerWrapper(Executor executor, IntConsumer listener) {
                this.mExecutor = executor;
                this.mListener = new WeakReference<>(listener);
            }
        }

        boolean add(Executor executor, IntConsumer listener) {
            for (int i10 = this.mListeners.size() - 1; i10 >= 0; i10--) {
                if (this.mListeners.get(i10).mListener.get() == listener) {
                    return false;
                }
            }
            this.mListeners.add(new ListenerWrapper(executor, listener));
            this.mListenerArray = (ListenerWrapper[]) this.mListeners.toArray(new ListenerWrapper[0]);
            return true;
        }

        boolean remove(IntConsumer listener) {
            int i10 = this.mListeners.size();
            do {
                i10--;
                if (i10 < 0) {
                    return false;
                }
            } while (this.mListeners.get(i10).mListener.get() != listener);
            this.mListeners.remove(i10);
            this.mListenerArray = (ListenerWrapper[]) this.mListeners.toArray(new ListenerWrapper[0]);
            return this.mListeners.isEmpty();
        }

        @Override // android.view.IRotationWatcher
        public void onRotationChanged(final int rotation) {
            this.mLastRotation = rotation;
            boolean alive = false;
            for (ListenerWrapper listenerWrapper : this.mListenerArray) {
                final IntConsumer listener = listenerWrapper.mListener.get();
                if (listener != null) {
                    listenerWrapper.mExecutor.execute(new Runnable() { // from class: android.view.WindowManagerGlobal$ProposedRotationListenerDelegate$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            IntConsumer.this.accept(rotation);
                        }
                    });
                    alive = true;
                }
            }
            if (!alive) {
                try {
                    WindowManagerGlobal.getWindowManagerService().removeRotationWatcher(this);
                } catch (RemoteException e2) {
                    e2.rethrowFromSystemServer();
                }
            }
        }
    }

    public void addWindowlessRoot(ViewRootImpl impl) {
        synchronized (this.mLock) {
            this.mWindowlessRoots.add(impl);
        }
    }

    public void removeWindowlessRoot(ViewRootImpl impl) {
        synchronized (this.mLock) {
            this.mWindowlessRoots.remove(impl);
        }
    }

    public void setRecentsAppBehindSystemBars(boolean behindSystemBars) {
        try {
            getWindowManagerService().setRecentsAppBehindSystemBars(behindSystemBars);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public IWindowManagerGlobalWrapper getWrapper() {
        return this.mWindowManagerGlobalWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class WindowManagerGlobalWrapper implements IWindowManagerGlobalWrapper {
        private WindowManagerGlobalWrapper() {
        }

        @Override // android.view.IWindowManagerGlobalWrapper
        public boolean trimMemoryIfAllowed(int level) {
            boolean allowed = true;
            synchronized (WindowManagerGlobal.this.mLock) {
                for (int i10 = WindowManagerGlobal.this.mRoots.size() - 1; i10 >= 0; i10--) {
                    ViewRootImpl root = (ViewRootImpl) WindowManagerGlobal.this.mRoots.get(i10);
                    if (root.mAttachInfo.mThreadedRenderer != null && root.mView != null && (root.getHostVisibility() == 0 || root.mAttachInfo.mThreadedRenderer.isEnabled())) {
                        Log.d(WindowManagerGlobal.TAG, "don't allow trim: visibility=" + root.getHostVisibility() + ", renderEnable=" + root.mAttachInfo.mThreadedRenderer.isEnabled());
                        allowed = false;
                        break;
                    }
                }
            }
            if (allowed) {
                WindowManagerGlobal.this.trimMemory(level);
            }
            return allowed;
        }
    }
}
