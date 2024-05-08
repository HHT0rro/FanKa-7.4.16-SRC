package com.android.internal.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.android.internal.widget.ViewPager;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ResolverViewPager extends ViewPager {
    private boolean mSwipingEnabled;

    public ResolverViewPager(Context context) {
        super(context);
        this.mSwipingEnabled = true;
    }

    public ResolverViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSwipingEnabled = true;
    }

    public ResolverViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mSwipingEnabled = true;
    }

    public ResolverViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mSwipingEnabled = true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (View.MeasureSpec.getMode(heightMeasureSpec) != Integer.MIN_VALUE) {
            return;
        }
        int widthMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int height = getMeasuredHeight();
        int maxHeight = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View child = getChildAt(i10);
            child.measure(widthMeasureSpec2, View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            if (maxHeight < child.getMeasuredHeight()) {
                maxHeight = child.getMeasuredHeight();
            }
        }
        if (maxHeight > 0) {
            height = maxHeight;
        }
        super.onMeasure(widthMeasureSpec2, View.MeasureSpec.makeMeasureSpec(height, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSwipingEnabled(boolean swipingEnabled) {
        this.mSwipingEnabled = swipingEnabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return !isLayoutRtl() && this.mSwipingEnabled && super.onInterceptTouchEvent(ev);
    }
}
