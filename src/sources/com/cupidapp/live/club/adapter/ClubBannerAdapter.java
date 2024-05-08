package com.cupidapp.live.club.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.club.model.ClubBannerModel;
import com.cupidapp.live.club.viewholder.ClubBannerItemViewHolder;
import com.cupidapp.live.track.group.GroupOthersLog;
import h1.a;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubBannerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubBannerAdapter extends FKBaseRecyclerViewAdapter {
    public ClubBannerAdapter(@NotNull RecyclerView recyclerView, @NotNull final SensorPosition sensorPosition) {
        s.i(recyclerView, "recyclerView");
        s.i(sensorPosition, "sensorPosition");
        k().add(ClubBannerModel.class);
        t(new RecyclerExposureHelper(ExposureScene.ClubBannerList, recyclerView, 0.0f, 0L, null, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.club.adapter.ClubBannerAdapter.1
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
                s.i(itemList, "itemList");
                SensorPosition sensorPosition2 = SensorPosition.this;
                ClubBannerAdapter clubBannerAdapter = this;
                Iterator<a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof ClubBannerModel) {
                        GroupOthersLog.f18702a.k(sensorPosition2, ((ClubBannerModel) a10).getActId(), Integer.valueOf(clubBannerAdapter.j().indexOf(a10) + 1));
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
        ClubBannerItemViewHolder a10 = ClubBannerItemViewHolder.f13683c.a(parent);
        a10.k(l());
        return a10;
    }
}
