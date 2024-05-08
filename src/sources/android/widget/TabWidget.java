package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import com.android.internal.R;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class TabWidget extends LinearLayout implements View.OnFocusChangeListener {
    private final Rect mBounds;
    private boolean mDrawBottomStrips;
    private int[] mImposedTabWidths;
    private int mImposedTabsHeight;
    private Drawable mLeftStrip;
    private Drawable mRightStrip;
    private int mSelectedTab;
    private OnTabSelectionChanged mSelectionChangedListener;
    private boolean mStripMoved;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnTabSelectionChanged {
        void onTabSelectionChanged(int i10, boolean z10);
    }

    public TabWidget(Context context) {
        this(context, null);
    }

    public TabWidget(Context context, AttributeSet attrs) {
        this(context, attrs, 16842883);
    }

    public TabWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TabWidget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mBounds = new Rect();
        this.mSelectedTab = -1;
        this.mDrawBottomStrips = true;
        this.mImposedTabsHeight = -1;
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.TabWidget, defStyleAttr, defStyleRes);
        saveAttributeDataForStyleable(context, R.styleable.TabWidget, attrs, a10, defStyleAttr, defStyleRes);
        this.mDrawBottomStrips = a10.getBoolean(3, this.mDrawBottomStrips);
        boolean isTargetSdkDonutOrLower = context.getApplicationInfo().targetSdkVersion <= 4;
        boolean hasExplicitLeft = a10.hasValueOrEmpty(1);
        if (hasExplicitLeft) {
            this.mLeftStrip = a10.getDrawable(1);
        } else if (isTargetSdkDonutOrLower) {
            this.mLeftStrip = context.getDrawable(17303804);
        } else {
            this.mLeftStrip = context.getDrawable(17303803);
        }
        boolean hasExplicitRight = a10.hasValueOrEmpty(2);
        if (hasExplicitRight) {
            this.mRightStrip = a10.getDrawable(2);
        } else if (isTargetSdkDonutOrLower) {
            this.mRightStrip = context.getDrawable(R.drawable.tab_bottom_right_v4);
        } else {
            this.mRightStrip = context.getDrawable(R.drawable.tab_bottom_right);
        }
        a10.recycle();
        setChildrenDrawingOrderEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int w3, int h10, int oldw, int oldh) {
        this.mStripMoved = true;
        super.onSizeChanged(w3, h10, oldw, oldh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int childCount, int i10) {
        int i11 = this.mSelectedTab;
        if (i11 == -1) {
            return i10;
        }
        if (i10 == childCount - 1) {
            return i11;
        }
        if (i10 >= i11) {
            return i10 + 1;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.LinearLayout
    public void measureChildBeforeLayout(View child, int childIndex, int widthMeasureSpec, int totalWidth, int heightMeasureSpec, int totalHeight) {
        if (!isMeasureWithLargestChildEnabled() && this.mImposedTabsHeight >= 0) {
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mImposedTabWidths[childIndex] + totalWidth, 1073741824);
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mImposedTabsHeight, 1073741824);
        }
        super.measureChildBeforeLayout(child, childIndex, widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.LinearLayout
    public void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        if (View.MeasureSpec.getMode(widthMeasureSpec) == 0) {
            super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int unspecifiedWidth = View.MeasureSpec.makeSafeMeasureSpec(width, 0);
        this.mImposedTabsHeight = -1;
        super.measureHorizontal(unspecifiedWidth, heightMeasureSpec);
        int extraWidth = getMeasuredWidth() - width;
        if (extraWidth > 0) {
            int count = getChildCount();
            int childCount = 0;
            for (int i10 = 0; i10 < count; i10++) {
                if (getChildAt(i10).getVisibility() != 8) {
                    childCount++;
                }
            }
            if (childCount > 0) {
                int[] iArr = this.mImposedTabWidths;
                if (iArr == null || iArr.length != count) {
                    this.mImposedTabWidths = new int[count];
                }
                for (int i11 = 0; i11 < count; i11++) {
                    View child = getChildAt(i11);
                    if (child.getVisibility() != 8) {
                        int childWidth = child.getMeasuredWidth();
                        int delta = extraWidth / childCount;
                        int newWidth = Math.max(0, childWidth - delta);
                        this.mImposedTabWidths[i11] = newWidth;
                        extraWidth -= childWidth - newWidth;
                        childCount--;
                        this.mImposedTabsHeight = Math.max(this.mImposedTabsHeight, child.getMeasuredHeight());
                    }
                }
            }
        }
        super.measureHorizontal(widthMeasureSpec, heightMeasureSpec);
    }

    public View getChildTabViewAt(int index) {
        return getChildAt(index);
    }

    public int getTabCount() {
        return getChildCount();
    }

    @Override // android.widget.LinearLayout
    public void setDividerDrawable(Drawable drawable) {
        super.setDividerDrawable(drawable);
    }

    public void setDividerDrawable(int resId) {
        setDividerDrawable(this.mContext.getDrawable(resId));
    }

    public void setLeftStripDrawable(Drawable drawable) {
        this.mLeftStrip = drawable;
        requestLayout();
        invalidate();
    }

    public void setLeftStripDrawable(int resId) {
        setLeftStripDrawable(this.mContext.getDrawable(resId));
    }

    public Drawable getLeftStripDrawable() {
        return this.mLeftStrip;
    }

    public void setRightStripDrawable(Drawable drawable) {
        this.mRightStrip = drawable;
        requestLayout();
        invalidate();
    }

    public void setRightStripDrawable(int resId) {
        setRightStripDrawable(this.mContext.getDrawable(resId));
    }

    public Drawable getRightStripDrawable() {
        return this.mRightStrip;
    }

    public void setStripEnabled(boolean stripEnabled) {
        this.mDrawBottomStrips = stripEnabled;
        invalidate();
    }

    public boolean isStripEnabled() {
        return this.mDrawBottomStrips;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void childDrawableStateChanged(View child) {
        if (getTabCount() > 0 && child == getChildTabViewAt(this.mSelectedTab)) {
            invalidate();
        }
        super.childDrawableStateChanged(child);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (getTabCount() == 0 || !this.mDrawBottomStrips) {
            return;
        }
        View selectedChild = getChildTabViewAt(this.mSelectedTab);
        Drawable leftStrip = this.mLeftStrip;
        Drawable rightStrip = this.mRightStrip;
        if (leftStrip != null) {
            leftStrip.setState(selectedChild.getDrawableState());
        }
        if (rightStrip != null) {
            rightStrip.setState(selectedChild.getDrawableState());
        }
        if (this.mStripMoved) {
            Rect bounds = this.mBounds;
            bounds.left = selectedChild.getLeft();
            bounds.right = selectedChild.getRight();
            int myHeight = getHeight();
            if (leftStrip != null) {
                leftStrip.setBounds(Math.min(0, bounds.left - leftStrip.getIntrinsicWidth()), myHeight - leftStrip.getIntrinsicHeight(), bounds.left, myHeight);
            }
            if (rightStrip != null) {
                rightStrip.setBounds(bounds.right, myHeight - rightStrip.getIntrinsicHeight(), Math.max(getWidth(), bounds.right + rightStrip.getIntrinsicWidth()), myHeight);
            }
            this.mStripMoved = false;
        }
        if (leftStrip != null) {
            leftStrip.draw(canvas);
        }
        if (rightStrip != null) {
            rightStrip.draw(canvas);
        }
    }

    public void setCurrentTab(int index) {
        int i10;
        if (index < 0 || index >= getTabCount() || index == (i10 = this.mSelectedTab)) {
            return;
        }
        if (i10 != -1) {
            getChildTabViewAt(i10).setSelected(false);
        }
        this.mSelectedTab = index;
        getChildTabViewAt(index).setSelected(true);
        this.mStripMoved = true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return TabWidget.class.getName();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEventInternal(AccessibilityEvent event) {
        super.onInitializeAccessibilityEventInternal(event);
        event.setItemCount(getTabCount());
        event.setCurrentItemIndex(this.mSelectedTab);
    }

    public void focusCurrentTab(int index) {
        int oldTab = this.mSelectedTab;
        setCurrentTab(index);
        if (oldTab != index) {
            getChildTabViewAt(index).requestFocus();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        int count = getTabCount();
        for (int i10 = 0; i10 < count; i10++) {
            View child = getChildTabViewAt(i10);
            child.setEnabled(enabled);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        if (child.getLayoutParams() == null) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, -1, 1.0f);
            lp.setMargins(0, 0, 0, 0);
            child.setLayoutParams(lp);
        }
        child.setFocusable(true);
        child.setClickable(true);
        if (child.getPointerIcon() == null) {
            child.setPointerIcon(PointerIcon.getSystemIcon(getContext(), 1002));
        }
        super.addView(child);
        child.setOnClickListener(new TabClickListener(getTabCount() - 1));
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.mSelectedTab = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        if (!isEnabled()) {
            return null;
        }
        return super.onResolvePointerIcon(event, pointerIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTabSelectionListener(OnTabSelectionChanged listener) {
        this.mSelectionChangedListener = listener;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v2, boolean hasFocus) {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class TabClickListener implements View.OnClickListener {
        private final int mTabIndex;

        private TabClickListener(int tabIndex) {
            this.mTabIndex = tabIndex;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v2) {
            TabWidget.this.mSelectionChangedListener.onTabSelectionChanged(this.mTabIndex, true);
        }
    }
}
