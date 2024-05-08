package com.cupidapp.live.profile.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.profile.holder.FeedLikedUserUiModel;
import com.cupidapp.live.profile.holder.FeedLikedUserViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedLikedUserListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedLikedUserListAdapter extends MutableColumnRecyclerAdapter {
    public FeedLikedUserListAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(FeedLikedUserUiModel.class);
        k10.add(FKEmptyViewModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof FeedLikedUserUiModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FeedLikedUserViewHolder.f17806c.a(parent);
        } else if (i10 != 1) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}