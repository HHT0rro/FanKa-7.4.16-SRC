package com.cupidapp.live.feed.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.feed.adapter.RainbowRecommendAdapter;
import com.cupidapp.live.feed.model.RainbowRecommendResult;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.model.VipPurchaseSuccessEvent;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import f2.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RainbowRecommendActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RainbowRecommendActivity extends FKBaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f14128x = new a(null);

    /* renamed from: r, reason: collision with root package name */
    public boolean f14130r;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public String f14132t;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14135w = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    public boolean f14129q = true;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f14131s = kotlin.c.b(new Function0<RainbowRecommendAdapter>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$recommendAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final RainbowRecommendAdapter invoke() {
            RainbowRecommendAdapter rainbowRecommendAdapter = new RainbowRecommendAdapter();
            final RainbowRecommendActivity rainbowRecommendActivity = RainbowRecommendActivity.this;
            rainbowRecommendAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$recommendAdapter$2$1$1
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
                    if (obj instanceof User) {
                        User user = (User) obj;
                        NearByMiniProfileActivity.f16517r.a(RainbowRecommendActivity.this, new NearbyUserModel(user.userId(), false, false, false, false, false, user.getAvatarImage(), user.getName(), null, null, false, false, false, null, null, null, null, false, false, false, null, 2096958, null), SensorScene.RainbowRecommend, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : SensorPosition.RainbowRecommend, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : true);
                    }
                }
            });
            ExposureScene exposureScene = ExposureScene.RainbowRecommend;
            RecyclerView recommend_recyclerview = (RecyclerView) rainbowRecommendActivity.k1(R$id.recommend_recyclerview);
            kotlin.jvm.internal.s.h(recommend_recyclerview, "recommend_recyclerview");
            rainbowRecommendAdapter.t(new RecyclerExposureHelper(exposureScene, recommend_recyclerview, 0.0f, 0L, null, new Function1<List<? extends h1.a>, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$recommendAdapter$2$1$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends h1.a> list) {
                    invoke2((List<h1.a>) list);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<h1.a> list) {
                    kotlin.jvm.internal.s.i(list, "list");
                    Iterator<h1.a> iterator2 = list.iterator2();
                    while (iterator2.hasNext()) {
                        Object a10 = iterator2.next().a();
                        if (a10 instanceof User) {
                            GroupSocialLog.f18708a.w(SensorScene.RainbowRecommend.getValue(), ((User) a10).userId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : true, (r29 & 2048) != 0 ? false : false);
                        }
                    }
                }
            }, 28, null));
            return rainbowRecommendAdapter;
        }
    });

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f14133u = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final RainbowRecommendActivity rainbowRecommendActivity = RainbowRecommendActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$loadMoreListener$2.1
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
                    str = RainbowRecommendActivity.this.f14132t;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    RainbowRecommendActivity rainbowRecommendActivity2 = RainbowRecommendActivity.this;
                    str2 = rainbowRecommendActivity2.f14132t;
                    rainbowRecommendActivity2.y1(str2);
                }
            });
        }
    });

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public final Lazy f14134v = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$purchaseManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            RainbowRecommendActivity rainbowRecommendActivity = RainbowRecommendActivity.this;
            Lifecycle lifecycle = rainbowRecommendActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(rainbowRecommendActivity, lifecycle);
        }
    });

    /* compiled from: RainbowRecommendActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            Intent intent = new Intent(context, (Class<?>) RainbowRecommendActivity.class);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static final void v1(RainbowRecommendActivity this$0, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (compoundButton.isPressed()) {
            this$0.C1(z10);
        }
    }

    public static /* synthetic */ void z1(RainbowRecommendActivity rainbowRecommendActivity, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        rainbowRecommendActivity.y1(str);
    }

    public final RainbowRecommendAdapter A1() {
        return (RainbowRecommendAdapter) this.f14131s.getValue();
    }

    public final void B1() {
        TextView rainbow_vip_recommend_textview = (TextView) k1(R$id.rainbow_vip_recommend_textview);
        kotlin.jvm.internal.s.h(rainbow_vip_recommend_textview, "rainbow_vip_recommend_textview");
        z0.u.a(rainbow_vip_recommend_textview);
        int i10 = R$id.open_recommend_textview;
        TextView open_recommend_textview = (TextView) k1(i10);
        kotlin.jvm.internal.s.h(open_recommend_textview, "open_recommend_textview");
        z0.u.a(open_recommend_textview);
        TextView open_recommend_textview2 = (TextView) k1(i10);
        kotlin.jvm.internal.s.h(open_recommend_textview2, "open_recommend_textview");
        z0.y.i(open_recommend_textview2, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 26.0f), kotlin.collections.s.m(-1764332, -35817, -3695838, -9189605, -14639927, -9418753, -2867969), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TL_BR, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        RecyclerView recyclerView = (RecyclerView) k1(R$id.recommend_recyclerview);
        recyclerView.setAdapter(A1());
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) this, A1().v(), 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$initView$1$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i11) {
                RainbowRecommendAdapter A1;
                A1 = RainbowRecommendActivity.this.A1();
                return A1.u(i11);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(w1());
        ((FKSwipeRefreshLayout) k1(R$id.recommend_refresh_layout)).setOnRefreshListener(this);
    }

    public final void C1(final boolean z10) {
        Disposable disposed = NetworkClient.f11868a.l().N(z10).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$switchRecommend$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$switchRecommend$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                ((CheckBox) RainbowRecommendActivity.this.k1(R$id.open_recommend_checkbox)).setChecked(!z10);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f14135w;
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
        setContentView(R$layout.activity_rainbow_recommend);
        B1();
        u1();
        z1(this, null, 1, null);
        j1.c.b(j1.c.f50228a, SensorPosition.RainbowRecommend, null, null, 6, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        boolean z10 = this.f14130r;
        int i10 = R$id.open_recommend_checkbox;
        if (z10 != ((CheckBox) k1(i10)).isChecked()) {
            EventBus.c().o(new OpenRainbowRecommendEvent(((CheckBox) k1(i10)).isChecked()));
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull VipPurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        z1(this, null, 1, null);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.RainbowRecommend);
        z1(this, null, 1, null);
    }

    public final void u1() {
        ((FKTitleBarLayout) k1(R$id.rainbow_recommend_title_layout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$bindClickEvent$1
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
                RainbowRecommendActivity.this.finish();
            }
        });
        ((CheckBox) k1(R$id.open_recommend_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.feed.activity.e0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                RainbowRecommendActivity.v1(RainbowRecommendActivity.this, compoundButton, z10);
            }
        });
        TextView open_recommend_textview = (TextView) k1(R$id.open_recommend_textview);
        kotlin.jvm.internal.s.h(open_recommend_textview, "open_recommend_textview");
        z0.y.d(open_recommend_textview, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$bindClickEvent$3
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
                PurchaseDialogManager x12;
                x12 = RainbowRecommendActivity.this.x1();
                PurchaseDialogManager.o(x12, VipPurchaseEntranceType.RainbowRecommend, null, false, false, 14, null);
                SensorsLogKeyButtonClick.RainbowRecommend.StartRecommend.click();
            }
        });
    }

    public final FKLoadMoreListener w1() {
        return (FKLoadMoreListener) this.f14133u.getValue();
    }

    public final PurchaseDialogManager x1() {
        return (PurchaseDialogManager) this.f14134v.getValue();
    }

    public final void y1(final String str) {
        Disposable disposed = a.C0731a.i(NetworkClient.f11868a.l(), str, 0, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<RainbowRecommendResult, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$getRainbowRecommend$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(RainbowRecommendResult rainbowRecommendResult) {
                m2557invoke(rainbowRecommendResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2557invoke(RainbowRecommendResult rainbowRecommendResult) {
                FKLoadMoreListener w12;
                String str2;
                RainbowRecommendAdapter A1;
                RainbowRecommendAdapter A12;
                RainbowRecommendAdapter A13;
                boolean z10;
                RainbowRecommendAdapter A14;
                RainbowRecommendAdapter A15;
                RainbowRecommendResult rainbowRecommendResult2 = rainbowRecommendResult;
                ((FKSwipeRefreshLayout) RainbowRecommendActivity.this.k1(R$id.recommend_refresh_layout)).setRefreshing(false);
                w12 = RainbowRecommendActivity.this.w1();
                w12.c(false);
                RainbowRecommendActivity.this.f14132t = rainbowRecommendResult2.getNextCursorId();
                String str3 = str;
                if (str3 == null || str3.length() == 0) {
                    z10 = RainbowRecommendActivity.this.f14129q;
                    if (z10) {
                        RainbowRecommendActivity.this.f14130r = rainbowRecommendResult2.getSpecialExposureSetting();
                        RainbowRecommendActivity.this.f14129q = false;
                    }
                    RelativeLayout open_recommend_layout = (RelativeLayout) RainbowRecommendActivity.this.k1(R$id.open_recommend_layout);
                    kotlin.jvm.internal.s.h(open_recommend_layout, "open_recommend_layout");
                    open_recommend_layout.setVisibility(rainbowRecommendResult2.getSsvipRequired() ^ true ? 0 : 8);
                    ((CheckBox) RainbowRecommendActivity.this.k1(R$id.open_recommend_checkbox)).setChecked(rainbowRecommendResult2.getSpecialExposureSetting());
                    TextView open_recommend_textview = (TextView) RainbowRecommendActivity.this.k1(R$id.open_recommend_textview);
                    kotlin.jvm.internal.s.h(open_recommend_textview, "open_recommend_textview");
                    open_recommend_textview.setVisibility(rainbowRecommendResult2.getSsvipRequired() ? 0 : 8);
                    A14 = RainbowRecommendActivity.this.A1();
                    A14.j().clear();
                    A15 = RainbowRecommendActivity.this.A1();
                    A15.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                }
                str2 = RainbowRecommendActivity.this.f14132t;
                if (str2 == null || str2.length() == 0) {
                    A13 = RainbowRecommendActivity.this.A1();
                    A13.s();
                }
                A1 = RainbowRecommendActivity.this.A1();
                A1.e(rainbowRecommendResult2.getList());
                A12 = RainbowRecommendActivity.this.A1();
                A12.notifyDataSetChanged();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.activity.RainbowRecommendActivity$getRainbowRecommend$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener w12;
                kotlin.jvm.internal.s.i(it, "it");
                ((FKSwipeRefreshLayout) RainbowRecommendActivity.this.k1(R$id.recommend_refresh_layout)).setRefreshing(false);
                w12 = RainbowRecommendActivity.this.w1();
                w12.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }
}
