package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.huawei.appgallery.agd.agdpro.R$attr;
import com.huawei.appgallery.agd.agdpro.R$color;
import com.huawei.appgallery.agd.agdpro.R$dimen;
import com.huawei.appgallery.agd.agdpro.R$plurals;
import com.huawei.appgallery.agd.agdpro.R$string;
import com.huawei.appgallery.agd.agdpro.R$styleable;
import com.huawei.uikit.hwcommon.utils.HwVibrateUtil;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorInteractor;
import com.huawei.uikit.hwdotspageindicator.widget.d;
import com.huawei.uikit.hwdotspageindicator.widget.u;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwDotsPageIndicator extends com.huawei.uikit.hwdotspageindicator.widget.d implements HwViewPager.OnPageChangeListener, View.OnClickListener, HwDotsPageIndicatorAnimation.AnimationUpdateListener {

    /* renamed from: o, reason: collision with root package name */
    public static final String f34998o = "HwDotsPageIndicator";

    /* renamed from: p, reason: collision with root package name */
    public static final boolean f34999p = false;

    /* renamed from: q, reason: collision with root package name */
    public static final int f35000q = 11;

    /* renamed from: r, reason: collision with root package name */
    public static final int f35001r = 5000;

    /* renamed from: s, reason: collision with root package name */
    public static final float f35002s = 2.0f;

    /* renamed from: t, reason: collision with root package name */
    public static final int f35003t = 2;

    /* renamed from: u, reason: collision with root package name */
    public static final int f35004u = 1;

    /* renamed from: v, reason: collision with root package name */
    public static final int f35005v = 3;

    /* renamed from: w, reason: collision with root package name */
    public static final long f35006w = 300;

    /* renamed from: x, reason: collision with root package name */
    public static final long f35007x = 100;

    /* renamed from: y, reason: collision with root package name */
    public static final float f35008y = 1.0f;
    public boolean A;
    public HwViewPager.OnPageChangeListener Aa;
    public boolean B;
    public Handler Ba;
    public boolean C;
    public Paint Ca;
    public boolean D;
    public Paint Da;
    public boolean E;
    public Paint Ea;
    public int F;
    public Paint Fa;
    public boolean G;
    public Paint.FontMetrics Ga;
    public boolean H;
    public u.a Ha;
    public boolean I;
    public HwDotsPageIndicatorInteractor.OnClickListener Ia;
    public int J;
    public HwDotsPageIndicatorInteractor.OnGestureListener Ja;
    public float K;
    public HwDotsPageIndicatorInteractor.OnMouseOperationListener Ka;
    public int L;
    public b La;
    public float M;
    public d Ma;
    public int N;
    public a Na;
    public int O;
    public c Oa;
    public int P;
    public RectF Pa;
    public int Q;
    public RectF Qa;
    public int R;
    public RectF Ra;
    public int S;
    public RectF Sa;
    public int T;
    public RectF Ta;
    public int U;
    public final Runnable Ua;
    public float V;
    public int W;

    /* renamed from: aa, reason: collision with root package name */
    public int f35009aa;

    /* renamed from: ba, reason: collision with root package name */
    public int f35010ba;

    /* renamed from: ca, reason: collision with root package name */
    public float f35011ca;

    /* renamed from: da, reason: collision with root package name */
    public int f35012da;

    /* renamed from: ea, reason: collision with root package name */
    public int f35013ea;

    /* renamed from: fa, reason: collision with root package name */
    public int f35014fa;

    /* renamed from: ga, reason: collision with root package name */
    public int f35015ga;

    /* renamed from: ha, reason: collision with root package name */
    public int f35016ha;

    /* renamed from: ia, reason: collision with root package name */
    public int f35017ia;

    /* renamed from: ja, reason: collision with root package name */
    public float f35018ja;

    /* renamed from: ka, reason: collision with root package name */
    public float f35019ka;

    /* renamed from: la, reason: collision with root package name */
    public float f35020la;

    /* renamed from: ma, reason: collision with root package name */
    public int f35021ma;

    /* renamed from: na, reason: collision with root package name */
    public int f35022na;

    /* renamed from: oa, reason: collision with root package name */
    public boolean f35023oa;

    /* renamed from: pa, reason: collision with root package name */
    public String f35024pa;

    /* renamed from: qa, reason: collision with root package name */
    public boolean f35025qa;

    /* renamed from: ra, reason: collision with root package name */
    public float f35026ra;

    /* renamed from: sa, reason: collision with root package name */
    public long f35027sa;

    /* renamed from: ta, reason: collision with root package name */
    public boolean f35028ta;

    /* renamed from: ua, reason: collision with root package name */
    public boolean f35029ua;

    /* renamed from: va, reason: collision with root package name */
    public boolean f35030va;

    /* renamed from: wa, reason: collision with root package name */
    public boolean f35031wa;

    /* renamed from: xa, reason: collision with root package name */
    public boolean f35032xa;

    /* renamed from: ya, reason: collision with root package name */
    public boolean f35033ya;

    /* renamed from: z, reason: collision with root package name */
    public int f35034z;

    /* renamed from: za, reason: collision with root package name */
    public HwViewPager f35035za;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HwDotsPageIndicator.this.Ja != null && HwDotsPageIndicator.this.B) {
                HwDotsPageIndicator.this.Ja.onLongPress(1);
            }
            HwDotsPageIndicator.this.doHotZoneVisibleAnimation(true);
        }

        public /* synthetic */ a(HwDotsPageIndicator hwDotsPageIndicator, e eVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        COMMON,
        VISIBLE,
        MOUSE_ON_DOT
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwDotsPageIndicator.this.doHotZoneInVisibleAnimation(false);
        }

        public /* synthetic */ c(HwDotsPageIndicator hwDotsPageIndicator, e eVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum d {
        DEFAULT,
        TARGET,
        SLIDE
    }

    public HwDotsPageIndicator(@NonNull Context context) {
        this(context, null);
    }

    private void A() {
        HwViewPager hwViewPager = this.f35035za;
        boolean z10 = false;
        int currentItem = hwViewPager != null ? hwViewPager.getCurrentItem() : 0;
        this.f35022na = currentItem;
        this.mOptions.q(currentItem);
        if (!this.G) {
            if (v()) {
                this.f35024pa = this.f35021ma + "/" + (this.f35022na + 1);
                return;
            }
            this.f35024pa = (this.f35022na + 1) + "/" + this.f35021ma;
            return;
        }
        if (this.f35025qa && v()) {
            z10 = true;
        }
        this.I = z10;
        this.mOptions.c(z10);
    }

    private void B() {
        Handler handler = this.Ba;
        if (handler != null) {
            handler.removeCallbacks(this.Ua);
        }
        this.Ba = null;
    }

    private int getDesiredWidth() {
        float f10 = this.f35015ga * 2.0f;
        int i10 = this.N;
        int i11 = this.f35021ma - 1;
        return (int) (f10 + (i10 * i11) + (this.J * i11) + this.T);
    }

    private int getDistanceProper() {
        int i10;
        int i11;
        if (x()) {
            i10 = this.N;
            i11 = this.J;
        } else {
            i10 = this.O;
            i11 = this.L;
        }
        return i10 + i11;
    }

    private int getScaledWidth() {
        float f10 = this.f35015ga * 2.0f;
        int i10 = this.O;
        int i11 = this.f35021ma - 1;
        return (int) (f10 + (i10 * i11) + (this.L * i11) + this.f35010ba);
    }

    @Nullable
    public static HwDotsPageIndicator instantiate(@NonNull Context context) {
        Object instantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwDotsPageIndicator.class, HwWidgetInstantiator.getCurrentType(context, 11, 1)), HwDotsPageIndicator.class);
        if (instantiate instanceof HwDotsPageIndicator) {
            return (HwDotsPageIndicator) instantiate;
        }
        return null;
    }

    private void m() {
        this.Ba = new Handler();
    }

    private t n() {
        t b4 = this.mOptions.b();
        b4.d(this.K);
        b4.p(this.f35009aa);
        b4.a(this.mOptions.j(this.f35022na));
        b4.c(this.mOptions.c());
        b4.b(this.Sa);
        b4.h(this.f35011ca - this.K);
        b4.g(this.mOptions.g(this.f35022na));
        b4.f(this.mOptions.e(this.f35022na));
        b4.k(this.f35011ca + this.K);
        return b4;
    }

    private void o() {
        if (this.Ta == null) {
            return;
        }
        if (this.Qa == null) {
            this.Qa = new RectF();
        }
        int i10 = this.f35022na;
        if (i10 == this.f35021ma - 1) {
            this.Qa = new RectF();
            return;
        }
        this.Qa.left = this.I ? this.Ta.left : this.mOptions.e(i10) + (this.N / 2.0f);
        RectF rectF = this.Qa;
        RectF rectF2 = this.Ta;
        rectF.top = rectF2.top;
        rectF.right = this.I ? this.mOptions.e(this.f35022na) - (this.N / 2.0f) : rectF2.right;
        this.Qa.bottom = this.Ta.bottom;
    }

    private void p() {
        Resources resources = getResources();
        this.f35020la = resources.getDimensionPixelSize(R$dimen.emui_text_size_body2);
        this.f35013ea = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_total_height);
        this.f35017ia = resources.getDimensionPixelSize(R$dimen.hwdotspageindocator_hot_zone_num_margin);
        this.V = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_focus_box_width);
        Paint paint = new Paint(1);
        this.Ea = paint;
        paint.setTextSize(this.f35020la);
        this.Ea.setColor(this.f35014fa);
        this.Ea.setTextAlign(Paint.Align.CENTER);
        this.Ea.setTypeface(Typeface.create(getResources().getString(R$string.emui_text_font_family_regular), 0));
        this.Ga = this.Ea.getFontMetrics();
    }

    private void q() {
        this.mOptions.c(this.I);
        this.mOptions.h(this.f35011ca - this.K);
        this.mOptions.k(this.f35011ca + this.K);
        t tVar = this.mOptions;
        tVar.g(tVar.g(this.f35022na));
        t tVar2 = this.mOptions;
        tVar2.f(tVar2.e(this.f35022na));
        this.mOptions.d(this.K);
        this.mOptions.l(this.K);
        this.mOptions.p(this.f35009aa);
        this.mOptions.a(this.mOptions.j(this.f35022na));
        this.mOptions.c(this.f35011ca);
        this.mOptions.b(this.Sa);
    }

    private void r() {
        if (this.Ta == null) {
            return;
        }
        if (this.Pa == null) {
            this.Pa = new RectF();
        }
        int i10 = this.f35022na;
        if (i10 == 0) {
            this.Pa = new RectF();
            return;
        }
        this.Pa.left = this.I ? (this.N / 2.0f) + this.mOptions.g(i10) : this.Ta.left;
        RectF rectF = this.Pa;
        RectF rectF2 = this.Ta;
        rectF.top = rectF2.top;
        rectF.right = this.I ? rectF2.right : this.mOptions.g(this.f35022na) - (this.N / 2.0f);
        this.Pa.bottom = this.Ta.bottom;
    }

    private void s() {
        float width = (((getWidth() - getPaddingRight()) - getScaledWidth()) / 2.0f) + getPaddingLeft() + this.f35015ga;
        this.mOptions.b(width);
        float f10 = width - this.f35015ga;
        this.Ra = new RectF(f10, this.f35011ca - (this.f35013ea / 2.0f), getScaledWidth() + f10, (this.f35013ea / 2.0f) + this.f35011ca);
    }

    private void setCurrentItemIndirect(int i10) {
        HwViewPager hwViewPager = this.f35035za;
        if (hwViewPager == null || hwViewPager.getAdapter() == null || this.f35035za.getAdapter().getCount() < 2 || i10 < 0 || i10 >= this.f35021ma) {
            return;
        }
        this.f35035za.setCurrentItem(i10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageCount(int i10) {
        this.f35021ma = i10;
        this.mOptions.r(i10);
        c();
        requestLayout();
        invalidate();
    }

    private void settleToTarget(int i10) {
        this.Ha.a(this.f35026ra);
        this.Ha.b(this.f35026ra);
        this.Ha.a(true);
        setCurrentItemIndirect(i10);
        if (isHapticFeedbackEnabled()) {
            HwVibrateUtil.vibrator(this, 7, 0);
        }
        a(1.0f, 3, i10);
    }

    private t t() {
        t b4 = this.mOptions.b();
        b4.d(this.L / 2.0f);
        b4.p(this.W);
        b4.a(this.mOptions.k(this.f35022na));
        b4.c(this.mOptions.c());
        b4.b(this.Ra);
        b4.h(this.f35011ca - (this.L / 2.0f));
        b4.k((this.L / 2.0f) + this.f35011ca);
        b4.g(this.mOptions.i(this.f35022na));
        b4.f(this.mOptions.h(this.f35022na));
        return b4;
    }

    private boolean u() {
        return getLayoutDirection() == 1;
    }

    private boolean v() {
        String language = Locale.getDefault().getLanguage();
        return (language.contains("ar") || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(com.huawei.openalliance.ad.constant.u.cF)) || u();
    }

    private boolean w() {
        return (!this.G || this.B || this.A) ? false : true;
    }

    private boolean x() {
        return this.La == b.COMMON;
    }

    private void y() {
        c cVar = this.Oa;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
    }

    private void z() {
        t tVar = this.mOptions;
        tVar.g(tVar.d(x(), this.f35022na));
        t tVar2 = this.mOptions;
        tVar2.f(tVar2.c(x(), this.f35022na));
        this.mOptions.h(this.f35011ca - (this.L / 2.0f));
        this.mOptions.k((this.L / 2.0f) + this.f35011ca);
        this.mOptions.b(false);
    }

    public void doHotZoneInVisibleAnimation(boolean z10) {
        t n10 = n();
        if (!this.B) {
            this.mOptions = n10;
            invalidate();
            this.La = b.COMMON;
            this.F = 0;
            this.mOptions.t(-1);
            this.mOptions.a();
            return;
        }
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator;
        if (hwDotsPageIndicatorAnimation == null || hwDotsPageIndicatorAnimation.n()) {
            return;
        }
        ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.x();
        stopSpringAnimation();
        performHotZoneInVisibleAnimation(z10, n10, this, this);
        this.La = b.COMMON;
        this.F = 0;
    }

    public void doHotZoneVisibleAnimation(boolean z10) {
        HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener;
        HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener2;
        HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener;
        t t2 = t();
        if (!this.B) {
            this.mOptions = t2;
            invalidate();
            this.La = b.VISIBLE;
            this.Ha.a(this.f35026ra);
            if (z10 && (onGestureListener = this.Ja) != null) {
                onGestureListener.onLongPress(2);
            }
            if (z10 || (onMouseOperationListener2 = this.Ka) == null) {
                return;
            }
            onMouseOperationListener2.onMoveInHotZone(2);
            return;
        }
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator;
        if (hwDotsPageIndicatorAnimation == null || hwDotsPageIndicatorAnimation.p()) {
            return;
        }
        ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.v();
        stopSpringAnimation();
        g gVar = new g(this, z10);
        if (!z10 && (onMouseOperationListener = this.Ka) != null) {
            onMouseOperationListener.onMoveInHotZone(1);
        }
        performHotZoneVisibleAnimation(t2, z10, this, gVar);
        this.La = b.VISIBLE;
    }

    public void drawFocusBgBox(@NonNull Canvas canvas, @Nullable RectF rectF) {
        Paint paint = new Paint(1);
        paint.setStrokeWidth(this.V);
        paint.setColor(this.U);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF2 = new RectF();
        if (!this.G) {
            float measureText = this.Ea.measureText(this.f35024pa);
            rectF2.left = ((getWidth() - measureText) / 2.0f) - this.f35017ia;
            rectF2.top = this.V;
            rectF2.right = ((getWidth() + measureText) / 2.0f) + this.f35017ia;
            float f10 = this.f35013ea;
            float f11 = this.V;
            rectF2.bottom = f10 - f11;
            float f12 = (f10 / 2.0f) - f11;
            canvas.drawRoundRect(rectF2, f12, f12, paint);
            return;
        }
        RectF rectF3 = this.Ta;
        if (rectF3 != null) {
            if (rectF == null) {
                rectF = rectF3;
            }
            float f13 = rectF.left;
            float f14 = this.V;
            float f15 = f14 / 2.0f;
            rectF2.left = f13 + f15;
            rectF2.top = rectF.top + f15;
            rectF2.right = rectF.right - f15;
            rectF2.bottom = rectF.bottom - f15;
            float f16 = (this.f35013ea - f14) / 2.0f;
            canvas.drawRoundRect(rectF2, f16, f16, paint);
        }
    }

    public void drawHotZone(@NonNull Canvas canvas, @ColorInt int i10) {
        if (this.Fa == null || this.mOptions.s() == null) {
            return;
        }
        float f10 = (this.mOptions.s().bottom - this.mOptions.s().top) / 2.0f;
        this.Fa.setColor(i10);
        canvas.drawRoundRect(this.mOptions.s(), f10, f10, this.Fa);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public TimeInterpolator getAccelerateInterpolator() {
        return super.getAccelerateInterpolator();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public TimeInterpolator getAlphaInterpolator() {
        return super.getAlphaInterpolator();
    }

    @ColorInt
    public int getBgFocusSelectedDotColor() {
        return this.S;
    }

    @ColorInt
    public int getBgFocusUnSelectedDotColor() {
        return this.R;
    }

    @ColorInt
    public int getCurrentBgColor() {
        return this.mOptions.v();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public TimeInterpolator getDecelerateInterpolator() {
        return super.getDecelerateInterpolator();
    }

    public int getDesiredHeight() {
        return this.f35013ea;
    }

    @ColorInt
    public int getDotColor() {
        return this.P;
    }

    @ColorInt
    public int getFocusBoxColor() {
        return this.U;
    }

    @ColorInt
    public int getFocusDotColor() {
        return this.Q;
    }

    @Nullable
    public RectF getHotZoneRectF() {
        return this.mOptions.s();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ float getMaxDiffFraction() {
        return super.getMaxDiffFraction();
    }

    @ColorInt
    public int getNumTextColor() {
        return this.f35014fa;
    }

    @ColorInt
    public int getPressedStateColor() {
        return this.W;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public TimeInterpolator getScaleInterpolator() {
        return super.getScaleInterpolator();
    }

    @ColorInt
    public int getStartBgColor() {
        return this.f35009aa;
    }

    public boolean isAnimationEnable() {
        return this.B;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ boolean isFocusAccelerateAnimationRunning() {
        return super.isFocusAccelerateAnimationRunning();
    }

    public boolean isGainFocused() {
        return this.D;
    }

    public boolean isGestureEnable() {
        if (this.A) {
            return false;
        }
        return this.C;
    }

    public boolean isRtl() {
        return this.I;
    }

    public boolean isShowAsDot() {
        return this.G;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ boolean isSpringAnimationRunning() {
        return super.isSpringAnimationRunning();
    }

    public void nextPage() {
        int i10 = this.f35022na;
        if (i10 == this.f35021ma - 1) {
            if (this.f35035za.isSupportLoop()) {
                b(0, false);
                b(this.f35022na, 0);
                return;
            }
            return;
        }
        b(i10, i10 + 1);
        if (this.G && this.B) {
            b(true);
        } else {
            this.f35035za.nextPage();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onAnimationUpdate(t tVar) {
        if (tVar == null) {
            return;
        }
        this.mOptions.b(tVar.s());
        this.mOptions.p(tVar.v());
        this.mOptions.a(tVar.d());
        this.mOptions.d(tVar.f());
        this.mOptions.a(tVar.l());
        invalidate();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f35023oa = true;
        if (this.A) {
            startAutoPlay(this.f35034z);
        }
        if (this.E) {
            this.f35032xa = hasFocus();
            boolean hasWindowFocus = hasWindowFocus();
            this.f35033ya = hasWindowFocus;
            setIndicatorFocusChanged(this.f35032xa && hasWindowFocus);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.G && !this.A && this.C) {
            if ((isFocusAccelerateAnimationRunning() && isSpringAnimationRunning()) || this.La != b.MOUSE_ON_DOT || this.mOptions.A() == -1) {
                return;
            }
            HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener = this.Ka;
            if (onMouseOperationListener != null) {
                onMouseOperationListener.onDotClick(this.f35022na, this.mOptions.A());
            }
            b(this.mOptions.A(), true);
            c(this.mOptions.A());
            this.mOptions.t(-1);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f35023oa = false;
        if (this.A) {
            B();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onDotCenterChanged(float[] fArr) {
        this.mOptions.a(fArr);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null || this.f35021ma <= 0) {
            return;
        }
        if (this.G) {
            a(canvas);
            b(canvas);
        } else {
            c(canvas);
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, @Nullable Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.E) {
            if (!z10 || this.La == b.COMMON) {
                if (a(z10, this.f35033ya)) {
                    setIndicatorFocusChanged(z10);
                }
                this.f35032xa = z10;
                invalidate();
            }
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onFocusDotChanged(boolean z10, float f10) {
        if (z10) {
            if (this.f35030va) {
                this.mOptions.f(f10);
            } else {
                this.mOptions.g(f10);
            }
        } else if (this.f35030va) {
            if (!isSpringAnimationRunning()) {
                this.mOptions.g(f10);
            }
        } else if (!isSpringAnimationRunning()) {
            this.mOptions.f(f10);
        }
        invalidate();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onFocusSingleScaled(RectF rectF) {
        if (rectF == null) {
            return;
        }
        this.mOptions.g(this.I ? rectF.right : rectF.left);
        this.mOptions.f(this.I ? rectF.left : rectF.right);
        this.mOptions.h(rectF.top);
        this.mOptions.k(rectF.bottom);
        invalidate();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (!a(motionEvent.getAction(), x10, y10)) {
            return super.onHoverEvent(motionEvent);
        }
        if (this.La != b.COMMON) {
            d(x10, y10);
            return super.onHoverEvent(motionEvent);
        }
        if (this.f35028ta) {
            y();
            doHotZoneVisibleAnimation(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
            Resources resources = getContext().getResources();
            int i10 = R$plurals.page_progress;
            int i11 = this.f35022na + 1;
            String quantityString = resources.getQuantityString(i10, i11, Integer.valueOf(i11));
            Resources resources2 = getContext().getResources();
            int i12 = R$plurals.total_page;
            int i13 = this.f35021ma;
            String quantityString2 = resources2.getQuantityString(i12, i13, Integer.valueOf(i13));
            accessibilityNodeInfo.setContentDescription(String.format(Locale.ROOT, getContext().getString(R$string.page), quantityString, quantityString2));
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (keyEvent == null || !this.C) {
            return false;
        }
        if (this.f35021ma > 1 && this.D && (i10 == 21 || i10 == 22)) {
            if ((i10 == 21 && this.I) || (i10 == 22 && !this.I)) {
                nextPage();
            } else {
                prePage();
            }
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (z10 || this.H) {
            c();
            this.H = false;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        Pair<Integer, Integer> a10 = u.a(i10, i11, this.G ? u.a(this.f35021ma, getScaledWidth()) : View.MeasureSpec.getSize(i10), getDesiredHeight());
        setMeasuredDimension(((Integer) a10.first).intValue(), ((Integer) a10.second).intValue());
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i10) {
        HwViewPager.OnPageChangeListener onPageChangeListener = this.Aa;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i10);
        }
        a(i10);
        this.F = i10;
        if (i10 == 1 && this.La == b.COMMON) {
            stopSpringAnimation();
            HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator;
            if (hwDotsPageIndicatorAnimation != null && (hwDotsPageIndicatorAnimation.k() || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.i())) {
                ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.s();
                ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.q();
                this.Ma = d.DEFAULT;
            }
        }
        if (this.F != 0) {
            d();
        }
        if (this.F == 0) {
            HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation2 = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator;
            boolean z10 = hwDotsPageIndicatorAnimation2 != null && (hwDotsPageIndicatorAnimation2.p() || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.n());
            if (!isFocusAccelerateAnimationRunning() && !z10) {
                boolean a10 = true ^ this.mOptions.a(x(), this.f35022na, this.mOptions.m(), this.mOptions.k());
                if (this.G && a10) {
                    stopSpringAnimation();
                    t tVar = this.mOptions;
                    tVar.g(tVar.d(x(), this.f35022na));
                    t tVar2 = this.mOptions;
                    tVar2.f(tVar2.c(x(), this.f35022na));
                    invalidate();
                }
            }
            this.Ma = d.DEFAULT;
            this.mOptions.q(this.f35022na);
            if (!this.G || z10) {
                return;
            }
            a(x());
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageScrolled(int i10, float f10, int i11) {
        HwViewPager.OnPageChangeListener onPageChangeListener = this.Aa;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i10, f10, i11);
        }
        if (this.F == 1) {
            this.f35029ua = i10 == this.f35022na;
        }
        if (f(i10)) {
            b(i10, f10);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
    public void onPageSelected(int i10) {
        HwViewPager.OnPageChangeListener onPageChangeListener = this.Aa;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i10);
        }
        if (!this.f35023oa) {
            A();
            return;
        }
        if (this.G && this.B) {
            u.a(this.Ma == d.DEFAULT);
            if (u.e()) {
                stopSpringAnimation();
                setSelectedPage(i10);
                q();
                invalidate();
                return;
            }
            if ((this.A ? d(i10) : e(i10)) && !this.D) {
                HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator;
                if (hwDotsPageIndicatorAnimation != null) {
                    hwDotsPageIndicatorAnimation.s();
                    ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.q();
                    stopSpringAnimation();
                }
                b(i10, false);
            }
            setSelectedPage(i10);
            return;
        }
        setSelectedPage(i10);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onSingleScaled(boolean z10, int i10, float f10) {
        if (z10) {
            this.mOptions.l(f10);
        }
        this.mOptions.a(i10, f10);
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        setMeasuredDimension(i10, i11);
        c();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationUpdateListener
    public void onSpringAnimationUpdate(boolean z10, float f10) {
        if (this.F == 1 || u.e()) {
            return;
        }
        if (z10) {
            this.mOptions.g(f10);
        } else {
            this.mOptions.f(f10);
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (this.G && this.f35021ma != 0 && !this.A && this.C) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (this.La == b.MOUSE_ON_DOT) {
                y();
                return super.onTouchEvent(motionEvent);
            }
            if (action == 0) {
                h();
                if (this.f35027sa == 0) {
                    this.f35027sa = SystemClock.uptimeMillis();
                }
                this.f35026ra = x10;
            } else if (action == 1) {
                if (SystemClock.uptimeMillis() - this.f35027sa < 300) {
                    c(x10, y10);
                }
                j();
            } else if (action == 2) {
                c(x10);
                this.f35026ra = x10;
            } else if (action == 3) {
                j();
            } else {
                return super.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (this.E) {
            if (a(this.f35032xa, z10)) {
                setIndicatorFocusChanged(z10);
            }
            this.f35033ya = z10;
            invalidate();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performDotCenterXsLayoutAnimation(@NonNull float[] fArr, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performDotCenterXsLayoutAnimation(fArr, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performFocusAccelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performFocusAccelerateAnimation(f10, f11, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performFocusSingleZoomInAnimation(@NonNull RectF rectF, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performFocusSingleZoomInAnimation(rectF, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performFocusSingleZoomOutAnimation(@NonNull RectF rectF, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performFocusSingleZoomOutAnimation(rectF, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performHotZoneInVisibleAnimation(boolean z10, @NonNull t tVar, @NonNull View view, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performHotZoneInVisibleAnimation(z10, tVar, view, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performHotZoneVisibleAnimation(@NonNull t tVar, boolean z10, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        super.performHotZoneVisibleAnimation(tVar, z10, animationUpdateListener, animationStateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performSingleDotZoomInAnimation(int i10, float f10, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performSingleDotZoomInAnimation(i10, f10, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performSingleDotZoomOutAnimation(int i10, @NonNull View view, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performSingleDotZoomOutAnimation(i10, view, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performSpringAnimation(@NonNull d.a aVar, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        super.performSpringAnimation(aVar, animationUpdateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performTargetAccelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        super.performTargetAccelerateAnimation(f10, f11, animationUpdateListener, animationStateListener);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void performTargetDecelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        super.performTargetDecelerateAnimation(f10, f11, animationUpdateListener, animationStateListener);
    }

    public void prePage() {
        int i10 = this.f35022na;
        if (i10 == 0) {
            if (this.f35035za.isSupportLoop()) {
                b(this.f35021ma - 1, false);
                b(this.f35022na, this.f35021ma - 1);
                return;
            }
            return;
        }
        b(i10, i10 - 1);
        if (this.G && this.B) {
            b(false);
        } else {
            this.f35035za.prePage();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public void setAlphaInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        super.setAlphaInterpolator(timeInterpolator);
    }

    public void setAnimationEnable(boolean z10) {
        this.B = z10;
        if (z10 && ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator == null) {
            ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator = new HwDotsPageIndicatorAnimation();
        }
    }

    public void setDotColor(@ColorInt int i10) {
        if (this.P != i10) {
            this.P = i10;
            Paint paint = this.Ca;
            if (paint == null || !this.G) {
                return;
            }
            paint.setColor(i10);
            invalidate();
        }
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public void setDragAccelerateInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        super.setDragAccelerateInterpolator(timeInterpolator);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public void setDragDecelerateInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        super.setDragDecelerateInterpolator(timeInterpolator);
    }

    public void setFocusBoxColor(@ColorInt int i10) {
        this.U = i10;
    }

    public void setFocusDotColor(@ColorInt int i10) {
        if (this.Q != i10) {
            this.Q = i10;
            Paint paint = this.Da;
            if (paint == null || !this.G) {
                return;
            }
            paint.setColor(i10);
            invalidate();
        }
    }

    public void setGestureEnable(boolean z10) {
        if (this.A) {
            return;
        }
        this.C = z10;
    }

    public void setIndicatorFocusChanged(boolean z10) {
        this.D = z10;
    }

    public void setNumTextColor(@ColorInt int i10) {
        if (this.f35014fa != i10) {
            this.f35014fa = i10;
            Paint paint = this.Ea;
            if (paint == null || this.G) {
                return;
            }
            paint.setColor(i10);
            invalidate();
        }
    }

    public void setOnIndicatorClickListener(@Nullable HwDotsPageIndicatorInteractor.OnClickListener onClickListener) {
        this.Ia = onClickListener;
    }

    public void setOnIndicatorGestureListener(@Nullable HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener) {
        this.Ja = onGestureListener;
    }

    public void setOnIndicatorMouseOperatorListener(@Nullable HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener) {
        this.Ka = onMouseOperationListener;
    }

    public void setOnPageChangeListener(HwViewPager.OnPageChangeListener onPageChangeListener) {
        this.Aa = onPageChangeListener;
    }

    public void setPressedStateColor(@ColorInt int i10) {
        this.W = i10;
        if (x() || !this.G) {
            return;
        }
        this.mOptions.p(this.W);
        invalidate();
    }

    public void setRtlEnable(boolean z10) {
        this.f35025qa = z10;
        invalidate();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public void setScaleInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        super.setScaleInterpolator(timeInterpolator);
    }

    public void setSelectedPage(int i10) {
        if (i10 == this.f35022na || this.f35021ma == 0) {
            return;
        }
        A();
        if (w()) {
            if (x()) {
                q();
            } else {
                this.mOptions.a(this.mOptions.e(false, this.f35022na));
                t tVar = this.mOptions;
                tVar.g(tVar.i(this.f35022na));
                t tVar2 = this.mOptions;
                tVar2.f(tVar2.h(this.f35022na));
            }
        }
        invalidate();
    }

    public void setShowAsDot(boolean z10) {
        if (this.G == z10) {
            return;
        }
        this.G = z10;
        this.H = true;
        requestLayout();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public void setSpringAnimationDamping(@FloatRange(from = 0.0d) float f10) {
        super.setSpringAnimationDamping(f10);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public void setSpringAnimationStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        super.setSpringAnimationStiffness(f10);
    }

    public void setViewPager(HwViewPager hwViewPager) {
        if (hwViewPager == null || hwViewPager.getAdapter() == null) {
            return;
        }
        this.f35035za = hwViewPager;
        setPageCount(hwViewPager.getAdapter().getCount());
        hwViewPager.getAdapter().registerDataSetObserver(new f(this));
        hwViewPager.addOnPageChangeListener(this);
        A();
    }

    public void startAutoPlay(int i10) {
        this.A = true;
        this.C = false;
        this.f35034z = i10;
        if (this.Ba == null) {
            m();
        }
        this.Ba.removeCallbacks(this.Ua);
        this.Ba.postDelayed(this.Ua, i10);
    }

    public void stopAutoPlay() {
        this.A = false;
        B();
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.d
    public /* bridge */ /* synthetic */ void stopSpringAnimation() {
        super.stopSpringAnimation();
    }

    public HwDotsPageIndicator(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.hwDotsPageIndicatorStyle);
    }

    private void b(Context context, AttributeSet attributeSet, int i10) {
        a(context, attributeSet, i10);
        if (this.A) {
            this.C = false;
        }
        if (!this.G) {
            this.C = false;
            this.B = false;
        }
        if (this.B) {
            ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator = new HwDotsPageIndicatorAnimation();
        }
        if (isInEditMode()) {
            this.f35021ma = 3;
            this.mOptions.r(3);
        }
        l();
        p();
        if (this.A) {
            m();
        }
        setOnClickListener(this);
    }

    private void c(int i10, float f10, int i11) {
        if (this.f35029ua) {
            float d10 = this.mOptions.d(x(), i10);
            float c4 = this.mOptions.c(x(), i10);
            this.mOptions.g(this.I ? d10 - (e(f10) * i11) : d10 + (e(f10) * i11));
            this.mOptions.f(this.I ? c4 - (d(f10) * i11) : c4 + (d(f10) * i11));
            return;
        }
        int i12 = i10 + 1;
        float d11 = this.mOptions.d(x(), i12);
        float c10 = this.mOptions.c(x(), i12);
        this.mOptions.g(this.I ? (d(1.0f - f10) * i11) + d11 : d11 - (d(1.0f - f10) * i11));
        float f11 = 1.0f - f10;
        this.mOptions.f(this.I ? (e(f11) * i11) + c10 : c10 - (e(f11) * i11));
    }

    private void d(int i10, float f10, int i11) {
        boolean z10 = this.f35022na != i10;
        if (!this.f35031wa) {
            if (z10) {
                e(i10, f10, i11);
                return;
            } else {
                f(i10, f10, i11);
                return;
            }
        }
        if (u.e()) {
            return;
        }
        if (z10) {
            a(i10, f10, i11);
        } else {
            b(i10, f10, i11);
        }
    }

    private void e(int i10, float f10, int i11) {
        if (this.f35029ua) {
            a(i10, f10, i11);
            return;
        }
        float c4 = this.mOptions.c(x(), this.f35022na);
        float f11 = 1.0f - f10;
        this.mOptions.f(this.I ? (e(f11) * i11) + c4 : c4 - (e(f11) * i11));
        float m10 = this.mOptions.m();
        float d10 = this.mOptions.d(x(), i10 + 1);
        if (isSpringAnimationRunning()) {
            return;
        }
        this.f35030va = true;
        a(true, m10, d10, this.mSpringStiffness, this.mSpringDamping);
    }

    private boolean f(int i10) {
        if (!this.G || !this.B || this.Ma == d.TARGET) {
            return false;
        }
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator;
        return (hwDotsPageIndicatorAnimation == null || !(hwDotsPageIndicatorAnimation.p() || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.n())) && i10 + 1 <= this.f35021ma - 1;
    }

    private void g() {
        if (!this.C || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator == null || !this.mOptions.C() || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.p() || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.m()) {
            return;
        }
        ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.t();
        float j10 = this.L - (this.mOptions.j() - this.mOptions.n());
        if (!this.B) {
            t tVar = this.mOptions;
            float f10 = j10 / 2.0f;
            tVar.h(tVar.n() - f10);
            t tVar2 = this.mOptions;
            tVar2.k(tVar2.j() + f10);
            float m10 = this.mOptions.m();
            float k10 = this.mOptions.k();
            this.mOptions.g(this.I ? m10 + j10 : m10 - j10);
            this.mOptions.f(this.I ? k10 - j10 : k10 + j10);
            this.La = b.VISIBLE;
            this.mOptions.b(false);
            invalidate();
            return;
        }
        float f11 = j10 / 2.0f;
        performFocusSingleZoomOutAnimation(new RectF(this.mOptions.m() - j10, this.mOptions.n() - f11, this.mOptions.k() + j10, this.mOptions.j() + f11), this);
        this.La = b.VISIBLE;
    }

    private void h() {
        HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener;
        if (!this.C || (onGestureListener = this.Ja) == null || this.D) {
            return;
        }
        onGestureListener.onLongPress(0);
        if (this.Na == null) {
            a aVar = new a(this, null);
            this.Na = aVar;
            postDelayed(aVar, 300L);
        }
    }

    private void i() {
        if (!this.C || this.Ja == null) {
            return;
        }
        a aVar = this.Na;
        if (aVar != null) {
            removeCallbacks(aVar);
            this.Na = null;
        }
        if (x()) {
            return;
        }
        doHotZoneInVisibleAnimation(true);
        if (this.Ma == d.SLIDE) {
            this.Ma = d.DEFAULT;
        }
        this.Ha.a(0.0f);
    }

    private void j() {
        this.f35027sa = 0L;
        this.Ha.a(true);
        i();
    }

    private void k() {
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        float desiredWidth = getDesiredWidth();
        float f10 = ((width - desiredWidth) / 2.0f) + paddingLeft + this.f35015ga;
        float f11 = this.f35013ea / 2.0f;
        this.f35011ca = f11;
        this.mOptions.c(f11);
        this.mOptions.a(f10);
        float f12 = f10 - this.f35015ga;
        float f13 = this.f35011ca;
        float f14 = this.f35012da / 2.0f;
        float f15 = desiredWidth + f12;
        this.Sa = new RectF(f12, f13 - f14, f15, f13 + f14);
        float f16 = this.f35016ha - this.f35015ga;
        float f17 = this.f35011ca;
        float f18 = this.f35013ea / 2.0f;
        this.Ta = new RectF(f12 - f16, f17 - f18, f15 + f16, f17 + f18);
    }

    private void l() {
        Resources resources = getResources();
        this.L = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_unselected_zoom_in_diameter);
        this.M = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_unselected_zoom_in_second_diameter);
        this.J = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_unselected_diameter);
        this.N = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_default_gap);
        this.O = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_zoom_in_gap);
        this.T = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_selected_width);
        this.f35013ea = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_total_height);
        this.f35010ba = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_selected_zoom_in_length);
        this.V = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_focus_box_width);
        this.f35012da = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_default_zone_height);
        this.f35015ga = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_margin_start_end);
        this.f35016ha = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_hot_zone_margin_start_end);
        float dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.hwdotspageindicator_touch_move_response_length);
        float dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.hwdotspageindicator_touch_move_valid_length);
        float dimensionPixelOffset2 = resources.getDimensionPixelOffset(R$dimen.hwdotspageindicator_touch_bottom_max_scale_distance);
        this.Ha.d(dimensionPixelSize);
        this.Ha.e(dimensionPixelOffset);
        this.Ha.c(dimensionPixelOffset2);
        this.mOptions.d(this.J / 2.0f);
        this.mOptions.m(this.N);
        this.mOptions.s(this.O);
        this.mOptions.i(this.T);
        this.mOptions.j(this.f35010ba);
        this.mOptions.e(this.L);
        this.K = this.J / 2.0f;
        Paint paint = new Paint(1);
        this.Ca = paint;
        paint.setColor(this.P);
        Paint paint2 = new Paint(1);
        this.Da = paint2;
        paint2.setColor(this.Q);
        Paint paint3 = new Paint(1);
        this.Fa = paint3;
        paint3.setColor(this.W);
    }

    public HwDotsPageIndicator(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f35034z = 5000;
        this.F = 0;
        this.I = false;
        this.f35025qa = true;
        this.f35027sa = 0L;
        this.f35028ta = false;
        this.f35029ua = false;
        this.f35030va = true;
        this.f35031wa = false;
        this.Ha = new u.a();
        this.La = b.COMMON;
        this.Ma = d.DEFAULT;
        this.Ua = new e(this);
        b(super.getContext(), attributeSet, i10);
        setOnClickListener(this);
        setFocusable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(false);
        }
    }

    private void a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HwDotsPageIndicator, i10, 0);
        this.A = obtainStyledAttributes.getBoolean(R$styleable.HwDotsPageIndicator_hwIsAutoPlay, false);
        this.P = obtainStyledAttributes.getColor(R$styleable.HwDotsPageIndicator_hwUnselectedDotColor, ContextCompat.getColor(getContext(), R$color.emui_control_normal));
        int i11 = R$styleable.HwDotsPageIndicator_hwSelectedDotColor;
        Context context2 = getContext();
        int i12 = R$color.emui_control_focused;
        this.Q = obtainStyledAttributes.getColor(i11, ContextCompat.getColor(context2, i12));
        int i13 = R$styleable.HwDotsPageIndicator_hwBgEndColor;
        Context context3 = getContext();
        int i14 = R$color.emui_clickeffic_default_color;
        this.W = obtainStyledAttributes.getColor(i13, ContextCompat.getColor(context3, i14));
        int color = obtainStyledAttributes.getColor(R$styleable.HwDotsPageIndicator_hwBgStartColor, ContextCompat.getColor(getContext(), i14));
        this.f35009aa = color;
        this.mOptions.o(color);
        this.mOptions.n(this.W);
        this.U = obtainStyledAttributes.getColor(R$styleable.HwDotsPageIndicator_hwFocusBoxColor, ContextCompat.getColor(getContext(), R$color.emui_control_focused_outline));
        this.G = obtainStyledAttributes.getBoolean(R$styleable.HwDotsPageIndicator_hwIsShowAsDot, true);
        this.B = obtainStyledAttributes.getBoolean(R$styleable.HwDotsPageIndicator_hwHasAnimation, true);
        this.C = obtainStyledAttributes.getBoolean(R$styleable.HwDotsPageIndicator_hwIsOperable, true);
        this.f35014fa = obtainStyledAttributes.getColor(R$styleable.HwDotsPageIndicator_hwNumTextColor, ContextCompat.getColor(getContext(), R$color.emui_selector_text_secondary));
        this.R = obtainStyledAttributes.getColor(R$styleable.HwDotsPageIndicator_hwBgFocusUnSelectedDotColor, ContextCompat.getColor(getContext(), R$color.hwdotspageindicator_unselected_focus_color));
        this.S = obtainStyledAttributes.getColor(R$styleable.HwDotsPageIndicator_hwBgFocusSelectedDotColor, ContextCompat.getColor(getContext(), i12));
        this.E = obtainStyledAttributes.getBoolean(R$styleable.HwDotsPageIndicator_hwBgFocusEnable, false);
        obtainStyledAttributes.recycle();
    }

    private void f(int i10, float f10, int i11) {
        if (!this.f35029ua) {
            b(i10, f10, i11);
            return;
        }
        float d10 = this.mOptions.d(x(), i10);
        this.mOptions.g(this.I ? d10 - (e(f10) * i11) : d10 + (e(f10) * i11));
        float k10 = this.mOptions.k();
        float c4 = this.mOptions.c(x(), i10);
        if (isSpringAnimationRunning()) {
            return;
        }
        this.f35030va = false;
        a(false, k10, c4, this.mSpringStiffness, this.mSpringDamping);
    }

    public void startAutoPlay() {
        startAutoPlay(5000);
    }

    private float d(float f10) {
        return getAccelerateInterpolator().getInterpolation(f10);
    }

    private boolean d(int i10) {
        return (i10 == 0 && this.f35022na == this.f35021ma - 1 && (this.f35031wa || this.f35029ua)) || (i10 == this.f35021ma - 1 && this.f35022na == 0 && (this.f35031wa || !this.f35029ua));
    }

    private void d() {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator;
        if (hwDotsPageIndicatorAnimation != null && hwDotsPageIndicatorAnimation.l()) {
            ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.t();
            z();
        }
        if (this.mOptions.C()) {
            z();
        }
    }

    private float e(float f10) {
        return getDecelerateInterpolator().getInterpolation(f10);
    }

    private boolean e(int i10) {
        HwViewPager hwViewPager = this.f35035za;
        return x() && (hwViewPager != null && hwViewPager.isSupportLoop()) && d(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f35028ta) {
            return;
        }
        doHotZoneInVisibleAnimation(false);
    }

    private void f() {
        if (!this.C || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator == null || this.F != 0 || this.mOptions.C() || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.p() || ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.l()) {
            return;
        }
        ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.u();
        float j10 = this.M - (this.mOptions.j() - this.mOptions.n());
        if (!this.B) {
            t tVar = this.mOptions;
            float f10 = j10 / 2.0f;
            tVar.h(tVar.n() - f10);
            t tVar2 = this.mOptions;
            tVar2.k(tVar2.j() + f10);
            float k10 = this.mOptions.k();
            float m10 = this.mOptions.m();
            this.mOptions.g(this.I ? m10 + j10 : m10 - j10);
            this.mOptions.f(this.I ? k10 - j10 : k10 + j10);
            this.mOptions.b(true);
            invalidate();
            return;
        }
        float f11 = j10 / 2.0f;
        performFocusSingleZoomInAnimation(new RectF(this.mOptions.m() - j10, this.mOptions.n() - f11, this.mOptions.k() + j10, this.mOptions.j() + f11), this);
        this.La = b.MOUSE_ON_DOT;
    }

    private void d(float f10, float f11) {
        if (!this.f35028ta) {
            doHotZoneInVisibleAnimation(false);
            return;
        }
        if (u.a(this.mOptions, this.I, f10, f11)) {
            f();
            c(this.mOptions.A());
            this.mOptions.t(-1);
            return;
        }
        g();
        int a10 = u.a(this.mOptions, this.M / 2.0f, (this.L + this.O) / 2.0f, f10, f11);
        if (a10 == this.f35022na) {
            return;
        }
        if (a10 == -1) {
            if (this.mOptions.A() != -1) {
                c(this.mOptions.A());
                this.mOptions.t(-1);
                return;
            }
            return;
        }
        if (a10 == this.mOptions.A()) {
            return;
        }
        c(this.mOptions.A());
        this.mOptions.t(-1);
        if (b(a10)) {
            this.mOptions.t(a10);
        }
    }

    private void b(int i10, float f10) {
        if (this.F == 0 && Float.compare(f10, 0.0f) == 0) {
            this.f35022na = i10;
            onPageScrollStateChanged(this.F);
            return;
        }
        int distanceProper = getDistanceProper();
        if (this.F == 2) {
            d(i10, f10, distanceProper);
        } else {
            c(i10, f10, distanceProper);
        }
        a(i10, f10);
    }

    private void c() {
        if (this.G) {
            a();
        } else {
            b();
        }
    }

    private void c(float f10, float f11) {
        if (this.Ia == null || !isInTouchMode()) {
            return;
        }
        RectF rectF = this.Qa;
        if (rectF != null && rectF.contains(f10, f11)) {
            nextPage();
            return;
        }
        RectF rectF2 = this.Pa;
        if (rectF2 == null || !rectF2.contains(f10, f11)) {
            return;
        }
        prePage();
    }

    private void b(int i10, float f10, int i11) {
        float d10;
        int i12 = i10 + 1;
        float d11 = this.mOptions.d(x(), i12);
        t tVar = this.mOptions;
        if (this.I) {
            d10 = (d(1.0f - f10) * i11) + d11;
        } else {
            d10 = d11 - (d(1.0f - f10) * i11);
        }
        tVar.g(d10);
        float f11 = 1.0f - f10;
        if (f11 < getMaxDiffFraction()) {
            float c4 = this.mOptions.c(x(), i12);
            this.mOptions.f(this.I ? (e(f11) * i11) + c4 : c4 - (e(f11) * i11));
            return;
        }
        float k10 = this.mOptions.k();
        float c10 = this.mOptions.c(x(), i10);
        if (isSpringAnimationRunning()) {
            return;
        }
        this.f35030va = false;
        a(false, k10, c10, this.mSpringStiffness, this.mSpringDamping);
    }

    private void c(int i10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        if (!this.C || (hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator) == null || i10 == -1 || hwDotsPageIndicatorAnimation.b(i10)) {
            return;
        }
        if (!this.B) {
            this.mOptions.l(i10);
            invalidate();
        } else {
            performSingleDotZoomOutAnimation(i10, this, this);
            this.La = b.VISIBLE;
        }
    }

    private void c(float f10) {
        int i10;
        if (!this.C || this.Ja == null || this.Ha.e() <= 0.0f) {
            return;
        }
        if (a(f10)) {
            f(f10);
            return;
        }
        if (!b(f10)) {
            this.Ha.a(true);
            return;
        }
        if (this.Ha.f()) {
            this.Ha.b(this.f35026ra);
            this.Ha.a(false);
        }
        float b4 = f10 - this.Ha.b();
        float abs = Math.abs(b4) / this.Ha.e();
        if ((b4 > 0.0f && !this.I) || (b4 < 0.0f && this.I)) {
            i10 = this.f35022na + 1;
        } else {
            i10 = this.f35022na - 1;
        }
        this.Ma = d.SLIDE;
        int i11 = this.f35022na;
        if (this.B) {
            b(i11, i10, abs);
        } else if (Float.compare(abs, 1.0f) >= 0) {
            this.f35022na = i10;
            this.mOptions = t();
            invalidate();
            settleToTarget(i10);
        }
    }

    private void f(float f10) {
        stopSpringAnimation();
        if (this.f35021ma - 1 <= 0 || this.Ha.d() <= 0.0f || this.Ha.c() <= 0.0f) {
            return;
        }
        float a10 = f10 - this.Ha.a();
        boolean z10 = a10 > 0.0f && !this.I;
        boolean z11 = a10 < 0.0f && this.I;
        float min = Math.min(Math.abs(a10), this.Ha.c()) / this.Ha.c();
        HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener = this.Ja;
        if (onGestureListener != null) {
            onGestureListener.onOverDrag(min);
        }
        Pair<Float, Float> a11 = u.a(getScaleInterpolator(), min, this.f35021ma, getScaledWidth(), this.f35013ea);
        float floatValue = ((Float) a11.first).floatValue();
        float floatValue2 = ((Float) a11.second).floatValue();
        RectF rectF = this.Ra;
        float f11 = (this.f35013ea - floatValue2) / 2.0f;
        a(z11, z10, floatValue, rectF.top + f11, rectF.bottom - f11);
    }

    private void a(int i10, float f10, int i11) {
        float c4 = this.mOptions.c(x(), i10);
        this.mOptions.f(this.I ? c4 - (d(f10) * i11) : c4 + (d(f10) * i11));
        if (!u.f() && f10 >= getMaxDiffFraction()) {
            float m10 = this.mOptions.m();
            float d10 = this.mOptions.d(x(), i10 + 1);
            if (isSpringAnimationRunning()) {
                return;
            }
            this.f35030va = true;
            a(true, m10, d10, this.mSpringStiffness, this.mSpringDamping);
            return;
        }
        float d11 = this.mOptions.d(x(), i10);
        this.mOptions.g(this.I ? d11 - (e(f10) * i11) : d11 + (e(f10) * i11));
    }

    private void b() {
        this.f35018ja = (((getWidth() - getPaddingRight()) - r0) / 2.0f) + getPaddingLeft();
        float paddingTop = getPaddingTop();
        float f10 = this.f35013ea;
        Paint.FontMetrics fontMetrics = this.Ga;
        this.f35019ka = (((f10 - fontMetrics.descent) - fontMetrics.ascent) / 2.0f) + paddingTop;
        A();
    }

    private boolean b(int i10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        boolean z10 = false;
        if (this.C && (hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator) != null && !hwDotsPageIndicatorAnimation.p() && !((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.n() && !((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator.a(i10)) {
            if (this.mOptions.A() == i10) {
                return false;
            }
            z10 = true;
            if (!this.B) {
                this.mOptions.a(i10, this.M / 2.0f);
                this.La = b.MOUSE_ON_DOT;
                invalidate();
                return true;
            }
            performSingleDotZoomInAnimation(i10, this.M / 2.0f, this);
            this.La = b.MOUSE_ON_DOT;
        }
        return z10;
    }

    private void a(int i10, float f10) {
        float a10 = this.mOptions.a(x());
        float b4 = this.mOptions.b(x(), i10);
        if (!this.I) {
            this.mOptions.b(i10, b4 - (a10 * f10));
            int i11 = i10 + 1;
            if (i11 < this.f35021ma) {
                t tVar = this.mOptions;
                tVar.b(i11, ((1.0f - f10) * a10) + tVar.b(x(), i11));
            }
        } else {
            this.mOptions.b(i10, (a10 * f10) + b4);
            int i12 = i10 + 1;
            if (i12 < this.f35021ma) {
                t tVar2 = this.mOptions;
                tVar2.b(i12, tVar2.b(x(), i12) - ((1.0f - f10) * a10));
            }
        }
        invalidate();
    }

    private void c(@NonNull Canvas canvas) {
        Paint paint;
        String str = this.f35024pa;
        if (str == null || (paint = this.Ea) == null) {
            return;
        }
        canvas.drawText(str, this.f35018ja, this.f35019ka, paint);
    }

    private boolean b(float f10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        if (this.f35021ma <= 1 || !this.C || x() || ((hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator) != null && hwDotsPageIndicatorAnimation.p())) {
            return false;
        }
        u.a aVar = this.Ha;
        boolean z10 = this.I;
        int i10 = this.f35022na;
        return u.b(aVar, f10, z10, i10 > 0, i10 < this.f35021ma - 1);
    }

    private void b(int i10, int i11, float f10) {
        if (Float.compare(f10, 1.0f) >= 0) {
            a(i10, i11);
            return;
        }
        a(i10, i11, f10);
        a(i10, i11 > i10);
        this.F = 1;
        invalidate();
    }

    private void a(int i10) {
        if (this.Ma == d.DEFAULT && this.F != 1 && i10 == 2) {
            this.f35031wa = true;
        } else {
            this.f35031wa = false;
        }
    }

    private void b(@NonNull Canvas canvas) {
        float j10 = (this.mOptions.j() - this.mOptions.n()) / 2.0f;
        canvas.drawRoundRect(this.mOptions.l(), j10, j10, this.Da);
        r();
        o();
    }

    private void a(boolean z10) {
        t tVar = this.mOptions;
        if (tVar.a(z10, this.f35022na, tVar.d())) {
            return;
        }
        t tVar2 = this.mOptions;
        tVar2.a(tVar2.a(z10, this.f35022na));
        invalidate();
    }

    private void a() {
        HwViewPager hwViewPager = this.f35035za;
        this.f35022na = hwViewPager != null ? hwViewPager.getCurrentItem() : 0;
        if (this.f35021ma < 1) {
            return;
        }
        k();
        s();
        q();
        A();
    }

    private void b(int i10, boolean z10) {
        HwViewPager hwViewPager = this.f35035za;
        if (hwViewPager == null || hwViewPager.getAdapter() == null || this.f35035za.getAdapter().getCount() < 2 || i10 < 0 || i10 >= this.f35021ma || i10 == this.f35022na || isFocusAccelerateAnimationRunning()) {
            return;
        }
        this.Ma = d.TARGET;
        this.mOptions.q(this.f35022na);
        float[] e2 = this.mOptions.e(x(), i10);
        float d10 = this.mOptions.d(x(), i10);
        float c4 = this.mOptions.c(x(), i10);
        if (!this.B) {
            this.mOptions.g(d10);
            this.mOptions.f(c4);
            a(e2);
            this.f35035za.setCurrentItem(i10, false);
            HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener = this.Ka;
            if (onMouseOperationListener != null) {
                onMouseOperationListener.onFocusAnimationProgress(1.0f);
                return;
            }
            return;
        }
        stopSpringAnimation();
        t b4 = this.mOptions.b();
        b4.q(i10);
        b4.g(d10);
        b4.f(c4);
        boolean z11 = b4.w() > this.mOptions.w();
        float k10 = z11 ? this.mOptions.k() : this.mOptions.m();
        float k11 = z11 ? b4.k() : b4.m();
        a(i10, z11, z11 ? this.mOptions.m() : this.mOptions.k(), z11 ? b4.m() : b4.k(), z10);
        b(k10, k11);
        this.f35030va = b4.w() > this.mOptions.w();
        a(e2);
        this.f35035za.setCurrentItem(i10);
    }

    private boolean a(boolean z10, boolean z11) {
        boolean z12 = this.f35032xa && this.f35033ya;
        boolean z13 = z10 && z11;
        if (!z12 || z13) {
            return !z12 && z13;
        }
        return true;
    }

    private boolean a(int i10, float f10, float f11) {
        if (this.A || !this.C || this.Ka == null || this.D || this.mOptions.s() == null || !this.G || this.f35021ma == 0) {
            return false;
        }
        boolean isFocusAccelerateAnimationRunning = isFocusAccelerateAnimationRunning();
        if (i10 == 10 && !isFocusAccelerateAnimationRunning) {
            if (this.Oa == null) {
                this.Oa = new c(this, null);
            }
            postDelayed(this.Oa, 100L);
        }
        this.f35028ta = this.mOptions.s().contains(f10, f11);
        return !isFocusAccelerateAnimationRunning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10, float f10, float f11, float f12, float f13) {
        performSpringAnimation(new d.a(z10, f10, f11, f12, f13), this);
    }

    private void a(float[] fArr) {
        if (!this.B) {
            this.mOptions.a(fArr);
            invalidate();
        } else {
            performDotCenterXsLayoutAnimation(fArr, this);
        }
    }

    private void a(float f10, float f11) {
        performFocusAccelerateAnimation(f10, f11, this);
    }

    private boolean a(float f10) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation;
        if (this.f35021ma <= 1 || !this.C || !this.B || x() || ((hwDotsPageIndicatorAnimation = ((com.huawei.uikit.hwdotspageindicator.widget.d) this).mAnimator) != null && (hwDotsPageIndicatorAnimation.p() || isFocusAccelerateAnimationRunning()))) {
            return false;
        }
        u.a aVar = this.Ha;
        boolean z10 = this.I;
        int i10 = this.f35022na;
        return u.a(aVar, f10, z10, i10 == 0, i10 == this.f35021ma - 1);
    }

    private void a(int i10, boolean z10) {
        this.mOptions.b(i10, z10 ? this.mOptions.c(i10) : this.mOptions.b(i10));
    }

    private void a(int i10, int i11, float f10) {
        if (i10 == i11 || i11 > this.f35021ma - 1 || i11 < 0) {
            return;
        }
        boolean z10 = i11 > i10;
        a(f10, 1, i10);
        float interpolation = getAccelerateInterpolator().getInterpolation(f10);
        float interpolation2 = getDecelerateInterpolator().getInterpolation(f10);
        stopSpringAnimation();
        float c4 = this.mOptions.c(x(), i10);
        float c10 = this.mOptions.c(x(), i11);
        float d10 = this.mOptions.d(x(), i10);
        float d11 = ((this.mOptions.d(x(), i11) - d10) * (z10 ? interpolation2 : interpolation)) + d10;
        float f11 = c10 - c4;
        if (!z10) {
            interpolation = interpolation2;
        }
        this.mOptions.g(d11);
        this.mOptions.f((f11 * interpolation) + c4);
    }

    private void b(float f10, float f11) {
        performTargetAccelerateAnimation(f10, f11, this, new j(this));
    }

    private void b(int i10, int i11) {
        HwDotsPageIndicatorInteractor.OnClickListener onClickListener = this.Ia;
        if (onClickListener != null) {
            onClickListener.onClick(i10, i11);
        }
    }

    private void b(boolean z10) {
        if (isFocusAccelerateAnimationRunning()) {
            return;
        }
        stopSpringAnimation();
        this.Ma = d.TARGET;
        int i10 = z10 ? this.f35022na + 1 : this.f35022na - 1;
        float d10 = this.mOptions.d(x(), i10);
        float c4 = this.mOptions.c(x(), i10);
        t b4 = this.mOptions.b();
        b4.g(d10);
        b4.f(c4);
        int w3 = this.mOptions.w();
        b4.q(z10 ? w3 + 1 : w3 - 1);
        float maxDiffFraction = getMaxDiffFraction();
        this.f35030va = b4.w() > w3;
        a(z10 ? this.mOptions.k() : this.mOptions.m(), z10 ? b4.k() : b4.m());
        performTargetDecelerateAnimation(z10 ? this.mOptions.m() : this.mOptions.k(), z10 ? b4.m() : b4.k(), this, new k(this, maxDiffFraction, z10, d10, c4));
        this.f35022na = i10;
        a(this.mOptions.e(x(), this.f35022na));
        if (z10) {
            this.f35035za.nextPage();
        } else {
            this.f35035za.prePage();
        }
    }

    private void a(int i10, int i11) {
        float h10 = this.mOptions.h(i11);
        this.mOptions.g(this.mOptions.i(i11));
        this.mOptions.f(h10);
        boolean z10 = i11 > i10;
        float c4 = this.mOptions.c(i10);
        float b4 = this.mOptions.b(i10);
        float a10 = this.mOptions.a(i11);
        if (!z10) {
            c4 = b4;
        }
        this.mOptions.b(i10, c4);
        this.mOptions.b(i11, a10);
        invalidate();
        settleToTarget(i11);
    }

    private void a(boolean z10, boolean z11, float f10, float f11, float f12) {
        float f13;
        float f14;
        float f15;
        float f16;
        int i10;
        int i11 = this.L;
        int i12 = this.f35021ma;
        int i13 = i12 - 1;
        float f17 = (((f10 - (this.f35015ga * 2.0f)) - this.f35010ba) - (i11 * i13)) / i13;
        float[] fArr = new float[i12];
        boolean z12 = this.I;
        int i14 = 0;
        boolean z13 = z12 && z10;
        boolean z14 = z12 && !z10;
        boolean z15 = (z12 || z11) ? false : true;
        if (!z13 && !z15) {
            f16 = this.Ra.left;
            f13 = f16 + f10;
            while (true) {
                i10 = this.f35021ma;
                if (i14 >= i10) {
                    break;
                }
                int i15 = this.I ? (i10 - 1) - i14 : i14;
                fArr[i15] = (this.L / 2.0f) + (i14 * f17) + this.f35015ga + f16 + (r10 * i14);
                i14++;
            }
            if (z14) {
                f15 = (this.L / 2.0f) + fArr[1] + f17;
                f14 = this.f35010ba + f15;
            } else {
                f14 = f17 + (this.L / 2.0f) + fArr[(i10 - 1) - 1];
                f15 = f14 + this.f35010ba;
            }
        } else {
            f13 = this.Ra.right;
            float f18 = f13 - f10;
            for (int i16 = i12 - 1; i16 >= 0; i16--) {
                int i17 = (this.f35021ma - 1) - i16;
                int i18 = this.I ? i17 : i16;
                fArr[i18] = (((f13 - this.f35015ga) - (i17 * f17)) - (this.L / 2.0f)) - (i17 * r12);
            }
            if (z13) {
                f15 = f18 + this.f35015ga;
                f14 = this.f35010ba + f15;
            } else {
                f14 = this.f35015ga + f18;
                f15 = f14 + this.f35010ba;
            }
            f16 = f18;
        }
        this.mOptions.b(f16, f11, f13, f12);
        this.mOptions.a(fArr);
        this.mOptions.g(f14);
        this.mOptions.f(f15);
        invalidate();
    }

    private void a(@NonNull Canvas canvas) {
        Paint paint;
        ConcurrentHashMap<Integer, Float> B = this.mOptions.B();
        float[] d10 = this.mOptions.d();
        for (int i10 = 0; i10 < this.f35021ma; i10++) {
            float f10 = this.mOptions.f();
            if (B != null && B.get(Integer.valueOf(i10)) != null && i10 != this.f35022na) {
                f10 = B.get(Integer.valueOf(i10)).floatValue();
            }
            if (d10 != null && i10 < d10.length && (paint = this.Ca) != null) {
                canvas.drawCircle(d10[i10], this.f35011ca, f10, paint);
            }
        }
    }

    private void a(int i10, boolean z10, float f10, float f11, boolean z11) {
        performTargetDecelerateAnimation(f10, f11, this, new i(this, getMaxDiffFraction(), z10, Math.abs(i10 - this.f35022na), f11, new h(this, z11)));
    }

    private void a(float f10, int i10, int i11) {
        HwDotsPageIndicatorInteractor.OnGestureListener onGestureListener = this.Ja;
        if (onGestureListener != null) {
            onGestureListener.onDragging(f10, i10, i11);
        }
    }
}
