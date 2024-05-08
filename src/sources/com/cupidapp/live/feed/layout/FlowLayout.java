package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlowLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public int f14522b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14523c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@Nullable Context context) {
        super(context);
        this.f14523c = new LinkedHashMap();
    }

    @Override // android.view.ViewGroup
    @NotNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    @NotNull
    public ViewGroup.LayoutParams generateLayoutParams(@NotNull ViewGroup.LayoutParams p10) {
        kotlin.jvm.internal.s.i(p10, "p");
        return new ViewGroup.MarginLayoutParams(p10);
    }

    public final int getNewLineCount() {
        return this.f14522b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            if (i17 == 0) {
                this.f14522b = 0;
            }
            View childAt = getChildAt(i17);
            kotlin.jvm.internal.s.h(childAt, "getChildAt(i)");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            kotlin.jvm.internal.s.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i18 = i14 + measuredWidth;
            if (i18 > getMeasuredWidth()) {
                this.f14522b++;
                i15 += i16;
                int i19 = marginLayoutParams.leftMargin;
                childAt.layout(i19, marginLayoutParams.topMargin + i15, childAt.getMeasuredWidth() + i19, marginLayoutParams.topMargin + i15 + childAt.getMeasuredHeight());
                i14 = measuredWidth;
                i16 = measuredHeight;
            } else {
                int i20 = marginLayoutParams.leftMargin;
                childAt.layout(i14 + i20, marginLayoutParams.topMargin + i15, i14 + i20 + childAt.getMeasuredWidth(), marginLayoutParams.topMargin + i15 + childAt.getMeasuredHeight());
                i16 = ce.n.b(measuredHeight, i16);
                i14 = i18;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(size2);
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            kotlin.jvm.internal.s.h(childAt, "getChildAt(i)");
            measureChild(childAt, i10, i11);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            kotlin.jvm.internal.s.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            i12 += measuredWidth;
            if (i12 > size) {
                i13 += i14;
                i14 = measuredHeight;
                i12 = measuredWidth;
            } else {
                i14 = ce.n.b(measuredHeight, i14);
            }
            if (i15 == childCount - 1) {
                i13 += i14;
            }
        }
        if (mode != 1073741824) {
            size2 = i13;
        }
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14523c = new LinkedHashMap();
    }

    @Override // android.view.ViewGroup
    @NotNull
    public ViewGroup.LayoutParams generateLayoutParams(@Nullable AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14523c = new LinkedHashMap();
    }
}
