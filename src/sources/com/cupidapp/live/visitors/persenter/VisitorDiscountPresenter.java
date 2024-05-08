package com.cupidapp.live.visitors.persenter;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.wrapper.BasePurchasePresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorDiscountPresenter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorDiscountPresenter extends BasePurchasePresenter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final a f18961b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorDiscountPresenter(@NotNull a visitorDiscountView) {
        super(visitorDiscountView);
        s.i(visitorDiscountView, "visitorDiscountView");
        this.f18961b = visitorDiscountView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(@NotNull Context context, @Nullable String str, @NotNull VipPurchasePriceModel model, @NotNull final PayType payType, int i10) {
        s.i(context, "context");
        s.i(model, "model");
        s.i(payType, "payType");
        Observable<Result<CreateOrderModel>> d10 = NetworkClient.f11868a.p().d(payType.getType(), model.getId(), model.getSkuCode(), model.getActCodes(), model.getPromoCodes(), Integer.valueOf(i10));
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.visitors.persenter.VisitorDiscountPresenter$createVisitorPurchaseOrder$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                VisitorDiscountPresenter.this.c().a();
                return Boolean.FALSE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = d10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CreateOrderModel, p>() { // from class: com.cupidapp.live.visitors.persenter.VisitorDiscountPresenter$createVisitorPurchaseOrder$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CreateOrderModel createOrderModel) {
                m2841invoke(createOrderModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2841invoke(CreateOrderModel createOrderModel) {
                VisitorDiscountPresenter.this.c().h(createOrderModel, payType);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final a c() {
        return this.f18961b;
    }
}
