package com.cupidapp.live.base.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.o0;
import com.cupidapp.live.base.utils.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLottieAnimationView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLottieAnimationView extends LottieAnimationView {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final String f12599r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.view.animation.a f12600s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12601t = new LinkedHashMap();

    /* compiled from: FKLottieAnimationView.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            s.i(animation, "animation");
            com.cupidapp.live.base.view.animation.a aVar = FKLottieAnimationView.this.f12600s;
            if (aVar != null) {
                aVar.onAnimationCancel(animation);
            }
            j.f12332a.a(FKLottieAnimationView.this.f12599r, "停止播放 onAnimationCancel " + ((Object) animation));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            com.cupidapp.live.base.view.animation.a aVar = FKLottieAnimationView.this.f12600s;
            if (aVar != null) {
                aVar.onAnimationEnd(animation);
            }
            j.f12332a.a(FKLottieAnimationView.this.f12599r, "动画结束 onAnimationEnd " + ((Object) animation));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(@NotNull Animator animation) {
            s.i(animation, "animation");
            com.cupidapp.live.base.view.animation.a aVar = FKLottieAnimationView.this.f12600s;
            if (aVar != null) {
                aVar.onAnimationPause(animation);
            }
            j.f12332a.a(FKLottieAnimationView.this.f12599r, "暂停播放 onAnimationPause " + ((Object) animation));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            s.i(animation, "animation");
            com.cupidapp.live.base.view.animation.a aVar = FKLottieAnimationView.this.f12600s;
            if (aVar != null) {
                aVar.onAnimationRepeat(animation);
            }
            j.f12332a.a(FKLottieAnimationView.this.f12599r, "重复播放 onAnimationRepeat " + ((Object) animation));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(@NotNull Animator animation) {
            s.i(animation, "animation");
            com.cupidapp.live.base.view.animation.a aVar = FKLottieAnimationView.this.f12600s;
            if (aVar != null) {
                aVar.onAnimationResume(animation);
            }
            j.f12332a.a(FKLottieAnimationView.this.f12599r, "继续播放 onAnimationResume " + ((Object) animation));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            com.cupidapp.live.base.view.animation.a aVar = FKLottieAnimationView.this.f12600s;
            if (aVar != null) {
                aVar.onAnimationStart(animation);
            }
            j.f12332a.a(FKLottieAnimationView.this.f12599r, "开始播放 onAnimationStart " + ((Object) animation));
        }
    }

    public FKLottieAnimationView(@Nullable Context context) {
        super(context);
        this.f12599r = "FKLottieAnimationView";
        G();
    }

    public static final void H(FKLottieAnimationView this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        com.cupidapp.live.base.view.animation.a aVar = this$0.f12600s;
        if (aVar != null) {
            aVar.onAnimationUpdate(it);
        }
    }

    public final void F(@NotNull com.cupidapp.live.base.view.animation.a listener) {
        s.i(listener, "listener");
        this.f12600s = listener;
    }

    public final void G() {
        g(new a());
        h(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.base.view.animation.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FKLottieAnimationView.H(FKLottieAnimationView.this, valueAnimator);
            }
        });
    }

    public final void I() {
        u();
    }

    public final void J() {
        w();
        x();
        this.f12600s = null;
    }

    public final void K() {
        y();
    }

    public final void L() {
        v();
    }

    public final void M() {
        j();
    }

    public final void setLottieAnimation(int i10) {
        setAnimation(i10);
    }

    public final void setLottieAnimationFromUrl(@NotNull String url) {
        s.i(url, "url");
        setAnimationFromUrl(url);
    }

    public final void setLottieImage(@NotNull String imageKey, int i10) {
        s.i(imageKey, "imageKey");
        B(imageKey, BitmapFactory.decodeResource(getContext().getResources(), i10));
    }

    public final void setLottieImageAssetsFolder(@NotNull String imageAssetsFolder) {
        s.i(imageAssetsFolder, "imageAssetsFolder");
        setImageAssetsFolder(imageAssetsFolder);
    }

    public final void setLottieText(@NotNull String textKey, @NotNull String output) {
        s.i(textKey, "textKey");
        s.i(output, "output");
        o0 o0Var = new o0(this);
        o0Var.e(textKey, output);
        setTextDelegate(o0Var);
    }

    public final void setLottieAnimation(@NotNull String assetName) {
        s.i(assetName, "assetName");
        setAnimation(assetName);
    }

    public FKLottieAnimationView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12599r = "FKLottieAnimationView";
        G();
    }

    public FKLottieAnimationView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12599r = "FKLottieAnimationView";
        G();
    }
}
