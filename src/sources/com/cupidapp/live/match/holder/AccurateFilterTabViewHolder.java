package com.cupidapp.live.match.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.flutter.activity.FlutterMainActivity;
import com.cupidapp.live.flutter.model.PageChannel;
import com.cupidapp.live.flutter.model.PageName;
import com.cupidapp.live.match.activity.AreaListActivity;
import com.cupidapp.live.match.activity.CitiesModel;
import com.cupidapp.live.match.adapter.FKAccurateAdapter;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.model.AccurateFilterUiModel;
import com.cupidapp.live.match.model.LocationItemViewModel;
import com.cupidapp.live.match.model.OpenMapFilterEvent;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.model.RegionModel;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.SensorIconType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.Iterator;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import u0.a;
import z0.z;

/* compiled from: AccurateFilterTabViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AccurateFilterTabViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16778e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16779c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final FKAccurateAdapter f16780d;

    /* compiled from: AccurateFilterTabViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AccurateFilterTabViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new AccurateFilterTabViewHolder(z.b(parent, R$layout.item_filter_advanced, false, 2, null), z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccurateFilterTabViewHolder(@NotNull final View itemView, boolean z10) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16779c = z10;
        FKAccurateAdapter fKAccurateAdapter = new FKAccurateAdapter();
        Map<Integer, Function1<Object, p>> d10 = fKAccurateAdapter.l().d();
        d10.put(Integer.valueOf(R$id.current_city_layout), new Function1<Object, p>() { // from class: com.cupidapp.live.match.holder.AccurateFilterTabViewHolder$matchFilterAdapter$1$1$1
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
                if (obj instanceof LocationItemViewModel) {
                    LocationItemViewModel locationItemViewModel = (LocationItemViewModel) obj;
                    if (locationItemViewModel.getFromNearby()) {
                        return;
                    }
                    locationItemViewModel.setUseRecommendConditionData();
                    AccurateFilterTabViewHolder.this.y();
                }
            }
        });
        d10.put(Integer.valueOf(R$id.roaming_to_other_city_layout), new Function1<Object, p>() { // from class: com.cupidapp.live.match.holder.AccurateFilterTabViewHolder$matchFilterAdapter$1$1$2
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
                boolean v2;
                if (obj instanceof LocationItemViewModel) {
                    LocationItemViewModel locationItemViewModel = (LocationItemViewModel) obj;
                    if (locationItemViewModel.getFromNearby()) {
                        return;
                    }
                    SensorsLogKeyButtonClick.MatchFilter.City.click();
                    v2 = AccurateFilterTabViewHolder.this.v();
                    if (v2) {
                        return;
                    }
                    if (a.f53817a.e()) {
                        FlutterMainActivity.a aVar = FlutterMainActivity.f14650t;
                        Context context = itemView.getContext();
                        s.h(context, "itemView.context");
                        aVar.a(context, SensorPosition.RoamingFlutter, PageName.Roaming, PageChannel.Roaming, null);
                        return;
                    }
                    String string = itemView.getContext().getString(R$string.choose_other_location);
                    s.h(string, "itemView.context.getStri…ng.choose_other_location)");
                    CitiesModel citiesModel = new CitiesModel(string, locationItemViewModel.getHotCities(), locationItemViewModel.getRegions(), false, null, 16, null);
                    Context context2 = itemView.getContext();
                    if (context2 != null) {
                        AreaListActivity.f16481r.b(context2, citiesModel);
                    }
                }
            }
        });
        d10.put(Integer.valueOf(R$id.map_find_cl), new Function1<Object, p>() { // from class: com.cupidapp.live.match.holder.AccurateFilterTabViewHolder$matchFilterAdapter$1$1$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof LocationItemViewModel) {
                    EventBus.c().l(new OpenMapFilterEvent());
                    z3.d.f54832a.y(SensorIconType.FILTER, SensorPosition.MatchFilter);
                }
            }
        });
        this.f16780d = fKAccurateAdapter;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AccurateFilterUiModel) {
            View view = this.itemView;
            int i10 = R$id.recyclerView;
            ((RecyclerView) view.findViewById(i10)).setLayoutManager(new LinearLayoutManager(this.itemView.getContext()));
            ((RecyclerView) this.itemView.findViewById(i10)).setAdapter(this.f16780d);
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) this.itemView.findViewById(i10)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            z((AccurateFilterUiModel) obj);
        }
    }

    public final void t(@Nullable RegionModel regionModel) {
        String str;
        LocationItemViewModel u10 = u();
        if (u10 != null) {
            if (regionModel == null || (str = regionModel.getCode()) == null) {
                str = "";
            }
            u10.setFilterRegion(str);
            u10.setSelectedRegion(regionModel != null ? regionModel.getName() : null);
            String filterRegion = u10.getFilterRegion();
            u10.setUseRecommend(filterRegion == null || filterRegion.length() == 0);
        }
        y();
    }

    public final LocationItemViewModel u() {
        Object obj;
        Iterator<Object> iterator2 = this.f16780d.j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            }
            obj = iterator2.next();
            if (obj instanceof LocationItemViewModel) {
                break;
            }
        }
        return (LocationItemViewModel) obj;
    }

    public final boolean v() {
        User X = g.f52734a.X();
        boolean pro = X != null ? X.getPro() : false;
        if (!this.f16779c || c.f17839a.f() || pro || this.f16780d.u() || !this.f16780d.v()) {
            return false;
        }
        EventBus.c().l(new ShowPurchaseDialogEvent(VipPurchaseEntranceType.Roaming, null, PurchaseProductType.VIP));
        return true;
    }

    public final void w() {
        ((RecyclerView) this.itemView.findViewById(R$id.recyclerView)).setLayoutFrozen(false);
    }

    public final void x() {
        ((RecyclerView) this.itemView.findViewById(R$id.recyclerView)).setLayoutFrozen(true);
    }

    public final void y() {
        Iterator<Object> iterator2 = this.f16780d.j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            } else if (iterator2.next() instanceof LocationItemViewModel) {
                break;
            } else {
                i10++;
            }
        }
        if (this.f16780d.f(i10)) {
            this.f16780d.notifyItemChanged(i10);
        }
    }

    public final void z(AccurateFilterUiModel accurateFilterUiModel) {
        this.f16780d.j().clear();
        this.f16780d.e(accurateFilterUiModel.getList());
        this.f16780d.x(accurateFilterUiModel.getLimitTimeReward(), this.f16779c);
        this.f16780d.notifyDataSetChanged();
    }
}
