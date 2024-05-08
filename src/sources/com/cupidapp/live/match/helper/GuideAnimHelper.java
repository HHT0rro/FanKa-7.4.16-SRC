package com.cupidapp.live.match.helper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: GuideAnimHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GuideAnimHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuideAnimHelper f16763a = new GuideAnimHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Lazy f16764b = kotlin.c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.match.helper.GuideAnimHelper$alphaChangeToShow$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f);
        }
    });

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Lazy f16765c = kotlin.c.b(new Function0<PropertyValuesHolder>() { // from class: com.cupidapp.live.match.helper.GuideAnimHelper$alphaRevert$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyValuesHolder invoke() {
            return PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public static boolean f16766d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static AnimatorSet f16767e;

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f16768b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f16769c;

        public a(AnimatorSet animatorSet, Function0 function0) {
            this.f16768b = animatorSet;
            this.f16769c = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            this.f16768b.removeAllListeners();
            Function0 function0 = this.f16769c;
            if (function0 != null) {
                function0.invoke();
            }
            GuideAnimHelper guideAnimHelper = GuideAnimHelper.f16763a;
            GuideAnimHelper.f16766d = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    public static /* synthetic */ void h(GuideAnimHelper guideAnimHelper, ValueAnimator valueAnimator, long j10, long j11, TimeInterpolator timeInterpolator, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j11 = 0;
        }
        long j12 = j11;
        if ((i10 & 8) != 0) {
            timeInterpolator = null;
        }
        guideAnimHelper.g(valueAnimator, j10, j12, timeInterpolator);
    }

    public final PropertyValuesHolder b() {
        Object value = f16764b.getValue();
        s.h(value, "<get-alphaChangeToShow>(...)");
        return (PropertyValuesHolder) value;
    }

    public final PropertyValuesHolder c() {
        Object value = f16765c.getValue();
        s.h(value, "<get-alphaRevert>(...)");
        return (PropertyValuesHolder) value;
    }

    public final ObjectAnimator d(View view) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(Key.ROTATION, -3.0f, 0.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, h.c(this, 80.0f), 0.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, -h.c(this, 15.0f), 0.0f));
        s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n…ransYRevertCard\n        )");
        h(this, ofPropertyValuesHolder, 600L, 750L, null, 8, null);
        return ofPropertyValuesHolder;
    }

    public final Pair<AnimatorSet, ObjectAnimator> e(View view, ImageView imageView, ImageView imageView2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(Key.ROTATION, 3.0f, -3.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, -h.c(this, 80.0f), h.c(this, 80.0f)), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, -h.c(this, 15.0f), 0.0f, -h.c(this, 15.0f)));
        s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n…     transYCard\n        )");
        h(this, ofPropertyValuesHolder, 600L, 150L, null, 8, null);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(imageView, c());
        s.h(ofPropertyValuesHolder2, "ofPropertyValuesHolder(skipTag, alphaRevert)");
        h(this, ofPropertyValuesHolder2, 450L, 0L, null, 12, null);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(imageView2, b());
        s.h(ofPropertyValuesHolder3, "ofPropertyValuesHolder(likeTag, alphaChangeToShow)");
        h(this, ofPropertyValuesHolder3, 200L, 200L, null, 8, null);
        ObjectAnimator d10 = d(view);
        ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(imageView2, c());
        s.h(ofPropertyValuesHolder4, "ofPropertyValuesHolder(likeTag, alphaRevert)");
        h(this, ofPropertyValuesHolder4, 450L, 900L, null, 8, null);
        animatorSet.play(ofPropertyValuesHolder2).with(ofPropertyValuesHolder3).with(ofPropertyValuesHolder).with(d10).with(ofPropertyValuesHolder4).after(300L);
        return new Pair<>(animatorSet, ofPropertyValuesHolder);
    }

    public final AnimatorSet f(View view, ImageView imageView) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(Key.ROTATION, 0.0f, 3.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, 0.0f, -h.c(this, 80.0f)), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 0.0f, -h.c(this, 15.0f)));
        s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(c…, transXCard, transYCard)");
        h(this, ofPropertyValuesHolder, 450L, 150L, null, 8, null);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(imageView, b());
        s.h(ofPropertyValuesHolder2, "ofPropertyValuesHolder(skipTag, alphaChangeToShow)");
        h(this, ofPropertyValuesHolder2, 200L, 200L, null, 8, null);
        animatorSet.play(ofPropertyValuesHolder).with(ofPropertyValuesHolder2);
        return animatorSet;
    }

    public final void g(ValueAnimator valueAnimator, long j10, long j11, TimeInterpolator timeInterpolator) {
        valueAnimator.setRepeatMode(2);
        valueAnimator.setDuration(j10);
        valueAnimator.setStartDelay(j11);
        if (timeInterpolator != null) {
            valueAnimator.setInterpolator(timeInterpolator);
        }
    }

    public final void i(@NotNull View card, @Nullable Function0<p> function0) {
        s.i(card, "card");
        if (f16766d) {
            return;
        }
        f16766d = true;
        ImageView imageView = (ImageView) card.findViewById(2131365026);
        ImageView imageView2 = (ImageView) card.findViewById(2131366508);
        AnimatorSet animatorSet = f16767e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        f16767e = animatorSet2;
        AnimatorSet f10 = f(card, imageView);
        Pair<AnimatorSet, ObjectAnimator> e2 = e(card, imageView, imageView2);
        AnimatorSet component1 = e2.component1();
        e2.component2();
        animatorSet2.addListener(new a(animatorSet2, function0));
        animatorSet2.playSequentially(f10, component1);
        animatorSet2.start();
    }
}
