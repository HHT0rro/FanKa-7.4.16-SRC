package com.cupidapp.live.feed.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedRainbowRecommendAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRainbowRecommendAdapter extends FKBaseRecyclerViewAdapter {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FeedRainbowRecommendItemViewHolder a10 = FeedRainbowRecommendItemViewHolder.f14184c.a(parent);
        a10.k(l());
        return a10;
    }
}