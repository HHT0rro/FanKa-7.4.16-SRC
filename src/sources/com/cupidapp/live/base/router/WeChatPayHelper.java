package com.cupidapp.live.base.router;

import android.app.Activity;
import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.WeChatPayHelper;
import com.cupidapp.live.wxapi.event.WXEntryPayResultEvent;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WeChatPayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WeChatPayHelper {

    /* renamed from: a */
    @Nullable
    public String f12117a;

    /* compiled from: WeChatPayHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class a {
        public void a() {
        }

        public abstract boolean b(@NotNull Throwable th);

        public abstract void c(@NotNull OrderDataResult orderDataResult, @NotNull PurchaseStatus purchaseStatus, @NotNull String str);

        public abstract void d();
    }

    public static final ObservableSource j(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public static final void k(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void m(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void f(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Function0<p> function0) {
        s.i(context, "context");
        PayReq payReq = new PayReq();
        payReq.appId = "wxbb62cffc9aa42285";
        payReq.partnerId = "1594795801";
        payReq.packageValue = "Sign=WXPay";
        payReq.prepayId = str;
        payReq.nonceStr = str2;
        payReq.timeStamp = str3;
        payReq.sign = str4;
        this.f12117a = str5;
        IWXAPI P = NetworkClient.f11868a.P(context);
        if (P != null) {
            P.sendReq(payReq);
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean h(Activity activity) {
        return !activity.isDestroyed();
    }

    public final void i(@NotNull final WXEntryPayResultEvent event, @NotNull final a resultListener, @NotNull final Activity activity) {
        s.i(event, "event");
        s.i(resultListener, "resultListener");
        s.i(activity, "activity");
        final String str = this.f12117a;
        if (str == null) {
            return;
        }
        Observable delay = Observable.just(str).delay(3L, TimeUnit.SECONDS);
        final Function1<String, ObservableSource<? extends Result<? extends OrderDataResult>>> function1 = new Function1<String, ObservableSource<? extends Result<? extends OrderDataResult>>>() { // from class: com.cupidapp.live.base.router.WeChatPayHelper$handlerPayResult$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ObservableSource<? extends Result<OrderDataResult>> invoke(@NotNull String it) {
                s.i(it, "it");
                return NetworkClient.f11868a.p().c(it, WXEntryPayResultEvent.this.getCode());
            }
        };
        Observable observeOn = delay.flatMap(new Function() { // from class: com.cupidapp.live.base.router.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource j10;
                j10 = WeChatPayHelper.j(Function1.this, obj);
                return j10;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<Disposable, p> function12 = new Function1<Disposable, p>() { // from class: com.cupidapp.live.base.router.WeChatPayHelper$handlerPayResult$2
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
                WeChatPayHelper.a.this.d();
            }
        };
        Observable flatMap = observeOn.doOnSubscribe(new Consumer() { // from class: com.cupidapp.live.base.router.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WeChatPayHelper.k(Function1.this, obj);
            }
        }).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<OrderDataResult, p> function13 = new Function1<OrderDataResult, p>() { // from class: com.cupidapp.live.base.router.WeChatPayHelper$handlerPayResult$3

            /* compiled from: WeChatPayHelper.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f12118a;

                static {
                    int[] iArr = new int[PurchaseStatus.values().length];
                    try {
                        iArr[PurchaseStatus.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PurchaseStatus.CLOSED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PurchaseStatus.UNPAID.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[PurchaseStatus.WAITING_FOR_COMFIRM.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f12118a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(OrderDataResult orderDataResult) {
                invoke2(orderDataResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OrderDataResult it) {
                boolean h10;
                p1.g.f52734a.W1(it.getBalance());
                PurchaseStatus valueOf = PurchaseStatus.valueOf(it.getOrder().getStatus());
                h10 = WeChatPayHelper.this.h(activity);
                if (h10) {
                    resultListener.a();
                    WeChatPayHelper.a aVar = resultListener;
                    s.h(it, "it");
                    aVar.c(it, valueOf, str);
                }
                if (com.cupidapp.live.base.utils.a.a(activity) == null) {
                    int i10 = a.f12118a[valueOf.ordinal()];
                    if (i10 == 1) {
                        com.cupidapp.live.base.view.h.f12779a.c(activity, R$string.alipay_success);
                        return;
                    }
                    if (i10 == 2) {
                        com.cupidapp.live.base.view.h.f12779a.r(activity, R$string.alipay_close);
                    } else if (i10 == 3) {
                        com.cupidapp.live.base.view.h.f12779a.r(activity, R$string.alipay_cancel);
                    } else {
                        if (i10 != 4) {
                            return;
                        }
                        com.cupidapp.live.base.view.h.f12779a.r(activity, R$string.alipay_watting);
                    }
                }
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.base.router.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WeChatPayHelper.l(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function14 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.router.WeChatPayHelper$handlerPayResult$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                boolean h10;
                h10 = WeChatPayHelper.this.h(activity);
                if (h10) {
                    resultListener.a();
                    WeChatPayHelper.a aVar = resultListener;
                    s.h(it, "it");
                    if (aVar.b(it)) {
                        return;
                    }
                    com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, null, null, null, 14, null);
                    return;
                }
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                s.h(it, "it");
                com.cupidapp.live.base.network.j.f(jVar, it, null, null, null, 14, null);
            }
        };
        flatMap.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.router.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WeChatPayHelper.m(Function1.this, obj);
            }
        });
    }

    public final void n() {
        this.f12117a = null;
    }
}
