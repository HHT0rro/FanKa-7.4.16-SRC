package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.LocationItemViewModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.o;
import z0.u;
import z0.z;

/* compiled from: LocationItemViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocationItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16803c = new a(null);

    /* compiled from: LocationItemViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LocationItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new LocationItemViewHolder(z.b(parent, R$layout.view_holder_location_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LocationItemViewModel) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.roaming_to_other_city_name);
            s.h(textView, "itemView.roaming_to_other_city_name");
            u.a(textView);
            TextView textView2 = (TextView) this.itemView.findViewById(R$id.current_city_name);
            s.h(textView2, "itemView.current_city_name");
            u.a(textView2);
            TextView textView3 = (TextView) this.itemView.findViewById(R$id.map_content_txt);
            s.h(textView3, "itemView.map_content_txt");
            u.a(textView3);
            LocationItemViewModel locationItemViewModel = (LocationItemViewModel) obj;
            if (locationItemViewModel.getFromNearby()) {
                s();
                return;
            }
            r(locationItemViewModel.getUseRecommend());
            if (locationItemViewModel.getUseRecommend()) {
                ((TextView) this.itemView.findViewById(R$id.roaming_to_city_text)).setText("");
            } else {
                ((TextView) this.itemView.findViewById(R$id.roaming_to_city_text)).setText(locationItemViewModel.getSelectedRegion());
            }
            ((ImageView) this.itemView.findViewById(R$id.roaming_to_other_city_vip_img)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.map_vip_img)).setVisibility(0);
        }
    }

    public final void r(boolean z10) {
        if (z10) {
            ((ImageView) this.itemView.findViewById(R$id.current_city_tick)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.roaming_to_other_city_tick)).setVisibility(4);
            ((TextView) this.itemView.findViewById(R$id.roaming_to_city_text)).setText("");
        } else {
            ((ImageView) this.itemView.findViewById(R$id.current_city_tick)).setVisibility(4);
            ((ImageView) this.itemView.findViewById(R$id.roaming_to_other_city_tick)).setVisibility(0);
        }
    }

    public final void s() {
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.current_city_tick);
        s.h(imageView, "itemView.current_city_tick");
        o.b(imageView, -5658199);
        ((TextView) this.itemView.findViewById(R$id.current_city_name)).setTextColor(-5658199);
        ((ImageView) this.itemView.findViewById(R$id.roaming_to_other_city_tick)).setVisibility(4);
        ((TextView) this.itemView.findViewById(R$id.roaming_to_other_city_name)).setTextColor(-5658199);
        ((ImageView) this.itemView.findViewById(R$id.roaming_to_other_city_vip_img)).setImageAlpha(85);
        ((TextView) this.itemView.findViewById(R$id.roaming_to_city_text)).setVisibility(4);
        ImageView imageView2 = (ImageView) this.itemView.findViewById(R$id.roaming_to_other_city_arrow);
        s.h(imageView2, "itemView.roaming_to_other_city_arrow");
        o.b(imageView2, -5658199);
    }
}
