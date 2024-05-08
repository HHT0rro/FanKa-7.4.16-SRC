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
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.RedEnvelopeTagModel;
import com.cupidapp.live.liveshow.viewholder.FKBaseLiveListViewHolder;
import com.irisdt.client.live.LiveProtos;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKBaseLiveListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKBaseLiveListAdapter extends MutableColumnRecyclerAdapter {
    public FKBaseLiveListAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(LiveShowModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof LiveShowModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FKBaseLiveListViewHolder.f16030c.a(parent);
        } else {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void y(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        t(new RecyclerExposureHelper(ExposureScene.LiveNearby, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.liveshow.adapter.FKBaseLiveListAdapter$setExposureHelper$1
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
                        SensorPosition sensorPosition = SensorPosition.LiveNearby;
                        SensorScene sensorScene = SensorScene.Live;
                        String viewerCount = liveShowModel.getViewerCount();
                        Integer anchorPrivilegeType = liveShowModel.getAnchorPrivilegeType();
                        String strategyId = liveShowModel.getStrategyId();
                        SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource = SensorsLogLiveShow.EnterLiveShowSource.LIVE_NEARBY;
                        FKLiveType liveType = liveShowModel.getLiveType();
                        LiveProtos.CoverType coverType = liveShowModel.getCoverType();
                        RedEnvelopeTagModel redPacketInfo = liveShowModel.getRedPacketInfo();
                        sensorsLogLiveShow.o(itemId, userId, sensorPosition, sensorScene, (r33 & 16) != 0 ? null : viewerCount, (r33 & 32) != 0 ? null : anchorPrivilegeType, (r33 & 64) != 0 ? null : strategyId, (r33 & 128) != 0 ? null : enterLiveShowSource, (r33 & 256) != 0 ? null : liveType, (r33 & 512) != 0 ? null : coverType, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : redPacketInfo != null ? redPacketInfo.getIconCategory() : null);
                    }
                }
            }
        }, 28, null));
    }
}
