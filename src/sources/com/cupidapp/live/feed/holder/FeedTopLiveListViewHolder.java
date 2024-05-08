package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.feed.holder.FeedTopLiveListViewHolder;
import com.cupidapp.live.feed.layout.FeedTopRcmdLiveLayout;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.activity.LiveshowOpenSource;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.FeedTopLiveModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.RedEnvelopeTagModel;
import com.cupidapp.live.setting.helper.PersonalizedRecommendHelper;
import com.irisdt.client.live.LiveProtos;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedTopLiveListViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTopLiveListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f14392d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f14393c;

    /* compiled from: FeedTopLiveListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class FeedTopLiveItemAdapter extends FKBaseRecyclerViewAdapter {
        public FeedTopLiveItemAdapter(@NotNull RecyclerView recyclerView) {
            s.i(recyclerView, "recyclerView");
            t(new RecyclerExposureHelper(ExposureScene.FeedRecommendLive, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.feed.holder.FeedTopLiveListViewHolder.FeedTopLiveItemAdapter.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(List<? extends h1.a> list) {
                    invoke2((List<h1.a>) list);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<h1.a> itemList) {
                    s.i(itemList, "itemList");
                    Iterator<h1.a> iterator2 = itemList.iterator2();
                    while (iterator2.hasNext()) {
                        Object a10 = iterator2.next().a();
                        if (a10 instanceof LiveShowModel) {
                            SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
                            LiveShowModel liveShowModel = (LiveShowModel) a10;
                            String itemId = liveShowModel.getItemId();
                            String userId = liveShowModel.getUser().userId();
                            SensorPosition sensorPosition = SensorPosition.Feed;
                            SensorScene sensorScene = SensorScene.Feed;
                            String viewerCount = liveShowModel.getViewerCount();
                            Integer anchorPrivilegeType = liveShowModel.getAnchorPrivilegeType();
                            String strategyId = liveShowModel.getStrategyId();
                            SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource = SensorsLogLiveShow.EnterLiveShowSource.FOLLOWING_LIST;
                            FKLiveType liveType = liveShowModel.getLiveType();
                            LiveProtos.CoverType coverType = liveShowModel.getCoverType();
                            RedEnvelopeTagModel redPacketInfo = liveShowModel.getRedPacketInfo();
                            sensorsLogLiveShow.o(itemId, userId, sensorPosition, sensorScene, (r33 & 16) != 0 ? null : viewerCount, (r33 & 32) != 0 ? null : anchorPrivilegeType, (r33 & 64) != 0 ? null : strategyId, (r33 & 128) != 0 ? null : enterLiveShowSource, (r33 & 256) != 0 ? null : liveType, (r33 & 512) != 0 ? null : coverType, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : redPacketInfo != null ? redPacketInfo.getIconCategory() : null);
                        }
                    }
                }
            }, 28, null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
            s.i(parent, "parent");
            FeedTopLiveItemViewHolder a10 = FeedTopLiveItemViewHolder.f14391c.a(parent);
            a10.k(l());
            return a10;
        }
    }

    /* compiled from: FeedTopLiveListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedTopLiveListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedTopLiveListViewHolder(z.b(parent, R$layout.view_holder_feed_top_live_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTopLiveListViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f14393c = kotlin.c.b(new Function0<FeedTopLiveItemAdapter>() { // from class: com.cupidapp.live.feed.holder.FeedTopLiveListViewHolder$feedTopLiveListAdapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedTopLiveListViewHolder.FeedTopLiveItemAdapter invoke() {
                RecyclerView recyclerView = (RecyclerView) View.this.findViewById(R$id.feedTopLiveRecyclerView);
                s.h(recyclerView, "itemView.feedTopLiveRecyclerView");
                FeedTopLiveListViewHolder.FeedTopLiveItemAdapter feedTopLiveItemAdapter = new FeedTopLiveListViewHolder.FeedTopLiveItemAdapter(recyclerView);
                final FeedTopLiveListViewHolder feedTopLiveListViewHolder = this;
                feedTopLiveItemAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.FeedTopLiveListViewHolder$feedTopLiveListAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof LiveShowModel) {
                            FeedTopLiveListViewHolder.this.t((LiveShowModel) obj);
                        }
                    }
                });
                return feedTopLiveItemAdapter;
            }
        });
        RecyclerView _init_$lambda$0 = (RecyclerView) itemView.findViewById(R$id.feedTopLiveRecyclerView);
        _init_$lambda$0.setAdapter(s());
        _init_$lambda$0.setLayoutManager(new LinearLayoutManager(_init_$lambda$0.getContext(), 0, false));
        s.h(_init_$lambda$0, "_init_$lambda$0");
        int c4 = z0.h.c(_init_$lambda$0, 5.0f);
        _init_$lambda$0.addItemDecoration(new ExtraSpacingDecoration(c4, 0, c4, 0, c4));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedTopLiveModel) {
            ((TextView) this.itemView.findViewById(R$id.feed_top_live_title)).setText(this.itemView.getContext().getString(PersonalizedRecommendHelper.f18179a.a()));
            FeedTopLiveModel feedTopLiveModel = (FeedTopLiveModel) obj;
            if (feedTopLiveModel.getUseNewUi()) {
                View view = this.itemView;
                int i10 = R$id.feedTopLiveLl;
                ((FeedTopRcmdLiveLayout) view.findViewById(i10)).setVisibility(0);
                ((RecyclerView) this.itemView.findViewById(R$id.feedTopLiveRecyclerView)).setVisibility(8);
                ((FeedTopRcmdLiveLayout) this.itemView.findViewById(i10)).j(feedTopLiveModel.getList(), new Function1<LiveShowModel, p>() { // from class: com.cupidapp.live.feed.holder.FeedTopLiveListViewHolder$config$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(LiveShowModel liveShowModel) {
                        invoke2(liveShowModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull LiveShowModel it) {
                        s.i(it, "it");
                        FeedTopLiveListViewHolder.this.t(it);
                    }
                });
                return;
            }
            ((FeedTopRcmdLiveLayout) this.itemView.findViewById(R$id.feedTopLiveLl)).setVisibility(8);
            ((RecyclerView) this.itemView.findViewById(R$id.feedTopLiveRecyclerView)).setVisibility(0);
            s().j().clear();
            s().e(feedTopLiveModel.getList());
            s().notifyDataSetChanged();
        }
    }

    public final FeedTopLiveItemAdapter s() {
        return (FeedTopLiveItemAdapter) this.f14393c.getValue();
    }

    public final void t(LiveShowModel liveShowModel) {
        FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, this.itemView.getContext(), new FKLiveForViewerViewModel(liveShowModel, LiveshowOpenSource.Follow, new LiveInRoomSensorModel("FOLLOWING_LIST", null, SensorScene.Feed, SensorPosition.Feed, null, null, 48, null), false, 8, null), false, 4, null);
    }

    public final void u() {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) this.itemView.findViewById(R$id.scroll_root);
        if (horizontalScrollView != null) {
            horizontalScrollView.scrollTo(0, 0);
        }
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R$id.feedTopLiveRecyclerView);
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }
}
