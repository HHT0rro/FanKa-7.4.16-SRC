package com.cupidapp.live.chat.viewholder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKNewMatchShakeAnimationUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f13260a = new a();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static AnimatorSet f13261b;

    /* compiled from: FKNewMatchShakeAnimationUtil.kt */
    @d
    /* renamed from: com.cupidapp.live.chat.viewholder.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0151a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f13262b;

        public C0151a(View view) {
            this.f13262b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            ((ImageView) this.f13262b.findViewById(R$id.new_match_gradient_strip)).setVisibility(8);
            ((ImageView) this.f13262b.findViewById(R$id.new_match_mark)).setVisibility(8);
        }
    }

    /* compiled from: FKNewMatchShakeAnimationUtil.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f13263b;

        public b(View view) {
            this.f13263b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            ((ImageView) this.f13263b.findViewById(R$id.new_match_mark)).setVisibility(0);
        }
    }

    /* compiled from: FKNewMatchShakeAnimationUtil.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f13264b;

        public c(View view) {
            this.f13264b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            ((TextView) this.f13264b.findViewById(R$id.new_match_user_name)).setVisibility(0);
            ((TextView) this.f13264b.findViewById(R$id.new_match_tag)).setVisibility(0);
            ((ImageView) this.f13264b.findViewById(R$id.new_match_gradient_strip)).setVisibility(0);
            this.f13264b.findViewById(R$id.new_match_gradient_mask).setVisibility(0);
        }
    }

    public final void a(@NotNull View itemView) {
        s.i(itemView, "itemView");
        AnimatorSet animatorSet = f13261b;
        if (animatorSet != null && animatorSet.isRunning()) {
            return;
        }
        int i10 = R$id.new_match_user_name;
        ((TextView) itemView.findViewById(i10)).setVisibility(4);
        int i11 = R$id.new_match_tag;
        ((TextView) itemView.findViewById(i11)).setVisibility(4);
        int i12 = R$id.new_match_gradient_strip;
        ((ImageView) itemView.findViewById(i12)).setVisibility(4);
        int i13 = R$id.new_match_mark;
        ((ImageView) itemView.findViewById(i13)).setVisibility(4);
        itemView.findViewById(R$id.new_match_gradient_mask).setVisibility(4);
        AnimatorSet animatorSet2 = new AnimatorSet();
        int i14 = R$id.new_match_user_avatar_image;
        animatorSet2.play(ObjectAnimator.ofFloat((ImageLoaderView) itemView.findViewById(i14), (Property<ImageLoaderView, Float>) View.SCALE_X, 1.0f, 1.1f)).with(ObjectAnimator.ofFloat((ImageLoaderView) itemView.findViewById(i14), (Property<ImageLoaderView, Float>) View.SCALE_Y, 1.0f, 1.1f));
        animatorSet2.setDuration(100L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageLoaderView) itemView.findViewById(i14), (Property<ImageLoaderView, Float>) View.ROTATION, 0.0f, 2.0f, -2.0f, 2.0f, -2.0f, 2.0f, 0.0f);
        ofFloat.setDuration(396L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(ObjectAnimator.ofFloat((ImageLoaderView) itemView.findViewById(i14), (Property<ImageLoaderView, Float>) View.SCALE_X, 1.1f, 1.0f)).with(ObjectAnimator.ofFloat((ImageLoaderView) itemView.findViewById(i14), (Property<ImageLoaderView, Float>) View.SCALE_Y, 1.1f, 1.0f));
        animatorSet3.setStartDelay(396L);
        animatorSet3.setDuration(100L);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.play(animatorSet2).with(ofFloat).with(animatorSet3);
        animatorSet4.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.play(ObjectAnimator.ofFloat((ImageView) itemView.findViewById(i12), (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f)).with(ObjectAnimator.ofFloat((ImageView) itemView.findViewById(i12), (Property<ImageView, Float>) View.SCALE_X, 0.15f, 1.0f)).with(ObjectAnimator.ofFloat((TextView) itemView.findViewById(i10), (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f)).with(ObjectAnimator.ofFloat((TextView) itemView.findViewById(i11), (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f));
        animatorSet5.setDuration(350L);
        animatorSet5.setInterpolator(new DecelerateInterpolator());
        animatorSet5.addListener(new c(itemView));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((ImageView) itemView.findViewById(i13), (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat2.setStartDelay(300L);
        ofFloat2.setDuration(150L);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        ofFloat2.addListener(new b(itemView));
        AnimatorSet animatorSet6 = new AnimatorSet();
        animatorSet6.play(ObjectAnimator.ofFloat((ImageView) itemView.findViewById(i12), (Property<ImageView, Float>) View.ALPHA, 1.0f, 0.0f)).with(ObjectAnimator.ofFloat((ImageView) itemView.findViewById(i13), (Property<ImageView, Float>) View.ALPHA, 1.0f, 0.0f));
        animatorSet6.setStartDelay(2700L);
        animatorSet6.setDuration(150L);
        animatorSet6.setInterpolator(new DecelerateInterpolator());
        animatorSet6.addListener(new C0151a(itemView));
        AnimatorSet animatorSet7 = new AnimatorSet();
        f13261b = animatorSet7;
        s.f(animatorSet7);
        animatorSet7.play(animatorSet4).before(animatorSet5).before(ofFloat2).with(animatorSet6);
        AnimatorSet animatorSet8 = f13261b;
        s.f(animatorSet8);
        animatorSet8.start();
    }
}
