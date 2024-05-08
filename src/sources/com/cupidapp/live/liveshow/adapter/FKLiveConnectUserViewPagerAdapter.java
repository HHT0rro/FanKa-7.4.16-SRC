package com.cupidapp.live.liveshow.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveConnectUserViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveConnectUserViewPagerAdapter extends MutableColumnRecyclerAdapter {
    public FKLiveConnectUserViewPagerAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(FKLiveRequestViewModel.class);
        k10.add(FKEmptyViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof FKLiveRequestViewModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FKLiveConnectUserViewHolder.f14811c.a(parent);
        } else {
            a10 = FKLiveConnectUserEmptyViewHolder.f14810c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
