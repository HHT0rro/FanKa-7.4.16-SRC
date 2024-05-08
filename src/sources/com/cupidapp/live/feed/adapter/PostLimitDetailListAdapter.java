package com.cupidapp.live.feed.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.feed.holder.PostLimitDetailListViewHolder;
import com.cupidapp.live.feed.layout.j;
import com.cupidapp.live.feed.layout.p;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitDetailListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDetailListAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final FKSensorContext f14185f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final p f14186g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final j f14187h;

    public PostLimitDetailListAdapter(@Nullable FKSensorContext fKSensorContext, @Nullable p pVar, @NotNull j listener) {
        s.i(listener, "listener");
        this.f14185f = fKSensorContext;
        this.f14186g = pVar;
        this.f14187h = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        PostLimitDetailListViewHolder a10 = PostLimitDetailListViewHolder.f14401f.a(parent, this.f14185f, this.f14186g, this.f14187h);
        a10.k(l());
        return a10;
    }
}
