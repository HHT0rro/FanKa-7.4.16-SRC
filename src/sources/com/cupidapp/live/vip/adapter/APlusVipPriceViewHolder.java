package com.cupidapp.live.vip.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ce.n;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.vip.model.VipPurchaseActivityModel;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.model.VipType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: APlusVipPriceRecyclerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class APlusVipPriceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18732c = new a(null);

    /* compiled from: APlusVipPriceRecyclerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final APlusVipPriceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new APlusVipPriceViewHolder(z.b(parent, R$layout.item_a_plus_vip_price, false, 2, null));
        }
    }

    /* compiled from: APlusVipPriceRecyclerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18733a;

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
            f18733a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APlusVipPriceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.item_vip_monthNum)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof VipPurchasePriceModel) {
            RecyclerView.Adapter<? extends RecyclerView.ViewHolder> bindingAdapter = getBindingAdapter();
            if ((bindingAdapter != null ? bindingAdapter.getItemCount() : 0) > 3) {
                int l10 = (int) (((h.l(this) - h.c(this, 40.0f)) - h.c(this, 24.0f)) / 3.4f);
                if (((VipPurchasePriceModel) obj).isSelected()) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.item_price_container);
                    s.h(relativeLayout, "itemView.item_price_container");
                    y.o(relativeLayout, Integer.valueOf((int) (l10 * 1.13f)), null, 2, null);
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.itemView.findViewById(R$id.item_price_container);
                    s.h(relativeLayout2, "itemView.item_price_container");
                    y.o(relativeLayout2, Integer.valueOf(l10), null, 2, null);
                }
                ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setMinimumWidth(n.d(h.c(this, 72.0f), l10));
            } else {
                int l11 = (int) (((h.l(this) - h.c(this, 56.0f)) - h.c(this, 16.0f)) / 3.12f);
                if (((VipPurchasePriceModel) obj).isSelected()) {
                    RelativeLayout relativeLayout3 = (RelativeLayout) this.itemView.findViewById(R$id.item_price_container);
                    s.h(relativeLayout3, "itemView.item_price_container");
                    y.o(relativeLayout3, Integer.valueOf((int) (l11 * 1.12f)), null, 2, null);
                } else {
                    RelativeLayout relativeLayout4 = (RelativeLayout) this.itemView.findViewById(R$id.item_price_container);
                    s.h(relativeLayout4, "itemView.item_price_container");
                    y.o(relativeLayout4, Integer.valueOf(l11), null, 2, null);
                }
                ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setMinimumWidth(n.d(h.c(this, 80.0f), l11));
            }
            VipPurchasePriceModel vipPurchasePriceModel = (VipPurchasePriceModel) obj;
            ((TextView) this.itemView.findViewById(R$id.item_vip_monthNum)).setText(vipPurchasePriceModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.item_vip_total_price)).setText(this.itemView.getContext().getString(R$string.total_price, vipPurchasePriceModel.price()));
            String crossedPrice = vipPurchasePriceModel.getCrossedPrice();
            if (!(crossedPrice == null || crossedPrice.length() == 0)) {
                View view = this.itemView;
                int i10 = R$id.item_vip_origin_price;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(R$string.price, vipPurchasePriceModel.getCrossedPrice()));
                ((TextView) this.itemView.findViewById(i10)).setPaintFlags(17);
            } else {
                ((TextView) this.itemView.findViewById(R$id.item_vip_origin_price)).setVisibility(8);
            }
            View view2 = this.itemView;
            int i11 = R$id.item_vip_unit_price;
            ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i11)).setText(this.itemView.getContext().getString(R$string.price_of_month, vipPurchasePriceModel.getPerMonthPrice()));
            s(vipPurchasePriceModel.getVipType(), vipPurchasePriceModel.isSelected());
            t(vipPurchasePriceModel);
            r(vipPurchasePriceModel);
        }
    }

    public final void r(VipPurchasePriceModel vipPurchasePriceModel) {
        VipPurchaseActivityModel cornerMark = vipPurchasePriceModel.getCornerMark();
        ImageModel cornerImg = cornerMark != null ? cornerMark.getCornerImg() : null;
        VipPurchaseActivityModel cornerMark2 = vipPurchasePriceModel.getCornerMark();
        String cornerImgUrlDesc = cornerMark2 != null ? cornerMark2.getCornerImgUrlDesc() : null;
        if (cornerImg != null) {
            View view = this.itemView;
            int i10 = R$id.item_vip_angle_img;
            ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
            ImageLoaderView configAngleView$lambda$0 = (ImageLoaderView) this.itemView.findViewById(i10);
            ViewGroup.LayoutParams layoutParams = configAngleView$lambda$0.getLayoutParams();
            s.h(configAngleView$lambda$0, "configAngleView$lambda$0");
            layoutParams.width = cornerImg.getScaleWidthByHeight(h.c(configAngleView$lambda$0, 15.0f));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView, "itemView.item_vip_angle_img");
            ImageLoaderView.g(imageLoaderView, cornerImg, null, null, 6, null);
        } else {
            ((ImageLoaderView) this.itemView.findViewById(R$id.item_vip_angle_img)).setVisibility(8);
        }
        if (cornerImgUrlDesc == null || cornerImgUrlDesc.length() == 0) {
            ((TextView) this.itemView.findViewById(R$id.item_vip_angle)).setVisibility(8);
            return;
        }
        View view2 = this.itemView;
        int i11 = R$id.item_vip_angle;
        ((TextView) view2.findViewById(i11)).setVisibility(0);
        ((TextView) this.itemView.findViewById(i11)).setText(cornerImgUrlDesc);
    }

    public final void s(VipType vipType, boolean z10) {
        int i10 = b.f18733a[vipType.ordinal()];
        if (i10 == 1) {
            ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$drawable.bg_item_selector_vip_purchase);
            ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setBackgroundResource(R$drawable.bg_selector_vip_price);
        } else if (i10 == 2) {
            ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$drawable.bg_selector_svip_purchase);
            ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setBackgroundResource(R$drawable.bg_selector_svip_price);
        } else if (i10 == 3) {
            if (z10) {
                ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$mipmap.rainbow_sku_bg);
            } else {
                ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$drawable.bg_svip_purchase);
            }
            ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setBackgroundResource(R$drawable.bg_selector_rainbow_vip_price);
        } else if (i10 == 4) {
            ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$drawable.bg_item_selector_vip_purchase);
            ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setBackgroundResource(R$drawable.bg_selector_vip_price);
        }
        ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setSelected(z10);
    }

    public final void t(VipPurchasePriceModel vipPurchasePriceModel) {
        if (vipPurchasePriceModel.isSelected()) {
            View view = this.itemView;
            int i10 = R$id.item_vip_unit_price;
            ((TextView) view.findViewById(i10)).setSelected(true);
            ((TextView) this.itemView.findViewById(i10)).getPaint().setFakeBoldText(true);
        } else {
            View view2 = this.itemView;
            int i11 = R$id.item_vip_unit_price;
            ((TextView) view2.findViewById(i11)).setSelected(false);
            ((TextView) this.itemView.findViewById(i11)).getPaint().setFakeBoldText(false);
        }
        int i12 = b.f18733a[vipPurchasePriceModel.getVipType().ordinal()];
        if (i12 == 1) {
            u(-15066598, vipPurchasePriceModel.isSelected() ? -49088 : -15066598, -15066598, com.cupidapp.live.base.utils.h.a(-15066598, 0.3f));
            return;
        }
        if (i12 == 2) {
            int i13 = vipPurchasePriceModel.isSelected() ? -15066598 : -3750202;
            u(i13, i13, i13, vipPurchasePriceModel.isSelected() ? com.cupidapp.live.base.utils.h.a(-16777216, 0.3f) : com.cupidapp.live.base.utils.h.a(-1, 0.3f));
        } else if (i12 == 3) {
            int i14 = vipPurchasePriceModel.isSelected() ? -1 : -3750202;
            u(i14, i14, i14, com.cupidapp.live.base.utils.h.a(-1, 0.3f));
        } else {
            if (i12 != 4) {
                return;
            }
            u(-15066598, vipPurchasePriceModel.isSelected() ? -49088 : -15066598, -15066598, com.cupidapp.live.base.utils.h.a(-15066598, 0.3f));
        }
    }

    public final void u(int i10, int i11, int i12, int i13) {
        ((TextView) this.itemView.findViewById(R$id.item_vip_monthNum)).setTextColor(i10);
        ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setTextColor(i11);
        ((TextView) this.itemView.findViewById(R$id.item_vip_total_price)).setTextColor(i12);
        ((TextView) this.itemView.findViewById(R$id.item_vip_origin_price)).setTextColor(i13);
    }
}
