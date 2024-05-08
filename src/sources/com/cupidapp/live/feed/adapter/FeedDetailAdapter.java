package com.cupidapp.live.feed.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.feed.holder.CommentTitleViewHolder;
import com.cupidapp.live.feed.holder.FeedDetailCommentTitleModel;
import com.cupidapp.live.feed.holder.FeedDetailCommentViewHolder;
import com.cupidapp.live.feed.holder.FeedDetailCommentViewModel;
import com.cupidapp.live.feed.holder.FeedDetailNoCommentModel;
import com.cupidapp.live.feed.holder.FeedDetailPraiseListViewHolder;
import com.cupidapp.live.feed.holder.FeedDetailPraiseListViewModel;
import com.cupidapp.live.feed.holder.FeedDetailShowMoreCommentViewHolder;
import com.cupidapp.live.feed.holder.FeedDetailShowMoreCommentViewModel;
import com.cupidapp.live.feed.holder.FeedDetailViewHolder;
import com.cupidapp.live.feed.holder.FeedRcmdDivideViewHolder;
import com.cupidapp.live.feed.holder.NoCommentViewHolder;
import com.cupidapp.live.feed.holder.b;
import com.cupidapp.live.feed.holder.c;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRcmdDivideUiModel;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedDetailAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final b f14177f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final c f14178g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public FeedSensorContext f14179h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public Map<String, ? extends Object> f14180i;

    public FeedDetailAdapter(@NotNull b feedPraiseListener, @NotNull c baseFeedListener) {
        s.i(feedPraiseListener, "feedPraiseListener");
        s.i(baseFeedListener, "baseFeedListener");
        this.f14177f = feedPraiseListener;
        this.f14178g = baseFeedListener;
        List<Class<? extends Object>> k10 = k();
        k10.add(FeedModel.class);
        k10.add(FeedDetailPraiseListViewModel.class);
        k10.add(FeedDetailCommentTitleModel.class);
        k10.add(FeedDetailCommentViewModel.class);
        k10.add(FeedDetailShowMoreCommentViewModel.class);
        k10.add(FeedDetailNoCommentModel.class);
        k10.add(FeedRcmdDivideUiModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        switch (i10) {
            case 0:
                a10 = FeedDetailViewHolder.f14382j.a(parent, this.f14177f, this.f14178g, this.f14179h, this.f14180i);
                break;
            case 1:
                a10 = FeedDetailPraiseListViewHolder.f14380c.a(parent);
                break;
            case 2:
                a10 = CommentTitleViewHolder.f14373c.a(parent);
                break;
            case 3:
                a10 = FeedDetailCommentViewHolder.f14377d.a(parent, j());
                break;
            case 4:
                a10 = FeedDetailShowMoreCommentViewHolder.f14381c.a(parent);
                break;
            case 5:
                a10 = NoCommentViewHolder.f14400c.a(parent);
                break;
            case 6:
                a10 = FeedRcmdDivideViewHolder.f14388c.a(parent);
                break;
            default:
                a10 = FKFooterViewHolder.f12036c.a(parent);
                break;
        }
        a10.k(l());
        return a10;
    }

    public final void v(@Nullable FeedSensorContext feedSensorContext, @Nullable Map<String, ? extends Object> map) {
        this.f14179h = feedSensorContext;
        this.f14180i = map;
    }
}
