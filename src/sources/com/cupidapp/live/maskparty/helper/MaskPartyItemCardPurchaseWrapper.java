package com.cupidapp.live.maskparty.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.cupidapp.live.base.router.PurchaseStatus;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.wrapper.BasePurchaseWrapper;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardPurchaseWrapper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardPurchaseWrapper extends BasePurchaseWrapper {

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public Function0<p> f16345k;

    /* compiled from: MaskPartyItemCardPurchaseWrapper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16346a;

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
            f16346a = iArr;
        }
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void A() {
        J();
    }

    public final void M(@NotNull Activity activity, @NotNull CreateOrderModel order, @NotNull PayType payType) {
        s.i(activity, "activity");
        s.i(order, "order");
        s.i(payType, "payType");
        F(true);
        E(order.getCallback());
        PayInfoModel payInfo = order.getPayInfo();
        if (payInfo != null) {
            int i10 = a.f16346a[payType.ordinal()];
            if (i10 != 1 && i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                L(activity, payInfo);
            } else {
                if (payInfo.getPayInfo() == null || payInfo.getOrderId() == null) {
                    return;
                }
                String info = URLDecoder.decode(payInfo.getPayInfo(), "utf-8");
                s.h(info, "info");
                o(activity, info, payInfo.getOrderId(), payType);
            }
        }
    }

    public final void N(@Nullable Dialog dialog, @NotNull Context context) {
        s.i(context, "context");
        G(dialog);
        H(new WeakReference<>(context));
    }

    public final void O(@Nullable Function0<p> function0) {
        this.f16345k = function0;
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void z(@NotNull PurchaseStatus status, @NotNull PayType payType, @NotNull String orderId) {
        Function0<p> function0;
        s.i(status, "status");
        s.i(payType, "payType");
        s.i(orderId, "orderId");
        if (status != PurchaseStatus.SUCCESS || (function0 = this.f16345k) == null) {
            return;
        }
        function0.invoke();
    }
}
