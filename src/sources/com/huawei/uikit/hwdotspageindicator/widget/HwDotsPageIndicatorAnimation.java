package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwDotsPageIndicatorAnimation implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35046a = "DotIndicatorAnimation";

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f35047b = false;

    /* renamed from: c, reason: collision with root package name */
    public static final int f35048c = 2;

    /* renamed from: d, reason: collision with root package name */
    public ValueAnimator f35049d;

    /* renamed from: e, reason: collision with root package name */
    public ValueAnimator f35050e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<Integer, ValueAnimator> f35051f;

    /* renamed from: g, reason: collision with root package name */
    public ConcurrentHashMap<Integer, ValueAnimator> f35052g;

    /* renamed from: h, reason: collision with root package name */
    public ValueAnimator f35053h;

    /* renamed from: i, reason: collision with root package name */
    public ValueAnimator f35054i;

    /* renamed from: j, reason: collision with root package name */
    public ValueAnimator f35055j;

    /* renamed from: k, reason: collision with root package name */
    public ValueAnimator f35056k;

    /* renamed from: l, reason: collision with root package name */
    public ValueAnimator f35057l;

    /* renamed from: m, reason: collision with root package name */
    public SpringAnimation f35058m;

    /* renamed from: n, reason: collision with root package name */
    public final ConcurrentHashMap<Animator, List<AnimationStateListener>> f35059n = new ConcurrentHashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class AnimationStateListener {
        public void a() {
        }

        public void a(float f10) {
        }

        public void b() {
        }

        public void c() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AnimationUpdateListener {
        void onAnimationUpdate(t tVar);

        void onDotCenterChanged(float[] fArr);

        void onFocusDotChanged(boolean z10, float f10);

        void onFocusSingleScaled(RectF rectF);

        void onSingleScaled(boolean z10, int i10, float f10);

        void onSpringAnimationUpdate(boolean z10, float f10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Options {

        /* renamed from: a, reason: collision with root package name */
        public final t f35060a;

        /* renamed from: b, reason: collision with root package name */
        public final t f35061b;

        /* renamed from: c, reason: collision with root package name */
        public final float f35062c;

        /* renamed from: d, reason: collision with root package name */
        public final float f35063d;

        /* renamed from: e, reason: collision with root package name */
        public final float[] f35064e;

        /* renamed from: f, reason: collision with root package name */
        public final float[] f35065f;

        /* renamed from: g, reason: collision with root package name */
        public final float f35066g;

        /* renamed from: h, reason: collision with root package name */
        public final float f35067h;

        /* renamed from: i, reason: collision with root package name */
        public final RectF f35068i;

        /* renamed from: j, reason: collision with root package name */
        public final RectF f35069j;

        /* renamed from: k, reason: collision with root package name */
        public final float f35070k;

        /* renamed from: l, reason: collision with root package name */
        public final float f35071l;

        /* renamed from: m, reason: collision with root package name */
        public final long f35072m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeInterpolator f35073n;

        /* renamed from: o, reason: collision with root package name */
        public final AnimationUpdateListener f35074o;

        /* renamed from: p, reason: collision with root package name */
        public final AnimationStateListener f35075p;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            public float f35076a;

            /* renamed from: b, reason: collision with root package name */
            public float f35077b;

            /* renamed from: c, reason: collision with root package name */
            public float[] f35078c;

            /* renamed from: d, reason: collision with root package name */
            public float[] f35079d;

            /* renamed from: e, reason: collision with root package name */
            public float f35080e;

            /* renamed from: f, reason: collision with root package name */
            public float f35081f;

            /* renamed from: g, reason: collision with root package name */
            public float f35082g;

            /* renamed from: h, reason: collision with root package name */
            public float f35083h;

            /* renamed from: i, reason: collision with root package name */
            public long f35084i;

            /* renamed from: j, reason: collision with root package name */
            public RectF f35085j;

            /* renamed from: k, reason: collision with root package name */
            public RectF f35086k;

            /* renamed from: l, reason: collision with root package name */
            public t f35087l;

            /* renamed from: m, reason: collision with root package name */
            public t f35088m;

            /* renamed from: n, reason: collision with root package name */
            public TimeInterpolator f35089n;

            /* renamed from: o, reason: collision with root package name */
            public AnimationUpdateListener f35090o;

            /* renamed from: p, reason: collision with root package name */
            public AnimationStateListener f35091p;

            public Options create() {
                return new Options(this);
            }

            public float getDamping() {
                return this.f35083h;
            }

            public long getDuration() {
                return this.f35084i;
            }

            public t getEndEntity() {
                return this.f35088m;
            }

            public TimeInterpolator getInterpolator() {
                return this.f35089n;
            }

            public float[] getStartCenterXs() {
                return this.f35078c;
            }

            public t getStartEntity() {
                return this.f35087l;
            }

            public RectF getStartFocusRectF() {
                return this.f35085j;
            }

            public float getStartLoc() {
                return this.f35080e;
            }

            public float getStartRadius() {
                return this.f35076a;
            }

            public AnimationStateListener getStateListener() {
                return this.f35091p;
            }

            public float getStiffness() {
                return this.f35082g;
            }

            public float[] getTargetCenterXs() {
                return this.f35079d;
            }

            public RectF getTargetFocusRectF() {
                return this.f35086k;
            }

            public float getTargetLoc() {
                return this.f35081f;
            }

            public float getTargetRadius() {
                return this.f35077b;
            }

            public AnimationUpdateListener getUpdateListener() {
                return this.f35090o;
            }

            public Builder setDamping(@FloatRange(from = 0.0d) float f10) {
                this.f35083h = f10;
                return this;
            }

            public Builder setDuration(long j10) {
                this.f35084i = j10;
                return this;
            }

            public Builder setEndEntity(@NonNull t tVar) {
                this.f35088m = tVar;
                return this;
            }

            public Builder setInterpolator(@NonNull TimeInterpolator timeInterpolator) {
                this.f35089n = timeInterpolator;
                return this;
            }

            public Builder setStartCenterXs(@NonNull float[] fArr) {
                this.f35078c = fArr;
                return this;
            }

            public Builder setStartEntity(@NonNull t tVar) {
                this.f35087l = tVar;
                return this;
            }

            public Builder setStartFocusRectF(@NonNull RectF rectF) {
                this.f35085j = rectF;
                return this;
            }

            public Builder setStartLoc(@FloatRange(from = 0.0d) float f10) {
                this.f35080e = f10;
                return this;
            }

            public Builder setStartRadius(@FloatRange(from = 0.0d) float f10) {
                this.f35076a = f10;
                return this;
            }

            public Builder setStateListener(AnimationStateListener animationStateListener) {
                this.f35091p = animationStateListener;
                return this;
            }

            public Builder setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
                this.f35082g = f10;
                return this;
            }

            public Builder setTargetCenterXs(@NonNull float[] fArr) {
                this.f35079d = fArr;
                return this;
            }

            public Builder setTargetFocusRectF(@NonNull RectF rectF) {
                this.f35086k = rectF;
                return this;
            }

            public Builder setTargetLoc(@FloatRange(from = 0.0d) float f10) {
                this.f35081f = f10;
                return this;
            }

            public Builder setTargetRadius(@FloatRange(from = 0.0d) float f10) {
                this.f35077b = f10;
                return this;
            }

            public Builder setUpdateListener(AnimationUpdateListener animationUpdateListener) {
                this.f35090o = animationUpdateListener;
                return this;
            }
        }

        public Options(@NonNull Builder builder) {
            this.f35060a = builder.getStartEntity();
            this.f35061b = builder.getEndEntity();
            this.f35062c = builder.getStartRadius();
            this.f35063d = builder.getTargetRadius();
            this.f35064e = builder.getStartCenterXs();
            this.f35065f = builder.getTargetCenterXs();
            this.f35066g = builder.getStartLoc();
            this.f35067h = builder.getTargetLoc();
            this.f35068i = builder.getStartFocusRectF();
            this.f35069j = builder.getTargetFocusRectF();
            this.f35070k = builder.getStiffness();
            this.f35071l = builder.getDamping();
            this.f35072m = builder.getDuration();
            this.f35073n = builder.getInterpolator();
            this.f35074o = builder.getUpdateListener();
            this.f35075p = builder.getStateListener();
        }

        public float getDamping() {
            return this.f35071l;
        }

        public long getDuration() {
            return this.f35072m;
        }

        public TimeInterpolator getInterpolator() {
            return this.f35073n;
        }

        public float[] getStartCenterXs() {
            return this.f35064e;
        }

        public t getStartEntity() {
            return this.f35060a;
        }

        public RectF getStartFocusRectF() {
            return this.f35068i;
        }

        public float getStartLoc() {
            return this.f35066g;
        }

        public float getStartRadius() {
            return this.f35062c;
        }

        public AnimationStateListener getStateListener() {
            return this.f35075p;
        }

        public float getStiffness() {
            return this.f35070k;
        }

        public float[] getTargetCenterXs() {
            return this.f35065f;
        }

        public t getTargetEntity() {
            return this.f35061b;
        }

        public RectF getTargetFocusRectF() {
            return this.f35069j;
        }

        public float getTargetLoc() {
            return this.f35067h;
        }

        public float getTargetRadius() {
            return this.f35063d;
        }

        public AnimationUpdateListener getUpdateListener() {
            return this.f35074o;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(float f10, float f11, float f12) {
        return ((f11 - f10) * f12) + f10;
    }

    public boolean b(int i10) {
        ValueAnimator valueAnimator;
        ConcurrentHashMap<Integer, ValueAnimator> concurrentHashMap = this.f35051f;
        return (concurrentHashMap == null || (valueAnimator = concurrentHashMap.get(Integer.valueOf(i10))) == null || !valueAnimator.isRunning()) ? false : true;
    }

    @Nullable
    public Animator c() {
        return this.f35053h;
    }

    @Nullable
    public Animator d() {
        return this.f35056k;
    }

    public void e(int i10) {
        if (a(i10)) {
            this.f35052g.get(Integer.valueOf(i10)).cancel();
        }
    }

    @Nullable
    public Animator f() {
        return this.f35050e;
    }

    @Nullable
    public SpringAnimation g() {
        return this.f35058m;
    }

    @Nullable
    public Animator h() {
        return this.f35049d;
    }

    public boolean i() {
        ValueAnimator valueAnimator = this.f35054i;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f35055j;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f35053h;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean l() {
        ValueAnimator valueAnimator = this.f35056k;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean m() {
        ValueAnimator valueAnimator = this.f35057l;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean n() {
        ValueAnimator valueAnimator = this.f35050e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean o() {
        SpringAnimation springAnimation = this.f35058m;
        return springAnimation != null && springAnimation.isRunning();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        List<AnimationStateListener> remove;
        Set<Animator> keySet = this.f35059n.keySet();
        if (keySet == null || keySet.size() == 0) {
            return;
        }
        for (Animator animator2 : keySet) {
            if (animator2 == animator && (remove = this.f35059n.remove(animator2)) != null && remove.size() != 0) {
                Iterator<AnimationStateListener> iterator2 = remove.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().a();
                }
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        List<AnimationStateListener> remove;
        Set<Animator> keySet = this.f35059n.keySet();
        if (keySet == null || keySet.size() == 0) {
            return;
        }
        for (Animator animator2 : keySet) {
            if (animator2 == animator && (remove = this.f35059n.remove(animator2)) != null && remove.size() != 0) {
                Iterator<AnimationStateListener> iterator2 = remove.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().b();
                }
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        List<AnimationStateListener> list;
        Set<Animator> keySet = this.f35059n.keySet();
        if (keySet == null || keySet.size() == 0) {
            return;
        }
        for (Animator animator2 : keySet) {
            if (animator2 == animator && (list = this.f35059n.get(animator2)) != null && list.size() != 0) {
                Iterator<AnimationStateListener> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().c();
                }
            }
        }
    }

    public boolean p() {
        ValueAnimator valueAnimator = this.f35049d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void q() {
        if (i()) {
            this.f35054i.cancel();
        }
    }

    public void r() {
        if (j()) {
            this.f35055j.cancel();
        }
    }

    public void s() {
        if (k()) {
            this.f35053h.cancel();
        }
    }

    public void t() {
        if (l()) {
            this.f35056k.cancel();
        }
    }

    public void u() {
        if (m()) {
            this.f35057l.cancel();
        }
    }

    public void v() {
        if (n()) {
            this.f35050e.cancel();
        }
    }

    public void w() {
        if (o()) {
            this.f35058m.cancel();
        }
    }

    public void x() {
        if (p()) {
            this.f35049d.cancel();
        }
    }

    public void c(int i10) {
        ConcurrentHashMap<Integer, ValueAnimator> concurrentHashMap = this.f35052g;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
        }
    }

    public void d(@NonNull Options options) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f35050e = ofFloat;
        a(ofFloat, options);
    }

    public void f(int i10) {
        if (b(i10)) {
            this.f35051f.get(Integer.valueOf(i10)).cancel();
        }
    }

    public boolean a(int i10) {
        ValueAnimator valueAnimator;
        ConcurrentHashMap<Integer, ValueAnimator> concurrentHashMap = this.f35052g;
        return (concurrentHashMap == null || (valueAnimator = concurrentHashMap.get(Integer.valueOf(i10))) == null || !valueAnimator.isRunning()) ? false : true;
    }

    @Nullable
    public Animator b() {
        return this.f35055j;
    }

    public void c(@NonNull Options options) {
        if (options.getInterpolator() == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f35053h = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f35053h.setDuration(options.getDuration());
        this.f35053h.addListener(this);
        if (options.getStateListener() != null) {
            a(this.f35053h, options.getStateListener());
        }
        this.f35053h.addUpdateListener(new q(this, options, options.getStartLoc(), options.getTargetLoc()));
        this.f35053h.start();
    }

    public void d(int i10) {
        ConcurrentHashMap<Integer, ValueAnimator> concurrentHashMap = this.f35051f;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
        }
    }

    @Nullable
    public Animator e() {
        return this.f35057l;
    }

    private void b(int i10, @NonNull ValueAnimator valueAnimator) {
        if (this.f35051f == null) {
            this.f35051f = new ConcurrentHashMap<>();
        }
        this.f35051f.put(Integer.valueOf(i10), valueAnimator);
    }

    public void e(@NonNull Options options) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f35049d = ofFloat;
        a(ofFloat, options);
    }

    private void a(@NonNull ValueAnimator valueAnimator, @NonNull Options options) {
        t startEntity = options.getStartEntity();
        t targetEntity = options.getTargetEntity();
        if (a(startEntity, targetEntity, options.getInterpolator())) {
            t b4 = startEntity.b();
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new l(this, options, new ArgbEvaluator(), startEntity, targetEntity, b4));
            valueAnimator.addListener(this);
            if (options.getStateListener() != null) {
                a(valueAnimator, options.getStateListener());
            }
            valueAnimator.setDuration(options.getDuration());
            valueAnimator.start();
        }
    }

    public void b(boolean z10, @NonNull Options options) {
        this.f35058m = new SpringAnimation(new FloatValueHolder(options.getStartLoc()));
        float targetLoc = options.getTargetLoc();
        this.f35058m.addUpdateListener(new o(this, options, z10));
        if (options.getStateListener() != null) {
            this.f35058m.addEndListener(new p(this, options));
        }
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(options.getDamping()).setStiffness(options.getStiffness()).setFinalPosition(targetLoc);
        this.f35058m.setSpring(springForce);
        this.f35058m.start();
    }

    private boolean a(t tVar, t tVar2, TimeInterpolator timeInterpolator) {
        if (tVar == null || tVar2 == null || timeInterpolator == null) {
            return false;
        }
        float[] d10 = tVar2.d();
        float[] d11 = tVar.d();
        return (d10 == null || d11 == null || d10.length != d11.length) ? false : true;
    }

    public void b(@NonNull Options options) {
        if (options.getInterpolator() == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f35054i = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f35054i.setDuration(options.f35072m);
        this.f35054i.addListener(this);
        if (options.f35075p != null) {
            a(this.f35054i, options.f35075p);
        }
        this.f35054i.addUpdateListener(new r(this, options, options.getStartLoc(), options.getTargetLoc()));
        this.f35054i.start();
    }

    public void a(boolean z10, @NonNull Options options) {
        RectF startFocusRectF = options.getStartFocusRectF();
        RectF targetFocusRectF = options.getTargetFocusRectF();
        if (startFocusRectF == null || targetFocusRectF == null || options.getInterpolator() == null) {
            return;
        }
        float f10 = startFocusRectF.left;
        float f11 = startFocusRectF.top;
        float f12 = startFocusRectF.right;
        float f13 = startFocusRectF.bottom;
        float f14 = f13 - f11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f14, targetFocusRectF.bottom - targetFocusRectF.top);
        if (z10) {
            this.f35056k = ofFloat;
        } else {
            this.f35057l = ofFloat;
        }
        ofFloat.setInterpolator(options.getInterpolator());
        ofFloat.addUpdateListener(new m(this, f14, new RectF(), f11, f10, f12, f13, options));
        ofFloat.start();
    }

    public void a(int i10, boolean z10, @NonNull Options options) {
        if (options.getInterpolator() == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(options.getStartRadius(), options.getTargetRadius());
        if (z10) {
            a(i10, ofFloat);
        } else {
            b(i10, ofFloat);
        }
        ofFloat.setDuration(options.getDuration());
        ofFloat.setInterpolator(options.getInterpolator());
        ofFloat.addListener(this);
        if (options.getStateListener() != null) {
            a(ofFloat, options.getStateListener());
        }
        ofFloat.addUpdateListener(new n(this, options, z10, i10));
        ofFloat.start();
    }

    private void a(int i10, @NonNull ValueAnimator valueAnimator) {
        if (this.f35052g == null) {
            this.f35052g = new ConcurrentHashMap<>();
        }
        this.f35052g.put(Integer.valueOf(i10), valueAnimator);
    }

    public void a(@NonNull Options options) {
        if (options.getInterpolator() == null) {
            return;
        }
        float[] startCenterXs = options.getStartCenterXs();
        float[] targetCenterXs = options.getTargetCenterXs();
        if (startCenterXs == null || targetCenterXs == null || startCenterXs.length != targetCenterXs.length) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f35055j = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f35055j.setDuration(options.getDuration());
        this.f35055j.addListener(this);
        if (options.f35075p != null) {
            a(this.f35055j, options.f35075p);
        }
        this.f35055j.addUpdateListener(new s(this, options, startCenterXs, targetCenterXs));
        this.f35055j.start();
    }

    public void a(@NonNull Animator animator, @NonNull AnimationStateListener animationStateListener) {
        List<AnimationStateListener> list = this.f35059n.get(animator);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(animationStateListener);
        this.f35059n.put(animator, list);
    }

    public void a(@NonNull Animator animator) {
        this.f35059n.remove(animator);
    }

    public void a() {
        this.f35059n.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Animator animator, float f10) {
        List<AnimationStateListener> list;
        Set<Animator> keySet = this.f35059n.keySet();
        if (keySet == null || keySet.size() == 0) {
            return;
        }
        for (Animator animator2 : keySet) {
            if (animator2 == animator && (list = this.f35059n.get(animator2)) != null && list.size() != 0) {
                Iterator<AnimationStateListener> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().a(f10);
                }
            }
        }
    }
}
