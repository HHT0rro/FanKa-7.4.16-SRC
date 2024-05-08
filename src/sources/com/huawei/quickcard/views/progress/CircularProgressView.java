package com.huawei.quickcard.views.progress;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.b;
import com.huawei.quickcard.framework.c;
import com.huawei.quickcard.views.GestureDelegate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CircularProgressView extends ProgressBar implements IComponentSupport {

    /* renamed from: a, reason: collision with root package name */
    private ExposureManager f34639a;

    public CircularProgressView(Context context) {
        super(context);
        setProgressBarColor(-13388545);
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        b.a(this, obj);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ ViewParent getViewParent(View view) {
        return c.a(this, view);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ExposureManager exposureManager = this.f34639a;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExposureManager exposureManager = this.f34639a;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34639a;
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
        ExposureManager exposureManager = this.f34639a;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34639a = exposureManager;
    }

    public void setProgressBarColor(int i10) {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        c.c(this, viewParent);
    }
}
