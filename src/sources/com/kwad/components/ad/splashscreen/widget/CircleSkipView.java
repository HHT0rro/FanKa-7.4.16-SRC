package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CircleSkipView extends KSFrameLayout implements a {
    private int FA;
    private ValueAnimator FB;
    private boolean FC;
    private SkipView.a FD;
    private long FE;
    private float FF;
    private float Fy;
    private float Fz;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;
    private boolean sB;

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void S(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        T(context);
        addView(U(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.FD != null) {
                    CircleSkipView.this.FD.la();
                }
            }
        });
    }

    private void T(Context context) {
        this.FA = com.kwad.sdk.d.a.a.a(context, 2.0f);
        int a10 = com.kwad.sdk.d.a.a.a(context, 32.0f);
        int i10 = this.FA;
        this.radius = a10 - i10;
        this.padding = i10 / 2;
        int i11 = this.padding;
        int i12 = this.radius;
        this.mRectF = new RectF(i11, i11, i12 + i11, i12 + i11);
    }

    private static TextView U(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i10) {
        SkipView.a aVar = this.FD;
        if (aVar != null) {
            aVar.Y(i10);
        }
    }

    private void lP() {
        this.FC = true;
        ValueAnimator valueAnimator = this.FB;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.FE);
            this.FB.start();
        }
    }

    private void lQ() {
        this.FC = false;
        ValueAnimator valueAnimator = this.FB;
        if (valueAnimator != null) {
            this.FE = valueAnimator.getCurrentPlayTime();
            this.FB.cancel();
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.FA);
        paint.setColor(-1);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.FA);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void A(AdInfo adInfo) {
        lQ();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void B(AdInfo adInfo) {
        lP();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int aa(int i10) {
        getLayoutParams().height = com.kwad.sdk.d.a.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bf() {
        lQ();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.FA, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.FC) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.Fy, -this.Fz, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(SkipView.a aVar) {
        this.FD = aVar;
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(final int i10, final boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.FB = ofFloat;
        ofFloat.setDuration(i10);
        this.FB.setInterpolator(new LinearInterpolator());
        this.FB.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.FF != 1.0f || CircleSkipView.this.FD == null) {
                    return;
                }
                CircleSkipView.this.FD.lb();
            }
        });
        this.FB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.FF = floatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.X((int) ((i10 / 1000) * circleSkipView.FF));
                if (z10) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f10 = floatValue * 360.0f;
                    CircleSkipView.this.Fy = 270.0f - f10;
                    CircleSkipView.this.Fz = 360.0f - f10;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaint = new Paint();
        this.Fy = 270.0f;
        this.Fz = 360.0f;
        this.radius = 0;
        this.FA = 0;
        this.FC = false;
        this.FE = 0L;
        this.FF = 0.0f;
        this.padding = 0;
        this.sB = true;
        S(context);
    }

    public static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z10) {
        circleSkipView.FC = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sB = com.kwad.sdk.core.response.b.a.cx(adInfo);
        boolean cy = com.kwad.sdk.core.response.b.a.cy(adInfo);
        if (this.sB) {
            setVisibility(0);
        }
        c(splashSkipViewModel.skipSecond * 1000, cy);
    }
}
