package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.match.holder.LocationItemViewHolder;
import com.cupidapp.live.match.holder.MatchFilterTitleViewHolder;
import com.cupidapp.live.match.holder.RangeMatchFilterViewHolder;
import com.cupidapp.live.match.model.FilterTitleModel;
import com.cupidapp.live.match.model.LocationItemViewModel;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKAccurateAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKAccurateAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    public boolean f16617f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16618g = true;

    public FKAccurateAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(FilterTitleModel.class);
        k10.add(LocationItemViewModel.class);
        k10.add(RangeMatchFilterViewModel.class);
        k10.add(FKFooterViewModel.class);
    }

    public final boolean u() {
        return this.f16617f;
    }

    public final boolean v() {
        return this.f16618g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = MatchFilterTitleViewHolder.f16805c.a(parent);
        } else if (i10 == 1) {
            a10 = LocationItemViewHolder.f16803c.a(parent);
        } else if (i10 != 2) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = RangeMatchFilterViewHolder.f16814e.a(parent, this.f16617f, this.f16618g);
        }
        a10.k(l());
        return a10;
    }

    public final void x(boolean z10, boolean z11) {
        this.f16617f = z10;
        this.f16618g = z11;
    }
}
