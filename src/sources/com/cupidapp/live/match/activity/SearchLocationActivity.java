package com.cupidapp.live.match.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.maps.model.LatLng;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.databinding.ActivitySearchLocationBinding;
import com.cupidapp.live.feed.layout.FlowLayout;
import com.cupidapp.live.match.adapter.SearchHistoryAdapter;
import com.cupidapp.live.match.adapter.SearchLocationAdapter;
import com.cupidapp.live.match.model.AddressModel;
import com.cupidapp.live.match.viewmodel.SearchLocationViewModel;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.as;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchLocationActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchLocationActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f16558u = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f16561s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16562t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16559q = kotlin.c.b(new Function0<SearchLocationAdapter>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$searchAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SearchLocationAdapter invoke() {
            SearchLocationAdapter searchLocationAdapter = new SearchLocationAdapter();
            final SearchLocationActivity searchLocationActivity = SearchLocationActivity.this;
            searchLocationAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$searchAdapter$2$1$1
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
                    if (obj instanceof AddressModel) {
                        AddressModel addressModel = (AddressModel) obj;
                        SearchLocationActivity.this.B1(addressModel);
                        SearchLocationActivity.this.C1(addressModel, false);
                    }
                }
            });
            return searchLocationAdapter;
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16560r = kotlin.c.b(new Function0<SearchHistoryAdapter>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$historyAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SearchHistoryAdapter invoke() {
            SearchHistoryAdapter searchHistoryAdapter = new SearchHistoryAdapter();
            final SearchLocationActivity searchLocationActivity = SearchLocationActivity.this;
            searchHistoryAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$historyAdapter$2$1$1
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
                    if (obj instanceof AddressModel) {
                        AddressModel addressModel = (AddressModel) obj;
                        SearchLocationActivity.this.B1(addressModel);
                        SearchLocationActivity.this.C1(addressModel, false);
                    }
                }
            });
            return searchHistoryAdapter;
        }
    });

    /* compiled from: SearchLocationActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, @Nullable Double d10, @Nullable Double d11, @NotNull String from, int i10) {
            kotlin.jvm.internal.s.i(activity, "activity");
            kotlin.jvm.internal.s.i(from, "from");
            Intent intent = new Intent(activity, (Class<?>) SearchLocationActivity.class);
            intent.putExtra(as.at, d10);
            intent.putExtra(as.au, d11);
            intent.putExtra(RemoteMessageConst.FROM, from);
            activity.startActivityForResult(intent, i10);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, activity, 0, 0, 6, null);
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            SearchLocationActivity.this.t1().changeSearchContent(String.valueOf(editable != null ? StringsKt__StringsKt.P0(editable) : null));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public SearchLocationActivity() {
        final Function0 function0 = null;
        this.f16561s = new ViewModelLazy(kotlin.jvm.internal.v.b(SearchLocationViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final SearchLocationActivity searchLocationActivity = SearchLocationActivity.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        String value;
                        kotlin.jvm.internal.s.i(p02, "p0");
                        Intent intent = SearchLocationActivity.this.getIntent();
                        double d10 = ShadowDrawableWrapper.COS_45;
                        double doubleExtra = intent != null ? intent.getDoubleExtra(as.at, ShadowDrawableWrapper.COS_45) : 0.0d;
                        Intent intent2 = SearchLocationActivity.this.getIntent();
                        if (intent2 != null) {
                            d10 = intent2.getDoubleExtra(as.au, ShadowDrawableWrapper.COS_45);
                        }
                        Intent intent3 = SearchLocationActivity.this.getIntent();
                        if (intent3 == null || (value = intent3.getStringExtra(RemoteMessageConst.FROM)) == null) {
                            value = SensorPosition.Unknown.getValue();
                        }
                        kotlin.jvm.internal.s.h(value, "intent?.getStringExtra(D…sorPosition.Unknown.value");
                        Double valueOf = Double.valueOf(doubleExtra);
                        Double valueOf2 = Double.valueOf(d10);
                        Application application = SearchLocationActivity.this.getApplication();
                        kotlin.jvm.internal.s.h(application, "application");
                        return new SearchLocationViewModel(valueOf, valueOf2, value, application);
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                kotlin.jvm.internal.s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void A1(SearchLocationActivity this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.r1().j().clear();
        this$0.r1().e(list);
        this$0.r1().notifyDataSetChanged();
    }

    public static final boolean w1(SearchLocationActivity this$0, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (i10 != 3) {
            return false;
        }
        if (!this$0.s1().j().isEmpty()) {
            Object obj = this$0.s1().j().get(0);
            if (obj instanceof AddressModel) {
                AddressModel addressModel = (AddressModel) obj;
                this$0.B1(addressModel);
                this$0.C1(addressModel, false);
            } else {
                SearchLocationViewModel t12 = this$0.t1();
                Editable text = ((EditText) this$0.n1(R$id.search_edit)).getText();
                kotlin.jvm.internal.s.h(text, "search_edit.text");
                t12.searchAgain(StringsKt__StringsKt.P0(text).toString());
            }
        } else {
            SearchLocationViewModel t13 = this$0.t1();
            Editable text2 = ((EditText) this$0.n1(R$id.search_edit)).getText();
            kotlin.jvm.internal.s.h(text2, "search_edit.text");
            t13.searchAgain(StringsKt__StringsKt.P0(text2).toString());
        }
        return true;
    }

    public static final void y1(final SearchLocationActivity this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FlowLayout) this$0.n1(R$id.search_hot_flow)).removeAllViews();
        if (list != null) {
            Iterator<E> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                final AddressModel addressModel = (AddressModel) iterator2.next();
                LayoutInflater from = LayoutInflater.from(this$0);
                int i10 = R$id.search_hot_flow;
                View child = from.inflate(R$layout.item_hot_city, (ViewGroup) this$0.n1(i10), false);
                ((TextView) child.findViewById(R$id.item_city_txt)).setText(addressModel.getName());
                kotlin.jvm.internal.s.h(child, "child");
                z0.y.d(child, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$initViewModelObserve$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        SearchLocationActivity.this.B1(addressModel);
                        SearchLocationActivity.this.C1(addressModel, true);
                    }
                });
                ((FlowLayout) this$0.n1(i10)).addView(child);
            }
        }
    }

    public static final void z1(SearchLocationActivity this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.s1().j().clear();
        if (list == null || list.isEmpty()) {
            this$0.s1().d(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_empty_location), null, this$0.getString(R$string.search_location_result_tip), null, null, null, null, false, null, null, 1018, null));
        } else {
            this$0.s1().e(list);
        }
        this$0.s1().notifyDataSetChanged();
    }

    public final void B1(AddressModel addressModel) {
        if (kotlin.jvm.internal.s.d(t1().getFrom(), SensorPosition.TravelMap.getValue())) {
            Intent intent = new Intent();
            intent.putExtra("location", addressModel);
            setResult(-1, intent);
            finish();
            return;
        }
        if (addressModel.getLatitude() == null || addressModel.getLongitude() == null) {
            return;
        }
        SearchLocationViewModel t12 = t1();
        Double latitude = addressModel.getLatitude();
        kotlin.jvm.internal.s.f(latitude);
        double doubleValue = latitude.doubleValue();
        Double longitude = addressModel.getLongitude();
        kotlin.jvm.internal.s.f(longitude);
        t12.saveLocation(new LatLng(doubleValue, longitude.doubleValue()), addressModel.getName());
    }

    public final void C1(AddressModel addressModel, boolean z10) {
        if (kotlin.jvm.internal.s.d(t1().getFrom(), SensorPosition.TravelMap.getValue())) {
            return;
        }
        z3.d.f54832a.D(addressModel.getLatitude(), addressModel.getLongitude(), addressModel.getName(), z10);
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f16562t;
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
        ActivitySearchLocationBinding activitySearchLocationBinding = (ActivitySearchLocationBinding) DataBindingUtil.setContentView(this, R$layout.activity_search_location);
        activitySearchLocationBinding.b(t1());
        activitySearchLocationBinding.setLifecycleOwner(this);
        u1();
        x1();
        t1().initData();
        v1();
    }

    public final SearchHistoryAdapter r1() {
        return (SearchHistoryAdapter) this.f16560r.getValue();
    }

    public final SearchLocationAdapter s1() {
        return (SearchLocationAdapter) this.f16559q.getValue();
    }

    public final SearchLocationViewModel t1() {
        return (SearchLocationViewModel) this.f16561s.getValue();
    }

    public final void u1() {
        TextView hot_title_txt = (TextView) n1(R$id.hot_title_txt);
        kotlin.jvm.internal.s.h(hot_title_txt, "hot_title_txt");
        z0.u.a(hot_title_txt);
        TextView history_txt = (TextView) n1(R$id.history_txt);
        kotlin.jvm.internal.s.h(history_txt, "history_txt");
        z0.u.a(history_txt);
        int i10 = R$id.search_location_rv;
        ((RecyclerView) n1(i10)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) n1(i10)).setAdapter(s1());
        int i11 = R$id.search_history_rv;
        ((RecyclerView) n1(i11)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) n1(i11)).setAdapter(r1());
    }

    public final void v1() {
        int i10 = R$id.search_edit;
        EditText search_edit = (EditText) n1(i10);
        kotlin.jvm.internal.s.h(search_edit, "search_edit");
        search_edit.addTextChangedListener(new b());
        TextView search_cancel_txt = (TextView) n1(R$id.search_cancel_txt);
        kotlin.jvm.internal.s.h(search_cancel_txt, "search_cancel_txt");
        z0.y.d(search_cancel_txt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$initViewListener$2
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
                SearchLocationActivity.this.finish();
            }
        });
        ImageView search_clear_img = (ImageView) n1(R$id.search_clear_img);
        kotlin.jvm.internal.s.h(search_clear_img, "search_clear_img");
        z0.y.d(search_clear_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$initViewListener$3
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
                ((EditText) SearchLocationActivity.this.n1(R$id.search_edit)).setText((CharSequence) null);
            }
        });
        ((EditText) n1(i10)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.match.activity.g0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                boolean w12;
                w12 = SearchLocationActivity.w1(SearchLocationActivity.this, textView, i11, keyEvent);
                return w12;
            }
        });
    }

    public final void x1() {
        t1().getHotsLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.h0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchLocationActivity.y1(SearchLocationActivity.this, (List) obj);
            }
        });
        t1().getSearchResultLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.i0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchLocationActivity.z1(SearchLocationActivity.this, (List) obj);
            }
        });
        t1().getHistoryLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.j0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchLocationActivity.A1(SearchLocationActivity.this, (List) obj);
            }
        });
        t1().getOpenMapEvent().observe(this, new EventObserver(new Function1<AddressModel, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$initViewModelObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(AddressModel addressModel) {
                invoke2(addressModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AddressModel location) {
                kotlin.jvm.internal.s.i(location, "location");
                SearchLocationActivity.this.B1(location);
            }
        }));
        t1().getOpenNearByEvent().observe(this, new EventObserver(new Function1<kotlin.p, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$initViewModelObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(kotlin.p pVar) {
                invoke2(pVar);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull kotlin.p it) {
                kotlin.jvm.internal.s.i(it, "it");
                MainActivity.F.e("match", SearchLocationActivity.this, "near");
            }
        }));
        t1().getShowLoading().observe(this, new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.activity.SearchLocationActivity$initViewModelObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                if (z10) {
                    SearchLocationActivity.this.e1();
                } else {
                    SearchLocationActivity.this.V0();
                }
            }
        }));
    }
}
