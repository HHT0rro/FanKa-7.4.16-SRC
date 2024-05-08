package android.view.inputmethod;

import android.annotation.SystemApi;
import android.app.ActivityThread;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.ResultReceiver;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.style.SuggestionSpan;
import android.util.Log;
import android.util.Pair;
import android.util.Pools;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.ImeFocusController;
import android.view.ImeInsetsSourceConsumer;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventSender;
import android.view.InsetsController$$ExternalSyntheticLambda2;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.InputMethodManager;
import android.window.ImeOnBackInvokedDispatcher;
import android.window.WindowOnBackInvokedDispatcher;
import com.android.internal.inputmethod.IInputMethodClient;
import com.android.internal.inputmethod.IInputMethodSession;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.inputmethod.ImeTracing;
import com.android.internal.inputmethod.InputBindResult;
import com.android.internal.inputmethod.InputMethodDebug;
import com.android.internal.inputmethod.InputMethodPrivilegedOperationsRegistry;
import com.android.internal.os.SomeArgs;
import com.android.internal.view.IInputMethodManager;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InputMethodManager {
    public static final long CLEAR_SHOW_FORCED_FLAG_WHEN_LEAVING = 214016041;
    public static final int DISPATCH_HANDLED = 1;
    public static final int DISPATCH_IN_PROGRESS = -1;
    public static final int DISPATCH_NOT_HANDLED = 0;
    public static final int HIDE_IMPLICIT_ONLY = 1;
    public static final int HIDE_NOT_ALWAYS = 2;
    private static final long INPUT_METHOD_NOT_RESPONDING_TIMEOUT = 2500;
    private static final int MSG_BIND = 2;
    private static final int MSG_BIND_ACCESSIBILITY_SERVICE = 11;
    private static final int MSG_DUMP = 1;
    private static final int MSG_FLUSH_INPUT_EVENT = 7;
    private static final int MSG_ON_SHOW_REQUESTED = 31;
    private static final int MSG_REPORT_FULLSCREEN_MODE = 10;
    private static final int MSG_SEND_INPUT_EVENT = 5;
    private static final int MSG_SET_ACTIVE = 4;
    private static final int MSG_SET_INTERACTIVE = 13;
    private static final int MSG_TIMEOUT_INPUT_EVENT = 6;
    private static final int MSG_UNBIND = 3;
    private static final int MSG_UNBIND_ACCESSIBILITY_SERVICE = 12;
    private static final int MSG_UPDATE_VIRTUAL_DISPLAY_TO_SCREEN_MATRIX = 30;
    private static final int NOT_A_SUBTYPE_ID = -1;
    private static final String PENDING_EVENT_COUNTER = "aq:imm";
    private static final int REQUEST_UPDATE_CURSOR_ANCHOR_INFO_NONE = 0;
    public static final int RESULT_HIDDEN = 3;
    public static final int RESULT_SHOWN = 2;
    public static final int RESULT_UNCHANGED_HIDDEN = 1;
    public static final int RESULT_UNCHANGED_SHOWN = 0;

    @Deprecated
    public static final int SHOW_FORCED = 2;
    public static final int SHOW_IMPLICIT = 1;
    public static final int SHOW_IM_PICKER_MODE_AUTO = 0;
    public static final int SHOW_IM_PICKER_MODE_EXCLUDE_AUXILIARY_SUBTYPES = 2;
    public static final int SHOW_IM_PICKER_MODE_INCLUDE_AUXILIARY_SUBTYPES = 1;
    private static final String SUBTYPE_MODE_VOICE = "voice";
    private static final String TAG = "InputMethodManager";

    @Deprecated
    static InputMethodManager sInstance;
    private static boolean sPreventImeStartupUnlessTextEditor;
    private CompletionInfo[] mCompletions;
    private BindState mCurBindState;
    private InputChannel mCurChannel;

    @Deprecated
    String mCurId;

    @Deprecated
    IInputMethodSession mCurMethod;
    ViewRootImpl mCurRootView;
    boolean mCurRootViewWindowFocused;
    private ImeInputEventSender mCurSender;
    private EditorInfo mCurrentEditorInfo;
    private int mCursorCandEnd;
    private int mCursorCandStart;
    private int mCursorSelEnd;
    private int mCursorSelStart;
    private final int mDisplayId;
    private final RemoteInputConnectionImpl mFallbackInputConnection;
    private boolean mFullscreenMode;
    final H mH;
    private ImeInsetsSourceConsumer mImeInsetsConsumer;
    private int mInitialSelEnd;
    private int mInitialSelStart;
    private final Looper mMainLooper;
    private View mNextServedView;
    private ViewFocusParameterInfo mPreviousViewFocusParameters;
    private boolean mServedConnecting;
    private RemoteInputConnectionImpl mServedInputConnection;
    private Handler mServedInputConnectionHandler;
    private View mServedView;

    @Deprecated
    final IInputMethodManager mService;
    static boolean DEBUG = false;
    private static final Object sLock = new Object();
    private static final SparseArray<InputMethodManager> sInstanceMap = new SparseArray<>();
    private static final boolean OPTIMIZE_NONEDITABLE_VIEWS = SystemProperties.getBoolean("debug.imm.optimize_noneditable_views", true);
    private final ImeOnBackInvokedDispatcher mImeDispatcher = new ImeOnBackInvokedDispatcher(Handler.getMain()) { // from class: android.view.inputmethod.InputMethodManager.1
        @Override // android.window.ImeOnBackInvokedDispatcher
        public WindowOnBackInvokedDispatcher getReceivingDispatcher() {
            WindowOnBackInvokedDispatcher onBackInvokedDispatcher;
            synchronized (InputMethodManager.this.mH) {
                onBackInvokedDispatcher = InputMethodManager.this.mCurRootView != null ? InputMethodManager.this.mCurRootView.getOnBackInvokedDispatcher() : null;
            }
            return onBackInvokedDispatcher;
        }
    };
    private boolean mActive = false;
    private boolean mRestartOnNextWindowFocus = true;
    Rect mTmpCursorRect = new Rect();
    Rect mCursorRect = new Rect();
    private CursorAnchorInfo mCursorAnchorInfo = null;
    private Matrix mVirtualDisplayToScreenMatrix = null;
    private final SparseArray<IAccessibilityInputMethodSessionInvoker> mAccessibilityInputMethodSession = new SparseArray<>();

    @Deprecated
    private int mRequestUpdateCursorAnchorInfoMonitorMode = 0;
    private final Pools.Pool<PendingEvent> mPendingEventPool = new Pools.SimplePool(20);
    private final SparseArray<PendingEvent> mPendingEvents = new SparseArray<>(20);
    private final DelegateImpl mDelegate = new DelegateImpl();
    private final IInputMethodClient.Stub mClient = new IInputMethodClient.Stub() { // from class: android.view.inputmethod.InputMethodManager.2
        @Override // android.os.Binder
        protected void dump(FileDescriptor fd2, PrintWriter fout, String[] args) {
            CountDownLatch latch = new CountDownLatch(1);
            SomeArgs sargs = SomeArgs.obtain();
            sargs.arg1 = fd2;
            sargs.arg2 = fout;
            sargs.arg3 = args;
            sargs.arg4 = latch;
            InputMethodManager.this.mH.sendMessage(InputMethodManager.this.mH.obtainMessage(1, sargs));
            try {
                if (!latch.await(5L, TimeUnit.SECONDS)) {
                    fout.println("Timeout waiting for dump");
                }
            } catch (InterruptedException e2) {
                fout.println("Interrupted waiting for dump");
            }
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void onBindMethod(InputBindResult res) {
            InputMethodManager.this.mH.obtainMessage(2, res).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void onBindAccessibilityService(InputBindResult res, int id2) {
            InputMethodManager.this.mH.obtainMessage(11, id2, 0, res).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void onUnbindMethod(int sequence, int unbindReason) {
            InputMethodManager.this.mH.obtainMessage(3, sequence, unbindReason).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void onUnbindAccessibilityService(int sequence, int id2) {
            InputMethodManager.this.mH.obtainMessage(12, sequence, id2).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void setActive(boolean z10, boolean z11) {
            InputMethodManager.this.mH.obtainMessage(4, z10 ? 1 : 0, z11 ? 1 : 0).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void setInteractive(boolean z10, boolean z11) {
            InputMethodManager.this.mH.obtainMessage(13, z10 ? 1 : 0, z11 ? 1 : 0).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void scheduleStartInputIfNecessary(boolean z10) {
            InputMethodManager.this.mH.obtainMessage(4, 0, z10 ? 1 : 0).sendToTarget();
            InputMethodManager.this.mH.obtainMessage(4, 1, z10 ? 1 : 0).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void reportFullscreenMode(boolean z10) {
            InputMethodManager.this.mH.obtainMessage(10, z10 ? 1 : 0, 0).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void updateVirtualDisplayToScreenMatrix(int bindSequence, float[] matrixValues) {
            InputMethodManager.this.mH.obtainMessage(30, bindSequence, 0, matrixValues).sendToTarget();
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void setImeTraceEnabled(boolean enabled) {
            ImeTracing.getInstance().setEnabled(enabled);
        }

        @Override // com.android.internal.inputmethod.IInputMethodClient
        public void throwExceptionFromSystem(String message) {
            throw new RuntimeException(message);
        }
    };
    final AtomicBoolean mRequestCursorUpdateDisplayIdCheck = new AtomicBoolean(true);
    private InputMethodManagerWrapper mImmWrapper = new InputMethodManagerWrapper();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface FinishedInputEventCallback {
        void onFinishedInputEvent(Object obj, boolean z10);
    }

    public static void ensureDefaultInstanceForDefaultDisplayIfNecessary() {
        forContextInternal(0, Looper.getMainLooper());
    }

    private static boolean isAutofillUIShowing(View servedView) {
        AutofillManager afm = (AutofillManager) servedView.getContext().getSystemService(AutofillManager.class);
        return afm != null && afm.isAutofillUiShowing();
    }

    private InputMethodManager getFallbackInputMethodManagerIfNecessary(View view) {
        ViewRootImpl viewRootImpl;
        int viewRootDisplayId;
        if (view == null || (viewRootImpl = view.getViewRootImpl()) == null || (viewRootDisplayId = viewRootImpl.getDisplayId()) == this.mDisplayId) {
            return null;
        }
        InputMethodManager fallbackImm = (InputMethodManager) viewRootImpl.mContext.getSystemService(InputMethodManager.class);
        if (fallbackImm == null) {
            Log.v(TAG, "b/117267690: Failed to get non-null fallback IMM. view=" + ((Object) view));
            return null;
        }
        if (fallbackImm.mDisplayId != viewRootDisplayId) {
            Log.v(TAG, "b/117267690: Failed to get fallback IMM with expected displayId=" + viewRootDisplayId + " actual IMM#displayId=" + fallbackImm.mDisplayId + " view=" + ((Object) view));
            return null;
        }
        Log.v(TAG, "b/117267690: Display ID mismatch found. ViewRootImpl displayId=" + viewRootDisplayId + " InputMethodManager displayId=" + this.mDisplayId + ". Use the right InputMethodManager instance to avoid performance overhead.", new Throwable());
        return fallbackImm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getFallbackContextFromServedView() {
        synchronized (this.mH) {
            if (this.mCurRootView == null) {
                return null;
            }
            View view = this.mServedView;
            return view != null ? view.getContext() : null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canStartInput(View servedView) {
        return servedView.hasWindowFocus() || isAutofillUIShowing(servedView);
    }

    public void reportPerceptible(IBinder windowToken, boolean perceptible) {
        IInputMethodManagerGlobalInvoker.reportPerceptibleAsync(windowToken, perceptible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class DelegateImpl implements ImeFocusController.InputMethodManagerDelegate {
        private DelegateImpl() {
        }

        @Override // android.view.ImeFocusController.InputMethodManagerDelegate
        public void onPreWindowGainedFocus(ViewRootImpl viewRootImpl) {
            synchronized (InputMethodManager.this.mH) {
                setCurrentRootViewLocked(viewRootImpl);
                InputMethodManager.this.mCurRootViewWindowFocused = true;
            }
        }

        @Override // android.view.ImeFocusController.InputMethodManagerDelegate
        public void onPostWindowGainedFocus(View viewForWindowFocus, WindowManager.LayoutParams windowAttribute) {
            boolean forceFocus;
            boolean forceFocus2 = false;
            synchronized (InputMethodManager.this.mH) {
                boolean z10 = true;
                InputMethodManager.this.onViewFocusChangedInternal(viewForWindowFocus, true);
                if (InputMethodManager.this.mServedView != viewForWindowFocus) {
                    z10 = false;
                }
                boolean nextFocusIsServedView = z10;
                if (nextFocusIsServedView && !InputMethodManager.this.hasActiveInputConnectionInternal(viewForWindowFocus)) {
                    forceFocus2 = true;
                }
            }
            int softInputMode = windowAttribute.softInputMode;
            int windowFlags = windowAttribute.flags;
            int startInputFlags = InputMethodManager.this.getStartInputFlags(viewForWindowFocus, 0) | 8;
            ImeTracing.getInstance().triggerClientDump("InputMethodManager.DelegateImpl#startInputAsyncOnWindowFocusGain", InputMethodManager.this, null);
            synchronized (InputMethodManager.this.mH) {
                try {
                    try {
                        if (InputMethodManager.this.mCurRootView == null) {
                            return;
                        }
                        if (!InputMethodManager.this.mRestartOnNextWindowFocus) {
                            forceFocus = forceFocus2;
                        } else {
                            if (InputMethodManager.DEBUG) {
                                Log.v(InputMethodManager.TAG, "Restarting due to mRestartOnNextWindowFocus as true");
                            }
                            InputMethodManager.this.mRestartOnNextWindowFocus = false;
                            forceFocus = true;
                        }
                        try {
                            InputMethodManager inputMethodManager = InputMethodManager.this;
                            boolean checkFocusResult = inputMethodManager.checkFocusInternalLocked(forceFocus, inputMethodManager.mCurRootView);
                            if (checkFocusResult && InputMethodManager.this.startInputOnWindowFocusGainInternal(1, viewForWindowFocus, startInputFlags, softInputMode, windowFlags)) {
                                return;
                            }
                            synchronized (InputMethodManager.this.mH) {
                                try {
                                    try {
                                        if (InputMethodManager.DEBUG) {
                                            try {
                                                Log.v(InputMethodManager.TAG, "Reporting focus gain, without startInput");
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        }
                                        Trace.traceBegin(32L, "IMM.startInputOrWindowGainedFocus");
                                        IInputMethodManagerGlobalInvoker.startInputOrWindowGainedFocus(2, InputMethodManager.this.mClient, viewForWindowFocus.getWindowToken(), startInputFlags, softInputMode, windowFlags, null, null, null, InputMethodManager.this.mCurRootView.mContext.getApplicationInfo().targetSdkVersion, UserHandle.myUserId(), InputMethodManager.this.mImeDispatcher);
                                        Trace.traceEnd(32L);
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            while (true) {
                                try {
                                    break;
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        }

        @Override // android.view.ImeFocusController.InputMethodManagerDelegate
        public void onWindowLostFocus(ViewRootImpl viewRootImpl) {
            synchronized (InputMethodManager.this.mH) {
                if (InputMethodManager.this.mCurRootView == viewRootImpl) {
                    InputMethodManager.this.mCurRootViewWindowFocused = false;
                    InputMethodManager.this.clearCurRootViewIfNeeded();
                }
            }
        }

        @Override // android.view.ImeFocusController.InputMethodManagerDelegate
        public void onViewFocusChanged(View view, boolean hasFocus) {
            InputMethodManager.this.onViewFocusChangedInternal(view, hasFocus);
        }

        @Override // android.view.ImeFocusController.InputMethodManagerDelegate
        public void onScheduledCheckFocus(ViewRootImpl viewRootImpl) {
            synchronized (InputMethodManager.this.mH) {
                if (InputMethodManager.this.checkFocusInternalLocked(false, viewRootImpl)) {
                    InputMethodManager.this.startInputOnWindowFocusGainInternal(3, null, 0, 0, 0);
                }
            }
        }

        @Override // android.view.ImeFocusController.InputMethodManagerDelegate
        public void onViewDetachedFromWindow(View view, ViewRootImpl viewRootImpl) {
            synchronized (InputMethodManager.this.mH) {
                if (InputMethodManager.this.mCurRootView != view.getViewRootImpl()) {
                    return;
                }
                if (InputMethodManager.this.mNextServedView == view) {
                    InputMethodManager.this.mNextServedView = null;
                }
                if (InputMethodManager.this.mServedView == view) {
                    viewRootImpl.dispatchCheckFocus();
                }
            }
        }

        @Override // android.view.ImeFocusController.InputMethodManagerDelegate
        public void onWindowDismissed(ViewRootImpl viewRootImpl) {
            synchronized (InputMethodManager.this.mH) {
                if (InputMethodManager.this.mCurRootView != viewRootImpl) {
                    return;
                }
                if (InputMethodManager.this.mServedView != null) {
                    InputMethodManager.this.finishInputLocked();
                }
                setCurrentRootViewLocked(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurrentRootViewLocked(ViewRootImpl rootView) {
            InputMethodManager.this.mImeDispatcher.switchRootView(InputMethodManager.this.mCurRootView, rootView);
            InputMethodManager.this.mCurRootView = rootView;
            InputMethodManager.this.mImmWrapper.getExtImpl().updateCurrentRootView(rootView);
        }
    }

    public DelegateImpl getDelegate() {
        return this.mDelegate;
    }

    public boolean hasActiveInputConnection(View view) {
        boolean z10;
        RemoteInputConnectionImpl remoteInputConnectionImpl;
        synchronized (this.mH) {
            z10 = this.mCurRootView != null && view != null && this.mServedView == view && (remoteInputConnectionImpl = this.mServedInputConnection) != null && remoteInputConnectionImpl.isAssociatedWith(view) && isImeSessionAvailableLocked();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasActiveInputConnectionInternal(View view) {
        synchronized (this.mH) {
            boolean z10 = false;
            if (hasServedByInputMethodLocked(view) && isImeSessionAvailableLocked()) {
                RemoteInputConnectionImpl remoteInputConnectionImpl = this.mServedInputConnection;
                if (remoteInputConnectionImpl != null && remoteInputConnectionImpl.isAssociatedWith(view)) {
                    z10 = true;
                }
                return z10;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startInputOnWindowFocusGainInternal(int startInputReason, View focusedView, int startInputFlags, int softInputMode, int windowFlags) {
        synchronized (this.mH) {
            this.mCurrentEditorInfo = null;
            this.mCompletions = null;
            this.mServedConnecting = true;
        }
        return startInputInner(startInputReason, focusedView != null ? focusedView.getWindowToken() : null, startInputFlags, softInputMode, windowFlags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getServedViewLocked() {
        if (this.mCurRootView != null) {
            return this.mServedView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getNextServedViewLocked() {
        if (this.mCurRootView != null) {
            return this.mNextServedView;
        }
        return null;
    }

    private boolean hasServedByInputMethodLocked(View view) {
        View servedView = getServedViewLocked();
        return servedView == view || (servedView != null && servedView.checkInputConnectionProxy(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class H extends Handler {
        H(Looper looper) {
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            IAccessibilityInputMethodSessionInvoker invoker;
            switch (msg.what) {
                case 1:
                    SomeArgs args = (SomeArgs) msg.obj;
                    try {
                        InputMethodManager.this.doDump((FileDescriptor) args.arg1, (PrintWriter) args.arg2, (String[]) args.arg3);
                    } catch (RuntimeException e2) {
                        ((PrintWriter) args.arg2).println("Exception: " + ((Object) e2));
                    }
                    synchronized (args.arg4) {
                        ((CountDownLatch) args.arg4).countDown();
                    }
                    args.recycle();
                    return;
                case 2:
                    InputBindResult res = (InputBindResult) msg.obj;
                    if (InputMethodManager.DEBUG) {
                        Log.i(InputMethodManager.TAG, "handleMessage: MSG_BIND " + res.sequence + "," + res.f9159id);
                    }
                    synchronized (InputMethodManager.this.mH) {
                        int curBindSequence = InputMethodManager.this.getBindSequenceLocked();
                        if (curBindSequence >= 0 && curBindSequence == res.sequence) {
                            InputMethodManager.this.mRequestUpdateCursorAnchorInfoMonitorMode = 0;
                            InputMethodManager.this.updateInputChannelLocked(res.channel);
                            InputMethodManager.this.mCurMethod = res.method;
                            InputMethodManager.this.mCurBindState = new BindState(res);
                            InputMethodManager.this.mCurId = res.f9159id;
                            InputMethodManager.this.mVirtualDisplayToScreenMatrix = res.getVirtualDisplayToScreenMatrix();
                            InputMethodManager.this.startInputInner(6, null, 0, 0, 0);
                            return;
                        }
                        Log.w(InputMethodManager.TAG, "Ignoring onBind: cur seq=" + curBindSequence + ", given seq=" + res.sequence);
                        if (res.channel != null && res.channel != InputMethodManager.this.mCurChannel) {
                            res.channel.dispose();
                        }
                        return;
                    }
                case 3:
                    int sequence = msg.arg1;
                    int reason = msg.arg2;
                    if (InputMethodManager.DEBUG) {
                        Log.i(InputMethodManager.TAG, "handleMessage: MSG_UNBIND " + sequence + " reason=" + InputMethodDebug.unbindReasonToString(reason));
                    }
                    synchronized (InputMethodManager.this.mH) {
                        if (InputMethodManager.this.getBindSequenceLocked() != sequence) {
                            return;
                        }
                        InputMethodManager.this.clearAllAccessibilityBindingLocked();
                        InputMethodManager.this.clearBindingLocked();
                        View servedView = InputMethodManager.this.getServedViewLocked();
                        if (servedView != null && servedView.isFocused()) {
                            InputMethodManager.this.mServedConnecting = true;
                        }
                        boolean startInput = InputMethodManager.this.mActive;
                        if (startInput) {
                            InputMethodManager.this.startInputInner(7, null, 0, 0, 0);
                            return;
                        }
                        return;
                    }
                case 4:
                    boolean active = msg.arg1 != 0;
                    boolean fullscreen = msg.arg2 != 0;
                    if (InputMethodManager.DEBUG) {
                        Log.i(InputMethodManager.TAG, "handleMessage: MSG_SET_ACTIVE " + active + ", was " + InputMethodManager.this.mActive);
                    }
                    synchronized (InputMethodManager.this.mH) {
                        InputMethodManager.this.mActive = active;
                        InputMethodManager.this.mFullscreenMode = fullscreen;
                        if (!active) {
                            InputMethodManager.this.mRestartOnNextWindowFocus = true;
                            InputMethodManager.this.mFallbackInputConnection.finishComposingTextFromImm();
                            if (InputMethodManager.this.clearCurRootViewIfNeeded()) {
                                return;
                            }
                        }
                        View servedView2 = InputMethodManager.this.getServedViewLocked();
                        if (servedView2 != null && InputMethodManager.canStartInput(servedView2)) {
                            if (InputMethodManager.this.mCurRootView == null) {
                                return;
                            }
                            InputMethodManager inputMethodManager = InputMethodManager.this;
                            if (inputMethodManager.checkFocusInternalLocked(inputMethodManager.mRestartOnNextWindowFocus, InputMethodManager.this.mCurRootView)) {
                                InputMethodManager.this.mCurrentEditorInfo = null;
                                InputMethodManager.this.mCompletions = null;
                                InputMethodManager.this.mServedConnecting = true;
                                int reason2 = active ? 8 : 9;
                                InputMethodManager.this.startInputInner(reason2, null, 0, 0, 0);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                case 5:
                    InputMethodManager.this.sendInputEventAndReportResultOnMainLooper((PendingEvent) msg.obj);
                    return;
                case 6:
                    InputMethodManager.this.finishedInputEvent(msg.arg1, false, true);
                    return;
                case 7:
                    InputMethodManager.this.finishedInputEvent(msg.arg1, false, false);
                    return;
                case 10:
                    boolean fullscreen2 = msg.arg1 != 0;
                    RemoteInputConnectionImpl ic2 = null;
                    synchronized (InputMethodManager.this.mH) {
                        if (InputMethodManager.this.mFullscreenMode != fullscreen2 && InputMethodManager.this.mServedInputConnection != null) {
                            ic2 = InputMethodManager.this.mServedInputConnection;
                            InputMethodManager.this.mFullscreenMode = fullscreen2;
                        }
                    }
                    if (ic2 != null) {
                        ic2.dispatchReportFullscreenMode(fullscreen2);
                        return;
                    }
                    return;
                case 11:
                    int sequence2 = msg.arg1;
                    InputBindResult res2 = (InputBindResult) msg.obj;
                    if (InputMethodManager.DEBUG) {
                        Log.i(InputMethodManager.TAG, "handleMessage: MSG_BIND_ACCESSIBILITY " + res2.sequence + "," + res2.f9159id);
                    }
                    synchronized (InputMethodManager.this.mH) {
                        int curBindSequence2 = InputMethodManager.this.getBindSequenceLocked();
                        if (curBindSequence2 >= 0 && curBindSequence2 == res2.sequence) {
                            if (res2.accessibilitySessions != null && (invoker = IAccessibilityInputMethodSessionInvoker.createOrNull(res2.accessibilitySessions.get(sequence2))) != null) {
                                InputMethodManager.this.mAccessibilityInputMethodSession.put(sequence2, invoker);
                                if (InputMethodManager.this.mServedInputConnection != null) {
                                    invoker.updateSelection(InputMethodManager.this.mInitialSelStart, InputMethodManager.this.mInitialSelEnd, InputMethodManager.this.mCursorSelStart, InputMethodManager.this.mCursorSelEnd, InputMethodManager.this.mCursorCandStart, InputMethodManager.this.mCursorCandEnd);
                                } else {
                                    invoker.updateSelection(-1, -1, -1, -1, -1, -1);
                                }
                            }
                            InputMethodManager.this.startInputInner(12, null, 0, 0, 0);
                            return;
                        }
                        Log.w(InputMethodManager.TAG, "Ignoring onBind: cur seq=" + curBindSequence2 + ", given seq=" + res2.sequence);
                        if (res2.channel != null && res2.channel != InputMethodManager.this.mCurChannel) {
                            res2.channel.dispose();
                        }
                        return;
                    }
                case 12:
                    int sequence3 = msg.arg1;
                    int id2 = msg.arg2;
                    if (InputMethodManager.DEBUG) {
                        Log.i(InputMethodManager.TAG, "handleMessage: MSG_UNBIND_ACCESSIBILITY_SERVICE " + sequence3 + " id=" + id2);
                    }
                    synchronized (InputMethodManager.this.mH) {
                        if (InputMethodManager.this.getBindSequenceLocked() != sequence3) {
                            if (InputMethodManager.DEBUG) {
                                Log.i(InputMethodManager.TAG, "current BindSequence =" + InputMethodManager.this.getBindSequenceLocked() + " sequence =" + sequence3 + " id=" + id2);
                            }
                            return;
                        } else {
                            InputMethodManager.this.clearAccessibilityBindingLocked(id2);
                            return;
                        }
                    }
                case 13:
                    boolean interactive = msg.arg1 != 0;
                    boolean fullscreen3 = msg.arg2 != 0;
                    if (InputMethodManager.DEBUG) {
                        Log.i(InputMethodManager.TAG, "handleMessage: MSG_SET_INTERACTIVE " + interactive + ", was " + InputMethodManager.this.mActive);
                    }
                    synchronized (InputMethodManager.this.mH) {
                        InputMethodManager.this.mActive = interactive;
                        InputMethodManager.this.mFullscreenMode = fullscreen3;
                        if (interactive) {
                            View rootView = InputMethodManager.this.mCurRootView != null ? InputMethodManager.this.mCurRootView.getView() : null;
                            if (rootView == null) {
                                return;
                            }
                            final ViewRootImpl currentViewRootImpl = InputMethodManager.this.mCurRootView;
                            rootView.post(new Runnable() { // from class: android.view.inputmethod.InputMethodManager$H$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    InputMethodManager.H.this.lambda$handleMessage$0(currentViewRootImpl);
                                }
                            });
                        } else {
                            if (InputMethodManager.this.mImmWrapper.getExtImpl().ignoreFinishInput(InputMethodManager.this.mDisplayId)) {
                                InputMethodManager.this.mImmWrapper.getExtImpl().logDebugIme("ignoreFinishInput");
                                return;
                            }
                            InputMethodManager.this.finishInputLocked();
                            if (InputMethodManager.this.isImeSessionAvailableLocked()) {
                                InputMethodManager.this.mCurBindState.mImeSession.finishInput();
                            }
                            InputMethodManager.this.forAccessibilitySessionsLocked(new Consumer() { // from class: android.view.inputmethod.InputMethodManager$H$$ExternalSyntheticLambda1
                                @Override // java.util.function.Consumer
                                public final void accept(Object obj) {
                                    ((IAccessibilityInputMethodSessionInvoker) obj).finishInput();
                                }
                            });
                        }
                        return;
                    }
                case 30:
                    float[] matrixValues = (float[]) msg.obj;
                    int bindSequence = msg.arg1;
                    synchronized (InputMethodManager.this.mH) {
                        if (InputMethodManager.this.getBindSequenceLocked() != bindSequence) {
                            return;
                        }
                        if (matrixValues != null && InputMethodManager.this.mVirtualDisplayToScreenMatrix != null) {
                            float[] currentValues = new float[9];
                            InputMethodManager.this.mVirtualDisplayToScreenMatrix.getValues(currentValues);
                            if (Arrays.equals(currentValues, matrixValues)) {
                                return;
                            }
                            InputMethodManager.this.mVirtualDisplayToScreenMatrix.setValues(matrixValues);
                            if (InputMethodManager.this.mCursorAnchorInfo != null && InputMethodManager.this.isImeSessionAvailableLocked() && InputMethodManager.this.mServedInputConnection != null) {
                                if (InputMethodManager.this.mServedInputConnection.isCursorAnchorInfoMonitoring()) {
                                    InputMethodManager.this.mCurBindState.mImeSession.updateCursorAnchorInfo(CursorAnchorInfo.createForAdditionalParentMatrix(InputMethodManager.this.mCursorAnchorInfo, InputMethodManager.this.mVirtualDisplayToScreenMatrix));
                                    InputMethodManager.this.mImmWrapper.getExtImpl().updateCursorAnchorInfoToSynergy(CursorAnchorInfo.createForAdditionalParentMatrix(InputMethodManager.this.mCursorAnchorInfo, InputMethodManager.this.mVirtualDisplayToScreenMatrix));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        InputMethodManager.this.mVirtualDisplayToScreenMatrix = null;
                        return;
                    }
                case 31:
                    synchronized (InputMethodManager.this.mH) {
                        if (InputMethodManager.this.mImeInsetsConsumer != null) {
                            InputMethodManager.this.mImeInsetsConsumer.onShowRequested();
                        }
                    }
                    return;
                default:
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$0(ViewRootImpl currentViewRootImpl) {
            synchronized (InputMethodManager.this.mH) {
                if (InputMethodManager.this.mCurRootView != currentViewRootImpl) {
                    return;
                }
                View focusedView = currentViewRootImpl.getView().findFocus();
                InputMethodManager.this.onViewFocusChangedInternal(focusedView, focusedView != null);
            }
        }
    }

    static void tearDownEditMode() {
        if (!isInEditMode()) {
            throw new UnsupportedOperationException("This method must be called only from layoutlib");
        }
        synchronized (sLock) {
            sInstance = null;
        }
    }

    private static boolean isInEditMode() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isInEditModeInternal() {
        return isInEditMode();
    }

    private static InputMethodManager createInstance(int displayId, Looper looper) {
        return isInEditMode() ? createStubInstance(displayId, looper) : createRealInstance(displayId, looper);
    }

    private static InputMethodManager createRealInstance(int displayId, Looper looper) {
        IInputMethodManager service = IInputMethodManagerGlobalInvoker.getService();
        if (service == null) {
            throw new IllegalStateException("IInputMethodManager is not available");
        }
        InputMethodManager imm = new InputMethodManager(service, displayId, looper);
        long identity = Binder.clearCallingIdentity();
        try {
            IInputMethodManagerGlobalInvoker.addClient(imm.mClient, imm.mFallbackInputConnection, displayId);
            return imm;
        } finally {
            Binder.restoreCallingIdentity(identity);
        }
    }

    private static InputMethodManager createStubInstance(int displayId, Looper looper) {
        IInputMethodManager stubInterface = (IInputMethodManager) Proxy.newProxyInstance(IInputMethodManager.class.getClassLoader(), new Class[]{IInputMethodManager.class}, new InvocationHandler() { // from class: android.view.inputmethod.InputMethodManager$$ExternalSyntheticLambda1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return InputMethodManager.lambda$createStubInstance$0(obj, method, objArr);
            }
        });
        return new InputMethodManager(stubInterface, displayId, looper);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$createStubInstance$0(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> returnType = method.getReturnType();
        if (returnType == Boolean.TYPE) {
            return false;
        }
        if (returnType == Integer.TYPE) {
            return 0;
        }
        if (returnType == Long.TYPE) {
            return 0L;
        }
        if (returnType == Short.TYPE || returnType == Character.TYPE || returnType == Byte.TYPE) {
            return 0;
        }
        if (returnType == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (returnType == Double.TYPE) {
            return Double.valueOf(ShadowDrawableWrapper.COS_45);
        }
        return null;
    }

    private InputMethodManager(IInputMethodManager iInputMethodManager, int i10, Looper looper) {
        this.mService = iInputMethodManager;
        this.mMainLooper = looper;
        this.mH = new H(looper);
        this.mDisplayId = i10;
        this.mFallbackInputConnection = new RemoteInputConnectionImpl(looper, new BaseInputConnection(this, false), this, null);
    }

    public static InputMethodManager forContext(Context context) {
        int displayId = context.getDisplayId();
        Looper looper = displayId == 0 ? Looper.getMainLooper() : context.getMainLooper();
        sPreventImeStartupUnlessTextEditor = context.getResources().getBoolean(17891335);
        return forContextInternal(displayId, looper);
    }

    private static InputMethodManager forContextInternal(int displayId, Looper looper) {
        boolean isDefaultDisplay = displayId == 0;
        synchronized (sLock) {
            SparseArray<InputMethodManager> sparseArray = sInstanceMap;
            InputMethodManager instance = sparseArray.get(displayId);
            if (instance != null) {
                return instance;
            }
            InputMethodManager instance2 = createInstance(displayId, looper);
            if (sInstance == null && isDefaultDisplay) {
                sInstance = instance2;
            }
            sparseArray.put(displayId, instance2);
            return instance2;
        }
    }

    @Deprecated
    public static InputMethodManager getInstance() {
        Log.w(TAG, "InputMethodManager.getInstance() is deprecated because it cannot be compatible with multi-display. Use context.getSystemService(InputMethodManager.class) instead.", new Throwable());
        ensureDefaultInstanceForDefaultDisplayIfNecessary();
        return peekInstance();
    }

    @Deprecated
    public static InputMethodManager peekInstance() {
        InputMethodManager inputMethodManager;
        Log.w(TAG, "InputMethodManager.peekInstance() is deprecated because it cannot be compatible with multi-display. Use context.getSystemService(InputMethodManager.class) instead.", new Throwable());
        synchronized (sLock) {
            inputMethodManager = sInstance;
        }
        return inputMethodManager;
    }

    public List<InputMethodInfo> getInputMethodList() {
        return IInputMethodManagerGlobalInvoker.getInputMethodList(UserHandle.myUserId(), 0);
    }

    public boolean isStylusHandwritingAvailable() {
        return isStylusHandwritingAvailableAsUser(UserHandle.myUserId());
    }

    public boolean isStylusHandwritingAvailableAsUser(int userId) {
        Context fallbackContext = ActivityThread.currentApplication();
        if (fallbackContext == null) {
            return false;
        }
        return IInputMethodManagerGlobalInvoker.isStylusHandwritingAvailableAsUser(userId);
    }

    public List<InputMethodInfo> getInputMethodListAsUser(int userId) {
        return IInputMethodManagerGlobalInvoker.getInputMethodList(userId, 0);
    }

    public List<InputMethodInfo> getInputMethodListAsUser(int userId, int directBootAwareness) {
        return IInputMethodManagerGlobalInvoker.getInputMethodList(userId, directBootAwareness);
    }

    public InputMethodInfo getCurrentInputMethodInfo() {
        return IInputMethodManagerGlobalInvoker.getCurrentInputMethodInfoAsUser(UserHandle.myUserId());
    }

    @SystemApi
    public InputMethodInfo getCurrentInputMethodInfoAsUser(UserHandle user) {
        Objects.requireNonNull(user);
        return IInputMethodManagerGlobalInvoker.getCurrentInputMethodInfoAsUser(user.getIdentifier());
    }

    public List<InputMethodInfo> getEnabledInputMethodList() {
        return IInputMethodManagerGlobalInvoker.getEnabledInputMethodList(UserHandle.myUserId());
    }

    public List<InputMethodInfo> getEnabledInputMethodListAsUser(int userId) {
        return IInputMethodManagerGlobalInvoker.getEnabledInputMethodList(userId);
    }

    public List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi, boolean allowsImplicitlyEnabledSubtypes) {
        return IInputMethodManagerGlobalInvoker.getEnabledInputMethodSubtypeList(imi == null ? null : imi.getId(), allowsImplicitlyEnabledSubtypes, UserHandle.myUserId());
    }

    public List<InputMethodSubtype> getEnabledInputMethodSubtypeListAsUser(String imeId, boolean allowsImplicitlyEnabledSubtypes, int userId) {
        return IInputMethodManagerGlobalInvoker.getEnabledInputMethodSubtypeList((String) Objects.requireNonNull(imeId), allowsImplicitlyEnabledSubtypes, userId);
    }

    @Deprecated
    public void showStatusIcon(IBinder imeToken, String packageName, int iconId) {
        InputMethodPrivilegedOperationsRegistry.get(imeToken).updateStatusIconAsync(packageName, iconId);
    }

    @Deprecated
    public void hideStatusIcon(IBinder imeToken) {
        InputMethodPrivilegedOperationsRegistry.get(imeToken).updateStatusIconAsync(null, 0);
    }

    @Deprecated
    public void registerSuggestionSpansForNotification(SuggestionSpan[] spans) {
        Log.w(TAG, "registerSuggestionSpansForNotification() is deprecated.  Does nothing.");
    }

    @Deprecated
    public void notifySuggestionPicked(SuggestionSpan span, String originalString, int index) {
        Log.w(TAG, "notifySuggestionPicked() is deprecated.  Does nothing.");
    }

    public boolean isFullscreenMode() {
        boolean z10;
        synchronized (this.mH) {
            z10 = this.mFullscreenMode;
        }
        return z10;
    }

    public boolean isActive(View view) {
        boolean z10;
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            return fallbackImm.isActive(view);
        }
        checkFocus();
        synchronized (this.mH) {
            z10 = hasServedByInputMethodLocked(view) && this.mCurrentEditorInfo != null;
        }
        return z10;
    }

    public boolean isActive() {
        boolean z10;
        checkFocus();
        synchronized (this.mH) {
            z10 = (getServedViewLocked() == null || this.mCurrentEditorInfo == null) ? false : true;
        }
        return z10;
    }

    public boolean isCurrentRootView(View attachedView) {
        boolean z10;
        synchronized (this.mH) {
            z10 = this.mCurRootView == attachedView.getViewRootImpl();
        }
        return z10;
    }

    public boolean isAcceptingText() {
        boolean z10;
        checkFocus();
        synchronized (this.mH) {
            z10 = this.mServedInputConnection != null;
        }
        return z10;
    }

    public boolean isInputMethodSuppressingSpellChecker() {
        boolean z10;
        synchronized (this.mH) {
            BindState bindState = this.mCurBindState;
            z10 = bindState != null && bindState.mIsInputMethodSuppressingSpellChecker;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBindingLocked() {
        if (DEBUG) {
            Log.v(TAG, "Clearing binding!");
        }
        clearConnectionLocked();
        updateInputChannelLocked(null);
        this.mCurId = null;
        this.mCurMethod = null;
        this.mCurBindState = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccessibilityBindingLocked(int id2) {
        if (DEBUG) {
            Log.v(TAG, "Clearing accessibility binding " + id2);
        }
        this.mAccessibilityInputMethodSession.remove(id2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllAccessibilityBindingLocked() {
        if (DEBUG) {
            Log.v(TAG, "Clearing all accessibility bindings");
        }
        this.mAccessibilityInputMethodSession.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInputChannelLocked(InputChannel channel) {
        if (areSameInputChannel(this.mCurChannel, channel)) {
            return;
        }
        if (this.mCurSender != null) {
            flushPendingEventsLocked();
            this.mCurSender.dispose();
            this.mCurSender = null;
        }
        InputChannel inputChannel = this.mCurChannel;
        if (inputChannel != null) {
            inputChannel.dispose();
        }
        this.mCurChannel = channel;
    }

    private static boolean areSameInputChannel(InputChannel lhs, InputChannel rhs) {
        if (lhs == rhs) {
            return true;
        }
        if (lhs != null && rhs != null && lhs.getToken() == rhs.getToken()) {
            return true;
        }
        return false;
    }

    private void clearConnectionLocked() {
        this.mCurrentEditorInfo = null;
        this.mPreviousViewFocusParameters = null;
        RemoteInputConnectionImpl remoteInputConnectionImpl = this.mServedInputConnection;
        if (remoteInputConnectionImpl != null) {
            remoteInputConnectionImpl.deactivate();
            this.mServedInputConnection = null;
            this.mServedInputConnectionHandler = null;
        }
    }

    void finishInputLocked() {
        this.mVirtualDisplayToScreenMatrix = null;
        View clearedView = null;
        this.mNextServedView = null;
        if (this.mServedView != null) {
            clearedView = this.mServedView;
            this.mServedView = null;
        }
        if (clearedView != null) {
            if (DEBUG) {
                Log.v(TAG, "FINISH INPUT: mServedView=" + InputMethodDebug.dumpViewInfo(clearedView));
            }
            this.mCompletions = null;
            this.mServedConnecting = false;
            clearConnectionLocked();
        }
        this.mImeDispatcher.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clearCurRootViewIfNeeded() {
        if (!this.mActive && !this.mCurRootViewWindowFocused) {
            finishInputLocked();
            this.mDelegate.setCurrentRootViewLocked(null);
            return true;
        }
        return false;
    }

    public void displayCompletions(View view, CompletionInfo[] completions) {
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.displayCompletions(view, completions);
            return;
        }
        checkFocus();
        synchronized (this.mH) {
            if (hasServedByInputMethodLocked(view)) {
                this.mCompletions = completions;
                if (isImeSessionAvailableLocked()) {
                    this.mCurBindState.mImeSession.displayCompletions(this.mCompletions);
                }
            }
        }
    }

    public void updateExtractedText(View view, int token, ExtractedText text) {
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.updateExtractedText(view, token, text);
            return;
        }
        checkFocus();
        synchronized (this.mH) {
            if (hasServedByInputMethodLocked(view)) {
                if (isImeSessionAvailableLocked()) {
                    this.mCurBindState.mImeSession.updateExtractedText(token, text);
                }
            }
        }
    }

    public boolean showSoftInput(View view, int flags) {
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            return fallbackImm.showSoftInput(view, flags);
        }
        return showSoftInput(view, flags, null);
    }

    public boolean showSoftInput(View view, int flags, ResultReceiver resultReceiver) {
        return showSoftInput(view, null, flags, resultReceiver, 1);
    }

    private boolean showSoftInput(View view, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver, int reason) {
        if (statsToken == null) {
            statsToken = ImeTracker.forLogging().onRequestShow(null, Process.myUid(), 1, reason);
        }
        ImeTracker.forLatency().onRequestShow(statsToken, 1, reason, new InsetsController$$ExternalSyntheticLambda2());
        ImeTracing.getInstance().triggerClientDump("InputMethodManager#showSoftInput", this, null);
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            return fallbackImm.showSoftInput(view, flags, resultReceiver);
        }
        this.mImmWrapper.getExtImpl().onCallShowBeforeCheckFocus(view);
        checkFocus();
        synchronized (this.mH) {
            this.mImmWrapper.getExtImpl().logMethodCallers("showSoftInput");
            if (!hasServedByInputMethodLocked(view)) {
                ImeTracker.forLogging().onFailed(statsToken, 1);
                ImeTracker.forLatency().onShowFailed(statsToken, 1, new InsetsController$$ExternalSyntheticLambda2());
                Log.w(TAG, "Ignoring showSoftInput() as view=" + ((Object) view) + " is not served.");
                return false;
            }
            ImeTracker.forLogging().onProgress(statsToken, 1);
            int flags2 = this.mImmWrapper.getExtImpl().adjustForceFlag(flags);
            H h10 = this.mH;
            h10.executeOrSendMessage(Message.obtain(h10, 31));
            if (view != null && view.getViewRootImpl() != null && view.getContext() != null) {
                view.getViewRootImpl().getWrapper().getExtImpl().showSoftInput(view.getContext().toString());
            }
            Log.d(TAG, "showSoftInput() view=" + ((Object) view) + " flags=" + flags2 + " reason=" + InputMethodDebug.softInputDisplayReasonToString(reason));
            return IInputMethodManagerGlobalInvoker.showSoftInput(this.mClient, view.getWindowToken(), statsToken, flags2, this.mCurRootView.getLastClickToolType(), resultReceiver, reason);
        }
    }

    @Deprecated
    public void showSoftInputUnchecked(int flags, ResultReceiver resultReceiver) {
        synchronized (this.mH) {
            ImeTracker.Token statsToken = ImeTracker.forLogging().onRequestShow(null, Process.myUid(), 1, 1);
            Log.w(TAG, "showSoftInputUnchecked() is a hidden method, which will be removed soon. If you are using androidx.appcompat.widget.SearchView, please update to version 26.0 or newer version.");
            ViewRootImpl viewRootImpl = this.mCurRootView;
            if (viewRootImpl != null && viewRootImpl.getView() != null) {
                ImeTracker.forLogging().onProgress(statsToken, 1);
                this.mImmWrapper.getExtImpl().logMethodCallers("showSoftInputUncheck");
                H h10 = this.mH;
                h10.executeOrSendMessage(Message.obtain(h10, 31));
                IInputMethodManagerGlobalInvoker.showSoftInput(this.mClient, this.mCurRootView.getView().getWindowToken(), statsToken, flags, this.mCurRootView.getLastClickToolType(), resultReceiver, 1);
                return;
            }
            ImeTracker.forLogging().onFailed(statsToken, 1);
            Log.w(TAG, "No current root view, ignoring showSoftInputUnchecked()");
        }
    }

    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags) {
        return hideSoftInputFromWindow(windowToken, flags, null);
    }

    public boolean hideSoftInputFromWindow(IBinder windowToken, int flags, ResultReceiver resultReceiver) {
        return hideSoftInputFromWindow(windowToken, flags, resultReceiver, 4);
    }

    private boolean hideSoftInputFromWindow(IBinder windowToken, int flags, ResultReceiver resultReceiver, int reason) {
        ImeTracker.Token statsToken = ImeTracker.forLogging().onRequestHide(null, Process.myUid(), 2, reason);
        ImeTracker.forLatency().onRequestHide(statsToken, 2, reason, new InsetsController$$ExternalSyntheticLambda2());
        ImeTracing.getInstance().triggerClientDump("InputMethodManager#hideSoftInputFromWindow", this, null);
        checkFocus();
        synchronized (this.mH) {
            View servedView = getServedViewLocked();
            if (servedView != null && servedView.getWindowToken() == windowToken) {
                this.mImmWrapper.getExtImpl().logMethodCallers("hideSoftInputFromWindow");
                if (servedView.getViewRootImpl() != null && servedView.getContext() != null) {
                    servedView.getViewRootImpl().getWrapper().getExtImpl().hideSoftInputFromWindow(servedView.getContext().toString());
                }
                ImeTracker.forLogging().onProgress(statsToken, 1);
                return IInputMethodManagerGlobalInvoker.hideSoftInput(this.mClient, windowToken, statsToken, flags, resultReceiver, reason);
            }
            ImeTracker.forLogging().onFailed(statsToken, 1);
            ImeTracker.forLatency().onHideFailed(statsToken, 1, new InsetsController$$ExternalSyntheticLambda2());
            return false;
        }
    }

    public void startStylusHandwriting(View view) {
        startStylusHandwritingInternal(view, null);
    }

    private boolean startStylusHandwritingInternal(View view, String delegatorPackageName) {
        Objects.requireNonNull(view);
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.startStylusHandwritingInternal(view, delegatorPackageName);
        }
        boolean useDelegation = !TextUtils.isEmpty(delegatorPackageName);
        checkFocus();
        synchronized (this.mH) {
            if (!hasServedByInputMethodLocked(view)) {
                Log.w(TAG, "Ignoring startStylusHandwriting as view=" + ((Object) view) + " is not served.");
                return false;
            }
            if (view.getViewRootImpl() != this.mCurRootView) {
                Log.w(TAG, "Ignoring startStylusHandwriting: View's window does not have focus.");
                return false;
            }
            if (useDelegation) {
                return IInputMethodManagerGlobalInvoker.acceptStylusHandwritingDelegation(this.mClient, UserHandle.myUserId(), view.getContext().getOpPackageName(), delegatorPackageName);
            }
            IInputMethodManagerGlobalInvoker.startStylusHandwriting(this.mClient);
            return false;
        }
    }

    public void prepareStylusHandwritingDelegation(View delegatorView) {
        prepareStylusHandwritingDelegation(delegatorView, delegatorView.getContext().getOpPackageName());
    }

    public void prepareStylusHandwritingDelegation(View delegatorView, String delegatePackageName) {
        Objects.requireNonNull(delegatorView);
        Objects.requireNonNull(delegatePackageName);
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(delegatorView);
        if (fallbackImm != null) {
            fallbackImm.prepareStylusHandwritingDelegation(delegatorView, delegatePackageName);
        }
        IInputMethodManagerGlobalInvoker.prepareStylusHandwritingDelegation(this.mClient, UserHandle.myUserId(), delegatePackageName, delegatorView.getContext().getOpPackageName());
    }

    public boolean acceptStylusHandwritingDelegation(View delegateView) {
        return startStylusHandwritingInternal(delegateView, delegateView.getContext().getOpPackageName());
    }

    public boolean acceptStylusHandwritingDelegation(View delegateView, String delegatorPackageName) {
        Objects.requireNonNull(delegatorPackageName);
        return startStylusHandwritingInternal(delegateView, delegatorPackageName);
    }

    @Deprecated
    public void toggleSoftInputFromWindow(IBinder windowToken, int showFlags, int hideFlags) {
        ImeTracing.getInstance().triggerClientDump("InputMethodManager#toggleSoftInputFromWindow", this, null);
        synchronized (this.mH) {
            View servedView = getServedViewLocked();
            if (servedView != null && servedView.getWindowToken() == windowToken) {
                this.mImmWrapper.getExtImpl().logMethodCallers("toggleSoftInputFromWindow");
                toggleSoftInput(showFlags, hideFlags);
            }
        }
    }

    @Deprecated
    public void toggleSoftInput(int showFlags, int hideFlags) {
        ImeTracing.getInstance().triggerClientDump("InputMethodManager#toggleSoftInput", this, null);
        this.mImmWrapper.getExtImpl().logMethodCallers("toggleSoftInput");
        synchronized (this.mH) {
            View view = getServedViewLocked();
            if (view != null) {
                WindowInsets rootInsets = view.getRootWindowInsets();
                if (rootInsets != null && rootInsets.isVisible(WindowInsets.Type.ime())) {
                    hideSoftInputFromWindow(view.getWindowToken(), hideFlags, null, 25);
                } else {
                    showSoftInput(view, null, showFlags, null, 24);
                }
            }
        }
    }

    public void restartInput(View view) {
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.restartInput(view);
            return;
        }
        checkFocus();
        synchronized (this.mH) {
            if (hasServedByInputMethodLocked(view)) {
                this.mServedConnecting = true;
                startInputInner(4, null, 0, 0, 0);
            }
        }
    }

    public boolean doInvalidateInput(RemoteInputConnectionImpl inputConnection, TextSnapshot textSnapshot, final int sessionId) {
        synchronized (this.mH) {
            if (this.mServedInputConnection == inputConnection && this.mCurrentEditorInfo != null) {
                if (!isImeSessionAvailableLocked()) {
                    return false;
                }
                final EditorInfo editorInfo = this.mCurrentEditorInfo.createCopyInternal();
                int selectionStart = textSnapshot.getSelectionStart();
                this.mCursorSelStart = selectionStart;
                editorInfo.initialSelStart = selectionStart;
                int selectionEnd = textSnapshot.getSelectionEnd();
                this.mCursorSelEnd = selectionEnd;
                editorInfo.initialSelEnd = selectionEnd;
                this.mCursorCandStart = textSnapshot.getCompositionStart();
                this.mCursorCandEnd = textSnapshot.getCompositionEnd();
                editorInfo.initialCapsMode = textSnapshot.getCursorCapsMode();
                editorInfo.setInitialSurroundingTextInternal(textSnapshot.getSurroundingText());
                this.mImmWrapper.getExtImpl().invalidateInputToSynergy(editorInfo, this.mServedInputConnection, sessionId);
                this.mCurBindState.mImeSession.invalidateInput(editorInfo, this.mServedInputConnection, sessionId);
                final IRemoteAccessibilityInputConnection accessibilityInputConnection = this.mServedInputConnection.asIRemoteAccessibilityInputConnection();
                forAccessibilitySessionsLocked(new Consumer() { // from class: android.view.inputmethod.InputMethodManager$$ExternalSyntheticLambda2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((IAccessibilityInputMethodSessionInvoker) obj).invalidateInput(EditorInfo.this, accessibilityInputConnection, sessionId);
                    }
                });
                return true;
            }
            return true;
        }
    }

    public void invalidateInput(View view) {
        Objects.requireNonNull(view);
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.invalidateInput(view);
            return;
        }
        synchronized (this.mH) {
            if (this.mServedInputConnection != null && getServedViewLocked() == view) {
                this.mImmWrapper.getExtImpl().logMethodCallers("invalidateInput");
                this.mServedInputConnection.scheduleInvalidateInput();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e3 A[Catch: all -> 0x0145, TRY_ENTER, TryCatch #5 {all -> 0x0145, blocks: (B:189:0x0104, B:72:0x010d, B:75:0x0128, B:78:0x0130, B:80:0x0136, B:81:0x013f, B:85:0x015f, B:91:0x01af, B:97:0x01e3, B:99:0x01e7, B:100:0x01ee, B:105:0x01f6, B:183:0x013b), top: B:188:0x0104 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean startInputInner(final int r35, android.os.IBinder r36, int r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 1092
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.inputmethod.InputMethodManager.startInputInner(int, android.os.IBinder, int, int, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startInputInner$2(int startInputReason) {
        startInputOnWindowFocusGainInternal(startInputReason, null, 0, 0, 0);
    }

    private boolean isSwitchingBetweenEquivalentNonEditableViews(ViewFocusParameterInfo previousViewFocusParameters, int startInputFlags, int startInputReason, int softInputMode, int windowFlags) {
        return (startInputFlags & 8) == 0 && (startInputFlags & 2) == 0 && previousViewFocusParameters != null && previousViewFocusParameters.sameAs(this.mCurrentEditorInfo, startInputFlags, startInputReason, softInputMode, windowFlags);
    }

    private void reportInputConnectionOpened(InputConnection ic2, EditorInfo editorInfo, Handler icHandler, View view) {
        view.onInputConnectionOpenedInternal(ic2, editorInfo, icHandler);
        ViewRootImpl viewRoot = view.getViewRootImpl();
        if (viewRoot != null) {
            viewRoot.getHandwritingInitiator().onInputConnectionCreated(view);
        }
    }

    public void addVirtualStylusIdForTestSession() {
        synchronized (this.mH) {
            IInputMethodManagerGlobalInvoker.addVirtualStylusIdForTestSession(this.mClient);
        }
    }

    public void setStylusWindowIdleTimeoutForTest(long timeout) {
        synchronized (this.mH) {
            IInputMethodManagerGlobalInvoker.setStylusWindowIdleTimeoutForTest(this.mClient, timeout);
        }
    }

    @Deprecated
    public void windowDismissed(IBinder appWindowToken) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStartInputFlags(View focusedView, int startInputFlags) {
        int startInputFlags2 = startInputFlags | 1;
        if (focusedView.onCheckIsTextEditor()) {
            startInputFlags2 |= 2;
        }
        return this.mImmWrapper.getExtImpl().adjustStartInputFlags(startInputFlags2);
    }

    public void checkFocus() {
        synchronized (this.mH) {
            if (this.mCurRootView == null) {
                return;
            }
            boolean needForceNewFocus = this.mImmWrapper.getExtImpl().needForceNewFocus();
            if (checkFocusInternalLocked(needForceNewFocus, this.mCurRootView)) {
                startInputOnWindowFocusGainInternal(5, null, 0, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkFocusInternalLocked(boolean forceNewFocus, ViewRootImpl viewRootImpl) {
        if (this.mCurRootView != viewRootImpl) {
            return false;
        }
        if (this.mServedView == this.mNextServedView && !forceNewFocus) {
            return false;
        }
        if (DEBUG) {
            StringBuilder append = new StringBuilder().append("checkFocus: view=").append((Object) this.mServedView).append(" next=").append((Object) this.mNextServedView).append(" force=").append(forceNewFocus).append(" package=");
            View view = this.mServedView;
            Log.v(TAG, append.append(view != null ? view.getContext().getPackageName() : "<none>").toString());
        }
        View view2 = this.mNextServedView;
        if (view2 == null) {
            finishInputLocked();
            closeCurrentInput();
            return false;
        }
        this.mServedView = view2;
        RemoteInputConnectionImpl remoteInputConnectionImpl = this.mServedInputConnection;
        if (remoteInputConnectionImpl != null) {
            remoteInputConnectionImpl.finishComposingTextFromImm();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onViewFocusChangedInternal(View view, boolean hasFocus) {
        if (view == null || view.isTemporarilyDetached()) {
            if (DEBUG) {
                Log.v(TAG, "onViewFocusChanged return, view = " + ((Object) view));
                return;
            }
            return;
        }
        ViewRootImpl viewRootImpl = view.getViewRootImpl();
        synchronized (this.mH) {
            if (this.mCurRootView != viewRootImpl) {
                if (DEBUG) {
                    Log.v(TAG, "onViewFocusChanged return, ViewRootImpl = " + ((Object) viewRootImpl));
                }
                return;
            }
            if (view.hasImeFocus() && view.hasWindowFocus()) {
                if (DEBUG) {
                    Log.d(TAG, "onViewFocusChangedInternal, view=" + InputMethodDebug.dumpViewInfo(view));
                }
                if (!hasFocus) {
                    this.mImmWrapper.getExtImpl().logMethodCallers("onViewFocusChanged");
                }
                if (hasFocus) {
                    this.mNextServedView = view;
                }
                viewRootImpl.dispatchCheckFocus();
                return;
            }
            if (DEBUG) {
                Log.v(TAG, "onViewFocusChanged return, hasImeFocus = " + view.hasImeFocus() + " hasWindowFocus = " + view.hasWindowFocus());
            }
        }
    }

    void closeCurrentInput() {
        ImeTracker.Token statsToken = ImeTracker.forLogging().onRequestHide(null, Process.myUid(), 2, 4);
        ImeTracker.forLatency().onRequestHide(statsToken, 2, 4, new InsetsController$$ExternalSyntheticLambda2());
        synchronized (this.mH) {
            ViewRootImpl viewRootImpl = this.mCurRootView;
            if (viewRootImpl != null && viewRootImpl.getView() != null) {
                ImeTracker.forLogging().onProgress(statsToken, 1);
                this.mImmWrapper.getExtImpl().logMethodCallers("closeCurrentInput");
                IInputMethodManagerGlobalInvoker.hideSoftInput(this.mClient, this.mCurRootView.getView().getWindowToken(), statsToken, 2, null, 4);
                return;
            }
            ImeTracker.forLogging().onFailed(statsToken, 1);
            ImeTracker.forLatency().onHideFailed(statsToken, 1, new InsetsController$$ExternalSyntheticLambda2());
            Log.w(TAG, "No current root view, ignoring closeCurrentInput()");
        }
    }

    public void registerImeConsumer(ImeInsetsSourceConsumer imeInsetsConsumer) {
        if (imeInsetsConsumer == null) {
            throw new IllegalStateException("ImeInsetsSourceConsumer cannot be null.");
        }
        synchronized (this.mH) {
            this.mImeInsetsConsumer = imeInsetsConsumer;
        }
    }

    public void unregisterImeConsumer(ImeInsetsSourceConsumer imeInsetsConsumer) {
        if (imeInsetsConsumer == null) {
            throw new IllegalStateException("ImeInsetsSourceConsumer cannot be null.");
        }
        synchronized (this.mH) {
            if (this.mImeInsetsConsumer == imeInsetsConsumer) {
                this.mImeInsetsConsumer = null;
            }
        }
    }

    public boolean requestImeShow(IBinder windowToken, ImeTracker.Token statsToken) {
        checkFocus();
        synchronized (this.mH) {
            View servedView = getServedViewLocked();
            if (servedView != null && servedView.getWindowToken() == windowToken) {
                ImeTracker.forLogging().onProgress(statsToken, 37);
                showSoftInput(servedView, statsToken, 0, null, 26);
                return true;
            }
            ImeTracker.forLogging().onFailed(statsToken, 37);
            return false;
        }
    }

    public void notifyImeHidden(IBinder windowToken, ImeTracker.Token statsToken) {
        ViewRootImpl viewRootImpl;
        if (statsToken == null) {
            statsToken = ImeTracker.forLogging().onRequestHide(null, Process.myUid(), 2, 28);
        }
        ImeTracker.forLatency().onRequestHide(statsToken, 2, 28, new InsetsController$$ExternalSyntheticLambda2());
        ImeTracing.getInstance().triggerClientDump("InputMethodManager#notifyImeHidden", this, null);
        synchronized (this.mH) {
            if (isImeSessionAvailableLocked() && (viewRootImpl = this.mCurRootView) != null && viewRootImpl.getWindowToken() == windowToken) {
                ImeTracker.forLogging().onProgress(statsToken, 1);
                this.mImmWrapper.getExtImpl().logMethodCallers("notifyImeHidden");
                IInputMethodManagerGlobalInvoker.hideSoftInput(this.mClient, windowToken, statsToken, 0, null, 28);
                return;
            }
            ImeTracker.forLogging().onFailed(statsToken, 1);
            ImeTracker.forLatency().onHideFailed(statsToken, 1, new InsetsController$$ExternalSyntheticLambda2());
        }
    }

    public void removeImeSurface(IBinder windowToken) {
        synchronized (this.mH) {
            this.mImmWrapper.getExtImpl().logMethodCallers("removeImeSurface");
            IInputMethodManagerGlobalInvoker.removeImeSurfaceFromWindowAsync(windowToken);
        }
    }

    public void updateSelection(View view, final int selStart, final int selEnd, final int candidatesStart, final int candidatesEnd) {
        H h10;
        H h11;
        H h12;
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.updateSelection(view, selStart, selEnd, candidatesStart, candidatesEnd);
            return;
        }
        checkFocus();
        H h13 = this.mH;
        synchronized (h13) {
            try {
                try {
                    if (!hasServedByInputMethodLocked(view) || this.mCurrentEditorInfo == null) {
                        h11 = h13;
                    } else if (isImeSessionAvailableLocked()) {
                        RemoteInputConnectionImpl remoteInputConnectionImpl = this.mServedInputConnection;
                        if (remoteInputConnectionImpl == null || !remoteInputConnectionImpl.hasPendingInvalidation()) {
                            try {
                                if (this.mCursorSelStart == selStart && this.mCursorSelEnd == selEnd && this.mCursorCandStart == candidatesStart && this.mCursorCandEnd == candidatesEnd) {
                                    h12 = h13;
                                    return;
                                }
                                this.mCurBindState.mImeSession.updateSelection(this.mCursorSelStart, this.mCursorSelEnd, selStart, selEnd, candidatesStart, candidatesEnd);
                                h12 = h13;
                                forAccessibilitySessionsLocked(new Consumer() { // from class: android.view.inputmethod.InputMethodManager$$ExternalSyntheticLambda3
                                    @Override // java.util.function.Consumer
                                    public final void accept(Object obj) {
                                        InputMethodManager.this.lambda$updateSelection$3(selStart, selEnd, candidatesStart, candidatesEnd, (IAccessibilityInputMethodSessionInvoker) obj);
                                    }
                                });
                                this.mCursorSelStart = selStart;
                                this.mCursorSelEnd = selEnd;
                                this.mCursorCandStart = candidatesStart;
                                this.mCursorCandEnd = candidatesEnd;
                                return;
                            } catch (Throwable th) {
                                th = th;
                                h10 = h13;
                                throw th;
                            }
                            if (DEBUG) {
                                Log.d(TAG, "updateSelection");
                            }
                            if (DEBUG) {
                                Log.v(TAG, "SELECTION CHANGE: " + ((Object) this.mCurBindState.mImeSession));
                            }
                        }
                    } else {
                        h11 = h13;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    h10 = h13;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSelection$3(int selStart, int selEnd, int candidatesStart, int candidatesEnd, IAccessibilityInputMethodSessionInvoker wrapper) {
        wrapper.updateSelection(this.mCursorSelStart, this.mCursorSelEnd, selStart, selEnd, candidatesStart, candidatesEnd);
    }

    @Deprecated
    public void viewClicked(View view) {
        View servedView;
        View nextServedView;
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.viewClicked(view);
            return;
        }
        synchronized (this.mH) {
            servedView = getServedViewLocked();
            nextServedView = getNextServedViewLocked();
        }
        boolean focusChanged = servedView != nextServedView;
        checkFocus();
        synchronized (this.mH) {
            if (hasServedByInputMethodLocked(view) && this.mCurrentEditorInfo != null && isImeSessionAvailableLocked()) {
                if (DEBUG) {
                    Log.v(TAG, "onViewClicked: " + focusChanged);
                }
                this.mCurBindState.mImeSession.viewClicked(focusChanged);
            }
        }
    }

    @Deprecated
    public boolean isWatchingCursor(View view) {
        return false;
    }

    @Deprecated
    public boolean isCursorAnchorInfoEnabled() {
        boolean z10;
        synchronized (this.mH) {
            int i10 = this.mRequestUpdateCursorAnchorInfoMonitorMode;
            boolean isImmediate = (i10 & 1) != 0;
            boolean isMonitoring = (i10 & 2) != 0;
            z10 = isImmediate || isMonitoring;
        }
        return z10;
    }

    @Deprecated
    public void setUpdateCursorAnchorInfoMode(int flags) {
        synchronized (this.mH) {
            this.mRequestUpdateCursorAnchorInfoMonitorMode = flags;
        }
    }

    @Deprecated
    public void updateCursor(View view, int left, int top, int right, int bottom) {
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.updateCursor(view, left, top, right, bottom);
            return;
        }
        checkFocus();
        synchronized (this.mH) {
            if (hasServedByInputMethodLocked(view) && this.mCurrentEditorInfo != null && isImeSessionAvailableLocked()) {
                this.mTmpCursorRect.set(left, top, right, bottom);
                if (!this.mCursorRect.equals(this.mTmpCursorRect)) {
                    if (DEBUG) {
                        Log.d(TAG, "updateCursor: " + ((Object) this.mCurBindState.mImeSession));
                    }
                    this.mCurBindState.mImeSession.updateCursor(this.mTmpCursorRect);
                    this.mCursorRect.set(this.mTmpCursorRect);
                }
            }
        }
    }

    public void updateCursorAnchorInfo(View view, CursorAnchorInfo cursorAnchorInfo) {
        if (view == null || cursorAnchorInfo == null) {
            return;
        }
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.updateCursorAnchorInfo(view, cursorAnchorInfo);
            return;
        }
        checkFocus();
        synchronized (this.mH) {
            if (hasServedByInputMethodLocked(view) && this.mCurrentEditorInfo != null && isImeSessionAvailableLocked()) {
                RemoteInputConnectionImpl remoteInputConnectionImpl = this.mServedInputConnection;
                boolean isImmediate = remoteInputConnectionImpl != null && remoteInputConnectionImpl.resetHasPendingImmediateCursorAnchorInfoUpdate();
                if (!isImmediate && Objects.equals(this.mCursorAnchorInfo, cursorAnchorInfo)) {
                    if (DEBUG) {
                        Log.w(TAG, "Ignoring redundant updateCursorAnchorInfo: info=" + ((Object) cursorAnchorInfo));
                    }
                    return;
                }
                if (DEBUG) {
                    Log.v(TAG, "updateCursorAnchorInfo: " + ((Object) cursorAnchorInfo));
                }
                if (this.mVirtualDisplayToScreenMatrix != null) {
                    this.mCurBindState.mImeSession.updateCursorAnchorInfo(CursorAnchorInfo.createForAdditionalParentMatrix(cursorAnchorInfo, this.mVirtualDisplayToScreenMatrix));
                    this.mImmWrapper.getExtImpl().updateCursorAnchorInfoToSynergy(CursorAnchorInfo.createForAdditionalParentMatrix(cursorAnchorInfo, this.mVirtualDisplayToScreenMatrix));
                } else {
                    this.mCurBindState.mImeSession.updateCursorAnchorInfo(cursorAnchorInfo);
                    this.mImmWrapper.getExtImpl().updateCursorAnchorInfoToSynergy(cursorAnchorInfo);
                }
                this.mCursorAnchorInfo = cursorAnchorInfo;
            }
        }
    }

    public void sendAppPrivateCommand(View view, String action, Bundle data) {
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(view);
        if (fallbackImm != null) {
            fallbackImm.sendAppPrivateCommand(view, action, data);
            return;
        }
        checkFocus();
        synchronized (this.mH) {
            if (hasServedByInputMethodLocked(view) && this.mCurrentEditorInfo != null && isImeSessionAvailableLocked()) {
                if (DEBUG) {
                    Log.v(TAG, "APP PRIVATE COMMAND " + action + ": " + ((Object) data));
                }
                this.mCurBindState.mImeSession.appPrivateCommand(action, data);
            }
        }
    }

    @Deprecated
    public void setInputMethod(IBinder token, String id2) {
        if (token == null) {
            if (id2 == null) {
                return;
            }
            if (Process.myUid() == 1000) {
                Log.w(TAG, "System process should not be calling setInputMethod() because almost always it is a bug under multi-user / multi-profile environment. Consider interacting with InputMethodManagerService directly via LocalServices.");
                return;
            }
            Context fallbackContext = ActivityThread.currentApplication();
            if (fallbackContext == null || fallbackContext.checkSelfPermission("android.permission.WRITE_SECURE_SETTINGS") != 0) {
                return;
            }
            List<InputMethodInfo> imis = getEnabledInputMethodList();
            int numImis = imis.size();
            boolean found = false;
            int i10 = 0;
            while (true) {
                if (i10 >= numImis) {
                    break;
                }
                InputMethodInfo imi = imis.get(i10);
                if (!id2.equals(imi.getId())) {
                    i10++;
                } else {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Log.e(TAG, "Ignoring setInputMethod(null, " + id2 + ") because the specified id not found in enabled IMEs.");
                return;
            }
            Log.w(TAG, "The undocumented behavior that setInputMethod() accepts null token when the caller has WRITE_SECURE_SETTINGS is deprecated. This behavior may be completely removed in a future version.  Update secure settings directly instead.");
            ContentResolver resolver = fallbackContext.getContentResolver();
            Settings.Secure.putInt(resolver, "selected_input_method_subtype", -1);
            Settings.Secure.putString(resolver, "default_input_method", id2);
            return;
        }
        InputMethodPrivilegedOperationsRegistry.get(token).setInputMethod(id2);
    }

    @Deprecated
    public void setInputMethodAndSubtype(IBinder token, String id2, InputMethodSubtype subtype) {
        if (token == null) {
            Log.e(TAG, "setInputMethodAndSubtype() does not accept null token on Android Q and later.");
        } else {
            InputMethodPrivilegedOperationsRegistry.get(token).setInputMethodAndSubtype(id2, subtype);
        }
    }

    @Deprecated
    public void hideSoftInputFromInputMethod(IBinder token, int flags) {
        this.mImmWrapper.getExtImpl().logMethodCallers("hideSoftInputFromInputMethod");
        InputMethodPrivilegedOperationsRegistry.get(token).hideMySoftInput(flags, 32);
    }

    @Deprecated
    public void showSoftInputFromInputMethod(IBinder token, int flags) {
        this.mImmWrapper.getExtImpl().logMethodCallers("showSoftInputFromInputMethod");
        InputMethodPrivilegedOperationsRegistry.get(token).showMySoftInput(flags);
    }

    public int dispatchInputEvent(InputEvent event, Object token, FinishedInputEventCallback callback, Handler handler) {
        synchronized (this.mH) {
            if (isImeSessionAvailableLocked()) {
                if (event instanceof KeyEvent) {
                    KeyEvent keyEvent = (KeyEvent) event;
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 63 && keyEvent.getRepeatCount() == 0) {
                        showInputMethodPickerLocked();
                        return 1;
                    }
                }
                if (DEBUG) {
                    Log.v(TAG, "DISPATCH INPUT EVENT: " + ((Object) this.mCurBindState.mImeSession));
                }
                PendingEvent p10 = obtainPendingEventLocked(event, token, this.mCurBindState.mImeId, callback, handler);
                if (this.mMainLooper.isCurrentThread()) {
                    return sendInputEventOnMainLooperLocked(p10);
                }
                Message msg = this.mH.obtainMessage(5, p10);
                msg.setAsynchronous(true);
                this.mH.sendMessage(msg);
                return -1;
            }
            return 0;
        }
    }

    public void dispatchKeyEventFromInputMethod(View targetView, KeyEvent event) {
        ViewRootImpl viewRootImpl;
        View servedView;
        InputMethodManager fallbackImm = getFallbackInputMethodManagerIfNecessary(targetView);
        if (fallbackImm != null) {
            fallbackImm.dispatchKeyEventFromInputMethod(targetView, event);
            return;
        }
        synchronized (this.mH) {
            if (targetView == null) {
                viewRootImpl = null;
            } else {
                try {
                    viewRootImpl = targetView.getViewRootImpl();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (viewRootImpl == null && (servedView = getServedViewLocked()) != null) {
                viewRootImpl = servedView.getViewRootImpl();
            }
            if (viewRootImpl != null) {
                viewRootImpl.dispatchKeyFromIme(event);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInputEventAndReportResultOnMainLooper(PendingEvent p10) {
        synchronized (this.mH) {
            int result = sendInputEventOnMainLooperLocked(p10);
            if (result == -1) {
                return;
            }
            boolean z10 = true;
            if (result != 1) {
                z10 = false;
            }
            boolean handled = z10;
            invokeFinishedInputEventCallback(p10, handled);
        }
    }

    private int sendInputEventOnMainLooperLocked(PendingEvent p10) {
        InputChannel inputChannel = this.mCurChannel;
        if (inputChannel != null) {
            if (this.mCurSender == null) {
                this.mCurSender = new ImeInputEventSender(inputChannel, this.mH.getLooper());
            }
            InputEvent event = p10.mEvent;
            int seq = event.getSequenceNumber();
            if (this.mCurSender.sendInputEvent(seq, event)) {
                this.mPendingEvents.put(seq, p10);
                Trace.traceCounter(4L, PENDING_EVENT_COUNTER, this.mPendingEvents.size());
                Message msg = this.mH.obtainMessage(6, seq, 0, p10);
                msg.setAsynchronous(true);
                this.mH.sendMessageDelayed(msg, INPUT_METHOD_NOT_RESPONDING_TIMEOUT);
                return -1;
            }
            if (sPreventImeStartupUnlessTextEditor) {
                Log.d(TAG, "Dropping event because IME is evicted: " + ((Object) event));
            } else {
                Log.w(TAG, "Unable to send input event to IME: " + getImeIdLocked() + " dropping: " + ((Object) event));
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishedInputEvent(int seq, boolean handled, boolean timeout) {
        synchronized (this.mH) {
            int index = this.mPendingEvents.indexOfKey(seq);
            if (index < 0) {
                return;
            }
            PendingEvent p10 = this.mPendingEvents.valueAt(index);
            this.mPendingEvents.removeAt(index);
            Trace.traceCounter(4L, PENDING_EVENT_COUNTER, this.mPendingEvents.size());
            if (timeout) {
                Log.w(TAG, "Timeout waiting for IME to handle input event after 2500 ms: " + p10.mInputMethodId);
            } else {
                this.mH.removeMessages(6, p10);
            }
            invokeFinishedInputEventCallback(p10, handled);
        }
    }

    private void invokeFinishedInputEventCallback(PendingEvent p10, boolean handled) {
        p10.mHandled = handled;
        if (p10.mHandler.getLooper().isCurrentThread()) {
            p10.run();
            return;
        }
        Message msg = Message.obtain(p10.mHandler, p10);
        msg.setAsynchronous(true);
        msg.sendToTarget();
    }

    private void flushPendingEventsLocked() {
        this.mH.removeMessages(7);
        int count = this.mPendingEvents.size();
        for (int i10 = 0; i10 < count; i10++) {
            int seq = this.mPendingEvents.keyAt(i10);
            Message msg = this.mH.obtainMessage(7, seq, 0);
            msg.setAsynchronous(true);
            msg.sendToTarget();
        }
    }

    private PendingEvent obtainPendingEventLocked(InputEvent event, Object token, String inputMethodId, FinishedInputEventCallback callback, Handler handler) {
        PendingEvent p10 = (PendingEvent) this.mPendingEventPool.acquire();
        if (p10 == null) {
            p10 = new PendingEvent();
        }
        p10.mEvent = event;
        p10.mToken = token;
        p10.mInputMethodId = inputMethodId;
        p10.mCallback = callback;
        p10.mHandler = handler;
        return p10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recyclePendingEventLocked(PendingEvent p10) {
        p10.recycle();
        this.mPendingEventPool.release(p10);
    }

    public void showInputMethodPicker() {
        synchronized (this.mH) {
            showInputMethodPickerLocked();
        }
    }

    public void showInputMethodPickerFromSystem(boolean showAuxiliarySubtypes, int displayId) {
        int mode;
        if (showAuxiliarySubtypes) {
            mode = 1;
        } else {
            mode = 2;
        }
        IInputMethodManagerGlobalInvoker.showInputMethodPickerFromSystem(mode, displayId);
    }

    private void showInputMethodPickerLocked() {
        IInputMethodManagerGlobalInvoker.showInputMethodPickerFromClient(this.mClient, 0);
    }

    public boolean isInputMethodPickerShown() {
        return IInputMethodManagerGlobalInvoker.isInputMethodPickerShownForTest();
    }

    public boolean hasPendingImeVisibilityRequests() {
        return IInputMethodManagerGlobalInvoker.hasPendingImeVisibilityRequests();
    }

    public void showInputMethodAndSubtypeEnabler(String imiId) {
        Context context = null;
        synchronized (this.mH) {
            ViewRootImpl viewRootImpl = this.mCurRootView;
            if (viewRootImpl != null) {
                context = viewRootImpl.mContext;
            }
        }
        if (context == null) {
            Context appContext = ActivityThread.currentApplication();
            DisplayManager displayManager = (DisplayManager) appContext.getSystemService(DisplayManager.class);
            context = appContext.createDisplayContext(displayManager.getDisplay(this.mDisplayId));
        }
        Intent intent = new Intent("android.settings.INPUT_METHOD_SUBTYPE_SETTINGS");
        intent.setFlags(337641472);
        if (!TextUtils.isEmpty(imiId)) {
            intent.putExtra("input_method_id", imiId);
        }
        context.startActivity(intent);
    }

    public InputMethodSubtype getCurrentInputMethodSubtype() {
        return IInputMethodManagerGlobalInvoker.getCurrentInputMethodSubtype(UserHandle.myUserId());
    }

    @Deprecated
    public boolean setCurrentInputMethodSubtype(InputMethodSubtype subtype) {
        Context fallbackContext;
        if (Process.myUid() == 1000) {
            Log.w(TAG, "System process should not call setCurrentInputMethodSubtype() because almost always it is a bug under multi-user / multi-profile environment. Consider directly interacting with InputMethodManagerService via LocalServices.");
            return false;
        }
        if (subtype == null || (fallbackContext = ActivityThread.currentApplication()) == null || fallbackContext.checkSelfPermission("android.permission.WRITE_SECURE_SETTINGS") != 0) {
            return false;
        }
        ContentResolver contentResolver = fallbackContext.getContentResolver();
        String imeId = Settings.Secure.getString(contentResolver, "default_input_method");
        if (ComponentName.unflattenFromString(imeId) == null) {
            return false;
        }
        List<InputMethodSubtype> enabledSubtypes = IInputMethodManagerGlobalInvoker.getEnabledInputMethodSubtypeList(imeId, true, UserHandle.myUserId());
        int numSubtypes = enabledSubtypes.size();
        for (int i10 = 0; i10 < numSubtypes; i10++) {
            InputMethodSubtype enabledSubtype = enabledSubtypes.get(i10);
            if (enabledSubtype.equals(subtype)) {
                Settings.Secure.putInt(contentResolver, "selected_input_method_subtype", enabledSubtype.hashCode());
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public void notifyUserAction() {
        Log.w(TAG, "notifyUserAction() is a hidden method, which is now just a stub method that does nothing.  Leave comments in b.android.com/114740982 if your  application still depends on the previous behavior of this method.");
    }

    public Map<InputMethodInfo, List<InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() {
        List<InputMethodInfo> enabledImes = getEnabledInputMethodList();
        enabledImes.sort(Comparator.comparingInt(new ToIntFunction() { // from class: android.view.inputmethod.InputMethodManager$$ExternalSyntheticLambda0
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return InputMethodManager.lambda$getShortcutInputMethodsAndSubtypes$4((InputMethodInfo) obj);
            }
        }));
        int numEnabledImes = enabledImes.size();
        for (int imiIndex = 0; imiIndex < numEnabledImes; imiIndex++) {
            InputMethodInfo imi = enabledImes.get(imiIndex);
            List<InputMethodSubtype> subtypes = getEnabledInputMethodSubtypeList(imi, true);
            int subtypeCount = subtypes.size();
            for (int subtypeIndex = 0; subtypeIndex < subtypeCount; subtypeIndex++) {
                InputMethodSubtype subtype = imi.getSubtypeAt(subtypeIndex);
                if (SUBTYPE_MODE_VOICE.equals(subtype.getMode())) {
                    return Collections.singletonMap(imi, Collections.singletonList(subtype));
                }
            }
        }
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$getShortcutInputMethodsAndSubtypes$4(InputMethodInfo inputMethodInfo) {
        return !inputMethodInfo.isSystem() ? 1 : 0;
    }

    public int getInputMethodWindowVisibleHeight() {
        return IInputMethodManagerGlobalInvoker.getInputMethodWindowVisibleHeight(this.mClient);
    }

    public void setRequestCursorUpdateDisplayIdCheck(boolean enabled) {
        this.mRequestCursorUpdateDisplayIdCheck.set(enabled);
    }

    public void reportVirtualDisplayGeometry(int childDisplayId, Matrix matrix) {
        float[] matrixValues;
        if (matrix == null) {
            matrixValues = null;
        } else {
            matrixValues = new float[9];
            matrix.getValues(matrixValues);
        }
        IInputMethodManagerGlobalInvoker.reportVirtualDisplayGeometryAsync(this.mClient, childDisplayId, matrixValues);
    }

    public boolean hasVirtualDisplayToScreenMatrix() {
        boolean z10;
        synchronized (this.mH) {
            z10 = this.mVirtualDisplayToScreenMatrix != null;
        }
        return z10;
    }

    @Deprecated
    public boolean switchToLastInputMethod(IBinder imeToken) {
        return InputMethodPrivilegedOperationsRegistry.get(imeToken).switchToPreviousInputMethod();
    }

    @Deprecated
    public boolean switchToNextInputMethod(IBinder imeToken, boolean onlyCurrentIme) {
        return InputMethodPrivilegedOperationsRegistry.get(imeToken).switchToNextInputMethod(onlyCurrentIme);
    }

    @Deprecated
    public boolean shouldOfferSwitchingToNextInputMethod(IBinder imeToken) {
        return InputMethodPrivilegedOperationsRegistry.get(imeToken).shouldOfferSwitchingToNextInputMethod();
    }

    @Deprecated
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes) {
        IInputMethodManagerGlobalInvoker.setAdditionalInputMethodSubtypes(imiId, subtypes, UserHandle.myUserId());
    }

    public void setExplicitlyEnabledInputMethodSubtypes(String imiId, int[] subtypeHashCodes) {
        IInputMethodManagerGlobalInvoker.setExplicitlyEnabledInputMethodSubtypes(imiId, subtypeHashCodes, UserHandle.myUserId());
    }

    public InputMethodSubtype getLastInputMethodSubtype() {
        return IInputMethodManagerGlobalInvoker.getLastInputMethodSubtype(UserHandle.myUserId());
    }

    public int getDisplayId() {
        return this.mDisplayId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDump(FileDescriptor fd2, PrintWriter fout, String[] args) {
        if (processDump(fd2, args)) {
            return;
        }
        if (this.mImmWrapper.getExtImpl().configDebug(args) && this.mCurBindState == null) {
            return;
        }
        Printer p10 = new PrintWriterPrinter(fout);
        p10.println("Input method client state for " + ((Object) this) + u.bD);
        p10.println("  mFallbackInputConnection=" + ((Object) this.mFallbackInputConnection));
        p10.println("  mActive=" + this.mActive + " mRestartOnNextWindowFocus=" + this.mRestartOnNextWindowFocus + " mBindSequence=" + getBindSequenceLocked() + " mCurImeId=" + getImeIdLocked());
        p10.println("  mFullscreenMode=" + this.mFullscreenMode);
        if (isImeSessionAvailableLocked()) {
            p10.println("  mCurMethod=" + ((Object) this.mCurBindState.mImeSession));
        } else {
            p10.println("  mCurMethod= null");
        }
        for (int i10 = 0; i10 < this.mAccessibilityInputMethodSession.size(); i10++) {
            p10.println("  mAccessibilityInputMethodSession(" + this.mAccessibilityInputMethodSession.keyAt(i10) + ")=" + ((Object) this.mAccessibilityInputMethodSession.valueAt(i10)));
        }
        p10.println("  mCurRootView=" + ((Object) this.mCurRootView));
        p10.println("  mServedView=" + ((Object) getServedViewLocked()));
        p10.println("  mNextServedView=" + ((Object) getNextServedViewLocked()));
        p10.println("  mServedConnecting=" + this.mServedConnecting);
        if (this.mCurrentEditorInfo != null) {
            p10.println("  mCurrentEditorInfo:");
            this.mCurrentEditorInfo.dump(p10, "    ", false);
        } else {
            p10.println("  mCurrentEditorInfo: null");
        }
        p10.println("  mServedInputConnection=" + ((Object) this.mServedInputConnection));
        p10.println("  mServedInputConnectionHandler=" + ((Object) this.mServedInputConnectionHandler));
        p10.println("  mCompletions=" + Arrays.toString(this.mCompletions));
        p10.println("  mCursorRect=" + ((Object) this.mCursorRect));
        p10.println("  mCursorSelStart=" + this.mCursorSelStart + " mCursorSelEnd=" + this.mCursorSelEnd + " mCursorCandStart=" + this.mCursorCandStart + " mCursorCandEnd=" + this.mCursorCandEnd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ImeInputEventSender extends InputEventSender {
        public ImeInputEventSender(InputChannel inputChannel, Looper looper) {
            super(inputChannel, looper);
        }

        @Override // android.view.InputEventSender
        public void onInputEventFinished(int seq, boolean handled) {
            InputMethodManager.this.finishedInputEvent(seq, handled, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class PendingEvent implements Runnable {
        public FinishedInputEventCallback mCallback;
        public InputEvent mEvent;
        public boolean mHandled;
        public Handler mHandler;
        public String mInputMethodId;
        public Object mToken;

        private PendingEvent() {
        }

        public void recycle() {
            this.mEvent = null;
            this.mToken = null;
            this.mInputMethodId = null;
            this.mCallback = null;
            this.mHandler = null;
            this.mHandled = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCallback.onFinishedInputEvent(this.mToken, this.mHandled);
            synchronized (InputMethodManager.this.mH) {
                InputMethodManager.this.recyclePendingEventLocked(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class BindState {
        final int mBindSequence;
        final String mImeId;
        final IInputMethodSessionInvoker mImeSession;
        final boolean mIsInputMethodSuppressingSpellChecker;

        BindState(InputBindResult inputBindResult) {
            this.mImeSession = IInputMethodSessionInvoker.createOrNull(inputBindResult.method);
            this.mIsInputMethodSuppressingSpellChecker = inputBindResult.isInputMethodSuppressingSpellChecker;
            this.mImeId = inputBindResult.f9159id;
            this.mBindSequence = inputBindResult.sequence;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isImeSessionAvailableLocked() {
        BindState bindState = this.mCurBindState;
        return (bindState == null || bindState.mImeSession == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getImeIdLocked() {
        BindState bindState = this.mCurBindState;
        if (bindState != null) {
            return bindState.mImeId;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBindSequenceLocked() {
        BindState bindState = this.mCurBindState;
        if (bindState != null) {
            return bindState.mBindSequence;
        }
        return -1;
    }

    private boolean processDump(FileDescriptor fd2, String[] args) {
        if (args == null) {
            return false;
        }
        for (String arg : args) {
            if (arg.equals(ImeTracing.PROTO_ARG)) {
                ProtoOutputStream proto = new ProtoOutputStream(fd2);
                dumpDebug(proto, null);
                proto.flush();
                return true;
            }
        }
        return false;
    }

    public void dumpDebug(ProtoOutputStream proto, byte[] icProto) {
        if (!isImeSessionAvailableLocked()) {
            return;
        }
        proto.write(1120986464257L, this.mDisplayId);
        long token = proto.start(1146756268034L);
        synchronized (this.mH) {
            proto.write(1138166333441L, this.mCurBindState.mImeId);
            proto.write(1133871366146L, this.mFullscreenMode);
            proto.write(1133871366148L, this.mActive);
            proto.write(1133871366149L, this.mServedConnecting);
            proto.write(InputMethodManagerProto.SERVED_VIEW, Objects.toString(this.mServedView));
            proto.write(InputMethodManagerProto.NEXT_SERVED_VIEW, Objects.toString(this.mNextServedView));
            proto.end(token);
            ViewRootImpl viewRootImpl = this.mCurRootView;
            if (viewRootImpl != null) {
                viewRootImpl.dumpDebug(proto, 1146756268035L);
            }
            EditorInfo editorInfo = this.mCurrentEditorInfo;
            if (editorInfo != null) {
                editorInfo.dumpDebug(proto, 1146756268038L);
            }
            ImeInsetsSourceConsumer imeInsetsSourceConsumer = this.mImeInsetsConsumer;
            if (imeInsetsSourceConsumer != null) {
                imeInsetsSourceConsumer.dumpDebug(proto, 1146756268037L);
            }
            RemoteInputConnectionImpl remoteInputConnectionImpl = this.mServedInputConnection;
            if (remoteInputConnectionImpl != null) {
                remoteInputConnectionImpl.dumpDebug(proto, 1146756268040L);
            }
            if (icProto != null) {
                proto.write(1146756268041L, icProto);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forAccessibilitySessionsLocked(Consumer<IAccessibilityInputMethodSessionInvoker> consumer) {
        for (int i10 = 0; i10 < this.mAccessibilityInputMethodSession.size(); i10++) {
            consumer.accept(this.mAccessibilityInputMethodSession.valueAt(i10));
        }
    }

    private static Pair<InputConnection, EditorInfo> createInputConnection(View servedView) {
        EditorInfo editorInfo = new EditorInfo();
        editorInfo.packageName = servedView.getContext().getOpPackageName();
        editorInfo.autofillId = servedView.getAutofillId();
        editorInfo.fieldId = servedView.getId();
        InputConnection ic2 = servedView.onCreateInputConnection(editorInfo);
        if (DEBUG) {
            Log.v(TAG, "Starting input: editorInfo=" + ((Object) editorInfo) + " ic=" + ((Object) ic2));
        }
        if (ic2 == null) {
            editorInfo.autofillId = AutofillId.NO_AUTOFILL_ID;
            editorInfo.fieldId = 0;
        }
        return new Pair<>(ic2, editorInfo);
    }

    public IInputMethodManagerWrapper getWrapper() {
        return this.mImmWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class InputMethodManagerWrapper implements IInputMethodManagerWrapper {
        private IInputMethodManagerExt mImmExt;

        private InputMethodManagerWrapper() {
            this.mImmExt = (IInputMethodManagerExt) ExtLoader.type(IInputMethodManagerExt.class).base(InputMethodManager.this).create();
        }

        @Override // android.view.inputmethod.IInputMethodManagerWrapper
        public IInputMethodManagerExt getExtImpl() {
            return this.mImmExt;
        }

        @Override // android.view.inputmethod.IInputMethodManagerWrapper
        public View getNextServedView() {
            return InputMethodManager.this.getNextServedViewLocked();
        }

        @Override // android.view.inputmethod.IInputMethodManagerWrapper
        public String getCurId() {
            return InputMethodManager.this.getImeIdLocked();
        }
    }

    public static InputMethodManager getInstanceForDisplay(int displayId) {
        return forContextInternal(displayId, Looper.getMainLooper());
    }

    public static InputMethodManager getDefaultInstance() {
        return getInstanceForDisplay(0);
    }
}
