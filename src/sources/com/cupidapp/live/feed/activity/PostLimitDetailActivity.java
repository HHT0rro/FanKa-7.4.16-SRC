package com.cupidapp.live.feed.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.feed.activity.PostLimitEditActivity;
import com.cupidapp.live.feed.fragment.PostViewerBottomFragment;
import com.cupidapp.live.feed.layout.PostLimitPagerLayout;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.feed.viewmodel.PostLimitDetailViewModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitDetailActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDetailActivity extends FKBaseActivity implements com.cupidapp.live.feed.layout.p {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f14091t = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f14093r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14094s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f14092q = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailActivity$sensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            SensorPosition sensorPosition;
            Serializable serializableExtra = PostLimitDetailActivity.this.getIntent().getSerializableExtra(RemoteMessageConst.FROM);
            FKSensorContext fKSensorContext = serializableExtra instanceof FKSensorContext ? (FKSensorContext) serializableExtra : null;
            SensorPosition sensorPosition2 = SensorPosition.PostLimit;
            if (fKSensorContext == null || (sensorPosition = fKSensorContext.getPosition()) == null) {
                sensorPosition = SensorPosition.Unknown;
            }
            return new FKSensorContext(sensorPosition2, sensorPosition, fKSensorContext != null ? fKSensorContext.getSource() : null, fKSensorContext != null ? fKSensorContext.getScene() : null);
        }
    });

    /* compiled from: PostLimitDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Fragment fragment, @NotNull PostLimitDetailModel postLimitDetail, @NotNull FKSensorContext fromSensor) {
            kotlin.jvm.internal.s.i(postLimitDetail, "postLimitDetail");
            kotlin.jvm.internal.s.i(fromSensor, "fromSensor");
            if (fragment == null) {
                return;
            }
            Intent intent = new Intent(fragment.getContext(), (Class<?>) PostLimitDetailActivity.class);
            intent.putExtra("postLimit", postLimitDetail);
            intent.putExtra(RemoteMessageConst.MSGID, postLimitDetail);
            intent.putExtra(RemoteMessageConst.FROM, fromSensor);
            fragment.startActivityForResult(intent, MetricsProto.MetricsEvent.PROVISIONING_WEB_ACTIVITY_TIME_MS);
        }

        public final void b(@Nullable Fragment fragment, @NotNull String postLimitId, @Nullable String str, @NotNull FKSensorContext fromSensor, @Nullable User user) {
            kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
            kotlin.jvm.internal.s.i(fromSensor, "fromSensor");
            if (fragment == null) {
                return;
            }
            Intent intent = new Intent(fragment.getContext(), (Class<?>) PostLimitDetailActivity.class);
            intent.putExtra("postLimitId", postLimitId);
            intent.putExtra(RemoteMessageConst.MSGID, str);
            intent.putExtra("chat_user", user);
            intent.putExtra(RemoteMessageConst.FROM, fromSensor);
            fragment.startActivityForResult(intent, MetricsProto.MetricsEvent.PROVISIONING_WEB_ACTIVITY_TIME_MS);
        }
    }

    /* compiled from: PostLimitDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.feed.layout.j {
        @Override // com.cupidapp.live.feed.layout.j
        public boolean a() {
            return false;
        }

        @Override // com.cupidapp.live.feed.layout.j
        public boolean b() {
            return false;
        }
    }

    public PostLimitDetailActivity() {
        final Function0 function0 = null;
        this.f14093r = new ViewModelLazy(kotlin.jvm.internal.v.b(PostLimitDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final PostLimitDetailActivity postLimitDetailActivity = PostLimitDetailActivity.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailActivity$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        FKSensorContext o12;
                        kotlin.jvm.internal.s.i(p02, "p0");
                        String stringExtra = PostLimitDetailActivity.this.getIntent().getStringExtra("postLimitId");
                        String stringExtra2 = PostLimitDetailActivity.this.getIntent().getStringExtra(RemoteMessageConst.MSGID);
                        o12 = PostLimitDetailActivity.this.o1();
                        return new PostLimitDetailViewModel(stringExtra, stringExtra2, o12);
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailActivity$special$$inlined$viewModels$default$3
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

    public static final void r1(PostLimitDetailActivity this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.a) {
            this$0.k1(R$id.post_detail_empty).setVisibility(0);
        } else {
            if (!(stateResult instanceof StateResult.c) || stateResult.getData() == null) {
                return;
            }
            this$0.k1(R$id.post_detail_empty).setVisibility(8);
            ((PostLimitPagerLayout) this$0.k1(R$id.post_detail_layout)).s(kotlin.collections.s.o((PostLimitDetailModel) stateResult.getData()), this$0.o1(), this$0, new b());
            this$0.n1();
        }
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void G() {
        PostLimitEditActivity.a.b(PostLimitEditActivity.E, this, o1(), null, 4, null);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void I(@Nullable User user) {
        if (user == null) {
            return;
        }
        String value = ViewProfilePrefer.PostLimitToProfile.getValue();
        boolean me2 = user.getMe();
        SensorPosition sensorPosition = SensorPosition.PostLimit;
        UserProfileActivity.G.a(this, user, new ProfileSensorContext(value, null, me2, sensorPosition, sensorPosition, null), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void J(@NotNull String postLimitId) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        PostViewerBottomFragment a10 = PostViewerBottomFragment.f14258j.a();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.s.h(supportFragmentManager, "supportFragmentManager");
        a10.k1(supportFragmentManager, postLimitId);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void L(@NotNull String reportData) {
        kotlin.jvm.internal.s.i(reportData, "reportData");
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void O(@Nullable String str) {
        p1().follow(str);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PostLimit;
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void U(@NotNull String postLimitId, @Nullable String str) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        p1().readPostLimit(postLimitId, str);
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void c(@NotNull String postLimitId) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        p1().deleteLimitPost(postLimitId);
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f14094s;
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

    public final void m1() {
        if (o1().getSource() == SensorPosition.MessageDetail) {
            Serializable serializableExtra = getIntent().getSerializableExtra("chat_user");
            User user = serializableExtra instanceof User ? (User) serializableExtra : null;
            if (user != null) {
                String userId = user.userId();
                SensorPosition sensorPosition = SensorPosition.PostLimit;
                ChatDetailActivity.f13276r.a(this, new ChatBundleData(user, userId, new FKSensorContext(sensorPosition, sensorPosition, null, SensorScene.Feed), null, false, true, false, false, false, MetricsProto.MetricsEvent.ACTION_DELETION_HELPER_DOWNLOADS_DELETION_FAIL, null));
            }
        }
    }

    public final void n1() {
        p1.g gVar = p1.g.f52734a;
        if (kotlin.jvm.internal.s.d(gVar.g1(), Boolean.TRUE)) {
            gVar.s3(Boolean.FALSE);
            int i10 = R$id.post_detail_click_guide_ll;
            k1(i10).setVisibility(0);
            View post_detail_click_guide_ll = k1(i10);
            kotlin.jvm.internal.s.h(post_detail_click_guide_ll, "post_detail_click_guide_ll");
            z0.y.d(post_detail_click_guide_ll, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailActivity$checkShowGuide$1
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
                    PostLimitDetailActivity.this.k1(R$id.post_detail_click_guide_ll).setVisibility(8);
                }
            });
            return;
        }
        k1(R$id.post_detail_click_guide_ll).setVisibility(8);
    }

    public final FKSensorContext o1() {
        return (FKSensorContext) this.f14092q.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        m1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_post_detail);
        ImageView post_empty_close_view = (ImageView) k1(R$id.post_empty_close_view);
        kotlin.jvm.internal.s.h(post_empty_close_view, "post_empty_close_view");
        z0.y.d(post_empty_close_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailActivity$onCreate$1
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
                PostLimitDetailActivity.this.finish();
            }
        });
        Serializable serializableExtra = getIntent().getSerializableExtra("postLimit");
        PostLimitDetailModel postLimitDetailModel = serializableExtra instanceof PostLimitDetailModel ? (PostLimitDetailModel) serializableExtra : null;
        if (postLimitDetailModel == null) {
            p1().loadData();
        } else {
            p1().setData(postLimitDetailModel);
        }
        q1();
        p0.c(this, true, 0, 2, null);
        GroupOthersLog.d(GroupOthersLog.f18702a, Q0().getValue(), null, o1().getSource().getValue(), 2, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        p0.c(this, false, 0, 2, null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        p1().uploadUserFocus(event.getUser());
    }

    public final PostLimitDetailViewModel p1() {
        return (PostLimitDetailViewModel) this.f14093r.getValue();
    }

    @Override // com.cupidapp.live.feed.layout.p
    public void q() {
        finish();
        m1();
    }

    public final void q1() {
        p1().getResultLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.feed.activity.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PostLimitDetailActivity.r1(PostLimitDetailActivity.this, (StateResult) obj);
            }
        });
        p1().getDelPostEvent().observe(this, new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.PostLimitDetailActivity$initObserve$2
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
                Intent intent = new Intent();
                intent.putExtra("postLimitId", it);
                PostLimitDetailActivity.this.setResult(-1, intent);
                PostLimitDetailActivity.this.finish();
            }
        }));
    }
}
