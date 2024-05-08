package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.appdialog.model.ActivationType;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.BoostRippleLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity;
import com.cupidapp.live.superlike.helper.SuperLikeClickHelper;
import com.cupidapp.live.superlike.view.SuperLikeDeliveryAnimLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardClickButtonLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardClickButtonLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public h f16867d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Disposable f16868e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16869f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16870g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardClickButtonLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16870g = new LinkedHashMap();
        C();
    }

    public static final boolean G(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final void I(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void J(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void L(FKSwipeCardClickButtonLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.A();
    }

    public static final void O(FKSwipeCardClickButtonLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.B();
    }

    public final void A() {
        View o10 = o();
        if (o10 == null) {
            return;
        }
        o10.setVisibility(8);
    }

    public final void B() {
        View R = R();
        if (R == null) {
            return;
        }
        R.setVisibility(8);
    }

    public final void C() {
        z0.z.a(this, R$layout.layout_new_swipe_card_click_button, true);
        setVisibility(8);
        View findViewById = findViewById(R$id.exposure_time);
        kotlin.jvm.internal.s.h(findViewById, "findViewById<TextView>(R.id.exposure_time)");
        z0.u.a((TextView) findViewById);
        z0.y.d(y(), new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                h hVar;
                hVar = FKSwipeCardClickButtonLayout.this.f16867d;
                if (hVar != null) {
                    hVar.c();
                }
            }
        });
        z0.y.d(w(), new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                h hVar;
                hVar = FKSwipeCardClickButtonLayout.this.f16867d;
                if (hVar != null) {
                    hVar.a();
                }
            }
        });
        z0.y.d(u(), new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$initView$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                h hVar;
                hVar = FKSwipeCardClickButtonLayout.this.f16867d;
                if (hVar != null) {
                    hVar.b();
                }
                FKSwipeCardClickButtonLayout.this.A();
            }
        });
        FKClickAnimationLayout x10 = x();
        if (x10 != null) {
            z0.y.d(x10, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$initView$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                    invoke2(view);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    boolean z10;
                    h hVar;
                    p1.g gVar = p1.g.f52734a;
                    if (kotlin.jvm.internal.s.d(gVar.N0(), Boolean.TRUE)) {
                        ActivationType activationType = ActivationType.Recall;
                        gVar.a(activationType.getValue());
                        RegisterUserMatchBtnDesActivity.a aVar = RegisterUserMatchBtnDesActivity.f16544s;
                        Context context = FKSwipeCardClickButtonLayout.this.getContext();
                        kotlin.jvm.internal.s.h(context, "context");
                        aVar.a(context, activationType.getValue());
                        return;
                    }
                    z10 = FKSwipeCardClickButtonLayout.this.f16869f;
                    if (z10) {
                        SensorsLogKeyButtonClick.Match.UndoNope.click();
                        hVar = FKSwipeCardClickButtonLayout.this.f16867d;
                        if (hVar != null) {
                            hVar.e();
                        }
                    }
                }
            });
        }
        o1.a.f52250a.a(this);
    }

    public final void D(@Nullable SuperLikeDeliveryAnimLayout superLikeDeliveryAnimLayout) {
        SuperLikeClickHelper.f18616a.f(superLikeDeliveryAnimLayout);
    }

    public final void E(@NotNull String remainTime) {
        kotlin.jvm.internal.s.i(remainTime, "remainTime");
        TextView textView = (TextView) findViewById(R$id.exposure_time);
        textView.setVisibility(0);
        textView.setText(remainTime);
        F(true);
    }

    public final void F(boolean z10) {
        final BoostRippleLayout boostRippleLayout = (BoostRippleLayout) findViewById(R$id.ic_boost_svga);
        if (z10) {
            if (boostRippleLayout.getVisibility() != 0) {
                boostRippleLayout.setVisibility(0);
                boostRippleLayout.getAnimSet().start();
                Disposable disposable = this.f16868e;
                if (disposable != null) {
                    disposable.dispose();
                }
                Observable<Long> interval = Observable.interval(HwCubicBezierInterpolator.f34870a, TimeUnit.MILLISECONDS);
                final Function1<Long, Boolean> function1 = new Function1<Long, Boolean>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$showBoostSvga$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Long it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        return Boolean.valueOf(FKSwipeCardClickButtonLayout.this.isAttachedToWindow());
                    }
                };
                Observable<Long> observeOn = interval.filter(new Predicate() { // from class: com.cupidapp.live.match.view.e
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Object obj) {
                        boolean G;
                        G = FKSwipeCardClickButtonLayout.G(Function1.this, obj);
                        return G;
                    }
                }).observeOn(AndroidSchedulers.mainThread());
                final Function1<Long, kotlin.p> function12 = new Function1<Long, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$showBoostSvga$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Long l10) {
                        invoke2(l10);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Long l10) {
                        try {
                            BoostRippleLayout.this.getAnimSet().cancel();
                            BoostRippleLayout.this.getAnimSet().start();
                        } catch (Exception unused) {
                        }
                    }
                };
                Consumer<? super Long> consumer = new Consumer() { // from class: com.cupidapp.live.match.view.d
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        FKSwipeCardClickButtonLayout.I(Function1.this, obj);
                    }
                };
                final FKSwipeCardClickButtonLayout$showBoostSvga$3 fKSwipeCardClickButtonLayout$showBoostSvga$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$showBoostSvga$3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                        invoke2(th);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                    }
                };
                Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.view.c
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        FKSwipeCardClickButtonLayout.J(Function1.this, obj);
                    }
                });
                this.f16868e = subscribe;
                if (subscribe != null) {
                    H(subscribe);
                    return;
                }
                return;
            }
            return;
        }
        Disposable disposable2 = this.f16868e;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        boostRippleLayout.setVisibility(8);
    }

    public final void K() {
        View o10;
        if (!p1.g.f52734a.L3() || (o10 = o()) == null) {
            return;
        }
        B();
        o10.setVisibility(0);
        z0.y.d(o10, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$showSuperBoostBubble$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKSwipeCardClickButtonLayout.this.A();
            }
        });
        o10.postDelayed(new Runnable() { // from class: com.cupidapp.live.match.view.g
            @Override // java.lang.Runnable
            public final void run() {
                FKSwipeCardClickButtonLayout.L(FKSwipeCardClickButtonLayout.this);
            }
        }, 5000L);
    }

    public final void M(@Nullable String str) {
        if (str == null) {
            return;
        }
        final ImageView imageView = (ImageView) findViewById(R$id.exposure_icon);
        imageView.setVisibility(8);
        final FKSVGAImageView findSuperBoostGuideImageView = (FKSVGAImageView) findViewById(R$id.super_boost_guide_imageview);
        findSuperBoostGuideImageView.setVisibility(0);
        kotlin.jvm.internal.s.h(findSuperBoostGuideImageView, "findSuperBoostGuideImageView");
        findSuperBoostGuideImageView.G("home_superboost_guide_new.svga", (r23 & 2) != 0 ? null : Float.valueOf(23.0f), (r23 & 4) != 0 ? -1 : -16777216, (r23 & 8) != 0 ? false : false, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : kotlin.collections.h0.d(new Pair("ic_superboost_back_number", str)), (r23 & 128) != 0 ? null : null, (r23 & 256) == 0 ? 0 : 0, (r23 & 512) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$showSuperBoostGuide$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView.this.setVisibility(0);
                findSuperBoostGuideImageView.setVisibility(8);
            }
        }, (r23 & 1024) == 0 ? null : null);
        GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.SUPER_BOOST_AE, SensorPosition.Match, SensorScene.Match, null, 8, null);
    }

    public final void N() {
        View R;
        if (!p1.g.f52734a.M3() || (R = R()) == null) {
            return;
        }
        R.setVisibility(0);
        z0.y.d(R, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$showSuperLikeBubble$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKSwipeCardClickButtonLayout.this.B();
            }
        });
        R.postDelayed(new Runnable() { // from class: com.cupidapp.live.match.view.f
            @Override // java.lang.Runnable
            public final void run() {
                FKSwipeCardClickButtonLayout.O(FKSwipeCardClickButtonLayout.this);
            }
        }, 5000L);
    }

    public final void P(@Nullable String str) {
        if (str == null) {
            return;
        }
        final ImageView imageView = (ImageView) findViewById(R$id.super_like_icon);
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) findViewById(R$id.ic_superlike_svga);
        if (fKSVGAImageView != null) {
            fKSVGAImageView.G("home_superlike_guide_new.svga", (r23 & 2) != 0 ? null : Float.valueOf(23.0f), (r23 & 4) != 0 ? -1 : 0, (r23 & 8) != 0 ? false : false, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : kotlin.collections.h0.d(new Pair("ic_superlike_back_number", str)), (r23 & 128) != 0 ? null : null, (r23 & 256) == 0 ? 0 : 0, (r23 & 512) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$showSuperLikeGuide$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ImageView imageView2 = ImageView.this;
                    if (imageView2 == null) {
                        return;
                    }
                    imageView2.setVisibility(0);
                }
            }, (r23 & 1024) == 0 ? null : null);
        }
        GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.REMAIN_TIPS, SensorPosition.Match, SensorScene.Match, null, 8, null);
    }

    public final void Q(boolean z10, float f10) {
        if (z10) {
            setVisibility(0);
            float abs = 1 - Math.abs(f10 * 4);
            y().setAlpha(abs);
            w().setAlpha(abs);
            v().setAlpha(abs);
            u().setAlpha(abs);
            FKClickAnimationLayout x10 = x();
            if (x10 != null) {
                x10.setAlpha(abs);
            }
            View R = R();
            if (R != null) {
                R.setAlpha(abs);
            }
            View o10 = o();
            if (o10 != null) {
                o10.setAlpha(abs);
            }
            if (abs >= 0.0f && abs < 1.0f) {
                y().setDisable(true);
                w().setDisable(true);
                v().setDisable(true);
                u().setDisable(true);
                FKClickAnimationLayout x11 = x();
                if (x11 == null) {
                    return;
                }
                x11.setDisable(true);
                return;
            }
            y().setDisable(false);
            w().setDisable(false);
            v().setDisable(false);
            u().setDisable(false);
            FKClickAnimationLayout x12 = x();
            if (x12 == null) {
                return;
            }
            x12.setDisable(false);
            return;
        }
        setVisibility(8);
    }

    public final View R() {
        return findViewById(R$id.super_like_guide_img);
    }

    public final View o() {
        return findViewById(R$id.super_exposure_marketing_img);
    }

    public final void p(boolean z10) {
        if (getAlpha() >= 0.0f && getAlpha() < 1.0f) {
            v().setDisable(true);
        } else {
            v().setDisable(z10);
        }
    }

    public final void q() {
        int l10;
        p1.g gVar = p1.g.f52734a;
        boolean L3 = gVar.L3();
        boolean M3 = gVar.M3();
        if (L3) {
            l10 = z0.h.l(this) / 5;
        } else {
            l10 = z0.h.l(this) / 4;
        }
        z0.y.o(w(), Integer.valueOf(l10), null, 2, null);
        z0.y.o(y(), Integer.valueOf(l10), null, 2, null);
        z0.y.o(v(), Integer.valueOf(l10), null, 2, null);
        u().setVisibility(L3 ? 0 : 8);
        v().setVisibility(M3 ? 0 : 8);
        FKClickAnimationLayout x10 = x();
        if (x10 == null) {
            return;
        }
        x10.setVisibility(L3 ? 0 : 8);
    }

    public final void r(boolean z10) {
        this.f16869f = z10;
        int i10 = z10 ? R$mipmap.ic_black_cancel_nope_enable : R$mipmap.ic_black_cancel_nope_disable;
        ImageView imageView = (ImageView) findViewById(R$id.swipe_card_cancel_nope_img);
        if (imageView != null) {
            imageView.setImageResource(i10);
        }
    }

    public final void s(boolean z10) {
        int c4 = z0.h.c(this, z10 ? 0.0f : 8.0f);
        z0.y.m(this, Integer.valueOf(c4), null, Integer.valueOf(c4), Integer.valueOf(c4), 2, null);
    }

    public final void setSwipeCardClickListener(@NotNull h listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f16867d = listener;
    }

    public final void t(@NotNull SuperLikeDeliveryAnimLayout superlikeDelivery, @NotNull Lifecycle lifecycle) {
        kotlin.jvm.internal.s.i(superlikeDelivery, "superlikeDelivery");
        kotlin.jvm.internal.s.i(lifecycle, "lifecycle");
        if (getContext() instanceof LifecycleOwner) {
            SuperLikeClickHelper superLikeClickHelper = SuperLikeClickHelper.f18616a;
            Context context = getContext();
            kotlin.jvm.internal.s.h(context, "context");
            superLikeClickHelper.g(context, lifecycle, SensorPosition.Match, v(), superlikeDelivery, (r17 & 32) != 0 ? null : null, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardClickButtonLayout$configSuperLikeClick$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                    invoke(num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(int i10) {
                    h hVar;
                    FKSwipeCardClickButtonLayout.this.B();
                    hVar = FKSwipeCardClickButtonLayout.this.f16867d;
                    if (hVar != null) {
                        hVar.d(i10);
                    }
                }
            });
        }
    }

    public final FKClickAnimationLayout u() {
        View findViewById = findViewById(R$id.match_exposure_btn);
        kotlin.jvm.internal.s.h(findViewById, "findViewById(R.id.match_exposure_btn)");
        return (FKClickAnimationLayout) findViewById;
    }

    public final FKClickAnimationLayout v() {
        View findViewById = findViewById(R$id.match_super_like_btn);
        kotlin.jvm.internal.s.h(findViewById, "findViewById(R.id.match_super_like_btn)");
        return (FKClickAnimationLayout) findViewById;
    }

    public final FKClickAnimationLayout w() {
        View findViewById = findViewById(R$id.swipe_card_aloha_button);
        kotlin.jvm.internal.s.h(findViewById, "findViewById(R.id.swipe_card_aloha_button)");
        return (FKClickAnimationLayout) findViewById;
    }

    public final FKClickAnimationLayout x() {
        return (FKClickAnimationLayout) findViewById(R$id.swipe_card_cancel_nope_button);
    }

    public final FKClickAnimationLayout y() {
        View findViewById = findViewById(R$id.swipe_card_nope_button);
        kotlin.jvm.internal.s.h(findViewById, "findViewById(R.id.swipe_card_nope_button)");
        return (FKClickAnimationLayout) findViewById;
    }

    public final void z() {
        F(false);
        ((TextView) findViewById(R$id.exposure_time)).setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardClickButtonLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16870g = new LinkedHashMap();
        C();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardClickButtonLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16870g = new LinkedHashMap();
        C();
    }
}
