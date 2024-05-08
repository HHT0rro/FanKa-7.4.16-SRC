package com.cupidapp.live.vip.wrapper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.DefaultEvent;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.router.AlipayHelper;
import com.cupidapp.live.base.router.OrderDataResult;
import com.cupidapp.live.base.router.PurchaseStatus;
import com.cupidapp.live.base.router.WeChatPayHelper;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.vip.model.MarketPopInfoModel;
import com.cupidapp.live.vip.model.PayInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.wxapi.event.WXEntryPayResultEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BasePurchaseWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class BasePurchaseWrapper implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Dialog f18817d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public WeakReference<Context> f18818e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f18819f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18820g;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f18815b = kotlin.c.b(new Function0<AlipayHelper>() { // from class: com.cupidapp.live.vip.wrapper.BasePurchaseWrapper$aliPayHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AlipayHelper invoke() {
            return new AlipayHelper();
        }
    });

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f18816c = kotlin.c.b(new Function0<WeChatPayHelper>() { // from class: com.cupidapp.live.vip.wrapper.BasePurchaseWrapper$weChatPayHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final WeChatPayHelper invoke() {
            return new WeChatPayHelper();
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f18821h = kotlin.c.b(new Function0<com.cupidapp.live.base.utils.i>() { // from class: com.cupidapp.live.vip.wrapper.BasePurchaseWrapper$countDownTimer$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final com.cupidapp.live.base.utils.i invoke() {
            return new com.cupidapp.live.base.utils.i();
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public VipPurchaseEntranceType f18822i = VipPurchaseEntranceType.Nearby;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public List<VasFunctionType> f18823j = new ArrayList();

    /* compiled from: BasePurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18824a;

        static {
            int[] iArr = new int[SensorPosition.values().length];
            try {
                iArr[SensorPosition.Feed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorPosition.Accessibility.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SensorPosition.Message.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SensorPosition.MessageDetail.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f18824a = iArr;
        }
    }

    /* compiled from: BasePurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends AlipayHelper.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PayType f18826b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f18827c;

        public b(PayType payType, String str) {
            this.f18826b = payType;
            this.f18827c = str;
        }

        @Override // com.cupidapp.live.base.router.AlipayHelper.b
        public boolean b(@NotNull Throwable t2) {
            kotlin.jvm.internal.s.i(t2, "t");
            BasePurchaseWrapper.this.a();
            BasePurchaseWrapper.this.A();
            return true;
        }

        @Override // com.cupidapp.live.base.router.AlipayHelper.b
        public void c(@NotNull OrderDataResult orderDataResult, @NotNull PurchaseStatus purchaseStatus) {
            kotlin.jvm.internal.s.i(orderDataResult, "orderDataResult");
            kotlin.jvm.internal.s.i(purchaseStatus, "purchaseStatus");
            BasePurchaseWrapper.this.a();
            BasePurchaseWrapper.this.z(purchaseStatus, this.f18826b, this.f18827c);
        }

        @Override // com.cupidapp.live.base.router.AlipayHelper.b
        public void d() {
            BasePurchaseWrapper.this.K();
        }
    }

    /* compiled from: BasePurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends WeChatPayHelper.a {
        public c() {
        }

        @Override // com.cupidapp.live.base.router.WeChatPayHelper.a
        public boolean b(@NotNull Throwable t2) {
            kotlin.jvm.internal.s.i(t2, "t");
            BasePurchaseWrapper.this.a();
            BasePurchaseWrapper.this.A();
            return true;
        }

        @Override // com.cupidapp.live.base.router.WeChatPayHelper.a
        public void c(@NotNull OrderDataResult orderDataResult, @NotNull PurchaseStatus purchaseStatus, @NotNull String orderId) {
            kotlin.jvm.internal.s.i(orderDataResult, "orderDataResult");
            kotlin.jvm.internal.s.i(purchaseStatus, "purchaseStatus");
            kotlin.jvm.internal.s.i(orderId, "orderId");
            BasePurchaseWrapper.this.a();
            BasePurchaseWrapper.this.z(purchaseStatus, PayType.WeChatPay, orderId);
        }

        @Override // com.cupidapp.live.base.router.WeChatPayHelper.a
        public void d() {
            BasePurchaseWrapper.this.K();
        }
    }

    public static final void D(DialogInterface dialogInterface) {
    }

    public static final void q(BasePurchaseWrapper this$0, final Context context, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        List<VasFunctionType> w3 = this$0.w();
        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(w3, 10));
        Iterator<VasFunctionType> iterator2 = w3.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(Integer.valueOf(iterator2.next().getValue()));
        }
        Disposable disposed = NetworkClient.f11868a.p().b(arrayList).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MarketPopInfoModel, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.BasePurchaseWrapper$dialogDismissJumpWeb$lambda$2$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MarketPopInfoModel marketPopInfoModel) {
                m2834invoke(marketPopInfoModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2834invoke(MarketPopInfoModel marketPopInfoModel) {
                j.a.b(com.cupidapp.live.base.router.j.f12156c, context, marketPopInfoModel.getUrl(), null, 4, null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public abstract void A();

    public final void B(@NotNull Lifecycle lifecycle) {
        kotlin.jvm.internal.s.i(lifecycle, "lifecycle");
        lifecycle.addObserver(this);
    }

    public final void C() {
        Dialog dialog = this.f18817d;
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.vip.wrapper.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    BasePurchaseWrapper.D(dialogInterface);
                }
            });
        }
    }

    public final void E(@Nullable String str) {
        this.f18819f = str;
    }

    public final void F(boolean z10) {
        this.f18820g = z10;
    }

    public final void G(@Nullable Dialog dialog) {
        this.f18817d = dialog;
    }

    public final void H(@Nullable WeakReference<Context> weakReference) {
        this.f18818e = weakReference;
    }

    public final void I(@NotNull VipPurchaseEntranceType vipPurchaseEntranceType) {
        kotlin.jvm.internal.s.i(vipPurchaseEntranceType, "<set-?>");
        this.f18822i = vipPurchaseEntranceType;
    }

    public final void J() {
        com.cupidapp.live.base.view.h hVar = com.cupidapp.live.base.view.h.f12779a;
        WeakReference<Context> weakReference = this.f18818e;
        hVar.r(weakReference != null ? weakReference.get() : null, R$string.alipay_close);
    }

    public final void K() {
        String str;
        Context context;
        Dialog dialog = this.f18817d;
        if (dialog != null) {
            WeakReference<Context> weakReference = this.f18818e;
            if (weakReference == null || (context = weakReference.get()) == null || (str = context.getString(R$string.please_wait)) == null) {
                str = "";
            }
            z0.d.p(dialog, str);
        }
    }

    public final void L(@NotNull Context context, @NotNull PayInfoModel payInfo) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(payInfo, "payInfo");
        WeChatPayHelper.g(y(), context, payInfo.getPrepayId(), payInfo.getNonceStr(), payInfo.getTimestamp(), payInfo.getSign(), payInfo.getOrderId(), null, 64, null);
    }

    public final void a() {
        Dialog dialog = this.f18817d;
        if (dialog != null) {
            z0.d.c(dialog);
        }
    }

    public final void m() {
        if (TextUtils.isEmpty(this.f18819f)) {
            return;
        }
        int i10 = a.f18824a[this.f18822i.getPosition().ordinal()];
        if (i10 == 1) {
            if (this.f18822i.getScene() != CreateOrderScene.SuperLike.getValue()) {
                this.f18819f = this.f18819f + "&ref=feed";
                return;
            }
            return;
        }
        if (i10 == 2) {
            this.f18819f = this.f18819f + "&ref=vipPrivilege";
            return;
        }
        if (i10 == 3 || i10 == 4) {
            this.f18819f = this.f18819f + "&ref=quietLookMessages";
        }
    }

    public final void o(@NotNull Activity activity, @NotNull String payInfo, @NotNull String orderId, @NotNull PayType payType) {
        kotlin.jvm.internal.s.i(activity, "activity");
        kotlin.jvm.internal.s.i(payInfo, "payInfo");
        kotlin.jvm.internal.s.i(orderId, "orderId");
        kotlin.jvm.internal.s.i(payType, "payType");
        r().h(activity, payInfo, orderId, new b(payType, orderId));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f18817d = null;
        y().n();
        t().g();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull DefaultEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull WXEntryPayResultEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (!this.f18820g || this.f18818e == null) {
            return;
        }
        EventBus.c().r(event);
        WeakReference<Context> weakReference = this.f18818e;
        if ((weakReference != null ? weakReference.get() : null) instanceof Activity) {
            this.f18820g = false;
            t().g();
            WeChatPayHelper y10 = y();
            c cVar = new c();
            WeakReference<Context> weakReference2 = this.f18818e;
            kotlin.jvm.internal.s.f(weakReference2);
            Context context = weakReference2.get();
            kotlin.jvm.internal.s.g(context, "null cannot be cast to non-null type android.app.Activity");
            y10.i(event, cVar, (Activity) context);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        y0.a.f54658a.c(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        y0.a.b(y0.a.f54658a, this, null, 2, null);
        if (this.f18820g) {
            com.cupidapp.live.base.utils.i.d(t(), 5, 1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.BasePurchaseWrapper$onResume$1
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
                    BasePurchaseWrapper.this.a();
                }
            }, null, 8, null);
            this.f18820g = false;
        }
    }

    public final void p(@Nullable final Context context) {
        Dialog dialog;
        if (context == null || w().isEmpty() || (dialog = this.f18817d) == null) {
            return;
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.vip.wrapper.a
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BasePurchaseWrapper.q(BasePurchaseWrapper.this, context, dialogInterface);
            }
        });
    }

    public final AlipayHelper r() {
        return (AlipayHelper) this.f18815b.getValue();
    }

    @Nullable
    public final String s() {
        return this.f18819f;
    }

    public final com.cupidapp.live.base.utils.i t() {
        return (com.cupidapp.live.base.utils.i) this.f18821h.getValue();
    }

    @Nullable
    public final Dialog u() {
        return this.f18817d;
    }

    @Nullable
    public final WeakReference<Context> v() {
        return this.f18818e;
    }

    @NotNull
    public List<VasFunctionType> w() {
        return this.f18823j;
    }

    @NotNull
    public final VipPurchaseEntranceType x() {
        return this.f18822i;
    }

    public final WeChatPayHelper y() {
        return (WeChatPayHelper) this.f18816c.getValue();
    }

    public abstract void z(@NotNull PurchaseStatus purchaseStatus, @NotNull PayType payType, @NotNull String str);
}
