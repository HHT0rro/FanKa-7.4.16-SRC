package com.cupidapp.live.liveshow.fanclub.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKFanClubForAnchorAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubForAnchorAdapter extends FKBaseRecyclerViewAdapter {
    public FKFanClubForAnchorAdapter() {
        k().add(FKTaskProgressModel.class);
        k().add(FKClubMemberModel.class);
        k().add(FKEmptyViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        if (i10 == 0) {
            return FKFanClubTaskProgressViewHolder.f14958d.a(parent);
        }
        if (i10 != 1) {
            return FKEmptyListViewHolder.f12034c.a(parent);
        }
        return FKClubMemberViewHolder.f14954d.a(parent);
    }
}
