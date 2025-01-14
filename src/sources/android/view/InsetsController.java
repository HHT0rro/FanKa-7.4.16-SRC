package android.view;

import android.animation.AnimationHandler;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemProperties;
import android.os.Trace;
import android.text.TextUtils;
import android.util.IntArray;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.IInsetsControllerExt;
import android.view.InsetsController;
import android.view.InsetsState;
import android.view.SyncRtSurfaceTransactionApplier;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.graphics.SfVsyncFrameCallbackProvider;
import com.android.internal.inputmethod.ImeTracing;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InsetsController implements WindowInsetsController, InsetsAnimationControlCallbacks {
    private static final int ANIMATION_DELAY_DIM_MS = 500;
    private static final int ANIMATION_DURATION_FADE_IN_MS = 500;
    private static final int ANIMATION_DURATION_FADE_OUT_MS = 1500;
    private static final int ANIMATION_DURATION_MOVE_IN_MS = 275;
    private static final int ANIMATION_DURATION_MOVE_OUT_MS = 340;
    public static final int ANIMATION_DURATION_RESIZE = 300;
    private static final int ANIMATION_DURATION_SYNC_IME_MS = 285;
    private static final int ANIMATION_DURATION_UNSYNC_IME_MS = 200;
    public static final int ANIMATION_TYPE_HIDE = 1;
    public static final int ANIMATION_TYPE_NONE = -1;
    public static final int ANIMATION_TYPE_RESIZE = 3;
    public static final int ANIMATION_TYPE_SHOW = 0;
    public static final int ANIMATION_TYPE_USER = 2;
    private static final int FLOATING_IME_BOTTOM_INSET_DP = -80;
    public static final int LAYOUT_INSETS_DURING_ANIMATION_HIDDEN = 1;
    public static final int LAYOUT_INSETS_DURING_ANIMATION_SHOWN = 0;
    private static final int PENDING_CONTROL_TIMEOUT_MS = 2000;
    private static final String TAG = "InsetsController";
    static final boolean WARN = false;
    private final Runnable mAnimCallback;
    private boolean mAnimCallbackScheduled;
    private boolean mAnimationsDisabled;
    private int mCaptionInsetsHeight;
    private boolean mCompatSysUiVisibilityStaled;
    private final BiFunction<InsetsController, InsetsSource, InsetsSourceConsumer> mConsumerCreator;
    private final ArrayList<WindowInsetsController.OnControllableInsetsChangedListener> mControllableInsetsChangedListeners;
    private int mControllableTypes;
    private int mDisabledUserAnimationInsetsTypes;
    private int mExistingTypes;
    private final Rect mFrame;
    private final Handler mHandler;
    private final Host mHost;
    private final InsetsSourceConsumer mImeSourceConsumer;
    public IInsetsControllerExt mInsetsControllerExt;
    private final Runnable mInvokeControllableInsetsChangedListeners;
    private final ImeTracker.InputMethodJankContext mJankContext;
    private final InsetsState mLastDispatchedState;
    private WindowInsets mLastInsets;
    private int mLastLegacySoftInputMode;
    private int mLastLegacySystemUiFlags;
    private int mLastLegacyWindowFlags;
    private int mLastStartedAnimTypes;
    private int mLastWindowingMode;
    private WindowInsetsAnimationControlListener mLoggingListener;
    private final Runnable mPendingControlTimeout;
    private PendingControlRequest mPendingImeControlRequest;
    private final InsetsState.OnTraverseCallbacks mRemoveGoneSources;
    private int mReportedRequestedVisibleTypes;
    private int mRequestedVisibleTypes;
    private final ArrayList<RunningAnimation> mRunningAnimations;
    private final SparseArray<InsetsSourceConsumer> mSourceConsumers;
    private final InsetsState.OnTraverseCallbacks mStartResizingAnimationIfNeeded;
    private boolean mStartingAnimation;
    private final InsetsState mState;
    private final SparseArray<InsetsSourceControl> mTmpControlArray;
    private int mTypesBeingCancelled;
    private int mVisibleTypes;
    private int mWindowType;
    private static final Interpolator SYSTEM_BARS_INSETS_INTERPOLATOR = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator SYSTEM_BARS_ALPHA_INTERPOLATOR = new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f);
    private static final Interpolator SYSTEM_BARS_DIM_INTERPOLATOR = new Interpolator() { // from class: android.view.InsetsController$$ExternalSyntheticLambda0
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f10) {
            return InsetsController.lambda$static$0(f10);
        }
    };
    private static final Interpolator SYNC_IME_INTERPOLATOR = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
    private static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
    public static final Interpolator RESIZE_INTERPOLATOR = new LinearInterpolator();
    private static final int ID_CAPTION_BAR = InsetsSource.createId(null, 0, WindowInsets.Type.captionBar());
    static boolean DEBUG = false;
    static boolean DEBUG_PANIC = SystemProperties.getBoolean("persist.sys.assert.panic", false);
    static final int DEBUG_DEPTH = SystemProperties.getInt("debug.insets_controller.depth", 5);
    static long mImeAnimPreJankCount = 0;
    private static TypeEvaluator<Insets> sEvaluator = new TypeEvaluator() { // from class: android.view.InsetsController$$ExternalSyntheticLambda1
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f10, Object obj, Object obj2) {
            Insets of;
            Insets insets = (Insets) obj;
            Insets insets2 = (Insets) obj2;
            of = Insets.of((int) (insets.left + ((insets2.left - insets.left) * f10)), (int) (insets.top + ((insets2.top - insets.top) * f10)), (int) (insets.right + ((insets2.right - insets.right) * f10)), (int) (insets.bottom + ((insets2.bottom - insets.bottom) * f10)));
            return of;
        }
    };
    private static IInsetsControllerExt.IStaticExt mStaticExt = (IInsetsControllerExt.IStaticExt) ExtLoader.type(IInsetsControllerExt.IStaticExt.class).create();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface AnimationType {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    @interface LayoutInsetsDuringAnimation {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Host {
        void addOnPreDrawRunnable(Runnable runnable);

        void applySurfaceParams(SyncRtSurfaceTransactionApplier.SurfaceParams... surfaceParamsArr);

        int dipToPx(int i10);

        void dispatchWindowInsetsAnimationEnd(WindowInsetsAnimation windowInsetsAnimation);

        void dispatchWindowInsetsAnimationPrepare(WindowInsetsAnimation windowInsetsAnimation);

        WindowInsets dispatchWindowInsetsAnimationProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list);

        WindowInsetsAnimation.Bounds dispatchWindowInsetsAnimationStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds);

        Handler getHandler();

        InputMethodManager getInputMethodManager();

        String getRootViewTitle();

        int getSystemBarsAppearance();

        int getSystemBarsBehavior();

        IBinder getWindowToken();

        boolean hasAnimationCallbacks();

        void notifyInsetsChanged();

        void postInsetsAnimationCallback(Runnable runnable);

        void releaseSurfaceControlFromRt(SurfaceControl surfaceControl);

        void setSystemBarsAppearance(int i10, int i11);

        void setSystemBarsBehavior(int i10);

        void updateRequestedVisibleTypes(int i10);

        default void updateCompatSysUiVisibility(int visibleTypes, int requestedVisibleTypes, int controllableTypes) {
        }

        default boolean isSystemBarsAppearanceControlled() {
            return false;
        }

        default boolean isSystemBarsBehaviorControlled() {
            return false;
        }

        default Context getRootViewContext() {
            return null;
        }

        default CompatibilityInfo.Translator getTranslator() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float lambda$static$0(float alphaFraction) {
        float fraction = 1.0f - alphaFraction;
        if (fraction <= 0.33333334f) {
            return 1.0f;
        }
        float innerFraction = (fraction - 0.33333334f) / 0.6666666f;
        return 1.0f - SYSTEM_BARS_ALPHA_INTERPOLATOR.getInterpolation(innerFraction);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class InternalAnimationControlListener implements WindowInsetsAnimationControlListener {
        private ValueAnimator mAnimator;
        private final int mBehavior;
        private WindowInsetsAnimationController mController;
        private final boolean mDisable;
        private final int mFloatingImeBottomInset;
        private final boolean mHasAnimationCallbacks;
        private final ImeTracker.InputMethodJankContext mInputMethodJankContext;
        private final WindowInsetsAnimationControlListener mLoggingListener;
        private final int mRequestedTypes;
        private final boolean mShow;
        private final ThreadLocal<AnimationHandler> mSfAnimationHandlerThreadLocal = new ThreadLocal<AnimationHandler>() { // from class: android.view.InsetsController.InternalAnimationControlListener.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public AnimationHandler initialValue() {
                AnimationHandler handler = new AnimationHandler();
                handler.setProvider(new SfVsyncFrameCallbackProvider());
                return handler;
            }
        };
        private final long mDurationMs = calculateDurationMs();

        public InternalAnimationControlListener(boolean show, boolean hasAnimationCallbacks, int requestedTypes, int behavior, boolean disable, int floatingImeBottomInset, WindowInsetsAnimationControlListener loggingListener, ImeTracker.InputMethodJankContext jankContext) {
            this.mShow = show;
            this.mHasAnimationCallbacks = hasAnimationCallbacks;
            this.mRequestedTypes = requestedTypes;
            this.mBehavior = behavior;
            this.mDisable = disable;
            this.mFloatingImeBottomInset = floatingImeBottomInset;
            this.mLoggingListener = loggingListener;
            this.mInputMethodJankContext = jankContext;
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onReady(final WindowInsetsAnimationController controller, final int types) {
            Insets insets;
            final Insets start;
            final Insets end;
            this.mController = controller;
            if (InsetsController.DEBUG) {
                Log.d(InsetsController.TAG, "default animation onReady types: " + types);
            }
            WindowInsetsAnimationControlListener windowInsetsAnimationControlListener = this.mLoggingListener;
            if (windowInsetsAnimationControlListener != null) {
                windowInsetsAnimationControlListener.onReady(controller, types);
            }
            if (this.mDisable) {
                onAnimationFinish();
                return;
            }
            InsetsController.mStaticExt.setInsetAnimationTid(types);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mAnimator = ofFloat;
            ofFloat.setDuration(this.mDurationMs);
            this.mAnimator.setInterpolator(new LinearInterpolator());
            Insets hiddenInsets = controller.getHiddenStateInsets();
            if (controller.hasZeroInsetsIme()) {
                insets = Insets.of(hiddenInsets.left, hiddenInsets.top, hiddenInsets.right, this.mFloatingImeBottomInset);
            } else {
                insets = hiddenInsets;
            }
            Insets hiddenInsets2 = insets;
            if (this.mShow) {
                start = hiddenInsets2;
            } else {
                start = controller.getShownStateInsets();
            }
            if (this.mShow) {
                end = controller.getShownStateInsets();
            } else {
                end = hiddenInsets2;
            }
            final Interpolator insetsInterpolator = getInsetsInterpolator();
            final Interpolator alphaInterpolator = getAlphaInterpolator();
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.view.InsetsController$InternalAnimationControlListener$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    InsetsController.InternalAnimationControlListener.this.lambda$onReady$0(insetsInterpolator, controller, start, end, alphaInterpolator, types, valueAnimator);
                }
            });
            this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.view.InsetsController.InternalAnimationControlListener.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (InternalAnimationControlListener.this.mInputMethodJankContext == null) {
                        return;
                    }
                    ImeTracker.forJank().onRequestAnimation(InternalAnimationControlListener.this.mInputMethodJankContext, !InternalAnimationControlListener.this.mShow ? 1 : 0, !InternalAnimationControlListener.this.mHasAnimationCallbacks);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (InternalAnimationControlListener.this.mInputMethodJankContext == null) {
                        return;
                    }
                    ImeTracker.forJank().onCancelAnimation();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    InternalAnimationControlListener.this.onAnimationFinish();
                    if (InternalAnimationControlListener.this.mInputMethodJankContext == null) {
                        return;
                    }
                    ImeTracker.forJank().onFinishAnimation();
                }
            });
            if (!this.mHasAnimationCallbacks) {
                this.mAnimator.setAnimationHandler(this.mSfAnimationHandlerThreadLocal.get());
            }
            this.mAnimator.start();
            InsetsController.mStaticExt.imeAnimatorStart(this.mRequestedTypes, types, this.mDurationMs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReady$0(Interpolator insetsInterpolator, WindowInsetsAnimationController controller, Insets start, Insets end, Interpolator alphaInterpolator, int types, ValueAnimator animation) {
            float alphaFraction;
            float rawFraction = animation.getAnimatedFraction();
            if (this.mShow) {
                alphaFraction = rawFraction;
            } else {
                alphaFraction = 1.0f - rawFraction;
            }
            float insetsFraction = insetsInterpolator.getInterpolation(rawFraction);
            controller.setInsetsAndAlpha((Insets) InsetsController.sEvaluator.evaluate(insetsFraction, start, end), alphaInterpolator.getInterpolation(alphaFraction), rawFraction);
            if (InsetsController.DEBUG) {
                Log.d(InsetsController.TAG, "Default animation setInsetsAndAlpha fraction: " + insetsFraction);
            }
            InsetsController.mStaticExt.imeAnimatorUpdate(this.mRequestedTypes, types);
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onFinished(WindowInsetsAnimationController controller) {
            InsetsController.mStaticExt.setInsetAnimationTid(0);
            InsetsController.mImeAnimPreJankCount = InsetsController.mStaticExt.imeAnimatorFinished(this.mRequestedTypes, InsetsController.mImeAnimPreJankCount);
            if (InsetsController.DEBUG) {
                Log.d(InsetsController.TAG, "InternalAnimationControlListener onFinished types:" + WindowInsets.Type.toString(this.mRequestedTypes));
            }
            WindowInsetsAnimationControlListener windowInsetsAnimationControlListener = this.mLoggingListener;
            if (windowInsetsAnimationControlListener != null) {
                windowInsetsAnimationControlListener.onFinished(controller);
            }
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onCancelled(WindowInsetsAnimationController controller) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            InsetsController.mStaticExt.imeAnimatorCancelled(this.mRequestedTypes);
            if (InsetsController.DEBUG) {
                Log.d(InsetsController.TAG, "InternalAnimationControlListener onCancelled types:" + this.mRequestedTypes);
            }
            WindowInsetsAnimationControlListener windowInsetsAnimationControlListener = this.mLoggingListener;
            if (windowInsetsAnimationControlListener != null) {
                windowInsetsAnimationControlListener.onCancelled(controller);
            }
        }

        protected Interpolator getInsetsInterpolator() {
            if ((this.mRequestedTypes & WindowInsets.Type.ime()) != 0) {
                if (this.mHasAnimationCallbacks) {
                    return InsetsController.SYNC_IME_INTERPOLATOR;
                }
                if (this.mShow) {
                    return InsetsController.mStaticExt.replaceIMEInterpolator(InsetsController.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                }
                return InsetsController.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            }
            if (this.mBehavior == 2) {
                return InsetsController.SYSTEM_BARS_INSETS_INTERPOLATOR;
            }
            return new Interpolator() { // from class: android.view.InsetsController$InternalAnimationControlListener$$ExternalSyntheticLambda1
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f10) {
                    float lambda$getInsetsInterpolator$1;
                    lambda$getInsetsInterpolator$1 = InsetsController.InternalAnimationControlListener.this.lambda$getInsetsInterpolator$1(f10);
                    return lambda$getInsetsInterpolator$1;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ float lambda$getInsetsInterpolator$1(float input) {
            return this.mShow ? 1.0f : 0.0f;
        }

        Interpolator getAlphaInterpolator() {
            if ((this.mRequestedTypes & WindowInsets.Type.ime()) != 0) {
                if (this.mHasAnimationCallbacks) {
                    return new Interpolator() { // from class: android.view.InsetsController$InternalAnimationControlListener$$ExternalSyntheticLambda2
                        @Override // android.animation.TimeInterpolator
                        public final float getInterpolation(float f10) {
                            return InsetsController.InternalAnimationControlListener.lambda$getAlphaInterpolator$2(f10);
                        }
                    };
                }
                if (this.mShow) {
                    return new Interpolator() { // from class: android.view.InsetsController$InternalAnimationControlListener$$ExternalSyntheticLambda3
                        @Override // android.animation.TimeInterpolator
                        public final float getInterpolation(float f10) {
                            float min;
                            min = Math.min(1.0f, 2.0f * f10);
                            return min;
                        }
                    };
                }
                return InsetsController.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            }
            if (this.mBehavior == 2) {
                return new Interpolator() { // from class: android.view.InsetsController$InternalAnimationControlListener$$ExternalSyntheticLambda4
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f10) {
                        return InsetsController.InternalAnimationControlListener.lambda$getAlphaInterpolator$4(f10);
                    }
                };
            }
            if (this.mShow) {
                return InsetsController.SYSTEM_BARS_ALPHA_INTERPOLATOR;
            }
            return InsetsController.SYSTEM_BARS_DIM_INTERPOLATOR;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ float lambda$getAlphaInterpolator$2(float input) {
            return 1.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ float lambda$getAlphaInterpolator$4(float input) {
            return 1.0f;
        }

        protected void onAnimationFinish() {
            this.mController.finish(this.mShow);
            if (InsetsController.DEBUG) {
                Log.d(InsetsController.TAG, "onAnimationFinish showOnFinish: " + this.mShow);
            }
        }

        public long getDurationMs() {
            return this.mDurationMs;
        }

        private long calculateDurationMs() {
            if ((this.mRequestedTypes & WindowInsets.Type.ime()) == 0) {
                return this.mBehavior == 2 ? this.mShow ? 275L : 340L : this.mShow ? 500L : 1500L;
            }
            if (this.mHasAnimationCallbacks) {
                return 285L;
            }
            return 200L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RunningAnimation {
        final InsetsAnimationControlRunner runner;
        boolean startDispatched;
        final int type;

        RunningAnimation(InsetsAnimationControlRunner runner, int type) {
            this.runner = runner;
            this.type = type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class PendingControlRequest {
        final int animationType;
        final CancellationSignal cancellationSignal;
        final long durationMs;
        final Interpolator interpolator;
        final int layoutInsetsDuringAnimation;
        final WindowInsetsAnimationControlListener listener;
        int types;
        final boolean useInsetsAnimationThread;

        PendingControlRequest(int types, WindowInsetsAnimationControlListener listener, long durationMs, Interpolator interpolator, int animationType, int layoutInsetsDuringAnimation, CancellationSignal cancellationSignal, boolean useInsetsAnimationThread) {
            this.types = types;
            this.listener = listener;
            this.durationMs = durationMs;
            this.interpolator = interpolator;
            this.animationType = animationType;
            this.layoutInsetsDuringAnimation = layoutInsetsDuringAnimation;
            this.cancellationSignal = cancellationSignal;
            this.useInsetsAnimationThread = useInsetsAnimationThread;
        }
    }

    public InsetsController(Host host) {
        this(host, new BiFunction() { // from class: android.view.InsetsController$$ExternalSyntheticLambda7
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return InsetsController.lambda$new$2((InsetsController) obj, (InsetsSource) obj2);
            }
        }, host.getHandler());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InsetsSourceConsumer lambda$new$2(InsetsController controller, InsetsSource source) {
        if (source.getType() == WindowInsets.Type.ime()) {
            return new ImeInsetsSourceConsumer(source.getId(), controller.mState, new InsetsController$$ExternalSyntheticLambda8(), controller);
        }
        return new InsetsSourceConsumer(source.getId(), source.getType(), controller.mState, new InsetsController$$ExternalSyntheticLambda8(), controller);
    }

    public InsetsController(Host host, BiFunction<InsetsController, InsetsSource, InsetsSourceConsumer> consumerCreator, Handler handler) {
        this.mJankContext = new ImeTracker.InputMethodJankContext() { // from class: android.view.InsetsController.1
            @Override // android.view.inputmethod.ImeTracker.InputMethodJankContext
            public Context getDisplayContext() {
                if (InsetsController.this.mHost != null) {
                    return InsetsController.this.mHost.getRootViewContext();
                }
                return null;
            }

            @Override // android.view.inputmethod.ImeTracker.InputMethodJankContext
            public SurfaceControl getTargetSurfaceControl() {
                InsetsSourceControl imeSourceControl = InsetsController.this.getImeSourceConsumer().getControl();
                if (imeSourceControl != null) {
                    return imeSourceControl.getLeash();
                }
                return null;
            }

            @Override // android.view.inputmethod.ImeTracker.InputMethodJankContext
            public String getHostPackageName() {
                if (InsetsController.this.mHost != null) {
                    return InsetsController.this.mHost.getRootViewContext().getPackageName();
                }
                return null;
            }
        };
        this.mState = new InsetsState();
        this.mLastDispatchedState = new InsetsState();
        this.mFrame = new Rect();
        this.mSourceConsumers = new SparseArray<>();
        this.mTmpControlArray = new SparseArray<>();
        this.mRunningAnimations = new ArrayList<>();
        this.mCaptionInsetsHeight = 0;
        this.mPendingControlTimeout = new Runnable() { // from class: android.view.InsetsController$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                InsetsController.this.abortPendingImeControlRequest();
            }
        };
        this.mControllableInsetsChangedListeners = new ArrayList<>();
        this.mExistingTypes = 0;
        this.mVisibleTypes = WindowInsets.Type.defaultVisible();
        this.mRequestedVisibleTypes = WindowInsets.Type.defaultVisible();
        this.mReportedRequestedVisibleTypes = WindowInsets.Type.defaultVisible();
        this.mInvokeControllableInsetsChangedListeners = new Runnable() { // from class: android.view.InsetsController$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                InsetsController.this.invokeControllableInsetsChangedListeners();
            }
        };
        this.mRemoveGoneSources = new InsetsState.OnTraverseCallbacks() { // from class: android.view.InsetsController.2
            private final IntArray mPendingRemoveIndexes = new IntArray();

            @Override // android.view.InsetsState.OnTraverseCallbacks
            public void onIdNotFoundInState2(int index1, InsetsSource source1) {
                if (!ViewRootImpl.CAPTION_ON_SHELL && source1.getType() == WindowInsets.Type.captionBar()) {
                    return;
                }
                this.mPendingRemoveIndexes.add(index1);
                if (source1.getType() != WindowInsets.Type.ime()) {
                    InsetsController.this.mSourceConsumers.remove(source1.getId());
                }
            }

            @Override // android.view.InsetsState.OnTraverseCallbacks
            public void onFinish(InsetsState state1, InsetsState state2) {
                for (int i10 = this.mPendingRemoveIndexes.size() - 1; i10 >= 0; i10--) {
                    state1.removeSourceAt(this.mPendingRemoveIndexes.get(i10));
                }
                this.mPendingRemoveIndexes.clear();
            }
        };
        this.mStartResizingAnimationIfNeeded = new InsetsState.OnTraverseCallbacks() { // from class: android.view.InsetsController.3
            private InsetsState mToState;
            private int mTypes;

            @Override // android.view.InsetsState.OnTraverseCallbacks
            public void onStart(InsetsState state1, InsetsState state2) {
                this.mTypes = 0;
                this.mToState = null;
            }

            @Override // android.view.InsetsState.OnTraverseCallbacks
            public void onIdMatch(InsetsSource source1, InsetsSource source2) {
                int type = source1.getType();
                if ((WindowInsets.Type.systemBars() & type) != 0 && source1.isVisible() && source2.isVisible() && !source1.getFrame().equals(source2.getFrame())) {
                    if (!Rect.intersects(InsetsController.this.mFrame, source1.getFrame()) && !Rect.intersects(InsetsController.this.mFrame, source2.getFrame())) {
                        return;
                    }
                    this.mTypes |= type;
                    if (this.mToState == null) {
                        this.mToState = new InsetsState();
                    }
                    this.mToState.addSource(new InsetsSource(source2));
                }
            }

            @Override // android.view.InsetsState.OnTraverseCallbacks
            public void onFinish(InsetsState state1, InsetsState state2) {
                if (this.mTypes == 0 || InsetsController.this.mInsetsControllerExt.isIgnoreTaskBarAnim(this.mTypes, InsetsController.this.mSourceConsumers)) {
                    return;
                }
                InsetsController.this.cancelExistingControllers(this.mTypes);
                InsetsAnimationControlRunner runner = new InsetsResizeAnimationRunner(InsetsController.this.mFrame, state1, this.mToState, InsetsController.RESIZE_INTERPOLATOR, 300L, this.mTypes, InsetsController.this);
                InsetsController.this.mRunningAnimations.add(new RunningAnimation(runner, runner.getAnimationType()));
            }
        };
        this.mInsetsControllerExt = (IInsetsControllerExt) ExtLoader.type(IInsetsControllerExt.class).create();
        this.mHost = host;
        this.mConsumerCreator = consumerCreator;
        this.mHandler = handler;
        this.mAnimCallback = new Runnable() { // from class: android.view.InsetsController$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                InsetsController.this.lambda$new$3();
            }
        };
        this.mImeSourceConsumer = getSourceConsumer(new InsetsSource(InsetsSource.ID_IME, WindowInsets.Type.ime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3() {
        this.mAnimCallbackScheduled = false;
        if (this.mRunningAnimations.isEmpty()) {
            return;
        }
        List<WindowInsetsAnimation> runningAnimations = new ArrayList<>();
        List<WindowInsetsAnimation> finishedAnimations = new ArrayList<>();
        InsetsState state = new InsetsState(this.mState, true);
        for (int i10 = this.mRunningAnimations.size() - 1; i10 >= 0; i10--) {
            RunningAnimation runningAnimation = this.mRunningAnimations.get(i10);
            if (DEBUG) {
                Log.d(TAG, "Running animation type: " + runningAnimation.type);
            }
            InsetsAnimationControlRunner runner = runningAnimation.runner;
            if (runner instanceof WindowInsetsAnimationController) {
                if (runningAnimation.startDispatched) {
                    runningAnimations.add(runner.getAnimation());
                }
                if (((InternalInsetsAnimationController) runner).applyChangeInsets(state)) {
                    finishedAnimations.add(runner.getAnimation());
                }
            }
        }
        WindowInsets insets = state.calculateInsets(this.mFrame, this.mState, this.mLastInsets.isRound(), this.mLastInsets.shouldAlwaysConsumeSystemBars(), this.mLastLegacySoftInputMode, this.mLastLegacyWindowFlags, this.mLastLegacySystemUiFlags, this.mWindowType, this.mLastWindowingMode, null);
        this.mHost.dispatchWindowInsetsAnimationProgress(insets, Collections.unmodifiableList(runningAnimations));
        if (DEBUG) {
            for (WindowInsetsAnimation anim : runningAnimations) {
                Log.d(TAG, String.format("Running animation type: %d, progress: %f", Integer.valueOf(anim.getTypeMask()), Float.valueOf(anim.getInterpolatedFraction())));
            }
        }
        for (int i11 = finishedAnimations.size() - 1; i11 >= 0; i11--) {
            dispatchAnimationEnd(finishedAnimations.get(i11));
        }
    }

    public void onFrameChanged(Rect frame) {
        if (this.mFrame.equals(frame)) {
            return;
        }
        this.mHost.notifyInsetsChanged();
        this.mFrame.set(frame);
    }

    @Override // android.view.WindowInsetsController
    public InsetsState getState() {
        return this.mState;
    }

    @Override // android.view.WindowInsetsController
    public int getRequestedVisibleTypes() {
        return this.mRequestedVisibleTypes;
    }

    public InsetsState getLastDispatchedState() {
        return this.mLastDispatchedState;
    }

    public boolean onStateChanged(InsetsState state) {
        boolean stateChanged;
        InputMethodManager.getDefaultInstance().getWrapper().getExtImpl().updateNavInsets(this.mWindowType, state);
        if (!ViewRootImpl.CAPTION_ON_SHELL) {
            stateChanged = !this.mState.equals(state, true, false) || captionInsetsUnchanged();
        } else {
            stateChanged = !this.mState.equals(state, false, false);
        }
        if (!stateChanged && this.mLastDispatchedState.equals(state)) {
            return false;
        }
        if (DEBUG || DEBUG_PANIC) {
            Log.d(TAG, "onStateChanged: " + ((Object) state) + " callers=" + Debug.getCallers(DEBUG_DEPTH));
        }
        this.mLastDispatchedState.set(state, true);
        InsetsState lastState = new InsetsState(this.mState, true);
        updateState(state);
        applyLocalVisibilityOverride();
        updateCompatSysUiVisibility();
        if (!this.mState.equals(lastState, false, true)) {
            if (DEBUG) {
                Log.d(TAG, "onStateChanged, notifyInsetsChanged");
            }
            this.mHost.notifyInsetsChanged();
            if (lastState.getDisplayFrame().equals(this.mState.getDisplayFrame())) {
                InsetsState.traverse(lastState, this.mState, this.mStartResizingAnimationIfNeeded);
            }
        }
        return true;
    }

    private void updateState(InsetsState newState) {
        this.mState.set(newState, 0);
        int existingTypes = 0;
        int visibleTypes = 0;
        int disabledUserAnimationTypes = 0;
        final int[] cancelledUserAnimationTypes = {0};
        int size = newState.sourceSize();
        for (int i10 = 0; i10 < size; i10++) {
            InsetsSource source = newState.sourceAt(i10);
            int type = source.getType();
            int animationType = getAnimationType(type);
            if (!source.isUserControllable()) {
                disabledUserAnimationTypes |= type;
                if (animationType == 2) {
                    animationType = -1;
                    cancelledUserAnimationTypes[0] = cancelledUserAnimationTypes[0] | type;
                }
            }
            getSourceConsumer(source).updateSource(source, animationType);
            existingTypes |= type;
            if (source.isVisible()) {
                visibleTypes |= type;
            }
        }
        int i11 = WindowInsets.Type.defaultVisible();
        int visibleTypes2 = visibleTypes | (i11 & (~existingTypes));
        int i12 = this.mVisibleTypes;
        if (i12 != visibleTypes2) {
            if (WindowInsets.Type.hasCompatSystemBars(i12 ^ visibleTypes2)) {
                this.mCompatSysUiVisibilityStaled = true;
            }
            this.mVisibleTypes = visibleTypes2;
        }
        int i13 = this.mExistingTypes;
        if (i13 != existingTypes) {
            if (WindowInsets.Type.hasCompatSystemBars(i13 ^ existingTypes)) {
                this.mCompatSysUiVisibilityStaled = true;
            }
            this.mExistingTypes = existingTypes;
        }
        InsetsState.traverse(this.mState, newState, this.mRemoveGoneSources);
        updateDisabledUserAnimationTypes(disabledUserAnimationTypes);
        if (cancelledUserAnimationTypes[0] != 0) {
            this.mHandler.post(new Runnable() { // from class: android.view.InsetsController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    InsetsController.this.lambda$updateState$4(cancelledUserAnimationTypes);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateState$4(int[] cancelledUserAnimationTypes) {
        show(cancelledUserAnimationTypes[0]);
    }

    private void updateDisabledUserAnimationTypes(int disabledUserAnimationTypes) {
        int diff = this.mDisabledUserAnimationInsetsTypes ^ disabledUserAnimationTypes;
        if (diff != 0) {
            int i10 = this.mSourceConsumers.size() - 1;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                InsetsSourceConsumer consumer = this.mSourceConsumers.valueAt(i10);
                if (consumer.getControl() == null || (consumer.getType() & diff) == 0) {
                    i10--;
                } else {
                    this.mHandler.removeCallbacks(this.mInvokeControllableInsetsChangedListeners);
                    this.mHandler.post(this.mInvokeControllableInsetsChangedListeners);
                    break;
                }
            }
            this.mDisabledUserAnimationInsetsTypes = disabledUserAnimationTypes;
        }
    }

    private boolean captionInsetsUnchanged() {
        if (ViewRootImpl.CAPTION_ON_SHELL) {
            return false;
        }
        InsetsSource source = this.mState.peekSource(ID_CAPTION_BAR);
        if (source == null && this.mCaptionInsetsHeight == 0) {
            return false;
        }
        return source == null || this.mCaptionInsetsHeight != source.getFrame().height();
    }

    public WindowInsets calculateInsets(boolean isScreenRound, boolean alwaysConsumeSystemBars, int windowType, int windowingMode, int legacySoftInputMode, int legacyWindowFlags, int legacySystemUiFlags) {
        this.mWindowType = windowType;
        this.mLastWindowingMode = windowingMode;
        this.mLastLegacySoftInputMode = legacySoftInputMode;
        this.mLastLegacyWindowFlags = legacyWindowFlags;
        this.mLastLegacySystemUiFlags = legacySystemUiFlags;
        WindowInsets calculateInsets = this.mState.calculateInsets(this.mFrame, null, isScreenRound, alwaysConsumeSystemBars, legacySoftInputMode, legacyWindowFlags, legacySystemUiFlags, windowType, windowingMode, null);
        this.mLastInsets = calculateInsets;
        return calculateInsets;
    }

    public Insets calculateVisibleInsets(int windowType, int windowingMode, int softInputMode, int windowFlags) {
        return this.mState.calculateVisibleInsets(this.mFrame, windowType, windowingMode, softInputMode, windowFlags);
    }

    public void onControlsChanged(InsetsSourceControl[] activeControls) {
        if (activeControls != null) {
            for (InsetsSourceControl activeControl : activeControls) {
                if (activeControl != null) {
                    this.mTmpControlArray.put(activeControl.getId(), activeControl);
                }
            }
        }
        int controllableTypes = 0;
        int consumedControlCount = 0;
        int[] showTypes = new int[1];
        int[] hideTypes = new int[1];
        for (int i10 = this.mSourceConsumers.size() - 1; i10 >= 0; i10--) {
            InsetsSourceConsumer consumer = this.mSourceConsumers.valueAt(i10);
            InsetsSourceControl control = this.mTmpControlArray.get(consumer.getId());
            if (control != null) {
                controllableTypes |= control.getType();
                consumedControlCount++;
            }
            consumer.setControl(control, showTypes, hideTypes);
        }
        if (consumedControlCount != this.mTmpControlArray.size()) {
            for (int i11 = this.mTmpControlArray.size() - 1; i11 >= 0; i11--) {
                InsetsSourceControl control2 = this.mTmpControlArray.valueAt(i11);
                if (this.mSourceConsumers.get(control2.getId()) == null) {
                    control2.release(new InsetsAnimationThreadControlRunner$$ExternalSyntheticLambda0());
                    Log.e(TAG, ((Object) control2) + " has no consumer.");
                }
            }
        }
        if (this.mTmpControlArray.size() > 0) {
            for (int i12 = this.mRunningAnimations.size() - 1; i12 >= 0; i12--) {
                this.mRunningAnimations.get(i12).runner.updateSurfacePosition(this.mTmpControlArray);
            }
        }
        this.mTmpControlArray.clear();
        int animatingTypes = invokeControllableInsetsChangedListeners();
        showTypes[0] = showTypes[0] & (~animatingTypes);
        hideTypes[0] = hideTypes[0] & (~animatingTypes);
        if (showTypes[0] != 0) {
            applyAnimation(showTypes[0], true, false, null);
        }
        if (hideTypes[0] != 0) {
            applyAnimation(hideTypes[0], false, false, null);
        }
        int i13 = this.mControllableTypes;
        if (i13 != controllableTypes) {
            if (WindowInsets.Type.hasCompatSystemBars(i13 ^ controllableTypes)) {
                this.mCompatSysUiVisibilityStaled = true;
            }
            this.mControllableTypes = controllableTypes;
        }
        reportRequestedVisibleTypes();
    }

    @Override // android.view.WindowInsetsController
    public void show(int types) {
        ImeTracker.Token statsToken = null;
        if ((WindowInsets.Type.ime() & types) != 0) {
            statsToken = ImeTracker.forLogging().onRequestShow(null, Process.myUid(), 1, 26);
        }
        show(types, false, statsToken);
    }

    public void show(int types, boolean fromIme, ImeTracker.Token statsToken) {
        if (DEBUG || DEBUG_PANIC) {
            Log.d(TAG, String.format("show: types=%d fromIme=%b callers=%s", Integer.valueOf(types), Boolean.valueOf(fromIme), Debug.getCallers(DEBUG_DEPTH)));
        }
        if ((types & WindowInsets.Type.ime()) != 0) {
            Log.d(TAG, "show(ime(), fromIme=" + fromIme + ")");
        }
        boolean z10 = false;
        if (fromIme) {
            ImeTracing.getInstance().triggerClientDump("InsetsController#show", this.mHost.getInputMethodManager(), null);
            Trace.asyncTraceEnd(8L, "IC.showRequestFromApiToImeReady", 0);
            Trace.asyncTraceBegin(8L, "IC.showRequestFromIme", 0);
        } else {
            Trace.asyncTraceBegin(8L, "IC.showRequestFromApi", 0);
            Trace.asyncTraceBegin(8L, "IC.showRequestFromApiToImeReady", 0);
        }
        if (fromIme && this.mPendingImeControlRequest != null) {
            if ((types & WindowInsets.Type.ime()) != 0) {
                ImeTracker.forLatency().onShown(statsToken, new InsetsController$$ExternalSyntheticLambda2());
            }
            handlePendingControlRequest(statsToken);
            return;
        }
        int typesReady = 0;
        boolean imeVisible = this.mState.isSourceOrDefaultVisible(this.mImeSourceConsumer.getId(), WindowInsets.Type.ime());
        int type = 1;
        while (true) {
            if (type > 512) {
                break;
            }
            if ((types & type) != 0) {
                int animationType = getAnimationType(type);
                boolean requestedVisible = (this.mRequestedVisibleTypes & type) != 0 ? true : z10;
                boolean isIme = type == WindowInsets.Type.ime() ? true : z10;
                boolean alreadyVisible = (!requestedVisible || (isIme && !imeVisible) || animationType != -1) ? z10 : true;
                boolean alreadyAnimatingShow = animationType != 0 ? z10 : true;
                if (alreadyVisible || alreadyAnimatingShow) {
                    if (DEBUG) {
                        Log.d(TAG, String.format("show ignored for type: %d animType: %d requestedVisible: %s", Integer.valueOf(type), Integer.valueOf(animationType), Boolean.valueOf(requestedVisible)));
                    }
                    if (isIme) {
                        ImeTracker.forLogging().onCancelled(statsToken, 32);
                    }
                } else if (fromIme && animationType == 2) {
                    if (isIme) {
                        ImeTracker.forLogging().onFailed(statsToken, 32);
                    }
                } else {
                    if (isIme) {
                        ImeTracker.forLogging().onProgress(statsToken, 32);
                    }
                    typesReady |= type;
                }
            }
            type <<= 1;
            z10 = false;
        }
        if (DEBUG) {
            Log.d(TAG, "show typesReady: " + typesReady);
        }
        if (fromIme && (WindowInsets.Type.ime() & typesReady) != 0) {
            ImeTracker.forLatency().onShown(statsToken, new InsetsController$$ExternalSyntheticLambda2());
        }
        applyAnimation(typesReady, true, fromIme, statsToken);
    }

    private void handlePendingControlRequest(ImeTracker.Token statsToken) {
        PendingControlRequest pendingRequest = this.mPendingImeControlRequest;
        this.mPendingImeControlRequest = null;
        this.mHandler.removeCallbacks(this.mPendingControlTimeout);
        controlAnimationUnchecked(pendingRequest.types, pendingRequest.cancellationSignal, pendingRequest.listener, null, true, pendingRequest.durationMs, pendingRequest.interpolator, pendingRequest.animationType, pendingRequest.layoutInsetsDuringAnimation, pendingRequest.useInsetsAnimationThread, statsToken);
    }

    @Override // android.view.WindowInsetsController
    public void hide(int types) {
        ImeTracker.Token statsToken = null;
        if ((WindowInsets.Type.ime() & types) != 0) {
            statsToken = ImeTracker.forLogging().onRequestHide(null, Process.myUid(), 2, 28);
        }
        hide(types, false, statsToken);
    }

    public void hide(int types, boolean fromIme, ImeTracker.Token statsToken) {
        if (DEBUG || DEBUG_PANIC) {
            Log.d(TAG, String.format("hide: types=%d fromIme=%b callers=%s", Integer.valueOf(types), Boolean.valueOf(fromIme), Debug.getCallers(DEBUG_DEPTH)));
        }
        if (!fromIme) {
            Trace.asyncTraceBegin(8L, "IC.hideRequestFromApi", 0);
        } else {
            ImeTracing.getInstance().triggerClientDump("InsetsController#hide", this.mHost.getInputMethodManager(), null);
            Trace.asyncTraceBegin(8L, "IC.hideRequestFromIme", 0);
        }
        int typesReady = 0;
        boolean hasImeRequestedHidden = false;
        boolean hadPendingImeControlRequest = this.mPendingImeControlRequest != null;
        int type = 1;
        while (type <= 512) {
            if ((types & type) != 0) {
                int animationType = getAnimationType(type);
                boolean requestedVisible = (this.mRequestedVisibleTypes & type) != 0;
                boolean isImeAnimation = type == WindowInsets.Type.ime();
                PendingControlRequest pendingControlRequest = this.mPendingImeControlRequest;
                if (pendingControlRequest != null && !requestedVisible) {
                    pendingControlRequest.types &= ~type;
                    if (this.mPendingImeControlRequest.types == 0) {
                        abortPendingImeControlRequest();
                    }
                }
                if (isImeAnimation && !requestedVisible && animationType == -1) {
                    hasImeRequestedHidden = true;
                    if (hadPendingImeControlRequest || getImeSourceConsumer().isRequestedVisibleAwaitingControl()) {
                        getImeSourceConsumer().requestHide(fromIme, statsToken);
                    }
                }
                if ((!requestedVisible && animationType == -1) || animationType == 1) {
                    if (isImeAnimation) {
                        ImeTracker.forLogging().onCancelled(statsToken, 32);
                    }
                } else {
                    if (isImeAnimation) {
                        ImeTracker.forLogging().onProgress(statsToken, 32);
                    }
                    typesReady |= type;
                }
            }
            type <<= 1;
        }
        if (hasImeRequestedHidden && this.mPendingImeControlRequest != null) {
            handlePendingControlRequest(statsToken);
            getImeSourceConsumer().removeSurface();
        }
        applyAnimation(typesReady, false, fromIme, statsToken);
    }

    @Override // android.view.WindowInsetsController
    public void controlWindowInsetsAnimation(int types, long durationMillis, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListener listener) {
        controlWindowInsetsAnimation(types, cancellationSignal, listener, false, durationMillis, interpolator, 2);
    }

    private void controlWindowInsetsAnimation(int types, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListener listener, boolean fromIme, long durationMs, Interpolator interpolator, int animationType) {
        if ((this.mState.calculateUncontrollableInsetsFromFrame(this.mFrame) & types) != 0) {
            listener.onCancelled(null);
            return;
        }
        if (fromIme) {
            ImeTracing.getInstance().triggerClientDump("InsetsController#controlWindowInsetsAnimation", this.mHost.getInputMethodManager(), null);
        }
        controlAnimationUnchecked(types, cancellationSignal, listener, this.mFrame, fromIme, durationMs, interpolator, animationType, getLayoutInsetsDuringAnimationMode(types), false, null);
    }

    private void controlAnimationUnchecked(int types, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListener listener, Rect frame, boolean fromIme, long durationMs, Interpolator interpolator, int animationType, int layoutInsetsDuringAnimation, boolean useInsetsAnimationThread, ImeTracker.Token statsToken) {
        boolean visible = layoutInsetsDuringAnimation == 0;
        setRequestedVisibleTypes(visible ? types : 0, types);
        controlAnimationUncheckedInner(types, cancellationSignal, listener, frame, fromIme, durationMs, interpolator, animationType, layoutInsetsDuringAnimation, useInsetsAnimationThread, statsToken);
        reportRequestedVisibleTypes();
    }

    private void controlAnimationUncheckedInner(int types, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListener listener, Rect frame, boolean fromIme, long durationMs, Interpolator interpolator, int animationType, int layoutInsetsDuringAnimation, boolean useInsetsAnimationThread, ImeTracker.Token statsToken) {
        int types2;
        int types3;
        byte[] bArr;
        int typesReady;
        final InsetsController insetsController;
        InsetsAnimationControlRunner insetsAnimationControlImpl;
        int i10;
        ImeTracker.Token token;
        long j10;
        int i11;
        ImeTracker.forLogging().onProgress(statsToken, 33);
        boolean z10 = true;
        if ((types & this.mTypesBeingCancelled) != 0) {
            if (animationType != 0 && animationType != 1) {
                z10 = false;
            }
            boolean monitoredAnimation = z10;
            if (monitoredAnimation && (types & WindowInsets.Type.ime()) != 0) {
                if (animationType == 0) {
                    ImeTracker.forLatency().onShowCancelled(statsToken, 40, new InsetsController$$ExternalSyntheticLambda2());
                } else {
                    ImeTracker.forLatency().onHideCancelled(statsToken, 40, new InsetsController$$ExternalSyntheticLambda2());
                }
            }
            throw new IllegalStateException("Cannot start a new insets animation of " + WindowInsets.Type.toString(types) + " while an existing " + WindowInsets.Type.toString(this.mTypesBeingCancelled) + " is being cancelled.");
        }
        if (animationType != 2) {
            types2 = types;
        } else {
            int disabledTypes = types & this.mDisabledUserAnimationInsetsTypes;
            if (DEBUG) {
                Log.d(TAG, "user animation disabled types: " + disabledTypes);
            }
            int types4 = types & (~this.mDisabledUserAnimationInsetsTypes);
            if ((WindowInsets.Type.ime() & disabledTypes) != 0) {
                ImeTracker.forLogging().onFailed(statsToken, 34);
                if (fromIme && !this.mState.isSourceOrDefaultVisible(this.mImeSourceConsumer.getId(), WindowInsets.Type.ime())) {
                    setRequestedVisibleTypes(0, WindowInsets.Type.ime());
                    if (this.mImeSourceConsumer.onAnimationStateChanged(false)) {
                        notifyVisibilityChanged();
                    }
                }
            }
            types2 = types4;
        }
        if (types2 == 0) {
            listener.onCancelled(null);
            if (DEBUG) {
                Log.d(TAG, "no types to animate in controlAnimationUnchecked");
            }
            Trace.asyncTraceEnd(8L, "IC.showRequestFromApi", 0);
            Trace.asyncTraceEnd(8L, "IC.showRequestFromApiToImeReady", 0);
            return;
        }
        ImeTracker.forLogging().onProgress(statsToken, 34);
        if (DEBUG) {
            Log.d(TAG, "controlAnimation types: " + types2);
        }
        this.mLastStartedAnimTypes |= types2;
        SparseArray<InsetsSourceControl> controls = new SparseArray<>();
        Pair<Integer, Boolean> typesReadyPair = collectSourceControls(fromIme, types2, controls, animationType, statsToken);
        int typesReady2 = ((Integer) typesReadyPair.first).intValue();
        boolean imeReady = ((Boolean) typesReadyPair.second).booleanValue();
        if (DEBUG) {
            Log.d(TAG, String.format("controlAnimationUnchecked, typesReady: %s imeReady: %s", Integer.valueOf(typesReady2), Boolean.valueOf(imeReady)));
        }
        if (!imeReady) {
            abortPendingImeControlRequest();
            int types5 = types2;
            final PendingControlRequest request = new PendingControlRequest(types2, listener, durationMs, interpolator, animationType, layoutInsetsDuringAnimation, cancellationSignal, useInsetsAnimationThread);
            this.mPendingImeControlRequest = request;
            this.mHandler.postDelayed(this.mPendingControlTimeout, 2000L);
            if (DEBUG) {
                Log.d(TAG, "Ime not ready. Create pending request");
            }
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: android.view.InsetsController$$ExternalSyntheticLambda4
                    @Override // android.os.CancellationSignal.OnCancelListener
                    public final void onCancel() {
                        InsetsController.this.lambda$controlAnimationUncheckedInner$5(request);
                    }
                });
            }
            setRequestedVisibleTypes(this.mReportedRequestedVisibleTypes, types5);
            Trace.asyncTraceEnd(8L, "IC.showRequestFromApi", 0);
            if (!fromIme) {
                Trace.asyncTraceEnd(8L, "IC.showRequestFromApiToImeReady", 0);
                return;
            }
            return;
        }
        int typesReady3 = types2;
        if (typesReady2 != 0) {
            cancelExistingControllers(typesReady2);
            if (useInsetsAnimationThread) {
                types3 = typesReady3;
                bArr = null;
                typesReady = typesReady2;
                insetsController = this;
                insetsAnimationControlImpl = new InsetsAnimationThreadControlRunner(controls, frame, this.mState, listener, typesReady2, this, durationMs, interpolator, animationType, layoutInsetsDuringAnimation, this.mHost.getTranslator(), this.mHost.getHandler(), statsToken);
            } else {
                types3 = typesReady3;
                bArr = null;
                typesReady = typesReady2;
                insetsController = this;
                insetsAnimationControlImpl = new InsetsAnimationControlImpl(controls, frame, insetsController.mState, listener, typesReady, this, durationMs, interpolator, animationType, layoutInsetsDuringAnimation, insetsController.mHost.getTranslator(), statsToken);
            }
            final InsetsAnimationControlRunner runner = insetsAnimationControlImpl;
            if ((typesReady & WindowInsets.Type.ime()) == 0) {
                i10 = animationType;
                token = statsToken;
            } else {
                ImeTracing.getInstance().triggerClientDump("InsetsAnimationControlImpl", insetsController.mHost.getInputMethodManager(), bArr);
                i10 = animationType;
                if (i10 != 1) {
                    token = statsToken;
                } else {
                    token = statsToken;
                    ImeTracker.forLatency().onHidden(token, new InsetsController$$ExternalSyntheticLambda2());
                }
            }
            ImeTracker.forLogging().onProgress(token, 39);
            insetsController.mRunningAnimations.add(new RunningAnimation(runner, i10));
            if (DEBUG) {
                Log.d(TAG, "Animation added to runner. useInsetsAnimationThread: " + useInsetsAnimationThread);
            }
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: android.view.InsetsController$$ExternalSyntheticLambda5
                    @Override // android.os.CancellationSignal.OnCancelListener
                    public final void onCancel() {
                        InsetsController.this.lambda$controlAnimationUncheckedInner$6(runner);
                    }
                });
                j10 = 8;
                i11 = 0;
            } else {
                j10 = 8;
                i11 = 0;
                Trace.asyncTraceBegin(8L, "IC.pendingAnim", 0);
            }
            insetsController.onAnimationStateChanged(types3, true);
            if (fromIme) {
                switch (i10) {
                    case 0:
                        Trace.asyncTraceEnd(j10, "IC.showRequestFromIme", i11);
                        return;
                    case 1:
                        Trace.asyncTraceEnd(j10, "IC.hideRequestFromIme", i11);
                        return;
                    default:
                        return;
                }
            }
            if (i10 == 1) {
                Trace.asyncTraceEnd(j10, "IC.hideRequestFromApi", i11);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "No types ready. onCancelled()");
        }
        listener.onCancelled(null);
        Trace.asyncTraceEnd(8L, "IC.showRequestFromApi", 0);
        if (!fromIme) {
            Trace.asyncTraceEnd(8L, "IC.showRequestFromApiToImeReady", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$controlAnimationUncheckedInner$5(PendingControlRequest request) {
        if (this.mPendingImeControlRequest == request) {
            if (DEBUG) {
                Log.d(TAG, "Cancellation signal abortPendingImeControlRequest");
            }
            abortPendingImeControlRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$controlAnimationUncheckedInner$6(InsetsAnimationControlRunner runner) {
        cancelAnimation(runner, true);
    }

    @Override // android.view.WindowInsetsController
    public void setSystemDrivenInsetsAnimationLoggingListener(WindowInsetsAnimationControlListener listener) {
        this.mLoggingListener = listener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Pair<Integer, Boolean> collectSourceControls(boolean fromIme, int types, SparseArray<InsetsSourceControl> controls, int animationType, ImeTracker.Token statsToken) {
        InsetsSourceControl control;
        ImeTracker.forLogging().onProgress(statsToken, 35);
        int typesReady = 0;
        boolean imeReady = true;
        for (int i10 = this.mSourceConsumers.size() - 1; i10 >= 0; i10--) {
            InsetsSourceConsumer consumer = this.mSourceConsumers.valueAt(i10);
            if ((consumer.getType() & types) != 0) {
                boolean show = animationType == 0 || animationType == 2;
                boolean canRun = true;
                if (show) {
                    switch (consumer.requestShow(fromIme, statsToken)) {
                        case 1:
                            imeReady = false;
                            if (DEBUG) {
                                Log.d(TAG, "requestShow IME_SHOW_DELAYED");
                                break;
                            }
                            break;
                        case 2:
                            canRun = false;
                            setRequestedVisibleTypes(0, consumer.getType());
                            break;
                    }
                } else {
                    consumer.requestHide(fromIme, statsToken);
                }
                if (canRun && (control = consumer.getControl()) != null && control.getLeash() != null) {
                    controls.put(control.getId(), new InsetsSourceControl(control));
                    typesReady |= consumer.getType();
                }
            }
        }
        return new Pair<>(Integer.valueOf(typesReady), Boolean.valueOf(imeReady));
    }

    private int getLayoutInsetsDuringAnimationMode(int types) {
        if ((this.mRequestedVisibleTypes & types) != types) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelExistingControllers(int types) {
        int originalmTypesBeingCancelled = this.mTypesBeingCancelled;
        this.mTypesBeingCancelled |= types;
        try {
            for (int i10 = this.mRunningAnimations.size() - 1; i10 >= 0; i10--) {
                InsetsAnimationControlRunner control = this.mRunningAnimations.get(i10).runner;
                if ((control.getTypes() & types) != 0) {
                    cancelAnimation(control, true);
                }
            }
            int i11 = WindowInsets.Type.ime();
            if ((i11 & types) != 0) {
                abortPendingImeControlRequest();
            }
        } finally {
            this.mTypesBeingCancelled = originalmTypesBeingCancelled;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abortPendingImeControlRequest() {
        PendingControlRequest pendingControlRequest = this.mPendingImeControlRequest;
        if (pendingControlRequest != null) {
            pendingControlRequest.listener.onCancelled(null);
            this.mPendingImeControlRequest = null;
            this.mHandler.removeCallbacks(this.mPendingControlTimeout);
            if (DEBUG) {
                Log.d(TAG, "abortPendingImeControlRequest");
            }
        }
    }

    @Override // android.view.InsetsAnimationControlCallbacks
    public void notifyFinished(InsetsAnimationControlRunner runner, boolean shown) {
        boolean isRunning = false;
        int i10 = this.mRunningAnimations.size() - 1;
        while (true) {
            if (i10 < 0) {
                break;
            }
            if (this.mRunningAnimations.get(i10).runner != runner) {
                i10--;
            } else {
                isRunning = true;
                break;
            }
        }
        if (!isRunning && (runner.getTypes() & WindowInsets.Type.ime()) == 0) {
            Log.d(TAG, "notifyFinished. No animation running, is it cancelled in controlAnimationUnchecked?");
            return;
        }
        setRequestedVisibleTypes(shown ? runner.getTypes() : 0, runner.getTypes());
        cancelAnimation(runner, false);
        if (DEBUG) {
            Log.d(TAG, "notifyFinished. shown: " + shown);
        }
        if (runner.getAnimationType() == 3) {
            return;
        }
        ImeTracker.Token statsToken = runner.getStatsToken();
        if (shown) {
            ImeTracker.forLogging().onProgress(statsToken, 41);
            ImeTracker.forLogging().onShown(statsToken);
        } else {
            ImeTracker.forLogging().onProgress(statsToken, 42);
            ImeTracker.forLogging().onHidden(statsToken);
        }
        reportRequestedVisibleTypes();
    }

    @Override // android.view.InsetsAnimationControlCallbacks
    public void applySurfaceParams(SyncRtSurfaceTransactionApplier.SurfaceParams... params) {
        this.mHost.applySurfaceParams(params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyControlRevoked(InsetsSourceConsumer consumer) {
        int type = consumer.getType();
        for (int i10 = this.mRunningAnimations.size() - 1; i10 >= 0; i10--) {
            InsetsAnimationControlRunner control = this.mRunningAnimations.get(i10).runner;
            control.notifyControlRevoked(type);
            if (control.getControllingTypes() == 0) {
                cancelAnimation(control, true);
            }
        }
        int i11 = WindowInsets.Type.ime();
        if (type == i11) {
            abortPendingImeControlRequest();
        }
    }

    private void cancelAnimation(InsetsAnimationControlRunner control, boolean invokeCallback) {
        if ((DEBUG || DEBUG_PANIC) && control.getTypes() == 2) {
            Log.d(TAG, String.format("cancelAnimation of types: %d, animType: %d, host: %s,, invokeCallback: %b, callers: %s", Integer.valueOf(control.getTypes()), Integer.valueOf(control.getAnimationType()), this.mHost.getRootViewTitle(), Boolean.valueOf(invokeCallback), Debug.getCallers(10)));
        }
        if (invokeCallback) {
            ImeTracker.forLogging().onCancelled(control.getStatsToken(), 40);
            control.cancel();
        } else {
            ImeTracker.forLogging().onProgress(control.getStatsToken(), 40);
        }
        if (DEBUG) {
            Log.d(TAG, TextUtils.formatSimple("cancelAnimation of types: %d, animType: %d, host: %s", new Object[]{Integer.valueOf(control.getTypes()), Integer.valueOf(control.getAnimationType()), this.mHost.getRootViewTitle()}));
        }
        int removedTypes = 0;
        int i10 = this.mRunningAnimations.size() - 1;
        while (true) {
            if (i10 < 0) {
                break;
            }
            RunningAnimation runningAnimation = this.mRunningAnimations.get(i10);
            if (runningAnimation.runner != control) {
                i10--;
            } else {
                this.mRunningAnimations.remove(i10);
                removedTypes = control.getTypes();
                if (invokeCallback) {
                    dispatchAnimationEnd(runningAnimation.runner.getAnimation());
                }
            }
        }
        onAnimationStateChanged(removedTypes, false);
    }

    private void onAnimationStateChanged(int types, boolean running) {
        boolean insetsChanged = false;
        for (int i10 = this.mSourceConsumers.size() - 1; i10 >= 0; i10--) {
            InsetsSourceConsumer consumer = this.mSourceConsumers.valueAt(i10);
            if ((consumer.getType() & types) != 0) {
                insetsChanged |= consumer.onAnimationStateChanged(running);
            }
        }
        if (insetsChanged) {
            notifyVisibilityChanged();
        }
    }

    private void applyLocalVisibilityOverride() {
        for (int i10 = this.mSourceConsumers.size() - 1; i10 >= 0; i10--) {
            InsetsSourceConsumer consumer = this.mSourceConsumers.valueAt(i10);
            consumer.applyLocalVisibilityOverride();
        }
    }

    public InsetsSourceConsumer getSourceConsumer(InsetsSource source) {
        InsetsSourceConsumer consumer;
        InsetsSourceConsumer insetsSourceConsumer;
        int sourceId = source.getId();
        InsetsSourceConsumer consumer2 = this.mSourceConsumers.get(sourceId);
        if (consumer2 != null) {
            return consumer2;
        }
        if (source.getType() == WindowInsets.Type.ime() && (insetsSourceConsumer = this.mImeSourceConsumer) != null) {
            this.mSourceConsumers.remove(insetsSourceConsumer.getId());
            consumer = this.mImeSourceConsumer;
            consumer.setId(sourceId);
        } else {
            consumer = this.mConsumerCreator.apply(this, source);
        }
        this.mSourceConsumers.put(sourceId, consumer);
        return consumer;
    }

    public InsetsSourceConsumer getImeSourceConsumer() {
        return this.mImeSourceConsumer;
    }

    public void notifyVisibilityChanged() {
        this.mHost.notifyInsetsChanged();
    }

    public void updateCompatSysUiVisibility() {
        if (this.mCompatSysUiVisibilityStaled) {
            this.mCompatSysUiVisibilityStaled = false;
            this.mHost.updateCompatSysUiVisibility(this.mVisibleTypes, this.mRequestedVisibleTypes, this.mControllableTypes | (~this.mExistingTypes));
        }
    }

    public void onWindowFocusGained(boolean hasViewFocused) {
        this.mImeSourceConsumer.onWindowFocusGained(hasViewFocused);
    }

    public void onWindowFocusLost() {
        this.mImeSourceConsumer.onWindowFocusLost();
    }

    public int getAnimationType(int type) {
        for (int i10 = this.mRunningAnimations.size() - 1; i10 >= 0; i10--) {
            InsetsAnimationControlRunner control = this.mRunningAnimations.get(i10).runner;
            if (control.controlsType(type)) {
                return this.mRunningAnimations.get(i10).type;
            }
        }
        return -1;
    }

    public void setRequestedVisibleTypes(int visibleTypes, int mask) {
        int i10 = this.mRequestedVisibleTypes;
        int requestedVisibleTypes = ((~mask) & i10) | (visibleTypes & mask);
        if (i10 != requestedVisibleTypes) {
            this.mRequestedVisibleTypes = requestedVisibleTypes;
        }
    }

    private void reportRequestedVisibleTypes() {
        int i10 = this.mReportedRequestedVisibleTypes;
        int i11 = this.mRequestedVisibleTypes;
        if (i10 != i11) {
            int diff = i10 ^ i11;
            if (WindowInsets.Type.hasCompatSystemBars(diff)) {
                this.mCompatSysUiVisibilityStaled = true;
            }
            int i12 = this.mRequestedVisibleTypes;
            this.mReportedRequestedVisibleTypes = i12;
            this.mHost.updateRequestedVisibleTypes(i12);
        }
        updateCompatSysUiVisibility();
    }

    public void applyAnimation(int types, boolean show, boolean fromIme, ImeTracker.Token statsToken) {
        InsetsSourceControl imeControl;
        boolean skipAnim = false;
        if ((WindowInsets.Type.ime() & types) != 0 && (imeControl = this.mImeSourceConsumer.getControl()) != null) {
            skipAnim = imeControl.getAndClearSkipAnimationOnce() && show && this.mImeSourceConsumer.hasViewFocusWhenWindowFocusGain();
        }
        if (DEBUG_PANIC && types == 2) {
            Log.d(TAG, "applyAnimation, types: " + types + ", show: " + show + ", animation from: " + Debug.getCallers(DEBUG_DEPTH));
        }
        applyAnimation(types, show, fromIme, skipAnim, statsToken);
    }

    public void applyAnimation(int i10, boolean z10, boolean z11, boolean z12, ImeTracker.Token token) {
        if (i10 == 0) {
            if (DEBUG) {
                Log.d(TAG, "applyAnimation, nothing to animate");
            }
            Trace.asyncTraceEnd(8L, "IC.showRequestFromApi", 0);
            if (!z11) {
                Trace.asyncTraceEnd(8L, "IC.showRequestFromApiToImeReady", 0);
                return;
            }
            return;
        }
        boolean hasAnimationCallbacks = this.mHost.hasAnimationCallbacks();
        InternalAnimationControlListener internalAnimationControlListener = new InternalAnimationControlListener(z10, hasAnimationCallbacks, i10, this.mHost.getSystemBarsBehavior(), z12 || this.mAnimationsDisabled, this.mHost.dipToPx(FLOATING_IME_BOTTOM_INSET_DP), this.mLoggingListener, this.mJankContext);
        controlAnimationUnchecked(i10, null, internalAnimationControlListener, null, z11, internalAnimationControlListener.getDurationMs(), internalAnimationControlListener.getInsetsInterpolator(), !z10 ? 1 : 0, !z10 ? 1 : 0, !hasAnimationCallbacks, token);
    }

    public void cancelExistingAnimations() {
        cancelExistingControllers(WindowInsets.Type.all());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.println("InsetsController:");
        this.mState.dump(prefix + "  ", pw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        this.mState.dumpDebug(proto, 1146756268033L);
        for (int i10 = this.mRunningAnimations.size() - 1; i10 >= 0; i10--) {
            InsetsAnimationControlRunner runner = this.mRunningAnimations.get(i10).runner;
            runner.dumpDebug(proto, 2246267895810L);
        }
        proto.end(token);
    }

    @Override // android.view.InsetsAnimationControlCallbacks
    public <T extends InsetsAnimationControlRunner & InternalInsetsAnimationController> void startAnimation(final T runner, final WindowInsetsAnimationControlListener listener, final int types, final WindowInsetsAnimation animation, final WindowInsetsAnimation.Bounds bounds) {
        this.mHost.dispatchWindowInsetsAnimationPrepare(animation);
        this.mHost.addOnPreDrawRunnable(new Runnable() { // from class: android.view.InsetsController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                InsetsController.this.lambda$startAnimation$7(runner, types, animation, bounds, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnimation$7(InsetsAnimationControlRunner runner, int types, WindowInsetsAnimation animation, WindowInsetsAnimation.Bounds bounds, WindowInsetsAnimationControlListener listener) {
        if (((WindowInsetsAnimationController) runner).isCancelled()) {
            return;
        }
        Trace.asyncTraceBegin(8L, "InsetsAnimation: " + WindowInsets.Type.toString(types), types);
        for (int i10 = this.mRunningAnimations.size() - 1; i10 >= 0; i10--) {
            RunningAnimation runningAnimation = this.mRunningAnimations.get(i10);
            if (runningAnimation.runner == runner) {
                runningAnimation.startDispatched = true;
            }
        }
        Trace.asyncTraceEnd(8L, "IC.pendingAnim", 0);
        this.mHost.dispatchWindowInsetsAnimationStart(animation, bounds);
        this.mStartingAnimation = true;
        ((InternalInsetsAnimationController) runner).setReadyDispatched(true);
        listener.onReady((WindowInsetsAnimationController) runner, types);
        this.mStartingAnimation = false;
    }

    public void dispatchAnimationEnd(WindowInsetsAnimation animation) {
        Trace.asyncTraceEnd(8L, "InsetsAnimation: " + WindowInsets.Type.toString(animation.getTypeMask()), animation.getTypeMask());
        this.mHost.dispatchWindowInsetsAnimationEnd(animation);
    }

    @Override // android.view.InsetsAnimationControlCallbacks
    public void scheduleApplyChangeInsets(InsetsAnimationControlRunner runner) {
        if (this.mStartingAnimation || runner.getAnimationType() == 2) {
            this.mAnimCallback.run();
            this.mAnimCallbackScheduled = false;
        } else if (!this.mAnimCallbackScheduled) {
            this.mHost.postInsetsAnimationCallback(this.mAnimCallback);
            this.mAnimCallbackScheduled = true;
        }
    }

    @Override // android.view.WindowInsetsController
    public void setSystemBarsAppearance(int appearance, int mask) {
        this.mHost.setSystemBarsAppearance(appearance, mask);
    }

    @Override // android.view.WindowInsetsController
    public int getSystemBarsAppearance() {
        if (!this.mHost.isSystemBarsAppearanceControlled()) {
            return 0;
        }
        return this.mHost.getSystemBarsAppearance();
    }

    @Override // android.view.WindowInsetsController
    public void setCaptionInsetsHeight(int height) {
        if (!ViewRootImpl.CAPTION_ON_SHELL && this.mCaptionInsetsHeight != height) {
            this.mCaptionInsetsHeight = height;
            if (height != 0) {
                this.mState.getOrCreateSource(ID_CAPTION_BAR, WindowInsets.Type.captionBar()).setFrame(this.mFrame.left, this.mFrame.top, this.mFrame.right, this.mFrame.top + this.mCaptionInsetsHeight);
            } else {
                this.mState.removeSource(ID_CAPTION_BAR);
            }
            this.mHost.notifyInsetsChanged();
        }
    }

    @Override // android.view.WindowInsetsController
    public void setSystemBarsBehavior(int behavior) {
        this.mHost.setSystemBarsBehavior(behavior);
    }

    @Override // android.view.WindowInsetsController
    public int getSystemBarsBehavior() {
        if (!this.mHost.isSystemBarsBehaviorControlled()) {
            return 0;
        }
        return this.mHost.getSystemBarsBehavior();
    }

    @Override // android.view.WindowInsetsController
    public void setAnimationsDisabled(boolean disable) {
        this.mAnimationsDisabled = disable;
    }

    private int calculateControllableTypes() {
        int result = 0;
        for (int i10 = this.mSourceConsumers.size() - 1; i10 >= 0; i10--) {
            InsetsSourceConsumer consumer = this.mSourceConsumers.valueAt(i10);
            InsetsSource source = this.mState.peekSource(consumer.getId());
            if (consumer.getControl() != null && source != null && source.isUserControllable()) {
                result |= consumer.getType();
            }
        }
        return (~this.mState.calculateUncontrollableInsetsFromFrame(this.mFrame)) & result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int invokeControllableInsetsChangedListeners() {
        this.mHandler.removeCallbacks(this.mInvokeControllableInsetsChangedListeners);
        this.mLastStartedAnimTypes = 0;
        int types = calculateControllableTypes();
        int size = this.mControllableInsetsChangedListeners.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mControllableInsetsChangedListeners.get(i10).onControllableInsetsChanged(this, types);
        }
        int i11 = this.mLastStartedAnimTypes;
        return i11;
    }

    @Override // android.view.WindowInsetsController
    public void addOnControllableInsetsChangedListener(WindowInsetsController.OnControllableInsetsChangedListener listener) {
        Objects.requireNonNull(listener);
        this.mControllableInsetsChangedListeners.add(listener);
        listener.onControllableInsetsChanged(this, calculateControllableTypes());
    }

    @Override // android.view.WindowInsetsController
    public void removeOnControllableInsetsChangedListener(WindowInsetsController.OnControllableInsetsChangedListener listener) {
        Objects.requireNonNull(listener);
        this.mControllableInsetsChangedListeners.remove(listener);
    }

    @Override // android.view.InsetsAnimationControlCallbacks
    public void releaseSurfaceControlFromRt(SurfaceControl sc2) {
        this.mHost.releaseSurfaceControlFromRt(sc2);
    }

    @Override // android.view.InsetsAnimationControlCallbacks
    public void reportPerceptible(int types, boolean perceptible) {
        int size = this.mSourceConsumers.size();
        for (int i10 = 0; i10 < size; i10++) {
            InsetsSourceConsumer consumer = this.mSourceConsumers.valueAt(i10);
            if ((consumer.getType() & types) != 0) {
                consumer.onPerceptible(perceptible);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Host getHost() {
        return this.mHost;
    }
}
