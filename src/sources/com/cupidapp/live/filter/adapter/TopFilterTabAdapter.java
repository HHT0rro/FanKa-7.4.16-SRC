package com.cupidapp.live.filter.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.filter.model.FilterTopTabUiBaseModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: TopFilterTabAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TopFilterTabAdapter extends FKBaseRecyclerViewAdapter {
    public TopFilterTabAdapter() {
        k().add(FilterTopTabUiBaseModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        TopFilterViewHolder a10 = TopFilterViewHolder.f14615c.a(parent);
        a10.k(l());
        return a10;
    }
}
