package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.filter.view.FilterRangeBarLayout;
import com.cupidapp.live.match.activity.AreaListActivity;
import com.cupidapp.live.match.activity.CitiesModel;
import com.cupidapp.live.match.event.ChooseAreaResultEvent;
import com.cupidapp.live.match.model.LocationItemViewModel;
import com.cupidapp.live.match.model.MatchFilterModel;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.match.model.RegionModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CardFilterLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CardFilterLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public List<RangeMatchFilterViewModel> f16846d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public LocationItemViewModel f16847e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16848f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFilterLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16848f = new LinkedHashMap();
        this.f16846d = new ArrayList();
        j();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16848f;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void g(@NotNull LocationItemViewModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        this.f16847e = model;
        k();
    }

    @Nullable
    public final LocationItemViewModel getLocationData() {
        return this.f16847e;
    }

    @NotNull
    public final List<RangeMatchFilterViewModel> getRangeFilterData() {
        return this.f16846d;
    }

    public final void h(@Nullable List<MatchFilterModel> list) {
        ((LinearLayout) e(R$id.card_filter_range_ll)).removeAllViews();
        this.f16846d.clear();
        if (list != null) {
            for (MatchFilterModel matchFilterModel : list) {
                if (matchFilterModel.getType() == MatchFilterModel.MatchFilterType.Range) {
                    LinearLayout linearLayout = (LinearLayout) e(R$id.card_filter_range_ll);
                    Context context = getContext();
                    kotlin.jvm.internal.s.h(context, "context");
                    FilterRangeBarLayout filterRangeBarLayout = new FilterRangeBarLayout(context);
                    RangeMatchFilterViewModel rangeMatchFilterViewModel = new RangeMatchFilterViewModel(matchFilterModel, 0, 0, kotlin.jvm.internal.s.d(matchFilterModel.getKey(), "filterActiveTime"), false, null, 54, null);
                    FilterRangeBarLayout.e(filterRangeBarLayout, rangeMatchFilterViewModel, null, 2, null);
                    this.f16846d.add(rangeMatchFilterViewModel);
                    linearLayout.addView(filterRangeBarLayout);
                }
            }
        }
    }

    public final void i(boolean z10) {
        if (z10) {
            ((ImageView) e(R$id.card_current_city_tick)).setVisibility(0);
            ((ImageView) e(R$id.card_roaming_to_other_city_tick)).setVisibility(4);
            ((TextView) e(R$id.card_roaming_to_city_text)).setText("");
        } else {
            ((ImageView) e(R$id.card_current_city_tick)).setVisibility(4);
            ((ImageView) e(R$id.card_roaming_to_other_city_tick)).setVisibility(0);
        }
    }

    public final void j() {
        z0.z.a(this, R$layout.view_card_filter, true);
        RelativeLayout card_current_city_layout = (RelativeLayout) e(R$id.card_current_city_layout);
        kotlin.jvm.internal.s.h(card_current_city_layout, "card_current_city_layout");
        z0.y.d(card_current_city_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.CardFilterLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                LocationItemViewModel locationItemViewModel;
                locationItemViewModel = CardFilterLayout.this.f16847e;
                if (locationItemViewModel != null) {
                    locationItemViewModel.setUseRecommendConditionData();
                }
                CardFilterLayout.this.k();
            }
        });
        ConstraintLayout card_roaming_to_other_city_layout = (ConstraintLayout) e(R$id.card_roaming_to_other_city_layout);
        kotlin.jvm.internal.s.h(card_roaming_to_other_city_layout, "card_roaming_to_other_city_layout");
        z0.y.d(card_roaming_to_other_city_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.CardFilterLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                LocationItemViewModel locationItemViewModel;
                LocationItemViewModel locationItemViewModel2;
                String string = CardFilterLayout.this.getContext().getString(R$string.choose_other_location);
                kotlin.jvm.internal.s.h(string, "context.getString(R.string.choose_other_location)");
                locationItemViewModel = CardFilterLayout.this.f16847e;
                List<RegionModel> hotCities = locationItemViewModel != null ? locationItemViewModel.getHotCities() : null;
                locationItemViewModel2 = CardFilterLayout.this.f16847e;
                CitiesModel citiesModel = new CitiesModel(string, hotCities, locationItemViewModel2 != null ? locationItemViewModel2.getRegions() : null, false, null, 16, null);
                AreaListActivity.a aVar = AreaListActivity.f16481r;
                Context context = CardFilterLayout.this.getContext();
                kotlin.jvm.internal.s.h(context, "context");
                aVar.b(context, citiesModel);
            }
        });
    }

    public final void k() {
        LocationItemViewModel locationItemViewModel = this.f16847e;
        if (locationItemViewModel != null) {
            i(locationItemViewModel.getUseRecommend());
            if (locationItemViewModel.getUseRecommend()) {
                ((TextView) e(R$id.card_roaming_to_city_text)).setText("");
            } else {
                ((TextView) e(R$id.card_roaming_to_city_text)).setText(locationItemViewModel.getSelectedRegion());
            }
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChooseAreaResultEvent event) {
        String str;
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        LocationItemViewModel locationItemViewModel = this.f16847e;
        if (locationItemViewModel != null) {
            RegionModel region = event.getRegion();
            if (region == null || (str = region.getCode()) == null) {
                str = "";
            }
            locationItemViewModel.setFilterRegion(str);
            RegionModel region2 = event.getRegion();
            locationItemViewModel.setSelectedRegion(region2 != null ? region2.getName() : null);
            String filterRegion = locationItemViewModel.getFilterRegion();
            locationItemViewModel.setUseRecommend(filterRegion == null || filterRegion.length() == 0);
        }
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFilterLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16848f = new LinkedHashMap();
        this.f16846d = new ArrayList();
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFilterLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16848f = new LinkedHashMap();
        this.f16846d = new ArrayList();
        j();
    }
}
