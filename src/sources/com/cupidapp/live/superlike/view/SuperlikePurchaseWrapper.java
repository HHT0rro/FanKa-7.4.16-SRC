package com.cupidapp.live.superlike.view;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.router.PurchaseStatus;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.superlike.presenter.SuperlikePurchasePresenter;
import com.cupidapp.live.superlike.view.SuperLikePurchaseLayout;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.wrapper.BasePurchaseWrapper;
import com.cupidapp.live.vip.wrapper.VasFunctionType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperlikePurchaseWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperlikePurchaseWrapper extends BasePurchaseWrapper implements com.cupidapp.live.superlike.presenter.a {

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public SuperLikePurchaseLayout f18650l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public SuperLikePurchaseSkuModel f18651m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public String f18652n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public g f18653o;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final SuperlikePurchasePresenter f18649k = new SuperlikePurchasePresenter(this);

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public List<VasFunctionType> f18654p = s.o(VasFunctionType.SUPER_LIKE);

    /* compiled from: SuperlikePurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18655a;

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
            f18655a = iArr;
        }
    }

    /* compiled from: SuperlikePurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements SuperLikePurchaseLayout.a {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.cupidapp.live.superlike.view.SuperLikePurchaseLayout.a
        public void a(@NotNull SuperLikePurchaseSkuModel skuModel, @NotNull PayType payType) {
            Context context;
            kotlin.jvm.internal.s.i(skuModel, "skuModel");
            kotlin.jvm.internal.s.i(payType, "payType");
            z3.d.f54832a.c(SuperlikePurchaseWrapper.this.x().getPosition());
            if (payType == PayType.WeChatPay) {
                NetworkClient networkClient = NetworkClient.f11868a;
                WeakReference v2 = SuperlikePurchaseWrapper.this.v();
                if (networkClient.P(v2 != null ? (Context) v2.get() : null) == null) {
                    return;
                }
            }
            SuperlikePurchaseWrapper.this.F(true);
            SuperlikePurchaseWrapper.this.f18651m = skuModel;
            WeakReference v10 = SuperlikePurchaseWrapper.this.v();
            if (v10 == null || (context = (Context) v10.get()) == null) {
                return;
            }
            SuperlikePurchaseWrapper superlikePurchaseWrapper = SuperlikePurchaseWrapper.this;
            superlikePurchaseWrapper.f18649k.b(context, skuModel, payType, superlikePurchaseWrapper.x().getScene());
        }

        @Override // com.cupidapp.live.superlike.view.SuperLikePurchaseLayout.a
        public void b() {
            g gVar = SuperlikePurchaseWrapper.this.f18653o;
            if (gVar != null) {
                gVar.a(SuperlikePurchaseWrapper.this.x());
            }
            SuperlikePurchaseWrapper.this.f18649k.c();
        }
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void A() {
        SuperLikePurchaseLayout superLikePurchaseLayout = this.f18650l;
        if (superLikePurchaseLayout != null) {
            superLikePurchaseLayout.s();
        }
        J();
    }

    public final void S(@NotNull Lifecycle lifecycle, @NotNull Context context, @NotNull String from, @NotNull VipPurchaseEntranceType vipPurchaseEntranceType, @Nullable g gVar) {
        kotlin.jvm.internal.s.i(lifecycle, "lifecycle");
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(from, "from");
        kotlin.jvm.internal.s.i(vipPurchaseEntranceType, "vipPurchaseEntranceType");
        this.f18652n = from;
        this.f18653o = gVar;
        I(vipPurchaseEntranceType);
        H(new WeakReference<>(context));
        B(lifecycle);
        this.f18649k.e();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        this.f18649k.c();
    }

    @Override // com.cupidapp.live.superlike.presenter.a
    public void f(@Nullable SuperLikePurchaseModel superLikePurchaseModel) {
        Context context;
        if (superLikePurchaseModel == null) {
            return;
        }
        WeakReference<Context> v2 = v();
        if (v2 != null && (context = v2.get()) != null) {
            SuperLikePurchaseLayout superLikePurchaseLayout = new SuperLikePurchaseLayout(context);
            this.f18650l = superLikePurchaseLayout;
            G(superLikePurchaseLayout.v(superLikePurchaseModel));
            p(context);
            SuperLikePurchaseLayout superLikePurchaseLayout2 = this.f18650l;
            if (superLikePurchaseLayout2 != null) {
                superLikePurchaseLayout2.setVipPurchaseClickListener(new b());
            }
        }
        z3.d.f54832a.d(x().getPosition());
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
            int i10 = a.f18655a[payType.ordinal()];
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

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    @NotNull
    public List<VasFunctionType> w() {
        return this.f18654p;
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void z(@NotNull PurchaseStatus status, @NotNull PayType payType, @NotNull String orderId) {
        Context context;
        kotlin.jvm.internal.s.i(status, "status");
        kotlin.jvm.internal.s.i(payType, "payType");
        kotlin.jvm.internal.s.i(orderId, "orderId");
        SuperLikePurchaseLayout superLikePurchaseLayout = this.f18650l;
        if (superLikePurchaseLayout != null) {
            superLikePurchaseLayout.s();
        }
        WeakReference<Context> v2 = v();
        if (v2 != null && (context = v2.get()) != null) {
            this.f18649k.a(context);
        }
        if (status == PurchaseStatus.SUCCESS && this.f18651m != null) {
            z3.d dVar = z3.d.f54832a;
            SensorPosition position = x().getPosition();
            SuperLikePurchaseSkuModel superLikePurchaseSkuModel = this.f18651m;
            dVar.e(position, superLikePurchaseSkuModel != null ? superLikePurchaseSkuModel.getTitle() : null);
        }
        j.a aVar = j.f12156c;
        WeakReference<Context> v10 = v();
        j.a.b(aVar, v10 != null ? v10.get() : null, s(), null, 4, null);
    }
}
