package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.holder.SearchLocationHistoryViewHolder;
import com.cupidapp.live.match.model.AddressModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SearchHistoryAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchHistoryAdapter extends FKBaseRecyclerViewAdapter {
    public SearchHistoryAdapter() {
        k().add(AddressModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        SearchLocationHistoryViewHolder a10 = SearchLocationHistoryViewHolder.f16820c.a(parent);
        a10.k(l());
        return a10;
    }
}
