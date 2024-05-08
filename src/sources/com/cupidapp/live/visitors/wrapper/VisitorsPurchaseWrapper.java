package com.cupidapp.live.visitors.wrapper;

import android.app.Dialog;
import android.content.Context;
import com.cupidapp.live.base.router.PurchaseStatus;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.wrapper.BasePurchaseWrapper;
import com.cupidapp.live.visitors.event.RefreshVisitorsListEvent;
import com.cupidapp.live.visitors.model.VisitorsPurchasePriceModel;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsPurchaseWrapper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsPurchaseWrapper extends BasePurchaseWrapper {

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public String f18978k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public VisitorsPurchasePriceModel f18979l;

    /* compiled from: VisitorsPurchaseWrapper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18980a;

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
            f18980a = iArr;
        }
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void A() {
        Dialog u10 = u();
        if (u10 != null) {
            u10.dismiss();
        }
        J();
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void z(@NotNull PurchaseStatus status, @NotNull PayType payType, @NotNull String orderId) {
        VisitorsPurchasePriceModel visitorsPurchasePriceModel;
        s.i(status, "status");
        s.i(payType, "payType");
        s.i(orderId, "orderId");
        Dialog u10 = u();
        if (u10 != null) {
            u10.dismiss();
        }
        PurchaseStatus purchaseStatus = PurchaseStatus.SUCCESS;
        if (status == purchaseStatus) {
            EventBus.c().l(new RefreshVisitorsListEvent());
        }
        j.a aVar = j.f12156c;
        WeakReference<Context> v2 = v();
        j.a.b(aVar, v2 != null ? v2.get() : null, s(), null, 4, null);
        if (status != purchaseStatus || (visitorsPurchasePriceModel = this.f18979l) == null) {
            return;
        }
        z3.d.f54832a.p(this.f18978k, visitorsPurchasePriceModel.price());
    }
}
