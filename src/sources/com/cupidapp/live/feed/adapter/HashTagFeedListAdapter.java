package com.cupidapp.live.feed.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.feed.holder.HashTagFeedViewHolder;
import com.cupidapp.live.feed.holder.HashTagHeadViewHolder;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.hashtag.model.HashTag;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: HashTagFeedListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagFeedListAdapter extends MutableColumnRecyclerAdapter {
    public HashTagFeedListAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(HashTag.class);
        k10.add(FeedModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onViewAttachedToWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (holder instanceof HashTagHeadViewHolder) {
            Object V = CollectionsKt___CollectionsKt.V(j());
            if (V instanceof HashTag) {
                HashTag hashTag = (HashTag) V;
                if (hashTag.getBackgroundImage() != null) {
                    ((HashTagHeadViewHolder) holder).t(hashTag.getPresetImageKey(), hashTag.getBackgroundImage());
                }
            }
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onViewDetachedFromWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof HashTagHeadViewHolder) {
            ((HashTagHeadViewHolder) holder).u();
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof FeedModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = HashTagHeadViewHolder.f14395c.a(parent);
        } else if (i10 != 1) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = HashTagFeedViewHolder.f14394d.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
