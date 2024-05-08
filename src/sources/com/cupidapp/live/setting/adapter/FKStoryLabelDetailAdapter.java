package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelDetailAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelDetailAdapter extends FKBaseRecyclerViewAdapter {
    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter
    public void m(@Nullable List<? extends Object> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        j().clear();
        e(list);
        notifyItemRangeChanged(0, j().size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        return FKStoryLabelDetailItemViewHolder.f18086e.a(parent, j().size());
    }
}
