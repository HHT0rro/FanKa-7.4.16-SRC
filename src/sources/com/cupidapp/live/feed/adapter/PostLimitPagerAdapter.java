package com.cupidapp.live.feed.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.feed.holder.PostLimitViewHolder;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitPagerAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final FKSensorContext f14188f;

    public PostLimitPagerAdapter(@Nullable FKSensorContext fKSensorContext) {
        this.f14188f = fKSensorContext;
        k().add(PostLimitDetailModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onViewAttachedToWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (holder instanceof PostLimitViewHolder) {
            ((PostLimitViewHolder) holder).r();
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onViewDetachedFromWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof PostLimitViewHolder) {
            ((PostLimitViewHolder) holder).v();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        PostLimitViewHolder a10 = PostLimitViewHolder.f14405d.a(parent, this.f14188f);
        a10.k(l());
        return a10;
    }
}
