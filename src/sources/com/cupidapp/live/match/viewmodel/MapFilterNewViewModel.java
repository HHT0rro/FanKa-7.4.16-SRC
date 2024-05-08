package com.cupidapp.live.match.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.Result;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapFilterNewViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MapFilterNewViewModel extends AndroidViewModel {

    @NotNull
    private final MutableLiveData<Event<kotlin.p>> _openNearByEvent;

    @NotNull
    private MutableLiveData<Event<String>> _openWeb;

    @NotNull
    private MutableLiveData<Event<Boolean>> _showLoading;

    @NotNull
    private final Application context;

    @NotNull
    private final Lazy geocoderSearch$delegate;

    @NotNull
    private final LiveData<Event<kotlin.p>> openNearByEvent;

    @NotNull
    private final LiveData<Event<String>> openWeb;

    @NotNull
    private final LiveData<Event<Boolean>> showLoading;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapFilterNewViewModel(@NotNull Application context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.context = context;
        MutableLiveData<Event<kotlin.p>> mutableLiveData = new MutableLiveData<>();
        this._openNearByEvent = mutableLiveData;
        this.openNearByEvent = mutableLiveData;
        MutableLiveData<Event<Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._showLoading = mutableLiveData2;
        this.showLoading = mutableLiveData2;
        MutableLiveData<Event<String>> mutableLiveData3 = new MutableLiveData<>();
        this._openWeb = mutableLiveData3;
        this.openWeb = mutableLiveData3;
        this.geocoderSearch$delegate = kotlin.c.b(new Function0<GeocodeSearch>() { // from class: com.cupidapp.live.match.viewmodel.MapFilterNewViewModel$geocoderSearch$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GeocodeSearch invoke() {
                return new GeocodeSearch(MapFilterNewViewModel.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GeocodeSearch getGeocoderSearch() {
        return (GeocodeSearch) this.geocoderSearch$delegate.getValue();
    }

    private final void saveLocation(final LatLng latLng) {
        Flowable onBackpressureLatest = Flowable.just(latLng).subscribeOn(Schedulers.io()).onBackpressureLatest();
        final Function1<LatLng, RegeocodeAddress> function1 = new Function1<LatLng, RegeocodeAddress>() { // from class: com.cupidapp.live.match.viewmodel.MapFilterNewViewModel$saveLocation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RegeocodeAddress invoke(@NotNull LatLng it) {
                GeocodeSearch geocoderSearch;
                kotlin.jvm.internal.s.i(it, "it");
                LatLng latLng2 = LatLng.this;
                RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(latLng2.latitude, latLng2.longitude), 200.0f, GeocodeSearch.AMAP);
                geocoderSearch = this.getGeocoderSearch();
                return geocoderSearch.getFromLocation(regeocodeQuery);
            }
        };
        Observable observable = onBackpressureLatest.map(new Function() { // from class: com.cupidapp.live.match.viewmodel.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RegeocodeAddress saveLocation$lambda$0;
                saveLocation$lambda$0 = MapFilterNewViewModel.saveLocation$lambda$0(Function1.this, obj);
                return saveLocation$lambda$0;
            }
        }).toObservable();
        final Function1<RegeocodeAddress, ObservableSource<? extends Result<? extends Object>>> function12 = new Function1<RegeocodeAddress, ObservableSource<? extends Result<? extends Object>>>() { // from class: com.cupidapp.live.match.viewmodel.MapFilterNewViewModel$saveLocation$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ObservableSource<? extends Result<Object>> invoke(@NotNull RegeocodeAddress it) {
                kotlin.jvm.internal.s.i(it, "it");
                return NetworkClient.f11868a.A().u(Double.valueOf(LatLng.this.latitude), Double.valueOf(LatLng.this.longitude), it.getDistrict(), it.getProvince(), it.getFormatAddress(), it.getCity(), false);
            }
        };
        Observable flatMap = observable.flatMap(new Function() { // from class: com.cupidapp.live.match.viewmodel.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource saveLocation$lambda$1;
                saveLocation$lambda$1 = MapFilterNewViewModel.saveLocation$lambda$1(Function1.this, obj);
                return saveLocation$lambda$1;
            }
        });
        kotlin.jvm.internal.s.h(flatMap, "private fun saveLocation…alse\n            })\n    }");
        Disposable disposed = flatMap.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.MapFilterNewViewModel$saveLocation$$inlined$handle$1
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
                mutableLiveData = MapFilterNewViewModel.this._showLoading;
                mutableLiveData.setValue(new Event(Boolean.FALSE));
                mutableLiveData2 = MapFilterNewViewModel.this._openNearByEvent;
                mutableLiveData2.setValue(new Event(kotlin.p.f51048a));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.MapFilterNewViewModel$saveLocation$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                kotlin.jvm.internal.s.i(it, "it");
                mutableLiveData = MapFilterNewViewModel.this._showLoading;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final RegeocodeAddress saveLocation$lambda$0(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (RegeocodeAddress) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource saveLocation$lambda$1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final LiveData<Event<kotlin.p>> getOpenNearByEvent() {
        return this.openNearByEvent;
    }

    @NotNull
    public final LiveData<Event<String>> getOpenWeb() {
        return this.openWeb;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowLoading() {
        return this.showLoading;
    }

    public final void openTravelPage() {
        String str;
        ConstantsUrlModel urlModel;
        String travelH5Url;
        MutableLiveData<Event<String>> mutableLiveData = this._openWeb;
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 == null || (urlModel = q10.getUrlModel()) == null || (travelH5Url = urlModel.getTravelH5Url()) == null || (str = z0.x.a(travelH5Url, "entrance_name", "MAP_FIND")) == null) {
            str = "";
        }
        mutableLiveData.setValue(new Event<>(str));
    }

    public final void saveMapFilterLocation(@Nullable LatLng latLng) {
        if (latLng != null) {
            this._showLoading.setValue(new Event<>(Boolean.TRUE));
            saveLocation(latLng);
        }
    }
}
