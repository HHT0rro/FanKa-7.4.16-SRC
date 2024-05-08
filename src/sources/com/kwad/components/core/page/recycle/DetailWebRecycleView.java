package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.s.o;
import com.kwad.sdk.utils.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DetailWebRecycleView extends b {
    private boolean PA;
    private int PB;
    private int PC;
    private boolean PD;
    public a PE;
    private Runnable PF;
    private o PG;
    private int Py;
    private boolean Pz;
    private int mf;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        boolean pR();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.PG, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.PG);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.PE;
        if (aVar != null && aVar.pR()) {
            return true;
        }
        this.PC = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.PB - this.PC) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.PC = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.PB) {
            return false;
        }
        fling((int) f10, (int) f11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.PC = computeVerticalScrollOffset;
        if ((i11 > 0 && computeVerticalScrollOffset < this.PB) && !this.PD && computeVerticalScrollOffset < this.mf) {
            scrollBy(0, i11);
            iArr[1] = i11;
        }
        if (i11 < 0 && this.PC > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i11);
            iArr[1] = i11;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i10) {
        super.onScrollStateChanged(i10);
        if (i10 == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.PD = true;
                    return;
                }
            }
            this.PD = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return (i10 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.PA) {
            this.PA = false;
        } else {
            if (this.Pz) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z10) {
        this.Pz = z10;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z10) {
        this.PA = z10;
    }

    public void setInterceptTouchListener(a aVar) {
        this.PE = aVar;
    }

    public void setTopViewHeight(int i10) {
        this.PB = i10;
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Py = 1000;
        this.Pz = false;
        this.PA = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = s.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        s.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Py));
                    }
                } catch (RuntimeException e2) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                }
            }
        };
        this.PF = runnable;
        this.PG = new o(runnable);
        if (context instanceof Activity) {
            this.mf = com.kwad.sdk.d.a.a.e((Activity) context);
        } else {
            this.mf = com.kwad.sdk.d.a.a.getScreenHeight(context);
        }
    }
}
