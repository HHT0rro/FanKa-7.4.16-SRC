package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.agdpro.R$style;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d extends View {
    public static final int CURSOR_IN_DOT_INDEX = -1;

    /* renamed from: a, reason: collision with root package name */
    public static final float f35099a = 700.0f;

    /* renamed from: b, reason: collision with root package name */
    public static final float f35100b = 0.47f;

    /* renamed from: c, reason: collision with root package name */
    public static final long f35101c = 250;

    /* renamed from: d, reason: collision with root package name */
    public static final long f35102d = 250;

    /* renamed from: e, reason: collision with root package name */
    public static final long f35103e = 250;

    /* renamed from: f, reason: collision with root package name */
    public static final long f35104f = 300;

    /* renamed from: g, reason: collision with root package name */
    public static final long f35105g = 100;

    /* renamed from: h, reason: collision with root package name */
    public static final long f35106h = 150;

    /* renamed from: i, reason: collision with root package name */
    public static final long f35107i = 400;

    /* renamed from: j, reason: collision with root package name */
    public float f35108j;

    /* renamed from: k, reason: collision with root package name */
    public TimeInterpolator f35109k;

    /* renamed from: l, reason: collision with root package name */
    public TimeInterpolator f35110l;

    /* renamed from: m, reason: collision with root package name */
    public TimeInterpolator f35111m;
    public HwDotsPageIndicatorAnimation mAnimator;
    public t mOptions;
    public float mSpringDamping;
    public float mSpringStiffness;

    /* renamed from: n, reason: collision with root package name */
    public TimeInterpolator f35112n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f35113a;

        /* renamed from: b, reason: collision with root package name */
        public float f35114b;

        /* renamed from: c, reason: collision with root package name */
        public float f35115c;

        /* renamed from: d, reason: collision with root package name */
        public float f35116d;

        /* renamed from: e, reason: collision with root package name */
        public float f35117e;

        public a(boolean z10, float f10, float f11, float f12, float f13) {
            this.f35113a = z10;
            this.f35114b = f10;
            this.f35115c = f11;
            this.f35116d = f12;
            this.f35117e = f13;
        }
    }

    public d(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(a(context, i10), attributeSet, i10);
        this.mOptions = new t();
        this.mSpringDamping = 0.47f;
        this.mSpringStiffness = 700.0f;
    }

    public TimeInterpolator getAccelerateInterpolator() {
        if (this.f35110l == null) {
            this.f35110l = u.a();
        }
        return this.f35110l;
    }

    public TimeInterpolator getAlphaInterpolator() {
        if (this.f35109k == null) {
            this.f35109k = u.b();
        }
        return this.f35109k;
    }

    public TimeInterpolator getDecelerateInterpolator() {
        if (this.f35111m == null) {
            this.f35111m = u.c();
        }
        return this.f35111m;
    }

    public float getMaxDiffFraction() {
        if (this.f35108j == 0.0f) {
            this.f35108j = u.a(getAccelerateInterpolator(), getDecelerateInterpolator());
        }
        return this.f35108j;
    }

    public TimeInterpolator getScaleInterpolator() {
        if (this.f35112n == null) {
            this.f35112n = u.d();
        }
        return this.f35112n;
    }

    public boolean isFocusAccelerateAnimationRunning() {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        return hwDotsPageIndicatorAnimation != null && hwDotsPageIndicatorAnimation.k();
    }

    public boolean isSpringAnimationRunning() {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        return hwDotsPageIndicatorAnimation != null && hwDotsPageIndicatorAnimation.o();
    }

    public void performDotCenterXsLayoutAnimation(@NonNull float[] fArr, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.a(new HwDotsPageIndicatorAnimation.Options.Builder().setStartCenterXs(this.mOptions.d()).setTargetCenterXs(fArr).setDuration(400L).setInterpolator(getAccelerateInterpolator()).setUpdateListener(animationUpdateListener).create());
        }
    }

    public void performFocusAccelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.c(new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(f10).setTargetLoc(f11).setDuration(400L).setInterpolator(getAccelerateInterpolator()).setUpdateListener(animationUpdateListener).create());
        }
    }

    public void performFocusSingleZoomInAnimation(@NonNull RectF rectF, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.a(true, new HwDotsPageIndicatorAnimation.Options.Builder().setStartFocusRectF(this.mOptions.l()).setTargetFocusRectF(rectF).setDuration(100L).setInterpolator(getAlphaInterpolator()).setUpdateListener(animationUpdateListener).create());
            this.mOptions.b(true);
        }
    }

    public void performFocusSingleZoomOutAnimation(@NonNull RectF rectF, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.a(false, new HwDotsPageIndicatorAnimation.Options.Builder().setStartFocusRectF(this.mOptions.l()).setTargetFocusRectF(rectF).setDuration(150L).setInterpolator(getAlphaInterpolator()).setUpdateListener(animationUpdateListener).create());
            this.mOptions.b(false);
        }
    }

    public void performHotZoneInVisibleAnimation(boolean z10, @NonNull t tVar, @NonNull View view, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.d(new HwDotsPageIndicatorAnimation.Options.Builder().setStartEntity(this.mOptions.b()).setEndEntity(tVar).setInterpolator(getAlphaInterpolator()).setDuration(z10 ? 250L : 300L).setUpdateListener(animationUpdateListener).setStateListener(new c(this, view)).create());
            this.mOptions.t(-1);
            this.mOptions.b(false);
            this.mOptions.a();
        }
    }

    public void performHotZoneVisibleAnimation(@NonNull t tVar, boolean z10, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.e(new HwDotsPageIndicatorAnimation.Options.Builder().setStartEntity(this.mOptions.b()).setEndEntity(tVar).setInterpolator(getAlphaInterpolator()).setDuration(250L).setUpdateListener(animationUpdateListener).setStateListener(animationStateListener).create());
        }
    }

    public void performSingleDotZoomInAnimation(int i10, float f10, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        if (hwDotsPageIndicatorAnimation != null) {
            hwDotsPageIndicatorAnimation.f(i10);
            this.mAnimator.a(i10, true, new HwDotsPageIndicatorAnimation.Options.Builder().setStartRadius(this.mOptions.f()).setTargetRadius(f10).setDuration(100L).setInterpolator(getAlphaInterpolator()).setUpdateListener(animationUpdateListener).setStateListener(new com.huawei.uikit.hwdotspageindicator.widget.a(this, i10)).create());
        }
    }

    public void performSingleDotZoomOutAnimation(int i10, @NonNull View view, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        if (hwDotsPageIndicatorAnimation != null) {
            hwDotsPageIndicatorAnimation.e(i10);
            this.mAnimator.a(i10, false, new HwDotsPageIndicatorAnimation.Options.Builder().setStartRadius(this.mOptions.y()).setTargetRadius(this.mOptions.f()).setDuration(150L).setInterpolator(getAlphaInterpolator()).setUpdateListener(animationUpdateListener).setStateListener(new b(this, i10, view)).create());
        }
    }

    public void performSpringAnimation(@NonNull a aVar, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.b(aVar.f35113a, new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(aVar.f35114b).setTargetLoc(aVar.f35115c).setStiffness(aVar.f35116d).setDamping(aVar.f35117e).setUpdateListener(animationUpdateListener).create());
        }
    }

    public void performTargetAccelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.c(new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(f10).setTargetLoc(f11).setDuration(400L).setInterpolator(getAccelerateInterpolator()).setUpdateListener(animationUpdateListener).setStateListener(animationStateListener).create());
        }
    }

    public void performTargetDecelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.b(new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(f10).setTargetLoc(f11).setDuration(400L).setInterpolator(getDecelerateInterpolator()).setUpdateListener(animationUpdateListener).setStateListener(animationStateListener).create());
        }
    }

    public void setAlphaInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        this.f35109k = timeInterpolator;
    }

    public void setDragAccelerateInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        this.f35110l = timeInterpolator;
        this.f35108j = u.a(timeInterpolator, getDecelerateInterpolator());
    }

    public void setDragDecelerateInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        this.f35111m = timeInterpolator;
        this.f35108j = u.a(getAccelerateInterpolator(), this.f35111m);
    }

    public void setScaleInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        this.f35112n = timeInterpolator;
    }

    public void setSpringAnimationDamping(@FloatRange(from = 0.0d) float f10) {
        if (f10 <= 0.0f) {
            f10 = this.mSpringDamping;
        }
        this.mSpringDamping = f10;
    }

    public void setSpringAnimationStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 <= 0.0f) {
            f10 = this.mSpringStiffness;
        }
        this.mSpringStiffness = f10;
    }

    public void stopSpringAnimation() {
        if (isSpringAnimationRunning()) {
            this.mAnimator.w();
        }
    }

    public static Context a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, R$style.Theme_Emui_HwDotsPageIndicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull View view) {
        if (this.mOptions.E()) {
            return;
        }
        this.mOptions.a();
        view.invalidate();
    }
}
