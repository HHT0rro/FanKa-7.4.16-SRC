package com.cupidapp.live.visitors.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.visitors.model.FootmarkModel;
import com.cupidapp.live.visitors.viewholder.FootMarkEmptyModel;
import com.cupidapp.live.visitors.viewholder.FootMarkEmptyViewHolder;
import com.cupidapp.live.visitors.viewholder.FootmarkViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FootmarkAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FootmarkAdapter extends FKBaseRecyclerViewAdapter {
    public FootmarkAdapter() {
        k().add(FootmarkModel.class);
        k().add(FootMarkEmptyModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FootmarkViewHolder.f18963c.a(parent);
        } else {
            a10 = FootMarkEmptyViewHolder.f18962c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
