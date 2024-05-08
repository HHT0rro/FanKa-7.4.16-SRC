package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.match.adapter.NearMatchAdapter;
import com.cupidapp.live.match.model.NearMatchModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearMatchActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearMatchActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f16524v = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16526r;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16529u = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16525q = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$isUsingMap$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            Intent intent = NearMatchActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("isUsingMap", false) : false);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f16527s = kotlin.c.b(new Function0<NearMatchAdapter>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final NearMatchAdapter invoke() {
            NearMatchAdapter nearMatchAdapter = new NearMatchAdapter();
            final NearMatchActivity nearMatchActivity = NearMatchActivity.this;
            nearMatchAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$adapter$2$1$1
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
                    if (obj instanceof NearMatchModel) {
                        NearMatchActivity.this.w1(((NearMatchModel) obj).getUser());
                    }
                }
            });
            return nearMatchAdapter;
        }
    });

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f16528t = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final NearMatchActivity nearMatchActivity = NearMatchActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$loadMoreListener$2.1
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
                    NearMatchViewModel q12;
                    q12 = NearMatchActivity.this.q1();
                    q12.getData(false);
                }
            });
        }
    });

    /* compiled from: NearMatchActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable ArrayList<NearMatchModel> arrayList, @Nullable String str, boolean z10) {
            kotlin.jvm.internal.s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) NearMatchActivity.class);
            intent.putExtra("list", arrayList);
            intent.putExtra("cursor", str);
            intent.putExtra("isUsingMap", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public NearMatchActivity() {
        final Function0 function0 = null;
        this.f16526r = new ViewModelLazy(kotlin.jvm.internal.v.b(NearMatchViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final NearMatchActivity nearMatchActivity = NearMatchActivity.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        kotlin.jvm.internal.s.i(p02, "p0");
                        Serializable serializableExtra = NearMatchActivity.this.getIntent().getSerializableExtra("list");
                        return new NearMatchViewModel(serializableExtra instanceof ArrayList ? (ArrayList) serializableExtra : null, NearMatchActivity.this.getIntent().getStringExtra("cursor"));
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$special$$inlined$viewModels$default$3
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

    public static final void s1(NearMatchActivity this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.l1(R$id.near_match_refresh)).setRefreshing(false);
        this$0.p1().c(false);
        if (pair.getFirst() instanceof StateResult.c) {
            Collection<? extends Object> collection = (List) ((StateResult) pair.getFirst()).getData();
            if (collection == null) {
                collection = new ArrayList<>();
            }
            if (((Boolean) pair.getSecond()).booleanValue()) {
                this$0.o1().j().clear();
                if (collection.isEmpty()) {
                    ((TextView) this$0.l1(R$id.near_match_tip_txt)).setVisibility(8);
                    this$0.o1().j().add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_near_match_empty), Integer.valueOf(R$string.near_match_empty), null, -8618884, null, null, null, false, null, null, 1012, null));
                    this$0.o1().notifyDataSetChanged();
                    return;
                } else {
                    ((TextView) this$0.l1(R$id.near_match_tip_txt)).setVisibility(0);
                    this$0.o1().j().addAll(collection);
                    this$0.o1().notifyDataSetChanged();
                    return;
                }
            }
            if (!collection.isEmpty()) {
                this$0.o1().j().addAll(collection);
                this$0.o1().notifyDataSetChanged();
            }
        }
    }

    public static final void u1(NearMatchActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.l1(R$id.near_match_refresh)).setRefreshing(true);
        this$0.q1().getData(true);
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f16529u;
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

    public final NearMatchAdapter o1() {
        return (NearMatchAdapter) this.f16527s.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_near_match);
        t1();
        r1();
        q1().getData(true);
        z3.d.f54832a.F();
    }

    public final FKLoadMoreListener p1() {
        return (FKLoadMoreListener) this.f16528t.getValue();
    }

    public final NearMatchViewModel q1() {
        return (NearMatchViewModel) this.f16526r.getValue();
    }

    public final void r1() {
        q1().getNearMatchListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearMatchActivity.s1(NearMatchActivity.this, (Pair) obj);
            }
        });
    }

    public final void t1() {
        ((FKSwipeRefreshLayout) l1(R$id.near_match_refresh)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.match.activity.v
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                NearMatchActivity.u1(NearMatchActivity.this);
            }
        });
        int i10 = R$id.near_match_rv;
        ((RecyclerView) l1(i10)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) l1(i10)).setAdapter(o1());
        ((RecyclerView) l1(i10)).addOnScrollListener(p1());
        ((FKTitleBarLayout) l1(R$id.near_match_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearMatchActivity$initView$2
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
                NearMatchActivity.this.finish();
            }
        });
    }

    public final boolean v1() {
        return ((Boolean) this.f16525q.getValue()).booleanValue();
    }

    public final void w1(User user) {
        if (user == null) {
            return;
        }
        UserProfileActivity.G.a(this, user, new ProfileSensorContext(ViewProfilePrefer.NearByMapToProfile.getValue(), null, user.getMe(), SensorPosition.NearMatch, null, SensorScene.MapFind), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : v1());
    }
}
