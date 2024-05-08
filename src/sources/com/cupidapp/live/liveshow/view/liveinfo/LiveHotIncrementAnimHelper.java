package com.cupidapp.live.liveshow.view.liveinfo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import z0.h;

/* compiled from: LiveHotIncrementAnimHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveHotIncrementAnimHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LiveHotIncrementAnimHelper f15723a = new LiveHotIncrementAnimHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Lazy f15724b = c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.LiveHotIncrementAnimHelper$alphaShowChange$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f);
        }
    });

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Lazy f15725c = c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.LiveHotIncrementAnimHelper$alphaHideChange$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Lazy f15726d = c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.LiveHotIncrementAnimHelper$scaleXShow$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.SCALE_X, 0.0f, 1.2f);
        }
    });

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Lazy f15727e = c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.LiveHotIncrementAnimHelper$scaleYShow$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.0f, 1.2f);
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final Lazy f15728f = c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.LiveHotIncrementAnimHelper$scaleXHide$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f, 1.0f);
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final Lazy f15729g = c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.LiveHotIncrementAnimHelper$scaleYHide$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f, 1.0f);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final Lazy f15730h = c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.LiveHotIncrementAnimHelper$transY$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -h.c(LiveHotIncrementAnimHelper.f15723a, 18.0f));
        }
    });

    public static /* synthetic */ void i(LiveHotIncrementAnimHelper liveHotIncrementAnimHelper, ValueAnimator valueAnimator, long j10, long j11, TimeInterpolator timeInterpolator, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j11 = 0;
        }
        long j12 = j11;
        if ((i10 & 8) != 0) {
            timeInterpolator = null;
        }
        liveHotIncrementAnimHelper.h(valueAnimator, j10, j12, timeInterpolator);
    }

    public final PropertyValuesHolder a() {
        Object value = f15725c.getValue();
        s.h(value, "<get-alphaHideChange>(...)");
        return (PropertyValuesHolder) value;
    }

    public final PropertyValuesHolder b() {
        Object value = f15724b.getValue();
        s.h(value, "<get-alphaShowChange>(...)");
        return (PropertyValuesHolder) value;
    }

    public final PropertyValuesHolder c() {
        Object value = f15728f.getValue();
        s.h(value, "<get-scaleXHide>(...)");
        return (PropertyValuesHolder) value;
    }

    public final PropertyValuesHolder d() {
        Object value = f15726d.getValue();
        s.h(value, "<get-scaleXShow>(...)");
        return (PropertyValuesHolder) value;
    }

    public final PropertyValuesHolder e() {
        Object value = f15729g.getValue();
        s.h(value, "<get-scaleYHide>(...)");
        return (PropertyValuesHolder) value;
    }

    public final PropertyValuesHolder f() {
        Object value = f15727e.getValue();
        s.h(value, "<get-scaleYShow>(...)");
        return (PropertyValuesHolder) value;
    }

    public final PropertyValuesHolder g() {
        Object value = f15730h.getValue();
        s.h(value, "<get-transY>(...)");
        return (PropertyValuesHolder) value;
    }

    public final void h(ValueAnimator valueAnimator, long j10, long j11, TimeInterpolator timeInterpolator) {
        valueAnimator.setRepeatMode(2);
        valueAnimator.setDuration(j10);
        valueAnimator.setStartDelay(j11);
        if (timeInterpolator != null) {
            valueAnimator.setInterpolator(timeInterpolator);
        }
    }

    public final void j(@NotNull View view) {
        s.i(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, b(), f(), d());
        s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(v…, scaleYShow, scaleXShow)");
        i(this, ofPropertyValuesHolder, 200L, 0L, null, 12, null);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, c(), e());
        s.h(ofPropertyValuesHolder2, "ofPropertyValuesHolder(v…, scaleXHide, scaleYHide)");
        i(this, ofPropertyValuesHolder2, 80L, 200L, null, 8, null);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, a());
        s.h(ofPropertyValuesHolder3, "ofPropertyValuesHolder(view, alphaHideChange)");
        i(this, ofPropertyValuesHolder3, 720L, 280L, null, 8, null);
        ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(view, g());
        s.h(ofPropertyValuesHolder4, "ofPropertyValuesHolder(view,transY)");
        i(this, ofPropertyValuesHolder4, 1000L, 0L, null, 12, null);
        animatorSet.playTogether(ofPropertyValuesHolder, ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder4);
        animatorSet.start();
    }
}
