package com.huawei.uikit.hwcommon.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwOutLineLayout extends FrameLayout {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OutLineCallback {
        void onParentDraw(Canvas canvas);
    }

    public HwOutLineLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        setClipChildren(false);
        setClipToPadding(false);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            return;
        }
        super.addView(view, i10, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        if (canvas == null || view == 0) {
            return false;
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        if (view instanceof OutLineCallback) {
            canvas.save();
            canvas.translate(view.getLeft(), view.getTop());
            ((OutLineCallback) view).onParentDraw(canvas);
            canvas.restore();
        }
        return drawChild;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(getParent());
    }

    public HwOutLineLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HwOutLineLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        a();
    }

    private void a(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }
}
