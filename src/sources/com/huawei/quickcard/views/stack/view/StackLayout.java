package com.huawei.quickcard.views.stack.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.b;
import com.huawei.quickcard.framework.c;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.framework.ui.YogaContainer;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.YogaUtils;
import com.huawei.quickcard.views.GestureDelegate;
import com.huawei.quickcard.yoga.QuickCardYogaNodeFactory;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class StackLayout extends FrameLayout implements IComponentSupport, YogaContainer {

    /* renamed from: d, reason: collision with root package name */
    private static final String f34647d = "StackLayout";

    /* renamed from: a, reason: collision with root package name */
    private final YogaNode f34648a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<View, YogaNode> f34649b;

    /* renamed from: c, reason: collision with root package name */
    private ExposureManager f34650c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements YogaMeasureFunction {
        private int a(YogaMeasureMode yogaMeasureMode) {
            if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return yogaMeasureMode == YogaMeasureMode.EXACTLY ? 1073741824 : 0;
        }

        @Override // com.facebook.yoga.YogaMeasureFunction
        public long measure(YogaNode yogaNode, float f10, YogaMeasureMode yogaMeasureMode, float f11, YogaMeasureMode yogaMeasureMode2) {
            Object g3 = yogaNode.g();
            View view = g3 instanceof View ? (View) g3 : null;
            if (view != null && !(view instanceof StackLayout)) {
                view.measure(View.MeasureSpec.makeMeasureSpec((int) f10, a(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f11, a(yogaMeasureMode2)));
                return YogaMeasureOutput.b(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
            return YogaMeasureOutput.b(0, 0);
        }
    }

    public StackLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(YogaNode yogaNode) {
        Object g3 = yogaNode.g();
        View view = g3 instanceof View ? (View) g3 : null;
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int round = Math.round(yogaNode.m());
            int round2 = Math.round(yogaNode.n());
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.l()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.k()), 1073741824));
            view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
        }
        int f10 = yogaNode.f();
        for (int i10 = 0; i10 < f10; i10++) {
            a(yogaNode.e(i10));
        }
    }

    public static void applyLayoutDirection(YogaNode yogaNode, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            view.setTextDirection(4);
            view.setLayoutDirection(1);
            yogaNode.z(YogaDirection.RTL);
        } else {
            view.setTextDirection(3);
            view.setLayoutDirection(0);
            yogaNode.z(YogaDirection.LTR);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        YogaNode a10;
        this.f34648a.O(null);
        super.addView(view, i10, layoutParams);
        if (this.f34649b.containsKey(view)) {
            return;
        }
        if (view instanceof YogaContainer) {
            a10 = ((YogaContainer) view).getYogaNode();
        } else {
            if (this.f34649b.containsKey(view)) {
                a10 = this.f34649b.get(view);
            } else {
                a10 = a();
            }
            a10.y(view);
            a10.O(new a());
        }
        applyLayoutDirection(a10, view);
        this.f34649b.put(view, a10);
        if (i10 == -1) {
            i10 = this.f34648a.f();
        }
        this.f34648a.a(a10, i10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof FrameLayout.LayoutParams;
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        b.a(this, obj);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ ViewParent getViewParent(View view) {
        return c.a(this, view);
    }

    @Override // com.huawei.quickcard.framework.ui.YogaContainer
    public YogaNode getYogaNode() {
        return this.f34648a;
    }

    @Override // com.huawei.quickcard.framework.ui.YogaContainer
    public YogaNode getYogaNodeForView(View view) {
        return this.f34649b.get(view);
    }

    @Override // com.huawei.quickcard.framework.ui.YogaContainer
    public Map<View, YogaNode> getYogaNodes() {
        return this.f34649b;
    }

    @Override // com.huawei.quickcard.framework.ui.YogaContainer
    public void invalidate(View view) {
        if (this.f34649b.containsKey(view)) {
            this.f34649b.get(view).c();
            return;
        }
        int f10 = this.f34648a.f();
        for (int i10 = 0; i10 < f10; i10++) {
            Object g3 = this.f34648a.e(i10).g();
            if (g3 instanceof YogaContainer) {
                ((YogaContainer) g3).invalidate(view);
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ExposureManager exposureManager = this.f34650c;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExposureManager exposureManager = this.f34650c;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        a(getYogaNode());
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        a(i10, i11);
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34650c;
        if (exposureManager != null) {
            exposureManager.onScreenSateChange(this, i10);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return GestureDelegate.onTouchEvent(this, motionEvent) | super.onTouchEvent(motionEvent);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void onViewCreated(CardContext cardContext) {
        c.b(this, cardContext);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        ExposureManager exposureManager = this.f34650c;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
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

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34650c = exposureManager;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        c.c(this, viewParent);
    }

    public StackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public StackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new FrameLayout.LayoutParams(getContext(), attributeSet);
    }

    public StackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        FrameLayout.LayoutParams layoutParams;
        this.f34649b = new HashMap();
        YogaNode a10 = a();
        this.f34648a = a10;
        a10.C(YogaFlexDirection.ROW);
        a10.E(1.0f);
        a10.y(this);
        a10.O(new a());
        if (attributeSet != null) {
            layoutParams = new FrameLayout.LayoutParams(context, attributeSet);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        a(layoutParams, a10, this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new FrameLayout.LayoutParams(layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams, YogaNode yogaNode, View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                yogaNode.T(YogaEdge.RIGHT, r0.right);
                yogaNode.T(YogaEdge.BOTTOM, r0.bottom);
                yogaNode.T(YogaEdge.LEFT, r0.left);
                yogaNode.T(YogaEdge.TOP, r0.top);
            }
        }
        setLayoutParams(layoutParams);
    }

    public void addView(View view, YogaNode yogaNode, int i10) {
        this.f34648a.O(null);
        if (yogaNode == null) {
            if (this.f34649b.containsKey(view)) {
                yogaNode = this.f34649b.get(view);
            } else {
                yogaNode = a();
            }
        }
        yogaNode.y(view);
        if (!(view instanceof YogaContainer)) {
            yogaNode.O(new a());
        }
        this.f34649b.put(view, yogaNode);
        this.f34648a.a(yogaNode, i10);
        applyLayoutDirection(yogaNode, view);
        addView(view, i10);
    }

    private void a(int i10, int i11) {
        YogaNode yogaNode;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt != null && childAt.getLayoutParams() != null && (yogaNode = YogaUtils.getYogaNode(childAt)) != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(childAt);
                float viewHeightPercent = obtainPropertyCacheBeanFromView.getViewHeightPercent();
                if (viewHeightPercent >= 0.0f) {
                    int size = (int) (viewHeightPercent * View.MeasureSpec.getSize(i11));
                    layoutParams.height = size;
                    yogaNode.F(size);
                }
                float viewWidthPercent = obtainPropertyCacheBeanFromView.getViewWidthPercent();
                if (viewWidthPercent >= 0.0f) {
                    int size2 = (int) (viewWidthPercent * View.MeasureSpec.getSize(i10));
                    layoutParams.width = size2;
                    yogaNode.W(size2);
                }
                childAt.requestLayout();
            }
        }
    }

    private void a(View view, boolean z10) {
        YogaNode yogaNode = this.f34649b.get(view);
        if (yogaNode == null) {
            return;
        }
        YogaNode o10 = yogaNode.o();
        if (o10 != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= o10.f()) {
                    break;
                }
                if (o10.e(i10).equals(yogaNode)) {
                    o10.s(i10);
                    break;
                }
                i10++;
            }
        }
        yogaNode.y(null);
        this.f34649b.remove(view);
        if (z10) {
            this.f34648a.b(Float.NaN, Float.NaN);
        }
    }

    private static YogaNode a() {
        return QuickCardYogaNodeFactory.make();
    }
}
