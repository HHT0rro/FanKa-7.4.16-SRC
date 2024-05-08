package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends g {
    private Rect Pq;
    private int Pr;
    private int Ps;
    private boolean Pt;
    private int Pu;
    private a Pv;
    private boolean Pw;
    private boolean Px;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        boolean pQ();
    }

    public b(Context context) {
        this(context, null);
    }

    private void a(int i10, int i11, int i12) {
        while (true) {
            if (this.Pu == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.Pu = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (i10 >= findFirstVisibleItemPosition && i10 <= findLastVisibleItemPosition) {
                int i13 = i10 - findFirstVisibleItemPosition;
                if (getChildCount() > i13) {
                    int[] iArr2 = new int[2];
                    getChildAt(i13).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.Pu) - i12);
                    return;
                }
                return;
            }
            if (i10 > findLastVisibleItemPosition) {
                scrollBy(0, i11);
                a(i10, i11, i12);
                return;
            }
            scrollBy(0, -i11);
        }
    }

    private void pO() {
        Rect rect = this.Pq;
        if (rect == null) {
            this.Pq = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                this.Pq.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void pP() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).pT();
        }
    }

    private void scrollToPositionWithOffset(int i10, int i11) {
        a(i10, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pP();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Pr != 0) {
            pO();
            Rect rect = this.Pq;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Pq);
                canvas.drawColor(this.Pr);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Pw) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.Px) {
            stopScroll();
        }
        a aVar = this.Pv;
        if (aVar == null || !aVar.pQ()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        int i12 = this.Ps;
        if (i12 > 0 && i12 < size) {
            i11 = View.MeasureSpec.makeMeasureSpec(this.Ps, View.MeasureSpec.getMode(i11));
        }
        super.onMeasure(i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Pw) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i10) {
        if (this.Pt) {
            scrollToPositionWithOffset(i10, 0);
        } else {
            super.scrollToPosition(i10);
        }
    }

    public void setDisableScroll(boolean z10) {
        this.Pw = z10;
    }

    public void setDownStop(boolean z10) {
        this.Px = z10;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.Pv = aVar;
    }

    public void setUnderneathColor(int i10) {
        this.Pr = i10;
        pO();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z10) {
        this.Pt = z10;
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Pu = Integer.MIN_VALUE;
        this.Px = false;
    }
}
