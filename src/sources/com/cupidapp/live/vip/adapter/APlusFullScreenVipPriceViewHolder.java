package com.cupidapp.live.vip.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.cupidapp.live.base.scrolltext.RollingTextView;
import com.cupidapp.live.vip.adapter.APlusFullScreenVipPriceViewHolder;
import com.cupidapp.live.vip.model.AnimLoadedEvent;
import com.cupidapp.live.vip.model.VipPurchaseActivityModel;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.model.VipType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: APlusFullScreenVipPriceAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class APlusFullScreenVipPriceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18730c = new a(null);

    /* compiled from: APlusFullScreenVipPriceAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final APlusFullScreenVipPriceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new APlusFullScreenVipPriceViewHolder(z.b(parent, R$layout.item_a_plus_full_screen_price, false, 2, null));
        }
    }

    /* compiled from: APlusFullScreenVipPriceAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18731a;

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
            f18731a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APlusFullScreenVipPriceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final void x(APlusFullScreenVipPriceViewHolder this$0, VipPurchasePriceModel model) {
        s.i(this$0, "this$0");
        s.i(model, "$model");
        RollingTextView rollingTextView = (RollingTextView) this$0.itemView.findViewById(R$id.item_vip_roll_price_txt);
        if (rollingTextView != null) {
            rollingTextView.setText(model.price(), true);
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof VipPurchasePriceModel) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.item_vip_total_price_txt);
            s.h(textView, "itemView.item_vip_total_price_txt");
            u.a(textView);
            RecyclerView.Adapter<? extends RecyclerView.ViewHolder> bindingAdapter = getBindingAdapter();
            if ((bindingAdapter != null ? bindingAdapter.getItemCount() : 0) > 3) {
                int l10 = (int) (((h.l(this) - h.c(this, 32.0f)) - h.c(this, 24.0f)) / 3.3f);
                if (((VipPurchasePriceModel) obj).isSelected()) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.item_price_container);
                    s.h(relativeLayout, "itemView.item_price_container");
                    y.o(relativeLayout, Integer.valueOf((int) (l10 * 1.07f)), null, 2, null);
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.itemView.findViewById(R$id.item_price_container);
                    s.h(relativeLayout2, "itemView.item_price_container");
                    y.o(relativeLayout2, Integer.valueOf(l10), null, 2, null);
                }
                ((LinearLayout) this.itemView.findViewById(R$id.item_vip_total_price)).setMinimumWidth(n.d(h.c(this, 72.0f), l10));
            } else {
                int l11 = (int) (((h.l(this) - h.c(this, 32.0f)) - h.c(this, 24.0f)) / 3.06f);
                if (((VipPurchasePriceModel) obj).isSelected()) {
                    RelativeLayout relativeLayout3 = (RelativeLayout) this.itemView.findViewById(R$id.item_price_container);
                    s.h(relativeLayout3, "itemView.item_price_container");
                    y.o(relativeLayout3, Integer.valueOf((int) (l11 * 1.06f)), null, 2, null);
                } else {
                    RelativeLayout relativeLayout4 = (RelativeLayout) this.itemView.findViewById(R$id.item_price_container);
                    s.h(relativeLayout4, "itemView.item_price_container");
                    y.o(relativeLayout4, Integer.valueOf(l11), null, 2, null);
                }
                ((LinearLayout) this.itemView.findViewById(R$id.item_vip_total_price)).setMinimumWidth(n.d(h.c(this, 80.0f), l11));
            }
            VipPurchasePriceModel vipPurchasePriceModel = (VipPurchasePriceModel) obj;
            ((TextView) this.itemView.findViewById(R$id.item_vip_monthNum)).setText(vipPurchasePriceModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setText(this.itemView.getContext().getString(R$string.price_of_month, vipPurchasePriceModel.getPerMonthPrice()));
            t(vipPurchasePriceModel.getVipType(), vipPurchasePriceModel.isSelected());
            u(vipPurchasePriceModel);
            s(vipPurchasePriceModel);
            w(vipPurchasePriceModel);
        }
    }

    public final void s(VipPurchasePriceModel vipPurchasePriceModel) {
        VipPurchaseActivityModel cornerMark = vipPurchasePriceModel.getCornerMark();
        ImageModel cornerImg = cornerMark != null ? cornerMark.getCornerImg() : null;
        VipPurchaseActivityModel cornerMark2 = vipPurchasePriceModel.getCornerMark();
        String cornerImgUrlDesc = cornerMark2 != null ? cornerMark2.getCornerImgUrlDesc() : null;
        if (cornerImg != null) {
            View view = this.itemView;
            int i10 = R$id.item_vip_angle_img;
            ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
            ImageLoaderView configAngleView$lambda$1 = (ImageLoaderView) this.itemView.findViewById(i10);
            ViewGroup.LayoutParams layoutParams = configAngleView$lambda$1.getLayoutParams();
            s.h(configAngleView$lambda$1, "configAngleView$lambda$1");
            layoutParams.width = cornerImg.getScaleWidthByHeight(h.c(configAngleView$lambda$1, 15.0f));
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

    public final void t(VipType vipType, boolean z10) {
        int i10 = b.f18731a[vipType.ordinal()];
        if (i10 == 1) {
            ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$drawable.selector_gold_purchase);
            ((LinearLayout) this.itemView.findViewById(R$id.item_vip_total_price)).setBackgroundResource(R$drawable.bg_selector_svip_price);
        } else if (i10 != 2) {
            ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$drawable.selector_red_purchase);
            ((LinearLayout) this.itemView.findViewById(R$id.item_vip_total_price)).setBackgroundResource(R$drawable.selector_total_price_red);
        } else {
            if (z10) {
                ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$mipmap.rainbow_sku_bg);
            } else {
                ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setBackgroundResource(R$drawable.rect_cor_8_sd_26ffffff);
            }
            ((LinearLayout) this.itemView.findViewById(R$id.item_vip_total_price)).setBackgroundResource(R$drawable.bg_selector_rainbow_vip_price);
        }
        ((RelativeLayout) this.itemView.findViewById(R$id.item_price_container)).setSelected(z10);
    }

    public final void u(VipPurchasePriceModel vipPurchasePriceModel) {
        if (vipPurchasePriceModel.isSelected()) {
            ((LinearLayout) this.itemView.findViewById(R$id.item_vip_total_price)).setSelected(true);
            ((TextView) this.itemView.findViewById(R$id.item_vip_monthNum)).getPaint().setFakeBoldText(true);
        } else {
            ((LinearLayout) this.itemView.findViewById(R$id.item_vip_total_price)).setSelected(false);
            ((TextView) this.itemView.findViewById(R$id.item_vip_monthNum)).getPaint().setFakeBoldText(false);
        }
        int i10 = b.f18731a[vipPurchasePriceModel.getVipType().ordinal()];
        if (i10 == 1) {
            int i11 = vipPurchasePriceModel.isSelected() ? -15066598 : -1;
            v(i11, i11, vipPurchasePriceModel.isSelected() ? -15066598 : com.cupidapp.live.base.utils.h.a(-1, 0.5f));
        } else if (i10 != 2) {
            v(vipPurchasePriceModel.isSelected() ? -49088 : -15066598, vipPurchasePriceModel.isSelected() ? -1 : -15066598, vipPurchasePriceModel.isSelected() ? -49088 : -8618884);
        } else {
            v(-1, -1, vipPurchasePriceModel.isSelected() ? -1 : com.cupidapp.live.base.utils.h.a(-1, 0.5f));
        }
    }

    public final void v(int i10, int i11, int i12) {
        ((TextView) this.itemView.findViewById(R$id.item_vip_monthNum)).setTextColor(i10);
        ((TextView) this.itemView.findViewById(R$id.item_vip_total_price_txt)).setTextColor(i11);
        ((RollingTextView) this.itemView.findViewById(R$id.item_vip_roll_price_txt)).setTextColor(i11);
        ((TextView) this.itemView.findViewById(R$id.item_vip_unit_price)).setTextColor(i12);
    }

    public final void w(final VipPurchasePriceModel vipPurchasePriceModel) {
        if (vipPurchasePriceModel.getAnimationType() != null) {
            EventBus.c().l(new AnimLoadedEvent(vipPurchasePriceModel.getAnimationType()));
            vipPurchasePriceModel.setAnimationType(null);
            ((TextView) this.itemView.findViewById(R$id.item_vip_total_price_txt)).setText(R$string.yuan);
            View view = this.itemView;
            int i10 = R$id.item_vip_roll_price_txt;
            ((RollingTextView) view.findViewById(i10)).k();
            ((RollingTextView) this.itemView.findViewById(i10)).setAnimationDuration(400L);
            ((RollingTextView) this.itemView.findViewById(i10)).setCharOrder("0123456789");
            RollingTextView rollingTextView = (RollingTextView) this.itemView.findViewById(i10);
            Integer originPriceInCent = vipPurchasePriceModel.getOriginPriceInCent();
            rollingTextView.setText(String.valueOf((originPriceInCent != null ? originPriceInCent.intValue() : 0) / 100), false);
            ((RollingTextView) this.itemView.findViewById(i10)).setVisibility(0);
            this.itemView.postDelayed(new Runnable() { // from class: a4.a
                @Override // java.lang.Runnable
                public final void run() {
                    APlusFullScreenVipPriceViewHolder.x(APlusFullScreenVipPriceViewHolder.this, vipPurchasePriceModel);
                }
            }, 400L);
            return;
        }
        ((RollingTextView) this.itemView.findViewById(R$id.item_vip_roll_price_txt)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.item_vip_total_price_txt)).setText(this.itemView.getContext().getString(R$string.total_price, vipPurchasePriceModel.price()));
    }
}
