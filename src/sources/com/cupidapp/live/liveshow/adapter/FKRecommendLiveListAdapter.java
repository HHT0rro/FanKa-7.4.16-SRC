package com.cupidapp.live.liveshow.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.model.AdModel;
import com.cupidapp.live.liveshow.model.AdViewModel;
import com.cupidapp.live.liveshow.model.LiveCoverTagModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.RedEnvelopeTagModel;
import com.cupidapp.live.liveshow.viewholder.EmptyFollowedUserModel;
import com.cupidapp.live.liveshow.viewholder.FKEmptyFollowedUserLiveViewHolder;
import com.cupidapp.live.liveshow.viewholder.FKFollowOrNearbyUserLiveViewHolder;
import com.cupidapp.live.liveshow.viewholder.FKLiveBannerViewHolder;
import com.cupidapp.live.liveshow.viewholder.FKLiveImageViewHolder;
import com.cupidapp.live.liveshow.viewholder.FKLiveSquareCardModel;
import com.cupidapp.live.liveshow.viewholder.FKLiveSquareCardViewHolder;
import com.cupidapp.live.liveshow.viewholder.FKLiveStreamViewHolder;
import com.cupidapp.live.liveshow.viewholder.FKLiveTitleModel;
import com.cupidapp.live.liveshow.viewholder.FKLiveTitleViewHolder;
import com.cupidapp.live.liveshow.viewholder.FKRecommendLiveListViewHolder;
import com.cupidapp.live.liveshow.viewholder.FKRecommendLiveShowModel;
import com.cupidapp.live.liveshow.viewholder.FollowOrNearbyUserLiveViewModel;
import com.cupidapp.live.liveshow.viewholder.LiveImageModel;
import com.cupidapp.live.liveshow.viewholder.LiveStreamModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.live.LiveProtos;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKRecommendLiveListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKRecommendLiveListAdapter extends MutableColumnRecyclerAdapter {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public SensorPosition f14828g = SensorPosition.Unknown;

    public FKRecommendLiveListAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(AdViewModel.class);
        k10.add(FKRecommendLiveShowModel.class);
        k10.add(FollowOrNearbyUserLiveViewModel.class);
        k10.add(FKLiveSquareCardModel.class);
        k10.add(FKLiveTitleModel.class);
        k10.add(LiveStreamModel.class);
        k10.add(LiveImageModel.class);
        k10.add(EmptyFollowedUserModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof FKRecommendLiveShowModel)) {
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
        switch (i10) {
            case 0:
                a10 = FKLiveBannerViewHolder.f16034h.a(parent, this.f14828g);
                break;
            case 1:
                a10 = FKRecommendLiveListViewHolder.f16053c.a(parent);
                break;
            case 2:
                a10 = FKFollowOrNearbyUserLiveViewHolder.f16032d.a(parent, this.f14828g);
                break;
            case 3:
                a10 = FKLiveSquareCardViewHolder.f16046d.a(parent, this.f14828g);
                break;
            case 4:
                a10 = FKLiveTitleViewHolder.f16052c.a(parent);
                break;
            case 5:
                a10 = FKLiveStreamViewHolder.f16048d.a(parent);
                break;
            case 6:
                a10 = FKLiveImageViewHolder.f16043c.a(parent);
                break;
            case 7:
                a10 = FKEmptyFollowedUserLiveViewHolder.f16031c.a(parent);
                break;
            default:
                a10 = FKFooterViewHolder.f12036c.a(parent);
                break;
        }
        a10.k(l());
        return a10;
    }

    public final void y(@NotNull RecyclerView recyclerView, @NotNull ExposureScene exposureScene, @NotNull final SensorPosition position) {
        s.i(recyclerView, "recyclerView");
        s.i(exposureScene, "exposureScene");
        s.i(position, "position");
        this.f14828g = position;
        t(new RecyclerExposureHelper(exposureScene, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.liveshow.adapter.FKRecommendLiveListAdapter$setExposureHelper$1
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
                Object obj;
                SensorPosition sensorPosition;
                SensorPosition sensorPosition2;
                s.i(itemList, "itemList");
                SensorPosition sensorPosition3 = SensorPosition.this;
                Iterator<h1.a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof FKRecommendLiveShowModel) {
                        FKRecommendLiveShowModel fKRecommendLiveShowModel = (FKRecommendLiveShowModel) a10;
                        LiveShowModel liveShow = fKRecommendLiveShowModel.getLiveShow();
                        SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
                        String itemId = liveShow.getItemId();
                        String userId = liveShow.getUser().userId();
                        SensorScene sensorScene = SensorScene.Live;
                        String viewerCount = liveShow.getViewerCount();
                        Integer anchorPrivilegeType = liveShow.getAnchorPrivilegeType();
                        String strategyId = liveShow.getStrategyId();
                        SensorsLogLiveShow.EnterLiveShowSource enterSource = fKRecommendLiveShowModel.getEnterSource();
                        FKLiveType liveType = liveShow.getLiveType();
                        LiveProtos.CoverType coverType = liveShow.getCoverType();
                        LiveCoverTagModel coverTag = liveShow.getCoverTag();
                        String id2 = coverTag != null ? coverTag.getId() : null;
                        String userType = liveShow.getUserType();
                        Double score = liveShow.getScore();
                        RedEnvelopeTagModel redPacketInfo = liveShow.getRedPacketInfo();
                        obj = a10;
                        sensorPosition = sensorPosition3;
                        sensorsLogLiveShow.o(itemId, userId, sensorPosition3, sensorScene, viewerCount, anchorPrivilegeType, strategyId, enterSource, liveType, coverType, id2, userType, score, redPacketInfo != null ? redPacketInfo.getIconCategory() : null);
                    } else {
                        obj = a10;
                        sensorPosition = sensorPosition3;
                    }
                    boolean z10 = false;
                    if (obj instanceof FKLiveSquareCardModel) {
                        int i10 = 0;
                        for (LiveShowModel liveShowModel : ((FKLiveSquareCardModel) obj).getSquareCardList()) {
                            int i11 = i10 + 1;
                            if (i10 < 0) {
                                kotlin.collections.s.s();
                            }
                            LiveShowModel liveShowModel2 = liveShowModel;
                            SensorsLogLiveShow sensorsLogLiveShow2 = SensorsLogLiveShow.f12212a;
                            String itemId2 = liveShowModel2.getItemId();
                            String userId2 = liveShowModel2.getUser().userId();
                            SensorScene sensorScene2 = SensorScene.Live;
                            String viewerCount2 = liveShowModel2.getViewerCount();
                            Integer anchorPrivilegeType2 = liveShowModel2.getAnchorPrivilegeType();
                            String strategyId2 = liveShowModel2.getStrategyId();
                            SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource = SensorsLogLiveShow.EnterLiveShowSource.LIVE_COMPONENT;
                            FKLiveType liveType2 = liveShowModel2.getLiveType();
                            LiveProtos.CoverType coverType2 = liveShowModel2.getCoverType();
                            LiveCoverTagModel coverTag2 = liveShowModel2.getCoverTag();
                            String id3 = coverTag2 != null ? coverTag2.getId() : null;
                            RedEnvelopeTagModel redPacketInfo2 = liveShowModel2.getRedPacketInfo();
                            sensorsLogLiveShow2.o(itemId2, userId2, sensorPosition, sensorScene2, (r33 & 16) != 0 ? null : viewerCount2, (r33 & 32) != 0 ? null : anchorPrivilegeType2, (r33 & 64) != 0 ? null : strategyId2, (r33 & 128) != 0 ? null : enterLiveShowSource, (r33 & 256) != 0 ? null : liveType2, (r33 & 512) != 0 ? null : coverType2, (r33 & 1024) != 0 ? null : id3, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : redPacketInfo2 != null ? redPacketInfo2.getIconCategory() : null);
                            i10 = i11;
                        }
                    }
                    if (obj instanceof LiveStreamModel) {
                        LiveShowModel liveShow2 = ((LiveStreamModel) obj).getLiveShow();
                        SensorsLogLiveShow sensorsLogLiveShow3 = SensorsLogLiveShow.f12212a;
                        String itemId3 = liveShow2.getItemId();
                        String userId3 = liveShow2.getUser().userId();
                        SensorScene sensorScene3 = SensorScene.Live;
                        String viewerCount3 = liveShow2.getViewerCount();
                        Integer anchorPrivilegeType3 = liveShow2.getAnchorPrivilegeType();
                        String strategyId3 = liveShow2.getStrategyId();
                        SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource2 = SensorsLogLiveShow.EnterLiveShowSource.PUSH_CARD;
                        FKLiveType liveType3 = liveShow2.getLiveType();
                        LiveProtos.CoverType coverType3 = liveShow2.getCoverType();
                        LiveCoverTagModel coverTag3 = liveShow2.getCoverTag();
                        String id4 = coverTag3 != null ? coverTag3.getId() : null;
                        RedEnvelopeTagModel redPacketInfo3 = liveShow2.getRedPacketInfo();
                        sensorsLogLiveShow3.o(itemId3, userId3, sensorPosition, sensorScene3, (r33 & 16) != 0 ? null : viewerCount3, (r33 & 32) != 0 ? null : anchorPrivilegeType3, (r33 & 64) != 0 ? null : strategyId3, (r33 & 128) != 0 ? null : enterLiveShowSource2, (r33 & 256) != 0 ? null : liveType3, (r33 & 512) != 0 ? null : coverType3, (r33 & 1024) != 0 ? null : id4, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : redPacketInfo3 != null ? redPacketInfo3.getIconCategory() : null);
                    }
                    if (obj instanceof LiveImageModel) {
                        LiveImageModel liveImageModel = (LiveImageModel) obj;
                        sensorPosition2 = sensorPosition;
                        SensorsLogFeed.f12208a.g(liveImageModel.getUrl(), liveImageModel.getBannerId(), sensorPosition2);
                    } else {
                        sensorPosition2 = sensorPosition;
                    }
                    if (obj instanceof AdViewModel) {
                        AdModel adModel = (AdModel) CollectionsKt___CollectionsKt.V(((AdViewModel) obj).getList());
                        String itemId4 = adModel != null ? adModel.getItemId() : null;
                        if (itemId4 != null) {
                            if (itemId4.length() > 0) {
                                z10 = true;
                            }
                        }
                        if (z10) {
                            GroupOthersLog.f18702a.k(sensorPosition2, itemId4, 1);
                        }
                    }
                    sensorPosition3 = sensorPosition2;
                }
            }
        }, 28, null));
    }
}
