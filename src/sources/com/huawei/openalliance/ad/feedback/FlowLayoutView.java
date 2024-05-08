package com.huawei.openalliance.ad.feedback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.utils.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlowLayoutView extends ViewGroup {
    private c B;
    private int D;
    private int F;
    private int L;
    private int S;

    /* renamed from: a, reason: collision with root package name */
    private final List<c> f32437a;

    public FlowLayoutView(Context context) {
        this(context, null);
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.D = 1;
        this.S = v.V(context, 8.0f);
        this.F = v.V(context, 8.0f);
        this.f32437a = new ArrayList();
        this.L = 0;
    }

    private void Code() {
        if (this.B == null) {
            this.B = new c();
        }
    }

    private void I() {
        int i10 = this.L;
        if (i10 > 0) {
            this.B.Code(i10 - this.S);
        }
        c cVar = this.B;
        if (cVar != null) {
            this.f32437a.add(cVar);
        }
        this.L = 0;
        this.B = new c();
    }

    private void V() {
        this.f32437a.clear();
        this.B = new c();
        this.L = 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = (getMeasuredWidth() - paddingLeft) - paddingTop;
        for (c cVar : this.f32437a) {
            cVar.Code(this.D, getLeft(), paddingLeft, paddingTop, measuredWidth, this.S);
            paddingTop = this.F + cVar.Code() + paddingTop;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i11) - getPaddingBottom()) - getPaddingTop();
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        V();
        Code();
        int childCount = getChildCount();
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, mode == 1073741824 ? Integer.MIN_VALUE : mode), View.MeasureSpec.makeMeasureSpec(size2, mode2 != 1073741824 ? mode2 : Integer.MIN_VALUE));
            int measuredWidth = childAt.getMeasuredWidth();
            if (this.L + measuredWidth > size) {
                I();
            }
            int i14 = this.L + this.S + measuredWidth;
            this.L = i14;
            this.B.Code(i14);
            this.B.Code(childAt);
        }
        c cVar = this.B;
        if (cVar != null && !this.f32437a.contains(cVar)) {
            I();
        }
        Iterator<c> iterator2 = this.f32437a.iterator2();
        while (iterator2.hasNext()) {
            i12 += iterator2.next().Code();
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), ViewGroup.resolveSize(i12 + (this.F * (this.f32437a.size() - 1)) + getPaddingBottom() + getPaddingTop(), i11));
    }

    public void setDefaultDisplayMode(int i10) {
        this.D = i10;
    }
}
