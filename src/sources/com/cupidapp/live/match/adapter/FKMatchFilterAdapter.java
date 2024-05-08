package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.match.holder.CityFilterItemViewHolder;
import com.cupidapp.live.match.holder.LocationItemViewHolder;
import com.cupidapp.live.match.holder.MulSelectFilterViewHolder;
import com.cupidapp.live.match.holder.RangeMatchFilterViewHolder;
import com.cupidapp.live.match.holder.SettingStyleTitleViewHolder;
import com.cupidapp.live.match.holder.SuperVipTitleViewHolder;
import com.cupidapp.live.match.holder.TipFilterViewHolder;
import com.cupidapp.live.match.model.CityFilterModel;
import com.cupidapp.live.match.model.LocationItemViewModel;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.match.model.SuperFilterModel;
import com.cupidapp.live.match.model.SuperVipTitleUiModel;
import com.cupidapp.live.match.model.TipModel;
import com.cupidapp.live.match.model.TitleViewModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKMatchFilterAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchFilterAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    public boolean f16621f;

    public FKMatchFilterAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(TitleViewModel.class);
        k10.add(LocationItemViewModel.class);
        k10.add(CityFilterModel.class);
        k10.add(RangeMatchFilterViewModel.class);
        k10.add(SuperFilterModel.class);
        k10.add(SuperVipTitleUiModel.class);
        k10.add(TipModel.class);
        k10.add(FKFooterViewModel.class);
    }

    public final boolean u() {
        return this.f16621f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        switch (i10) {
            case 0:
                a10 = SettingStyleTitleViewHolder.f16822c.a(parent);
                break;
            case 1:
                a10 = LocationItemViewHolder.f16803c.a(parent);
                break;
            case 2:
                a10 = CityFilterItemViewHolder.f16787c.a(parent);
                break;
            case 3:
                a10 = RangeMatchFilterViewHolder.f16814e.a(parent, this.f16621f, true);
                break;
            case 4:
                a10 = MulSelectFilterViewHolder.f16807c.a(parent);
                break;
            case 5:
                a10 = SuperVipTitleViewHolder.f16823c.a(parent);
                break;
            case 6:
                a10 = TipFilterViewHolder.f16825c.a(parent);
                break;
            default:
                a10 = FKFooterViewHolder.f12036c.a(parent);
                break;
        }
        a10.k(l());
        return a10;
    }
}
