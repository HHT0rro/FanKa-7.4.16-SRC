package com.cupidapp.live.match.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.match.model.CheckTravelUseResult;
import com.cupidapp.live.match.model.TravelCountSelectUiModel;
import com.cupidapp.live.match.model.TravelUseResult;
import com.cupidapp.live.mediapicker.model.InChinaModel;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelMapViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TravelMapViewModel extends AndroidViewModel {

    @NotNull
    private final MutableLiveData<Event<kotlin.p>> _failDialogEventLiveData;

    @NotNull
    private MutableLiveData<Event<String>> _openWeb;

    @NotNull
    private final MutableLiveData<Event<TravelCountSelectUiModel>> _selectDialogEventLiveData;

    @NotNull
    private MutableLiveData<Event<String>> _selectLocation;

    @NotNull
    private MutableLiveData<Event<Boolean>> _showLoading;

    @NotNull
    private final MutableLiveData<Event<Triple<LatLng, RegeocodeAddress, Boolean>>> _twiceDialogEventLiveData;

    @NotNull
    private final MutableLiveData<Event<String>> _useSucEventLiveData;

    @NotNull
    private final Application context;

    @NotNull
    private final LiveData<Event<kotlin.p>> failDialogEventLiveData;

    @NotNull
    private final Lazy geocoderSearch$delegate;
    private boolean inChina;

    @NotNull
    private final LiveData<Event<String>> openWeb;

    @NotNull
    private final LiveData<Event<TravelCountSelectUiModel>> selectDialogEventLiveData;

    @NotNull
    private final LiveData<Event<String>> selectLocation;

    @NotNull
    private final LiveData<Event<Boolean>> showLoading;

    @NotNull
    private final LiveData<Event<Triple<LatLng, RegeocodeAddress, Boolean>>> twiceDialogEventLiveData;

    @NotNull
    private final LiveData<Event<String>> useSucEventLiveData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TravelMapViewModel(@NotNull Application context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.context = context;
        this.geocoderSearch$delegate = kotlin.c.b(new Function0<GeocodeSearch>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$geocoderSearch$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GeocodeSearch invoke() {
                return new GeocodeSearch(TravelMapViewModel.this.getContext());
            }
        });
        MutableLiveData<Event<Boolean>> mutableLiveData = new MutableLiveData<>();
        this._showLoading = mutableLiveData;
        this.showLoading = mutableLiveData;
        MutableLiveData<Event<String>> mutableLiveData2 = new MutableLiveData<>();
        this._openWeb = mutableLiveData2;
        this.openWeb = mutableLiveData2;
        MutableLiveData<Event<String>> mutableLiveData3 = new MutableLiveData<>();
        this._selectLocation = mutableLiveData3;
        this.selectLocation = mutableLiveData3;
        MutableLiveData<Event<Triple<LatLng, RegeocodeAddress, Boolean>>> mutableLiveData4 = new MutableLiveData<>();
        this._twiceDialogEventLiveData = mutableLiveData4;
        this.twiceDialogEventLiveData = mutableLiveData4;
        MutableLiveData<Event<TravelCountSelectUiModel>> mutableLiveData5 = new MutableLiveData<>();
        this._selectDialogEventLiveData = mutableLiveData5;
        this.selectDialogEventLiveData = mutableLiveData5;
        MutableLiveData<Event<String>> mutableLiveData6 = new MutableLiveData<>();
        this._useSucEventLiveData = mutableLiveData6;
        this.useSucEventLiveData = mutableLiveData6;
        MutableLiveData<Event<kotlin.p>> mutableLiveData7 = new MutableLiveData<>();
        this._failDialogEventLiveData = mutableLiveData7;
        this.failDialogEventLiveData = mutableLiveData7;
        this.inChina = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource changeLocation$lambda$3(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public static /* synthetic */ void confirmUseTravel$default(TravelMapViewModel travelMapViewModel, LatLng latLng, RegeocodeAddress regeocodeAddress, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 1;
        }
        travelMapViewModel.confirmUseTravel(latLng, regeocodeAddress, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GeocodeSearch getGeocoderSearch() {
        return (GeocodeSearch) this.geocoderSearch$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RegeocodeAddress getLocationAddress$lambda$0(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (RegeocodeAddress) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLocationAddress$lambda$1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLocationAddress$lambda$2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void saveLocation(final LatLng latLng) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Flowable onBackpressureLatest = Flowable.just(latLng).subscribeOn(Schedulers.io()).onBackpressureLatest();
        final Function1<LatLng, RegeocodeAddress> function1 = new Function1<LatLng, RegeocodeAddress>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$saveLocation$1
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
        Observable observable = onBackpressureLatest.map(new Function() { // from class: com.cupidapp.live.match.viewmodel.b0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RegeocodeAddress saveLocation$lambda$5;
                saveLocation$lambda$5 = TravelMapViewModel.saveLocation$lambda$5(Function1.this, obj);
                return saveLocation$lambda$5;
            }
        }).toObservable();
        final Function1<RegeocodeAddress, kotlin.p> function12 = new Function1<RegeocodeAddress, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$saveLocation$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(RegeocodeAddress regeocodeAddress) {
                invoke2(regeocodeAddress);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RegeocodeAddress regeocodeAddress) {
                ref$ObjectRef.element = regeocodeAddress;
            }
        };
        Observable doOnNext = observable.doOnNext(new Consumer() { // from class: com.cupidapp.live.match.viewmodel.x
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TravelMapViewModel.saveLocation$lambda$6(Function1.this, obj);
            }
        });
        final Function1<RegeocodeAddress, ObservableSource<? extends Result<? extends CheckTravelUseResult>>> function13 = new Function1<RegeocodeAddress, ObservableSource<? extends Result<? extends CheckTravelUseResult>>>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$saveLocation$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ObservableSource<? extends Result<CheckTravelUseResult>> invoke(@NotNull RegeocodeAddress it) {
                kotlin.jvm.internal.s.i(it, "it");
                return NetworkClient.f11868a.A().l(Double.valueOf(LatLng.this.latitude), Double.valueOf(LatLng.this.longitude), it.getDistrict(), it.getProvince(), it.getFormatAddress(), it.getCity());
            }
        };
        Observable flatMap = doOnNext.flatMap(new Function() { // from class: com.cupidapp.live.match.viewmodel.z
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource saveLocation$lambda$7;
                saveLocation$lambda$7 = TravelMapViewModel.saveLocation$lambda$7(Function1.this, obj);
                return saveLocation$lambda$7;
            }
        });
        kotlin.jvm.internal.s.h(flatMap, "private fun saveLocation…   }\n            })\n    }");
        Disposable disposed = flatMap.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<CheckTravelUseResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$saveLocation$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(CheckTravelUseResult checkTravelUseResult) {
                m2735invoke(checkTravelUseResult);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2735invoke(CheckTravelUseResult checkTravelUseResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = TravelMapViewModel.this._showLoading;
                mutableLiveData.setValue(new Event(Boolean.FALSE));
                mutableLiveData2 = TravelMapViewModel.this._selectDialogEventLiveData;
                mutableLiveData2.setValue(new Event(new TravelCountSelectUiModel(checkTravelUseResult, latLng, (RegeocodeAddress) ref$ObjectRef.element)));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$saveLocation$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                boolean z10;
                kotlin.jvm.internal.s.i(it, "it");
                mutableLiveData = TravelMapViewModel.this._showLoading;
                mutableLiveData.setValue(new Event(Boolean.FALSE));
                String a10 = com.cupidapp.live.base.network.j.f12008a.a(it);
                Integer valueOf = a10 != null ? Integer.valueOf(z0.t.q(a10)) : null;
                int value = RequestErrorCode.MakeSureExposure.getValue();
                boolean z11 = true;
                if (valueOf != null && valueOf.intValue() == value) {
                    mutableLiveData3 = TravelMapViewModel.this._twiceDialogEventLiveData;
                    LatLng latLng2 = latLng;
                    RegeocodeAddress regeocodeAddress = ref$ObjectRef.element;
                    z10 = TravelMapViewModel.this.inChina;
                    mutableLiveData3.setValue(new Event(new Triple(latLng2, regeocodeAddress, Boolean.valueOf(z10))));
                } else {
                    int value2 = RequestErrorCode.CanNotExposure.getValue();
                    if (valueOf != null && valueOf.intValue() == value2) {
                        mutableLiveData2 = TravelMapViewModel.this._failDialogEventLiveData;
                        mutableLiveData2.setValue(new Event(kotlin.p.f51048a));
                    } else {
                        z11 = false;
                    }
                }
                return Boolean.valueOf(z11);
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RegeocodeAddress saveLocation$lambda$5(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (RegeocodeAddress) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveLocation$lambda$6(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource saveLocation$lambda$7(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public final void changeLocation(@NotNull final CameraPosition cameraPosition) {
        kotlin.jvm.internal.s.i(cameraPosition, "cameraPosition");
        if (!cameraPosition.isAbroad) {
            getLocationAddress(cameraPosition, true);
            return;
        }
        Observable observable = Flowable.just(cameraPosition).onBackpressureLatest().subscribeOn(Schedulers.io()).toObservable();
        final Function1<CameraPosition, ObservableSource<? extends Result<? extends InChinaModel>>> function1 = new Function1<CameraPosition, ObservableSource<? extends Result<? extends InChinaModel>>>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$changeLocation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ObservableSource<? extends Result<InChinaModel>> invoke(@NotNull CameraPosition it) {
                kotlin.jvm.internal.s.i(it, "it");
                return NetworkClient.f11868a.s().b(Double.valueOf(CameraPosition.this.target.latitude), Double.valueOf(CameraPosition.this.target.longitude));
            }
        };
        Observable flatMap = observable.flatMap(new Function() { // from class: com.cupidapp.live.match.viewmodel.a0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource changeLocation$lambda$3;
                changeLocation$lambda$3 = TravelMapViewModel.changeLocation$lambda$3(Function1.this, obj);
                return changeLocation$lambda$3;
            }
        });
        kotlin.jvm.internal.s.h(flatMap, "cameraPosition: CameraPo…      )\n                }");
        Disposable disposed = flatMap.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<InChinaModel, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$changeLocation$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(InChinaModel inChinaModel) {
                m2733invoke(inChinaModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2733invoke(InChinaModel inChinaModel) {
                TravelMapViewModel.this.getLocationAddress(cameraPosition, inChinaModel.getRes());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$changeLocation$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                TravelMapViewModel.this.getLocationAddress(cameraPosition, false);
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void confirmUseTravel(@NotNull LatLng latLng, @Nullable RegeocodeAddress regeocodeAddress, int i10) {
        kotlin.jvm.internal.s.i(latLng, "latLng");
        this._showLoading.setValue(new Event<>(Boolean.TRUE));
        Disposable disposed = NetworkClient.f11868a.A().q(Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude), regeocodeAddress != null ? regeocodeAddress.getDistrict() : null, regeocodeAddress != null ? regeocodeAddress.getProvince() : null, regeocodeAddress != null ? regeocodeAddress.getFormatAddress() : null, regeocodeAddress != null ? regeocodeAddress.getCity() : null, Integer.valueOf(i10), 2).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<TravelUseResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$confirmUseTravel$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(TravelUseResult travelUseResult) {
                m2734invoke(travelUseResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2734invoke(TravelUseResult travelUseResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = TravelMapViewModel.this._showLoading;
                mutableLiveData.setValue(new Event(Boolean.FALSE));
                mutableLiveData2 = TravelMapViewModel.this._useSucEventLiveData;
                String url = travelUseResult.getUrl();
                if (url == null) {
                    url = "";
                }
                mutableLiveData2.setValue(new Event(url));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$confirmUseTravel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                kotlin.jvm.internal.s.i(it, "it");
                mutableLiveData = TravelMapViewModel.this._showLoading;
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
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final LiveData<Event<kotlin.p>> getFailDialogEventLiveData() {
        return this.failDialogEventLiveData;
    }

    public final void getLocationAddress(@Nullable CameraPosition cameraPosition, boolean z10) {
        if (cameraPosition == null) {
            return;
        }
        this.inChina = z10;
        final LatLng latLng = cameraPosition.target;
        if (!z10) {
            this._selectLocation.setValue(new Event<>(z0.m.b(latLng.latitude) + "," + z0.m.b(latLng.longitude)));
            return;
        }
        Flowable onBackpressureLatest = Flowable.just(latLng).subscribeOn(Schedulers.io()).onBackpressureLatest();
        final Function1<LatLng, RegeocodeAddress> function1 = new Function1<LatLng, RegeocodeAddress>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$getLocationAddress$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RegeocodeAddress invoke(@NotNull LatLng it) {
                GeocodeSearch geocoderSearch;
                kotlin.jvm.internal.s.i(it, "it");
                RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(it.latitude, it.longitude), 200.0f, GeocodeSearch.AMAP);
                geocoderSearch = TravelMapViewModel.this.getGeocoderSearch();
                return geocoderSearch.getFromLocation(regeocodeQuery);
            }
        };
        Observable observeOn = onBackpressureLatest.map(new Function() { // from class: com.cupidapp.live.match.viewmodel.c0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RegeocodeAddress locationAddress$lambda$0;
                locationAddress$lambda$0 = TravelMapViewModel.getLocationAddress$lambda$0(Function1.this, obj);
                return locationAddress$lambda$0;
            }
        }).toObservable().observeOn(AndroidSchedulers.mainThread());
        final Function1<RegeocodeAddress, kotlin.p> function12 = new Function1<RegeocodeAddress, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$getLocationAddress$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(RegeocodeAddress regeocodeAddress) {
                invoke2(regeocodeAddress);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RegeocodeAddress regeocodeAddress) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                String city = regeocodeAddress.getCity();
                if (city == null || city.length() == 0) {
                    mutableLiveData2 = TravelMapViewModel.this._selectLocation;
                    mutableLiveData2.setValue(new Event(z0.m.b(latLng.latitude) + "," + z0.m.b(latLng.longitude)));
                    return;
                }
                mutableLiveData = TravelMapViewModel.this._selectLocation;
                mutableLiveData.setValue(new Event(regeocodeAddress.getCity()));
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.match.viewmodel.y
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TravelMapViewModel.getLocationAddress$lambda$1(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function13 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.TravelMapViewModel$getLocationAddress$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TravelMapViewModel.this._selectLocation;
                mutableLiveData.setValue(new Event(z0.m.b(latLng.latitude) + "," + z0.m.b(latLng.longitude)));
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.viewmodel.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TravelMapViewModel.getLocationAddress$lambda$2(Function1.this, obj);
            }
        });
    }

    @NotNull
    public final LiveData<Event<String>> getOpenWeb() {
        return this.openWeb;
    }

    @NotNull
    public final LiveData<Event<TravelCountSelectUiModel>> getSelectDialogEventLiveData() {
        return this.selectDialogEventLiveData;
    }

    @NotNull
    public final LiveData<Event<String>> getSelectLocation() {
        return this.selectLocation;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowLoading() {
        return this.showLoading;
    }

    @NotNull
    public final LiveData<Event<Triple<LatLng, RegeocodeAddress, Boolean>>> getTwiceDialogEventLiveData() {
        return this.twiceDialogEventLiveData;
    }

    @NotNull
    public final LiveData<Event<String>> getUseSucEventLiveData() {
        return this.useSucEventLiveData;
    }

    public final void saveMapFilterLocation(@Nullable LatLng latLng) {
        if (latLng != null) {
            this._showLoading.setValue(new Event<>(Boolean.TRUE));
            saveLocation(latLng);
        }
    }
}
