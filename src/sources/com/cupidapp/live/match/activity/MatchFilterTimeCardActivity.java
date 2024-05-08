package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.RewardDetailModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.match.model.LocationItemViewModel;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.match.view.CardFilterLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.vip.model.VipDiscountAndMatchSettingResult;
import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import com.huawei.openalliance.ad.constant.as;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterTimeCardActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterTimeCardActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f16512u = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public String f16515s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16516t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16513q = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$taskId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String stringExtra = MatchFilterTimeCardActivity.this.getIntent().getStringExtra(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16514r = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$taskType$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String stringExtra = MatchFilterTimeCardActivity.this.getIntent().getStringExtra("task_type");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* compiled from: MatchFilterTimeCardActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull String taskId, @Nullable String str) {
            kotlin.jvm.internal.s.i(taskId, "taskId");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) MatchFilterTimeCardActivity.class);
            intent.putExtra(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, taskId);
            intent.putExtra("task_type", str);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anmi_stop);
        }
    }

    public static final void A1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final ObservableSource H1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public static final Result x1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    public static final VipDiscountAndMatchSettingResult y1(Result vipDiscount, Result matchSetting) {
        kotlin.jvm.internal.s.i(vipDiscount, "vipDiscount");
        kotlin.jvm.internal.s.i(matchSetting, "matchSetting");
        return new VipDiscountAndMatchSettingResult((VipDiscountDescriptionResult) vipDiscount.getData(), (MatchSettingResult) matchSetting.getData());
    }

    public static final void z1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final String B1() {
        return (String) this.f16513q.getValue();
    }

    public final String C1() {
        return (String) this.f16514r.getValue();
    }

    public final void D1() {
        x2.a N = NetworkClient.f11868a.N();
        String taskId = B1();
        kotlin.jvm.internal.s.h(taskId, "taskId");
        Disposable disposed = N.o0(taskId, C1()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<RewardDetailModel, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$initReward$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(RewardDetailModel rewardDetailModel) {
                m2698invoke(rewardDetailModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2698invoke(RewardDetailModel rewardDetailModel) {
                RewardDetailModel rewardDetailModel2 = rewardDetailModel;
                ImageLoaderView task_reward_img = (ImageLoaderView) MatchFilterTimeCardActivity.this.o1(R$id.task_reward_img);
                kotlin.jvm.internal.s.h(task_reward_img, "task_reward_img");
                ImageLoaderView.g(task_reward_img, rewardDetailModel2.getIcon(), null, null, 6, null);
                ((TextView) MatchFilterTimeCardActivity.this.o1(R$id.task_reward_name)).setText(rewardDetailModel2.getTitle());
                ((TextView) MatchFilterTimeCardActivity.this.o1(R$id.task_reward_des)).setText(rewardDetailModel2.getDesc());
                ((TextView) MatchFilterTimeCardActivity.this.o1(R$id.task_reward_expire_txt)).setText(rewardDetailModel2.getValidTime());
                MatchFilterTimeCardActivity.this.f16515s = rewardDetailModel2.getJumpUrl();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void E1() {
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.not_set_filter), R$string.continue_setting, null, null, 6, null).q(R$string.get_now, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$showNotChangeDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MatchFilterTimeCardActivity.this.G1();
            }
        }), null, 1, null);
    }

    public final void F1() {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int i10 = R$id.card_filter_layout;
        LocationItemViewModel locationData = ((CardFilterLayout) o1(i10)).getLocationData();
        String selectedRegion = locationData != null ? locationData.getSelectedRegion() : null;
        if (selectedRegion == null || selectedRegion.length() == 0) {
            selectedRegion = getString(R$string.current_city);
            kotlin.jvm.internal.s.h(selectedRegion, "getString(R.string.current_city)");
        }
        String str = selectedRegion;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        for (RangeMatchFilterViewModel rangeMatchFilterViewModel : ((CardFilterLayout) o1(i10)).getRangeFilterData()) {
            String name = rangeMatchFilterViewModel.getMatchFilterModel().getName();
            if (kotlin.jvm.internal.s.d(name, getString(R$string.age))) {
                str2 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
            } else if (kotlin.jvm.internal.s.d(name, getString(R$string.active_time))) {
                str3 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
            } else if (kotlin.jvm.internal.s.d(name, getString(R$string.height))) {
                str4 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
            } else if (kotlin.jvm.internal.s.d(name, getString(R$string.weight))) {
                str5 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
            }
        }
        z3.d dVar = z3.d.f54832a;
        String sb4 = sb2.toString();
        kotlin.jvm.internal.s.h(sb4, "role.toString()");
        String R0 = StringsKt__StringsKt.R0(sb4, ',');
        String sb5 = sb3.toString();
        kotlin.jvm.internal.s.h(sb5, "constellation.toString()");
        dVar.s((r30 & 1) != 0 ? null : str, (r30 & 2) != 0 ? null : R0, (r30 & 4) != 0 ? null : StringsKt__StringsKt.R0(sb5, ','), (r30 & 8) != 0 ? null : str2, (r30 & 16) != 0 ? null : str3, (r30 & 32) != 0 ? null : str4, (r30 & 64) != 0 ? null : str5, (r30 & 128) != 0 ? null : Q0(), (r30 & 256) != 0 ? null : null, (r30 & 512) != 0 ? null : null, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? null : null, (r30 & 4096) != 0 ? null : null, (r30 & 8192) == 0 ? null : null);
    }

    public final void G1() {
        String filterRegion;
        int i10 = R$id.card_filter_layout;
        LocationItemViewModel locationData = ((CardFilterLayout) o1(i10)).getLocationData();
        if (locationData != null) {
            boolean useRecommend = locationData.getUseRecommend();
            LocationItemViewModel locationData2 = ((CardFilterLayout) o1(i10)).getLocationData();
            if (locationData2 == null || (filterRegion = locationData2.getFilterRegion()) == null) {
                return;
            }
            final FormBody.Builder builder = new FormBody.Builder(null, 1, 0 == true ? 1 : 0);
            for (RangeMatchFilterViewModel rangeMatchFilterViewModel : ((CardFilterLayout) o1(i10)).getRangeFilterData()) {
                String str = rangeMatchFilterViewModel.getMatchFilterModel().getKey() + "[]";
                builder.add(str, String.valueOf(rangeMatchFilterViewModel.getMin()));
                builder.add(str, String.valueOf(rangeMatchFilterViewModel.getMax()));
            }
            CoordinateModel j10 = LocationUtils.f12270h.a().j();
            builder.add("filterRegion", filterRegion);
            builder.add(as.at, String.valueOf(j10.getLatitude()));
            builder.add(as.au, String.valueOf(j10.getLongitude()));
            builder.add("useRecommend", String.valueOf(useRecommend));
            x2.a N = NetworkClient.f11868a.N();
            String taskId = B1();
            kotlin.jvm.internal.s.h(taskId, "taskId");
            Observable<Result<Object>> D = N.D(taskId, C1());
            final Function1<Result<? extends Object>, ObservableSource<? extends Result<? extends MatchSettingResult>>> function1 = new Function1<Result<? extends Object>, ObservableSource<? extends Result<? extends MatchSettingResult>>>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$uploadData$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ObservableSource<? extends Result<MatchSettingResult>> invoke(@NotNull Result<? extends Object> it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    return NetworkClient.f11868a.A().s(FormBody.Builder.this.build());
                }
            };
            Observable<R> flatMap = D.flatMap(new Function() { // from class: com.cupidapp.live.match.activity.o
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource H1;
                    H1 = MatchFilterTimeCardActivity.H1(Function1.this, obj);
                    return H1;
                }
            });
            kotlin.jvm.internal.s.h(flatMap, "formBodyBuilder = FormBo…er.build())\n            }");
            Disposable disposed = flatMap.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MatchSettingResult, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$uploadData$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(MatchSettingResult matchSettingResult) {
                    m2699invoke(matchSettingResult);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2699invoke(MatchSettingResult matchSettingResult) {
                    String str2;
                    MatchSettingResult matchSettingResult2 = matchSettingResult;
                    p1.g gVar = p1.g.f52734a;
                    ConstantsResult q10 = gVar.q();
                    if (q10 != null) {
                        q10.setMatchFilterSettingType(matchSettingResult2.getMatchFilterSettingType());
                    }
                    if (q10 != null) {
                        q10.setNearbyFilterSettingType(matchSettingResult2.getNearbyFilterSettingType());
                    }
                    gVar.b2(q10);
                    gVar.l0().d(matchSettingResult2);
                    gVar.Y1(true);
                    j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                    MatchFilterTimeCardActivity matchFilterTimeCardActivity = MatchFilterTimeCardActivity.this;
                    str2 = matchFilterTimeCardActivity.f16515s;
                    j.a.b(aVar, matchFilterTimeCardActivity, str2, null, 4, null);
                    MatchFilterTimeCardActivity.this.finish();
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                H(disposed);
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
            F1();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.NewTaskReward;
    }

    @Nullable
    public View o1(int i10) {
        Map<Integer, View> map = this.f16516t;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(R$anim.anmi_stop, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        setContentView(R$layout.activity_match_time_card_filter);
        w1();
        D1();
        u1();
    }

    public final void u1() {
        ((FKTitleBarLayout) o1(R$id.card_filter_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$bindEvent$1$1
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
                MatchFilterTimeCardActivity.this.finish();
            }
        });
        FKUniversalButton card_filter_btn = (FKUniversalButton) o1(R$id.card_filter_btn);
        kotlin.jvm.internal.s.h(card_filter_btn, "card_filter_btn");
        z0.y.d(card_filter_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$bindEvent$2
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
                boolean v12;
                v12 = MatchFilterTimeCardActivity.this.v1();
                if (v12) {
                    MatchFilterTimeCardActivity.this.G1();
                } else {
                    MatchFilterTimeCardActivity.this.E1();
                }
            }
        });
    }

    public final boolean v1() {
        int i10 = R$id.card_filter_layout;
        LocationItemViewModel locationData = ((CardFilterLayout) o1(i10)).getLocationData();
        if (!kotlin.jvm.internal.s.d(locationData != null ? Boolean.valueOf(locationData.getUseRecommend()) : null, Boolean.TRUE)) {
            return true;
        }
        for (RangeMatchFilterViewModel rangeMatchFilterViewModel : ((CardFilterLayout) o1(i10)).getRangeFilterData()) {
            if (rangeMatchFilterViewModel.getMin() != rangeMatchFilterViewModel.getMatchFilterModel().getDefaultMin() || rangeMatchFilterViewModel.getMax() != rangeMatchFilterViewModel.getMatchFilterModel().getDefaultMax()) {
                return true;
            }
        }
        return false;
    }

    public final void w1() {
        e1();
        User X = p1.g.f52734a.X();
        String userId = X != null ? X.userId() : null;
        NetworkClient networkClient = NetworkClient.f11868a;
        Observable<Result<VipDiscountDescriptionResult>> e2 = networkClient.p().e(userId);
        final MatchFilterTimeCardActivity$getMatchSettingData$discountDescriptionObservable$1 matchFilterTimeCardActivity$getMatchSettingData$discountDescriptionObservable$1 = new Function1<Throwable, Result<? extends VipDiscountDescriptionResult>>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$getMatchSettingData$discountDescriptionObservable$1
            @Override // kotlin.jvm.functions.Function1
            public final Result<VipDiscountDescriptionResult> invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return new Result<>(null, false, null, null, null, null, null, 127, null);
            }
        };
        Observable<Result<VipDiscountDescriptionResult>> onErrorReturn = e2.onErrorReturn(new Function() { // from class: com.cupidapp.live.match.activity.p
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Result x12;
                x12 = MatchFilterTimeCardActivity.x1(Function1.this, obj);
                return x12;
            }
        });
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        Observable observeOn = Observable.zip(onErrorReturn, networkClient.A().p(Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude())), new BiFunction() { // from class: com.cupidapp.live.match.activity.l
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                VipDiscountAndMatchSettingResult y1;
                y1 = MatchFilterTimeCardActivity.y1((Result) obj, (Result) obj2);
                return y1;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<VipDiscountAndMatchSettingResult, kotlin.p> function1 = new Function1<VipDiscountAndMatchSettingResult, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$getMatchSettingData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(VipDiscountAndMatchSettingResult vipDiscountAndMatchSettingResult) {
                invoke2(vipDiscountAndMatchSettingResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VipDiscountAndMatchSettingResult vipDiscountAndMatchSettingResult) {
                MatchFilterTimeCardActivity.this.V0();
                MatchSettingResult matchSetting = vipDiscountAndMatchSettingResult.getMatchSetting();
                if (matchSetting != null) {
                    MatchFilterTimeCardActivity matchFilterTimeCardActivity = MatchFilterTimeCardActivity.this;
                    String str = matchSetting.getUseRecommend() ? "" : null;
                    int i10 = R$id.card_filter_layout;
                    CardFilterLayout cardFilterLayout = (CardFilterLayout) matchFilterTimeCardActivity.o1(i10);
                    boolean useRecommend = matchSetting.getUseRecommend();
                    String filterRegion = matchSetting.getFilterRegion();
                    String str2 = filterRegion == null ? str : filterRegion;
                    List<String> selectedRegion = matchSetting.getSelectedRegion();
                    cardFilterLayout.g(new LocationItemViewModel(useRecommend, str2, selectedRegion != null ? (String) CollectionsKt___CollectionsKt.f0(selectedRegion) : null, matchSetting.getHotCities(), matchSetting.getRegions(), false));
                    ((CardFilterLayout) matchFilterTimeCardActivity.o1(i10)).h(matchSetting.getFilters());
                }
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.match.activity.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MatchFilterTimeCardActivity.z1(Function1.this, obj);
            }
        };
        final MatchFilterTimeCardActivity$getMatchSettingData$3 matchFilterTimeCardActivity$getMatchSettingData$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MatchFilterTimeCardActivity$getMatchSettingData$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                kotlin.jvm.internal.s.h(it, "it");
                com.cupidapp.live.base.network.j.f(jVar, it, null, null, null, 14, null);
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.activity.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MatchFilterTimeCardActivity.A1(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(subscribe, "this");
        H(subscribe);
    }
}
