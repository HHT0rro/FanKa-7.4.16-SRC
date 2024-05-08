package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.match.holder.UnlockDailyHeartTitleViewHolder;
import com.cupidapp.live.match.holder.UnlockDailyHeartViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UnlockDailyHeartAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnlockDailyHeartAdapter extends MutableColumnRecyclerAdapter {
    public UnlockDailyHeartAdapter() {
        k().add(UnlockDailyHeartTitleModel.class);
        k().add(DailyUnLockModel.class);
        k().add(FKEmptyViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof DailyUnLockModel)) {
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
            a10 = UnlockDailyHeartTitleViewHolder.f16826c.a(parent);
        } else if (i10 != 1) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = UnlockDailyHeartViewHolder.f16827c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
