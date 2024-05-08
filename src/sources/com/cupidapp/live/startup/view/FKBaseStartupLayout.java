package com.cupidapp.live.startup.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMaterialType;
import com.cupidapp.live.startup.model.FKStartupMediaBaseInfoModel;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseStartupLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class FKBaseStartupLayout extends BaseLayout implements DefaultLifecycleObserver {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f18553g = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Animator f18554d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.startup.view.b f18555e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18556f;

    /* compiled from: FKBaseStartupLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Animator.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FKAdType f18558c;

        public b(FKAdType fKAdType) {
            this.f18558c = fKAdType;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            com.cupidapp.live.startup.view.b listener = FKBaseStartupLayout.this.getListener();
            if (listener != null) {
                listener.c0(this.f18558c, SplashAdShowState.COMPLETE_DISPLAY);
            }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseStartupLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18556f = new LinkedHashMap();
    }

    public static final void l(FKBaseStartupLayout this$0, int i10, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        String string = this$0.getContext().getString(R$string.ad_skip_count, Integer.valueOf(i10 - ((Integer) animatedValue).intValue()));
        s.h(string, "context.getString(R.stri…count, countTime - value)");
        this$0.k(string);
    }

    public abstract void f(boolean z10, int i10, @Nullable String str);

    public abstract void g(@NotNull String str);

    @Nullable
    public final com.cupidapp.live.startup.view.b getListener() {
        return this.f18555e;
    }

    public final void h(@NotNull FKStartupMediaConfigModel startup) {
        FKAdType fKAdType;
        s.i(startup, "startup");
        if (startup.isSelfOperatedAdvertising()) {
            FKStartupMediaBaseInfoModel advertisementBaseInfo = startup.getAdvertisementBaseInfo();
            Integer materialType = advertisementBaseInfo.getMaterialType();
            int type = FKStartupMaterialType.Image.getType();
            if (materialType != null && materialType.intValue() == type) {
                fKAdType = FKAdType.Image;
            } else {
                fKAdType = (materialType != null && materialType.intValue() == FKStartupMaterialType.Video.getType()) ? FKAdType.Video : FKAdType.Image;
            }
            if (startup.canShow()) {
                com.cupidapp.live.startup.view.b bVar = this.f18555e;
                if (bVar != null) {
                    bVar.p0(fKAdType);
                }
                setVisibility(0);
                String resourcePath = startup.getResourcePath();
                s.f(resourcePath);
                g(resourcePath);
                j(advertisementBaseInfo.getDisplayTime(), fKAdType);
                f(startup.isDisplayHotButton(), startup.getClickHotArea(), advertisementBaseInfo.getJumpLink());
                com.cupidapp.live.startup.view.b bVar2 = this.f18555e;
                if (bVar2 != null) {
                    bVar2.P(fKAdType);
                    return;
                }
                return;
            }
            String str = ((Object) fKAdType) + " showAd fail, canShow() = false";
            com.cupidapp.live.startup.view.b bVar3 = this.f18555e;
            if (bVar3 != null) {
                bVar3.Q(fKAdType, -1, str);
            }
            setVisibility(4);
        }
    }

    public final void i(@NotNull LifecycleOwner lifecycleOwner) {
        s.i(lifecycleOwner, "lifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public final void j(Integer num, FKAdType fKAdType) {
        final int i10 = 5;
        if (num != null && num.intValue() >= 5) {
            i10 = num.intValue();
        }
        ValueAnimator startCountDown$lambda$2 = ValueAnimator.ofInt(i10);
        startCountDown$lambda$2.setDuration(i10 * 1000);
        startCountDown$lambda$2.setInterpolator(new LinearInterpolator());
        s.h(startCountDown$lambda$2, "startCountDown$lambda$2");
        startCountDown$lambda$2.addListener(new b(fKAdType));
        startCountDown$lambda$2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.startup.view.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FKBaseStartupLayout.l(FKBaseStartupLayout.this, i10, valueAnimator);
            }
        });
        this.f18554d = startCountDown$lambda$2;
        startCountDown$lambda$2.start();
    }

    public abstract void k(@NotNull String str);

    public final void m() {
        Animator animator = this.f18554d;
        if (animator != null) {
            animator.removeAllListeners();
        }
        Animator animator2 = this.f18554d;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.f(this, lifecycleOwner);
    }

    public final void setListener(@Nullable com.cupidapp.live.startup.view.b bVar) {
        this.f18555e = bVar;
    }

    public final void setStartupListener(@Nullable com.cupidapp.live.startup.view.b bVar) {
        this.f18555e = bVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseStartupLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18556f = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseStartupLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18556f = new LinkedHashMap();
    }
}
