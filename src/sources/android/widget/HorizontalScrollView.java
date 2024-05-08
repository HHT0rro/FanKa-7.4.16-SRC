package android.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewHierarchyEncoder;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.FrameLayout;
import com.alipay.sdk.util.i;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class HorizontalScrollView extends FrameLayout {
    private static final int ANIMATED_SCROLL_GAP = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final int INVALID_POINTER = -1;
    private static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final String TAG = "HorizontalScrollView";
    private int mActivePointerId;
    private View mChildToScrollTo;
    public EdgeEffect mEdgeGlowLeft;
    public EdgeEffect mEdgeGlowRight;

    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mFillViewport;
    private float mHorizontalScrollFactor;
    private boolean mIsBeingDragged;
    private boolean mIsLayoutDirty;
    private int mLastMotionX;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private SavedState mSavedState;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<HorizontalScrollView> {
        private int mFillViewportId;
        private boolean mPropertiesMapped = false;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            this.mFillViewportId = propertyMapper.mapBoolean("fillViewport", 16843130);
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(HorizontalScrollView node, PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readBoolean(this.mFillViewportId, node.isFillViewport());
        }
    }

    public HorizontalScrollView(Context context) {
        this(context, null);
    }

    public HorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 16843603);
    }

    public HorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public HorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mEdgeGlowLeft = new EdgeEffect(context, attrs);
        this.mEdgeGlowRight = new EdgeEffect(context, attrs);
        initScrollView();
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.HorizontalScrollView, defStyleAttr, defStyleRes);
        saveAttributeDataForStyleable(context, R.styleable.HorizontalScrollView, attrs, a10, defStyleAttr, defStyleRes);
        setFillViewport(a10.getBoolean(0, false));
        a10.recycle();
        if (context.getResources().getConfiguration().uiMode == 6) {
            setRevealOnFocusHint(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int length = getHorizontalFadingEdgeLength();
        if (this.mScrollX < length) {
            return this.mScrollX / length;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int length = getHorizontalFadingEdgeLength();
        int rightEdge = getWidth() - this.mPaddingRight;
        int span = (getChildAt(0).getRight() - this.mScrollX) - rightEdge;
        if (span < length) {
            return span / length;
        }
        return 1.0f;
    }

    public void setEdgeEffectColor(int color) {
        setLeftEdgeEffectColor(color);
        setRightEdgeEffectColor(color);
    }

    public void setRightEdgeEffectColor(int color) {
        this.mEdgeGlowRight.setColor(color);
    }

    public void setLeftEdgeEffectColor(int color) {
        this.mEdgeGlowLeft.setColor(color);
    }

    public int getLeftEdgeEffectColor() {
        return this.mEdgeGlowLeft.getColor();
    }

    public int getRightEdgeEffectColor() {
        return this.mEdgeGlowRight.getColor();
    }

    public int getMaxScrollAmount() {
        return (int) ((this.mRight - this.mLeft) * 0.5f);
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration configuration = ViewConfiguration.get(this.mContext);
        this.mTouchSlop = configuration.getScaledTouchSlop();
        this.mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        this.mOverscrollDistance = configuration.getScaledOverscrollDistance();
        this.mOverflingDistance = configuration.getScaledOverflingDistance();
        this.mHorizontalScrollFactor = configuration.getScaledHorizontalScrollFactor();
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        super.addView(child);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        super.addView(child, index);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        super.addView(child, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        super.addView(child, index, params);
    }

    private boolean canScroll() {
        View child = getChildAt(0);
        if (child == null) {
            return false;
        }
        int childWidth = child.getWidth();
        return getWidth() < (this.mPaddingLeft + childWidth) + this.mPaddingRight;
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public void setFillViewport(boolean fillViewport) {
        if (fillViewport != this.mFillViewport) {
            this.mFillViewport = fillViewport;
            requestLayout();
        }
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        this.mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthPadding;
        int heightPadding;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.mFillViewport) {
            return;
        }
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode != 0 && getChildCount() > 0) {
            View child = getChildAt(0);
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
            int targetSdkVersion = getContext().getApplicationInfo().targetSdkVersion;
            if (targetSdkVersion >= 23) {
                widthPadding = this.mPaddingLeft + this.mPaddingRight + lp.leftMargin + lp.rightMargin;
                heightPadding = this.mPaddingTop + this.mPaddingBottom + lp.topMargin + lp.bottomMargin;
            } else {
                int widthPadding2 = this.mPaddingLeft;
                widthPadding = widthPadding2 + this.mPaddingRight;
                heightPadding = this.mPaddingTop + this.mPaddingBottom;
            }
            int desiredWidth = getMeasuredWidth() - widthPadding;
            if (child.getMeasuredWidth() < desiredWidth) {
                int childWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(desiredWidth, 1073741824);
                int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, heightPadding, lp.height);
                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    public boolean executeKeyEvent(KeyEvent event) {
        this.mTempRect.setEmpty();
        if (!canScroll()) {
            if (!isFocused()) {
                return false;
            }
            View currentFocused = findFocus();
            if (currentFocused == this) {
                currentFocused = null;
            }
            View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, 66);
            return (nextFocused == null || nextFocused == this || !nextFocused.requestFocus(66)) ? false : true;
        }
        if (event.getAction() != 0) {
            return false;
        }
        switch (event.getKeyCode()) {
            case 21:
                if (!event.isAltPressed()) {
                    boolean handled = arrowScroll(17);
                    return handled;
                }
                boolean handled2 = fullScroll(17);
                return handled2;
            case 22:
                if (!event.isAltPressed()) {
                    boolean handled3 = arrowScroll(66);
                    return handled3;
                }
                boolean handled4 = fullScroll(66);
                return handled4;
            case 62:
                pageScroll(event.isShiftPressed() ? 17 : 66);
                return false;
            default:
                return false;
        }
    }

    private boolean inChild(int x10, int y10) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollX = this.mScrollX;
        View child = getChildAt(0);
        return y10 >= child.getTop() && y10 < child.getBottom() && x10 >= child.getLeft() - scrollX && x10 < child.getRight() - scrollX;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        boolean z10 = true;
        if ((action == 2 && this.mIsBeingDragged) || super.onInterceptTouchEvent(ev)) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int x10 = (int) ev.getX();
                if (!inChild(x10, (int) ev.getY())) {
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                    break;
                } else {
                    this.mLastMotionX = x10;
                    this.mActivePointerId = ev.getPointerId(0);
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(ev);
                    if (this.mScroller.isFinished() && this.mEdgeGlowLeft.isFinished() && this.mEdgeGlowRight.isFinished()) {
                        z10 = false;
                    }
                    this.mIsBeingDragged = z10;
                    if (!this.mEdgeGlowLeft.isFinished()) {
                        this.mEdgeGlowLeft.onPullDistance(0.0f, 1.0f - (ev.getY() / getHeight()));
                    }
                    if (!this.mEdgeGlowRight.isFinished()) {
                        this.mEdgeGlowRight.onPullDistance(0.0f, ev.getY() / getHeight());
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mScroller.springBack(this.mScrollX, this.mScrollY, 0, getScrollRange(), 0, 0)) {
                    postInvalidateOnAnimation();
                    break;
                }
                break;
            case 2:
                int index = this.mActivePointerId;
                if (index != -1) {
                    int pointerIndex = ev.findPointerIndex(index);
                    if (pointerIndex == -1) {
                        Log.e(TAG, "Invalid pointerId=" + index + " in onInterceptTouchEvent");
                        break;
                    } else {
                        int x11 = (int) ev.getX(pointerIndex);
                        int xDiff = Math.abs(x11 - this.mLastMotionX);
                        if (xDiff > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionX = x11;
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(ev);
                            if (this.mParent != null) {
                                this.mParent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                }
                break;
            case 5:
                int index2 = ev.getActionIndex();
                this.mLastMotionX = (int) ev.getX(index2);
                this.mActivePointerId = ev.getPointerId(index2);
                break;
            case 6:
                onSecondaryPointerUp(ev);
                this.mLastMotionX = (int) ev.getX(ev.findPointerIndex(this.mActivePointerId));
                break;
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        ViewParent parent;
        int deltaX;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(ev);
        int action = ev.getAction();
        boolean z10 = false;
        switch (action & 255) {
            case 0:
                if (getChildCount() == 0) {
                    return false;
                }
                if (!this.mScroller.isFinished() && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionX = (int) ev.getX();
                this.mActivePointerId = ev.getPointerId(0);
                return true;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int initialVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                    if (getChildCount() > 0) {
                        if (Math.abs(initialVelocity) > this.mMinimumVelocity) {
                            fling(-initialVelocity);
                        } else if (this.mScroller.springBack(this.mScrollX, this.mScrollY, 0, getScrollRange(), 0, 0)) {
                            postInvalidateOnAnimation();
                        }
                    }
                    this.mActivePointerId = -1;
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                    if (shouldDisplayEdgeEffects()) {
                        this.mEdgeGlowLeft.onRelease();
                        this.mEdgeGlowRight.onRelease();
                        return true;
                    }
                    return true;
                }
                return true;
            case 2:
                int activePointerIndex = ev.findPointerIndex(this.mActivePointerId);
                if (activePointerIndex == -1) {
                    Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    return true;
                }
                int x10 = (int) ev.getX(activePointerIndex);
                int deltaX2 = this.mLastMotionX - x10;
                if (!this.mIsBeingDragged && Math.abs(deltaX2) > this.mTouchSlop) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    this.mIsBeingDragged = true;
                    deltaX2 = deltaX2 > 0 ? deltaX2 - this.mTouchSlop : deltaX2 + this.mTouchSlop;
                }
                if (this.mIsBeingDragged) {
                    this.mLastMotionX = x10;
                    int oldX = this.mScrollX;
                    int range = getScrollRange();
                    int overscrollMode = getOverScrollMode();
                    if (overscrollMode == 0 || (overscrollMode == 1 && range > 0)) {
                        z10 = true;
                    }
                    boolean canOverscroll = z10;
                    float displacement = ev.getY(activePointerIndex) / getHeight();
                    if (!canOverscroll) {
                        deltaX = deltaX2;
                    } else {
                        int consumed = 0;
                        if (deltaX2 < 0 && this.mEdgeGlowRight.getDistance() != 0.0f) {
                            consumed = Math.round(getWidth() * this.mEdgeGlowRight.onPullDistance(deltaX2 / getWidth(), displacement));
                        } else if (deltaX2 > 0 && this.mEdgeGlowLeft.getDistance() != 0.0f) {
                            consumed = Math.round((-getWidth()) * this.mEdgeGlowLeft.onPullDistance((-deltaX2) / getWidth(), 1.0f - displacement));
                        }
                        deltaX = deltaX2 - consumed;
                    }
                    int deltaX3 = deltaX;
                    overScrollBy(deltaX, 0, this.mScrollX, 0, range, 0, this.mOverscrollDistance, 0, true);
                    if (canOverscroll && deltaX3 != 0.0f) {
                        int pulledToX = oldX + deltaX3;
                        if (pulledToX < 0) {
                            this.mEdgeGlowLeft.onPullDistance((-deltaX3) / getWidth(), 1.0f - displacement);
                            if (!this.mEdgeGlowRight.isFinished()) {
                                this.mEdgeGlowRight.onRelease();
                            }
                        } else if (pulledToX > range) {
                            this.mEdgeGlowRight.onPullDistance(deltaX3 / getWidth(), displacement);
                            if (!this.mEdgeGlowLeft.isFinished()) {
                                this.mEdgeGlowLeft.onRelease();
                            }
                        }
                        if (shouldDisplayEdgeEffects()) {
                            if (!this.mEdgeGlowLeft.isFinished() || !this.mEdgeGlowRight.isFinished()) {
                                postInvalidateOnAnimation();
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            case 3:
                if (this.mIsBeingDragged && getChildCount() > 0) {
                    if (this.mScroller.springBack(this.mScrollX, this.mScrollY, 0, getScrollRange(), 0, 0)) {
                        postInvalidateOnAnimation();
                    }
                    this.mActivePointerId = -1;
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                    if (shouldDisplayEdgeEffects()) {
                        this.mEdgeGlowLeft.onRelease();
                        this.mEdgeGlowRight.onRelease();
                        return true;
                    }
                    return true;
                }
                return true;
            case 4:
            case 5:
            default:
                return true;
            case 6:
                onSecondaryPointerUp(ev);
                return true;
        }
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = (ev.getAction() & 65280) >> 8;
        int pointerId = ev.getPointerId(pointerIndex);
        if (pointerId == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.mLastMotionX = (int) ev.getX(newPointerIndex);
            this.mActivePointerId = ev.getPointerId(newPointerIndex);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent event) {
        float axisValue;
        switch (event.getAction()) {
            case 8:
                if (!this.mIsBeingDragged) {
                    if (event.isFromSource(2)) {
                        if ((event.getMetaState() & 1) != 0) {
                            axisValue = -event.getAxisValue(9);
                        } else {
                            axisValue = event.getAxisValue(10);
                        }
                    } else if (event.isFromSource(4194304)) {
                        axisValue = event.getAxisValue(26);
                    } else {
                        axisValue = 0.0f;
                    }
                    int delta = Math.round(this.mHorizontalScrollFactor * axisValue);
                    if (delta != 0) {
                        int range = getScrollRange();
                        int oldScrollX = this.mScrollX;
                        int newScrollX = oldScrollX + delta;
                        int overscrollMode = getOverScrollMode();
                        boolean canOverscroll = !event.isFromSource(8194) && (overscrollMode == 0 || (overscrollMode == 1 && range > 0));
                        boolean absorbed = false;
                        if (newScrollX < 0) {
                            if (canOverscroll) {
                                this.mEdgeGlowLeft.onPullDistance((-newScrollX) / getWidth(), 0.5f);
                                this.mEdgeGlowLeft.onRelease();
                                invalidate();
                                absorbed = true;
                            }
                            newScrollX = 0;
                        } else if (newScrollX > range) {
                            if (canOverscroll) {
                                this.mEdgeGlowRight.onPullDistance((newScrollX - range) / getWidth(), 0.5f);
                                this.mEdgeGlowRight.onRelease();
                                invalidate();
                                absorbed = true;
                            }
                            newScrollX = range;
                        }
                        if (newScrollX != oldScrollX) {
                            super.scrollTo(newScrollX, this.mScrollY);
                            return true;
                        }
                        if (absorbed) {
                            return true;
                        }
                    }
                }
                break;
        }
        return super.onGenericMotionEvent(event);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        if (!this.mScroller.isFinished()) {
            int oldX = this.mScrollX;
            int oldY = this.mScrollY;
            this.mScrollX = scrollX;
            this.mScrollY = scrollY;
            invalidateParentIfNeeded();
            onScrollChanged(this.mScrollX, this.mScrollY, oldX, oldY);
            if (clampedX) {
                this.mScroller.springBack(this.mScrollX, this.mScrollY, 0, getScrollRange(), 0, 0);
            }
        } else {
            super.scrollTo(scrollX, scrollY);
        }
        awakenScrollBars();
    }

    @Override // android.view.View
    public boolean performAccessibilityActionInternal(int action, Bundle arguments) {
        if (super.performAccessibilityActionInternal(action, arguments)) {
            return true;
        }
        switch (action) {
            case 4096:
            case 16908347:
                if (!isEnabled()) {
                    return false;
                }
                int viewportWidth = (getWidth() - this.mPaddingLeft) - this.mPaddingRight;
                int targetScrollX = Math.min(this.mScrollX + viewportWidth, getScrollRange());
                if (targetScrollX == this.mScrollX) {
                    return false;
                }
                smoothScrollTo(targetScrollX, 0);
                return true;
            case 8192:
            case 16908345:
                if (!isEnabled()) {
                    return false;
                }
                int viewportWidth2 = (getWidth() - this.mPaddingLeft) - this.mPaddingRight;
                int targetScrollX2 = Math.max(0, this.mScrollX - viewportWidth2);
                if (targetScrollX2 == this.mScrollX) {
                    return false;
                }
                smoothScrollTo(targetScrollX2, 0);
                return true;
            default:
                return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return HorizontalScrollView.class.getName();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfoInternal(info);
        int scrollRange = getScrollRange();
        if (scrollRange > 0) {
            info.setScrollable(true);
            if (isEnabled() && this.mScrollX > 0) {
                info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT);
            }
            if (isEnabled() && this.mScrollX < scrollRange) {
                info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEventInternal(AccessibilityEvent event) {
        super.onInitializeAccessibilityEventInternal(event);
        event.setScrollable(getScrollRange() > 0);
        event.setMaxScrollX(getScrollRange());
        event.setMaxScrollY(this.mScrollY);
    }

    private int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View child = getChildAt(0);
        int scrollRange = Math.max(0, child.getWidth() - ((getWidth() - this.mPaddingLeft) - this.mPaddingRight));
        return scrollRange;
    }

    private View findFocusableViewInMyBounds(boolean leftFocus, int left, View preferredFocusable) {
        int fadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        int leftWithoutFadingEdge = left + fadingEdgeLength;
        int rightWithoutFadingEdge = (getWidth() + left) - fadingEdgeLength;
        if (preferredFocusable != null && preferredFocusable.getLeft() < rightWithoutFadingEdge && preferredFocusable.getRight() > leftWithoutFadingEdge) {
            return preferredFocusable;
        }
        return findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge, rightWithoutFadingEdge);
    }

    private View findFocusableViewInBounds(boolean leftFocus, int left, int right) {
        List<View> focusables = getFocusables(2);
        View focusCandidate = null;
        boolean foundFullyContainedFocusable = false;
        int count = focusables.size();
        for (int i10 = 0; i10 < count; i10++) {
            View view = focusables.get(i10);
            int viewLeft = view.getLeft();
            int viewRight = view.getRight();
            if (left < viewRight && viewLeft < right) {
                boolean viewIsCloserToBoundary = false;
                boolean viewIsFullyContained = left < viewLeft && viewRight < right;
                if (focusCandidate == null) {
                    focusCandidate = view;
                    foundFullyContainedFocusable = viewIsFullyContained;
                } else {
                    if ((leftFocus && viewLeft < focusCandidate.getLeft()) || (!leftFocus && viewRight > focusCandidate.getRight())) {
                        viewIsCloserToBoundary = true;
                    }
                    if (foundFullyContainedFocusable) {
                        if (viewIsFullyContained && viewIsCloserToBoundary) {
                            focusCandidate = view;
                        }
                    } else if (viewIsFullyContained) {
                        focusCandidate = view;
                        foundFullyContainedFocusable = true;
                    } else if (viewIsCloserToBoundary) {
                        focusCandidate = view;
                    }
                }
            }
        }
        return focusCandidate;
    }

    public boolean pageScroll(int direction) {
        boolean right = direction == 66;
        int width = getWidth();
        if (right) {
            this.mTempRect.left = getScrollX() + width;
            int count = getChildCount();
            if (count > 0) {
                View view = getChildAt(0);
                if (this.mTempRect.left + width > view.getRight()) {
                    this.mTempRect.left = view.getRight() - width;
                }
            }
        } else {
            this.mTempRect.left = getScrollX() - width;
            if (this.mTempRect.left < 0) {
                this.mTempRect.left = 0;
            }
        }
        Rect rect = this.mTempRect;
        rect.right = rect.left + width;
        return scrollAndFocus(direction, this.mTempRect.left, this.mTempRect.right);
    }

    public boolean fullScroll(int direction) {
        boolean right = direction == 66;
        int width = getWidth();
        this.mTempRect.left = 0;
        this.mTempRect.right = width;
        if (right) {
            int count = getChildCount();
            if (count > 0) {
                View view = getChildAt(0);
                this.mTempRect.right = view.getRight();
                Rect rect = this.mTempRect;
                rect.left = rect.right - width;
            }
        }
        return scrollAndFocus(direction, this.mTempRect.left, this.mTempRect.right);
    }

    private boolean scrollAndFocus(int direction, int left, int right) {
        boolean handled = true;
        int width = getWidth();
        int containerLeft = getScrollX();
        int containerRight = containerLeft + width;
        boolean goLeft = direction == 17;
        View newFocused = findFocusableViewInBounds(goLeft, left, right);
        if (newFocused == null) {
            newFocused = this;
        }
        if (left >= containerLeft && right <= containerRight) {
            handled = false;
        } else {
            int delta = goLeft ? left - containerLeft : right - containerRight;
            doScrollX(delta);
        }
        if (newFocused != findFocus()) {
            newFocused.requestFocus(direction);
        }
        return handled;
    }

    public boolean arrowScroll(int direction) {
        View currentFocused = findFocus();
        if (currentFocused == this) {
            currentFocused = null;
        }
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        int maxJump = getMaxScrollAmount();
        if (nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump)) {
            nextFocused.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(nextFocused, this.mTempRect);
            doScrollX(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            nextFocused.requestFocus(direction);
        } else {
            int scrollDelta = maxJump;
            if (direction == 17 && getScrollX() < scrollDelta) {
                scrollDelta = getScrollX();
            } else if (direction == 66 && getChildCount() > 0) {
                int daRight = getChildAt(0).getRight();
                int screenRight = getScrollX() + getWidth();
                if (daRight - screenRight < maxJump) {
                    scrollDelta = daRight - screenRight;
                }
            }
            if (scrollDelta == 0) {
                return false;
            }
            doScrollX(direction == 66 ? scrollDelta : -scrollDelta);
        }
        if (currentFocused != null && currentFocused.isFocused() && isOffScreen(currentFocused)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    private boolean isOffScreen(View descendant) {
        return !isWithinDeltaOfScreen(descendant, 0);
    }

    private boolean isWithinDeltaOfScreen(View descendant, int delta) {
        descendant.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(descendant, this.mTempRect);
        return this.mTempRect.right + delta >= getScrollX() && this.mTempRect.left - delta <= getScrollX() + getWidth();
    }

    private void doScrollX(int delta) {
        if (delta != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(delta, 0);
            } else {
                scrollBy(delta, 0);
            }
        }
    }

    public final void smoothScrollBy(int dx, int dy) {
        if (getChildCount() == 0) {
            return;
        }
        long duration = AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll;
        if (duration > 250) {
            int width = (getWidth() - this.mPaddingRight) - this.mPaddingLeft;
            int right = getChildAt(0).getWidth();
            int maxX = Math.max(0, right - width);
            int scrollX = this.mScrollX;
            this.mScroller.startScroll(scrollX, this.mScrollY, Math.max(0, Math.min(scrollX + dx, maxX)) - scrollX, 0);
            postInvalidateOnAnimation();
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            scrollBy(dx, dy);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void smoothScrollTo(int x10, int y10) {
        smoothScrollBy(x10 - this.mScrollX, y10 - this.mScrollY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        int count = getChildCount();
        int contentWidth = (getWidth() - this.mPaddingLeft) - this.mPaddingRight;
        if (count == 0) {
            return contentWidth;
        }
        int scrollRange = getChildAt(0).getRight();
        int scrollX = this.mScrollX;
        int overscrollRight = Math.max(0, scrollRange - contentWidth);
        if (scrollX < 0) {
            return scrollRange - scrollX;
        }
        if (scrollX > overscrollRight) {
            return scrollRange + (scrollX - overscrollRight);
        }
        return scrollRange;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        int horizontalPadding = this.mPaddingLeft + this.mPaddingRight;
        int childWidthMeasureSpec = View.MeasureSpec.makeSafeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(parentWidthMeasureSpec) - horizontalPadding), 0);
        int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, this.mPaddingTop + this.mPaddingBottom, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, this.mPaddingTop + this.mPaddingBottom + lp.topMargin + lp.bottomMargin + heightUsed, lp.height);
        int usedTotal = this.mPaddingLeft + this.mPaddingRight + lp.leftMargin + lp.rightMargin + widthUsed;
        int childWidthMeasureSpec = View.MeasureSpec.makeSafeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(parentWidthMeasureSpec) - usedTotal), 0);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int oldX = this.mScrollX;
            int oldY = this.mScrollY;
            int x10 = this.mScroller.getCurrX();
            int y10 = this.mScroller.getCurrY();
            int deltaX = consumeFlingInStretch(x10 - oldX);
            if (deltaX != 0 || oldY != y10) {
                int range = getScrollRange();
                int overscrollMode = getOverScrollMode();
                boolean z10 = true;
                if (overscrollMode != 0 && (overscrollMode != 1 || range <= 0)) {
                    z10 = false;
                }
                boolean canOverscroll = z10;
                overScrollBy(deltaX, y10 - oldY, oldX, oldY, range, 0, this.mOverflingDistance, 0, false);
                onScrollChanged(this.mScrollX, this.mScrollY, oldX, oldY);
                if (canOverscroll && deltaX != 0) {
                    if (x10 < 0 && oldX >= 0) {
                        this.mEdgeGlowLeft.onAbsorb((int) this.mScroller.getCurrVelocity());
                    } else if (x10 > range && oldX <= range) {
                        this.mEdgeGlowRight.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                }
            }
            if (!awakenScrollBars()) {
                postInvalidateOnAnimation();
            }
        }
    }

    private int consumeFlingInStretch(int unconsumed) {
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        if (unconsumed > 0 && (edgeEffect2 = this.mEdgeGlowLeft) != null && edgeEffect2.getDistance() != 0.0f) {
            int size = getWidth();
            float deltaDistance = ((-unconsumed) * 4.0f) / size;
            int consumed = Math.round(((-size) / 4.0f) * this.mEdgeGlowLeft.onPullDistance(deltaDistance, 0.5f));
            if (consumed != unconsumed) {
                this.mEdgeGlowLeft.finish();
            }
            return unconsumed - consumed;
        }
        if (unconsumed < 0 && (edgeEffect = this.mEdgeGlowRight) != null && edgeEffect.getDistance() != 0.0f) {
            int size2 = getWidth();
            float deltaDistance2 = (unconsumed * 4.0f) / size2;
            int consumed2 = Math.round((size2 / 4.0f) * this.mEdgeGlowRight.onPullDistance(deltaDistance2, 0.5f));
            if (consumed2 != unconsumed) {
                this.mEdgeGlowRight.finish();
            }
            return unconsumed - consumed2;
        }
        return unconsumed;
    }

    private void scrollToChild(View child) {
        child.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(child, this.mTempRect);
        int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (scrollDelta != 0) {
            scrollBy(scrollDelta, 0);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean scroll = delta != 0;
        if (scroll) {
            if (immediate) {
                scrollBy(delta, 0);
            } else {
                smoothScrollBy(delta, 0);
            }
        }
        return scroll;
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int width = getWidth();
        int screenLeft = getScrollX();
        int screenRight = screenLeft + width;
        int fadingEdge = getHorizontalFadingEdgeLength();
        if (rect.left > 0) {
            screenLeft += fadingEdge;
        }
        if (rect.right < getChildAt(0).getWidth()) {
            screenRight -= fadingEdge;
        }
        if (rect.right > screenRight && rect.left > screenLeft) {
            int scrollXDelta = rect.width() > width ? 0 + (rect.left - screenLeft) : 0 + (rect.right - screenRight);
            int right = getChildAt(0).getRight();
            int distanceToRight = right - screenRight;
            return Math.min(scrollXDelta, distanceToRight);
        }
        if (rect.left >= screenLeft || rect.right >= screenRight) {
            return 0;
        }
        int scrollXDelta2 = rect.width() > width ? 0 - (screenRight - rect.right) : 0 - (screenLeft - rect.left);
        return Math.max(scrollXDelta2, -getScrollX());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        if (focused != null && focused.getRevealOnFocusHint()) {
            if (!this.mIsLayoutDirty) {
                scrollToChild(focused);
            } else {
                this.mChildToScrollTo = focused;
            }
        }
        super.requestChildFocus(child, focused);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        View nextFocus;
        if (direction == 2) {
            direction = 66;
        } else if (direction == 1) {
            direction = 17;
        }
        if (previouslyFocusedRect == null) {
            nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        } else {
            nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, previouslyFocusedRect, direction);
        }
        if (nextFocus == null || isOffScreen(nextFocus)) {
            return false;
        }
        return nextFocus.requestFocus(direction, previouslyFocusedRect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        rectangle.offset(child.getLeft() - child.getScrollX(), child.getTop() - child.getScrollY());
        return scrollToChildRect(rectangle, immediate);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l10, int t2, int r10, int b4) {
        int childWidth;
        int childMargins;
        int i10;
        if (getChildCount() <= 0) {
            childWidth = 0;
            childMargins = 0;
        } else {
            int childWidth2 = getChildAt(0).getMeasuredWidth();
            FrameLayout.LayoutParams childParams = (FrameLayout.LayoutParams) getChildAt(0).getLayoutParams();
            int childMargins2 = childParams.leftMargin + childParams.rightMargin;
            childWidth = childWidth2;
            childMargins = childMargins2;
        }
        int childWidth3 = r10 - l10;
        int available = ((childWidth3 - getPaddingLeftWithForeground()) - getPaddingRightWithForeground()) - childMargins;
        boolean forceLeftGravity = childWidth > available;
        layoutChildren(l10, t2, r10, b4, forceLeftGravity);
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!isLaidOut()) {
            int scrollRange = Math.max(0, childWidth - (((r10 - l10) - this.mPaddingLeft) - this.mPaddingRight));
            if (this.mSavedState != null) {
                if (isLayoutRtl()) {
                    i10 = scrollRange - this.mSavedState.scrollOffsetFromStart;
                } else {
                    i10 = this.mSavedState.scrollOffsetFromStart;
                }
                this.mScrollX = i10;
                this.mSavedState = null;
            } else if (isLayoutRtl()) {
                this.mScrollX = scrollRange - this.mScrollX;
            }
            if (this.mScrollX > scrollRange) {
                this.mScrollX = scrollRange;
            } else if (this.mScrollX < 0) {
                this.mScrollX = 0;
            }
        }
        scrollTo(this.mScrollX, this.mScrollY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int w3, int h10, int oldw, int oldh) {
        super.onSizeChanged(w3, h10, oldw, oldh);
        View currentFocused = findFocus();
        if (currentFocused == null || this == currentFocused) {
            return;
        }
        int maxJump = this.mRight - this.mLeft;
        if (isWithinDeltaOfScreen(currentFocused, maxJump)) {
            currentFocused.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(currentFocused, this.mTempRect);
            int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
            doScrollX(scrollDelta);
        }
    }

    private static boolean isViewDescendantOf(View child, View parent) {
        if (child == parent) {
            return true;
        }
        Object parent2 = child.getParent();
        return (parent2 instanceof ViewGroup) && isViewDescendantOf((View) parent2, parent);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void fling(int r20) {
        /*
            r19 = this;
            r0 = r19
            r12 = r20
            int r1 = r19.getChildCount()
            if (r1 <= 0) goto Lae
            int r1 = r19.getWidth()
            int r2 = r0.mPaddingRight
            int r1 = r1 - r2
            int r2 = r0.mPaddingLeft
            int r13 = r1 - r2
            r14 = 0
            android.view.View r1 = r0.getChildAt(r14)
            int r1 = r1.getRight()
            int r2 = r0.mPaddingLeft
            int r15 = r1 - r2
            int r1 = r15 - r13
            int r11 = java.lang.Math.max(r14, r1)
            r1 = 0
            int r2 = r0.mScrollX
            if (r2 != 0) goto L49
            android.widget.EdgeEffect r2 = r0.mEdgeGlowLeft
            boolean r2 = r2.isFinished()
            if (r2 != 0) goto L49
            android.widget.EdgeEffect r2 = r0.mEdgeGlowLeft
            int r3 = -r12
            boolean r2 = r0.shouldAbsorb(r2, r3)
            if (r2 == 0) goto L45
            android.widget.EdgeEffect r2 = r0.mEdgeGlowLeft
            int r3 = -r12
            r2.onAbsorb(r3)
            goto L62
        L45:
            r1 = 1
            r16 = r1
            goto L6c
        L49:
            int r2 = r0.mScrollX
            if (r2 != r11) goto L69
            android.widget.EdgeEffect r2 = r0.mEdgeGlowRight
            boolean r2 = r2.isFinished()
            if (r2 != 0) goto L69
            android.widget.EdgeEffect r2 = r0.mEdgeGlowRight
            boolean r2 = r0.shouldAbsorb(r2, r12)
            if (r2 == 0) goto L65
            android.widget.EdgeEffect r2 = r0.mEdgeGlowRight
            r2.onAbsorb(r12)
        L62:
            r16 = r1
            goto L6c
        L65:
            r1 = 1
            r16 = r1
            goto L6c
        L69:
            r1 = 1
            r16 = r1
        L6c:
            if (r16 == 0) goto La9
            android.widget.OverScroller r1 = r0.mScroller
            int r2 = r0.mScrollX
            int r3 = r0.mScrollY
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            int r10 = r13 / 2
            r17 = 0
            r4 = r20
            r7 = r11
            r18 = r11
            r11 = r17
            r1.fling(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r12 <= 0) goto L89
            r14 = 1
        L89:
            r1 = r14
            android.view.View r2 = r19.findFocus()
            android.widget.OverScroller r3 = r0.mScroller
            int r3 = r3.getFinalX()
            android.view.View r3 = r0.findFocusableViewInMyBounds(r1, r3, r2)
            if (r3 != 0) goto L9c
            r3 = r19
        L9c:
            if (r3 == r2) goto Lab
            if (r1 == 0) goto La3
            r4 = 66
            goto La5
        La3:
            r4 = 17
        La5:
            r3.requestFocus(r4)
            goto Lab
        La9:
            r18 = r11
        Lab:
            r19.postInvalidateOnAnimation()
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.HorizontalScrollView.fling(int):void");
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int velocity) {
        if (velocity > 0) {
            return true;
        }
        float distance = edgeEffect.getDistance() * getWidth();
        float flingDistance = (float) this.mScroller.getSplineFlingDistance(-velocity);
        return flingDistance < distance;
    }

    @Override // android.view.View
    public void scrollTo(int x10, int y10) {
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            int x11 = clamp(x10, (getWidth() - this.mPaddingRight) - this.mPaddingLeft, child.getWidth());
            int y11 = clamp(y10, (getHeight() - this.mPaddingBottom) - this.mPaddingTop, child.getHeight());
            if (x11 != this.mScrollX || y11 != this.mScrollY) {
                super.scrollTo(x11, y11);
            }
        }
    }

    private boolean shouldDisplayEdgeEffects() {
        return getOverScrollMode() != 2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (shouldDisplayEdgeEffects()) {
            int scrollX = this.mScrollX;
            if (!this.mEdgeGlowLeft.isFinished()) {
                int restoreCount = canvas.save();
                int height = (getHeight() - this.mPaddingTop) - this.mPaddingBottom;
                canvas.rotate(270.0f);
                canvas.translate((-height) + this.mPaddingTop, Math.min(0, scrollX));
                this.mEdgeGlowLeft.setSize(height, getWidth());
                if (this.mEdgeGlowLeft.draw(canvas)) {
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(restoreCount);
            }
            if (!this.mEdgeGlowRight.isFinished()) {
                int restoreCount2 = canvas.save();
                int width = getWidth();
                int height2 = (getHeight() - this.mPaddingTop) - this.mPaddingBottom;
                canvas.rotate(90.0f);
                canvas.translate(-this.mPaddingTop, -(Math.max(getScrollRange(), scrollX) + width));
                this.mEdgeGlowRight.setSize(height2, width);
                if (this.mEdgeGlowRight.draw(canvas)) {
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(restoreCount2);
            }
        }
    }

    private static int clamp(int n10, int my, int child) {
        if (my >= child || n10 < 0) {
            return 0;
        }
        if (my + n10 > child) {
            return child - my;
        }
        return n10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (this.mContext.getApplicationInfo().targetSdkVersion <= 18) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.mSavedState = ss;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (this.mContext.getApplicationInfo().targetSdkVersion <= 18) {
            return super.onSaveInstanceState();
        }
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.scrollOffsetFromStart = isLayoutRtl() ? -this.mScrollX : this.mScrollX;
        return ss;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void encodeProperties(ViewHierarchyEncoder encoder) {
        super.encodeProperties(encoder);
        encoder.addProperty("layout:fillViewPort", this.mFillViewport);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.HorizontalScrollView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        public int scrollOffsetFromStart;

        SavedState(Parcelable superState) {
            super(superState);
        }

        public SavedState(Parcel source) {
            super(source);
            this.scrollOffsetFromStart = source.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.scrollOffsetFromStart);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollOffsetFromStart + i.f4738d;
        }
    }
}
