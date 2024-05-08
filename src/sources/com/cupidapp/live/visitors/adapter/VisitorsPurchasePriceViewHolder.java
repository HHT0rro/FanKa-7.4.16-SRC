package com.cupidapp.live.visitors.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.visitors.model.CornerMarkModel;
import com.cupidapp.live.visitors.model.VisitorsPurchasePriceModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.z;

/* compiled from: VisitorsPurchaseRecyclerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsPurchasePriceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18940c = new a(null);

    /* compiled from: VisitorsPurchaseRecyclerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorsPurchasePriceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new VisitorsPurchasePriceViewHolder(z.b(parent, R$layout.item_visitors_purchase_price, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsPurchasePriceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof VisitorsPurchasePriceModel) {
            View view = this.itemView;
            int i10 = R$id.totalPrice;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            View view2 = this.itemView;
            int i11 = R$id.title;
            VisitorsPurchasePriceModel visitorsPurchasePriceModel = (VisitorsPurchasePriceModel) obj;
            ((TextView) view2.findViewById(i11)).setText(visitorsPurchasePriceModel.getTitle());
            TextView textView = (TextView) this.itemView.findViewById(i11);
            s.h(textView, "itemView.title");
            u.a(textView);
            String string = this.itemView.getContext().getString(R$string.total_price, visitorsPurchasePriceModel.price());
            s.h(string, "itemView.context.getStri…tal_price, model.price())");
            ((TextView) this.itemView.findViewById(i10)).setText(string);
            String crossedPrice = visitorsPurchasePriceModel.getCrossedPrice();
            if (!(crossedPrice == null || crossedPrice.length() == 0)) {
                View view3 = this.itemView;
                int i12 = R$id.crossedPrice;
                ((TextView) view3.findViewById(i12)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i12)).setText(this.itemView.getContext().getString(R$string.price, visitorsPurchasePriceModel.getCrossedPrice()));
                ((TextView) this.itemView.findViewById(i12)).setPaintFlags(17);
            } else {
                ((TextView) this.itemView.findViewById(R$id.crossedPrice)).setVisibility(4);
            }
            ((TextView) this.itemView.findViewById(R$id.unitPrice)).setText(this.itemView.getContext().getString(R$string.price_of_month, visitorsPurchasePriceModel.getPerMonthPrice()));
            s(visitorsPurchasePriceModel.isSelected());
            r(visitorsPurchasePriceModel);
        }
    }

    public final void r(VisitorsPurchasePriceModel visitorsPurchasePriceModel) {
        CornerMarkModel cornerMark = visitorsPurchasePriceModel.getCornerMark();
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
            ((LinearLayout) this.itemView.findViewById(R$id.priceItemContainerLayout)).setBackground(gradientDrawable);
            ((TextView) this.itemView.findViewById(R$id.totalPrice)).setTextColor(-49088);
            return;
        }
        gradientDrawable.setColor(ContextCompat.getColor(this.itemView.getContext(), R$color.app_white));
        gradientDrawable.setStroke(h.c(this, 1.0f), -2236963);
        ((LinearLayout) this.itemView.findViewById(R$id.priceItemContainerLayout)).setBackground(gradientDrawable);
        ((TextView) this.itemView.findViewById(R$id.totalPrice)).setTextColor(-15066598);
    }
}
