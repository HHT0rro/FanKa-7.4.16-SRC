package com.cupidapp.live.liveshow.pk.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LivePkUserModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLivePkFriendListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkFriendListAdapter extends FKBaseRecyclerViewAdapter {
    public FKLivePkFriendListAdapter() {
        k().add(LivePkEmptyListModel.class);
        k().add(LivePkUserModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        if (i10 == 0) {
            return FKLivePkEmptyListViewHolder.f15106c.a(parent);
        }
        FKLivePkFriendListViewHolder a10 = FKLivePkFriendListViewHolder.f15107c.a(parent);
        a10.k(l());
        return a10;
    }
}
