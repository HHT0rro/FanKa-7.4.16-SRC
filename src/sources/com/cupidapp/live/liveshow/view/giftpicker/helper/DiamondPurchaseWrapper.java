package com.cupidapp.live.liveshow.view.giftpicker.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.PurchaseStatus;
import com.cupidapp.live.liveshow.view.giftpicker.helper.DiamondPurchaseWrapper;
import com.cupidapp.live.liveshow.view.giftpicker.model.DiamondModel;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.wrapper.BasePurchaseWrapper;
import com.cupidapp.live.vip.wrapper.CreateOrderScene;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DiamondPurchaseWrapper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiamondPurchaseWrapper extends BasePurchaseWrapper {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.liveshow.view.giftpicker.helper.a f15464k;

    /* compiled from: DiamondPurchaseWrapper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15465a;

        static {
            int[] iArr = new int[PayType.values().length];
            try {
                iArr[PayType.WeChatPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PayType.AliPay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PayType.AliPayHuaBei.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15465a = iArr;
        }
    }

    public DiamondPurchaseWrapper(@NotNull com.cupidapp.live.liveshow.view.giftpicker.helper.a purchaseInterface) {
        s.i(purchaseInterface, "purchaseInterface");
        this.f15464k = purchaseInterface;
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void A() {
        this.f15464k.M0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O(@NotNull final Context context, @Nullable Dialog dialog, @NotNull DiamondModel model, @NotNull final PayType payType, @NotNull CreateOrderScene scene) {
        s.i(context, "context");
        s.i(model, "model");
        s.i(payType, "payType");
        s.i(scene, "scene");
        if (payType == PayType.WeChatPay && NetworkClient.f11868a.P(context) == null) {
            return;
        }
        H(new WeakReference<>(context));
        G(dialog);
        F(true);
        K();
        Observable<Result<CreateOrderModel>> g3 = NetworkClient.f11868a.p().g(model.getCode(), payType.getType(), scene.getValue(), model.getPrice());
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.helper.DiamondPurchaseWrapper$createOrder$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                DiamondPurchaseWrapper.this.a();
                return Boolean.FALSE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = g3.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CreateOrderModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.helper.DiamondPurchaseWrapper$createOrder$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CreateOrderModel createOrderModel) {
                m2645invoke(createOrderModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2645invoke(CreateOrderModel createOrderModel) {
                PayInfoModel payInfo = createOrderModel.getPayInfo();
                if (payInfo == null) {
                    return;
                }
                int i10 = DiamondPurchaseWrapper.a.f15465a[PayType.this.ordinal()];
                if (i10 == 1) {
                    this.L(context, payInfo);
                    return;
                }
                if (i10 == 2 || i10 == 3) {
                    Context context2 = context;
                    Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
                    if (activity == null || payInfo.getPayInfo() == null || payInfo.getOrderId() == null) {
                        return;
                    }
                    String info = URLDecoder.decode(payInfo.getPayInfo(), "utf-8");
                    DiamondPurchaseWrapper diamondPurchaseWrapper = this;
                    s.h(info, "info");
                    diamondPurchaseWrapper.o(activity, info, payInfo.getOrderId(), PayType.this);
                }
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

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void z(@NotNull PurchaseStatus status, @NotNull PayType payType, @NotNull String orderId) {
        s.i(status, "status");
        s.i(payType, "payType");
        s.i(orderId, "orderId");
        if (status == PurchaseStatus.SUCCESS) {
            this.f15464k.J(orderId);
        } else {
            this.f15464k.M0();
        }
    }
}
