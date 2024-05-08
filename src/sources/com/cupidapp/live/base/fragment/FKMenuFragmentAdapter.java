package com.cupidapp.live.base.fragment;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKMenuFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMenuFragmentAdapter extends FKBaseRecyclerViewAdapter {
    public FKMenuFragmentAdapter() {
        k().add(FKMenuFragmentItemModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FKMenuFragmentHolder a10 = FKMenuFragmentHolder.f11803c.a(parent);
        a10.k(l());
        return a10;
    }
}
