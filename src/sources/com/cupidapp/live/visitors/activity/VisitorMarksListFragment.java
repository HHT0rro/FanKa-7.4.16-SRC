package com.cupidapp.live.visitors.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.k;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.visitors.adapter.VisitorsAdapter;
import com.cupidapp.live.visitors.model.VisitorsViewModel;
import java.util.Collection;
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

/* compiled from: VisitorMarksListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorMarksListFragment extends FKBaseFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f18897j = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f18900g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f18901h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18902i = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18898e = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListFragment$operationPosition$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = VisitorMarksListFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("OPERATION_POSITION");
            }
            return null;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18899f = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListFragment$visitorMarkType$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = VisitorMarksListFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("type");
            }
            return null;
        }
    });

    /* compiled from: VisitorMarksListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorMarksListFragment a(@Nullable String str, @Nullable String str2) {
            VisitorMarksListFragment visitorMarksListFragment = new VisitorMarksListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("OPERATION_POSITION", str);
            bundle.putString("type", str2);
            visitorMarksListFragment.setArguments(bundle);
            return visitorMarksListFragment;
        }
    }

    public VisitorMarksListFragment() {
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final VisitorMarksListFragment visitorMarksListFragment = VisitorMarksListFragment.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListFragment$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        String a12;
                        s.i(p02, "p0");
                        a12 = VisitorMarksListFragment.this.a1();
                        return new VisitorMarksListViewModel(a12);
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return k.b(this, cls, creationExtras);
                    }
                };
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListFragment$special$$inlined$viewModels$default$1
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
        this.f18900g = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(VisitorMarksListViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListFragment$special$$inlined$viewModels$default$2
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
        this.f18901h = kotlin.c.b(new Function0<VisitorsAdapter>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListFragment$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorsAdapter invoke() {
                VisitorsAdapter visitorsAdapter = new VisitorsAdapter(null);
                final VisitorMarksListFragment visitorMarksListFragment = VisitorMarksListFragment.this;
                visitorsAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksListFragment$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        User user;
                        String Y0;
                        if (!(obj instanceof VisitorsViewModel) || (user = ((VisitorsViewModel) obj).getVisitorModel().getUser()) == null) {
                            return;
                        }
                        VisitorMarksListFragment visitorMarksListFragment2 = VisitorMarksListFragment.this;
                        Y0 = visitorMarksListFragment2.Y0();
                        SensorPosition sensorPosition = SensorPosition.Setting;
                        if (!s.d(Y0, sensorPosition.getValue())) {
                            sensorPosition = SensorPosition.Message;
                            if (!s.d(Y0, sensorPosition.getValue())) {
                                sensorPosition = null;
                            }
                        }
                        SensorPosition sensorPosition2 = sensorPosition;
                        String value = ViewProfilePrefer.VisitorToProfile.getValue();
                        SensorPosition sensorPosition3 = SensorPosition.MyVisitorsSubPage;
                        SensorScene sensorScene = SensorScene.MyVisitors;
                        UserProfileActivity.G.a(visitorMarksListFragment2.getContext(), user, new ProfileSensorContext(value, null, false, sensorPosition3, sensorPosition2, sensorScene), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                        GroupSocialLog.f18708a.u(sensorScene.getValue(), user.userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                    }
                });
                return visitorsAdapter;
            }
        });
    }

    public static final void c1(VisitorMarksListFragment this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            ((FKSwipeRefreshLayout) this$0.U0(R$id.visitor_mark_refresh_root)).setRefreshing(false);
            this$0.X0().j().clear();
            Collection collection = (Collection) stateResult.getData();
            if (collection == null || collection.isEmpty()) {
                this$0.X0().j().add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_empty_footer), Integer.valueOf(R$string.no_qualified_visitors), null, null, null, null, null, false, null, null, 1020, null));
            } else {
                this$0.X0().j().addAll((Collection) stateResult.getData());
            }
            this$0.X0().notifyDataSetChanged();
            return;
        }
        if (stateResult instanceof StateResult.a) {
            ((FKSwipeRefreshLayout) this$0.U0(R$id.visitor_mark_refresh_root)).setRefreshing(false);
        }
    }

    public static final void e1(VisitorMarksListFragment this$0) {
        s.i(this$0, "this$0");
        this$0.Z0().loadData();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18902i.clear();
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18902i;
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

    public final VisitorsAdapter X0() {
        return (VisitorsAdapter) this.f18901h.getValue();
    }

    public final String Y0() {
        return (String) this.f18898e.getValue();
    }

    public final VisitorMarksListViewModel Z0() {
        return (VisitorMarksListViewModel) this.f18900g.getValue();
    }

    public final String a1() {
        return (String) this.f18899f.getValue();
    }

    public final void b1() {
        Z0().getListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.visitors.activity.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VisitorMarksListFragment.c1(VisitorMarksListFragment.this, (StateResult) obj);
            }
        });
    }

    public final void d1() {
        int i10 = R$id.visitor_mark_rv;
        ((RecyclerView) U0(i10)).setAdapter(X0());
        ((RecyclerView) U0(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((FKSwipeRefreshLayout) U0(R$id.visitor_mark_refresh_root)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.visitors.activity.f
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                VisitorMarksListFragment.e1(VisitorMarksListFragment.this);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        d1();
        b1();
        j1.c.b(j1.c.f50228a, SensorPosition.MyVisitorsSubPage, a1(), null, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.visitor_marks_list_fragment, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }
}
