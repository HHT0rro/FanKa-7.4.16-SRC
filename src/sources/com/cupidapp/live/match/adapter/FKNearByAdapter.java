package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.match.holder.FKNearbyLocationFailedViewHolder;
import com.cupidapp.live.match.holder.FKNearbyNoBodyViewHolder;
import com.cupidapp.live.match.holder.FKNearbySameCityRecommendViewHolder;
import com.cupidapp.live.match.holder.FKNearbyUserViewHolder;
import com.cupidapp.live.match.model.NearbyListModel;
import com.cupidapp.live.match.model.NearbyLocationFailedViewModel;
import com.cupidapp.live.match.model.NearbyNoBodyViewModel;
import com.cupidapp.live.match.model.NearbySameCityRecommendViewModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKNearByAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKNearByAdapter extends MutableColumnRecyclerAdapter {
    public FKNearByAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(NearbyListModel.class);
        k10.add(NearbyNoBodyViewModel.class);
        k10.add(NearbySameCityRecommendViewModel.class);
        k10.add(FKFooterViewModel.class);
        k10.add(NearbyLocationFailedViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 < 0 || i10 >= j().size() || (j().get(i10) instanceof NearbyListModel)) {
            return 1;
        }
        return v();
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FKNearbyUserViewHolder.f16795c.a(parent);
        } else if (i10 == 1) {
            a10 = FKNearbyNoBodyViewHolder.f16791c.a(parent);
        } else if (i10 == 2) {
            a10 = FKNearbySameCityRecommendViewHolder.f16793d.a(parent);
        } else if (i10 != 3) {
            a10 = FKNearbyLocationFailedViewHolder.f16790c.a(parent);
        } else {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
