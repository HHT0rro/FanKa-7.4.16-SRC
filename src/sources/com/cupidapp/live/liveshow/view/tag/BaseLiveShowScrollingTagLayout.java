package com.cupidapp.live.liveshow.view.tag;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: BaseLiveShowScrollingTagLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class BaseLiveShowScrollingTagLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15957b;

    /* renamed from: c, reason: collision with root package name */
    public int f15958c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<LiveShowTagModel> f15959d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Disposable f15960e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15961f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLiveShowScrollingTagLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15961f = new LinkedHashMap();
        this.f15959d = new ArrayList();
        d();
    }

    public static final void i(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void d() {
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.tag.BaseLiveShowScrollingTagLayout$bindClickEvent$1
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
                if (BaseLiveShowScrollingTagLayout.this.getCurrentPosition() >= BaseLiveShowScrollingTagLayout.this.getMTagList().size()) {
                    return;
                }
                LiveShowTagModel liveShowTagModel = BaseLiveShowScrollingTagLayout.this.getMTagList().get(BaseLiveShowScrollingTagLayout.this.getCurrentPosition());
                String url = liveShowTagModel.getUrl();
                if (url != null) {
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(url, false, 2, null));
                }
                String name = liveShowTagModel.getName();
                if (name != null) {
                    SensorsLogKeyButtonClick.f12211a.c(SensorPosition.LiveShowRoom.getValue(), name);
                }
            }
        });
    }

    public void e(@NotNull List<LiveShowTagModel> tagList, int i10) {
        s.i(tagList, "tagList");
        if (tagList.isEmpty()) {
            return;
        }
        this.f15958c = 0;
        this.f15959d.clear();
        this.f15959d.addAll(tagList);
    }

    @NotNull
    public abstract ObjectAnimator f(int i10, int i11);

    @NotNull
    public abstract ObjectAnimator g(int i10);

    public final int getCurrentPosition() {
        return this.f15958c;
    }

    @NotNull
    public final List<LiveShowTagModel> getMTagList() {
        return this.f15959d;
    }

    public final void h(final int i10) {
        if (this.f15960e == null) {
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            Observable<Long> observeOn = Observable.interval(5L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.view.tag.BaseLiveShowScrollingTagLayout$startAnimation$1

                /* compiled from: Animator.kt */
                @d
                /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
                public static final class a implements Animator.AnimatorListener {

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Ref$IntRef f15962b;

                    public a(Ref$IntRef ref$IntRef) {
                        this.f15962b = ref$IntRef;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(@NotNull Animator animator) {
                        s.i(animator, "animator");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@NotNull Animator animator) {
                        s.i(animator, "animator");
                        this.f15962b.element++;
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
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke2(l10);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                    AnimatorSet animatorSet;
                    AnimatorSet animatorSet2;
                    AnimatorSet animatorSet3;
                    animatorSet = BaseLiveShowScrollingTagLayout.this.f15957b;
                    if (animatorSet != null) {
                        animatorSet.cancel();
                    }
                    BaseLiveShowScrollingTagLayout baseLiveShowScrollingTagLayout = BaseLiveShowScrollingTagLayout.this;
                    AnimatorSet animatorSet4 = new AnimatorSet();
                    animatorSet4.addListener(new a(ref$IntRef));
                    baseLiveShowScrollingTagLayout.f15957b = animatorSet4;
                    ObjectAnimator g3 = BaseLiveShowScrollingTagLayout.this.g(ref$IntRef.element);
                    ObjectAnimator f10 = BaseLiveShowScrollingTagLayout.this.f(ref$IntRef.element, i10);
                    animatorSet2 = BaseLiveShowScrollingTagLayout.this.f15957b;
                    if (animatorSet2 != null) {
                        animatorSet2.playTogether(g3, f10);
                    }
                    animatorSet3 = BaseLiveShowScrollingTagLayout.this.f15957b;
                    if (animatorSet3 != null) {
                        animatorSet3.start();
                    }
                }
            };
            this.f15960e = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.liveshow.view.tag.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BaseLiveShowScrollingTagLayout.i(Function1.this, obj);
                }
            });
        }
    }

    public final void j() {
        AnimatorSet animatorSet = this.f15957b;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Disposable disposable = this.f15960e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f15960e = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    public final void setCurrentPosition(int i10) {
        this.f15958c = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLiveShowScrollingTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15961f = new LinkedHashMap();
        this.f15959d = new ArrayList();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLiveShowScrollingTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15961f = new LinkedHashMap();
        this.f15959d = new ArrayList();
        d();
    }
}
