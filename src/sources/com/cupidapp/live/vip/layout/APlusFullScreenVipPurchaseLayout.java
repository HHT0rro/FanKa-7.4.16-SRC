package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.vip.adapter.VipFunctionAdapter;
import com.cupidapp.live.vip.helper.VasBuyHelper;
import com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.model.VipClientUiInfoModel;
import com.cupidapp.live.vip.model.VipFunctionUiModel;
import com.cupidapp.live.vip.model.VipOptionsModel;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.model.VipType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
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
import z0.o;
import z0.t;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: APlusFullScreenVipPurchaseLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class APlusFullScreenVipPurchaseLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f18743b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Map<VipType, VipOptionsModel> f18744c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public VipPurchaseEntranceType f18745d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public VipType f18746e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public PayType f18747f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public VipPurchasePriceModel f18748g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18749h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f18750i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18751j;

    /* compiled from: APlusFullScreenVipPurchaseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(@NotNull VipPurchasePriceModel vipPurchasePriceModel, @NotNull PayType payType);

        void b();

        void c(@NotNull VipType vipType);

        void d();

        void e();
    }

    /* compiled from: APlusFullScreenVipPurchaseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18752a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18753b;

        static {
            int[] iArr = new int[VipType.values().length];
            try {
                iArr[VipType.SUPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VipType.RAINBOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18752a = iArr;
            int[] iArr2 = new int[PayType.values().length];
            try {
                iArr2[PayType.AliPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PayType.WeChatPay.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PayType.AliPayHuaBei.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f18753b = iArr2;
        }
    }

    /* compiled from: APlusFullScreenVipPurchaseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f18755c;

        public c(Map.Entry<String, String> entry) {
            this.f18755c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, APlusFullScreenVipPurchaseLayout.this.getContext(), this.f18755c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APlusFullScreenVipPurchaseLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18751j = new LinkedHashMap();
        this.f18745d = VipPurchaseEntranceType.Filter;
        this.f18746e = VipType.SUPER;
        this.f18747f = PayType.AliPay;
        this.f18750i = kotlin.c.b(new Function0<VipFunctionAdapter>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipFunctionAdapter invoke() {
                VipFunctionAdapter vipFunctionAdapter = new VipFunctionAdapter();
                final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = APlusFullScreenVipPurchaseLayout.this;
                vipFunctionAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2$1$1
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
                        if (obj instanceof VipFunctionUiModel) {
                            APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout2 = APlusFullScreenVipPurchaseLayout.this;
                            int i10 = R$id.function_intro_layout;
                            final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout3 = APlusFullScreenVipPurchaseLayout.this;
                            ((VipFunctionIntroLayout) aPlusFullScreenVipPurchaseLayout2.a(i10)).f((VipFunctionUiModel) obj, new Function0<p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2$1$1.1
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
                                    ((VipFunctionIntroLayout) APlusFullScreenVipPurchaseLayout.this.a(R$id.function_intro_layout)).setVisibility(8);
                                }
                            });
                            ((VipFunctionIntroLayout) APlusFullScreenVipPurchaseLayout.this.a(i10)).setVisibility(0);
                        }
                    }
                });
                return vipFunctionAdapter;
            }
        });
        v();
    }

    private final VipFunctionAdapter getAdapter() {
        return (VipFunctionAdapter) this.f18750i.getValue();
    }

    public final void A(VipOptionsModel vipOptionsModel) {
        if (!this.f18749h) {
            if (vipOptionsModel != null && vipOptionsModel.hasHideOptions(this.f18747f)) {
                ((TextView) a(R$id.more_sku_txt)).setVisibility(0);
                return;
            }
        }
        ((TextView) a(R$id.more_sku_txt)).setVisibility(4);
    }

    public final void B(VipOptionsModel vipOptionsModel) {
        A(vipOptionsModel);
        int i10 = b.f18753b[this.f18747f.ordinal()];
        List<VipPurchasePriceModel> list = null;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.f18749h) {
                    if (vipOptionsModel != null) {
                        list = vipOptionsModel.getAllAlipayOptions();
                    }
                } else if (vipOptionsModel != null) {
                    list = vipOptionsModel.getBaseAlipayOptions();
                }
            } else if (this.f18749h) {
                if (vipOptionsModel != null) {
                    list = vipOptionsModel.getAllWeChatOptions();
                }
            } else if (vipOptionsModel != null) {
                list = vipOptionsModel.getBaseWechatOptions();
            }
        } else if (this.f18749h) {
            if (vipOptionsModel != null) {
                list = vipOptionsModel.getAllAlipayOptions();
            }
        } else if (vipOptionsModel != null) {
            list = vipOptionsModel.getBaseAlipayOptions();
        }
        ((VipPurchaseFullScreenSkuLayout) a(R$id.purchase_sku_layout)).f(list, this.f18748g, this.f18746e);
    }

    public final void C() {
        Map<VipType, VipOptionsModel> map = this.f18744c;
        B(map != null ? map.get(this.f18746e) : null);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18751j;
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

    public final void p() {
        ((VipPurchaseTabLayout) a(R$id.vip_purchase_tab_layout)).setTabSelectCallback(new Function1<VipType, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$1
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
                APlusFullScreenVipPurchaseLayout.a aVar;
                s.i(it, "it");
                APlusFullScreenVipPurchaseLayout.this.f18746e = it;
                APlusFullScreenVipPurchaseLayout.this.f18747f = PayType.AliPay;
                ((TextView) APlusFullScreenVipPurchaseLayout.this.a(R$id.purchase_type_text)).setText(APlusFullScreenVipPurchaseLayout.this.getContext().getString(R$string.aliPay));
                APlusFullScreenVipPurchaseLayout.this.f18748g = null;
                APlusFullScreenVipPurchaseLayout.this.f18749h = false;
                APlusFullScreenVipPurchaseLayout.this.t();
                aVar = APlusFullScreenVipPurchaseLayout.this.f18743b;
                if (aVar != null) {
                    aVar.c(it);
                }
            }
        });
        ((VipPurchaseFullScreenSkuLayout) a(R$id.purchase_sku_layout)).setSelectCurrentPriceCallback(new Function1<VipPurchasePriceModel, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$2
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
                VipPurchasePriceModel vipPurchasePriceModel;
                s.i(it, "it");
                APlusFullScreenVipPurchaseLayout.this.f18748g = it;
                APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = APlusFullScreenVipPurchaseLayout.this;
                String description = it.getDescription();
                if (description == null) {
                    description = "";
                }
                aPlusFullScreenVipPurchaseLayout.q(description);
                String detailInfo = it.getDetailInfo();
                if (detailInfo == null || detailInfo.length() == 0) {
                    ((TextView) APlusFullScreenVipPurchaseLayout.this.a(R$id.purchase_tips_txt)).setVisibility(8);
                } else {
                    APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout2 = APlusFullScreenVipPurchaseLayout.this;
                    int i10 = R$id.purchase_tips_txt;
                    TextView purchase_tips_txt = (TextView) aPlusFullScreenVipPurchaseLayout2.a(i10);
                    s.h(purchase_tips_txt, "purchase_tips_txt");
                    u.a(purchase_tips_txt);
                    ((TextView) APlusFullScreenVipPurchaseLayout.this.a(i10)).setVisibility(0);
                    ((TextView) APlusFullScreenVipPurchaseLayout.this.a(i10)).setText(t.a(it.getDetailInfo(), -8618884));
                }
                APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout3 = APlusFullScreenVipPurchaseLayout.this;
                vipPurchasePriceModel = aPlusFullScreenVipPurchaseLayout3.f18748g;
                aPlusFullScreenVipPurchaseLayout3.z(vipPurchasePriceModel != null ? vipPurchasePriceModel.getPaymentButtonTag() : null);
            }
        });
        LinearLayout purchase_type_layout = (LinearLayout) a(R$id.purchase_type_layout);
        s.h(purchase_type_layout, "purchase_type_layout");
        y.d(purchase_type_layout, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$3
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
                Context context = APlusFullScreenVipPurchaseLayout.this.getContext();
                s.h(context, "context");
                PurchaseTypeLayout purchaseTypeLayout = new PurchaseTypeLayout(context);
                final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = APlusFullScreenVipPurchaseLayout.this;
                purchaseTypeLayout.c(new Function2<String, PayType, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$3.1
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
                        payType = APlusFullScreenVipPurchaseLayout.this.f18747f;
                        if (payType == type) {
                            return;
                        }
                        APlusFullScreenVipPurchaseLayout.this.f18747f = type;
                        ((TextView) APlusFullScreenVipPurchaseLayout.this.a(R$id.purchase_type_text)).setText(typeText);
                        APlusFullScreenVipPurchaseLayout.this.C();
                    }
                });
            }
        });
        TextView vip_purchase_text = (TextView) a(R$id.vip_purchase_text);
        s.h(vip_purchase_text, "vip_purchase_text");
        y.d(vip_purchase_text, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$4
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
                vipPurchasePriceModel = APlusFullScreenVipPurchaseLayout.this.f18748g;
                if (vipPurchasePriceModel != null) {
                    final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = APlusFullScreenVipPurchaseLayout.this;
                    VasBuyHelper vasBuyHelper = VasBuyHelper.f18742a;
                    Context context = aPlusFullScreenVipPurchaseLayout.getContext();
                    s.h(context, "context");
                    vasBuyHelper.b(context, ((ImageView) aPlusFullScreenVipPurchaseLayout.a(R$id.payment_terms_img)).isSelected(), new Function0<p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$4$1$1
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
                            APlusFullScreenVipPurchaseLayout.a aVar;
                            PayType payType;
                            APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout2 = APlusFullScreenVipPurchaseLayout.this;
                            int i10 = R$id.payment_terms_img;
                            if (((ImageView) aPlusFullScreenVipPurchaseLayout2.a(i10)).getVisibility() == 0) {
                                ((ImageView) APlusFullScreenVipPurchaseLayout.this.a(i10)).setSelected(true);
                            }
                            aVar = APlusFullScreenVipPurchaseLayout.this.f18743b;
                            if (aVar != null) {
                                VipPurchasePriceModel vipPurchasePriceModel2 = vipPurchasePriceModel;
                                payType = APlusFullScreenVipPurchaseLayout.this.f18747f;
                                aVar.a(vipPurchasePriceModel2, payType);
                            }
                        }
                    });
                }
            }
        });
        LinearLayout to_superlike_layout = (LinearLayout) a(R$id.to_superlike_layout);
        s.h(to_superlike_layout, "to_superlike_layout");
        y.d(to_superlike_layout, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$5
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
                APlusFullScreenVipPurchaseLayout.a aVar;
                aVar = APlusFullScreenVipPurchaseLayout.this.f18743b;
                if (aVar != null) {
                    aVar.e();
                }
            }
        });
        ImageView vip_close_imageview = (ImageView) a(R$id.vip_close_imageview);
        s.h(vip_close_imageview, "vip_close_imageview");
        y.d(vip_close_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$6
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
                APlusFullScreenVipPurchaseLayout.a aVar;
                aVar = APlusFullScreenVipPurchaseLayout.this.f18743b;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
        TextView more_sku_txt = (TextView) a(R$id.more_sku_txt);
        s.h(more_sku_txt, "more_sku_txt");
        y.d(more_sku_txt, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$7
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
                APlusFullScreenVipPurchaseLayout.a aVar;
                VipType vipType;
                APlusFullScreenVipPurchaseLayout.this.f18749h = true;
                map = APlusFullScreenVipPurchaseLayout.this.f18744c;
                if (map != null) {
                    vipType = APlusFullScreenVipPurchaseLayout.this.f18746e;
                    vipOptionsModel = (VipOptionsModel) map.get(vipType);
                } else {
                    vipOptionsModel = null;
                }
                APlusFullScreenVipPurchaseLayout.this.B(vipOptionsModel);
                aVar = APlusFullScreenVipPurchaseLayout.this.f18743b;
                if (aVar != null) {
                    aVar.d();
                }
            }
        });
        ImageView payment_terms_img = (ImageView) a(R$id.payment_terms_img);
        s.h(payment_terms_img, "payment_terms_img");
        y.d(payment_terms_img, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$bindClickEvent$8
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
                ((ImageView) APlusFullScreenVipPurchaseLayout.this.a(R$id.payment_terms_img)).setSelected(!((ImageView) APlusFullScreenVipPurchaseLayout.this.a(r0)).isSelected());
            }
        });
    }

    public final void q(String str) {
        LinkDictTipsModel billingVipTips;
        SpannableStringBuilder c4;
        Set<Map.Entry<String, String>> entrySet;
        ImageView imageView = (ImageView) a(R$id.payment_terms_img);
        VipType vipType = this.f18746e;
        VipType vipType2 = VipType.NORMAL;
        imageView.setImageResource(vipType == vipType2 ? R$drawable.selector_payment_terms_btn_gray : R$drawable.selector_payment_terms_btn);
        int a10 = this.f18746e == vipType2 ? -8618884 : h.a(-1, 0.5f);
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
            c4 = q1.d.f53006a.c(billingVipTips.getContent(), arrayList, (r18 & 4) != 0 ? null : Integer.valueOf(this.f18746e == VipType.NORMAL ? -15066598 : -1), (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : true, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
            int i12 = R$id.payment_terms_txt;
            ((TextView) a(i12)).setTextColor(a10);
            ((TextView) a(i12)).setText(c4);
            ((TextView) a(i12)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        int i13 = R$id.protocol_textview;
        ((TextView) a(i13)).setTextColor(a10);
        ((TextView) a(i13)).setText(str);
    }

    public final void r(boolean z10, String str) {
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

    public final void s(VipType vipType) {
        int i10 = b.f18752a[vipType.ordinal()];
        if (i10 == 1) {
            ((ImageView) a(R$id.rainbow_vip_bg_view)).setVisibility(8);
            ((ConstraintLayout) a(R$id.vip_purchase_layout)).setBackgroundColor(-16777216);
            ((TextView) a(R$id.vip_purchase_text)).setTextColor(-15066598);
            ((TextView) a(R$id.purchase_type_text)).setTextColor(-1);
            ImageView purchase_type_image = (ImageView) a(R$id.purchase_type_image);
            s.h(purchase_type_image, "purchase_type_image");
            o.b(purchase_type_image, -1);
            ImageView vip_close_imageview = (ImageView) a(R$id.vip_close_imageview);
            s.h(vip_close_imageview, "vip_close_imageview");
            o.b(vip_close_imageview, -1);
            int i11 = R$id.function_title;
            ((TextView) a(i11)).setTextColor(h.a(-1, 0.6f));
            TextView textView = (TextView) a(i11);
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
            String string = getContext().getString(R$string.contains_function, getContext().getString(R$string.diamond_vip));
            s.h(string, "context.getString(\n     …ip)\n                    )");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            s.h(format, "format(format, *args)");
            textView.setText(format);
            ((CardView) a(R$id.root_btn_rl)).setCardBackgroundColor(-15066598);
            ((FKLottieAnimationView) a(R$id.purchase_lottie)).setLottieAnimation("lottie/purchase/anim_svip_btn.json");
            ((VipDiscountTimeLayout) a(R$id.activity_count_down_layout)).j(-5947);
        } else if (i10 != 2) {
            ((ImageView) a(R$id.rainbow_vip_bg_view)).setVisibility(8);
            ((ConstraintLayout) a(R$id.vip_purchase_layout)).setBackgroundColor(-1);
            ((TextView) a(R$id.vip_purchase_text)).setTextColor(-1);
            ((TextView) a(R$id.purchase_type_text)).setTextColor(-15066598);
            ImageView purchase_type_image2 = (ImageView) a(R$id.purchase_type_image);
            s.h(purchase_type_image2, "purchase_type_image");
            o.b(purchase_type_image2, -15066598);
            ImageView vip_close_imageview2 = (ImageView) a(R$id.vip_close_imageview);
            s.h(vip_close_imageview2, "vip_close_imageview");
            o.b(vip_close_imageview2, -16777216);
            int i12 = R$id.function_title;
            ((TextView) a(i12)).setTextColor(-5658199);
            TextView textView2 = (TextView) a(i12);
            kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f51038a;
            String string2 = getContext().getString(R$string.contains_function, getContext().getString(R$string.a_plus));
            s.h(string2, "context.getString(\n     …us)\n                    )");
            String format2 = String.format(string2, Arrays.copyOf(new Object[0], 0));
            s.h(format2, "format(format, *args)");
            textView2.setText(format2);
            ((CardView) a(R$id.root_btn_rl)).setCardBackgroundColor(-1);
            ((FKLottieAnimationView) a(R$id.purchase_lottie)).setLottieAnimation("lottie/purchase/anim_vip_btn.json");
            ((VipDiscountTimeLayout) a(R$id.activity_count_down_layout)).j(-1557);
        } else {
            ((ImageView) a(R$id.rainbow_vip_bg_view)).setVisibility(0);
            ((ConstraintLayout) a(R$id.vip_purchase_layout)).setBackgroundColor(-16777216);
            ((TextView) a(R$id.vip_purchase_text)).setTextColor(-1);
            ((TextView) a(R$id.purchase_type_text)).setTextColor(-1);
            ImageView purchase_type_image3 = (ImageView) a(R$id.purchase_type_image);
            s.h(purchase_type_image3, "purchase_type_image");
            o.b(purchase_type_image3, -1);
            ImageView vip_close_imageview3 = (ImageView) a(R$id.vip_close_imageview);
            s.h(vip_close_imageview3, "vip_close_imageview");
            o.b(vip_close_imageview3, -1);
            int i13 = R$id.function_title;
            ((TextView) a(i13)).setTextColor(h.a(-1, 0.6f));
            TextView textView3 = (TextView) a(i13);
            kotlin.jvm.internal.y yVar3 = kotlin.jvm.internal.y.f51038a;
            String string3 = getContext().getString(R$string.contains_function, getContext().getString(R$string.rainbow_vip));
            s.h(string3, "context.getString(\n     …ip)\n                    )");
            String format3 = String.format(string3, Arrays.copyOf(new Object[0], 0));
            s.h(format3, "format(format, *args)");
            textView3.setText(format3);
            ((CardView) a(R$id.root_btn_rl)).setCardBackgroundColor(-15066598);
            ((FKLottieAnimationView) a(R$id.purchase_lottie)).setLottieAnimation("lottie/purchase/anim_ssvip_btn.json");
            ((VipDiscountTimeLayout) a(R$id.activity_count_down_layout)).j(-5947);
        }
        ((FKLottieAnimationView) a(R$id.purchase_lottie)).L();
    }

    public final void setVipPurchaseClickListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f18743b = listener;
    }

    public final void t() {
        Map<VipType, VipOptionsModel> map = this.f18744c;
        VipOptionsModel vipOptionsModel = map != null ? map.get(this.f18746e) : null;
        y(vipOptionsModel != null ? vipOptionsModel.getVipClientUiInfo() : null);
        ((VipDiscountTimeLayout) a(R$id.activity_count_down_layout)).h(vipOptionsModel != null ? Long.valueOf(vipOptionsModel.getUserStrategyEndTime()) : null);
        B(vipOptionsModel);
        s(this.f18746e);
        x();
        w();
    }

    public final void u(@NotNull Map<VipType, VipOptionsModel> optionsMap, @NotNull VipType defaultVipType, @NotNull VipPurchaseEntranceType entranceType, boolean z10) {
        s.i(optionsMap, "optionsMap");
        s.i(defaultVipType, "defaultVipType");
        s.i(entranceType, "entranceType");
        this.f18744c = optionsMap;
        this.f18745d = entranceType;
        this.f18746e = defaultVipType;
        this.f18747f = PayType.AliPay;
        this.f18748g = null;
        this.f18749h = false;
        ((TextView) a(R$id.purchase_type_text)).setText(getContext().getString(R$string.aliPay));
        ((VipPurchaseTabLayout) a(R$id.vip_purchase_tab_layout)).f(CollectionsKt___CollectionsKt.x0(optionsMap.h()), defaultVipType);
        t();
        VipOptionsModel vipOptionsModel = optionsMap.get(defaultVipType);
        r(z10, vipOptionsModel != null ? vipOptionsModel.getSuperLikePurchaseDescription() : null);
        if (VasBuyHelper.f18742a.a()) {
            int i10 = R$id.payment_terms_img;
            ((ImageView) a(i10)).setVisibility(0);
            ((ImageView) a(i10)).setSelected(false);
            return;
        }
        ((ImageView) a(R$id.payment_terms_img)).setVisibility(4);
    }

    public final void v() {
        z.a(this, R$layout.layout_full_vip_purchase, true);
        ((TextView) a(R$id.purchase_type_text)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.vip_purchase_text)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.to_superlike_purchase)).getPaint().setFakeBoldText(true);
        p();
        int i10 = R$id.function_rv;
        ((RecyclerView) a(i10)).setLayoutManager(new GridLayoutManager(getContext(), getAdapter().v()));
        ((RecyclerView) a(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(z0.h.c(this, 3.0f), 0, z0.h.c(this, 3.0f), z0.h.c(this, 8.0f), 0, 0, 48, null));
        ((RecyclerView) a(i10)).setAdapter(getAdapter());
    }

    public final void w() {
        com.cupidapp.live.vip.layout.c cVar = com.cupidapp.live.vip.layout.c.f18809a;
        Context context = getContext();
        s.h(context, "context");
        List<VipFunctionUiModel> g3 = cVar.g(context, this.f18746e);
        getAdapter().j().clear();
        getAdapter().e(g3);
        getAdapter().notifyDataSetChanged();
    }

    public final void x() {
        if (u0.a.f53817a.d()) {
            com.cupidapp.live.vip.layout.c cVar = com.cupidapp.live.vip.layout.c.f18809a;
            Context context = getContext();
            s.h(context, "context");
            List<VipFunctionUiModel> a10 = cVar.a(context, this.f18746e);
            int i10 = R$id.new_function_layout;
            ((NewFunctionOfVipLayout) a(i10)).setVisibility(0);
            ((NewFunctionOfVipLayout) a(i10)).f(a10, this.f18746e, new Function1<VipFunctionUiModel, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$renderNewFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(VipFunctionUiModel vipFunctionUiModel) {
                    invoke2(vipFunctionUiModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull VipFunctionUiModel it) {
                    s.i(it, "it");
                    APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = APlusFullScreenVipPurchaseLayout.this;
                    int i11 = R$id.function_intro_layout;
                    VipFunctionIntroLayout vipFunctionIntroLayout = (VipFunctionIntroLayout) aPlusFullScreenVipPurchaseLayout.a(i11);
                    final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout2 = APlusFullScreenVipPurchaseLayout.this;
                    vipFunctionIntroLayout.f(it, new Function0<p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$renderNewFunction$1.1
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
                            ((VipFunctionIntroLayout) APlusFullScreenVipPurchaseLayout.this.a(R$id.function_intro_layout)).setVisibility(8);
                        }
                    });
                    ((VipFunctionIntroLayout) APlusFullScreenVipPurchaseLayout.this.a(i11)).setVisibility(0);
                }
            });
            return;
        }
        ((NewFunctionOfVipLayout) a(R$id.new_function_layout)).setVisibility(8);
    }

    public final void y(VipClientUiInfoModel vipClientUiInfoModel) {
        ((VipPurchaseGuideIntroLayout) a(R$id.purchase_guide_layout_no_loop)).setVisibility(8);
        int i10 = R$id.purchase_guide_layout;
        ((VipPurchaseGuideLayout) a(i10)).setVisibility(0);
        ((VipPurchaseGuideLayout) a(i10)).v(this.f18746e, this.f18745d);
    }

    public final void z(String str) {
        if (str == null || str.length() == 0) {
            ((TextView) a(R$id.purchase_tag_txt)).setVisibility(8);
        } else {
            int i10 = R$id.purchase_tag_txt;
            ((TextView) a(i10)).setText(str);
            ((TextView) a(i10)).setVisibility(0);
        }
        if (this.f18746e == VipType.NORMAL) {
            int i11 = R$id.purchase_tag_txt;
            ((TextView) a(i11)).setBackgroundResource(R$drawable.vip_tag_bounds);
            ((TextView) a(i11)).setTextColor(-15066598);
        } else {
            int i12 = R$id.purchase_tag_txt;
            ((TextView) a(i12)).setBackgroundResource(R$drawable.svip_tag_bounds);
            ((TextView) a(i12)).setTextColor(-1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APlusFullScreenVipPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18751j = new LinkedHashMap();
        this.f18745d = VipPurchaseEntranceType.Filter;
        this.f18746e = VipType.SUPER;
        this.f18747f = PayType.AliPay;
        this.f18750i = kotlin.c.b(new Function0<VipFunctionAdapter>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipFunctionAdapter invoke() {
                VipFunctionAdapter vipFunctionAdapter = new VipFunctionAdapter();
                final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = APlusFullScreenVipPurchaseLayout.this;
                vipFunctionAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2$1$1
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
                        if (obj instanceof VipFunctionUiModel) {
                            APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout2 = APlusFullScreenVipPurchaseLayout.this;
                            int i10 = R$id.function_intro_layout;
                            final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout3 = APlusFullScreenVipPurchaseLayout.this;
                            ((VipFunctionIntroLayout) aPlusFullScreenVipPurchaseLayout2.a(i10)).f((VipFunctionUiModel) obj, new Function0<p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2$1$1.1
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
                                    ((VipFunctionIntroLayout) APlusFullScreenVipPurchaseLayout.this.a(R$id.function_intro_layout)).setVisibility(8);
                                }
                            });
                            ((VipFunctionIntroLayout) APlusFullScreenVipPurchaseLayout.this.a(i10)).setVisibility(0);
                        }
                    }
                });
                return vipFunctionAdapter;
            }
        });
        v();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APlusFullScreenVipPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18751j = new LinkedHashMap();
        this.f18745d = VipPurchaseEntranceType.Filter;
        this.f18746e = VipType.SUPER;
        this.f18747f = PayType.AliPay;
        this.f18750i = kotlin.c.b(new Function0<VipFunctionAdapter>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipFunctionAdapter invoke() {
                VipFunctionAdapter vipFunctionAdapter = new VipFunctionAdapter();
                final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout = APlusFullScreenVipPurchaseLayout.this;
                vipFunctionAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2$1$1
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
                        if (obj instanceof VipFunctionUiModel) {
                            APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout2 = APlusFullScreenVipPurchaseLayout.this;
                            int i102 = R$id.function_intro_layout;
                            final APlusFullScreenVipPurchaseLayout aPlusFullScreenVipPurchaseLayout3 = APlusFullScreenVipPurchaseLayout.this;
                            ((VipFunctionIntroLayout) aPlusFullScreenVipPurchaseLayout2.a(i102)).f((VipFunctionUiModel) obj, new Function0<p>() { // from class: com.cupidapp.live.vip.layout.APlusFullScreenVipPurchaseLayout$adapter$2$1$1.1
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
                                    ((VipFunctionIntroLayout) APlusFullScreenVipPurchaseLayout.this.a(R$id.function_intro_layout)).setVisibility(8);
                                }
                            });
                            ((VipFunctionIntroLayout) APlusFullScreenVipPurchaseLayout.this.a(i102)).setVisibility(0);
                        }
                    }
                });
                return vipFunctionAdapter;
            }
        });
        v();
    }
}
