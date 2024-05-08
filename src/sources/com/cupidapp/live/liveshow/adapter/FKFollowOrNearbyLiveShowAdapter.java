package com.cupidapp.live.liveshow.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.RedEnvelopeTagModel;
import com.irisdt.client.live.LiveProtos;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKFollowOrNearbyLiveShowAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFollowOrNearbyLiveShowAdapter extends FKBaseRecyclerViewAdapter {
    public FKFollowOrNearbyLiveShowAdapter(@NotNull RecyclerView recyclerView, @NotNull final SensorPosition position) {
        s.i(recyclerView, "recyclerView");
        s.i(position, "position");
        t(new RecyclerExposureHelper(ExposureScene.LiveNearbyOrFollow, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.liveshow.adapter.FKFollowOrNearbyLiveShowAdapter.1
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
                SensorPosition sensorPosition;
                s.i(itemList, "itemList");
                SensorPosition sensorPosition2 = SensorPosition.this;
                Iterator<h1.a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof FKFollowOrNearbyLiveShowModel) {
                        FKFollowOrNearbyLiveShowModel fKFollowOrNearbyLiveShowModel = (FKFollowOrNearbyLiveShowModel) a10;
                        LiveShowModel liveShow = fKFollowOrNearbyLiveShowModel.getLiveShow();
                        SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
                        String itemId = liveShow.getItemId();
                        String userId = liveShow.getUser().userId();
                        SensorScene sensorScene = SensorScene.Live;
                        String viewerCount = liveShow.getViewerCount();
                        Integer anchorPrivilegeType = liveShow.getAnchorPrivilegeType();
                        String strategyId = liveShow.getStrategyId();
                        SensorsLogLiveShow.EnterLiveShowSource enterSource = fKFollowOrNearbyLiveShowModel.getEnterSource();
                        FKLiveType liveType = liveShow.getLiveType();
                        LiveProtos.CoverType coverType = liveShow.getCoverType();
                        RedEnvelopeTagModel redPacketInfo = liveShow.getRedPacketInfo();
                        sensorPosition = sensorPosition2;
                        sensorsLogLiveShow.o(itemId, userId, sensorPosition2, sensorScene, (r33 & 16) != 0 ? null : viewerCount, (r33 & 32) != 0 ? null : anchorPrivilegeType, (r33 & 64) != 0 ? null : strategyId, (r33 & 128) != 0 ? null : enterSource, (r33 & 256) != 0 ? null : liveType, (r33 & 512) != 0 ? null : coverType, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : redPacketInfo != null ? redPacketInfo.getIconCategory() : null);
                    } else {
                        sensorPosition = sensorPosition2;
                    }
                    sensorPosition2 = sensorPosition;
                }
            }
        }, 28, null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FKLiveUserAvatarViewHolder a10 = FKLiveUserAvatarViewHolder.f14827c.a(parent);
        a10.k(l());
        return a10;
    }
}
