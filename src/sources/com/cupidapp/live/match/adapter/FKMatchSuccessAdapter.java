package com.cupidapp.live.match.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.holder.MatchSuccessViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKMatchSuccessAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchSuccessAdapter extends FKBaseRecyclerViewAdapter {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        return MatchSuccessViewHolder.f16806c.a(parent);
    }
}