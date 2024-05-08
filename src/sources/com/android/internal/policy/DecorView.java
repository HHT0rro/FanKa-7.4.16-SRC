package com.android.internal.policy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.WindowConfiguration;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.Property;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.InputQueue;
import android.view.InsetsState;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.PendingInsetsController;
import android.view.SurfaceHolder;
import android.view.ThreadedRenderer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewRootImpl;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowCallbacks;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.android.internal.R;
import com.android.internal.graphics.drawable.BackgroundBlurDrawable;
import com.android.internal.policy.PhoneWindow;
import com.android.internal.view.FloatingActionMode;
import com.android.internal.view.RootViewSurfaceTaker;
import com.android.internal.view.StandaloneActionMode;
import com.android.internal.view.menu.ContextMenuBuilder;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;
import com.android.internal.widget.ActionBarContextView;
import com.android.internal.widget.BackgroundFallback;
import com.android.internal.widget.DecorCaptionView;
import com.android.internal.widget.floatingtoolbar.FloatingToolbar;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.hms.ads.dynamicloader.b;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import java.util.function.Consumer;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DecorView extends FrameLayout implements RootViewSurfaceTaker, WindowCallbacks {
    private static final boolean DEBUG_MEASURE = false;
    public static final int DECOR_SHADOW_FOCUSED_HEIGHT_IN_DIP = 20;
    public static final int DECOR_SHADOW_UNFOCUSED_HEIGHT_IN_DIP = 5;
    private static final int SCRIM_LIGHT = -419430401;
    private static final boolean SWEEP_OPEN_MENU = false;
    private static final String TAG = "DecorView";
    private boolean mAllowUpdateElevation;
    private boolean mApplyFloatingHorizontalInsets;
    private boolean mApplyFloatingVerticalInsets;
    private BackdropFrameRenderer mBackdropFrameRenderer;
    private BackgroundBlurDrawable mBackgroundBlurDrawable;
    private final ViewTreeObserver.OnPreDrawListener mBackgroundBlurOnPreDrawListener;
    private int mBackgroundBlurRadius;
    private final BackgroundFallback mBackgroundFallback;
    private Insets mBackgroundInsets;
    private final Rect mBackgroundPadding;
    private final int mBarEnterExitDuration;
    private Drawable mCaptionBackgroundDrawable;
    private boolean mChanging;
    ViewGroup mContentRoot;
    private boolean mCrossWindowBlurEnabled;
    private Consumer<Boolean> mCrossWindowBlurEnabledListener;
    private DecorCaptionView mDecorCaptionView;
    private IDecorViewExt mDecorViewExt;
    private IDecorViewWrapper mDecorViewWrapper;
    int mDefaultOpacity;
    private int mDownY;
    private boolean mDrawLegacyNavigationBarBackground;
    private boolean mDrawLegacyNavigationBarBackgroundHandled;
    private final Rect mDrawingBounds;
    private boolean mElevationAdjustedForStack;
    private ObjectAnimator mFadeAnim;
    private final int mFeatureId;
    private ActionMode mFloatingActionMode;
    private View mFloatingActionModeOriginatingView;
    private final Rect mFloatingInsets;
    private FloatingToolbar mFloatingToolbar;
    private ViewTreeObserver.OnPreDrawListener mFloatingToolbarPreDrawListener;
    final boolean mForceWindowDrawsBarBackgrounds;
    private final Rect mFrameOffsets;
    private final Rect mFramePadding;
    private boolean mHasCaption;
    private final Interpolator mHideInterpolator;
    private boolean mIsInPictureInPictureMode;
    private BackgroundBlurDrawable mLastBackgroundBlurDrawable;
    private Drawable.Callback mLastBackgroundDrawableCb;
    private Insets mLastBackgroundInsets;
    private int mLastBottomInset;
    private boolean mLastHasBottomStableInset;
    private boolean mLastHasLeftStableInset;
    private boolean mLastHasRightStableInset;
    private boolean mLastHasTopStableInset;
    private int mLastLeftInset;
    private Drawable mLastOriginalBackgroundDrawable;
    private ViewOutlineProvider mLastOutlineProvider;
    private int mLastRightInset;
    private boolean mLastShouldAlwaysConsumeSystemBars;
    private int mLastSuppressScrimTypes;
    private int mLastTopInset;
    private int mLastWindowFlags;
    private final Paint mLegacyNavigationBarBackgroundPaint;
    String mLogTag;
    private Drawable mMenuBackground;
    private final ColorViewState mNavigationColorViewState;
    private int mOriginalBackgroundBlurRadius;
    private Drawable mOriginalBackgroundDrawable;
    private PendingInsetsController mPendingInsetsController;
    private Drawable mPendingWindowBackground;
    ActionMode mPrimaryActionMode;
    private PopupWindow mPrimaryActionModePopup;
    private ActionBarContextView mPrimaryActionModeView;
    private Drawable mResizingBackgroundDrawable;
    private int mRootScrollY;
    private final int mSemiTransparentBarColor;
    private final Interpolator mShowInterpolator;
    private Runnable mShowPrimaryActionModePopup;
    private final ColorViewState mStatusColorViewState;
    private View mStatusGuard;
    private Rect mTempRect;
    private Drawable mUserCaptionBackgroundDrawable;
    private boolean mWatchingForMenu;
    private PhoneWindow mWindow;
    private boolean mWindowResizeCallbacksAdded;
    private static boolean isClosedSuperFirewall = false;
    public static final ColorViewAttributes STATUS_BAR_COLOR_VIEW_ATTRIBUTES = new ColorViewAttributes(67108864, 48, 3, 5, Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME, 16908335, WindowInsets.Type.statusBars());
    public static final ColorViewAttributes NAVIGATION_BAR_COLOR_VIEW_ATTRIBUTES = new ColorViewAttributes(134217728, 80, 5, 3, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME, 16908336, WindowInsets.Type.navigationBars());
    private static final ViewOutlineProvider PIP_OUTLINE_PROVIDER = new ViewOutlineProvider() { // from class: com.android.internal.policy.DecorView.1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(1.0f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0() {
        updateBackgroundBlurCorners();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecorView(Context context, int featureId, PhoneWindow window, WindowManager.LayoutParams params) {
        super(context);
        boolean defaultForceWindowDrawsBarBackgrounds = false;
        this.mAllowUpdateElevation = false;
        this.mElevationAdjustedForStack = false;
        this.mDefaultOpacity = -1;
        this.mDrawingBounds = new Rect();
        this.mBackgroundPadding = new Rect();
        this.mFramePadding = new Rect();
        this.mFrameOffsets = new Rect();
        this.mHasCaption = false;
        this.mStatusColorViewState = new ColorViewState(STATUS_BAR_COLOR_VIEW_ATTRIBUTES);
        this.mNavigationColorViewState = new ColorViewState(NAVIGATION_BAR_COLOR_VIEW_ATTRIBUTES);
        this.mBackgroundFallback = new BackgroundFallback();
        this.mLastTopInset = 0;
        this.mLastBottomInset = 0;
        this.mLastRightInset = 0;
        this.mLastLeftInset = 0;
        this.mLastHasTopStableInset = false;
        this.mLastHasBottomStableInset = false;
        this.mLastHasRightStableInset = false;
        this.mLastHasLeftStableInset = false;
        this.mLastWindowFlags = 0;
        this.mLastShouldAlwaysConsumeSystemBars = false;
        this.mLastSuppressScrimTypes = 0;
        this.mRootScrollY = 0;
        this.mWindowResizeCallbacksAdded = false;
        this.mLastBackgroundDrawableCb = null;
        this.mBackdropFrameRenderer = null;
        this.mLogTag = TAG;
        this.mFloatingInsets = new Rect();
        this.mApplyFloatingVerticalInsets = false;
        this.mApplyFloatingHorizontalInsets = false;
        Paint paint = new Paint();
        this.mLegacyNavigationBarBackgroundPaint = paint;
        this.mBackgroundInsets = Insets.NONE;
        this.mLastBackgroundInsets = Insets.NONE;
        this.mPendingInsetsController = new PendingInsetsController();
        this.mOriginalBackgroundBlurRadius = 0;
        this.mBackgroundBlurRadius = 0;
        this.mBackgroundBlurOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.internal.policy.DecorView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                boolean lambda$new$0;
                lambda$new$0 = DecorView.this.lambda$new$0();
                return lambda$new$0;
            }
        };
        this.mDecorViewWrapper = new DecorViewWrapper();
        this.mDecorViewExt = (IDecorViewExt) ExtLoader.type(IDecorViewExt.class).base(this).create();
        this.mFeatureId = featureId;
        this.mShowInterpolator = AnimationUtils.loadInterpolator(context, 17563662);
        this.mHideInterpolator = AnimationUtils.loadInterpolator(context, 17563663);
        this.mBarEnterExitDuration = context.getResources().getInteger(R.integer.dock_enter_exit_duration);
        if (context.getResources().getBoolean(R.bool.config_forceWindowDrawsStatusBarBackground) && params.type != 2011 && context.getApplicationInfo().targetSdkVersion >= 24) {
            defaultForceWindowDrawsBarBackgrounds = true;
        }
        this.mForceWindowDrawsBarBackgrounds = this.mDecorViewExt.hookDecorView(context, defaultForceWindowDrawsBarBackgrounds);
        this.mSemiTransparentBarColor = context.getResources().getColor(R.color.system_bar_background_semi_transparent, null);
        setWindow(window);
        updateLogTag(params);
        paint.setColor(this.mDecorViewExt.getLegacyNavBarBackgroundColor());
        this.mDecorViewExt.initDarkModeBackgroundColor();
        isClosedSuperFirewall = this.mDecorViewExt.isClosedSuperFirewall();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundFallback(Drawable fallbackDrawable) {
        this.mBackgroundFallback.setDrawable(fallbackDrawable);
        setWillNotDraw(getBackground() == null && !this.mBackgroundFallback.hasFallback());
    }

    public Drawable getBackgroundFallback() {
        return this.mBackgroundFallback.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getStatusBarBackgroundView() {
        return this.mStatusColorViewState.view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getNavigationBarBackgroundView() {
        return this.mNavigationColorViewState.view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        boolean statusOpaque = gatherTransparentRegion(this.mStatusColorViewState, region);
        boolean navOpaque = gatherTransparentRegion(this.mNavigationColorViewState, region);
        boolean decorOpaque = super.gatherTransparentRegion(region);
        return statusOpaque || navOpaque || decorOpaque;
    }

    boolean gatherTransparentRegion(ColorViewState colorViewState, Region region) {
        if (colorViewState.view != null && colorViewState.visible && isResizing()) {
            return colorViewState.view.gatherTransparentRegion(region);
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas c4) {
        super.onDraw(c4);
        this.mBackgroundFallback.draw(this, this.mContentRoot, c4, this.mWindow.mContentParent, this.mStatusColorViewState.view, this.mNavigationColorViewState.view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        int action = event.getAction();
        boolean isDown = action == 0;
        this.mDecorViewExt.inputLog("d", TAG, "dispatchKeyEvent, code=" + keyCode + ", action=" + action + ", repeat=" + event.getRepeatCount() + ", destoryed=" + this.mWindow.isDestroyed(), null);
        if (isDown && event.getRepeatCount() == 0) {
            if (this.mWindow.mPanelChordingKey > 0 && this.mWindow.mPanelChordingKey != keyCode) {
                if (dispatchKeyShortcutEvent(event)) {
                    return true;
                }
            }
            if (this.mWindow.mPreparedPanel != null && this.mWindow.mPreparedPanel.isOpen) {
                PhoneWindow phoneWindow = this.mWindow;
                if (phoneWindow.performPanelShortcut(phoneWindow.mPreparedPanel, keyCode, event, 0)) {
                    return true;
                }
            }
        }
        if (!this.mWindow.isDestroyed()) {
            Window.Callback cb2 = this.mWindow.getCallback();
            boolean handled = (cb2 == null || this.mFeatureId >= 0) ? super.dispatchKeyEvent(event) : cb2.dispatchKeyEvent(event);
            if (event.getDownTime() == event.getEventTime() || event.isLongPress() || action == 1) {
                try {
                    this.mDecorViewExt.inputLog(t.f36218c, TAG, "dispatchKeyEvent cb handled=" + handled + ", " + ((Object) event) + ", activity=" + ((Object) cb2) + ", mFeatureId=" + this.mFeatureId, null);
                } catch (Exception e2) {
                    this.mDecorViewExt.inputLog(t.f36218c, TAG, "dispatchKeyEvent: print log exception = " + ((Object) e2), null);
                }
            }
            if (handled) {
                return true;
            }
        }
        return isDown ? this.mWindow.onKeyDown(this.mFeatureId, event.getKeyCode(), event) : this.mWindow.onKeyUp(this.mFeatureId, event.getKeyCode(), event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyShortcutEvent(KeyEvent ev) {
        if (this.mWindow.mPreparedPanel != null) {
            PhoneWindow phoneWindow = this.mWindow;
            boolean handled = phoneWindow.performPanelShortcut(phoneWindow.mPreparedPanel, ev.getKeyCode(), ev, 1);
            if (handled) {
                if (this.mWindow.mPreparedPanel != null) {
                    this.mWindow.mPreparedPanel.isHandled = true;
                }
                return true;
            }
        }
        Window.Callback cb2 = this.mWindow.getCallback();
        boolean handled2 = (cb2 == null || this.mWindow.isDestroyed() || this.mFeatureId >= 0) ? super.dispatchKeyShortcutEvent(ev) : cb2.dispatchKeyShortcutEvent(ev);
        if (handled2) {
            return true;
        }
        PhoneWindow.PanelFeatureState st = this.mWindow.getPanelState(0, false);
        if (st != null && this.mWindow.mPreparedPanel == null) {
            this.mWindow.preparePanel(st, ev);
            boolean handled3 = this.mWindow.performPanelShortcut(st, ev.getKeyCode(), ev, 1);
            st.isPrepared = false;
            if (handled3) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Window.Callback cb2 = this.mWindow.getCallback();
        this.mDecorViewExt.inputLog("d1", TAG, "dispatchTouchEvent cb=" + ((Object) cb2) + ", destoryed=" + this.mWindow.isDestroyed() + ", featureId=" + this.mFeatureId, ev);
        return (cb2 == null || this.mWindow.isDestroyed() || this.mFeatureId >= 0) ? super.dispatchTouchEvent(ev) : cb2.dispatchTouchEvent(ev);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        Window.Callback cb2 = this.mWindow.getCallback();
        return (cb2 == null || this.mWindow.isDestroyed() || this.mFeatureId >= 0) ? super.dispatchTrackballEvent(ev) : cb2.dispatchTrackballEvent(ev);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Window.Callback cb2 = this.mWindow.getCallback();
        return (cb2 == null || this.mWindow.isDestroyed() || this.mFeatureId >= 0) ? super.dispatchGenericMotionEvent(ev) : cb2.dispatchGenericMotionEvent(ev);
    }

    public boolean superDispatchKeyEvent(KeyEvent event) {
        this.mDecorViewExt.inputLog("d", TAG, " superDispatchKeyEvent(), event = " + KeyEvent.keyCodeToString(event.getKeyCode()), null);
        if (event.getKeyCode() == 4) {
            int action = event.getAction();
            ActionMode actionMode = this.mPrimaryActionMode;
            if (actionMode != null) {
                if (action == 1) {
                    actionMode.finish();
                }
                this.mDecorViewExt.inputLog(b.f29144f, TAG, " KeyEvent.KEYCODE_BACK consumed by " + ((Object) this.mPrimaryActionMode), null);
                return true;
            }
        }
        if (super.dispatchKeyEvent(event)) {
            return true;
        }
        return getViewRootImpl() != null && getViewRootImpl().dispatchUnhandledKeyEvent(event);
    }

    public boolean superDispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }

    public boolean superDispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    public boolean superDispatchTrackballEvent(MotionEvent event) {
        return super.dispatchTrackballEvent(event);
    }

    public boolean superDispatchGenericMotionEvent(MotionEvent event) {
        return super.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return onInterceptTouchEvent(event);
    }

    private boolean isOutOfInnerBounds(int x10, int y10) {
        return x10 < 0 || y10 < 0 || x10 > getWidth() || y10 > getHeight();
    }

    private boolean isOutOfBounds(int x10, int y10) {
        return x10 < -5 || y10 < -5 || x10 > getWidth() + 5 || y10 > getHeight() + 5;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (this.mHasCaption && isShowingCaption() && action == 0) {
            int x10 = (int) event.getX();
            int y10 = (int) event.getY();
            if (isOutOfInnerBounds(x10, y10)) {
                return true;
            }
        }
        int x11 = this.mFeatureId;
        if (x11 >= 0 && action == 0) {
            int x12 = (int) event.getX();
            int y11 = (int) event.getY();
            if (isOutOfBounds(x12, y11)) {
                this.mWindow.closePanel(this.mFeatureId);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int eventType) {
        if (!AccessibilityManager.getInstance(this.mContext).isEnabled()) {
            return;
        }
        int i10 = this.mFeatureId;
        if ((i10 == 0 || i10 == 6 || i10 == 2 || i10 == 5) && getChildCount() == 1) {
            getChildAt(0).sendAccessibilityEvent(eventType);
        } else {
            super.sendAccessibilityEvent(eventType);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        Window.Callback cb2 = this.mWindow.getCallback();
        if (cb2 != null && !this.mWindow.isDestroyed() && cb2.dispatchPopulateAccessibilityEvent(event)) {
            return true;
        }
        return super.dispatchPopulateAccessibilityEventInternal(event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean setFrame(int l10, int t2, int r10, int b4) {
        boolean changed = super.setFrame(l10, t2, r10, b4);
        if (changed) {
            Rect drawingBounds = this.mDrawingBounds;
            getDrawingRect(drawingBounds);
            Drawable fg = getForeground();
            if (fg != null) {
                Rect frameOffsets = this.mFrameOffsets;
                drawingBounds.left += frameOffsets.left;
                drawingBounds.top += frameOffsets.top;
                drawingBounds.right -= frameOffsets.right;
                drawingBounds.bottom -= frameOffsets.bottom;
                fg.setBounds(drawingBounds);
                Rect framePadding = this.mFramePadding;
                drawingBounds.left += framePadding.left - frameOffsets.left;
                drawingBounds.top += framePadding.top - frameOffsets.top;
                drawingBounds.right -= framePadding.right - frameOffsets.right;
                drawingBounds.bottom -= framePadding.bottom - frameOffsets.bottom;
            }
            Drawable bg = super.getBackground();
            if (bg != null) {
                bg.setBounds(drawingBounds);
            }
            this.mDecorViewExt.markOnDecorSetFrame(this, l10, t2, r10, b4);
        }
        return changed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0132  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.policy.DecorView.onMeasure(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mApplyFloatingVerticalInsets) {
            offsetTopAndBottom(this.mFloatingInsets.top);
        }
        if (this.mApplyFloatingHorizontalInsets) {
            offsetLeftAndRight(this.mFloatingInsets.left);
        }
        updateElevation();
        this.mAllowUpdateElevation = true;
        if (changed && this.mDrawLegacyNavigationBarBackground) {
            getViewRootImpl().requestInvalidateRootRenderNode();
        }
        this.mDecorViewExt.markOnDecorLayout(this, left, top, right, bottom);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.mMenuBackground;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View originalView) {
        return showContextMenuForChildInternal(originalView, Float.NaN, Float.NaN);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View originalView, float x10, float y10) {
        return showContextMenuForChildInternal(originalView, x10, y10);
    }

    private boolean showContextMenuForChildInternal(View originalView, float x10, float y10) {
        MenuPopupHelper showDialog;
        if (this.mWindow.mContextMenuHelper != null) {
            this.mWindow.mContextMenuHelper.dismiss();
            this.mWindow.mContextMenuHelper = null;
        }
        PhoneWindow.PhoneWindowMenuCallback callback = this.mWindow.mContextMenuCallback;
        if (this.mWindow.mContextMenu == null) {
            this.mWindow.mContextMenu = new ContextMenuBuilder(getContext());
            this.mWindow.mContextMenu.setCallback(callback);
        } else {
            this.mWindow.mContextMenu.clearAll();
        }
        boolean isPopup = (Float.isNaN(x10) || Float.isNaN(y10)) ? false : true;
        if (isPopup) {
            showDialog = this.mWindow.mContextMenu.showPopup(getContext(), originalView, x10, y10);
        } else {
            showDialog = this.mWindow.mContextMenu.showDialog(originalView, originalView.getWindowToken());
        }
        if (showDialog != null) {
            callback.setShowDialogForSubmenu(!isPopup);
            showDialog.setPresenterCallback(callback);
        }
        this.mWindow.mContextMenuHelper = showDialog;
        return showDialog != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        return startActionModeForChild(originalView, callback, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View child, ActionMode.Callback callback, int type) {
        return startActionMode(child, callback, type);
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return startActionMode(callback, 0);
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        return startActionMode(this, callback, type);
    }

    private ActionMode startActionMode(View originatingView, ActionMode.Callback callback, int type) {
        ActionMode.Callback2 wrappedCallback = new ActionModeCallback2Wrapper(callback);
        ActionMode mode = null;
        if (this.mWindow.getCallback() != null && !this.mWindow.isDestroyed()) {
            try {
                mode = this.mWindow.getCallback().onWindowStartingActionMode(wrappedCallback, type);
            } catch (AbstractMethodError e2) {
                if (type == 0) {
                    try {
                        mode = this.mWindow.getCallback().onWindowStartingActionMode(wrappedCallback);
                    } catch (AbstractMethodError e10) {
                    }
                }
            }
        }
        if (mode != null) {
            if (mode.getType() == 0) {
                cleanupPrimaryActionMode();
                this.mPrimaryActionMode = mode;
            } else if (mode.getType() == 1) {
                ActionMode actionMode = this.mFloatingActionMode;
                if (actionMode != null) {
                    actionMode.finish();
                }
                this.mFloatingActionMode = mode;
            }
        } else {
            mode = createActionMode(type, wrappedCallback, originatingView);
            if (mode != null && wrappedCallback.onCreateActionMode(mode, mode.getMenu())) {
                setHandledActionMode(mode);
            } else {
                mode = null;
            }
        }
        if (mode != null && this.mWindow.getCallback() != null && !this.mWindow.isDestroyed()) {
            try {
                this.mWindow.getCallback().onActionModeStarted(mode);
            } catch (AbstractMethodError e11) {
            }
        }
        return mode;
    }

    private void cleanupPrimaryActionMode() {
        ActionMode actionMode = this.mPrimaryActionMode;
        if (actionMode != null) {
            actionMode.finish();
            this.mPrimaryActionMode = null;
        }
        ActionBarContextView actionBarContextView = this.mPrimaryActionModeView;
        if (actionBarContextView != null) {
            actionBarContextView.killMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupFloatingActionModeViews() {
        FloatingToolbar floatingToolbar = this.mFloatingToolbar;
        if (floatingToolbar != null) {
            floatingToolbar.dismiss();
            this.mFloatingToolbar = null;
        }
        View view = this.mFloatingActionModeOriginatingView;
        if (view != null) {
            if (this.mFloatingToolbarPreDrawListener != null) {
                view.getViewTreeObserver().removeOnPreDrawListener(this.mFloatingToolbarPreDrawListener);
                this.mFloatingToolbarPreDrawListener = null;
            }
            this.mFloatingActionModeOriginatingView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startChanging() {
        this.mChanging = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finishChanging() {
        this.mChanging = false;
        drawableChanged();
    }

    public void setWindowBackground(Drawable drawable) {
        if (this.mWindow == null) {
            this.mPendingWindowBackground = drawable;
            return;
        }
        if (this.mOriginalBackgroundDrawable != drawable) {
            this.mOriginalBackgroundDrawable = drawable;
            updateBackgroundDrawable();
            if (drawable != null) {
                this.mResizingBackgroundDrawable = enforceNonTranslucentBackground(drawable, this.mWindow.isTranslucent() || this.mWindow.isShowingWallpaper());
            } else {
                this.mResizingBackgroundDrawable = getResizingBackgroundDrawable(this.mWindow.mBackgroundDrawable, this.mWindow.mBackgroundFallbackDrawable, this.mWindow.isTranslucent() || this.mWindow.isShowingWallpaper());
            }
            Drawable drawable2 = this.mResizingBackgroundDrawable;
            if (drawable2 != null) {
                drawable2.getPadding(this.mBackgroundPadding);
            } else {
                this.mBackgroundPadding.setEmpty();
            }
            if (!View.sBrokenWindowBackground) {
                drawableChanged();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
        setWindowBackground(background);
    }

    public void setWindowFrame(Drawable drawable) {
        if (getForeground() != drawable) {
            setForeground(drawable);
            if (drawable != null) {
                drawable.getPadding(this.mFramePadding);
            } else {
                this.mFramePadding.setEmpty();
            }
            drawableChanged();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int visible) {
        updateColorViews(null, true);
        updateDecorCaptionStatus(getResources().getConfiguration());
        View view = this.mStatusGuard;
        if (view != null && view.getVisibility() == 0) {
            updateStatusGuardColor();
        }
    }

    @Override // android.view.View
    public void onSystemBarAppearanceChanged(int appearance) {
        updateColorViews(null, true);
        PhoneWindow phoneWindow = this.mWindow;
        if (phoneWindow != null) {
            phoneWindow.dispatchOnSystemBarAppearanceChanged(appearance);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        WindowManager.LayoutParams attrs = this.mWindow.getAttributes();
        this.mFloatingInsets.setEmpty();
        if ((attrs.flags & 256) == 0) {
            if (attrs.height == -2) {
                this.mFloatingInsets.top = insets.getSystemWindowInsetTop();
                this.mFloatingInsets.bottom = insets.getSystemWindowInsetBottom();
                insets = insets.inset(0, insets.getSystemWindowInsetTop(), 0, insets.getSystemWindowInsetBottom());
            }
            if (this.mWindow.getAttributes().width == -2) {
                this.mFloatingInsets.left = insets.getSystemWindowInsetTop();
                this.mFloatingInsets.right = insets.getSystemWindowInsetBottom();
                insets = insets.inset(insets.getSystemWindowInsetLeft(), 0, insets.getSystemWindowInsetRight(), 0);
            }
        }
        this.mFrameOffsets.set(insets.getSystemWindowInsetsAsRect());
        WindowInsets insets2 = updateStatusGuard(updateColorViews(insets, true));
        if (getForeground() != null) {
            drawableChanged();
        }
        return insets2;
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        return false;
    }

    public static boolean isNavBarToRightEdge(int bottomInset, int rightInset) {
        return bottomInset == 0 && rightInset > 0;
    }

    public static boolean isNavBarToLeftEdge(int bottomInset, int leftInset) {
        return bottomInset == 0 && leftInset > 0;
    }

    public static int getNavBarSize(int bottomInset, int rightInset, int leftInset) {
        return isNavBarToRightEdge(bottomInset, rightInset) ? rightInset : isNavBarToLeftEdge(bottomInset, leftInset) ? leftInset : bottomInset;
    }

    public static void getNavigationBarRect(int canvasWidth, int canvasHeight, Rect systemBarInsets, Rect outRect, float scale) {
        int bottomInset = (int) (systemBarInsets.bottom * scale);
        int leftInset = (int) (systemBarInsets.left * scale);
        int rightInset = (int) (systemBarInsets.right * scale);
        int size = getNavBarSize(bottomInset, rightInset, leftInset);
        if (isNavBarToRightEdge(bottomInset, rightInset)) {
            outRect.set(canvasWidth - size, 0, canvasWidth, canvasHeight);
        } else if (isNavBarToLeftEdge(bottomInset, leftInset)) {
            outRect.set(0, 0, size, canvasHeight);
        } else {
            outRect.set(0, canvasHeight - size, canvasWidth, canvasHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowInsets updateColorViews(WindowInsets insets, boolean animate) {
        int systemBarsAppearance;
        boolean disallowAnimate;
        int statusBarSideInset;
        Insets systemInsets;
        WindowInsets insets2 = insets;
        WindowManager.LayoutParams attrs = this.mWindow.getAttributes();
        int sysUiVisibility = attrs.systemUiVisibility | getWindowSystemUiVisibility();
        WindowInsetsController controller = getWindowInsetsController();
        int requestedVisibleTypes = controller.getRequestedVisibleTypes();
        boolean z10 = true;
        boolean isImeWindow = this.mWindow.getAttributes().type == 2011;
        if (!this.mWindow.mIsFloating || isImeWindow) {
            boolean disallowAnimate2 = (!isLaidOut()) | (((this.mLastWindowFlags ^ attrs.flags) & Integer.MIN_VALUE) != 0);
            this.mLastWindowFlags = attrs.flags;
            ViewRootImpl viewRoot = getViewRootImpl();
            if (viewRoot != null) {
                systemBarsAppearance = viewRoot.mWindowAttributes.insetsFlags.appearance;
            } else {
                systemBarsAppearance = controller.getSystemBarsAppearance();
            }
            int appearance = systemBarsAppearance;
            if (insets2 != null) {
                this.mLastShouldAlwaysConsumeSystemBars = insets.shouldAlwaysConsumeSystemBars();
                boolean clearsCompatInsets = InsetsState.clearsCompatInsets(attrs.type, attrs.flags, getResources().getConfiguration().windowConfiguration.getWindowingMode()) && !this.mLastShouldAlwaysConsumeSystemBars;
                Insets stableBarInsets = insets2.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
                if (clearsCompatInsets) {
                    systemInsets = Insets.NONE;
                } else {
                    systemInsets = Insets.min(insets2.getInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout()), stableBarInsets);
                }
                this.mLastTopInset = systemInsets.top;
                this.mLastBottomInset = systemInsets.bottom;
                this.mLastRightInset = systemInsets.right;
                this.mLastLeftInset = systemInsets.left;
                boolean hasTopStableInset = stableBarInsets.top != 0;
                boolean disallowAnimate3 = disallowAnimate2 | (hasTopStableInset != this.mLastHasTopStableInset);
                this.mLastHasTopStableInset = hasTopStableInset;
                boolean hasBottomStableInset = stableBarInsets.bottom != 0;
                boolean disallowAnimate4 = disallowAnimate3 | (hasBottomStableInset != this.mLastHasBottomStableInset);
                this.mLastHasBottomStableInset = hasBottomStableInset;
                boolean hasRightStableInset = stableBarInsets.right != 0;
                boolean disallowAnimate5 = disallowAnimate4 | (hasRightStableInset != this.mLastHasRightStableInset);
                this.mLastHasRightStableInset = hasRightStableInset;
                boolean hasLeftStableInset = stableBarInsets.left != 0;
                boolean disallowAnimate6 = disallowAnimate5 | (hasLeftStableInset != this.mLastHasLeftStableInset);
                this.mLastHasLeftStableInset = hasLeftStableInset;
                this.mLastSuppressScrimTypes = insets.getSuppressScrimTypes();
                disallowAnimate = disallowAnimate6;
            } else {
                disallowAnimate = disallowAnimate2;
            }
            boolean navBarToRightEdge = isNavBarToRightEdge(this.mLastBottomInset, this.mLastRightInset);
            boolean navBarToLeftEdge = isNavBarToLeftEdge(this.mLastBottomInset, this.mLastLeftInset);
            int navBarSize = getNavBarSize(this.mLastBottomInset, this.mLastRightInset, this.mLastLeftInset);
            updateColorViewInt(this.mNavigationColorViewState, calculateNavigationBarColor(appearance), this.mWindow.mNavigationBarDividerColor, navBarSize, navBarToRightEdge || navBarToLeftEdge, navBarToLeftEdge, 0, animate && !disallowAnimate, this.mForceWindowDrawsBarBackgrounds, requestedVisibleTypes);
            boolean oldDrawLegacy = this.mDrawLegacyNavigationBarBackground;
            boolean z11 = (isImeWindow || this.mNavigationColorViewState.visible) && (this.mWindow.getAttributes().flags & Integer.MIN_VALUE) == 0;
            this.mDrawLegacyNavigationBarBackground = z11;
            if (oldDrawLegacy != z11) {
                this.mDrawLegacyNavigationBarBackgroundHandled = this.mWindow.onDrawLegacyNavigationBarBackgroundChanged(z11);
                if (viewRoot != null) {
                    viewRoot.requestInvalidateRootRenderNode();
                }
            }
            boolean statusBarNeedsRightInset = navBarToRightEdge && this.mNavigationColorViewState.present;
            boolean statusBarNeedsLeftInset = navBarToLeftEdge && this.mNavigationColorViewState.present;
            if (statusBarNeedsRightInset) {
                statusBarSideInset = this.mLastRightInset;
            } else {
                statusBarSideInset = statusBarNeedsLeftInset ? this.mLastLeftInset : 0;
            }
            int statusBarColor = calculateStatusBarColor(appearance);
            updateColorViewInt(this.mStatusColorViewState, statusBarColor, 0, this.mLastTopInset, false, statusBarNeedsLeftInset, statusBarSideInset, animate && !disallowAnimate, this.mForceWindowDrawsBarBackgrounds, requestedVisibleTypes);
            if (this.mHasCaption) {
                this.mDecorCaptionView.getCaption().setBackgroundColor(statusBarColor);
                updateDecorCaptionShade();
            }
        }
        boolean hideNavigation = (sysUiVisibility & 2) != 0 || (requestedVisibleTypes & WindowInsets.Type.navigationBars()) == 0;
        boolean decorFitsSystemWindows = this.mWindow.mDecorFitsSystemWindows;
        boolean forceConsumingNavBar = ((this.mForceWindowDrawsBarBackgrounds || this.mDrawLegacyNavigationBarBackgroundHandled) && (attrs.flags & Integer.MIN_VALUE) == 0 && (sysUiVisibility & 512) == 0 && decorFitsSystemWindows && !hideNavigation) || (this.mLastShouldAlwaysConsumeSystemBars && hideNavigation);
        boolean consumingNavBar = ((attrs.flags & Integer.MIN_VALUE) != 0 && (sysUiVisibility & 512) == 0 && decorFitsSystemWindows && !hideNavigation) || forceConsumingNavBar;
        boolean fullscreen = ((sysUiVisibility & 4) == 0 && (attrs.flags & 1024) == 0 && (requestedVisibleTypes & WindowInsets.Type.statusBars()) != 0) ? false : true;
        if (((sysUiVisibility & 1024) != 0 || !decorFitsSystemWindows || (attrs.flags & 256) != 0 || (attrs.flags & 65536) != 0 || !this.mForceWindowDrawsBarBackgrounds || this.mLastTopInset == 0) && (!this.mLastShouldAlwaysConsumeSystemBars || !fullscreen)) {
            z10 = false;
        }
        boolean consumingStatusBar = z10;
        int consumedTop = consumingStatusBar ? this.mLastTopInset : 0;
        int consumedRight = consumingNavBar ? this.mLastRightInset : 0;
        int consumedBottom = consumingNavBar ? this.mLastBottomInset : 0;
        int consumedLeft = consumingNavBar ? this.mLastLeftInset : 0;
        int consumedBottom2 = this.mDecorViewExt.forceMarginByTaskBar(insets2, this, consumedBottom);
        ViewGroup viewGroup = this.mContentRoot;
        if (viewGroup != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mContentRoot.getLayoutParams();
            if (lp.topMargin != consumedTop || lp.rightMargin != consumedRight || lp.bottomMargin != consumedBottom2 || lp.leftMargin != consumedLeft) {
                lp.topMargin = consumedTop;
                lp.rightMargin = consumedRight;
                lp.bottomMargin = consumedBottom2;
                lp.leftMargin = consumedLeft;
                this.mContentRoot.setLayoutParams(lp);
                if (insets2 == null) {
                    requestApplyInsets();
                }
            }
            if (insets2 != null) {
                insets2 = insets2.inset(consumedLeft, consumedTop, consumedRight, consumedBottom2);
            }
        }
        if (!forceConsumingNavBar || hideNavigation || this.mDrawLegacyNavigationBarBackgroundHandled) {
            this.mBackgroundInsets = Insets.NONE;
        } else {
            this.mBackgroundInsets = Insets.of(this.mLastLeftInset, 0, this.mLastRightInset, this.mLastBottomInset);
        }
        updateBackgroundDrawable();
        return insets2;
    }

    private void updateBackgroundDrawable() {
        if (this.mBackgroundInsets == null) {
            this.mBackgroundInsets = Insets.NONE;
        }
        if (this.mBackgroundInsets.equals(this.mLastBackgroundInsets) && this.mBackgroundBlurDrawable == this.mLastBackgroundBlurDrawable && this.mLastOriginalBackgroundDrawable == this.mOriginalBackgroundDrawable) {
            return;
        }
        Drawable destDrawable = this.mOriginalBackgroundDrawable;
        if (this.mBackgroundBlurDrawable != null) {
            destDrawable = new LayerDrawable(new Drawable[]{this.mBackgroundBlurDrawable, this.mOriginalBackgroundDrawable});
        }
        if (destDrawable != null && !this.mBackgroundInsets.equals(Insets.NONE)) {
            destDrawable = new InsetDrawable(destDrawable, this.mBackgroundInsets.left, this.mBackgroundInsets.top, this.mBackgroundInsets.right, this.mBackgroundInsets.bottom) { // from class: com.android.internal.policy.DecorView.2
                @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
                public boolean getPadding(Rect padding) {
                    return getDrawable().getPadding(padding);
                }
            };
        }
        super.setBackgroundDrawable(destDrawable);
        this.mLastBackgroundInsets = this.mBackgroundInsets;
        this.mLastBackgroundBlurDrawable = this.mBackgroundBlurDrawable;
        this.mLastOriginalBackgroundDrawable = this.mOriginalBackgroundDrawable;
    }

    private void updateBackgroundBlurCorners() {
        if (this.mBackgroundBlurDrawable == null) {
            return;
        }
        float cornerRadius = 0.0f;
        if (this.mBackgroundBlurRadius != 0 && this.mOriginalBackgroundDrawable != null) {
            Outline outline = new Outline();
            this.mOriginalBackgroundDrawable.getOutline(outline);
            cornerRadius = outline.mMode == 1 ? outline.getRadius() : 0.0f;
        }
        this.mBackgroundBlurDrawable.setCornerRadius(cornerRadius);
    }

    private void updateBackgroundBlurRadius() {
        if (getViewRootImpl() == null) {
            return;
        }
        int i10 = (this.mCrossWindowBlurEnabled && this.mWindow.isTranslucent()) ? this.mOriginalBackgroundBlurRadius : 0;
        this.mBackgroundBlurRadius = i10;
        if (this.mBackgroundBlurDrawable == null && i10 > 0) {
            this.mBackgroundBlurDrawable = getViewRootImpl().createBackgroundBlurDrawable();
            updateBackgroundDrawable();
        }
        BackgroundBlurDrawable backgroundBlurDrawable = this.mBackgroundBlurDrawable;
        if (backgroundBlurDrawable != null) {
            backgroundBlurDrawable.setBlurRadius(this.mBackgroundBlurRadius);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundBlurRadius(int blurRadius) {
        this.mOriginalBackgroundBlurRadius = blurRadius;
        if (blurRadius > 0) {
            if (this.mCrossWindowBlurEnabledListener == null) {
                this.mCrossWindowBlurEnabledListener = new Consumer() { // from class: com.android.internal.policy.DecorView$$ExternalSyntheticLambda1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        DecorView.this.lambda$setBackgroundBlurRadius$1((Boolean) obj);
                    }
                };
                ((WindowManager) getContext().getSystemService(WindowManager.class)).addCrossWindowBlurEnabledListener(this.mCrossWindowBlurEnabledListener);
                getViewTreeObserver().addOnPreDrawListener(this.mBackgroundBlurOnPreDrawListener);
                return;
            }
            updateBackgroundBlurRadius();
            return;
        }
        if (this.mCrossWindowBlurEnabledListener != null) {
            updateBackgroundBlurRadius();
            removeBackgroundBlurDrawable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBackgroundBlurRadius$1(Boolean enabled) {
        this.mCrossWindowBlurEnabled = enabled.booleanValue();
        updateBackgroundBlurRadius();
    }

    void removeBackgroundBlurDrawable() {
        if (this.mCrossWindowBlurEnabledListener != null) {
            ((WindowManager) getContext().getSystemService(WindowManager.class)).removeCrossWindowBlurEnabledListener(this.mCrossWindowBlurEnabledListener);
            this.mCrossWindowBlurEnabledListener = null;
        }
        getViewTreeObserver().removeOnPreDrawListener(this.mBackgroundBlurOnPreDrawListener);
        this.mBackgroundBlurDrawable = null;
        updateBackgroundDrawable();
    }

    @Override // android.view.View
    public Drawable getBackground() {
        return this.mOriginalBackgroundDrawable;
    }

    private int calculateStatusBarColor(int appearance) {
        return calculateBarColor(this.mWindow.getAttributes().flags, 67108864, this.mSemiTransparentBarColor, this.mWindow.mStatusBarColor, appearance, 8, this.mWindow.mEnsureStatusBarContrastWhenTransparent && (this.mLastSuppressScrimTypes & WindowInsets.Type.statusBars()) == 0);
    }

    private int calculateNavigationBarColor(int appearance) {
        return calculateBarColor(this.mWindow.getAttributes().flags, 134217728, this.mSemiTransparentBarColor, this.mWindow.mNavigationBarColor, appearance, 16, this.mWindow.mEnsureNavigationBarContrastWhenTransparent && (this.mLastSuppressScrimTypes & WindowInsets.Type.navigationBars()) == 0);
    }

    public static int calculateBarColor(int flags, int translucentFlag, int semiTransparentBarColor, int barColor, int appearance, int lightAppearanceFlag, boolean scrimTransparent) {
        if ((flags & translucentFlag) != 0) {
            return semiTransparentBarColor;
        }
        if ((Integer.MIN_VALUE & flags) == 0 && (isClosedSuperFirewall || lightAppearanceFlag == 8)) {
            return -16777216;
        }
        if (scrimTransparent && Color.alpha(barColor) == 0) {
            boolean light = (appearance & lightAppearanceFlag) != 0;
            return light ? SCRIM_LIGHT : semiTransparentBarColor;
        }
        return barColor;
    }

    private int getCurrentColor(ColorViewState state) {
        if (state.visible) {
            return state.color;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f3, code lost:
    
        if (r7.leftMargin != r12) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateColorViewInt(final com.android.internal.policy.DecorView.ColorViewState r20, int r21, int r22, int r23, boolean r24, boolean r25, int r26, boolean r27, boolean r28, int r29) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.policy.DecorView.updateColorViewInt(com.android.internal.policy.DecorView$ColorViewState, int, int, int, boolean, boolean, int, boolean, boolean, int):void");
    }

    private static void setColor(View v2, int color, int dividerColor, boolean verticalBar, boolean seascape) {
        if (dividerColor != 0) {
            Pair<Boolean, Boolean> dir = (Pair) v2.getTag();
            if (dir == null || ((Boolean) dir.first).booleanValue() != verticalBar || ((Boolean) dir.second).booleanValue() != seascape) {
                int size = Math.round(TypedValue.applyDimension(1, 1.0f, v2.getContext().getResources().getDisplayMetrics()));
                v2.setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(dividerColor), new InsetDrawable((Drawable) new ColorDrawable(color), (!verticalBar || seascape) ? 0 : size, !verticalBar ? size : 0, (verticalBar && seascape) ? size : 0, 0)}));
                v2.setTag(new Pair(Boolean.valueOf(verticalBar), Boolean.valueOf(seascape)));
                return;
            } else {
                LayerDrawable d10 = (LayerDrawable) v2.getBackground();
                InsetDrawable inset = (InsetDrawable) d10.getDrawable(1);
                ((ColorDrawable) inset.getDrawable()).setColor(color);
                ((ColorDrawable) d10.getDrawable(0)).setColor(dividerColor);
                return;
            }
        }
        v2.setTag(null);
        v2.setBackgroundColor(color);
    }

    private void updateColorViewTranslations() {
        int rootScrollY = this.mRootScrollY;
        if (this.mStatusColorViewState.view != null) {
            this.mStatusColorViewState.view.setTranslationY(rootScrollY > 0 ? rootScrollY : 0.0f);
        }
        if (this.mNavigationColorViewState.view != null) {
            this.mNavigationColorViewState.view.setTranslationY(rootScrollY < 0 ? rootScrollY : 0.0f);
        }
    }

    private WindowInsets updateStatusGuard(WindowInsets insets) {
        boolean showStatusGuard;
        int i10;
        WindowInsets insets2 = insets;
        ActionBarContextView actionBarContextView = this.mPrimaryActionModeView;
        if (actionBarContextView == null) {
            showStatusGuard = false;
            i10 = 0;
        } else if (!(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            showStatusGuard = false;
            i10 = 0;
        } else {
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) this.mPrimaryActionModeView.getLayoutParams();
            boolean mlpChanged = false;
            if (this.mPrimaryActionModeView.isShown()) {
                if (this.mTempRect == null) {
                    this.mTempRect = new Rect();
                }
                Rect rect = this.mTempRect;
                WindowInsets innerInsets = this.mWindow.mContentParent.computeSystemWindowInsets(insets2, rect);
                int newTopMargin = innerInsets.getSystemWindowInsetTop();
                int newLeftMargin = innerInsets.getSystemWindowInsetLeft();
                int newRightMargin = innerInsets.getSystemWindowInsetRight();
                WindowInsets rootInsets = getRootWindowInsets();
                int newGuardLeftMargin = rootInsets.getSystemWindowInsetLeft();
                int newGuardRightMargin = rootInsets.getSystemWindowInsetRight();
                if (mlp.topMargin != newTopMargin || mlp.leftMargin != newLeftMargin || mlp.rightMargin != newRightMargin) {
                    mlpChanged = true;
                    mlp.topMargin = newTopMargin;
                    mlp.leftMargin = newLeftMargin;
                    mlp.rightMargin = newRightMargin;
                }
                if (newTopMargin > 0 && this.mStatusGuard == null) {
                    View view = new View(this.mContext);
                    this.mStatusGuard = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, mlp.topMargin, 51);
                    lp.leftMargin = newGuardLeftMargin;
                    lp.rightMargin = newGuardRightMargin;
                    addView(this.mStatusGuard, indexOfChild(this.mStatusColorViewState.view), lp);
                } else {
                    View view2 = this.mStatusGuard;
                    if (view2 != null) {
                        FrameLayout.LayoutParams lp2 = (FrameLayout.LayoutParams) view2.getLayoutParams();
                        if (lp2.height != mlp.topMargin || lp2.leftMargin != newGuardLeftMargin || lp2.rightMargin != newGuardRightMargin) {
                            lp2.height = mlp.topMargin;
                            lp2.leftMargin = newGuardLeftMargin;
                            lp2.rightMargin = newGuardRightMargin;
                            this.mStatusGuard.setLayoutParams(lp2);
                        }
                    }
                }
                View view3 = this.mStatusGuard;
                boolean showStatusGuard2 = view3 != null;
                if (showStatusGuard2 && view3.getVisibility() != 0) {
                    updateStatusGuardColor();
                }
                boolean nonOverlay = (this.mWindow.getLocalFeaturesPrivate() & 1024) == 0;
                if (nonOverlay && showStatusGuard2) {
                    insets2 = insets2.inset(0, insets.getSystemWindowInsetTop(), 0, 0);
                }
                showStatusGuard = showStatusGuard2;
                i10 = 0;
            } else {
                showStatusGuard = false;
                if (mlp.topMargin == 0 && mlp.leftMargin == 0 && mlp.rightMargin == 0) {
                    i10 = 0;
                } else {
                    mlpChanged = true;
                    i10 = 0;
                    mlp.topMargin = 0;
                }
            }
            if (mlpChanged) {
                this.mPrimaryActionModeView.setLayoutParams(mlp);
            }
        }
        View view4 = this.mStatusGuard;
        if (view4 != null) {
            view4.setVisibility(showStatusGuard ? i10 : 8);
        }
        return insets2;
    }

    private void updateStatusGuardColor() {
        int color;
        boolean lightStatusBar = (getWindowSystemUiVisibility() & 8192) != 0;
        View view = this.mStatusGuard;
        if (lightStatusBar) {
            color = this.mContext.getColor(17170943);
        } else {
            color = this.mContext.getColor(17170942);
        }
        view.setBackgroundColor(color);
    }

    public void updatePictureInPictureOutlineProvider(boolean isInPictureInPictureMode) {
        if (this.mIsInPictureInPictureMode == isInPictureInPictureMode) {
            return;
        }
        if (isInPictureInPictureMode) {
            Window.WindowControllerCallback callback = this.mWindow.getWindowControllerCallback();
            if (callback != null && callback.isTaskRoot()) {
                super.setOutlineProvider(PIP_OUTLINE_PROVIDER);
            }
        } else {
            ViewOutlineProvider outlineProvider = getOutlineProvider();
            ViewOutlineProvider viewOutlineProvider = this.mLastOutlineProvider;
            if (outlineProvider != viewOutlineProvider) {
                setOutlineProvider(viewOutlineProvider);
            }
        }
        this.mIsInPictureInPictureMode = isInPictureInPictureMode;
    }

    @Override // android.view.View
    public void setOutlineProvider(ViewOutlineProvider provider) {
        super.setOutlineProvider(provider);
        this.mLastOutlineProvider = provider;
    }

    private void drawableChanged() {
        if (this.mChanging) {
            return;
        }
        Rect framePadding = this.mFramePadding;
        if (framePadding == null) {
            framePadding = new Rect();
        }
        Rect backgroundPadding = this.mBackgroundPadding;
        if (backgroundPadding == null) {
            backgroundPadding = new Rect();
        }
        setPadding(framePadding.left + backgroundPadding.left, framePadding.top + backgroundPadding.top, framePadding.right + backgroundPadding.right, framePadding.bottom + backgroundPadding.bottom);
        requestLayout();
        invalidate();
        int opacity = -1;
        WindowConfiguration winConfig = getResources().getConfiguration().windowConfiguration;
        boolean renderShadowsInCompositor = this.mWindow.mRenderShadowsInCompositor;
        if (winConfig.hasWindowShadow() && !renderShadowsInCompositor) {
            opacity = -3;
        } else {
            Drawable bg = getBackground();
            Drawable fg = getForeground();
            if (bg != null) {
                if (fg == null) {
                    opacity = bg.getOpacity();
                } else if (framePadding.left <= 0 && framePadding.top <= 0 && framePadding.right <= 0 && framePadding.bottom <= 0) {
                    int fop = fg.getOpacity();
                    int bop = bg.getOpacity();
                    if (fop == -1 || bop == -1) {
                        opacity = -1;
                    } else if (fop == 0) {
                        opacity = bop;
                    } else if (bop == 0) {
                        opacity = fop;
                    } else {
                        opacity = Drawable.resolveOpacity(fop, bop);
                    }
                } else {
                    opacity = -3;
                }
            }
        }
        this.mDefaultOpacity = opacity;
        if (this.mFeatureId < 0) {
            this.mWindow.setDefaultWindowFormat(opacity);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (this.mWindow.hasFeature(0) && !hasWindowFocus && this.mWindow.mPanelChordingKey != 0) {
            this.mWindow.closePanel(0);
        }
        Window.Callback cb2 = this.mWindow.getCallback();
        if (cb2 != null && !this.mWindow.isDestroyed() && this.mFeatureId < 0) {
            cb2.onWindowFocusChanged(hasWindowFocus);
        }
        ActionMode actionMode = this.mPrimaryActionMode;
        if (actionMode != null) {
            actionMode.onWindowFocusChanged(hasWindowFocus);
        }
        ActionMode actionMode2 = this.mFloatingActionMode;
        if (actionMode2 != null) {
            actionMode2.onWindowFocusChanged(hasWindowFocus);
        }
        updateElevation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window.Callback cb2 = this.mWindow.getCallback();
        if (cb2 != null && !this.mWindow.isDestroyed() && this.mFeatureId < 0) {
            cb2.onAttachedToWindow();
        }
        if (this.mFeatureId == -1) {
            this.mWindow.openPanelsAfterRestore();
        }
        if (!this.mWindowResizeCallbacksAdded) {
            getViewRootImpl().addWindowCallbacks(this);
            this.mWindowResizeCallbacksAdded = true;
        } else {
            BackdropFrameRenderer backdropFrameRenderer = this.mBackdropFrameRenderer;
            if (backdropFrameRenderer != null) {
                backdropFrameRenderer.onConfigurationChange();
            }
        }
        updateBackgroundBlurRadius();
        this.mWindow.onViewRootImplSet(getViewRootImpl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Window.Callback cb2 = this.mWindow.getCallback();
        if (cb2 != null && this.mFeatureId < 0) {
            cb2.onDetachedFromWindow();
        }
        if (this.mWindow.mDecorContentParent != null) {
            this.mWindow.mDecorContentParent.dismissPopups();
        }
        if (this.mPrimaryActionModePopup != null) {
            removeCallbacks(this.mShowPrimaryActionModePopup);
            if (this.mPrimaryActionModePopup.isShowing()) {
                this.mPrimaryActionModePopup.dismiss();
            }
            this.mPrimaryActionModePopup = null;
        }
        FloatingToolbar floatingToolbar = this.mFloatingToolbar;
        if (floatingToolbar != null) {
            floatingToolbar.dismiss();
            this.mFloatingToolbar = null;
        }
        removeBackgroundBlurDrawable();
        PhoneWindow.PanelFeatureState st = this.mWindow.getPanelState(0, false);
        if (st != null && st.menu != null && this.mFeatureId < 0) {
            st.menu.close();
        }
        releaseThreadedRenderer();
        if (this.mWindowResizeCallbacksAdded) {
            getViewRootImpl().removeWindowCallbacks(this);
            this.mWindowResizeCallbacksAdded = false;
        }
        this.mPendingInsetsController.detach();
    }

    @Override // android.view.View
    public void onCloseSystemDialogs(String reason) {
        if (this.mFeatureId >= 0) {
            this.mWindow.closeAllPanels();
        }
    }

    public SurfaceHolder.Callback2 willYouTakeTheSurface() {
        if (this.mFeatureId < 0) {
            return this.mWindow.mTakeSurfaceCallback;
        }
        return null;
    }

    public InputQueue.Callback willYouTakeTheInputQueue() {
        if (this.mFeatureId < 0) {
            return this.mWindow.mTakeInputQueueCallback;
        }
        return null;
    }

    public void setSurfaceType(int type) {
        this.mWindow.setType(type);
    }

    public void setSurfaceFormat(int format) {
        this.mWindow.setFormat(format);
    }

    public void setSurfaceKeepScreenOn(boolean keepOn) {
        if (keepOn) {
            this.mWindow.addFlags(128);
        } else {
            this.mWindow.clearFlags(128);
        }
    }

    public void onRootViewScrollYChanged(int rootScrollY) {
        this.mRootScrollY = rootScrollY;
        DecorCaptionView decorCaptionView = this.mDecorCaptionView;
        if (decorCaptionView != null) {
            decorCaptionView.onRootViewScrollYChanged(rootScrollY);
        }
        updateColorViewTranslations();
    }

    public PendingInsetsController providePendingInsetsController() {
        return this.mPendingInsetsController;
    }

    private ActionMode createActionMode(int type, ActionMode.Callback2 callback, View originatingView) {
        switch (type) {
            case 1:
                return createFloatingActionMode(originatingView, callback);
            default:
                return createStandaloneActionMode(callback);
        }
    }

    private void setHandledActionMode(ActionMode mode) {
        if (mode.getType() == 0) {
            setHandledPrimaryActionMode(mode);
        } else if (mode.getType() == 1) {
            setHandledFloatingActionMode(mode);
        }
    }

    private ActionMode createStandaloneActionMode(ActionMode.Callback callback) {
        Context actionBarContext;
        endOnGoingFadeAnimation();
        cleanupPrimaryActionMode();
        ActionBarContextView actionBarContextView = this.mPrimaryActionModeView;
        if (actionBarContextView == null || !actionBarContextView.isAttachedToWindow()) {
            if (this.mWindow.isFloating()) {
                TypedValue outValue = new TypedValue();
                Resources.Theme baseTheme = this.mContext.getTheme();
                baseTheme.resolveAttribute(16843825, outValue, true);
                if (outValue.resourceId != 0) {
                    Resources.Theme actionBarTheme = this.mContext.getResources().newTheme();
                    actionBarTheme.setTo(baseTheme);
                    actionBarTheme.applyStyle(outValue.resourceId, true);
                    actionBarContext = new ContextThemeWrapper(this.mContext, 0);
                    actionBarContext.getTheme().setTo(actionBarTheme);
                } else {
                    actionBarContext = this.mContext;
                }
                this.mPrimaryActionModeView = new ActionBarContextView(actionBarContext);
                PopupWindow popupWindow = new PopupWindow(actionBarContext, (AttributeSet) null, 17956872);
                this.mPrimaryActionModePopup = popupWindow;
                popupWindow.setWindowLayoutType(2);
                this.mPrimaryActionModePopup.setContentView(this.mPrimaryActionModeView);
                this.mPrimaryActionModePopup.setWidth(-1);
                actionBarContext.getTheme().resolveAttribute(16843499, outValue, true);
                int height = TypedValue.complexToDimensionPixelSize(outValue.data, actionBarContext.getResources().getDisplayMetrics());
                this.mPrimaryActionModeView.setContentHeight(height);
                this.mPrimaryActionModePopup.setHeight(-2);
                this.mShowPrimaryActionModePopup = new Runnable() { // from class: com.android.internal.policy.DecorView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DecorView.this.mPrimaryActionModePopup.showAtLocation(DecorView.this.mPrimaryActionModeView.getApplicationWindowToken(), 55, 0, 0);
                        DecorView.this.endOnGoingFadeAnimation();
                        if (DecorView.this.shouldAnimatePrimaryActionModeView()) {
                            DecorView decorView = DecorView.this;
                            decorView.mFadeAnim = ObjectAnimator.ofFloat(decorView.mPrimaryActionModeView, (Property<ActionBarContextView, Float>) View.ALPHA, 0.0f, 1.0f);
                            DecorView.this.mFadeAnim.addListener(new AnimatorListenerAdapter() { // from class: com.android.internal.policy.DecorView.4.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animation) {
                                    DecorView.this.mPrimaryActionModeView.setVisibility(0);
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animation) {
                                    DecorView.this.mPrimaryActionModeView.setAlpha(1.0f);
                                    DecorView.this.mFadeAnim = null;
                                }
                            });
                            DecorView.this.mFadeAnim.start();
                            return;
                        }
                        DecorView.this.mPrimaryActionModeView.setAlpha(1.0f);
                        DecorView.this.mPrimaryActionModeView.setVisibility(0);
                    }
                };
            } else {
                ViewStub stub = (ViewStub) findViewById(16908746);
                if (stub != null) {
                    this.mPrimaryActionModeView = stub.inflate();
                    this.mPrimaryActionModePopup = null;
                }
            }
        }
        ActionBarContextView actionBarContextView2 = this.mPrimaryActionModeView;
        if (actionBarContextView2 == null) {
            return null;
        }
        actionBarContextView2.killMode();
        return new StandaloneActionMode(this.mPrimaryActionModeView.getContext(), this.mPrimaryActionModeView, callback, this.mPrimaryActionModePopup == null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endOnGoingFadeAnimation() {
        ObjectAnimator objectAnimator = this.mFadeAnim;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
    }

    private void setHandledPrimaryActionMode(ActionMode mode) {
        endOnGoingFadeAnimation();
        this.mPrimaryActionMode = mode;
        mode.invalidate();
        this.mPrimaryActionModeView.initForMode(this.mPrimaryActionMode);
        if (this.mPrimaryActionModePopup != null) {
            post(this.mShowPrimaryActionModePopup);
        } else if (shouldAnimatePrimaryActionModeView()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mPrimaryActionModeView, (Property<ActionBarContextView, Float>) View.ALPHA, 0.0f, 1.0f);
            this.mFadeAnim = ofFloat;
            this.mDecorViewExt.hookSetHandledPrimaryActionMode(ofFloat);
            this.mFadeAnim.addListener(new AnimatorListenerAdapter() { // from class: com.android.internal.policy.DecorView.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    DecorView.this.mPrimaryActionModeView.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    DecorView.this.mPrimaryActionModeView.setAlpha(1.0f);
                    DecorView.this.mFadeAnim = null;
                }
            });
            this.mFadeAnim.start();
        } else {
            this.mPrimaryActionModeView.setAlpha(1.0f);
            this.mPrimaryActionModeView.setVisibility(0);
        }
        this.mPrimaryActionModeView.sendAccessibilityEvent(32);
    }

    boolean shouldAnimatePrimaryActionModeView() {
        return isLaidOut();
    }

    private ActionMode createFloatingActionMode(View originatingView, ActionMode.Callback2 callback) {
        ActionMode actionMode = this.mFloatingActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        cleanupFloatingActionModeViews();
        this.mFloatingToolbar = new FloatingToolbar(this.mWindow);
        final FloatingActionMode mode = new FloatingActionMode(this.mContext, callback, originatingView, this.mFloatingToolbar);
        this.mFloatingActionModeOriginatingView = originatingView;
        this.mFloatingToolbarPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.internal.policy.DecorView.6
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                mode.updateViewLocationInWindow();
                return true;
            }
        };
        return mode;
    }

    private void setHandledFloatingActionMode(ActionMode mode) {
        this.mFloatingActionMode = mode;
        mode.invalidate();
        this.mFloatingActionModeOriginatingView.getViewTreeObserver().addOnPreDrawListener(this.mFloatingToolbarPreDrawListener);
    }

    void enableCaption(boolean attachedAndVisible) {
        if (this.mHasCaption != attachedAndVisible) {
            this.mHasCaption = attachedAndVisible;
            if (getForeground() != null) {
                drawableChanged();
            }
            notifyCaptionHeightChanged();
        }
    }

    public void notifyCaptionHeightChanged() {
        if (!ViewRootImpl.CAPTION_ON_SHELL) {
            getWindowInsetsController().setCaptionInsetsHeight(getCaptionInsetsHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWindow(PhoneWindow phoneWindow) {
        this.mWindow = phoneWindow;
        this.mDecorViewExt.updatePhoneWindow(phoneWindow);
        Context context = getContext();
        if (context instanceof DecorContext) {
            DecorContext decorContext = (DecorContext) context;
            decorContext.setPhoneWindow(this.mWindow);
        }
        if (this.mPendingWindowBackground != null) {
            Drawable background = this.mPendingWindowBackground;
            this.mPendingWindowBackground = null;
            setWindowBackground(background);
        }
    }

    @Override // android.view.View
    public Resources getResources() {
        return getContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateDecorCaptionStatus(newConfig);
        initializeElevation();
        this.mDecorViewExt.requestUpdateColorViewsForPocketStudio(getContext(), this, newConfig);
        this.mDecorViewExt.requestLayoutForDarkModeBackgroundView();
    }

    @Override // android.view.View
    public void onMovedToDisplay(int displayId, Configuration config) {
        super.onMovedToDisplay(displayId, config);
        getContext().updateDisplay(displayId);
    }

    private boolean isFillingScreen(Configuration config) {
        boolean isFullscreen = config.windowConfiguration.getWindowingMode() == 1;
        return isFullscreen && ((getWindowSystemUiVisibility() | getSystemUiVisibility()) & 4) != 0;
    }

    private void updateDecorCaptionStatus(Configuration config) {
        boolean displayWindowDecor = config.windowConfiguration.hasWindowDecorCaption() && !isFillingScreen(config);
        DecorCaptionView decorCaptionView = this.mDecorCaptionView;
        if (decorCaptionView == null && displayWindowDecor) {
            LayoutInflater inflater = this.mWindow.getLayoutInflater();
            DecorCaptionView createDecorCaptionView = createDecorCaptionView(inflater);
            this.mDecorCaptionView = createDecorCaptionView;
            if (createDecorCaptionView != null) {
                if (createDecorCaptionView.getParent() == null) {
                    addView((View) this.mDecorCaptionView, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                removeView(this.mContentRoot);
                this.mDecorCaptionView.addView(this.mContentRoot, new ViewGroup.MarginLayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (decorCaptionView != null) {
            decorCaptionView.onConfigurationChanged(displayWindowDecor);
            enableCaption(displayWindowDecor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResourcesLoaded(LayoutInflater inflater, int layoutResource) {
        if (this.mBackdropFrameRenderer != null) {
            loadBackgroundDrawablesIfNeeded();
            this.mBackdropFrameRenderer.onResourcesLoaded(this, this.mResizingBackgroundDrawable, this.mCaptionBackgroundDrawable, this.mUserCaptionBackgroundDrawable, getCurrentColor(this.mStatusColorViewState), getCurrentColor(this.mNavigationColorViewState));
        }
        this.mDecorCaptionView = createDecorCaptionView(inflater);
        View root = inflater.inflate(layoutResource, (ViewGroup) null);
        DecorCaptionView decorCaptionView = this.mDecorCaptionView;
        if (decorCaptionView != null) {
            if (decorCaptionView.getParent() == null) {
                addView((View) this.mDecorCaptionView, new ViewGroup.LayoutParams(-1, -1));
            }
            this.mDecorCaptionView.addView(root, new ViewGroup.MarginLayoutParams(-1, -1));
        } else {
            addView(root, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        this.mContentRoot = (ViewGroup) root;
        initializeElevation();
    }

    private void loadBackgroundDrawablesIfNeeded() {
        if (this.mResizingBackgroundDrawable == null) {
            Drawable resizingBackgroundDrawable = getResizingBackgroundDrawable(this.mWindow.mBackgroundDrawable, this.mWindow.mBackgroundFallbackDrawable, this.mWindow.isTranslucent() || this.mWindow.isShowingWallpaper());
            this.mResizingBackgroundDrawable = resizingBackgroundDrawable;
            if (resizingBackgroundDrawable == null) {
                Log.w(this.mLogTag, "Failed to find background drawable for PhoneWindow=" + ((Object) this.mWindow));
            }
        }
        if (this.mCaptionBackgroundDrawable == null) {
            this.mCaptionBackgroundDrawable = getContext().getDrawable(17302152);
        }
        Drawable drawable = this.mResizingBackgroundDrawable;
        if (drawable != null) {
            this.mLastBackgroundDrawableCb = drawable.getCallback();
            this.mResizingBackgroundDrawable.setCallback(null);
        }
    }

    private DecorCaptionView createDecorCaptionView(LayoutInflater inflater) {
        DecorCaptionView decorCaptionView = null;
        for (int i10 = getChildCount() - 1; i10 >= 0 && decorCaptionView == null; i10--) {
            View view = getChildAt(i10);
            if (view instanceof DecorCaptionView) {
                decorCaptionView = (DecorCaptionView) view;
                removeViewAt(i10);
            }
        }
        WindowManager.LayoutParams attrs = this.mWindow.getAttributes();
        boolean isApplication = attrs.type == 1 || attrs.type == 2 || attrs.type == 4;
        WindowConfiguration winConfig = getResources().getConfiguration().windowConfiguration;
        if (!this.mWindow.isFloating() && isApplication && winConfig.hasWindowDecorCaption() && !ViewRootImpl.CAPTION_ON_SHELL) {
            if (decorCaptionView == null) {
                decorCaptionView = inflateDecorCaptionView(inflater);
            }
            decorCaptionView.setPhoneWindow(this.mWindow, true);
        } else {
            decorCaptionView = null;
        }
        enableCaption(decorCaptionView != null);
        return decorCaptionView;
    }

    private DecorCaptionView inflateDecorCaptionView(LayoutInflater inflater) {
        Context context = getContext();
        LayoutInflater inflater2 = LayoutInflater.from(context);
        DecorCaptionView view = (DecorCaptionView) inflater2.inflate(17367152, (ViewGroup) null);
        setDecorCaptionShade(view);
        return view;
    }

    private void setDecorCaptionShade(DecorCaptionView view) {
        int shade = this.mWindow.getDecorCaptionShade();
        switch (shade) {
            case 1:
                setLightDecorCaptionShade(view);
                return;
            case 2:
                setDarkDecorCaptionShade(view);
                return;
            default:
                if ((getWindowSystemUiVisibility() & 8192) != 0) {
                    setDarkDecorCaptionShade(view);
                    return;
                } else {
                    setLightDecorCaptionShade(view);
                    return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateDecorCaptionShade() {
        DecorCaptionView decorCaptionView = this.mDecorCaptionView;
        if (decorCaptionView != null) {
            setDecorCaptionShade(decorCaptionView);
        }
    }

    private void setLightDecorCaptionShade(DecorCaptionView view) {
        view.findViewById(16909223).setBackgroundResource(17302157);
        view.findViewById(16908891).setBackgroundResource(17302155);
    }

    private void setDarkDecorCaptionShade(DecorCaptionView view) {
        view.findViewById(16909223).setBackgroundResource(17302156);
        view.findViewById(16908891).setBackgroundResource(17302154);
    }

    public static Drawable getResizingBackgroundDrawable(Drawable backgroundDrawable, Drawable fallbackDrawable, boolean windowTranslucent) {
        if (backgroundDrawable != null) {
            return enforceNonTranslucentBackground(backgroundDrawable, windowTranslucent);
        }
        if (fallbackDrawable != null) {
            return enforceNonTranslucentBackground(fallbackDrawable, windowTranslucent);
        }
        return new ColorDrawable(-16777216);
    }

    private static Drawable enforceNonTranslucentBackground(Drawable drawable, boolean windowTranslucent) {
        if (!windowTranslucent && (drawable instanceof ColorDrawable)) {
            ColorDrawable colorDrawable = (ColorDrawable) drawable;
            int color = colorDrawable.getColor();
            if (Color.alpha(color) != 255) {
                ColorDrawable copy = (ColorDrawable) colorDrawable.getConstantState().newDrawable().mutate();
                copy.setColor(Color.argb(255, Color.red(color), Color.green(color), Color.blue(color)));
                return copy;
            }
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearContentView() {
        DecorCaptionView decorCaptionView = this.mDecorCaptionView;
        if (decorCaptionView != null) {
            decorCaptionView.removeContentView();
            return;
        }
        for (int i10 = getChildCount() - 1; i10 >= 0; i10--) {
            View v2 = getChildAt(i10);
            if (v2 != this.mStatusColorViewState.view && v2 != this.mNavigationColorViewState.view && v2 != this.mStatusGuard) {
                removeViewAt(i10);
            }
        }
    }

    @Override // android.view.WindowCallbacks
    public void onWindowSizeIsChanging(Rect newBounds, boolean fullscreen, Rect systemInsets, Rect stableInsets) {
        BackdropFrameRenderer backdropFrameRenderer = this.mBackdropFrameRenderer;
        if (backdropFrameRenderer != null) {
            backdropFrameRenderer.setTargetRect(newBounds, fullscreen, systemInsets);
        }
    }

    @Override // android.view.WindowCallbacks
    public void onWindowDragResizeStart(Rect initialBounds, boolean fullscreen, Rect systemInsets, Rect stableInsets) {
        if (this.mWindow.isDestroyed()) {
            releaseThreadedRenderer();
            return;
        }
        if (this.mBackdropFrameRenderer != null) {
            return;
        }
        ThreadedRenderer renderer = getThreadedRenderer();
        if (renderer != null && !ViewRootImpl.CAPTION_ON_SHELL) {
            loadBackgroundDrawablesIfNeeded();
            WindowInsets rootInsets = getRootWindowInsets();
            this.mBackdropFrameRenderer = new BackdropFrameRenderer(this, renderer, initialBounds, this.mResizingBackgroundDrawable, this.mCaptionBackgroundDrawable, this.mUserCaptionBackgroundDrawable, getCurrentColor(this.mStatusColorViewState), getCurrentColor(this.mNavigationColorViewState), fullscreen, rootInsets.getInsets(WindowInsets.Type.systemBars()));
            updateElevation();
            updateColorViews(null, false);
        }
        getViewRootImpl().requestInvalidateRootRenderNode();
    }

    @Override // android.view.WindowCallbacks
    public void onWindowDragResizeEnd() {
        releaseThreadedRenderer();
        updateColorViews(null, false);
        getViewRootImpl().requestInvalidateRootRenderNode();
    }

    @Override // android.view.WindowCallbacks
    public boolean onContentDrawn(int offsetX, int offsetY, int sizeX, int sizeY) {
        BackdropFrameRenderer backdropFrameRenderer = this.mBackdropFrameRenderer;
        if (backdropFrameRenderer == null) {
            return false;
        }
        return backdropFrameRenderer.onContentDrawn(offsetX, offsetY, sizeX, sizeY);
    }

    @Override // android.view.WindowCallbacks
    public void onRequestDraw(boolean reportNextDraw) {
        BackdropFrameRenderer backdropFrameRenderer = this.mBackdropFrameRenderer;
        if (backdropFrameRenderer != null) {
            backdropFrameRenderer.onRequestDraw(reportNextDraw);
        } else if (reportNextDraw && isAttachedToWindow()) {
            getViewRootImpl().reportDrawFinish();
        }
    }

    @Override // android.view.WindowCallbacks
    public void onPostDraw(RecordingCanvas canvas) {
        drawLegacyNavigationBarBackground(canvas);
    }

    private void drawLegacyNavigationBarBackground(RecordingCanvas canvas) {
        View v2;
        if (!this.mDrawLegacyNavigationBarBackground || this.mDrawLegacyNavigationBarBackgroundHandled || (v2 = this.mNavigationColorViewState.view) == null) {
            return;
        }
        canvas.drawRect(v2.getLeft(), v2.getTop(), v2.getRight(), v2.getBottom(), this.mLegacyNavigationBarBackgroundPaint);
    }

    private void releaseThreadedRenderer() {
        Drawable.Callback callback;
        Drawable drawable = this.mResizingBackgroundDrawable;
        if (drawable != null && (callback = this.mLastBackgroundDrawableCb) != null) {
            drawable.setCallback(callback);
            this.mLastBackgroundDrawableCb = null;
        }
        BackdropFrameRenderer backdropFrameRenderer = this.mBackdropFrameRenderer;
        if (backdropFrameRenderer != null) {
            backdropFrameRenderer.releaseRenderer();
            this.mBackdropFrameRenderer = null;
            updateElevation();
        }
    }

    private boolean isResizing() {
        return this.mBackdropFrameRenderer != null;
    }

    private void initializeElevation() {
        this.mAllowUpdateElevation = false;
        updateElevation();
    }

    private void updateElevation() {
        int windowingMode = getResources().getConfiguration().windowConfiguration.getWindowingMode();
        boolean renderShadowsInCompositor = this.mWindow.mRenderShadowsInCompositor;
        if (renderShadowsInCompositor) {
            return;
        }
        float elevation = 0.0f;
        boolean wasAdjustedForStack = this.mElevationAdjustedForStack;
        if (windowingMode == 5 && !isResizing()) {
            float elevation2 = hasWindowFocus() ? 20.0f : 5.0f;
            if (!this.mAllowUpdateElevation) {
                elevation2 = 20.0f;
            }
            elevation = dipToPx(elevation2);
            this.mElevationAdjustedForStack = true;
        } else {
            this.mElevationAdjustedForStack = false;
        }
        if ((wasAdjustedForStack || this.mElevationAdjustedForStack) && getElevation() != elevation) {
            if (!isResizing()) {
                this.mWindow.setElevation(elevation);
            } else {
                setElevation(elevation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowingCaption() {
        DecorCaptionView decorCaptionView = this.mDecorCaptionView;
        return decorCaptionView != null && decorCaptionView.isCaptionShowing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCaptionHeight() {
        if (isShowingCaption()) {
            return this.mDecorCaptionView.getCaptionHeight();
        }
        return 0;
    }

    public int getCaptionInsetsHeight() {
        if (this.mWindow.isOverlayWithDecorCaptionEnabled()) {
            return getCaptionHeight();
        }
        return 0;
    }

    private float dipToPx(float dip) {
        return TypedValue.applyDimension(1, dip, getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserCaptionBackgroundDrawable(Drawable drawable) {
        this.mUserCaptionBackgroundDrawable = drawable;
        BackdropFrameRenderer backdropFrameRenderer = this.mBackdropFrameRenderer;
        if (backdropFrameRenderer != null) {
            backdropFrameRenderer.setUserCaptionBackgroundDrawable(drawable);
        }
    }

    private static String getTitleSuffix(WindowManager.LayoutParams params) {
        if (params == null) {
            return "";
        }
        String[] split = params.getTitle().toString().split("\\.");
        if (split.length <= 0) {
            return "";
        }
        if (split[split.length - 1] != null && (split[split.length - 1].contains("WLAN") || split[split.length - 1].contains("Wi-Fi"))) {
            return StringUtils.SENSITIVE_CODE;
        }
        return split[split.length - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateLogTag(WindowManager.LayoutParams params) {
        this.mLogTag = "DecorView[" + getTitleSuffix(params) + "]";
    }

    @Override // android.view.View
    public void requestKeyboardShortcuts(List<KeyboardShortcutGroup> list, int deviceId) {
        PhoneWindow.PanelFeatureState st = this.mWindow.getPanelState(0, false);
        MenuBuilder menuBuilder = st != null ? st.menu : null;
        if (!this.mWindow.isDestroyed() && this.mWindow.getCallback() != null) {
            this.mWindow.getCallback().onProvideKeyboardShortcuts(list, menuBuilder, deviceId);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchPointerCaptureChanged(boolean hasCapture) {
        super.dispatchPointerCaptureChanged(hasCapture);
        if (!this.mWindow.isDestroyed() && this.mWindow.getCallback() != null) {
            this.mWindow.getCallback().onPointerCaptureChanged(hasCapture);
        }
    }

    @Override // android.view.View
    public int getAccessibilityViewId() {
        return AccessibilityNodeInfo.ROOT_ITEM_ID;
    }

    @Override // android.view.View
    public WindowInsetsController getWindowInsetsController() {
        if (isAttachedToWindow()) {
            return super.getWindowInsetsController();
        }
        return this.mPendingInsetsController;
    }

    @Override // android.view.View
    public String toString() {
        return "DecorView@" + Integer.toHexString(hashCode()) + "[" + getTitleSuffix(this.mWindow.getAttributes()) + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ColorViewState {
        final ColorViewAttributes attributes;
        int color;
        boolean visible;
        View view = null;
        int targetVisibility = 4;
        boolean present = false;

        ColorViewState(ColorViewAttributes attributes) {
            this.attributes = attributes;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ColorViewAttributes {
        final int horizontalGravity;

        /* renamed from: id, reason: collision with root package name */
        final int f9300id;
        final int insetsType;
        final int seascapeGravity;
        final String transitionName;
        final int translucentFlag;
        final int verticalGravity;

        private ColorViewAttributes(int translucentFlag, int verticalGravity, int horizontalGravity, int seascapeGravity, String transitionName, int id2, int insetsType) {
            this.f9300id = id2;
            this.translucentFlag = translucentFlag;
            this.verticalGravity = verticalGravity;
            this.horizontalGravity = horizontalGravity;
            this.seascapeGravity = seascapeGravity;
            this.transitionName = transitionName;
            this.insetsType = insetsType;
        }

        public boolean isPresent(boolean requestedVisible, int windowFlags, boolean force) {
            return requestedVisible && ((Integer.MIN_VALUE & windowFlags) != 0 || force);
        }

        public boolean isVisible(boolean present, int color, int windowFlags, boolean force) {
            return present && Color.alpha(color) != 0 && ((this.translucentFlag & windowFlags) == 0 || force);
        }

        public boolean isVisible(int requestedVisibleTypes, int color, int windowFlags, boolean force) {
            boolean requestedVisible = (this.insetsType & requestedVisibleTypes) != 0;
            boolean present = isPresent(requestedVisible, windowFlags, force);
            return isVisible(present, color, windowFlags, force);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ActionModeCallback2Wrapper extends ActionMode.Callback2 {
        private final ActionMode.Callback mWrapped;

        public ActionModeCallback2Wrapper(ActionMode.Callback wrapped) {
            this.mWrapped = wrapped;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onCreateActionMode(mode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            DecorView.this.requestFitSystemWindows();
            return this.mWrapped.onPrepareActionMode(mode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.mWrapped.onActionItemClicked(mode, item);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            boolean isPrimary;
            this.mWrapped.onDestroyActionMode(mode);
            boolean isMncApp = DecorView.this.mContext.getApplicationInfo().targetSdkVersion >= 23;
            if (isMncApp) {
                isPrimary = mode == DecorView.this.mPrimaryActionMode;
                isFloating = mode == DecorView.this.mFloatingActionMode;
                if (!isPrimary && mode.getType() == 0) {
                    Log.e(DecorView.this.mLogTag, "Destroying unexpected ActionMode instance of TYPE_PRIMARY; " + ((Object) mode) + " was not the current primary action mode! Expected " + ((Object) DecorView.this.mPrimaryActionMode));
                }
                if (!isFloating && mode.getType() == 1) {
                    Log.e(DecorView.this.mLogTag, "Destroying unexpected ActionMode instance of TYPE_FLOATING; " + ((Object) mode) + " was not the current floating action mode! Expected " + ((Object) DecorView.this.mFloatingActionMode));
                }
            } else {
                isPrimary = mode.getType() == 0;
                if (mode.getType() == 1) {
                    isFloating = true;
                }
            }
            if (isPrimary) {
                if (DecorView.this.mPrimaryActionModePopup != null) {
                    DecorView decorView = DecorView.this;
                    decorView.removeCallbacks(decorView.mShowPrimaryActionModePopup);
                }
                if (DecorView.this.mPrimaryActionModeView != null) {
                    DecorView.this.endOnGoingFadeAnimation();
                    final ActionBarContextView lastActionModeView = DecorView.this.mPrimaryActionModeView;
                    DecorView decorView2 = DecorView.this;
                    decorView2.mFadeAnim = ObjectAnimator.ofFloat(decorView2.mPrimaryActionModeView, (Property<ActionBarContextView, Float>) View.ALPHA, 1.0f, 0.0f);
                    DecorView.this.mDecorViewExt.hookOnDestroyActionMode(DecorView.this.mFadeAnim);
                    DecorView.this.mFadeAnim.addListener(new Animator.AnimatorListener() { // from class: com.android.internal.policy.DecorView.ActionModeCallback2Wrapper.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (lastActionModeView == DecorView.this.mPrimaryActionModeView) {
                                lastActionModeView.setVisibility(8);
                                if (DecorView.this.mPrimaryActionModePopup != null) {
                                    DecorView.this.mPrimaryActionModePopup.dismiss();
                                }
                                lastActionModeView.killMode();
                                DecorView.this.mFadeAnim = null;
                                DecorView.this.requestApplyInsets();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                        }
                    });
                    DecorView.this.mFadeAnim.start();
                }
                DecorView.this.mPrimaryActionMode = null;
            } else if (isFloating) {
                DecorView.this.cleanupFloatingActionModeViews();
                DecorView.this.mFloatingActionMode = null;
            }
            if (DecorView.this.mWindow.getCallback() != null && !DecorView.this.mWindow.isDestroyed()) {
                try {
                    DecorView.this.mWindow.getCallback().onActionModeFinished(mode);
                } catch (AbstractMethodError e2) {
                }
            }
            DecorView.this.requestFitSystemWindows();
        }

        @Override // android.view.ActionMode.Callback2
        public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
            ActionMode.Callback callback = this.mWrapped;
            if (callback instanceof ActionMode.Callback2) {
                ((ActionMode.Callback2) callback).onGetContentRect(mode, view, outRect);
            } else {
                super.onGetContentRect(mode, view, outRect);
            }
        }
    }

    public IDecorViewWrapper getWrapper() {
        return this.mDecorViewWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class DecorViewWrapper implements IDecorViewWrapper {
        private DecorViewWrapper() {
        }

        @Override // com.android.internal.policy.IDecorViewWrapper
        public IDecorViewExt getExtImpl() {
            return DecorView.this.mDecorViewExt;
        }

        @Override // com.android.internal.policy.IDecorViewWrapper
        public PhoneWindow getWindow() {
            return DecorView.this.mWindow;
        }
    }
}
