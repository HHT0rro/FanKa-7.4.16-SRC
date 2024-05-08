package com.cupidapp.live.base.router;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.liveshow.view.giftpicker.model.DiamondResult;
import com.cupidapp.live.liveshow.view.giftpicker.model.RechargeDiamondResult;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.MarketPopInfoModel;
import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import com.cupidapp.live.vip.model.VipDiscountPromptModel;
import com.cupidapp.live.vip.model.VipOptionsModel;
import com.cupidapp.live.vip.model.VipStrategyModel;
import com.cupidapp.live.visitors.model.VisitorPurchaseResult;
import com.cupidapp.live.visitors.model.VisitorRecallResult;
import io.reactivex.Observable;
import java.util.List;
import ne.s;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IAPService.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface g {

    /* compiled from: IAPService.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public static /* synthetic */ Observable a(g gVar, int i10, int i11, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animLoadedCallBack");
            }
            if ((i12 & 2) != 0) {
                i11 = 1;
            }
            return gVar.n(i10, i11);
        }

        public static /* synthetic */ Observable b(g gVar, Integer num, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVipBilling");
            }
            if ((i10 & 1) != 0) {
                num = null;
            }
            return gVar.q(num);
        }
    }

    @ne.f("/vas/marketing/polling-info")
    @NotNull
    Observable<Result<VipDiscountPromptModel>> a();

    @ne.o("/vas/marketing/popinfo")
    @ne.e
    @NotNull
    Observable<Result<MarketPopInfoModel>> b(@ne.c("productType[]") @NotNull List<Integer> list);

    @ne.o("/billing/purchase/weixin-result")
    @ne.e
    @NotNull
    Observable<Result<OrderDataResult>> c(@ne.c("orderId") @NotNull String str, @ne.c("code") @Nullable Integer num);

    @ne.o("/billing/visitor/create-order")
    @ne.e
    @NotNull
    Observable<Result<CreateOrderModel>> d(@ne.c("receiptType") int i10, @ne.c("id") @NotNull String str, @ne.c("skuCode") @Nullable String str2, @ne.c("actCodes") @Nullable String str3, @ne.c("promoCodes") @Nullable String str4, @ne.c("scene") @Nullable Integer num);

    @ne.o("/billing/vip/getDiscountDescription")
    @ne.e
    @NotNull
    Observable<Result<VipDiscountDescriptionResult>> e(@ne.c("userId") @Nullable String str);

    @ne.f("/billingv2/sku/{productType}")
    @NotNull
    Observable<Result<SuperLikePurchaseModel>> f(@s("productType") @NotNull String str);

    @ne.o("/billingv2/diamond/create-order")
    @ne.e
    @NotNull
    Observable<Result<CreateOrderModel>> g(@ne.c("skuCode") @NotNull String str, @ne.c("receiptType") int i10, @ne.c("scene") int i11, @ne.c("price") float f10);

    @ne.f("/vas/visitor/sku")
    @NotNull
    Observable<Result<VisitorPurchaseResult>> h();

    @ne.f("/billingv2/check-pay-result")
    @NotNull
    Observable<Result<RechargeDiamondResult>> i(@t("payOrderId") @NotNull String str);

    @ne.f("/billing/assets/recall")
    @NotNull
    Observable<Result<VisitorRecallResult>> j(@t("productType") @Nullable Integer num, @t("actCodes") @Nullable Integer num2);

    @ne.f("/billingv2/sku/diamond")
    @NotNull
    Observable<Result<DiamondResult>> k(@t("liveShowId") @Nullable String str, @t("roomId") @Nullable String str2);

    @ne.o("billing/purchase/alipay-result")
    @ne.e
    @NotNull
    Observable<Result<OrderDataResult>> l(@ne.c("orderId") @NotNull String str, @ne.c("data") @NotNull String str2);

    @ne.o("/billingv2/{category}/create-order")
    @ne.e
    @NotNull
    Observable<Result<CreateOrderModel>> m(@s("category") @NotNull String str, @ne.c("receiptType") int i10, @ne.c("skuCode") @Nullable String str2, @ne.c("actCodes") @Nullable String str3, @ne.c("promoCodes") @Nullable String str4, @ne.c("scene") @Nullable Integer num);

    @ne.o("/vas/marketing/strategy-popup-callback")
    @ne.e
    @NotNull
    Observable<Result<Object>> n(@ne.c("type") int i10, @ne.c("sourceType") int i11);

    @ne.f("/vas/marketing/check-strategy-popup")
    @NotNull
    Observable<Result<VipStrategyModel>> o(@t("productType") @Nullable Integer num, @t("sourceType") @Nullable Integer num2);

    @ne.o("/billing/vip/create-order")
    @ne.e
    @NotNull
    Observable<Result<CreateOrderModel>> p(@ne.c("id") @Nullable String str, @ne.c("receiptType") int i10, @ne.c("skuCode") @Nullable String str2, @ne.c("actCodes") @Nullable String str3, @ne.c("promoCodes") @Nullable String str4, @ne.c("scene") @Nullable Integer num);

    @ne.f("/billing/vip/pay-page")
    @NotNull
    Observable<Result<VipOptionsModel>> q(@t("vipType") @Nullable Integer num);
}
