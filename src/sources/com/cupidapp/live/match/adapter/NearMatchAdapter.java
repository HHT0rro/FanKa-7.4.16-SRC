package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.match.holder.NearMatchViewHolder;
import com.cupidapp.live.match.model.NearMatchModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: NearMatchAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearMatchAdapter extends FKBaseRecyclerViewAdapter {
    public NearMatchAdapter() {
        k().add(NearMatchModel.class);
        k().add(FKEmptyViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = NearMatchViewHolder.f16808c.a(parent);
        } else {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
