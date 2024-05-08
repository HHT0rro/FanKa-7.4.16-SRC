package com.cupidapp.live.liveshow.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.adapter.FKRecommendLiveListAdapter;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.viewholder.FKRecommendLiveShowModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;
import z0.h;

/* compiled from: FKLiveListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveListActivity extends FKBaseActivity {

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public static final a f14776w = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public String f14778r;

    /* renamed from: u, reason: collision with root package name */
    public long f14781u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14782v = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f14777q = kotlin.c.b(new Function0<FKRecommendLiveListAdapter>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$liveListAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKRecommendLiveListAdapter invoke() {
            final FKRecommendLiveListAdapter fKRecommendLiveListAdapter = new FKRecommendLiveListAdapter();
            final FKLiveListActivity fKLiveListActivity = FKLiveListActivity.this;
            fKRecommendLiveListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$liveListAdapter$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (obj instanceof FKRecommendLiveShowModel) {
                        List<Object> j10 = FKRecommendLiveListAdapter.this.j();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : j10) {
                            if (obj2 instanceof FKRecommendLiveShowModel) {
                                arrayList.add(obj2);
                            }
                        }
                        if (arrayList.contains(obj)) {
                            FKRecommendLiveShowModel fKRecommendLiveShowModel = (FKRecommendLiveShowModel) obj;
                            FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, fKLiveListActivity, new FKLiveForViewerViewModel(fKRecommendLiveShowModel.getLiveShow(), null, new LiveInRoomSensorModel(fKRecommendLiveShowModel.getEnterSource().name(), Integer.valueOf(arrayList.indexOf(obj) + 1), SensorScene.Live, SensorPosition.LiveContent, null, null, 48, null), false, 8, null), false, 4, null);
                        }
                    }
                }
            });
            return fKRecommendLiveListAdapter;
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f14779s = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FKLiveListActivity fKLiveListActivity = FKLiveListActivity.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$loadMoreListener$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    String str2;
                    str = FKLiveListActivity.this.f14778r;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    FKLiveListActivity fKLiveListActivity2 = FKLiveListActivity.this;
                    str2 = fKLiveListActivity2.f14778r;
                    fKLiveListActivity2.q1(str2);
                }
            });
        }
    });

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f14780t = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$title$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return FKLiveListActivity.this.getIntent().getStringExtra("LIVE_LIST_TITLE");
        }
    });

    /* compiled from: FKLiveListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable String str, @Nullable String str2) {
            Intent intent = new Intent(context, (Class<?>) FKLiveListActivity.class);
            intent.putExtra("LIVE_LIST_TITLE", str);
            intent.putExtra("LIVE_LIST_ID", str2);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static /* synthetic */ void r1(FKLiveListActivity fKLiveListActivity, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        fKLiveListActivity.q1(str);
    }

    public static final void w1(FKLiveListActivity this$0) {
        s.i(this$0, "this$0");
        this$0.x1();
        r1(this$0, null, 1, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.LiveContent;
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f14782v;
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
        setContentView(R$layout.activity_live_list);
        y1();
        v1();
        r1(this, null, 1, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.f14781u;
        int i10 = (int) ((currentTimeMillis - j10) / 1000);
        if (j10 <= 0 || i10 == 0) {
            return;
        }
        GroupOthersLog.f18702a.e(Q0(), i10);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f14781u = System.currentTimeMillis();
    }

    public final void q1(final String str) {
        String stringExtra = getIntent().getStringExtra("LIVE_LIST_ID");
        if (stringExtra == null) {
            return;
        }
        Disposable disposed = a.C0826a.c(NetworkClient.f11868a.r(), stringExtra, str, 0, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<LiveShowModel>, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$getLiveList$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<LiveShowModel> listResult) {
                m2603invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2603invoke(ListResult<LiveShowModel> listResult) {
                FKLoadMoreListener t12;
                FKRecommendLiveListAdapter s12;
                ArrayList arrayList;
                String str2;
                FKRecommendLiveListAdapter s13;
                FKRecommendLiveListAdapter s14;
                FKRecommendLiveListAdapter s15;
                FKRecommendLiveListAdapter s16;
                ListResult<LiveShowModel> listResult2 = listResult;
                ((FKSwipeRefreshLayout) FKLiveListActivity.this.k1(R$id.liveListRefreshLayout)).setRefreshing(false);
                t12 = FKLiveListActivity.this.t1();
                t12.c(false);
                FKLiveListActivity.this.f14778r = listResult2.getNextCursorId();
                if (str == null) {
                    s15 = FKLiveListActivity.this.s1();
                    s15.j().clear();
                    s16 = FKLiveListActivity.this.s1();
                    s16.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                }
                s12 = FKLiveListActivity.this.s1();
                List<LiveShowModel> list = listResult2.getList();
                if (list != null) {
                    arrayList = new ArrayList(t.t(list, 10));
                    Iterator<LiveShowModel> iterator2 = list.iterator2();
                    while (iterator2.hasNext()) {
                        arrayList.add(new FKRecommendLiveShowModel(iterator2.next(), SensorsLogLiveShow.EnterLiveShowSource.LIVE_COMPONENT, false, 4, null));
                    }
                } else {
                    arrayList = null;
                }
                s12.e(arrayList);
                str2 = FKLiveListActivity.this.f14778r;
                if (str2 == null || str2.length() == 0) {
                    s14 = FKLiveListActivity.this.s1();
                    s14.s();
                }
                s13 = FKLiveListActivity.this.s1();
                s13.notifyDataSetChanged();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$getLiveList$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener t12;
                s.i(it, "it");
                ((FKSwipeRefreshLayout) FKLiveListActivity.this.k1(R$id.liveListRefreshLayout)).setRefreshing(false);
                t12 = FKLiveListActivity.this.t1();
                t12.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final FKRecommendLiveListAdapter s1() {
        return (FKRecommendLiveListAdapter) this.f14777q.getValue();
    }

    public final FKLoadMoreListener t1() {
        return (FKLoadMoreListener) this.f14779s.getValue();
    }

    public final String u1() {
        return (String) this.f14780t.getValue();
    }

    public final void v1() {
        int i10 = R$id.liveListTitleLayout;
        FKTitleBarLayout liveListTitleLayout = (FKTitleBarLayout) k1(i10);
        s.h(liveListTitleLayout, "liveListTitleLayout");
        FKTitleBarLayout.setSingleTitle$default(liveListTitleLayout, u1(), null, 2, null);
        ((FKTitleBarLayout) k1(i10)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$initView$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLiveListActivity.this.finish();
            }
        });
        int i11 = R$id.liveListRecyclerView;
        RecyclerView initView$lambda$2 = (RecyclerView) k1(i11);
        initView$lambda$2.setAdapter(s1());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, s1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.liveshow.activity.FKLiveListActivity$initView$2$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i12) {
                FKRecommendLiveListAdapter s12;
                s12 = FKLiveListActivity.this.s1();
                return s12.u(i12);
            }
        });
        initView$lambda$2.setLayoutManager(gridLayoutManager);
        FKRecommendLiveListAdapter s12 = s1();
        s.h(initView$lambda$2, "initView$lambda$2");
        initView$lambda$2.addItemDecoration(new MutableColumnDecoration(s12, h.c(initView$lambda$2, 1.0f)));
        initView$lambda$2.addOnScrollListener(t1());
        FKRecommendLiveListAdapter s13 = s1();
        RecyclerView liveListRecyclerView = (RecyclerView) k1(i11);
        s.h(liveListRecyclerView, "liveListRecyclerView");
        s13.y(liveListRecyclerView, ExposureScene.LiveContent, SensorPosition.LiveContent);
        ((FKSwipeRefreshLayout) k1(R$id.liveListRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.liveshow.activity.f
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FKLiveListActivity.w1(FKLiveListActivity.this);
            }
        });
    }

    public final void x1() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.LiveContent);
    }

    public final void y1() {
        j1.c.b(j1.c.f50228a, SensorPosition.LiveContent, u1(), null, 4, null);
    }
}
