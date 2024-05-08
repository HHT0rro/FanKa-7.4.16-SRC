package com.cupidapp.live.match.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.match.model.AccurateFilterUiModel;
import com.cupidapp.live.match.model.AdvanceFilterUiModel;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.FilterTabModel;
import com.cupidapp.live.match.model.FilterTitleModel;
import com.cupidapp.live.match.model.FilterUiModel;
import com.cupidapp.live.match.model.IntelligentFilterUiModel;
import com.cupidapp.live.match.model.LocationItemViewModel;
import com.cupidapp.live.match.model.MatchFilterModel;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.model.OptionFilterUiModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.match.model.SuperFilterOptionModel;
import com.cupidapp.live.match.model.UserType;
import com.cupidapp.live.match.model.UserTypeModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import com.huawei.openalliance.ad.constant.as;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterViewModel extends AndroidViewModel {

    @NotNull
    private final MutableLiveData<Event<SensorPosition>> _doneBtnClickEvent;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _mbtiEntranceShowEvent;

    @NotNull
    private final MutableLiveData<StateResult<List<FilterUiModel>>> _resultLiveData;

    @NotNull
    private final MutableLiveData<MatchSettingResult> _uploadResultSucLiveData;

    @NotNull
    private final Application context;

    @Nullable
    private List<String> defaultIntelligentWords;

    @NotNull
    private final LiveData<Event<SensorPosition>> doneBtnClickEvent;

    @NotNull
    private final LiveData<Event<Boolean>> mbtiEntranceShowEvent;

    @NotNull
    private final LiveData<StateResult<List<FilterUiModel>>> resultLiveData;

    @NotNull
    private final LiveData<MatchSettingResult> uploadSucResultLiveData;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String DEFAULT_TAB_KEY = "accurate";

    @NotNull
    private static final String ADVANCED_TAB_KEY = "advanced";

    /* compiled from: MatchFilterViewModel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return MatchFilterViewModel.DEFAULT_TAB_KEY;
        }
    }

    /* compiled from: MatchFilterViewModel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17048a;

        static {
            int[] iArr = new int[MatchFilterModel.MatchFilterType.values().length];
            try {
                iArr[MatchFilterModel.MatchFilterType.Range.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f17048a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchFilterViewModel(@NotNull Application context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.context = context;
        MutableLiveData<StateResult<List<FilterUiModel>>> mutableLiveData = new MutableLiveData<>();
        this._resultLiveData = mutableLiveData;
        this.resultLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<MatchSettingResult> mutableLiveData2 = new MutableLiveData<>();
        this._uploadResultSucLiveData = mutableLiveData2;
        this.uploadSucResultLiveData = Transformations.distinctUntilChanged(mutableLiveData2);
        MutableLiveData<Event<SensorPosition>> mutableLiveData3 = new MutableLiveData<>();
        this._doneBtnClickEvent = mutableLiveData3;
        this.doneBtnClickEvent = mutableLiveData3;
        MutableLiveData<Event<Boolean>> mutableLiveData4 = new MutableLiveData<>();
        this._mbtiEntranceShowEvent = mutableLiveData4;
        this.mbtiEntranceShowEvent = mutableLiveData4;
    }

    private final AccurateFilterUiModel generateAccurateUiModel(MatchSettingResult matchSettingResult, boolean z10, Result<VipDiscountDescriptionResult> result) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        String string = this.context.getString(R$string.filter_search);
        kotlin.jvm.internal.s.h(string, "context.getString(R.string.filter_search)");
        arrayList.add(new FilterTitleModel(string, z10 ? this.context.getString(R$string.in_nearby_not_need_set_location_range) : null, false, PurchaseProductType.NO.getValue(), null, 16, null));
        String str = matchSettingResult.getUseRecommend() ? "" : null;
        boolean useRecommend = matchSettingResult.getUseRecommend();
        String filterRegion = matchSettingResult.getFilterRegion();
        String str2 = filterRegion == null ? str : filterRegion;
        List<String> selectedRegion = matchSettingResult.getSelectedRegion();
        arrayList.add(new LocationItemViewModel(useRecommend, str2, selectedRegion != null ? (String) CollectionsKt___CollectionsKt.f0(selectedRegion) : null, matchSettingResult.getHotCities(), matchSettingResult.getRegions(), z10));
        String string2 = this.context.getString(R$string.filter_criteria);
        kotlin.jvm.internal.s.h(string2, "context.getString(R.string.filter_criteria)");
        arrayList.add(new FilterTitleModel(string2, null, true, PurchaseProductType.VIP.getValue(), null, 16, null));
        List<MatchFilterModel> filters = matchSettingResult.getFilters();
        if (filters != null) {
            for (MatchFilterModel matchFilterModel : filters) {
                if (a.f17048a[matchFilterModel.getType().ordinal()] == 1) {
                    arrayList.add(new RangeMatchFilterViewModel(matchFilterModel, 0, 0, kotlin.jvm.internal.s.d(matchFilterModel.getKey(), "filterActiveTime"), kotlin.jvm.internal.s.d(matchFilterModel.getKey(), "filterAge"), null, 38, null));
                }
            }
        }
        arrayList.add(new FKFooterViewModel(false, false, null, 0, 0, 0, 62, null));
        boolean limitTimeReward = matchSettingResult.getLimitTimeReward();
        String string3 = this.context.getString(R$string.filter_title);
        kotlin.jvm.internal.s.h(string3, "context.getString(R.string.filter_title)");
        return new AccurateFilterUiModel(arrayList, limitTimeReward, string3, DEFAULT_TAB_KEY, result.getData());
    }

    private final AdvanceFilterUiModel generateAdvanceFilterUiModel(MatchSettingResult matchSettingResult, boolean z10, Result<VipDiscountDescriptionResult> result) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (!z10) {
            arrayList.add(new IntelligentFilterUiModel(matchSettingResult.getMatchKeywords(), matchSettingResult.getMatchKeywordsOption()));
        }
        UserTypeModel userFilters = matchSettingResult.getUserFilters();
        if (userFilters != null) {
            arrayList.add(new FilterTitleModel(userFilters.getName(), null, !z10, userFilters.getProductType(), result.getData()));
            arrayList.add(userFilters);
        }
        SuperFilterOptionModel zodiacFilters = matchSettingResult.getZodiacFilters();
        if (zodiacFilters != null) {
            arrayList.add(new FilterTitleModel(zodiacFilters.getTitle(), null, true, zodiacFilters.getProductType(), result.getData()));
            arrayList.add(zodiacFilters);
        }
        arrayList.add(new FKFooterViewModel(false, false, null, 0, 0, 0, 62, null));
        boolean limitTimeReward = matchSettingResult.getLimitTimeReward();
        String string = this.context.getString(R$string.super_filter_title);
        kotlin.jvm.internal.s.h(string, "context.getString(R.string.super_filter_title)");
        return new AdvanceFilterUiModel(arrayList, limitTimeReward, string, ADVANCED_TAB_KEY, result.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Result loadData$lambda$0(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List loadData$lambda$3(MatchFilterViewModel this$0, boolean z10, Result vipDiscount, Result matchSetting) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(vipDiscount, "vipDiscount");
        kotlin.jvm.internal.s.i(matchSetting, "matchSetting");
        ArrayList arrayList = new ArrayList();
        MatchSettingResult matchSettingResult = (MatchSettingResult) matchSetting.getData();
        if (matchSettingResult != null) {
            this$0.defaultIntelligentWords = matchSettingResult.getMatchKeywords();
            arrayList.add(this$0.generateAccurateUiModel(matchSettingResult, z10, vipDiscount));
            arrayList.add(this$0.generateAdvanceFilterUiModel(matchSettingResult, z10, vipDiscount));
            List<FilterTabModel> filterTabs = matchSettingResult.getFilterTabs();
            if (filterTabs != null) {
                for (FilterTabModel filterTabModel : filterTabs) {
                    arrayList.add(new OptionFilterUiModel(filterTabModel, filterTabModel.getKey(), filterTabModel.getTabName(), (VipDiscountDescriptionResult) vipDiscount.getData()));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadData$lambda$4(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadData$lambda$5(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void trackFilterContent(boolean z10, List<? extends Object> list, SensorPosition sensorPosition) {
        List<FilterOption> options;
        List<FilterOption> options2;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        for (Object obj : list) {
            if (obj instanceof AccurateFilterUiModel) {
                for (Object obj2 : ((AccurateFilterUiModel) obj).getList()) {
                    if (obj2 instanceof LocationItemViewModel) {
                        LocationItemViewModel locationItemViewModel = (LocationItemViewModel) obj2;
                        String selectedRegion = locationItemViewModel.getSelectedRegion();
                        if (!(selectedRegion == null || selectedRegion.length() == 0)) {
                            str = locationItemViewModel.getSelectedRegion();
                        } else {
                            str = this.context.getString(R$string.current_city);
                        }
                    } else if (obj2 instanceof RangeMatchFilterViewModel) {
                        RangeMatchFilterViewModel rangeMatchFilterViewModel = (RangeMatchFilterViewModel) obj2;
                        String name = rangeMatchFilterViewModel.getMatchFilterModel().getName();
                        if (kotlin.jvm.internal.s.d(name, this.context.getString(R$string.age))) {
                            str2 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
                        } else if (kotlin.jvm.internal.s.d(name, this.context.getString(R$string.active_time))) {
                            str3 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
                        } else if (kotlin.jvm.internal.s.d(name, this.context.getString(R$string.height))) {
                            str4 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
                        } else if (kotlin.jvm.internal.s.d(name, this.context.getString(R$string.weight))) {
                            str5 = rangeMatchFilterViewModel.getMin() + "-" + rangeMatchFilterViewModel.getMax();
                        }
                    }
                }
            } else if (obj instanceof AdvanceFilterUiModel) {
                for (Object obj3 : ((AdvanceFilterUiModel) obj).getList()) {
                    if (obj3 instanceof UserTypeModel) {
                        List<FilterOption> options3 = ((UserTypeModel) obj3).getOptions();
                        if (options3 != null) {
                            for (FilterOption filterOption : options3) {
                                String id2 = filterOption.getId();
                                if (kotlin.jvm.internal.s.d(id2, UserType.SingleUser.getKey())) {
                                    bool = Boolean.valueOf(filterOption.getChecked());
                                } else if (kotlin.jvm.internal.s.d(id2, UserType.NewUser.getKey())) {
                                    bool2 = Boolean.valueOf(filterOption.getChecked());
                                } else if (kotlin.jvm.internal.s.d(id2, UserType.HotUser.getKey())) {
                                    bool3 = Boolean.valueOf(filterOption.getChecked());
                                } else if (kotlin.jvm.internal.s.d(id2, UserType.MatchUser.getKey())) {
                                    bool4 = Boolean.valueOf(filterOption.getChecked());
                                }
                            }
                        }
                    } else if (obj3 instanceof SuperFilterOptionModel) {
                        SuperFilterOptionModel superFilterOptionModel = (SuperFilterOptionModel) obj3;
                        if (kotlin.jvm.internal.s.d(superFilterOptionModel.getKey(), "zodiac") && (options = superFilterOptionModel.getOptions()) != null) {
                            for (FilterOption filterOption2 : options) {
                                if (filterOption2.getChecked()) {
                                    sb3.append(filterOption2.getLabel());
                                    sb3.append(",");
                                }
                            }
                        }
                    }
                }
            } else if (obj instanceof OptionFilterUiModel) {
                FilterTabModel filterTabModel = ((OptionFilterUiModel) obj).getFilterTabModel();
                if (kotlin.jvm.internal.s.d(filterTabModel.getTabName(), this.context.getString(R$string.role))) {
                    List<FilterOption> options4 = filterTabModel.getOptions();
                    if (options4 != null) {
                        for (FilterOption filterOption3 : options4) {
                            if (filterOption3.getChecked()) {
                                sb2.append(filterOption3.getLabel());
                                sb2.append(",");
                            }
                        }
                    }
                } else if (kotlin.jvm.internal.s.d(filterTabModel.getTabName(), this.context.getString(R$string.constellation))) {
                    List<FilterOption> options5 = filterTabModel.getOptions();
                    if (options5 != null) {
                        for (FilterOption filterOption4 : options5) {
                            if (filterOption4.getChecked()) {
                                sb3.append(filterOption4.getLabel());
                                sb3.append(",");
                            }
                        }
                    }
                } else if (kotlin.text.p.r(this.context.getString(R$string.mbti), filterTabModel.getTabName(), true) && (options2 = filterTabModel.getOptions()) != null) {
                    for (FilterOption filterOption5 : options2) {
                        if (filterOption5.getChecked()) {
                            sb4.append(filterOption5.getLabel());
                            sb4.append(",");
                        }
                    }
                }
            }
        }
        z3.d dVar = z3.d.f54832a;
        String sb5 = sb2.toString();
        kotlin.jvm.internal.s.h(sb5, "role.toString()");
        String R0 = StringsKt__StringsKt.R0(sb5, ',');
        String sb6 = sb3.toString();
        kotlin.jvm.internal.s.h(sb6, "constellation.toString()");
        String R02 = StringsKt__StringsKt.R0(sb6, ',');
        Boolean valueOf = Boolean.valueOf(z10);
        String sb7 = sb4.toString();
        kotlin.jvm.internal.s.h(sb7, "mbti.toString()");
        dVar.s(str, R0, R02, str2, str3, str4, str5, sensorPosition, valueOf, StringsKt__StringsKt.R0(sb7, ','), bool, bool2, bool3, bool4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadData$lambda$26(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadData$lambda$27(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void changeMBTITestEntranceShow(boolean z10) {
        this._mbtiEntranceShowEvent.setValue(new Event<>(Boolean.valueOf(z10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[LOOP:6: B:85:0x00e6->B:112:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[LOOP:4: B:61:0x0092->B:125:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d4 A[EDGE_INSN: B:81:0x00d4->B:82:0x00d4 BREAK  A[LOOP:4: B:61:0x0092->B:125:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int checkNeedPurchase(@org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.Object> r11) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.viewmodel.MatchFilterViewModel.checkNeedPurchase(java.util.List):int");
    }

    public final void doneBtnClick(@NotNull SensorPosition position) {
        kotlin.jvm.internal.s.i(position, "position");
        this._doneBtnClickEvent.setValue(new Event<>(position));
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final LiveData<Event<SensorPosition>> getDoneBtnClickEvent() {
        return this.doneBtnClickEvent;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getMbtiEntranceShowEvent() {
        return this.mbtiEntranceShowEvent;
    }

    @NotNull
    public final LiveData<StateResult<List<FilterUiModel>>> getResultLiveData() {
        return this.resultLiveData;
    }

    @NotNull
    public final LiveData<MatchSettingResult> getUploadSucResultLiveData() {
        return this.uploadSucResultLiveData;
    }

    public final void loadData(final boolean z10) {
        if (this.resultLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._resultLiveData.setValue(new StateResult.b(null, null, 3, null));
        User X = p1.g.f52734a.X();
        String userId = X != null ? X.userId() : null;
        NetworkClient networkClient = NetworkClient.f11868a;
        Observable<Result<VipDiscountDescriptionResult>> e2 = networkClient.p().e(userId);
        final MatchFilterViewModel$loadData$discountDescriptionObservable$1 matchFilterViewModel$loadData$discountDescriptionObservable$1 = new Function1<Throwable, Result<? extends VipDiscountDescriptionResult>>() { // from class: com.cupidapp.live.match.viewmodel.MatchFilterViewModel$loadData$discountDescriptionObservable$1
            @Override // kotlin.jvm.functions.Function1
            public final Result<VipDiscountDescriptionResult> invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return new Result<>(null, false, null, null, null, null, null, 127, null);
            }
        };
        Observable<Result<VipDiscountDescriptionResult>> onErrorReturn = e2.onErrorReturn(new Function() { // from class: com.cupidapp.live.match.viewmodel.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Result loadData$lambda$0;
                loadData$lambda$0 = MatchFilterViewModel.loadData$lambda$0(Function1.this, obj);
                return loadData$lambda$0;
            }
        });
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        Observable observeOn = Observable.zip(onErrorReturn, networkClient.A().p(Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude())), new BiFunction() { // from class: com.cupidapp.live.match.viewmodel.j
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                List loadData$lambda$3;
                loadData$lambda$3 = MatchFilterViewModel.loadData$lambda$3(MatchFilterViewModel.this, z10, (Result) obj, (Result) obj2);
                return loadData$lambda$3;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<List<? extends FilterUiModel>, kotlin.p> function1 = new Function1<List<? extends FilterUiModel>, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.MatchFilterViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends FilterUiModel> list) {
                invoke2(list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends FilterUiModel> list) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MatchFilterViewModel.this._resultLiveData;
                mutableLiveData.setValue(new StateResult.c(list, null, 2, null));
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.match.viewmodel.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MatchFilterViewModel.loadData$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.MatchFilterViewModel$loadData$3
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
                mutableLiveData = MatchFilterViewModel.this._resultLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                kotlin.jvm.internal.s.h(it, "it");
                com.cupidapp.live.base.network.j.f(jVar, it, null, null, null, 14, null);
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.viewmodel.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MatchFilterViewModel.loadData$lambda$5(Function1.this, obj);
            }
        });
    }

    public final void uploadData(@NotNull List<? extends Object> list, @NotNull SensorPosition sensorPosition) {
        List<FilterOption> options;
        Object obj;
        kotlin.jvm.internal.s.i(list, "list");
        kotlin.jvm.internal.s.i(sensorPosition, "sensorPosition");
        Object obj2 = null;
        FormBody.Builder builder = new FormBody.Builder(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        boolean z10 = false;
        for (Object obj3 : list) {
            if (obj3 instanceof AccurateFilterUiModel) {
                AccurateFilterUiModel accurateFilterUiModel = (AccurateFilterUiModel) obj3;
                Iterator<Object> iterator2 = accurateFilterUiModel.getList().iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        obj = iterator2.next();
                        if (obj instanceof LocationItemViewModel) {
                            break;
                        }
                    } else {
                        obj = obj2;
                        break;
                    }
                }
                LocationItemViewModel locationItemViewModel = (LocationItemViewModel) obj;
                if (locationItemViewModel != null) {
                    boolean useRecommend = locationItemViewModel.getUseRecommend();
                    String filterRegion = locationItemViewModel.getFilterRegion();
                    if (filterRegion != null) {
                        for (Object obj4 : accurateFilterUiModel.getList()) {
                            if (obj4 instanceof RangeMatchFilterViewModel) {
                                RangeMatchFilterViewModel rangeMatchFilterViewModel = (RangeMatchFilterViewModel) obj4;
                                String str = rangeMatchFilterViewModel.getMatchFilterModel().getKey() + "[]";
                                builder.add(str, String.valueOf(rangeMatchFilterViewModel.getMin()));
                                builder.add(str, String.valueOf(rangeMatchFilterViewModel.getMax()));
                            }
                        }
                        CoordinateModel j10 = LocationUtils.f12270h.a().j();
                        builder.add("filterRegion", filterRegion);
                        builder.add(as.at, String.valueOf(j10.getLatitude()));
                        builder.add(as.au, String.valueOf(j10.getLongitude()));
                        builder.add("useRecommend", String.valueOf(useRecommend));
                    }
                }
            } else if (obj3 instanceof AdvanceFilterUiModel) {
                List<String> list2 = this.defaultIntelligentWords;
                for (Object obj5 : ((AdvanceFilterUiModel) obj3).getList()) {
                    if (obj5 instanceof IntelligentFilterUiModel) {
                        list2 = ((IntelligentFilterUiModel) obj5).getMatchKeywords();
                    } else if (obj5 instanceof UserTypeModel) {
                        List<FilterOption> options2 = ((UserTypeModel) obj5).getOptions();
                        if (options2 != null) {
                            for (FilterOption filterOption : options2) {
                                builder.add(filterOption.getId(), String.valueOf(filterOption.getChecked()));
                            }
                        }
                    } else if (obj5 instanceof SuperFilterOptionModel) {
                        SuperFilterOptionModel superFilterOptionModel = (SuperFilterOptionModel) obj5;
                        if (kotlin.jvm.internal.s.d(superFilterOptionModel.getKey(), "zodiac") && (options = superFilterOptionModel.getOptions()) != null) {
                            for (FilterOption filterOption2 : options) {
                                if (filterOption2.getChecked()) {
                                    builder.add(superFilterOptionModel.getKey() + "[]", filterOption2.getId());
                                }
                            }
                        }
                    }
                }
                if (list2 != null) {
                    for (String str2 : list2) {
                        if (str2.length() > 0) {
                            builder.add("matchKeywords[]", str2);
                            z10 = true;
                        }
                    }
                }
            } else if (obj3 instanceof OptionFilterUiModel) {
                FilterTabModel filterTabModel = ((OptionFilterUiModel) obj3).getFilterTabModel();
                String key = filterTabModel.getKey();
                List<FilterOption> options3 = filterTabModel.getOptions();
                if (options3 != null) {
                    for (FilterOption filterOption3 : options3) {
                        if (filterOption3.getChecked()) {
                            builder.add(key + "[]", filterOption3.getId());
                        }
                    }
                }
            }
            obj2 = null;
        }
        Observable observeOn = NetworkClient.f11868a.A().s(builder.build()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread());
        final Function1<MatchSettingResult, kotlin.p> function1 = new Function1<MatchSettingResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.MatchFilterViewModel$uploadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MatchSettingResult matchSettingResult) {
                invoke2(matchSettingResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MatchSettingResult matchSettingResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MatchFilterViewModel.this._uploadResultSucLiveData;
                mutableLiveData.setValue(matchSettingResult);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.match.viewmodel.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj6) {
                MatchFilterViewModel.uploadData$lambda$26(Function1.this, obj6);
            }
        };
        final MatchFilterViewModel$uploadData$3 matchFilterViewModel$uploadData$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.MatchFilterViewModel$uploadData$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.viewmodel.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj6) {
                MatchFilterViewModel.uploadData$lambda$27(Function1.this, obj6);
            }
        });
        trackFilterContent(z10, list, sensorPosition);
    }
}
