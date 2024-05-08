package android.view.autofill;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.window.WindowMetricsHelper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AutofillPopupWindow extends PopupWindow {
    private static final String TAG = "AutofillPopupWindow";
    private boolean mFullScreen;
    private final View.OnAttachStateChangeListener mOnAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: android.view.autofill.AutofillPopupWindow.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v2) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v2) {
            AutofillPopupWindow.this.dismiss();
        }
    };
    private WindowManager.LayoutParams mWindowLayoutParams;
    private final WindowPresenter mWindowPresenter;

    public AutofillPopupWindow(IAutofillWindowPresenter presenter) {
        this.mWindowPresenter = new WindowPresenter(presenter);
        setTouchModal(false);
        setOutsideTouchable(true);
        setInputMethodMode(2);
        setFocusable(true);
    }

    @Override // android.widget.PopupWindow
    protected boolean hasContentView() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.PopupWindow
    public boolean hasDecorView() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.PopupWindow
    public WindowManager.LayoutParams getDecorViewLayoutParams() {
        return this.mWindowLayoutParams;
    }

    public void update(final View anchor, int offsetX, int offsetY, int width, int height, Rect virtualBounds) {
        View actualAnchor;
        boolean z10 = width == -1;
        this.mFullScreen = z10;
        setWindowLayoutType(z10 ? 2008 : 1005);
        if (this.mFullScreen) {
            offsetX = 0;
            offsetY = 0;
            WindowManager windowManager = (WindowManager) anchor.getContext().getSystemService(WindowManager.class);
            Rect windowBounds = WindowMetricsHelper.getBoundsExcludingNavigationBarAndCutout(windowManager.getCurrentWindowMetrics());
            width = windowBounds.width();
            if (height != -1) {
                offsetY = windowBounds.height() - height;
            }
            actualAnchor = anchor;
        } else if (virtualBounds != null) {
            final int[] mLocationOnScreen = {virtualBounds.left, virtualBounds.top};
            View actualAnchor2 = new View(anchor.getContext()) { // from class: android.view.autofill.AutofillPopupWindow.2
                @Override // android.view.View
                public void getLocationOnScreen(int[] location) {
                    int[] iArr = mLocationOnScreen;
                    location[0] = iArr[0];
                    location[1] = iArr[1];
                }

                @Override // android.view.View
                public int getAccessibilityViewId() {
                    return anchor.getAccessibilityViewId();
                }

                @Override // android.view.View
                public ViewTreeObserver getViewTreeObserver() {
                    return anchor.getViewTreeObserver();
                }

                @Override // android.view.View
                public IBinder getApplicationWindowToken() {
                    return anchor.getApplicationWindowToken();
                }

                @Override // android.view.View
                public View getRootView() {
                    return anchor.getRootView();
                }

                @Override // android.view.View
                public int getLayoutDirection() {
                    return anchor.getLayoutDirection();
                }

                @Override // android.view.View
                public void getWindowDisplayFrame(Rect outRect) {
                    anchor.getWindowDisplayFrame(outRect);
                }

                @Override // android.view.View
                public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener listener) {
                    anchor.addOnAttachStateChangeListener(listener);
                }

                @Override // android.view.View
                public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener listener) {
                    anchor.removeOnAttachStateChangeListener(listener);
                }

                @Override // android.view.View
                public boolean isAttachedToWindow() {
                    return anchor.isAttachedToWindow();
                }

                @Override // android.view.View
                public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
                    return anchor.requestRectangleOnScreen(rectangle, immediate);
                }

                @Override // android.view.View
                public IBinder getWindowToken() {
                    return anchor.getWindowToken();
                }
            };
            actualAnchor2.setLeftTopRightBottom(virtualBounds.left, virtualBounds.top, virtualBounds.right, virtualBounds.bottom);
            actualAnchor2.setScrollX(anchor.getScrollX());
            actualAnchor2.setScrollY(anchor.getScrollY());
            anchor.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: android.view.autofill.AutofillPopupWindow$$ExternalSyntheticLambda0
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                    AutofillPopupWindow.lambda$update$0(mLocationOnScreen, view, i10, i11, i12, i13);
                }
            });
            actualAnchor2.setWillNotDraw(true);
            actualAnchor = actualAnchor2;
        } else {
            actualAnchor = anchor;
        }
        if (!this.mFullScreen) {
            setAnimationStyle(-1);
        } else if (height == -1) {
            setAnimationStyle(0);
        } else {
            setAnimationStyle(16974609);
        }
        if (!isShowing()) {
            setWidth(width);
            setHeight(height);
            showAsDropDown(actualAnchor, offsetX, offsetY);
            return;
        }
        update(actualAnchor, offsetX, offsetY, width, height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$update$0(int[] mLocationOnScreen, View v2, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        mLocationOnScreen[0] = mLocationOnScreen[0] - (scrollX - oldScrollX);
        mLocationOnScreen[1] = mLocationOnScreen[1] - (scrollY - oldScrollY);
    }

    @Override // android.widget.PopupWindow
    protected void update(View anchor, WindowManager.LayoutParams params) {
        int layoutDirection = anchor != null ? anchor.getLayoutDirection() : 3;
        this.mWindowPresenter.show(params, getTransitionEpicenter(), isLayoutInsetDecor(), layoutDirection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.PopupWindow
    public boolean findDropDownPosition(View anchor, WindowManager.LayoutParams outParams, int xOffset, int yOffset, int width, int height, int gravity, boolean allowScroll) {
        if (this.mFullScreen) {
            outParams.f816x = xOffset;
            outParams.f817y = yOffset;
            outParams.width = width;
            outParams.height = height;
            outParams.gravity = gravity;
            return false;
        }
        return super.findDropDownPosition(anchor, outParams, xOffset, yOffset, width, height, gravity, allowScroll);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        if (Helper.sVerbose) {
            Log.v(TAG, "showAsDropDown(): anchor=" + ((Object) anchor) + ", xoff=" + xoff + ", yoff=" + yoff + ", isShowing(): " + isShowing());
        }
        if (isShowing()) {
            return;
        }
        setShowing(true);
        setDropDown(true);
        attachToAnchor(anchor, xoff, yoff, gravity);
        WindowManager.LayoutParams p10 = createPopupLayoutParams(anchor.getWindowToken());
        this.mWindowLayoutParams = p10;
        boolean aboveAnchor = findDropDownPosition(anchor, p10, xoff, yoff, p10.width, p10.height, gravity, getAllowScrollingAnchorParent());
        updateAboveAnchor(aboveAnchor);
        p10.accessibilityIdOfAnchor = anchor.getAccessibilityViewId();
        p10.packageName = anchor.getContext().getPackageName();
        this.mWindowPresenter.show(p10, getTransitionEpicenter(), isLayoutInsetDecor(), anchor.getLayoutDirection());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.PopupWindow
    public void attachToAnchor(View anchor, int xoff, int yoff, int gravity) {
        super.attachToAnchor(anchor, xoff, yoff, gravity);
        anchor.addOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.PopupWindow
    public void detachFromAnchor() {
        View anchor = getAnchor();
        if (anchor != null) {
            anchor.removeOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
        }
        super.detachFromAnchor();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!isShowing() || isTransitioningToDismiss()) {
            return;
        }
        setShowing(false);
        setTransitioningToDismiss(true);
        this.mWindowPresenter.hide(getTransitionEpicenter());
        detachFromAnchor();
        if (getOnDismissListener() != null) {
            getOnDismissListener().onDismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public int getAnimationStyle() {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public Drawable getBackground() {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public float getElevation() {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public Transition getEnterTransition() {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public Transition getExitTransition() {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public void setBackgroundDrawable(Drawable background) {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View contentView) {
        if (contentView != null) {
            throw new IllegalStateException("You can't call this!");
        }
    }

    @Override // android.widget.PopupWindow
    public void setElevation(float elevation) {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public void setEnterTransition(Transition enterTransition) {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public void setExitTransition(Transition exitTransition) {
        throw new IllegalStateException("You can't call this!");
    }

    @Override // android.widget.PopupWindow
    public void setTouchInterceptor(View.OnTouchListener l10) {
        throw new IllegalStateException("You can't call this!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class WindowPresenter {
        final IAutofillWindowPresenter mPresenter;

        WindowPresenter(IAutofillWindowPresenter presenter) {
            this.mPresenter = presenter;
        }

        void show(WindowManager.LayoutParams p10, Rect transitionEpicenter, boolean fitsSystemWindows, int layoutDirection) {
            try {
                this.mPresenter.show(p10, transitionEpicenter, fitsSystemWindows, layoutDirection);
            } catch (RemoteException e2) {
                Log.w(AutofillPopupWindow.TAG, "Error showing fill window", e2);
                e2.rethrowFromSystemServer();
            }
        }

        void hide(Rect transitionEpicenter) {
            try {
                this.mPresenter.hide(transitionEpicenter);
            } catch (RemoteException e2) {
                Log.w(AutofillPopupWindow.TAG, "Error hiding fill window", e2);
                e2.rethrowFromSystemServer();
            }
        }
    }
}
