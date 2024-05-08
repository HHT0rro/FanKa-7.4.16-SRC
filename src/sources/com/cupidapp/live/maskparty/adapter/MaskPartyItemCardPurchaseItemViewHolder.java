package com.cupidapp.live.maskparty.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.VipPurchaseActivityModel;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: MaskPartyItemCardPurchaseAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardPurchaseItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16261c = new a(null);

    /* compiled from: MaskPartyItemCardPurchaseAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MaskPartyItemCardPurchaseItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MaskPartyItemCardPurchaseItemViewHolder(z.b(parent, R$layout.view_holder_mask_party_item_card_purchase_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardPurchaseItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.purchase_count_textview)).getPaint().setFakeBoldText(true);
        y.o(itemView, Integer.valueOf((h.l(this) - h.c(this, 64.0f)) / 3), null, 2, null);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof SuperLikePurchaseSkuModel) {
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.purchase_item_layout);
            s.h(linearLayout, "itemView.purchase_item_layout");
            SuperLikePurchaseSkuModel superLikePurchaseSkuModel = (SuperLikePurchaseSkuModel) obj;
            boolean z10 = true;
            y.i(linearLayout, (r18 & 1) != 0 ? 0.0f : h.c(this, 8.0f), superLikePurchaseSkuModel.getChecked() ? kotlin.collections.s.m(-9603585, -4954625) : r.e(0), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TL_BR, (r18 & 8) != 0 ? null : superLikePurchaseSkuModel.getChecked() ? null : Integer.valueOf(h.c(this, 1.0f)), (r18 & 16) != 0 ? null : Integer.valueOf(com.cupidapp.live.base.utils.h.a(-1, 0.3f)), (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            ((TextView) this.itemView.findViewById(R$id.purchase_count_textview)).setText(superLikePurchaseSkuModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.price_textview)).setText(superLikePurchaseSkuModel.getPriceFormatted());
            ((TextView) this.itemView.findViewById(R$id.unit_price_textview)).setText(superLikePurchaseSkuModel.getUnitPriceFormatted());
            VipPurchaseActivityModel cornerMark = superLikePurchaseSkuModel.getCornerMark();
            String cornerImgUrlDesc = cornerMark != null ? cornerMark.getCornerImgUrlDesc() : null;
            if (cornerImgUrlDesc != null && cornerImgUrlDesc.length() != 0) {
                z10 = false;
            }
            if (z10) {
                TextView textView = (TextView) this.itemView.findViewById(R$id.subscript_textview);
                s.h(textView, "itemView.subscript_textview");
                textView.setVisibility(8);
                return;
            }
            View view = this.itemView;
            int i10 = R$id.subscript_textview;
            TextView textView2 = (TextView) view.findViewById(i10);
            s.h(textView2, "itemView.subscript_textview");
            textView2.setVisibility(0);
            TextView textView3 = (TextView) this.itemView.findViewById(i10);
            VipPurchaseActivityModel cornerMark2 = superLikePurchaseSkuModel.getCornerMark();
            textView3.setText(cornerMark2 != null ? cornerMark2.getCornerImgUrlDesc() : null);
        }
    }
}
