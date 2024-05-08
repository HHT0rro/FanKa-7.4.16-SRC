package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.CityFilterModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: CityFilterItemViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CityFilterItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16787c = new a(null);

    /* compiled from: CityFilterItemViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CityFilterItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new CityFilterItemViewHolder(z.b(parent, R$layout.item_city_filter, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CityFilterItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof CityFilterModel) {
            View view = this.itemView;
            int i10 = R$id.city_filter_city_text;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.city_filter_city_text");
            u.a(textView);
            CityFilterModel cityFilterModel = (CityFilterModel) obj;
            String selectedRegion = cityFilterModel.getSelectedRegion();
            if (selectedRegion == null || selectedRegion.length() == 0) {
                ((ImageView) this.itemView.findViewById(R$id.city_filter_other_city_tick)).setVisibility(8);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.city_filter_other_city_tick)).setVisibility(0);
            }
            ((TextView) this.itemView.findViewById(i10)).setText(cityFilterModel.getSelectedRegion());
            TextView textView2 = (TextView) this.itemView.findViewById(R$id.city_filter_other_city_name);
            s.h(textView2, "itemView.city_filter_other_city_name");
            u.a(textView2);
        }
    }
}
