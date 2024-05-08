package com.cupidapp.live.feed.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.decoration.ProfileGridDecoration;
import com.cupidapp.live.feed.adapter.HashTagFeedListAdapter;
import com.cupidapp.live.feed.holder.HashTagHeadViewHolder;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.HashTagFeedResult;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.activity.MediaPickerActivity;
import com.cupidapp.live.mediapicker.event.FeedPublishSuccessEvent;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.model.MediaPickerActivityModel;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import f2.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagFeedListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagFeedListActivity extends FKBaseActivity {

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public static final a f14075z = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public String f14077r;

    /* renamed from: t, reason: collision with root package name */
    public FeedSensorContext f14079t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final HashTagFeedListAdapter f14080u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public final Lazy f14081v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14082w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.o f14083x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14084y = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f14076q = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(HashTagFeedListActivity.this);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f14078s = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$mHashTagId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return HashTagFeedListActivity.this.getIntent().getStringExtra("HASH_TAG_ID");
        }
    });

    /* compiled from: HashTagFeedListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable String str, @NotNull FeedSensorContext sensorContext) {
            kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
            if (context != null) {
                if (str == null || str.length() == 0) {
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) HashTagFeedListActivity.class);
                intent.putExtra("HASH_TAG_ID", str);
                z0.g.c(intent, sensorContext);
                context.startActivity(intent);
                FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
            }
        }
    }

    /* compiled from: HashTagFeedListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements o.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            j1.k.f50238a.a(HashTagFeedListActivity.this.Q0(), (i10 & 2) != 0 ? null : null, (i10 & 4) != 0 ? null : null, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            kotlin.jvm.internal.s.i(imageUriString, "imageUriString");
            j1.k.f50238a.d(HashTagFeedListActivity.this.Q0(), z10);
        }
    }

    public HashTagFeedListActivity() {
        HashTagFeedListAdapter hashTagFeedListAdapter = new HashTagFeedListAdapter();
        hashTagFeedListAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$hashTagFeedListAdapter$1$1
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
                if (obj instanceof FeedModel) {
                    HashTagFeedListActivity.this.C1((FeedModel) obj);
                }
            }
        });
        this.f14080u = hashTagFeedListAdapter;
        this.f14081v = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final HashTagFeedListActivity hashTagFeedListActivity = HashTagFeedListActivity.this;
                return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$loadMoreListener$2.1
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
                        String str;
                        String str2;
                        str = HashTagFeedListActivity.this.f14077r;
                        if (str == null || str.length() == 0) {
                            return;
                        }
                        HashTagFeedListActivity hashTagFeedListActivity2 = HashTagFeedListActivity.this;
                        str2 = hashTagFeedListActivity2.f14077r;
                        hashTagFeedListActivity2.A1(str2);
                    }
                });
            }
        });
        this.f14082w = true;
    }

    public static /* synthetic */ void B1(HashTagFeedListActivity hashTagFeedListActivity, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        hashTagFeedListActivity.A1(str);
    }

    public static final void z1(HashTagFeedListActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        B1(this$0, null, 1, null);
    }

    public final void A1(final String str) {
        String w12 = w1();
        if (w12 == null || w12.length() == 0) {
            return;
        }
        Disposable disposed = a.C0731a.j(NetworkClient.f11868a.l(), w12, str, 0, 4, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<HashTagFeedResult, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$loadHashTagFeedListData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(HashTagFeedResult hashTagFeedResult) {
                m2556invoke(hashTagFeedResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2556invoke(HashTagFeedResult hashTagFeedResult) {
                FKLoadMoreListener v12;
                HashTagFeedListAdapter hashTagFeedListAdapter;
                boolean z10;
                HashTagFeedListAdapter hashTagFeedListAdapter2;
                HashTagFeedListAdapter hashTagFeedListAdapter3;
                HashTagFeedListAdapter hashTagFeedListAdapter4;
                HashTagFeedListAdapter hashTagFeedListAdapter5;
                HashTagFeedListAdapter hashTagFeedListAdapter6;
                HashTagFeedListAdapter hashTagFeedListAdapter7;
                HashTagFeedListAdapter hashTagFeedListAdapter8;
                HashTagFeedListAdapter hashTagFeedListAdapter9;
                HashTagFeedResult hashTagFeedResult2 = hashTagFeedResult;
                v12 = HashTagFeedListActivity.this.v1();
                v12.c(false);
                ((FKSwipeRefreshLayout) HashTagFeedListActivity.this.k1(R$id.hashTagRefreshLayout)).setRefreshing(false);
                HashTagFeedListActivity.this.f14077r = hashTagFeedResult2.getNextCursorId();
                hashTagFeedListAdapter = HashTagFeedListActivity.this.f14080u;
                int n10 = hashTagFeedListAdapter.n();
                if (str == null) {
                    hashTagFeedListAdapter7 = HashTagFeedListActivity.this.f14080u;
                    hashTagFeedListAdapter7.j().clear();
                    hashTagFeedListAdapter8 = HashTagFeedListActivity.this.f14080u;
                    hashTagFeedListAdapter8.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                    HashTag hashtag = hashTagFeedResult2.getHashtag();
                    FKTitleBarLayout hashTagTitleBarLayout = (FKTitleBarLayout) HashTagFeedListActivity.this.k1(R$id.hashTagTitleBarLayout);
                    kotlin.jvm.internal.s.h(hashTagTitleBarLayout, "hashTagTitleBarLayout");
                    FKTitleBarLayout.setSingleTitle$default(hashTagTitleBarLayout, hashtag.getName(), null, 2, null);
                    hashTagFeedListAdapter9 = HashTagFeedListActivity.this.f14080u;
                    hashTagFeedListAdapter9.d(hashtag);
                }
                List<FeedModel> list = hashTagFeedResult2.getList();
                if (list != null) {
                    hashTagFeedListAdapter6 = HashTagFeedListActivity.this.f14080u;
                    hashTagFeedListAdapter6.e(list);
                }
                if (hashTagFeedResult2.getNextCursorId() == null) {
                    hashTagFeedListAdapter5 = HashTagFeedListActivity.this.f14080u;
                    FKFooterViewModel h10 = hashTagFeedListAdapter5.h();
                    if (h10 != null) {
                        h10.setShowProgress(false);
                    }
                }
                z10 = HashTagFeedListActivity.this.f14082w;
                if (z10) {
                    j1.c.b(j1.c.f50228a, SensorPosition.Hashtag, hashTagFeedResult2.getHashtag().getName(), null, 4, null);
                    HashTagFeedListActivity.this.f14082w = false;
                }
                if (str == null) {
                    hashTagFeedListAdapter4 = HashTagFeedListActivity.this.f14080u;
                    hashTagFeedListAdapter4.notifyDataSetChanged();
                } else {
                    hashTagFeedListAdapter2 = HashTagFeedListActivity.this.f14080u;
                    hashTagFeedListAdapter3 = HashTagFeedListActivity.this.f14080u;
                    hashTagFeedListAdapter2.notifyItemRangeChanged(n10, hashTagFeedListAdapter3.n() - n10);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$loadHashTagFeedListData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener v12;
                kotlin.jvm.internal.s.i(it, "it");
                v12 = HashTagFeedListActivity.this.v1();
                v12.c(false);
                ((FKSwipeRefreshLayout) HashTagFeedListActivity.this.k1(R$id.hashTagRefreshLayout)).setRefreshing(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void C1(FeedModel feedModel) {
        List<Object> j10 = this.f14080u.j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FeedModel) {
                arrayList.add(obj);
            }
        }
        List<Object> j11 = this.f14080u.j();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : j11) {
            if (obj2 instanceof HashTag) {
                arrayList2.add(obj2);
            }
        }
        HashTag hashTag = (HashTag) CollectionsKt___CollectionsKt.V(arrayList2);
        final String w12 = w1();
        com.cupidapp.live.feed.helper.i iVar = new com.cupidapp.live.feed.helper.i(true, null, arrayList, arrayList.indexOf(feedModel), this.f14077r, false, new Function1<String, Observable<Result<? extends ListResult<FeedModel>>>>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$openFeedDetailList$dataSource$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Observable<Result<ListResult<FeedModel>>> invoke(@Nullable String str) {
                String str2 = String.this;
                if (str2 == null || str2.length() == 0) {
                    return null;
                }
                return a.C0731a.k(NetworkClient.f11868a.l(), String.this, str, 0, 4, null);
            }
        });
        SensorPosition sensorPosition = SensorPosition.PostStream;
        FeedSensorContext feedSensorContext = this.f14079t;
        if (feedSensorContext == null) {
            kotlin.jvm.internal.s.A("feedSensorContext");
            feedSensorContext = null;
        }
        SensorPosition position = feedSensorContext.getPosition();
        FeedSensorContext feedSensorContext2 = this.f14079t;
        if (feedSensorContext2 == null) {
            kotlin.jvm.internal.s.A("feedSensorContext");
            feedSensorContext2 = null;
        }
        SensorPosition source = feedSensorContext2.getSource();
        FeedSensorContext feedSensorContext3 = this.f14079t;
        if (feedSensorContext3 == null) {
            kotlin.jvm.internal.s.A("feedSensorContext");
            feedSensorContext3 = null;
        }
        FeedDetailListActivity.f14060v.a(this, iVar, hashTag != null ? hashTag.getName() : null, new FeedSensorContext(sensorPosition, position, source, feedSensorContext3.getScene()), true);
    }

    public final void D1() {
        com.cupidapp.live.base.utils.o c4 = com.cupidapp.live.base.utils.o.f12354i.c(this);
        this.f14083x = c4;
        if (c4 != null) {
            c4.l(new b());
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.Hashtag;
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f14084y;
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
        setContentView(R$layout.activity_hash_tag_feed_list);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        FeedSensorContext feedSensorContext = (FeedSensorContext) z0.g.a(intent, FeedSensorContext.class);
        if (feedSensorContext == null) {
            finish();
        }
        kotlin.jvm.internal.s.f(feedSensorContext);
        this.f14079t = feedSensorContext;
        y1();
        B1(this, null, 1, null);
        D1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) k1(R$id.hashTagRecyclerView)).findViewHolderForLayoutPosition(0);
        HashTagHeadViewHolder hashTagHeadViewHolder = findViewHolderForLayoutPosition instanceof HashTagHeadViewHolder ? (HashTagHeadViewHolder) findViewHolderForLayoutPosition : null;
        if (hashTagHeadViewHolder != null) {
            hashTagHeadViewHolder.u();
        }
        super.onDestroy();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FeedPublishSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        ((RecyclerView) k1(R$id.hashTagRecyclerView)).scrollToPosition(0);
        ((FKSwipeRefreshLayout) k1(R$id.hashTagRefreshLayout)).setRefreshing(true);
        B1(this, null, 1, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.cupidapp.live.base.utils.o oVar = this.f14083x;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String singleTitle = ((FKTitleBarLayout) k1(R$id.hashTagTitleBarLayout)).getSingleTitle();
        if ((singleTitle.length() > 0) && !this.f14082w) {
            j1.c.b(j1.c.f50228a, SensorPosition.Hashtag, singleTitle, null, 4, null);
        }
        com.cupidapp.live.base.utils.o oVar = this.f14083x;
        if (oVar != null) {
            oVar.m();
        }
    }

    public final FKLoadMoreListener v1() {
        return (FKLoadMoreListener) this.f14081v.getValue();
    }

    public final String w1() {
        return (String) this.f14078s.getValue();
    }

    public final xb.b x1() {
        return (xb.b) this.f14076q.getValue();
    }

    public final void y1() {
        ((FKSwipeRefreshLayout) k1(R$id.hashTagRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.feed.activity.v
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HashTagFeedListActivity.z1(HashTagFeedListActivity.this);
            }
        });
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) k1(R$id.hashTagTitleBarLayout);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$initView$2$1
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
                HashTagFeedListActivity.this.finish();
            }
        });
        fKTitleBarLayout.setRightImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$initView$2$2
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
                xb.b x12;
                FeedSensorContext feedSensorContext;
                FKRxPermissionAlertDialog.Companion companion = FKRxPermissionAlertDialog.f12016a;
                HashTagFeedListActivity hashTagFeedListActivity = HashTagFeedListActivity.this;
                x12 = hashTagFeedListActivity.x1();
                final HashTagFeedListActivity hashTagFeedListActivity2 = HashTagFeedListActivity.this;
                companion.m(hashTagFeedListActivity, x12, (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.HashTagFeedListActivity$initView$2$2.1
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
                        HashTagFeedListAdapter hashTagFeedListAdapter;
                        hashTagFeedListAdapter = HashTagFeedListActivity.this.f14080u;
                        List<Object> j10 = hashTagFeedListAdapter.j();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : j10) {
                            if (obj instanceof HashTag) {
                                arrayList.add(obj);
                            }
                        }
                        HashTag hashTag = (HashTag) CollectionsKt___CollectionsKt.V(arrayList);
                        HashTagSimpleModel simpleHashTag = hashTag != null ? hashTag.getSimpleHashTag() : null;
                        if (simpleHashTag != null) {
                            MediaPickerActivity.A.a(HashTagFeedListActivity.this, new MediaPickerActivityModel(simpleHashTag, false, -1, MediaType.ALL, null, null, null, null, SensorPosition.Hashtag, CameraStartPosition.FeedPublish, 242, null));
                        }
                    }
                }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                feedSensorContext = HashTagFeedListActivity.this.f14079t;
                if (feedSensorContext == null) {
                    kotlin.jvm.internal.s.A("feedSensorContext");
                    feedSensorContext = null;
                }
                sensorsLogFeed.A(feedSensorContext.getScene(), SensorPosition.Hashtag, null);
            }
        });
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(this.f14080u.v(), 1);
        RecyclerView initView$lambda$4 = (RecyclerView) k1(R$id.hashTagRecyclerView);
        initView$lambda$4.setAdapter(this.f14080u);
        initView$lambda$4.setLayoutManager(staggeredGridLayoutManager);
        HashTagFeedListAdapter hashTagFeedListAdapter = this.f14080u;
        kotlin.jvm.internal.s.h(initView$lambda$4, "initView$lambda$4");
        initView$lambda$4.addItemDecoration(new ProfileGridDecoration(hashTagFeedListAdapter, z0.h.c(initView$lambda$4, 2.0f)));
        RecyclerView.ItemAnimator itemAnimator = initView$lambda$4.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        initView$lambda$4.addOnScrollListener(v1());
    }
}
