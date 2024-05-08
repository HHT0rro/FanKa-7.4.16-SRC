package com.cupidapp.live.profile.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.network.model.InnerFunctionModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKDecorationViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKDecorationModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.profile.holder.InnerFunctionViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: InnerFunctionAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class InnerFunctionAdapter extends FKBaseRecyclerViewAdapter {
    public InnerFunctionAdapter() {
        k().add(InnerFunctionModel.class);
        k().add(FKDecorationModel.class);
        k().add(FKFooterViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = InnerFunctionViewHolder.f17811c.a(parent);
        } else if (i10 != 1) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = FKDecorationViewHolder.f12033c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
