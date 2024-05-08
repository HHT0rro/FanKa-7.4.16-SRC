package com.cupidapp.live.feed.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.feed.holder.PostViewerViewHolder;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PostViewerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostViewerAdapter extends FKBaseRecyclerViewAdapter {
    public PostViewerAdapter() {
        k().add(User.class);
        k().add(FKEmptyViewModel.class);
        k().add(FKFooterViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = PostViewerViewHolder.f14407c.a(parent);
        } else if (i10 != 1) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
