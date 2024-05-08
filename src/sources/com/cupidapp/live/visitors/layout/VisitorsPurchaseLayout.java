package com.cupidapp.live.visitors.layout;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.decoration.AddExtraSpacingDecoration;
import com.cupidapp.live.vip.helper.VasBuyHelper;
import com.cupidapp.live.vip.layout.PurchaseTypeLayout;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.visitors.adapter.VisitorsPurchaseRecyclerAdapter;
import com.cupidapp.live.visitors.model.VisitorPurchaseUIResult;
import com.cupidapp.live.visitors.model.VisitorsPurchasePriceModel;
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
import p1.g;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: VisitorsPurchaseLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsPurchaseLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public PayType f18951b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.visitors.layout.a f18952c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public List<VisitorsPurchasePriceModel> f18953d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18954e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public VisitorsPurchasePriceModel f18955f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public VisitorPurchaseUIResult f18956g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18957h;

    /* compiled from: VisitorsPurchaseLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f18959c;

        public a(Map.Entry<String, String> entry) {
            this.f18959c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, VisitorsPurchaseLayout.this.getContext(), this.f18959c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsPurchaseLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18957h = new LinkedHashMap();
        this.f18951b = PayType.AliPay;
        this.f18953d = new ArrayList();
        this.f18954e = c.b(new Function0<VisitorsPurchaseRecyclerAdapter>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$visitorsPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorsPurchaseRecyclerAdapter invoke() {
                VisitorsPurchaseRecyclerAdapter visitorsPurchaseRecyclerAdapter = new VisitorsPurchaseRecyclerAdapter();
                final VisitorsPurchaseLayout visitorsPurchaseLayout = VisitorsPurchaseLayout.this;
                visitorsPurchaseRecyclerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$visitorsPurchasePriceAdapter$2$1$1
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
                        if (obj instanceof VisitorsPurchasePriceModel) {
                            VisitorsPurchaseLayout.this.l((VisitorsPurchasePriceModel) obj);
                        }
                    }
                });
                return visitorsPurchaseRecyclerAdapter;
            }
        });
        k();
    }

    private final VisitorsPurchaseRecyclerAdapter getVisitorsPurchasePriceAdapter() {
        return (VisitorsPurchaseRecyclerAdapter) this.f18954e.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18957h;
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

    public final void h() {
        ImageView closeImageView = (ImageView) a(R$id.closeImageView);
        s.h(closeImageView, "closeImageView");
        y.d(closeImageView, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$bindClickEvent$1
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
                a aVar;
                aVar = VisitorsPurchaseLayout.this.f18952c;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
        TextView visitor_pay_option = (TextView) a(R$id.visitor_pay_option);
        s.h(visitor_pay_option, "visitor_pay_option");
        y.d(visitor_pay_option, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$bindClickEvent$2
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
                Context context = VisitorsPurchaseLayout.this.getContext();
                s.h(context, "context");
                PurchaseTypeLayout purchaseTypeLayout = new PurchaseTypeLayout(context);
                final VisitorsPurchaseLayout visitorsPurchaseLayout = VisitorsPurchaseLayout.this;
                purchaseTypeLayout.c(new Function2<String, PayType, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$bindClickEvent$2.1
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
                        VisitorsPurchaseLayout.this.f18951b = type;
                        ((TextView) VisitorsPurchaseLayout.this.a(R$id.visitor_pay_option)).setText(typeText);
                        VisitorsPurchaseLayout.this.m();
                    }
                });
            }
        });
        FKUniversalButton purchaseConfirmBtn = (FKUniversalButton) a(R$id.purchaseConfirmBtn);
        s.h(purchaseConfirmBtn, "purchaseConfirmBtn");
        y.d(purchaseConfirmBtn, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$bindClickEvent$3
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
                List list;
                Object obj;
                list = VisitorsPurchaseLayout.this.f18953d;
                Iterator<E> iterator2 = list.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = iterator2.next();
                        if (((VisitorsPurchasePriceModel) obj).isSelected()) {
                            break;
                        }
                    }
                }
                final VisitorsPurchasePriceModel visitorsPurchasePriceModel = (VisitorsPurchasePriceModel) obj;
                if (visitorsPurchasePriceModel != null) {
                    final VisitorsPurchaseLayout visitorsPurchaseLayout = VisitorsPurchaseLayout.this;
                    VasBuyHelper vasBuyHelper = VasBuyHelper.f18742a;
                    Context context = visitorsPurchaseLayout.getContext();
                    s.h(context, "context");
                    VasBuyHelper.c(vasBuyHelper, context, false, new Function0<p>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$bindClickEvent$3$2$1
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
                            a aVar;
                            PayType payType;
                            aVar = VisitorsPurchaseLayout.this.f18952c;
                            if (aVar != null) {
                                payType = VisitorsPurchaseLayout.this.f18951b;
                                aVar.a(payType, visitorsPurchasePriceModel);
                            }
                        }
                    }, 2, null);
                }
            }
        });
    }

    public final void i(VisitorsPurchasePriceModel visitorsPurchasePriceModel) {
        boolean z10;
        Iterator<Object> iterator2 = getVisitorsPurchasePriceAdapter().j().iterator2();
        int i10 = 0;
        while (true) {
            z10 = true;
            if (!iterator2.hasNext()) {
                break;
            }
            Object next = iterator2.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (next instanceof VisitorsPurchasePriceModel) {
                VisitorsPurchasePriceModel visitorsPurchasePriceModel2 = (VisitorsPurchasePriceModel) next;
                if (s.d(visitorsPurchasePriceModel2.getId(), visitorsPurchasePriceModel != null ? visitorsPurchasePriceModel.getId() : null) && s.d(visitorsPurchasePriceModel2.getSkuCode(), visitorsPurchasePriceModel.getSkuCode())) {
                    visitorsPurchasePriceModel2.setSelected(true);
                    this.f18955f = visitorsPurchasePriceModel2;
                } else {
                    visitorsPurchasePriceModel2.setSelected(false);
                }
            }
            i10 = i11;
        }
        String description = visitorsPurchasePriceModel != null ? visitorsPurchasePriceModel.getDescription() : null;
        if (description != null && description.length() != 0) {
            z10 = false;
        }
        if (z10) {
            ((TextView) a(R$id.visitor_option_tip)).setVisibility(4);
            return;
        }
        int i12 = R$id.visitor_option_tip;
        ((TextView) a(i12)).setVisibility(0);
        ((TextView) a(i12)).setText(visitorsPurchasePriceModel != null ? visitorsPurchasePriceModel.getDescription() : null);
    }

    public final void j() {
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
                arrayList2.add(i10, new a(entry2));
                i10 = i11;
            }
        }
        c4 = q1.d.f53006a.c(addServicesTips.getContent(), arrayList, (r18 & 4) != 0 ? null : -1, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
        int i12 = R$id.purchaseInstructions;
        ((TextView) a(i12)).setText(c4);
        ((TextView) a(i12)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void k() {
        z.a(this, R$layout.layout_visitors_vip_purchase, true);
        j();
        h();
        RecyclerView initView$lambda$0 = (RecyclerView) a(R$id.visitorsVipRecyclerView);
        s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.addItemDecoration(new AddExtraSpacingDecoration(h.c(initView$lambda$0, 4.0f), 0, h.c(initView$lambda$0, 4.0f), 0, h.c(initView$lambda$0, 12.0f)));
        initView$lambda$0.setAdapter(getVisitorsPurchasePriceAdapter());
        TextView visitor_pay_option = (TextView) a(R$id.visitor_pay_option);
        s.h(visitor_pay_option, "visitor_pay_option");
        u.a(visitor_pay_option);
    }

    public final void l(VisitorsPurchasePriceModel visitorsPurchasePriceModel) {
        i(visitorsPurchasePriceModel);
        getVisitorsPurchasePriceAdapter().notifyDataSetChanged();
    }

    public final void m() {
        List<VisitorsPurchasePriceModel> alipayOptions;
        int i10;
        int i11;
        List<VisitorsPurchasePriceModel> wechatOptions;
        this.f18953d.clear();
        if (this.f18951b == PayType.WeChatPay) {
            VisitorPurchaseUIResult visitorPurchaseUIResult = this.f18956g;
            if (visitorPurchaseUIResult != null && (wechatOptions = visitorPurchaseUIResult.getWechatOptions()) != null) {
                this.f18953d.addAll(wechatOptions);
            }
        } else {
            VisitorPurchaseUIResult visitorPurchaseUIResult2 = this.f18956g;
            if (visitorPurchaseUIResult2 != null && (alipayOptions = visitorPurchaseUIResult2.getAlipayOptions()) != null) {
                this.f18953d.addAll(alipayOptions);
            }
        }
        getVisitorsPurchasePriceAdapter().j().clear();
        getVisitorsPurchasePriceAdapter().e(this.f18953d);
        if (this.f18955f == null) {
            i10 = 0;
        } else {
            Iterator<VisitorsPurchasePriceModel> iterator2 = this.f18953d.iterator2();
            i10 = 0;
            while (true) {
                i11 = -1;
                if (!iterator2.hasNext()) {
                    i10 = -1;
                    break;
                }
                String skuCode = iterator2.next().getSkuCode();
                VisitorsPurchasePriceModel visitorsPurchasePriceModel = this.f18955f;
                if (s.d(skuCode, visitorsPurchasePriceModel != null ? visitorsPurchasePriceModel.getSkuCode() : null)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                Iterator<VisitorsPurchasePriceModel> iterator22 = this.f18953d.iterator2();
                int i12 = 0;
                while (true) {
                    if (!iterator22.hasNext()) {
                        break;
                    }
                    VisitorsPurchasePriceModel next = iterator22.next();
                    VisitorsPurchasePriceModel visitorsPurchasePriceModel2 = this.f18955f;
                    if (visitorsPurchasePriceModel2 != null && next.getMonth() == visitorsPurchasePriceModel2.getMonth()) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                }
                i10 = i11;
            }
        }
        i((VisitorsPurchasePriceModel) CollectionsKt___CollectionsKt.W(this.f18953d, Math.max(i10, 0)));
        getVisitorsPurchasePriceAdapter().notifyDataSetChanged();
    }

    public final void setVisitorsPurchaseListener(@NotNull com.cupidapp.live.visitors.layout.a listener) {
        s.i(listener, "listener");
        this.f18952c = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18957h = new LinkedHashMap();
        this.f18951b = PayType.AliPay;
        this.f18953d = new ArrayList();
        this.f18954e = c.b(new Function0<VisitorsPurchaseRecyclerAdapter>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$visitorsPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorsPurchaseRecyclerAdapter invoke() {
                VisitorsPurchaseRecyclerAdapter visitorsPurchaseRecyclerAdapter = new VisitorsPurchaseRecyclerAdapter();
                final VisitorsPurchaseLayout visitorsPurchaseLayout = VisitorsPurchaseLayout.this;
                visitorsPurchaseRecyclerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$visitorsPurchasePriceAdapter$2$1$1
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
                        if (obj instanceof VisitorsPurchasePriceModel) {
                            VisitorsPurchaseLayout.this.l((VisitorsPurchasePriceModel) obj);
                        }
                    }
                });
                return visitorsPurchaseRecyclerAdapter;
            }
        });
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsPurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18957h = new LinkedHashMap();
        this.f18951b = PayType.AliPay;
        this.f18953d = new ArrayList();
        this.f18954e = c.b(new Function0<VisitorsPurchaseRecyclerAdapter>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$visitorsPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorsPurchaseRecyclerAdapter invoke() {
                VisitorsPurchaseRecyclerAdapter visitorsPurchaseRecyclerAdapter = new VisitorsPurchaseRecyclerAdapter();
                final VisitorsPurchaseLayout visitorsPurchaseLayout = VisitorsPurchaseLayout.this;
                visitorsPurchaseRecyclerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.layout.VisitorsPurchaseLayout$visitorsPurchasePriceAdapter$2$1$1
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
                        if (obj instanceof VisitorsPurchasePriceModel) {
                            VisitorsPurchaseLayout.this.l((VisitorsPurchasePriceModel) obj);
                        }
                    }
                });
                return visitorsPurchaseRecyclerAdapter;
            }
        });
        k();
    }
}
