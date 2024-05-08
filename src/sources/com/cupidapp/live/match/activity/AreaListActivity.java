package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.match.adapter.AreaListAdapter;
import com.cupidapp.live.match.event.ChooseAreaResultEvent;
import com.cupidapp.live.match.model.CurrentSelectCityUiModel;
import com.cupidapp.live.match.model.ExposureEntranceModel;
import com.cupidapp.live.match.model.HotViewModel;
import com.cupidapp.live.match.model.RegionModel;
import com.cupidapp.live.match.model.TitleViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AreaListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AreaListActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f16481r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16482q = new LinkedHashMap();

    /* compiled from: AreaListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FKBaseActivity activity, @NotNull CitiesModel citiesModel, int i10) {
            kotlin.jvm.internal.s.i(activity, "activity");
            kotlin.jvm.internal.s.i(citiesModel, "citiesModel");
            Intent intent = new Intent(activity, (Class<?>) AreaListActivity.class);
            z0.g.c(intent, citiesModel);
            activity.startActivityForResult(intent, i10);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, activity, 0, 0, 6, null);
        }

        public final void b(@NotNull Context context, @NotNull CitiesModel citiesModel) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(citiesModel, "citiesModel");
            Intent intent = new Intent(context, (Class<?>) AreaListActivity.class);
            z0.g.c(intent, citiesModel);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16482q;
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

    public final void n1(RegionModel regionModel) {
        List<RegionModel> regions = regionModel.getRegions();
        if (regions == null || regions.isEmpty()) {
            EventBus.c().o(new ChooseAreaResultEvent(regionModel));
            setResult(-1);
            finish();
            return;
        }
        f16481r.a(this, new CitiesModel(regionModel.getName(), null, regionModel.getRegions(), true, null, 16, null), 331);
    }

    public final void o1(CitiesModel citiesModel) {
        FKTitleBarLayout initView$lambda$5 = (FKTitleBarLayout) j1(R$id.titleBar);
        kotlin.jvm.internal.s.h(initView$lambda$5, "initView$lambda$5");
        FKTitleBarLayout.setSingleTitle$default(initView$lambda$5, citiesModel != null ? citiesModel.getTitle() : null, null, 2, null);
        initView$lambda$5.setLeftImageVisible(true);
        initView$lambda$5.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.AreaListActivity$initView$1$1
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
                AreaListActivity.this.finish();
            }
        });
        ((RecyclerView) j1(R$id.recyclerView)).setLayoutManager(new LinearLayoutManager(this));
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        if (-1 == i11 && i10 == 331) {
            finish();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_area_list);
        AreaListAdapter areaListAdapter = new AreaListAdapter(new Function1<RegionModel, kotlin.p>() { // from class: com.cupidapp.live.match.activity.AreaListActivity$onCreate$areaListAdapter$1
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RegionModel it) {
                kotlin.jvm.internal.s.i(it, "it");
                AreaListActivity.this.n1(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(RegionModel regionModel) {
                invoke2(regionModel);
                return kotlin.p.f51048a;
            }
        });
        areaListAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.AreaListActivity$onCreate$areaListAdapter$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof RegionModel) {
                    AreaListActivity.this.n1((RegionModel) obj);
                } else if (obj instanceof CurrentSelectCityUiModel) {
                    AreaListActivity.this.q1();
                } else if (obj instanceof ExposureEntranceModel) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, AreaListActivity.this, ((ExposureEntranceModel) obj).getTravelH5Url(), null, 4, null);
                }
            }
        });
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        CitiesModel citiesModel = (CitiesModel) z0.g.a(intent, CitiesModel.class);
        o1(citiesModel);
        p1(citiesModel, areaListAdapter);
    }

    public final void p1(final CitiesModel citiesModel, final AreaListAdapter areaListAdapter) {
        if (citiesModel != null && citiesModel.getSubCity()) {
            r1(citiesModel, areaListAdapter);
            return;
        }
        Disposable disposed = NetworkClient.f11868a.N().Q0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ExposureEntranceModel, kotlin.p>() { // from class: com.cupidapp.live.match.activity.AreaListActivity$loadData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ExposureEntranceModel exposureEntranceModel) {
                m2697invoke(exposureEntranceModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2697invoke(ExposureEntranceModel exposureEntranceModel) {
                ExposureEntranceModel exposureEntranceModel2 = exposureEntranceModel;
                if (exposureEntranceModel2.getTravelH5Url() != null) {
                    AreaListAdapter.this.j().add(exposureEntranceModel2);
                }
                this.r1(citiesModel, AreaListAdapter.this);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.activity.AreaListActivity$loadData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                AreaListActivity.this.r1(citiesModel, areaListAdapter);
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void q1() {
        EventBus.c().o(new ChooseAreaResultEvent(null));
        setResult(-1);
        finish();
    }

    public final void r1(CitiesModel citiesModel, AreaListAdapter areaListAdapter) {
        RegionModel selectRegion = citiesModel != null ? citiesModel.getSelectRegion() : null;
        if (selectRegion != null) {
            List<Object> j10 = areaListAdapter.j();
            String string = getString(R$string.current_select);
            kotlin.jvm.internal.s.h(string, "getString(R.string.current_select)");
            j10.add(new CurrentSelectCityUiModel(string, selectRegion));
        }
        List<RegionModel> hotCities = citiesModel != null ? citiesModel.getHotCities() : null;
        if (!(hotCities == null || hotCities.isEmpty())) {
            List<Object> j11 = areaListAdapter.j();
            String string2 = getString(R$string.hot_city);
            kotlin.jvm.internal.s.h(string2, "getString(R.string.hot_city)");
            j11.add(new HotViewModel(string2, hotCities));
        }
        List<RegionModel> regions = citiesModel != null ? citiesModel.getRegions() : null;
        if (citiesModel != null && citiesModel.getSubCity()) {
            j1(R$id.divider_line).setVisibility(0);
            if (regions != null) {
                areaListAdapter.j().addAll(regions);
            }
        } else {
            j1(R$id.divider_line).setVisibility(8);
            if (regions != null) {
                for (RegionModel regionModel : regions) {
                    areaListAdapter.j().add(new TitleViewModel(regionModel.getName(), false, null, false, 12, null));
                    List<RegionModel> regions2 = regionModel.getRegions();
                    if (regions2 != null) {
                        areaListAdapter.j().addAll(regions2);
                    }
                }
            }
        }
        ((RecyclerView) j1(R$id.recyclerView)).setAdapter(areaListAdapter);
    }
}
