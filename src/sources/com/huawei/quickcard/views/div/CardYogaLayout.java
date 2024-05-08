package com.huawei.quickcard.views.div;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.f2;
import com.huawei.quickcard.framework.ui.IViewDirection;
import com.huawei.quickcard.framework.ui.YogaContainer;
import com.huawei.quickcard.views.GestureDelegate;
import com.huawei.quickcard.views.image.view.LayoutHolder;
import com.huawei.quickcard.yoga.QuickCardYogaNodeFactory;
import java.util.HashMap;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardYogaLayout extends ViewGroup implements YogaContainer, IViewDirection, LayoutHolder {

    /* renamed from: a, reason: collision with root package name */
    private final Map<View, YogaNode> f34512a;

    /* renamed from: b, reason: collision with root package name */
    private final YogaNode f34513b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutHolder.OnLayoutListener f34514c;

    public CardYogaLayout(Context context) {
        this(context, null, 0);
    }

    private static YogaNode a() {
        return QuickCardYogaNodeFactory.make();
    }

    public static void applyLayoutDirection(YogaNode yogaNode, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            view.setLayoutDirection(1);
            yogaNode.z(YogaDirection.RTL);
        } else {
            view.setLayoutDirection(0);
            yogaNode.z(YogaDirection.LTR);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        YogaNode a10;
        this.f34513b.O(null);
        super.addView(view, i10, layoutParams);
        if (this.f34512a.containsKey(view)) {
            return;
        }
        if (view instanceof YogaContainer) {
            a10 = ((YogaContainer) view).getYogaNode();
        } else {
            if (this.f34512a.containsKey(view)) {
                a10 = this.f34512a.get(view);
            } else {
                a10 = a();
            }
            a10.y(view);
            a10.O(new a());
        }
        applyLayoutDirection(a10, view);
        this.f34512a.put(view, a10);
        if (i10 == -1) {
            i10 = this.f34513b.f();
        }
        this.f34513b.a(a10, i10);
    }

    public void applyLayoutToView(YogaNode yogaNode, float f10, float f11) {
        Object g3 = yogaNode.g();
        View view = g3 instanceof View ? (View) g3 : null;
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int round = Math.round(yogaNode.m() + f10);
            int round2 = Math.round(yogaNode.n() + f11);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.l()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.k()), 1073741824));
            view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
        }
        int f12 = yogaNode.f();
        for (int i10 = 0; i10 < f12; i10++) {
            if (equals(view)) {
                applyLayoutToView(yogaNode.e(i10), f10, f11);
            } else if (!(view instanceof YogaContainer)) {
                applyLayoutToView(yogaNode.e(i10), yogaNode.m() + f10, yogaNode.n() + f11);
            }
        }
    }

    public void calculateYogaLayout(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode == 1073741824) {
            this.f34513b.W(size);
        }
        if (mode == Integer.MIN_VALUE) {
            this.f34513b.M(size);
        }
        if (mode2 == 1073741824) {
            this.f34513b.F(size2);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.f34513b.K(size2);
        }
        this.f34513b.b(Float.NaN, Float.NaN);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f2;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f2(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f2(getContext(), attributeSet);
    }

    @Override // com.huawei.quickcard.framework.ui.IViewDirection
    public int getContentDirection() {
        YogaFlexDirection h10 = this.f34513b.h();
        int layoutDirection = getLayoutDirection();
        return h10 == YogaFlexDirection.ROW_REVERSE ? layoutDirection == 1 ? 0 : 1 : layoutDirection;
    }

    @Override // com.huawei.quickcard.framework.ui.YogaContainer
    public YogaNode getYogaNode() {
        return this.f34513b;
    }

    @Override // com.huawei.quickcard.framework.ui.YogaContainer
    public YogaNode getYogaNodeForView(View view) {
        return this.f34512a.get(view);
    }

    @Override // com.huawei.quickcard.framework.ui.YogaContainer
    public Map<View, YogaNode> getYogaNodes() {
        return this.f34512a;
    }

    @Override // com.huawei.quickcard.framework.ui.YogaContainer
    public void invalidate(View view) {
        if (this.f34512a.containsKey(view)) {
            this.f34512a.get(view).c();
            return;
        }
        int f10 = this.f34513b.f();
        for (int i10 = 0; i10 < f10; i10++) {
            Object g3 = this.f34513b.e(i10).g();
            if (g3 instanceof YogaContainer) {
                ((YogaContainer) g3).invalidate(view);
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (!(getParent() instanceof CardYogaLayout)) {
            calculateYogaLayout(View.MeasureSpec.makeMeasureSpec(i12 - i10, 1073741824), View.MeasureSpec.makeMeasureSpec(i13 - i11, 1073741824));
        }
        applyLayoutToView(this.f34513b, 0.0f, 0.0f);
        LayoutHolder.OnLayoutListener onLayoutListener = this.f34514c;
        if (onLayoutListener != null) {
            onLayoutListener.onLayout();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (!(getParent() instanceof CardYogaLayout)) {
            calculateYogaLayout(i10, i11);
        }
        setMeasuredDimension(Math.round(this.f34513b.l()), Math.round(this.f34513b.k()));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return GestureDelegate.onTouchEvent(this, motionEvent) | super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            a(getChildAt(i10), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            a(getChildAt(i10), true);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        a(getChildAt(i10), false);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            a(getChildAt(i12), false);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            a(getChildAt(i12), true);
        }
        super.removeViewsInLayout(i10, i11);
    }

    @Override // com.huawei.quickcard.views.image.view.LayoutHolder
    public void setOnLayoutListener(LayoutHolder.OnLayoutListener onLayoutListener) {
        this.f34514c = onLayoutListener;
    }

    public CardYogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(@NonNull YogaNode yogaNode) {
        YogaNode o10 = yogaNode.o();
        if (o10 != null) {
            for (int i10 = 0; i10 < o10.f(); i10++) {
                if (o10.e(i10).equals(yogaNode)) {
                    o10.s(i10);
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f2(layoutParams);
    }

    public CardYogaLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        YogaNode a10 = a();
        this.f34513b = a10;
        a10.C(YogaFlexDirection.ROW);
        a10.E(1.0f);
        this.f34512a = new HashMap();
        a10.y(this);
        a10.O(new a());
        applyLayoutDirection(a10, this);
    }

    private void a(View view, boolean z10) {
        YogaNode yogaNode = this.f34512a.get(view);
        if (yogaNode == null) {
            return;
        }
        a(yogaNode);
        yogaNode.y(null);
        this.f34512a.remove(view);
        if (z10) {
            this.f34513b.b(Float.NaN, Float.NaN);
        }
    }

    public void addView(View view, YogaNode yogaNode, int i10) {
        this.f34513b.O(null);
        if (yogaNode == null) {
            if (this.f34512a.containsKey(view)) {
                yogaNode = this.f34512a.get(view);
            } else {
                yogaNode = a();
            }
        }
        yogaNode.y(view);
        if (!(view instanceof CardYogaLayout)) {
            yogaNode.O(new a());
        }
        this.f34512a.put(view, yogaNode);
        this.f34513b.a(yogaNode, i10);
        applyLayoutDirection(yogaNode, view);
        addView(view, i10);
    }

    public void addView(View view, YogaNode yogaNode) {
        addView(view, yogaNode, -1);
    }
}
