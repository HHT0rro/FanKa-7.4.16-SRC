package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.holder.AccurateFilterTabViewHolder;
import com.cupidapp.live.match.holder.AdvancedFilterTabViewHolder;
import com.cupidapp.live.match.holder.OptionFilterTabViewHolder;
import com.cupidapp.live.match.model.AccurateFilterUiModel;
import com.cupidapp.live.match.model.AdvanceFilterUiModel;
import com.cupidapp.live.match.model.OptionFilterUiModel;
import com.cupidapp.live.match.model.RegionModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterViewPagerAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f16634f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public AdvancedFilterTabViewHolder f16635g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public AccurateFilterTabViewHolder f16636h;

    public MatchFilterViewPagerAdapter(boolean z10) {
        this.f16634f = z10;
        k().add(AccurateFilterUiModel.class);
        k().add(AdvanceFilterUiModel.class);
        k().add(OptionFilterUiModel.class);
    }

    public final void u(@Nullable RegionModel regionModel) {
        AccurateFilterTabViewHolder accurateFilterTabViewHolder = this.f16636h;
        if (accurateFilterTabViewHolder != null) {
            accurateFilterTabViewHolder.t(regionModel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        if (i10 == 0) {
            AccurateFilterTabViewHolder a10 = AccurateFilterTabViewHolder.f16778e.a(parent, this.f16634f);
            this.f16636h = a10;
            s.f(a10);
            return a10;
        }
        if (i10 != 1) {
            return OptionFilterTabViewHolder.f16812d.a(parent, this.f16634f);
        }
        AdvancedFilterTabViewHolder a11 = AdvancedFilterTabViewHolder.f16781e.a(parent, this.f16634f);
        this.f16635g = a11;
        s.f(a11);
        return a11;
    }

    public final void w() {
        AccurateFilterTabViewHolder accurateFilterTabViewHolder = this.f16636h;
        if (accurateFilterTabViewHolder != null) {
            accurateFilterTabViewHolder.w();
        }
    }

    public final void x() {
        AccurateFilterTabViewHolder accurateFilterTabViewHolder = this.f16636h;
        if (accurateFilterTabViewHolder != null) {
            accurateFilterTabViewHolder.x();
        }
    }

    public final void y(@Nullable String str) {
        AdvancedFilterTabViewHolder advancedFilterTabViewHolder = this.f16635g;
        if (advancedFilterTabViewHolder != null) {
            advancedFilterTabViewHolder.w(str);
        }
    }
}
