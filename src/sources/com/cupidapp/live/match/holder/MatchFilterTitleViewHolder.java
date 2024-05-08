package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.FKSVipImgLayout;
import com.cupidapp.live.match.model.FilterTitleModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: MatchFilterTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16805c = new a(null);

    /* compiled from: MatchFilterTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MatchFilterTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MatchFilterTitleViewHolder(z.b(parent, R$layout.item_match_filter_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchFilterTitleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FilterTitleModel) {
            View view = this.itemView;
            int i10 = R$id.titleTextView;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.titleTextView");
            u.a(textView);
            FilterTitleModel filterTitleModel = (FilterTitleModel) obj;
            ((TextView) this.itemView.findViewById(i10)).setText(filterTitleModel.getTitle());
            int i11 = 8;
            this.itemView.findViewById(R$id.gap).setVisibility(filterTitleModel.getShowGap() ? 0 : 8);
            View view2 = this.itemView;
            int i12 = R$id.description;
            TextView textView2 = (TextView) view2.findViewById(i12);
            String des = filterTitleModel.getDes();
            if (!(des == null || des.length() == 0)) {
                ((TextView) this.itemView.findViewById(i12)).setText(filterTitleModel.getDes());
                i11 = 0;
            }
            textView2.setVisibility(i11);
            int productType = filterTitleModel.getProductType();
            VipDiscountDescriptionResult sVipDiscount = filterTitleModel.getSVipDiscount();
            r(productType, sVipDiscount != null ? sVipDiscount.getDescription() : null);
        }
    }

    public final void r(int i10, String str) {
        PurchaseProductType.a aVar = PurchaseProductType.Companion;
        if (aVar.d(i10)) {
            View view = this.itemView;
            int i11 = R$id.titleAfterIconImageView;
            ((FKSVipImgLayout) view.findViewById(i11)).d();
            ((FKSVipImgLayout) this.itemView.findViewById(i11)).setVisibility(0);
            return;
        }
        if (aVar.c(i10)) {
            View view2 = this.itemView;
            int i12 = R$id.titleAfterIconImageView;
            ((FKSVipImgLayout) view2.findViewById(i12)).c(str);
            ((FKSVipImgLayout) this.itemView.findViewById(i12)).setVisibility(0);
            return;
        }
        if (aVar.b(i10)) {
            View view3 = this.itemView;
            int i13 = R$id.titleAfterIconImageView;
            ((FKSVipImgLayout) view3.findViewById(i13)).b();
            ((FKSVipImgLayout) this.itemView.findViewById(i13)).setVisibility(0);
            return;
        }
        ((FKSVipImgLayout) this.itemView.findViewById(R$id.titleAfterIconImageView)).setVisibility(8);
    }
}
