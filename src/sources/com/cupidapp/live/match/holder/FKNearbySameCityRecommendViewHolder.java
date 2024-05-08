package com.cupidapp.live.match.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.decoration.MediaGridInset;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.adapter.NearbyRecommendAdapter;
import com.cupidapp.live.match.model.NearbySameCityRecommendViewModel;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import h1.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKNearbySameCityRecommendViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKNearbySameCityRecommendViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16793d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f16794c;

    /* compiled from: FKNearbySameCityRecommendViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKNearbySameCityRecommendViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKNearbySameCityRecommendViewHolder(z.b(parent, R$layout.view_holder_nearby_same_city_recommend, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNearbySameCityRecommendViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16794c = c.b(new Function0<NearbyRecommendAdapter>() { // from class: com.cupidapp.live.match.holder.FKNearbySameCityRecommendViewHolder$nearbyRecommendAdapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NearbyRecommendAdapter invoke() {
                NearbyRecommendAdapter nearbyRecommendAdapter = new NearbyRecommendAdapter();
                final View view = View.this;
                final FKNearbySameCityRecommendViewHolder fKNearbySameCityRecommendViewHolder = this;
                nearbyRecommendAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.match.holder.FKNearbySameCityRecommendViewHolder$nearbyRecommendAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (obj instanceof NearbyUserModel) {
                            NearByMiniProfileActivity.a aVar = NearByMiniProfileActivity.f16517r;
                            Context context = View.this.getContext();
                            NearbyUserModel nearbyUserModel = (NearbyUserModel) obj;
                            SensorScene sensorScene = SensorScene.NearbySameCityRecommend;
                            NearbySameCityRecommendViewModel nearbySameCityRecommendViewModel = (NearbySameCityRecommendViewModel) fKNearbySameCityRecommendViewHolder.o();
                            NearByMiniProfileActivity.a.b(aVar, context, nearbyUserModel, sensorScene, nearbySameCityRecommendViewModel != null ? nearbySameCityRecommendViewModel.isUsingMap() : false, null, false, null, SensorPosition.Nearby, null, null, false, SecExceptionCode.SEC_ERROR_GENERIC_AVMP_LOW_VERISON_JPG, null);
                            GroupSocialLog.f18708a.u(sensorScene.getValue(), nearbyUserModel.getId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                        }
                    }
                });
                return nearbyRecommendAdapter;
            }
        });
        RecyclerView _init_$lambda$0 = (RecyclerView) itemView.findViewById(R$id.nearbyRecommendRecyclerView);
        _init_$lambda$0.setAdapter(r());
        _init_$lambda$0.setLayoutManager(new GridLayoutManager(itemView.getContext(), 3, 0, false));
        s.h(_init_$lambda$0, "_init_$lambda$0");
        _init_$lambda$0.addItemDecoration(new MediaGridInset(h.c(_init_$lambda$0, 1.0f), false));
        r().t(new RecyclerExposureHelper(ExposureScene.NearbySameCityRecommend, _init_$lambda$0, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.match.holder.FKNearbySameCityRecommendViewHolder$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> list) {
                s.i(list, "list");
                Iterator<a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof NearbyUserModel) {
                        NearbyUserModel nearbyUserModel = (NearbyUserModel) a10;
                        if (!nearbyUserModel.getHide()) {
                            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                            String value = SensorScene.NearbySameCityRecommend.getValue();
                            String id2 = nearbyUserModel.getId();
                            String travelCity = nearbyUserModel.getTravelCity();
                            boolean z10 = false;
                            if (travelCity != null) {
                                if (travelCity.length() > 0) {
                                    z10 = true;
                                }
                            }
                            groupSocialLog.w(value, id2, (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : z10);
                        }
                    }
                }
            }
        }, 28, null));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NearbySameCityRecommendViewModel) {
            ((TextView) this.itemView.findViewById(R$id.sameCityRecommend)).getPaint().setFakeBoldText(true);
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) this.itemView.findViewById(R$id.nearbyRecommendRecyclerView)).getLayoutManager();
            GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
            if (gridLayoutManager != null) {
                gridLayoutManager.setSpanCount(((NearbySameCityRecommendViewModel) obj).getSameCityUserList().size());
            }
            r().j().clear();
            Iterator<List<NearbyUserModel>> iterator2 = ((NearbySameCityRecommendViewModel) obj).getSameCityUserList().iterator2();
            while (iterator2.hasNext()) {
                r().e(iterator2.next());
            }
            r().notifyDataSetChanged();
        }
    }

    public final NearbyRecommendAdapter r() {
        return (NearbyRecommendAdapter) this.f16794c.getValue();
    }
}
