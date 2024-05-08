package com.huawei.openalliance.ad.views;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.fs;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ScanningRelativeLayout extends AutoScaleSizeRelativeLayout {
    private int B;
    private int C;
    private Paint D;
    private Bitmap F;
    private Paint L;
    private Bitmap S;

    /* renamed from: a, reason: collision with root package name */
    private float f32987a;

    /* renamed from: b, reason: collision with root package name */
    private float f32988b;

    /* renamed from: c, reason: collision with root package name */
    private float f32989c;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f32990d;

    /* renamed from: e, reason: collision with root package name */
    private PorterDuffXfermode f32991e;

    public ScanningRelativeLayout(Context context) {
        super(context);
        B();
    }

    public ScanningRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScanningRelativeLayout);
        this.B = obtainStyledAttributes.getResourceId(R.styleable.ScanningRelativeLayout_layoutScanImage, R.drawable.hiad_scan);
        this.C = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ScanningRelativeLayout_layoutRadius, 36);
        obtainStyledAttributes.recycle();
        B();
    }

    private void B() {
        gl.V("ScanningRelativeLayout", "init");
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.B);
            this.F = decodeResource;
            float f10 = -decodeResource.getWidth();
            this.f32988b = f10;
            this.f32987a = f10;
            Paint paint = new Paint(1);
            this.L = paint;
            paint.setDither(true);
            this.L.setFilterBitmap(true);
            Paint paint2 = new Paint(1);
            this.D = paint2;
            paint2.setDither(true);
            this.D.setStyle(Paint.Style.FILL);
            this.D.setColor(-1);
            this.D.setFilterBitmap(true);
            this.f32991e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } catch (Throwable th) {
            gl.I("ScanningRelativeLayout", "init exception: %s", th.getClass().getSimpleName());
        }
    }

    private void C() {
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        try {
            this.S = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.S).drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), v.V(getContext(), this.C), v.V(getContext(), this.C), this.D);
        } catch (Throwable th) {
            gl.I("ScanningRelativeLayout", "createBitMapException: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        try {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0.0f, this.f32988b), Keyframe.ofFloat(1.0f, this.f32989c)));
            this.f32990d = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new fs(0.2f, 0.0f, 0.2f, 1.0f));
            this.f32990d.setDuration(1500L);
            this.f32990d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.ScanningRelativeLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ScanningRelativeLayout.this.f32987a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ScanningRelativeLayout.this.postInvalidate();
                }
            });
        } catch (Throwable th) {
            gl.I("ScanningRelativeLayout", "init animator exception: %s", th.getClass().getSimpleName());
        }
    }

    public void Code() {
        gl.V("ScanningRelativeLayout", bg.b.Code);
        try {
            ValueAnimator valueAnimator = this.f32990d;
            if (valueAnimator == null) {
                S();
            } else if (valueAnimator.isRunning()) {
                this.f32990d.cancel();
            }
        } catch (Throwable th) {
            gl.I("ScanningRelativeLayout", "prepare scan exception: %s", th.getClass().getSimpleName());
        }
    }

    public void I() {
        gl.V("ScanningRelativeLayout", "stop");
        try {
            ValueAnimator valueAnimator = this.f32990d;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f32990d.cancel();
            }
        } catch (Throwable th) {
            gl.I("ScanningRelativeLayout", "cancel animation exception: %s", th.getClass().getSimpleName());
        }
        this.f32987a = this.f32988b;
        postInvalidate();
    }

    public void V() {
        gl.V("ScanningRelativeLayout", "start");
        post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ScanningRelativeLayout.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanningRelativeLayout.this.f32990d == null) {
                        ScanningRelativeLayout.this.S();
                    } else if (ScanningRelativeLayout.this.f32990d.isRunning()) {
                        ScanningRelativeLayout.this.f32990d.cancel();
                    }
                    ScanningRelativeLayout.this.f32990d.start();
                } catch (Throwable th) {
                    gl.I("ScanningRelativeLayout", "start scan exception: %s", th.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.S == null) {
            return;
        }
        try {
            canvas.drawBitmap(this.F, this.f32987a, 0.0f, this.L);
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.L, 31);
            this.L.setXfermode(this.f32991e);
            canvas.drawBitmap(this.S, 0.0f, 0.0f, this.L);
            this.L.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        } catch (Throwable th) {
            gl.I("ScanningRelativeLayout", "dispatchDraw exception: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f32990d;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f32990d.cancel();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        C();
        this.f32989c = i10;
    }

    public void setRadius(int i10) {
        this.C = i10;
        setRectCornerRadius(v.V(getContext(), i10));
    }
}
