package com.cupidapp.live.maskparty.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.maskparty.model.ItemCardPurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.layout.PurchaseTypeLayout;
import com.cupidapp.live.vip.model.PayType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: MaskPartyItemCardAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardPurchaseViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f16262f = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function2<? super SuperLikePurchaseSkuModel, ? super PayType, p> f16263c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f16264d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public PayType f16265e;

    /* compiled from: MaskPartyItemCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MaskPartyItemCardPurchaseViewHolder a(@NotNull ViewGroup parent, @Nullable Function2<? super SuperLikePurchaseSkuModel, ? super PayType, p> function2) {
            s.i(parent, "parent");
            MaskPartyItemCardPurchaseViewHolder maskPartyItemCardPurchaseViewHolder = new MaskPartyItemCardPurchaseViewHolder(z.b(parent, R$layout.view_holder_mask_party_item_card_purchase, false, 2, null));
            maskPartyItemCardPurchaseViewHolder.f16263c = function2;
            return maskPartyItemCardPurchaseViewHolder;
        }
    }

    /* compiled from: MaskPartyItemCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16266a;

        static {
            int[] iArr = new int[PayType.values().length];
            try {
                iArr[PayType.AliPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PayType.WeChatPay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PayType.AliPayHuaBei.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16266a = iArr;
        }
    }

    /* compiled from: MaskPartyItemCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f16268c;

        public c(Map.Entry<String, String> entry) {
            this.f16268c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, MaskPartyItemCardPurchaseViewHolder.this.itemView.getContext(), this.f16268c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardPurchaseViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16264d = kotlin.c.b(new Function0<MaskPartyItemCardPurchaseAdapter>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardPurchaseViewHolder$purchaseAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MaskPartyItemCardPurchaseAdapter invoke() {
                MaskPartyItemCardPurchaseAdapter maskPartyItemCardPurchaseAdapter = new MaskPartyItemCardPurchaseAdapter();
                final MaskPartyItemCardPurchaseViewHolder maskPartyItemCardPurchaseViewHolder = MaskPartyItemCardPurchaseViewHolder.this;
                maskPartyItemCardPurchaseAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardPurchaseViewHolder$purchaseAdapter$2$1$1
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
                            MaskPartyItemCardPurchaseViewHolder.this.x((SuperLikePurchaseSkuModel) obj);
                        }
                    }
                });
                return maskPartyItemCardPurchaseAdapter;
            }
        });
        this.f16265e = PayType.AliPay;
        ((TextView) itemView.findViewById(R$id.purchase_type_text)).getPaint().setFakeBoldText(true);
        int i10 = R$id.item_card_purchase_textview;
        ((TextView) itemView.findViewById(i10)).getPaint().setFakeBoldText(true);
        TextView textView = (TextView) itemView.findViewById(i10);
        s.h(textView, "itemView.item_card_purchase_textview");
        y.i(textView, (r18 & 1) != 0 ? 0.0f : h.c(this, 28.0f), kotlin.collections.s.m(-9603585, -4954625), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R$id.item_card_purchase_recyclerview);
        recyclerView.setAdapter(z());
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), 0, false));
        LinearLayout linearLayout = (LinearLayout) itemView.findViewById(R$id.purchase_type_layout);
        s.h(linearLayout, "itemView.purchase_type_layout");
        y.d(linearLayout, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardPurchaseViewHolder.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Context context = View.this.getContext();
                s.h(context, "itemView.context");
                PurchaseTypeLayout purchaseTypeLayout = new PurchaseTypeLayout(context);
                final MaskPartyItemCardPurchaseViewHolder maskPartyItemCardPurchaseViewHolder = this;
                final View view2 = View.this;
                purchaseTypeLayout.c(new Function2<String, PayType, p>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardPurchaseViewHolder.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        MaskPartyItemCardPurchaseViewHolder.this.f16265e = type;
                        ((TextView) view2.findViewById(R$id.purchase_type_text)).setText(typeText);
                    }
                });
            }
        });
        TextView textView2 = (TextView) itemView.findViewById(i10);
        s.h(textView2, "itemView.item_card_purchase_textview");
        y.d(textView2, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.adapter.MaskPartyItemCardPurchaseViewHolder.3
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
                Object obj;
                MaskPartyItemCardPurchaseViewHolder maskPartyItemCardPurchaseViewHolder;
                Function2 function2;
                List<Object> j10 = MaskPartyItemCardPurchaseViewHolder.this.z().j();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : j10) {
                    if (obj2 instanceof SuperLikePurchaseSkuModel) {
                        arrayList.add(obj2);
                    }
                }
                Iterator<E> iterator2 = arrayList.iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        obj = iterator2.next();
                        if (((SuperLikePurchaseSkuModel) obj).getChecked()) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                SuperLikePurchaseSkuModel superLikePurchaseSkuModel = (SuperLikePurchaseSkuModel) obj;
                if (superLikePurchaseSkuModel == null || (function2 = (maskPartyItemCardPurchaseViewHolder = MaskPartyItemCardPurchaseViewHolder.this).f16263c) == null) {
                    return;
                }
                function2.mo1743invoke(superLikePurchaseSkuModel, maskPartyItemCardPurchaseViewHolder.f16265e);
            }
        });
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String string;
        List<SuperLikePurchaseSkuModel> products;
        SuperLikePurchaseSkuModel superLikePurchaseSkuModel;
        if (obj instanceof ItemCardPurchaseModel) {
            SuperLikePurchaseModel purchaseModel = ((ItemCardPurchaseModel) obj).getPurchaseModel();
            z().j().clear();
            z().e(purchaseModel != null ? purchaseModel.getProducts() : null);
            z().notifyDataSetChanged();
            if (purchaseModel != null && (products = purchaseModel.getProducts()) != null && (superLikePurchaseSkuModel = (SuperLikePurchaseSkuModel) CollectionsKt___CollectionsKt.V(products)) != null) {
                x(superLikePurchaseSkuModel);
            }
            TextView textView = (TextView) this.itemView.findViewById(R$id.purchase_type_text);
            int i10 = b.f16266a[this.f16265e.ordinal()];
            if (i10 == 1) {
                string = this.itemView.getContext().getString(R$string.aliPay);
            } else if (i10 == 2) {
                string = this.itemView.getContext().getString(R$string.weChat);
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                string = this.itemView.getContext().getString(R$string.hua_bei_pay);
            }
            textView.setText(string);
            y(purchaseModel != null ? purchaseModel.getAssignment() : null);
        }
    }

    public final void x(SuperLikePurchaseSkuModel superLikePurchaseSkuModel) {
        List<Object> j10 = z().j();
        ArrayList<SuperLikePurchaseSkuModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof SuperLikePurchaseSkuModel) {
                arrayList.add(obj);
            }
        }
        for (SuperLikePurchaseSkuModel superLikePurchaseSkuModel2 : arrayList) {
            superLikePurchaseSkuModel2.setChecked(s.d(superLikePurchaseSkuModel.getItemId(), superLikePurchaseSkuModel2.getItemId()));
        }
        z().notifyDataSetChanged();
        ((TextView) this.itemView.findViewById(R$id.item_card_effective_date_textview)).setText(superLikePurchaseSkuModel.getDescription());
    }

    public final void y(LinkDictTipsModel linkDictTipsModel) {
        SpannableStringBuilder c4;
        Set<Map.Entry<String, String>> entrySet;
        if (linkDictTipsModel == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
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
                arrayList2.add(i10, new c(entry2));
                i10 = i11;
            }
        }
        c4 = q1.d.f53006a.c(linkDictTipsModel.getContent(), arrayList, (r18 & 4) != 0 ? null : Integer.valueOf(com.cupidapp.live.base.utils.h.a(-1, 0.5f)), (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
        View view = this.itemView;
        int i12 = R$id.purchase_protocol_textview;
        ((TextView) view.findViewById(i12)).setText(c4);
        ((TextView) this.itemView.findViewById(i12)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final MaskPartyItemCardPurchaseAdapter z() {
        return (MaskPartyItemCardPurchaseAdapter) this.f16264d.getValue();
    }
}
