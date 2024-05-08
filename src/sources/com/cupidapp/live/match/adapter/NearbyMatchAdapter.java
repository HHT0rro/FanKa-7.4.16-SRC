package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.holder.NearbyMatchItemViewHolder;
import com.cupidapp.live.match.model.NearMatchModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: NearbyMatchAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyMatchAdapter extends FKBaseRecyclerViewAdapter {
    public NearbyMatchAdapter() {
        k().add(NearMatchModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        NearbyMatchItemViewHolder a10 = NearbyMatchItemViewHolder.f16809e.a(parent);
        a10.k(l());
        return a10;
    }
}
