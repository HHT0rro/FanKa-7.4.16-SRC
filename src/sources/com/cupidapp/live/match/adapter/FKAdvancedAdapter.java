package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.match.holder.FilterOptionViewHolder;
import com.cupidapp.live.match.holder.IntelligentFilterNewViewHolder;
import com.cupidapp.live.match.holder.MatchFilterTitleViewHolder;
import com.cupidapp.live.match.holder.UserTypeViewHolder;
import com.cupidapp.live.match.model.FilterTitleModel;
import com.cupidapp.live.match.model.IntelligentFilterUiModel;
import com.cupidapp.live.match.model.SuperFilterOptionModel;
import com.cupidapp.live.match.model.UserTypeModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKAdvancedAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKAdvancedAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    public boolean f16619f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16620g = true;

    public FKAdvancedAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(FilterTitleModel.class);
        k10.add(IntelligentFilterUiModel.class);
        k10.add(UserTypeModel.class);
        k10.add(SuperFilterOptionModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = MatchFilterTitleViewHolder.f16805c.a(parent);
        } else if (i10 == 1) {
            a10 = IntelligentFilterNewViewHolder.f16800d.a(parent, this.f16620g);
        } else if (i10 == 2) {
            a10 = UserTypeViewHolder.f16828d.a(parent, this.f16620g);
        } else if (i10 != 3) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = FilterOptionViewHolder.f16796d.a(parent, this.f16620g);
        }
        a10.k(l());
        return a10;
    }

    public final void v(boolean z10, boolean z11) {
        this.f16619f = z10;
        this.f16620g = z11;
    }

    public final void w(@Nullable List<String> list) {
        int size = j().size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = j().get(i10);
            if (obj instanceof IntelligentFilterUiModel) {
                ((IntelligentFilterUiModel) obj).setMatchKeywords(list);
                notifyItemChanged(i10);
                return;
            }
        }
    }
}
