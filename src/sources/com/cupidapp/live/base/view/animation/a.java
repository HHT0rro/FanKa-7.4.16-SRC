package com.cupidapp.live.base.view.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLottieAnimationView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: FKLottieAnimationView.kt */
    @d
    /* renamed from: com.cupidapp.live.base.view.animation.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0145a {
        public static void a(@NotNull a aVar, @NotNull Animator animation) {
            s.i(animation, "animation");
        }

        public static void b(@NotNull a aVar, @Nullable Animator animator) {
        }

        public static void c(@NotNull a aVar, @Nullable Animator animator) {
        }

        public static void d(@NotNull a aVar, @NotNull Animator animation) {
            s.i(animation, "animation");
        }

        public static void e(@NotNull a aVar, @Nullable Animator animator) {
        }

        public static void f(@NotNull a aVar, @Nullable Animator animator) {
        }

        public static void g(@NotNull a aVar, @NotNull ValueAnimator animation) {
            s.i(animation, "animation");
        }
    }

    void onAnimationCancel(@NotNull Animator animator);

    void onAnimationEnd(@Nullable Animator animator);

    void onAnimationPause(@Nullable Animator animator);

    void onAnimationRepeat(@NotNull Animator animator);

    void onAnimationResume(@Nullable Animator animator);

    void onAnimationStart(@Nullable Animator animator);

    void onAnimationUpdate(@NotNull ValueAnimator valueAnimator);
}
