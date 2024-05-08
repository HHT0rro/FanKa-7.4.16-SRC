package com.cupidapp.live.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import ce.n;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.smartrefresh.layout.SmartRefreshLayout;
import com.cupidapp.live.smartrefresh.layout.constant.RefreshState;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s3.e;
import z0.h;

/* compiled from: SmartRefreshLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SmartRefreshLayout extends ViewGroup implements q3.d, NestedScrollingParent {

    /* renamed from: g0, reason: collision with root package name */
    @Nullable
    public static s3.b f18262g0;
    public boolean A;
    public boolean B;

    @Nullable
    public s3.c C;

    @Nullable
    public e D;
    public int E;
    public boolean F;

    @NotNull
    public int[] G;

    @NotNull
    public NestedScrollingChildHelper H;

    @NotNull
    public NestedScrollingParentHelper I;
    public int J;
    public r3.a K;
    public int L;
    public float M;
    public float N;
    public float O;

    @Nullable
    public q3.a P;

    @Nullable
    public q3.b Q;

    @Nullable
    public Handler R;

    @NotNull
    public q3.c S;

    @NotNull
    public RefreshState T;

    @NotNull
    public RefreshState U;
    public boolean V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f18264a0;

    /* renamed from: b, reason: collision with root package name */
    public int f18265b;

    /* renamed from: b0, reason: collision with root package name */
    @Nullable
    public MotionEvent f18266b0;

    /* renamed from: c, reason: collision with root package name */
    public int f18267c;

    /* renamed from: c0, reason: collision with root package name */
    @Nullable
    public Runnable f18268c0;

    /* renamed from: d, reason: collision with root package name */
    public int f18269d;

    /* renamed from: d0, reason: collision with root package name */
    @Nullable
    public ValueAnimator f18270d0;

    /* renamed from: e, reason: collision with root package name */
    public int f18271e;

    /* renamed from: e0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18272e0;

    /* renamed from: f, reason: collision with root package name */
    public int f18273f;

    /* renamed from: g, reason: collision with root package name */
    public int f18274g;

    /* renamed from: h, reason: collision with root package name */
    public int f18275h;

    /* renamed from: i, reason: collision with root package name */
    public float f18276i;

    /* renamed from: j, reason: collision with root package name */
    public float f18277j;

    /* renamed from: k, reason: collision with root package name */
    public float f18278k;

    /* renamed from: l, reason: collision with root package name */
    public float f18279l;

    /* renamed from: m, reason: collision with root package name */
    public float f18280m;

    /* renamed from: n, reason: collision with root package name */
    public char f18281n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f18282o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f18283p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f18284q;

    /* renamed from: r, reason: collision with root package name */
    public int f18285r;

    /* renamed from: s, reason: collision with root package name */
    public int f18286s;

    /* renamed from: t, reason: collision with root package name */
    public int f18287t;

    /* renamed from: u, reason: collision with root package name */
    public int f18288u;

    /* renamed from: v, reason: collision with root package name */
    public int f18289v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Scroller f18290w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public VelocityTracker f18291x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public Interpolator f18292y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f18293z;

    /* renamed from: f0, reason: collision with root package name */
    @NotNull
    public static final b f18261f0 = new b(null);

    /* renamed from: h0, reason: collision with root package name */
    @NotNull
    public static ViewGroup.MarginLayoutParams f18263h0 = new ViewGroup.MarginLayoutParams(-1, -1);

    /* compiled from: SmartRefreshLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public float f18294b;

        /* renamed from: c, reason: collision with root package name */
        public int f18295c;

        /* renamed from: d, reason: collision with root package name */
        public int f18296d;

        /* renamed from: e, reason: collision with root package name */
        public int f18297e = 10;

        /* renamed from: f, reason: collision with root package name */
        public long f18298f = AnimationUtils.currentAnimationTimeMillis();

        /* renamed from: g, reason: collision with root package name */
        public float f18299g;

        public a(float f10, int i10) {
            this.f18294b = f10;
            this.f18295c = i10;
            Handler handler = SmartRefreshLayout.this.R;
            if (handler != null) {
                handler.postDelayed(this, this.f18297e);
            }
            if (this.f18294b > 0.0f) {
                SmartRefreshLayout.this.S.a(RefreshState.PullDownToRefresh);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            double pow;
            if (SmartRefreshLayout.this.f18268c0 != this || SmartRefreshLayout.this.T.isFinishing()) {
                return;
            }
            float f10 = this.f18294b;
            if (Math.abs(SmartRefreshLayout.this.f18267c) >= Math.abs(this.f18295c)) {
                if (this.f18295c != 0) {
                    this.f18296d = this.f18296d + 1;
                    pow = Math.pow(0.45d, r3 * 2);
                } else {
                    this.f18296d = this.f18296d + 1;
                    pow = Math.pow(0.85d, r3 * 2);
                }
            } else {
                this.f18296d = this.f18296d + 1;
                pow = Math.pow(0.95d, r3 * 2);
            }
            this.f18294b = f10 * ((float) pow);
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f11 = this.f18294b * ((((float) (currentAnimationTimeMillis - this.f18298f)) * 1.0f) / 1000);
            if (Math.abs(f11) >= 1.0f) {
                this.f18298f = currentAnimationTimeMillis;
                float f12 = this.f18299g + f11;
                this.f18299g = f12;
                SmartRefreshLayout.this.G(f12);
                Handler handler = SmartRefreshLayout.this.R;
                if (handler != null) {
                    handler.postDelayed(this, this.f18297e);
                    return;
                }
                return;
            }
            if (SmartRefreshLayout.this.U.isDragging() && SmartRefreshLayout.this.U.isHeader()) {
                SmartRefreshLayout.this.S.a(RefreshState.PullDownCanceled);
            }
            SmartRefreshLayout.this.f18268c0 = null;
            if (Math.abs(SmartRefreshLayout.this.f18267c) >= Math.abs(this.f18295c)) {
                int min = Math.min(Math.max(h.t(this, Math.abs(SmartRefreshLayout.this.f18267c - this.f18295c)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.C(this.f18295c, 0, smartRefreshLayout.f18292y, min);
            }
        }
    }

    /* compiled from: SmartRefreshLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SmartRefreshLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements q3.c {

        /* compiled from: SmartRefreshLayout.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f18302a;

            static {
                int[] iArr = new int[RefreshState.values().length];
                try {
                    iArr[RefreshState.None.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RefreshState.PullDownToRefresh.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RefreshState.PullDownCanceled.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RefreshState.ReleaseToRefresh.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RefreshState.ReleaseToTwoLevel.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f18302a = iArr;
            }
        }

        /* compiled from: SmartRefreshLayout.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class b extends AnimatorListenerAdapter {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SmartRefreshLayout f18303b;

            public b(SmartRefreshLayout smartRefreshLayout) {
                this.f18303b = smartRefreshLayout;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                s.i(animation, "animation");
                if (animation.getDuration() == 0) {
                    return;
                }
                this.f18303b.S.a(RefreshState.TwoLevel);
            }
        }

        public c() {
        }

        @Override // q3.c
        @Nullable
        public q3.c a(@NotNull RefreshState state) {
            s.i(state, "state");
            int i10 = a.f18302a[state.ordinal()];
            if (i10 == 1) {
                RefreshState refreshState = SmartRefreshLayout.this.T;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState != refreshState2 && SmartRefreshLayout.this.f18267c == 0) {
                    SmartRefreshLayout.this.H(refreshState2);
                    return null;
                }
                if (SmartRefreshLayout.this.f18267c == 0) {
                    return null;
                }
                b(0);
                return null;
            }
            if (i10 == 2) {
                if (!SmartRefreshLayout.this.T.isOpening()) {
                    SmartRefreshLayout.this.H(RefreshState.PullDownToRefresh);
                    return null;
                }
                SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                return null;
            }
            if (i10 == 3) {
                if (!SmartRefreshLayout.this.T.isOpening()) {
                    SmartRefreshLayout.this.H(RefreshState.PullDownCanceled);
                    a(RefreshState.None);
                    return null;
                }
                SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                return null;
            }
            if (i10 == 4) {
                if (!SmartRefreshLayout.this.T.isOpening()) {
                    SmartRefreshLayout.this.H(RefreshState.ReleaseToRefresh);
                    return null;
                }
                SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                return null;
            }
            if (i10 != 5) {
                SmartRefreshLayout.this.H(state);
                return null;
            }
            if (!SmartRefreshLayout.this.T.isOpening()) {
                SmartRefreshLayout.this.H(RefreshState.ReleaseToTwoLevel);
                return null;
            }
            SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
            return null;
        }

        @Override // q3.c
        @Nullable
        public ValueAnimator b(int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.C(i10, 0, smartRefreshLayout.f18292y, SmartRefreshLayout.this.f18274g);
        }

        @Override // q3.c
        @NotNull
        public q3.d c() {
            return SmartRefreshLayout.this;
        }

        @Override // q3.c
        @NotNull
        public q3.c d() {
            if (SmartRefreshLayout.this.T == RefreshState.TwoLevel) {
                SmartRefreshLayout.this.S.a(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.f18267c == 0) {
                    g(0, false);
                    SmartRefreshLayout.this.H(RefreshState.None);
                } else {
                    ValueAnimator b4 = b(0);
                    if (b4 != null) {
                        b4.setDuration(SmartRefreshLayout.this.f18273f);
                    }
                }
            }
            return this;
        }

        @Override // q3.c
        @NotNull
        public q3.c e(@NotNull q3.a internal, boolean z10) {
            s.i(internal, "internal");
            if (s.d(internal, SmartRefreshLayout.this.P)) {
                SmartRefreshLayout.this.V = z10;
            }
            return this;
        }

        @Override // q3.c
        @NotNull
        public q3.c f(boolean z10) {
            if (z10) {
                b bVar = new b(SmartRefreshLayout.this);
                ValueAnimator b4 = b(SmartRefreshLayout.this.getMeasuredHeight());
                if (b4 != null && b4 == SmartRefreshLayout.this.f18270d0) {
                    b4.setDuration(SmartRefreshLayout.this.f18273f);
                    b4.addListener(bVar);
                } else if (b4 != null) {
                    bVar.onAnimationEnd(b4);
                }
            } else if (b(0) == null) {
                SmartRefreshLayout.this.H(RefreshState.None);
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
        @Override // q3.c
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public q3.c g(int r13, boolean r14) {
            /*
                Method dump skipped, instructions count: 364
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.smartrefresh.layout.SmartRefreshLayout.c.g(int, boolean):q3.c");
        }
    }

    /* compiled from: SmartRefreshLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            if (animation.getDuration() == 0) {
                return;
            }
            SmartRefreshLayout.this.f18270d0 = null;
            if (SmartRefreshLayout.this.f18267c == 0) {
                RefreshState refreshState = SmartRefreshLayout.this.T;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState != refreshState2 && !SmartRefreshLayout.this.T.isOpening() && !SmartRefreshLayout.this.T.isDragging()) {
                    SmartRefreshLayout.this.H(refreshState2);
                    return;
                }
            }
            if (SmartRefreshLayout.this.T != SmartRefreshLayout.this.U) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.setViceState(smartRefreshLayout.T);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartRefreshLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        s.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartRefreshLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18272e0 = new LinkedHashMap();
        this.f18273f = 500;
        this.f18274g = 200;
        this.f18280m = 0.5f;
        this.f18281n = 'n';
        this.f18285r = -1;
        this.f18286s = -1;
        this.f18293z = true;
        this.A = true;
        this.B = true;
        this.G = new int[2];
        this.H = new NestedScrollingChildHelper(this);
        this.I = new NestedScrollingParentHelper(this);
        this.K = r3.a.f53246c;
        this.M = 2.5f;
        this.N = 0.5f;
        this.O = 1.0f;
        this.S = new c();
        RefreshState refreshState = RefreshState.None;
        this.T = refreshState;
        this.U = refreshState;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.R = new Handler(Looper.getMainLooper());
        this.f18290w = new Scroller(context);
        VelocityTracker obtain = VelocityTracker.obtain();
        s.h(obtain, "obtain()");
        this.f18291x = obtain;
        this.f18275h = context.getResources().getDisplayMetrics().heightPixels;
        this.f18292y = new u3.b();
        this.f18265b = viewConfiguration.getScaledTouchSlop();
        this.f18287t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f18288u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.J = h.c(this, 100.0f);
        s3.b bVar = f18262g0;
        if (bVar == null || bVar == null) {
            return;
        }
        bVar.a(context, this);
    }

    public static final void D(SmartRefreshLayout this$0, ValueAnimator animation) {
        s.i(this$0, "this$0");
        s.i(animation, "animation");
        q3.c cVar = this$0.S;
        Object animatedValue = animation.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        cVar.g(((Integer) animatedValue).intValue(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setViceState(RefreshState refreshState) {
        if (this.T.isDragging() && this.T.isHeader() != refreshState.isHeader()) {
            H(RefreshState.None);
        }
        if (this.U != refreshState) {
            this.U = refreshState;
        }
    }

    public final ValueAnimator C(int i10, int i11, Interpolator interpolator, int i12) {
        if (this.f18267c == i10) {
            return null;
        }
        ValueAnimator valueAnimator = this.f18270d0;
        if (valueAnimator != null) {
            if (valueAnimator != null) {
                valueAnimator.setDuration(0L);
            }
            ValueAnimator valueAnimator2 = this.f18270d0;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            this.f18270d0 = null;
        }
        this.f18268c0 = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f18267c, i10);
        this.f18270d0 = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(i12);
        }
        ValueAnimator valueAnimator3 = this.f18270d0;
        if (valueAnimator3 != null) {
            valueAnimator3.setInterpolator(interpolator);
        }
        ValueAnimator valueAnimator4 = this.f18270d0;
        if (valueAnimator4 != null) {
            valueAnimator4.addListener(new d());
        }
        ValueAnimator valueAnimator5 = this.f18270d0;
        if (valueAnimator5 != null) {
            valueAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: p3.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator6) {
                    SmartRefreshLayout.D(SmartRefreshLayout.this, valueAnimator6);
                }
            });
        }
        ValueAnimator valueAnimator6 = this.f18270d0;
        if (valueAnimator6 != null) {
            valueAnimator6.setStartDelay(i11);
        }
        ValueAnimator valueAnimator7 = this.f18270d0;
        if (valueAnimator7 != null) {
            valueAnimator7.start();
        }
        return this.f18270d0;
    }

    public final void E(float f10) {
        if (this.f18270d0 == null && f10 > 0.0f && this.T == RefreshState.TwoLevel) {
            this.f18268c0 = new a(f10, this.J);
        }
    }

    public final boolean F(int i10) {
        return this.f18270d0 != null;
    }

    public final void G(float f10) {
        if (this.T == RefreshState.TwoLevel && f10 > 0.0f) {
            this.S.g(Math.min((int) f10, getMeasuredHeight()), true);
            return;
        }
        if (f10 >= 0.0f) {
            float f11 = this.M;
            double d10 = f11 < 10.0f ? this.J * f11 : f11;
            double max = Math.max(this.f18275h / 2, getHeight());
            double max2 = Math.max(0.0f, f10 * this.f18280m);
            this.S.g((int) Math.min(d10 * (1 - Math.pow(100.0d, (-max2) / ((max > ShadowDrawableWrapper.COS_45 ? 1 : (max == ShadowDrawableWrapper.COS_45 ? 0 : -1)) == 0 ? 1.0d : max))), max2), true);
            return;
        }
        double max3 = Math.max(this.f18275h / 2, getHeight());
        double d11 = -Math.min(0.0f, f10 * this.f18280m);
        double d12 = 1;
        double d13 = -d11;
        if (max3 == ShadowDrawableWrapper.COS_45) {
            max3 = 1.0d;
        }
        this.S.g((int) (-Math.min((d12 - Math.pow(100.0d, d13 / max3)) * ShadowDrawableWrapper.COS_45, d11)), true);
    }

    public final void H(RefreshState refreshState) {
        RefreshState refreshState2 = this.T;
        if (refreshState2 != refreshState) {
            this.T = refreshState;
            this.U = refreshState;
            q3.a aVar = this.P;
            s3.c cVar = this.C;
            if (aVar != null) {
                aVar.c(this, refreshState2, refreshState);
            }
            if (cVar != null) {
                cVar.c(this, refreshState2, refreshState);
                return;
            }
            return;
        }
        if (this.U != refreshState2) {
            this.U = refreshState2;
        }
    }

    public final void I() {
        RefreshState refreshState = this.T;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.f18289v > -1000 && this.f18267c > getHeight() / 2) {
                ValueAnimator b4 = this.S.b(getHeight());
                if (b4 != null) {
                    b4.setDuration(this.f18273f);
                    return;
                }
                return;
            }
            if (this.f18282o) {
                this.S.d();
                return;
            }
            return;
        }
        if (refreshState == RefreshState.PullDownToRefresh) {
            this.S.a(RefreshState.PullDownCanceled);
        } else if (refreshState == RefreshState.ReleaseToTwoLevel) {
            this.S.a(RefreshState.TwoLevelReleased);
        } else if (this.f18267c != 0) {
            this.S.b(0);
        }
    }

    @NotNull
    public q3.d J(@Nullable s3.c cVar) {
        this.C = cVar;
        return this;
    }

    public final boolean K(float f10) {
        if (f10 == 0.0f) {
            f10 = this.f18289v;
        }
        return Math.abs(f10) > ((float) this.f18287t) && f10 * ((float) this.f18267c) < 0.0f && this.T.isReleaseToOpening();
    }

    @Override // q3.d
    @NotNull
    public q3.d a(boolean z10) {
        setNestedScrollingEnabled(z10);
        return this;
    }

    @Override // q3.d
    @NotNull
    public q3.d b(float f10) {
        this.M = f10;
        q3.a aVar = this.P;
        if (aVar == null || !this.W) {
            this.K = this.K.c();
        } else {
            if (f10 < 10.0f) {
                f10 *= this.J;
            }
            int i10 = (int) f10;
            if (aVar != null) {
                aVar.b(this.S, this.J, i10);
            }
        }
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f18290w.computeScrollOffset()) {
            if (this.f18290w.getFinalY() < 0) {
                q3.b bVar = this.Q;
                boolean z10 = false;
                if (bVar != null && bVar.f()) {
                    z10 = true;
                }
                if (z10) {
                    if (this.f18264a0) {
                        E(this.f18290w.getCurrVelocity());
                    }
                    this.f18290w.forceFinished(true);
                    return;
                }
            }
            this.f18264a0 = true;
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x013f, code lost:
    
        if ((r2 != null && r2.f()) != false) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 701
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(@NotNull Canvas canvas, @NotNull View child, long j10) {
        s.i(canvas, "canvas");
        s.i(child, "child");
        q3.b bVar = this.Q;
        View view = (bVar == null || bVar == null) ? null : bVar.getView();
        q3.a aVar = this.P;
        if (aVar != null) {
            if ((aVar != null ? aVar.getView() : null) == child) {
                if (isInEditMode()) {
                    return true;
                }
                if (view != null) {
                    int b4 = n.b(view.getTop() + view.getPaddingTop() + this.f18267c, child.getTop());
                    if (this.f18293z) {
                        q3.a aVar2 = this.P;
                        if ((aVar2 != null ? aVar2.getSpinnerStyle() : null) == r3.b.f53261c) {
                            canvas.save();
                            canvas.clipRect(child.getLeft(), child.getTop(), child.getRight(), b4);
                            boolean drawChild = super.drawChild(canvas, child, j10);
                            canvas.restore();
                            return drawChild;
                        }
                    }
                }
            }
        }
        return super.drawChild(canvas, child, j10);
    }

    @Override // android.view.ViewGroup
    @NotNull
    public ViewGroup.LayoutParams generateLayoutParams(@NotNull AttributeSet attrs) {
        s.i(attrs, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    public final float getHeaderTriggerRate() {
        return this.N;
    }

    @Override // q3.d
    @NotNull
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.I.getNestedScrollAxes();
    }

    @Override // q3.d
    @NotNull
    public RefreshState getState() {
        return this.T;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        r3.b spinnerStyle;
        int i10;
        super.onAttachedToWindow();
        this.W = true;
        if (!isInEditMode()) {
            if (this.Q == null) {
                int childCount = getChildCount();
                while (i10 < childCount) {
                    View childAt = getChildAt(i10);
                    q3.a aVar = this.P;
                    if (aVar != null) {
                        i10 = childAt == (aVar != null ? aVar.getView() : null) ? i10 + 1 : 0;
                    }
                    this.Q = new v3.a(childAt);
                }
            }
            if (this.Q == null) {
                int c4 = h.c(this, 20.0f);
                TextView textView = new TextView(getContext());
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R$string.load_failed_refresh);
                super.addView(textView, 0, new ViewGroup.LayoutParams(-1, -1));
                v3.a aVar2 = new v3.a(textView);
                this.Q = aVar2;
                View view = aVar2.getView();
                if (view != null) {
                    view.setPadding(c4, c4, c4, c4);
                }
            }
            View findViewById = findViewById(this.f18285r);
            q3.b bVar = this.Q;
            if (bVar != null) {
                bVar.g(this.D);
            }
            q3.b bVar2 = this.Q;
            if (bVar2 != null) {
                bVar2.b(false);
            }
            q3.b bVar3 = this.Q;
            if (bVar3 != null) {
                bVar3.c(this.S, findViewById);
            }
            if (this.f18267c != 0) {
                H(RefreshState.None);
                q3.b bVar4 = this.Q;
                if (bVar4 != null) {
                    this.f18267c = 0;
                    bVar4.d(0, this.f18286s);
                }
            }
        }
        q3.b bVar5 = this.Q;
        if (bVar5 != null) {
            super.bringChildToFront(bVar5 != null ? bVar5.getView() : null);
        }
        q3.a aVar3 = this.P;
        if (aVar3 != null) {
            if ((aVar3 == null || (spinnerStyle = aVar3.getSpinnerStyle()) == null || !spinnerStyle.f53265b) ? false : true) {
                q3.a aVar4 = this.P;
                super.bringChildToFront(aVar4 != null ? aVar4.getView() : null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.W = false;
        this.f18268c0 = null;
        ValueAnimator valueAnimator = this.f18270d0;
        if (valueAnimator != null) {
            s.f(valueAnimator);
            valueAnimator.removeAllListeners();
            ValueAnimator valueAnimator2 = this.f18270d0;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllUpdateListeners();
            }
            ValueAnimator valueAnimator3 = this.f18270d0;
            if (valueAnimator3 != null) {
                valueAnimator3.setDuration(0L);
            }
            ValueAnimator valueAnimator4 = this.f18270d0;
            if (valueAnimator4 != null) {
                valueAnimator4.cancel();
            }
            this.f18270d0 = null;
        }
        if (this.f18267c != 0) {
            this.S.g(0, true);
        }
        RefreshState refreshState = this.T;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2) {
            H(refreshState2);
        }
        Handler handler = this.R;
        if (handler == null || handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i10 = -1;
        int i11 = 0;
        int i12 = -1;
        char c4 = 0;
        while (i11 < childCount) {
            View childAt = super.getChildAt(i11);
            if (u3.b.b(childAt) && (c4 < 2 || i11 == 1)) {
                i12 = i11;
                c4 = 2;
            } else if (!(childAt instanceof q3.a) && c4 < 1) {
                c4 = i11 > 0 ? (char) 1 : (char) 0;
                i12 = i11;
            }
            i11++;
        }
        if (i12 >= 0) {
            this.Q = new v3.a(super.getChildAt(i12));
            if (i12 == 1) {
                i10 = 0;
            }
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            KeyEvent.Callback childAt2 = super.getChildAt(i13);
            if (i13 == i10 && (childAt2 instanceof q3.a)) {
                this.P = (q3.a) childAt2;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view;
        View view2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = super.getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = super.getChildAt(i14);
            if (childAt.getVisibility() != 8 && !s.d("GONE", childAt.getTag(R$id.srl_tag))) {
                q3.b bVar = this.Q;
                if (bVar != null) {
                    if ((bVar != null ? bVar.getView() : null) == childAt) {
                        isInEditMode();
                        q3.b bVar2 = this.Q;
                        if (bVar2 == null || (view2 = bVar2.getView()) == null) {
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f18263h0;
                        int i15 = marginLayoutParams.leftMargin + paddingLeft;
                        int i16 = marginLayoutParams.topMargin + paddingTop;
                        view2.layout(i15, i16, view2.getMeasuredWidth() + i15, view2.getMeasuredHeight() + i16);
                    }
                }
                q3.a aVar = this.P;
                if (aVar == null) {
                    continue;
                } else if ((aVar != null ? aVar.getView() : null) == childAt) {
                    isInEditMode();
                    q3.a aVar2 = this.P;
                    if (aVar2 == null || (view = aVar2.getView()) == null) {
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : f18263h0;
                    int i17 = marginLayoutParams2.leftMargin;
                    int i18 = marginLayoutParams2.topMargin + this.L;
                    view.layout(i17, i18, view.getMeasuredWidth() + i17, view.getMeasuredHeight() + i18);
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019d A[SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(@NotNull View target, float f10, float f11, boolean z10) {
        s.i(target, "target");
        return this.H.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(@NotNull View target, float f10, float f11) {
        s.i(target, "target");
        return K(-f11) || this.H.dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(@NotNull View target, int i10, int i11, @NotNull int[] consumed) {
        s.i(target, "target");
        s.i(consumed, "consumed");
        int i12 = 0;
        if (this.E * i11 > 0) {
            if (Math.abs(i11) > Math.abs(this.E)) {
                int i13 = this.E;
                this.E = 0;
                i12 = i13;
            } else {
                this.E -= i11;
                i12 = i11;
            }
            G(this.E);
        }
        this.H.dispatchNestedPreScroll(i10, i11 - i12, consumed, null);
        consumed[1] = consumed[1] + i12;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(@NotNull View target, int i10, int i11, int i12, int i13) {
        ViewParent parent;
        s.i(target, "target");
        boolean dispatchNestedScroll = this.H.dispatchNestedScroll(i10, i11, i12, i13, this.G);
        int i14 = i13 + this.G[1];
        if (i14 < 0) {
            if (this.E == 0 && this.D != null) {
                q3.b bVar = this.Q;
                if ((bVar != null ? bVar.getView() : null) == null) {
                    return;
                }
                e eVar = this.D;
                boolean z10 = false;
                if (eVar != null) {
                    q3.b bVar2 = this.Q;
                    if (eVar.a(bVar2 != null ? bVar2.getView() : null)) {
                        z10 = true;
                    }
                }
                if (!z10) {
                    return;
                }
            }
            RefreshState refreshState = this.U;
            if (refreshState == RefreshState.None || refreshState.isOpening()) {
                this.S.a(RefreshState.PullDownToRefresh);
                if (!dispatchNestedScroll && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i15 = this.E - i14;
            this.E = i15;
            G(i15);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int i10) {
        s.i(child, "child");
        s.i(target, "target");
        this.I.onNestedScrollAccepted(child, target, i10);
        this.H.startNestedScroll(i10 & 2);
        this.E = this.f18267c;
        this.F = true;
        F(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int i10) {
        s.i(child, "child");
        s.i(target, "target");
        return isEnabled() && isNestedScrollingEnabled() && (i10 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(@NotNull View target) {
        s.i(target, "target");
        this.I.onStopNestedScroll(target);
        this.F = false;
        this.E = 0;
        I();
        this.H.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        q3.b bVar = this.Q;
        View e2 = bVar != null ? bVar.e() : null;
        if (e2 == null || !ViewCompat.isNestedScrollingEnabled(e2)) {
            return;
        }
        this.f18284q = z10;
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public final void setHeaderTriggerRate(float f10) {
        this.N = f10;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z10) {
        this.B = z10;
        this.H.setNestedScrollingEnabled(z10);
    }

    public /* synthetic */ SmartRefreshLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
