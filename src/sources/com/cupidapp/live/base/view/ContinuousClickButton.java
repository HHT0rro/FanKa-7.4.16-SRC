package com.cupidapp.live.base.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuousClickButton.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ContinuousClickButton extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<kotlin.p> f12426b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function0<kotlin.p> f12427c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AnimatorSet f12428d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public AnimatorSet f12429e;

    /* renamed from: f, reason: collision with root package name */
    public long f12430f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12431g = new LinkedHashMap();

    public ContinuousClickButton(@Nullable Context context) {
        super(context);
        a();
    }

    public final void a() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f12428d = animatorSet;
        AnimatorSet.Builder play = animatorSet.play(ObjectAnimator.ofFloat(this, (Property<ContinuousClickButton, Float>) View.SCALE_X, 1.0f, 0.8f));
        if (play != null) {
            play.with(ObjectAnimator.ofFloat(this, (Property<ContinuousClickButton, Float>) View.SCALE_Y, 1.0f, 0.8f));
        }
        AnimatorSet animatorSet2 = this.f12428d;
        if (animatorSet2 != null) {
            animatorSet2.setDuration(100L);
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f12429e = animatorSet3;
        AnimatorSet.Builder play2 = animatorSet3.play(ObjectAnimator.ofFloat(this, (Property<ContinuousClickButton, Float>) View.SCALE_X, 0.8f, 1.0f));
        if (play2 != null) {
            play2.with(ObjectAnimator.ofFloat(this, (Property<ContinuousClickButton, Float>) View.SCALE_Y, 0.8f, 1.0f));
        }
        AnimatorSet animatorSet4 = this.f12429e;
        if (animatorSet4 == null) {
            return;
        }
        animatorSet4.setDuration(100L);
    }

    @Nullable
    public final Function0<kotlin.p> getContinuousClickFunction() {
        return this.f12426b;
    }

    @Nullable
    public final AnimatorSet getDownAnimator() {
        return this.f12428d;
    }

    public final long getLastClickTime() {
        return this.f12430f;
    }

    @Nullable
    public final Function0<kotlin.p> getStopContinuousClickCallback() {
        return this.f12427c;
    }

    @Nullable
    public final AnimatorSet getUpAnimator() {
        return this.f12429e;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        int action = event.getAction();
        if (action == 0) {
            AnimatorSet animatorSet = this.f12429e;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.f12428d;
            if (animatorSet2 != null) {
                animatorSet2.start();
            }
        } else if (action == 1) {
            AnimatorSet animatorSet3 = this.f12428d;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.f12429e;
            if (animatorSet4 != null) {
                animatorSet4.start();
            }
            if (this.f12430f != 0 && System.currentTimeMillis() - this.f12430f <= 1000) {
                this.f12430f = 0L;
            } else {
                this.f12430f = System.currentTimeMillis();
                Function0<kotlin.p> function0 = this.f12426b;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
        return true;
    }

    public final void setContinuousClickFunction(@Nullable Function0<kotlin.p> function0) {
        this.f12426b = function0;
    }

    public final void setDownAnimator(@Nullable AnimatorSet animatorSet) {
        this.f12428d = animatorSet;
    }

    public final void setLastClickTime(long j10) {
        this.f12430f = j10;
    }

    public final void setStopContinuousClickCallback(@Nullable Function0<kotlin.p> function0) {
        this.f12427c = function0;
    }

    public final void setUpAnimator(@Nullable AnimatorSet animatorSet) {
        this.f12429e = animatorSet;
    }

    public ContinuousClickButton(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ContinuousClickButton(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
