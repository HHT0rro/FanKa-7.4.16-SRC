package com.cupidapp.live.feed.holder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.SubRecyclerview;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendListModel;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.feed.model.ShowMoreModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: RecommendFeedEnterListViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RecommendFeedEnterListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f14409f = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final FeedSensorContext f14410c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final b f14411d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f14412e;

    /* compiled from: RecommendFeedEnterListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class FeedRecommendEnterItemAdapter extends FKBaseRecyclerViewAdapter {
        public FeedRecommendEnterItemAdapter(@NotNull RecyclerView recyclerView, @NotNull final FeedSensorContext sensorContext) {
            s.i(recyclerView, "recyclerView");
            s.i(sensorContext, "sensorContext");
            t(new RecyclerExposureHelper(ExposureScene.RecommendFeedEnter, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.FeedRecommendEnterItemAdapter.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(List<? extends h1.a> list) {
                    invoke2((List<h1.a>) list);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<h1.a> itemList) {
                    FeedRecommendResult feedRecommendResult;
                    FeedModel post;
                    s.i(itemList, "itemList");
                    FeedSensorContext feedSensorContext = FeedSensorContext.this;
                    for (h1.a aVar : itemList) {
                        Object a10 = aVar.a();
                        if ((a10 instanceof FeedRecommendResult) && (post = (feedRecommendResult = (FeedRecommendResult) a10).getPost()) != null) {
                            SensorPosition position = feedSensorContext.getPosition();
                            if (!TextUtils.isEmpty(post.getStrategyId())) {
                                position = SensorPosition.RecommendFeed;
                            }
                            SensorPosition sensorPosition = position;
                            com.cupidapp.live.feed.helper.h hVar = com.cupidapp.live.feed.helper.h.f14329a;
                            String postId = post.getPostId();
                            Integer tagId = post.getTagId();
                            UserActionType userActionType = UserActionType.Read;
                            SensorPosition source = feedSensorContext.getSource();
                            Integer valueOf = Integer.valueOf(aVar.d() + 1);
                            String callback = feedRecommendResult.getCallback();
                            if (callback == null) {
                                callback = post.getPostStatisticsCallback();
                            }
                            hVar.e(postId, tagId, userActionType, sensorPosition, source, valueOf, callback);
                            SensorsLogFeed.f12208a.D(post.getUser().userId(), post.getPostId(), feedSensorContext.getPosition(), feedSensorContext.getScene(), Boolean.valueOf(post.getUser().getAloha()), post.getUrl(), post.getStrategyId(), p1.g.f52734a.x(), (r31 & 256) != 0 ? null : null, aVar.d() + 1, (r31 & 1024) != 0 ? null : null, (r31 & 2048) != 0 ? null : null, (r31 & 4096) != 0 ? null : null);
                        }
                    }
                }
            }, 28, null));
            List<Class<? extends Object>> k10 = k();
            k10.add(FeedRecommendResult.class);
            k10.add(ShowMoreModel.class);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
            FKBaseRecyclerViewHolder a10;
            s.i(parent, "parent");
            if (i10 == 0) {
                a10 = FeedRecommendEnterItemViewHolder.f14389c.a(parent);
            } else {
                a10 = ShowMoreViewHolder.f14414c.a(parent);
            }
            a10.k(l());
            return a10;
        }

        public final void v() {
            RecyclerExposureHelper g3 = g();
            if (g3 != null) {
                g3.j();
            }
            RecyclerExposureHelper g10 = g();
            if (g10 != null) {
                g10.d();
            }
        }
    }

    /* compiled from: RecommendFeedEnterListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecommendFeedEnterListViewHolder a(@NotNull ViewGroup parent, @NotNull FeedSensorContext sensorContext, @Nullable b bVar) {
            s.i(parent, "parent");
            s.i(sensorContext, "sensorContext");
            RecommendFeedEnterListViewHolder recommendFeedEnterListViewHolder = new RecommendFeedEnterListViewHolder(z.b(parent, R$layout.view_holder_feed_recommend_list, false, 2, null), sensorContext, bVar);
            SubRecyclerview creator$lambda$1$lambda$0 = (SubRecyclerview) recommendFeedEnterListViewHolder.itemView.findViewById(R$id.feedRecommendRecyclerView);
            creator$lambda$1$lambda$0.setAdapter(recommendFeedEnterListViewHolder.u());
            creator$lambda$1$lambda$0.setLayoutManager(new LinearLayoutManager(creator$lambda$1$lambda$0.getContext(), 0, false));
            s.h(creator$lambda$1$lambda$0, "creator$lambda$1$lambda$0");
            creator$lambda$1$lambda$0.addItemDecoration(new ExtraSpacingDecoration(z0.h.c(creator$lambda$1$lambda$0, 4.0f), 0, 0, 0, z0.h.c(creator$lambda$1$lambda$0, 7.0f), 0));
            ConstantsResult q10 = p1.g.f52734a.q();
            if (q10 != null && q10.showRecommendTab()) {
                ((TextView) recommendFeedEnterListViewHolder.itemView.findViewById(R$id.feedRecommendMore)).setVisibility(0);
            } else {
                ((TextView) recommendFeedEnterListViewHolder.itemView.findViewById(R$id.feedRecommendMore)).setVisibility(8);
            }
            return recommendFeedEnterListViewHolder;
        }
    }

    /* compiled from: RecommendFeedEnterListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void H0(@NotNull FeedRecommendResult feedRecommendResult, boolean z10, @NotNull FeedSensorContext feedSensorContext);

        void m0(@NotNull FeedRecommendResult feedRecommendResult, @NotNull FeedSensorContext feedSensorContext);

        void y();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendFeedEnterListViewHolder(@NotNull final View itemView, @NotNull FeedSensorContext sensorContext, @Nullable b bVar) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(sensorContext, "sensorContext");
        this.f14410c = sensorContext;
        this.f14411d = bVar;
        this.f14412e = kotlin.c.b(new Function0<FeedRecommendEnterItemAdapter>() { // from class: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$feedRecommendListAdapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RecommendFeedEnterListViewHolder.FeedRecommendEnterItemAdapter invoke() {
                FeedSensorContext feedSensorContext;
                SubRecyclerview subRecyclerview = (SubRecyclerview) View.this.findViewById(R$id.feedRecommendRecyclerView);
                s.h(subRecyclerview, "itemView.feedRecommendRecyclerView");
                feedSensorContext = this.f14410c;
                RecommendFeedEnterListViewHolder.FeedRecommendEnterItemAdapter feedRecommendEnterItemAdapter = new RecommendFeedEnterListViewHolder.FeedRecommendEnterItemAdapter(subRecyclerview, feedSensorContext);
                final RecommendFeedEnterListViewHolder recommendFeedEnterListViewHolder = this;
                feedRecommendEnterItemAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.enterCoverImageView), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$feedRecommendListAdapter$2$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r3 = r1.f14411d;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r2, int r3) {
                        /*
                            r1 = this;
                            boolean r3 = r2 instanceof com.cupidapp.live.feed.model.FeedRecommendResult
                            if (r3 == 0) goto L17
                            com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder r3 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.this
                            com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$b r3 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.r(r3)
                            if (r3 == 0) goto L17
                            com.cupidapp.live.feed.model.FeedRecommendResult r2 = (com.cupidapp.live.feed.model.FeedRecommendResult) r2
                            com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder r0 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.this
                            com.cupidapp.live.base.sensorslog.FeedSensorContext r0 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.t(r0)
                            r3.m0(r2, r0)
                        L17:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$feedRecommendListAdapter$2$1$1.invoke(java.lang.Object, int):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.linkcountTxt), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$feedRecommendListAdapter$2$1$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i10) {
                        RecommendFeedEnterListViewHolder.b bVar2;
                        FeedSensorContext feedSensorContext2;
                        RecommendFeedEnterListViewHolder.b bVar3;
                        FeedSensorContext feedSensorContext3;
                        if (obj instanceof FeedRecommendResult) {
                            FeedRecommendResult feedRecommendResult = (FeedRecommendResult) obj;
                            if (feedRecommendResult.getPost() != null) {
                                RecommendFeedEnterListViewHolder recommendFeedEnterListViewHolder2 = RecommendFeedEnterListViewHolder.this;
                                if (feedRecommendResult.getPost().getLiked()) {
                                    bVar3 = recommendFeedEnterListViewHolder2.f14411d;
                                    if (bVar3 != null) {
                                        feedSensorContext3 = recommendFeedEnterListViewHolder2.f14410c;
                                        bVar3.H0(feedRecommendResult, false, feedSensorContext3);
                                        return;
                                    }
                                    return;
                                }
                                bVar2 = recommendFeedEnterListViewHolder2.f14411d;
                                if (bVar2 != null) {
                                    feedSensorContext2 = recommendFeedEnterListViewHolder2.f14410c;
                                    bVar2.H0(feedRecommendResult, true, feedSensorContext2);
                                }
                            }
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.showMoreTxt), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$feedRecommendListAdapter$2$1$3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r1 = r1.f14411d;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r1, int r2) {
                        /*
                            r0 = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.feed.model.ShowMoreModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder r1 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.this
                            com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$b r1 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.r(r1)
                            if (r1 == 0) goto Lf
                            r1.y()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$feedRecommendListAdapter$2$1$3.invoke(java.lang.Object, int):void");
                    }
                })));
                feedRecommendEnterItemAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$feedRecommendListAdapter$2$1$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f14411d;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
                        /*
                            r2 = this;
                            boolean r0 = r3 instanceof com.cupidapp.live.feed.model.FeedRecommendResult
                            if (r0 == 0) goto L17
                            com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder r0 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.this
                            com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$b r0 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.r(r0)
                            if (r0 == 0) goto L17
                            com.cupidapp.live.feed.model.FeedRecommendResult r3 = (com.cupidapp.live.feed.model.FeedRecommendResult) r3
                            com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder r1 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.this
                            com.cupidapp.live.base.sensorslog.FeedSensorContext r1 = com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.t(r1)
                            r0.m0(r3, r1)
                        L17:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder$feedRecommendListAdapter$2$1$4.invoke2(java.lang.Object):void");
                    }
                });
                return feedRecommendEnterItemAdapter;
            }
        });
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedRecommendListModel) {
            u().j().clear();
            FeedRecommendEnterItemAdapter u10 = u();
            List<FeedRecommendResult> list = ((FeedRecommendListModel) obj).getList();
            ArrayList arrayList = new ArrayList();
            Iterator<FeedRecommendResult> iterator2 = list.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                FeedRecommendResult next = iterator2.next();
                if (next.getPost() != null) {
                    arrayList.add(next);
                }
            }
            u10.e(arrayList);
            ConstantsResult q10 = p1.g.f52734a.q();
            if (q10 != null && q10.showRecommendTab()) {
                FeedRecommendEnterItemAdapter u11 = u();
                String string = this.itemView.getContext().getString(R$string.slip_show_more);
                s.h(string, "itemView.context.getStri…(R.string.slip_show_more)");
                u11.d(new ShowMoreModel(string));
            }
            u().notifyDataSetChanged();
        }
    }

    public final FeedRecommendEnterItemAdapter u() {
        return (FeedRecommendEnterItemAdapter) this.f14412e.getValue();
    }

    public final void v() {
        u().notifyDataSetChanged();
    }

    public final void w() {
        u().v();
    }

    public final void x() {
        ((SubRecyclerview) this.itemView.findViewById(R$id.feedRecommendRecyclerView)).scrollToPosition(0);
    }
}
