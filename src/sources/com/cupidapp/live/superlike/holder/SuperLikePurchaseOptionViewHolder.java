package com.cupidapp.live.superlike.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.VipPurchaseActivityModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: SuperLikePurchaseOptionViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikePurchaseOptionViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18626c = new a(null);

    /* compiled from: SuperLikePurchaseOptionViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SuperLikePurchaseOptionViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SuperLikePurchaseOptionViewHolder(z.b(parent, R$layout.view_holder_super_like_purchase_option, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikePurchaseOptionViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        View view = this.itemView;
        int i10 = R$id.super_like_purchase_count;
        boolean z10 = true;
        ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
        if (obj instanceof SuperLikePurchaseSkuModel) {
            SuperLikePurchaseSkuModel superLikePurchaseSkuModel = (SuperLikePurchaseSkuModel) obj;
            if (superLikePurchaseSkuModel.getChecked()) {
                ((TextView) this.itemView.findViewById(R$id.super_like_purchase_price)).setTextColor(ContextCompat.getColor(this.itemView.getContext(), R$color.purple_7A69FF));
                ((ConstraintLayout) this.itemView.findViewById(R$id.super_like_sku_root)).setBackgroundResource(R$drawable.shape_super_like_purchase_option_selected);
            } else {
                ((TextView) this.itemView.findViewById(R$id.super_like_purchase_price)).setTextColor(ContextCompat.getColor(this.itemView.getContext(), R$color.text_black));
                ((ConstraintLayout) this.itemView.findViewById(R$id.super_like_sku_root)).setBackgroundResource(R$drawable.bg_vip_purchase);
            }
            ((TextView) this.itemView.findViewById(i10)).setText(superLikePurchaseSkuModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.super_like_purchase_price)).setText(superLikePurchaseSkuModel.getPriceFormatted());
            String originPriceFormatted = superLikePurchaseSkuModel.getOriginPriceFormatted();
            if (originPriceFormatted != null && originPriceFormatted.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) this.itemView.findViewById(R$id.super_like_original_price)).setVisibility(8);
            } else {
                View view2 = this.itemView;
                int i11 = R$id.super_like_original_price;
                ((TextView) view2.findViewById(i11)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).setText(superLikePurchaseSkuModel.getOriginPriceFormatted());
                ((TextView) this.itemView.findViewById(i11)).setPaintFlags(17);
            }
            ((TextView) this.itemView.findViewById(R$id.super_like_unit_price)).setText(superLikePurchaseSkuModel.getUnitPriceFormatted());
            r(superLikePurchaseSkuModel.getCornerMark());
        }
    }

    public final void r(VipPurchaseActivityModel vipPurchaseActivityModel) {
        ImageModel cornerImg = vipPurchaseActivityModel != null ? vipPurchaseActivityModel.getCornerImg() : null;
        String cornerImgUrlDesc = vipPurchaseActivityModel != null ? vipPurchaseActivityModel.getCornerImgUrlDesc() : null;
        if (cornerImg != null) {
            View view = this.itemView;
            int i10 = R$id.super_like_discount_img;
            ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
            ImageLoaderView configAngleView$lambda$0 = (ImageLoaderView) this.itemView.findViewById(i10);
            ViewGroup.LayoutParams layoutParams = configAngleView$lambda$0.getLayoutParams();
            s.h(configAngleView$lambda$0, "configAngleView$lambda$0");
            layoutParams.width = cornerImg.getScaleWidthByHeight(h.c(configAngleView$lambda$0, 15.0f));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView, "itemView.super_like_discount_img");
            ImageLoaderView.g(imageLoaderView, cornerImg, null, null, 6, null);
        } else {
            ((ImageLoaderView) this.itemView.findViewById(R$id.super_like_discount_img)).setVisibility(8);
        }
        if (cornerImgUrlDesc == null || cornerImgUrlDesc.length() == 0) {
            ((TextView) this.itemView.findViewById(R$id.super_like_discount_info)).setVisibility(4);
            return;
        }
        View view2 = this.itemView;
        int i11 = R$id.super_like_discount_info;
        ((TextView) view2.findViewById(i11)).setVisibility(0);
        ((TextView) this.itemView.findViewById(i11)).setText(cornerImgUrlDesc);
    }
}
