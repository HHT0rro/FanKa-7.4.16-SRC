package com.cupidapp.live.profile.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKTitleModel;
import com.cupidapp.live.profile.holder.FocusUserViewHolder;
import com.cupidapp.live.profile.holder.UserManagerTitleViewHolder;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FocusUserManageAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FocusUserManageAdapter extends FKBaseRecyclerViewAdapter {
    public FocusUserManageAdapter() {
        k().add(FKTitleModel.class);
        k().add(User.class);
        k().add(FKEmptyViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = UserManagerTitleViewHolder.f17835c.a(parent);
        } else if (i10 != 1) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = FocusUserViewHolder.f17807c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
