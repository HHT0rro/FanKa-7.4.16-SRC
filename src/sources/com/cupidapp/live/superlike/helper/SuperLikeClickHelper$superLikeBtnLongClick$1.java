package com.cupidapp.live.superlike.helper;

import com.cupidapp.live.superlike.view.SuperLikeDeliveryAnimLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: SuperLikeClickHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikeClickHelper$superLikeBtnLongClick$1 extends Lambda implements Function1<Integer, p> {
    public final /* synthetic */ Function1<Integer, p> $clickListener;
    public final /* synthetic */ SuperLikeDeliveryAnimLayout $superlikeDelivery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuperLikeClickHelper$superLikeBtnLongClick$1(SuperLikeDeliveryAnimLayout superLikeDeliveryAnimLayout, Function1<? super Integer, p> function1) {
        super(1);
        this.$superlikeDelivery = superLikeDeliveryAnimLayout;
        this.$clickListener = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Integer num) {
        invoke(num.intValue());
        return p.f51048a;
    }

    public final void invoke(final int i10) {
        CompositeDisposable compositeDisposable;
        CompositeDisposable compositeDisposable2;
        compositeDisposable = SuperLikeClickHelper.f18617b;
        compositeDisposable.clear();
        compositeDisposable2 = SuperLikeClickHelper.f18617b;
        Observable<Long> observeOn = Observable.interval(1000L, 100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        final SuperLikeDeliveryAnimLayout superLikeDeliveryAnimLayout = this.$superlikeDelivery;
        final Function1<Disposable, p> function1 = new Function1<Disposable, p>() { // from class: com.cupidapp.live.superlike.helper.SuperLikeClickHelper$superLikeBtnLongClick$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Disposable disposable) {
                invoke2(disposable);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Disposable disposable) {
                SuperLikeClickHelper superLikeClickHelper = SuperLikeClickHelper.f18616a;
                SuperLikeClickHelper.f18618c = 1;
                SuperLikeDeliveryAnimLayout.this.c(1);
            }
        };
        Observable<Long> doOnSubscribe = observeOn.doOnSubscribe(new Consumer() { // from class: com.cupidapp.live.superlike.helper.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SuperLikeClickHelper$superLikeBtnLongClick$1.invoke$lambda$0(Function1.this, obj);
            }
        });
        final SuperLikeDeliveryAnimLayout superLikeDeliveryAnimLayout2 = this.$superlikeDelivery;
        final Function1<Integer, p> function12 = this.$clickListener;
        final Function1<Long, p> function13 = new Function1<Long, p>() { // from class: com.cupidapp.live.superlike.helper.SuperLikeClickHelper$superLikeBtnLongClick$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l10) {
                invoke2(l10);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
            
                if (r0 < r3) goto L17;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(java.lang.Long r5) {
                /*
                    r4 = this;
                    int r0 = com.cupidapp.live.superlike.helper.SuperLikeClickHelper.c()
                    r1 = 5
                    if (r0 > r1) goto L12
                    long r0 = r5.longValue()
                    r5 = 4
                    long r2 = (long) r5
                    long r0 = r0 / r2
                    int r5 = (int) r0
                    int r0 = r5 + 2
                    goto L22
                L12:
                    if (r0 <= r1) goto L22
                    long r0 = r5.longValue()
                    r5 = 16
                    long r2 = (long) r5
                    long r0 = r0 - r2
                    r5 = 3
                    long r2 = (long) r5
                    long r0 = r0 / r2
                    int r5 = (int) r0
                    int r0 = r5 + 6
                L22:
                    int r5 = com.cupidapp.live.superlike.helper.SuperLikeClickHelper.c()
                    if (r0 == r5) goto L57
                    com.cupidapp.live.superlike.helper.SuperLikeClickHelper r5 = com.cupidapp.live.superlike.helper.SuperLikeClickHelper.f18616a
                    com.cupidapp.live.superlike.helper.SuperLikeClickHelper.d(r0)
                    int r0 = com.cupidapp.live.superlike.helper.SuperLikeClickHelper.c()
                    r1 = 1000(0x3e8, float:1.401E-42)
                    r2 = 0
                    if (r0 >= r1) goto L50
                    int r0 = r1
                    r1 = 1
                    if (r1 > r0) goto L42
                    int r3 = com.cupidapp.live.superlike.helper.SuperLikeClickHelper.c()
                    if (r0 >= r3) goto L42
                    goto L43
                L42:
                    r1 = 0
                L43:
                    if (r1 == 0) goto L46
                    goto L50
                L46:
                    com.cupidapp.live.superlike.view.SuperLikeDeliveryAnimLayout r5 = r2
                    int r0 = com.cupidapp.live.superlike.helper.SuperLikeClickHelper.c()
                    r5.c(r0)
                    goto L57
                L50:
                    com.cupidapp.live.superlike.view.SuperLikeDeliveryAnimLayout r0 = r2
                    kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.p> r1 = r3
                    r5.k(r2, r0, r1)
                L57:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.superlike.helper.SuperLikeClickHelper$superLikeBtnLongClick$1.AnonymousClass2.invoke2(java.lang.Long):void");
            }
        };
        compositeDisposable2.add(doOnSubscribe.subscribe(new Consumer() { // from class: com.cupidapp.live.superlike.helper.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SuperLikeClickHelper$superLikeBtnLongClick$1.invoke$lambda$1(Function1.this, obj);
            }
        }));
    }
}
