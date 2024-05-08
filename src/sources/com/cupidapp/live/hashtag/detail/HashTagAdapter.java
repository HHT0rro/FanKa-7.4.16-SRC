package com.cupidapp.live.hashtag.detail;

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
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.helper.h;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagAdapter extends MutableColumnRecyclerAdapter {
    public HashTagAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(FeedModel.class);
        k10.add(FKFooterViewModel.class);
        k10.add(FKEmptyViewModel.class);
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
            a10 = HashTagViewHolder.f14695c.a(parent);
        } else if (i10 != 1) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void y() {
        RecyclerExposureHelper g3 = g();
        if (g3 != null) {
            g3.j();
        }
        RecyclerExposureHelper g10 = g();
        if (g10 != null) {
            g10.d();
        }
    }

    public final void z(@NotNull RecyclerView recyclerView, @NotNull ExposureScene scene, @Nullable final FKSensorContext fKSensorContext, @Nullable String str) {
        s.i(recyclerView, "recyclerView");
        s.i(scene, "scene");
        t(new RecyclerExposureHelper(scene, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagAdapter$setExposureHelper$1
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
                String postId;
                SensorPosition sensorPosition2;
                s.i(itemList, "itemList");
                FKSensorContext fKSensorContext2 = FKSensorContext.this;
                for (h1.a aVar : itemList) {
                    Object a10 = aVar.a();
                    if (a10 instanceof FeedModel) {
                        h hVar = h.f14329a;
                        FeedModel feedModel = (FeedModel) a10;
                        String postId2 = feedModel.getPostId();
                        Integer tagId = feedModel.getTagId();
                        UserActionType userActionType = UserActionType.Read;
                        if (fKSensorContext2 == null || (sensorPosition = fKSensorContext2.getPosition()) == null) {
                            sensorPosition = SensorPosition.Unknown;
                        }
                        hVar.e(postId2, tagId, userActionType, sensorPosition, fKSensorContext2 != null ? fKSensorContext2.getSource() : null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : feedModel.getPostStatisticsCallback());
                        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                        String userId = feedModel.getUser().userId();
                        postId = feedModel.getPostId();
                        if (fKSensorContext2 == null || (sensorPosition2 = fKSensorContext2.getPosition()) == null) {
                            sensorPosition2 = SensorPosition.Unknown;
                        }
                        sensorsLogFeed.D(userId, postId, sensorPosition2, fKSensorContext2 != null ? fKSensorContext2.getScene() : null, Boolean.valueOf(feedModel.getUser().getAloha()), feedModel.getUrl(), feedModel.getStrategyId(), p1.g.f52734a.x(), (r31 & 256) != 0 ? null : null, aVar.d() + 1, (r31 & 1024) != 0 ? null : null, (r31 & 2048) != 0 ? null : null, (r31 & 4096) != 0 ? null : null);
                        GroupSocialLog.f18708a.w(SensorScene.Hashtag.getValue(), feedModel.getUser().userId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                    }
                }
            }
        }, 28, null));
    }
}
