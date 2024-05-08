package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.vip.helper.VasBuyHelper;
import com.cupidapp.live.vip.layout.APlusVipPurchaseLayout;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.model.VipOptionsModel;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.model.VipType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.o;
import z0.t;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: APlusVipPurchaseLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class APlusVipPurchaseLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f18756b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Map<VipType, VipOptionsModel> f18757c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public VipPurchaseEntranceType f18758d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public VipType f18759e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public PayType f18760f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public VipPurchasePriceModel f18761g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18762h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18763i;

    /* compiled from: APlusVipPurchaseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(@NotNull VipPurchasePriceModel vipPurchasePriceModel, @NotNull PayType payType);

        void b();

        void c(@NotNull VipType vipType);

        void d();

        void e();
    }

    /* compiled from: APlusVipPurchaseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18764a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18765b;

        static {
            int[] iArr = new int[VipType.values().length];
            try {
                iArr[VipType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VipType.SUPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VipType.RAINBOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VipType.VISITOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f18764a = iArr;
            int[] iArr2 = new int[PayType.values().length];
            try {
                iArr2[PayType.AliPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PayType.WeChatPay.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PayType.AliPayHuaBei.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f18765b = iArr2;
        }
    }

    /* compiled from: APlusVipPurchaseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f18767c;

        public c(Map.Entry<String, String> entry) {
            this.f18767c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, APlusVipPurchaseLayout.this.getContext(), this.f18767c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APlusVipPurchaseLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18763i = new LinkedHashMap();
        this.f18758d = VipPurchaseEntranceType.Filter;
        this.f18759e = VipType.SUPER;
        this.f18760f = PayType.AliPay;
        u();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18763i;
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
        ((VipPurchaseTabLayout) a(R$id.vip_purchase_tab_layout)).setTabSelectCallback(new Function1<VipType, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VipType vipType) {
                invoke2(vipType);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VipType it) {
                APlusVipPurchaseLayout.a aVar;
                s.i(it, "it");
                APlusVipPurchaseLayout.this.f18759e = it;
                APlusVipPurchaseLayout.this.f18760f = PayType.AliPay;
                ((TextView) APlusVipPurchaseLayout.this.a(R$id.purchase_type_text)).setText(APlusVipPurchaseLayout.this.getContext().getString(R$string.aliPay));
                APlusVipPurchaseLayout.this.f18761g = null;
                APlusVipPurchaseLayout.this.f18762h = false;
                APlusVipPurchaseLayout.this.s();
                aVar = APlusVipPurchaseLayout.this.f18756b;
                if (aVar != null) {
                    aVar.c(it);
                }
            }
        });
        ((VipPurchaseSkuLayout) a(R$id.purchase_sku_layout)).setSelectCurrentPriceCallback(new Function1<VipPurchasePriceModel, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VipPurchasePriceModel vipPurchasePriceModel) {
                invoke2(vipPurchasePriceModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VipPurchasePriceModel it) {
                s.i(it, "it");
                APlusVipPurchaseLayout.this.f18761g = it;
                APlusVipPurchaseLayout aPlusVipPurchaseLayout = APlusVipPurchaseLayout.this;
                String description = it.getDescription();
                if (description == null) {
                    description = "";
                }
                aPlusVipPurchaseLayout.p(description);
                String detailInfo = it.getDetailInfo();
                if (detailInfo == null || detailInfo.length() == 0) {
                    ((TextView) APlusVipPurchaseLayout.this.a(R$id.purchase_tips_txt)).setVisibility(8);
                    return;
                }
                APlusVipPurchaseLayout aPlusVipPurchaseLayout2 = APlusVipPurchaseLayout.this;
                int i10 = R$id.purchase_tips_txt;
                TextView purchase_tips_txt = (TextView) aPlusVipPurchaseLayout2.a(i10);
                s.h(purchase_tips_txt, "purchase_tips_txt");
                u.a(purchase_tips_txt);
                ((TextView) APlusVipPurchaseLayout.this.a(i10)).setVisibility(0);
                ((TextView) APlusVipPurchaseLayout.this.a(i10)).setText(t.a(it.getDetailInfo(), -8618884));
            }
        });
        LinearLayout purchase_type_layout = (LinearLayout) a(R$id.purchase_type_layout);
        s.h(purchase_type_layout, "purchase_type_layout");
        y.d(purchase_type_layout, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$3
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
                Context context = APlusVipPurchaseLayout.this.getContext();
                s.h(context, "context");
                PurchaseTypeLayout purchaseTypeLayout = new PurchaseTypeLayout(context);
                final APlusVipPurchaseLayout aPlusVipPurchaseLayout = APlusVipPurchaseLayout.this;
                purchaseTypeLayout.c(new Function2<String, PayType, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$3.1
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
                        PayType payType;
                        s.i(typeText, "typeText");
                        s.i(type, "type");
                        payType = APlusVipPurchaseLayout.this.f18760f;
                        if (payType == type) {
                            return;
                        }
                        APlusVipPurchaseLayout.this.f18760f = type;
                        ((TextView) APlusVipPurchaseLayout.this.a(R$id.purchase_type_text)).setText(typeText);
                        APlusVipPurchaseLayout.this.x();
                    }
                });
            }
        });
        TextView vip_purchase_text = (TextView) a(R$id.vip_purchase_text);
        s.h(vip_purchase_text, "vip_purchase_text");
        y.d(vip_purchase_text, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$4
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
                final VipPurchasePriceModel vipPurchasePriceModel;
                vipPurchasePriceModel = APlusVipPurchaseLayout.this.f18761g;
                if (vipPurchasePriceModel != null) {
                    final APlusVipPurchaseLayout aPlusVipPurchaseLayout = APlusVipPurchaseLayout.this;
                    VasBuyHelper vasBuyHelper = VasBuyHelper.f18742a;
                    Context context = aPlusVipPurchaseLayout.getContext();
                    s.h(context, "context");
                    vasBuyHelper.b(context, ((ImageView) aPlusVipPurchaseLayout.a(R$id.payment_terms_img)).isSelected(), new Function0<p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$4$1$1
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
                            APlusVipPurchaseLayout.a aVar;
                            PayType payType;
                            APlusVipPurchaseLayout aPlusVipPurchaseLayout2 = APlusVipPurchaseLayout.this;
                            int i10 = R$id.payment_terms_img;
                            if (((ImageView) aPlusVipPurchaseLayout2.a(i10)).getVisibility() == 0) {
                                ((ImageView) APlusVipPurchaseLayout.this.a(i10)).setSelected(true);
                            }
                            aVar = APlusVipPurchaseLayout.this.f18756b;
                            if (aVar != null) {
                                VipPurchasePriceModel vipPurchasePriceModel2 = vipPurchasePriceModel;
                                payType = APlusVipPurchaseLayout.this.f18760f;
                                aVar.a(vipPurchasePriceModel2, payType);
                            }
                        }
                    });
                }
            }
        });
        LinearLayout to_superlike_layout = (LinearLayout) a(R$id.to_superlike_layout);
        s.h(to_superlike_layout, "to_superlike_layout");
        y.d(to_superlike_layout, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$5
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
                APlusVipPurchaseLayout.a aVar;
                aVar = APlusVipPurchaseLayout.this.f18756b;
                if (aVar != null) {
                    aVar.e();
                }
            }
        });
        ImageView vip_close_imageview = (ImageView) a(R$id.vip_close_imageview);
        s.h(vip_close_imageview, "vip_close_imageview");
        y.d(vip_close_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$6
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
                APlusVipPurchaseLayout.a aVar;
                aVar = APlusVipPurchaseLayout.this.f18756b;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
        TextView more_sku_txt = (TextView) a(R$id.more_sku_txt);
        s.h(more_sku_txt, "more_sku_txt");
        y.d(more_sku_txt, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$7
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
                Map map;
                VipOptionsModel vipOptionsModel;
                APlusVipPurchaseLayout.a aVar;
                VipType vipType;
                APlusVipPurchaseLayout.this.f18762h = true;
                map = APlusVipPurchaseLayout.this.f18757c;
                if (map != null) {
                    vipType = APlusVipPurchaseLayout.this.f18759e;
                    vipOptionsModel = (VipOptionsModel) map.get(vipType);
                } else {
                    vipOptionsModel = null;
                }
                APlusVipPurchaseLayout.this.w(vipOptionsModel);
                aVar = APlusVipPurchaseLayout.this.f18756b;
                if (aVar != null) {
                    aVar.d();
                }
            }
        });
        ImageView payment_terms_img = (ImageView) a(R$id.payment_terms_img);
        s.h(payment_terms_img, "payment_terms_img");
        y.d(payment_terms_img, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusVipPurchaseLayout$bindClickEvent$8
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
                ((ImageView) APlusVipPurchaseLayout.this.a(R$id.payment_terms_img)).setSelected(!((ImageView) APlusVipPurchaseLayout.this.a(r0)).isSelected());
            }
        });
    }

    public final void p(String str) {
        LinkDictTipsModel billingVipTips;
        SpannableStringBuilder c4;
        Set<Map.Entry<String, String>> entrySet;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ConstantsResult q10 = g.f52734a.q();
        if (q10 != null && (billingVipTips = q10.getBillingVipTips()) != null) {
            Map<String, String> linkDict = billingVipTips.getLinkDict();
            if (linkDict != null && (entrySet = linkDict.entrySet()) != null) {
                int i10 = 0;
                for (Map.Entry<String, String> entry : entrySet) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        kotlin.collections.s.s();
                    }
                    Map.Entry<String, String> entry2 = entry;
                    arrayList.add(i10, entry2.getKey());
                    arrayList2.add(i10, new c(entry2));
                    i10 = i11;
                }
            }
            c4 = q1.d.f53006a.c(billingVipTips.getContent(), arrayList, (r18 & 4) != 0 ? null : -1, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : true, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
            int i12 = R$id.payment_terms_txt;
            ((TextView) a(i12)).setText(c4);
            ((TextView) a(i12)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        ((TextView) a(R$id.protocol_textview)).setText(str);
    }

    public final void q(boolean z10, String str) {
        if (z10) {
            LinearLayout to_superlike_layout = (LinearLayout) a(R$id.to_superlike_layout);
            s.h(to_superlike_layout, "to_superlike_layout");
            to_superlike_layout.setVisibility(0);
            if (str == null || str.length() == 0) {
                TextView superlike_unit_price = (TextView) a(R$id.superlike_unit_price);
                s.h(superlike_unit_price, "superlike_unit_price");
                superlike_unit_price.setVisibility(8);
                return;
            } else {
                int i10 = R$id.superlike_unit_price;
                TextView superlike_unit_price2 = (TextView) a(i10);
                s.h(superlike_unit_price2, "superlike_unit_price");
                superlike_unit_price2.setVisibility(0);
                ((TextView) a(i10)).setText(str);
                return;
            }
        }
        LinearLayout to_superlike_layout2 = (LinearLayout) a(R$id.to_superlike_layout);
        s.h(to_superlike_layout2, "to_superlike_layout");
        to_superlike_layout2.setVisibility(8);
    }

    public final void r(VipType vipType) {
        int i10 = b.f18764a[vipType.ordinal()];
        if (i10 == 1) {
            a(R$id.rainbow_vip_bg_view).setBackground(null);
            ((ConstraintLayout) a(R$id.vip_purchase_layout)).setBackgroundResource(R$drawable.shape_white_bg_twenty_corners);
            int i11 = R$id.vip_purchase_text;
            ((TextView) a(i11)).setBackgroundResource(R$drawable.shape_prime_red_bg_round_corners);
            ((TextView) a(i11)).setTextColor(-1);
            ((TextView) a(R$id.purchase_type_text)).setTextColor(-15066598);
            ImageView purchase_type_image = (ImageView) a(R$id.purchase_type_image);
            s.h(purchase_type_image, "purchase_type_image");
            o.b(purchase_type_image, -15066598);
            ImageView vip_close_imageview = (ImageView) a(R$id.vip_close_imageview);
            s.h(vip_close_imageview, "vip_close_imageview");
            o.b(vip_close_imageview, -7434610);
            return;
        }
        if (i10 == 2) {
            a(R$id.rainbow_vip_bg_view).setBackground(null);
            ((ConstraintLayout) a(R$id.vip_purchase_layout)).setBackgroundResource(R$drawable.shape_black_bg_20_corners);
            int i12 = R$id.vip_purchase_text;
            ((TextView) a(i12)).setBackgroundResource(R$drawable.shape_gold_gradient_bg_round_corners);
            ((TextView) a(i12)).setTextColor(-15066598);
            ((TextView) a(R$id.purchase_type_text)).setTextColor(-1);
            ImageView purchase_type_image2 = (ImageView) a(R$id.purchase_type_image);
            s.h(purchase_type_image2, "purchase_type_image");
            o.b(purchase_type_image2, -1);
            ImageView vip_close_imageview2 = (ImageView) a(R$id.vip_close_imageview);
            s.h(vip_close_imageview2, "vip_close_imageview");
            o.b(vip_close_imageview2, -3750202);
            return;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                return;
            }
            a(R$id.rainbow_vip_bg_view).setBackground(null);
            ((ConstraintLayout) a(R$id.vip_purchase_layout)).setBackgroundResource(R$drawable.shape_white_bg_twenty_corners);
            int i13 = R$id.vip_purchase_text;
            ((TextView) a(i13)).setBackgroundResource(R$drawable.shape_prime_red_bg_round_corners);
            ((TextView) a(i13)).setTextColor(-1);
            ((TextView) a(R$id.purchase_type_text)).setTextColor(-15066598);
            ImageView purchase_type_image3 = (ImageView) a(R$id.purchase_type_image);
            s.h(purchase_type_image3, "purchase_type_image");
            o.b(purchase_type_image3, -15066598);
            ImageView vip_close_imageview3 = (ImageView) a(R$id.vip_close_imageview);
            s.h(vip_close_imageview3, "vip_close_imageview");
            o.b(vip_close_imageview3, -7434610);
            return;
        }
        a(R$id.rainbow_vip_bg_view).setBackgroundResource(R$mipmap.rainbow_vip_bg);
        ((ConstraintLayout) a(R$id.vip_purchase_layout)).setBackgroundResource(R$drawable.shape_black_bg_20_corners);
        TextView vip_purchase_text = (TextView) a(R$id.vip_purchase_text);
        s.h(vip_purchase_text, "vip_purchase_text");
        float c4 = h.c(this, 100.0f);
        List m10 = kotlin.collections.s.m(-2088928, -367616, -543488, -9579520, -16739841, -10340609, -4841248);
        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(m10, 10));
        Iterator<E> iterator2 = m10.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(Integer.valueOf(com.cupidapp.live.base.utils.h.a(((Number) iterator2.next()).intValue(), 0.8f)));
        }
        y.i(vip_purchase_text, (r18 & 1) != 0 ? 0.0f : c4, arrayList, (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TL_BR, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        ((TextView) a(R$id.vip_purchase_text)).setTextColor(-1);
        ((TextView) a(R$id.purchase_type_text)).setTextColor(-1);
        ImageView purchase_type_image4 = (ImageView) a(R$id.purchase_type_image);
        s.h(purchase_type_image4, "purchase_type_image");
        o.b(purchase_type_image4, -1);
        ImageView vip_close_imageview4 = (ImageView) a(R$id.vip_close_imageview);
        s.h(vip_close_imageview4, "vip_close_imageview");
        o.b(vip_close_imageview4, -3750202);
    }

    public final void s() {
        ((VipPurchaseGuideLayout) a(R$id.purchase_guide_layout)).v(this.f18759e, this.f18758d);
        Map<VipType, VipOptionsModel> map = this.f18757c;
        VipOptionsModel vipOptionsModel = map != null ? map.get(this.f18759e) : null;
        ((VipActivityCountDownLayout) a(R$id.activity_count_down_layout)).b(vipOptionsModel != null ? Long.valueOf(vipOptionsModel.getUserStrategyEndTime()) : null);
        w(vipOptionsModel);
        r(this.f18759e);
    }

    public final void setVipPurchaseClickListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f18756b = listener;
    }

    public final void t(@NotNull Map<VipType, VipOptionsModel> optionsMap, @NotNull VipType defaultVipType, @NotNull VipPurchaseEntranceType entranceType, boolean z10) {
        s.i(optionsMap, "optionsMap");
        s.i(defaultVipType, "defaultVipType");
        s.i(entranceType, "entranceType");
        this.f18757c = optionsMap;
        this.f18758d = entranceType;
        this.f18759e = defaultVipType;
        this.f18760f = PayType.AliPay;
        this.f18761g = null;
        this.f18762h = false;
        ((TextView) a(R$id.purchase_type_text)).setText(getContext().getString(R$string.aliPay));
        ((VipPurchaseTabLayout) a(R$id.vip_purchase_tab_layout)).f(CollectionsKt___CollectionsKt.x0(optionsMap.h()), defaultVipType);
        s();
        VipOptionsModel vipOptionsModel = optionsMap.get(defaultVipType);
        q(z10, vipOptionsModel != null ? vipOptionsModel.getSuperLikePurchaseDescription() : null);
        if (VasBuyHelper.f18742a.a()) {
            int i10 = R$id.payment_terms_img;
            ((ImageView) a(i10)).setVisibility(0);
            ((ImageView) a(i10)).setSelected(false);
            return;
        }
        ((ImageView) a(R$id.payment_terms_img)).setVisibility(4);
    }

    public final void u() {
        z.a(this, R$layout.layout_super_vip_purchase, true);
        ((TextView) a(R$id.purchase_type_text)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.vip_purchase_text)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.to_superlike_purchase)).getPaint().setFakeBoldText(true);
        o();
    }

    public final void v(VipOptionsModel vipOptionsModel) {
        if (!this.f18762h) {
            if (vipOptionsModel != null && vipOptionsModel.hasHideOptions(this.f18760f)) {
                ((TextView) a(R$id.more_sku_txt)).setVisibility(0);
                return;
            }
        }
        ((TextView) a(R$id.more_sku_txt)).setVisibility(4);
    }

    public final void w(VipOptionsModel vipOptionsModel) {
        v(vipOptionsModel);
        int i10 = b.f18765b[this.f18760f.ordinal()];
        List<VipPurchasePriceModel> list = null;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.f18762h) {
                    if (vipOptionsModel != null) {
                        list = vipOptionsModel.getAllAlipayOptions();
                    }
                } else if (vipOptionsModel != null) {
                    list = vipOptionsModel.getBaseAlipayOptions();
                }
            } else if (this.f18762h) {
                if (vipOptionsModel != null) {
                    list = vipOptionsModel.getAllWeChatOptions();
                }
            } else if (vipOptionsModel != null) {
                list = vipOptionsModel.getBaseWechatOptions();
            }
        } else if (this.f18762h) {
            if (vipOptionsModel != null) {
                list = vipOptionsModel.getAllAlipayOptions();
            }
        } else if (vipOptionsModel != null) {
            list = vipOptionsModel.getBaseAlipayOptions();
        }
        ((VipPurchaseSkuLayout) a(R$id.purchase_sku_layout)).f(list, this.f18761g, this.f18759e);
    }

    public final void x() {
        Map<VipType, VipOptionsModel> map = this.f18757c;
        w(map != null ? map.get(this.f18759e) : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APlusVipPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18763i = new LinkedHashMap();
        this.f18758d = VipPurchaseEntranceType.Filter;
        this.f18759e = VipType.SUPER;
        this.f18760f = PayType.AliPay;
        u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APlusVipPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18763i = new LinkedHashMap();
        this.f18758d = VipPurchaseEntranceType.Filter;
        this.f18759e = VipType.SUPER;
        this.f18760f = PayType.AliPay;
        u();
    }
}
