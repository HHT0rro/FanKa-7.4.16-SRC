package com.cupidapp.live.mediapicker.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.mediapicker.adapter.FeedTagPickerAdapter;
import f2.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTagPickerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedTagPickerActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f17093u = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public String f17095r;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17097t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17094q = kotlin.c.b(new Function0<FeedTagPickerAdapter>() { // from class: com.cupidapp.live.mediapicker.activity.FeedTagPickerActivity$tagAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FeedTagPickerAdapter invoke() {
            FeedTagPickerAdapter feedTagPickerAdapter = new FeedTagPickerAdapter();
            final FeedTagPickerActivity feedTagPickerActivity = FeedTagPickerActivity.this;
            feedTagPickerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedTagPickerActivity$tagAdapter$2$1$1
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
                    if (obj instanceof HashTag) {
                        Intent intent = new Intent();
                        intent.putExtra("SELECT_HASH_TAG_RESULT", (Serializable) obj);
                        FeedTagPickerActivity.this.setResult(-1, intent);
                        FeedTagPickerActivity.this.finish();
                    }
                }
            });
            return feedTagPickerAdapter;
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17096s = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.mediapicker.activity.FeedTagPickerActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FeedTagPickerActivity feedTagPickerActivity = FeedTagPickerActivity.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedTagPickerActivity$loadMoreListener$2.1
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
                    str = FeedTagPickerActivity.this.f17095r;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    FeedTagPickerActivity feedTagPickerActivity2 = FeedTagPickerActivity.this;
                    str2 = feedTagPickerActivity2.f17095r;
                    feedTagPickerActivity2.r1(str2);
                }
            });
        }
    });

    /* compiled from: FeedTagPickerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, int i10) {
            s.i(activity, "activity");
            Intent intent = new Intent(activity, (Class<?>) FeedTagPickerActivity.class);
            intent.putExtras(new Bundle());
            activity.startActivityForResult(intent, i10);
            FKBaseActivity.f11750o.b(activity, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    public static /* synthetic */ void s1(FeedTagPickerActivity feedTagPickerActivity, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        feedTagPickerActivity.r1(str);
    }

    public static final void w1(FeedTagPickerActivity this$0) {
        s.i(this$0, "this$0");
        s1(this$0, null, 1, null);
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f17097t;
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
        setContentView(R$layout.activity_feed_hashtag_list_picker);
        p0.c(this, true, 0, 2, null);
        v1();
        q1();
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
    }

    public final void q1() {
        ((FKTitleBarLayout) k1(R$id.titleBar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedTagPickerActivity$bindEvent$1
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
                FeedTagPickerActivity.this.finish();
            }
        });
    }

    public final void r1(final String str) {
        Disposable disposed = a.C0731a.e(NetworkClient.f11868a.l(), str, 0, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<HashTag>, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedTagPickerActivity$getHashTagData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<HashTag> listResult) {
                m2739invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2739invoke(ListResult<HashTag> listResult) {
                FeedTagPickerAdapter u12;
                FKLoadMoreListener t12;
                FeedTagPickerAdapter u13;
                FeedTagPickerAdapter u14;
                ListResult<HashTag> listResult2 = listResult;
                FeedTagPickerActivity.this.f17095r = listResult2.getNextCursorId();
                if (str == null) {
                    u14 = FeedTagPickerActivity.this.u1();
                    u14.j().clear();
                }
                List<HashTag> list = listResult2.getList();
                if (list != null) {
                    u13 = FeedTagPickerActivity.this.u1();
                    u13.e(list);
                }
                u12 = FeedTagPickerActivity.this.u1();
                u12.notifyDataSetChanged();
                t12 = FeedTagPickerActivity.this.t1();
                t12.c(false);
                ((FKSwipeRefreshLayout) FeedTagPickerActivity.this.k1(R$id.listRefreshLayout)).setRefreshing(false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.mediapicker.activity.FeedTagPickerActivity$getHashTagData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener t12;
                s.i(it, "it");
                t12 = FeedTagPickerActivity.this.t1();
                t12.c(false);
                ((FKSwipeRefreshLayout) FeedTagPickerActivity.this.k1(R$id.listRefreshLayout)).setRefreshing(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final FKLoadMoreListener t1() {
        return (FKLoadMoreListener) this.f17096s.getValue();
    }

    public final FeedTagPickerAdapter u1() {
        return (FeedTagPickerAdapter) this.f17094q.getValue();
    }

    public final void v1() {
        ((FKSwipeRefreshLayout) k1(R$id.listRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.mediapicker.activity.f
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FeedTagPickerActivity.w1(FeedTagPickerActivity.this);
            }
        });
        RecyclerView recyclerView = (RecyclerView) k1(R$id.tagListRecyclerView);
        Context context = recyclerView.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context instanceof Activity ? (Activity) context : null));
        recyclerView.setAdapter(u1());
        recyclerView.addOnScrollListener(t1());
        s1(this, null, 1, null);
    }
}
