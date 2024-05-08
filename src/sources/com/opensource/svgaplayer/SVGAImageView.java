package com.opensource.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.opensource.svgaplayer.SVGAParser;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVGAImageView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SVGAImageView extends ImageView {

    /* renamed from: b, reason: collision with root package name */
    public final String f37882b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f37883c;

    /* renamed from: d, reason: collision with root package name */
    public int f37884d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f37885e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f37886f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public FillMode f37887g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public com.opensource.svgaplayer.b f37888h;

    /* renamed from: i, reason: collision with root package name */
    public ValueAnimator f37889i;

    /* renamed from: j, reason: collision with root package name */
    public com.opensource.svgaplayer.c f37890j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f37891k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f37892l;

    /* renamed from: m, reason: collision with root package name */
    public final a f37893m;

    /* renamed from: n, reason: collision with root package name */
    public final b f37894n;

    /* renamed from: o, reason: collision with root package name */
    public int f37895o;

    /* renamed from: p, reason: collision with root package name */
    public int f37896p;

    /* compiled from: SVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum FillMode {
        Backward,
        Forward,
        Clear
    }

    /* compiled from: SVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<SVGAImageView> f37897b;

        public a(@NotNull SVGAImageView view) {
            s.j(view, "view");
            this.f37897b = new WeakReference<>(view);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animator) {
            SVGAImageView sVGAImageView = this.f37897b.get();
            if (sVGAImageView != null) {
                sVGAImageView.f37883c = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animator) {
            SVGAImageView sVGAImageView = this.f37897b.get();
            if (sVGAImageView != null) {
                sVGAImageView.m(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animator) {
            com.opensource.svgaplayer.b callback;
            SVGAImageView sVGAImageView = this.f37897b.get();
            if (sVGAImageView == null || (callback = sVGAImageView.getCallback()) == null) {
                return;
            }
            callback.c();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animator) {
            SVGAImageView sVGAImageView = this.f37897b.get();
            if (sVGAImageView != null) {
                sVGAImageView.f37883c = true;
            }
        }
    }

    /* compiled from: SVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<SVGAImageView> f37898b;

        public b(@NotNull SVGAImageView view) {
            s.j(view, "view");
            this.f37898b = new WeakReference<>(view);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator valueAnimator) {
            SVGAImageView sVGAImageView = this.f37898b.get();
            if (sVGAImageView != null) {
                sVGAImageView.n(valueAnimator);
            }
        }
    }

    /* compiled from: SVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class c implements SVGAParser.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f37899a;

        public c(WeakReference weakReference) {
            this.f37899a = weakReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void a(@NotNull SVGAVideoEntity videoItem) {
            s.j(videoItem, "videoItem");
            SVGAImageView sVGAImageView = (SVGAImageView) this.f37899a.get();
            if (sVGAImageView != null) {
                sVGAImageView.t(videoItem);
            }
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void onError() {
        }
    }

    /* compiled from: SVGAImageView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class d implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SVGAVideoEntity f37901c;

        public d(SVGAVideoEntity sVGAVideoEntity) {
            this.f37901c = sVGAVideoEntity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f37901c.x(SVGAImageView.this.f37891k);
            SVGAImageView.this.setVideoItem(this.f37901c);
            com.opensource.svgaplayer.d sVGADrawable = SVGAImageView.this.getSVGADrawable();
            if (sVGADrawable != null) {
                ImageView.ScaleType scaleType = SVGAImageView.this.getScaleType();
                s.e(scaleType, "scaleType");
                sVGADrawable.g(scaleType);
            }
            if (SVGAImageView.this.f37892l) {
                SVGAImageView.this.s();
            }
        }
    }

    public SVGAImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    public SVGAImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SVGAImageView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.opensource.svgaplayer.d getSVGADrawable() {
        Drawable drawable = getDrawable();
        if (!(drawable instanceof com.opensource.svgaplayer.d)) {
            drawable = null;
        }
        return (com.opensource.svgaplayer.d) drawable;
    }

    @Nullable
    public final com.opensource.svgaplayer.b getCallback() {
        return this.f37888h;
    }

    public final boolean getClearsAfterDetached() {
        return this.f37886f;
    }

    public final boolean getClearsAfterStop() {
        return this.f37885e;
    }

    @NotNull
    public final FillMode getFillMode() {
        return this.f37887g;
    }

    public final int getLoops() {
        return this.f37884d;
    }

    public final void h() {
        com.opensource.svgaplayer.d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.e(true);
        }
        com.opensource.svgaplayer.d sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 != null) {
            sVGADrawable2.a();
        }
        setImageDrawable(null);
    }

    public final SVGAParser.c i(WeakReference<SVGAImageView> weakReference) {
        return new c(weakReference);
    }

    public final double j() {
        double d10 = 1.0d;
        try {
            Class<?> cls = Class.forName("android.animation.ValueAnimator");
            Method declaredMethod = cls.getDeclaredMethod("getDurationScale", new Class[0]);
            if (declaredMethod == null) {
                return 1.0d;
            }
            Object invoke = declaredMethod.invoke(cls, new Object[0]);
            if (invoke == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
            double floatValue = ((Float) invoke).floatValue();
            if (floatValue != ShadowDrawableWrapper.COS_45) {
                return floatValue;
            }
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("setDurationScale", Float.TYPE);
                if (declaredMethod2 == null) {
                    return floatValue;
                }
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(cls, Float.valueOf(1.0f));
                ub.c.f54010a.e(this.f37882b, "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                return 1.0d;
            } catch (Exception e2) {
                e = e2;
                d10 = floatValue;
                e.printStackTrace();
                return d10;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public final boolean k() {
        return this.f37883c;
    }

    public final void l(AttributeSet attributeSet) {
        Context context = getContext();
        s.e(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SVGAImageView, 0, 0);
        this.f37884d = obtainStyledAttributes.getInt(R$styleable.SVGAImageView_loopCount, 0);
        this.f37885e = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_clearsAfterStop, false);
        this.f37886f = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_clearsAfterDetached, false);
        this.f37891k = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_antiAlias, true);
        this.f37892l = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R$styleable.SVGAImageView_fillMode);
        if (string != null) {
            switch (string.hashCode()) {
                case 48:
                    if (string.equals("0")) {
                        this.f37887g = FillMode.Backward;
                        break;
                    }
                    break;
                case 49:
                    if (string.equals("1")) {
                        this.f37887g = FillMode.Forward;
                        break;
                    }
                    break;
                case 50:
                    if (string.equals("2")) {
                        this.f37887g = FillMode.Clear;
                        break;
                    }
                    break;
            }
        }
        String string2 = obtainStyledAttributes.getString(R$styleable.SVGAImageView_source);
        if (string2 != null) {
            o(string2);
        }
        obtainStyledAttributes.recycle();
    }

    public final void m(Animator animator) {
        this.f37883c = false;
        w();
        com.opensource.svgaplayer.d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            int i10 = f.f38002a[this.f37887g.ordinal()];
            if (i10 == 1) {
                sVGADrawable.f(this.f37895o);
            } else if (i10 == 2) {
                sVGADrawable.f(this.f37896p);
            } else if (i10 == 3) {
                sVGADrawable.e(true);
            }
        }
        com.opensource.svgaplayer.b bVar = this.f37888h;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void n(ValueAnimator valueAnimator) {
        com.opensource.svgaplayer.d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
            if (animatedValue != null) {
                sVGADrawable.f(((Integer) animatedValue).intValue());
                double b4 = (sVGADrawable.b() + 1) / sVGADrawable.d().n();
                com.opensource.svgaplayer.b bVar = this.f37888h;
                if (bVar != null) {
                    bVar.b(sVGADrawable.b(), b4);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public final void o(String str) {
        WeakReference<SVGAImageView> weakReference = new WeakReference<>(this);
        SVGAParser sVGAParser = new SVGAParser(getContext());
        if (!p.F(str, "http://", false, 2, null) && !p.F(str, "https://", false, 2, null)) {
            SVGAParser.o(sVGAParser, str, i(weakReference), null, 4, null);
        } else {
            SVGAParser.u(sVGAParser, new URL(str), i(weakReference), null, 4, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x(this.f37886f);
        if (this.f37886f) {
            h();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        com.opensource.svgaplayer.c cVar;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            com.opensource.svgaplayer.d sVGADrawable = getSVGADrawable();
            if (sVGADrawable != null) {
                for (Map.Entry<String, int[]> entry : sVGADrawable.c().j().entrySet()) {
                    String key = entry.getKey();
                    int[] value = entry.getValue();
                    if (motionEvent.getX() >= value[0] && motionEvent.getX() <= value[2] && motionEvent.getY() >= value[1] && motionEvent.getY() <= value[3] && (cVar = this.f37890j) != null) {
                        cVar.a(key);
                        return true;
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        x(false);
        com.opensource.svgaplayer.b bVar = this.f37888h;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public final void q(tb.c cVar, boolean z10) {
        ub.c.f54010a.e(this.f37882b, "================ start animation ================");
        com.opensource.svgaplayer.d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            r();
            this.f37895o = Math.max(0, 0);
            int min = Math.min(sVGADrawable.d().n() - 1, (Integer.MAX_VALUE + 0) - 1);
            this.f37896p = min;
            ValueAnimator animator = ValueAnimator.ofInt(this.f37895o, min);
            s.e(animator, "animator");
            animator.setInterpolator(new LinearInterpolator());
            animator.setDuration((long) ((((this.f37896p - this.f37895o) + 1) * (1000 / r8.m())) / j()));
            int i10 = this.f37884d;
            animator.setRepeatCount(i10 <= 0 ? 99999 : i10 - 1);
            animator.addUpdateListener(this.f37894n);
            animator.addListener(this.f37893m);
            if (z10) {
                animator.reverse();
            } else {
                animator.start();
            }
            this.f37889i = animator;
        }
    }

    public final void r() {
        com.opensource.svgaplayer.d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.e(false);
            ImageView.ScaleType scaleType = getScaleType();
            s.e(scaleType, "scaleType");
            sVGADrawable.g(scaleType);
        }
    }

    public final void s() {
        u(null, false);
    }

    public final void setCallback(@Nullable com.opensource.svgaplayer.b bVar) {
        this.f37888h = bVar;
    }

    public final void setClearsAfterDetached(boolean z10) {
        this.f37886f = z10;
    }

    public final void setClearsAfterStop(boolean z10) {
        this.f37885e = z10;
    }

    public final void setFillMode(@NotNull FillMode fillMode) {
        s.j(fillMode, "<set-?>");
        this.f37887g = fillMode;
    }

    public final void setLoops(int i10) {
        this.f37884d = i10;
    }

    public final void setOnAnimKeyClickListener(@NotNull com.opensource.svgaplayer.c clickListener) {
        s.j(clickListener, "clickListener");
        this.f37890j = clickListener;
    }

    public final void setVideoItem(@Nullable SVGAVideoEntity sVGAVideoEntity) {
        setVideoItem(sVGAVideoEntity, new e());
    }

    public final void t(SVGAVideoEntity sVGAVideoEntity) {
        post(new d(sVGAVideoEntity));
    }

    public final void u(@Nullable tb.c cVar, boolean z10) {
        x(false);
        q(cVar, z10);
    }

    public final void v(int i10, boolean z10) {
        p();
        com.opensource.svgaplayer.d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.f(i10);
            if (z10) {
                s();
                ValueAnimator valueAnimator = this.f37889i;
                if (valueAnimator != null) {
                    valueAnimator.setCurrentPlayTime(Math.max(0.0f, Math.min(1.0f, i10 / sVGADrawable.d().n())) * ((float) valueAnimator.getDuration()));
                }
            }
        }
    }

    public final void w() {
        x(this.f37885e);
    }

    public final void x(boolean z10) {
        ValueAnimator valueAnimator = this.f37889i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f37889i;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.f37889i;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        com.opensource.svgaplayer.d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.h();
        }
        com.opensource.svgaplayer.d sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 != null) {
            sVGADrawable2.e(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.j(context, "context");
        this.f37882b = "SVGAImageView";
        this.f37887g = FillMode.Forward;
        this.f37891k = true;
        this.f37892l = true;
        this.f37893m = new a(this);
        this.f37894n = new b(this);
        if (attributeSet != null) {
            l(attributeSet);
        }
    }

    public final void setVideoItem(@Nullable SVGAVideoEntity sVGAVideoEntity, @Nullable e eVar) {
        if (sVGAVideoEntity == null) {
            setImageDrawable(null);
            return;
        }
        if (eVar == null) {
            eVar = new e();
        }
        com.opensource.svgaplayer.d dVar = new com.opensource.svgaplayer.d(sVGAVideoEntity, eVar);
        dVar.e(true);
        setImageDrawable(dVar);
    }
}
