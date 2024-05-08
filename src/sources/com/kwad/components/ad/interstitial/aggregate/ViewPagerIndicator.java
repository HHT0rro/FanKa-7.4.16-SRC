package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ViewPagerIndicator extends View {
    private int iU;

    /* renamed from: ja, reason: collision with root package name */
    private int f36499ja;

    /* renamed from: jb, reason: collision with root package name */
    private int f36500jb;

    /* renamed from: jc, reason: collision with root package name */
    private int f36501jc;

    /* renamed from: jd, reason: collision with root package name */
    private float f36502jd;

    /* renamed from: je, reason: collision with root package name */
    private float f36503je;
    private Paint jf;
    private float jg;
    private float jh;
    private float ji;
    private int jj;
    private Paint jk;
    private float jl;
    private boolean jm;
    private a jn;
    private ValueAnimator jo;
    private final Context mContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void cw();
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    private void cA() {
        Paint paint = new Paint(1);
        this.jf = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jf.setStrokeWidth(1.0f);
        this.jf.setColor(this.f36500jb);
        Paint paint2 = new Paint(1);
        this.jk = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jk.setStrokeWidth(1.0f);
        this.jk.setColor(this.f36499ja);
    }

    private void cB() {
        if (this.jj <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.ji, this.jh);
        this.jo = ofFloat;
        ofFloat.setDuration(this.jj * 1000);
        this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.jl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.jo.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewPagerIndicator.a(ViewPagerIndicator.this, true);
                if (ViewPagerIndicator.this.jn != null) {
                    ViewPagerIndicator.this.jn.cw();
                }
            }
        });
        this.jo.start();
    }

    @RequiresApi(api = 19)
    public final void cC() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    public final void cD() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.jg : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                if (this.f36501jc > 1) {
                    size = (int) (this.jh + ((r6 - 1) * (this.f36503je + this.ji)));
                } else {
                    size = (int) this.jh;
                }
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setFirstAdShowTime(int i10) {
        this.jj = i10;
    }

    public void setPlayProgressListener(a aVar) {
        this.jn = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.f36501jc = count;
        if (count <= 1) {
            return;
        }
        this.jm = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i10, float f10, int i11) {
                ViewPagerIndicator.this.iU = i10;
                ViewPagerIndicator.this.f36502jd = f10;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i10) {
                ViewPagerIndicator.this.iU = i10;
                ViewPagerIndicator.this.f36502jd = 0.0f;
                ViewPagerIndicator.this.invalidate();
            }
        });
        cB();
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(Canvas canvas) {
        if (this.jm || this.iU != 0) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, this.jl, this.jg);
        float f10 = this.jg;
        canvas.drawRoundRect(rectF, f10 / 2.0f, f10 / 2.0f, this.jk);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i10);
        cA();
    }

    public static /* synthetic */ boolean a(ViewPagerIndicator viewPagerIndicator, boolean z10) {
        viewPagerIndicator.jm = true;
        return true;
    }

    private void a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i10, 0);
        this.f36503je = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.d.a.a.a(this.mContext, 5.0f));
        this.jg = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.d.a.a.a(this.mContext, 6.0f));
        this.jh = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.d.a.a.a(this.mContext, 50.0f));
        this.ji = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.d.a.a.a(this.mContext, 6.0f));
        this.f36500jb = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.f36499ja = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF();
        for (int i10 = 0; i10 < this.f36501jc; i10++) {
            int i11 = this.iU;
            if (i10 < i11) {
                float f10 = this.f36503je;
                float f11 = this.ji;
                float f12 = i10 * (f10 + f11);
                rectF.left = f12;
                rectF.right = f12 + f11;
                this.jf.setColor(this.f36500jb);
            } else if (i10 == i11) {
                float f13 = this.f36503je;
                float f14 = this.ji;
                float f15 = i10 * (f13 + f14);
                rectF.left = f15;
                rectF.right = f15 + f14 + ((this.jh - f14) * (1.0f - this.f36502jd));
                if (this.jm) {
                    this.jf.setColor(this.f36499ja);
                    this.jf.setAlpha((int) (((1.0f - this.f36502jd) * 127.0f) + 127.0f));
                } else {
                    this.jf.setColor(this.f36500jb);
                }
            } else if (i10 == i11 + 1) {
                float f16 = this.f36503je;
                float f17 = this.ji;
                float f18 = this.jh;
                float f19 = this.f36502jd;
                float f20 = ((i10 - 1) * (f16 + f17)) + f17 + ((f18 - f17) * (1.0f - f19)) + f16;
                rectF.left = f20;
                rectF.right = f20 + (f19 * (f18 - f17)) + f17;
                if (this.jm) {
                    this.jf.setColor(this.f36499ja);
                    this.jf.setAlpha((int) (255.0f - ((1.0f - this.f36502jd) * 127.0f)));
                } else {
                    this.jf.setColor(this.f36500jb);
                }
            } else {
                float f21 = this.f36503je;
                float f22 = this.ji;
                float f23 = ((i10 - 1) * (f21 + f22)) + f21 + this.jh;
                rectF.left = f23;
                rectF.right = f23 + f22;
                this.jf.setColor(this.f36500jb);
            }
            rectF.top = 0.0f;
            float f24 = this.jg;
            rectF.bottom = 0.0f + f24;
            canvas.drawRoundRect(rectF, f24 / 2.0f, f24 / 2.0f, this.jf);
        }
    }
}
