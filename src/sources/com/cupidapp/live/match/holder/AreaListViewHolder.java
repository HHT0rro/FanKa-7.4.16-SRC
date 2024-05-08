package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.adapter.AreaListAdapter;
import com.cupidapp.live.match.model.RegionModel;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AreaListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AreaListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16784d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final AreaListAdapter f16785c;

    /* compiled from: AreaListViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AreaListViewHolder a(@NotNull ViewGroup parent, @NotNull AreaListAdapter adapter) {
            s.i(parent, "parent");
            s.i(adapter, "adapter");
            return new AreaListViewHolder(z.b(parent, R$layout.view_holder_area_list, false, 2, null), adapter);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaListViewHolder(@NotNull View itemView, @NotNull AreaListAdapter adapter) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(adapter, "adapter");
        this.f16785c = adapter;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof RegionModel) {
            RegionModel regionModel = (RegionModel) obj;
            ((TextView) this.itemView.findViewById(R$id.areaTextView)).setText(regionModel.getName());
            boolean z10 = true;
            Object W = CollectionsKt___CollectionsKt.W(this.f16785c.j(), getAdapterPosition() + 1);
            this.itemView.findViewById(R$id.lineView).setVisibility((W == null || (W instanceof String)) ? 4 : 0);
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.icon_arrow);
            List<RegionModel> regions = regionModel.getRegions();
            if (regions != null && !regions.isEmpty()) {
                z10 = false;
            }
            imageView.setVisibility(z10 ? 8 : 0);
        }
    }
}
