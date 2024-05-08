package com.huawei.quickcard.views.progress;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.b;
import com.huawei.quickcard.framework.c;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.GestureDelegate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HorizontalProgressView extends FrameLayout implements IComponentSupport {
    public static final int DEFAULT_COLOR = -13388545;
    public static final int DEFAULT_LAYER_COLOR = -986896;
    public static final String DEFAULT_LAYER_COLOR_STR = "#fff0f0f0";
    public static final long DEFAULT_SPEED = 16;

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar f34640a;

    /* renamed from: b, reason: collision with root package name */
    private String f34641b;

    /* renamed from: c, reason: collision with root package name */
    private GradientDrawable f34642c;

    /* renamed from: d, reason: collision with root package name */
    private GradientDrawable f34643d;

    /* renamed from: e, reason: collision with root package name */
    private ExposureManager f34644e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f34645f;

    public HorizontalProgressView(@NonNull Context context) {
        super(context);
        this.f34641b = Attributes.LayoutDirection.AUTO;
        a(context);
    }

    private void a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f34643d = gradientDrawable;
        gradientDrawable.setColors(new int[]{DEFAULT_LAYER_COLOR, DEFAULT_LAYER_COLOR});
        this.f34643d.setCornerRadius(15.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f34642c = gradientDrawable2;
        gradientDrawable2.setColor(-13388545);
        this.f34642c.setCornerRadius(15.0f);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f34643d, new ClipDrawable(this.f34642c, 8388611, 1)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        this.f34640a = progressBar;
        progressBar.setProgressDrawable(layerDrawable);
        addView(this.f34640a, new FrameLayout.LayoutParams(-1, getDefaultDimension(), 16));
        a();
    }

    private void b() {
        setProgressDir(0);
        setLayoutDirection(0);
        setTextDirection(3);
    }

    private void c() {
        setProgressDir(180);
        setLayoutDirection(1);
        setTextDirection(4);
    }

    private void setProgressDir(int i10) {
        this.f34640a.setRotation(i10);
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        b.a(this, obj);
    }

    public int getDefaultDimension() {
        return (int) ViewUtils.dip2FloatPx(ViewUtils.getConfigDensity(getContext(), ViewUtils.getCardContext(this)), 32.0f);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ ViewParent getViewParent(View view) {
        return c.a(this, view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ExposureManager exposureManager = this.f34644e;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExposureManager exposureManager = this.f34644e;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34644e;
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
        ExposureManager exposureManager = this.f34644e;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
    }

    public void setColor(int i10) {
        GradientDrawable gradientDrawable = this.f34642c;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(i10);
        }
    }

    public void setDirection(String str) {
        if (this.f34640a == null || TextUtils.isEmpty(str) || this.f34641b.equals(str)) {
            return;
        }
        str.hashCode();
        if (str.equals(Attributes.LayoutDirection.LTR)) {
            b();
        } else if (!str.equals(Attributes.LayoutDirection.RTL)) {
            a();
        } else {
            c();
        }
        this.f34641b = str;
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34644e = exposureManager;
    }

    public void setLayerColor(int i10) {
        GradientDrawable gradientDrawable = this.f34643d;
        if (gradientDrawable != null) {
            gradientDrawable.setColors(new int[]{i10, i10});
        }
    }

    public void setPercent(int i10) {
        if (this.f34640a != null) {
            int min = Math.min(Math.max(i10, 0), 100);
            if (this.f34645f) {
                setPercentSmoothly(min);
            } else {
                this.f34640a.setProgress(min);
            }
        }
    }

    public void setPercentSmoothly(@IntRange(from = 0, to = 100) int i10) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f34640a, "progress", i10);
        ofInt.setDuration(Math.abs(i10 - this.f34640a.getProgress()) * 16);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.start();
    }

    public void setSmoothEnable(boolean z10) {
        this.f34645f = z10;
    }

    public void setStrokeWidth(int i10) {
        if (this.f34640a != null) {
            if (i10 <= 0) {
                i10 = getDefaultDimension();
            }
            ViewGroup.LayoutParams layoutParams = this.f34640a.getLayoutParams();
            layoutParams.height = i10;
            this.f34640a.setLayoutParams(layoutParams);
        }
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        c.c(this, viewParent);
    }

    public HorizontalProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34641b = Attributes.LayoutDirection.AUTO;
        a(context);
    }

    public HorizontalProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f34641b = Attributes.LayoutDirection.AUTO;
        a(context);
    }

    public HorizontalProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f34641b = Attributes.LayoutDirection.AUTO;
        a(context);
    }

    private void a() {
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            c();
        } else {
            b();
        }
    }
}
