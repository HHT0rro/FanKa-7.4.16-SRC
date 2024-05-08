package android.view;

import android.animation.AnimationHandler;
import android.animation.LayoutTransition;
import android.app.ActivityManager;
import android.app.ICompatCameraControlCallback;
import android.app.PendingIntent$;
import android.app.ResourcesManager;
import android.app.WindowConfiguration;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BLASTBufferQueue;
import android.graphics.Canvas;
import android.graphics.FrameInfo;
import android.graphics.HardwareRenderer;
import android.graphics.HardwareRendererObserver;
import android.graphics.Insets;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerGlobal;
import android.hardware.input.InputManagerGlobal;
import android.hardware.input.InputSettings;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.IOplusJankMonitorExt;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.sysprop.DisplayProperties;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.LongArray;
import android.util.MergedConfiguration;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.proto.ProtoOutputStream;
import android.view.ActionMode;
import android.view.AttachedSurfaceControl;
import android.view.Choreographer;
import android.view.GestureDetector;
import android.view.IWindow;
import android.view.InputQueue;
import android.view.InsetsSourceControl;
import android.view.KeyCharacterMap;
import android.view.ScrollCaptureResponse;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import android.view.ThreadedRenderer;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeIdManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityWindowAttributes;
import android.view.accessibility.IAccessibilityEmbeddedConnection;
import android.view.accessibility.IAccessibilityInteractionConnection;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.contentcapture.ContentCaptureManager;
import android.view.contentcapture.ContentCaptureSession;
import android.view.contentcapture.MainContentCaptureSession;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import android.window.BackEvent;
import android.window.ClientWindowFrames;
import android.window.CompatOnBackInvokedCallback;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import android.window.ScreenCapture;
import android.window.SurfaceSyncGroup;
import android.window.WindowOnBackInvokedDispatcher;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import com.android.internal.graphics.drawable.BackgroundBlurDrawable;
import com.android.internal.inputmethod.ImeTracing;
import com.android.internal.inputmethod.InputMethodDebug;
import com.android.internal.os.IResultReceiver;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.SomeArgs;
import com.android.internal.policy.DecorView;
import com.android.internal.policy.PhoneFallbackEventHandler;
import com.android.internal.util.Preconditions;
import com.android.internal.view.BaseSurfaceHolder;
import com.android.internal.view.RootViewSurfaceTaker;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ViewRootImpl implements ViewParent, View.AttachInfo.Callbacks, ThreadedRenderer.DrawCallbacks, AttachedSurfaceControl {
    private static final int CONTENT_CAPTURE_ENABLED_FALSE = 2;
    private static final int CONTENT_CAPTURE_ENABLED_NOT_CHECKED = 0;
    private static final int CONTENT_CAPTURE_ENABLED_TRUE = 1;
    private static final boolean ENABLE_INPUT_LATENCY_TRACKING = true;
    private static final int KEEP_CLEAR_AREA_REPORT_RATE_MILLIS = 100;
    private static final int LIMIT = 10000;
    private static final int LOGTAG_INPUT_FOCUS = 62001;
    private static final int MAX_QUEUED_INPUT_EVENT_POOL_SIZE = 10;
    static final int MAX_TRACKBALL_DELAY = 250;
    private static final int MSG_CHECK_FOCUS = 13;
    private static final int MSG_CLEAR_ACCESSIBILITY_FOCUS_HOST = 21;
    private static final int MSG_CLOSE_SYSTEM_DIALOGS = 14;
    private static final int MSG_DIE = 3;
    private static final int MSG_DISPATCH_APP_VISIBILITY = 8;
    private static final int MSG_DISPATCH_DRAG_EVENT = 15;
    private static final int MSG_DISPATCH_DRAG_LOCATION_EVENT = 16;
    private static final int MSG_DISPATCH_GET_NEW_SURFACE = 9;
    private static final int MSG_DISPATCH_INPUT_EVENT = 7;
    private static final int MSG_DISPATCH_KEY_FROM_AUTOFILL = 12;
    private static final int MSG_DISPATCH_KEY_FROM_IME = 11;
    private static final int MSG_DISPATCH_SYSTEM_UI_VISIBILITY = 17;
    private static final int MSG_DISPATCH_WINDOW_SHOWN = 25;
    private static final int MSG_HIDE_INSETS = 32;
    private static final int MSG_INSETS_CONTROL_CHANGED = 29;
    private static final int MSG_INVALIDATE = 1;
    private static final int MSG_INVALIDATE_RECT = 2;
    private static final int MSG_INVALIDATE_WORLD = 22;
    private static final int MSG_KEEP_CLEAR_RECTS_CHANGED = 35;
    private static final int MSG_PAUSED_FOR_SYNC_TIMEOUT = 37;
    private static final int MSG_POINTER_CAPTURE_CHANGED = 28;
    private static final int MSG_PROCESS_INPUT_EVENTS = 19;
    private static final int MSG_REPORT_KEEP_CLEAR_RECTS = 36;
    private static final int MSG_REQUEST_KEYBOARD_SHORTCUTS = 26;
    private static final int MSG_REQUEST_SCROLL_CAPTURE = 33;
    private static final int MSG_RESIZED = 4;
    private static final int MSG_RESIZED_REPORT = 5;
    private static final int MSG_SHOW_INSETS = 31;
    private static final int MSG_SYNTHESIZE_INPUT_EVENT = 24;
    private static final int MSG_SYSTEM_GESTURE_EXCLUSION_CHANGED = 30;
    private static final int MSG_UPDATE_CONFIGURATION = 18;
    private static final int MSG_UPDATE_POINTER_ICON = 27;
    private static final int MSG_WINDOW_FOCUS_CHANGED = 6;
    private static final int MSG_WINDOW_MOVED = 23;
    private static final int MSG_WINDOW_TOUCH_MODE_CHANGED = 34;
    private static final boolean MT_RENDERER_AVAILABLE = true;
    private static final String PROPERTY_PROFILE_RENDERING = "viewroot.profile_rendering";
    private static final int SCROLL_CAPTURE_REQUEST_TIMEOUT_MILLIS = 2500;
    private static final String TAG = "ViewRootImpl";
    private static final int UNSET_SYNC_ID = -1;
    private static final boolean USE_ASYNC_PERFORM_HAPTIC_FEEDBACK = true;
    private static final int WMS_SYNC_MERGED = 3;
    private static final int WMS_SYNC_NONE = 0;
    private static final int WMS_SYNC_PENDING = 1;
    private static final int WMS_SYNC_RETURNED = 2;
    private static boolean sAlwaysAssignFocus;
    private IAccessibilityEmbeddedConnection mAccessibilityEmbeddedConnection;
    View mAccessibilityFocusedHost;
    AccessibilityNodeInfo mAccessibilityFocusedVirtualView;
    final AccessibilityInteractionConnectionManager mAccessibilityInteractionConnectionManager;
    AccessibilityInteractionController mAccessibilityInteractionController;
    final AccessibilityManager mAccessibilityManager;
    private AccessibilityWindowAttributes mAccessibilityWindowAttributes;
    private SurfaceSyncGroup mActiveSurfaceSyncGroup;
    private ActivityConfigCallback mActivityConfigCallback;
    boolean mAdded;
    boolean mAddedTouchMode;
    private boolean mAppVisibilityChanged;
    boolean mAppVisible;
    boolean mApplyInsetsRequested;
    final View.AttachInfo mAttachInfo;
    AudioManager mAudioManager;
    final String mBasePackageName;
    private BLASTBufferQueue mBlastBufferQueue;
    private final BackgroundBlurDrawable.Aggregator mBlurRegionAggregator;
    private SurfaceControl mBoundsLayer;
    private int mCanvasOffsetX;
    private int mCanvasOffsetY;
    private boolean mCheckIfCanDraw;
    private final Rect mChildBoundingInsets;
    private boolean mChildBoundingInsetsChanged;
    final Choreographer mChoreographer;
    int mClientWindowLayoutFlags;
    private CompatOnBackInvokedCallback mCompatOnBackInvokedCallback;
    final SystemUiVisibilityInfo mCompatibleVisibilityInfo;
    final ConsumeBatchedInputImmediatelyRunnable mConsumeBatchedInputImmediatelyRunnable;
    boolean mConsumeBatchedInputImmediatelyScheduled;
    boolean mConsumeBatchedInputScheduled;
    final ConsumeBatchedInputRunnable mConsumedBatchedInputRunnable;
    int mContentCaptureEnabled;
    public final Context mContext;
    int mCurScrollY;
    View mCurrentDragView;
    private PointerIcon mCustomPointerIcon;
    private final int mDensity;
    private float mDesiredHdrSdrRatio;
    private Rect mDirty;
    int mDispatchedSystemBarAppearance;
    int mDispatchedSystemUiVisibility;
    Display mDisplay;
    boolean mDisplayDecorationCached;
    private final DisplayManager.DisplayListener mDisplayListener;
    ClipDescription mDragDescription;
    final PointF mDragPoint;
    private boolean mDragResizing;
    boolean mDrawingAllowed;
    private boolean mDrewOnceForSync;
    private final Executor mExecutor;
    FallbackEventHandler mFallbackEventHandler;
    private boolean mFastScrollSoundEffectsEnabled;
    boolean mFirst;
    InputStage mFirstInputStage;
    InputStage mFirstPostImeInputStage;
    private boolean mForceDecorViewVisibility;
    private boolean mForceDisableBLAST;
    private boolean mForceNextConfigUpdate;
    boolean mForceNextWindowRelayout;
    private int mFpsNumFrames;
    private long mFpsPrevTime;
    private long mFpsStartTime;
    public int mFrame;
    boolean mFullRedrawNeeded;
    private final ViewRootRectTracker mGestureExclusionTracker;
    final ViewRootHandler mHandler;
    boolean mHandlingLayoutInLayoutRequest;
    private final HandwritingInitiator mHandwritingInitiator;
    HardwareRendererObserver mHardwareRendererObserver;
    int mHardwareXOffset;
    int mHardwareYOffset;
    private boolean mHasPendingKeepClearAreaChange;
    boolean mHasPendingTransactions;
    private Consumer<Display> mHdrSdrRatioChangedListener;
    int mHeight;
    final HighContrastTextManager mHighContrastTextManager;
    public long mIdent;
    private final ImeFocusController mImeFocusController;
    private boolean mInLayout;
    private final InputEventCompatProcessor mInputCompatProcessor;
    private final InputEventAssigner mInputEventAssigner;
    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    WindowInputEventReceiver mInputEventReceiver;
    InputQueue mInputQueue;
    InputQueue.Callback mInputQueueCallback;
    private final InsetsController mInsetsController;
    private float mInvCompatScale;
    final InvalidateOnAnimationRunnable mInvalidateOnAnimationRunnable;
    private boolean mInvalidateRootRequested;
    boolean mIsAmbientMode;
    public boolean mIsAnimating;
    boolean mIsCreating;
    boolean mIsDrawing;
    boolean mIsInTraversal;
    private final boolean mIsStylusPointerIconEnabled;
    private boolean mIsSurfaceOpaque;
    private Rect mKeepClearAccessibilityFocusRect;
    private final ViewRootRectTracker mKeepClearRectsTracker;
    private int mLastClickToolType;
    private final Configuration mLastConfigurationFromResources;
    private String mLastDisplayCallEvent;
    private String mLastDisplayListenerState;
    String mLastDisplaySource;
    String mLastDisplayStateSource;
    final ViewTreeObserver.InternalInsetsInfo mLastGivenInsets;
    boolean mLastInCompatMode;
    private final Rect mLastLayoutFrame;
    String mLastPerformDrawSkippedReason;
    String mLastPerformTraversalsSkipDrawReason;
    String mLastReportNextDrawReason;
    private final MergedConfiguration mLastReportedMergedConfiguration;
    WeakReference<View> mLastScrolledFocus;
    private final Point mLastSurfaceSize;
    int mLastSyncSeqId;
    int mLastSystemUiVisibility;
    final PointF mLastTouchPoint;
    int mLastTouchSource;
    private int mLastTransformHint;
    private WindowInsets mLastWindowInsets;
    boolean mLayoutRequested;
    ArrayList<View> mLayoutRequesters;
    final IBinder mLeashToken;
    volatile Object mLocalDragState;
    final WindowLeaked mLocation;
    private String mMeasureReason;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private boolean mNeedsRendererSetup;
    boolean mNewSurfaceNeeded;
    private final int mNoncompatDensity;
    private int mNumPausedForSync;
    private final WindowOnBackInvokedDispatcher mOnBackInvokedDispatcher;
    int mOrigWindowType;
    Rect mOverrideInsetsFrame;
    boolean mPausedForTransition;
    boolean mPendingAlwaysConsumeSystemBars;
    final Rect mPendingBackDropFrame;
    private boolean mPendingDragResizing;
    int mPendingInputEventCount;
    QueuedInputEvent mPendingInputEventHead;
    String mPendingInputEventQueueLengthCounterName;
    QueuedInputEvent mPendingInputEventTail;
    private final MergedConfiguration mPendingMergedConfiguration;
    private SurfaceControl.Transaction mPendingTransaction;
    private ArrayList<LayoutTransition> mPendingTransitions;
    boolean mPerformContentCapture;
    boolean mPointerCapture;
    private Integer mPointerIconType;
    private SurfaceSyncGroup mPreviousSyncSafeguard;
    private final Object mPreviousSyncSafeguardLock;
    Region mPreviousTouchableRegion;
    private int mPreviousTransformHint;
    final Region mPreviousTransparentRegion;
    boolean mProcessInputEventsScheduled;
    private boolean mProfile;
    private boolean mProfileRendering;
    private QueuedInputEvent mQueuedInputEventPool;
    private int mQueuedInputEventPoolSize;
    private Bundle mRelayoutBundle;
    private boolean mRelayoutRequested;
    private int mRelayoutSeq;
    private boolean mRemoved;
    private float mRenderHdrSdrRatio;
    private Choreographer.FrameCallback mRenderProfiler;
    private boolean mRenderProfilingEnabled;
    boolean mReportNextDraw;
    private HashSet<ScrollCaptureCallback> mRootScrollCaptureCallbacks;
    private long mScrollCaptureRequestTimeout;
    boolean mScrollMayChange;
    int mScrollY;
    Scroller mScroller;
    SendWindowContentChangedAccessibilityEvent mSendWindowContentChangedAccessibilityEvent;
    private final Executor mSimpleExecutor;
    int mSoftInputMode;
    View mStartedDragViewForA11y;
    boolean mStopped;
    public final Surface mSurface;
    private final ArrayList<SurfaceChangedCallback> mSurfaceChangedCallbacks;
    private final SurfaceControl mSurfaceControl;
    BaseSurfaceHolder mSurfaceHolder;
    SurfaceHolder.Callback2 mSurfaceHolderCallback;
    private int mSurfaceSequenceId;
    private final SurfaceSession mSurfaceSession;
    private final Point mSurfaceSize;
    private boolean mSyncBuffer;
    int mSyncSeqId;
    InputStage mSyntheticInputStage;
    private String mTag;
    final int mTargetSdkVersion;
    private final InsetsSourceControl.Array mTempControls;
    HashSet<View> mTempHashSet;
    private final InsetsState mTempInsets;
    private final Rect mTempRect;
    private final WindowConfiguration mTempWinConfig;
    final Thread mThread;
    private final ClientWindowFrames mTmpFrames;
    final int[] mTmpLocation;
    final TypedValue mTmpValue;
    Region mTouchableRegion;
    private final SurfaceControl.Transaction mTransaction;
    private ArrayList<AttachedSurfaceControl.OnBufferTransformHintChangedListener> mTransformHintListeners;
    CompatibilityInfo.Translator mTranslator;
    final Region mTransparentRegion;
    int mTraversalBarrier;
    final TraversalRunnable mTraversalRunnable;
    public boolean mTraversalScheduled;
    private int mTypesHiddenByFlags;
    boolean mUnbufferedInputDispatch;
    int mUnbufferedInputSource;
    private final UnhandledKeyManager mUnhandledKeyManager;
    private final ViewRootRectTracker mUnrestrictedKeepClearRectsTracker;
    boolean mUpcomingInTouchMode;
    boolean mUpcomingWindowFocus;
    private boolean mUpdateHdrSdrRatioInfo;
    private boolean mUpdateSurfaceNeeded;
    private boolean mUseBLASTAdapter;
    private boolean mUseMTRenderer;
    View mView;
    private final boolean mViewBoundsSandboxingEnabled;
    final ViewConfiguration mViewConfiguration;
    protected final ViewFrameInfo mViewFrameInfo;
    private int mViewLayoutDirectionInitial;
    private boolean mViewMeasureDeferred;
    private IViewRootImplExt mViewRootImplExt;
    private IViewRootImplSocExt mViewRootImplSocExt;
    private IViewRootImplWrapper mViewRootImplWrapper;
    int mViewVisibility;
    private final Rect mVisRect;
    int mWidth;
    boolean mWillDrawSoon;
    final Rect mWinFrame;
    private final Rect mWinFrameInScreen;
    final W mWindow;
    public final WindowManager.LayoutParams mWindowAttributes;
    boolean mWindowAttributesChanged;
    final ArrayList<WindowCallbacks> mWindowCallbacks;
    CountDownLatch mWindowDrawCountDown;
    boolean mWindowFocusChanged;
    private final WindowLayout mWindowLayout;
    final IWindowSession mWindowSession;
    private SurfaceSyncGroup mWmsRequestSyncGroup;
    int mWmsRequestSyncGroupState;
    public static boolean DBG = false;
    public static boolean LOCAL_LOGV = false;
    public static boolean DEBUG_DRAW = false;
    public static boolean DEBUG_LAYOUT = false;
    public static boolean DEBUG_DIALOG = false;
    public static boolean DEBUG_INPUT_RESIZE = false;
    public static boolean DEBUG_ORIENTATION = false;
    public static boolean DEBUG_TRACKBALL = false;
    public static boolean DEBUG_IMF = false;
    public static boolean DEBUG_CONFIGURATION = false;
    public static boolean DEBUG_FPS = false;
    public static boolean DEBUG_INPUT_STAGES = false;
    public static boolean DEBUG_KEEP_SCREEN_ON = false;
    private static final boolean DEBUG_CONTENT_CAPTURE = false;
    private static final boolean DEBUG_SCROLL_CAPTURE = false;
    private static final boolean DEBUG_TOUCH_NAVIGATION = false;
    private static final boolean DEBUG_BLAST = false;
    public static final boolean CAPTION_ON_SHELL = SystemProperties.getBoolean("persist.wm.debug.caption_on_shell", true);
    public static final boolean CLIENT_TRANSIENT = SystemProperties.getBoolean("persist.wm.debug.client_transient", false);
    public static final boolean LOCAL_LAYOUT = SystemProperties.getBoolean("persist.debug.local_layout", true);
    private static final boolean PANIC_DEBUG = SystemProperties.getBoolean("persist.sys.assert.panic", false);
    static final ThreadLocal<HandlerActionQueue> sRunQueues = new ThreadLocal<>();
    static final ArrayList<Runnable> sFirstDrawHandlers = new ArrayList<>();
    static boolean sFirstDrawComplete = false;
    private static final ArrayList<ConfigChangedCallback> sConfigCallbacks = new ArrayList<>();
    private static boolean sCompatibilityDone = false;
    static final Interpolator mResizeInterpolator = new AccelerateDecelerateInterpolator();
    private static final Object sSyncProgressLock = new Object();
    private static int sNumSyncsInProgress = 0;
    private static volatile boolean sAnrReported = false;
    static BLASTBufferQueue.TransactionHangCallback sTransactionHangCallback = new BLASTBufferQueue.TransactionHangCallback() { // from class: android.view.ViewRootImpl.1
        public void onTransactionHang(String reason) {
            if (ViewRootImpl.sAnrReported) {
                return;
            }
            ViewRootImpl.sAnrReported = true;
            long identityToken = Binder.clearCallingIdentity();
            try {
                ActivityManager.getService().appNotResponding(reason);
            } catch (RemoteException e2) {
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(identityToken);
                throw th;
            }
            Binder.restoreCallingIdentity(identityToken);
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ActivityConfigCallback {
        void onConfigurationChanged(Configuration configuration, int i10);

        void requestCompatCameraControl(boolean z10, boolean z11, ICompatCameraControlCallback iCompatCameraControlCallback);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ConfigChangedCallback {
        void onConfigurationChanged(Configuration configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameInfo getUpdatedFrameInfo() {
        FrameInfo frameInfo = this.mChoreographer.mFrameInfo;
        this.mChoreographer.mChoreographerExt.populateAndResetFrameInfo(frameInfo.opFrameInfo, this.mAppVisible);
        this.mViewFrameInfo.populateFrameInfo(frameInfo);
        this.mViewFrameInfo.reset();
        this.mInputEventAssigner.notifyFrameProcessed();
        return frameInfo;
    }

    public ImeFocusController getImeFocusController() {
        return this.mImeFocusController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class SystemUiVisibilityInfo {
        int globalVisibility;
        int localChanges;
        int localValue;

        SystemUiVisibilityInfo() {
        }
    }

    public HandwritingInitiator getHandwritingInitiator() {
        return this.mHandwritingInitiator;
    }

    public ViewRootImpl(Context context, Display display) {
        this(context, display, WindowManagerGlobal.getWindowSession(), new WindowLayout());
    }

    public ViewRootImpl(Context context, Display display, IWindowSession iWindowSession, WindowLayout windowLayout) {
        this.mMeasureReason = "0";
        this.mTransformHintListeners = new ArrayList<>();
        this.mPreviousTransformHint = 0;
        this.mFastScrollSoundEffectsEnabled = false;
        this.mWindowCallbacks = new ArrayList<>();
        this.mTmpLocation = new int[2];
        this.mTmpValue = new TypedValue();
        this.mWindowAttributes = new WindowManager.LayoutParams();
        this.mAppVisible = true;
        this.mForceDecorViewVisibility = false;
        this.mOrigWindowType = -1;
        this.mStopped = false;
        this.mIsAmbientMode = false;
        this.mPausedForTransition = false;
        this.mLastInCompatMode = false;
        this.mViewFrameInfo = new ViewFrameInfo();
        this.mInputEventAssigner = new InputEventAssigner();
        this.mDisplayDecorationCached = false;
        this.mSurfaceSize = new Point();
        this.mLastSurfaceSize = new Point();
        this.mVisRect = new Rect();
        this.mTempRect = new Rect();
        this.mContentCaptureEnabled = 0;
        this.mSyncBuffer = false;
        this.mCheckIfCanDraw = false;
        this.mDrewOnceForSync = false;
        this.mSyncSeqId = 0;
        this.mLastSyncSeqId = 0;
        this.mPendingTransaction = new SurfaceControl.Transaction();
        this.mUnbufferedInputSource = 0;
        this.mPendingInputEventQueueLengthCounterName = "pq";
        byte b4 = 0;
        this.mUnhandledKeyManager = new UnhandledKeyManager();
        this.mWindowAttributesChanged = false;
        this.mSurface = new Surface();
        this.mSurfaceControl = new SurfaceControl();
        this.mUpdateHdrSdrRatioInfo = false;
        this.mDesiredHdrSdrRatio = 1.0f;
        this.mRenderHdrSdrRatio = 1.0f;
        this.mHdrSdrRatioChangedListener = null;
        this.mSurfaceSession = new SurfaceSession();
        this.mTransaction = new SurfaceControl.Transaction();
        this.mTmpFrames = new ClientWindowFrames();
        this.mPendingBackDropFrame = new Rect();
        this.mWinFrameInScreen = new Rect();
        this.mTempInsets = new InsetsState();
        this.mTempControls = new InsetsSourceControl.Array();
        this.mTempWinConfig = new WindowConfiguration();
        this.mInvCompatScale = 1.0f;
        this.mLastGivenInsets = new ViewTreeObserver.InternalInsetsInfo();
        this.mTypesHiddenByFlags = 0;
        this.mLastConfigurationFromResources = new Configuration();
        this.mLastReportedMergedConfiguration = new MergedConfiguration();
        this.mPendingMergedConfiguration = new MergedConfiguration();
        this.mDragPoint = new PointF();
        this.mLastTouchPoint = new PointF();
        this.mFpsStartTime = -1L;
        this.mFpsPrevTime = -1L;
        this.mPointerIconType = null;
        this.mCustomPointerIcon = null;
        this.mAccessibilityInteractionConnectionManager = new AccessibilityInteractionConnectionManager();
        this.mInLayout = false;
        this.mLayoutRequesters = new ArrayList<>();
        this.mHandlingLayoutInLayoutRequest = false;
        this.mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ? new InputEventConsistencyVerifier(this, 0) : null;
        this.mBlurRegionAggregator = new BackgroundBlurDrawable.Aggregator(this);
        this.mGestureExclusionTracker = new ViewRootRectTracker(new Function() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List systemGestureExclusionRects;
                systemGestureExclusionRects = ((View) obj).getSystemGestureExclusionRects();
                return systemGestureExclusionRects;
            }
        });
        this.mKeepClearRectsTracker = new ViewRootRectTracker(new Function() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List collectPreferKeepClearRects;
                collectPreferKeepClearRects = ((View) obj).collectPreferKeepClearRects();
                return collectPreferKeepClearRects;
            }
        });
        this.mUnrestrictedKeepClearRectsTracker = new ViewRootRectTracker(new Function() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List collectUnrestrictedPreferKeepClearRects;
                collectUnrestrictedPreferKeepClearRects = ((View) obj).collectUnrestrictedPreferKeepClearRects();
                return collectUnrestrictedPreferKeepClearRects;
            }
        });
        this.mPreviousSyncSafeguardLock = new Object();
        this.mNumPausedForSync = 0;
        this.mScrollCaptureRequestTimeout = 2500L;
        this.mSurfaceSequenceId = 0;
        this.mLastTransformHint = Integer.MIN_VALUE;
        this.mRelayoutBundle = new Bundle();
        this.mChildBoundingInsets = new Rect();
        this.mChildBoundingInsetsChanged = false;
        this.mTag = TAG;
        this.mProfile = false;
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: android.view.ViewRootImpl.3
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int displayId) {
                int oldDisplayState;
                int newDisplayState;
                ViewRootImpl.this.mLastDisplayCallEvent = "onDisplayChanged " + displayId + " mDisplayId " + ViewRootImpl.this.mDisplay.getDisplayId() + " state " + ViewRootImpl.this.mDisplay.getState() + " time " + System.currentTimeMillis();
                ViewRootImpl.this.mViewRootImplExt.onDisplayChanged(displayId);
                if (ViewRootImpl.this.mView != null && ViewRootImpl.this.mDisplay.getDisplayId() == displayId && (oldDisplayState = ViewRootImpl.this.mAttachInfo.mDisplayState) != (newDisplayState = ViewRootImpl.this.mDisplay.getState())) {
                    ViewRootImpl.this.mAttachInfo.mDisplayState = newDisplayState;
                    ViewRootImpl.this.mLastDisplayStateSource = "State " + ViewRootImpl.this.mDisplay.getState() + " caller " + Debug.getCallers(30);
                    ViewRootImpl.this.pokeDrawLockIfNeeded();
                    if (oldDisplayState != 0) {
                        int oldScreenState = toViewScreenState(oldDisplayState);
                        int newScreenState = toViewScreenState(newDisplayState);
                        if (oldScreenState != newScreenState) {
                            ViewRootImpl.this.mView.dispatchScreenStateChanged(newScreenState);
                        }
                        if (oldDisplayState == 1) {
                            ViewRootImpl.this.mFullRedrawNeeded = true;
                            ViewRootImpl.this.scheduleTraversals();
                        }
                    }
                }
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int displayId) {
            }

            private int toViewScreenState(int displayState) {
                if (displayState != 1) {
                    return 1;
                }
                return 0;
            }
        };
        this.mSurfaceChangedCallbacks = new ArrayList<>();
        ViewRootHandler viewRootHandler = new ViewRootHandler();
        this.mHandler = viewRootHandler;
        this.mExecutor = new Executor() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                ViewRootImpl.this.lambda$new$9(runnable);
            }
        };
        this.mTraversalRunnable = new TraversalRunnable();
        this.mConsumedBatchedInputRunnable = new ConsumeBatchedInputRunnable();
        this.mConsumeBatchedInputImmediatelyRunnable = new ConsumeBatchedInputImmediatelyRunnable();
        this.mInvalidateOnAnimationRunnable = new InvalidateOnAnimationRunnable();
        this.mFrame = 0;
        this.mSimpleExecutor = new PendingIntent$.ExternalSyntheticLambda1();
        this.mViewRootImplWrapper = new ViewRootImplWrapper();
        this.mViewRootImplSocExt = (IViewRootImplSocExt) ExtLoader.type(IViewRootImplSocExt.class).base(this).create();
        IViewRootImplExt iViewRootImplExt = (IViewRootImplExt) ExtLoader.type(IViewRootImplExt.class).base(this).create();
        this.mViewRootImplExt = iViewRootImplExt;
        this.mContext = context;
        this.mWindowSession = iWindowSession;
        this.mWindowLayout = windowLayout;
        iViewRootImplExt.init(this, context);
        this.mDisplay = display;
        this.mLastDisplaySource = "From Constructor " + this.mDisplay.getDisplayId() + " state " + this.mDisplay.getState() + " caller " + Debug.getCallers(30);
        this.mBasePackageName = context.getBasePackageName();
        this.mThread = Thread.currentThread();
        WindowLeaked windowLeaked = new WindowLeaked(null);
        this.mLocation = windowLeaked;
        windowLeaked.fillInStackTrace();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mDirty = new Rect();
        this.mWinFrame = new Rect();
        this.mLastLayoutFrame = new Rect();
        W createWindowClient = this.mViewRootImplExt.createWindowClient();
        this.mWindow = createWindowClient;
        this.mLeashToken = new Binder();
        this.mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        this.mViewVisibility = 8;
        this.mTransparentRegion = new Region();
        this.mPreviousTransparentRegion = new Region();
        this.mFirst = true;
        this.mPerformContentCapture = true;
        this.mAdded = false;
        this.mAttachInfo = new View.AttachInfo(iWindowSession, createWindowClient, display, this, viewRootHandler, this, context);
        this.mCompatibleVisibilityInfo = new SystemUiVisibilityInfo();
        this.mAccessibilityManager = AccessibilityManager.getInstance(context);
        this.mHighContrastTextManager = new HighContrastTextManager();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mViewConfiguration = viewConfiguration;
        this.mDensity = context.getResources().getDisplayMetrics().densityDpi;
        this.mNoncompatDensity = context.getResources().getDisplayMetrics().noncompatDensityDpi;
        this.mFallbackEventHandler = new PhoneFallbackEventHandler(context);
        this.mChoreographer = Choreographer.getInstance();
        this.mInsetsController = new InsetsController(new ViewRootInsetsControllerHost(this));
        this.mHandwritingInitiator = new HandwritingInitiator(viewConfiguration, (InputMethodManager) context.getSystemService(InputMethodManager.class));
        this.mViewBoundsSandboxingEnabled = getViewBoundsSandboxingEnabled();
        this.mIsStylusPointerIconEnabled = InputSettings.isStylusPointerIconEnabled(context);
        String string = context.getResources().getString(17039991);
        if (string.isEmpty()) {
            this.mInputCompatProcessor = new InputEventCompatProcessor(context);
        } else {
            InputEventCompatProcessor inputEventCompatProcessor = null;
            try {
                InputEventCompatProcessor inputEventCompatProcessor2 = (InputEventCompatProcessor) Class.forName(string).getConstructor(Context.class).newInstance(context);
            } catch (Exception e2) {
                Log.e(TAG, "Unable to create the InputEventCompatProcessor. ", e2);
            } finally {
                this.mInputCompatProcessor = inputEventCompatProcessor;
            }
        }
        if (!sCompatibilityDone) {
            sAlwaysAssignFocus = this.mTargetSdkVersion < 28;
            sCompatibilityDone = true;
        }
        loadSystemProperties();
        this.mImeFocusController = new ImeFocusController(this);
        this.mViewRootImplExt.initSystemUINavigationGesture(this, context);
        this.mViewRootImplExt.hookNewInstance(this.mContext);
        this.mScrollCaptureRequestTimeout = 2500L;
        this.mOnBackInvokedDispatcher = new WindowOnBackInvokedDispatcher(context);
        if (!InsetsState.LTW_DISABLE) {
            this.mInsetsController.getState().getWrapper().getExtImpl().setRTWindowInsetHelper(this.mViewRootImplExt.getRTWindowInsetHelper());
        }
    }

    public static void addFirstDrawHandler(Runnable callback) {
        ArrayList<Runnable> arrayList = sFirstDrawHandlers;
        synchronized (arrayList) {
            if (!sFirstDrawComplete) {
                arrayList.add(callback);
            }
        }
    }

    public static void addConfigCallback(ConfigChangedCallback callback) {
        ArrayList<ConfigChangedCallback> arrayList = sConfigCallbacks;
        synchronized (arrayList) {
            arrayList.add(callback);
        }
    }

    public static void removeConfigCallback(ConfigChangedCallback callback) {
        ArrayList<ConfigChangedCallback> arrayList = sConfigCallbacks;
        synchronized (arrayList) {
            arrayList.remove(callback);
        }
    }

    public void setActivityConfigCallback(ActivityConfigCallback callback) {
        this.mActivityConfigCallback = callback;
    }

    public void setOnContentApplyWindowInsetsListener(Window.OnContentApplyWindowInsetsListener listener) {
        this.mAttachInfo.mContentOnApplyWindowInsetsListener = listener;
        if (!this.mFirst) {
            requestFitSystemWindows();
        }
    }

    public void addWindowCallbacks(WindowCallbacks callback) {
        this.mWindowCallbacks.add(callback);
    }

    public void removeWindowCallbacks(WindowCallbacks callback) {
        this.mWindowCallbacks.remove(callback);
    }

    public void reportDrawFinish() {
        CountDownLatch countDownLatch = this.mWindowDrawCountDown;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void profile() {
        this.mProfile = true;
    }

    private boolean isInTouchMode() {
        IWindowManager windowManager = WindowManagerGlobal.getWindowManagerService();
        if (windowManager != null) {
            try {
                return windowManager.isInTouchMode(getDisplayId());
            } catch (RemoteException e2) {
                return false;
            }
        }
        return false;
    }

    public void notifyChildRebuilt() {
        if (this.mView instanceof RootViewSurfaceTaker) {
            SurfaceHolder.Callback2 callback2 = this.mSurfaceHolderCallback;
            if (callback2 != null) {
                this.mSurfaceHolder.removeCallback(callback2);
            }
            SurfaceHolder.Callback2 willYouTakeTheSurface = this.mView.willYouTakeTheSurface();
            this.mSurfaceHolderCallback = willYouTakeTheSurface;
            if (willYouTakeTheSurface != null) {
                TakenSurfaceHolder takenSurfaceHolder = new TakenSurfaceHolder();
                this.mSurfaceHolder = takenSurfaceHolder;
                takenSurfaceHolder.setFormat(0);
                this.mSurfaceHolder.addCallback(this.mSurfaceHolderCallback);
            } else {
                this.mSurfaceHolder = null;
            }
            InputQueue.Callback willYouTakeTheInputQueue = this.mView.willYouTakeTheInputQueue();
            this.mInputQueueCallback = willYouTakeTheInputQueue;
            if (willYouTakeTheInputQueue != null) {
                willYouTakeTheInputQueue.onInputQueueCreated(this.mInputQueue);
            }
        }
        updateLastConfigurationFromResources(getConfiguration());
        reportNextDraw("rebuilt");
        if (this.mStopped) {
            setWindowStopped(false);
        }
    }

    private Configuration getConfiguration() {
        return this.mContext.getResources().getConfiguration();
    }

    private WindowConfiguration getCompatWindowConfiguration() {
        WindowConfiguration winConfig = getConfiguration().windowConfiguration;
        if (this.mInvCompatScale == 1.0f) {
            return winConfig;
        }
        this.mTempWinConfig.setTo(winConfig);
        this.mTempWinConfig.scale(this.mInvCompatScale);
        return this.mTempWinConfig;
    }

    public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView) {
        setView(view, attrs, panelParentView, UserHandle.myUserId());
    }

    public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView, int userId) {
        Throwable th;
        WindowManager.LayoutParams attrs2;
        Rect attachedFrame;
        PendingInsetsController pendingInsetsController;
        synchronized (this) {
            try {
                if (this.mView == null) {
                    this.mView = view;
                    this.mViewRootImplExt.hookSetView(view, this.mContext);
                    if (this.mViewRootImplExt.needUpdateInternalDisplay(this.mContext, this.mDisplay)) {
                        updateInternalDisplay(this.mContext.getDisplayId(), view.getResources());
                    }
                    if (this.mViewRootImplExt.changeActivityPreloadDisplay(this.mContext.getDisplayId(), this.mDisplay.getName())) {
                        updateInternalDisplay(this.mContext.getDisplayId(), view.getResources());
                    }
                    this.mViewLayoutDirectionInitial = this.mView.getRawLayoutDirection();
                    this.mFallbackEventHandler.setView(view);
                    try {
                        this.mWindowAttributes.copyFrom(attrs);
                        if (this.mWindowAttributes.packageName == null) {
                            this.mWindowAttributes.packageName = this.mBasePackageName;
                        }
                        this.mWindowAttributes.privateFlags |= 33554432;
                        attrs2 = this.mWindowAttributes;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        this.mViewRootImplExt.setScrollToTopRootView(this.mView, attrs2);
                        setTag();
                        if (DEBUG_KEEP_SCREEN_ON && (this.mClientWindowLayoutFlags & 128) != 0 && (attrs2.flags & 128) == 0) {
                            Slog.d(this.mTag, "setView: FLAG_KEEP_SCREEN_ON changed from true to false!");
                        }
                        this.mClientWindowLayoutFlags = attrs2.flags;
                        setAccessibilityFocus(null, null);
                        if (view instanceof RootViewSurfaceTaker) {
                            SurfaceHolder.Callback2 willYouTakeTheSurface = ((RootViewSurfaceTaker) view).willYouTakeTheSurface();
                            this.mSurfaceHolderCallback = willYouTakeTheSurface;
                            if (willYouTakeTheSurface != null) {
                                TakenSurfaceHolder takenSurfaceHolder = new TakenSurfaceHolder();
                                this.mSurfaceHolder = takenSurfaceHolder;
                                takenSurfaceHolder.setFormat(0);
                                this.mSurfaceHolder.addCallback(this.mSurfaceHolderCallback);
                            }
                        }
                        if (!attrs2.hasManualSurfaceInsets) {
                            attrs2.setSurfaceInsets(view, false, true);
                        }
                        CompatibilityInfo compatibilityInfo = this.mDisplay.getDisplayAdjustments().getCompatibilityInfo();
                        this.mTranslator = compatibilityInfo.getTranslator();
                        if (this.mSurfaceHolder == null) {
                            enableHardwareAcceleration(attrs2);
                            boolean useMTRenderer = this.mAttachInfo.mThreadedRenderer != null;
                            if (this.mUseMTRenderer != useMTRenderer) {
                                endDragResizing();
                                this.mUseMTRenderer = useMTRenderer;
                            }
                        }
                        boolean restore = false;
                        CompatibilityInfo.Translator translator = this.mTranslator;
                        if (translator != null) {
                            this.mSurface.setCompatibilityTranslator(translator);
                            restore = true;
                            attrs2.backup();
                            this.mTranslator.translateWindowLayout(attrs2);
                        }
                        if (DEBUG_LAYOUT) {
                            Log.d(this.mTag, "WindowLayout in setView:" + ((Object) attrs2));
                        }
                        if (!compatibilityInfo.supportsScreen()) {
                            attrs2.privateFlags |= 128;
                            this.mLastInCompatMode = true;
                        }
                        this.mSoftInputMode = attrs2.softInputMode;
                        this.mWindowAttributesChanged = true;
                        this.mAttachInfo.mRootView = view;
                        this.mAttachInfo.mScalingRequired = this.mTranslator != null;
                        View.AttachInfo attachInfo = this.mAttachInfo;
                        CompatibilityInfo.Translator translator2 = this.mTranslator;
                        attachInfo.mApplicationScale = translator2 == null ? 1.0f : translator2.applicationScale;
                        if (panelParentView != null) {
                            this.mAttachInfo.mPanelParentWindowToken = panelParentView.getApplicationWindowToken();
                        }
                        this.mAdded = true;
                        requestLayout();
                        InputChannel inputChannel = null;
                        if ((this.mWindowAttributes.inputFeatures & 1) == 0) {
                            inputChannel = new InputChannel();
                        }
                        this.mForceDecorViewVisibility = (this.mWindowAttributes.privateFlags & 8192) != 0;
                        RootViewSurfaceTaker rootViewSurfaceTaker = this.mView;
                        if ((rootViewSurfaceTaker instanceof RootViewSurfaceTaker) && (pendingInsetsController = rootViewSurfaceTaker.providePendingInsetsController()) != null) {
                            pendingInsetsController.replayAndAttach(this.mInsetsController);
                        }
                        try {
                            try {
                                this.mOrigWindowType = this.mWindowAttributes.type;
                                this.mAttachInfo.mRecomputeGlobalAttributes = true;
                                collectViewAttributes();
                                adjustLayoutParamsForCompatibility(this.mWindowAttributes);
                                controlInsetsForCompatibility(this.mWindowAttributes);
                                Rect attachedFrame2 = new Rect();
                                float[] compatScale = {1.0f};
                                int res = this.mWindowSession.addToDisplayAsUser(this.mWindow, this.mWindowAttributes, getHostVisibility(), this.mDisplay.getDisplayId(), userId, this.mInsetsController.getRequestedVisibleTypes(), inputChannel, this.mTempInsets, this.mTempControls, attachedFrame2, compatScale);
                                if (attachedFrame2.isValid()) {
                                    attachedFrame = attachedFrame2;
                                } else {
                                    attachedFrame = null;
                                }
                                CompatibilityInfo.Translator translator3 = this.mTranslator;
                                if (translator3 != null) {
                                    translator3.translateInsetsStateInScreenToAppWindow(this.mTempInsets);
                                    this.mTranslator.translateSourceControlsInScreenToAppWindow(this.mTempControls.get());
                                    this.mTranslator.translateRectInScreenToAppWindow(attachedFrame);
                                }
                                this.mTmpFrames.attachedFrame = attachedFrame;
                                this.mTmpFrames.compatScale = compatScale[0];
                                this.mInvCompatScale = 1.0f / compatScale[0];
                                if (restore) {
                                    attrs2.restore();
                                }
                                this.mAttachInfo.mAlwaysConsumeSystemBars = (res & 4) != 0;
                                this.mPendingAlwaysConsumeSystemBars = this.mAttachInfo.mAlwaysConsumeSystemBars;
                                this.mInsetsController.onStateChanged(this.mTempInsets);
                                this.mInsetsController.onControlsChanged(this.mTempControls.get());
                                InsetsState state = this.mInsetsController.getState();
                                Rect displayCutoutSafe = this.mTempRect;
                                state.getDisplayCutoutSafe(displayCutoutSafe);
                                WindowConfiguration winConfig = getCompatWindowConfiguration();
                                this.mWindowLayout.computeFrames(this.mWindowAttributes, state, displayCutoutSafe, winConfig.getBounds(), winConfig.getWindowingMode(), -1, -1, this.mInsetsController.getRequestedVisibleTypes(), 1.0f, this.mTmpFrames);
                                setFrame(this.mTmpFrames.frame, true);
                                registerBackCallbackOnWindow();
                                if (DEBUG_LAYOUT) {
                                    Log.v(this.mTag, "Added window " + ((Object) this.mWindow));
                                }
                                if (res < 0) {
                                    this.mAttachInfo.mRootView = null;
                                    this.mAdded = false;
                                    this.mFallbackEventHandler.setView(null);
                                    unscheduleTraversals();
                                    setAccessibilityFocus(null, null);
                                    this.mAccessibilityInteractionConnectionManager.ensureNoConnection();
                                    this.mAccessibilityManager.removeAccessibilityStateChangeListener(this.mAccessibilityInteractionConnectionManager);
                                    this.mAccessibilityManager.removeHighTextContrastStateChangeListener(this.mHighContrastTextManager);
                                    removeSendWindowContentChangedCallback();
                                    switch (res) {
                                        case -11:
                                            throw new WindowManager.BadTokenException("Unable to add Window " + ((Object) this.mWindow) + " -- requested userId is not valid");
                                        case -10:
                                            throw new WindowManager.InvalidDisplayException("Unable to add window " + ((Object) this.mWindow) + " -- the specified window type " + this.mWindowAttributes.type + " is not valid");
                                        case -9:
                                            throw new WindowManager.InvalidDisplayException("Unable to add window " + ((Object) this.mWindow) + " -- the specified display can not be found");
                                        case -8:
                                            throw new WindowManager.BadTokenException("Unable to add window " + ((Object) this.mWindow) + " -- permission denied for window type " + this.mWindowAttributes.type);
                                        case -7:
                                            throw new WindowManager.BadTokenException("Unable to add window " + ((Object) this.mWindow) + " -- another window of type " + this.mWindowAttributes.type + " already exists");
                                        case -6:
                                            return;
                                        case -5:
                                            throw new WindowManager.BadTokenException("Unable to add window -- window " + ((Object) this.mWindow) + " has already been added");
                                        case -4:
                                            throw new WindowManager.BadTokenException("Unable to add window -- app for token " + ((Object) attrs2.token) + " is exiting");
                                        case -3:
                                            throw new WindowManager.BadTokenException("Unable to add window -- token " + ((Object) attrs2.token) + " is not for an application");
                                        case -2:
                                        case -1:
                                            throw new WindowManager.BadTokenException("Unable to add window -- token " + ((Object) attrs2.token) + " is not valid; is your activity running?");
                                        default:
                                            throw new RuntimeException("Unable to add window -- unknown error code " + res);
                                    }
                                }
                                registerListeners();
                                this.mAttachInfo.mDisplayState = this.mDisplay.getState();
                                this.mLastDisplayStateSource = "State " + this.mDisplay.getState() + " caller " + Debug.getCallers(30);
                                if ((res & 8) != 0) {
                                    this.mUseBLASTAdapter = true;
                                }
                                if (view instanceof RootViewSurfaceTaker) {
                                    this.mInputQueueCallback = ((RootViewSurfaceTaker) view).willYouTakeTheInputQueue();
                                }
                                if (inputChannel != null) {
                                    if (this.mInputQueueCallback != null) {
                                        InputQueue inputQueue = new InputQueue();
                                        this.mInputQueue = inputQueue;
                                        this.mInputQueueCallback.onInputQueueCreated(inputQueue);
                                    }
                                    this.mInputEventReceiver = new WindowInputEventReceiver(inputChannel, Looper.myLooper());
                                    if (this.mAttachInfo.mThreadedRenderer != null) {
                                        InputMetricsListener listener = new InputMetricsListener();
                                        this.mHardwareRendererObserver = new HardwareRendererObserver(listener, listener.data, this.mHandler, true);
                                        this.mAttachInfo.mThreadedRenderer.addObserver(this.mHardwareRendererObserver);
                                    }
                                    this.mUnbufferedInputSource = this.mView.mUnbufferedInputSource;
                                }
                                view.assignParent(this);
                                this.mAddedTouchMode = (res & 1) != 0;
                                this.mAppVisible = (res & 2) != 0;
                                if (this.mAccessibilityManager.isEnabled()) {
                                    this.mAccessibilityInteractionConnectionManager.ensureConnection();
                                    setAccessibilityWindowAttributesIfNeeded();
                                }
                                if (view.getImportantForAccessibility() == 0) {
                                    view.setImportantForAccessibility(1);
                                }
                                CharSequence counterSuffix = attrs2.getTitle();
                                SyntheticInputStage syntheticInputStage = new SyntheticInputStage();
                                this.mSyntheticInputStage = syntheticInputStage;
                                InputStage viewPostImeStage = new ViewPostImeInputStage(syntheticInputStage);
                                InputStage nativePostImeStage = new NativePostImeInputStage(viewPostImeStage, "aq:native-post-ime:" + ((Object) counterSuffix));
                                InputStage earlyPostImeStage = new EarlyPostImeInputStage(nativePostImeStage);
                                InputStage imeStage = new ImeInputStage(earlyPostImeStage, "aq:ime:" + ((Object) counterSuffix));
                                InputStage viewPreImeStage = new ViewPreImeInputStage(imeStage);
                                InputStage nativePreImeStage = new NativePreImeInputStage(viewPreImeStage, "aq:native-pre-ime:" + ((Object) counterSuffix));
                                this.mFirstInputStage = nativePreImeStage;
                                this.mFirstPostImeInputStage = earlyPostImeStage;
                                this.mPendingInputEventQueueLengthCounterName = "aq:pending:" + ((Object) counterSuffix);
                                if (this.mRemoved && this.mAppVisible) {
                                    if (LOCAL_LOGV) {
                                        Log.v(this.mTag, "setView() enabling visibility when removed");
                                    }
                                }
                                AnimationHandler.requestAnimatorsEnabled(this.mAppVisible, this);
                            } finally {
                            }
                        } catch (RemoteException | RuntimeException e2) {
                            this.mAdded = false;
                            this.mView = null;
                            this.mAttachInfo.mRootView = null;
                            this.mFallbackEventHandler.setView(null);
                            unscheduleTraversals();
                            setAccessibilityFocus(null, null);
                            this.mAccessibilityInteractionConnectionManager.ensureNoConnection();
                            this.mAccessibilityManager.removeAccessibilityStateChangeListener(this.mAccessibilityInteractionConnectionManager);
                            this.mAccessibilityManager.removeHighTextContrastStateChangeListener(this.mHighContrastTextManager);
                            removeSendWindowContentChangedCallback();
                            throw new RuntimeException("Adding window failed", e2);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessibilityWindowAttributesIfNeeded() {
        boolean registered = this.mAttachInfo.mAccessibilityWindowId != -1;
        if (registered) {
            AccessibilityWindowAttributes attributes = new AccessibilityWindowAttributes(this.mWindowAttributes, this.mContext.getResources().getConfiguration().getLocales());
            if (!attributes.equals(this.mAccessibilityWindowAttributes)) {
                this.mAccessibilityWindowAttributes = attributes;
                this.mAccessibilityManager.setAccessibilityWindowAttributes(getDisplayId(), this.mAttachInfo.mAccessibilityWindowId, attributes);
            }
        }
    }

    private void registerListeners() {
        this.mAccessibilityManager.addAccessibilityStateChangeListener(this.mAccessibilityInteractionConnectionManager, this.mHandler);
        this.mAccessibilityManager.addHighTextContrastStateChangeListener(this.mHighContrastTextManager, this.mHandler);
        DisplayManagerGlobal.getInstance().registerDisplayListener(this.mDisplayListener, this.mHandler, 7L);
        this.mLastDisplayListenerState = "registerListeners , time " + System.currentTimeMillis() + " caller " + Debug.getCallers(30);
    }

    private void unregisterListeners() {
        this.mAccessibilityManager.removeAccessibilityStateChangeListener(this.mAccessibilityInteractionConnectionManager);
        this.mAccessibilityManager.removeHighTextContrastStateChangeListener(this.mHighContrastTextManager);
        DisplayManagerGlobal.getInstance().unregisterDisplayListener(this.mDisplayListener);
        this.mLastDisplayListenerState = "unregisterListeners , time " + System.currentTimeMillis() + " caller " + Debug.getCallers(30);
    }

    private void setTag() {
        String[] split = this.mWindowAttributes.getTitle().toString().split("\\.");
        if (split.length > 0) {
            this.mTag = "VRI[" + split[split.length - 1] + "]";
        }
    }

    public int getWindowFlags() {
        return this.mWindowAttributes.flags;
    }

    public int getDisplayId() {
        return this.mDisplay.getDisplayId();
    }

    public CharSequence getTitle() {
        return this.mWindowAttributes.getTitle();
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroyHardwareResources() {
        ThreadedRenderer renderer = this.mAttachInfo.mThreadedRenderer;
        if (renderer != null) {
            if (Looper.myLooper() != this.mAttachInfo.mHandler.getLooper()) {
                this.mAttachInfo.mHandler.postAtFrontOfQueue(new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda16
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewRootImpl.this.destroyHardwareResources();
                    }
                });
            } else {
                renderer.destroyHardwareResources(this.mView);
                renderer.destroy();
            }
        }
    }

    public void detachFunctor(long functor) {
    }

    public static void invokeFunctor(long functor, boolean waitForCompletion) {
    }

    public void registerAnimatingRenderNode(RenderNode animator) {
        if (this.mAttachInfo.mThreadedRenderer != null) {
            this.mAttachInfo.mThreadedRenderer.registerAnimatingRenderNode(animator);
            return;
        }
        if (this.mAttachInfo.mPendingAnimatingRenderNodes == null) {
            this.mAttachInfo.mPendingAnimatingRenderNodes = new ArrayList();
        }
        this.mAttachInfo.mPendingAnimatingRenderNodes.add(animator);
    }

    public void registerVectorDrawableAnimator(NativeVectorDrawableAnimator animator) {
        if (this.mAttachInfo.mThreadedRenderer != null) {
            this.mAttachInfo.mThreadedRenderer.registerVectorDrawableAnimator(animator);
        }
    }

    public void registerRtFrameCallback(final HardwareRenderer.FrameDrawingCallback callback) {
        if (this.mAttachInfo.mThreadedRenderer != null) {
            this.mAttachInfo.mThreadedRenderer.registerRtFrameCallback(new HardwareRenderer.FrameDrawingCallback() { // from class: android.view.ViewRootImpl.2
                public void onFrameDraw(long frame) {
                }

                public HardwareRenderer.FrameCommitCallback onFrameDraw(int syncResult, long frame) {
                    try {
                        return callback.onFrameDraw(syncResult, frame);
                    } catch (Exception e2) {
                        Log.e(ViewRootImpl.TAG, "Exception while executing onFrameDraw", e2);
                        return null;
                    }
                }
            });
        }
    }

    private void enableHardwareAcceleration(WindowManager.LayoutParams attrs) {
        this.mAttachInfo.mHardwareAccelerated = false;
        this.mAttachInfo.mHardwareAccelerationRequested = false;
        if (this.mTranslator != null) {
            return;
        }
        boolean hardwareAccelerated = (attrs.flags & 16777216) != 0;
        if (hardwareAccelerated) {
            boolean forceHwAccelerated = (attrs.privateFlags & 2) != 0;
            boolean fakeHwAccelerated = (attrs.privateFlags & 1) != 0;
            if (fakeHwAccelerated) {
                this.mAttachInfo.mHardwareAccelerationRequested = true;
                return;
            }
            if (ThreadedRenderer.sRendererEnabled || forceHwAccelerated) {
                if (this.mAttachInfo.mThreadedRenderer != null) {
                    this.mAttachInfo.mThreadedRenderer.destroy();
                }
                Rect insets = attrs.surfaceInsets;
                boolean hasSurfaceInsets = (insets.left == 0 && insets.right == 0 && insets.top == 0 && insets.bottom == 0) ? false : true;
                boolean translucent = attrs.format != -1 || hasSurfaceInsets;
                ThreadedRenderer renderer = ThreadedRenderer.create(this.mContext, translucent, attrs.getTitle().toString());
                this.mAttachInfo.mThreadedRenderer = renderer;
                renderer.setSurfaceControl(this.mSurfaceControl, this.mBlastBufferQueue);
                updateColorModeIfNeeded(attrs.getColorMode());
                updateRenderHdrSdrRatio();
                updateForceDarkMode();
                this.mAttachInfo.mHardwareAccelerated = true;
                this.mAttachInfo.mHardwareAccelerationRequested = true;
                HardwareRendererObserver hardwareRendererObserver = this.mHardwareRendererObserver;
                if (hardwareRendererObserver != null) {
                    renderer.addObserver(hardwareRendererObserver);
                }
            }
        }
    }

    private int getNightMode() {
        return getConfiguration().uiMode & 48;
    }

    private void updateForceDarkMode() {
        if (this.mAttachInfo.mThreadedRenderer == null) {
            return;
        }
        boolean useAutoDark = getNightMode() == 32;
        this.mViewRootImplExt.logConfigurationNightError(this.mContext, useAutoDark);
        if (useAutoDark) {
            boolean forceDarkAllowedDefault = SystemProperties.getBoolean(ThreadedRenderer.DEBUG_FORCE_DARK, false);
            TypedArray a10 = this.mContext.obtainStyledAttributes(R.styleable.Theme);
            useAutoDark = a10.getBoolean(279, true) && a10.getBoolean(278, forceDarkAllowedDefault);
            a10.recycle();
            this.mViewRootImplExt.logForceDarkAllowedStatus(this.mContext, forceDarkAllowedDefault);
        }
        this.mViewRootImplExt.forceDarkWithoutTheme(this.mContext, this.mView, useAutoDark);
        if (this.mAttachInfo.mThreadedRenderer != null && this.mAttachInfo.mThreadedRenderer.setForceDark(useAutoDark)) {
            invalidateWorld(this.mView);
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WindowLeaked getLocation() {
        return this.mLocation;
    }

    public void setLayoutParams(WindowManager.LayoutParams attrs, boolean newView) {
        int oldInsetLeft;
        synchronized (this) {
            int oldInsetLeft2 = this.mWindowAttributes.surfaceInsets.left;
            int oldInsetTop = this.mWindowAttributes.surfaceInsets.top;
            int oldInsetRight = this.mWindowAttributes.surfaceInsets.right;
            int oldInsetBottom = this.mWindowAttributes.surfaceInsets.bottom;
            int oldSoftInputMode = this.mWindowAttributes.softInputMode;
            boolean oldHasManualSurfaceInsets = this.mWindowAttributes.hasManualSurfaceInsets;
            if (DEBUG_KEEP_SCREEN_ON && (this.mClientWindowLayoutFlags & 128) != 0 && (attrs.flags & 128) == 0) {
                Slog.d(this.mTag, "setLayoutParams: FLAG_KEEP_SCREEN_ON from true to false!");
            }
            this.mClientWindowLayoutFlags = attrs.flags;
            int compatibleWindowFlag = this.mWindowAttributes.privateFlags & 128;
            int systemUiVisibility = this.mWindowAttributes.systemUiVisibility;
            int subtreeSystemUiVisibility = this.mWindowAttributes.subtreeSystemUiVisibility;
            int appearance = this.mWindowAttributes.insetsFlags.appearance;
            int behavior = this.mWindowAttributes.insetsFlags.behavior;
            int appearanceAndBehaviorPrivateFlags = this.mWindowAttributes.privateFlags & 201326592;
            int changes = this.mWindowAttributes.copyFrom(attrs);
            if ((524288 & changes) != 0) {
                this.mAttachInfo.mRecomputeGlobalAttributes = true;
            }
            if ((changes & 1) != 0) {
                this.mAttachInfo.mNeedsUpdateLightCenter = true;
            }
            if (this.mWindowAttributes.packageName == null) {
                this.mWindowAttributes.packageName = this.mBasePackageName;
            }
            this.mWindowAttributes.systemUiVisibility = systemUiVisibility;
            this.mWindowAttributes.subtreeSystemUiVisibility = subtreeSystemUiVisibility;
            this.mWindowAttributes.insetsFlags.appearance = appearance;
            this.mWindowAttributes.insetsFlags.behavior = behavior;
            this.mWindowAttributes.privateFlags |= compatibleWindowFlag | appearanceAndBehaviorPrivateFlags | 33554432;
            if (this.mWindowAttributes.preservePreviousSurfaceInsets) {
                this.mWindowAttributes.surfaceInsets.set(oldInsetLeft2, oldInsetTop, oldInsetRight, oldInsetBottom);
                this.mWindowAttributes.hasManualSurfaceInsets = oldHasManualSurfaceInsets;
            } else if (this.mWindowAttributes.surfaceInsets.left != oldInsetLeft2 || this.mWindowAttributes.surfaceInsets.top != oldInsetTop || this.mWindowAttributes.surfaceInsets.right != oldInsetRight || this.mWindowAttributes.surfaceInsets.bottom != oldInsetBottom) {
                this.mNeedsRendererSetup = true;
            }
            applyKeepScreenOnFlag(this.mWindowAttributes);
            if (newView) {
                this.mSoftInputMode = attrs.softInputMode;
                requestLayout();
            }
            if ((attrs.softInputMode & 240) == 0) {
                WindowManager.LayoutParams layoutParams = this.mWindowAttributes;
                oldInsetLeft = oldSoftInputMode;
                layoutParams.softInputMode = (oldInsetLeft & 240) | (layoutParams.softInputMode & (-241));
            } else {
                oldInsetLeft = oldSoftInputMode;
            }
            if (this.mWindowAttributes.softInputMode != oldInsetLeft) {
                requestFitSystemWindows();
            }
            this.mWindowAttributesChanged = true;
            this.mViewRootImplExt.setScrollToTopRootView(this.mView, this.mWindowAttributes);
            scheduleTraversals();
            setAccessibilityWindowAttributesIfNeeded();
        }
    }

    void handleAppVisibility(boolean visible) {
        boolean z10 = this.mAppVisible;
        if (z10 != visible) {
            this.mViewRootImplExt.markHandleAppVisibility(z10, this.mWindowAttributes);
            boolean previousVisible = getHostVisibility() == 0;
            this.mAppVisible = visible;
            boolean currentVisible = getHostVisibility() == 0;
            if (previousVisible != currentVisible) {
                this.mAppVisibilityChanged = true;
                scheduleTraversals();
            }
            if (!this.mRemoved || !this.mAppVisible) {
                AnimationHandler.requestAnimatorsEnabled(this.mAppVisible, this);
            } else if (LOCAL_LOGV) {
                Log.v(this.mTag, "handleAppVisibility() enabling visibility when removed");
            }
        }
    }

    void handleGetNewSurface() {
        this.mNewSurfaceNeeded = true;
        this.mFullRedrawNeeded = true;
        scheduleTraversals();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
    
        if (r24.mViewRootImplExt.shouldBlockResizeReportForSplashScreen(r24.mWindowAttributes, r24.mBasePackageName) != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleResized(int r25, com.android.internal.os.SomeArgs r26) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.handleResized(int, com.android.internal.os.SomeArgs):void");
    }

    public void onMovedToDisplay(int displayId, Configuration config) {
        if (this.mDisplay.getDisplayId() == displayId) {
            return;
        }
        if (!InsetsState.LTW_DISABLE) {
            this.mViewRootImplExt.getRTWindowInsetHelper().updateDisplayId(displayId);
        }
        updateInternalDisplay(displayId, this.mView.getResources());
        this.mImeFocusController.onMovedToDisplay();
        this.mAttachInfo.mDisplayState = this.mDisplay.getState();
        this.mLastDisplayStateSource = "State " + this.mDisplay.getState() + " caller " + Debug.getCallers(30);
        this.mView.dispatchMovedToDisplay(this.mDisplay, config);
    }

    private void updateInternalDisplay(int displayId, Resources resources) {
        Display display;
        Display display2;
        Display preferredDisplay = ResourcesManager.getInstance().getAdjustedDisplay(displayId, resources);
        Consumer<Display> consumer = this.mHdrSdrRatioChangedListener;
        if (consumer != null && (display2 = this.mDisplay) != null) {
            display2.unregisterHdrSdrRatioChangedListener(consumer);
        }
        if (preferredDisplay == null) {
            Slog.w(TAG, "Cannot get desired display with Id: " + displayId);
            this.mDisplay = ResourcesManager.getInstance().getAdjustedDisplay(0, resources);
        } else {
            this.mDisplay = preferredDisplay;
        }
        Consumer<Display> consumer2 = this.mHdrSdrRatioChangedListener;
        if (consumer2 != null && (display = this.mDisplay) != null) {
            display.registerHdrSdrRatioChangedListener(this.mExecutor, consumer2);
        }
        this.mLastDisplaySource = "From updateInternalDisplay " + this.mDisplay.getDisplayId() + " state " + this.mDisplay.getState() + " caller " + Debug.getCallers(30);
        this.mContext.updateDisplay(this.mDisplay.getDisplayId());
        this.mViewRootImplExt.onUpdateInternalDisplay(this.mDisplay);
    }

    void pokeDrawLockIfNeeded() {
        if (Display.isDozeState(this.mAttachInfo.mDisplayState) && this.mWindowAttributes.type == 1 && this.mAdded && this.mTraversalScheduled && this.mAttachInfo.mHasWindowFocus) {
            try {
                this.mWindowSession.pokeDrawLock(this.mWindow);
            } catch (RemoteException e2) {
            }
        }
    }

    @Override // android.view.ViewParent
    public void requestFitSystemWindows() {
        checkThread();
        this.mApplyInsetsRequested = true;
        scheduleTraversals();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyInsetsChanged() {
        this.mApplyInsetsRequested = true;
        requestLayout();
        if (View.sForceLayoutWhenInsetsChanged && this.mView != null && (this.mWindowAttributes.softInputMode & 240) == 16 && !this.mViewRootImplExt.disableRelayout()) {
            forceLayout(this.mView);
        }
        if (!this.mIsInTraversal) {
            scheduleTraversals();
        }
    }

    @Override // android.view.ViewParent
    public void requestLayout() {
        if (!this.mHandlingLayoutInLayoutRequest) {
            checkThread();
            this.mLayoutRequested = true;
            scheduleTraversals();
        }
    }

    @Override // android.view.ViewParent
    public boolean isLayoutRequested() {
        return this.mLayoutRequested;
    }

    @Override // android.view.ViewParent
    public void onDescendantInvalidated(View child, View descendant) {
        if ((descendant.mPrivateFlags & 64) != 0) {
            this.mIsAnimating = true;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate() {
        this.mDirty.set(0, 0, this.mWidth, this.mHeight);
        if (!this.mWillDrawSoon) {
            scheduleTraversals();
        }
    }

    void invalidateWorld(View view) {
        view.invalidate();
        if (view instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) view;
            for (int i10 = 0; i10 < parent.getChildCount(); i10++) {
                invalidateWorld(parent.getChildAt(i10));
            }
        }
    }

    @Override // android.view.ViewParent
    public void invalidateChild(View child, Rect dirty) {
        invalidateChildInParent(null, dirty);
    }

    @Override // android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        checkThread();
        if (DEBUG_DRAW) {
            Log.v(this.mTag, "Invalidate child: " + ((Object) dirty));
        }
        if (dirty == null) {
            invalidate();
            return null;
        }
        if (dirty.isEmpty() && !this.mIsAnimating) {
            return null;
        }
        if (this.mCurScrollY != 0 || this.mTranslator != null) {
            this.mTempRect.set(dirty);
            dirty = this.mTempRect;
            int i10 = this.mCurScrollY;
            if (i10 != 0) {
                dirty.offset(0, -i10);
            }
            CompatibilityInfo.Translator translator = this.mTranslator;
            if (translator != null) {
                translator.translateRectInAppWindowToScreen(dirty);
            }
            if (this.mAttachInfo.mScalingRequired) {
                dirty.inset(-1, -1);
            }
        }
        invalidateRectOnScreen(dirty);
        return null;
    }

    private void invalidateRectOnScreen(Rect dirty) {
        if (DEBUG_DRAW) {
            Log.v(this.mTag, "invalidateRectOnScreen: " + ((Object) dirty));
        }
        Rect localDirty = this.mDirty;
        localDirty.union(dirty.left, dirty.top, dirty.right, dirty.bottom);
        float appScale = this.mAttachInfo.mApplicationScale;
        boolean intersected = localDirty.intersect(0, 0, (int) ((this.mWidth * appScale) + 0.5f), (int) ((this.mHeight * appScale) + 0.5f));
        if (!intersected) {
            localDirty.setEmpty();
        }
        if (this.mWillDrawSoon) {
            return;
        }
        if (intersected || this.mIsAnimating) {
            scheduleTraversals();
        }
    }

    public void setIsAmbientMode(boolean ambient) {
        this.mIsAmbientMode = ambient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWindowStopped(boolean stopped) {
        checkThread();
        if (this.mStopped != stopped) {
            Log.d(this.mTag, "setWindowStopped stopped:" + stopped);
            this.mStopped = stopped;
            ThreadedRenderer renderer = this.mAttachInfo.mThreadedRenderer;
            if (renderer != null) {
                if (DEBUG_DRAW) {
                    Log.d(this.mTag, "WindowStopped on " + ((Object) getTitle()) + " set to " + this.mStopped);
                }
                renderer.setStopped(this.mStopped);
            }
            if (!this.mStopped) {
                this.mAppVisibilityChanged = true;
                scheduleTraversals();
                return;
            }
            if (renderer != null) {
                renderer.destroyHardwareResources(this.mView);
            }
            if (this.mSurface.isValid()) {
                if (this.mSurfaceHolder != null) {
                    notifyHolderSurfaceDestroyed();
                }
                notifySurfaceDestroyed();
            }
            destroySurface();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface SurfaceChangedCallback {
        void surfaceCreated(SurfaceControl.Transaction transaction);

        void surfaceDestroyed();

        void surfaceReplaced(SurfaceControl.Transaction transaction);

        default void vriDrawStarted(boolean isWmSync) {
        }
    }

    public void addSurfaceChangedCallback(SurfaceChangedCallback c4) {
        this.mSurfaceChangedCallbacks.add(c4);
    }

    public void removeSurfaceChangedCallback(SurfaceChangedCallback c4) {
        this.mSurfaceChangedCallbacks.remove(c4);
    }

    private void notifySurfaceCreated(SurfaceControl.Transaction t2) {
        this.mViewRootImplExt.updateLogLevel();
        for (int i10 = 0; i10 < this.mSurfaceChangedCallbacks.size(); i10++) {
            this.mSurfaceChangedCallbacks.get(i10).surfaceCreated(t2);
        }
    }

    private void notifySurfaceReplaced(SurfaceControl.Transaction t2) {
        for (int i10 = 0; i10 < this.mSurfaceChangedCallbacks.size(); i10++) {
            this.mSurfaceChangedCallbacks.get(i10).surfaceReplaced(t2);
        }
    }

    private void notifySurfaceDestroyed() {
        for (int i10 = 0; i10 < this.mSurfaceChangedCallbacks.size(); i10++) {
            this.mSurfaceChangedCallbacks.get(i10).surfaceDestroyed();
        }
    }

    private void notifyDrawStarted(boolean isWmSync) {
        for (int i10 = 0; i10 < this.mSurfaceChangedCallbacks.size(); i10++) {
            this.mSurfaceChangedCallbacks.get(i10).vriDrawStarted(isWmSync);
        }
    }

    public SurfaceControl getBoundsLayer() {
        if (this.mBoundsLayer == null) {
            this.mBoundsLayer = new SurfaceControl.Builder(this.mSurfaceSession).setContainerLayer().setName("Bounds for - " + getTitle().toString()).setParent(getSurfaceControl()).setCallsite("ViewRootImpl.getBoundsLayer").build();
            setBoundsLayerCrop(this.mTransaction);
            this.mTransaction.show(this.mBoundsLayer).apply();
        }
        return this.mBoundsLayer;
    }

    void updateBlastSurfaceIfNeeded() {
        if (!this.mSurfaceControl.isValid()) {
            return;
        }
        if (this.mWindowAttributes.isFullscreen()) {
            Slog.w(this.mTag, "updateBlastSurfaceIfNeeded, surfaceSize:" + ((Object) this.mSurfaceSize) + ", lastSurfaceSize:" + ((Object) this.mLastSurfaceSize) + ", format:" + this.mWindowAttributes.format + ", blastBufferQueue:" + ((Object) this.mBlastBufferQueue));
        }
        BLASTBufferQueue bLASTBufferQueue = this.mBlastBufferQueue;
        if (bLASTBufferQueue != null && bLASTBufferQueue.isSameSurfaceControl(this.mSurfaceControl)) {
            this.mBlastBufferQueue.update(this.mSurfaceControl, this.mSurfaceSize.x, this.mSurfaceSize.y, this.mWindowAttributes.format);
            return;
        }
        BLASTBufferQueue bLASTBufferQueue2 = this.mBlastBufferQueue;
        if (bLASTBufferQueue2 != null) {
            bLASTBufferQueue2.destroy();
        }
        BLASTBufferQueue bLASTBufferQueue3 = new BLASTBufferQueue(this.mViewRootImplExt.getOsieLayerName(this.mTag, this.mWindowAttributes.getTitle().toString()), this.mSurfaceControl, this.mSurfaceSize.x, this.mSurfaceSize.y, this.mWindowAttributes.format);
        this.mBlastBufferQueue = bLASTBufferQueue3;
        bLASTBufferQueue3.setTransactionHangCallback(sTransactionHangCallback);
        this.mViewRootImplSocExt.setBLASTBufferQueue(this.mBlastBufferQueue);
        this.mViewRootImplExt.updateBlastSurfaceIfNeeded(this.mBlastBufferQueue);
        Surface blastSurface = this.mBlastBufferQueue.createSurface();
        this.mSurface.transferFrom(blastSurface);
    }

    private void setBoundsLayerCrop(SurfaceControl.Transaction t2) {
        this.mTempRect.set(0, 0, this.mSurfaceSize.x, this.mSurfaceSize.y);
        this.mTempRect.inset(this.mWindowAttributes.surfaceInsets.left, this.mWindowAttributes.surfaceInsets.top, this.mWindowAttributes.surfaceInsets.right, this.mWindowAttributes.surfaceInsets.bottom);
        this.mTempRect.inset(this.mChildBoundingInsets.left, this.mChildBoundingInsets.top, this.mChildBoundingInsets.right, this.mChildBoundingInsets.bottom);
        t2.setWindowCrop(this.mBoundsLayer, this.mTempRect);
    }

    private boolean updateBoundsLayer(SurfaceControl.Transaction t2) {
        if (this.mBoundsLayer != null) {
            setBoundsLayerCrop(t2);
            return true;
        }
        return false;
    }

    private void prepareSurfaces() {
        SurfaceControl.Transaction t2 = this.mTransaction;
        SurfaceControl sc2 = getSurfaceControl();
        if (sc2.isValid() && updateBoundsLayer(t2)) {
            applyTransactionOnDraw(t2);
        }
    }

    private void destroySurface() {
        SurfaceControl surfaceControl = this.mBoundsLayer;
        if (surfaceControl != null) {
            surfaceControl.release();
            this.mBoundsLayer = null;
        }
        this.mSurface.release();
        this.mSurfaceControl.release();
        BLASTBufferQueue bLASTBufferQueue = this.mBlastBufferQueue;
        if (bLASTBufferQueue != null) {
            bLASTBufferQueue.destroy();
            this.mBlastBufferQueue = null;
        }
        if (this.mAttachInfo.mThreadedRenderer != null) {
            this.mAttachInfo.mThreadedRenderer.setSurfaceControl(null, null);
        }
        this.mViewRootImplExt.notifySurfaceDestroyed();
    }

    public void setPausedForTransition(boolean paused) {
        this.mPausedForTransition = paused;
    }

    @Override // android.view.ViewParent
    public ViewParent getParent() {
        return null;
    }

    @Override // android.view.ViewParent
    public boolean getChildVisibleRect(View child, Rect r10, Point offset) {
        if (child != this.mView) {
            throw new RuntimeException("child is not mine, honest!");
        }
        return r10.intersect(0, 0, this.mWidth, this.mHeight);
    }

    @Override // android.view.ViewParent
    public void bringChildToFront(View child) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHostVisibility() {
        View view = this.mView;
        if (view == null || !(this.mAppVisible || this.mForceDecorViewVisibility)) {
            return 8;
        }
        return view.getVisibility();
    }

    public void requestTransitionStart(LayoutTransition transition) {
        ArrayList<LayoutTransition> arrayList = this.mPendingTransitions;
        if (arrayList == null || !arrayList.contains(transition)) {
            if (this.mPendingTransitions == null) {
                this.mPendingTransitions = new ArrayList<>();
            }
            this.mPendingTransitions.add(transition);
        }
    }

    void notifyRendererOfFramePending() {
        if (this.mAttachInfo.mThreadedRenderer != null) {
            this.mAttachInfo.mThreadedRenderer.notifyFramePending();
        }
    }

    public void notifyRendererOfExpensiveFrame() {
        if (this.mAttachInfo.mThreadedRenderer != null) {
            this.mAttachInfo.mThreadedRenderer.notifyExpensiveFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scheduleTraversals() {
        if (this.mTraversalScheduled || this.mViewRootImplExt.shouldSkipScheduleTraversals(this)) {
            return;
        }
        String appendStr = this.mViewRootImplExt.markScheduleTraversals(this.mView, this.mWindowAttributes);
        Trace.traceBegin(8L, "scheduleTraversals " + appendStr);
        this.mTraversalScheduled = true;
        this.mTraversalBarrier = this.mHandler.getLooper().getQueue().postSyncBarrier();
        this.mChoreographer.postCallback(3, this.mTraversalRunnable, null);
        notifyRendererOfFramePending();
        pokeDrawLockIfNeeded();
        Trace.traceEnd(8L);
    }

    void unscheduleTraversals() {
        if (this.mTraversalScheduled) {
            this.mTraversalScheduled = false;
            this.mHandler.getLooper().getQueue().removeSyncBarrier(this.mTraversalBarrier);
            this.mChoreographer.removeCallbacks(3, this.mTraversalRunnable, null);
        }
    }

    void doTraversal() {
        if (this.mTraversalScheduled) {
            this.mTraversalScheduled = false;
            this.mHandler.getLooper().getQueue().removeSyncBarrier(this.mTraversalBarrier);
            if (this.mProfile) {
                Debug.startMethodTracing("ViewAncestor");
            }
            performTraversals();
            if (this.mProfile) {
                Debug.stopMethodTracing();
                this.mProfile = false;
            }
        }
    }

    private void applyKeepScreenOnFlag(WindowManager.LayoutParams params) {
        if (this.mAttachInfo.mKeepScreenOn) {
            params.flags |= 128;
        } else {
            params.flags = (params.flags & (-129)) | (this.mClientWindowLayoutFlags & 128);
        }
    }

    private boolean collectViewAttributes() {
        if (this.mAttachInfo.mRecomputeGlobalAttributes) {
            this.mAttachInfo.mRecomputeGlobalAttributes = false;
            boolean oldScreenOn = this.mAttachInfo.mKeepScreenOn;
            this.mAttachInfo.mKeepScreenOn = false;
            this.mAttachInfo.mSystemUiVisibility = 0;
            this.mAttachInfo.mHasSystemUiListeners = false;
            this.mView.dispatchCollectViewAttributes(this.mAttachInfo, 0);
            View.AttachInfo attachInfo = this.mAttachInfo;
            attachInfo.mSystemUiVisibility = this.mViewRootImplExt.changeSystemUiVisibility(attachInfo.mSystemUiVisibility);
            this.mAttachInfo.mSystemUiVisibility &= ~this.mAttachInfo.mDisabledSystemUiVisibility;
            WindowManager.LayoutParams params = this.mWindowAttributes;
            this.mAttachInfo.mSystemUiVisibility |= getImpliedSystemUiVisibility(params);
            SystemUiVisibilityInfo systemUiVisibilityInfo = this.mCompatibleVisibilityInfo;
            systemUiVisibilityInfo.globalVisibility = (systemUiVisibilityInfo.globalVisibility & (-2)) | (this.mAttachInfo.mSystemUiVisibility & 1);
            dispatchDispatchSystemUiVisibilityChanged();
            if (this.mAttachInfo.mKeepScreenOn != oldScreenOn || this.mAttachInfo.mSystemUiVisibility != params.subtreeSystemUiVisibility || this.mAttachInfo.mHasSystemUiListeners != params.hasSystemUiListeners) {
                applyKeepScreenOnFlag(params);
                params.subtreeSystemUiVisibility = this.mAttachInfo.mSystemUiVisibility;
                params.hasSystemUiListeners = this.mAttachInfo.mHasSystemUiListeners;
                this.mView.dispatchWindowSystemUiVisiblityChanged(this.mAttachInfo.mSystemUiVisibility);
                return true;
            }
        }
        return false;
    }

    private int getImpliedSystemUiVisibility(WindowManager.LayoutParams params) {
        int vis = 0;
        if ((params.flags & 67108864) != 0) {
            vis = 0 | 1280;
        }
        if ((params.flags & 134217728) != 0) {
            return vis | 768;
        }
        return vis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateCompatSysUiVisibility(int visibleTypes, int requestedVisibleTypes, int controllableTypes) {
        int visibleTypes2 = (requestedVisibleTypes & controllableTypes) | ((~controllableTypes) & visibleTypes);
        updateCompatSystemUiVisibilityInfo(4, WindowInsets.Type.statusBars(), visibleTypes2, controllableTypes);
        updateCompatSystemUiVisibilityInfo(2, WindowInsets.Type.navigationBars(), visibleTypes2, controllableTypes);
        dispatchDispatchSystemUiVisibilityChanged();
    }

    private void updateCompatSystemUiVisibilityInfo(int systemUiFlag, int insetsType, int visibleTypes, int controllableTypes) {
        SystemUiVisibilityInfo info = this.mCompatibleVisibilityInfo;
        boolean willBeVisible = (visibleTypes & insetsType) != 0;
        boolean hasControl = (controllableTypes & insetsType) != 0;
        boolean wasInvisible = (this.mAttachInfo.mSystemUiVisibility & systemUiFlag) != 0;
        if (willBeVisible) {
            info.globalVisibility &= ~systemUiFlag;
            if (hasControl && wasInvisible) {
                info.localChanges |= systemUiFlag;
                return;
            }
            return;
        }
        info.globalVisibility |= systemUiFlag;
        info.localChanges &= ~systemUiFlag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLowProfileModeIfNeeded(int showTypes, boolean fromIme) {
        SystemUiVisibilityInfo info = this.mCompatibleVisibilityInfo;
        if ((WindowInsets.Type.systemBars() & showTypes) != 0 && !fromIme && (info.globalVisibility & 1) != 0) {
            info.globalVisibility &= -2;
            info.localChanges |= 1;
            dispatchDispatchSystemUiVisibilityChanged();
        }
    }

    private void dispatchDispatchSystemUiVisibilityChanged() {
        this.mViewRootImplExt.hookDispatchDispatchSystemUiVisibilityChanged();
        if (this.mDispatchedSystemUiVisibility != this.mCompatibleVisibilityInfo.globalVisibility) {
            this.mHandler.removeMessages(17);
            ViewRootHandler viewRootHandler = this.mHandler;
            viewRootHandler.sendMessage(viewRootHandler.obtainMessage(17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDispatchSystemUiVisibilityChanged() {
        if (this.mView == null) {
            return;
        }
        SystemUiVisibilityInfo info = this.mCompatibleVisibilityInfo;
        if (info.localChanges != 0) {
            this.mView.updateLocalSystemUiVisibility(info.localValue, info.localChanges);
            info.localChanges = 0;
        }
        int visibility = info.globalVisibility & 7;
        if (this.mDispatchedSystemUiVisibility != visibility) {
            this.mDispatchedSystemUiVisibility = visibility;
            this.mView.dispatchSystemUiVisibilityChanged(visibility);
        }
    }

    public static void adjustLayoutParamsForCompatibility(WindowManager.LayoutParams inOutParams) {
        int sysUiVis = inOutParams.systemUiVisibility | inOutParams.subtreeSystemUiVisibility;
        int flags = inOutParams.flags;
        int type = inOutParams.type;
        int adjust = inOutParams.softInputMode & 240;
        if ((inOutParams.privateFlags & 67108864) == 0) {
            inOutParams.insetsFlags.appearance = 0;
            if ((sysUiVis & 1) != 0) {
                inOutParams.insetsFlags.appearance |= 4;
            }
            if ((sysUiVis & 8192) != 0) {
                inOutParams.insetsFlags.appearance |= 8;
            }
            if ((sysUiVis & 16) != 0) {
                inOutParams.insetsFlags.appearance |= 16;
            }
        }
        if ((inOutParams.privateFlags & 134217728) == 0) {
            if ((sysUiVis & 4096) != 0 || (flags & 1024) != 0) {
                inOutParams.insetsFlags.behavior = 2;
            } else {
                inOutParams.insetsFlags.behavior = 1;
            }
        }
        inOutParams.privateFlags &= -1073741825;
        if ((inOutParams.privateFlags & 268435456) != 0) {
            return;
        }
        int types = inOutParams.getFitInsetsTypes();
        boolean ignoreVis = inOutParams.isFitInsetsIgnoringVisibility();
        if ((sysUiVis & 1024) != 0 || (flags & 256) != 0 || (67108864 & flags) != 0) {
            types &= ~WindowInsets.Type.statusBars();
        }
        if ((sysUiVis & 512) != 0 || (flags & 134217728) != 0) {
            types &= ~WindowInsets.Type.systemBars();
        }
        if (type == 2005 || type == 2003) {
            ignoreVis = true;
        } else if ((WindowInsets.Type.systemBars() & types) == WindowInsets.Type.systemBars()) {
            if (adjust == 16) {
                types |= WindowInsets.Type.ime();
            } else {
                inOutParams.privateFlags |= 1073741824;
            }
        }
        inOutParams.setFitInsetsTypes(types);
        inOutParams.setFitInsetsIgnoringVisibility(ignoreVis);
        inOutParams.privateFlags &= -268435457;
    }

    private void controlInsetsForCompatibility(WindowManager.LayoutParams params) {
        int sysUiVis = params.systemUiVisibility | params.subtreeSystemUiVisibility;
        int flags = params.flags;
        boolean matchParent = params.width == -1 && params.height == -1;
        boolean nonAttachedAppWindow = params.type >= 1 && params.type <= 99;
        boolean statusWasHiddenByFlags = (this.mTypesHiddenByFlags & WindowInsets.Type.statusBars()) != 0;
        boolean statusIsHiddenByFlags = (sysUiVis & 4) != 0 || ((flags & 1024) != 0 && matchParent && nonAttachedAppWindow);
        boolean navWasHiddenByFlags = (this.mTypesHiddenByFlags & WindowInsets.Type.navigationBars()) != 0;
        boolean navIsHiddenByFlags = (sysUiVis & 2) != 0;
        int typesToHide = 0;
        int typesToShow = 0;
        if (statusIsHiddenByFlags && !statusWasHiddenByFlags) {
            typesToHide = 0 | WindowInsets.Type.statusBars();
        } else if (!statusIsHiddenByFlags && statusWasHiddenByFlags) {
            typesToShow = 0 | WindowInsets.Type.statusBars();
        }
        if (navIsHiddenByFlags && !navWasHiddenByFlags) {
            typesToHide |= WindowInsets.Type.navigationBars();
        } else if (!navIsHiddenByFlags && navWasHiddenByFlags) {
            typesToShow |= WindowInsets.Type.navigationBars();
        }
        if (typesToHide != 0) {
            getInsetsController().hide(typesToHide);
        }
        if (typesToShow != 0) {
            getInsetsController().show(typesToShow);
        }
        int i10 = this.mTypesHiddenByFlags | typesToHide;
        this.mTypesHiddenByFlags = i10;
        this.mTypesHiddenByFlags = i10 & (~typesToShow);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean measureHierarchy(android.view.View r19, android.view.WindowManager.LayoutParams r20, android.content.res.Resources r21, int r22, int r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.measureHierarchy(android.view.View, android.view.WindowManager$LayoutParams, android.content.res.Resources, int, int, boolean):boolean");
    }

    public void resetIME() {
        this.mImeFocusController.onMovedToDisplay();
    }

    private boolean setMeasuredRootSizeFromSpec(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode != 1073741824 || heightMode != 1073741824) {
            return false;
        }
        this.mMeasuredWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        this.mMeasuredHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transformMatrixToGlobal(Matrix m10) {
        m10.preTranslate(this.mAttachInfo.mWindowLeft, this.mAttachInfo.mWindowTop);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transformMatrixToLocal(Matrix m10) {
        m10.postTranslate(-this.mAttachInfo.mWindowLeft, -this.mAttachInfo.mWindowTop);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowInsets getWindowInsets(boolean forceConstruct) {
        if (this.mLastWindowInsets == null || forceConstruct) {
            Configuration config = getConfiguration();
            WindowInsets calculateInsets = this.mInsetsController.calculateInsets(config.isScreenRound(), this.mAttachInfo.mAlwaysConsumeSystemBars, this.mWindowAttributes.type, config.windowConfiguration.getWindowingMode(), this.mWindowAttributes.softInputMode, this.mWindowAttributes.flags, this.mWindowAttributes.systemUiVisibility | this.mWindowAttributes.subtreeSystemUiVisibility);
            this.mLastWindowInsets = calculateInsets;
            this.mLastWindowInsets = this.mViewRootImplExt.adjustWindowInsetsForDispatchIfNeed(calculateInsets);
            this.mAttachInfo.mContentInsets.set(this.mLastWindowInsets.getSystemWindowInsets().toRect());
            this.mAttachInfo.mStableInsets.set(this.mLastWindowInsets.getStableInsets().toRect());
            this.mAttachInfo.mVisibleInsets.set(this.mInsetsController.calculateVisibleInsets(this.mWindowAttributes.type, config.windowConfiguration.getWindowingMode(), this.mWindowAttributes.softInputMode, this.mWindowAttributes.flags).toRect());
        }
        return this.mLastWindowInsets;
    }

    public void dispatchApplyInsets(View host) {
        Trace.traceBegin(8L, "dispatchApplyInsets");
        this.mApplyInsetsRequested = false;
        WindowInsets insets = getWindowInsets(true);
        if (!shouldDispatchCutout()) {
            insets = insets.consumeDisplayCutout();
        }
        host.dispatchApplyWindowInsets(insets);
        this.mViewRootImplExt.updateTaskBarInset(this.mView, insets, this.mInsetsController.getState());
        this.mAttachInfo.delayNotifyContentCaptureInsetsEvent(insets.getInsets(WindowInsets.Type.all()));
        Trace.traceEnd(8L);
    }

    private boolean updateCaptionInsets() {
        if (CAPTION_ON_SHELL) {
            return false;
        }
        View view = this.mView;
        if (!(view instanceof DecorView)) {
            return false;
        }
        int captionInsetsHeight = ((DecorView) view).getCaptionInsetsHeight();
        Rect captionFrame = new Rect();
        if (captionInsetsHeight != 0) {
            captionFrame.set(this.mWinFrame.left, this.mWinFrame.top, this.mWinFrame.right, this.mWinFrame.top + captionInsetsHeight);
        }
        if (this.mAttachInfo.mCaptionInsets.equals(captionFrame)) {
            return false;
        }
        this.mAttachInfo.mCaptionInsets.set(captionFrame);
        return true;
    }

    private boolean shouldDispatchCutout() {
        return this.mWindowAttributes.layoutInDisplayCutoutMode == 3 || this.mWindowAttributes.layoutInDisplayCutoutMode == 1;
    }

    public InsetsController getInsetsController() {
        return this.mInsetsController;
    }

    private static boolean shouldUseDisplaySize(WindowManager.LayoutParams lp) {
        return lp.type == 2041 || lp.type == 2011 || lp.type == 2020;
    }

    private static boolean shouldOptimizeMeasure(WindowManager.LayoutParams lp) {
        return (lp.privateFlags & 512) != 0;
    }

    private Rect getWindowBoundsInsetSystemBars() {
        Rect bounds = new Rect(this.mContext.getResources().getConfiguration().windowConfiguration.getBounds());
        bounds.inset(this.mInsetsController.getState().calculateInsets(bounds, WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout(), false));
        this.mViewRootImplExt.intersectOverrideWindowBoundsIfNeed(this.mLastReportedMergedConfiguration, bounds);
        return bounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dipToPx(int dip) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return (int) ((displayMetrics.density * dip) + 0.5f);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(113:24|(1:877)(1:32)|33|(4:35|(1:37)(1:875)|(1:39)(1:874)|(106:41|42|(3:44|(1:46)(1:872)|47)(1:873)|48|(6:50|(1:52)(2:858|(1:863)(1:862))|53|(1:55)|56|(1:58))(2:864|(3:868|(1:870)|871))|(3:60|(2:(1:63)(1:65)|64)|(1:69))|70|(1:72)|73|(1:75)|76|(1:857)(1:82)|83|(3:85|(1:855)(2:91|(1:93)(1:854))|94)(1:856)|95|(1:97)(1:853)|98|(1:100)|101|(2:836|(6:838|(3:840|(2:842|843)(1:845)|844)|846|(1:848)|849|(85:851|107|(2:109|(1:111)(1:834))(1:835)|(1:113)|(1:833)(79:116|(1:832)(4:120|(2:122|(1:124))(1:831)|824|(2:826|(1:828)))|126|127|(1:823)(1:131)|132|(1:822)(1:136)|137|(1:139)(1:821)|140|(1:142)(1:820)|(4:144|(1:148)|149|(1:151))(1:819)|152|(1:818)(2:157|(1:159)(45:817|286|(1:288)|289|(1:522)(4:293|294|(1:296)|298)|(1:519)|(1:518)(1:310)|311|(1:517)(1:315)|316|(4:318|(4:320|(1:322)|323|(2:325|(1:327)))(1:515)|328|(1:330))(1:516)|331|(1:333)(1:(1:511)(2:(1:513)|514))|(1:335)|(1:337)|338|(3:340|(3:504|(1:506)(1:508)|507)(1:344)|345)(1:509)|346|(1:503)(1:350)|351|(7:353|(4:355|(1:357)|358|(1:360))(1:491)|(1:362)(1:490)|(1:364)|(1:366)(1:(1:489))|367|368)(2:492|(3:496|497|498))|369|(1:481)(7:371|(3:474|(1:478)|389)|376|(1:378)|379|(2:381|(2:383|(1:385))(2:386|(1:388)))|389)|(2:471|(18:473|(1:396)|397|(1:470)(1:400)|401|(1:403)|(1:469)(1:406)|407|(1:468)(1:412)|413|(4:415|(1:417)(1:423)|418|(1:422))|(4:425|(4:429|(2:432|430)|433|434)|435|(1:437))(1:(2:(1:450)(1:452)|451)(4:453|(4:457|(2:460|458)|461|462)|463|(1:467)))|438|(1:440)|441|(2:443|(1:445))|446|447))(1:393)|394|(0)|397|(0)|470|401|(0)|(0)|469|407|(1:410)|468|413|(0)|(0)(0)|438|(0)|441|(0)|446|447))|160|(3:162|(1:164)(1:815)|165)(1:816)|166|(1:168)|169|170|171|(9:173|174|175|176|177|178|179|180|181)(1:809)|183|184|(46:188|189|190|(1:192)(1:782)|193|194|195|196|197|198|199|200|201|(5:761|762|(1:764)|765|(1:767))|203|(1:205)(1:760)|206|207|(4:735|736|(1:740)|(1:754)(4:749|750|751|752))(1:209)|210|211|(1:213)|214|(6:218|(1:220)|221|(1:223)(1:587)|224|225)|588|(4:590|591|592|593)(1:730)|594|(1:596)(1:725)|597|(1:724)(1:601)|602|(1:723)(1:606)|607|(1:722)(1:610)|611|(1:613)|(1:615)|616|(1:618)|(1:719)|(2:625|(10:651|652|653|654|655|656|657|658|(1:664)|666)(1:627))(2:685|(8:687|(1:689)|690|(1:692)|693|(1:695)|696|(1:698))(1:(3:708|709|710)))|628|(1:650)(1:(5:631|(1:648)(1:635)|636|(1:638)(1:647)|639)(1:649))|640|(1:(1:643)(1:644))|645)|788|789|790|791|189|190|(0)(0)|193|194|195|196|197|198|199|200|201|(0)|203|(0)(0)|206|207|(0)(0)|210|211|(0)|214|(7:216|218|(0)|221|(0)(0)|224|225)|588|(0)(0)|594|(0)(0)|597|(1:599)|724|602|(1:604)|723|607|(0)|720|722|611|(0)|(0)|616|(0)|(1:620)|719|(0)(0)|628|(0)(0)|640|(0)|645)|830|127|(1:129)|823|132|(1:134)|822|137|(0)(0)|140|(0)(0)|(0)(0)|152|(0)|818|160|(0)(0)|166|(0)|169|170|171|(0)(0)|183|184|(51:188|189|190|(0)(0)|193|194|195|196|197|198|199|200|201|(0)|203|(0)(0)|206|207|(0)(0)|210|211|(0)|214|(0)|588|(0)(0)|594|(0)(0)|597|(0)|724|602|(0)|723|607|(0)|720|722|611|(0)|(0)|616|(0)|(0)|719|(0)(0)|628|(0)(0)|640|(0)|645)|788|789|790|791|189|190|(0)(0)|193|194|195|196|197|198|199|200|201|(0)|203|(0)(0)|206|207|(0)(0)|210|211|(0)|214|(0)|588|(0)(0)|594|(0)(0)|597|(0)|724|602|(0)|723|607|(0)|720|722|611|(0)|(0)|616|(0)|(0)|719|(0)(0)|628|(0)(0)|640|(0)|645))(1:852))(1:105)|106|107|(0)(0)|(0)|(0)|833|830|127|(0)|823|132|(0)|822|137|(0)(0)|140|(0)(0)|(0)(0)|152|(0)|818|160|(0)(0)|166|(0)|169|170|171|(0)(0)|183|184|(0)|788|789|790|791|189|190|(0)(0)|193|194|195|196|197|198|199|200|201|(0)|203|(0)(0)|206|207|(0)(0)|210|211|(0)|214|(0)|588|(0)(0)|594|(0)(0)|597|(0)|724|602|(0)|723|607|(0)|720|722|611|(0)|(0)|616|(0)|(0)|719|(0)(0)|628|(0)(0)|640|(0)|645))|876|42|(0)(0)|48|(0)(0)|(0)|70|(0)|73|(0)|76|(2:78|80)|857|83|(0)(0)|95|(0)(0)|98|(0)|101|(1:103)|836|(0)(0)|106|107|(0)(0)|(0)|(0)|833|830|127|(0)|823|132|(0)|822|137|(0)(0)|140|(0)(0)|(0)(0)|152|(0)|818|160|(0)(0)|166|(0)|169|170|171|(0)(0)|183|184|(0)|788|789|790|791|189|190|(0)(0)|193|194|195|196|197|198|199|200|201|(0)|203|(0)(0)|206|207|(0)(0)|210|211|(0)|214|(0)|588|(0)(0)|594|(0)(0)|597|(0)|724|602|(0)|723|607|(0)|720|722|611|(0)|(0)|616|(0)|(0)|719|(0)(0)|628|(0)(0)|640|(0)|645) */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0344, code lost:
    
        if (r29.width() != r57.mWidth) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x08ca, code lost:
    
        if (android.os.Trace.isTagEnabled(r3) == false) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x08cc, code lost:
    
        android.os.Trace.traceEnd(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x08cf, code lost:
    
        r3 = r26;
        r4 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x08d5, code lost:
    
        if (android.view.ViewRootImpl.DEBUG_ORIENTATION == false) goto L500;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x08d7, code lost:
    
        android.util.Log.v(android.view.ViewRootImpl.TAG, "Relayout returned: frame=" + ((java.lang.Object) r7) + ", surface=" + ((java.lang.Object) r57.mSurface));
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x08fb, code lost:
    
        r57.mAttachInfo.mWindowLeft = r7.left;
        r57.mAttachInfo.mWindowTop = r7.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x090d, code lost:
    
        if (r57.mWidth != r7.width()) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0915, code lost:
    
        if (r57.mHeight == r7.height()) goto L505;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0925, code lost:
    
        if (r57.mSurfaceHolder == null) goto L543;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x092d, code lost:
    
        if (r57.mSurface.isValid() == false) goto L510;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x092f, code lost:
    
        r57.mSurfaceHolder.mSurface = r57.mSurface;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0935, code lost:
    
        r57.mSurfaceHolder.setSurfaceFrameSize(r57.mWidth, r57.mHeight);
        r0 = r57.mSurfaceHolder;
        r0 = r0.mSurfaceLock;
        r0.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0945, code lost:
    
        if (r32 == false) goto L519;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0947, code lost:
    
        r57.mSurfaceHolder.ungetCallbacks();
        r57.mIsCreating = true;
        r0 = r57.mSurfaceHolder.getCallbacks();
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0955, code lost:
    
        if (r0 == null) goto L518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0957, code lost:
    
        r9 = r0.length;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0959, code lost:
    
        if (r10 >= r9) goto L895;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x095b, code lost:
    
        r12 = r0[r10];
        r12.surfaceCreated(r57.mSurfaceHolder);
        r10 = r10 + 1;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x096e, code lost:
    
        if (r32 != false) goto L525;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0970, code lost:
    
        if (r35 != false) goto L525;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0972, code lost:
    
        if (r28 != false) goto L525;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0974, code lost:
    
        if (r5 == false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x09c5, code lost:
    
        if (r33 == false) goto L544;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x09c7, code lost:
    
        notifyHolderSurfaceDestroyed();
        r57.mSurfaceHolder.mSurfaceLock.lock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x09d1, code lost:
    
        r57.mSurfaceHolder.mSurface = new android.view.Surface();
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x09e2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x09e3, code lost:
    
        r57.mSurfaceHolder.mSurfaceLock.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x09ea, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x09ef, code lost:
    
        r0 = r57.mAttachInfo.mThreadedRenderer;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x09f3, code lost:
    
        if (r0 == null) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x09f9, code lost:
    
        if (r0.isEnabled() == false) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x09fb, code lost:
    
        if (r36 != false) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0a03, code lost:
    
        if (r57.mWidth != r0.getWidth()) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0a0b, code lost:
    
        if (r57.mHeight != r0.getHeight()) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0a0f, code lost:
    
        if (r57.mNeedsRendererSetup == false) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0a11, code lost:
    
        r0.setup(r57.mWidth, r57.mHeight, r57.mAttachInfo, r57.mWindowAttributes.surfaceInsets);
        r57.mNeedsRendererSetup = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0a23, code lost:
    
        if (r57.mStopped == false) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0a27, code lost:
    
        if (r57.mReportNextDraw == false) goto L567;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0a3e, code lost:
    
        r13 = r40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0c92, code lost:
    
        r6 = r24;
        r15 = r31;
        r36 = r45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:524:0x0a2f, code lost:
    
        if (r57.mWidth != r11.getMeasuredWidth()) goto L568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x0a37, code lost:
    
        if (r57.mHeight != r11.getMeasuredHeight()) goto L568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:527:0x0a39, code lost:
    
        if (r4 != false) goto L568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:528:0x0a3b, code lost:
    
        if (r3 == false) goto L567;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0a48, code lost:
    
        r9 = getRootMeasureSpec(r57.mWidth, r1.width, r1.privateFlags);
        r10 = getRootMeasureSpec(r57.mHeight, r1.height, r1.privateFlags);
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x0a5e, code lost:
    
        if (android.view.ViewRootImpl.DEBUG_LAYOUT == false) goto L571;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0a60, code lost:
    
        android.util.Log.v(r57.mTag, "Ooops, something changed!  mWidth=" + r57.mWidth + " measuredWidth=" + r11.getMeasuredWidth() + " mHeight=" + r57.mHeight + " measuredHeight=" + r11.getMeasuredHeight() + " dispatchApplyInsets=" + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0aac, code lost:
    
        r12 = new java.lang.StringBuilder().append("Measure reason mFirst ").append(r57.mFirst).append(" windowShouldResize ").append(r2).append(" viewVisibilityChanged ").append(r14).append(" params != null ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:533:0x0ad7, code lost:
    
        if (r6 == null) goto L574;
     */
    /* JADX WARN: Code restructure failed: missing block: B:534:0x0ad9, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0adc, code lost:
    
        r12 = r12.append(r13).append(" mForceNextWindowRelayout ").append(r57.mForceNextWindowRelayout).append(" mStopped ").append(r57.mStopped).append(" mReportNextDraw ").append(r57.mReportNextDraw).append(" mWidth ").append(r57.mWidth).append(" host.getMeasuredWidth ").append(r11.getMeasuredWidth()).append(" mHeight ").append(r57.mHeight).append(" host.getMeasuredHeight ").append(r11.getMeasuredHeight()).append(" dispatchApplyInsets ").append(r4).append(" updateConfiguration ").append(r3).toString();
        r57.mViewRootImplExt.markPerformMeasureReason(r12);
        r13 = android.view.View.MeasureSpec.getSize(r10);
        r15 = android.view.View.MeasureSpec.getSize(r9);
        r22 = android.view.ViewRootImpl.PANIC_DEBUG;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x0b63, code lost:
    
        if (r22 == false) goto L582;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x0b65, code lost:
    
        if (r13 > 10000) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0b67, code lost:
    
        if (r15 <= 10000) goto L580;
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0b9b, code lost:
    
        performMeasure(r9, r10);
        r0 = r11.getMeasuredWidth();
        r2 = r11.getMeasuredHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x0baf, code lost:
    
        if (r1.horizontalWeight <= 0.0f) goto L586;
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:0x0bb1, code lost:
    
        r0 = r0 + ((int) ((r57.mWidth - r0) * r1.horizontalWeight));
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x0bcc, code lost:
    
        if (r1.verticalWeight <= 0.0f) goto L590;
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x0bce, code lost:
    
        r2 = r2 + ((int) ((r57.mHeight - r2) * r1.verticalWeight));
        r10 = android.view.View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x0be3, code lost:
    
        if (r3 == false) goto L606;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0be7, code lost:
    
        if (android.view.ViewRootImpl.DEBUG_LAYOUT == false) goto L595;
     */
    /* JADX WARN: Code restructure failed: missing block: B:549:0x0be9, code lost:
    
        android.util.Log.v(r57.mTag, "And hey let's measure once more: width=" + r0 + " height=" + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0c14, code lost:
    
        r57.mMeasureReason = "3";
        r3 = "Measure again lp.horizontalWeight " + r1.horizontalWeight + " lp.verticalWeight " + r1.verticalWeight;
        r57.mViewRootImplExt.markPerformMeasureReason(r3);
        r4 = android.view.View.MeasureSpec.getSize(r10);
        r6 = android.view.View.MeasureSpec.getSize(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:551:0x0c46, code lost:
    
        if (r22 == false) goto L604;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x0c4c, code lost:
    
        if (r4 > 10000) goto L603;
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x0c4e, code lost:
    
        if (r6 <= 10000) goto L602;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x0c84, code lost:
    
        performMeasure(r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:557:0x0c90, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:558:0x0c56, code lost:
    
        android.util.Log.d(r57.mTag, "measureAgain performMeasure heightAgain = " + r4 + ",widthAgain = " + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0bc4, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x0b6f, code lost:
    
        android.util.Log.d(r57.mTag, "performMeasure heightMesure = " + r13 + ",widthMesure = " + r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x0adb, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:568:0x0982, code lost:
    
        if (r57.mSurface.isValid() == false) goto L535;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x0984, code lost:
    
        r0 = r57.mSurfaceHolder.getCallbacks();
     */
    /* JADX WARN: Code restructure failed: missing block: B:570:0x098a, code lost:
    
        if (r0 == null) goto L533;
     */
    /* JADX WARN: Code restructure failed: missing block: B:571:0x098c, code lost:
    
        r9 = r0.length;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:572:0x098e, code lost:
    
        if (r10 >= r9) goto L898;
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x0990, code lost:
    
        r12 = r0[r10];
        r12.surfaceChanged(r57.mSurfaceHolder, r1.format, r57.mWidth, r57.mHeight);
        r10 = r10 + 1;
        r0 = r0;
        r9 = r9;
        r13 = r13;
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x09bd, code lost:
    
        r57.mIsCreating = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x0917, code lost:
    
        r57.mWidth = r7.width();
        r57.mHeight = r7.height();
     */
    /* JADX WARN: Code restructure failed: missing block: B:646:0x0821, code lost:
    
        if (android.os.Trace.isTagEnabled(8) == false) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:732:0x0833, code lost:
    
        r31 = r9;
        r3 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:733:0x082d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:769:0x0841, code lost:
    
        r24 = r4;
        r31 = r9;
        r3 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:770:0x0839, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:774:0x0853, code lost:
    
        r46 = r3;
        r24 = r4;
        r31 = r9;
        r3 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:775:0x0849, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:779:0x0868, code lost:
    
        r46 = r3;
        r24 = r4;
        r31 = r9;
        r45 = r4;
        r3 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:780:0x085d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:785:0x087d, code lost:
    
        r46 = r3;
        r45 = r4;
        r24 = r37;
        r3 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:786:0x0874, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:794:0x0891, code lost:
    
        r46 = r3;
        r14 = r9;
        r11 = r10;
        r45 = r4;
        r24 = r37;
        r3 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:795:0x0886, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:812:0x08b6, code lost:
    
        r46 = r3;
        r43 = r4;
        r44 = "======================================";
        r45 = r4;
        r42 = false;
        r3 = 8;
        r14 = r9;
        r11 = r10;
        r24 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:813:0x089c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:829:0x035a, code lost:
    
        if (r29.height() != r57.mHeight) goto L175;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x031d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x051a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05cb A[Catch: all -> 0x05f5, RemoteException -> 0x05fa, TRY_ENTER, TRY_LEAVE, TryCatch #31 {RemoteException -> 0x05fa, all -> 0x05f5, blocks: (B:752:0x05aa, B:213:0x05cb, B:216:0x0605, B:218:0x060f, B:220:0x0613, B:221:0x0631, B:224:0x063f), top: B:751:0x05aa }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0605 A[Catch: all -> 0x05f5, RemoteException -> 0x05fa, TRY_ENTER, TryCatch #31 {RemoteException -> 0x05fa, all -> 0x05f5, blocks: (B:752:0x05aa, B:213:0x05cb, B:216:0x0605, B:218:0x060f, B:220:0x0613, B:221:0x0631, B:224:0x063f), top: B:751:0x05aa }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0613 A[Catch: all -> 0x05f5, RemoteException -> 0x05fa, TryCatch #31 {RemoteException -> 0x05fa, all -> 0x05f5, blocks: (B:752:0x05aa, B:213:0x05cb, B:216:0x0605, B:218:0x060f, B:220:0x0613, B:221:0x0631, B:224:0x063f), top: B:751:0x05aa }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0fbe  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0fe8  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x101d  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x1044  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x10ea  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x10f4  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x1077  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x08b1  */
    /* JADX WARN: Removed duplicated region for block: B:587:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:590:0x0658 A[Catch: all -> 0x082d, RemoteException -> 0x0832, TRY_LEAVE, TryCatch #35 {RemoteException -> 0x0832, all -> 0x082d, blocks: (B:211:0x05c7, B:214:0x0601, B:588:0x0646, B:590:0x0658), top: B:210:0x05c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0681 A[Catch: all -> 0x0825, RemoteException -> 0x0828, TryCatch #37 {RemoteException -> 0x0828, all -> 0x0825, blocks: (B:593:0x0662, B:594:0x066c, B:597:0x0677, B:599:0x0681, B:604:0x0690, B:607:0x069b, B:613:0x06b6, B:615:0x06be, B:616:0x06c7, B:620:0x06d2, B:622:0x06da, B:625:0x06ec, B:652:0x06fa, B:628:0x07bf, B:631:0x07c5, B:633:0x07d3, B:636:0x07e4, B:639:0x07eb, B:640:0x0803, B:643:0x0809, B:644:0x0816, B:649:0x07fb, B:687:0x0758, B:689:0x075c, B:690:0x075f, B:692:0x076a, B:693:0x0770, B:695:0x0774, B:696:0x0777, B:698:0x077d, B:702:0x078b, B:704:0x078f, B:706:0x0795, B:708:0x079d, B:710:0x07a0, B:713:0x07ab, B:719:0x06de, B:720:0x06a7), top: B:592:0x0662, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0690 A[Catch: all -> 0x0825, RemoteException -> 0x0828, TryCatch #37 {RemoteException -> 0x0828, all -> 0x0825, blocks: (B:593:0x0662, B:594:0x066c, B:597:0x0677, B:599:0x0681, B:604:0x0690, B:607:0x069b, B:613:0x06b6, B:615:0x06be, B:616:0x06c7, B:620:0x06d2, B:622:0x06da, B:625:0x06ec, B:652:0x06fa, B:628:0x07bf, B:631:0x07c5, B:633:0x07d3, B:636:0x07e4, B:639:0x07eb, B:640:0x0803, B:643:0x0809, B:644:0x0816, B:649:0x07fb, B:687:0x0758, B:689:0x075c, B:690:0x075f, B:692:0x076a, B:693:0x0770, B:695:0x0774, B:696:0x0777, B:698:0x077d, B:702:0x078b, B:704:0x078f, B:706:0x0795, B:708:0x079d, B:710:0x07a0, B:713:0x07ab, B:719:0x06de, B:720:0x06a7), top: B:592:0x0662, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:609:0x06a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x06b6 A[Catch: all -> 0x0825, RemoteException -> 0x0828, TryCatch #37 {RemoteException -> 0x0828, all -> 0x0825, blocks: (B:593:0x0662, B:594:0x066c, B:597:0x0677, B:599:0x0681, B:604:0x0690, B:607:0x069b, B:613:0x06b6, B:615:0x06be, B:616:0x06c7, B:620:0x06d2, B:622:0x06da, B:625:0x06ec, B:652:0x06fa, B:628:0x07bf, B:631:0x07c5, B:633:0x07d3, B:636:0x07e4, B:639:0x07eb, B:640:0x0803, B:643:0x0809, B:644:0x0816, B:649:0x07fb, B:687:0x0758, B:689:0x075c, B:690:0x075f, B:692:0x076a, B:693:0x0770, B:695:0x0774, B:696:0x0777, B:698:0x077d, B:702:0x078b, B:704:0x078f, B:706:0x0795, B:708:0x079d, B:710:0x07a0, B:713:0x07ab, B:719:0x06de, B:720:0x06a7), top: B:592:0x0662, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:615:0x06be A[Catch: all -> 0x0825, RemoteException -> 0x0828, TryCatch #37 {RemoteException -> 0x0828, all -> 0x0825, blocks: (B:593:0x0662, B:594:0x066c, B:597:0x0677, B:599:0x0681, B:604:0x0690, B:607:0x069b, B:613:0x06b6, B:615:0x06be, B:616:0x06c7, B:620:0x06d2, B:622:0x06da, B:625:0x06ec, B:652:0x06fa, B:628:0x07bf, B:631:0x07c5, B:633:0x07d3, B:636:0x07e4, B:639:0x07eb, B:640:0x0803, B:643:0x0809, B:644:0x0816, B:649:0x07fb, B:687:0x0758, B:689:0x075c, B:690:0x075f, B:692:0x076a, B:693:0x0770, B:695:0x0774, B:696:0x0777, B:698:0x077d, B:702:0x078b, B:704:0x078f, B:706:0x0795, B:708:0x079d, B:710:0x07a0, B:713:0x07ab, B:719:0x06de, B:720:0x06a7), top: B:592:0x0662, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:618:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x06d2 A[Catch: all -> 0x0825, RemoteException -> 0x0828, TryCatch #37 {RemoteException -> 0x0828, all -> 0x0825, blocks: (B:593:0x0662, B:594:0x066c, B:597:0x0677, B:599:0x0681, B:604:0x0690, B:607:0x069b, B:613:0x06b6, B:615:0x06be, B:616:0x06c7, B:620:0x06d2, B:622:0x06da, B:625:0x06ec, B:652:0x06fa, B:628:0x07bf, B:631:0x07c5, B:633:0x07d3, B:636:0x07e4, B:639:0x07eb, B:640:0x0803, B:643:0x0809, B:644:0x0816, B:649:0x07fb, B:687:0x0758, B:689:0x075c, B:690:0x075f, B:692:0x076a, B:693:0x0770, B:695:0x0774, B:696:0x0777, B:698:0x077d, B:702:0x078b, B:704:0x078f, B:706:0x0795, B:708:0x079d, B:710:0x07a0, B:713:0x07ab, B:719:0x06de, B:720:0x06a7), top: B:592:0x0662, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:625:0x06ec A[Catch: all -> 0x0825, RemoteException -> 0x0828, TRY_LEAVE, TryCatch #37 {RemoteException -> 0x0828, all -> 0x0825, blocks: (B:593:0x0662, B:594:0x066c, B:597:0x0677, B:599:0x0681, B:604:0x0690, B:607:0x069b, B:613:0x06b6, B:615:0x06be, B:616:0x06c7, B:620:0x06d2, B:622:0x06da, B:625:0x06ec, B:652:0x06fa, B:628:0x07bf, B:631:0x07c5, B:633:0x07d3, B:636:0x07e4, B:639:0x07eb, B:640:0x0803, B:643:0x0809, B:644:0x0816, B:649:0x07fb, B:687:0x0758, B:689:0x075c, B:690:0x075f, B:692:0x076a, B:693:0x0770, B:695:0x0774, B:696:0x0777, B:698:0x077d, B:702:0x078b, B:704:0x078f, B:706:0x0795, B:708:0x079d, B:710:0x07a0, B:713:0x07ab, B:719:0x06de, B:720:0x06a7), top: B:592:0x0662, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:630:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:642:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:650:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:685:0x0754  */
    /* JADX WARN: Removed duplicated region for block: B:725:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:730:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:735:0x058a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:760:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:761:0x054e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:782:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:809:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:816:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:819:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:820:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:821:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:835:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:838:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:852:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:853:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:856:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:864:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:873:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0283  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void performTraversals() {
        /*
            Method dump skipped, instructions count: 4390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.performTraversals():void");
    }

    private void createSyncIfNeeded() {
        if (isInWMSRequestedSync() || !this.mReportNextDraw) {
            return;
        }
        this.mViewRootImplExt.hookCreateSyncIfNeeded(this.mTag, this.mSyncBuffer, this.mSyncSeqId);
        final int seqId = this.mSyncSeqId;
        this.mWmsRequestSyncGroupState = 1;
        this.mWmsRequestSyncGroup = new SurfaceSyncGroup("wmsSync-" + this.mTag, new Consumer() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda14
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ViewRootImpl.this.lambda$createSyncIfNeeded$3(seqId, (SurfaceControl.Transaction) obj);
            }
        });
        if (DEBUG_BLAST) {
            Log.d(this.mTag, "Setup new sync=" + this.mWmsRequestSyncGroup.getName());
        }
        this.mWmsRequestSyncGroup.add(this, (Runnable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createSyncIfNeeded$3(int seqId, SurfaceControl.Transaction t2) {
        Log.d(this.mTag, "draw finished.");
        this.mWmsRequestSyncGroupState = 3;
        reportDrawFinished(t2, seqId);
    }

    private void notifyContentCaptureEvents() {
        Trace.traceBegin(8L, "notifyContentCaptureEvents");
        try {
            MainContentCaptureSession mainSession = this.mAttachInfo.mContentCaptureManager.getMainContentCaptureSession();
            for (int i10 = 0; i10 < this.mAttachInfo.mContentCaptureEvents.size(); i10++) {
                int sessionId = this.mAttachInfo.mContentCaptureEvents.keyAt(i10);
                mainSession.notifyViewTreeEvent(sessionId, true);
                ArrayList<Object> events = this.mAttachInfo.mContentCaptureEvents.valueAt(i10);
                for (int j10 = 0; j10 < events.size(); j10++) {
                    Object event = events.get(j10);
                    if (event instanceof AutofillId) {
                        mainSession.notifyViewDisappeared(sessionId, (AutofillId) event);
                    } else if (event instanceof View) {
                        View view = (View) event;
                        ContentCaptureSession session = view.getContentCaptureSession();
                        if (session == null) {
                            Log.w(this.mTag, "no content capture session on view: " + ((Object) view));
                        } else {
                            int actualId = session.getId();
                            if (actualId != sessionId) {
                                Log.w(this.mTag, "content capture session mismatch for view (" + ((Object) view) + "): was " + sessionId + " before, it's " + actualId + " now");
                            } else {
                                ViewStructure structure = session.newViewStructure(view);
                                view.onProvideContentCaptureStructure(structure, 0);
                                session.notifyViewAppeared(structure);
                            }
                        }
                    } else if (event instanceof Insets) {
                        mainSession.notifyViewInsetsChanged(sessionId, (Insets) event);
                    } else {
                        Log.w(this.mTag, "invalid content capture event: " + event);
                    }
                }
                mainSession.notifyViewTreeEvent(sessionId, false);
            }
            this.mAttachInfo.mContentCaptureEvents = null;
        } finally {
            Trace.traceEnd(8L);
        }
    }

    private void notifyHolderSurfaceDestroyed() {
        this.mSurfaceHolder.ungetCallbacks();
        SurfaceHolder.Callback[] callbacks = this.mSurfaceHolder.getCallbacks();
        if (callbacks != null) {
            for (SurfaceHolder.Callback c4 : callbacks) {
                c4.surfaceDestroyed(this.mSurfaceHolder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeHandleWindowMove(Rect frame) {
        boolean windowMoved = (this.mAttachInfo.mWindowLeft == frame.left && this.mAttachInfo.mWindowTop == frame.top) ? false : true;
        if (windowMoved) {
            this.mAttachInfo.mWindowLeft = frame.left;
            this.mAttachInfo.mWindowTop = frame.top;
        }
        if (windowMoved || this.mAttachInfo.mNeedsUpdateLightCenter) {
            if (this.mAttachInfo.mThreadedRenderer != null) {
                this.mAttachInfo.mThreadedRenderer.setLightCenter(this.mAttachInfo);
            }
            this.mAttachInfo.mNeedsUpdateLightCenter = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWindowFocusChanged() {
        this.mViewRootImplExt.markHandleWindowFocusChange(this.mWindowFocusChanged, this.mUpcomingWindowFocus, this.mAdded, this.mWindowAttributes);
        synchronized (this) {
            if (this.mWindowFocusChanged) {
                this.mWindowFocusChanged = false;
                boolean hasWindowFocus = this.mUpcomingWindowFocus;
                this.mViewRootImplExt.handleWindowFocusChanged(this.mContext, hasWindowFocus);
                if (hasWindowFocus) {
                    this.mInsetsController.onWindowFocusGained(getFocusedViewOrNull() != null);
                } else {
                    this.mInsetsController.onWindowFocusLost();
                }
                if (this.mAdded) {
                    dispatchFocusEvent(hasWindowFocus, false);
                    this.mImeFocusController.onPostWindowFocus(getFocusedViewOrNull(), hasWindowFocus, this.mWindowAttributes);
                    if (hasWindowFocus) {
                        this.mWindowAttributes.softInputMode &= -257;
                        ((WindowManager.LayoutParams) this.mView.getLayoutParams()).softInputMode &= -257;
                        maybeFireAccessibilityWindowStateChangedEvent();
                        fireAccessibilityFocusEventIfHasFocusedNode();
                    } else if (this.mPointerCapture) {
                        handlePointerCaptureChanged(false);
                    }
                }
                this.mFirstInputStage.onWindowFocusChanged(hasWindowFocus);
                if (hasWindowFocus) {
                    handleContentCaptureFlush();
                }
            }
        }
    }

    public void dispatchCompatFakeFocus() {
        boolean aboutToHaveFocus;
        synchronized (this) {
            aboutToHaveFocus = this.mWindowFocusChanged && this.mUpcomingWindowFocus;
        }
        boolean alreadyHaveFocus = this.mAttachInfo.mHasWindowFocus;
        if (aboutToHaveFocus || alreadyHaveFocus) {
            return;
        }
        EventLog.writeEvent(LOGTAG_INPUT_FOCUS, "Giving fake focus to " + this.mBasePackageName, "reason=unity bug workaround");
        dispatchFocusEvent(true, true);
        EventLog.writeEvent(LOGTAG_INPUT_FOCUS, "Removing fake focus from " + this.mBasePackageName, "reason=timeout callback");
        dispatchFocusEvent(false, true);
    }

    private void dispatchFocusEvent(boolean hasWindowFocus, boolean fakeFocus) {
        profileRendering(hasWindowFocus);
        if (hasWindowFocus && this.mAttachInfo.mThreadedRenderer != null && this.mSurface.isValid()) {
            this.mFullRedrawNeeded = true;
            try {
                Rect surfaceInsets = this.mWindowAttributes.surfaceInsets;
                this.mAttachInfo.mThreadedRenderer.initializeIfNeeded(this.mWidth, this.mHeight, this.mAttachInfo, this.mSurface, surfaceInsets);
            } catch (Surface.OutOfResourcesException e2) {
                Log.e(this.mTag, "OutOfResourcesException locking surface", e2);
                try {
                    if (!this.mWindowSession.outOfMemory(this.mWindow)) {
                        Slog.w(this.mTag, "No processes killed for memory; killing self");
                        Process.killProcess(Process.myPid());
                    }
                } catch (RemoteException e10) {
                }
                ViewRootHandler viewRootHandler = this.mHandler;
                viewRootHandler.sendMessageDelayed(viewRootHandler.obtainMessage(6), 500L);
                this.mViewRootImplExt.markAndDumpWindowFocusChangeMsg(this.mTag, this.mHandler);
                return;
            }
        }
        this.mAttachInfo.mHasWindowFocus = hasWindowFocus;
        if (!fakeFocus) {
            this.mImeFocusController.onPreWindowFocus(hasWindowFocus, this.mWindowAttributes);
        }
        if (this.mView != null) {
            this.mAttachInfo.mKeyDispatchState.reset();
            this.mView.dispatchWindowFocusChanged(hasWindowFocus);
            this.mAttachInfo.mTreeObserver.dispatchOnWindowFocusChange(hasWindowFocus);
            if (this.mAttachInfo.mTooltipHost != null) {
                this.mAttachInfo.mTooltipHost.hideTooltip();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWindowTouchModeChanged() {
        boolean inTouchMode;
        synchronized (this) {
            inTouchMode = this.mUpcomingInTouchMode;
        }
        ensureTouchModeLocally(inTouchMode);
    }

    private void maybeFireAccessibilityWindowStateChangedEvent() {
        View view;
        WindowManager.LayoutParams layoutParams = this.mWindowAttributes;
        boolean isToast = layoutParams != null && layoutParams.type == 2005;
        if (!isToast && (view = this.mView) != null) {
            view.sendAccessibilityEvent(32);
        }
    }

    private void fireAccessibilityFocusEventIfHasFocusedNode() {
        View focusedView;
        if (!AccessibilityManager.getInstance(this.mContext).isEnabled() || (focusedView = this.mView.findFocus()) == null) {
            return;
        }
        AccessibilityNodeProvider provider = focusedView.getAccessibilityNodeProvider();
        if (provider == null) {
            focusedView.sendAccessibilityEvent(8);
            return;
        }
        AccessibilityNodeInfo focusedNode = findFocusedVirtualNode(provider);
        if (focusedNode != null) {
            int virtualId = AccessibilityNodeInfo.getVirtualDescendantId(focusedNode.getSourceNodeId());
            AccessibilityEvent event = AccessibilityEvent.obtain(8);
            event.setSource(focusedView, virtualId);
            event.setPackageName(focusedNode.getPackageName());
            event.setChecked(focusedNode.isChecked());
            event.setContentDescription(focusedNode.getContentDescription());
            event.setPassword(focusedNode.isPassword());
            event.getText().add(focusedNode.getText());
            event.setEnabled(focusedNode.isEnabled());
            focusedView.getParent().requestSendAccessibilityEvent(focusedView, event);
            focusedNode.recycle();
        }
    }

    private AccessibilityNodeInfo findFocusedVirtualNode(AccessibilityNodeProvider provider) {
        AccessibilityNodeInfo focusedNode = provider.findFocus(1);
        if (focusedNode != null) {
            return focusedNode;
        }
        if (!this.mContext.isAutofillCompatibilityEnabled()) {
            return null;
        }
        AccessibilityNodeInfo current = provider.createAccessibilityNodeInfo(-1);
        if (current.isFocused()) {
            return current;
        }
        Queue<AccessibilityNodeInfo> fringe = new ArrayDeque<>();
        fringe.offer(current);
        while (!fringe.isEmpty()) {
            AccessibilityNodeInfo current2 = fringe.poll();
            LongArray childNodeIds = current2.getChildNodeIds();
            if (childNodeIds != null && childNodeIds.size() > 0) {
                int childCount = childNodeIds.size();
                for (int i10 = 0; i10 < childCount; i10++) {
                    int virtualId = AccessibilityNodeInfo.getVirtualDescendantId(childNodeIds.get(i10));
                    AccessibilityNodeInfo child = provider.createAccessibilityNodeInfo(virtualId);
                    if (child != null) {
                        if (child.isFocused()) {
                            return child;
                        }
                        fringe.offer(child);
                    }
                }
                current2.recycle();
            }
        }
        return null;
    }

    private void handleOutOfResourcesException(Surface.OutOfResourcesException e2) {
        Log.e(this.mTag, "OutOfResourcesException initializing HW surface", e2);
        try {
            if (!this.mWindowSession.outOfMemory(this.mWindow) && Process.myUid() != 1000) {
                Slog.w(this.mTag, "No processes killed for memory; killing self");
                Process.killProcess(Process.myPid());
            }
        } catch (RemoteException e10) {
        }
        this.mLayoutRequested = true;
    }

    private void performMeasure(int childWidthMeasureSpec, int childHeightMeasureSpec) {
        if (this.mView == null) {
            return;
        }
        int height = View.MeasureSpec.getSize(childHeightMeasureSpec);
        int width = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (PANIC_DEBUG && (height > 10000 || width > 10000)) {
            Log.d(TAG, "height = " + height + ",width = " + width);
        }
        Trace.traceBegin(8L, "measure");
        long measureStartTime = System.nanoTime();
        try {
            this.mView.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            this.mChoreographer.mChoreographerExt.populateMeasureCost(System.nanoTime() - measureStartTime, this.mView, this.mMeasureReason);
            ((IOplusJankMonitorExt) ExtLoader.type(IOplusJankMonitorExt.class).create()).setLaunchStageTime(this.mBasePackageName, "performMeasure", measureStartTime);
            Trace.traceEnd(8L);
            this.mMeasuredWidth = this.mView.getMeasuredWidth();
            this.mMeasuredHeight = this.mView.getMeasuredHeight();
            this.mViewMeasureDeferred = false;
        } catch (Throwable th) {
            this.mChoreographer.mChoreographerExt.populateMeasureCost(System.nanoTime() - measureStartTime, this.mView, this.mMeasureReason);
            ((IOplusJankMonitorExt) ExtLoader.type(IOplusJankMonitorExt.class).create()).setLaunchStageTime(this.mBasePackageName, "performMeasure", measureStartTime);
            Trace.traceEnd(8L);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInLayout() {
        return this.mInLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean requestLayoutDuringLayout(View view) {
        if (view.mParent == null || view.mAttachInfo == null) {
            return true;
        }
        if (!this.mLayoutRequesters.contains(view)) {
            this.mLayoutRequesters.add(view);
        }
        return !this.mHandlingLayoutInLayoutRequest;
    }

    private void performLayout(WindowManager.LayoutParams lp, int desiredWindowWidth, int desiredWindowHeight) {
        ArrayList<View> validLayoutRequesters;
        this.mScrollMayChange = true;
        this.mInLayout = true;
        View host = this.mView;
        if (host == null) {
            return;
        }
        if (DEBUG_ORIENTATION || DEBUG_LAYOUT) {
            Log.v(this.mTag, "Laying out " + ((Object) host) + " to (" + host.getMeasuredWidth() + ", " + host.getMeasuredHeight() + ")");
        }
        Trace.traceBegin(8L, "layout");
        long layoutStartTime = System.nanoTime();
        try {
            host.layout(0, 0, host.getMeasuredWidth(), host.getMeasuredHeight());
            this.mInLayout = false;
            int numViewsRequestingLayout = this.mLayoutRequesters.size();
            if (numViewsRequestingLayout > 0 && (validLayoutRequesters = getValidLayoutRequesters(this.mLayoutRequesters, false)) != null) {
                this.mHandlingLayoutInLayoutRequest = true;
                int numValidRequests = validLayoutRequesters.size();
                for (int i10 = 0; i10 < numValidRequests; i10++) {
                    View view = validLayoutRequesters.get(i10);
                    if (DEBUG_LAYOUT) {
                        Log.w("View", "requestLayout() improperly called by " + ((Object) view) + " during layout: running second layout pass");
                    }
                    view.requestLayout();
                }
                measureHierarchy(host, lp, this.mView.getContext().getResources(), desiredWindowWidth, desiredWindowHeight, false);
                this.mInLayout = true;
                host.layout(0, 0, host.getMeasuredWidth(), host.getMeasuredHeight());
                this.mHandlingLayoutInLayoutRequest = false;
                final ArrayList<View> validLayoutRequesters2 = getValidLayoutRequesters(this.mLayoutRequesters, true);
                if (validLayoutRequesters2 != null) {
                    getRunQueue().post(new Runnable() { // from class: android.view.ViewRootImpl.4
                        @Override // java.lang.Runnable
                        public void run() {
                            int numValidRequests2 = validLayoutRequesters2.size();
                            for (int i11 = 0; i11 < numValidRequests2; i11++) {
                                View view2 = (View) validLayoutRequesters2.get(i11);
                                if (ViewRootImpl.DEBUG_LAYOUT) {
                                    Log.w("View", "requestLayout() improperly called by " + ((Object) view2) + " during second layout pass: posting in next frame");
                                }
                                view2.requestLayout();
                            }
                        }
                    });
                }
            }
            this.mChoreographer.mChoreographerExt.populateLayoutCost(System.nanoTime() - layoutStartTime, host);
            Trace.traceEnd(8L);
            this.mViewRootImplExt.postShowGuidePopupRunnable(this.mView);
            this.mInLayout = false;
        } catch (Throwable th) {
            this.mChoreographer.mChoreographerExt.populateLayoutCost(System.nanoTime() - layoutStartTime, host);
            Trace.traceEnd(8L);
            throw th;
        }
    }

    private ArrayList<View> getValidLayoutRequesters(ArrayList<View> layoutRequesters, boolean secondLayoutRequests) {
        int numViewsRequestingLayout = layoutRequesters.size();
        ArrayList<View> validLayoutRequesters = null;
        for (int i10 = 0; i10 < numViewsRequestingLayout; i10++) {
            View view = layoutRequesters.get(i10);
            if (view != null && view.mAttachInfo != null && view.mParent != null && (secondLayoutRequests || (view.mPrivateFlags & 4096) == 4096)) {
                boolean gone = false;
                View parent = view;
                while (true) {
                    if (parent == null) {
                        break;
                    }
                    if ((parent.mViewFlags & 12) == 8) {
                        gone = true;
                        break;
                    }
                    if (parent.mParent instanceof View) {
                        parent = (View) parent.mParent;
                    } else {
                        parent = null;
                    }
                }
                if (!gone) {
                    if (validLayoutRequesters == null) {
                        validLayoutRequesters = new ArrayList<>();
                    }
                    validLayoutRequesters.add(view);
                }
            }
        }
        if (!secondLayoutRequests) {
            for (int i11 = 0; i11 < numViewsRequestingLayout; i11++) {
                View view2 = layoutRequesters.get(i11);
                while (view2 != null && (view2.mPrivateFlags & 4096) != 0) {
                    view2.mPrivateFlags &= -4097;
                    if (view2.mParent instanceof View) {
                        view2 = (View) view2.mParent;
                    } else {
                        view2 = null;
                    }
                }
            }
        }
        layoutRequesters.clear();
        return validLayoutRequesters;
    }

    @Override // android.view.ViewParent
    public void requestTransparentRegion(View child) {
        checkThread();
        View view = this.mView;
        if (view != child) {
            return;
        }
        if ((view.mPrivateFlags & 512) == 0) {
            this.mView.mPrivateFlags |= 512;
            this.mWindowAttributesChanged = true;
        }
        requestLayout();
    }

    private static int getRootMeasureSpec(int windowSize, int measurement, int privateFlags) {
        int rootDimension = (privateFlags & 4096) != 0 ? -1 : measurement;
        switch (rootDimension) {
            case -2:
                int measureSpec = View.MeasureSpec.makeMeasureSpec(windowSize, Integer.MIN_VALUE);
                return measureSpec;
            case -1:
                int measureSpec2 = View.MeasureSpec.makeMeasureSpec(windowSize, 1073741824);
                return measureSpec2;
            default:
                int measureSpec3 = View.MeasureSpec.makeMeasureSpec(rootDimension, 1073741824);
                return measureSpec3;
        }
    }

    @Override // android.view.ThreadedRenderer.DrawCallbacks
    public void onPreDraw(RecordingCanvas canvas) {
        if (this.mCurScrollY != 0 && this.mHardwareYOffset != 0 && this.mAttachInfo.mThreadedRenderer.isOpaque()) {
            canvas.drawColor(-16777216);
        }
        canvas.translate(-this.mHardwareXOffset, -this.mHardwareYOffset);
    }

    @Override // android.view.ThreadedRenderer.DrawCallbacks
    public void onPostDraw(RecordingCanvas canvas) {
        drawAccessibilityFocusedDrawableIfNeeded(canvas);
        if (this.mUseMTRenderer) {
            for (int i10 = this.mWindowCallbacks.size() - 1; i10 >= 0; i10--) {
                this.mWindowCallbacks.get(i10).onPostDraw(canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void outputDisplayList(View view) {
        view.mRenderNode.output();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void profileRendering(boolean enabled) {
        if (this.mProfileRendering) {
            this.mRenderProfilingEnabled = enabled;
            Choreographer.FrameCallback frameCallback = this.mRenderProfiler;
            if (frameCallback != null) {
                this.mChoreographer.removeFrameCallback(frameCallback);
            }
            if (this.mRenderProfilingEnabled) {
                if (this.mRenderProfiler == null) {
                    this.mRenderProfiler = new Choreographer.FrameCallback() { // from class: android.view.ViewRootImpl.5
                        @Override // android.view.Choreographer.FrameCallback
                        public void doFrame(long frameTimeNanos) {
                            ViewRootImpl.this.mDirty.set(0, 0, ViewRootImpl.this.mWidth, ViewRootImpl.this.mHeight);
                            ViewRootImpl.this.scheduleTraversals();
                            if (ViewRootImpl.this.mRenderProfilingEnabled) {
                                ViewRootImpl.this.mChoreographer.postFrameCallback(ViewRootImpl.this.mRenderProfiler);
                            }
                        }
                    };
                }
                this.mChoreographer.postFrameCallback(this.mRenderProfiler);
                return;
            }
            this.mRenderProfiler = null;
        }
    }

    private void trackFPS() {
        long nowTime = System.currentTimeMillis();
        if (this.mFpsStartTime < 0) {
            this.mFpsPrevTime = nowTime;
            this.mFpsStartTime = nowTime;
            this.mFpsNumFrames = 0;
            return;
        }
        this.mFpsNumFrames++;
        String thisHash = Integer.toHexString(System.identityHashCode(this));
        long frameTime = nowTime - this.mFpsPrevTime;
        long totalTime = nowTime - this.mFpsStartTime;
        Log.v(this.mTag, "0x" + thisHash + "\tFrame time:\t" + frameTime);
        this.mFpsPrevTime = nowTime;
        if (totalTime > 1000) {
            float fps = (this.mFpsNumFrames * 1000.0f) / ((float) totalTime);
            Log.v(this.mTag, "0x" + thisHash + "\tFPS:\t" + fps);
            this.mFpsStartTime = nowTime;
            this.mFpsNumFrames = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0062, code lost:
    
        r5.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        if (r5 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x004e, code lost:
    
        if (r5 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0065, code lost:
    
        r4.mViewRootImplExt.hookSetBinderUxFlag(false, r4.mWindowAttributes);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x006d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void reportDrawFinished(android.view.SurfaceControl.Transaction r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = r4.mTag
            java.lang.String r1 = "reportDrawFinished"
            android.util.Log.d(r0, r1)
            r0 = 8
            boolean r2 = android.os.Trace.isTagEnabled(r0)
            if (r2 == 0) goto L33
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "reportDrawFinished "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r4.mTag
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " seqId="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.os.Trace.instant(r0, r2)
        L33:
            android.view.IViewRootImplExt r0 = r4.mViewRootImplExt     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            java.lang.String r1 = r4.mTag     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            r0.hookReportDrawFinished(r1, r6)     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            android.view.IViewRootImplExt r0 = r4.mViewRootImplExt     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            android.view.WindowManager$LayoutParams r1 = r4.mWindowAttributes     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            r2 = 1
            r0.hookSetBinderUxFlag(r2, r1)     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            android.view.IWindowSession r0 = r4.mWindowSession     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            android.view.ViewRootImpl$W r1 = r4.mWindow     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            r0.finishDrawing(r1, r5, r6)     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            android.view.IViewRootImplSocExt r0 = r4.mViewRootImplSocExt     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            r0.hookFinishDrawingPerfHint()     // Catch: java.lang.Throwable -> L51 android.os.RemoteException -> L53
            if (r5 == 0) goto L65
            goto L62
        L51:
            r0 = move-exception
            goto L6e
        L53:
            r0 = move-exception
            java.lang.String r1 = r4.mTag     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "Unable to report draw finished"
            android.util.Log.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r5 == 0) goto L60
            r5.apply()     // Catch: java.lang.Throwable -> L51
        L60:
            if (r5 == 0) goto L65
        L62:
            r5.clear()
        L65:
            android.view.IViewRootImplExt r0 = r4.mViewRootImplExt
            r1 = 0
            android.view.WindowManager$LayoutParams r2 = r4.mWindowAttributes
            r0.hookSetBinderUxFlag(r1, r2)
            return
        L6e:
            if (r5 == 0) goto L73
            r5.clear()
        L73:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.reportDrawFinished(android.view.SurfaceControl$Transaction, int):void");
    }

    public boolean isHardwareEnabled() {
        return this.mAttachInfo.mThreadedRenderer != null && this.mAttachInfo.mThreadedRenderer.isEnabled();
    }

    public boolean isInWMSRequestedSync() {
        return this.mWmsRequestSyncGroup != null;
    }

    private void addFrameCommitCallbackIfNeeded() {
        if (!isHardwareEnabled()) {
            return;
        }
        final ArrayList<Runnable> commitCallbacks = this.mAttachInfo.mTreeObserver.captureFrameCommitCallbacks();
        boolean needFrameCommitCallback = commitCallbacks != null && commitCallbacks.size() > 0;
        if (!needFrameCommitCallback) {
            return;
        }
        if (DEBUG_DRAW) {
            Log.d(this.mTag, "Creating frameCommitCallback commitCallbacks size=" + commitCallbacks.size());
        }
        this.mAttachInfo.mThreadedRenderer.setFrameCommitCallback(new HardwareRenderer.FrameCommitCallback() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda12
            public final void onFrameCommit(boolean z10) {
                ViewRootImpl.this.lambda$addFrameCommitCallbackIfNeeded$5(commitCallbacks, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFrameCommitCallbackIfNeeded$5(final ArrayList commitCallbacks, boolean didProduceBuffer) {
        if (DEBUG_DRAW) {
            Log.d(this.mTag, "Received frameCommitCallback didProduceBuffer=" + didProduceBuffer);
        }
        this.mHandler.postAtFrontOfQueue(new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ViewRootImpl.lambda$addFrameCommitCallbackIfNeeded$4(ArrayList.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$addFrameCommitCallbackIfNeeded$4(ArrayList commitCallbacks) {
        for (int i10 = 0; i10 < commitCallbacks.size(); i10++) {
            ((Runnable) commitCallbacks.get(i10)).run();
        }
    }

    private void registerCallbackForPendingTransactions() {
        SurfaceControl.Transaction t2 = new SurfaceControl.Transaction();
        t2.merge(this.mPendingTransaction);
        registerRtFrameCallback(new AnonymousClass6(t2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: android.view.ViewRootImpl$6, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AnonymousClass6 implements HardwareRenderer.FrameDrawingCallback {
        final /* synthetic */ SurfaceControl.Transaction val$t;

        AnonymousClass6(SurfaceControl.Transaction transaction) {
            this.val$t = transaction;
        }

        public HardwareRenderer.FrameCommitCallback onFrameDraw(int syncResult, final long frame) {
            ViewRootImpl.this.mergeWithNextTransaction(this.val$t, frame);
            if ((syncResult & 6) != 0) {
                ViewRootImpl.this.mBlastBufferQueue.applyPendingTransactions(frame);
                return null;
            }
            return new HardwareRenderer.FrameCommitCallback() { // from class: android.view.ViewRootImpl$6$$ExternalSyntheticLambda0
                public final void onFrameCommit(boolean z10) {
                    ViewRootImpl.AnonymousClass6.this.lambda$onFrameDraw$0(frame, z10);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFrameDraw$0(long frame, boolean didProduceBuffer) {
            if (!didProduceBuffer) {
                ViewRootImpl.this.mBlastBufferQueue.applyPendingTransactions(frame);
            }
        }

        public void onFrameDraw(long frame) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x010c A[Catch: all -> 0x00fa, TRY_LEAVE, TryCatch #1 {all -> 0x00fa, blocks: (B:99:0x00f4, B:46:0x00fe, B:49:0x0106, B:51:0x010c), top: B:98:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean performDraw() {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.performDraw():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performDraw$7(final SurfaceSyncGroup surfaceSyncGroup) {
        this.mHandler.post(new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceSyncGroup.this.markSyncReady();
            }
        });
    }

    private boolean isContentCaptureEnabled() {
        switch (this.mContentCaptureEnabled) {
            case 0:
                boolean reallyEnabled = isContentCaptureReallyEnabled();
                this.mContentCaptureEnabled = reallyEnabled ? 1 : 2;
                return reallyEnabled;
            case 1:
                return true;
            case 2:
                return false;
            default:
                Log.w(TAG, "isContentCaptureEnabled(): invalid state " + this.mContentCaptureEnabled);
                return false;
        }
    }

    private boolean isContentCaptureReallyEnabled() {
        ContentCaptureManager ccm;
        return (this.mContext.getContentCaptureOptions() == null || (ccm = this.mAttachInfo.getContentCaptureManager(this.mContext)) == null || !ccm.isContentCaptureEnabled()) ? false : true;
    }

    private void performContentCaptureInitialReport() {
        this.mPerformContentCapture = false;
        View rootView = this.mView;
        if (DEBUG_CONTENT_CAPTURE) {
            Log.v(this.mTag, "performContentCaptureInitialReport() on " + ((Object) rootView));
        }
        if (Trace.isTagEnabled(8L)) {
            Trace.traceBegin(8L, "dispatchContentCapture() for " + getClass().getSimpleName());
        }
        try {
            if (!isContentCaptureEnabled()) {
                return;
            }
            if (this.mAttachInfo.mContentCaptureManager != null) {
                MainContentCaptureSession session = this.mAttachInfo.mContentCaptureManager.getMainContentCaptureSession();
                session.notifyWindowBoundsChanged(session.getId(), getConfiguration().windowConfiguration.getBounds());
            }
            rootView.dispatchInitialProvideContentCaptureStructure();
        } finally {
            Trace.traceEnd(8L);
        }
    }

    private void handleContentCaptureFlush() {
        if (DEBUG_CONTENT_CAPTURE) {
            Log.v(this.mTag, "handleContentCaptureFlush()");
        }
        if (Trace.isTagEnabled(8L)) {
            Trace.traceBegin(8L, "flushContentCapture for " + getClass().getSimpleName());
        }
        try {
            if (isContentCaptureEnabled()) {
                ContentCaptureManager ccm = this.mAttachInfo.mContentCaptureManager;
                if (ccm == null) {
                    Log.w(TAG, "No ContentCapture on AttachInfo");
                } else {
                    ccm.flush(2);
                }
            }
        } finally {
            Trace.traceEnd(8L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean draw(boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.draw(boolean, boolean):boolean");
    }

    private boolean drawSoftware(Surface surface, View.AttachInfo attachInfo, int xoff, int yoff, boolean scalingRequired, Rect dirty, Rect surfaceInsets) {
        try {
            Canvas canvas = this.mSurface.lockCanvas(dirty);
            canvas.setDensity(this.mDensity);
            try {
                try {
                    if (DEBUG_ORIENTATION || DEBUG_DRAW) {
                        Log.v(this.mTag, "Surface " + ((Object) surface) + " drawing to bitmap w=" + canvas.getWidth() + ", h=" + canvas.getHeight() + ", dirty: " + ((Object) dirty) + ", xOff=" + xoff + ", yOff=" + yoff);
                    }
                    if (!canvas.isOpaque() || yoff != 0 || xoff != 0) {
                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    dirty.setEmpty();
                    this.mIsAnimating = false;
                    this.mView.mPrivateFlags |= 32;
                    if (DEBUG_DRAW) {
                        Context cxt = this.mView.getContext();
                        Log.i(this.mTag, "Drawing: package:" + cxt.getPackageName() + ", metrics=" + ((Object) cxt.getResources().getDisplayMetrics()) + ", compatibilityInfo=" + ((Object) cxt.getResources().getCompatibilityInfo()));
                    }
                    canvas.translate(-xoff, -yoff);
                    CompatibilityInfo.Translator translator = this.mTranslator;
                    if (translator != null) {
                        translator.translateCanvas(canvas);
                    }
                    canvas.setScreenDensity(scalingRequired ? this.mNoncompatDensity : 0);
                    this.mView.draw(canvas);
                    drawAccessibilityFocusedDrawableIfNeeded(canvas);
                    return true;
                } finally {
                    surface.unlockCanvasAndPost(canvas);
                    if (LOCAL_LOGV) {
                        Log.v(this.mTag, "Surface " + ((Object) surface) + " unlockCanvasAndPost");
                    }
                }
            } catch (IllegalArgumentException e2) {
                Log.e(this.mTag, "Could not unlock surface", e2);
                this.mLayoutRequested = true;
                return false;
            }
        } catch (Surface.OutOfResourcesException e10) {
            handleOutOfResourcesException(e10);
            return false;
        } catch (IllegalArgumentException e11) {
            Log.e(this.mTag, "Could not lock surface", e11);
            this.mLayoutRequested = true;
            return false;
        }
    }

    private void drawAccessibilityFocusedDrawableIfNeeded(Canvas canvas) {
        Rect bounds = this.mAttachInfo.mTmpInvalRect;
        if (getAccessibilityFocusedRect(bounds)) {
            Drawable drawable = getAccessibilityFocusedDrawable();
            if (drawable != null) {
                drawable.setBounds(bounds);
                drawable.draw(canvas);
                return;
            }
            return;
        }
        if (this.mAttachInfo.mAccessibilityFocusDrawable != null) {
            this.mAttachInfo.mAccessibilityFocusDrawable.setBounds(0, 0, 0, 0);
        }
    }

    private boolean getAccessibilityFocusedRect(Rect bounds) {
        View host;
        AccessibilityManager manager = AccessibilityManager.getInstance(this.mView.mContext);
        if (!manager.isEnabled() || !manager.isTouchExplorationEnabled() || (host = this.mAccessibilityFocusedHost) == null || host.mAttachInfo == null) {
            return false;
        }
        AccessibilityNodeProvider provider = host.getAccessibilityNodeProvider();
        if (provider == null) {
            host.getBoundsOnScreen(bounds, true);
        } else {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mAccessibilityFocusedVirtualView;
            if (accessibilityNodeInfo == null) {
                return false;
            }
            accessibilityNodeInfo.getBoundsInScreen(bounds);
        }
        View.AttachInfo attachInfo = this.mAttachInfo;
        bounds.offset(0, attachInfo.mViewRootImpl.mScrollY);
        bounds.offset(-attachInfo.mWindowLeft, -attachInfo.mWindowTop);
        if (!bounds.intersect(0, 0, attachInfo.mViewRootImpl.mWidth, attachInfo.mViewRootImpl.mHeight)) {
            bounds.setEmpty();
        }
        return !bounds.isEmpty();
    }

    private Drawable getAccessibilityFocusedDrawable() {
        if (this.mAttachInfo.mAccessibilityFocusDrawable == null) {
            TypedValue value = new TypedValue();
            boolean resolved = this.mView.mContext.getTheme().resolveAttribute(17956871, value, true);
            if (resolved) {
                this.mAttachInfo.mAccessibilityFocusDrawable = this.mView.mContext.getDrawable(value.resourceId);
            }
        }
        if (this.mAttachInfo.mAccessibilityFocusDrawable instanceof GradientDrawable) {
            GradientDrawable drawable = (GradientDrawable) this.mAttachInfo.mAccessibilityFocusDrawable;
            drawable.setStroke(this.mAccessibilityManager.getAccessibilityFocusStrokeWidth(), this.mAccessibilityManager.getAccessibilityFocusColor());
        }
        return this.mAttachInfo.mAccessibilityFocusDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateSystemGestureExclusionRectsForView(View view) {
        this.mGestureExclusionTracker.updateRectsForView(view);
        this.mHandler.sendEmptyMessage(30);
    }

    void systemGestureExclusionChanged() {
        List<Rect> rectsForWindowManager = this.mGestureExclusionTracker.computeChangedRects();
        if (rectsForWindowManager != null && this.mView != null) {
            try {
                this.mWindowSession.reportSystemGestureExclusionChanged(this.mWindow, rectsForWindowManager);
                this.mAttachInfo.mTreeObserver.dispatchOnSystemGestureExclusionRectsChanged(rectsForWindowManager);
                this.mViewRootImplExt.setSystemGestureExclusionRegion(rectsForWindowManager);
            } catch (RemoteException e2) {
                throw e2.rethrowFromSystemServer();
            }
        }
    }

    public void setRootSystemGestureExclusionRects(List<Rect> rects) {
        this.mGestureExclusionTracker.setRootRects(rects);
        this.mHandler.sendEmptyMessage(30);
    }

    public List<Rect> getRootSystemGestureExclusionRects() {
        return this.mGestureExclusionTracker.getRootRects();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateKeepClearRectsForView(View view) {
        this.mKeepClearRectsTracker.updateRectsForView(view);
        this.mUnrestrictedKeepClearRectsTracker.updateRectsForView(view);
        this.mHandler.sendEmptyMessage(35);
    }

    private void updateKeepClearForAccessibilityFocusRect() {
        if (this.mViewConfiguration.isPreferKeepClearForFocusEnabled()) {
            if (this.mKeepClearAccessibilityFocusRect == null) {
                this.mKeepClearAccessibilityFocusRect = new Rect();
            }
            boolean hasAccessibilityFocus = getAccessibilityFocusedRect(this.mKeepClearAccessibilityFocusRect);
            if (!hasAccessibilityFocus) {
                this.mKeepClearAccessibilityFocusRect.setEmpty();
            }
            this.mHandler.obtainMessage(35, 1, 0).sendToTarget();
        }
    }

    void keepClearRectsChanged(boolean accessibilityFocusRectChanged) {
        boolean restrictedKeepClearRectsChanged = this.mKeepClearRectsTracker.computeChanges();
        boolean unrestrictedKeepClearRectsChanged = this.mUnrestrictedKeepClearRectsTracker.computeChanges();
        if ((restrictedKeepClearRectsChanged || unrestrictedKeepClearRectsChanged || accessibilityFocusRectChanged) && this.mView != null) {
            this.mHasPendingKeepClearAreaChange = true;
            if (!this.mHandler.hasMessages(36)) {
                this.mHandler.sendEmptyMessageDelayed(36, 100L);
                reportKeepClearAreasChanged();
            }
        }
    }

    void reportKeepClearAreasChanged() {
        if (!this.mHasPendingKeepClearAreaChange || this.mView == null) {
            return;
        }
        this.mHasPendingKeepClearAreaChange = false;
        List<Rect> restrictedKeepClearRects = this.mKeepClearRectsTracker.getLastComputedRects();
        List<Rect> unrestrictedKeepClearRects = this.mUnrestrictedKeepClearRectsTracker.getLastComputedRects();
        Rect rect = this.mKeepClearAccessibilityFocusRect;
        if (rect != null && !rect.isEmpty()) {
            restrictedKeepClearRects = new ArrayList(restrictedKeepClearRects);
            restrictedKeepClearRects.add(this.mKeepClearAccessibilityFocusRect);
        }
        try {
            this.mWindowSession.reportKeepClearAreasChanged(this.mWindow, restrictedKeepClearRects, unrestrictedKeepClearRects);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void requestInvalidateRootRenderNode() {
        this.mInvalidateRootRequested = true;
    }

    boolean scrollToRectOrFocus(Rect rectangle, boolean immediate) {
        int scrollY;
        Rect ci = this.mAttachInfo.mContentInsets;
        Rect vi = this.mAttachInfo.mVisibleInsets;
        int scrollY2 = 0;
        boolean handled = false;
        if (vi.left > ci.left || vi.top > ci.top || vi.right > ci.right || vi.bottom > ci.bottom) {
            scrollY2 = this.mScrollY;
            View focus = this.mView.findFocus();
            if (focus == null) {
                return false;
            }
            WeakReference<View> weakReference = this.mLastScrolledFocus;
            View lastScrolledFocus = weakReference != null ? weakReference.get() : null;
            if (focus != lastScrolledFocus) {
                rectangle = null;
            }
            if (DEBUG_INPUT_RESIZE) {
                Log.v(this.mTag, "Eval scroll: focus=" + ((Object) focus) + " rectangle=" + ((Object) rectangle) + " ci=" + ((Object) ci) + " vi=" + ((Object) vi));
            }
            if (focus == lastScrolledFocus && !this.mScrollMayChange && rectangle == null) {
                if (DEBUG_INPUT_RESIZE) {
                    Log.v(this.mTag, "Keeping scroll y=" + this.mScrollY + " vi=" + vi.toShortString());
                }
            } else {
                this.mLastScrolledFocus = new WeakReference<>(focus);
                this.mScrollMayChange = false;
                if (DEBUG_INPUT_RESIZE) {
                    Log.v(this.mTag, "Need to scroll?");
                }
                if (focus.getGlobalVisibleRect(this.mVisRect, null)) {
                    if (DEBUG_INPUT_RESIZE) {
                        Log.v(this.mTag, "Root w=" + this.mView.getWidth() + " h=" + this.mView.getHeight() + " ci=" + ci.toShortString() + " vi=" + vi.toShortString());
                    }
                    if (rectangle == null) {
                        focus.getFocusedRect(this.mTempRect);
                        if (DEBUG_INPUT_RESIZE) {
                            Log.v(this.mTag, "Focus " + ((Object) focus) + ": focusRect=" + this.mTempRect.toShortString());
                        }
                        View view = this.mView;
                        if (view instanceof ViewGroup) {
                            ((ViewGroup) view).offsetDescendantRectToMyCoords(focus, this.mTempRect);
                        }
                        if (DEBUG_INPUT_RESIZE) {
                            Log.v(this.mTag, "Focus in window: focusRect=" + this.mTempRect.toShortString() + " visRect=" + this.mVisRect.toShortString());
                        }
                    } else {
                        this.mTempRect.set(rectangle);
                        if (DEBUG_INPUT_RESIZE) {
                            Log.v(this.mTag, "Request scroll to rect: " + this.mTempRect.toShortString() + " visRect=" + this.mVisRect.toShortString());
                        }
                    }
                    if (this.mTempRect.intersect(this.mVisRect)) {
                        if (DEBUG_INPUT_RESIZE) {
                            Log.v(this.mTag, "Focus window visible rect: " + this.mTempRect.toShortString());
                        }
                        if (this.mTempRect.height() > (this.mView.getHeight() - vi.top) - vi.bottom) {
                            if (DEBUG_INPUT_RESIZE) {
                                Log.v(this.mTag, "Too tall; leaving scrollY=" + scrollY2);
                            }
                        } else {
                            if (this.mTempRect.top < vi.top) {
                                scrollY = this.mTempRect.top - vi.top;
                                if (DEBUG_INPUT_RESIZE) {
                                    Log.v(this.mTag, "Top covered; scrollY=" + scrollY);
                                }
                            } else if (this.mTempRect.bottom > this.mView.getHeight() - vi.bottom) {
                                scrollY = this.mTempRect.bottom - (this.mView.getHeight() - vi.bottom);
                                if (DEBUG_INPUT_RESIZE) {
                                    Log.v(this.mTag, "Bottom covered; scrollY=" + scrollY);
                                }
                            } else {
                                scrollY2 = 0;
                            }
                            scrollY2 = scrollY;
                        }
                        handled = true;
                    }
                }
            }
        }
        if (scrollY2 != this.mScrollY) {
            if (DEBUG_INPUT_RESIZE) {
                Log.v(this.mTag, "Pan scroll changed: old=" + this.mScrollY + " , new=" + scrollY2);
            }
            if (!immediate) {
                if (this.mScroller == null) {
                    this.mScroller = new Scroller(this.mView.getContext());
                }
                Scroller scroller = this.mScroller;
                int i10 = this.mScrollY;
                scroller.startScroll(0, i10, 0, scrollY2 - i10);
            } else {
                Scroller scroller2 = this.mScroller;
                if (scroller2 != null) {
                    scroller2.abortAnimation();
                }
            }
            this.mScrollY = scrollY2;
        }
        return handled;
    }

    public View getAccessibilityFocusedHost() {
        return this.mAccessibilityFocusedHost;
    }

    public AccessibilityNodeInfo getAccessibilityFocusedVirtualView() {
        return this.mAccessibilityFocusedVirtualView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAccessibilityFocus(View view, AccessibilityNodeInfo node) {
        if (this.mAccessibilityFocusedVirtualView != null) {
            AccessibilityNodeInfo focusNode = this.mAccessibilityFocusedVirtualView;
            View focusHost = this.mAccessibilityFocusedHost;
            this.mAccessibilityFocusedHost = null;
            this.mAccessibilityFocusedVirtualView = null;
            focusHost.clearAccessibilityFocusNoCallbacks(64);
            AccessibilityNodeProvider provider = focusHost.getAccessibilityNodeProvider();
            if (provider != null) {
                focusNode.getBoundsInParent(this.mTempRect);
                focusHost.invalidate(this.mTempRect);
                int virtualNodeId = AccessibilityNodeInfo.getVirtualDescendantId(focusNode.getSourceNodeId());
                provider.performAction(virtualNodeId, 128, null);
            }
            focusNode.recycle();
        }
        View view2 = this.mAccessibilityFocusedHost;
        if (view2 != null && view2 != view) {
            view2.clearAccessibilityFocusNoCallbacks(64);
        }
        this.mAccessibilityFocusedHost = view;
        this.mAccessibilityFocusedVirtualView = node;
        updateKeepClearForAccessibilityFocusRect();
        if (this.mAttachInfo.mThreadedRenderer != null) {
            this.mAttachInfo.mThreadedRenderer.invalidateRoot();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasPointerCapture() {
        return this.mPointerCapture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestPointerCapture(boolean enabled) {
        IBinder inputToken = getInputToken();
        if (inputToken == null) {
            Log.e(this.mTag, "No input channel to request Pointer Capture.");
        } else {
            InputManagerGlobal.getInstance().requestPointerCapture(inputToken, enabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePointerCaptureChanged(boolean hasCapture) {
        if (this.mPointerCapture == hasCapture) {
            return;
        }
        this.mPointerCapture = hasCapture;
        View view = this.mView;
        if (view != null) {
            view.dispatchPointerCaptureChanged(hasCapture);
        }
    }

    private void updateRenderHdrSdrRatio() {
        this.mRenderHdrSdrRatio = Math.min(this.mDesiredHdrSdrRatio, this.mDisplay.getHdrSdrRatio());
        this.mUpdateHdrSdrRatioInfo = true;
    }

    private void updateColorModeIfNeeded(int colorMode) {
        if (this.mAttachInfo.mThreadedRenderer == null) {
            return;
        }
        if ((colorMode == 2 || colorMode == 3) && !this.mDisplay.isHdrSdrRatioAvailable()) {
            colorMode = 1;
        }
        if (colorMode != 4 && !getConfiguration().isScreenWideColorGamut()) {
            colorMode = 0;
        }
        float desiredRatio = this.mAttachInfo.mThreadedRenderer.setColorMode(this.mViewRootImplExt.getColorMode(colorMode));
        if (desiredRatio != this.mDesiredHdrSdrRatio) {
            this.mDesiredHdrSdrRatio = desiredRatio;
            updateRenderHdrSdrRatio();
            if (this.mDesiredHdrSdrRatio < 1.01f) {
                this.mDisplay.unregisterHdrSdrRatioChangedListener(this.mHdrSdrRatioChangedListener);
                this.mHdrSdrRatioChangedListener = null;
            } else {
                Consumer<Display> consumer = new Consumer() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda19
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ViewRootImpl.this.lambda$updateColorModeIfNeeded$8((Display) obj);
                    }
                };
                this.mHdrSdrRatioChangedListener = consumer;
                this.mDisplay.registerHdrSdrRatioChangedListener(this.mExecutor, consumer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateColorModeIfNeeded$8(Display display) {
        updateRenderHdrSdrRatio();
        invalidate();
    }

    @Override // android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        if (DEBUG_INPUT_RESIZE) {
            Log.v(this.mTag, "Request child focus: focus now " + ((Object) focused));
        }
        checkThread();
        scheduleTraversals();
    }

    @Override // android.view.ViewParent
    public void clearChildFocus(View child) {
        if (DEBUG_INPUT_RESIZE) {
            Log.v(this.mTag, "Clearing child focus");
        }
        checkThread();
        scheduleTraversals();
    }

    @Override // android.view.ViewParent
    public ViewParent getParentForAccessibility() {
        return null;
    }

    @Override // android.view.ViewParent
    public void focusableViewAvailable(View v2) {
        checkThread();
        View view = this.mView;
        if (view != null) {
            if (!view.hasFocus()) {
                if (sAlwaysAssignFocus || !this.mAttachInfo.mInTouchMode) {
                    v2.requestFocus();
                    return;
                }
                return;
            }
            View focused = this.mView.findFocus();
            if (focused instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) focused;
                if (group.getDescendantFocusability() == 262144 && isViewDescendantOf(v2, focused)) {
                    v2.requestFocus();
                }
            }
        }
    }

    @Override // android.view.ViewParent
    public void recomputeViewAttributes(View child) {
        checkThread();
        if (this.mView == child) {
            this.mAttachInfo.mRecomputeGlobalAttributes = true;
            if (!this.mWillDrawSoon) {
                scheduleTraversals();
            }
        }
    }

    void dispatchDetachedFromWindow() {
        InputQueue inputQueue;
        this.mInsetsController.onWindowFocusLost();
        InputStage inputStage = this.mFirstInputStage;
        if (inputStage != null) {
            inputStage.onDetachedFromWindow();
        }
        View view = this.mView;
        if (view != null && view.mAttachInfo != null) {
            this.mAttachInfo.mTreeObserver.dispatchOnWindowAttachedChange(false);
            this.mView.dispatchDetachedFromWindow();
            this.mViewRootImplExt.dispatchDetachedFromWindow(this.mView);
        }
        this.mAccessibilityInteractionConnectionManager.ensureNoConnection();
        this.mAccessibilityInteractionConnectionManager.ensureNoDirectConnection();
        removeSendWindowContentChangedCallback();
        destroyHardwareRenderer();
        setAccessibilityFocus(null, null);
        this.mInsetsController.cancelExistingAnimations();
        this.mView.assignParent(null);
        this.mView = null;
        this.mAttachInfo.mRootView = null;
        destroySurface();
        InputQueue.Callback callback = this.mInputQueueCallback;
        if (callback != null && (inputQueue = this.mInputQueue) != null) {
            callback.onInputQueueDestroyed(inputQueue);
            this.mInputQueue.dispose();
            this.mInputQueueCallback = null;
            this.mInputQueue = null;
        }
        try {
            this.mWindowSession.remove(this.mWindow);
        } catch (RemoteException e2) {
        }
        WindowInputEventReceiver windowInputEventReceiver = this.mInputEventReceiver;
        if (windowInputEventReceiver != null) {
            windowInputEventReceiver.dispose();
            this.mInputEventReceiver = null;
        }
        unregisterListeners();
        unscheduleTraversals();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performConfigurationChange(MergedConfiguration mergedConfiguration, boolean force, int newDisplayId) {
        if (mergedConfiguration == null) {
            throw new IllegalArgumentException("No merged config provided.");
        }
        int lastRotation = this.mLastReportedMergedConfiguration.getMergedConfiguration().windowConfiguration.getRotation();
        int newRotation = mergedConfiguration.getMergedConfiguration().windowConfiguration.getRotation();
        if (lastRotation != newRotation) {
            this.mUpdateSurfaceNeeded = true;
            if (!this.mIsInTraversal) {
                this.mForceNextWindowRelayout = true;
            }
        }
        Configuration globalConfig = mergedConfiguration.getGlobalConfiguration();
        Configuration overrideConfig = mergedConfiguration.getOverrideConfiguration();
        if (DEBUG_CONFIGURATION) {
            Log.v(this.mTag, "Applying new config to window " + ((Object) this.mWindowAttributes.getTitle()) + ", globalConfig: " + ((Object) globalConfig) + ", overrideConfig: " + ((Object) overrideConfig));
        }
        CompatibilityInfo ci = this.mDisplay.getDisplayAdjustments().getCompatibilityInfo();
        if (!ci.equals(CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO)) {
            globalConfig = new Configuration(globalConfig);
            ci.applyToConfiguration(this.mNoncompatDensity, globalConfig);
        }
        ArrayList<ConfigChangedCallback> arrayList = sConfigCallbacks;
        synchronized (arrayList) {
            for (int i10 = arrayList.size() - 1; i10 >= 0; i10--) {
                sConfigCallbacks.get(i10).onConfigurationChanged(globalConfig);
            }
        }
        this.mViewRootImplExt.handleGestureConfigCheck();
        this.mViewRootImplExt.setDarkModeProgress(this.mView, globalConfig);
        this.mLastReportedMergedConfiguration.setConfiguration(globalConfig, overrideConfig);
        this.mForceNextConfigUpdate = force;
        ActivityConfigCallback activityConfigCallback = this.mActivityConfigCallback;
        if (activityConfigCallback != null) {
            activityConfigCallback.onConfigurationChanged(overrideConfig, newDisplayId);
        } else {
            updateConfiguration(newDisplayId);
        }
        this.mForceNextConfigUpdate = false;
    }

    public void updateConfiguration(int newDisplayId) {
        View view = this.mView;
        if (view == null) {
            return;
        }
        Resources localResources = view.getResources();
        Configuration config = localResources.getConfiguration();
        if (newDisplayId != -1) {
            onMovedToDisplay(newDisplayId, config);
        }
        if (this.mForceNextConfigUpdate || this.mLastConfigurationFromResources.diff(config) != 0) {
            updateInternalDisplay(this.mDisplay.getDisplayId(), localResources);
            updateLastConfigurationFromResources(config);
            this.mView.dispatchConfigurationChanged(config);
            this.mForceNextWindowRelayout = true;
            requestLayout();
        }
        updateForceDarkMode();
    }

    private void updateLastConfigurationFromResources(Configuration resConfig) {
        View view;
        int lastLayoutDirection = this.mLastConfigurationFromResources.getLayoutDirection();
        int currentLayoutDirection = resConfig.getLayoutDirection();
        this.mLastConfigurationFromResources.setTo(resConfig);
        if (lastLayoutDirection != currentLayoutDirection && (view = this.mView) != null && this.mViewLayoutDirectionInitial == 2) {
            view.setLayoutDirection(currentLayoutDirection);
        }
        if (DEBUG_CONFIGURATION) {
            Log.i(this.mTag, "ViewRootImpl updateConfiguration" + ((Object) resConfig) + " \n" + Debug.getCallers(10));
        }
    }

    public static boolean isViewDescendantOf(View child, View parent) {
        if (child == parent) {
            return true;
        }
        Object parent2 = child.getParent();
        return (parent2 instanceof ViewGroup) && isViewDescendantOf((View) parent2, parent);
    }

    private static void forceLayout(View view) {
        view.forceLayout();
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
            for (int i10 = 0; i10 < count; i10++) {
                if (group.getChildAt(i10) != null) {
                    forceLayout(group.getChildAt(i10));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ViewRootHandler extends Handler {
        ViewRootHandler() {
        }

        @Override // android.os.Handler
        public String getMessageName(Message message) {
            switch (message.what) {
                case 1:
                    return "MSG_INVALIDATE";
                case 2:
                    return "MSG_INVALIDATE_RECT";
                case 3:
                    return "MSG_DIE";
                case 4:
                    return "MSG_RESIZED";
                case 5:
                    return "MSG_RESIZED_REPORT";
                case 6:
                    return "MSG_WINDOW_FOCUS_CHANGED";
                case 7:
                    return "MSG_DISPATCH_INPUT_EVENT";
                case 8:
                    return "MSG_DISPATCH_APP_VISIBILITY";
                case 9:
                    return "MSG_DISPATCH_GET_NEW_SURFACE";
                case 10:
                case 20:
                case 22:
                case 26:
                case 33:
                default:
                    return super.getMessageName(message);
                case 11:
                    return "MSG_DISPATCH_KEY_FROM_IME";
                case 12:
                    return "MSG_DISPATCH_KEY_FROM_AUTOFILL";
                case 13:
                    return "MSG_CHECK_FOCUS";
                case 14:
                    return "MSG_CLOSE_SYSTEM_DIALOGS";
                case 15:
                    return "MSG_DISPATCH_DRAG_EVENT";
                case 16:
                    return "MSG_DISPATCH_DRAG_LOCATION_EVENT";
                case 17:
                    return "MSG_DISPATCH_SYSTEM_UI_VISIBILITY";
                case 18:
                    return "MSG_UPDATE_CONFIGURATION";
                case 19:
                    return "MSG_PROCESS_INPUT_EVENTS";
                case 21:
                    return "MSG_CLEAR_ACCESSIBILITY_FOCUS_HOST";
                case 23:
                    return "MSG_WINDOW_MOVED";
                case 24:
                    return "MSG_SYNTHESIZE_INPUT_EVENT";
                case 25:
                    return "MSG_DISPATCH_WINDOW_SHOWN";
                case 27:
                    return "MSG_UPDATE_POINTER_ICON";
                case 28:
                    return "MSG_POINTER_CAPTURE_CHANGED";
                case 29:
                    return "MSG_INSETS_CONTROL_CHANGED";
                case 30:
                    return "MSG_SYSTEM_GESTURE_EXCLUSION_CHANGED";
                case 31:
                    return "MSG_SHOW_INSETS";
                case 32:
                    return "MSG_HIDE_INSETS";
                case 34:
                    return "MSG_WINDOW_TOUCH_MODE_CHANGED";
                case 35:
                    return "MSG_KEEP_CLEAR_RECTS_CHANGED";
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
            if (msg.what == 26 && msg.obj == null) {
                throw new NullPointerException("Attempted to call MSG_REQUEST_KEYBOARD_SHORTCUTS with null receiver:");
            }
            return super.sendMessageAtTime(msg, uptimeMillis);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (Trace.isTagEnabled(8L)) {
                Trace.traceBegin(8L, getMessageName(msg));
            }
            try {
                handleMessageImpl(msg);
            } finally {
                Trace.traceEnd(8L);
            }
        }

        private void handleMessageImpl(Message message) {
            ViewRootImpl.this.mViewRootImplExt.markOnHandleMessageImpl(getMessageName(message));
            switch (message.what) {
                case 1:
                    ((View) message.obj).invalidate();
                    return;
                case 2:
                    View.AttachInfo.InvalidateInfo invalidateInfo = (View.AttachInfo.InvalidateInfo) message.obj;
                    invalidateInfo.target.invalidate(invalidateInfo.left, invalidateInfo.top, invalidateInfo.right, invalidateInfo.bottom);
                    invalidateInfo.recycle();
                    return;
                case 3:
                    ViewRootImpl.this.doDie();
                    return;
                case 4:
                case 5:
                    SomeArgs someArgs = (SomeArgs) message.obj;
                    ViewRootImpl.this.mInsetsController.onStateChanged((InsetsState) someArgs.arg3);
                    ViewRootImpl.this.handleResized(message.what, someArgs);
                    someArgs.recycle();
                    return;
                case 6:
                    ViewRootImpl.this.handleWindowFocusChanged();
                    return;
                case 7:
                    SomeArgs someArgs2 = (SomeArgs) message.obj;
                    ViewRootImpl.this.enqueueInputEvent((InputEvent) someArgs2.arg1, (InputEventReceiver) someArgs2.arg2, 0, true);
                    someArgs2.recycle();
                    return;
                case 8:
                    ViewRootImpl.this.handleAppVisibility(message.arg1 != 0);
                    return;
                case 9:
                    ViewRootImpl.this.handleGetNewSurface();
                    return;
                case 10:
                case 20:
                default:
                    return;
                case 11:
                    if (ViewRootImpl.LOCAL_LOGV) {
                        Log.v(ViewRootImpl.TAG, "Dispatching key " + message.obj + " from IME to " + ((Object) ViewRootImpl.this.mView));
                    }
                    KeyEvent keyEvent = (KeyEvent) message.obj;
                    if ((keyEvent.getFlags() & 8) != 0) {
                        keyEvent = KeyEvent.changeFlags(keyEvent, keyEvent.getFlags() & (-9));
                    }
                    ViewRootImpl.this.enqueueInputEvent(keyEvent, null, 1, true);
                    return;
                case 12:
                    if (ViewRootImpl.LOCAL_LOGV) {
                        Log.v(ViewRootImpl.TAG, "Dispatching key " + message.obj + " from Autofill to " + ((Object) ViewRootImpl.this.mView));
                    }
                    ViewRootImpl.this.enqueueInputEvent((KeyEvent) message.obj, null, 0, true);
                    return;
                case 13:
                    ViewRootImpl.this.getImeFocusController().onScheduledCheckFocus();
                    return;
                case 14:
                    if (ViewRootImpl.this.mView != null) {
                        ViewRootImpl.this.mView.onCloseSystemDialogs((String) message.obj);
                        return;
                    }
                    return;
                case 15:
                case 16:
                    DragEvent dragEvent = (DragEvent) message.obj;
                    dragEvent.mLocalState = ViewRootImpl.this.mLocalDragState;
                    ViewRootImpl.this.handleDragEvent(dragEvent);
                    return;
                case 17:
                    ViewRootImpl.this.handleDispatchSystemUiVisibilityChanged();
                    return;
                case 18:
                    Configuration configuration = (Configuration) message.obj;
                    if (configuration.isOtherSeqNewer(ViewRootImpl.this.mLastReportedMergedConfiguration.getMergedConfiguration())) {
                        configuration = ViewRootImpl.this.mLastReportedMergedConfiguration.getGlobalConfiguration();
                    }
                    ViewRootImpl.this.mPendingMergedConfiguration.setConfiguration(configuration, ViewRootImpl.this.mLastReportedMergedConfiguration.getOverrideConfiguration());
                    ViewRootImpl.this.performConfigurationChange(new MergedConfiguration(ViewRootImpl.this.mPendingMergedConfiguration), false, -1);
                    return;
                case 19:
                    ViewRootImpl.this.mProcessInputEventsScheduled = false;
                    ViewRootImpl.this.doProcessInputEvents();
                    return;
                case 21:
                    ViewRootImpl.this.setAccessibilityFocus(null, null);
                    return;
                case 22:
                    if (ViewRootImpl.this.mView != null) {
                        ViewRootImpl viewRootImpl = ViewRootImpl.this;
                        viewRootImpl.invalidateWorld(viewRootImpl.mView);
                        return;
                    }
                    return;
                case 23:
                    if (ViewRootImpl.this.mAdded) {
                        int width = ViewRootImpl.this.mWinFrame.width();
                        int height = ViewRootImpl.this.mWinFrame.height();
                        int i10 = message.arg1;
                        int i11 = message.arg2;
                        ViewRootImpl.this.mTmpFrames.frame.left = i10;
                        ViewRootImpl.this.mTmpFrames.frame.right = i10 + width;
                        ViewRootImpl.this.mTmpFrames.frame.top = i11;
                        ViewRootImpl.this.mTmpFrames.frame.bottom = i11 + height;
                        ViewRootImpl viewRootImpl2 = ViewRootImpl.this;
                        viewRootImpl2.setFrame(viewRootImpl2.mTmpFrames.frame, false);
                        ViewRootImpl viewRootImpl3 = ViewRootImpl.this;
                        viewRootImpl3.maybeHandleWindowMove(viewRootImpl3.mWinFrame);
                        return;
                    }
                    return;
                case 24:
                    ViewRootImpl.this.enqueueInputEvent((InputEvent) message.obj, null, 32, true);
                    return;
                case 25:
                    ViewRootImpl.this.handleDispatchWindowShown();
                    ViewRootImpl.this.mViewRootImplExt.checkKeyguardAndConfig(ViewRootImpl.this.mTag);
                    return;
                case 26:
                    ViewRootImpl.this.handleRequestKeyboardShortcuts((IResultReceiver) message.obj, message.arg1);
                    return;
                case 27:
                    ViewRootImpl.this.resetPointerIcon((MotionEvent) message.obj);
                    return;
                case 28:
                    ViewRootImpl.this.handlePointerCaptureChanged(message.arg1 != 0);
                    return;
                case 29:
                    SomeArgs someArgs3 = (SomeArgs) message.obj;
                    ViewRootImpl.this.mInsetsController.onStateChanged((InsetsState) someArgs3.arg1);
                    InsetsSourceControl[] insetsSourceControlArr = (InsetsSourceControl[]) someArgs3.arg2;
                    if (ViewRootImpl.this.mAdded) {
                        ViewRootImpl.this.mInsetsController.onControlsChanged(insetsSourceControlArr);
                    } else if (insetsSourceControlArr != null) {
                        for (InsetsSourceControl insetsSourceControl : insetsSourceControlArr) {
                            if (insetsSourceControl != null) {
                                insetsSourceControl.release(new InsetsAnimationThreadControlRunner$$ExternalSyntheticLambda0());
                            }
                        }
                    }
                    someArgs3.recycle();
                    return;
                case 30:
                    ViewRootImpl.this.systemGestureExclusionChanged();
                    return;
                case 31:
                    ImeTracker.Token token = (ImeTracker.Token) message.obj;
                    ImeTracker.forLogging().onProgress(token, 30);
                    if (ViewRootImpl.this.mView == null) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(message.arg1);
                        objArr[1] = Boolean.valueOf(message.arg2 == 1);
                        Log.e(ViewRootImpl.TAG, String.format("Calling showInsets(%d,%b) on window that no longer has views.", objArr));
                    }
                    ViewRootImpl.this.mViewRootImplExt.markShowInsets(message.arg1, message.arg2 == 1);
                    ViewRootImpl.this.clearLowProfileModeIfNeeded(message.arg1, message.arg2 == 1);
                    ViewRootImpl.this.mInsetsController.show(message.arg1, message.arg2 == 1, token);
                    ViewRootImpl.this.mChoreographer.mChoreographerExt.showInsetAnim(message.arg1, message.arg2 == 1);
                    return;
                case 32:
                    ImeTracker.Token token2 = (ImeTracker.Token) message.obj;
                    ImeTracker.forLogging().onProgress(token2, 31);
                    ViewRootImpl.this.mInsetsController.hide(message.arg1, message.arg2 == 1, token2);
                    return;
                case 33:
                    ViewRootImpl.this.handleScrollCaptureRequest((IScrollCaptureResponseListener) message.obj);
                    return;
                case 34:
                    ViewRootImpl.this.handleWindowTouchModeChanged();
                    return;
                case 35:
                    ViewRootImpl.this.keepClearRectsChanged(message.arg1 == 1);
                    return;
                case 36:
                    ViewRootImpl.this.reportKeepClearAreasChanged();
                    return;
                case 37:
                    Log.e(ViewRootImpl.this.mTag, "Timedout waiting to unpause for sync");
                    ViewRootImpl.this.mNumPausedForSync = 0;
                    ViewRootImpl.this.scheduleTraversals();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(Runnable r10) {
        this.mHandler.post(r10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ensureTouchMode(boolean inTouchMode) {
        if (DBG) {
            Log.d("touchmode", "ensureTouchMode(" + inTouchMode + "), current touch mode is " + this.mAttachInfo.mInTouchMode);
        }
        if (this.mAttachInfo.mInTouchMode == inTouchMode) {
            return false;
        }
        try {
            IWindowManager windowManager = WindowManagerGlobal.getWindowManagerService();
            windowManager.setInTouchMode(inTouchMode, getDisplayId());
            return ensureTouchModeLocally(inTouchMode);
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean ensureTouchModeLocally(boolean inTouchMode) {
        if (DBG) {
            Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current touch mode is " + this.mAttachInfo.mInTouchMode);
        }
        if (this.mAttachInfo.mInTouchMode == inTouchMode) {
            return false;
        }
        this.mAttachInfo.mInTouchMode = inTouchMode;
        this.mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);
        return inTouchMode ? enterTouchMode() : leaveTouchMode();
    }

    private boolean enterTouchMode() {
        View focused;
        View view = this.mView;
        if (view == null || !view.hasFocus() || (focused = this.mView.findFocus()) == null || focused.isFocusableInTouchMode()) {
            return false;
        }
        ViewGroup ancestorToTakeFocus = findAncestorToTakeFocusInTouchMode(focused);
        if (ancestorToTakeFocus != null) {
            return ancestorToTakeFocus.requestFocus();
        }
        focused.clearFocusInternal(null, true, false);
        return true;
    }

    private static ViewGroup findAncestorToTakeFocusInTouchMode(View focused) {
        ViewParent parent = focused.getParent();
        while (parent instanceof ViewGroup) {
            ViewGroup vgParent = (ViewGroup) parent;
            if (vgParent.getDescendantFocusability() == 262144 && vgParent.isFocusableInTouchMode()) {
                return vgParent;
            }
            if (vgParent.isRootNamespace()) {
                return null;
            }
            parent = vgParent.getParent();
        }
        return null;
    }

    private boolean leaveTouchMode() {
        View view = this.mView;
        if (view == null) {
            return false;
        }
        if (view.hasFocus()) {
            View focusedView = this.mView.findFocus();
            if (!(focusedView instanceof ViewGroup) || ((ViewGroup) focusedView).getDescendantFocusability() != 262144) {
                return false;
            }
        }
        return this.mView.restoreDefaultFocus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public abstract class InputStage {
        protected static final int FINISH_HANDLED = 1;
        protected static final int FINISH_NOT_HANDLED = 2;
        protected static final int FORWARD = 0;
        private final InputStage mNext;
        private String mTracePrefix;

        public InputStage(InputStage next) {
            this.mNext = next;
        }

        public final void deliver(QueuedInputEvent q10) {
            if ((q10.mFlags & 4) != 0) {
                forward(q10);
                return;
            }
            if (shouldDropInputEvent(q10)) {
                finish(q10, false);
                return;
            }
            traceEvent(q10, 8L);
            try {
                int result = onProcess(q10);
                Trace.traceEnd(8L);
                apply(q10, result);
            } catch (Throwable th) {
                Trace.traceEnd(8L);
                throw th;
            }
        }

        protected void finish(QueuedInputEvent q10, boolean handled) {
            q10.mFlags |= 4;
            if (handled) {
                q10.mFlags |= 8;
            }
            forward(q10);
        }

        protected void forward(QueuedInputEvent q10) {
            onDeliverToNext(q10);
        }

        protected void apply(QueuedInputEvent q10, int result) {
            if (result == 0) {
                forward(q10);
            } else if (result == 1) {
                finish(q10, true);
            } else {
                if (result == 2) {
                    finish(q10, false);
                    return;
                }
                throw new IllegalArgumentException("Invalid result: " + result);
            }
        }

        protected int onProcess(QueuedInputEvent q10) {
            return 0;
        }

        protected void onDeliverToNext(QueuedInputEvent q10) {
            ViewRootImpl.this.mViewRootImplExt.debugInputStageDeliverd(ViewRootImpl.this.mTag, q10.mFlags, q10.mEvent, getClass().getSimpleName(), (ViewRootImpl.DEBUG_INPUT_STAGES || ViewRootImpl.this.mViewRootImplExt.isLevelDebug()) ? q10.toString() : null);
            if (ViewRootImpl.DEBUG_INPUT_STAGES) {
                Log.v(ViewRootImpl.this.mTag, "Done with " + getClass().getSimpleName() + ". " + ((Object) q10));
            }
            InputStage inputStage = this.mNext;
            if (inputStage != null) {
                inputStage.deliver(q10);
            } else {
                ViewRootImpl.this.finishInputEvent(q10);
            }
        }

        protected void onWindowFocusChanged(boolean hasWindowFocus) {
            InputStage inputStage = this.mNext;
            if (inputStage != null) {
                inputStage.onWindowFocusChanged(hasWindowFocus);
            }
        }

        protected void onDetachedFromWindow() {
            InputStage inputStage = this.mNext;
            if (inputStage != null) {
                inputStage.onDetachedFromWindow();
            }
        }

        protected boolean shouldDropInputEvent(QueuedInputEvent q10) {
            String reason;
            if (ViewRootImpl.this.mView == null || !ViewRootImpl.this.mAdded) {
                Slog.w(ViewRootImpl.this.mTag, "Dropping event due to root view being removed: " + ((Object) q10.mEvent));
                return true;
            }
            if (!ViewRootImpl.this.mAttachInfo.mHasWindowFocus && !q10.mEvent.isFromSource(2) && !ViewRootImpl.this.isAutofillUiShowing()) {
                reason = "no window focus";
            } else if (ViewRootImpl.this.mStopped) {
                reason = "window is stopped";
            } else if (ViewRootImpl.this.mIsAmbientMode && !q10.mEvent.isFromSource(1)) {
                reason = "non-button event in ambient mode";
            } else {
                if (!ViewRootImpl.this.mPausedForTransition || isBack(q10.mEvent)) {
                    return false;
                }
                reason = "paused for transition";
            }
            if (ViewRootImpl.isTerminalInputEvent(q10.mEvent)) {
                q10.mEvent.cancel();
                Slog.w(ViewRootImpl.this.mTag, "Cancelling event (" + reason + "):" + ((Object) q10.mEvent));
                return false;
            }
            Slog.w(ViewRootImpl.this.mTag, "Dropping event (" + reason + "):" + ((Object) q10.mEvent));
            return true;
        }

        void dump(String prefix, PrintWriter writer) {
            InputStage inputStage = this.mNext;
            if (inputStage != null) {
                inputStage.dump(prefix, writer);
            }
        }

        boolean isBack(InputEvent event) {
            return (event instanceof KeyEvent) && ((KeyEvent) event).getKeyCode() == 4;
        }

        private void traceEvent(QueuedInputEvent q10, long traceTag) {
            if (!Trace.isTagEnabled(traceTag)) {
                return;
            }
            if (this.mTracePrefix == null) {
                this.mTracePrefix = getClass().getSimpleName();
            }
            Trace.traceBegin(traceTag, this.mTracePrefix + " id=0x" + Integer.toHexString(q10.mEvent.getId()));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    abstract class AsyncInputStage extends InputStage {
        protected static final int DEFER = 3;
        private QueuedInputEvent mQueueHead;
        private int mQueueLength;
        private QueuedInputEvent mQueueTail;
        private final String mTraceCounter;

        public AsyncInputStage(InputStage next, String traceCounter) {
            super(next);
            this.mTraceCounter = traceCounter;
        }

        protected void defer(QueuedInputEvent q10) {
            q10.mFlags |= 2;
            enqueue(q10);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void forward(QueuedInputEvent q10) {
            q10.mFlags &= -3;
            QueuedInputEvent curr = this.mQueueHead;
            if (curr == null) {
                super.forward(q10);
                return;
            }
            int deviceId = q10.mEvent.getDeviceId();
            QueuedInputEvent prev = null;
            boolean blocked = false;
            while (curr != null && curr != q10) {
                if (!blocked && deviceId == curr.mEvent.getDeviceId()) {
                    blocked = true;
                }
                prev = curr;
                curr = curr.mNext;
            }
            if (blocked) {
                if (curr == null) {
                    enqueue(q10);
                    return;
                }
                return;
            }
            if (curr != null) {
                curr = curr.mNext;
                dequeue(q10, prev);
            }
            super.forward(q10);
            while (curr != null) {
                if (deviceId == curr.mEvent.getDeviceId()) {
                    if ((curr.mFlags & 2) == 0) {
                        QueuedInputEvent next = curr.mNext;
                        dequeue(curr, prev);
                        super.forward(curr);
                        curr = next;
                    } else {
                        return;
                    }
                } else {
                    prev = curr;
                    curr = curr.mNext;
                }
            }
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void apply(QueuedInputEvent q10, int result) {
            if (result == 3) {
                defer(q10);
            } else {
                super.apply(q10, result);
            }
        }

        private void enqueue(QueuedInputEvent q10) {
            QueuedInputEvent queuedInputEvent = this.mQueueTail;
            if (queuedInputEvent == null) {
                this.mQueueHead = q10;
                this.mQueueTail = q10;
            } else {
                queuedInputEvent.mNext = q10;
                this.mQueueTail = q10;
            }
            int i10 = this.mQueueLength + 1;
            this.mQueueLength = i10;
            Trace.traceCounter(4L, this.mTraceCounter, i10);
        }

        private void dequeue(QueuedInputEvent q10, QueuedInputEvent prev) {
            if (prev == null) {
                this.mQueueHead = q10.mNext;
            } else {
                prev.mNext = q10.mNext;
            }
            if (this.mQueueTail == q10) {
                this.mQueueTail = prev;
            }
            q10.mNext = null;
            int i10 = this.mQueueLength - 1;
            this.mQueueLength = i10;
            Trace.traceCounter(4L, this.mTraceCounter, i10);
        }

        @Override // android.view.ViewRootImpl.InputStage
        void dump(String prefix, PrintWriter writer) {
            writer.print(prefix);
            writer.print(getClass().getName());
            writer.print(": mQueueLength=");
            writer.println(this.mQueueLength);
            super.dump(prefix, writer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class NativePreImeInputStage extends AsyncInputStage implements InputQueue.FinishedInputEventCallback {
        public NativePreImeInputStage(InputStage next, String traceCounter) {
            super(next, traceCounter);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent q10) {
            if (q10.mEvent instanceof KeyEvent) {
                KeyEvent keyEvent = (KeyEvent) q10.mEvent;
                if (isBack(keyEvent) && ViewRootImpl.this.mContext != null && ViewRootImpl.this.mOnBackInvokedDispatcher.isOnBackInvokedCallbackEnabled()) {
                    return doOnBackKeyEvent(keyEvent);
                }
                if (ViewRootImpl.this.mInputQueue != null) {
                    ViewRootImpl.this.mInputQueue.sendInputEvent(q10.mEvent, q10, true, this);
                    return 3;
                }
                return 0;
            }
            return 0;
        }

        private int doOnBackKeyEvent(KeyEvent keyEvent) {
            OnBackInvokedCallback topCallback = ViewRootImpl.this.getOnBackInvokedDispatcher().getTopCallback();
            if (topCallback instanceof OnBackAnimationCallback) {
                OnBackAnimationCallback animationCallback = (OnBackAnimationCallback) topCallback;
                switch (keyEvent.getAction()) {
                    case 0:
                        if (keyEvent.getRepeatCount() == 0) {
                            animationCallback.onBackStarted(new BackEvent(0.0f, 0.0f, 0.0f, 0));
                            return 2;
                        }
                        return 2;
                    case 1:
                        if (keyEvent.isCanceled()) {
                            animationCallback.onBackCancelled();
                            return 2;
                        }
                        topCallback.onBackInvoked();
                        return 1;
                    default:
                        return 2;
                }
            }
            if (topCallback != null && keyEvent.getAction() == 1) {
                if (!keyEvent.isCanceled()) {
                    topCallback.onBackInvoked();
                    return 1;
                }
                Log.d(ViewRootImpl.this.mTag, "Skip onBackInvoked(), reason: keyEvent.isCanceled=true");
                return 2;
            }
            return 2;
        }

        @Override // android.view.InputQueue.FinishedInputEventCallback
        public void onFinishedInputEvent(Object token, boolean handled) {
            QueuedInputEvent q10 = (QueuedInputEvent) token;
            if (handled) {
                finish(q10, true);
            } else {
                forward(q10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ViewPreImeInputStage extends InputStage {
        public ViewPreImeInputStage(InputStage next) {
            super(next);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent q10) {
            if (q10.mEvent instanceof KeyEvent) {
                return processKeyEvent(q10);
            }
            return 0;
        }

        private int processKeyEvent(QueuedInputEvent q10) {
            KeyEvent event = (KeyEvent) q10.mEvent;
            if (ViewRootImpl.this.mView.dispatchKeyEventPreIme(event)) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ImeInputStage extends AsyncInputStage implements InputMethodManager.FinishedInputEventCallback {
        public ImeInputStage(InputStage next, String traceCounter) {
            super(next, traceCounter);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent q10) {
            int result = ViewRootImpl.this.mImeFocusController.onProcessImeInputStage(q10, q10.mEvent, ViewRootImpl.this.mWindowAttributes, this);
            switch (result) {
                case -1:
                    return 3;
                case 0:
                    return 0;
                case 1:
                    return 1;
                default:
                    throw new IllegalStateException("Unexpected result=" + result);
            }
        }

        @Override // android.view.inputmethod.InputMethodManager.FinishedInputEventCallback
        public void onFinishedInputEvent(Object token, boolean handled) {
            QueuedInputEvent q10 = (QueuedInputEvent) token;
            if (handled) {
                finish(q10, true);
            } else {
                forward(q10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class EarlyPostImeInputStage extends InputStage {
        public EarlyPostImeInputStage(InputStage next) {
            super(next);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent q10) {
            if (q10.mEvent instanceof KeyEvent) {
                return processKeyEvent(q10);
            }
            if (q10.mEvent instanceof MotionEvent) {
                return processMotionEvent(q10);
            }
            return 0;
        }

        private int processKeyEvent(QueuedInputEvent q10) {
            KeyEvent event = (KeyEvent) q10.mEvent;
            if (ViewRootImpl.this.mAttachInfo.mTooltipHost != null) {
                ViewRootImpl.this.mAttachInfo.mTooltipHost.handleTooltipKey(event);
            }
            if (ViewRootImpl.this.checkForLeavingTouchModeAndConsume(event)) {
                return 1;
            }
            ViewRootImpl.this.mFallbackEventHandler.preDispatchKeyEvent(event);
            if (event.getAction() == 0) {
                ViewRootImpl.this.mLastClickToolType = 0;
            }
            return 0;
        }

        private int processMotionEvent(QueuedInputEvent q10) {
            MotionEvent event = (MotionEvent) q10.mEvent;
            if (event.isFromSource(2)) {
                return processPointerEvent(q10);
            }
            int action = event.getActionMasked();
            if ((action == 0 || action == 8) && event.isFromSource(8)) {
                ViewRootImpl.this.ensureTouchMode(false);
            }
            return 0;
        }

        private int processPointerEvent(QueuedInputEvent q10) {
            AutofillManager afm;
            MotionEvent event = (MotionEvent) q10.mEvent;
            if (ViewRootImpl.this.mTranslator != null) {
                ViewRootImpl.this.mTranslator.translateEventInScreenToAppWindow(event);
            }
            int action = event.getAction();
            if (action == 0 || action == 8) {
                ViewRootImpl.this.ensureTouchMode(true);
            }
            if (action == 0 && (afm = ViewRootImpl.this.getAutofillManager()) != null) {
                afm.requestHideFillUi();
            }
            if (action == 0 && ViewRootImpl.this.mAttachInfo.mTooltipHost != null) {
                ViewRootImpl.this.mAttachInfo.mTooltipHost.hideTooltip();
            }
            if (ViewRootImpl.this.mCurScrollY != 0) {
                event.offsetLocation(0.0f, ViewRootImpl.this.mCurScrollY);
            }
            if (event.isTouchEvent()) {
                ViewRootImpl.this.mLastTouchPoint.x = event.getRawX();
                ViewRootImpl.this.mLastTouchPoint.y = event.getRawY();
                ViewRootImpl.this.mLastTouchSource = event.getSource();
                if (event.getActionMasked() == 1) {
                    ViewRootImpl.this.mLastClickToolType = event.getToolType(event.getActionIndex());
                    return 0;
                }
                return 0;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class NativePostImeInputStage extends AsyncInputStage implements InputQueue.FinishedInputEventCallback {
        public NativePostImeInputStage(InputStage next, String traceCounter) {
            super(next, traceCounter);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent q10) {
            if (ViewRootImpl.this.mInputQueue == null) {
                return 0;
            }
            ViewRootImpl.this.mInputQueue.sendInputEvent(q10.mEvent, q10, false, this);
            return 3;
        }

        @Override // android.view.InputQueue.FinishedInputEventCallback
        public void onFinishedInputEvent(Object token, boolean handled) {
            QueuedInputEvent q10 = (QueuedInputEvent) token;
            if (handled) {
                finish(q10, true);
            } else {
                forward(q10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ViewPostImeInputStage extends InputStage {
        public ViewPostImeInputStage(InputStage next) {
            super(next);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent q10) {
            if (q10.mEvent instanceof KeyEvent) {
                return processKeyEvent(q10);
            }
            int source = q10.mEvent.getSource();
            if ((source & 2) != 0) {
                return processPointerEvent(q10);
            }
            if ((source & 4) != 0) {
                return processTrackballEvent(q10);
            }
            return processGenericMotionEvent(q10);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void onDeliverToNext(QueuedInputEvent q10) {
            if (ViewRootImpl.this.mUnbufferedInputDispatch && (q10.mEvent instanceof MotionEvent) && ((MotionEvent) q10.mEvent).isTouchEvent() && ViewRootImpl.isTerminalInputEvent(q10.mEvent)) {
                ViewRootImpl.this.mUnbufferedInputDispatch = false;
                ViewRootImpl.this.scheduleConsumeBatchedInput();
            }
            super.onDeliverToNext(q10);
        }

        private boolean performFocusNavigation(KeyEvent event) {
            int direction = 0;
            switch (event.getKeyCode()) {
                case 19:
                    if (event.hasNoModifiers()) {
                        direction = 33;
                        break;
                    }
                    break;
                case 20:
                    if (event.hasNoModifiers()) {
                        direction = 130;
                        break;
                    }
                    break;
                case 21:
                    if (event.hasNoModifiers()) {
                        direction = 17;
                        break;
                    }
                    break;
                case 22:
                    if (event.hasNoModifiers()) {
                        direction = 66;
                        break;
                    }
                    break;
                case 61:
                    if (event.hasNoModifiers()) {
                        direction = 2;
                        break;
                    } else if (event.hasModifiers(1)) {
                        direction = 1;
                        break;
                    }
                    break;
            }
            if (direction != 0) {
                View focused = ViewRootImpl.this.mView.findFocus();
                if (focused != null) {
                    View v2 = focused.focusSearch(direction);
                    if (v2 != null && v2 != focused) {
                        focused.getFocusedRect(ViewRootImpl.this.mTempRect);
                        if (ViewRootImpl.this.mView instanceof ViewGroup) {
                            ((ViewGroup) ViewRootImpl.this.mView).offsetDescendantRectToMyCoords(focused, ViewRootImpl.this.mTempRect);
                            ((ViewGroup) ViewRootImpl.this.mView).offsetRectIntoDescendantCoords(v2, ViewRootImpl.this.mTempRect);
                        }
                        if (v2.requestFocus(direction, ViewRootImpl.this.mTempRect)) {
                            boolean isFastScrolling = event.getRepeatCount() > 0;
                            ViewRootImpl.this.playSoundEffect(SoundEffectConstants.getConstantForFocusDirection(direction, isFastScrolling));
                            return true;
                        }
                    }
                    if (ViewRootImpl.this.mView.dispatchUnhandledMove(focused, direction)) {
                        return true;
                    }
                } else if (ViewRootImpl.this.mView.restoreDefaultFocus()) {
                    return true;
                }
            }
            return false;
        }

        private boolean performKeyboardGroupNavigation(int direction) {
            View cluster;
            View focused = ViewRootImpl.this.mView.findFocus();
            if (focused == null && ViewRootImpl.this.mView.restoreDefaultFocus()) {
                return true;
            }
            if (focused == null) {
                cluster = ViewRootImpl.this.keyboardNavigationClusterSearch(null, direction);
            } else {
                cluster = focused.keyboardNavigationClusterSearch(null, direction);
            }
            int realDirection = direction;
            if (direction == 2 || direction == 1) {
                realDirection = 130;
            }
            if (cluster != null && cluster.isRootNamespace()) {
                if (!cluster.restoreFocusNotInCluster()) {
                    cluster = ViewRootImpl.this.keyboardNavigationClusterSearch(null, direction);
                } else {
                    ViewRootImpl.this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
                    return true;
                }
            }
            if (cluster != null && cluster.restoreFocusInCluster(realDirection)) {
                ViewRootImpl.this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
                return true;
            }
            return false;
        }

        private int processKeyEvent(QueuedInputEvent q10) {
            KeyEvent event = (KeyEvent) q10.mEvent;
            if (ViewRootImpl.this.mUnhandledKeyManager.preViewDispatch(event)) {
                ViewRootImpl.this.mViewRootImplExt.v(ViewRootImpl.this.mTag, "App handle dispatchUnique event = " + ((Object) event) + ", mView = " + ((Object) ViewRootImpl.this.mView) + ", this = " + ((Object) this));
                return 1;
            }
            if (ViewRootImpl.this.mView.dispatchKeyEvent(event)) {
                return 1;
            }
            if (shouldDropInputEvent(q10)) {
                return 2;
            }
            if (ViewRootImpl.this.mUnhandledKeyManager.dispatch(ViewRootImpl.this.mView, event)) {
                return 1;
            }
            int groupNavigationDirection = 0;
            if (event.getAction() == 0 && event.getKeyCode() == 61) {
                if (KeyEvent.metaStateHasModifiers(event.getMetaState(), 4096)) {
                    groupNavigationDirection = 2;
                } else if (KeyEvent.metaStateHasModifiers(event.getMetaState(), 4097)) {
                    groupNavigationDirection = 1;
                }
            }
            if (event.getAction() == 0 && !KeyEvent.metaStateHasNoModifiers(event.getMetaState()) && event.getRepeatCount() == 0 && !KeyEvent.isModifierKey(event.getKeyCode()) && groupNavigationDirection == 0) {
                if (ViewRootImpl.this.mView.dispatchKeyShortcutEvent(event)) {
                    return 1;
                }
                if (shouldDropInputEvent(q10)) {
                    return 2;
                }
            }
            if (ViewRootImpl.this.mFallbackEventHandler.dispatchKeyEvent(event)) {
                return 1;
            }
            if (shouldDropInputEvent(q10)) {
                return 2;
            }
            if (event.getAction() == 0) {
                return groupNavigationDirection != 0 ? performKeyboardGroupNavigation(groupNavigationDirection) ? 1 : 0 : performFocusNavigation(event) ? 1 : 0;
            }
            return 0;
        }

        private int processPointerEvent(QueuedInputEvent q10) {
            MotionEvent event = (MotionEvent) q10.mEvent;
            boolean handled = ViewRootImpl.this.mHandwritingInitiator.onTouchEvent(event);
            if (handled) {
                ViewRootImpl.this.mLastClickToolType = event.getToolType(event.getActionIndex());
            }
            boolean isHandled = ViewRootImpl.this.mViewRootImplExt.processGestureEvent(event);
            if (isHandled) {
                ViewRootImpl.this.mViewRootImplExt.debugEventHandled(ViewRootImpl.this.mTag, event, "Smart SideBar Gesture handled=" + isHandled);
                return 1;
            }
            if (ViewRootImpl.this.mViewRootImplExt.isInterceptedProcessPointerEvent(ViewRootImpl.this.mTag, event, ViewRootImpl.this.mContext)) {
                ViewRootImpl.this.mViewRootImplExt.debugEventHandled(ViewRootImpl.this.mTag, event, "HandWritting pen handled=true");
                return 1;
            }
            ViewRootImpl.this.mAttachInfo.mUnbufferedDispatchRequested = false;
            ViewRootImpl.this.mAttachInfo.mHandlingPointerEvent = true;
            if (ViewRootImpl.this.mView == null) {
                return 1;
            }
            ViewRootImpl.this.mViewRootImplSocExt.hookInputBegin(event, ViewRootImpl.this.mContext);
            ViewRootImpl.this.mViewRootImplExt.markBeforeDispatchTouchEvent(event, ViewRootImpl.this.getTitle().toString());
            boolean handled2 = handled || ViewRootImpl.this.mView.dispatchPointerEvent(event);
            ViewRootImpl.this.mViewRootImplExt.markAfterDispatchTouchEvent(event);
            ViewRootImpl.this.mViewRootImplSocExt.hookMotionEventPerfHint(event, ViewRootImpl.this.mContext);
            ViewRootImpl.this.mViewRootImplSocExt.setHaveMoveEvent(event);
            ViewRootImpl.this.mViewRootImplExt.processPointerEvent(event, ViewRootImpl.this.mContext, handled2);
            maybeUpdatePointerIcon(event);
            ViewRootImpl.this.maybeUpdateTooltip(event);
            ViewRootImpl.this.mAttachInfo.mHandlingPointerEvent = false;
            if (ViewRootImpl.this.mAttachInfo.mUnbufferedDispatchRequested && !ViewRootImpl.this.mUnbufferedInputDispatch) {
                ViewRootImpl.this.mUnbufferedInputDispatch = true;
                if (ViewRootImpl.this.mConsumeBatchedInputScheduled) {
                    ViewRootImpl.this.scheduleConsumeBatchedInputImmediately();
                }
            }
            ViewRootImpl.this.mViewRootImplExt.debugEventHandled(ViewRootImpl.this.mTag, event, "mView handled=" + handled2);
            return handled2 ? 1 : 0;
        }

        private void maybeUpdatePointerIcon(MotionEvent event) {
            if (event.getPointerCount() != 1) {
                return;
            }
            boolean needsStylusPointerIcon = event.isStylusPointer() && event.isHoverEvent() && ViewRootImpl.this.mIsStylusPointerIconEnabled;
            if (needsStylusPointerIcon || event.isFromSource(8194)) {
                if (event.getActionMasked() == 9 || event.getActionMasked() == 10) {
                    ViewRootImpl.this.mPointerIconType = null;
                }
                if (event.getActionMasked() != 10 && !ViewRootImpl.this.updatePointerIcon(event) && event.getActionMasked() == 7) {
                    ViewRootImpl.this.mPointerIconType = null;
                }
            }
        }

        private int processTrackballEvent(QueuedInputEvent q10) {
            MotionEvent event = (MotionEvent) q10.mEvent;
            return ((!event.isFromSource(InputDevice.SOURCE_MOUSE_RELATIVE) || (ViewRootImpl.this.hasPointerCapture() && !ViewRootImpl.this.mView.dispatchCapturedPointerEvent(event))) && !ViewRootImpl.this.mView.dispatchTrackballEvent(event)) ? 0 : 1;
        }

        private int processGenericMotionEvent(QueuedInputEvent q10) {
            MotionEvent event = (MotionEvent) q10.mEvent;
            return ((event.isFromSource(1048584) && ViewRootImpl.this.hasPointerCapture() && ViewRootImpl.this.mView.dispatchCapturedPointerEvent(event)) || ViewRootImpl.this.mView.dispatchGenericMotionEvent(event)) ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPointerIcon(MotionEvent event) {
        this.mPointerIconType = null;
        updatePointerIcon(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updatePointerIcon(MotionEvent event) {
        int pointerType;
        float x10 = event.getX(0);
        float y10 = event.getY(0);
        if (this.mView == null) {
            Slog.d(this.mTag, "updatePointerIcon called after view was removed");
            return false;
        }
        if (x10 < 0.0f || x10 >= r4.getWidth() || y10 < 0.0f || y10 >= this.mView.getHeight()) {
            Slog.d(this.mTag, "updatePointerIcon called with position out of bounds");
            return false;
        }
        PointerIcon pointerIcon = null;
        if (event.isStylusPointer() && this.mIsStylusPointerIconEnabled) {
            pointerIcon = this.mHandwritingInitiator.onResolvePointerIcon(this.mContext, event);
        }
        if (pointerIcon == null) {
            pointerIcon = this.mView.onResolvePointerIcon(event, 0);
        }
        if (pointerIcon == null) {
            pointerType = 1;
        } else {
            pointerType = pointerIcon.getType();
        }
        Integer num = this.mPointerIconType;
        if (num == null || num.intValue() != pointerType) {
            Integer valueOf = Integer.valueOf(pointerType);
            this.mPointerIconType = valueOf;
            this.mCustomPointerIcon = null;
            if (valueOf.intValue() != -1) {
                InputManagerGlobal.getInstance().setPointerIconType(pointerType);
                return true;
            }
        }
        if (this.mPointerIconType.intValue() == -1 && !pointerIcon.equals(this.mCustomPointerIcon)) {
            this.mCustomPointerIcon = pointerIcon;
            InputManagerGlobal.getInstance().setCustomPointerIcon(this.mCustomPointerIcon);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeUpdateTooltip(MotionEvent event) {
        if (event.getPointerCount() != 1) {
            return;
        }
        int action = event.getActionMasked();
        if (action != 9 && action != 7 && action != 10) {
            return;
        }
        AccessibilityManager manager = AccessibilityManager.getInstance(this.mContext);
        if (manager.isEnabled() && manager.isTouchExplorationEnabled()) {
            return;
        }
        View view = this.mView;
        if (view == null) {
            Slog.d(this.mTag, "maybeUpdateTooltip called after view was removed");
        } else {
            view.dispatchTooltipHoverEvent(event);
        }
    }

    private View getFocusedViewOrNull() {
        View view = this.mView;
        if (view != null) {
            return view.findFocus();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class SyntheticInputStage extends InputStage {
        private final SyntheticJoystickHandler mJoystick;
        private final SyntheticKeyboardHandler mKeyboard;
        private final SyntheticTouchNavigationHandler mTouchNavigation;
        private final SyntheticTrackballHandler mTrackball;

        public SyntheticInputStage() {
            super(null);
            this.mTrackball = new SyntheticTrackballHandler();
            this.mJoystick = new SyntheticJoystickHandler();
            this.mTouchNavigation = new SyntheticTouchNavigationHandler();
            this.mKeyboard = new SyntheticKeyboardHandler();
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected int onProcess(QueuedInputEvent q10) {
            q10.mFlags |= 16;
            if (q10.mEvent instanceof MotionEvent) {
                MotionEvent event = (MotionEvent) q10.mEvent;
                int source = event.getSource();
                if ((source & 4) != 0) {
                    this.mTrackball.process(event);
                    return 1;
                }
                if ((source & 16) != 0) {
                    this.mJoystick.process(event);
                    return 1;
                }
                if ((source & 2097152) == 2097152) {
                    this.mTouchNavigation.process(event);
                    return 1;
                }
                return 0;
            }
            if ((q10.mFlags & 32) != 0) {
                this.mKeyboard.process((KeyEvent) q10.mEvent);
                return 1;
            }
            return 0;
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void onDeliverToNext(QueuedInputEvent q10) {
            if ((q10.mFlags & 16) == 0 && (q10.mEvent instanceof MotionEvent)) {
                MotionEvent event = (MotionEvent) q10.mEvent;
                int source = event.getSource();
                if ((source & 4) != 0) {
                    this.mTrackball.cancel();
                } else if ((source & 16) != 0) {
                    this.mJoystick.cancel();
                }
            }
            super.onDeliverToNext(q10);
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void onWindowFocusChanged(boolean hasWindowFocus) {
            if (!hasWindowFocus) {
                this.mJoystick.cancel();
            }
        }

        @Override // android.view.ViewRootImpl.InputStage
        protected void onDetachedFromWindow() {
            this.mJoystick.cancel();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    final class SyntheticTrackballHandler {
        private long mLastTime;
        private final TrackballAxis mX = new TrackballAxis();
        private final TrackballAxis mY = new TrackballAxis();

        SyntheticTrackballHandler() {
        }

        public void process(MotionEvent event) {
            long curTime;
            int keycode;
            float accel;
            String str;
            int keycode2;
            long curTime2;
            String str2;
            long curTime3 = SystemClock.uptimeMillis();
            if (this.mLastTime + 250 < curTime3) {
                this.mX.reset(0);
                this.mY.reset(0);
                this.mLastTime = curTime3;
            }
            int action = event.getAction();
            int metaState = event.getMetaState();
            switch (action) {
                case 0:
                    curTime = curTime3;
                    this.mX.reset(2);
                    this.mY.reset(2);
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(curTime, curTime, 0, 23, 0, metaState, -1, 0, 1024, 257));
                    break;
                case 1:
                    this.mX.reset(2);
                    this.mY.reset(2);
                    curTime = curTime3;
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(curTime3, curTime3, 1, 23, 0, metaState, -1, 0, 1024, 257));
                    break;
                default:
                    curTime = curTime3;
                    break;
            }
            if (ViewRootImpl.DEBUG_TRACKBALL) {
                Log.v(ViewRootImpl.this.mTag, "TB X=" + this.mX.position + " step=" + this.mX.step + " dir=" + this.mX.dir + " acc=" + this.mX.acceleration + " move=" + event.getX() + " / Y=" + this.mY.position + " step=" + this.mY.step + " dir=" + this.mY.dir + " acc=" + this.mY.acceleration + " move=" + event.getY());
            }
            float xOff = this.mX.collect(event.getX(), event.getEventTime(), "X");
            float yOff = this.mY.collect(event.getY(), event.getEventTime(), "Y");
            int movement = 0;
            if (xOff > yOff) {
                movement = this.mX.generate();
                if (movement == 0) {
                    keycode = 0;
                    accel = 1.0f;
                } else {
                    int keycode3 = movement > 0 ? 22 : 21;
                    float accel2 = this.mX.acceleration;
                    this.mY.reset(2);
                    keycode = keycode3;
                    accel = accel2;
                }
            } else if (yOff <= 0.0f) {
                keycode = 0;
                accel = 1.0f;
            } else {
                movement = this.mY.generate();
                if (movement == 0) {
                    keycode = 0;
                    accel = 1.0f;
                } else {
                    int keycode4 = movement > 0 ? 20 : 19;
                    float accel3 = this.mY.acceleration;
                    this.mX.reset(2);
                    keycode = keycode4;
                    accel = accel3;
                }
            }
            if (keycode != 0) {
                if (movement < 0) {
                    movement = -movement;
                }
                int accelMovement = (int) (movement * accel);
                if (ViewRootImpl.DEBUG_TRACKBALL) {
                    Log.v(ViewRootImpl.this.mTag, "Move: movement=" + movement + " accelMovement=" + accelMovement + " accel=" + accel);
                }
                if (accelMovement <= movement) {
                    str = "Delivering fake DPAD: ";
                    keycode2 = keycode;
                    curTime2 = curTime;
                } else {
                    if (ViewRootImpl.DEBUG_TRACKBALL) {
                        Log.v(ViewRootImpl.this.mTag, "Delivering fake DPAD: " + keycode);
                    }
                    int movement2 = movement - 1;
                    int repeatCount = accelMovement - movement2;
                    str = "Delivering fake DPAD: ";
                    keycode2 = keycode;
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(curTime, curTime, 2, keycode, repeatCount, metaState, -1, 0, 1024, 257));
                    curTime2 = curTime;
                    movement = movement2;
                }
                while (movement > 0) {
                    if (ViewRootImpl.DEBUG_TRACKBALL) {
                        str2 = str;
                        Log.v(ViewRootImpl.this.mTag, str2 + keycode2);
                    } else {
                        str2 = str;
                    }
                    long curTime4 = SystemClock.uptimeMillis();
                    int i10 = keycode2;
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(curTime4, curTime4, 0, i10, 0, metaState, -1, 0, 1024, 257));
                    ViewRootImpl.this.enqueueInputEvent(new KeyEvent(curTime4, curTime4, 1, i10, 0, metaState, -1, 0, 1024, 257));
                    movement--;
                    curTime2 = curTime4;
                    str = str2;
                    keycode2 = keycode2;
                }
                this.mLastTime = curTime2;
            }
        }

        public void cancel() {
            this.mLastTime = -2147483648L;
            if (ViewRootImpl.this.mView != null && ViewRootImpl.this.mAdded) {
                ViewRootImpl.this.ensureTouchMode(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class TrackballAxis {
        static final float ACCEL_MOVE_SCALING_FACTOR = 0.025f;
        static final long FAST_MOVE_TIME = 150;
        static final float FIRST_MOVEMENT_THRESHOLD = 0.5f;
        static final float MAX_ACCELERATION = 20.0f;
        static final float SECOND_CUMULATIVE_MOVEMENT_THRESHOLD = 2.0f;
        static final float SUBSEQUENT_INCREMENTAL_MOVEMENT_THRESHOLD = 1.0f;
        int dir;
        int nonAccelMovement;
        float position;
        int step;
        float acceleration = 1.0f;
        long lastMoveTime = 0;

        TrackballAxis() {
        }

        void reset(int _step) {
            this.position = 0.0f;
            this.acceleration = 1.0f;
            this.lastMoveTime = 0L;
            this.step = _step;
            this.dir = 0;
        }

        float collect(float off, long time, String axis) {
            long normTime;
            if (off > 0.0f) {
                normTime = off * 150.0f;
                if (this.dir < 0) {
                    if (ViewRootImpl.DEBUG_TRACKBALL) {
                        Log.v(ViewRootImpl.TAG, axis + " reversed to positive!");
                    }
                    this.position = 0.0f;
                    this.step = 0;
                    this.acceleration = 1.0f;
                    this.lastMoveTime = 0L;
                }
                this.dir = 1;
            } else if (off < 0.0f) {
                normTime = (-off) * 150.0f;
                if (this.dir > 0) {
                    if (ViewRootImpl.DEBUG_TRACKBALL) {
                        Log.v(ViewRootImpl.TAG, axis + " reversed to negative!");
                    }
                    this.position = 0.0f;
                    this.step = 0;
                    this.acceleration = 1.0f;
                    this.lastMoveTime = 0L;
                }
                this.dir = -1;
            } else {
                normTime = 0;
            }
            if (normTime > 0) {
                long delta = time - this.lastMoveTime;
                this.lastMoveTime = time;
                float acc = this.acceleration;
                if (delta < normTime) {
                    float scale = ((float) (normTime - delta)) * ACCEL_MOVE_SCALING_FACTOR;
                    if (scale > 1.0f) {
                        acc *= scale;
                    }
                    if (ViewRootImpl.DEBUG_TRACKBALL) {
                        Log.v(ViewRootImpl.TAG, axis + " accelerate: off=" + off + " normTime=" + normTime + " delta=" + delta + " scale=" + scale + " acc=" + acc);
                    }
                    this.acceleration = acc < 20.0f ? acc : 20.0f;
                } else {
                    float scale2 = ((float) (delta - normTime)) * ACCEL_MOVE_SCALING_FACTOR;
                    if (scale2 > 1.0f) {
                        acc /= scale2;
                    }
                    if (ViewRootImpl.DEBUG_TRACKBALL) {
                        Log.v(ViewRootImpl.TAG, axis + " deccelerate: off=" + off + " normTime=" + normTime + " delta=" + delta + " scale=" + scale2 + " acc=" + acc);
                    }
                    this.acceleration = acc > 1.0f ? acc : 1.0f;
                }
            }
            float f10 = this.position + off;
            this.position = f10;
            return Math.abs(f10);
        }

        int generate() {
            int movement = 0;
            this.nonAccelMovement = 0;
            while (true) {
                float f10 = this.position;
                int dir = f10 >= 0.0f ? 1 : -1;
                switch (this.step) {
                    case 0:
                        if (Math.abs(f10) < 0.5f) {
                            return movement;
                        }
                        movement += dir;
                        this.nonAccelMovement += dir;
                        this.step = 1;
                        break;
                    case 1:
                        if (Math.abs(f10) < 2.0f) {
                            return movement;
                        }
                        movement += dir;
                        this.nonAccelMovement += dir;
                        this.position -= dir * 2.0f;
                        this.step = 2;
                        break;
                    default:
                        if (Math.abs(f10) < 1.0f) {
                            return movement;
                        }
                        movement += dir;
                        this.position -= dir * 1.0f;
                        float acc = this.acceleration * 1.1f;
                        this.acceleration = acc < 20.0f ? acc : this.acceleration;
                        break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class SyntheticJoystickHandler extends Handler {
        private static final int MSG_ENQUEUE_X_AXIS_KEY_REPEAT = 1;
        private static final int MSG_ENQUEUE_Y_AXIS_KEY_REPEAT = 2;
        private final SparseArray<KeyEvent> mDeviceKeyEvents;
        private final JoystickAxesState mJoystickAxesState;

        public SyntheticJoystickHandler() {
            super(true);
            this.mJoystickAxesState = new JoystickAxesState();
            this.mDeviceKeyEvents = new SparseArray<>();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                case 2:
                    if (ViewRootImpl.this.mAttachInfo.mHasWindowFocus) {
                        KeyEvent oldEvent = (KeyEvent) msg.obj;
                        KeyEvent e2 = KeyEvent.changeTimeRepeat(oldEvent, SystemClock.uptimeMillis(), oldEvent.getRepeatCount() + 1);
                        ViewRootImpl.this.enqueueInputEvent(e2);
                        Message m10 = obtainMessage(msg.what, e2);
                        m10.setAsynchronous(true);
                        sendMessageDelayed(m10, ViewConfiguration.getKeyRepeatDelay());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void process(MotionEvent event) {
            switch (event.getActionMasked()) {
                case 2:
                    update(event);
                    return;
                case 3:
                    cancel();
                    return;
                default:
                    Log.w(ViewRootImpl.this.mTag, "Unexpected action: " + event.getActionMasked());
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancel() {
            removeMessages(1);
            removeMessages(2);
            for (int i10 = 0; i10 < this.mDeviceKeyEvents.size(); i10++) {
                KeyEvent keyEvent = this.mDeviceKeyEvents.valueAt(i10);
                if (keyEvent != null) {
                    ViewRootImpl.this.enqueueInputEvent(KeyEvent.changeTimeRepeat(keyEvent, SystemClock.uptimeMillis(), 0));
                }
            }
            this.mDeviceKeyEvents.clear();
            this.mJoystickAxesState.resetState();
        }

        private void update(MotionEvent event) {
            int historySize = event.getHistorySize();
            for (int h10 = 0; h10 < historySize; h10++) {
                long time = event.getHistoricalEventTime(h10);
                this.mJoystickAxesState.updateStateForAxis(event, time, 0, event.getHistoricalAxisValue(0, 0, h10));
                this.mJoystickAxesState.updateStateForAxis(event, time, 1, event.getHistoricalAxisValue(1, 0, h10));
                this.mJoystickAxesState.updateStateForAxis(event, time, 15, event.getHistoricalAxisValue(15, 0, h10));
                this.mJoystickAxesState.updateStateForAxis(event, time, 16, event.getHistoricalAxisValue(16, 0, h10));
            }
            long time2 = event.getEventTime();
            this.mJoystickAxesState.updateStateForAxis(event, time2, 0, event.getAxisValue(0));
            this.mJoystickAxesState.updateStateForAxis(event, time2, 1, event.getAxisValue(1));
            this.mJoystickAxesState.updateStateForAxis(event, time2, 15, event.getAxisValue(15));
            this.mJoystickAxesState.updateStateForAxis(event, time2, 16, event.getAxisValue(16));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public final class JoystickAxesState {
            private static final int STATE_DOWN_OR_RIGHT = 1;
            private static final int STATE_NEUTRAL = 0;
            private static final int STATE_UP_OR_LEFT = -1;
            final int[] mAxisStatesHat = {0, 0};
            final int[] mAxisStatesStick = {0, 0};

            JoystickAxesState() {
            }

            void resetState() {
                int[] iArr = this.mAxisStatesHat;
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = this.mAxisStatesStick;
                iArr2[0] = 0;
                iArr2[1] = 0;
            }

            void updateStateForAxis(MotionEvent event, long time, int axis, float value) {
                int axisStateIndex;
                int repeatMessage;
                int currentState;
                int keyCode;
                if (isXAxis(axis)) {
                    axisStateIndex = 0;
                    repeatMessage = 1;
                } else if (!isYAxis(axis)) {
                    Log.e(ViewRootImpl.this.mTag, "Unexpected axis " + axis + " in updateStateForAxis!");
                    return;
                } else {
                    axisStateIndex = 1;
                    repeatMessage = 2;
                }
                int newState = joystickAxisValueToState(value);
                if (axis == 0 || axis == 1) {
                    currentState = this.mAxisStatesStick[axisStateIndex];
                } else {
                    currentState = this.mAxisStatesHat[axisStateIndex];
                }
                if (currentState == newState) {
                    return;
                }
                int metaState = event.getMetaState();
                int deviceId = event.getDeviceId();
                int source = event.getSource();
                if (currentState == 1 || currentState == -1) {
                    int keyCode2 = joystickAxisAndStateToKeycode(axis, currentState);
                    if (keyCode2 != 0) {
                        ViewRootImpl.this.enqueueInputEvent(new KeyEvent(time, time, 1, keyCode2, 0, metaState, deviceId, 0, 1024, source));
                        deviceId = deviceId;
                        SyntheticJoystickHandler.this.mDeviceKeyEvents.put(deviceId, null);
                    }
                    SyntheticJoystickHandler.this.removeMessages(repeatMessage);
                }
                if ((newState == 1 || newState == -1) && (keyCode = joystickAxisAndStateToKeycode(axis, newState)) != 0) {
                    int deviceId2 = deviceId;
                    KeyEvent keyEvent = new KeyEvent(time, time, 0, keyCode, 0, metaState, deviceId2, 0, 1024, source);
                    ViewRootImpl.this.enqueueInputEvent(keyEvent);
                    Message m10 = SyntheticJoystickHandler.this.obtainMessage(repeatMessage, keyEvent);
                    m10.setAsynchronous(true);
                    SyntheticJoystickHandler.this.sendMessageDelayed(m10, ViewConfiguration.getKeyRepeatTimeout());
                    SyntheticJoystickHandler.this.mDeviceKeyEvents.put(deviceId2, new KeyEvent(time, time, 1, keyCode, 0, metaState, deviceId2, 0, DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST, source));
                }
                if (axis == 0 || axis == 1) {
                    this.mAxisStatesStick[axisStateIndex] = newState;
                } else {
                    this.mAxisStatesHat[axisStateIndex] = newState;
                }
            }

            private boolean isXAxis(int axis) {
                return axis == 0 || axis == 15;
            }

            private boolean isYAxis(int axis) {
                return axis == 1 || axis == 16;
            }

            private int joystickAxisAndStateToKeycode(int axis, int state) {
                if (isXAxis(axis) && state == -1) {
                    return 21;
                }
                if (isXAxis(axis) && state == 1) {
                    return 22;
                }
                if (isYAxis(axis) && state == -1) {
                    return 19;
                }
                if (isYAxis(axis) && state == 1) {
                    return 20;
                }
                Log.e(ViewRootImpl.this.mTag, "Unknown axis " + axis + " or direction " + state);
                return 0;
            }

            private int joystickAxisValueToState(float value) {
                if (value >= 0.5f) {
                    return 1;
                }
                if (value <= -0.5f) {
                    return -1;
                }
                return 0;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    final class SyntheticTouchNavigationHandler extends Handler {
        private static final String LOCAL_TAG = "SyntheticTouchNavigationHandler";
        private int mCurrentDeviceId;
        private int mCurrentSource;
        private final GestureDetector mGestureDetector;
        private int mPendingKeyMetaState;

        SyntheticTouchNavigationHandler() {
            super(true);
            this.mCurrentDeviceId = -1;
            this.mGestureDetector = new GestureDetector(ViewRootImpl.this.mContext, new GestureDetector.OnGestureListener() { // from class: android.view.ViewRootImpl.SyntheticTouchNavigationHandler.1
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent e2) {
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent e2) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent e2) {
                    SyntheticTouchNavigationHandler.this.dispatchTap(e2.getEventTime());
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent e12, MotionEvent e2, float distanceX, float distanceY) {
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent e2) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent e12, MotionEvent e2, float velocityX, float velocityY) {
                    SyntheticTouchNavigationHandler.this.dispatchFling(velocityX, velocityY, e2.getEventTime());
                    return true;
                }
            });
        }

        public void process(MotionEvent event) {
            if (event.getDevice() == null) {
                if (ViewRootImpl.DEBUG_TOUCH_NAVIGATION) {
                    Log.d(LOCAL_TAG, "Current device not supported so motion event is not processed");
                    return;
                }
                return;
            }
            this.mPendingKeyMetaState = event.getMetaState();
            int deviceId = event.getDeviceId();
            int source = event.getSource();
            if (this.mCurrentDeviceId != deviceId || this.mCurrentSource != source) {
                this.mCurrentDeviceId = deviceId;
                this.mCurrentSource = source;
            }
            this.mGestureDetector.onTouchEvent(event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dispatchTap(long time) {
            dispatchEvent(time, 23);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dispatchFling(float x10, float y10, long time) {
            if (Math.abs(x10) > Math.abs(y10)) {
                dispatchEvent(time, x10 > 0.0f ? 22 : 21);
            } else {
                dispatchEvent(time, y10 > 0.0f ? 20 : 19);
            }
        }

        private void dispatchEvent(long time, int keyCode) {
            if (ViewRootImpl.DEBUG_TOUCH_NAVIGATION) {
                Log.d(LOCAL_TAG, "Dispatching DPAD events DOWN and UP with keycode " + keyCode);
            }
            ViewRootImpl.this.enqueueInputEvent(new KeyEvent(time, time, 0, keyCode, 0, this.mPendingKeyMetaState, this.mCurrentDeviceId, 0, 1024, this.mCurrentSource));
            ViewRootImpl.this.enqueueInputEvent(new KeyEvent(time, time, 1, keyCode, 0, this.mPendingKeyMetaState, this.mCurrentDeviceId, 0, 1024, this.mCurrentSource));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    final class SyntheticKeyboardHandler {
        SyntheticKeyboardHandler() {
        }

        public void process(KeyEvent event) {
            if ((event.getFlags() & 1024) != 0) {
                return;
            }
            KeyCharacterMap kcm = event.getKeyCharacterMap();
            int keyCode = event.getKeyCode();
            int metaState = event.getMetaState();
            KeyCharacterMap.FallbackAction fallbackAction = kcm.getFallbackAction(keyCode, metaState);
            if (fallbackAction != null) {
                int flags = event.getFlags() | 1024;
                KeyEvent fallbackEvent = KeyEvent.obtain(event.getDownTime(), event.getEventTime(), event.getAction(), fallbackAction.keyCode, event.getRepeatCount(), fallbackAction.metaState, event.getDeviceId(), event.getScanCode(), flags, event.getSource(), null);
                fallbackAction.recycle();
                ViewRootImpl.this.enqueueInputEvent(fallbackEvent);
            }
        }
    }

    private static boolean isNavigationKey(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 61:
            case 62:
            case 66:
            case 92:
            case 93:
            case 122:
            case 123:
                return true;
            default:
                return false;
        }
    }

    private static boolean isTypingKey(KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkForLeavingTouchModeAndConsume(KeyEvent event) {
        if (!this.mAttachInfo.mInTouchMode) {
            return false;
        }
        int action = event.getAction();
        if ((action != 0 && action != 2) || (event.getFlags() & 4) != 0) {
            return false;
        }
        if (event.hasNoModifiers() && isNavigationKey(event)) {
            return ensureTouchMode(false);
        }
        if (!isTypingKey(event)) {
            return false;
        }
        ensureTouchMode(false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocalDragState(Object obj) {
        this.mLocalDragState = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDragEvent(DragEvent event) {
        if (this.mView != null && this.mAdded) {
            int what = event.mAction;
            if (what == 1) {
                this.mCurrentDragView = null;
                this.mDragDescription = event.mClipDescription;
                View view = this.mStartedDragViewForA11y;
                if (view != null) {
                    view.sendWindowContentChangedAccessibilityEvent(128);
                }
            } else {
                if (what == 4) {
                    this.mDragDescription = null;
                }
                event.mClipDescription = this.mDragDescription;
            }
            if (what == 6) {
                if (View.sCascadedDragDrop) {
                    this.mView.dispatchDragEnterExitInPreN(event);
                }
                setDragFocus(null, event);
            } else {
                if (what == 2 || what == 3) {
                    this.mDragPoint.set(event.mX, event.mY);
                    CompatibilityInfo.Translator translator = this.mTranslator;
                    if (translator != null) {
                        translator.translatePointInScreenToAppWindow(this.mDragPoint);
                    }
                    int i10 = this.mCurScrollY;
                    if (i10 != 0) {
                        this.mDragPoint.offset(0.0f, i10);
                    }
                    event.mX = this.mDragPoint.x;
                    event.mY = this.mDragPoint.y;
                }
                View prevDragView = this.mCurrentDragView;
                if (what == 3 && event.mClipData != null) {
                    event.mClipData.prepareToEnterProcess(this.mView.getContext().getAttributionSource());
                }
                boolean result = this.mView.dispatchDragEvent(event);
                if (what == 2 && !event.mEventHandlerWasCalled) {
                    setDragFocus(null, event);
                }
                if (prevDragView != this.mCurrentDragView) {
                    if (prevDragView != null) {
                        try {
                            this.mWindowSession.dragRecipientExited(this.mWindow);
                        } catch (RemoteException e2) {
                            Slog.e(this.mTag, "Unable to note drag target change");
                        }
                    }
                    if (this.mCurrentDragView != null) {
                        this.mWindowSession.dragRecipientEntered(this.mWindow);
                    }
                }
                if (what == 3) {
                    try {
                        Log.i(this.mTag, "Reporting drop result: " + result);
                        this.mWindowSession.reportDropResult(this.mWindow, result);
                    } catch (RemoteException e10) {
                        Log.e(this.mTag, "Unable to report drop result");
                    }
                }
                if (what == 4) {
                    if (this.mStartedDragViewForA11y != null) {
                        if (!event.getResult()) {
                            this.mStartedDragViewForA11y.sendWindowContentChangedAccessibilityEvent(512);
                        }
                        this.mStartedDragViewForA11y.setAccessibilityDragStarted(false);
                    }
                    this.mStartedDragViewForA11y = null;
                    this.mCurrentDragView = null;
                    setLocalDragState(null);
                    this.mAttachInfo.mDragToken = null;
                    if (this.mAttachInfo.mDragSurface != null) {
                        this.mAttachInfo.mDragSurface.release();
                        this.mAttachInfo.mDragSurface = null;
                    }
                }
            }
        }
        event.recycle();
    }

    public void onWindowTitleChanged() {
        this.mAttachInfo.mForceReportNewAttributes = true;
    }

    public void handleDispatchWindowShown() {
        this.mAttachInfo.mTreeObserver.dispatchOnWindowShown();
    }

    public void handleRequestKeyboardShortcuts(IResultReceiver receiver, int deviceId) {
        Bundle data = new Bundle();
        ArrayList<KeyboardShortcutGroup> list = new ArrayList<>();
        View view = this.mView;
        if (view != null) {
            view.requestKeyboardShortcuts(list, deviceId);
        }
        data.putParcelableArrayList(WindowManager.PARCEL_KEY_SHORTCUTS_ARRAY, list);
        try {
            receiver.send(0, data);
        } catch (RemoteException e2) {
        }
    }

    public void getLastTouchPoint(Point outLocation) {
        outLocation.x = (int) this.mLastTouchPoint.x;
        outLocation.y = (int) this.mLastTouchPoint.y;
    }

    public int getLastTouchSource() {
        return this.mLastTouchSource;
    }

    public int getLastClickToolType() {
        return this.mLastClickToolType;
    }

    public void setDragFocus(View newDragTarget, DragEvent event) {
        if (this.mCurrentDragView != newDragTarget && !View.sCascadedDragDrop) {
            float tx = event.mX;
            float ty = event.mY;
            int action = event.mAction;
            ClipData td2 = event.mClipData;
            event.mX = 0.0f;
            event.mY = 0.0f;
            event.mClipData = null;
            if (this.mCurrentDragView != null) {
                event.mAction = 6;
                this.mCurrentDragView.callDragEventHandler(event);
            }
            if (newDragTarget != null) {
                event.mAction = 5;
                newDragTarget.callDragEventHandler(event);
            }
            event.mAction = action;
            event.mX = tx;
            event.mY = ty;
            event.mClipData = td2;
        }
        this.mCurrentDragView = newDragTarget;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDragStartedViewForAccessibility(View view) {
        if (this.mStartedDragViewForA11y == null) {
            this.mStartedDragViewForA11y = view;
        }
    }

    private AudioManager getAudioManager() {
        View view = this.mView;
        if (view == null) {
            throw new IllegalStateException("getAudioManager called when there is no mView");
        }
        if (this.mAudioManager == null) {
            AudioManager audioManager = (AudioManager) view.getContext().getSystemService(PowerProfile.POWER_AUDIO);
            this.mAudioManager = audioManager;
            this.mFastScrollSoundEffectsEnabled = audioManager.areNavigationRepeatSoundEffectsEnabled();
        }
        return this.mAudioManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AutofillManager getAutofillManager() {
        View view = this.mView;
        if (view instanceof ViewGroup) {
            ViewGroup decorView = (ViewGroup) view;
            if (decorView.getChildCount() > 0) {
                return (AutofillManager) decorView.getChildAt(0).getContext().getSystemService(AutofillManager.class);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAutofillUiShowing() {
        AutofillManager afm = getAutofillManager();
        if (afm == null) {
            return false;
        }
        return afm.isAutofillUiShowing();
    }

    public AccessibilityInteractionController getAccessibilityInteractionController() {
        if (this.mView == null) {
            throw new IllegalStateException("getAccessibilityInteractionController called when there is no mView");
        }
        if (this.mAccessibilityInteractionController == null) {
            this.mAccessibilityInteractionController = new AccessibilityInteractionController(this);
        }
        return this.mAccessibilityInteractionController;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x046a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int relayoutWindow(android.view.WindowManager.LayoutParams r31, int r32, boolean r33) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 1171
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.relayoutWindow(android.view.WindowManager$LayoutParams, int, boolean):int");
    }

    private void updateOpacity(WindowManager.LayoutParams params, boolean dragResizing, boolean forceUpdate) {
        boolean opaque = false;
        if (!PixelFormat.formatHasAlpha(params.format) && params.surfaceInsets.left == 0 && params.surfaceInsets.top == 0 && params.surfaceInsets.right == 0 && params.surfaceInsets.bottom == 0 && !dragResizing) {
            opaque = true;
        }
        if (!forceUpdate && this.mIsSurfaceOpaque == opaque) {
            return;
        }
        ThreadedRenderer renderer = this.mAttachInfo.mThreadedRenderer;
        if (renderer != null && renderer.rendererOwnsSurfaceControlOpacity()) {
            opaque = renderer.setSurfaceControlOpaque(opaque);
        } else {
            this.mTransaction.setOpaque(this.mSurfaceControl, opaque).apply();
        }
        this.mIsSurfaceOpaque = opaque;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrame(Rect frame, boolean withinRelayout) {
        Rect rect;
        this.mWinFrame.set(frame);
        this.mViewRootImplExt.setFrame(frame.width(), frame.height());
        if (withinRelayout) {
            this.mLastLayoutFrame.set(frame);
        }
        this.mViewRootImplExt.markOnSetFrame(frame, this.mWindowAttributes);
        WindowConfiguration winConfig = getCompatWindowConfiguration();
        Rect rect2 = this.mPendingBackDropFrame;
        if (this.mPendingDragResizing && !winConfig.useWindowFrameForBackdrop()) {
            rect = winConfig.getMaxBounds();
        } else {
            rect = frame;
        }
        rect2.set(rect);
        this.mPendingBackDropFrame.offsetTo(0, 0);
        InsetsController insetsController = this.mInsetsController;
        Rect rect3 = this.mOverrideInsetsFrame;
        if (rect3 == null) {
            rect3 = frame;
        }
        insetsController.onFrameChanged(rect3);
        this.mViewRootImplExt.setScrollToTopWinFrame(frame);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOverrideInsetsFrame(Rect frame) {
        Rect rect = new Rect(frame);
        this.mOverrideInsetsFrame = rect;
        this.mInsetsController.onFrameChanged(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getDisplayFrame(Rect outFrame) {
        outFrame.set(this.mTmpFrames.displayFrame);
        applyViewBoundsSandboxingIfNeeded(outFrame);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getWindowVisibleDisplayFrame(Rect outFrame) {
        outFrame.set(this.mTmpFrames.displayFrame);
        Rect insets = this.mAttachInfo.mVisibleInsets;
        outFrame.left += insets.left;
        outFrame.top += insets.top;
        outFrame.right -= insets.right;
        outFrame.bottom -= insets.bottom;
        applyViewBoundsSandboxingIfNeeded(outFrame);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyViewBoundsSandboxingIfNeeded(Rect inOutRect) {
        if (this.mViewBoundsSandboxingEnabled) {
            Rect bounds = getConfiguration().windowConfiguration.getBounds();
            inOutRect.offset(-bounds.left, -bounds.top);
        }
    }

    public void applyViewLocationSandboxingIfNeeded(int[] outLocation) {
        if (this.mViewBoundsSandboxingEnabled) {
            Rect bounds = getConfiguration().windowConfiguration.getBounds();
            outLocation[0] = outLocation[0] - bounds.left;
            outLocation[1] = outLocation[1] - bounds.top;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean getViewBoundsSandboxingEnabled() {
        /*
            r4 = this;
            boolean r0 = android.app.ActivityThread.isSystem()
            r1 = 0
            if (r0 != 0) goto L39
            r2 = 237531167(0xe28701f, double:1.173559894E-315)
            boolean r0 = android.app.compat.CompatChanges.isChangeEnabled(r2)
            if (r0 != 0) goto L11
            goto L39
        L11:
            r0 = 1
            android.content.Context r2 = r4.mContext     // Catch: java.lang.RuntimeException -> L37
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: java.lang.RuntimeException -> L37
            java.lang.String r3 = "android.window.PROPERTY_COMPAT_ALLOW_SANDBOXING_VIEW_BOUNDS_APIS"
            java.util.List r2 = r2.queryApplicationProperty(r3)     // Catch: java.lang.RuntimeException -> L37
            boolean r3 = r2.isEmpty()     // Catch: java.lang.RuntimeException -> L37
            if (r3 != 0) goto L32
            java.lang.Object r3 = r2.get(r1)     // Catch: java.lang.RuntimeException -> L37
            android.content.pm.PackageManager$Property r3 = (android.content.pm.PackageManager.Property) r3     // Catch: java.lang.RuntimeException -> L37
            boolean r3 = r3.getBoolean()     // Catch: java.lang.RuntimeException -> L37
            if (r3 != 0) goto L32
            r3 = r0
            goto L33
        L32:
            r3 = r1
        L33:
            if (r3 == 0) goto L36
            return r1
        L36:
            goto L38
        L37:
            r1 = move-exception
        L38:
            return r0
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.getViewBoundsSandboxingEnabled():boolean");
    }

    @Override // android.view.View.AttachInfo.Callbacks
    public void playSoundEffect(int effectId) {
        if ((this.mDisplay.getFlags() & 1024) != 0) {
            return;
        }
        checkThread();
        try {
            AudioManager audioManager = getAudioManager();
            if (this.mFastScrollSoundEffectsEnabled && SoundEffectConstants.isNavigationRepeat(effectId)) {
                audioManager.playSoundEffect(SoundEffectConstants.nextNavigationRepeatSoundEffectId());
                return;
            }
            switch (effectId) {
                case 0:
                    audioManager.playSoundEffect(0);
                    return;
                case 1:
                case 5:
                    audioManager.playSoundEffect(3);
                    return;
                case 2:
                case 6:
                    audioManager.playSoundEffect(1);
                    return;
                case 3:
                case 7:
                    audioManager.playSoundEffect(4);
                    return;
                case 4:
                case 8:
                    audioManager.playSoundEffect(2);
                    return;
                default:
                    throw new IllegalArgumentException("unknown effect id " + effectId + " not defined in " + SoundEffectConstants.class.getCanonicalName());
            }
        } catch (IllegalStateException e2) {
            Log.e(this.mTag, "FATAL EXCEPTION when attempting to play sound effect: " + ((Object) e2));
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.AttachInfo.Callbacks
    public boolean performHapticFeedback(int effectId, boolean always) {
        if ((this.mDisplay.getFlags() & 1024) != 0) {
            return false;
        }
        try {
            this.mWindowSession.performHapticFeedbackAsync(effectId, always);
            return true;
        } catch (RemoteException e2) {
            return false;
        }
    }

    @Override // android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        checkThread();
        if (!(this.mView instanceof ViewGroup)) {
            return null;
        }
        return FocusFinder.getInstance().findNextFocus((ViewGroup) this.mView, focused, direction);
    }

    @Override // android.view.ViewParent
    public View keyboardNavigationClusterSearch(View currentCluster, int direction) {
        checkThread();
        return FocusFinder.getInstance().findNextKeyboardNavigationCluster(this.mView, currentCluster, direction);
    }

    public void debug() {
        this.mView.debug();
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, Objects.toString(this.mView));
        proto.write(1120986464258L, this.mDisplay.getDisplayId());
        proto.write(1133871366147L, this.mAppVisible);
        proto.write(1120986464261L, this.mHeight);
        proto.write(1120986464260L, this.mWidth);
        proto.write(1133871366150L, this.mIsAnimating);
        this.mVisRect.dumpDebug(proto, 1146756268039L);
        proto.write(ViewRootImplProto.IS_DRAWING, this.mIsDrawing);
        proto.write(ViewRootImplProto.ADDED, this.mAdded);
        this.mWinFrame.dumpDebug(proto, 1146756268042L);
        proto.write(ViewRootImplProto.LAST_WINDOW_INSETS, Objects.toString(this.mLastWindowInsets));
        proto.write(ViewRootImplProto.SOFT_INPUT_MODE, InputMethodDebug.softInputModeToString(this.mSoftInputMode));
        proto.write(ViewRootImplProto.SCROLL_Y, this.mScrollY);
        proto.write(ViewRootImplProto.CUR_SCROLL_Y, this.mCurScrollY);
        proto.write(ViewRootImplProto.REMOVED, this.mRemoved);
        this.mWindowAttributes.dumpDebug(proto, ViewRootImplProto.WINDOW_ATTRIBUTES);
        proto.end(token);
        this.mInsetsController.dumpDebug(proto, 1146756268036L);
        this.mImeFocusController.dumpDebug(proto, 1146756268039L);
    }

    public void dump(String prefix, PrintWriter writer) {
        String innerPrefix = prefix + "  ";
        writer.println(prefix + "ViewRoot:");
        writer.println(innerPrefix + "mAdded=" + this.mAdded);
        writer.println(innerPrefix + "mRemoved=" + this.mRemoved);
        writer.println(innerPrefix + "mStopped=" + this.mStopped);
        writer.println(innerPrefix + "mPausedForTransition=" + this.mPausedForTransition);
        writer.println(innerPrefix + "mConsumeBatchedInputScheduled=" + this.mConsumeBatchedInputScheduled);
        writer.println(innerPrefix + "mConsumeBatchedInputImmediatelyScheduled=" + this.mConsumeBatchedInputImmediatelyScheduled);
        writer.println(innerPrefix + "mPendingInputEventCount=" + this.mPendingInputEventCount);
        writer.println(innerPrefix + "mProcessInputEventsScheduled=" + this.mProcessInputEventsScheduled);
        writer.println(innerPrefix + "mTraversalScheduled=" + this.mTraversalScheduled);
        if (this.mTraversalScheduled) {
            writer.println(innerPrefix + " (barrier=" + this.mTraversalBarrier + ")");
        }
        writer.println(innerPrefix + "mReportNextDraw=" + this.mReportNextDraw);
        if (this.mReportNextDraw) {
            writer.println(innerPrefix + " (reason=" + this.mLastReportNextDrawReason + ")");
        }
        if (this.mLastPerformTraversalsSkipDrawReason != null) {
            writer.println(innerPrefix + "mLastPerformTraversalsFailedReason=" + this.mLastPerformTraversalsSkipDrawReason);
        }
        if (this.mLastPerformDrawSkippedReason != null) {
            writer.println(innerPrefix + "mLastPerformDrawFailedReason=" + this.mLastPerformDrawSkippedReason);
        }
        if (this.mLastDisplaySource != null) {
            writer.println(innerPrefix + "mLastDisplaySource=" + this.mLastDisplaySource);
        }
        if (this.mLastDisplayStateSource != null) {
            writer.println(innerPrefix + "mLastDisplayStateSource=" + this.mLastDisplayStateSource);
        }
        if (this.mLastDisplayCallEvent != null) {
            writer.println(innerPrefix + "mLastDisplayCallEvent=" + this.mLastDisplayCallEvent);
        }
        if (this.mLastDisplayListenerState != null) {
            writer.println(innerPrefix + "mLastDisplayListenerState=" + this.mLastDisplayListenerState);
        }
        if (this.mWmsRequestSyncGroupState != 0) {
            writer.println(innerPrefix + "mWmsRequestSyncGroupState=" + this.mWmsRequestSyncGroupState);
        }
        writer.println(innerPrefix + "mLastReportedMergedConfiguration=" + ((Object) this.mLastReportedMergedConfiguration));
        writer.println(innerPrefix + "mLastConfigurationFromResources=" + ((Object) this.mLastConfigurationFromResources));
        this.mViewRootImplExt.dump(innerPrefix, writer);
        writer.println(innerPrefix + "mIsAmbientMode=" + this.mIsAmbientMode);
        writer.println(innerPrefix + "mUnbufferedInputSource=" + Integer.toHexString(this.mUnbufferedInputSource));
        if (this.mAttachInfo != null) {
            writer.print(innerPrefix + "mAttachInfo= ");
            this.mAttachInfo.dump(innerPrefix, writer);
        } else {
            writer.println(innerPrefix + "mAttachInfo=<null>");
        }
        this.mFirstInputStage.dump(innerPrefix, writer);
        WindowInputEventReceiver windowInputEventReceiver = this.mInputEventReceiver;
        if (windowInputEventReceiver != null) {
            windowInputEventReceiver.dump(innerPrefix, writer);
        }
        this.mChoreographer.dump(prefix, writer);
        this.mInsetsController.dump(prefix, writer);
        this.mOnBackInvokedDispatcher.dump(prefix, writer);
        writer.println(prefix + "View Hierarchy:");
        dumpViewHierarchy(innerPrefix, writer, this.mView);
    }

    private void dumpViewHierarchy(String prefix, PrintWriter writer, View view) {
        ViewGroup grp;
        int N;
        writer.print(prefix);
        if (view == null) {
            writer.println("null");
            return;
        }
        writer.println(view.toString());
        if (!(view instanceof ViewGroup) || (N = (grp = (ViewGroup) view).getChildCount()) <= 0) {
            return;
        }
        String prefix2 = prefix + "  ";
        for (int i10 = 0; i10 < N; i10++) {
            dumpViewHierarchy(prefix2, writer, grp.getChildAt(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class GfxInfo {
        public long renderNodeMemoryAllocated;
        public long renderNodeMemoryUsage;
        public int viewCount;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void add(GfxInfo other) {
            this.viewCount += other.viewCount;
            this.renderNodeMemoryUsage += other.renderNodeMemoryUsage;
            this.renderNodeMemoryAllocated += other.renderNodeMemoryAllocated;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GfxInfo getGfxInfo() {
        GfxInfo info = new GfxInfo();
        View view = this.mView;
        if (view != null) {
            appendGfxInfo(view, info);
        }
        return info;
    }

    private static void computeRenderNodeUsage(RenderNode node, GfxInfo info) {
        if (node == null) {
            return;
        }
        info.renderNodeMemoryUsage += node.computeApproximateMemoryUsage();
        info.renderNodeMemoryAllocated += node.computeApproximateMemoryAllocated();
    }

    private static void appendGfxInfo(View view, GfxInfo info) {
        info.viewCount++;
        computeRenderNodeUsage(view.mRenderNode, info);
        computeRenderNodeUsage(view.mBackgroundRenderNode, info);
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
            for (int i10 = 0; i10 < count; i10++) {
                appendGfxInfo(group.getChildAt(i10), info);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean die(boolean immediate) {
        if (immediate && !this.mIsInTraversal) {
            doDie();
            return false;
        }
        if (!this.mIsDrawing) {
            destroyHardwareRenderer();
        } else {
            Log.e(this.mTag, "Attempting to destroy the window while drawing!\n  window=" + ((Object) this) + ", title=" + ((Object) this.mWindowAttributes.getTitle()));
        }
        this.mHandler.sendEmptyMessage(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDie() {
        checkThread();
        if (LOCAL_LOGV) {
            Log.v(this.mTag, "DIE in " + ((Object) this) + " of " + ((Object) this.mSurface));
        }
        synchronized (this) {
            if (this.mRemoved) {
                return;
            }
            this.mViewRootImplExt.onWindowDying();
            this.mRemoved = true;
            this.mViewRootImplExt.doDie();
            this.mOnBackInvokedDispatcher.detachFromWindow();
            if (this.mAdded) {
                dispatchDetachedFromWindow();
            }
            if (this.mAdded && !this.mFirst) {
                destroyHardwareRenderer();
                View view = this.mView;
                if (view != null) {
                    int viewVisibility = view.getVisibility();
                    boolean viewVisibilityChanged = this.mViewVisibility != viewVisibility;
                    if (this.mWindowAttributesChanged || viewVisibilityChanged) {
                        try {
                            if ((1 & relayoutWindow(this.mWindowAttributes, viewVisibility, false)) != 0) {
                                this.mWindowSession.finishDrawing(this.mWindow, null, Integer.MAX_VALUE);
                            }
                        } catch (RemoteException e2) {
                        }
                    }
                    destroySurface();
                }
            }
            this.mInsetsController.onControlsChanged(null);
            this.mAdded = false;
            AnimationHandler.removeRequestor(this);
            SurfaceSyncGroup surfaceSyncGroup = this.mActiveSurfaceSyncGroup;
            if (surfaceSyncGroup != null) {
                surfaceSyncGroup.markSyncReady();
                this.mActiveSurfaceSyncGroup = null;
            }
            if (this.mHasPendingTransactions) {
                this.mPendingTransaction.apply();
            }
            WindowManagerGlobal.getInstance().doRemoveView(this);
        }
    }

    public void requestUpdateConfiguration(Configuration config) {
        Message msg = this.mHandler.obtainMessage(18, config);
        this.mHandler.sendMessage(msg);
    }

    public void loadSystemProperties() {
        this.mHandler.post(new Runnable() { // from class: android.view.ViewRootImpl.7
            @Override // java.lang.Runnable
            public void run() {
                ViewRootImpl.this.mProfileRendering = SystemProperties.getBoolean(ViewRootImpl.PROPERTY_PROFILE_RENDERING, false);
                ViewRootImpl viewRootImpl = ViewRootImpl.this;
                viewRootImpl.profileRendering(viewRootImpl.mAttachInfo.mHasWindowFocus);
                if (ViewRootImpl.this.mAttachInfo.mThreadedRenderer != null && ViewRootImpl.this.mAttachInfo.mThreadedRenderer.loadSystemProperties()) {
                    ViewRootImpl.this.invalidate();
                }
                boolean layout = ((Boolean) DisplayProperties.debug_layout().orElse(false)).booleanValue();
                if (layout != ViewRootImpl.this.mAttachInfo.mDebugLayout) {
                    ViewRootImpl.this.mAttachInfo.mDebugLayout = layout;
                    if (!ViewRootImpl.this.mHandler.hasMessages(22)) {
                        ViewRootImpl.this.mHandler.sendEmptyMessageDelayed(22, 200L);
                    }
                }
            }
        });
    }

    private void destroyHardwareRenderer() {
        ThreadedRenderer hardwareRenderer = this.mAttachInfo.mThreadedRenderer;
        Consumer<Display> consumer = this.mHdrSdrRatioChangedListener;
        if (consumer != null) {
            this.mDisplay.unregisterHdrSdrRatioChangedListener(consumer);
        }
        if (hardwareRenderer != null) {
            HardwareRendererObserver hardwareRendererObserver = this.mHardwareRendererObserver;
            if (hardwareRendererObserver != null) {
                hardwareRenderer.removeObserver(hardwareRendererObserver);
            }
            View view = this.mView;
            if (view != null) {
                hardwareRenderer.destroyHardwareResources(view);
            }
            hardwareRenderer.destroy();
            hardwareRenderer.setRequested(false);
            this.mAttachInfo.mThreadedRenderer = null;
            this.mAttachInfo.mHardwareAccelerated = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchResized(ClientWindowFrames clientWindowFrames, boolean z10, MergedConfiguration mergedConfiguration, InsetsState insetsState, boolean z11, boolean z12, int i10, int i11, boolean z13) {
        InsetsState insetsState2;
        Message obtainMessage = this.mHandler.obtainMessage(z10 ? 5 : 4);
        SomeArgs obtain = SomeArgs.obtain();
        boolean z14 = Binder.getCallingPid() == Process.myPid();
        if (!z14) {
            insetsState2 = insetsState;
        } else {
            insetsState2 = new InsetsState(insetsState, true);
        }
        CompatibilityInfo.Translator translator = this.mTranslator;
        if (translator != null) {
            translator.translateInsetsStateInScreenToAppWindow(insetsState2);
        }
        if (insetsState2.isSourceOrDefaultVisible(InsetsSource.ID_IME, WindowInsets.Type.ime())) {
            ImeTracing.getInstance().triggerClientDump("ViewRootImpl#dispatchResized", getInsetsController().getHost().getInputMethodManager(), null);
        }
        obtain.arg1 = z14 ? new ClientWindowFrames(clientWindowFrames) : clientWindowFrames;
        obtain.arg2 = (!z14 || mergedConfiguration == null) ? mergedConfiguration : new MergedConfiguration(mergedConfiguration);
        obtain.arg3 = insetsState2;
        obtain.argi1 = z11 ? 1 : 0;
        obtain.argi2 = z12 ? 1 : 0;
        obtain.argi3 = i10;
        obtain.argi4 = i11;
        obtain.argi5 = z13 ? 1 : 0;
        obtainMessage.obj = obtain;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchInsetsControlChanged(InsetsState insetsState, InsetsSourceControl[] activeControls) {
        if (Binder.getCallingPid() == Process.myPid()) {
            insetsState = new InsetsState(insetsState, true);
            if (activeControls != null) {
                for (int i10 = activeControls.length - 1; i10 >= 0; i10--) {
                    if (activeControls[i10] != null) {
                        activeControls[i10] = new InsetsSourceControl(activeControls[i10]);
                    }
                }
            }
        }
        CompatibilityInfo.Translator translator = this.mTranslator;
        if (translator != null) {
            translator.translateInsetsStateInScreenToAppWindow(insetsState);
            this.mTranslator.translateSourceControlsInScreenToAppWindow(activeControls);
        }
        if (insetsState != null && insetsState.isSourceOrDefaultVisible(InsetsSource.ID_IME, WindowInsets.Type.ime())) {
            ImeTracing.getInstance().triggerClientDump("ViewRootImpl#dispatchInsetsControlChanged", getInsetsController().getHost().getInputMethodManager(), null);
        }
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = insetsState;
        args.arg2 = activeControls;
        this.mHandler.obtainMessage(29, args).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInsets(int i10, boolean z10, ImeTracker.Token token) {
        this.mHandler.obtainMessage(31, i10, z10 ? 1 : 0, token).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInsets(int i10, boolean z10, ImeTracker.Token token) {
        this.mHandler.obtainMessage(32, i10, z10 ? 1 : 0, token).sendToTarget();
    }

    public void dispatchMoved(int newX, int newY) {
        if (DEBUG_LAYOUT) {
            Log.v(this.mTag, "Window moved " + ((Object) this) + ": newX=" + newX + " newY=" + newY);
        }
        if (this.mTranslator != null) {
            PointF point = new PointF(newX, newY);
            this.mTranslator.translatePointInScreenToAppWindow(point);
            newX = (int) (point.x + 0.5d);
            newY = (int) (point.y + 0.5d);
        }
        Message msg = this.mHandler.obtainMessage(23, newX, newY);
        this.mHandler.sendMessage(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class QueuedInputEvent {
        public static final int FLAG_DEFERRED = 2;
        public static final int FLAG_DELIVER_POST_IME = 1;
        public static final int FLAG_FINISHED = 4;
        public static final int FLAG_FINISHED_HANDLED = 8;
        public static final int FLAG_MODIFIED_FOR_COMPATIBILITY = 64;
        public static final int FLAG_RESYNTHESIZED = 16;
        public static final int FLAG_UNHANDLED = 32;
        public InputEvent mEvent;
        public int mFlags;
        public QueuedInputEvent mNext;
        public InputEventReceiver mReceiver;

        private QueuedInputEvent() {
        }

        public boolean shouldSkipIme() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            InputEvent inputEvent = this.mEvent;
            return (inputEvent instanceof MotionEvent) && (inputEvent.isFromSource(2) || this.mEvent.isFromSource(4194304));
        }

        public boolean shouldSendToSynthesizer() {
            if ((this.mFlags & 32) != 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("QueuedInputEvent{flags=");
            boolean hasPrevious = flagToString("DELIVER_POST_IME", 1, false, sb2);
            if (!flagToString("UNHANDLED", 32, flagToString("RESYNTHESIZED", 16, flagToString("FINISHED_HANDLED", 8, flagToString("FINISHED", 4, flagToString("DEFERRED", 2, hasPrevious, sb2), sb2), sb2), sb2), sb2)) {
                sb2.append("0");
            }
            sb2.append(", hasNextQueuedEvent=" + (this.mEvent != null ? "true" : "false"));
            sb2.append(", hasInputEventReceiver=" + (this.mReceiver == null ? "false" : "true"));
            sb2.append(", mEvent=" + ((Object) this.mEvent) + i.f4738d);
            return sb2.toString();
        }

        private boolean flagToString(String name, int flag, boolean hasPrevious, StringBuilder sb2) {
            if ((this.mFlags & flag) != 0) {
                if (hasPrevious) {
                    sb2.append("|");
                }
                sb2.append(name);
                return true;
            }
            return hasPrevious;
        }
    }

    private QueuedInputEvent obtainQueuedInputEvent(InputEvent event, InputEventReceiver receiver, int flags) {
        QueuedInputEvent q10 = this.mQueuedInputEventPool;
        if (q10 != null) {
            this.mQueuedInputEventPoolSize--;
            this.mQueuedInputEventPool = q10.mNext;
            q10.mNext = null;
        } else {
            q10 = new QueuedInputEvent();
        }
        q10.mEvent = event;
        q10.mReceiver = receiver;
        q10.mFlags = flags;
        return q10;
    }

    private void recycleQueuedInputEvent(QueuedInputEvent q10) {
        q10.mEvent = null;
        q10.mReceiver = null;
        int i10 = this.mQueuedInputEventPoolSize;
        if (i10 < 10) {
            this.mQueuedInputEventPoolSize = i10 + 1;
            q10.mNext = this.mQueuedInputEventPool;
            this.mQueuedInputEventPool = q10;
        }
    }

    public void enqueueInputEvent(InputEvent event) {
        enqueueInputEvent(event, null, 0, false);
    }

    void enqueueInputEvent(InputEvent event, InputEventReceiver receiver, int flags, boolean processImmediately) {
        QueuedInputEvent q10 = obtainQueuedInputEvent(event, receiver, flags);
        if (event instanceof MotionEvent) {
            MotionEvent me2 = (MotionEvent) event;
            if (me2.getAction() == 3) {
                EventLog.writeEvent(EventLogTags.VIEW_ENQUEUE_INPUT_EVENT, "Motion - Cancel", getTitle().toString());
            }
        } else if (event instanceof KeyEvent) {
            KeyEvent ke2 = (KeyEvent) event;
            if (ke2.isCanceled()) {
                EventLog.writeEvent(EventLogTags.VIEW_ENQUEUE_INPUT_EVENT, "Key - Cancel", getTitle().toString());
            }
        }
        QueuedInputEvent last = this.mPendingInputEventTail;
        if (last == null) {
            this.mPendingInputEventHead = q10;
            this.mPendingInputEventTail = q10;
        } else {
            last.mNext = q10;
            this.mPendingInputEventTail = q10;
        }
        int i10 = this.mPendingInputEventCount + 1;
        this.mPendingInputEventCount = i10;
        Trace.traceCounter(4L, this.mPendingInputEventQueueLengthCounterName, i10);
        this.mViewRootImplExt.debugInputEventEnqueue(this.mTag, event, processImmediately, this.mProcessInputEventsScheduled);
        if (processImmediately) {
            doProcessInputEvents();
        } else {
            scheduleProcessInputEvents();
        }
    }

    private void scheduleProcessInputEvents() {
        if (!this.mProcessInputEventsScheduled) {
            this.mProcessInputEventsScheduled = true;
            Message msg = this.mHandler.obtainMessage(19);
            msg.setAsynchronous(true);
            this.mHandler.sendMessage(msg);
        }
    }

    void doProcessInputEvents() {
        this.mViewRootImplSocExt.setBLASTBufferQueue(this.mBlastBufferQueue);
        while (this.mPendingInputEventHead != null) {
            QueuedInputEvent q10 = this.mPendingInputEventHead;
            QueuedInputEvent queuedInputEvent = q10.mNext;
            this.mPendingInputEventHead = queuedInputEvent;
            if (queuedInputEvent == null) {
                this.mPendingInputEventTail = null;
            }
            q10.mNext = null;
            int i10 = this.mPendingInputEventCount - 1;
            this.mPendingInputEventCount = i10;
            Trace.traceCounter(4L, this.mPendingInputEventQueueLengthCounterName, i10);
            this.mViewFrameInfo.setInputEvent(this.mInputEventAssigner.processEvent(q10.mEvent));
            this.mChoreographer.mChoreographerExt.handleInputEvent(q10.mEvent, this.mViewConfiguration.getScaledMaximumFlingVelocity(), this.mViewConfiguration.getScaledMinimumFlingVelocity());
            deliverInputEvent(q10);
        }
        if (this.mProcessInputEventsScheduled) {
            this.mProcessInputEventsScheduled = false;
            this.mHandler.removeMessages(19);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bb, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void deliverInputEvent(android.view.ViewRootImpl.QueuedInputEvent r6) {
        /*
            r5 = this;
            android.view.InputEvent r0 = r6.mEvent
            int r0 = r0.getId()
            r1 = 8
            java.lang.String r3 = "deliverInputEvent"
            android.os.Trace.asyncTraceBegin(r1, r3, r0)
            boolean r0 = android.os.Trace.isTagEnabled(r1)
            if (r0 == 0) goto L57
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "deliverInputEvent src=0x"
            java.lang.StringBuilder r0 = r0.append(r3)
            android.view.InputEvent r3 = r6.mEvent
            int r3 = r3.getSource()
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = " eventTimeNano="
            java.lang.StringBuilder r0 = r0.append(r3)
            android.view.InputEvent r3 = r6.mEvent
            long r3 = r3.getEventTimeNanos()
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = " id=0x"
            java.lang.StringBuilder r0 = r0.append(r3)
            android.view.InputEvent r3 = r6.mEvent
            int r3 = r3.getId()
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.os.Trace.traceBegin(r1, r0)
        L57:
            android.view.InputEventConsistencyVerifier r0 = r5.mInputEventConsistencyVerifier     // Catch: java.lang.Throwable -> Lb7
            if (r0 == 0) goto L73
            java.lang.String r0 = "verifyEventConsistency"
            android.os.Trace.traceBegin(r1, r0)     // Catch: java.lang.Throwable -> Lb7
            android.view.InputEventConsistencyVerifier r0 = r5.mInputEventConsistencyVerifier     // Catch: java.lang.Throwable -> L6d
            android.view.InputEvent r3 = r6.mEvent     // Catch: java.lang.Throwable -> L6d
            r4 = 0
            r0.onInputEvent(r3, r4)     // Catch: java.lang.Throwable -> L6d
            android.os.Trace.traceEnd(r1)     // Catch: java.lang.Throwable -> Lb7
            goto L73
        L6d:
            r0 = move-exception
            android.os.Trace.traceEnd(r1)     // Catch: java.lang.Throwable -> Lb7
            throw r0     // Catch: java.lang.Throwable -> Lb7
        L73:
            boolean r0 = r6.shouldSendToSynthesizer()     // Catch: java.lang.Throwable -> Lb7
            if (r0 == 0) goto L7c
            android.view.ViewRootImpl$InputStage r0 = r5.mSyntheticInputStage     // Catch: java.lang.Throwable -> Lb7
            goto L87
        L7c:
            boolean r0 = r6.shouldSkipIme()     // Catch: java.lang.Throwable -> Lb7
            if (r0 == 0) goto L85
            android.view.ViewRootImpl$InputStage r0 = r5.mFirstPostImeInputStage     // Catch: java.lang.Throwable -> Lb7
            goto L87
        L85:
            android.view.ViewRootImpl$InputStage r0 = r5.mFirstInputStage     // Catch: java.lang.Throwable -> Lb7
        L87:
            android.view.InputEvent r3 = r6.mEvent     // Catch: java.lang.Throwable -> Lb7
            boolean r3 = r3 instanceof android.view.KeyEvent     // Catch: java.lang.Throwable -> Lb7
            if (r3 == 0) goto La6
            java.lang.String r3 = "preDispatchToUnhandledKeyManager"
            android.os.Trace.traceBegin(r1, r3)     // Catch: java.lang.Throwable -> Lb7
            android.view.ViewRootImpl$UnhandledKeyManager r3 = r5.mUnhandledKeyManager     // Catch: java.lang.Throwable -> La0
            android.view.InputEvent r4 = r6.mEvent     // Catch: java.lang.Throwable -> La0
            android.view.KeyEvent r4 = (android.view.KeyEvent) r4     // Catch: java.lang.Throwable -> La0
            r3.preDispatch(r4)     // Catch: java.lang.Throwable -> La0
            android.os.Trace.traceEnd(r1)     // Catch: java.lang.Throwable -> Lb7
            goto La6
        La0:
            r3 = move-exception
            android.os.Trace.traceEnd(r1)     // Catch: java.lang.Throwable -> Lb7
            throw r3     // Catch: java.lang.Throwable -> Lb7
        La6:
            if (r0 == 0) goto Laf
            r5.handleWindowFocusChanged()     // Catch: java.lang.Throwable -> Lb7
            r0.deliver(r6)     // Catch: java.lang.Throwable -> Lb7
            goto Lb2
        Laf:
            r5.finishInputEvent(r6)     // Catch: java.lang.Throwable -> Lb7
        Lb2:
            android.os.Trace.traceEnd(r1)
            return
        Lb7:
            r0 = move-exception
            android.os.Trace.traceEnd(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewRootImpl.deliverInputEvent(android.view.ViewRootImpl$QueuedInputEvent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishInputEvent(QueuedInputEvent q10) {
        Trace.asyncTraceEnd(8L, "deliverInputEvent", q10.mEvent.getId());
        this.mViewRootImplExt.debugInputEventFinished(this.mTag, q10.mFlags, q10.mEvent);
        this.mViewRootImplExt.enableClickIfNeededWhenInputEventFinish(q10.mEvent);
        if (q10.mReceiver != null) {
            boolean handled = (q10.mFlags & 8) != 0;
            boolean modified = (q10.mFlags & 64) != 0;
            if (modified) {
                Trace.traceBegin(8L, "processInputEventBeforeFinish");
                try {
                    InputEvent processedEvent = this.mInputCompatProcessor.processInputEventBeforeFinish(q10.mEvent);
                    if (processedEvent != null) {
                        q10.mReceiver.finishInputEvent(processedEvent, handled);
                    }
                } finally {
                    Trace.traceEnd(8L);
                }
            } else {
                q10.mReceiver.finishInputEvent(q10.mEvent, handled);
            }
        } else {
            q10.mEvent.recycleIfNeededAfterDispatch();
        }
        recycleQueuedInputEvent(q10);
    }

    static boolean isTerminalInputEvent(InputEvent event) {
        if (event instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) event;
            return keyEvent.getAction() == 1;
        }
        MotionEvent motionEvent = (MotionEvent) event;
        int action = motionEvent.getAction();
        return action == 1 || action == 3 || action == 10;
    }

    void scheduleConsumeBatchedInput() {
        if (!this.mConsumeBatchedInputScheduled && !this.mConsumeBatchedInputImmediatelyScheduled) {
            this.mConsumeBatchedInputScheduled = true;
            this.mChoreographer.postCallback(0, this.mConsumedBatchedInputRunnable, null);
            if (this.mAttachInfo.mThreadedRenderer != null) {
                this.mAttachInfo.mThreadedRenderer.notifyCallbackPending();
            }
        }
    }

    void unscheduleConsumeBatchedInput() {
        if (this.mConsumeBatchedInputScheduled) {
            this.mConsumeBatchedInputScheduled = false;
            this.mChoreographer.removeCallbacks(0, this.mConsumedBatchedInputRunnable, null);
        }
    }

    void scheduleConsumeBatchedInputImmediately() {
        if (!this.mConsumeBatchedInputImmediatelyScheduled) {
            unscheduleConsumeBatchedInput();
            this.mConsumeBatchedInputImmediatelyScheduled = true;
            this.mHandler.post(this.mConsumeBatchedInputImmediatelyRunnable);
        }
    }

    boolean doConsumeBatchedInput(long frameTimeNanos) {
        boolean consumedBatches;
        WindowInputEventReceiver windowInputEventReceiver = this.mInputEventReceiver;
        if (windowInputEventReceiver != null) {
            consumedBatches = windowInputEventReceiver.consumeBatchedInputEvents(frameTimeNanos);
        } else {
            consumedBatches = false;
        }
        doProcessInputEvents();
        return consumedBatches;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class TraversalRunnable implements Runnable {
        TraversalRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewRootImpl.this.doTraversal();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class WindowInputEventReceiver extends InputEventReceiver {
        public WindowInputEventReceiver(InputChannel inputChannel, Looper looper) {
            super(inputChannel, looper);
        }

        @Override // android.view.InputEventReceiver
        public void onInputEvent(InputEvent event) {
            Trace.traceBegin(8L, "processInputEventForCompatibility");
            ViewRootImpl.this.mViewRootImplExt.debugInputEventStart(ViewRootImpl.this.mTag, event);
            ViewRootImpl.this.mViewRootImplExt.disableClickIfNeededWhenInputEventStart(event);
            try {
                ViewRootImpl.this.mViewRootImplExt.updateInputEventToInputMethod(event);
                ViewRootImpl.this.mViewRootImplExt.updateInputEventForBracketModeIfNeeded(ViewRootImpl.this.mView, event, this);
                List<InputEvent> processedEvents = ViewRootImpl.this.mInputCompatProcessor.processInputEventForCompatibility(event);
                Trace.traceEnd(8L);
                if (processedEvents == null) {
                    ViewRootImpl.this.enqueueInputEvent(event, this, 0, true);
                    return;
                }
                if (processedEvents.isEmpty()) {
                    finishInputEvent(event, true);
                    return;
                }
                for (int i10 = 0; i10 < processedEvents.size(); i10++) {
                    ViewRootImpl.this.enqueueInputEvent(processedEvents.get(i10), this, 64, true);
                }
            } catch (Throwable th) {
                Trace.traceEnd(8L);
                throw th;
            }
        }

        @Override // android.view.InputEventReceiver
        public void onBatchedInputEventPending(int source) {
            boolean unbuffered = ViewRootImpl.this.mUnbufferedInputDispatch || (ViewRootImpl.this.mUnbufferedInputSource & source) != 0;
            if (unbuffered) {
                if (ViewRootImpl.this.mConsumeBatchedInputScheduled) {
                    ViewRootImpl.this.unscheduleConsumeBatchedInput();
                }
                consumeBatchedInputEvents(-1L);
                return;
            }
            ViewRootImpl.this.scheduleConsumeBatchedInput();
        }

        @Override // android.view.InputEventReceiver
        public void onFocusEvent(boolean hasFocus) {
            Log.d(ViewRootImpl.this.mTag, "onFocusEvent " + hasFocus);
            ViewRootImpl.this.windowFocusChanged(hasFocus);
        }

        @Override // android.view.InputEventReceiver
        public void onTouchModeChanged(boolean inTouchMode) {
            ViewRootImpl.this.touchModeChanged(inTouchMode);
        }

        @Override // android.view.InputEventReceiver
        public void onPointerCaptureEvent(boolean pointerCaptureEnabled) {
            ViewRootImpl.this.dispatchPointerCaptureChanged(pointerCaptureEnabled);
        }

        @Override // android.view.InputEventReceiver
        public void onDragEvent(boolean isExiting, float x10, float y10) {
            DragEvent event = DragEvent.obtain(isExiting ? 6 : 2, x10, y10, 0.0f, 0.0f, null, null, null, null, null, false);
            ViewRootImpl.this.dispatchDragEvent(event);
        }

        @Override // android.view.InputEventReceiver
        public void dispose() {
            ViewRootImpl.this.unscheduleConsumeBatchedInput();
            super.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class InputMetricsListener implements HardwareRendererObserver.OnFrameMetricsAvailableListener {
        public long[] data = new long[23];

        InputMetricsListener() {
        }

        public void onFrameMetricsAvailable(int dropCountSinceLastInvocation) {
            long[] jArr = this.data;
            int inputEventId = (int) jArr[4];
            if (inputEventId == 0) {
                return;
            }
            long presentTime = jArr[21];
            if (presentTime <= 0) {
                return;
            }
            long gpuCompletedTime = jArr[19];
            if (ViewRootImpl.this.mInputEventReceiver == null) {
                return;
            }
            if (gpuCompletedTime >= presentTime) {
                double discrepancyMs = (gpuCompletedTime - presentTime) * 1.0E-6d;
                long vsyncId = this.data[1];
                Log.w(ViewRootImpl.TAG, "Not reporting timeline because gpuCompletedTime is " + discrepancyMs + "ms ahead of presentTime. FRAME_TIMELINE_VSYNC_ID=" + vsyncId + ", INPUT_EVENT_ID=" + inputEventId);
                return;
            }
            ViewRootImpl.this.mInputEventReceiver.reportTimeline(inputEventId, gpuCompletedTime, presentTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ConsumeBatchedInputRunnable implements Runnable {
        ConsumeBatchedInputRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewRootImpl.this.mConsumeBatchedInputScheduled = false;
            ViewRootImpl viewRootImpl = ViewRootImpl.this;
            if (viewRootImpl.doConsumeBatchedInput(viewRootImpl.mChoreographer.getFrameTimeNanos())) {
                ViewRootImpl.this.scheduleConsumeBatchedInput();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ConsumeBatchedInputImmediatelyRunnable implements Runnable {
        ConsumeBatchedInputImmediatelyRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewRootImpl.this.mConsumeBatchedInputImmediatelyScheduled = false;
            ViewRootImpl.this.doConsumeBatchedInput(-1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class InvalidateOnAnimationRunnable implements Runnable {
        private boolean mPosted;
        private View.AttachInfo.InvalidateInfo[] mTempViewRects;
        private View[] mTempViews;
        private final ArrayList<View> mViews = new ArrayList<>();
        private final ArrayList<View.AttachInfo.InvalidateInfo> mViewRects = new ArrayList<>();

        InvalidateOnAnimationRunnable() {
        }

        public void addView(View view) {
            synchronized (this) {
                this.mViews.add(view);
                postIfNeededLocked();
            }
            if (ViewRootImpl.this.mAttachInfo.mThreadedRenderer != null) {
                ViewRootImpl.this.mAttachInfo.mThreadedRenderer.notifyCallbackPending();
            }
        }

        public void addViewRect(View.AttachInfo.InvalidateInfo info) {
            synchronized (this) {
                this.mViewRects.add(info);
                postIfNeededLocked();
            }
            if (ViewRootImpl.this.mAttachInfo.mThreadedRenderer != null) {
                ViewRootImpl.this.mAttachInfo.mThreadedRenderer.notifyCallbackPending();
            }
        }

        public void removeView(View view) {
            synchronized (this) {
                this.mViews.remove(view);
                int i10 = this.mViewRects.size();
                while (true) {
                    int i11 = i10 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    View.AttachInfo.InvalidateInfo info = this.mViewRects.get(i11);
                    if (info.target == view) {
                        this.mViewRects.remove(i11);
                        info.recycle();
                    }
                    i10 = i11;
                }
                if (this.mPosted && this.mViews.isEmpty() && this.mViewRects.isEmpty()) {
                    ViewRootImpl.this.mChoreographer.removeCallbacks(1, this, null);
                    this.mPosted = false;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int viewCount;
            int viewRectCount;
            synchronized (this) {
                this.mPosted = false;
                viewCount = this.mViews.size();
                if (viewCount != 0) {
                    ArrayList<View> arrayList = this.mViews;
                    View[] viewArr = this.mTempViews;
                    if (viewArr == null) {
                        viewArr = new View[viewCount];
                    }
                    this.mTempViews = (View[]) arrayList.toArray(viewArr);
                    this.mViews.clear();
                }
                viewRectCount = this.mViewRects.size();
                if (viewRectCount != 0) {
                    ArrayList<View.AttachInfo.InvalidateInfo> arrayList2 = this.mViewRects;
                    View.AttachInfo.InvalidateInfo[] invalidateInfoArr = this.mTempViewRects;
                    if (invalidateInfoArr == null) {
                        invalidateInfoArr = new View.AttachInfo.InvalidateInfo[viewRectCount];
                    }
                    this.mTempViewRects = (View.AttachInfo.InvalidateInfo[]) arrayList2.toArray(invalidateInfoArr);
                    this.mViewRects.clear();
                }
            }
            for (int i10 = 0; i10 < viewCount; i10++) {
                this.mTempViews[i10].invalidate();
                this.mTempViews[i10] = null;
            }
            for (int i11 = 0; i11 < viewRectCount; i11++) {
                View.AttachInfo.InvalidateInfo info = this.mTempViewRects[i11];
                info.target.invalidate(info.left, info.top, info.right, info.bottom);
                info.recycle();
            }
        }

        private void postIfNeededLocked() {
            if (!this.mPosted) {
                ViewRootImpl.this.mChoreographer.postCallback(1, this, null);
                this.mPosted = true;
            }
        }
    }

    public void dispatchInvalidateDelayed(View view, long delayMilliseconds) {
        Message msg = this.mHandler.obtainMessage(1, view);
        this.mHandler.sendMessageDelayed(msg, delayMilliseconds);
    }

    public void dispatchInvalidateRectDelayed(View.AttachInfo.InvalidateInfo info, long delayMilliseconds) {
        Message msg = this.mHandler.obtainMessage(2, info);
        this.mHandler.sendMessageDelayed(msg, delayMilliseconds);
    }

    public void dispatchInvalidateOnAnimation(View view) {
        this.mInvalidateOnAnimationRunnable.addView(view);
    }

    public void dispatchInvalidateRectOnAnimation(View.AttachInfo.InvalidateInfo info) {
        this.mInvalidateOnAnimationRunnable.addViewRect(info);
    }

    public void cancelInvalidate(View view) {
        this.mHandler.removeMessages(1, view);
        this.mHandler.removeMessages(2, view);
        this.mInvalidateOnAnimationRunnable.removeView(view);
    }

    public void dispatchInputEvent(InputEvent event) {
        dispatchInputEvent(event, null);
    }

    public void dispatchInputEvent(InputEvent event, InputEventReceiver receiver) {
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = event;
        args.arg2 = receiver;
        Message msg = this.mHandler.obtainMessage(7, args);
        msg.setAsynchronous(true);
        this.mHandler.sendMessage(msg);
    }

    public void synthesizeInputEvent(InputEvent event) {
        Message msg = this.mHandler.obtainMessage(24, event);
        msg.setAsynchronous(true);
        this.mHandler.sendMessage(msg);
    }

    public void dispatchKeyFromIme(KeyEvent event) {
        Message msg = this.mHandler.obtainMessage(11, event);
        msg.setAsynchronous(true);
        this.mHandler.sendMessage(msg);
    }

    public void dispatchKeyFromAutofill(KeyEvent event) {
        Message msg = this.mHandler.obtainMessage(12, event);
        msg.setAsynchronous(true);
        this.mHandler.sendMessage(msg);
    }

    public void dispatchUnhandledInputEvent(InputEvent event) {
        if (event instanceof MotionEvent) {
            event = MotionEvent.obtain((MotionEvent) event);
        }
        synthesizeInputEvent(event);
    }

    public void dispatchAppVisibility(boolean z10) {
        Log.d(this.mTag, "dispatchAppVisibility visible:" + z10);
        Message obtainMessage = this.mHandler.obtainMessage(8);
        obtainMessage.arg1 = z10 ? 1 : 0;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void dispatchGetNewSurface() {
        Message msg = this.mHandler.obtainMessage(9);
        this.mHandler.sendMessage(msg);
    }

    public void windowFocusChanged(boolean hasFocus) {
        this.mViewRootImplExt.checkKeyguardAndConfig(this.mTag);
        synchronized (this) {
            this.mWindowFocusChanged = true;
            this.mUpcomingWindowFocus = hasFocus;
        }
        Message msg = Message.obtain();
        msg.what = 6;
        this.mHandler.sendMessage(msg);
        this.mViewRootImplExt.markAndDumpWindowFocusChangeMsg(this.mTag, this.mHandler);
    }

    public void touchModeChanged(boolean inTouchMode) {
        synchronized (this) {
            this.mUpcomingInTouchMode = inTouchMode;
        }
        Message msg = Message.obtain();
        msg.what = 34;
        this.mHandler.sendMessage(msg);
    }

    public void dispatchWindowShown() {
        this.mHandler.sendEmptyMessage(25);
    }

    public void dispatchCloseSystemDialogs(String reason) {
        Message msg = Message.obtain();
        msg.what = 14;
        msg.obj = reason;
        this.mHandler.sendMessage(msg);
    }

    public void dispatchDragEvent(DragEvent event) {
        int what;
        if (event.getAction() == 2) {
            what = 16;
            this.mHandler.removeMessages(16);
        } else {
            what = 15;
        }
        Message msg = this.mHandler.obtainMessage(what, event);
        this.mHandler.sendMessage(msg);
    }

    public void updatePointerIcon(float x10, float y10) {
        this.mHandler.removeMessages(27);
        long now = SystemClock.uptimeMillis();
        MotionEvent event = MotionEvent.obtain(0L, now, 7, x10, y10, 0);
        Message msg = this.mHandler.obtainMessage(27, event);
        this.mHandler.sendMessage(msg);
    }

    public void dispatchCheckFocus() {
        if (!this.mHandler.hasMessages(13)) {
            this.mHandler.sendEmptyMessage(13);
        }
    }

    public void dispatchRequestKeyboardShortcuts(IResultReceiver receiver, int deviceId) {
        this.mHandler.obtainMessage(26, deviceId, 0, receiver).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPointerCaptureChanged(boolean z10) {
        this.mHandler.removeMessages(28);
        Message obtainMessage = this.mHandler.obtainMessage(28);
        obtainMessage.arg1 = z10 ? 1 : 0;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void postSendWindowContentChangedCallback(View source, int changeType) {
        if (this.mSendWindowContentChangedAccessibilityEvent == null) {
            this.mSendWindowContentChangedAccessibilityEvent = new SendWindowContentChangedAccessibilityEvent();
        }
        this.mSendWindowContentChangedAccessibilityEvent.runOrPost(source, changeType);
    }

    private void removeSendWindowContentChangedCallback() {
        SendWindowContentChangedAccessibilityEvent sendWindowContentChangedAccessibilityEvent = this.mSendWindowContentChangedAccessibilityEvent;
        if (sendWindowContentChangedAccessibilityEvent != null) {
            this.mHandler.removeCallbacks(sendWindowContentChangedAccessibilityEvent);
        }
    }

    public int getDirectAccessibilityConnectionId() {
        return this.mAccessibilityInteractionConnectionManager.ensureDirectConnection();
    }

    @Override // android.view.ViewParent
    public boolean showContextMenuForChild(View originalView) {
        return false;
    }

    @Override // android.view.ViewParent
    public boolean showContextMenuForChild(View originalView, float x10, float y10) {
        return false;
    }

    @Override // android.view.ViewParent
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewParent
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback, int type) {
        return null;
    }

    @Override // android.view.ViewParent
    public void createContextMenu(ContextMenu menu) {
    }

    @Override // android.view.ViewParent
    public void childDrawableStateChanged(View child) {
    }

    @Override // android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        AccessibilityNodeProvider provider;
        SendWindowContentChangedAccessibilityEvent sendWindowContentChangedAccessibilityEvent;
        if (this.mView == null || this.mStopped || this.mPausedForTransition) {
            return false;
        }
        if (event.getEventType() != 2048 && (sendWindowContentChangedAccessibilityEvent = this.mSendWindowContentChangedAccessibilityEvent) != null && sendWindowContentChangedAccessibilityEvent.mSource != null) {
            this.mSendWindowContentChangedAccessibilityEvent.removeCallbacksAndRun();
        }
        int eventType = event.getEventType();
        View source = getSourceForAccessibilityEvent(event);
        switch (eventType) {
            case 2048:
                handleWindowContentChangedEvent(event);
                break;
            case 32768:
                if (source != null && (provider = source.getAccessibilityNodeProvider()) != null) {
                    int virtualNodeId = AccessibilityNodeInfo.getVirtualDescendantId(event.getSourceNodeId());
                    AccessibilityNodeInfo node = provider.createAccessibilityNodeInfo(virtualNodeId);
                    setAccessibilityFocus(source, node);
                    break;
                }
                break;
            case 65536:
                if (source != null && source.getAccessibilityNodeProvider() != null) {
                    setAccessibilityFocus(null, null);
                    break;
                }
                break;
        }
        this.mAccessibilityManager.sendAccessibilityEvent(event);
        return true;
    }

    private View getSourceForAccessibilityEvent(AccessibilityEvent event) {
        long sourceNodeId = event.getSourceNodeId();
        int accessibilityViewId = AccessibilityNodeInfo.getAccessibilityViewId(sourceNodeId);
        return AccessibilityNodeIdManager.getInstance().findView(accessibilityViewId);
    }

    private void handleWindowContentChangedEvent(AccessibilityEvent event) {
        View focusedHost = this.mAccessibilityFocusedHost;
        if (focusedHost == null || this.mAccessibilityFocusedVirtualView == null) {
            return;
        }
        AccessibilityNodeProvider provider = focusedHost.getAccessibilityNodeProvider();
        if (provider == null) {
            this.mAccessibilityFocusedHost = null;
            this.mAccessibilityFocusedVirtualView = null;
            focusedHost.clearAccessibilityFocusNoCallbacks(0);
            return;
        }
        int changes = event.getContentChangeTypes();
        if ((changes & 1) == 0 && changes != 0) {
            return;
        }
        long eventSourceNodeId = event.getSourceNodeId();
        int changedViewId = AccessibilityNodeInfo.getAccessibilityViewId(eventSourceNodeId);
        boolean hostInSubtree = false;
        View root = this.mAccessibilityFocusedHost;
        while (root != null && !hostInSubtree) {
            if (changedViewId == root.getAccessibilityViewId()) {
                hostInSubtree = true;
            } else {
                Object parent = root.getParent();
                if (parent instanceof View) {
                    root = (View) parent;
                } else {
                    root = null;
                }
            }
        }
        if (!hostInSubtree) {
            return;
        }
        long focusedSourceNodeId = this.mAccessibilityFocusedVirtualView.getSourceNodeId();
        int focusedChildId = AccessibilityNodeInfo.getVirtualDescendantId(focusedSourceNodeId);
        Rect oldBounds = this.mTempRect;
        this.mAccessibilityFocusedVirtualView.getBoundsInScreen(oldBounds);
        AccessibilityNodeInfo createAccessibilityNodeInfo = provider.createAccessibilityNodeInfo(focusedChildId);
        this.mAccessibilityFocusedVirtualView = createAccessibilityNodeInfo;
        if (createAccessibilityNodeInfo == null) {
            this.mAccessibilityFocusedHost = null;
            focusedHost.clearAccessibilityFocusNoCallbacks(0);
            provider.performAction(focusedChildId, AccessibilityNodeInfo.AccessibilityAction.ACTION_CLEAR_ACCESSIBILITY_FOCUS.getId(), null);
            invalidateRectOnScreen(oldBounds);
            return;
        }
        Rect newBounds = createAccessibilityNodeInfo.getBoundsInScreen();
        if (!oldBounds.equals(newBounds)) {
            oldBounds.union(newBounds);
            invalidateRectOnScreen(oldBounds);
        }
    }

    @Override // android.view.ViewParent
    public void notifySubtreeAccessibilityStateChanged(View child, View source, int changeType) {
        postSendWindowContentChangedCallback((View) Preconditions.checkNotNull(source), changeType);
    }

    @Override // android.view.ViewParent
    public boolean canResolveLayoutDirection() {
        return true;
    }

    @Override // android.view.ViewParent
    public boolean isLayoutDirectionResolved() {
        return true;
    }

    @Override // android.view.ViewParent
    public int getLayoutDirection() {
        return 0;
    }

    @Override // android.view.ViewParent
    public boolean canResolveTextDirection() {
        return true;
    }

    @Override // android.view.ViewParent
    public boolean isTextDirectionResolved() {
        return true;
    }

    @Override // android.view.ViewParent
    public int getTextDirection() {
        return 1;
    }

    @Override // android.view.ViewParent
    public boolean canResolveTextAlignment() {
        return true;
    }

    @Override // android.view.ViewParent
    public boolean isTextAlignmentResolved() {
        return true;
    }

    @Override // android.view.ViewParent
    public int getTextAlignment() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getCommonPredecessor(View first, View second) {
        if (this.mTempHashSet == null) {
            this.mTempHashSet = new HashSet<>();
        }
        HashSet<View> seen = this.mTempHashSet;
        seen.clear();
        View firstCurrent = first;
        while (firstCurrent != null) {
            seen.add(firstCurrent);
            Object obj = firstCurrent.mParent;
            if (obj instanceof View) {
                firstCurrent = (View) obj;
            } else {
                firstCurrent = null;
            }
        }
        View secondCurrent = second;
        while (secondCurrent != null) {
            if (seen.contains(secondCurrent)) {
                seen.clear();
                return secondCurrent;
            }
            Object obj2 = secondCurrent.mParent;
            if (obj2 instanceof View) {
                secondCurrent = (View) obj2;
            } else {
                secondCurrent = null;
            }
        }
        seen.clear();
        return null;
    }

    void checkThread() {
        Thread current = Thread.currentThread();
        if (this.mThread != current) {
            throw new CalledFromWrongThreadException("Only the original thread that created a view hierarchy can touch its views. Expected: " + this.mThread.getName() + " Calling: " + current.getName());
        }
    }

    @Override // android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    @Override // android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        if (rectangle == null) {
            return scrollToRectOrFocus(null, immediate);
        }
        rectangle.offset(child.getLeft() - child.getScrollX(), child.getTop() - child.getScrollY());
        boolean scrolled = scrollToRectOrFocus(rectangle, immediate);
        this.mTempRect.set(rectangle);
        this.mTempRect.offset(0, -this.mCurScrollY);
        this.mTempRect.offset(this.mAttachInfo.mWindowLeft, this.mAttachInfo.mWindowTop);
        try {
            this.mWindowSession.onRectangleOnScreenRequested(this.mWindow, this.mTempRect);
        } catch (RemoteException e2) {
        }
        return scrolled;
    }

    @Override // android.view.ViewParent
    public void childHasTransientStateChanged(View child, boolean hasTransientState) {
    }

    @Override // android.view.ViewParent
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return false;
    }

    @Override // android.view.ViewParent
    public void onStopNestedScroll(View target) {
    }

    @Override // android.view.ViewParent
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
    }

    @Override // android.view.ViewParent
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
    }

    @Override // android.view.ViewParent
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
    }

    @Override // android.view.ViewParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override // android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override // android.view.ViewParent
    public boolean onNestedPrePerformAccessibilityAction(View target, int action, Bundle args) {
        return false;
    }

    public void addScrollCaptureCallback(ScrollCaptureCallback callback) {
        if (this.mRootScrollCaptureCallbacks == null) {
            this.mRootScrollCaptureCallbacks = new HashSet<>();
        }
        this.mRootScrollCaptureCallbacks.add(callback);
    }

    public void removeScrollCaptureCallback(ScrollCaptureCallback callback) {
        HashSet<ScrollCaptureCallback> hashSet = this.mRootScrollCaptureCallbacks;
        if (hashSet != null) {
            hashSet.remove(callback);
            if (this.mRootScrollCaptureCallbacks.isEmpty()) {
                this.mRootScrollCaptureCallbacks = null;
            }
        }
    }

    public void dispatchScrollCaptureRequest(IScrollCaptureResponseListener listener) {
        this.mHandler.obtainMessage(33, listener).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collectRootScrollCaptureTargets(ScrollCaptureSearchResults results) {
        HashSet<ScrollCaptureCallback> hashSet = this.mRootScrollCaptureCallbacks;
        if (hashSet == null) {
            return;
        }
        Iterator<ScrollCaptureCallback> iterator2 = hashSet.iterator2();
        while (iterator2.hasNext()) {
            ScrollCaptureCallback cb2 = iterator2.next();
            Point offset = new Point(this.mView.getLeft(), this.mView.getTop());
            Rect rect = new Rect(0, 0, this.mView.getWidth(), this.mView.getHeight());
            results.addTarget(new ScrollCaptureTarget(this.mView, rect, offset, cb2));
        }
    }

    public void setScrollCaptureRequestTimeout(int timeMillis) {
        this.mScrollCaptureRequestTimeout = timeMillis;
    }

    public long getScrollCaptureRequestTimeout() {
        return this.mScrollCaptureRequestTimeout;
    }

    public void handleScrollCaptureRequest(final IScrollCaptureResponseListener listener) {
        final ScrollCaptureSearchResults results = new ScrollCaptureSearchResults(this.mContext.getMainExecutor());
        collectRootScrollCaptureTargets(results);
        View rootView = getView();
        if (rootView != null) {
            Point point = new Point();
            Rect rect = new Rect(0, 0, rootView.getWidth(), rootView.getHeight());
            getChildVisibleRect(rootView, rect, point);
            Objects.requireNonNull(results);
            rootView.dispatchScrollCaptureSearch(rect, point, new Consumer() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ScrollCaptureSearchResults.this.addTarget((ScrollCaptureTarget) obj);
                }
            });
        }
        Runnable onComplete = new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                ViewRootImpl.this.lambda$handleScrollCaptureRequest$10(listener, results);
            }
        };
        results.setOnCompleteListener(onComplete);
        if (!results.isComplete()) {
            ViewRootHandler viewRootHandler = this.mHandler;
            Objects.requireNonNull(results);
            viewRootHandler.postDelayed(new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    ScrollCaptureSearchResults.this.finish();
                }
            }, getScrollCaptureRequestTimeout());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dispatchScrollCaptureSearchResponse, reason: merged with bridge method [inline-methods] */
    public void lambda$handleScrollCaptureRequest$10(IScrollCaptureResponseListener listener, ScrollCaptureSearchResults results) {
        ScrollCaptureTarget selectedTarget = results.getTopResult();
        ScrollCaptureResponse.Builder response = new ScrollCaptureResponse.Builder();
        response.setWindowTitle(getTitle().toString());
        response.setPackageName(this.mContext.getPackageName());
        StringWriter writer = new StringWriter();
        IndentingPrintWriter pw = new IndentingPrintWriter(writer);
        results.dump(pw);
        pw.flush();
        response.addMessage(writer.toString());
        if (selectedTarget == null) {
            response.setDescription("No scrollable targets found in window");
            try {
                listener.onScrollCaptureResponse(response.build());
                return;
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to send scroll capture search result", e2);
                return;
            }
        }
        response.setDescription("Connected");
        Rect boundsInWindow = new Rect();
        View containingView = selectedTarget.getContainingView();
        containingView.getLocationInWindow(this.mAttachInfo.mTmpLocation);
        boundsInWindow.set(selectedTarget.getScrollBounds());
        boundsInWindow.offset(this.mAttachInfo.mTmpLocation[0], this.mAttachInfo.mTmpLocation[1]);
        response.setBoundsInWindow(boundsInWindow);
        Rect boundsOnScreen = new Rect();
        this.mView.getLocationOnScreen(this.mAttachInfo.mTmpLocation);
        boundsOnScreen.set(0, 0, this.mView.getWidth(), this.mView.getHeight());
        boundsOnScreen.offset(this.mAttachInfo.mTmpLocation[0], this.mAttachInfo.mTmpLocation[1]);
        response.setWindowBounds(boundsOnScreen);
        ScrollCaptureConnection connection = new ScrollCaptureConnection(this.mView.getContext().getMainExecutor(), selectedTarget);
        response.setConnection(connection);
        try {
            listener.onScrollCaptureResponse(response.build());
        } catch (RemoteException e10) {
            if (DEBUG_SCROLL_CAPTURE) {
                Log.w(TAG, "Failed to send scroll capture search response.", e10);
            }
            connection.close();
        }
    }

    private void reportNextDraw(String reason) {
        if (DEBUG_BLAST) {
            Log.d(this.mTag, "reportNextDraw " + Debug.getCallers(5));
        }
        this.mReportNextDraw = true;
        this.mLastReportNextDrawReason = reason;
    }

    public void setReportNextDraw(boolean syncBuffer, String reason) {
        this.mSyncBuffer = syncBuffer;
        reportNextDraw(reason);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeCanvasOpacity(boolean opaque) {
        Log.d(this.mTag, "changeCanvasOpacity: opaque=" + opaque);
        boolean opaque2 = opaque & ((this.mView.mPrivateFlags & 512) == 0);
        if (this.mAttachInfo.mThreadedRenderer != null) {
            this.mAttachInfo.mThreadedRenderer.setOpaque(opaque2);
        }
    }

    public boolean dispatchUnhandledKeyEvent(KeyEvent event) {
        return this.mUnhandledKeyManager.dispatch(this.mView, event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class TakenSurfaceHolder extends BaseSurfaceHolder {
        TakenSurfaceHolder() {
        }

        public boolean onAllowLockCanvas() {
            return ViewRootImpl.this.mDrawingAllowed;
        }

        public void onRelayoutContainer() {
        }

        public void setFormat(int format) {
            ViewRootImpl.this.mView.setSurfaceFormat(format);
        }

        public void setType(int type) {
            ViewRootImpl.this.mView.setSurfaceType(type);
        }

        public void onUpdateSurface() {
            throw new IllegalStateException("Shouldn't be here");
        }

        public boolean isCreating() {
            return ViewRootImpl.this.mIsCreating;
        }

        public void setFixedSize(int width, int height) {
            throw new UnsupportedOperationException("Currently only support sizing from layout");
        }

        public void setKeepScreenOn(boolean screenOn) {
            ViewRootImpl.this.mView.setSurfaceKeepScreenOn(screenOn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class W extends IWindow.Stub {
        final WeakReference<ViewRootImpl> mViewAncestor;
        private final IWindowSession mWindowSession;

        W(ViewRootImpl viewAncestor) {
            this.mViewAncestor = new WeakReference<>(viewAncestor);
            this.mWindowSession = viewAncestor.mWindowSession;
        }

        @Override // android.view.IWindow
        public void resized(ClientWindowFrames frames, boolean reportDraw, MergedConfiguration mergedConfiguration, InsetsState insetsState, boolean forceLayout, boolean alwaysConsumeSystemBars, int displayId, int syncSeqId, boolean dragResizing) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchResized(frames, reportDraw, mergedConfiguration, insetsState, forceLayout, alwaysConsumeSystemBars, displayId, syncSeqId, dragResizing);
            }
        }

        @Override // android.view.IWindow
        public void insetsControlChanged(InsetsState insetsState, InsetsSourceControl[] activeControls) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchInsetsControlChanged(insetsState, activeControls);
            }
        }

        @Override // android.view.IWindow
        public void showInsets(int types, boolean fromIme, ImeTracker.Token statsToken) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (fromIme) {
                ImeTracing.getInstance().triggerClientDump("ViewRootImpl.W#showInsets", viewAncestor.getInsetsController().getHost().getInputMethodManager(), null);
            }
            if (viewAncestor != null) {
                ImeTracker.forLogging().onProgress(statsToken, 28);
                viewAncestor.showInsets(types, fromIme, statsToken);
            } else {
                ImeTracker.forLogging().onFailed(statsToken, 28);
            }
        }

        @Override // android.view.IWindow
        public void hideInsets(int types, boolean fromIme, ImeTracker.Token statsToken) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (fromIme) {
                ImeTracing.getInstance().triggerClientDump("ViewRootImpl.W#hideInsets", viewAncestor.getInsetsController().getHost().getInputMethodManager(), null);
            }
            if (viewAncestor != null) {
                ImeTracker.forLogging().onProgress(statsToken, 29);
                viewAncestor.hideInsets(types, fromIme, statsToken);
            } else {
                ImeTracker.forLogging().onFailed(statsToken, 29);
            }
        }

        @Override // android.view.IWindow
        public void moved(int newX, int newY) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchMoved(newX, newY);
            }
        }

        @Override // android.view.IWindow
        public void dispatchAppVisibility(boolean visible) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchAppVisibility(visible);
            }
        }

        @Override // android.view.IWindow
        public void dispatchGetNewSurface() {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchGetNewSurface();
            }
        }

        @Override // android.view.IWindow
        public void dispatchBlackScreenKeyEvent(KeyEvent event) {
            View view;
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null && (view = viewAncestor.mView) != null) {
                view.dispatchKeyEvent(event);
            }
        }

        private static int checkCallingPermission(String permission) {
            try {
                return ActivityManager.getService().checkPermission(permission, Binder.getCallingPid(), Binder.getCallingUid());
            } catch (RemoteException e2) {
                return -1;
            }
        }

        @Override // android.view.IWindow
        public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
            View view;
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null && (view = viewAncestor.mView) != null) {
                if (checkCallingPermission("android.permission.DUMP") != 0) {
                    throw new SecurityException("Insufficient permissions to invoke executeCommand() from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
                }
                OutputStream clientStream = null;
                try {
                    try {
                        try {
                            clientStream = new ParcelFileDescriptor.AutoCloseOutputStream(out);
                            ViewDebug.dispatchCommand(view, command, parameters, clientStream);
                            clientStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            if (clientStream != null) {
                                clientStream.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (clientStream != null) {
                            try {
                                clientStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
        }

        @Override // android.view.IWindow
        public void closeSystemDialogs(String reason) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchCloseSystemDialogs(reason);
            }
        }

        @Override // android.view.IWindow
        public void dispatchWallpaperOffsets(float x10, float y10, float xStep, float yStep, float zoom, boolean sync) {
            if (sync) {
                try {
                    this.mWindowSession.wallpaperOffsetsComplete(asBinder());
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.IWindow
        public void dispatchWallpaperCommand(String action, int x10, int y10, int z10, Bundle extras, boolean sync) {
            if (sync) {
                try {
                    this.mWindowSession.wallpaperCommandComplete(asBinder(), null);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.IWindow
        public void dispatchDragEvent(DragEvent event) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchDragEvent(event);
            }
        }

        @Override // android.view.IWindow
        public void updatePointerIcon(float x10, float y10) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.updatePointerIcon(x10, y10);
            }
        }

        @Override // android.view.IWindow
        public void dispatchWindowShown() {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchWindowShown();
            }
        }

        @Override // android.view.IWindow
        public void requestAppKeyboardShortcuts(IResultReceiver receiver, int deviceId) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchRequestKeyboardShortcuts(receiver, deviceId);
            }
        }

        @Override // android.view.IWindow
        public void requestScrollCapture(IScrollCaptureResponseListener listener) {
            ViewRootImpl viewAncestor = this.mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchScrollCaptureRequest(listener);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {
        public CalledFromWrongThreadException(String msg) {
            super(msg);
        }
    }

    static HandlerActionQueue getRunQueue() {
        ThreadLocal<HandlerActionQueue> threadLocal = sRunQueues;
        HandlerActionQueue rq = threadLocal.get();
        if (rq != null) {
            return rq;
        }
        HandlerActionQueue rq2 = new HandlerActionQueue();
        threadLocal.set(rq2);
        return rq2;
    }

    private void startDragResizing(Rect initialBounds, boolean fullscreen, Rect systemInsets, Rect stableInsets) {
        if (!this.mDragResizing) {
            this.mDragResizing = true;
            if (this.mUseMTRenderer) {
                for (int i10 = this.mWindowCallbacks.size() - 1; i10 >= 0; i10--) {
                    this.mWindowCallbacks.get(i10).onWindowDragResizeStart(initialBounds, fullscreen, systemInsets, stableInsets);
                }
            }
            this.mFullRedrawNeeded = true;
        }
    }

    private void endDragResizing() {
        if (this.mDragResizing) {
            this.mDragResizing = false;
            if (this.mUseMTRenderer) {
                for (int i10 = this.mWindowCallbacks.size() - 1; i10 >= 0; i10--) {
                    this.mWindowCallbacks.get(i10).onWindowDragResizeEnd();
                }
            }
            this.mFullRedrawNeeded = true;
        }
    }

    private boolean updateContentDrawBounds() {
        boolean updated = false;
        if (this.mUseMTRenderer) {
            for (int i10 = this.mWindowCallbacks.size() - 1; i10 >= 0; i10--) {
                updated |= this.mWindowCallbacks.get(i10).onContentDrawn(this.mWindowAttributes.surfaceInsets.left, this.mWindowAttributes.surfaceInsets.top, this.mWidth, this.mHeight);
            }
        }
        return updated | (this.mDragResizing && this.mReportNextDraw);
    }

    private void requestDrawWindow() {
        if (!this.mUseMTRenderer) {
            return;
        }
        if (this.mReportNextDraw) {
            this.mWindowDrawCountDown = new CountDownLatch(this.mWindowCallbacks.size());
        }
        for (int i10 = this.mWindowCallbacks.size() - 1; i10 >= 0; i10--) {
            this.mWindowCallbacks.get(i10).onRequestDraw(this.mReportNextDraw || this.mDragResizing);
        }
    }

    public SurfaceControl getSurfaceControl() {
        return this.mSurfaceControl;
    }

    public IBinder getInputToken() {
        WindowInputEventReceiver windowInputEventReceiver = this.mInputEventReceiver;
        if (windowInputEventReceiver == null) {
            return null;
        }
        return windowInputEventReceiver.getToken();
    }

    public IBinder getWindowToken() {
        return this.mAttachInfo.mWindowToken;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class AccessibilityInteractionConnectionManager implements AccessibilityManager.AccessibilityStateChangeListener {
        private int mDirectConnectionId = -1;

        AccessibilityInteractionConnectionManager() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean enabled) {
            if (enabled) {
                ensureConnection();
                ViewRootImpl.this.setAccessibilityWindowAttributesIfNeeded();
                try {
                    if (ViewRootImpl.this.mAttachInfo.mHasWindowFocus && ViewRootImpl.this.mView != null) {
                        ViewRootImpl.this.mView.sendAccessibilityEvent(32);
                        View focusedView = ViewRootImpl.this.mView.findFocus();
                        if (focusedView != null && focusedView != ViewRootImpl.this.mView) {
                            focusedView.sendAccessibilityEvent(8);
                        }
                    }
                    if (ViewRootImpl.this.mAttachInfo.mLeashedParentToken != null) {
                        ViewRootImpl.this.mAccessibilityManager.associateEmbeddedHierarchy(ViewRootImpl.this.mAttachInfo.mLeashedParentToken, ViewRootImpl.this.mLeashToken);
                        return;
                    }
                    return;
                } catch (NullPointerException e2) {
                    Slog.w(ViewRootImpl.TAG, "onAccessibilityStateChanged catch NullPointerException " + ((Object) e2));
                    return;
                }
            }
            ensureNoConnection();
            ViewRootImpl.this.mHandler.obtainMessage(21).sendToTarget();
        }

        public void ensureConnection() {
            boolean registered = ViewRootImpl.this.mAttachInfo.mAccessibilityWindowId != -1;
            if (!registered) {
                ViewRootImpl.this.mAttachInfo.mAccessibilityWindowId = ViewRootImpl.this.mAccessibilityManager.addAccessibilityInteractionConnection(ViewRootImpl.this.mWindow, ViewRootImpl.this.mLeashToken, ViewRootImpl.this.mContext.getPackageName(), new AccessibilityInteractionConnection(ViewRootImpl.this));
            }
        }

        public void ensureNoConnection() {
            boolean registered = ViewRootImpl.this.mAttachInfo.mAccessibilityWindowId != -1;
            if (registered) {
                ViewRootImpl.this.mAttachInfo.mAccessibilityWindowId = -1;
                ViewRootImpl.this.mAccessibilityWindowAttributes = null;
                ViewRootImpl.this.mAccessibilityManager.removeAccessibilityInteractionConnection(ViewRootImpl.this.mWindow);
            }
        }

        public int ensureDirectConnection() {
            if (this.mDirectConnectionId == -1) {
                this.mDirectConnectionId = AccessibilityInteractionClient.addDirectConnection(new AccessibilityInteractionConnection(ViewRootImpl.this), ViewRootImpl.this.mAccessibilityManager);
                ViewRootImpl.this.mAccessibilityManager.notifyAccessibilityStateChanged();
            }
            return this.mDirectConnectionId;
        }

        public void ensureNoDirectConnection() {
            int i10 = this.mDirectConnectionId;
            if (i10 != -1) {
                AccessibilityInteractionClient.removeConnection(i10);
                this.mDirectConnectionId = -1;
                ViewRootImpl.this.mAccessibilityManager.notifyAccessibilityStateChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class HighContrastTextManager implements AccessibilityManager.HighTextContrastChangeListener {
        HighContrastTextManager() {
            ThreadedRenderer.setHighContrastText(ViewRootImpl.this.mAccessibilityManager.isHighTextContrastEnabled());
        }

        @Override // android.view.accessibility.AccessibilityManager.HighTextContrastChangeListener
        public void onHighTextContrastStateChanged(boolean enabled) {
            ThreadedRenderer.setHighContrastText(enabled);
            ViewRootImpl.this.destroyHardwareResources();
            ViewRootImpl.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class AccessibilityInteractionConnection extends IAccessibilityInteractionConnection.Stub {
        private final WeakReference<ViewRootImpl> mViewRootImpl;

        AccessibilityInteractionConnection(ViewRootImpl viewRootImpl) {
            this.mViewRootImpl = new WeakReference<>(viewRootImpl);
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void findAccessibilityNodeInfoByAccessibilityId(long accessibilityNodeId, Region interactiveRegion, int interactionId, IAccessibilityInteractionConnectionCallback callback, int flags, int interrogatingPid, long interrogatingTid, MagnificationSpec spec, float[] matrix, Bundle args) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().findAccessibilityNodeInfoByAccessibilityIdClientThread(accessibilityNodeId, interactiveRegion, interactionId, callback, flags, interrogatingPid, interrogatingTid, spec, matrix, args);
            } else {
                try {
                    callback.setFindAccessibilityNodeInfosResult(null, interactionId);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void performAccessibilityAction(long accessibilityNodeId, int action, Bundle arguments, int interactionId, IAccessibilityInteractionConnectionCallback callback, int flags, int interrogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().performAccessibilityActionClientThread(accessibilityNodeId, action, arguments, interactionId, callback, flags, interrogatingPid, interrogatingTid);
            } else {
                try {
                    callback.setPerformAccessibilityActionResult(false, interactionId);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void findAccessibilityNodeInfosByViewId(long accessibilityNodeId, String viewId, Region interactiveRegion, int interactionId, IAccessibilityInteractionConnectionCallback callback, int flags, int interrogatingPid, long interrogatingTid, MagnificationSpec spec, float[] matrix) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().findAccessibilityNodeInfosByViewIdClientThread(accessibilityNodeId, viewId, interactiveRegion, interactionId, callback, flags, interrogatingPid, interrogatingTid, spec, matrix);
            } else {
                try {
                    callback.setFindAccessibilityNodeInfoResult(null, interactionId);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void findAccessibilityNodeInfosByText(long accessibilityNodeId, String text, Region interactiveRegion, int interactionId, IAccessibilityInteractionConnectionCallback callback, int flags, int interrogatingPid, long interrogatingTid, MagnificationSpec spec, float[] matrix) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().findAccessibilityNodeInfosByTextClientThread(accessibilityNodeId, text, interactiveRegion, interactionId, callback, flags, interrogatingPid, interrogatingTid, spec, matrix);
            } else {
                try {
                    callback.setFindAccessibilityNodeInfosResult(null, interactionId);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void findFocus(long accessibilityNodeId, int focusType, Region interactiveRegion, int interactionId, IAccessibilityInteractionConnectionCallback callback, int flags, int interrogatingPid, long interrogatingTid, MagnificationSpec spec, float[] matrix) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().findFocusClientThread(accessibilityNodeId, focusType, interactiveRegion, interactionId, callback, flags, interrogatingPid, interrogatingTid, spec, matrix);
            } else {
                try {
                    callback.setFindAccessibilityNodeInfoResult(null, interactionId);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void focusSearch(long accessibilityNodeId, int direction, Region interactiveRegion, int interactionId, IAccessibilityInteractionConnectionCallback callback, int flags, int interrogatingPid, long interrogatingTid, MagnificationSpec spec, float[] matrix) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().focusSearchClientThread(accessibilityNodeId, direction, interactiveRegion, interactionId, callback, flags, interrogatingPid, interrogatingTid, spec, matrix);
            } else {
                try {
                    callback.setFindAccessibilityNodeInfoResult(null, interactionId);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void clearAccessibilityFocus() {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().clearAccessibilityFocusClientThread();
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void notifyOutsideTouch() {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().notifyOutsideTouchClientThread();
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void takeScreenshotOfWindow(int interactionId, ScreenCapture.ScreenCaptureListener listener, IAccessibilityInteractionConnectionCallback callback) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null && viewRootImpl.mView != null) {
                viewRootImpl.getAccessibilityInteractionController().takeScreenshotOfWindowClientThread(interactionId, listener, callback);
            } else {
                try {
                    callback.sendTakeScreenshotOfWindowError(1, interactionId);
                } catch (RemoteException e2) {
                }
            }
        }

        @Override // android.view.accessibility.IAccessibilityInteractionConnection
        public void attachAccessibilityOverlayToWindow(SurfaceControl sc2) {
            ViewRootImpl viewRootImpl = this.mViewRootImpl.get();
            if (viewRootImpl != null) {
                viewRootImpl.getAccessibilityInteractionController().attachAccessibilityOverlayToWindowClientThread(sc2);
            }
        }
    }

    public IAccessibilityEmbeddedConnection getAccessibilityEmbeddedConnection() {
        if (this.mAccessibilityEmbeddedConnection == null) {
            this.mAccessibilityEmbeddedConnection = new AccessibilityEmbeddedConnection(this);
        }
        return this.mAccessibilityEmbeddedConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class SendWindowContentChangedAccessibilityEvent implements Runnable {
        public OptionalInt mAction;
        private int mChangeTypes;
        public long mLastEventTimeMillis;
        public StackTraceElement[] mOrigin;
        public View mSource;

        private SendWindowContentChangedAccessibilityEvent() {
            this.mChangeTypes = 0;
            this.mAction = OptionalInt.empty();
        }

        @Override // java.lang.Runnable
        public void run() {
            View source = this.mSource;
            this.mSource = null;
            if (source == null) {
                Log.e(ViewRootImpl.TAG, "Accessibility content change has no source");
                return;
            }
            if (AccessibilityManager.getInstance(ViewRootImpl.this.mContext).isEnabled()) {
                this.mLastEventTimeMillis = SystemClock.uptimeMillis();
                AccessibilityEvent event = AccessibilityEvent.obtain();
                event.setEventType(2048);
                event.setContentChangeTypes(this.mChangeTypes);
                if (this.mAction.isPresent()) {
                    event.setAction(this.mAction.getAsInt());
                }
                source.sendAccessibilityEventUnchecked(event);
            } else {
                this.mLastEventTimeMillis = 0L;
            }
            source.resetSubtreeAccessibilityStateChanged();
            this.mChangeTypes = 0;
            this.mAction = OptionalInt.empty();
        }

        public void runOrPost(View source, int changeType) {
            if (ViewRootImpl.this.mHandler.getLooper() != Looper.myLooper()) {
                CalledFromWrongThreadException e2 = new CalledFromWrongThreadException("Only the original thread that created a view hierarchy can touch its views.");
                Log.e(ViewRootImpl.TAG, "Accessibility content change on non-UI thread. Future Android versions will throw an exception.", e2);
                ViewRootImpl.this.mHandler.removeCallbacks(this);
                if (this.mSource != null) {
                    run();
                }
            }
            View view = this.mSource;
            if (view != null) {
                View predecessor = ViewRootImpl.this.getCommonPredecessor(view, source);
                if (predecessor != null) {
                    predecessor = predecessor.getSelfOrParentImportantForA11y();
                }
                this.mSource = predecessor != null ? predecessor : source;
                this.mChangeTypes |= changeType;
                int performingAction = ViewRootImpl.this.mAccessibilityManager.getPerformingAction();
                if (performingAction != 0) {
                    if (this.mAction.isEmpty()) {
                        this.mAction = OptionalInt.of(performingAction);
                        return;
                    } else {
                        if (this.mAction.getAsInt() != performingAction) {
                            this.mAction = OptionalInt.of(0);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.mSource = source;
            this.mChangeTypes = changeType;
            if (ViewRootImpl.this.mAccessibilityManager.getPerformingAction() != 0) {
                this.mAction = OptionalInt.of(ViewRootImpl.this.mAccessibilityManager.getPerformingAction());
            }
            long timeSinceLastMillis = SystemClock.uptimeMillis() - this.mLastEventTimeMillis;
            long minEventIntevalMillis = ViewConfiguration.getSendRecurringAccessibilityEventsInterval();
            if (timeSinceLastMillis >= minEventIntevalMillis) {
                removeCallbacksAndRun();
            } else {
                ViewRootImpl.this.mHandler.postDelayed(this, minEventIntevalMillis - timeSinceLastMillis);
            }
        }

        public void removeCallbacksAndRun() {
            ViewRootImpl.this.mHandler.removeCallbacks(this);
            run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class UnhandledKeyManager {
        private final SparseArray<WeakReference<View>> mCapturedKeys;
        private WeakReference<View> mCurrentReceiver;
        private boolean mDispatched;

        private UnhandledKeyManager() {
            this.mDispatched = true;
            this.mCapturedKeys = new SparseArray<>();
            this.mCurrentReceiver = null;
        }

        boolean dispatch(View root, KeyEvent event) {
            if (this.mDispatched) {
                return false;
            }
            try {
                Trace.traceBegin(8L, "UnhandledKeyEvent dispatch");
                this.mDispatched = true;
                View consumer = root.dispatchUnhandledKeyEvent(event);
                if (event.getAction() == 0) {
                    int keycode = event.getKeyCode();
                    if (consumer != null && !KeyEvent.isModifierKey(keycode)) {
                        this.mCapturedKeys.put(keycode, new WeakReference<>(consumer));
                    }
                }
                return consumer != null;
            } finally {
                Trace.traceEnd(8L);
            }
        }

        void preDispatch(KeyEvent event) {
            int idx;
            this.mCurrentReceiver = null;
            if (event.getAction() == 1 && (idx = this.mCapturedKeys.indexOfKey(event.getKeyCode())) >= 0) {
                this.mCurrentReceiver = this.mCapturedKeys.valueAt(idx);
                this.mCapturedKeys.removeAt(idx);
            }
        }

        boolean preViewDispatch(KeyEvent event) {
            this.mDispatched = false;
            if (this.mCurrentReceiver == null) {
                this.mCurrentReceiver = this.mCapturedKeys.get(event.getKeyCode());
            }
            WeakReference<View> weakReference = this.mCurrentReceiver;
            if (weakReference == null) {
                return false;
            }
            View target = weakReference.get();
            if (event.getAction() == 1) {
                this.mCurrentReceiver = null;
            }
            if (target != null && target.isAttachedToWindow()) {
                target.onUnhandledKeyEvent(event);
            }
            return true;
        }
    }

    public void setDisplayDecoration(boolean displayDecoration) {
        if (displayDecoration == this.mDisplayDecorationCached) {
            return;
        }
        this.mDisplayDecorationCached = displayDecoration;
        if (this.mSurfaceControl.isValid()) {
            updateDisplayDecoration();
        }
    }

    private void updateDisplayDecoration() {
        this.mTransaction.setDisplayDecoration(this.mSurfaceControl, this.mDisplayDecorationCached).apply();
    }

    public void dispatchBlurRegions(float[][] regionCopy, long frameNumber) {
        BLASTBufferQueue bLASTBufferQueue;
        SurfaceControl surfaceControl = getSurfaceControl();
        if (!surfaceControl.isValid()) {
            return;
        }
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        transaction.setBlurRegions(surfaceControl, regionCopy);
        if (useBLAST() && (bLASTBufferQueue = this.mBlastBufferQueue) != null) {
            bLASTBufferQueue.mergeWithNextTransaction(transaction, frameNumber);
        }
    }

    public BackgroundBlurDrawable createBackgroundBlurDrawable() {
        return this.mBlurRegionAggregator.createBackgroundBlurDrawable(this.mContext);
    }

    @Override // android.view.ViewParent
    public void onDescendantUnbufferedRequested() {
        this.mUnbufferedInputSource = this.mView.mUnbufferedInputSource;
    }

    void forceDisableBLAST() {
        this.mForceDisableBLAST = true;
    }

    boolean useBLAST() {
        return this.mUseBLASTAdapter && !this.mForceDisableBLAST;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSurfaceSequenceId() {
        return this.mSurfaceSequenceId;
    }

    public void mergeWithNextTransaction(SurfaceControl.Transaction t2, long frameNumber) {
        BLASTBufferQueue bLASTBufferQueue = this.mBlastBufferQueue;
        if (bLASTBufferQueue != null) {
            bLASTBufferQueue.mergeWithNextTransaction(t2, frameNumber);
        } else {
            t2.apply();
        }
    }

    @Override // android.view.AttachedSurfaceControl
    public SurfaceControl.Transaction buildReparentTransaction(SurfaceControl child) {
        if (this.mSurfaceControl.isValid()) {
            return new SurfaceControl.Transaction().reparent(child, getBoundsLayer());
        }
        return null;
    }

    @Override // android.view.AttachedSurfaceControl
    public boolean applyTransactionOnDraw(SurfaceControl.Transaction t2) {
        if (this.mRemoved || !isHardwareEnabled()) {
            t2.apply();
        } else {
            this.mPendingTransaction.merge(t2);
            this.mHasPendingTransactions = true;
            scheduleTraversals();
        }
        return true;
    }

    @Override // android.view.AttachedSurfaceControl
    public int getBufferTransformHint() {
        return this.mSurfaceControl.getTransformHint();
    }

    @Override // android.view.AttachedSurfaceControl
    public void addOnBufferTransformHintChangedListener(AttachedSurfaceControl.OnBufferTransformHintChangedListener listener) {
        Objects.requireNonNull(listener);
        if (this.mTransformHintListeners.contains(listener)) {
            throw new IllegalArgumentException("attempt to call addOnBufferTransformHintChangedListener() with a previously registered listener");
        }
        this.mTransformHintListeners.add(listener);
    }

    @Override // android.view.AttachedSurfaceControl
    public void removeOnBufferTransformHintChangedListener(AttachedSurfaceControl.OnBufferTransformHintChangedListener listener) {
        Objects.requireNonNull(listener);
        this.mTransformHintListeners.remove(listener);
    }

    private void dispatchTransformHintChanged(int hint) {
        if (this.mTransformHintListeners.isEmpty()) {
            return;
        }
        ArrayList<AttachedSurfaceControl.OnBufferTransformHintChangedListener> listeners = (ArrayList) this.mTransformHintListeners.clone();
        for (int i10 = 0; i10 < listeners.size(); i10++) {
            AttachedSurfaceControl.OnBufferTransformHintChangedListener listener = listeners.get(i10);
            listener.onBufferTransformHintChanged(hint);
        }
    }

    public void requestCompatCameraControl(boolean showControl, boolean transformationApplied, ICompatCameraControlCallback callback) {
        this.mActivityConfigCallback.requestCompatCameraControl(showControl, transformationApplied, callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean wasRelayoutRequested() {
        return this.mRelayoutRequested;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceWmRelayout() {
        this.mForceNextWindowRelayout = true;
        scheduleTraversals();
    }

    public WindowOnBackInvokedDispatcher getOnBackInvokedDispatcher() {
        return this.mOnBackInvokedDispatcher;
    }

    @Override // android.view.ViewParent
    public OnBackInvokedDispatcher findOnBackInvokedDispatcherForChild(View child, View requester) {
        return getOnBackInvokedDispatcher();
    }

    private void registerBackCallbackOnWindow() {
        this.mOnBackInvokedDispatcher.attachToWindow(this.mWindowSession, this.mWindow);
    }

    private void sendBackKeyEvent(int action) {
        long when = SystemClock.uptimeMillis();
        KeyEvent ev = new KeyEvent(when, when, action, 4, 0, 0, -1, 0, 72, 257);
        enqueueInputEvent(ev);
    }

    private void registerCompatOnBackInvokedCallback() {
        this.mCompatOnBackInvokedCallback = new CompatOnBackInvokedCallback() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda17
            @Override // android.window.CompatOnBackInvokedCallback, android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                ViewRootImpl.this.lambda$registerCompatOnBackInvokedCallback$11();
            }
        };
        if (this.mOnBackInvokedDispatcher.hasImeOnBackInvokedDispatcher()) {
            Log.d(TAG, "Skip registering CompatOnBackInvokedCallback on IME dispatcher");
        } else {
            this.mOnBackInvokedDispatcher.registerOnBackInvokedCallback(0, this.mCompatOnBackInvokedCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerCompatOnBackInvokedCallback$11() {
        sendBackKeyEvent(0);
        sendBackKeyEvent(1);
    }

    @Override // android.view.AttachedSurfaceControl
    public void setTouchableRegion(Region r10) {
        if (r10 != null) {
            this.mTouchableRegion = new Region(r10);
        } else {
            this.mTouchableRegion = null;
        }
        this.mLastGivenInsets.reset();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IWindowSession getWindowSession() {
        return this.mWindowSession;
    }

    private void registerCallbacksForSync(boolean syncBuffer, SurfaceSyncGroup surfaceSyncGroup) {
        if (!isHardwareEnabled()) {
            return;
        }
        if (DEBUG_BLAST) {
            Log.d(this.mTag, "registerCallbacksForSync syncBuffer=" + syncBuffer);
        }
        SurfaceControl.Transaction t2 = new SurfaceControl.Transaction();
        t2.merge(this.mPendingTransaction);
        this.mAttachInfo.mThreadedRenderer.registerRtFrameCallback(new AnonymousClass8(t2, surfaceSyncGroup, syncBuffer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: android.view.ViewRootImpl$8, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AnonymousClass8 implements HardwareRenderer.FrameDrawingCallback {
        final /* synthetic */ SurfaceSyncGroup val$surfaceSyncGroup;
        final /* synthetic */ boolean val$syncBuffer;
        final /* synthetic */ SurfaceControl.Transaction val$t;

        AnonymousClass8(SurfaceControl.Transaction transaction, SurfaceSyncGroup surfaceSyncGroup, boolean z10) {
            this.val$t = transaction;
            this.val$surfaceSyncGroup = surfaceSyncGroup;
            this.val$syncBuffer = z10;
        }

        public void onFrameDraw(long frame) {
        }

        public HardwareRenderer.FrameCommitCallback onFrameDraw(int syncResult, final long frame) {
            if (ViewRootImpl.DEBUG_BLAST) {
                Log.d(ViewRootImpl.this.mTag, "Received frameDrawingCallback syncResult=" + syncResult + " frameNum=" + frame + ".");
            }
            ViewRootImpl.this.mergeWithNextTransaction(this.val$t, frame);
            if ((syncResult & 6) != 0) {
                this.val$surfaceSyncGroup.addTransaction(ViewRootImpl.this.mBlastBufferQueue.gatherPendingTransactions(frame));
                this.val$surfaceSyncGroup.markSyncReady();
                return null;
            }
            if (ViewRootImpl.DEBUG_BLAST) {
                Log.d(ViewRootImpl.this.mTag, "Setting up sync and frameCommitCallback");
            }
            if (this.val$syncBuffer) {
                BLASTBufferQueue bLASTBufferQueue = ViewRootImpl.this.mBlastBufferQueue;
                final SurfaceSyncGroup surfaceSyncGroup = this.val$surfaceSyncGroup;
                boolean result = bLASTBufferQueue.syncNextTransaction(new Consumer() { // from class: android.view.ViewRootImpl$8$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ViewRootImpl.AnonymousClass8.lambda$onFrameDraw$0(SurfaceSyncGroup.this, (SurfaceControl.Transaction) obj);
                    }
                });
                if (!result) {
                    Log.w(ViewRootImpl.this.mTag, "Unable to syncNextTransaction. Possibly something else is trying to sync?");
                    this.val$surfaceSyncGroup.markSyncReady();
                }
            }
            final boolean z10 = this.val$syncBuffer;
            final SurfaceSyncGroup surfaceSyncGroup2 = this.val$surfaceSyncGroup;
            return new HardwareRenderer.FrameCommitCallback() { // from class: android.view.ViewRootImpl$8$$ExternalSyntheticLambda1
                public final void onFrameCommit(boolean z11) {
                    ViewRootImpl.AnonymousClass8.this.lambda$onFrameDraw$1(frame, z10, surfaceSyncGroup2, z11);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$onFrameDraw$0(SurfaceSyncGroup surfaceSyncGroup, SurfaceControl.Transaction transaction) {
            surfaceSyncGroup.addTransaction(transaction);
            surfaceSyncGroup.markSyncReady();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFrameDraw$1(long frame, boolean syncBuffer, SurfaceSyncGroup surfaceSyncGroup, boolean didProduceBuffer) {
            Log.d(ViewRootImpl.this.mTag, "Received frameCommittedCallback lastAttemptedDrawFrameNum=" + frame + " didProduceBuffer=" + didProduceBuffer + " syncBuffer=" + syncBuffer);
            ViewRootImpl.this.mViewRootImplSocExt.hookOnFrameDrawPerfHint();
            if (!didProduceBuffer) {
                ViewRootImpl.this.mBlastBufferQueue.clearSyncTransaction();
                surfaceSyncGroup.addTransaction(ViewRootImpl.this.mBlastBufferQueue.gatherPendingTransactions(frame));
                surfaceSyncGroup.markSyncReady();
            } else if (!syncBuffer) {
                surfaceSyncGroup.markSyncReady();
            }
        }
    }

    private void safeguardOverlappingSyncs(final SurfaceSyncGroup activeSurfaceSyncGroup) {
        final SurfaceSyncGroup safeguardSsg = new SurfaceSyncGroup("Safeguard-" + this.mTag);
        safeguardSsg.toggleTimeout(false);
        synchronized (this.mPreviousSyncSafeguardLock) {
            SurfaceSyncGroup surfaceSyncGroup = this.mPreviousSyncSafeguard;
            if (surfaceSyncGroup != null) {
                activeSurfaceSyncGroup.add(surfaceSyncGroup, (Runnable) null);
                activeSurfaceSyncGroup.toggleTimeout(false);
                this.mPreviousSyncSafeguard.addSyncCompleteCallback(this.mSimpleExecutor, new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceSyncGroup.this.toggleTimeout(true);
                    }
                });
            }
            this.mPreviousSyncSafeguard = safeguardSsg;
        }
        SurfaceControl.Transaction t2 = new SurfaceControl.Transaction();
        t2.addTransactionCommittedListener(this.mSimpleExecutor, new SurfaceControl.TransactionCommittedListener() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda4
            @Override // android.view.SurfaceControl.TransactionCommittedListener
            public final void onTransactionCommitted() {
                ViewRootImpl.this.lambda$safeguardOverlappingSyncs$13(safeguardSsg);
            }
        });
        activeSurfaceSyncGroup.addTransaction(t2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeguardOverlappingSyncs$13(SurfaceSyncGroup safeguardSsg) {
        safeguardSsg.markSyncReady();
        synchronized (this.mPreviousSyncSafeguardLock) {
            if (this.mPreviousSyncSafeguard == safeguardSsg) {
                this.mPreviousSyncSafeguard = null;
            }
        }
    }

    @Override // android.view.AttachedSurfaceControl
    public SurfaceSyncGroup getOrCreateSurfaceSyncGroup() {
        boolean newSyncGroup = false;
        if (this.mActiveSurfaceSyncGroup == null) {
            SurfaceSyncGroup surfaceSyncGroup = new SurfaceSyncGroup(this.mTag);
            this.mActiveSurfaceSyncGroup = surfaceSyncGroup;
            surfaceSyncGroup.setAddedToSyncListener(new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ViewRootImpl.this.lambda$getOrCreateSurfaceSyncGroup$15();
                }
            });
            newSyncGroup = true;
        }
        Trace.instant(8L, "getOrCreateSurfaceSyncGroup isNew=" + newSyncGroup + " " + this.mTag);
        if (DEBUG_BLAST) {
            if (newSyncGroup) {
                Log.d(this.mTag, "Creating new active sync group " + this.mActiveSurfaceSyncGroup.getName());
            } else {
                Log.d(this.mTag, "Return already created active sync group " + this.mActiveSurfaceSyncGroup.getName());
            }
        }
        this.mNumPausedForSync++;
        this.mHandler.removeMessages(37);
        this.mHandler.sendEmptyMessageDelayed(37, Build.HW_TIMEOUT_MULTIPLIER * 1000);
        return this.mActiveSurfaceSyncGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getOrCreateSurfaceSyncGroup$15() {
        Runnable runnable = new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                ViewRootImpl.this.lambda$getOrCreateSurfaceSyncGroup$14();
            }
        };
        if (Thread.currentThread() == this.mThread) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getOrCreateSurfaceSyncGroup$14() {
        int i10 = this.mNumPausedForSync;
        if (i10 > 0) {
            this.mNumPausedForSync = i10 - 1;
        }
        if (this.mNumPausedForSync == 0) {
            this.mHandler.removeMessages(37);
            if (!this.mIsInTraversal) {
                scheduleTraversals();
            }
        }
    }

    private void updateSyncInProgressCount(SurfaceSyncGroup syncGroup) {
        if (this.mAttachInfo.mThreadedRenderer == null) {
            return;
        }
        synchronized (sSyncProgressLock) {
            int i10 = sNumSyncsInProgress;
            sNumSyncsInProgress = i10 + 1;
            if (i10 == 0) {
                HardwareRenderer.setRtAnimationsEnabled(false);
            }
        }
        syncGroup.addSyncCompleteCallback(this.mSimpleExecutor, new Runnable() { // from class: android.view.ViewRootImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ViewRootImpl.lambda$updateSyncInProgressCount$16();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateSyncInProgressCount$16() {
        synchronized (sSyncProgressLock) {
            int i10 = sNumSyncsInProgress - 1;
            sNumSyncsInProgress = i10;
            if (i10 == 0) {
                HardwareRenderer.setRtAnimationsEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addToSync(SurfaceSyncGroup syncable) {
        SurfaceSyncGroup surfaceSyncGroup = this.mActiveSurfaceSyncGroup;
        if (surfaceSyncGroup == null) {
            return;
        }
        surfaceSyncGroup.add(syncable, (Runnable) null);
    }

    @Override // android.view.AttachedSurfaceControl
    public void setChildBoundingInsets(Rect insets) {
        if (insets.left < 0 || insets.top < 0 || insets.right < 0 || insets.bottom < 0) {
            throw new IllegalArgumentException("Negative insets passed to setChildBoundingInsets.");
        }
        this.mChildBoundingInsets.set(insets);
        this.mChildBoundingInsetsChanged = true;
        scheduleTraversals();
    }

    public IViewRootImplWrapper getWrapper() {
        return this.mViewRootImplWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class ViewRootImplWrapper implements IViewRootImplWrapper {
        private ViewRootImplWrapper() {
        }

        @Override // android.view.IViewRootImplWrapper
        public void collectRootScrollCaptureTargets(ScrollCaptureSearchResults results) {
            ViewRootImpl.this.collectRootScrollCaptureTargets(results);
        }

        @Override // android.view.IViewRootImplWrapper
        public Object getSocExtImpl() {
            return ViewRootImpl.this.mViewRootImplSocExt;
        }

        @Override // android.view.IViewRootImplWrapper
        public IViewRootImplExt getExtImpl() {
            return ViewRootImpl.this.mViewRootImplExt;
        }

        @Override // android.view.IViewRootImplWrapper
        public SurfaceControl getSurfaceControl() {
            return ViewRootImpl.this.mSurfaceControl;
        }

        @Override // android.view.IViewRootImplWrapper
        public Handler getHandler() {
            return ViewRootImpl.this.mHandler;
        }

        @Override // android.view.IViewRootImplWrapper
        public Choreographer getChoreographer() {
            return ViewRootImpl.this.mChoreographer;
        }

        @Override // android.view.IViewRootImplWrapper
        public WindowManager.LayoutParams getWindowAttributes() {
            return ViewRootImpl.this.mWindowAttributes;
        }

        @Override // android.view.IViewRootImplWrapper
        public String getBasePackageName() {
            return ViewRootImpl.this.mBasePackageName;
        }

        @Override // android.view.IViewRootImplWrapper
        public TraversalRunnable getTraversalRunnable() {
            return ViewRootImpl.this.mTraversalRunnable;
        }

        @Override // android.view.IViewRootImplWrapper
        public WindowInputEventReceiver getInputEventReceiver() {
            return ViewRootImpl.this.mInputEventReceiver;
        }

        @Override // android.view.IViewRootImplWrapper
        public int getTraversalBarrier() {
            return ViewRootImpl.this.mTraversalBarrier;
        }

        @Override // android.view.IViewRootImplWrapper
        public void setTraversalBarrier(int traversalBarrier) {
            ViewRootImpl.this.mTraversalBarrier = traversalBarrier;
        }

        @Override // android.view.IViewRootImplWrapper
        public boolean getTraversalScheduled() {
            return ViewRootImpl.this.mTraversalScheduled;
        }

        @Override // android.view.IViewRootImplWrapper
        public void scheduleTraversals() {
            ViewRootImpl.this.scheduleTraversals();
        }

        @Override // android.view.IViewRootImplWrapper
        public Display getDisplay() {
            return ViewRootImpl.this.mDisplay;
        }

        @Override // android.view.IViewRootImplWrapper
        public void setTraversalScheduled(boolean traversalScheduled) {
            ViewRootImpl.this.mTraversalScheduled = traversalScheduled;
        }

        @Override // android.view.IViewRootImplWrapper
        public boolean getUnbufferedInputDispatch() {
            return ViewRootImpl.this.mUnbufferedInputDispatch;
        }

        @Override // android.view.IViewRootImplWrapper
        public void notifyRendererOfFramePending() {
            ViewRootImpl.this.notifyRendererOfFramePending();
        }

        @Override // android.view.IViewRootImplWrapper
        public void pokeDrawLockIfNeeded() {
            ViewRootImpl.this.pokeDrawLockIfNeeded();
        }

        @Override // android.view.IViewRootImplWrapper
        public void scheduleConsumeBatchedInput() {
            ViewRootImpl.this.scheduleConsumeBatchedInput();
        }

        @Override // android.view.IViewRootImplWrapper
        public boolean isRemoved() {
            return ViewRootImpl.this.mRemoved;
        }

        @Override // android.view.IViewRootImplWrapper
        public SurfaceControl getSurfaceViewBoundsLayer() {
            return ViewRootImpl.this.mBoundsLayer;
        }

        @Override // android.view.IViewRootImplWrapper
        public ArrayList<SurfaceChangedCallback> getSurfaceChangedCallbacks() {
            return ViewRootImpl.this.mSurfaceChangedCallbacks;
        }

        @Override // android.view.IViewRootImplWrapper
        public Context getContext() {
            return ViewRootImpl.this.mContext;
        }

        @Override // android.view.IViewRootImplWrapper
        public void addToWmsSync(SurfaceSyncGroup syncGroup) {
            if (ViewRootImpl.this.mWmsRequestSyncGroup == null) {
                return;
            }
            ViewRootImpl.this.mWmsRequestSyncGroup.add(syncGroup, (Runnable) null);
        }
    }
}
