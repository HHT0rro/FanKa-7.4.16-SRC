package com.cupidapp.live.feed.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.helper.h;
import com.cupidapp.live.feed.holder.AdBannerViewHolder;
import com.cupidapp.live.feed.holder.AdTagPostUiModel;
import com.cupidapp.live.feed.holder.AdTagPostViewHolder;
import com.cupidapp.live.feed.holder.FeedClassifyListModel;
import com.cupidapp.live.feed.holder.FeedClassifyViewHolder;
import com.cupidapp.live.feed.holder.RecommendFeedViewHolder;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.liveshow.model.AdViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import h1.a;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: RecommendFeedAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RecommendFeedAdapter extends MutableColumnRecyclerAdapter {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final FeedSensorContext f14190g;

    public RecommendFeedAdapter(@NotNull FeedSensorContext sensorContext) {
        s.i(sensorContext, "sensorContext");
        this.f14190g = sensorContext;
        List<Class<? extends Object>> k10 = k();
        k10.add(AdTagPostUiModel.class);
        k10.add(AdViewModel.class);
        k10.add(FeedClassifyListModel.class);
        k10.add(FeedRecommendResult.class);
        k10.add(FKFooterViewModel.class);
        k10.add(FKEmptyViewModel.class);
    }

    public static /* synthetic */ void A(RecommendFeedAdapter recommendFeedAdapter, RecyclerView recyclerView, ExposureScene exposureScene, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        recommendFeedAdapter.z(recyclerView, exposureScene, str, str2);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 < 0 || (j().get(i10) instanceof FeedRecommendResult) || (j().get(i10) instanceof AdTagPostUiModel)) {
            return 1;
        }
        return v();
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 2;
    }

    @NotNull
    public final FeedSensorContext x() {
        return this.f14190g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = AdTagPostViewHolder.f14364c.a(parent);
        } else if (i10 == 1) {
            a10 = AdBannerViewHolder.f14355h.a(parent, this.f14190g.getPosition());
            a10.q();
        } else if (i10 == 2) {
            a10 = FeedClassifyViewHolder.f14375d.a(parent);
        } else if (i10 == 3) {
            a10 = RecommendFeedViewHolder.f14413c.a(parent);
        } else if (i10 != 4) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void z(@NotNull RecyclerView recyclerView, @NotNull ExposureScene scene, @Nullable final String str, @Nullable final String str2) {
        s.i(recyclerView, "recyclerView");
        s.i(scene, "scene");
        t(new RecyclerExposureHelper(scene, recyclerView, 0.0f, 0L, str, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.feed.adapter.RecommendFeedAdapter$setExposureHelper$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> itemList) {
                Iterator<a> iterator2;
                String str3;
                String str4;
                s.i(itemList, "itemList");
                RecommendFeedAdapter recommendFeedAdapter = RecommendFeedAdapter.this;
                String str5 = str2;
                String str6 = str;
                for (a aVar : itemList) {
                    Object a10 = aVar.a();
                    if (a10 instanceof FeedRecommendResult) {
                        FeedRecommendResult feedRecommendResult = (FeedRecommendResult) a10;
                        FeedModel post = feedRecommendResult.getPost();
                        if (post != null) {
                            h hVar = h.f14329a;
                            String postId = post.getPostId();
                            Integer tagId = post.getTagId();
                            UserActionType userActionType = UserActionType.Read;
                            SensorPosition position = recommendFeedAdapter.x().getPosition();
                            SensorPosition source = recommendFeedAdapter.x().getSource();
                            String callback = feedRecommendResult.getCallback();
                            if (callback == null) {
                                callback = post.getPostStatisticsCallback();
                            }
                            hVar.e(postId, tagId, userActionType, position, source, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : callback);
                            str3 = str6;
                            str4 = str5;
                            SensorsLogFeed.f12208a.D(post.getUser().userId(), post.getPostId(), recommendFeedAdapter.x().getPosition(), recommendFeedAdapter.x().getScene(), Boolean.valueOf(post.getUser().getAloha()), post.getUrl(), post.getStrategyId(), g.f52734a.x(), (r31 & 256) != 0 ? null : str5, aVar.d() + 1, (r31 & 1024) != 0 ? null : Boolean.valueOf(post.isPostBoostSpread()), (r31 & 2048) != 0 ? null : null, (r31 & 4096) != 0 ? null : str3);
                        } else {
                            str3 = str6;
                            str4 = str5;
                        }
                    } else {
                        str3 = str6;
                        str4 = str5;
                        if (a10 instanceof AdTagPostUiModel) {
                            GroupOthersLog.f18702a.b(null, ((AdTagPostUiModel) a10).getJumpUrl(), "RECOMMEND_FEED_SUGAR");
                        }
                    }
                    str6 = str3;
                    str5 = str4;
                }
            }
        }, 12, null));
    }
}
