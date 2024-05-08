package com.cupidapp.live.match.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.cupidapp.live.base.livedata.CombineLiveData;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.match.model.AddressModel;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchLocationViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchLocationViewModel extends AndroidViewModel {

    @NotNull
    private final MutableLiveData<List<AddressModel>> _historyLiveData;

    @NotNull
    private final MutableLiveData<List<AddressModel>> _hotsLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _isSearchStateLiveData;

    @NotNull
    private final MutableLiveData<Event<AddressModel>> _openMapEvent;

    @NotNull
    private final MutableLiveData<Event<kotlin.p>> _openNearByEvent;

    @NotNull
    private final MutableLiveData<List<AddressModel>> _searchResultLiveData;

    @NotNull
    private MutableLiveData<Event<Boolean>> _showLoading;

    @NotNull
    private final Application context;

    @NotNull
    private final String from;

    @NotNull
    private final Lazy geocoderSearch$delegate;

    @NotNull
    private final LiveData<List<AddressModel>> historyLiveData;

    @NotNull
    private final LiveData<List<AddressModel>> hotsLiveData;

    @NotNull
    private final LiveData<Boolean> isSearchStateLiveData;

    @Nullable
    private final Double latitude;

    @Nullable
    private final Double longitude;

    @NotNull
    private final LiveData<Event<AddressModel>> openMapEvent;

    @NotNull
    private final LiveData<Event<kotlin.p>> openNearByEvent;

    @Nullable
    private String recommendCursor;

    @NotNull
    private final LiveData<List<AddressModel>> searchResultLiveData;

    @NotNull
    private final LiveData<Boolean> showHistoryLiveData;

    @NotNull
    private final LiveData<Boolean> showHotLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> showLoading;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchLocationViewModel(@Nullable Double d10, @Nullable Double d11, @NotNull String from, @NotNull Application context) {
        super(context);
        kotlin.jvm.internal.s.i(from, "from");
        kotlin.jvm.internal.s.i(context, "context");
        this.latitude = d10;
        this.longitude = d11;
        this.from = from;
        this.context = context;
        MutableLiveData<List<AddressModel>> mutableLiveData = new MutableLiveData<>();
        this._hotsLiveData = mutableLiveData;
        this.hotsLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<List<AddressModel>> mutableLiveData2 = new MutableLiveData<>();
        this._searchResultLiveData = mutableLiveData2;
        this.searchResultLiveData = Transformations.distinctUntilChanged(mutableLiveData2);
        MutableLiveData<Event<AddressModel>> mutableLiveData3 = new MutableLiveData<>();
        this._openMapEvent = mutableLiveData3;
        this.openMapEvent = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue(Boolean.FALSE);
        this._isSearchStateLiveData = mutableLiveData4;
        this.isSearchStateLiveData = Transformations.map(Transformations.distinctUntilChanged(mutableLiveData4), new Function1<Boolean, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$isSearchStateLiveData$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(Boolean it) {
                kotlin.jvm.internal.s.h(it, "it");
                return it;
            }
        });
        MutableLiveData<Event<kotlin.p>> mutableLiveData5 = new MutableLiveData<>();
        this._openNearByEvent = mutableLiveData5;
        this.openNearByEvent = mutableLiveData5;
        MutableLiveData<List<AddressModel>> mutableLiveData6 = new MutableLiveData<>();
        this._historyLiveData = mutableLiveData6;
        this.historyLiveData = mutableLiveData6;
        this.showHistoryLiveData = new CombineLiveData(mutableLiveData4, mutableLiveData6, new Function2<Boolean, List<? extends AddressModel>, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$showHistoryLiveData$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Boolean mo1743invoke(Boolean bool, List<? extends AddressModel> list) {
                return invoke2(bool, (List<AddressModel>) list);
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(@Nullable Boolean bool, @Nullable List<AddressModel> list) {
                boolean z10 = false;
                if (kotlin.jvm.internal.s.d(bool, Boolean.FALSE)) {
                    if (list != null && (list.isEmpty() ^ true)) {
                        z10 = true;
                    }
                }
                return Boolean.valueOf(z10);
            }
        });
        this.showHotLiveData = new CombineLiveData(mutableLiveData4, mutableLiveData, new Function2<Boolean, List<? extends AddressModel>, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$showHotLiveData$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Boolean mo1743invoke(Boolean bool, List<? extends AddressModel> list) {
                return invoke2(bool, (List<AddressModel>) list);
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(@Nullable Boolean bool, @Nullable List<AddressModel> list) {
                boolean z10 = false;
                if (kotlin.jvm.internal.s.d(bool, Boolean.FALSE)) {
                    if (list != null && (list.isEmpty() ^ true)) {
                        z10 = true;
                    }
                }
                return Boolean.valueOf(z10);
            }
        });
        MutableLiveData<Event<Boolean>> mutableLiveData7 = new MutableLiveData<>();
        this._showLoading = mutableLiveData7;
        this.showLoading = mutableLiveData7;
        this.geocoderSearch$delegate = kotlin.c.b(new Function0<GeocodeSearch>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$geocoderSearch$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GeocodeSearch invoke() {
                return new GeocodeSearch(SearchLocationViewModel.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeSearchContent$lambda$4(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeSearchContent$lambda$5(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GeocodeSearch getGeocoderSearch() {
        return (GeocodeSearch) this.geocoderSearch$delegate.getValue();
    }

    private final void loadHistory() {
        Disposable disposed = NetworkClient.f11868a.s().g().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<AddressModel>, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$loadHistory$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<AddressModel> listResult) {
                m2732invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2732invoke(ListResult<AddressModel> listResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SearchLocationViewModel.this._historyLiveData;
                List<AddressModel> list = listResult.getList();
                if (list == null) {
                    list = kotlin.collections.s.j();
                }
                mutableLiveData.setValue(list);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public static /* synthetic */ void saveLocation$default(SearchLocationViewModel searchLocationViewModel, LatLng latLng, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        searchLocationViewModel.saveLocation(latLng, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource saveLocation$lambda$10(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RegeocodeAddress saveLocation$lambda$9(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (RegeocodeAddress) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList search$lambda$6(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (ArrayList) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchAgain$lambda$7(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchAgain$lambda$8(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void changeHotCity() {
        z3.d.f54832a.B();
        loadAddressRecommend();
    }

    public final void changeSearchContent(@Nullable String str) {
        if (str == null || str.length() == 0) {
            this._isSearchStateLiveData.setValue(Boolean.FALSE);
            return;
        }
        this._isSearchStateLiveData.setValue(Boolean.TRUE);
        Flowable<ArrayList<AddressModel>> observeOn = search(str).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<AddressModel>, kotlin.p> function1 = new Function1<ArrayList<AddressModel>, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$changeSearchContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ArrayList<AddressModel> arrayList) {
                invoke2(arrayList);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<AddressModel> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SearchLocationViewModel.this._searchResultLiveData;
                mutableLiveData.setValue(arrayList);
            }
        };
        Consumer<? super ArrayList<AddressModel>> consumer = new Consumer() { // from class: com.cupidapp.live.match.viewmodel.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchLocationViewModel.changeSearchContent$lambda$4(Function1.this, obj);
            }
        };
        final SearchLocationViewModel$changeSearchContent$2 searchLocationViewModel$changeSearchContent$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$changeSearchContent$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.viewmodel.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchLocationViewModel.changeSearchContent$lambda$5(Function1.this, obj);
            }
        });
    }

    public final void clearHistory() {
        Disposable disposed = NetworkClient.f11868a.s().e().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$clearHistory$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SearchLocationViewModel.this._historyLiveData;
                mutableLiveData.setValue(kotlin.collections.s.j());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    @NotNull
    public final LiveData<List<AddressModel>> getHistoryLiveData() {
        return this.historyLiveData;
    }

    @NotNull
    public final LiveData<List<AddressModel>> getHotsLiveData() {
        return this.hotsLiveData;
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final LiveData<Event<AddressModel>> getOpenMapEvent() {
        return this.openMapEvent;
    }

    @NotNull
    public final LiveData<Event<kotlin.p>> getOpenNearByEvent() {
        return this.openNearByEvent;
    }

    @NotNull
    public final LiveData<List<AddressModel>> getSearchResultLiveData() {
        return this.searchResultLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getShowHistoryLiveData() {
        return this.showHistoryLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getShowHotLiveData() {
        return this.showHotLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowLoading() {
        return this.showLoading;
    }

    public final void initData() {
        if (kotlin.jvm.internal.s.d(this.from, SensorPosition.TravelMap.getValue())) {
            return;
        }
        loadAddressRecommend();
        loadHistory();
    }

    @NotNull
    public final LiveData<Boolean> isSearchStateLiveData() {
        return this.isSearchStateLiveData;
    }

    public final void loadAddressRecommend() {
        Disposable disposed = NetworkClient.f11868a.s().f(this.recommendCursor).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<AddressModel>, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$loadAddressRecommend$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<AddressModel> listResult) {
                m2731invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2731invoke(ListResult<AddressModel> listResult) {
                MutableLiveData mutableLiveData;
                ListResult<AddressModel> listResult2 = listResult;
                mutableLiveData = SearchLocationViewModel.this._hotsLiveData;
                mutableLiveData.setValue(listResult2.getList());
                SearchLocationViewModel.this.recommendCursor = listResult2.getNextCursorId();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void saveLocation(@NotNull final LatLng latlng, @Nullable final String str) {
        kotlin.jvm.internal.s.i(latlng, "latlng");
        this._showLoading.setValue(new Event<>(Boolean.TRUE));
        Flowable onBackpressureLatest = Flowable.just(latlng).subscribeOn(Schedulers.io()).onBackpressureLatest();
        final Function1<LatLng, RegeocodeAddress> function1 = new Function1<LatLng, RegeocodeAddress>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$saveLocation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RegeocodeAddress invoke(@NotNull LatLng it) {
                GeocodeSearch geocoderSearch;
                kotlin.jvm.internal.s.i(it, "it");
                LatLng latLng = LatLng.this;
                RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(latLng.latitude, latLng.longitude), 200.0f, GeocodeSearch.AMAP);
                geocoderSearch = this.getGeocoderSearch();
                return geocoderSearch.getFromLocation(regeocodeQuery);
            }
        };
        Observable observable = onBackpressureLatest.map(new Function() { // from class: com.cupidapp.live.match.viewmodel.v
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RegeocodeAddress saveLocation$lambda$9;
                saveLocation$lambda$9 = SearchLocationViewModel.saveLocation$lambda$9(Function1.this, obj);
                return saveLocation$lambda$9;
            }
        }).toObservable();
        final Function1<RegeocodeAddress, ObservableSource<? extends Result<? extends Object>>> function12 = new Function1<RegeocodeAddress, ObservableSource<? extends Result<? extends Object>>>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$saveLocation$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ObservableSource<? extends Result<Object>> invoke(@NotNull RegeocodeAddress it) {
                kotlin.jvm.internal.s.i(it, "it");
                b3.a A = NetworkClient.f11868a.A();
                Double valueOf = Double.valueOf(LatLng.this.latitude);
                Double valueOf2 = Double.valueOf(LatLng.this.longitude);
                String district = it.getDistrict();
                String province = it.getProvince();
                String str2 = str;
                if (str2 == null) {
                    str2 = it.getFormatAddress();
                }
                return A.u(valueOf, valueOf2, district, province, str2, it.getCity(), false);
            }
        };
        Observable flatMap = observable.flatMap(new Function() { // from class: com.cupidapp.live.match.viewmodel.u
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource saveLocation$lambda$10;
                saveLocation$lambda$10 = SearchLocationViewModel.saveLocation$lambda$10(Function1.this, obj);
                return saveLocation$lambda$10;
            }
        });
        kotlin.jvm.internal.s.h(flatMap, "fun saveLocation(latlng:…alse\n            })\n    }");
        Disposable disposed = flatMap.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$saveLocation$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = SearchLocationViewModel.this._showLoading;
                mutableLiveData.setValue(new Event(Boolean.FALSE));
                mutableLiveData2 = SearchLocationViewModel.this._openNearByEvent;
                mutableLiveData2.setValue(new Event(kotlin.p.f51048a));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$saveLocation$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                kotlin.jvm.internal.s.i(it, "it");
                mutableLiveData = SearchLocationViewModel.this._showLoading;
                Boolean bool = Boolean.FALSE;
                mutableLiveData.setValue(new Event(bool));
                return bool;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @NotNull
    public final Flowable<ArrayList<AddressModel>> search(@NotNull final String keyword) {
        kotlin.jvm.internal.s.i(keyword, "keyword");
        Flowable onBackpressureLatest = Flowable.just(keyword).observeOn(Schedulers.io()).onBackpressureLatest();
        final Function1<String, ArrayList<AddressModel>> function1 = new Function1<String, ArrayList<AddressModel>>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$search$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ArrayList<AddressModel> invoke(@NotNull String it) {
                kotlin.jvm.internal.s.i(it, "it");
                PoiSearchV2.Query query = new PoiSearchV2.Query(String.this, "");
                query.setPageSize(20);
                PoiResultV2 searchPOI = new PoiSearchV2(this.getContext(), query).searchPOI();
                ArrayList<AddressModel> arrayList = new ArrayList<>();
                if (searchPOI != null && searchPOI.getQuery() != null) {
                    ArrayList<PoiItemV2> pois = searchPOI.getPois();
                    int size = pois.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        PoiItemV2 poiItemV2 = pois.get(i10);
                        String poiId = poiItemV2.getPoiId();
                        kotlin.jvm.internal.s.h(poiId, "itemV2.poiId");
                        arrayList.add(new AddressModel(poiId, poiItemV2.getSnippet(), poiItemV2.getTitle(), Double.valueOf(poiItemV2.getLatLonPoint().getLatitude()), Double.valueOf(poiItemV2.getLatLonPoint().getLongitude()), poiItemV2.getCityName(), poiItemV2.getAdName(), null, null));
                    }
                }
                return arrayList;
            }
        };
        Flowable<ArrayList<AddressModel>> map = onBackpressureLatest.map(new Function() { // from class: com.cupidapp.live.match.viewmodel.t
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ArrayList search$lambda$6;
                search$lambda$6 = SearchLocationViewModel.search$lambda$6(Function1.this, obj);
                return search$lambda$6;
            }
        });
        kotlin.jvm.internal.s.h(map, "fun search(keyword: Stri…ocationList\n            }");
        return map;
    }

    public final void searchAgain(@NotNull String searchKey) {
        kotlin.jvm.internal.s.i(searchKey, "searchKey");
        Flowable<ArrayList<AddressModel>> observeOn = search(searchKey).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<AddressModel>, kotlin.p> function1 = new Function1<ArrayList<AddressModel>, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$searchAgain$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ArrayList<AddressModel> arrayList) {
                invoke2(arrayList);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<AddressModel> listResult) {
                MutableLiveData mutableLiveData;
                kotlin.jvm.internal.s.h(listResult, "listResult");
                AddressModel addressModel = (AddressModel) CollectionsKt___CollectionsKt.V(listResult);
                if (addressModel != null) {
                    mutableLiveData = SearchLocationViewModel.this._openMapEvent;
                    mutableLiveData.setValue(new Event(addressModel));
                }
            }
        };
        Consumer<? super ArrayList<AddressModel>> consumer = new Consumer() { // from class: com.cupidapp.live.match.viewmodel.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchLocationViewModel.searchAgain$lambda$7(Function1.this, obj);
            }
        };
        final SearchLocationViewModel$searchAgain$2 searchLocationViewModel$searchAgain$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.SearchLocationViewModel$searchAgain$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.viewmodel.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchLocationViewModel.searchAgain$lambda$8(Function1.this, obj);
            }
        });
    }
}
