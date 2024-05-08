package com.cupidapp.live.liveshow.pk.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PkAnchorListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PkAnchorListAdapter extends FKBaseRecyclerViewAdapter {
    public PkAnchorListAdapter() {
        k().add(MultiPkAnchorModel.class);
        k().add(LivePkEmptyListModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = PkAnchorListViewHolder.f15108c.a(parent);
        } else {
            a10 = FKLivePkEmptyListViewHolder.f15106c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
