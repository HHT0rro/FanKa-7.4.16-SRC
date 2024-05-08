package com.cupidapp.live.base.router;

import android.app.Activity;
import android.util.Base64;
import com.alicom.tools.networking.RSA;
import com.alipay.sdk.app.PayTask;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.AlipayHelper;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AliypayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AlipayHelper {

    /* compiled from: AliypayHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0142a f12104a = new C0142a(null);

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f12105b = "7cd34577baef560d";

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final SecretKeySpec f12106c;

        /* compiled from: AliypayHelper.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.base.router.AlipayHelper$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0142a {
            public C0142a() {
            }

            public /* synthetic */ C0142a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final byte[] a(@NotNull String data) {
                byte[] doFinal;
                s.i(data, "data");
                Cipher cipherEncrypt = Cipher.getInstance(RSA.AES_ALGORITHM);
                cipherEncrypt.init(1, b());
                s.h(cipherEncrypt, "cipherEncrypt");
                synchronized (cipherEncrypt) {
                    byte[] bytes = data.getBytes(kotlin.text.c.f51097b);
                    s.h(bytes, "this as java.lang.String).getBytes(charset)");
                    doFinal = cipherEncrypt.doFinal(bytes);
                }
                return doFinal;
            }

            @NotNull
            public final SecretKeySpec b() {
                return a.f12106c;
            }
        }

        static {
            byte[] bytes = "7cd34577baef560d".getBytes(kotlin.text.c.f51097b);
            s.h(bytes, "this as java.lang.String).getBytes(charset)");
            f12106c = new SecretKeySpec(bytes, AESEncrypt.ALGORITHM);
        }
    }

    /* compiled from: AliypayHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract boolean b(@NotNull Throwable th);

        public abstract void c(@NotNull OrderDataResult orderDataResult, @NotNull PurchaseStatus purchaseStatus);

        public abstract void d();
    }

    /* compiled from: AliypayHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12107a;

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
            f12107a = iArr;
        }
    }

    public static final String i(Activity activity, String payInfo) {
        s.i(activity, "$activity");
        s.i(payInfo, "$payInfo");
        return new PayTask(activity).pay(payInfo, true);
    }

    public static final void j(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final ObservableSource k(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public static final void l(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void m(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void h(@NotNull final Activity activity, @NotNull final String payInfo, @NotNull final String orderId, @NotNull final b alipayListener) {
        s.i(activity, "activity");
        s.i(payInfo, "payInfo");
        s.i(orderId, "orderId");
        s.i(alipayListener, "alipayListener");
        Observable subscribeOn = Observable.fromCallable(new Callable() { // from class: com.cupidapp.live.base.router.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String i10;
                i10 = AlipayHelper.i(activity, payInfo);
                return i10;
            }
        }).subscribeOn(Schedulers.io());
        final Function1<Disposable, p> function1 = new Function1<Disposable, p>() { // from class: com.cupidapp.live.base.router.AlipayHelper$buy$2
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
                AlipayHelper.b.this.d();
            }
        };
        Observable delay = subscribeOn.doOnSubscribe(new Consumer() { // from class: com.cupidapp.live.base.router.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AlipayHelper.j(Function1.this, obj);
            }
        }).delay(3L, TimeUnit.SECONDS);
        final Function1<String, ObservableSource<? extends Result<? extends OrderDataResult>>> function12 = new Function1<String, ObservableSource<? extends Result<? extends OrderDataResult>>>() { // from class: com.cupidapp.live.base.router.AlipayHelper$buy$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ObservableSource<? extends Result<OrderDataResult>> invoke(@NotNull String it) {
                s.i(it, "it");
                g p10 = NetworkClient.f11868a.p();
                String str = String.this;
                String encodeToString = Base64.encodeToString(AlipayHelper.a.f12104a.a(it), 0);
                s.h(encodeToString, "encodeToString(AES.encrypt(it), 0)");
                return p10.l(str, encodeToString);
            }
        };
        Observable flatMap = delay.flatMap(new Function() { // from class: com.cupidapp.live.base.router.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource k10;
                k10 = AlipayHelper.k(Function1.this, obj);
                return k10;
            }
        }).observeOn(AndroidSchedulers.mainThread()).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<OrderDataResult, p> function13 = new Function1<OrderDataResult, p>() { // from class: com.cupidapp.live.base.router.AlipayHelper$buy$4
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
                AlipayHelper alipayHelper = AlipayHelper.this;
                s.h(it, "it");
                alipayHelper.o(it, activity, alipayListener);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.base.router.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AlipayHelper.l(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function14 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.router.AlipayHelper$buy$5
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
                boolean n10;
                n10 = AlipayHelper.this.n(activity);
                if (n10) {
                    alipayListener.a();
                    AlipayHelper.b bVar = alipayListener;
                    s.h(it, "it");
                    if (bVar.b(it)) {
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
        flatMap.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.router.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AlipayHelper.m(Function1.this, obj);
            }
        });
    }

    public final boolean n(Activity activity) {
        return !activity.isDestroyed();
    }

    public final void o(OrderDataResult orderDataResult, Activity activity, b bVar) {
        p1.g.f52734a.W1(orderDataResult.getBalance());
        PurchaseStatus valueOf = PurchaseStatus.valueOf(orderDataResult.getOrder().getStatus());
        com.cupidapp.live.base.utils.j.f12332a.a("aliPayResult", "status" + ((Object) valueOf) + " ");
        if (n(activity)) {
            bVar.a();
            bVar.c(orderDataResult, valueOf);
        }
        if (com.cupidapp.live.base.utils.a.a(activity) == null) {
            int i10 = c.f12107a[valueOf.ordinal()];
            if (i10 == 1) {
                com.cupidapp.live.base.view.h.f12779a.c(activity, R$string.iap_success);
                return;
            }
            if (i10 == 2) {
                com.cupidapp.live.base.view.h.f12779a.r(activity, R$string.iap_close);
            } else if (i10 == 3) {
                com.cupidapp.live.base.view.h.f12779a.r(activity, R$string.iap_cancel);
            } else {
                if (i10 != 4) {
                    return;
                }
                com.cupidapp.live.base.view.h.f12779a.r(activity, R$string.iap_watting);
            }
        }
    }
}
