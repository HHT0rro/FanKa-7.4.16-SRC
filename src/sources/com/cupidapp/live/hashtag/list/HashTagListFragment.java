package com.cupidapp.live.hashtag.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.k;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.databinding.HashtagListFragmentBinding;
import com.cupidapp.live.hashtag.detail.HashTagMainActivity;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.hashtag.model.HashTagAggregationModel;
import com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: HashTagListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagListFragment extends FKBaseFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f14720k = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKSensorContext f14721e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f14722f;

    /* renamed from: g, reason: collision with root package name */
    public HashtagListFragmentBinding f14723g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f14724h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f14725i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14726j = new LinkedHashMap();

    /* compiled from: HashTagListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashTagListFragment a(@NotNull HashTagListType type, @Nullable FKSensorContext fKSensorContext) {
            s.i(type, "type");
            HashTagListFragment hashTagListFragment = new HashTagListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("page_type", type);
            bundle.putSerializable("sensor_context", fKSensorContext);
            hashTagListFragment.setArguments(bundle);
            return hashTagListFragment;
        }
    }

    public HashTagListFragment() {
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final HashTagListFragment hashTagListFragment = HashTagListFragment.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        s.i(p02, "p0");
                        Bundle arguments = HashTagListFragment.this.getArguments();
                        HashTagListType hashTagListType = (HashTagListType) (arguments != null ? arguments.getSerializable("page_type") : null);
                        if (hashTagListType == null) {
                            hashTagListType = HashTagListType.DATA_VIEW_HASHTAG;
                        }
                        return new HashTagListViewModel(hashTagListType);
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return k.b(this, cls, creationExtras);
                    }
                };
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f14722f = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(HashTagListViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, function0);
        this.f14724h = kotlin.c.b(new Function0<HashTagClassifyAdapter>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$classifyAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashTagClassifyAdapter invoke() {
                HashTagListViewModel a12;
                a12 = HashTagListFragment.this.a1();
                return new HashTagClassifyAdapter(a12);
            }
        });
        this.f14725i = kotlin.c.b(new Function0<HashTagContentAdapter>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$contentAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashTagContentAdapter invoke() {
                HashTagListViewModel a12;
                a12 = HashTagListFragment.this.a1();
                return new HashTagContentAdapter(a12);
            }
        });
    }

    public static final void e1(HashTagListFragment this$0, HashTagClassifyModel hashTagClassifyModel) {
        s.i(this$0, "this$0");
        this$0.Y0().notifyDataSetChanged();
    }

    public static final void g1(HashTagListFragment this$0) {
        s.i(this$0, "this$0");
        this$0.c1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14726j.clear();
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14726j;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final HashTagClassifyAdapter Y0() {
        return (HashTagClassifyAdapter) this.f14724h.getValue();
    }

    public final HashTagContentAdapter Z0() {
        return (HashTagContentAdapter) this.f14725i.getValue();
    }

    public final HashTagListViewModel a1() {
        return (HashTagListViewModel) this.f14722f.getValue();
    }

    public final void b1(HashTag hashTag) {
        SensorPosition sensorPosition;
        SensorPosition sensorPosition2;
        Context context = getContext();
        if (context != null) {
            SensorPosition sensorPosition3 = SensorPosition.HashtagList;
            FKSensorContext fKSensorContext = this.f14721e;
            if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
                sensorPosition = SensorPosition.Unknown;
            }
            FKSensorContext fKSensorContext2 = this.f14721e;
            if (fKSensorContext2 == null || (sensorPosition2 = fKSensorContext2.getSource()) == null) {
                sensorPosition2 = SensorPosition.Unknown;
            }
            HashTagMainActivity.A.a(context, hashTag.getItemId(), hashTag.getName(), new FeedSensorContext(sensorPosition3, sensorPosition, sensorPosition2, SensorScene.Hashtag));
        }
    }

    public final void c1() {
        Observable<Result<ListResult<HashTagAggregationModel>>> hashtagClassifies = a1().getHashtagClassifies();
        Object context = getContext();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$initData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                ((FKSwipeRefreshLayout) HashTagListFragment.this.U0(R$id.hashTagRefreshLayout)).setRefreshing(false);
                return Boolean.FALSE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = hashtagClassifies.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<HashTagAggregationModel>, p>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$initData$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<HashTagAggregationModel> listResult) {
                m2591invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2591invoke(ListResult<HashTagAggregationModel> listResult) {
                HashTagListViewModel a12;
                a12 = HashTagListFragment.this.a1();
                a12.setHashTagClassifies(listResult.getList());
                ((FKSwipeRefreshLayout) HashTagListFragment.this.U0(R$id.hashTagRefreshLayout)).setRefreshing(false);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void d1() {
        a1().getSelectClassifyLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.hashtag.list.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HashTagListFragment.e1(HashTagListFragment.this, (HashTagClassifyModel) obj);
            }
        });
        a1().getOpenHashTagEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<HashTag, p>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(HashTag hashTag) {
                invoke2(hashTag);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HashTag it) {
                s.i(it, "it");
                HashTagListFragment.this.b1(it);
            }
        }));
        a1().getSelectHashTagEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<HashTag, p>() { // from class: com.cupidapp.live.hashtag.list.HashTagListFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(HashTag hashTag) {
                invoke2(hashTag);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HashTag it) {
                s.i(it, "it");
                HashTagListFragment.this.h1(it);
            }
        }));
    }

    public final void f1() {
        ((RecyclerView) U0(R$id.hashtagClassifyRV)).setAdapter(Y0());
        int i10 = R$id.hashtagContentRV;
        ((RecyclerView) U0(i10)).setAdapter(Z0());
        ((RecyclerView) U0(i10)).addItemDecoration(new ExtraSpacingDecoration(h.c(this, 16.0f), h.c(this, 8.0f), h.c(this, 16.0f), h.c(this, 8.0f), h.c(this, 10.0f)));
        ((FKSwipeRefreshLayout) U0(R$id.hashTagRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.hashtag.list.d
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HashTagListFragment.g1(HashTagListFragment.this);
            }
        });
    }

    public final void h1(HashTag hashTag) {
        Intent intent = new Intent();
        intent.putExtra("select_hashtag_result", hashTag);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        HashtagListFragmentBinding b4 = HashtagListFragmentBinding.b(inflater, viewGroup, false);
        s.h(b4, "inflate(inflater, container, false)");
        this.f14723g = b4;
        if (b4 == null) {
            s.A("binding");
            b4 = null;
        }
        View root = b4.getRoot();
        s.h(root, "binding.root");
        return root;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        HashtagListFragmentBinding hashtagListFragmentBinding = null;
        this.f14721e = (FKSensorContext) (arguments != null ? arguments.getSerializable("sensor_context") : null);
        HashtagListFragmentBinding hashtagListFragmentBinding2 = this.f14723g;
        if (hashtagListFragmentBinding2 == null) {
            s.A("binding");
            hashtagListFragmentBinding2 = null;
        }
        hashtagListFragmentBinding2.d(a1());
        HashtagListFragmentBinding hashtagListFragmentBinding3 = this.f14723g;
        if (hashtagListFragmentBinding3 == null) {
            s.A("binding");
        } else {
            hashtagListFragmentBinding = hashtagListFragmentBinding3;
        }
        hashtagListFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());
        f1();
        d1();
        c1();
    }
}
