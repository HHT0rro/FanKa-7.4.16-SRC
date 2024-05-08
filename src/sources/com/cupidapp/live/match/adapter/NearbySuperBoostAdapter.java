package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.NearbyListModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: NearbySuperBoostAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbySuperBoostAdapter extends FKBaseRecyclerViewAdapter {
    public NearbySuperBoostAdapter() {
        k().add(NearbySuperBoostEntranceModel.class);
        k().add(NearbyListModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = NearbySuperBoostEntranceViewHolder.f16637c.a(parent);
        } else {
            a10 = NearbySuperBoostItemViewHolder.f16638c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
