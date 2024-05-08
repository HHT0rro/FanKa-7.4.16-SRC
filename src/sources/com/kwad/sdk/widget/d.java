package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends ViewPager {
    private int aSQ;
    private boolean aSR;

    public d(@NonNull Context context) {
        super(context);
        this.aSR = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.aSR) {
            return super.canScrollHorizontally(i10);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.aSR) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x10 = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            int i10 = x10 - this.aSQ;
            if (getCurrentItem() == 0 && i10 > 0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        this.aSQ = x10;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.aSR && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.aSR && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z10) {
        this.aSR = z10;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSR = false;
    }
}
