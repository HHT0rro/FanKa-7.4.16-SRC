package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StyledPlayerControlViewLayoutManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h0 {
    public boolean A;
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public final StyledPlayerControlView f22616a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final View f22617b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final ViewGroup f22618c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final ViewGroup f22619d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final ViewGroup f22620e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final ViewGroup f22621f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final ViewGroup f22622g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final ViewGroup f22623h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final ViewGroup f22624i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final View f22625j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final View f22626k;

    /* renamed from: l, reason: collision with root package name */
    public final AnimatorSet f22627l;

    /* renamed from: m, reason: collision with root package name */
    public final AnimatorSet f22628m;

    /* renamed from: n, reason: collision with root package name */
    public final AnimatorSet f22629n;

    /* renamed from: o, reason: collision with root package name */
    public final AnimatorSet f22630o;

    /* renamed from: p, reason: collision with root package name */
    public final AnimatorSet f22631p;

    /* renamed from: q, reason: collision with root package name */
    public final ValueAnimator f22632q;

    /* renamed from: r, reason: collision with root package name */
    public final ValueAnimator f22633r;

    /* renamed from: s, reason: collision with root package name */
    public final Runnable f22634s = new Runnable() { // from class: com.google.android.exoplayer2.ui.x
        @Override // java.lang.Runnable
        public final void run() {
            h0.this.c0();
        }
    };

    /* renamed from: t, reason: collision with root package name */
    public final Runnable f22635t = new Runnable() { // from class: com.google.android.exoplayer2.ui.f0
        @Override // java.lang.Runnable
        public final void run() {
            h0.this.D();
        }
    };

    /* renamed from: u, reason: collision with root package name */
    public final Runnable f22636u = new Runnable() { // from class: com.google.android.exoplayer2.ui.v
        @Override // java.lang.Runnable
        public final void run() {
            h0.this.H();
        }
    };

    /* renamed from: v, reason: collision with root package name */
    public final Runnable f22637v = new Runnable() { // from class: com.google.android.exoplayer2.ui.w
        @Override // java.lang.Runnable
        public final void run() {
            h0.this.G();
        }
    };

    /* renamed from: w, reason: collision with root package name */
    public final Runnable f22638w = new Runnable() { // from class: com.google.android.exoplayer2.ui.g0
        @Override // java.lang.Runnable
        public final void run() {
            h0.this.E();
        }
    };

    /* renamed from: x, reason: collision with root package name */
    public final View.OnLayoutChangeListener f22639x = new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.c0
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            h0.this.R(view, i10, i11, i12, i13, i14, i15, i16, i17);
        }
    };
    public boolean C = true;

    /* renamed from: z, reason: collision with root package name */
    public int f22641z = 0;

    /* renamed from: y, reason: collision with root package name */
    public final List<View> f22640y = new ArrayList();

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (h0.this.f22617b != null) {
                h0.this.f22617b.setVisibility(4);
            }
            if (h0.this.f22618c != null) {
                h0.this.f22618c.setVisibility(4);
            }
            if (h0.this.f22620e != null) {
                h0.this.f22620e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(h0.this.f22625j instanceof DefaultTimeBar) || h0.this.A) {
                return;
            }
            ((DefaultTimeBar) h0.this.f22625j).g(250L);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (h0.this.f22617b != null) {
                h0.this.f22617b.setVisibility(0);
            }
            if (h0.this.f22618c != null) {
                h0.this.f22618c.setVisibility(0);
            }
            if (h0.this.f22620e != null) {
                h0.this.f22620e.setVisibility(h0.this.A ? 0 : 4);
            }
            if (!(h0.this.f22625j instanceof DefaultTimeBar) || h0.this.A) {
                return;
            }
            ((DefaultTimeBar) h0.this.f22625j).t(250L);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f22644b;

        public c(StyledPlayerControlView styledPlayerControlView) {
            this.f22644b = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h0.this.Z(1);
            if (h0.this.B) {
                this.f22644b.post(h0.this.f22634s);
                h0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h0.this.Z(3);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f22646b;

        public d(StyledPlayerControlView styledPlayerControlView) {
            this.f22646b = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h0.this.Z(2);
            if (h0.this.B) {
                this.f22646b.post(h0.this.f22634s);
                h0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h0.this.Z(3);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f22648b;

        public e(StyledPlayerControlView styledPlayerControlView) {
            this.f22648b = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h0.this.Z(2);
            if (h0.this.B) {
                this.f22648b.post(h0.this.f22634s);
                h0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h0.this.Z(3);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h0.this.Z(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h0.this.Z(4);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h0.this.Z(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h0.this.Z(4);
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (h0.this.f22621f != null) {
                h0.this.f22621f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (h0.this.f22623h != null) {
                h0.this.f22623h.setVisibility(0);
                h0.this.f22623h.setTranslationX(h0.this.f22623h.getWidth());
                h0.this.f22623h.scrollTo(h0.this.f22623h.getWidth(), 0);
            }
        }
    }

    /* compiled from: StyledPlayerControlViewLayoutManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (h0.this.f22623h != null) {
                h0.this.f22623h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (h0.this.f22621f != null) {
                h0.this.f22621f.setVisibility(0);
            }
        }
    }

    public h0(StyledPlayerControlView styledPlayerControlView) {
        this.f22616a = styledPlayerControlView;
        this.f22617b = styledPlayerControlView.findViewById(R$id.exo_controls_background);
        this.f22618c = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_center_controls);
        this.f22620e = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_bottom_bar);
        this.f22619d = viewGroup;
        this.f22624i = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_time);
        View findViewById = styledPlayerControlView.findViewById(R$id.exo_progress);
        this.f22625j = findViewById;
        this.f22621f = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_basic_controls);
        this.f22622g = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls);
        this.f22623h = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls_scroll_view);
        View findViewById2 = styledPlayerControlView.findViewById(R$id.exo_overflow_show);
        this.f22626k = findViewById2;
        View findViewById3 = styledPlayerControlView.findViewById(R$id.exo_overflow_hide);
        if (findViewById2 != null && findViewById3 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h0.this.T(view);
                }
            });
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h0.this.T(view);
                }
            });
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.y
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h0.this.J(valueAnimator);
            }
        });
        ofFloat.addListener(new a());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h0.this.K(valueAnimator);
            }
        });
        ofFloat2.addListener(new b());
        Resources resources = styledPlayerControlView.getResources();
        int i10 = R$dimen.exo_styled_bottom_bar_height;
        float dimension = resources.getDimension(i10) - resources.getDimension(R$dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(i10);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f22627l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(styledPlayerControlView));
        animatorSet.play(ofFloat).with(N(0.0f, dimension, findViewById)).with(N(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f22628m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(styledPlayerControlView));
        animatorSet2.play(N(dimension, dimension2, findViewById)).with(N(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f22629n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(styledPlayerControlView));
        animatorSet3.play(ofFloat).with(N(0.0f, dimension2, findViewById)).with(N(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f22630o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(ofFloat2).with(N(dimension, 0.0f, findViewById)).with(N(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f22631p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(ofFloat2).with(N(dimension2, 0.0f, findViewById)).with(N(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f22632q = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h0.this.L(valueAnimator);
            }
        });
        ofFloat3.addListener(new h());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f22633r = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.a0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h0.this.M(valueAnimator);
            }
        });
        ofFloat4.addListener(new i());
    }

    public static int B(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f22617b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f22618c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f22620e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f22617b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f22618c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f22620e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static ObjectAnimator N(float f10, float f11, View view) {
        return ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, f10, f11);
    }

    public static int z(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(@Nullable View view) {
        return view != null && this.f22640y.contains(view);
    }

    public void C() {
        int i10 = this.f22641z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        V();
        if (!this.C) {
            E();
        } else if (this.f22641z == 1) {
            H();
        } else {
            D();
        }
    }

    public final void D() {
        this.f22629n.start();
    }

    public final void E() {
        Z(2);
    }

    public void F() {
        int i10 = this.f22641z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        V();
        E();
    }

    public final void G() {
        this.f22627l.start();
        U(this.f22636u, 2000L);
    }

    public final void H() {
        this.f22628m.start();
    }

    public boolean I() {
        return this.f22641z == 0 && this.f22616a.j0();
    }

    public void O() {
        this.f22616a.addOnLayoutChangeListener(this.f22639x);
    }

    public void P() {
        this.f22616a.removeOnLayoutChangeListener(this.f22639x);
    }

    public void Q(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.f22617b;
        if (view != null) {
            view.layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    public final void R(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        boolean e02 = e0();
        if (this.A != e02) {
            this.A = e02;
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.d0
                @Override // java.lang.Runnable
                public final void run() {
                    h0.this.d0();
                }
            });
        }
        boolean z10 = i12 - i10 != i16 - i14;
        if (this.A || !z10) {
            return;
        }
        view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.e0
            @Override // java.lang.Runnable
            public final void run() {
                h0.this.S();
            }
        });
    }

    public final void S() {
        int i10;
        if (this.f22621f == null || this.f22622g == null) {
            return;
        }
        int width = (this.f22616a.getWidth() - this.f22616a.getPaddingLeft()) - this.f22616a.getPaddingRight();
        while (true) {
            if (this.f22622g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f22622g.getChildCount() - 2;
            View childAt = this.f22622g.getChildAt(childCount);
            this.f22622g.removeViewAt(childCount);
            this.f22621f.addView(childAt, 0);
        }
        View view = this.f22626k;
        if (view != null) {
            view.setVisibility(8);
        }
        int B = B(this.f22624i);
        int childCount2 = this.f22621f.getChildCount() - 1;
        for (int i11 = 0; i11 < childCount2; i11++) {
            B += B(this.f22621f.getChildAt(i11));
        }
        if (B > width) {
            View view2 = this.f22626k;
            if (view2 != null) {
                view2.setVisibility(0);
                B += B(this.f22626k);
            }
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt2 = this.f22621f.getChildAt(i12);
                B -= B(childAt2);
                arrayList.add(childAt2);
                if (B <= width) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f22621f.removeViews(0, arrayList.size());
            for (i10 = 0; i10 < arrayList.size(); i10++) {
                this.f22622g.addView((View) arrayList.get(i10), this.f22622g.getChildCount() - 1);
            }
            return;
        }
        ViewGroup viewGroup = this.f22623h;
        if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f22633r.isStarted()) {
            return;
        }
        this.f22632q.cancel();
        this.f22633r.start();
    }

    public final void T(View view) {
        W();
        if (view.getId() == R$id.exo_overflow_show) {
            this.f22632q.start();
        } else if (view.getId() == R$id.exo_overflow_hide) {
            this.f22633r.start();
        }
    }

    public final void U(Runnable runnable, long j10) {
        if (j10 >= 0) {
            this.f22616a.postDelayed(runnable, j10);
        }
    }

    public void V() {
        this.f22616a.removeCallbacks(this.f22638w);
        this.f22616a.removeCallbacks(this.f22635t);
        this.f22616a.removeCallbacks(this.f22637v);
        this.f22616a.removeCallbacks(this.f22636u);
    }

    public void W() {
        if (this.f22641z == 3) {
            return;
        }
        V();
        int showTimeoutMs = this.f22616a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                U(this.f22638w, showTimeoutMs);
            } else if (this.f22641z == 1) {
                U(this.f22636u, 2000L);
            } else {
                U(this.f22637v, showTimeoutMs);
            }
        }
    }

    public void X(boolean z10) {
        this.C = z10;
    }

    public void Y(@Nullable View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (!z10) {
            view.setVisibility(8);
            this.f22640y.remove(view);
            return;
        }
        if (this.A && a0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f22640y.add(view);
    }

    public final void Z(int i10) {
        int i11 = this.f22641z;
        this.f22641z = i10;
        if (i10 == 2) {
            this.f22616a.setVisibility(8);
        } else if (i11 == 2) {
            this.f22616a.setVisibility(0);
        }
        if (i11 != i10) {
            this.f22616a.k0();
        }
    }

    public final boolean a0(View view) {
        int id2 = view.getId();
        return id2 == R$id.exo_bottom_bar || id2 == R$id.exo_prev || id2 == R$id.exo_next || id2 == R$id.exo_rew || id2 == R$id.exo_rew_with_amount || id2 == R$id.exo_ffwd || id2 == R$id.exo_ffwd_with_amount;
    }

    public void b0() {
        if (!this.f22616a.j0()) {
            this.f22616a.setVisibility(0);
            this.f22616a.u0();
            this.f22616a.p0();
        }
        c0();
    }

    public final void c0() {
        if (!this.C) {
            Z(0);
            W();
            return;
        }
        int i10 = this.f22641z;
        if (i10 == 1) {
            this.f22630o.start();
        } else if (i10 == 2) {
            this.f22631p.start();
        } else if (i10 == 3) {
            this.B = true;
        } else if (i10 == 4) {
            return;
        }
        W();
    }

    public final void d0() {
        ViewGroup viewGroup = this.f22620e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        View view = this.f22625j;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.f22616a.getResources().getDimensionPixelSize(R$dimen.exo_styled_progress_margin_bottom);
            if (this.A) {
                dimensionPixelSize = 0;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.f22625j.setLayoutParams(marginLayoutParams);
            View view2 = this.f22625j;
            if (view2 instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view2;
                if (this.A) {
                    defaultTimeBar.h(true);
                } else {
                    int i10 = this.f22641z;
                    if (i10 == 1) {
                        defaultTimeBar.h(false);
                    } else if (i10 != 3) {
                        defaultTimeBar.s();
                    }
                }
            }
        }
        for (View view3 : this.f22640y) {
            view3.setVisibility((this.A && a0(view3)) ? 4 : 0);
        }
    }

    public final boolean e0() {
        int width = (this.f22616a.getWidth() - this.f22616a.getPaddingLeft()) - this.f22616a.getPaddingRight();
        int height = (this.f22616a.getHeight() - this.f22616a.getPaddingBottom()) - this.f22616a.getPaddingTop();
        int B = B(this.f22618c);
        ViewGroup viewGroup = this.f22618c;
        int paddingLeft = B - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f22618c.getPaddingRight() : 0);
        int z10 = z(this.f22618c);
        ViewGroup viewGroup2 = this.f22618c;
        return width <= Math.max(paddingLeft, B(this.f22624i) + B(this.f22626k)) || height <= (z10 - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f22618c.getPaddingBottom() : 0)) + (z(this.f22619d) * 2);
    }

    public final void y(float f10) {
        if (this.f22623h != null) {
            this.f22623h.setTranslationX((int) (r0.getWidth() * (1.0f - f10)));
        }
        ViewGroup viewGroup = this.f22624i;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f10);
        }
        ViewGroup viewGroup2 = this.f22621f;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f10);
        }
    }
}
