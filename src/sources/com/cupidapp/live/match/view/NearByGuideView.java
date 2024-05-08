package com.cupidapp.live.match.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByGuideView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByGuideView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public q f16983b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AnimatorSet f16984c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16985d;

    /* compiled from: NearByGuideView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            NearByGuideView.this.setVisibility(4);
            FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) NearByGuideView.this.a(R$id.near_guide_lottie);
            if (fKLottieAnimationView != null) {
                fKLottieAnimationView.M();
            }
            q qVar = NearByGuideView.this.f16983b;
            if (qVar != null) {
                qVar.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            NearByGuideView.this.setVisibility(0);
        }
    }

    /* compiled from: NearByGuideView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f16988c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f16989d;

        public b(int i10, View view) {
            this.f16988c = i10;
            this.f16989d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            ((FKLottieAnimationView) NearByGuideView.this.a(R$id.near_guide_lottie)).L();
            NearByGuideView.this.g(this.f16988c, this.f16989d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            NearByGuideView.this.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByGuideView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16985d = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16985d;
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

    public final void d(@NotNull ImageModel avatar, int i10, @Nullable View view, @NotNull q listener) {
        kotlin.jvm.internal.s.i(avatar, "avatar");
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f16983b = listener;
        ImageLoaderView near_guide_avatar = (ImageLoaderView) a(R$id.near_guide_avatar);
        kotlin.jvm.internal.s.h(near_guide_avatar, "near_guide_avatar");
        ImageLoaderView.g(near_guide_avatar, avatar, null, null, 6, null);
        h(i10, view);
    }

    public final void e() {
        AnimatorSet animatorSet = this.f16984c;
        if (animatorSet != null) {
            animatorSet.setStartDelay(0L);
        }
        AnimatorSet animatorSet2 = this.f16984c;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    public final void f() {
        z0.z.a(this, R$layout.view_nearby_guide, true);
        setVisibility(4);
    }

    public final void g(int i10, View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i11 = R$id.near_guide_avatar_root;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((FrameLayout) a(i11), (Property<FrameLayout, Float>) FrameLayout.SCALE_X, 1.0f, 1.2f, 0.6f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((FrameLayout) a(i11), (Property<FrameLayout, Float>) FrameLayout.SCALE_Y, 1.0f, 1.2f, 0.6f, 0.0f);
        if (view == null) {
            animatorSet.play(ofFloat).with(ofFloat2);
        } else {
            animatorSet.play(ofFloat).with(ofFloat2).with(ObjectAnimator.ofFloat(view, FrameLayout.SCALE_X, 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(view, FrameLayout.SCALE_Y, 0.0f, 1.0f));
        }
        animatorSet.setDuration(300L);
        this.f16984c = animatorSet;
        animatorSet.setStartDelay((i10 * 1000) - 300);
        AnimatorSet animatorSet2 = this.f16984c;
        if (animatorSet2 != null) {
            animatorSet2.addListener(new a());
        }
        AnimatorSet animatorSet3 = this.f16984c;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    public final void h(int i10, View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i11 = R$id.near_guide_avatar_root;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((FrameLayout) a(i11), (Property<FrameLayout, Float>) FrameLayout.SCALE_X, 0.0f, 0.6f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((FrameLayout) a(i11), (Property<FrameLayout, Float>) FrameLayout.SCALE_Y, 0.0f, 0.6f, 1.2f, 1.0f);
        if (view == null) {
            animatorSet.play(ofFloat).with(ofFloat2);
        } else {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, FrameLayout.SCALE_X, 1.0f, 0.0f);
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ObjectAnimator.ofFloat(view, FrameLayout.SCALE_Y, 1.0f, 0.0f));
        }
        animatorSet.setDuration(300L);
        animatorSet.addListener(new b(i10, view));
        animatorSet.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) a(R$id.near_guide_lottie);
        if (fKLottieAnimationView != null) {
            fKLottieAnimationView.M();
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16985d = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16985d = new LinkedHashMap();
        f();
    }
}
