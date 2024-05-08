package com.cupidapp.live.superboost.purchase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.router.PurchaseStatus;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.setting.activity.EditUserInfoActivity;
import com.cupidapp.live.superboost.persenter.SuperBoostPurchasePresenter;
import com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.wrapper.BasePurchaseWrapper;
import com.cupidapp.live.vip.wrapper.VasFunctionType;
import j1.i;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperBoostPurchaseWrapper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostPurchaseWrapper extends BasePurchaseWrapper implements com.cupidapp.live.superboost.persenter.a {

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public SuperBoostPurchaseLayout f18608l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public SuperLikePurchaseSkuModel f18609m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public String f18610n;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final SuperBoostPurchasePresenter f18607k = new SuperBoostPurchasePresenter(this);

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public List<VasFunctionType> f18611o = s.o(VasFunctionType.SUPER_BOOST);

    /* compiled from: SuperBoostPurchaseWrapper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18612a;

        static {
            int[] iArr = new int[PayType.values().length];
            try {
                iArr[PayType.AliPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PayType.AliPayHuaBei.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PayType.WeChatPay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18612a = iArr;
        }
    }

    /* compiled from: SuperBoostPurchaseWrapper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements SuperBoostPurchaseLayout.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f18614b;

        public b(Context context) {
            this.f18614b = context;
        }

        @Override // com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.a
        public void a(@NotNull SuperLikePurchaseSkuModel skuModel, @NotNull PayType payType, @Nullable SuperBoostType superBoostType) {
            kotlin.jvm.internal.s.i(skuModel, "skuModel");
            kotlin.jvm.internal.s.i(payType, "payType");
            z3.d.f54832a.f(SuperBoostPurchaseWrapper.this.f18610n, superBoostType != null ? superBoostType.getValue() : null);
            SuperBoostPurchasePresenter superBoostPurchasePresenter = SuperBoostPurchaseWrapper.this.f18607k;
            Context it = this.f18614b;
            kotlin.jvm.internal.s.h(it, "it");
            superBoostPurchasePresenter.e(it, skuModel, payType);
        }
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void A() {
        SuperBoostPurchaseLayout superBoostPurchaseLayout = this.f18608l;
        if (superBoostPurchaseLayout != null) {
            superBoostPurchaseLayout.v();
        }
        J();
    }

    public final void O(@NotNull Context context, @Nullable String str) {
        kotlin.jvm.internal.s.i(context, "context");
        Dialog u10 = u();
        if (u10 != null && u10.isShowing()) {
            return;
        }
        this.f18610n = str;
        H(new WeakReference<>(context));
        this.f18607k.i();
    }

    @Override // com.cupidapp.live.superboost.persenter.a
    public void b() {
        SuperBoostPurchaseLayout superBoostPurchaseLayout = this.f18608l;
        if (superBoostPurchaseLayout != null) {
            superBoostPurchaseLayout.v();
        }
    }

    @Override // com.cupidapp.live.superboost.persenter.a
    public void d() {
        final Context context;
        WeakReference<Context> v2 = v();
        if (v2 == null || (context = v2.get()) == null) {
            return;
        }
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.f12698l.b(context, true), R$string.change_avatar_msg, 0, 2, null), R$string.change_avatar, null, new Function0<p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseWrapper$showChangeUserAvatar$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                EditUserInfoActivity.f17947y.a(context, SensorScene.Match.getValue(), false);
            }
        }, 2, null).j(false), 0, null, 3, null), null, 1, null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        this.f18607k.g();
    }

    @Override // com.cupidapp.live.superboost.persenter.a
    public void e(@NotNull SuperLikePurchaseModel nonDirectModel, @NotNull SuperLikePurchaseModel directModel, @NotNull SuperLikePurchaseModel travelModel, @NotNull SuperBoostType defaultTab) {
        Context context;
        kotlin.jvm.internal.s.i(nonDirectModel, "nonDirectModel");
        kotlin.jvm.internal.s.i(directModel, "directModel");
        kotlin.jvm.internal.s.i(travelModel, "travelModel");
        kotlin.jvm.internal.s.i(defaultTab, "defaultTab");
        WeakReference<Context> v2 = v();
        if (v2 == null || (context = v2.get()) == null) {
            return;
        }
        SuperBoostPurchaseLayout superBoostPurchaseLayout = new SuperBoostPurchaseLayout(context);
        this.f18608l = superBoostPurchaseLayout;
        G(superBoostPurchaseLayout.z(nonDirectModel, directModel, travelModel, this.f18610n, defaultTab));
        p(context);
        SuperBoostPurchaseLayout superBoostPurchaseLayout2 = this.f18608l;
        if (superBoostPurchaseLayout2 != null) {
            superBoostPurchaseLayout2.setVipPurchaseClickListener(new b(context));
        }
    }

    @Override // com.cupidapp.live.superboost.persenter.a
    public void g(@NotNull final SuperLikePurchaseSkuModel skuModel, @NotNull final PayType payType) {
        kotlin.jvm.internal.s.i(skuModel, "skuModel");
        kotlin.jvm.internal.s.i(payType, "payType");
        FKAlertDialog.a aVar = FKAlertDialog.f12698l;
        WeakReference<Context> v2 = v();
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(aVar, v2 != null ? v2.get() : null, false, 2, null).j(false), R$string.super_boost_purchase_prompt, 0, 2, null), R$string.determine, null, new Function0<p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseWrapper$showCustomStealthPrompt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SuperBoostPurchaseWrapper.this.i(skuModel, payType);
                i.f50236a.a(PopupName.SUPER_BOOST_UNABLE_DISTANCE, PopupButtonName.Confirm, SensorPosition.Match);
            }
        }, 2, null), 0, new Function0<p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseWrapper$showCustomStealthPrompt$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.f50236a.a(PopupName.SUPER_BOOST_UNABLE_DISTANCE, PopupButtonName.Cancel, SensorPosition.Match);
            }
        }, 1, null), null, 1, null);
        i.g(i.f50236a, PopupName.SUPER_BOOST_UNABLE_DISTANCE, SensorPosition.Match, null, 4, null);
    }

    @Override // com.cupidapp.live.vip.wrapper.c
    public void h(@NotNull CreateOrderModel orderModel, @NotNull PayType payType) {
        Context it;
        kotlin.jvm.internal.s.i(orderModel, "orderModel");
        kotlin.jvm.internal.s.i(payType, "payType");
        E(orderModel.getCallback());
        m();
        PayInfoModel payInfo = orderModel.getPayInfo();
        if (payInfo != null) {
            int i10 = a.f18612a[payType.ordinal()];
            if (i10 != 1 && i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                WeakReference<Context> v2 = v();
                if (v2 == null || (it = v2.get()) == null) {
                    return;
                }
                kotlin.jvm.internal.s.h(it, "it");
                L(it, payInfo);
                return;
            }
            WeakReference<Context> v10 = v();
            Object obj = v10 != null ? (Context) v10.get() : null;
            Activity activity = obj instanceof Activity ? (Activity) obj : null;
            if (activity == null || payInfo.getPayInfo() == null || payInfo.getOrderId() == null) {
                return;
            }
            String info = URLDecoder.decode(payInfo.getPayInfo(), "utf-8");
            kotlin.jvm.internal.s.h(info, "info");
            o(activity, info, payInfo.getOrderId(), payType);
        }
    }

    @Override // com.cupidapp.live.superboost.persenter.a
    public void i(@NotNull SuperLikePurchaseSkuModel skuModel, @NotNull PayType payType) {
        Context context;
        kotlin.jvm.internal.s.i(skuModel, "skuModel");
        kotlin.jvm.internal.s.i(payType, "payType");
        if (payType == PayType.WeChatPay) {
            NetworkClient networkClient = NetworkClient.f11868a;
            WeakReference<Context> v2 = v();
            if (networkClient.P(v2 != null ? v2.get() : null) == null) {
                return;
            }
        }
        F(true);
        this.f18609m = skuModel;
        WeakReference<Context> v10 = v();
        if (v10 == null || (context = v10.get()) == null) {
            return;
        }
        this.f18607k.f(context, skuModel, payType);
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    @NotNull
    public List<VasFunctionType> w() {
        return this.f18611o;
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void z(@NotNull PurchaseStatus status, @NotNull PayType payType, @NotNull String orderId) {
        SuperLikePurchaseSkuModel superLikePurchaseSkuModel;
        Context context;
        kotlin.jvm.internal.s.i(status, "status");
        kotlin.jvm.internal.s.i(payType, "payType");
        kotlin.jvm.internal.s.i(orderId, "orderId");
        SuperBoostPurchaseLayout superBoostPurchaseLayout = this.f18608l;
        if (superBoostPurchaseLayout != null) {
            superBoostPurchaseLayout.v();
        }
        WeakReference<Context> v2 = v();
        if (v2 != null && (context = v2.get()) != null) {
            this.f18607k.a(context);
        }
        if (status == PurchaseStatus.SUCCESS && (superLikePurchaseSkuModel = this.f18609m) != null) {
            z3.d.f54832a.h(this.f18610n, superLikePurchaseSkuModel.getTitle(), payType, superLikePurchaseSkuModel.getPriceFormatted());
        }
        j.a aVar = j.f12156c;
        WeakReference<Context> v10 = v();
        j.a.b(aVar, v10 != null ? v10.get() : null, s(), null, 4, null);
    }
}
