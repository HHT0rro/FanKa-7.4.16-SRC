package com.cupidapp.live.base.view.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: BoostRippleLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BoostRippleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f12593b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f12594c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f12595d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f12596e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final AnimatorSet f12597f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12598g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoostRippleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12598g = new LinkedHashMap();
        this.f12593b = c.b(BoostRippleLayout$innerAlpha$2.INSTANCE);
        this.f12594c = c.b(BoostRippleLayout$outerAlpha$2.INSTANCE);
        this.f12595d = c.b(BoostRippleLayout$scaleX$2.INSTANCE);
        this.f12596e = c.b(BoostRippleLayout$scaleY$2.INSTANCE);
        this.f12597f = new AnimatorSet();
        b();
    }

    private final PropertyValuesHolder getInnerAlpha() {
        Object value = this.f12593b.getValue();
        s.h(value, "<get-innerAlpha>(...)");
        return (PropertyValuesHolder) value;
    }

    private final PropertyValuesHolder getOuterAlpha() {
        Object value = this.f12594c.getValue();
        s.h(value, "<get-outerAlpha>(...)");
        return (PropertyValuesHolder) value;
    }

    private final PropertyValuesHolder getScaleX() {
        Object value = this.f12595d.getValue();
        s.h(value, "<get-scaleX>(...)");
        return (PropertyValuesHolder) value;
    }

    private final PropertyValuesHolder getScaleY() {
        Object value = this.f12596e.getValue();
        s.h(value, "<get-scaleY>(...)");
        return (PropertyValuesHolder) value;
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12598g;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b() {
        z.a(this, R$layout.view_boost_ripple, true);
        int i10 = R$id.inner_ripple;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(a(i10), getInnerAlpha());
        s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(inner_ripple, innerAlpha)");
        c(ofPropertyValuesHolder, 1000L, 0L);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(a(i10), getScaleX());
        s.h(ofPropertyValuesHolder2, "ofPropertyValuesHolder(inner_ripple, scaleX)");
        c(ofPropertyValuesHolder2, 1000L, 0L);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(a(i10), getScaleY());
        s.h(ofPropertyValuesHolder3, "ofPropertyValuesHolder(inner_ripple, scaleY)");
        c(ofPropertyValuesHolder3, 1000L, 0L);
        int i11 = R$id.outer_ripple;
        ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(a(i11), getOuterAlpha());
        s.h(ofPropertyValuesHolder4, "ofPropertyValuesHolder(outer_ripple, outerAlpha)");
        c(ofPropertyValuesHolder4, 1000L, 500L);
        ObjectAnimator ofPropertyValuesHolder5 = ObjectAnimator.ofPropertyValuesHolder(a(i11), getScaleX());
        s.h(ofPropertyValuesHolder5, "ofPropertyValuesHolder(outer_ripple, scaleX)");
        c(ofPropertyValuesHolder5, 1000L, 500L);
        ObjectAnimator ofPropertyValuesHolder6 = ObjectAnimator.ofPropertyValuesHolder(a(i11), getScaleY());
        s.h(ofPropertyValuesHolder6, "ofPropertyValuesHolder(outer_ripple, scaleY)");
        c(ofPropertyValuesHolder6, 1000L, 500L);
        this.f12597f.playTogether(ofPropertyValuesHolder, ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder4, ofPropertyValuesHolder5, ofPropertyValuesHolder6);
    }

    public final void c(ValueAnimator valueAnimator, long j10, long j11) {
        valueAnimator.setDuration(j10);
        valueAnimator.setStartDelay(j11);
    }

    @NotNull
    public final AnimatorSet getAnimSet() {
        return this.f12597f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoostRippleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12598g = new LinkedHashMap();
        this.f12593b = c.b(BoostRippleLayout$innerAlpha$2.INSTANCE);
        this.f12594c = c.b(BoostRippleLayout$outerAlpha$2.INSTANCE);
        this.f12595d = c.b(BoostRippleLayout$scaleX$2.INSTANCE);
        this.f12596e = c.b(BoostRippleLayout$scaleY$2.INSTANCE);
        this.f12597f = new AnimatorSet();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoostRippleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12598g = new LinkedHashMap();
        this.f12593b = c.b(BoostRippleLayout$innerAlpha$2.INSTANCE);
        this.f12594c = c.b(BoostRippleLayout$outerAlpha$2.INSTANCE);
        this.f12595d = c.b(BoostRippleLayout$scaleX$2.INSTANCE);
        this.f12596e = c.b(BoostRippleLayout$scaleY$2.INSTANCE);
        this.f12597f = new AnimatorSet();
        b();
    }
}
