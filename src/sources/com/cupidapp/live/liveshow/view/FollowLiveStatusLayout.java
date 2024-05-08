package com.cupidapp.live.liveshow.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.progress.CircleProgressBarView;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.FollowLiveStatusModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.FollowLiveStatusLayout;
import com.irisdt.client.live.LiveProtos;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FollowLiveStatusLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FollowLiveStatusLayout extends BaseLayout {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final Companion f15289g = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    public static float f15290h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static ValueAnimator f15291i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public static n f15292j;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f15293d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15294e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15295f;

    /* compiled from: FollowLiveStatusLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {

        /* compiled from: Animator.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a implements Animator.AnimatorListener {
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                s.i(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                s.i(animator, "animator");
                Companion companion = FollowLiveStatusLayout.f15289g;
                FollowLiveStatusLayout.f15290h = 0.0f;
                n nVar = FollowLiveStatusLayout.f15292j;
                if (nVar != null) {
                    nVar.b();
                }
                companion.e();
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

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void f(Object obj) {
        }

        public static final void g(Function1 tmp0, Object obj) {
            s.i(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        public static final void j(ValueAnimator it) {
            s.i(it, "it");
            Object animatedValue = it.getAnimatedValue();
            s.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            Companion companion = FollowLiveStatusLayout.f15289g;
            FollowLiveStatusLayout.f15290h = floatValue;
            n nVar = FollowLiveStatusLayout.f15292j;
            if (nVar != null) {
                nVar.a(floatValue);
            }
        }

        public final void e() {
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (liveShowModel != null) {
                Observable observeOn = NetworkClient.f11868a.r().U(liveShowModel.getItemId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread());
                m mVar = new Consumer() { // from class: com.cupidapp.live.liveshow.view.m
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        FollowLiveStatusLayout.Companion.f(obj);
                    }
                };
                final FollowLiveStatusLayout$Companion$completeFollowLive$1$2 followLiveStatusLayout$Companion$completeFollowLive$1$2 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.liveshow.view.FollowLiveStatusLayout$Companion$completeFollowLive$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                        invoke2(th);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                    }
                };
                observeOn.subscribe(mVar, new Consumer() { // from class: com.cupidapp.live.liveshow.view.l
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        FollowLiveStatusLayout.Companion.g(Function1.this, obj);
                    }
                });
            }
        }

        public final void h(@Nullable n nVar) {
            FollowLiveStatusLayout.f15292j = nVar;
        }

        public final void i(long j10) {
            ValueAnimator valueAnimator = FollowLiveStatusLayout.f15291i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                return;
            }
            ValueAnimator startAnimation$lambda$2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            startAnimation$lambda$2.setDuration(j10);
            startAnimation$lambda$2.setInterpolator(new LinearInterpolator());
            startAnimation$lambda$2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.liveshow.view.k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    FollowLiveStatusLayout.Companion.j(valueAnimator2);
                }
            });
            s.h(startAnimation$lambda$2, "startAnimation$lambda$2");
            startAnimation$lambda$2.addListener(new a());
            FollowLiveStatusLayout.f15291i = startAnimation$lambda$2;
            ValueAnimator valueAnimator2 = FollowLiveStatusLayout.f15291i;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }

        public final void k() {
            FollowLiveStatusLayout.f15290h = 0.0f;
            ValueAnimator valueAnimator = FollowLiveStatusLayout.f15291i;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
            }
            ValueAnimator valueAnimator2 = FollowLiveStatusLayout.f15291i;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
            }
            ValueAnimator valueAnimator3 = FollowLiveStatusLayout.f15291i;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
            }
            FollowLiveStatusLayout.f15291i = null;
        }
    }

    /* compiled from: FollowLiveStatusLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements n {
        public a() {
        }

        @Override // com.cupidapp.live.liveshow.view.n
        public void a(float f10) {
            ((CircleProgressBarView) FollowLiveStatusLayout.this.e(R$id.follow_live_progress_view)).setProgress(f10);
        }

        @Override // com.cupidapp.live.liveshow.view.n
        public void b() {
            FollowLiveStatusLayout.this.r();
        }
    }

    /* compiled from: Animator.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            FollowLiveStatusLayout.this.setVisibility(8);
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
    public FollowLiveStatusLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15295f = new LinkedHashMap();
        p();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15295f;
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

    public final void m(@Nullable FollowLiveStatusModel followLiveStatusModel) {
        if (followLiveStatusModel == null) {
            setVisibility(8);
            f15289g.k();
            return;
        }
        setVisibility(0);
        this.f15293d = followLiveStatusModel.getUrl();
        o(followLiveStatusModel);
        Companion companion = f15289g;
        companion.h(new a());
        if (followLiveStatusModel.getCountDownSecs() != null) {
            companion.i(r6.intValue() * 1000);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(FollowLiveStatusModel followLiveStatusModel) {
        ImageLoaderView follow_live_rank_imageview = (ImageLoaderView) e(R$id.follow_live_rank_imageview);
        s.h(follow_live_rank_imageview, "follow_live_rank_imageview");
        ImageLoaderView.g(follow_live_rank_imageview, followLiveStatusModel.getLevelIcon(), null, null, 6, null);
        ((TextView) e(R$id.follow_live_times_textview)).setText(followLiveStatusModel.getTitle());
        String colorRange = followLiveStatusModel.getColorRange();
        if (colorRange == null || colorRange.length() == 0) {
            return;
        }
        List z02 = StringsKt__StringsKt.z0(followLiveStatusModel.getColorRange(), new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(t.t(z02, 10));
        Iterator<E> iterator2 = z02.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(Integer.valueOf(com.cupidapp.live.base.utils.h.b((String) iterator2.next())));
        }
        List z03 = CollectionsKt___CollectionsKt.z0(arrayList);
        z03.add(CollectionsKt___CollectionsKt.T(z03));
        ((CircleProgressBarView) e(R$id.follow_live_progress_view)).setProgressColor(z03);
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.f15294e;
        if (animatorSet != null && animatorSet.isRunning()) {
            setVisibility(8);
            AnimatorSet animatorSet2 = this.f15294e;
            if (animatorSet2 != null) {
                animatorSet2.removeAllListeners();
            }
            AnimatorSet animatorSet3 = this.f15294e;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            this.f15294e = null;
        }
    }

    public final void p() {
        z.a(this, R$layout.layout_follow_live_status, true);
        setVisibility(8);
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FollowLiveStatusLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                String str;
                str = FollowLiveStatusLayout.this.f15293d;
                if (str != null) {
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(str, false, 2, null));
                    LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                    if (liveShowModel != null) {
                        SensorsLogLiveShow.f12212a.f(liveShowModel.getItemId(), liveShowModel.getUser().userId(), LiveProtos.Type.FOLLOW_COUNT_DOWN, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
                    }
                }
            }
        });
    }

    public final void q(@Nullable FollowLiveStatusModel followLiveStatusModel) {
        if (followLiveStatusModel != null) {
            o(followLiveStatusModel);
        }
    }

    public final void r() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, (Property<FollowLiveStatusLayout, Float>) View.SCALE_X, 1.0f, 0.0f)).with(ObjectAnimator.ofFloat(this, (Property<FollowLiveStatusLayout, Float>) View.SCALE_Y, 1.0f, 0.0f));
        animatorSet.setDuration(300L);
        animatorSet.addListener(new b());
        this.f15294e = animatorSet;
        animatorSet.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowLiveStatusLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15295f = new LinkedHashMap();
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowLiveStatusLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15295f = new LinkedHashMap();
        p();
    }
}
