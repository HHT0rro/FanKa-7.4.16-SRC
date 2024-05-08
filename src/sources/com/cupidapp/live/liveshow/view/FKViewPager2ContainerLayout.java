package com.cupidapp.live.liveshow.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.cupidapp.live.base.utils.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKViewPager2ContainerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKViewPager2ContainerLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public float f15276b;

    /* renamed from: c, reason: collision with root package name */
    public float f15277c;

    /* renamed from: d, reason: collision with root package name */
    public float f15278d;

    /* renamed from: e, reason: collision with root package name */
    public float f15279e;

    /* renamed from: f, reason: collision with root package name */
    public float f15280f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15281g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public ValueAnimator f15282h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public b f15283i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public VelocityTracker f15284j;

    /* renamed from: k, reason: collision with root package name */
    public int f15285k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15286l;

    /* compiled from: FKViewPager2ContainerLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            if (FKViewPager2ContainerLayout.this.f15281g) {
                if (FKViewPager2ContainerLayout.this.f15280f == 0.0f) {
                    FKViewPager2ContainerLayout.this.f15281g = false;
                    b bVar = FKViewPager2ContainerLayout.this.f15283i;
                    if (bVar != null) {
                        bVar.a(false);
                        return;
                    }
                    return;
                }
            }
            if (FKViewPager2ContainerLayout.this.f15281g) {
                return;
            }
            if (Math.abs(FKViewPager2ContainerLayout.this.f15280f) == ((float) z0.h.l(this))) {
                FKViewPager2ContainerLayout.this.f15281g = true;
                b bVar2 = FKViewPager2ContainerLayout.this.f15283i;
                if (bVar2 != null) {
                    bVar2.a(true);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKViewPager2ContainerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15286l = new LinkedHashMap();
        this.f15285k = 8;
        g();
    }

    public static final void h(FKViewPager2ContainerLayout this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        com.cupidapp.live.base.utils.j.f12332a.a("FKViewPager2ContainerLayout", "addUpdateListener value: " + floatValue + " translateX: " + this$0.f15280f + " endX: " + this$0.f15279e);
        float f10 = this$0.f15280f;
        this$0.j(f10 + ((this$0.f15279e - f10) * floatValue));
    }

    public final void f(boolean z10) {
        com.cupidapp.live.base.utils.j.f12332a.a("FKViewPager2ContainerLayout", "clear: " + z10 + " isCleared: " + this.f15281g);
        if (z10 && !this.f15281g) {
            this.f15279e = z0.h.l(this);
            ValueAnimator valueAnimator = this.f15282h;
            if (valueAnimator != null) {
                valueAnimator.start();
                return;
            }
            return;
        }
        if (z10 || !this.f15281g) {
            return;
        }
        this.f15279e = 0.0f;
        ValueAnimator valueAnimator2 = this.f15282h;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    public final void g() {
        this.f15285k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f15284j = VelocityTracker.obtain();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.liveshow.view.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FKViewPager2ContainerLayout.h(FKViewPager2ContainerLayout.this, valueAnimator);
            }
        });
        ofFloat.addListener(new a());
        this.f15282h = ofFloat;
    }

    public final void i() {
        this.f15281g = false;
        this.f15280f = 0.0f;
    }

    public final void j(float f10) {
        com.cupidapp.live.base.utils.j.f12332a.a("FKViewPager2ContainerLayout", "translate: " + f10);
        this.f15280f = f10;
        b bVar = this.f15283i;
        if (bVar != null) {
            bVar.b(f10);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f15276b = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f15277c = y10;
            com.cupidapp.live.base.utils.j.f12332a.a("FKViewPager2ContainerLayout", "onInterceptTouchEvent ACTION_DOWN mDownX: " + this.f15276b + " mDownY: " + y10);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f15276b);
            float abs2 = Math.abs(motionEvent.getY() - this.f15277c);
            com.cupidapp.live.base.utils.j.f12332a.a("FKViewPager2ContainerLayout", "onInterceptTouchEvent ACTION_MOVE moveDistanceX: " + abs + " moveDistanceY: " + abs2 + "  mTouchSlop:" + this.f15285k);
            ValueAnimator valueAnimator = this.f15282h;
            boolean z10 = false;
            if (valueAnimator != null && !valueAnimator.isRunning()) {
                z10 = true;
            }
            if (z10 && abs > abs2 && abs > this.f15285k) {
                this.f15278d = this.f15280f;
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        boolean z10;
        VelocityTracker velocityTracker;
        if (motionEvent != null && (velocityTracker = this.f15284j) != null) {
            velocityTracker.addMovement(motionEvent);
        }
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        float f10 = 0.0f;
        if (valueOf != null && valueOf.intValue() == 2) {
            float x10 = motionEvent.getX() - this.f15276b;
            com.cupidapp.live.base.utils.j.f12332a.a("FKViewPager2ContainerLayout", "onTouchEvent ACTION_MOVE isCleared: " + this.f15281g + " distanceX: " + x10);
            boolean z11 = this.f15281g;
            if ((z11 && x10 < 0.0f) || (!z11 && x10 > 0.0f)) {
                j(this.f15278d + x10);
            }
            return true;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
            aVar.a("FKViewPager2ContainerLayout", "onTouchEvent ACTION_UP translateX: " + this.f15280f);
            float f11 = this.f15280f;
            if (f11 > 0.0f && f11 < z0.h.l(this)) {
                VelocityTracker velocityTracker2 = this.f15284j;
                if (velocityTracker2 != null) {
                    velocityTracker2.computeCurrentVelocity(10);
                }
                VelocityTracker velocityTracker3 = this.f15284j;
                float xVelocity = velocityTracker3 != null ? velocityTracker3.getXVelocity() : 0.0f;
                aVar.a("velocityTracker", "velocity: " + xVelocity);
                if (Math.abs(motionEvent.getX() - this.f15276b) <= z0.h.l(this) / 3 && ((!(z10 = this.f15281g) || xVelocity >= -20.0f) && (z10 || xVelocity <= 20.0f))) {
                    f10 = this.f15278d;
                } else if (!this.f15281g) {
                    f10 = z0.h.l(this);
                }
                this.f15279e = f10;
                ValueAnimator valueAnimator = this.f15282h;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setClearScreenListener(@NotNull b listener) {
        s.i(listener, "listener");
        this.f15283i = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKViewPager2ContainerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15286l = new LinkedHashMap();
        this.f15285k = 8;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKViewPager2ContainerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15286l = new LinkedHashMap();
        this.f15285k = 8;
        g();
    }
}
