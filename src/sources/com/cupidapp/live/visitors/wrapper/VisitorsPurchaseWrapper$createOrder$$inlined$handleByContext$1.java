package com.cupidapp.live.visitors.wrapper;

import android.app.Activity;
import android.content.Context;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.visitors.wrapper.VisitorsPurchaseWrapper;
import java.net.URLDecoder;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: ObservableExtension.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsPurchaseWrapper$createOrder$$inlined$handleByContext$1 extends Lambda implements Function1<CreateOrderModel, p> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ PayType $payType$inlined;
    public final /* synthetic */ VisitorsPurchaseWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsPurchaseWrapper$createOrder$$inlined$handleByContext$1(VisitorsPurchaseWrapper visitorsPurchaseWrapper, PayType payType, Context context) {
        super(1);
        this.this$0 = visitorsPurchaseWrapper;
        this.$payType$inlined = payType;
        this.$context$inlined = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(CreateOrderModel createOrderModel) {
        m2842invoke(createOrderModel);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2842invoke(CreateOrderModel createOrderModel) {
        CreateOrderModel createOrderModel2 = createOrderModel;
        this.this$0.E(createOrderModel2.getCallback());
        PayInfoModel payInfo = createOrderModel2.getPayInfo();
        if (payInfo != null) {
            int i10 = VisitorsPurchaseWrapper.a.f18980a[this.$payType$inlined.ordinal()];
            if (i10 != 1 && i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                this.this$0.L(this.$context$inlined, payInfo);
            } else {
                if (payInfo.getPayInfo() == null || payInfo.getOrderId() == null) {
                    return;
                }
                String info = URLDecoder.decode(payInfo.getPayInfo(), "utf-8");
                Context context = this.$context$inlined;
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null) {
                    VisitorsPurchaseWrapper visitorsPurchaseWrapper = this.this$0;
                    s.h(info, "info");
                    visitorsPurchaseWrapper.o(activity, info, payInfo.getOrderId(), this.$payType$inlined);
                }
            }
        }
    }
}
