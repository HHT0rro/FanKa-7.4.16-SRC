package com.huawei.uikit.hwcommon.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwAnimatedGradientDrawable extends GradientDrawable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f34907a = "HwAnimatedGradientDrawable";

    /* renamed from: b, reason: collision with root package name */
    public static final float f34908b = 0.9f;

    /* renamed from: c, reason: collision with root package name */
    public static final float f34909c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public static final float f34910d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    public static final float f34911e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public static final float f34912f = 12.0f;

    /* renamed from: g, reason: collision with root package name */
    public static final float f34913g = 4.0f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f34914h = 201326592;

    /* renamed from: i, reason: collision with root package name */
    public static final float f34915i = 0.5f;

    /* renamed from: j, reason: collision with root package name */
    public static final long f34916j = 100;

    /* renamed from: k, reason: collision with root package name */
    public static final int f34917k = 255;

    /* renamed from: l, reason: collision with root package name */
    public static final float f34918l = 1.0E-7f;

    /* renamed from: m, reason: collision with root package name */
    public static final float f34919m = 0.2f;

    /* renamed from: n, reason: collision with root package name */
    public static final float f34920n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    public static final float f34921o = 0.4f;

    /* renamed from: p, reason: collision with root package name */
    public static final float f34922p = 1.0f;
    public boolean A;

    /* renamed from: q, reason: collision with root package name */
    public TimeInterpolator f34923q;

    /* renamed from: r, reason: collision with root package name */
    public Animator f34924r;

    /* renamed from: s, reason: collision with root package name */
    public Animator f34925s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f34926t;

    /* renamed from: u, reason: collision with root package name */
    public float f34927u;

    /* renamed from: v, reason: collision with root package name */
    public float f34928v;

    /* renamed from: w, reason: collision with root package name */
    public float f34929w;

    /* renamed from: x, reason: collision with root package name */
    public float f34930x;

    /* renamed from: y, reason: collision with root package name */
    public float f34931y;

    /* renamed from: z, reason: collision with root package name */
    public float f34932z;

    public HwAnimatedGradientDrawable() {
        this(201326592, 1.0f, 12.0f);
    }

    private void a(int i10, float f10, float f11) {
        setShape(0);
        setColor(i10);
        setCornerRadius(f11);
        this.f34932z = f11;
        this.f34926t = false;
        this.f34927u = f10;
        this.f34930x = 0.0f;
        this.f34928v = 1.0f;
        this.f34929w = 0.9f;
        this.A = false;
    }

    private void b() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rectAlpha", this.f34927u);
        ofFloat.setDuration(100L);
        ofFloat.setInterpolator(this.f34923q);
        if (this.f34932z <= 0.0f && !this.A) {
            setRectScale(1.0f);
            animatorSet.play(ofFloat);
        } else {
            ObjectAnimator ofFloat2 = getRectAlpha() < 1.0E-7f ? ObjectAnimator.ofFloat(this, "rectScale", this.f34929w, this.f34928v) : ObjectAnimator.ofFloat(this, "rectScale", this.f34928v);
            ofFloat2.setDuration(100L);
            ofFloat2.setInterpolator(this.f34923q);
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        this.f34924r = animatorSet;
        animatorSet.start();
    }

    private void c() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rectAlpha", 0.0f);
        ofFloat.setDuration(100L);
        ofFloat.setInterpolator(this.f34923q);
        animatorSet.playTogether(ofFloat);
        this.f34925s = animatorSet;
        animatorSet.start();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f10 = this.f34930x;
        if (f10 < 1.0E-7f) {
            return;
        }
        float f11 = this.f34931y;
        setAlpha((int) (f10 * 255.0f));
        canvas.save();
        canvas.scale(f11, f11, canvas.getWidth() * 0.5f, canvas.getHeight() * 0.5f);
        super.draw(canvas);
        canvas.restore();
    }

    public float getMaxRectAlpha() {
        return this.f34927u;
    }

    public float getMaxRectScale() {
        return this.f34928v;
    }

    public float getMinRectScale() {
        return this.f34929w;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        outline.setRect(getBounds());
        outline.setAlpha(0.0f);
    }

    public float getRectAlpha() {
        return this.f34930x;
    }

    public float getRectScale() {
        return this.f34931y;
    }

    public boolean isForceDoScaleAnim() {
        return this.A;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z11 = true;
            } else if (i10 == 16842919) {
                z12 = true;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("State = ");
                sb2.append(i10);
            }
        }
        if (z11 && z12) {
            z10 = true;
        }
        a(z10);
        return true;
    }

    public void setForceDoScaleAnim(boolean z10) {
        this.A = z10;
    }

    public void setMaxRectAlpha(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f34927u = f10;
    }

    public void setMaxRectScale(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f34928v = f10;
    }

    public void setMinRectScale(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f34929w = f10;
    }

    @Keep
    public void setRectAlpha(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f34930x = f10;
        invalidateSelf();
    }

    @Keep
    public void setRectScale(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.f34931y = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (!z10) {
            a();
        } else if (visible) {
            if (this.f34926t) {
                this.f34930x = this.f34927u;
                this.f34931y = this.f34928v;
            } else {
                this.f34930x = 0.0f;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isChanged = ");
            sb2.append(visible);
        }
        return visible;
    }

    public HwAnimatedGradientDrawable(int i10, float f10, float f11) {
        this.f34923q = new HwCubicBezierInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        a(i10, f10, f11);
    }

    public HwAnimatedGradientDrawable(Context context) {
        this(201326592, 1.0f, context);
    }

    public HwAnimatedGradientDrawable(int i10, float f10, Context context) {
        this(i10, f10, 4.0f, context);
    }

    public HwAnimatedGradientDrawable(int i10, float f10, float f11, Context context) {
        this.f34923q = new HwCubicBezierInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        if (context != null) {
            a(i10, f10, f11 * context.getResources().getDisplayMetrics().density);
        } else {
            a(i10, f10, 12.0f);
        }
    }

    private void a(boolean z10) {
        if (this.f34926t != z10) {
            this.f34926t = z10;
            if (z10) {
                Animator animator = this.f34924r;
                if (animator == null || !animator.isRunning()) {
                    Animator animator2 = this.f34925s;
                    if (animator2 != null && animator2.isRunning()) {
                        this.f34925s.cancel();
                    }
                    b();
                    return;
                }
                return;
            }
            Animator animator3 = this.f34925s;
            if (animator3 == null || !animator3.isRunning()) {
                Animator animator4 = this.f34924r;
                if (animator4 != null && animator4.isRunning()) {
                    this.f34924r.cancel();
                }
                c();
            }
        }
    }

    private void a() {
        Animator animator = this.f34924r;
        if (animator != null && animator.isRunning()) {
            this.f34924r.end();
        }
        Animator animator2 = this.f34925s;
        if (animator2 != null && animator2.isRunning()) {
            this.f34925s.end();
        }
        this.f34924r = null;
        this.f34925s = null;
        this.f34926t = false;
        this.f34930x = 0.0f;
        invalidateSelf();
    }
}
