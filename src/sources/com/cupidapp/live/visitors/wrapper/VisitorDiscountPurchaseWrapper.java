package com.cupidapp.live.visitors.wrapper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.router.PurchaseStatus;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.wrapper.BasePurchaseWrapper;
import com.cupidapp.live.visitors.event.RefreshVisitorsListEvent;
import com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout;
import com.cupidapp.live.visitors.model.VisitorRecallResult;
import com.cupidapp.live.visitors.persenter.VisitorDiscountPresenter;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorDiscountPurchaseWrapper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorDiscountPurchaseWrapper extends BasePurchaseWrapper implements com.cupidapp.live.visitors.persenter.a {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final VisitorDiscountPresenter f18971k = new VisitorDiscountPresenter(this);

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public VisitorDiscountPurchaseLayout f18972l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public VipPurchasePriceModel f18973m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public String f18974n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public String f18975o;

    /* compiled from: VisitorDiscountPurchaseWrapper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18976a;

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
            f18976a = iArr;
        }
    }

    /* compiled from: VisitorDiscountPurchaseWrapper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements VisitorDiscountPurchaseLayout.a {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout.a
        public void a(@NotNull VipPurchasePriceModel skuModel, @NotNull PayType payType) {
            Context context;
            s.i(skuModel, "skuModel");
            s.i(payType, "payType");
            z3.d.f54832a.l(VisitorDiscountPurchaseWrapper.this.f18974n, VisitorDiscountPurchaseWrapper.this.f18975o);
            if (payType == PayType.WeChatPay) {
                NetworkClient networkClient = NetworkClient.f11868a;
                WeakReference v2 = VisitorDiscountPurchaseWrapper.this.v();
                if (networkClient.P(v2 != null ? (Context) v2.get() : null) == null) {
                    return;
                }
            }
            VisitorDiscountPurchaseWrapper.this.F(true);
            VisitorDiscountPurchaseWrapper.this.f18973m = skuModel;
            WeakReference v10 = VisitorDiscountPurchaseWrapper.this.v();
            if (v10 == null || (context = (Context) v10.get()) == null) {
                return;
            }
            VisitorDiscountPurchaseWrapper visitorDiscountPurchaseWrapper = VisitorDiscountPurchaseWrapper.this;
            visitorDiscountPurchaseWrapper.f18971k.b(context, visitorDiscountPurchaseWrapper.f18974n, skuModel, payType, visitorDiscountPurchaseWrapper.x().getScene());
        }
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void A() {
        VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout = this.f18972l;
        if (visitorDiscountPurchaseLayout != null) {
            visitorDiscountPurchaseLayout.t();
        }
        J();
    }

    public final void T(@NotNull VisitorRecallResult model) {
        Context context;
        s.i(model, "model");
        WeakReference<Context> v2 = v();
        if (v2 != null && (context = v2.get()) != null) {
            VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout = new VisitorDiscountPurchaseLayout(context);
            this.f18972l = visitorDiscountPurchaseLayout;
            G(visitorDiscountPurchaseLayout.y(model));
            VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout2 = this.f18972l;
            if (visitorDiscountPurchaseLayout2 != null) {
                visitorDiscountPurchaseLayout2.setVipPurchaseClickListener(new b());
            }
        }
        z3.d.f54832a.m(this.f18974n, this.f18975o);
    }

    public final void U(@NotNull Context context, @Nullable String str, @NotNull VisitorRecallResult model) {
        s.i(context, "context");
        s.i(model, "model");
        Dialog u10 = u();
        if (u10 != null && u10.isShowing()) {
            return;
        }
        this.f18975o = model.getDiscountReason();
        this.f18974n = str;
        H(new WeakReference<>(context));
        T(model);
    }

    @Override // com.cupidapp.live.vip.wrapper.c
    public void h(@NotNull CreateOrderModel orderModel, @NotNull PayType payType) {
        Context it;
        s.i(orderModel, "orderModel");
        s.i(payType, "payType");
        E(orderModel.getCallback());
        m();
        PayInfoModel payInfo = orderModel.getPayInfo();
        if (payInfo != null) {
            int i10 = a.f18976a[payType.ordinal()];
            if (i10 != 1 && i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                WeakReference<Context> v2 = v();
                if (v2 == null || (it = v2.get()) == null) {
                    return;
                }
                s.h(it, "it");
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
            s.h(info, "info");
            o(activity, info, payInfo.getOrderId(), payType);
        }
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void z(@NotNull PurchaseStatus status, @NotNull PayType payType, @NotNull String orderId) {
        s.i(status, "status");
        s.i(payType, "payType");
        s.i(orderId, "orderId");
        VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout = this.f18972l;
        if (visitorDiscountPurchaseLayout != null) {
            visitorDiscountPurchaseLayout.t();
        }
        if (status == PurchaseStatus.SUCCESS) {
            EventBus.c().l(new RefreshVisitorsListEvent());
            VipPurchasePriceModel vipPurchasePriceModel = this.f18973m;
            if (vipPurchasePriceModel != null) {
                z3.d.f54832a.n(this.f18974n, vipPurchasePriceModel.getTitle(), vipPurchasePriceModel.price(), this.f18975o);
            }
        }
        j.a aVar = j.f12156c;
        WeakReference<Context> v2 = v();
        j.a.b(aVar, v2 != null ? v2.get() : null, s(), null, 4, null);
    }
}
