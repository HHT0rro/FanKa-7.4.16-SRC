package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.setting.holder.OrderManagementViewHolder;
import com.cupidapp.live.setting.model.OrderManagementResult;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: OrderManagementAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OrderManagementAdapter extends FKBaseRecyclerViewAdapter {
    public OrderManagementAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(OrderManagementResult.class);
        k10.add(FKEmptyViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = OrderManagementViewHolder.f18190c.a(parent);
        } else {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
