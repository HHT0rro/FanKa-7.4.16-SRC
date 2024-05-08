package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.network.model.NewUserTaskModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.holder.UserTasksViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserTasksAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserTasksAdapter extends FKBaseRecyclerViewAdapter {
    public UserTasksAdapter() {
        k().add(NewUserTaskModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        UserTasksViewHolder a10 = UserTasksViewHolder.f18198c.a(parent);
        a10.k(l());
        return a10;
    }
}
