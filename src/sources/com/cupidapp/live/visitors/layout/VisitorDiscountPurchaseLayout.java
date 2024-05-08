package com.cupidapp.live.visitors.layout;

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
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.decoration.AddExtraSpacingDecoration;
import com.cupidapp.live.vip.helper.VasBuyHelper;
import com.cupidapp.live.vip.layout.PurchaseTypeLayout;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.visitors.adapter.VisitorsPurchaserDiscountAdapter;
import com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout;
import com.cupidapp.live.visitors.model.VisitorRecallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: VisitorDiscountPurchaseLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorDiscountPurchaseLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f18942d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public PayType f18943e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public a f18944f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public AlertDialog f18945g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public VisitorRecallResult f18946h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public VipPurchasePriceModel f18947i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18948j;

    /* compiled from: VisitorDiscountPurchaseLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(@NotNull VipPurchasePriceModel vipPurchasePriceModel, @NotNull PayType payType);
    }

    /* compiled from: VisitorDiscountPurchaseLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f18950c;

        public b(Map.Entry<String, String> entry) {
            this.f18950c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, VisitorDiscountPurchaseLayout.this.getContext(), this.f18950c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorDiscountPurchaseLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18948j = new LinkedHashMap();
        this.f18942d = c.b(new Function0<VisitorsPurchaserDiscountAdapter>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$visitorsPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorsPurchaserDiscountAdapter invoke() {
                VisitorsPurchaserDiscountAdapter visitorsPurchaserDiscountAdapter = new VisitorsPurchaserDiscountAdapter();
                final VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout = VisitorDiscountPurchaseLayout.this;
                visitorsPurchaserDiscountAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$visitorsPurchasePriceAdapter$2$1$1
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
                        if (obj instanceof VipPurchasePriceModel) {
                            VisitorDiscountPurchaseLayout.this.v((VipPurchasePriceModel) obj);
                        }
                    }
                });
                return visitorsPurchaserDiscountAdapter;
            }
        });
        this.f18943e = PayType.AliPay;
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VisitorsPurchaserDiscountAdapter getVisitorsPurchasePriceAdapter() {
        return (VisitorsPurchaserDiscountAdapter) this.f18942d.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f18948j;
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

    public final void o() {
        TextView visitor_sale_pay_option = (TextView) e(R$id.visitor_sale_pay_option);
        s.h(visitor_sale_pay_option, "visitor_sale_pay_option");
        y.d(visitor_sale_pay_option, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$bindClickEvent$1
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
                VisitorRecallResult visitorRecallResult;
                VisitorRecallResult visitorRecallResult2;
                List<VipPurchasePriceModel> alipayOptions;
                List<VipPurchasePriceModel> wechatOptions;
                visitorRecallResult = VisitorDiscountPurchaseLayout.this.f18946h;
                boolean z10 = false;
                if ((visitorRecallResult == null || (wechatOptions = visitorRecallResult.getWechatOptions()) == null || !(wechatOptions.isEmpty() ^ true)) ? false : true) {
                    visitorRecallResult2 = VisitorDiscountPurchaseLayout.this.f18946h;
                    if (visitorRecallResult2 != null && (alipayOptions = visitorRecallResult2.getAlipayOptions()) != null && (!alipayOptions.isEmpty())) {
                        z10 = true;
                    }
                    if (z10) {
                        Context context = VisitorDiscountPurchaseLayout.this.getContext();
                        s.h(context, "context");
                        PurchaseTypeLayout purchaseTypeLayout = new PurchaseTypeLayout(context);
                        final VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout = VisitorDiscountPurchaseLayout.this;
                        purchaseTypeLayout.c(new Function2<String, PayType, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$bindClickEvent$1.1
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
                                VisitorDiscountPurchaseLayout.this.f18943e = type;
                                VisitorDiscountPurchaseLayout.this.x(typeText);
                            }
                        });
                    }
                }
            }
        });
        TextView buy_it_now_btn = (TextView) e(R$id.buy_it_now_btn);
        s.h(buy_it_now_btn, "buy_it_now_btn");
        y.d(buy_it_now_btn, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$bindClickEvent$2
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
                VisitorsPurchaserDiscountAdapter visitorsPurchasePriceAdapter;
                Object obj;
                visitorsPurchasePriceAdapter = VisitorDiscountPurchaseLayout.this.getVisitorsPurchasePriceAdapter();
                List<Object> j10 = visitorsPurchasePriceAdapter.j();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : j10) {
                    if (obj2 instanceof VipPurchasePriceModel) {
                        arrayList.add(obj2);
                    }
                }
                Iterator<E> iterator2 = arrayList.iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        obj = iterator2.next();
                        if (((VipPurchasePriceModel) obj).isSelected()) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                final VipPurchasePriceModel vipPurchasePriceModel = (VipPurchasePriceModel) obj;
                if (vipPurchasePriceModel != null) {
                    VasBuyHelper vasBuyHelper = VasBuyHelper.f18742a;
                    Context context = VisitorDiscountPurchaseLayout.this.getContext();
                    s.h(context, "context");
                    boolean isSelected = ((ImageView) VisitorDiscountPurchaseLayout.this.e(R$id.payment_terms_img)).isSelected();
                    final VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout = VisitorDiscountPurchaseLayout.this;
                    vasBuyHelper.b(context, isSelected, new Function0<p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$bindClickEvent$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ p invoke() {
                            invoke2();
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            VisitorDiscountPurchaseLayout.a aVar;
                            PayType payType;
                            VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout2 = VisitorDiscountPurchaseLayout.this;
                            int i10 = R$id.payment_terms_img;
                            if (((ImageView) visitorDiscountPurchaseLayout2.e(i10)).getVisibility() == 0) {
                                ((ImageView) VisitorDiscountPurchaseLayout.this.e(i10)).setSelected(true);
                            }
                            aVar = VisitorDiscountPurchaseLayout.this.f18944f;
                            if (aVar != null) {
                                VipPurchasePriceModel vipPurchasePriceModel2 = vipPurchasePriceModel;
                                payType = VisitorDiscountPurchaseLayout.this.f18943e;
                                aVar.a(vipPurchasePriceModel2, payType);
                            }
                        }
                    });
                }
            }
        });
        ImageView visitor_sale_close_img = (ImageView) e(R$id.visitor_sale_close_img);
        s.h(visitor_sale_close_img, "visitor_sale_close_img");
        y.d(visitor_sale_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$bindClickEvent$3
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
                alertDialog = VisitorDiscountPurchaseLayout.this.f18945g;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        ImageView payment_terms_img = (ImageView) e(R$id.payment_terms_img);
        s.h(payment_terms_img, "payment_terms_img");
        y.d(payment_terms_img, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$bindClickEvent$4
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
                ((ImageView) VisitorDiscountPurchaseLayout.this.e(R$id.payment_terms_img)).setSelected(!((ImageView) VisitorDiscountPurchaseLayout.this.e(r0)).isSelected());
            }
        });
    }

    public final void p(VipPurchasePriceModel vipPurchasePriceModel) {
        Iterator<Object> iterator2 = getVisitorsPurchasePriceAdapter().j().iterator2();
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
            if (next instanceof VipPurchasePriceModel) {
                VipPurchasePriceModel vipPurchasePriceModel2 = (VipPurchasePriceModel) next;
                if (s.d(vipPurchasePriceModel2.getId(), vipPurchasePriceModel != null ? vipPurchasePriceModel.getId() : null) && s.d(vipPurchasePriceModel2.getSkuCode(), vipPurchasePriceModel.getSkuCode())) {
                    vipPurchasePriceModel2.setSelected(true);
                    this.f18947i = vipPurchasePriceModel2;
                } else {
                    vipPurchasePriceModel2.setSelected(false);
                }
            }
            i10 = i11;
        }
        s(vipPurchasePriceModel != null ? vipPurchasePriceModel.getDescription() : null);
    }

    public final void q(VisitorRecallResult visitorRecallResult) {
        String string;
        this.f18947i = null;
        List<VipPurchasePriceModel> alipayOptions = visitorRecallResult.getAlipayOptions();
        this.f18943e = alipayOptions == null || alipayOptions.isEmpty() ? PayType.WeChatPay : PayType.AliPay;
        this.f18946h = visitorRecallResult;
        w();
        if (this.f18943e == PayType.WeChatPay) {
            string = getContext().getString(R$string.weChat_pay);
        } else {
            string = getContext().getString(R$string.aliPay);
        }
        s.h(string, "if (payType == PayType.W….string.aliPay)\n        }");
        x(string);
        if (visitorRecallResult.getImageUrl() != null) {
            int i10 = R$id.visitor_sale_img;
            ((ImageLoaderView) e(i10)).setVisibility(0);
            int c4 = h.c(this, 260.0f);
            int scaleHeightByWidth = visitorRecallResult.getImageUrl().getScaleHeightByWidth(c4);
            ImageLoaderView visitor_sale_img = (ImageLoaderView) e(i10);
            s.h(visitor_sale_img, "visitor_sale_img");
            y.n(visitor_sale_img, Integer.valueOf(c4), Integer.valueOf(scaleHeightByWidth));
            ImageLoaderView visitor_sale_img2 = (ImageLoaderView) e(i10);
            s.h(visitor_sale_img2, "visitor_sale_img");
            ImageLoaderView.g(visitor_sale_img2, visitorRecallResult.getImageUrl(), null, null, 6, null);
        } else {
            ((ImageLoaderView) e(R$id.visitor_sale_img)).setVisibility(8);
        }
        if (VasBuyHelper.f18742a.a()) {
            int i11 = R$id.payment_terms_img;
            ((ImageView) e(i11)).setVisibility(0);
            ((ImageView) e(i11)).setSelected(false);
            return;
        }
        ((ImageView) e(R$id.payment_terms_img)).setVisibility(4);
    }

    public final void r() {
        LinkDictTipsModel addServicesTips;
        SpannableStringBuilder c4;
        Set<Map.Entry<String, String>> entrySet;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ConstantsResult q10 = g.f52734a.q();
        if (q10 == null || (addServicesTips = q10.getAddServicesTips()) == null) {
            return;
        }
        Map<String, String> linkDict = addServicesTips.getLinkDict();
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
        c4 = q1.d.f53006a.c(addServicesTips.getContent(), arrayList, (r18 & 4) != 0 ? null : -1, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
        int i12 = R$id.purchaseProtocol;
        ((TextView) e(i12)).setText(c4);
        ((TextView) e(i12)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void s(String str) {
        if (str == null || str.length() == 0) {
            ((TextView) e(R$id.visitor_sale_option_tip)).setVisibility(4);
            return;
        }
        int i10 = R$id.visitor_sale_option_tip;
        ((TextView) e(i10)).setVisibility(0);
        ((TextView) e(i10)).setText(str);
    }

    public final void setVipPurchaseClickListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f18944f = listener;
    }

    public final void t() {
        AlertDialog alertDialog = this.f18945g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void u() {
        z.a(this, R$layout.layout_visitor_new_purchase, true);
        ((TextView) e(R$id.visitor_sale_pay_option)).getPaint().setFakeBoldText(true);
        RecyclerView initView$lambda$0 = (RecyclerView) e(R$id.visitor_sale_recycler);
        initView$lambda$0.setLayoutManager(new LinearLayoutManager(initView$lambda$0.getContext(), 0, false));
        s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.addItemDecoration(new AddExtraSpacingDecoration(h.c(initView$lambda$0, 3.0f), 0, h.c(initView$lambda$0, 3.0f), 0, h.c(initView$lambda$0, 13.0f)));
        initView$lambda$0.setAdapter(getVisitorsPurchasePriceAdapter());
        TextView buy_it_now_btn = (TextView) e(R$id.buy_it_now_btn);
        s.h(buy_it_now_btn, "buy_it_now_btn");
        u.a(buy_it_now_btn);
        r();
        o();
    }

    public final void v(VipPurchasePriceModel vipPurchasePriceModel) {
        p(vipPurchasePriceModel);
        getVisitorsPurchasePriceAdapter().notifyDataSetChanged();
    }

    public final void w() {
        VisitorRecallResult visitorRecallResult = this.f18946h;
        Long userStrategyEndTime = visitorRecallResult != null ? visitorRecallResult.getUserStrategyEndTime() : null;
        if (userStrategyEndTime == null) {
            ((SaleTimeCountLayout) e(R$id.visitor_sale_time_layout)).setVisibility(8);
            return;
        }
        long longValue = userStrategyEndTime.longValue() - System.currentTimeMillis();
        if (longValue <= 0) {
            ((SaleTimeCountLayout) e(R$id.visitor_sale_time_layout)).setVisibility(8);
            return;
        }
        int i10 = R$id.visitor_sale_time_layout;
        ((SaleTimeCountLayout) e(i10)).setVisibility(0);
        ((SaleTimeCountLayout) e(i10)).b(longValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout.x(java.lang.String):void");
    }

    @Nullable
    public final AlertDialog y(@NotNull VisitorRecallResult model) {
        Window window;
        s.i(model, "model");
        q(model);
        if (this.f18945g == null) {
            this.f18945g = z0.b.f54812a.e(getContext()).setView(this).create();
        }
        AlertDialog alertDialog = this.f18945g;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog2 = this.f18945g;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        AlertDialog alertDialog3 = this.f18945g;
        if (alertDialog3 != null && (window = alertDialog3.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
        return this.f18945g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorDiscountPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18948j = new LinkedHashMap();
        this.f18942d = c.b(new Function0<VisitorsPurchaserDiscountAdapter>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$visitorsPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorsPurchaserDiscountAdapter invoke() {
                VisitorsPurchaserDiscountAdapter visitorsPurchaserDiscountAdapter = new VisitorsPurchaserDiscountAdapter();
                final VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout = VisitorDiscountPurchaseLayout.this;
                visitorsPurchaserDiscountAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$visitorsPurchasePriceAdapter$2$1$1
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
                        if (obj instanceof VipPurchasePriceModel) {
                            VisitorDiscountPurchaseLayout.this.v((VipPurchasePriceModel) obj);
                        }
                    }
                });
                return visitorsPurchaserDiscountAdapter;
            }
        });
        this.f18943e = PayType.AliPay;
        u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorDiscountPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18948j = new LinkedHashMap();
        this.f18942d = c.b(new Function0<VisitorsPurchaserDiscountAdapter>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$visitorsPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorsPurchaserDiscountAdapter invoke() {
                VisitorsPurchaserDiscountAdapter visitorsPurchaserDiscountAdapter = new VisitorsPurchaserDiscountAdapter();
                final VisitorDiscountPurchaseLayout visitorDiscountPurchaseLayout = VisitorDiscountPurchaseLayout.this;
                visitorsPurchaserDiscountAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorDiscountPurchaseLayout$visitorsPurchasePriceAdapter$2$1$1
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
                        if (obj instanceof VipPurchasePriceModel) {
                            VisitorDiscountPurchaseLayout.this.v((VipPurchasePriceModel) obj);
                        }
                    }
                });
                return visitorsPurchaserDiscountAdapter;
            }
        });
        this.f18943e = PayType.AliPay;
        u();
    }
}
