package com.cupidapp.live.login.helper;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LoginAnimationUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f16155a = new d();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static AnimatorSet f16156b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static AnimatorSet f16157c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static AnimatorSet f16158d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static ObjectAnimator f16159e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static AnimatorSet f16160f;

    public final void a(@NotNull List<? extends View> viewList) {
        s.i(viewList, "viewList");
        if (viewList.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = f16156b;
        if (animatorSet != null && animatorSet.isRunning()) {
            return;
        }
        View view = viewList.get(0);
        if (view != null) {
            view.setAlpha(0.0f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(160L);
            AnimatorSet.Builder play = animatorSet2.play(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, z0.h.c(animatorSet2, 21.0f), 0.0f);
            ofFloat2.setDuration(330L);
            play.with(ofFloat2);
            f16157c = animatorSet2;
        }
        View view2 = viewList.get(1);
        if (view2 != null) {
            view2.setAlpha(0.0f);
            AnimatorSet animatorSet3 = new AnimatorSet();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, View.ALPHA, 0.7f, 1.0f);
            ofFloat3.setDuration(200L);
            AnimatorSet.Builder play2 = animatorSet3.play(ofFloat3);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, z0.h.c(animatorSet3, 21.0f), 0.0f);
            ofFloat4.setDuration(330L);
            play2.with(ofFloat4);
            animatorSet3.setStartDelay(60L);
            f16158d = animatorSet3;
        }
        View view3 = viewList.get(2);
        if (view3 != null) {
            view3.setAlpha(0.0f);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view3, View.ALPHA, 0.0f, 1.0f);
            ofFloat5.setDuration(160L);
            f16159e = ofFloat5;
        }
        View view4 = viewList.get(3);
        if (view4 != null) {
            view4.setAlpha(0.0f);
            AnimatorSet animatorSet4 = new AnimatorSet();
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view4, View.ALPHA, 0.0f, 1.0f);
            ofFloat6.setDuration(160L);
            AnimatorSet.Builder play3 = animatorSet4.play(ofFloat6);
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, z0.h.c(animatorSet4, 21.0f), 0.0f);
            ofFloat7.setDuration(330L);
            play3.with(ofFloat7);
            animatorSet4.setStartDelay(120L);
            f16160f = animatorSet4;
        }
        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.setStartDelay(200L);
        animatorSet5.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet6 = f16157c;
        AnimatorSet.Builder play4 = animatorSet6 != null ? animatorSet5.play(animatorSet6) : null;
        AnimatorSet animatorSet7 = f16158d;
        if (animatorSet7 != null && play4 != null) {
            play4.with(animatorSet7);
        }
        ObjectAnimator objectAnimator = f16159e;
        if (objectAnimator != null && play4 != null) {
            play4.with(objectAnimator);
        }
        AnimatorSet animatorSet8 = f16160f;
        if (animatorSet8 != null && play4 != null) {
            play4.with(animatorSet8);
        }
        f16156b = animatorSet5;
        s.f(animatorSet5);
        animatorSet5.start();
    }
}
