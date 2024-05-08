package com.cupidapp.live.feed.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.feed.activity.PostLimitEditActivity;
import com.cupidapp.live.feed.adapter.PostLimitDetailListAdapter;
import com.cupidapp.live.feed.event.PostLimitUploadSucEvent;
import com.cupidapp.live.feed.event.UserPostLimitReadChangeEvent;
import com.cupidapp.live.feed.fragment.PostViewerBottomFragment;
import com.cupidapp.live.feed.helper.ScalePageTransformer;
import com.cupidapp.live.feed.viewmodel.PostLimitListViewModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitDetailListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDetailListActivity extends FKBaseActivity implements com.cupidapp.live.feed.layout.p {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f14096x = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f14098r;

    /* renamed from: t, reason: collision with root package name */
    public boolean f14100t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14101u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.feed.helper.b f14102v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14103w = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f14097q = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$sensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            SensorPosition sensorPosition;
            Serializable serializableExtra = PostLimitDetailListActivity.this.getIntent().getSerializableExtra(RemoteMessageConst.FROM);
            FKSensorContext fKSensorContext = serializableExtra instanceof FKSensorContext ? (FKSensorContext) serializableExtra : null;
            SensorPosition sensorPosition2 = SensorPosition.PostLimit;
            if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
                sensorPosition = SensorPosition.Unknown;
            }
            return new FKSensorContext(sensorPosition2, sensorPosition, fKSensorContext != null ? fKSensorContext.getSource() : null, fKSensorContext != null ? fKSensorContext.getScene() : null);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f14099s = kotlin.c.b(new Function0<PostLimitDetailListAdapter>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$adapter$2

        /* compiled from: PostLimitDetailListActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a implements com.cupidapp.live.feed.layout.j {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PostLimitDetailListActivity f14104a;

            public a(PostLimitDetailListActivity postLimitDetailListActivity) {
                this.f14104a = postLimitDetailListActivity;
            }

            @Override // com.cupidapp.live.feed.layout.j
            public boolean a() {
                boolean z10;
                z10 = this.f14104a.f14100t;
                if (z10) {
                    return true;
                }
                PostLimitDetailListActivity postLimitDetailListActivity = this.f14104a;
                int i10 = R$id.detail_view_pager;
                ((ViewPager2) postLimitDetailListActivity.m1(i10)).beginFakeDrag();
                ((ViewPager2) this.f14104a.m1(i10)).fakeDragBy(((z0.h.l(this) * (-1)) / 3) * 2.0f);
                ((ViewPager2) this.f14104a.m1(i10)).endFakeDrag();
                return false;
            }

            @Override // com.cupidapp.live.feed.layout.j
            public boolean b() {
                boolean z10;
                z10 = this.f14104a.f14101u;
                if (z10) {
                    return true;
                }
                PostLimitDetailListActivity postLimitDetailListActivity = this.f14104a;
                int i10 = R$id.detail_view_pager;
                ((ViewPager2) postLimitDetailListActivity.m1(i10)).beginFakeDrag();
                ((ViewPager2) this.f14104a.m1(i10)).fakeDragBy((z0.h.l(this) / 3) * 2.0f);
                ((ViewPager2) this.f14104a.m1(i10)).endFakeDrag();
                return false;
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PostLimitDetailListAdapter invoke() {
            FKSensorContext w12;
            w12 = PostLimitDetailListActivity.this.w1();
            PostLimitDetailListActivity postLimitDetailListActivity = PostLimitDetailListActivity.this;
            return new PostLimitDetailListAdapter(w12, postLimitDetailListActivity, new a(postLimitDetailListActivity));
        }
    });

    /* compiled from: PostLimitDetailListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ArrayList<String> userIds, int i10, @NotNull FKSensorContext fromSensor) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(userIds, "userIds");
            kotlin.jvm.internal.s.i(fromSensor, "fromSensor");
            Intent intent = new Intent(context, (Class<?>) PostLimitDetailListActivity.class);
            intent.putExtra("userIds", userIds);
            intent.putExtra("select_index", i10);
            intent.putExtra(RemoteMessageConst.FROM, fromSensor);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public PostLimitDetailListActivity() {
        final Function0 function0 = null;
        this.f14098r = new ViewModelLazy(kotlin.jvm.internal.v.b(PostLimitListViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final PostLimitDetailListActivity postLimitDetailListActivity = PostLimitDetailListActivity.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        FKSensorContext w12;
                        kotlin.jvm.internal.s.i(p02, "p0");
                        Serializable serializableExtra = PostLimitDetailListActivity.this.getIntent().getSerializableExtra("userIds");
                        List list = null;
                        if (serializableExtra != null && (serializableExtra instanceof List)) {
                            list = (List) serializableExtra;
                        }
                        int intExtra = PostLimitDetailListActivity.this.getIntent().getIntExtra("select_index", 0);
                        if (list == null) {
                            list = kotlin.collections.s.j();
                        }
                        w12 = PostLimitDetailListActivity.this.w1();
                        return new PostLimitListViewModel(list, intExtra, w12);
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$special$$inlined$viewModels$default$3
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

    public static final void A1(PostLimitDetailListActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        if (it.booleanValue()) {
            this$0.E1();
        }
    }

    public static final void B1(PostLimitDetailListActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        if (it.booleanValue()) {
            this$0.D1();
        }
    }

    public static final void z1(PostLimitDetailListActivity this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            return;
        }
        Pair pair = (Pair) stateResult.getData();
        List list = pair != null ? (List) pair.getFirst() : null;
        if (list == null || list.isEmpty()) {
            this$0.m1(R$id.post_empty_rl).setVisibility(0);
            return;
        }
        this$0.m1(R$id.post_empty_rl).setVisibility(8);
        this$0.v1().j().clear();
        PostLimitDetailListAdapter v12 = this$0.v1();
        Pair pair2 = (Pair) stateResult.getData();
        v12.e(pair2 != null ? (List) pair2.getFirst() : null);
        this$0.v1().notifyDataSetChanged();
        Pair pair3 = (Pair) stateResult.getData();
        if ((pair3 != null ? ((Number) pair3.getSecond()).intValue() : -1) >= 0) {
            ViewPager2 viewPager2 = (ViewPager2) this$0.m1(R$id.detail_view_pager);
            Pair pair4 = (Pair) stateResult.getData();
            viewPager2.setCurrentItem(pair4 != null ? ((Number) pair4.getSecond()).intValue() : 0, false);
        }
    }

    public final void C1() {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ((ViewPager2) m1(R$id.detail_view_pager)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$registerPagerLayout$1
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
            
                r3 = r2.f14102v;
             */
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPageScrollStateChanged(int r3) {
                /*
                    r2 = this;
                    super.onPageScrollStateChanged(r3)
                    r0 = 1
                    if (r3 == 0) goto L17
                    if (r3 == r0) goto L11
                    r1 = 2
                    if (r3 == r1) goto Lc
                    goto L48
                Lc:
                    kotlin.jvm.internal.Ref$BooleanRef r3 = kotlin.jvm.internal.Ref$BooleanRef.this
                    r3.element = r0
                    goto L48
                L11:
                    kotlin.jvm.internal.Ref$BooleanRef r3 = kotlin.jvm.internal.Ref$BooleanRef.this
                    r0 = 0
                    r3.element = r0
                    goto L48
                L17:
                    kotlin.jvm.internal.Ref$BooleanRef r3 = kotlin.jvm.internal.Ref$BooleanRef.this
                    boolean r3 = r3.element
                    if (r3 != 0) goto L44
                    com.cupidapp.live.feed.activity.PostLimitDetailListActivity r3 = r2
                    boolean r3 = com.cupidapp.live.feed.activity.PostLimitDetailListActivity.s1(r3)
                    if (r3 == 0) goto L31
                    com.cupidapp.live.feed.activity.PostLimitDetailListActivity r3 = r2
                    com.cupidapp.live.feed.helper.b r3 = com.cupidapp.live.feed.activity.PostLimitDetailListActivity.o1(r3)
                    if (r3 == 0) goto L44
                    r3.b()
                    goto L44
                L31:
                    com.cupidapp.live.feed.activity.PostLimitDetailListActivity r3 = r2
                    boolean r3 = com.cupidapp.live.feed.activity.PostLimitDetailListActivity.r1(r3)
                    if (r3 == 0) goto L44
                    com.cupidapp.live.feed.activity.PostLimitDetailListActivity r3 = r2
                    com.cupidapp.live.feed.helper.b r3 = com.cupidapp.live.feed.activity.PostLimitDetailListActivity.o1(r3)
                    if (r3 == 0) goto L44
                    r3.c()
                L44:
                    kotlin.jvm.internal.Ref$BooleanRef r3 = kotlin.jvm.internal.Ref$BooleanRef.this
                    r3.element = r0
                L48:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$registerPagerLayout$1.onPageScrollStateChanged(int):void");
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i10, float f10, int i11) {
                super.onPageScrolled(i10, f10, i11);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                PostLimitListViewModel x12;
                PostLimitDetailListAdapter v12;
                PostLimitListViewModel x13;
                boolean z10;
                PostLimitListViewModel x14;
                PostLimitListViewModel x15;
                boolean z11;
                PostLimitListViewModel x16;
                super.onPageSelected(i10);
                x12 = this.x1();
                x12.changeSelect(i10);
                v12 = this.v1();
                int size = v12.j().size();
                if (i10 == 0) {
                    PostLimitDetailListActivity postLimitDetailListActivity = this;
                    x15 = postLimitDetailListActivity.x1();
                    postLimitDetailListActivity.f14101u = !x15.checkCanLoadLeft();
                    z11 = this.f14101u;
                    if (!z11) {
                        x16 = this.x1();
                        x16.loadPreData();
                    }
                } else {
                    this.f14101u = false;
                }
                if (i10 == size - 1) {
                    PostLimitDetailListActivity postLimitDetailListActivity2 = this;
                    x13 = postLimitDetailListActivity2.x1();
                    postLimitDetailListActivity2.f14100t = !x13.checkCanLoadNextData();
                    z10 = this.f14100t;
                    if (z10) {
                        return;
                    }
                    x14 = this.x1();
                    x14.loadNextData();
                    return;
                }
                this.f14100t = false;
            }
        });
    }

    public final void D1() {
        p1.g.f52734a.s3(Boolean.FALSE);
        int i10 = R$id.click_guide_ll;
        m1(i10).setVisibility(0);
        View click_guide_ll = m1(i10);
        kotlin.jvm.internal.s.h(click_guide_ll, "click_guide_ll");
        z0.y.d(click_guide_ll, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$showClickAnim$1
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
                PostLimitDetailListActivity.this.m1(R$id.click_guide_ll).setVisibility(8);
            }
        });
    }

    public final void E1() {
        final AlertDialog g3;
        View layout = View.inflate(this, R$layout.state_swipe_guide, null);
        ((TextView) layout.findViewById(R$id.state_swipe_content)).setText(getString(R$string.swipe_to_see_more_post));
        z0.b bVar = z0.b.f54812a;
        kotlin.jvm.internal.s.h(layout, "layout");
        g3 = bVar.g(this, layout, 0, 0, -1, z0.h.c(this, 300.0f), (r32 & 64) != 0 ? 17 : 17, (r32 & 128) != 0 ? null : Float.valueOf(0.4f), (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null, (r32 & 8192) != 0 ? null : null);
        g3.setCanceledOnTouchOutside(false);
        View findViewById = layout.findViewById(R$id.state_swipe_svga);
        kotlin.jvm.internal.s.h(findViewById, "layout.findViewById<FKSV…w>(R.id.state_swipe_svga)");
        FKSVGAImageView.F((FKSVGAImageView) findViewById, "hand_swipe.svga", null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$showSwipeGuide$1
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
                PostLimitListViewModel x12;
                x12 = PostLimitDetailListActivity.this.x1();
                x12.changeSwipeGuide(false);
                g3.dismiss();
            }
        }, 2, null);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void G() {
        PostLimitEditActivity.a.b(PostLimitEditActivity.E, this, w1(), null, 4, null);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void I(@Nullable User user) {
        if (user == null) {
            return;
        }
        String value = ViewProfilePrefer.PostLimitToProfile.getValue();
        boolean me2 = user.getMe();
        SensorPosition sensorPosition = SensorPosition.PostLimit;
        UserProfileActivity.a.b(UserProfileActivity.G, this, user, new ProfileSensorContext(value, null, me2, sensorPosition, sensorPosition, null), true, null, null, null, false, 240, null);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void J(@NotNull String postLimitId) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        x1().showViewerList(postLimitId);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void L(@NotNull String reportData) {
        kotlin.jvm.internal.s.i(reportData, "reportData");
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void O(@Nullable String str) {
        x1().follow(str);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PostLimit;
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void U(@NotNull String postLimitId, @Nullable String str) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        x1().readPostLimit(postLimitId, str);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void c(@NotNull String postLimitId) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        x1().deleteLimitPost(postLimitId);
    }

    @Nullable
    public View m1(int i10) {
        Map<Integer, View> map = this.f14103w;
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
        setContentView(R$layout.activity_post_detail_list);
        getWindow().setSoftInputMode(16);
        int i10 = R$id.detail_view_pager;
        ((ViewPager2) m1(i10)).setAdapter(v1());
        ((ViewPager2) m1(i10)).setOrientation(0);
        ((ViewPager2) m1(i10)).setPageTransformer(new ScalePageTransformer());
        p0.c(this, true, 0, 2, null);
        ViewPager2 detail_view_pager = (ViewPager2) m1(i10);
        kotlin.jvm.internal.s.h(detail_view_pager, "detail_view_pager");
        this.f14102v = new com.cupidapp.live.feed.helper.b(detail_view_pager);
        C1();
        y1();
        ImageView post_empty_close_view = (ImageView) m1(R$id.post_empty_close_view);
        kotlin.jvm.internal.s.h(post_empty_close_view, "post_empty_close_view");
        z0.y.d(post_empty_close_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$onCreate$1
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
                PostLimitDetailListActivity.this.finish();
            }
        });
        GroupOthersLog.d(GroupOthersLog.f18702a, w1().getPosition().getValue(), null, w1().getSource().getValue(), 2, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.c().o(new UserPostLimitReadChangeEvent(x1().getReadList(), x1().isUploadedPostLimit(), x1().isDelAllMyPostLimit()));
        p0.c(this, false, 0, 2, null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PostLimitUploadSucEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        x1().uploadPostLimitSuc();
        finish();
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void q() {
        finish();
    }

    public final PostLimitDetailListAdapter v1() {
        return (PostLimitDetailListAdapter) this.f14099s.getValue();
    }

    public final FKSensorContext w1() {
        return (FKSensorContext) this.f14097q.getValue();
    }

    public final PostLimitListViewModel x1() {
        return (PostLimitListViewModel) this.f14098r.getValue();
    }

    public final void y1() {
        x1().getListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.feed.activity.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PostLimitDetailListActivity.z1(PostLimitDetailListActivity.this, (StateResult) obj);
            }
        });
        x1().getOpenViewerListEvent().observe(this, new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailListActivity$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                kotlin.jvm.internal.s.i(it, "it");
                PostViewerBottomFragment a10 = PostViewerBottomFragment.f14258j.a();
                FragmentManager supportFragmentManager = PostLimitDetailListActivity.this.getSupportFragmentManager();
                kotlin.jvm.internal.s.h(supportFragmentManager, "supportFragmentManager");
                a10.k1(supportFragmentManager, it);
            }
        }));
        x1().getSwipeGuideLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.feed.activity.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PostLimitDetailListActivity.A1(PostLimitDetailListActivity.this, (Boolean) obj);
            }
        });
        x1().getClickGuideLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.feed.activity.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PostLimitDetailListActivity.B1(PostLimitDetailListActivity.this, (Boolean) obj);
            }
        });
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        x1().uploadUserFocus(event.getUser());
    }
}
