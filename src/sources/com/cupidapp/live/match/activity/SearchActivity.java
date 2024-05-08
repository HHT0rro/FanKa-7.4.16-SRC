package com.cupidapp.live.match.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.liveshow.activity.FKStartLiveShowActivity;
import com.cupidapp.live.main.model.SearchResult;
import com.cupidapp.live.match.model.AddressModel;
import com.cupidapp.live.match.model.FilterTabKey;
import com.cupidapp.live.match.model.IntelligentFilterKeywordResult;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.search.adapter.SearchResultAdapter;
import com.cupidapp.live.search.holder.MatchFilterKeyClickEvent;
import com.cupidapp.live.search.model.SearchModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.huawei.openalliance.ad.constant.as;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.FormBody;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: SearchActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchActivity extends FKBaseActivity {

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public static final a f16547y = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public IntelligentFilterKeywordResult f16549r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public List<AddressModel> f16550s;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public Disposable f16553v;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16555x = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16548q = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.match.activity.SearchActivity$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            SearchActivity searchActivity = SearchActivity.this;
            Lifecycle lifecycle = searchActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(searchActivity, lifecycle);
        }
    });

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f16551t = kotlin.c.b(new Function0<GeocodeSearch>() { // from class: com.cupidapp.live.match.activity.SearchActivity$geocoderSearch$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final GeocodeSearch invoke() {
            return new GeocodeSearch(SearchActivity.this);
        }
    });

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f16552u = kotlin.c.b(new Function0<SearchResultAdapter>() { // from class: com.cupidapp.live.match.activity.SearchActivity$resultAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SearchResultAdapter invoke() {
            SearchResultAdapter searchResultAdapter = new SearchResultAdapter();
            final SearchActivity searchActivity = SearchActivity.this;
            searchResultAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$resultAdapter$2$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable final Object obj) {
                    if (obj instanceof SearchModel) {
                        SearchModel searchModel = (SearchModel) obj;
                        UserProfileActivity.G.a(SearchActivity.this, searchModel.getUser(), new ProfileSensorContext(ViewProfilePrefer.SearchToProfile.getValue(), null, searchModel.getUser().getMe(), SensorPosition.Search, SensorPosition.Unknown, null), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                    } else if (obj instanceof AddressModel) {
                        xb.b bVar = new xb.b(SearchActivity.this);
                        LocationUtils.Companion companion = LocationUtils.f12270h;
                        final SearchActivity searchActivity2 = SearchActivity.this;
                        companion.e(searchActivity2, bVar, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$resultAdapter$2$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                SearchActivity.this.G1((AddressModel) obj);
                            }
                        });
                    }
                }
            });
            searchResultAdapter.l().j(kotlin.collections.i0.h(kotlin.f.a(Integer.valueOf(R$id.liveShowSignView), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$resultAdapter$2$1$2
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
                    String onlineLiveShowId;
                    if (!(obj instanceof SearchModel) || (onlineLiveShowId = ((SearchModel) obj).getUser().getOnlineLiveShowId()) == null) {
                        return;
                    }
                    FKStartLiveShowActivity.f14790s.a(SearchActivity.this, onlineLiveShowId, null, SensorPosition.Search.getValue());
                }
            })));
            return searchResultAdapter;
        }
    });

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public TabState f16554w = TabState.HOT_SEARCH_LOCATION;

    /* compiled from: SearchActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            Intent intent = new Intent(context, (Class<?>) SearchActivity.class);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.f11750o.b(context, R$anim.alpha_in, R$anim.anim_activity_nothing);
        }
    }

    /* compiled from: SearchActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16556a;

        static {
            int[] iArr = new int[TabState.values().length];
            try {
                iArr[TabState.HOT_SEARCH_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabState.INTELLIGENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f16556a = iArr;
        }
    }

    public static /* synthetic */ void F1(SearchActivity searchActivity, TabState tabState, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            tabState = searchActivity.f16554w;
        }
        searchActivity.E1(tabState, z10);
    }

    public static final RegeocodeAddress H1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (RegeocodeAddress) tmp0.invoke(obj);
    }

    public static final ObservableSource I1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public static final void P1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Q1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void R1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void T1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void U1(SearchActivity this$0, Object obj) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.L1().j().clear();
        this$0.L1().e(this$0.f16550s);
        this$0.L1().notifyDataSetChanged();
        ((RecyclerView) this$0.r1(R$id.searchResultListView)).setVisibility(0);
        this$0.r1(R$id.bottom_map).setVisibility(0);
    }

    public static final void V1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void E1(TabState tabState, boolean z10) {
        if (z10) {
            r1(R$id.bottom_map).setVisibility(8);
            ((LinearLayout) r1(R$id.search_tab_ll)).setVisibility(8);
            r1(R$id.hot_location_bg).setVisibility(8);
            L1().j().clear();
            L1().notifyDataSetChanged();
            ((RecyclerView) r1(R$id.searchResultListView)).setVisibility(0);
            return;
        }
        this.f16554w = tabState;
        int i10 = b.f16556a[tabState.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            r1(R$id.hot_location_bg).setVisibility(8);
            ((LinearLayout) r1(R$id.search_tab_ll)).setVisibility(0);
            int i11 = R$id.search_location_tab;
            ((TextView) r1(i11)).getPaint().setFakeBoldText(false);
            ((TextView) r1(i11)).setTextColor(-5658199);
            int i12 = R$id.intelligent_filter_tab;
            ((TextView) r1(i12)).getPaint().setFakeBoldText(true);
            ((TextView) r1(i12)).setTextColor(-15066598);
            r1(R$id.bottom_map).setVisibility(8);
            ((RecyclerView) r1(R$id.searchResultListView)).setVisibility(4);
            O1();
            return;
        }
        ((LinearLayout) r1(R$id.search_tab_ll)).setVisibility(0);
        int i13 = R$id.search_location_tab;
        ((TextView) r1(i13)).getPaint().setFakeBoldText(true);
        ((TextView) r1(i13)).setTextColor(-15066598);
        int i14 = R$id.intelligent_filter_tab;
        ((TextView) r1(i14)).getPaint().setFakeBoldText(false);
        ((TextView) r1(i14)).setTextColor(-5658199);
        r1(R$id.hot_location_bg).setVisibility(0);
        ((RecyclerView) r1(R$id.searchResultListView)).setVisibility(4);
        S1();
        TextView map_title = (TextView) r1(R$id.map_title);
        kotlin.jvm.internal.s.h(map_title, "map_title");
        z0.u.a(map_title);
        TextView go_map_btn = (TextView) r1(R$id.go_map_btn);
        kotlin.jvm.internal.s.h(go_map_btn, "go_map_btn");
        z0.u.a(go_map_btn);
    }

    public final void G1(final AddressModel addressModel) {
        e1();
        if (addressModel.getLatitude() == null || addressModel.getLongitude() == null) {
            return;
        }
        Flowable onBackpressureLatest = Flowable.just(addressModel).subscribeOn(Schedulers.io()).onBackpressureLatest();
        final Function1<AddressModel, RegeocodeAddress> function1 = new Function1<AddressModel, RegeocodeAddress>() { // from class: com.cupidapp.live.match.activity.SearchActivity$citySelect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RegeocodeAddress invoke(@NotNull AddressModel it) {
                GeocodeSearch J1;
                kotlin.jvm.internal.s.i(it, "it");
                Double latitude = AddressModel.this.getLatitude();
                kotlin.jvm.internal.s.f(latitude);
                double doubleValue = latitude.doubleValue();
                Double longitude = AddressModel.this.getLongitude();
                kotlin.jvm.internal.s.f(longitude);
                RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(doubleValue, longitude.doubleValue()), 200.0f, GeocodeSearch.AMAP);
                J1 = this.J1();
                return J1.getFromLocation(regeocodeQuery);
            }
        };
        Observable observable = onBackpressureLatest.map(new Function() { // from class: com.cupidapp.live.match.activity.e0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RegeocodeAddress H1;
                H1 = SearchActivity.H1(Function1.this, obj);
                return H1;
            }
        }).toObservable();
        final Function1<RegeocodeAddress, ObservableSource<? extends Result<? extends Object>>> function12 = new Function1<RegeocodeAddress, ObservableSource<? extends Result<? extends Object>>>() { // from class: com.cupidapp.live.match.activity.SearchActivity$citySelect$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ObservableSource<? extends Result<Object>> invoke(@NotNull RegeocodeAddress it) {
                kotlin.jvm.internal.s.i(it, "it");
                b3.a A = NetworkClient.f11868a.A();
                Double latitude = AddressModel.this.getLatitude();
                kotlin.jvm.internal.s.f(latitude);
                Double longitude = AddressModel.this.getLongitude();
                kotlin.jvm.internal.s.f(longitude);
                String district = it.getDistrict();
                String province = it.getProvince();
                String name = AddressModel.this.getName();
                if (name == null) {
                    name = it.getFormatAddress();
                }
                return A.u(latitude, longitude, district, province, name, it.getCity(), false);
            }
        };
        Observable flatMap = observable.flatMap(new Function() { // from class: com.cupidapp.live.match.activity.f0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource I1;
                I1 = SearchActivity.I1(Function1.this, obj);
                return I1;
            }
        });
        kotlin.jvm.internal.s.h(flatMap, "private fun citySelect(m…    })\n\n        }\n\n\n    }");
        Disposable disposed = flatMap.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$citySelect$$inlined$handle$1
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
                SearchActivity.this.V0();
                p1.g.f52734a.J2(VipPurchaseEntranceType.SearchGuideMap);
                MainActivity.F.e("match", SearchActivity.this, "near");
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.activity.SearchActivity$citySelect$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                SearchActivity.this.V0();
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final GeocodeSearch J1() {
        return (GeocodeSearch) this.f16551t.getValue();
    }

    public final PurchaseDialogManager K1() {
        return (PurchaseDialogManager) this.f16548q.getValue();
    }

    public final SearchResultAdapter L1() {
        return (SearchResultAdapter) this.f16552u.getValue();
    }

    public final void M1(SearchResult searchResult) {
        ArrayList arrayList;
        L1().j().clear();
        List<User> list = searchResult.getList();
        if (list != null) {
            arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
            Iterator<User> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new SearchModel(searchResult.getKeyword(), iterator2.next()));
            }
        } else {
            arrayList = null;
        }
        boolean z10 = false;
        if (arrayList != null && (!arrayList.isEmpty())) {
            z10 = true;
        }
        if (z10) {
            L1().e(CollectionsKt___CollectionsKt.z0(arrayList));
        }
        L1().notifyDataSetChanged();
    }

    public final void N1(boolean z10) {
        if (z10) {
            ((ImageView) r1(R$id.clearButton)).setVisibility(4);
            ((ProgressBar) r1(R$id.loadingView)).setVisibility(0);
        } else {
            ((ImageView) r1(R$id.clearButton)).setVisibility(0);
            ((ProgressBar) r1(R$id.loadingView)).setVisibility(4);
        }
    }

    public final void O1() {
        Observable just;
        IntelligentFilterKeywordResult intelligentFilterKeywordResult = this.f16549r;
        if (intelligentFilterKeywordResult == null) {
            Observable<R> flatMap = NetworkClient.f11868a.A().w().flatMap(new com.cupidapp.live.base.network.i());
            final Function1<IntelligentFilterKeywordResult, kotlin.p> function1 = new Function1<IntelligentFilterKeywordResult, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$showIntelligentFilterView$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(IntelligentFilterKeywordResult intelligentFilterKeywordResult2) {
                    invoke2(intelligentFilterKeywordResult2);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IntelligentFilterKeywordResult intelligentFilterKeywordResult2) {
                    SearchActivity.this.f16549r = intelligentFilterKeywordResult2;
                }
            };
            just = flatMap.doOnNext(new Consumer() { // from class: com.cupidapp.live.match.activity.d0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SearchActivity.P1(Function1.this, obj);
                }
            });
        } else {
            just = Observable.just(intelligentFilterKeywordResult);
        }
        Observable observeOn = just.observeOn(AndroidSchedulers.mainThread());
        final Function1<IntelligentFilterKeywordResult, kotlin.p> function12 = new Function1<IntelligentFilterKeywordResult, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$showIntelligentFilterView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(IntelligentFilterKeywordResult intelligentFilterKeywordResult2) {
                invoke2(intelligentFilterKeywordResult2);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
            
                r5 = r4.this$0.f16549r;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
            
                r5 = r4.this$0.f16549r;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(com.cupidapp.live.match.model.IntelligentFilterKeywordResult r5) {
                /*
                    r4 = this;
                    com.cupidapp.live.match.activity.SearchActivity r5 = com.cupidapp.live.match.activity.SearchActivity.this
                    com.cupidapp.live.search.adapter.SearchResultAdapter r5 = com.cupidapp.live.match.activity.SearchActivity.w1(r5)
                    java.util.List r5 = r5.j()
                    r5.clear()
                    com.cupidapp.live.match.activity.SearchActivity r5 = com.cupidapp.live.match.activity.SearchActivity.this
                    com.cupidapp.live.match.model.IntelligentFilterKeywordResult r5 = com.cupidapp.live.match.activity.SearchActivity.u1(r5)
                    r0 = 0
                    r1 = 1
                    if (r5 == 0) goto L26
                    java.util.Map r5 = r5.getMatchKeywords()
                    if (r5 == 0) goto L26
                    boolean r5 = r5.isEmpty()
                    r5 = r5 ^ r1
                    if (r5 != r1) goto L26
                    r5 = 1
                    goto L27
                L26:
                    r5 = 0
                L27:
                    if (r5 == 0) goto L3a
                    com.cupidapp.live.match.activity.SearchActivity r5 = com.cupidapp.live.match.activity.SearchActivity.this
                    com.cupidapp.live.match.model.IntelligentFilterKeywordResult r5 = com.cupidapp.live.match.activity.SearchActivity.u1(r5)
                    if (r5 == 0) goto L3a
                    com.cupidapp.live.match.activity.SearchActivity r2 = com.cupidapp.live.match.activity.SearchActivity.this
                    com.cupidapp.live.search.adapter.SearchResultAdapter r2 = com.cupidapp.live.match.activity.SearchActivity.w1(r2)
                    r2.d(r5)
                L3a:
                    com.cupidapp.live.match.activity.SearchActivity r5 = com.cupidapp.live.match.activity.SearchActivity.this
                    com.cupidapp.live.match.model.IntelligentFilterKeywordResult r5 = com.cupidapp.live.match.activity.SearchActivity.u1(r5)
                    if (r5 == 0) goto L50
                    java.util.List r5 = r5.getSvipKeyWordOptions()
                    if (r5 == 0) goto L50
                    boolean r5 = r5.isEmpty()
                    r5 = r5 ^ r1
                    if (r5 != r1) goto L50
                    goto L51
                L50:
                    r1 = 0
                L51:
                    if (r1 == 0) goto L7b
                    com.cupidapp.live.match.activity.SearchActivity r5 = com.cupidapp.live.match.activity.SearchActivity.this
                    com.cupidapp.live.match.model.IntelligentFilterKeywordResult r5 = com.cupidapp.live.match.activity.SearchActivity.u1(r5)
                    if (r5 == 0) goto L7b
                    java.util.List r5 = r5.getSvipKeyWordOptions()
                    if (r5 == 0) goto L7b
                    com.cupidapp.live.match.activity.SearchActivity r1 = com.cupidapp.live.match.activity.SearchActivity.this
                    java.util.Iterator r5 = r5.iterator2()
                L67:
                    boolean r2 = r5.hasNext()
                    if (r2 == 0) goto L7b
                    java.lang.Object r2 = r5.next()
                    com.cupidapp.live.match.model.SVipKeywordOptionModel r2 = (com.cupidapp.live.match.model.SVipKeywordOptionModel) r2
                    com.cupidapp.live.search.adapter.SearchResultAdapter r3 = com.cupidapp.live.match.activity.SearchActivity.w1(r1)
                    r3.d(r2)
                    goto L67
                L7b:
                    com.cupidapp.live.match.activity.SearchActivity r5 = com.cupidapp.live.match.activity.SearchActivity.this
                    com.cupidapp.live.search.adapter.SearchResultAdapter r5 = com.cupidapp.live.match.activity.SearchActivity.w1(r5)
                    r5.notifyDataSetChanged()
                    com.cupidapp.live.match.activity.SearchActivity r5 = com.cupidapp.live.match.activity.SearchActivity.this
                    int r1 = com.cupidapp.live.R$id.searchResultListView
                    android.view.View r5 = r5.r1(r1)
                    androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
                    r5.setVisibility(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.activity.SearchActivity$showIntelligentFilterView$2.invoke2(com.cupidapp.live.match.model.IntelligentFilterKeywordResult):void");
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.match.activity.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchActivity.Q1(Function1.this, obj);
            }
        };
        final SearchActivity$showIntelligentFilterView$3 searchActivity$showIntelligentFilterView$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$showIntelligentFilterView$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.activity.b0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchActivity.R1(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(subscribe, "private fun showIntellig…       })\n        )\n    }");
        H(subscribe);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.Search;
    }

    public final void S1() {
        Observable just;
        List<AddressModel> list = this.f16550s;
        if (list == null || list.isEmpty()) {
            Observable<R> flatMap = NetworkClient.f11868a.s().d().flatMap(new com.cupidapp.live.base.network.i());
            final Function1<ListResult<AddressModel>, kotlin.p> function1 = new Function1<ListResult<AddressModel>, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$showLocationView$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<AddressModel> listResult) {
                    invoke2(listResult);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListResult<AddressModel> listResult) {
                    SearchActivity.this.f16550s = listResult.getList();
                }
            };
            just = flatMap.doOnNext(new Consumer() { // from class: com.cupidapp.live.match.activity.c0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SearchActivity.T1(Function1.this, obj);
                }
            });
        } else {
            just = Observable.just(this.f16550s);
        }
        Observable observeOn = just.observeOn(AndroidSchedulers.mainThread());
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.match.activity.y
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchActivity.U1(SearchActivity.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$showLocationView$3
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
                SearchActivity.this.r1(R$id.bottom_map).setVisibility(0);
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.activity.a0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SearchActivity.V1(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(subscribe, "private fun showLocation…       })\n        )\n    }");
        H(subscribe);
    }

    public final void W1(String str) {
        GroupOthersLog.f18702a.c0(Q0(), str);
    }

    public final void X1(String str) {
        e1();
        FormBody.Builder builder = new FormBody.Builder(null, 1, null);
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        builder.add(as.at, String.valueOf(j10.getLatitude()));
        builder.add(as.au, String.valueOf(j10.getLongitude()));
        builder.add("matchKeywords[]", str);
        Disposable disposed = NetworkClient.f11868a.A().i(builder.build()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MatchSettingResult, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$updateIntelligentFilterKeyword$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MatchSettingResult matchSettingResult) {
                m2705invoke(matchSettingResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2705invoke(MatchSettingResult matchSettingResult) {
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
                SearchActivity.this.V0();
                MainActivity.F.f(SearchActivity.this, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? false : false, (r12 & 16) == 0 ? null : null, (r12 & 32) != 0 ? Boolean.FALSE : null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_search);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.alpha_out));
        int i10 = R$id.titleLayout;
        ConstraintLayout titleLayout = (ConstraintLayout) r1(i10);
        kotlin.jvm.internal.s.h(titleLayout, "titleLayout");
        z0.h.u(this, titleLayout);
        j1.c.b(j1.c.f50228a, SensorPosition.Search, null, null, 6, null);
        int i11 = R$id.searchResultListView;
        ((RecyclerView) r1(i11)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) r1(i11)).setAdapter(L1());
        ((RecyclerView) r1(i11)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i12) {
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
                SearchActivity searchActivity = SearchActivity.this;
                z0.h.p(searchActivity, (EditText) searchActivity.r1(R$id.searchEditText));
            }
        });
        new com.cupidapp.live.base.utils.g(kotlin.collections.r.e((EditText) r1(R$id.searchEditText)), new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                Disposable disposable;
                if (z10) {
                    SearchActivity.F1(SearchActivity.this, null, true, 1, null);
                    SearchActivity.this.N1(true);
                    disposable = SearchActivity.this.f16553v;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    final CharSequence text = ((EditText) SearchActivity.this.r1(R$id.searchEditText)).getText();
                    if (text == null) {
                        text = "";
                    }
                    SearchActivity searchActivity = SearchActivity.this;
                    Observable delay = a.C0836a.e(NetworkClient.f11868a.N(), text.toString(), null, 2, null).delay(500L, TimeUnit.MILLISECONDS);
                    kotlin.jvm.internal.s.h(delay, "NetworkClient.userServic…L, TimeUnit.MILLISECONDS)");
                    final SearchActivity searchActivity2 = SearchActivity.this;
                    Disposable disposed = delay.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SearchResult, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$2$invoke$$inlined$handle$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ kotlin.p invoke(SearchResult searchResult) {
                            m2704invoke(searchResult);
                            return kotlin.p.f51048a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2704invoke(SearchResult searchResult) {
                            SearchResult searchResult2 = searchResult;
                            if (CharSequence.this.length() == 0) {
                                ((ImageView) searchActivity2.r1(R$id.clearButton)).setVisibility(8);
                                ((ProgressBar) searchActivity2.r1(R$id.loadingView)).setVisibility(8);
                            } else {
                                searchActivity2.N1(false);
                                searchActivity2.M1(searchResult2);
                            }
                            searchActivity2.W1(CharSequence.this.toString());
                        }
                    }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$2.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull Throwable it) {
                            kotlin.jvm.internal.s.i(it, "it");
                            SearchActivity.this.N1(false);
                            return Boolean.FALSE;
                        }
                    }, searchActivity2)));
                    if (disposed != null) {
                        kotlin.jvm.internal.s.h(disposed, "disposed");
                        if (searchActivity2 != null) {
                            searchActivity2.H(disposed);
                        }
                    }
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    searchActivity.f16553v = disposed;
                    return;
                }
                ((ImageView) SearchActivity.this.r1(R$id.clearButton)).setVisibility(8);
                SearchActivity.F1(SearchActivity.this, null, false, 1, null);
                SearchActivity searchActivity3 = SearchActivity.this;
                EditText searchEditText = (EditText) searchActivity3.r1(R$id.searchEditText);
                kotlin.jvm.internal.s.h(searchEditText, "searchEditText");
                z0.h.v(searchActivity3, searchEditText);
            }
        });
        ImageView clearButton = (ImageView) r1(R$id.clearButton);
        kotlin.jvm.internal.s.h(clearButton, "clearButton");
        z0.y.d(clearButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$3
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
                ((EditText) SearchActivity.this.r1(R$id.searchEditText)).setText("");
            }
        });
        int i12 = R$id.cancelTextView;
        TextView cancelTextView = (TextView) r1(i12);
        kotlin.jvm.internal.s.h(cancelTextView, "cancelTextView");
        z0.y.d(cancelTextView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$4
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
                z0.h.q(SearchActivity.this, null, 1, null);
                SearchActivity.this.finish();
            }
        });
        TextView go_map_btn = (TextView) r1(R$id.go_map_btn);
        kotlin.jvm.internal.s.h(go_map_btn, "go_map_btn");
        z0.y.d(go_map_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$5
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
                xb.b bVar = new xb.b(SearchActivity.this);
                LocationUtils.Companion companion = LocationUtils.f12270h;
                final SearchActivity searchActivity = SearchActivity.this;
                companion.e(searchActivity, bVar, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$5.1
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
                        CoordinateModel j10 = LocationUtils.f12270h.a().j();
                        SearchActivity searchActivity2 = SearchActivity.this;
                        if (searchActivity2 != null) {
                            MapFilterNewActivity.f16502z.a(searchActivity2, Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude()), searchActivity2.Q0(), VipPurchaseEntranceType.SearchGuideMap);
                        }
                    }
                });
            }
        });
        TextView intelligent_filter_tab = (TextView) r1(R$id.intelligent_filter_tab);
        kotlin.jvm.internal.s.h(intelligent_filter_tab, "intelligent_filter_tab");
        z0.y.d(intelligent_filter_tab, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$6
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
                z0.h.q(SearchActivity.this, null, 1, null);
                SearchActivity.this.E1(TabState.INTELLIGENT, false);
                GroupOthersLog.f18702a.Q(SearchActivity.this.Q0().getValue(), "SMART_FILTER");
            }
        });
        int i13 = R$id.search_location_tab;
        TextView search_location_tab = (TextView) r1(i13);
        kotlin.jvm.internal.s.h(search_location_tab, "search_location_tab");
        z0.y.d(search_location_tab, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchActivity$onCreate$7
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
                z0.h.q(SearchActivity.this, null, 1, null);
                SearchActivity.this.E1(TabState.HOT_SEARCH_LOCATION, false);
                GroupOthersLog.f18702a.Q(SearchActivity.this.Q0().getValue(), "HOT_SPOT");
            }
        });
        ((ConstraintLayout) r1(i10)).setVisibility(0);
        ObjectAnimator.ofFloat((ConstraintLayout) r1(i10), (Property<ConstraintLayout, Float>) View.Y, -200.0f, 0.0f).setDuration(300L).start();
        ((TextView) r1(i12)).getPaint().setFakeBoldText(true);
        ((TextView) r1(i13)).setVisibility(0);
        E1(TabState.HOT_SEARCH_LOCATION, false);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull MatchFilterKeyClickEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (PurchaseProductType.Companion.c(event.getProductType())) {
            if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
                FKMatchFilterNewActivity.f16488t.a(this, false, true, FilterTabKey.MBTI.getValue());
                GroupOthersLog.f18702a.Q(Q0().getValue(), event.getWord());
                return;
            } else {
                PurchaseDialogManager.q(K1(), VipPurchaseEntranceType.SuperFilterInSearch, event.getWord(), null, false, false, 28, null);
                return;
            }
        }
        if (com.cupidapp.live.profile.logic.c.f17839a.b()) {
            X1(event.getWord());
            GroupOthersLog.f18702a.Q(Q0().getValue(), event.getWord());
        } else {
            PurchaseDialogManager.o(K1(), VipPurchaseEntranceType.IntelligentFilterInSearch, null, false, false, 14, null);
        }
    }

    @Nullable
    public View r1(int i10) {
        Map<Integer, View> map = this.f16555x;
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
}
