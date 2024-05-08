package com.cupidapp.live.notify.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKBlankSpaceViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKBlankSpaceModel;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.notify.model.DailyHeartModel;
import com.cupidapp.live.notify.viewholder.DailyHeartViewHolder;
import com.cupidapp.live.notify.viewholder.NotifyTopTitleUiModel;
import com.cupidapp.live.notify.viewholder.NotifyTopTitleViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: DailyHeartAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DailyHeartAdapter extends MutableColumnRecyclerAdapter {
    public DailyHeartAdapter() {
        k().add(NotifyTopTitleUiModel.class);
        k().add(DailyHeartModel.class);
        k().add(FKBlankSpaceModel.class);
        k().add(FKEmptyViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof DailyHeartModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = NotifyTopTitleViewHolder.f17577c.a(parent);
        } else if (i10 == 1) {
            a10 = DailyHeartViewHolder.f17574c.a(parent);
        } else if (i10 != 2) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = FKBlankSpaceViewHolder.f12032c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
