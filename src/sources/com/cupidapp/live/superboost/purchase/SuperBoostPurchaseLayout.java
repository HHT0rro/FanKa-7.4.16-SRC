package com.cupidapp.live.superboost.purchase;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.decoration.AddExtraSpacingDecoration;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.layout.PurchaseTypeLayout;
import com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout;
import com.cupidapp.live.vip.model.PayType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.t;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: SuperBoostPurchaseLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostPurchaseLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f18596d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public PayType f18597e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public a f18598f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public AlertDialog f18599g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Map<SuperBoostType, SuperLikePurchaseModel> f18600h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f18601i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public SuperBoostType f18602j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18603k;

    /* compiled from: SuperBoostPurchaseLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(@NotNull SuperLikePurchaseSkuModel superLikePurchaseSkuModel, @NotNull PayType payType, @Nullable SuperBoostType superBoostType);
    }

    /* compiled from: SuperBoostPurchaseLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f18605c;

        public b(Map.Entry<String, String> entry) {
            this.f18605c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, SuperBoostPurchaseLayout.this.getContext(), this.f18605c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostPurchaseLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18603k = new LinkedHashMap();
        this.f18596d = c.b(new Function0<SuperBoostPurchaserAdapter>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$exposuresPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaserAdapter invoke() {
                SuperBoostPurchaserAdapter superBoostPurchaserAdapter = new SuperBoostPurchaserAdapter();
                final SuperBoostPurchaseLayout superBoostPurchaseLayout = SuperBoostPurchaseLayout.this;
                superBoostPurchaserAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$exposuresPurchasePriceAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof SuperLikePurchaseSkuModel) {
                            SuperBoostPurchaseLayout.this.x((SuperLikePurchaseSkuModel) obj);
                        }
                    }
                });
                return superBoostPurchaserAdapter;
            }
        });
        this.f18597e = PayType.AliPay;
        this.f18600h = new LinkedHashMap();
        this.f18602j = SuperBoostType.NON_DIRECT;
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuperBoostPurchaserAdapter getExposuresPurchasePriceAdapter() {
        return (SuperBoostPurchaserAdapter) this.f18596d.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f18603k;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @NotNull
    public final Map<SuperBoostType, SuperLikePurchaseModel> getMapModel() {
        return this.f18600h;
    }

    public final void q() {
        TextView exposure_pay_option = (TextView) e(R$id.exposure_pay_option);
        s.h(exposure_pay_option, "exposure_pay_option");
        y.d(exposure_pay_option, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Context context = SuperBoostPurchaseLayout.this.getContext();
                s.h(context, "context");
                PurchaseTypeLayout purchaseTypeLayout = new PurchaseTypeLayout(context);
                final SuperBoostPurchaseLayout superBoostPurchaseLayout = SuperBoostPurchaseLayout.this;
                purchaseTypeLayout.c(new Function2<String, PayType, p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$bindClickEvent$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(String str, PayType payType) {
                        invoke2(str, payType);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String typeText, @NotNull PayType type) {
                        s.i(typeText, "typeText");
                        s.i(type, "type");
                        SuperBoostPurchaseLayout.this.f18597e = type;
                        ((TextView) SuperBoostPurchaseLayout.this.e(R$id.exposure_pay_option)).setText(typeText);
                    }
                });
            }
        });
        FKUniversalButton buy_it_now_btn = (FKUniversalButton) e(R$id.buy_it_now_btn);
        s.h(buy_it_now_btn, "buy_it_now_btn");
        y.d(buy_it_now_btn, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
            
                r4 = r3.this$0.f18598f;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r4) {
                /*
                    r3 = this;
                    com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout r4 = com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.this
                    com.cupidapp.live.superboost.purchase.SuperBoostPurchaserAdapter r4 = com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.h(r4)
                    java.util.List r4 = r4.j()
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.Iterator r4 = r4.iterator2()
                L13:
                    boolean r1 = r4.hasNext()
                    if (r1 == 0) goto L25
                    java.lang.Object r1 = r4.next()
                    boolean r2 = r1 instanceof com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel
                    if (r2 == 0) goto L13
                    r0.add(r1)
                    goto L13
                L25:
                    java.util.Iterator r4 = r0.iterator2()
                L29:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L3d
                    java.lang.Object r0 = r4.next()
                    r1 = r0
                    com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel r1 = (com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel) r1
                    boolean r1 = r1.getChecked()
                    if (r1 == 0) goto L29
                    goto L3e
                L3d:
                    r0 = 0
                L3e:
                    com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel r0 = (com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel) r0
                    if (r0 == 0) goto L59
                    com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout r4 = com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.this
                    com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$a r4 = com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.k(r4)
                    if (r4 == 0) goto L59
                    com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout r1 = com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.this
                    com.cupidapp.live.vip.model.PayType r1 = com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.j(r1)
                    com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout r2 = com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.this
                    com.cupidapp.live.superboost.purchase.SuperBoostType r2 = com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout.l(r2)
                    r4.a(r0, r1, r2)
                L59:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$bindClickEvent$2.invoke2(android.view.View):void");
            }
        });
        ImageView exposure_close_img = (ImageView) e(R$id.exposure_close_img);
        s.h(exposure_close_img, "exposure_close_img");
        y.d(exposure_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                alertDialog = SuperBoostPurchaseLayout.this.f18599g;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        ((SuperBoostPurchaseTabLayout) e(R$id.tab_layout)).setTabSelectCallback(new Function1<SuperBoostType, p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SuperBoostType superBoostType) {
                invoke2(superBoostType);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SuperBoostType it) {
                SuperBoostType superBoostType;
                String str;
                s.i(it, "it");
                SuperBoostPurchaseLayout.this.f18602j = it;
                Map<SuperBoostType, SuperLikePurchaseModel> mapModel = SuperBoostPurchaseLayout.this.getMapModel();
                superBoostType = SuperBoostPurchaseLayout.this.f18602j;
                SuperLikePurchaseModel superLikePurchaseModel = mapModel.get(superBoostType);
                if (superLikePurchaseModel != null) {
                    SuperBoostPurchaseLayout.this.s(superLikePurchaseModel);
                }
                z3.d dVar = z3.d.f54832a;
                str = SuperBoostPurchaseLayout.this.f18601i;
                dVar.g(str, it.getValue());
            }
        });
    }

    public final void r(SuperLikePurchaseSkuModel superLikePurchaseSkuModel) {
        boolean z10;
        Iterator<Object> iterator2 = getExposuresPurchasePriceAdapter().j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            Object next = iterator2.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (next instanceof SuperLikePurchaseSkuModel) {
                SuperLikePurchaseSkuModel superLikePurchaseSkuModel2 = (SuperLikePurchaseSkuModel) next;
                if (s.d(superLikePurchaseSkuModel2.getItemId(), superLikePurchaseSkuModel != null ? superLikePurchaseSkuModel.getItemId() : null)) {
                    if (s.d(superLikePurchaseSkuModel2.getCode(), superLikePurchaseSkuModel != null ? superLikePurchaseSkuModel.getCode() : null)) {
                        z10 = true;
                        superLikePurchaseSkuModel2.setChecked(z10);
                    }
                }
                z10 = false;
                superLikePurchaseSkuModel2.setChecked(z10);
            }
            i10 = i11;
        }
        u(superLikePurchaseSkuModel != null ? superLikePurchaseSkuModel.getDescription() : null);
    }

    public final void s(SuperLikePurchaseModel superLikePurchaseModel) {
        SuperLikePurchaseSkuModel superLikePurchaseSkuModel;
        SuperLikePurchaseSkuModel superLikePurchaseSkuModel2;
        this.f18597e = PayType.AliPay;
        TextView textView = (TextView) e(R$id.exposure_purchase_description);
        String superboostMarketingInfo = superLikePurchaseModel.getSuperboostMarketingInfo();
        textView.setText(superboostMarketingInfo != null ? t.a(superboostMarketingInfo, -49088) : null);
        t(superLikePurchaseModel.getAssignment());
        ((TextView) e(R$id.exposure_pay_option)).setText(getContext().getString(R$string.aliPay));
        List<SuperLikePurchaseSkuModel> products = superLikePurchaseModel.getProducts();
        if (products == null) {
            products = kotlin.collections.s.j();
        }
        y(products);
        List<SuperLikePurchaseSkuModel> products2 = superLikePurchaseModel.getProducts();
        if (products2 != null) {
            Iterator<SuperLikePurchaseSkuModel> iterator2 = products2.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    superLikePurchaseSkuModel2 = null;
                    break;
                } else {
                    superLikePurchaseSkuModel2 = iterator2.next();
                    if (superLikePurchaseSkuModel2.getChecked()) {
                        break;
                    }
                }
            }
            superLikePurchaseSkuModel = superLikePurchaseSkuModel2;
        } else {
            superLikePurchaseSkuModel = null;
        }
        if (superLikePurchaseSkuModel == null) {
            List<SuperLikePurchaseSkuModel> products3 = superLikePurchaseModel.getProducts();
            r(products3 != null ? (SuperLikePurchaseSkuModel) CollectionsKt___CollectionsKt.V(products3) : null);
        } else {
            r(superLikePurchaseSkuModel);
        }
        ((ImageView) e(R$id.exposure_purchase_header_img)).setImageResource(this.f18602j.getPurchaseImg());
    }

    public final void setVipPurchaseClickListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f18598f = listener;
    }

    public final void t(LinkDictTipsModel linkDictTipsModel) {
        SpannableStringBuilder c4;
        Set<Map.Entry<String, String>> entrySet;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (linkDictTipsModel != null) {
            Map<String, String> linkDict = linkDictTipsModel.getLinkDict();
            if (linkDict != null && (entrySet = linkDict.entrySet()) != null) {
                int i10 = 0;
                for (Map.Entry<String, String> entry : entrySet) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        kotlin.collections.s.s();
                    }
                    Map.Entry<String, String> entry2 = entry;
                    arrayList.add(i10, entry2.getKey());
                    arrayList2.add(i10, new b(entry2));
                    i10 = i11;
                }
            }
            c4 = q1.d.f53006a.c(linkDictTipsModel.getContent(), arrayList, (r18 & 4) != 0 ? null : -1, (r18 & 8) != 0 ? null : 0, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
            int i12 = R$id.purchaseProtocol;
            ((TextView) e(i12)).setText(c4);
            ((TextView) e(i12)).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public final void u(String str) {
        if (str == null || str.length() == 0) {
            ((TextView) e(R$id.exposure_option_tip)).setVisibility(4);
            return;
        }
        int i10 = R$id.exposure_option_tip;
        ((TextView) e(i10)).setVisibility(0);
        ((TextView) e(i10)).setText(str);
    }

    public final void v() {
        AlertDialog alertDialog = this.f18599g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void w() {
        z.a(this, R$layout.layout_boost_purchase, true);
        ((TextView) e(R$id.exposure_pay_option)).getPaint().setFakeBoldText(true);
        RecyclerView initView$lambda$0 = (RecyclerView) e(R$id.exposure_recycler);
        initView$lambda$0.setLayoutManager(new LinearLayoutManager(initView$lambda$0.getContext(), 0, false));
        s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.addItemDecoration(new AddExtraSpacingDecoration(h.c(initView$lambda$0, 4.0f), 0, h.c(initView$lambda$0, 4.0f), 0, h.c(initView$lambda$0, 12.0f)));
        initView$lambda$0.setAdapter(getExposuresPurchasePriceAdapter());
        FKUniversalButton buy_it_now_btn = (FKUniversalButton) e(R$id.buy_it_now_btn);
        s.h(buy_it_now_btn, "buy_it_now_btn");
        u.a(buy_it_now_btn);
        q();
    }

    public final void x(SuperLikePurchaseSkuModel superLikePurchaseSkuModel) {
        r(superLikePurchaseSkuModel);
        getExposuresPurchasePriceAdapter().notifyDataSetChanged();
    }

    public final void y(List<SuperLikePurchaseSkuModel> list) {
        getExposuresPurchasePriceAdapter().j().clear();
        getExposuresPurchasePriceAdapter().j().addAll(list);
        getExposuresPurchasePriceAdapter().notifyDataSetChanged();
    }

    @Nullable
    public final AlertDialog z(@NotNull SuperLikePurchaseModel nonDirectModel, @NotNull SuperLikePurchaseModel directModel, @NotNull SuperLikePurchaseModel travelModel, @Nullable String str, @NotNull SuperBoostType defaultTab) {
        Window window;
        s.i(nonDirectModel, "nonDirectModel");
        s.i(directModel, "directModel");
        s.i(travelModel, "travelModel");
        s.i(defaultTab, "defaultTab");
        this.f18600h.clear();
        this.f18600h.put(SuperBoostType.NON_DIRECT, nonDirectModel);
        this.f18600h.put(SuperBoostType.DIRECT, directModel);
        this.f18600h.put(SuperBoostType.TRAVEL, travelModel);
        this.f18601i = str;
        ((SuperBoostPurchaseTabLayout) e(R$id.tab_layout)).f(defaultTab);
        if (this.f18599g == null) {
            this.f18599g = z0.b.f54812a.e(getContext()).setView(this).create();
        }
        AlertDialog alertDialog = this.f18599g;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog2 = this.f18599g;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        AlertDialog alertDialog3 = this.f18599g;
        if (alertDialog3 != null && (window = alertDialog3.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
        return this.f18599g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18603k = new LinkedHashMap();
        this.f18596d = c.b(new Function0<SuperBoostPurchaserAdapter>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$exposuresPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaserAdapter invoke() {
                SuperBoostPurchaserAdapter superBoostPurchaserAdapter = new SuperBoostPurchaserAdapter();
                final SuperBoostPurchaseLayout superBoostPurchaseLayout = SuperBoostPurchaseLayout.this;
                superBoostPurchaserAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$exposuresPurchasePriceAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof SuperLikePurchaseSkuModel) {
                            SuperBoostPurchaseLayout.this.x((SuperLikePurchaseSkuModel) obj);
                        }
                    }
                });
                return superBoostPurchaserAdapter;
            }
        });
        this.f18597e = PayType.AliPay;
        this.f18600h = new LinkedHashMap();
        this.f18602j = SuperBoostType.NON_DIRECT;
        w();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18603k = new LinkedHashMap();
        this.f18596d = c.b(new Function0<SuperBoostPurchaserAdapter>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$exposuresPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaserAdapter invoke() {
                SuperBoostPurchaserAdapter superBoostPurchaserAdapter = new SuperBoostPurchaserAdapter();
                final SuperBoostPurchaseLayout superBoostPurchaseLayout = SuperBoostPurchaseLayout.this;
                superBoostPurchaserAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.superboost.purchase.SuperBoostPurchaseLayout$exposuresPurchasePriceAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof SuperLikePurchaseSkuModel) {
                            SuperBoostPurchaseLayout.this.x((SuperLikePurchaseSkuModel) obj);
                        }
                    }
                });
                return superBoostPurchaserAdapter;
            }
        });
        this.f18597e = PayType.AliPay;
        this.f18600h = new LinkedHashMap();
        this.f18602j = SuperBoostType.NON_DIRECT;
        w();
    }
}
