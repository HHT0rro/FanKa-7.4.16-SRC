package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.FKSVipImgLayout;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.FilterTabKey;
import com.cupidapp.live.match.model.FilterTabModel;
import com.cupidapp.live.match.model.OptionFilterUiModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.view.OptionSelectLayout;
import com.cupidapp.live.match.view.OptionSelectTransModel;
import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.z;

/* compiled from: OptionFilterTabViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OptionFilterTabViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16812d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16813c;

    /* compiled from: OptionFilterTabViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OptionFilterTabViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new OptionFilterTabViewHolder(z.b(parent, R$layout.item_filter_tab, false, 2, null), z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OptionFilterTabViewHolder(@NotNull View itemView, boolean z10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16813c = z10;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof OptionFilterUiModel) {
            OptionFilterUiModel optionFilterUiModel = (OptionFilterUiModel) obj;
            FilterTabModel filterTabModel = optionFilterUiModel.getFilterTabModel();
            int productType = filterTabModel.getProductType();
            VipDiscountDescriptionResult vipDiscount = optionFilterUiModel.getVipDiscount();
            s(productType, vipDiscount != null ? vipDiscount.getDescription() : null);
            View view = this.itemView;
            int i10 = R$id.filter_title;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.filter_title");
            u.a(textView);
            ((TextView) this.itemView.findViewById(i10)).setText(filterTabModel.getTitle());
            int l10 = ((h.l(this) - h.c(this, 15.0f)) - h.c(this, 40.0f)) / 4;
            if (l10 <= 0) {
                l10 = h.c(this, 78.0f);
            }
            int i11 = l10;
            OptionSelectLayout optionSelectLayout = (OptionSelectLayout) this.itemView.findViewById(R$id.filter_ll);
            List<FilterOption> options = filterTabModel.getOptions();
            if (options == null) {
                options = kotlin.collections.s.j();
            }
            optionSelectLayout.h(new OptionSelectTransModel(options, i11, this.f16813c, filterTabModel.getProductType(), r(filterTabModel.getKey())));
        }
    }

    public final VipPurchaseEntranceType r(String str) {
        if (p.r(FilterTabKey.MBTI.getValue(), str, true)) {
            return VipPurchaseEntranceType.MBTIFilter;
        }
        if (p.r(FilterTabKey.ROLE.getValue(), str, true)) {
            return VipPurchaseEntranceType.RoleFilter;
        }
        if (p.r(FilterTabKey.ZODIAC.getValue(), str, true)) {
            return VipPurchaseEntranceType.ZodiacFilter;
        }
        return VipPurchaseEntranceType.SuperFilter;
    }

    public final void s(int i10, String str) {
        PurchaseProductType.a aVar = PurchaseProductType.Companion;
        if (aVar.d(i10)) {
            View view = this.itemView;
            int i11 = R$id.svip_img_layout;
            ((FKSVipImgLayout) view.findViewById(i11)).d();
            ((FKSVipImgLayout) this.itemView.findViewById(i11)).setVisibility(0);
            return;
        }
        if (aVar.c(i10)) {
            View view2 = this.itemView;
            int i12 = R$id.svip_img_layout;
            ((FKSVipImgLayout) view2.findViewById(i12)).c(str);
            ((FKSVipImgLayout) this.itemView.findViewById(i12)).setVisibility(0);
            return;
        }
        if (aVar.b(i10)) {
            View view3 = this.itemView;
            int i13 = R$id.svip_img_layout;
            ((FKSVipImgLayout) view3.findViewById(i13)).b();
            ((FKSVipImgLayout) this.itemView.findViewById(i13)).setVisibility(0);
            return;
        }
        ((FKSVipImgLayout) this.itemView.findViewById(R$id.svip_img_layout)).setVisibility(8);
    }
}
