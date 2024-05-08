package com.cupidapp.live.vip.wrapper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.router.PurchaseStatus;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.web.model.ReloadWebPageEvent;
import com.cupidapp.live.track.group.SensorVipType;
import com.cupidapp.live.track.group.VipBtnName;
import com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout;
import com.cupidapp.live.vip.model.AnimLoadedEvent;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.model.VipOptionsCombineModel;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.model.VipPurchaseSuccessEvent;
import com.cupidapp.live.vip.model.VipType;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipFullScreenPurchaseWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipFullScreenPurchaseWrapper extends BasePurchaseWrapper implements d {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final VipPurchasePresenter f18829k = new VipPurchasePresenter(this);

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public SensorVipType f18830l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public VipType f18831m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public APlusFullScreenVipPurchaseLayout f18832n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f18833o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public VipPurchasePriceModel f18834p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public VipType f18835q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public String f18836r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public String f18837s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public List<Integer> f18838t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f18839u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public List<VasFunctionType> f18840v;

    /* compiled from: VipFullScreenPurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18841a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18842b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f18843c;

        static {
            int[] iArr = new int[SensorVipType.values().length];
            try {
                iArr[SensorVipType.A_DIO_RAINBOW_MIXTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorVipType.DIO_RAINBOW_MIXTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SensorVipType.RAINBOW_A_PLUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18841a = iArr;
            int[] iArr2 = new int[PayType.values().length];
            try {
                iArr2[PayType.AliPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PayType.AliPayHuaBei.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PayType.WeChatPay.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f18842b = iArr2;
            int[] iArr3 = new int[VipType.values().length];
            try {
                iArr3[VipType.SUPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[VipType.RAINBOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f18843c = iArr3;
        }
    }

    /* compiled from: VipFullScreenPurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements APlusFullScreenVipPurchaseLayout.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f18845b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<kotlin.p> f18846c;

        public b(Context context, Function0<kotlin.p> function0) {
            this.f18845b = context;
            this.f18846c = function0;
        }

        @Override // com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout.a
        public void a(@NotNull VipPurchasePriceModel model, @NotNull PayType payType) {
            kotlin.jvm.internal.s.i(model, "model");
            kotlin.jvm.internal.s.i(payType, "payType");
            if (payType == PayType.WeChatPay && NetworkClient.f11868a.P(this.f18845b) == null) {
                return;
            }
            VipFullScreenPurchaseWrapper.this.F(true);
            VipFullScreenPurchaseWrapper.this.f18834p = model;
            VipFullScreenPurchaseWrapper.this.f18829k.r(model, payType, Integer.valueOf(VipFullScreenPurchaseWrapper.this.x().getScene()));
            VipFullScreenPurchaseWrapper.this.W(payType, model.getPromoCodes());
        }

        @Override // com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout.a
        public void b() {
            Dialog u10 = VipFullScreenPurchaseWrapper.this.u();
            if (u10 != null) {
                u10.dismiss();
            }
        }

        @Override // com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout.a
        public void c(@NotNull VipType vipType) {
            kotlin.jvm.internal.s.i(vipType, "vipType");
            VipFullScreenPurchaseWrapper.this.Z(vipType);
        }

        @Override // com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout.a
        public void d() {
            z3.d dVar = z3.d.f54832a;
            String str = VipFullScreenPurchaseWrapper.this.f18836r;
            VipFullScreenPurchaseWrapper vipFullScreenPurchaseWrapper = VipFullScreenPurchaseWrapper.this;
            SensorVipType X = vipFullScreenPurchaseWrapper.X(vipFullScreenPurchaseWrapper.f18835q);
            String value = VipBtnName.MORE_PACKAGES.getValue();
            VipFullScreenPurchaseWrapper vipFullScreenPurchaseWrapper2 = VipFullScreenPurchaseWrapper.this;
            dVar.I(str, X, value, vipFullScreenPurchaseWrapper2.X(vipFullScreenPurchaseWrapper2.f18831m), VipFullScreenPurchaseWrapper.this.f18830l);
        }

        @Override // com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout.a
        public void e() {
            VipFullScreenPurchaseWrapper.this.C();
            Dialog u10 = VipFullScreenPurchaseWrapper.this.u();
            if (u10 != null) {
                u10.dismiss();
            }
            Function0<kotlin.p> function0 = this.f18846c;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public VipFullScreenPurchaseWrapper() {
        VipType vipType = VipType.SUPER;
        this.f18831m = vipType;
        this.f18835q = vipType;
        this.f18840v = new ArrayList();
    }

    public static final void c0(VipFullScreenPurchaseWrapper this$0, DialogInterface dialogInterface) {
        List<Integer> list;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ConstantsResult q10 = p1.g.f52734a.q();
        if (!(q10 != null ? kotlin.jvm.internal.s.d(q10.getVasPolling(), Boolean.TRUE) : false) || (list = this$0.f18838t) == null) {
            return;
        }
        this$0.f18829k.S(list);
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void A() {
        Dialog u10 = u();
        if (u10 != null) {
            u10.dismiss();
        }
        J();
    }

    public final void W(PayType payType, String str) {
        z3.d dVar = z3.d.f54832a;
        String str2 = this.f18836r;
        SensorVipType X = X(this.f18835q);
        VipType vipType = this.f18835q;
        if (vipType != VipType.SUPER) {
            str = null;
        }
        String str3 = str;
        VipType vipType2 = this.f18831m;
        kotlin.jvm.internal.s.f(vipType2);
        dVar.i(str2, X, payType, vipType, str3, X(vipType2), this.f18830l);
    }

    public final SensorVipType X(VipType vipType) {
        int i10 = a.f18843c[vipType.ordinal()];
        if (i10 == 1) {
            return SensorVipType.DIO_A_PLUS;
        }
        if (i10 != 2) {
            return SensorVipType.A_PLUS;
        }
        return SensorVipType.RAINBOW_A_PLUS;
    }

    public final APlusFullScreenVipPurchaseLayout Y(Context context, Function0<kotlin.p> function0) {
        APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = new APlusFullScreenVipPurchaseLayout(context);
        aPlusFullScreenVipPurchaseLayout.setVipPurchaseClickListener(new b(context, function0));
        return aPlusFullScreenVipPurchaseLayout;
    }

    public final void Z(VipType vipType) {
        this.f18835q = vipType;
        z3.d dVar = z3.d.f54832a;
        String str = this.f18836r;
        SensorVipType X = X(vipType);
        String str2 = vipType == VipType.SUPER ? this.f18837s : null;
        VipType vipType2 = this.f18831m;
        kotlin.jvm.internal.s.f(vipType2);
        dVar.k(str, X, str2, X(vipType2), this.f18830l);
    }

    public void a0(@NotNull List<VasFunctionType> list) {
        kotlin.jvm.internal.s.i(list, "<set-?>");
        this.f18840v = list;
    }

    public final void b0() {
        Window window;
        if (u() == null) {
            z0.b bVar = z0.b.f54812a;
            WeakReference<Context> v2 = v();
            G(bVar.e(v2 != null ? v2.get() : null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.vip.wrapper.e
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    VipFullScreenPurchaseWrapper.c0(VipFullScreenPurchaseWrapper.this, dialogInterface);
                }
            }).create());
            WeakReference<Context> v10 = v();
            p(v10 != null ? v10.get() : null);
            Dialog u10 = u();
            if (u10 != null) {
                u10.setCanceledOnTouchOutside(false);
            }
        }
        APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = this.f18832n;
        if (aPlusFullScreenVipPurchaseLayout != null) {
            Dialog u11 = u();
            if (u11 != null) {
                u11.show();
            }
            Dialog u12 = u();
            if (u12 != null) {
                u12.setContentView(aPlusFullScreenVipPurchaseLayout);
            }
            Dialog u13 = u();
            if (u13 == null || (window = u13.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -1);
        }
    }

    @Override // com.cupidapp.live.vip.wrapper.d
    public void c(@Nullable String str) {
        j.a aVar = com.cupidapp.live.base.router.j.f12156c;
        WeakReference<Context> v2 = v();
        j.a.b(aVar, v2 != null ? v2.get() : null, str, null, 4, null);
    }

    public final void d0(@NotNull Context context, @NotNull VipType defaultType, @NotNull SensorVipType sensorVipType, @NotNull VipPurchaseEntranceType purchaseEntranceType, @Nullable String str, boolean z10, boolean z11, @Nullable Function0<kotlin.p> function0) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(defaultType, "defaultType");
        kotlin.jvm.internal.s.i(sensorVipType, "sensorVipType");
        kotlin.jvm.internal.s.i(purchaseEntranceType, "purchaseEntranceType");
        Dialog u10 = u();
        if (u10 != null && u10.isShowing()) {
            return;
        }
        H(new WeakReference<>(context));
        I(purchaseEntranceType);
        if (str == null || str.length() == 0) {
            str = purchaseEntranceType.getFrom();
        }
        this.f18836r = str;
        this.f18831m = defaultType;
        this.f18833o = z10;
        this.f18839u = z11;
        this.f18830l = sensorVipType;
        int i10 = a.f18841a[sensorVipType.ordinal()];
        if (i10 == 1) {
            VasFunctionType vasFunctionType = VasFunctionType.VIP;
            VasFunctionType vasFunctionType2 = VasFunctionType.SVIP;
            VasFunctionType vasFunctionType3 = VasFunctionType.SSVIP;
            a0(kotlin.collections.s.o(vasFunctionType, vasFunctionType2, vasFunctionType3));
            this.f18838t = kotlin.collections.s.m(Integer.valueOf(vasFunctionType.getValue()), Integer.valueOf(vasFunctionType2.getValue()), Integer.valueOf(vasFunctionType3.getValue()));
        } else if (i10 == 2) {
            VasFunctionType vasFunctionType4 = VasFunctionType.SVIP;
            VasFunctionType vasFunctionType5 = VasFunctionType.SSVIP;
            a0(kotlin.collections.s.o(vasFunctionType4, vasFunctionType5));
            this.f18838t = kotlin.collections.s.m(Integer.valueOf(vasFunctionType4.getValue()), Integer.valueOf(vasFunctionType5.getValue()));
        } else if (i10 == 3) {
            VasFunctionType vasFunctionType6 = VasFunctionType.SSVIP;
            a0(kotlin.collections.s.o(vasFunctionType6));
            this.f18838t = kotlin.collections.r.e(Integer.valueOf(vasFunctionType6.getValue()));
        }
        if (this.f18832n == null) {
            this.f18832n = Y(context, function0);
        }
        this.f18829k.P(sensorVipType);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        this.f18829k.u();
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
            int i10 = a.f18842b[payType.ordinal()];
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

    @Override // com.cupidapp.live.vip.wrapper.d
    public void j(@NotNull VipOptionsCombineModel vipCombine) {
        kotlin.jvm.internal.s.i(vipCombine, "vipCombine");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (vipCombine.getNormalVip() != null) {
            linkedHashMap.put(VipType.NORMAL, vipCombine.getNormalVip());
        }
        if (vipCombine.getSVip() != null) {
            linkedHashMap.put(VipType.SUPER, vipCombine.getSVip());
            List<VipPurchasePriceModel> allAlipayOptions = vipCombine.getSVip().getAllAlipayOptions();
            if (!(allAlipayOptions == null || allAlipayOptions.isEmpty())) {
                List<VipPurchasePriceModel> allAlipayOptions2 = vipCombine.getSVip().getAllAlipayOptions();
                ArrayList arrayList = new ArrayList(kotlin.collections.t.t(allAlipayOptions2, 10));
                Iterator<VipPurchasePriceModel> iterator2 = allAlipayOptions2.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(iterator2.next().getPromoCodes());
                }
                Iterator<E> iterator22 = arrayList.iterator2();
                if (iterator22.hasNext()) {
                    Object next = iterator22.next();
                    while (iterator22.hasNext()) {
                        next = ((String) next) + "," + ((String) iterator22.next());
                    }
                    this.f18837s = (String) next;
                } else {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
            }
        }
        if (vipCombine.getRainbowVip() != null) {
            linkedHashMap.put(VipType.RAINBOW, vipCombine.getRainbowVip());
        }
        if (linkedHashMap.size() == 1) {
            this.f18831m = (VipType) CollectionsKt___CollectionsKt.S(linkedHashMap.h());
        }
        APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = this.f18832n;
        if (aPlusFullScreenVipPurchaseLayout != null) {
            aPlusFullScreenVipPurchaseLayout.u(linkedHashMap, this.f18831m, x(), this.f18833o);
        }
        b0();
        Z(this.f18831m);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull AnimLoadedEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (event.getAnimType() != null) {
            this.f18829k.q(event.getAnimType().intValue());
        }
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    @NotNull
    public List<VasFunctionType> w() {
        return this.f18840v;
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    public void z(@NotNull PurchaseStatus status, @NotNull PayType payType, @NotNull String orderId) {
        Context context;
        kotlin.jvm.internal.s.i(status, "status");
        kotlin.jvm.internal.s.i(payType, "payType");
        kotlin.jvm.internal.s.i(orderId, "orderId");
        Dialog u10 = u();
        if (u10 != null) {
            u10.dismiss();
        }
        WeakReference<Context> v2 = v();
        if (v2 != null && (context = v2.get()) != null) {
            this.f18829k.a(context);
        }
        if (status == PurchaseStatus.SUCCESS) {
            EventBus.c().l(new VipPurchaseSuccessEvent(this.f18835q));
        }
        if (this.f18839u) {
            EventBus.c().l(new ReloadWebPageEvent());
            return;
        }
        j.a aVar = com.cupidapp.live.base.router.j.f12156c;
        WeakReference<Context> v10 = v();
        j.a.b(aVar, v10 != null ? v10.get() : null, s(), null, 4, null);
    }
}