package com.cupidapp.live.match.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.match.model.CityFilterModel;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.MatchFilterKey;
import com.cupidapp.live.match.model.MatchFilterModel;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.match.model.RegionModel;
import com.cupidapp.live.match.model.SuperFilterModel;
import com.cupidapp.live.match.model.SuperVipTitleUiModel;
import com.cupidapp.live.match.model.TipModel;
import com.cupidapp.live.match.model.TitleViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.vip.model.VipDiscountAndMatchSettingResult;
import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import com.huawei.openalliance.ad.constant.as;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContactFilterViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ContactFilterViewModel extends AndroidViewModel {

    @NotNull
    private final MutableLiveData<Event<kotlin.p>> _filterSucEventLiveData;

    @NotNull
    private final MutableLiveData<StateResult<List<Object>>> _listLiveData;

    @NotNull
    private final Application context;

    @NotNull
    private final LiveData<Event<kotlin.p>> filterSucEventLiveData;

    @NotNull
    private final LiveData<StateResult<List<Object>>> listLiveData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactFilterViewModel(@NotNull Application context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.context = context;
        MutableLiveData<StateResult<List<Object>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Event<kotlin.p>> mutableLiveData2 = new MutableLiveData<>();
        this._filterSucEventLiveData = mutableLiveData2;
        this.filterSucEventLiveData = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Result initData$lambda$0(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VipDiscountAndMatchSettingResult initData$lambda$1(Result vipDiscount, Result matchSetting) {
        kotlin.jvm.internal.s.i(vipDiscount, "vipDiscount");
        kotlin.jvm.internal.s.i(matchSetting, "matchSetting");
        return new VipDiscountAndMatchSettingResult((VipDiscountDescriptionResult) vipDiscount.getData(), (MatchSettingResult) matchSetting.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$3(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void trackFilterContent(List<? extends Object> list, SensorPosition sensorPosition) {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        for (Object obj : list) {
            if (obj instanceof RangeMatchFilterViewModel) {
                RangeMatchFilterViewModel rangeMatchFilterViewModel = (RangeMatchFilterViewModel) obj;
                String name = rangeMatchFilterViewModel.getMatchFilterModel().getName();
                if (kotlin.jvm.internal.s.d(name, this.context.getString(R$string.age))) {
                    str = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
                } else if (kotlin.jvm.internal.s.d(name, this.context.getString(R$string.active_time))) {
                    str2 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
                } else if (kotlin.jvm.internal.s.d(name, this.context.getString(R$string.height))) {
                    str3 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
                } else if (kotlin.jvm.internal.s.d(name, this.context.getString(R$string.weight))) {
                    str4 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
                }
            } else if (obj instanceof SuperFilterModel) {
                SuperFilterModel superFilterModel = (SuperFilterModel) obj;
                if (kotlin.jvm.internal.s.d(superFilterModel.getName(), this.context.getString(R$string.role))) {
                    for (FilterOption filterOption : superFilterModel.getOptions()) {
                        if (filterOption.getChecked()) {
                            sb2.append(filterOption.getLabel());
                            sb2.append(",");
                        }
                    }
                } else if (kotlin.jvm.internal.s.d(superFilterModel.getName(), this.context.getString(R$string.constellation))) {
                    for (FilterOption filterOption2 : superFilterModel.getOptions()) {
                        if (filterOption2.getChecked()) {
                            sb3.append(filterOption2.getLabel());
                            sb3.append(",");
                        }
                    }
                }
            }
        }
        z3.d dVar = z3.d.f54832a;
        String sb4 = sb2.toString();
        kotlin.jvm.internal.s.h(sb4, "role.toString()");
        String R0 = StringsKt__StringsKt.R0(sb4, ',');
        String sb5 = sb3.toString();
        kotlin.jvm.internal.s.h(sb5, "constellation.toString()");
        dVar.s((r30 & 1) != 0 ? null : null, (r30 & 2) != 0 ? null : R0, (r30 & 4) != 0 ? null : StringsKt__StringsKt.R0(sb5, ','), (r30 & 8) != 0 ? null : str, (r30 & 16) != 0 ? null : str2, (r30 & 32) != 0 ? null : str3, (r30 & 64) != 0 ? null : str4, (r30 & 128) != 0 ? null : sensorPosition, (r30 & 256) != 0 ? null : null, (r30 & 512) != 0 ? null : null, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? null : null, (r30 & 4096) != 0 ? null : null, (r30 & 8192) == 0 ? null : null);
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final LiveData<Event<kotlin.p>> getFilterSucEventLiveData() {
        return this.filterSucEventLiveData;
    }

    @NotNull
    public final LiveData<StateResult<List<Object>>> getListLiveData() {
        return this.listLiveData;
    }

    public final void initData() {
        this._listLiveData.setValue(new StateResult.b(null, null, 3, null));
        User X = p1.g.f52734a.X();
        String userId = X != null ? X.userId() : null;
        NetworkClient networkClient = NetworkClient.f11868a;
        Observable<Result<VipDiscountDescriptionResult>> e2 = networkClient.p().e(userId);
        final ContactFilterViewModel$initData$discountDescriptionObservable$1 contactFilterViewModel$initData$discountDescriptionObservable$1 = new Function1<Throwable, Result<? extends VipDiscountDescriptionResult>>() { // from class: com.cupidapp.live.match.viewmodel.ContactFilterViewModel$initData$discountDescriptionObservable$1
            @Override // kotlin.jvm.functions.Function1
            public final Result<VipDiscountDescriptionResult> invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return new Result<>(null, false, null, null, null, null, null, 127, null);
            }
        };
        Observable<Result<VipDiscountDescriptionResult>> onErrorReturn = e2.onErrorReturn(new Function() { // from class: com.cupidapp.live.match.viewmodel.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Result initData$lambda$0;
                initData$lambda$0 = ContactFilterViewModel.initData$lambda$0(Function1.this, obj);
                return initData$lambda$0;
            }
        });
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        Observable observeOn = Observable.zip(onErrorReturn, networkClient.A().m(Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude())), new BiFunction() { // from class: com.cupidapp.live.match.viewmodel.a
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                VipDiscountAndMatchSettingResult initData$lambda$1;
                initData$lambda$1 = ContactFilterViewModel.initData$lambda$1((Result) obj, (Result) obj2);
                return initData$lambda$1;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<VipDiscountAndMatchSettingResult, kotlin.p> function1 = new Function1<VipDiscountAndMatchSettingResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.ContactFilterViewModel$initData$2
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
                MutableLiveData mutableLiveData;
                List<MatchFilterModel> filters;
                List<SuperFilterModel> superFilters;
                List<String> selectedRegion;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new TipModel());
                String string = ContactFilterViewModel.this.getContext().getString(R$string.filter_search);
                kotlin.jvm.internal.s.h(string, "context.getString(R.string.filter_search)");
                arrayList.add(new TitleViewModel(string, false, null, false));
                MatchSettingResult matchSetting = vipDiscountAndMatchSettingResult.getMatchSetting();
                String filterRegion = matchSetting != null ? matchSetting.getFilterRegion() : null;
                MatchSettingResult matchSetting2 = vipDiscountAndMatchSettingResult.getMatchSetting();
                String str = (matchSetting2 == null || (selectedRegion = matchSetting2.getSelectedRegion()) == null) ? null : (String) CollectionsKt___CollectionsKt.f0(selectedRegion);
                MatchSettingResult matchSetting3 = vipDiscountAndMatchSettingResult.getMatchSetting();
                List<RegionModel> hotCities = matchSetting3 != null ? matchSetting3.getHotCities() : null;
                MatchSettingResult matchSetting4 = vipDiscountAndMatchSettingResult.getMatchSetting();
                arrayList.add(new CityFilterModel(filterRegion, str, hotCities, matchSetting4 != null ? matchSetting4.getRegions() : null));
                MatchSettingResult matchSetting5 = vipDiscountAndMatchSettingResult.getMatchSetting();
                if ((matchSetting5 == null || (superFilters = matchSetting5.getSuperFilters()) == null || superFilters.isEmpty()) ? false : true) {
                    String string2 = ContactFilterViewModel.this.getContext().getString(R$string.advanced_filter);
                    kotlin.jvm.internal.s.h(string2, "context.getString(R.string.advanced_filter)");
                    VipDiscountDescriptionResult vipDiscount = vipDiscountAndMatchSettingResult.getVipDiscount();
                    arrayList.add(new SuperVipTitleUiModel(string2, vipDiscount != null ? vipDiscount.getDescription() : null));
                    Iterator<SuperFilterModel> iterator2 = vipDiscountAndMatchSettingResult.getMatchSetting().getSuperFilters().iterator2();
                    while (iterator2.hasNext()) {
                        arrayList.add(iterator2.next());
                    }
                }
                String string3 = ContactFilterViewModel.this.getContext().getString(R$string.filter_criteria);
                kotlin.jvm.internal.s.h(string3, "context.getString(R.string.filter_criteria)");
                arrayList.add(new TitleViewModel(string3, false, null, true));
                MatchSettingResult matchSetting6 = vipDiscountAndMatchSettingResult.getMatchSetting();
                if (matchSetting6 != null && (filters = matchSetting6.getFilters()) != null) {
                    for (MatchFilterModel matchFilterModel : filters) {
                        if (matchFilterModel.getType() == MatchFilterModel.MatchFilterType.Range) {
                            arrayList.add(new RangeMatchFilterViewModel(matchFilterModel, 0, 0, kotlin.jvm.internal.s.d(matchFilterModel.getKey(), "filterActiveTime"), kotlin.jvm.internal.s.d(matchFilterModel.getKey(), "filterAge"), null, 38, null));
                        }
                    }
                }
                mutableLiveData = ContactFilterViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.c(arrayList, null, 2, null));
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.match.viewmodel.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactFilterViewModel.initData$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.ContactFilterViewModel$initData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ContactFilterViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                kotlin.jvm.internal.s.h(it, "it");
                com.cupidapp.live.base.network.j.f(jVar, it, null, null, null, 14, null);
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.viewmodel.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactFilterViewModel.initData$lambda$3(Function1.this, obj);
            }
        });
    }

    public final void uploadData(@NotNull List<? extends Object> modelList, @NotNull SensorPosition sensorPosition) {
        boolean z10;
        List<? extends Object> list;
        kotlin.jvm.internal.s.i(modelList, "modelList");
        kotlin.jvm.internal.s.i(sensorPosition, "sensorPosition");
        FormBody.Builder builder = new FormBody.Builder(null, 1, null);
        loop0: while (true) {
            z10 = false;
            for (Object obj : modelList) {
                if (obj instanceof CityFilterModel) {
                    String filterRegion = ((CityFilterModel) obj).getFilterRegion();
                    if (filterRegion == null || filterRegion.length() == 0) {
                        break;
                    }
                    builder.add("filterRegion", filterRegion);
                    z10 = true;
                } else if (obj instanceof RangeMatchFilterViewModel) {
                    RangeMatchFilterViewModel rangeMatchFilterViewModel = (RangeMatchFilterViewModel) obj;
                    String str = rangeMatchFilterViewModel.getMatchFilterModel().getKey() + "[]";
                    if (z10 && kotlin.jvm.internal.s.d(rangeMatchFilterViewModel.getMatchFilterModel().getKey(), MatchFilterKey.FilterDistance.getKey())) {
                        builder.add(str, String.valueOf(rangeMatchFilterViewModel.getMatchFilterModel().getDefaultMin()));
                        builder.add(str, String.valueOf(rangeMatchFilterViewModel.getMatchFilterModel().getDefaultMax()));
                    } else {
                        builder.add(str, String.valueOf(rangeMatchFilterViewModel.getMin()));
                        builder.add(str, String.valueOf(rangeMatchFilterViewModel.getMax()));
                    }
                } else if (obj instanceof SuperFilterModel) {
                    SuperFilterModel superFilterModel = (SuperFilterModel) obj;
                    String str2 = superFilterModel.getKey() + "[]";
                    for (FilterOption filterOption : superFilterModel.getOptions()) {
                        if (filterOption.getChecked()) {
                            builder.add(str2, filterOption.getId());
                        }
                    }
                }
            }
        }
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        builder.add(as.at, String.valueOf(j10.getLatitude()));
        builder.add(as.au, String.valueOf(j10.getLongitude()));
        Disposable disposed = NetworkClient.f11868a.A().c(builder.build()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MatchSettingResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.ContactFilterViewModel$uploadData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MatchSettingResult matchSettingResult) {
                m2720invoke(matchSettingResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2720invoke(MatchSettingResult matchSettingResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ContactFilterViewModel.this._filterSucEventLiveData;
                mutableLiveData.setValue(new Event(kotlin.p.f51048a));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        if (z10) {
            com.cupidapp.live.base.view.h.f12779a.k(R$string.use_city_filter_to_clear_distance);
        }
        StateResult<List<Object>> value = this.listLiveData.getValue();
        if (value == null || (list = (List) value.getData()) == null) {
            return;
        }
        trackFilterContent(list, sensorPosition);
    }
}
