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
import com.cupidapp.live.vip.layout.APlusVipPurchaseLayout;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchaseWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseWrapper extends BasePurchaseWrapper implements d {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final VipPurchasePresenter f18850k = new VipPurchasePresenter(this);

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public SensorVipType f18851l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public VipType f18852m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public APlusVipPurchaseLayout f18853n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f18854o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public VipPurchasePriceModel f18855p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public VipType f18856q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public String f18857r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public String f18858s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public List<Integer> f18859t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f18860u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public List<VasFunctionType> f18861v;

    /* compiled from: VipPurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18862a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18863b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f18864c;

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
            f18862a = iArr;
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
            f18863b = iArr2;
            int[] iArr3 = new int[VipType.values().length];
            try {
                iArr3[VipType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[VipType.SUPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[VipType.RAINBOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[VipType.VISITOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            f18864c = iArr3;
        }
    }

    /* compiled from: VipPurchaseWrapper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements APlusVipPurchaseLayout.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f18866b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<kotlin.p> f18867c;

        public b(Context context, Function0<kotlin.p> function0) {
            this.f18866b = context;
            this.f18867c = function0;
        }

        @Override // com.cupidapp.live.vip.layout.APlusVipPurchaseLayout.a
        public void a(@NotNull VipPurchasePriceModel model, @NotNull PayType payType) {
            kotlin.jvm.internal.s.i(model, "model");
            kotlin.jvm.internal.s.i(payType, "payType");
            if (payType == PayType.WeChatPay && NetworkClient.f11868a.P(this.f18866b) == null) {
                return;
            }
            VipPurchaseWrapper.this.F(true);
            VipPurchaseWrapper.this.f18855p = model;
            VipPurchaseWrapper.this.f18850k.r(model, payType, Integer.valueOf(VipPurchaseWrapper.this.x().getScene()));
            VipPurchaseWrapper.this.W(payType, model.getPromoCodes());
        }

        @Override // com.cupidapp.live.vip.layout.APlusVipPurchaseLayout.a
        public void b() {
            Dialog u10 = VipPurchaseWrapper.this.u();
            if (u10 != null) {
                u10.dismiss();
            }
        }

        @Override // com.cupidapp.live.vip.layout.APlusVipPurchaseLayout.a
        public void c(@NotNull VipType vipType) {
            kotlin.jvm.internal.s.i(vipType, "vipType");
            VipPurchaseWrapper.this.Z(vipType);
        }

        @Override // com.cupidapp.live.vip.layout.APlusVipPurchaseLayout.a
        public void d() {
            z3.d dVar = z3.d.f54832a;
            String str = VipPurchaseWrapper.this.f18857r;
            VipPurchaseWrapper vipPurchaseWrapper = VipPurchaseWrapper.this;
            SensorVipType X = vipPurchaseWrapper.X(vipPurchaseWrapper.f18856q);
            String value = VipBtnName.MORE_PACKAGES.getValue();
            VipPurchaseWrapper vipPurchaseWrapper2 = VipPurchaseWrapper.this;
            dVar.I(str, X, value, vipPurchaseWrapper2.X(vipPurchaseWrapper2.f18852m), VipPurchaseWrapper.this.f18851l);
        }

        @Override // com.cupidapp.live.vip.layout.APlusVipPurchaseLayout.a
        public void e() {
            VipPurchaseWrapper.this.C();
            Dialog u10 = VipPurchaseWrapper.this.u();
            if (u10 != null) {
                u10.dismiss();
            }
            Function0<kotlin.p> function0 = this.f18867c;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public VipPurchaseWrapper() {
        VipType vipType = VipType.SUPER;
        this.f18852m = vipType;
        this.f18856q = vipType;
        this.f18861v = new ArrayList();
    }

    public static final void c0(VipPurchaseWrapper this$0, DialogInterface dialogInterface) {
        List<Integer> list;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ConstantsResult q10 = p1.g.f52734a.q();
        if (!(q10 != null ? kotlin.jvm.internal.s.d(q10.getVasPolling(), Boolean.TRUE) : false) || (list = this$0.f18859t) == null) {
            return;
        }
        this$0.f18850k.S(list);
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
        String str2 = this.f18857r;
        SensorVipType X = X(this.f18856q);
        VipType vipType = this.f18856q;
        if (vipType != VipType.SUPER) {
            str = null;
        }
        String str3 = str;
        VipType vipType2 = this.f18852m;
        kotlin.jvm.internal.s.f(vipType2);
        dVar.i(str2, X, payType, vipType, str3, X(vipType2), this.f18851l);
    }

    public final SensorVipType X(VipType vipType) {
        int i10 = a.f18864c[vipType.ordinal()];
        if (i10 == 1) {
            return SensorVipType.A_PLUS;
        }
        if (i10 == 2) {
            return SensorVipType.DIO_A_PLUS;
        }
        if (i10 == 3) {
            return SensorVipType.RAINBOW_A_PLUS;
        }
        if (i10 == 4) {
            return SensorVipType.VISITOR;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final APlusVipPurchaseLayout Y(Context context, Function0<kotlin.p> function0) {
        APlusVipPurchaseLayout aPlusVipPurchaseLayout = new APlusVipPurchaseLayout(context);
        aPlusVipPurchaseLayout.setVipPurchaseClickListener(new b(context, function0));
        return aPlusVipPurchaseLayout;
    }

    public final void Z(VipType vipType) {
        this.f18856q = vipType;
        z3.d dVar = z3.d.f54832a;
        String str = this.f18857r;
        SensorVipType X = X(vipType);
        String str2 = vipType == VipType.SUPER ? this.f18858s : null;
        VipType vipType2 = this.f18852m;
        kotlin.jvm.internal.s.f(vipType2);
        dVar.k(str, X, str2, X(vipType2), this.f18851l);
    }

    public void a0(@NotNull List<VasFunctionType> list) {
        kotlin.jvm.internal.s.i(list, "<set-?>");
        this.f18861v = list;
    }

    public final void b0() {
        Window window;
        if (u() == null) {
            z0.b bVar = z0.b.f54812a;
            WeakReference<Context> v2 = v();
            G(bVar.e(v2 != null ? v2.get() : null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.vip.wrapper.t
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    VipPurchaseWrapper.c0(VipPurchaseWrapper.this, dialogInterface);
                }
            }).create());
            WeakReference<Context> v10 = v();
            p(v10 != null ? v10.get() : null);
            Dialog u10 = u();
            if (u10 != null) {
                u10.setCanceledOnTouchOutside(false);
            }
        }
        APlusVipPurchaseLayout aPlusVipPurchaseLayout = this.f18853n;
        if (aPlusVipPurchaseLayout != null) {
            Dialog u11 = u();
            if (u11 != null) {
                u11.show();
            }
            Dialog u12 = u();
            if (u12 != null) {
                u12.setContentView(aPlusVipPurchaseLayout);
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
        this.f18857r = str;
        this.f18852m = defaultType;
        this.f18854o = z10;
        this.f18860u = z11;
        this.f18851l = sensorVipType;
        int i10 = a.f18862a[sensorVipType.ordinal()];
        if (i10 == 1) {
            VasFunctionType vasFunctionType = VasFunctionType.VIP;
            VasFunctionType vasFunctionType2 = VasFunctionType.SVIP;
            VasFunctionType vasFunctionType3 = VasFunctionType.SSVIP;
            a0(kotlin.collections.s.o(vasFunctionType, vasFunctionType2, vasFunctionType3));
            this.f18859t = kotlin.collections.s.m(Integer.valueOf(vasFunctionType.getValue()), Integer.valueOf(vasFunctionType2.getValue()), Integer.valueOf(vasFunctionType3.getValue()));
        } else if (i10 == 2) {
            VasFunctionType vasFunctionType4 = VasFunctionType.SVIP;
            VasFunctionType vasFunctionType5 = VasFunctionType.SSVIP;
            a0(kotlin.collections.s.o(vasFunctionType4, vasFunctionType5));
            this.f18859t = kotlin.collections.s.m(Integer.valueOf(vasFunctionType4.getValue()), Integer.valueOf(vasFunctionType5.getValue()));
        } else if (i10 == 3) {
            VasFunctionType vasFunctionType6 = VasFunctionType.SSVIP;
            a0(kotlin.collections.s.o(vasFunctionType6));
            this.f18859t = kotlin.collections.r.e(Integer.valueOf(vasFunctionType6.getValue()));
        }
        if (this.f18853n == null) {
            this.f18853n = Y(context, function0);
        }
        this.f18850k.P(sensorVipType);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        this.f18850k.u();
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
            int i10 = a.f18863b[payType.ordinal()];
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
        String str;
        kotlin.jvm.internal.s.i(vipCombine, "vipCombine");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (vipCombine.getVisitor() != null) {
            linkedHashMap.put(VipType.VISITOR, vipCombine.getVisitor());
        }
        if (vipCombine.getNormalVip() != null) {
            linkedHashMap.put(VipType.NORMAL, vipCombine.getNormalVip());
        }
        if (vipCombine.getSVip() != null) {
            linkedHashMap.put(VipType.SUPER, vipCombine.getSVip());
            List<VipPurchasePriceModel> allAlipayOptions = vipCombine.getSVip().getAllAlipayOptions();
            if (allAlipayOptions != null) {
                ArrayList arrayList = new ArrayList(kotlin.collections.t.t(allAlipayOptions, 10));
                Iterator<VipPurchasePriceModel> iterator2 = allAlipayOptions.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(iterator2.next().getPromoCodes());
                }
                Iterator<E> iterator22 = arrayList.iterator2();
                if (iterator22.hasNext()) {
                    Object next = iterator22.next();
                    while (iterator22.hasNext()) {
                        next = ((String) next) + "," + ((String) iterator22.next());
                    }
                    str = (String) next;
                } else {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
            } else {
                str = null;
            }
            this.f18858s = str;
        }
        if (vipCombine.getRainbowVip() != null) {
            linkedHashMap.put(VipType.RAINBOW, vipCombine.getRainbowVip());
        }
        if (linkedHashMap.size() == 1) {
            this.f18852m = (VipType) CollectionsKt___CollectionsKt.S(linkedHashMap.h());
        }
        APlusVipPurchaseLayout aPlusVipPurchaseLayout = this.f18853n;
        if (aPlusVipPurchaseLayout != null) {
            aPlusVipPurchaseLayout.t(linkedHashMap, this.f18852m, x(), this.f18854o);
        }
        b0();
        Z(this.f18852m);
    }

    @Override // com.cupidapp.live.vip.wrapper.BasePurchaseWrapper
    @NotNull
    public List<VasFunctionType> w() {
        return this.f18861v;
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
            this.f18850k.a(context);
        }
        if (status == PurchaseStatus.SUCCESS) {
            EventBus.c().l(new VipPurchaseSuccessEvent(this.f18856q));
        }
        if (this.f18860u) {
            EventBus.c().l(new ReloadWebPageEvent());
            return;
        }
        j.a aVar = com.cupidapp.live.base.router.j.f12156c;
        WeakReference<Context> v10 = v();
        j.a.b(aVar, v10 != null ? v10.get() : null, s(), null, 4, null);
    }
}
