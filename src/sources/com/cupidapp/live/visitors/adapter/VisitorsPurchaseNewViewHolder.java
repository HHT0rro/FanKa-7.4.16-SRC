package com.cupidapp.live.visitors.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.vip.model.VipPurchaseActivityModel;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: VisitorsPurchaserNewAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsPurchaseNewViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18938d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final int f18939c;

    /* compiled from: VisitorsPurchaserNewAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorsPurchaseNewViewHolder a(@NotNull ViewGroup parent, int i10) {
            s.i(parent, "parent");
            return new VisitorsPurchaseNewViewHolder(z.b(parent, R$layout.item_visitors_discount_purchase, false, 2, null), i10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsPurchaseNewViewHolder(@NotNull View itemView, int i10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f18939c = i10;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof VipPurchasePriceModel) {
            int l10 = (int) ((h.l(this) - h.c(this, 88.0f)) / Math.min(this.f18939c, 3.1d));
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.saleItemContainerLayout);
            s.h(linearLayout, "itemView.saleItemContainerLayout");
            y.o(linearLayout, Integer.valueOf(l10), null, 2, null);
            View view = this.itemView;
            int i10 = R$id.total_sale;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            View view2 = this.itemView;
            int i11 = R$id.title;
            VipPurchasePriceModel vipPurchasePriceModel = (VipPurchasePriceModel) obj;
            ((TextView) view2.findViewById(i11)).setText(vipPurchasePriceModel.getTitle());
            TextView textView = (TextView) this.itemView.findViewById(i11);
            s.h(textView, "itemView.title");
            u.a(textView);
            TextView textView2 = (TextView) this.itemView.findViewById(i10);
            s.h(textView2, "itemView.total_sale");
            u.a(textView2);
            ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(R$string.total_price, vipPurchasePriceModel.price()));
            String crossedPrice = vipPurchasePriceModel.getCrossedPrice();
            if (!(crossedPrice == null || crossedPrice.length() == 0)) {
                View view3 = this.itemView;
                int i12 = R$id.crossed_sale;
                ((TextView) view3.findViewById(i12)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i12)).setText(this.itemView.getContext().getString(R$string.price, vipPurchasePriceModel.getCrossedPrice()));
                ((TextView) this.itemView.findViewById(i12)).setPaintFlags(17);
            } else {
                ((TextView) this.itemView.findViewById(R$id.crossed_sale)).setVisibility(4);
            }
            ((TextView) this.itemView.findViewById(R$id.unit_sale)).setText(this.itemView.getContext().getString(R$string.price_of_month, vipPurchasePriceModel.getPerMonthPrice()));
            s(vipPurchasePriceModel.isSelected());
            r(vipPurchasePriceModel);
        }
    }

    public final void r(VipPurchasePriceModel vipPurchasePriceModel) {
        VipPurchaseActivityModel cornerMark = vipPurchasePriceModel.getCornerMark();
        String cornerImgUrlDesc = cornerMark != null ? cornerMark.getCornerImgUrlDesc() : null;
        if (cornerImgUrlDesc == null || cornerImgUrlDesc.length() == 0) {
            ((TextView) this.itemView.findViewById(R$id.angleTextView)).setVisibility(8);
            return;
        }
        View view = this.itemView;
        int i10 = R$id.angleTextView;
        ((TextView) view.findViewById(i10)).setVisibility(0);
        ((TextView) this.itemView.findViewById(i10)).setText(cornerImgUrlDesc);
    }

    public final void s(boolean z10) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(h.c(gradientDrawable, 10.0f));
        if (z10) {
            gradientDrawable.setColor(ContextCompat.getColor(this.itemView.getContext(), R$color.red_0AFF4040));
            gradientDrawable.setStroke(h.c(this, 1.0f), -49088);
            ((LinearLayout) this.itemView.findViewById(R$id.saleItemContainerLayout)).setBackground(gradientDrawable);
            ((TextView) this.itemView.findViewById(R$id.total_sale)).setTextColor(-49088);
            View view = this.itemView;
            int i10 = R$id.unit_sale;
            ((TextView) view.findViewById(i10)).setTextColor(-49088);
            ((TextView) this.itemView.findViewById(i10)).setBackgroundResource(R$drawable.bg_four_corner_alpha_14_red);
            return;
        }
        gradientDrawable.setColor(ContextCompat.getColor(this.itemView.getContext(), R$color.app_white));
        gradientDrawable.setStroke(h.c(this, 1.0f), -2236963);
        ((LinearLayout) this.itemView.findViewById(R$id.saleItemContainerLayout)).setBackground(gradientDrawable);
        ((TextView) this.itemView.findViewById(R$id.total_sale)).setTextColor(-15066598);
        View view2 = this.itemView;
        int i11 = R$id.unit_sale;
        ((TextView) view2.findViewById(i11)).setTextColor(-8618884);
        ((TextView) this.itemView.findViewById(i11)).setBackgroundResource(R$drawable.shape_f2_bg_four_radius);
    }
}
