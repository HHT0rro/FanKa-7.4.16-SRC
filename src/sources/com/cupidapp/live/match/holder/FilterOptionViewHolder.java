package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.SuperFilterOptionModel;
import com.cupidapp.live.match.view.OptionSelectLayout;
import com.cupidapp.live.match.view.OptionSelectTransModel;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FilterOptionViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterOptionViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16796d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16797c;

    /* compiled from: FilterOptionViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FilterOptionViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new FilterOptionViewHolder(z.b(parent, R$layout.item_filter_option, false, 2, null), z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterOptionViewHolder(@NotNull View itemView, boolean z10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16797c = z10;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof SuperFilterOptionModel) {
            int l10 = ((h.l(this) - h.c(this, 26.0f)) - h.c(this, 40.0f)) / 4;
            if (l10 <= 0) {
                l10 = h.c(this, 78.0f);
            }
            SuperFilterOptionModel superFilterOptionModel = (SuperFilterOptionModel) obj;
            ((OptionSelectLayout) this.itemView.findViewById(R$id.filter_ll)).h(new OptionSelectTransModel(superFilterOptionModel.getOptions(), l10, this.f16797c, superFilterOptionModel.getProductType(), VipPurchaseEntranceType.SuperFilter));
        }
    }
}
