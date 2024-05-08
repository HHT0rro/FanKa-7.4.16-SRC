package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.holder.AreaListViewHolder;
import com.cupidapp.live.match.holder.AreaTitleViewHolder;
import com.cupidapp.live.match.holder.CurrentSelectCityViewHolder;
import com.cupidapp.live.match.holder.ExposureEntranceViewHolder;
import com.cupidapp.live.match.holder.HotAreaViewHolder;
import com.cupidapp.live.match.model.CurrentSelectCityUiModel;
import com.cupidapp.live.match.model.ExposureEntranceModel;
import com.cupidapp.live.match.model.HotViewModel;
import com.cupidapp.live.match.model.RegionModel;
import com.cupidapp.live.match.model.TitleViewModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: AreaListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AreaListAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Function1<RegionModel, p> f16616f;

    /* JADX WARN: Multi-variable type inference failed */
    public AreaListAdapter(@NotNull Function1<? super RegionModel, p> clickCallback) {
        s.i(clickCallback, "clickCallback");
        this.f16616f = clickCallback;
        k().add(CurrentSelectCityUiModel.class);
        k().add(HotViewModel.class);
        k().add(TitleViewModel.class);
        k().add(ExposureEntranceModel.class);
        k().add(RegionModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = CurrentSelectCityViewHolder.f16788c.a(parent);
        } else if (i10 == 1) {
            a10 = HotAreaViewHolder.f16798d.a(parent, this.f16616f);
        } else if (i10 == 2) {
            a10 = AreaTitleViewHolder.f16786c.a(parent);
        } else if (i10 != 3) {
            a10 = AreaListViewHolder.f16784d.a(parent, this);
        } else {
            a10 = ExposureEntranceViewHolder.f16789c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
