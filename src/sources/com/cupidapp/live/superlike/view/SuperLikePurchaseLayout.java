package com.cupidapp.live.superlike.view;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.decoration.AddExtraSpacingDecoration;
import com.cupidapp.live.superlike.holder.SuperLikePurchaseAdapter;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.superlike.view.SuperLikePurchaseLayout;
import com.cupidapp.live.vip.layout.PurchaseTypeLayout;
import com.cupidapp.live.vip.model.PayType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: SuperLikePurchaseLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikePurchaseLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f18638d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public PayType f18639e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public a f18640f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public AlertDialog f18641g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18642h;

    /* compiled from: SuperLikePurchaseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(@NotNull SuperLikePurchaseSkuModel superLikePurchaseSkuModel, @NotNull PayType payType);

        void b();
    }

    /* compiled from: SuperLikePurchaseLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f18644c;

        public b(Map.Entry<String, String> entry) {
            this.f18644c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, SuperLikePurchaseLayout.this.getContext(), this.f18644c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikePurchaseLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18642h = new LinkedHashMap();
        this.f18638d = kotlin.c.b(new Function0<SuperLikePurchaseAdapter>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$superLikePurchaseAdater$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperLikePurchaseAdapter invoke() {
                SuperLikePurchaseAdapter superLikePurchaseAdapter = new SuperLikePurchaseAdapter();
                final SuperLikePurchaseLayout superLikePurchaseLayout = SuperLikePurchaseLayout.this;
                superLikePurchaseAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$superLikePurchaseAdater$2$1$1
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
                            SuperLikePurchaseLayout.this.u((SuperLikePurchaseSkuModel) obj);
                        }
                    }
                });
                return superLikePurchaseAdapter;
            }
        });
        this.f18639e = PayType.AliPay;
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuperLikePurchaseAdapter getSuperLikePurchaseAdater() {
        return (SuperLikePurchaseAdapter) this.f18638d.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f18642h;
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

    public final void l() {
        TextView super_like_pay_option = (TextView) e(R$id.super_like_pay_option);
        s.h(super_like_pay_option, "super_like_pay_option");
        y.d(super_like_pay_option, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$bindClickEvent$1
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
                Context context = SuperLikePurchaseLayout.this.getContext();
                s.h(context, "context");
                PurchaseTypeLayout purchaseTypeLayout = new PurchaseTypeLayout(context);
                final SuperLikePurchaseLayout superLikePurchaseLayout = SuperLikePurchaseLayout.this;
                purchaseTypeLayout.c(new Function2<String, PayType, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$bindClickEvent$1.1
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
                        ((TextView) SuperLikePurchaseLayout.this.e(R$id.super_like_pay_option)).setText(typeText);
                        SuperLikePurchaseLayout.this.f18639e = type;
                    }
                });
            }
        });
        FKUniversalButton buy_it_now_btn = (FKUniversalButton) e(R$id.buy_it_now_btn);
        s.h(buy_it_now_btn, "buy_it_now_btn");
        y.d(buy_it_now_btn, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
            
                r4 = r3.this$0.f18640f;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r4) {
                /*
                    r3 = this;
                    com.cupidapp.live.superlike.view.SuperLikePurchaseLayout r4 = com.cupidapp.live.superlike.view.SuperLikePurchaseLayout.this
                    com.cupidapp.live.superlike.holder.SuperLikePurchaseAdapter r4 = com.cupidapp.live.superlike.view.SuperLikePurchaseLayout.h(r4)
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
                    if (r0 == 0) goto L53
                    com.cupidapp.live.superlike.view.SuperLikePurchaseLayout r4 = com.cupidapp.live.superlike.view.SuperLikePurchaseLayout.this
                    com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$a r4 = com.cupidapp.live.superlike.view.SuperLikePurchaseLayout.i(r4)
                    if (r4 == 0) goto L53
                    com.cupidapp.live.superlike.view.SuperLikePurchaseLayout r1 = com.cupidapp.live.superlike.view.SuperLikePurchaseLayout.this
                    com.cupidapp.live.vip.model.PayType r1 = com.cupidapp.live.superlike.view.SuperLikePurchaseLayout.g(r1)
                    r4.a(r0, r1)
                L53:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$bindClickEvent$2.invoke2(android.view.View):void");
            }
        });
        ImageView super_like_purchase_close_img = (ImageView) e(R$id.super_like_purchase_close_img);
        s.h(super_like_purchase_close_img, "super_like_purchase_close_img");
        y.d(super_like_purchase_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$bindClickEvent$3
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
                alertDialog = SuperLikePurchaseLayout.this.f18641g;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void m(SuperLikePurchaseSkuModel superLikePurchaseSkuModel) {
        for (Object obj : getSuperLikePurchaseAdater().j()) {
            if (obj instanceof SuperLikePurchaseSkuModel) {
                ((SuperLikePurchaseSkuModel) obj).setChecked(false);
            }
        }
        if (superLikePurchaseSkuModel != null) {
            superLikePurchaseSkuModel.setChecked(true);
        }
        r(superLikePurchaseSkuModel != null ? superLikePurchaseSkuModel.getDescription() : null);
    }

    public final void o(SuperLikePurchaseModel superLikePurchaseModel) {
        int i10 = R$id.super_like_go_supervip;
        boolean z10 = true;
        ((TextView) e(i10)).getPaint().setFakeBoldText(true);
        com.cupidapp.live.profile.logic.c cVar = com.cupidapp.live.profile.logic.c.f17839a;
        if (cVar.d()) {
            ((LinearLayout) e(R$id.buy_super_vip_ll)).setVisibility(8);
        } else if (cVar.e()) {
            ((LinearLayout) e(R$id.buy_super_vip_ll)).setVisibility(0);
            ((TextView) e(i10)).setText(R$string.update_to_super_vip);
            String vipFreeUsageCountDescription = superLikePurchaseModel.getVipFreeUsageCountDescription();
            if (vipFreeUsageCountDescription != null && vipFreeUsageCountDescription.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                int i11 = R$id.super_like_count;
                ((TextView) e(i11)).setVisibility(0);
                ((TextView) e(i11)).setText(superLikePurchaseModel.getVipFreeUsageCountDescription());
            }
        } else {
            ((LinearLayout) e(R$id.buy_super_vip_ll)).setVisibility(0);
            ((TextView) e(i10)).setText(R$string.buy_super_vip);
            int i12 = R$id.super_like_count;
            ((TextView) e(i12)).setText(superLikePurchaseModel.getVipFreeUsageCountDescription());
            String vipFreeUsageCountDescription2 = superLikePurchaseModel.getVipFreeUsageCountDescription();
            if (vipFreeUsageCountDescription2 != null && vipFreeUsageCountDescription2.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                ((TextView) e(i12)).setVisibility(0);
                ((TextView) e(i12)).setText(superLikePurchaseModel.getVipFreeUsageCountDescription());
            }
        }
        LinearLayout buy_super_vip_ll = (LinearLayout) e(R$id.buy_super_vip_ll);
        s.h(buy_super_vip_ll, "buy_super_vip_ll");
        y.d(buy_super_vip_ll, new Function1<View, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$configBuySuperVipData$1
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
                SuperLikePurchaseLayout.a aVar;
                AlertDialog alertDialog;
                aVar = SuperLikePurchaseLayout.this.f18640f;
                if (aVar != null) {
                    aVar.b();
                }
                alertDialog = SuperLikePurchaseLayout.this.f18641g;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void p(SuperLikePurchaseModel superLikePurchaseModel) {
        SuperLikePurchaseSkuModel superLikePurchaseSkuModel;
        List<SuperLikePurchaseSkuModel> products = superLikePurchaseModel.getProducts();
        if (products == null || products.isEmpty()) {
            return;
        }
        this.f18639e = PayType.AliPay;
        ((TextView) e(R$id.super_like_pay_option)).setText(getContext().getString(R$string.aliPay));
        ((RecyclerView) e(R$id.super_like_purchase_recycler)).setAdapter(getSuperLikePurchaseAdater());
        Iterator<SuperLikePurchaseSkuModel> iterator2 = superLikePurchaseModel.getProducts().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                superLikePurchaseSkuModel = null;
                break;
            } else {
                superLikePurchaseSkuModel = iterator2.next();
                if (superLikePurchaseSkuModel.getChecked()) {
                    break;
                }
            }
        }
        SuperLikePurchaseSkuModel superLikePurchaseSkuModel2 = superLikePurchaseSkuModel;
        if (superLikePurchaseSkuModel2 == null) {
            m((SuperLikePurchaseSkuModel) CollectionsKt___CollectionsKt.V(superLikePurchaseModel.getProducts()));
        } else {
            m(superLikePurchaseSkuModel2);
        }
        getSuperLikePurchaseAdater().j().clear();
        getSuperLikePurchaseAdater().j().addAll(superLikePurchaseModel.getProducts());
        getSuperLikePurchaseAdater().notifyDataSetChanged();
        o(superLikePurchaseModel);
    }

    public final void q(LinkDictTipsModel linkDictTipsModel) {
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
            c4 = q1.d.f53006a.c(linkDictTipsModel.getContent(), arrayList, (r18 & 4) != 0 ? null : -1, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
            int i12 = R$id.purchaseProtocol;
            ((TextView) e(i12)).setText(c4);
            ((TextView) e(i12)).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public final void r(String str) {
        if (str == null || str.length() == 0) {
            ((TextView) e(R$id.super_like_purchase_option_tip)).setVisibility(4);
            return;
        }
        int i10 = R$id.super_like_purchase_option_tip;
        ((TextView) e(i10)).setVisibility(0);
        ((TextView) e(i10)).setText(str);
    }

    public final void s() {
        AlertDialog alertDialog = this.f18641g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void setVipPurchaseClickListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f18640f = listener;
    }

    public final void t() {
        z.a(this, R$layout.layout_super_like_purchase, true);
        ((TextView) e(R$id.super_like_pay_option)).getPaint().setFakeBoldText(true);
        RecyclerView initView$lambda$0 = (RecyclerView) e(R$id.super_like_purchase_recycler);
        initView$lambda$0.setLayoutManager(new LinearLayoutManager(initView$lambda$0.getContext(), 0, false));
        s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.addItemDecoration(new AddExtraSpacingDecoration(z0.h.c(initView$lambda$0, 4.0f), 0, z0.h.c(initView$lambda$0, 4.0f), 0, z0.h.c(initView$lambda$0, 12.0f)));
        ConstantsResult q10 = p1.g.f52734a.q();
        q(q10 != null ? q10.getSuperLikeTerms() : null);
        l();
    }

    public final void u(SuperLikePurchaseSkuModel superLikePurchaseSkuModel) {
        m(superLikePurchaseSkuModel);
        getSuperLikePurchaseAdater().notifyDataSetChanged();
    }

    @Nullable
    public final AlertDialog v(@NotNull SuperLikePurchaseModel model) {
        Window window;
        s.i(model, "model");
        p(model);
        if (this.f18641g == null) {
            this.f18641g = z0.b.f54812a.e(getContext()).setView(this).create();
        }
        AlertDialog alertDialog = this.f18641g;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog2 = this.f18641g;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        AlertDialog alertDialog3 = this.f18641g;
        if (alertDialog3 != null && (window = alertDialog3.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
        return this.f18641g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikePurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18642h = new LinkedHashMap();
        this.f18638d = kotlin.c.b(new Function0<SuperLikePurchaseAdapter>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$superLikePurchaseAdater$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperLikePurchaseAdapter invoke() {
                SuperLikePurchaseAdapter superLikePurchaseAdapter = new SuperLikePurchaseAdapter();
                final SuperLikePurchaseLayout superLikePurchaseLayout = SuperLikePurchaseLayout.this;
                superLikePurchaseAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$superLikePurchaseAdater$2$1$1
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
                            SuperLikePurchaseLayout.this.u((SuperLikePurchaseSkuModel) obj);
                        }
                    }
                });
                return superLikePurchaseAdapter;
            }
        });
        this.f18639e = PayType.AliPay;
        t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikePurchaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18642h = new LinkedHashMap();
        this.f18638d = kotlin.c.b(new Function0<SuperLikePurchaseAdapter>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$superLikePurchaseAdater$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperLikePurchaseAdapter invoke() {
                SuperLikePurchaseAdapter superLikePurchaseAdapter = new SuperLikePurchaseAdapter();
                final SuperLikePurchaseLayout superLikePurchaseLayout = SuperLikePurchaseLayout.this;
                superLikePurchaseAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.superlike.view.SuperLikePurchaseLayout$superLikePurchaseAdater$2$1$1
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
                            SuperLikePurchaseLayout.this.u((SuperLikePurchaseSkuModel) obj);
                        }
                    }
                });
                return superLikePurchaseAdapter;
            }
        });
        this.f18639e = PayType.AliPay;
        t();
    }
}
