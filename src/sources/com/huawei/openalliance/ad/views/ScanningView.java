package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.fs;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.splash.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ScanningView extends View {
    private Bitmap B;
    private Bitmap C;
    private PorterDuffXfermode D;
    private Paint F;
    private int I;
    private float L;
    private Paint S;

    /* renamed from: a, reason: collision with root package name */
    private float f32992a;

    /* renamed from: b, reason: collision with root package name */
    private float f32993b;

    /* renamed from: c, reason: collision with root package name */
    private ValueAnimator f32994c;

    /* renamed from: d, reason: collision with root package name */
    private Animator.AnimatorListener f32995d;

    public ScanningView(Context context) {
        super(context);
        Z();
    }

    public ScanningView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Z();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScanningView);
        this.I = obtainStyledAttributes.getResourceId(R.styleable.ScanningView_lightImage, R.drawable.hiad_arrow_scan);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f32992a, this.f32993b);
        this.f32994c = ofFloat;
        ofFloat.setInterpolator(new fs(0.33f, 0.0f, 0.67f, 1.0f));
        this.f32994c.setDuration(2500L);
        this.f32994c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.ScanningView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScanningView.this.L = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScanningView.this.postInvalidate();
            }
        });
        this.f32994c.addListener(new AnimatorListenerAdapter() { // from class: com.huawei.openalliance.ad.views.ScanningView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ScanningView.this.setVisibility(8);
                if (ScanningView.this.f32995d != null) {
                    ScanningView.this.f32995d.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ScanningView.this.setVisibility(8);
                if (ScanningView.this.f32995d != null) {
                    ScanningView.this.f32995d.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ScanningView.this.setVisibility(0);
                if (ScanningView.this.f32995d != null) {
                    ScanningView.this.f32995d.onAnimationStart(animator);
                }
            }
        });
    }

    private void I() {
        this.C = BitmapFactory.decodeResource(getResources(), this.I);
    }

    private void Z() {
        Paint paint = new Paint(1);
        this.S = paint;
        paint.setDither(true);
        this.S.setFilterBitmap(true);
        Paint paint2 = new Paint(1);
        this.F = paint2;
        paint2.setDither(true);
        this.F.setStyle(Paint.Style.FILL);
        this.F.setColor(-1);
        this.F.setFilterBitmap(true);
        this.D = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public void Code() {
        if (this.B == null) {
            gl.V("ScanningView", "start, mSrcBitmap is null");
        } else {
            post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ScanningView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ScanningView.this.f32994c == null) {
                        ScanningView.this.B();
                    } else if (ScanningView.this.f32994c.isRunning()) {
                        ScanningView.this.f32994c.cancel();
                    }
                    ScanningView.this.f32994c.start();
                }
            });
        }
    }

    public void V() {
        ValueAnimator valueAnimator = this.f32994c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f32994c.cancel();
        }
        this.L = this.f32992a;
        postInvalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.B == null) {
            return;
        }
        try {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.S, 31);
            canvas.drawBitmap(this.C, 0.0f, this.L, this.S);
            this.S.setXfermode(this.D);
            canvas.drawBitmap(this.B, 0.0f, 0.0f, this.S);
            this.S.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        } catch (Throwable th) {
            gl.I("ScanningView", "draw exception: %s", th.getClass().getSimpleName());
        }
        super.draw(canvas);
    }

    public Bitmap getSrcBitmap() {
        return this.B;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        I();
        float f10 = i11;
        this.f32992a = f10;
        this.L = f10;
        this.f32993b = -i11;
    }

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f32995d = animatorListener;
    }

    public void setSrcBitmap(Bitmap bitmap) {
        this.B = bitmap;
    }
}
