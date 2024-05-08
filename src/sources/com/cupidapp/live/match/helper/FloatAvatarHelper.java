package com.cupidapp.live.match.helper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatAvatarHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FloatAvatarHelper<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public AnimatorSet f16756a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<T> f16757b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public int f16758c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Disposable f16759d;

    public static final boolean i(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final void j(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void h(final View view, final View view2, final Function2<? super T, ? super T, p> function2) {
        if (this.f16759d == null) {
            Observable<Long> interval = Observable.interval(3L, TimeUnit.SECONDS);
            final Function1<Long, Boolean> function1 = new Function1<Long, Boolean>(this) { // from class: com.cupidapp.live.match.helper.FloatAvatarHelper$changeAvatarsAnim$1
                public final /* synthetic */ FloatAvatarHelper<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Long it) {
                    List list;
                    s.i(it, "it");
                    list = this.this$0.f16757b;
                    return Boolean.valueOf((list.size() <= 0 || view == null || view2 == null) ? false : true);
                }
            };
            Observable<Long> observeOn = interval.filter(new Predicate() { // from class: com.cupidapp.live.match.helper.c
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean i10;
                    i10 = FloatAvatarHelper.i(Function1.this, obj);
                    return i10;
                }
            }).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function12 = new Function1<Long, p>(this) { // from class: com.cupidapp.live.match.helper.FloatAvatarHelper$changeAvatarsAnim$2
                public final /* synthetic */ FloatAvatarHelper<T> this$0;

                /* compiled from: Animator.kt */
                @d
                /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
                public static final class a implements Animator.AnimatorListener {

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Ref$IntRef f16760b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ FloatAvatarHelper f16761c;

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ Function2 f16762d;

                    public a(Ref$IntRef ref$IntRef, FloatAvatarHelper floatAvatarHelper, Function2 function2) {
                        this.f16760b = ref$IntRef;
                        this.f16761c = floatAvatarHelper;
                        this.f16762d = function2;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(@NotNull Animator animator) {
                        s.i(animator, "animator");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@NotNull Animator animator) {
                        s.i(animator, "animator");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(@NotNull Animator animator) {
                        List list;
                        List list2;
                        int i10;
                        int i11;
                        List list3;
                        List list4;
                        int i12;
                        s.i(animator, "animator");
                        Ref$IntRef ref$IntRef = this.f16760b;
                        int i13 = ref$IntRef.element + 1;
                        ref$IntRef.element = i13;
                        if (i13 % 2 == 0) {
                            list = this.f16761c.f16757b;
                            if (!list.isEmpty()) {
                                list2 = this.f16761c.f16757b;
                                i10 = this.f16761c.f16758c;
                                Object obj = list2.get(i10);
                                FloatAvatarHelper floatAvatarHelper = this.f16761c;
                                i11 = floatAvatarHelper.f16758c;
                                list3 = this.f16761c.f16757b;
                                floatAvatarHelper.f16758c = (i11 + 1) % list3.size();
                                list4 = this.f16761c.f16757b;
                                i12 = this.f16761c.f16758c;
                                this.f16762d.mo1743invoke(obj, list4.get(i12));
                            }
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(@NotNull Animator animator) {
                        s.i(animator, "animator");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
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
                    AnimatorSet animatorSet4;
                    animatorSet = this.this$0.f16756a;
                    if (animatorSet != null) {
                        animatorSet.cancel();
                    }
                    this.this$0.f16756a = new AnimatorSet();
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, 0.0f, 23.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.7f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.7f));
                    s.h(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n…leY\n                    )");
                    ofPropertyValuesHolder.setRepeatMode(2);
                    ofPropertyValuesHolder.setDuration(150L);
                    ofPropertyValuesHolder.setRepeatCount(1);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f, -23.0f);
                    ofFloat.setRepeatMode(2);
                    ofFloat.setDuration(150L);
                    ofFloat.setRepeatCount(1);
                    Ref$IntRef ref$IntRef = new Ref$IntRef();
                    ref$IntRef.element = 1;
                    ofPropertyValuesHolder.addListener(new a(ref$IntRef, this.this$0, function2));
                    animatorSet2 = this.this$0.f16756a;
                    if (animatorSet2 != null) {
                        animatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
                    }
                    animatorSet3 = this.this$0.f16756a;
                    if (animatorSet3 != null) {
                        animatorSet3.playTogether(ofPropertyValuesHolder, ofFloat);
                    }
                    animatorSet4 = this.this$0.f16756a;
                    if (animatorSet4 != null) {
                        animatorSet4.start();
                    }
                }
            };
            this.f16759d = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.match.helper.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    FloatAvatarHelper.j(Function1.this, obj);
                }
            });
        }
    }

    public final void k(@NotNull List<? extends T> list, @Nullable View view, @Nullable View view2, @NotNull Function2<? super T, ? super T, p> dataChangeCallback) {
        s.i(list, "list");
        s.i(dataChangeCallback, "dataChangeCallback");
        l();
        this.f16757b.clear();
        this.f16757b.addAll(list);
        this.f16758c = 0;
        int size = this.f16757b.size();
        T t2 = this.f16757b.get(this.f16758c % size);
        int i10 = (this.f16758c + 1) % size;
        this.f16758c = i10;
        dataChangeCallback.mo1743invoke(t2, this.f16757b.get(i10));
        h(view, view2, dataChangeCallback);
    }

    public final void l() {
        AnimatorSet animatorSet = this.f16756a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Disposable disposable = this.f16759d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f16759d = null;
    }
}
