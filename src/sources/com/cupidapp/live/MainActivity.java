package com.cupidapp.live;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amap.api.location.AMapLocationClient;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cupidapp.live.appdialog.layout.FKFakeChangeAvatarSuccessLayout;
import com.cupidapp.live.appdialog.model.LiveTabIconModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.activity.HandleClipboardJumpEvent;
import com.cupidapp.live.base.fragment.FKBaseMainPagerFragment;
import com.cupidapp.live.base.grpc.GrpcIM;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.utils.o0;
import com.cupidapp.live.base.utils.s0;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.chat.event.BottomTabVisibilityEvent;
import com.cupidapp.live.chat.event.CloseTwoLevelFloorEvent;
import com.cupidapp.live.chat.fragment.ContactSessionContainerFragment;
import com.cupidapp.live.chat.receiver.NewSessionBroadcastReceiver;
import com.cupidapp.live.chat.util.SessionLocalListUtil;
import com.cupidapp.live.chat2.helper.ChatBubbleHelper;
import com.cupidapp.live.club.model.ClubNewMessageConnectorMessageModel;
import com.cupidapp.live.consult.helper.ConsultFloatWindowHelper;
import com.cupidapp.live.feed.fragment.FeedContainerFragment;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.FollowAnchorModel;
import com.cupidapp.live.main.event.RefreshAllTabUnreadCountEvent;
import com.cupidapp.live.main.event.RefreshSpecifyTabUnreadCountEvent;
import com.cupidapp.live.main.model.CountDataModel;
import com.cupidapp.live.main.view.FKBottomTabLayout;
import com.cupidapp.live.main.viewmodel.MainViewModel;
import com.cupidapp.live.maskparty.model.MaskPartyRecommendModel;
import com.cupidapp.live.match.fragment.FKMatchContainerFragment;
import com.cupidapp.live.match.helper.LocationChangeHelper;
import com.cupidapp.live.match.model.ActivityJumpModel;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.model.SearchHideResult;
import com.cupidapp.live.profile.model.UserRankModel;
import com.cupidapp.live.push.BindPushTokenUtilKt;
import com.cupidapp.live.push.FKGRPCMessageWatcher;
import com.cupidapp.live.push.FKPushMessageModel;
import com.cupidapp.live.push.FKPushModel;
import com.cupidapp.live.push.FKPushTunnel;
import com.cupidapp.live.push.event.RouterUrlJumperSelectMainTabEvent;
import com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment;
import com.cupidapp.live.setting.helper.SwitchAccountHelper;
import com.cupidapp.live.startup.fragment.FKStartupAdFragment;
import com.cupidapp.live.startup.helper.SplashAdSelectHelper;
import com.cupidapp.live.startup.model.FKStartupMediaResult;
import com.cupidapp.live.startup.model.SplashAdRequestModel;
import com.cupidapp.live.startup.model.StartCacheSplashAdDataEvent;
import com.cupidapp.live.superboost.model.SuperBoostRemainAssetsResult;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.update.FKUpdateNewVersionDownloader;
import com.google.android.material.tabs.TabLayout;
import com.huawei.openalliance.ad.constant.u;
import com.irisdt.client.others.OthersProtos;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import e1.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: MainActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MainActivity extends FKBaseActivity {

    @NotNull
    public static final a F = new a(null);

    @Nullable
    public FKPointerDialog A;

    @Nullable
    public AMapLocationClient B;

    /* renamed from: q */
    @NotNull
    public final Lazy f11623q;

    /* renamed from: t */
    @Nullable
    public NewSessionBroadcastReceiver f11626t;

    /* renamed from: u */
    public long f11627u;

    /* renamed from: v */
    @Nullable
    public CountDownTimer f11628v;

    /* renamed from: w */
    @Nullable
    public o f11629w;

    /* renamed from: z */
    public boolean f11632z;

    @NotNull
    public Map<Integer, View> E = new LinkedHashMap();

    /* renamed from: r */
    @NotNull
    public final List<FKBaseMainPagerFragment> f11624r = new ArrayList();

    /* renamed from: s */
    @NotNull
    public final Lazy f11625s = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.MainActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(MainActivity.this);
        }
    });

    /* renamed from: x */
    public final long f11630x = 86400000;

    /* renamed from: y */
    public final long f11631y = u.as;

    @NotNull
    public final i C = new i();
    public boolean D = true;

    /* compiled from: MainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class MainPagerType extends Enum<MainPagerType> {
        public static final MainPagerType Match = new Match("Match", 0);
        public static final MainPagerType Live = new Live("Live", 1);
        public static final MainPagerType Feed = new Feed(ExploreConstants.SCENE_FEED, 2);
        public static final MainPagerType Chat = new Chat("Chat", 3);
        public static final MainPagerType Setting = new Setting("Setting", 4);
        private static final /* synthetic */ MainPagerType[] $VALUES = $values();

        /* compiled from: MainActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Chat extends MainPagerType {
            public Chat(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            public int getPageIndex() {
                return 3;
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            @NotNull
            public String getPageName() {
                return "Chat";
            }
        }

        /* compiled from: MainActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Feed extends MainPagerType {
            public Feed(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            public int getPageIndex() {
                return 2;
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            @NotNull
            public String getPageName() {
                return ExploreConstants.SCENE_FEED;
            }
        }

        /* compiled from: MainActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Live extends MainPagerType {
            public Live(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            public int getPageIndex() {
                return 1;
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            @NotNull
            public String getPageName() {
                return "Live";
            }
        }

        /* compiled from: MainActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Match extends MainPagerType {
            public Match(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            public int getPageIndex() {
                return 0;
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            @NotNull
            public String getPageName() {
                return "Match";
            }
        }

        /* compiled from: MainActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Setting extends MainPagerType {
            public Setting(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            public int getPageIndex() {
                return 4;
            }

            @Override // com.cupidapp.live.MainActivity.MainPagerType
            @NotNull
            public String getPageName() {
                return "Setting";
            }
        }

        private static final /* synthetic */ MainPagerType[] $values() {
            return new MainPagerType[]{Match, Live, Feed, Chat, Setting};
        }

        private MainPagerType(String str, int i10) {
            super(str, i10);
        }

        public /* synthetic */ MainPagerType(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i10);
        }

        public static MainPagerType valueOf(String str) {
            return (MainPagerType) Enum.valueOf(MainPagerType.class, str);
        }

        public static MainPagerType[] values() {
            return (MainPagerType[]) $VALUES.clone();
        }

        public abstract /* synthetic */ int getPageIndex();

        @NotNull
        public abstract /* synthetic */ String getPageName();
    }

    /* compiled from: MainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(a aVar, Context context, MainPagerType mainPagerType, String str, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str = null;
            }
            return aVar.a(context, mainPagerType, str);
        }

        public static /* synthetic */ void g(a aVar, Context context, Uri uri, String str, boolean z10, Integer num, Boolean bool, int i10, Object obj) {
            aVar.f(context, (i10 & 2) != 0 ? null : uri, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? false : z10, (i10 & 16) == 0 ? num : null, (i10 & 32) != 0 ? Boolean.FALSE : bool);
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull MainPagerType type, @Nullable String str) {
            s.i(context, "context");
            s.i(type, "type");
            return c(context, Uri.parse("finka2020://Router/MainPager/" + s0.f12376a.a(type.getPageName(), str)));
        }

        public final Intent c(Context context, Uri uri) {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setData(uri);
            return intent;
        }

        public final void d(@NotNull Context context, @NotNull Intent intent) {
            s.i(context, "context");
            s.i(intent, "intent");
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, 0, 0);
        }

        public final void e(@NotNull String tabName, @NotNull Context context, @Nullable String str) {
            s.i(tabName, "tabName");
            s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setAction("main_switch_tab");
            intent.putExtra("param_tab_name", tabName);
            if (str != null) {
                intent.putExtra("param_sub_tab_name", str);
            }
            context.startActivity(intent);
        }

        public final void f(@Nullable Context context, @Nullable Uri uri, @Nullable String str, boolean z10, @Nullable Integer num, @Nullable Boolean bool) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setData(uri);
            intent.putExtra("pushModel", str);
            intent.putExtra("PAGER_INDEX", num);
            intent.putExtra("IS_SHOW_SWITCH_ACCOUNT_TOAST", bool);
            if (z10) {
                intent.addFlags(32768);
                intent.addFlags(268435456);
            }
            d(context, intent);
        }
    }

    /* compiled from: MainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f11633a;

        static {
            int[] iArr = new int[MainPagerType.values().length];
            try {
                iArr[MainPagerType.Chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MainPagerType.Feed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MainPagerType.Match.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MainPagerType.Live.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MainPagerType.Setting.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f11633a = iArr;
        }
    }

    /* compiled from: MainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.push.b {
        public c() {
        }

        @Override // com.cupidapp.live.push.b
        public void a(@NotNull FollowAnchorModel model) {
            s.i(model, "model");
            FKBaseMainPagerFragment U1 = MainActivity.this.U1(MainPagerType.Live.getPageIndex());
            FKLiveContainerFragment fKLiveContainerFragment = U1 instanceof FKLiveContainerFragment ? (FKLiveContainerFragment) U1 : null;
            if (fKLiveContainerFragment != null && fKLiveContainerFragment.A1()) {
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.M1(model, mainActivity.f11632z);
            if (fKLiveContainerFragment != null) {
                fKLiveContainerFragment.f1();
            }
        }

        @Override // com.cupidapp.live.push.b
        public void b() {
            MainActivity.this.m2();
        }

        @Override // com.cupidapp.live.push.b
        public void c(@NotNull ClubNewMessageConnectorMessageModel model) {
            s.i(model, "model");
            String groupId = model.getGroupId();
            if (groupId == null) {
                return;
            }
            SessionLocalListUtil.f13179a.b(MainActivity.this, groupId);
            MainActivity.this.m2();
        }

        @Override // com.cupidapp.live.push.b
        public void d(@NotNull MaskPartyRecommendModel model) {
            s.i(model, "model");
            MainActivity.this.q2(model);
        }

        @Override // com.cupidapp.live.push.b
        public void e(@NotNull FKPushModel model) {
            s.i(model, "model");
            com.cupidapp.live.push.c.a(model, MainActivity.this, FKPushTunnel.GRPC);
        }

        @Override // com.cupidapp.live.push.b
        public void f(@NotNull FKLiveHornModel model) {
            s.i(model, "model");
            FKBaseMainPagerFragment U1 = MainActivity.this.U1(MainPagerType.Live.getPageIndex());
            FKLiveContainerFragment fKLiveContainerFragment = U1 instanceof FKLiveContainerFragment ? (FKLiveContainerFragment) U1 : null;
            if (fKLiveContainerFragment != null) {
                fKLiveContainerFragment.r1(model);
            }
        }
    }

    /* compiled from: MainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements TabLayout.OnTabSelectedListener {
        public d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
            FKBaseMainPagerFragment U1;
            j.f12332a.a("BottomTabLayout", "onTabReselected position:" + ((Object) (tab != null ? Integer.valueOf(tab.getPosition()) : null)));
            if (tab != null) {
                tab.getPosition();
                if (MainActivity.this.isFinishing() || MainActivity.this.getSupportFragmentManager().isDestroyed() || (U1 = MainActivity.this.U1(tab.getPosition())) == null) {
                    return;
                }
                U1.X0();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            j.f12332a.a("BottomTabLayout", "onTabSelected position:" + ((Object) (tab != null ? Integer.valueOf(tab.getPosition()) : null)));
            if (tab != null) {
                tab.getPosition();
                if (MainActivity.this.isFinishing() || MainActivity.this.getSupportFragmentManager().isDestroyed()) {
                    return;
                }
                MainActivity.this.I1(tab.getPosition());
                ((FKBottomTabLayout) MainActivity.this.p1(R$id.bottomTabLayout)).i(tab, true);
                MainActivity mainActivity = MainActivity.this;
                mainActivity.f1(mainActivity.U1(tab.getPosition()), false, R$id.mainFragmentContainerLayout, false, true);
                FKBaseMainPagerFragment U1 = MainActivity.this.U1(tab.getPosition());
                if (U1 != null) {
                    U1.Y0(MainActivity.this);
                }
                if (tab.getPosition() == MainPagerType.Match.getPageIndex()) {
                    MainActivity.this.p1(R$id.shadowView).setVisibility(8);
                } else {
                    MainActivity.this.p1(R$id.shadowView).setVisibility(0);
                }
                if (tab.getPosition() == MainPagerType.Live.getPageIndex()) {
                    MainActivity.this.N1();
                }
                MainActivity.this.D = true;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
            j.f12332a.a("BottomTabLayout", "onTabUnselected position:" + ((Object) (tab != null ? Integer.valueOf(tab.getPosition()) : null)));
            if (tab != null) {
                tab.getPosition();
                if (MainActivity.this.isFinishing() || MainActivity.this.getSupportFragmentManager().isDestroyed()) {
                    return;
                }
                ((FKBottomTabLayout) MainActivity.this.p1(R$id.bottomTabLayout)).i(tab, false);
                FKBaseMainPagerFragment U1 = MainActivity.this.U1(tab.getPosition());
                if (U1 != null) {
                    U1.Z0();
                }
            }
        }
    }

    /* compiled from: MainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e implements com.cupidapp.live.base.activity.g {
        public e() {
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            if (!(MainActivity.this.S1() instanceof ContactSessionContainerFragment)) {
                return false;
            }
            FKBaseMainPagerFragment S1 = MainActivity.this.S1();
            s.f(S1);
            return S1.onBackPressed();
        }
    }

    /* compiled from: MainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class f implements o.c {
        public f() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            FKBaseMainPagerFragment S1 = MainActivity.this.S1();
            if (S1 != null) {
                S1.b1(j10);
            }
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            s.i(imageUriString, "imageUriString");
            FKBaseMainPagerFragment S1 = MainActivity.this.S1();
            if (S1 != null) {
                S1.c1(z10);
            }
        }
    }

    /* compiled from: MainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class g extends CountDownTimer {
        public g(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            MainActivity.this.r2();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            if (j10 <= MainActivity.this.f11630x - MainActivity.this.f11631y && System.currentTimeMillis() - MainActivity.this.f11627u > 120000) {
                MainActivity.this.m2();
            }
        }
    }

    public MainActivity() {
        final Function0 function0 = null;
        this.f11623q = new ViewModelLazy(v.b(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.MainActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.MainActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.MainActivity$special$$inlined$viewModels$default$3
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
                s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void e2(MainActivity this$0, Intent intent) {
        String stringExtra;
        s.i(this$0, "this$0");
        if (AppApplication.f11612d.g() || (stringExtra = intent.getStringExtra("notification.sessionId")) == null) {
            return;
        }
        SessionLocalListUtil.f13179a.c(this$0, stringExtra);
    }

    public static final void g2(MainActivity this$0, List list) {
        s.i(this$0, "this$0");
        ChatBubbleHelper.f13339a.f(this$0, list);
    }

    public static final void h2(MainActivity this$0) {
        s.i(this$0, "this$0");
        this$0.runOnUiThread(new Runnable() { // from class: com.cupidapp.live.e
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.i2(MainActivity.this);
            }
        });
    }

    public static final void i2(MainActivity this$0) {
        s.i(this$0, "this$0");
        ((FKBottomTabLayout) this$0.p1(R$id.bottomTabLayout)).setVisibility(4);
    }

    public static final void j2(MainActivity this$0) {
        s.i(this$0, "this$0");
        z0.s.f54824a.b(Math.max(h.k(this$0), this$0.getWindow().getDecorView().getHeight()));
    }

    public static /* synthetic */ void l2(MainActivity mainActivity, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        mainActivity.k2(str, str2);
    }

    public static final void w2(MainActivity this$0) {
        s.i(this$0, "this$0");
        l2(this$0, "liveshow", null, 2, null);
    }

    public final void H1(int i10) {
        this.D = false;
        TabLayout.Tab tabAt = ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).getTabAt(i10);
        if (tabAt != null) {
            tabAt.select();
        }
    }

    public final void I1(int i10) {
        if (i10 == MainPagerType.Chat.getPageIndex()) {
            b1();
        } else {
            h1();
        }
    }

    public final void J1() {
        FKBaseMainPagerFragment U1 = U1(MainPagerType.Match.getPageIndex());
        FKMatchContainerFragment fKMatchContainerFragment = U1 instanceof FKMatchContainerFragment ? (FKMatchContainerFragment) U1 : null;
        if (fKMatchContainerFragment != null) {
            fKMatchContainerFragment.N1();
        }
    }

    public final boolean K1(String str) {
        Uri data = getIntent().getData();
        Bundle extras = getIntent().getExtras();
        Object obj = extras != null ? extras.get("pushModel") : null;
        return SwitchAccountHelper.f18181a.b(this, str, data, obj instanceof String ? (String) obj : null);
    }

    public final void L1(@NotNull final LiveTabIconModel model) {
        s.i(model, "model");
        if (model.getText() != null) {
            FKPointerDialog fKPointerDialog = this.A;
            if (fKPointerDialog != null) {
                fKPointerDialog.g(false);
            }
            int Z1 = Z1();
            MainPagerType mainPagerType = MainPagerType.Live;
            if (Z1 != mainPagerType.getPageIndex() || ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).getVisibility() == 0) {
                this.A = FKPointerDialog.f12718p.a(this).m(true).j(Float.valueOf(0.0f)).n(model.getText()).r(OthersProtos.Enum_type.ENTRANCE_FLOAT, model.getLiveRuleId()).q(PointerPos.BOTTOM_CENTER, BgColor.RED).f(true).p(new Function0<p>() { // from class: com.cupidapp.live.MainActivity$checkShowTextBubble$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        j.a.b(com.cupidapp.live.base.router.j.f12156c, MainActivity.this, model.getJumpUrl(), null, 4, null);
                    }
                }, true);
                int pageIndex = mainPagerType.getPageIndex();
                FKPointerDialog fKPointerDialog2 = this.A;
                if (fKPointerDialog2 != null) {
                    TabLayout.Tab tabAt = ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).getTabAt(pageIndex);
                    View customView = tabAt != null ? tabAt.getCustomView() : null;
                    Integer expires = model.getExpires();
                    FKPointerDialog.E(fKPointerDialog2, customView, 0, 0, expires != null ? expires.intValue() : 5, null, 22, null);
                }
                Disposable disposed = a.C0726a.c(NetworkClient.f11868a.i(), model.getScene(), WindowType.LiveTabTextBubble.getType(), null, null, null, null, null, null, null, model.getLiveRuleId(), 508, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.MainActivity$checkShowTextBubble$lambda$3$$inlined$handle$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.MainActivity$checkShowTextBubble$1$3
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        s.i(it, "it");
                        return Boolean.TRUE;
                    }
                }, this)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    H(disposed);
                }
                s.h(disposed, "disposed");
            }
        }
    }

    public final void M1(FollowAnchorModel followAnchorModel, boolean z10) {
        p1.g gVar = p1.g.f52734a;
        Integer newLiveShowCount = followAnchorModel.getNewLiveShowCount();
        boolean z11 = false;
        gVar.T2(newLiveShowCount != null ? newLiveShowCount.intValue() : 0);
        gVar.y2(followAnchorModel.getLiveTabJumpUrl());
        gVar.s2(followAnchorModel.getFollowAnchorAvatars());
        if (gVar.t0() <= 0 && !(S1() instanceof FKLiveContainerFragment)) {
            z11 = s.d(followAnchorModel.getRedDot(), Boolean.TRUE);
        }
        gVar.z2(z11);
        ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).s(z10);
    }

    public final void N1() {
        if (this.D) {
            FKPointerDialog fKPointerDialog = this.A;
            if (fKPointerDialog != null) {
                fKPointerDialog.g(true);
            }
            int i10 = R$id.bottomTabLayout;
            ((FKBottomTabLayout) p1(i10)).r(new Function1<String, p>() { // from class: com.cupidapp.live.MainActivity$configLiveTagSelect$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(String str) {
                    invoke2(str);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    s.i(it, "it");
                    Observable<Result<Object>> Y = NetworkClient.f11868a.r().Y(it);
                    MainActivity mainActivity = MainActivity.this;
                    Disposable disposed = Y.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.MainActivity$configLiveTagSelect$1$invoke$$inlined$handle$default$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(Object obj) {
                            invoke2(obj);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                        }
                    }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, mainActivity)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (mainActivity != null) {
                            mainActivity.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
            });
            ((FKBottomTabLayout) p1(i10)).f(true, new Function0<p>() { // from class: com.cupidapp.live.MainActivity$configLiveTagSelect$2
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
                    g gVar = g.f52734a;
                    String V = gVar.V();
                    if (V == null || V.length() == 0) {
                        MainActivity.this.k2("liveshow", "LiveFollow");
                    } else {
                        j.a.b(com.cupidapp.live.base.router.j.f12156c, MainActivity.this, gVar.V(), null, 4, null);
                    }
                }
            });
            ((FKBottomTabLayout) p1(i10)).h(new Function0<p>() { // from class: com.cupidapp.live.MainActivity$configLiveTagSelect$3
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
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, MainActivity.this, g.f52734a.V(), null, 4, null);
                }
            });
        }
    }

    public final void O1() {
        Q1(new Function0<p>() { // from class: com.cupidapp.live.MainActivity$enterAppConfigTabUnreadCount$1
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
                ((FKBottomTabLayout) MainActivity.this.p1(R$id.bottomTabLayout)).y();
            }
        });
    }

    public final void P1() {
        FKGRPCMessageWatcher fKGRPCMessageWatcher = new FKGRPCMessageWatcher(this, new c());
        Lifecycle lifecycle = getLifecycle();
        s.h(lifecycle, "lifecycle");
        fKGRPCMessageWatcher.a(lifecycle);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        SensorPosition O0;
        FKBaseMainPagerFragment S1 = S1();
        return (S1 == null || (O0 = S1.O0()) == null) ? super.Q0() : O0;
    }

    public final void Q1(final Function0<p> function0) {
        Disposable disposed = NetworkClient.f11868a.i().r().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<CountDataModel, p>() { // from class: com.cupidapp.live.MainActivity$getAppUnreadCount$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CountDataModel countDataModel) {
                m2436invoke(countDataModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2436invoke(CountDataModel countDataModel) {
                MainActivity.this.f11627u = System.currentTimeMillis();
                g.f52734a.S1(countDataModel);
                FKBaseMainPagerFragment S1 = MainActivity.this.S1();
                if (S1 != null) {
                    S1.f1();
                }
                Function0 function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.MainActivity$getAppUnreadCount$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void R1() {
        Disposable disposed = NetworkClient.f11868a.i().o().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ConstantsResult, p>() { // from class: com.cupidapp.live.MainActivity$getConstantsAndroidData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConstantsResult constantsResult) {
                m2437invoke(constantsResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2437invoke(ConstantsResult constantsResult) {
                ConstantsResult constantsResult2 = constantsResult;
                g.f52734a.b2(constantsResult2);
                FKUpdateNewVersionDownloader.b(FKUpdateNewVersionDownloader.f18715a, constantsResult2, MainActivity.this, false, 4, null);
                LaunchDownloader.f11925a.h(MainActivity.this, constantsResult2);
                FKBaseMainPagerFragment S1 = MainActivity.this.S1();
                FKMatchContainerFragment fKMatchContainerFragment = S1 instanceof FKMatchContainerFragment ? (FKMatchContainerFragment) S1 : null;
                if (fKMatchContainerFragment != null) {
                    fKMatchContainerFragment.t1();
                }
                ((FKBottomTabLayout) MainActivity.this.p1(R$id.bottomTabLayout)).q(constantsResult2.getLiveTabPromotionInfo());
                com.cupidapp.live.base.web.helper.e.f13103a.b(MainActivity.this, constantsResult2.getUrlModel().getPreloadResource());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Nullable
    public final FKBaseMainPagerFragment S1() {
        return U1(Z1());
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    public boolean T0() {
        return Z1() != MainPagerType.Chat.getPageIndex();
    }

    public final void T1() {
        Disposable disposed = NetworkClient.f11868a.r().E0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FollowAnchorModel, p>() { // from class: com.cupidapp.live.MainActivity$getFollowLiveAvatar$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FollowAnchorModel followAnchorModel) {
                m2438invoke(followAnchorModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2438invoke(FollowAnchorModel followAnchorModel) {
                MainActivity.this.M1(followAnchorModel, true);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final FKBaseMainPagerFragment U1(int i10) {
        if (i10 < 0 || i10 >= this.f11624r.size()) {
            return null;
        }
        return this.f11624r.get(i10);
    }

    public final MainViewModel V1() {
        return (MainViewModel) this.f11623q.getValue();
    }

    public final void W1() {
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        Disposable disposed = NetworkClient.f11868a.A().p(Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude())).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MatchSettingResult, p>() { // from class: com.cupidapp.live.MainActivity$getMatchSettingResult$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MatchSettingResult matchSettingResult) {
                m2439invoke(matchSettingResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2439invoke(MatchSettingResult matchSettingResult) {
                g.f52734a.l0().d(matchSettingResult);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final xb.b X1() {
        return (xb.b) this.f11625s.getValue();
    }

    public final void Y1() {
        Disposable disposed = NetworkClient.f11868a.A().t().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SearchHideResult, p>() { // from class: com.cupidapp.live.MainActivity$getSearchHideData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SearchHideResult searchHideResult) {
                m2440invoke(searchHideResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2440invoke(SearchHideResult searchHideResult) {
                g.f52734a.F2(searchHideResult);
                FKBaseMainPagerFragment S1 = MainActivity.this.S1();
                FKMatchContainerFragment fKMatchContainerFragment = S1 instanceof FKMatchContainerFragment ? (FKMatchContainerFragment) S1 : null;
                if (fKMatchContainerFragment != null) {
                    fKMatchContainerFragment.x1();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final int Z1() {
        return ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).getSelectedTabPosition();
    }

    public final void a2() {
        Disposable disposed = NetworkClient.f11868a.N().g0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SuperBoostRemainAssetsResult, p>() { // from class: com.cupidapp.live.MainActivity$getSuperBoostCount$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SuperBoostRemainAssetsResult superBoostRemainAssetsResult) {
                m2441invoke(superBoostRemainAssetsResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2441invoke(SuperBoostRemainAssetsResult superBoostRemainAssetsResult) {
                SuperBoostRemainAssetsResult superBoostRemainAssetsResult2 = superBoostRemainAssetsResult;
                GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                Integer superboostRemains = superBoostRemainAssetsResult2.getSuperboostRemains();
                int intValue = superboostRemains != null ? superboostRemains.intValue() : 0;
                Integer targetedSuperboostRemains = superBoostRemainAssetsResult2.getTargetedSuperboostRemains();
                int intValue2 = targetedSuperboostRemains != null ? targetedSuperboostRemains.intValue() : 0;
                Integer travelboostRemains = superBoostRemainAssetsResult2.getTravelboostRemains();
                groupOthersLog.E(intValue, intValue2, travelboostRemains != null ? travelboostRemains.intValue() : 0);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void b2() {
        Disposable disposed = NetworkClient.f11868a.M().a().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserRankModel, p>() { // from class: com.cupidapp.live.MainActivity$getUserRank$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserRankModel userRankModel) {
                m2442invoke(userRankModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2442invoke(UserRankModel userRankModel) {
                UserRankModel userRankModel2 = userRankModel;
                n.f50241a.b(userRankModel2);
                g.f52734a.F1().d(userRankModel2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void c2(boolean z10) {
        Integer valueOf;
        int i10 = R$id.bottomTabLayout;
        ((FKBottomTabLayout) p1(i10)).c(this);
        ((FKBottomTabLayout) p1(i10)).addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        if (z10) {
            int intExtra = getIntent().getIntExtra("PAGER_INDEX", 0);
            MainPagerType mainPagerType = MainPagerType.Setting;
            if (intExtra == mainPagerType.getPageIndex()) {
                valueOf = Integer.valueOf(mainPagerType.getPageIndex());
            } else {
                MainPagerType mainPagerType2 = MainPagerType.Live;
                valueOf = intExtra == mainPagerType2.getPageIndex() ? Integer.valueOf(mainPagerType2.getPageIndex()) : null;
            }
            ((FKBottomTabLayout) p1(i10)).b(valueOf);
            if (getIntent().getBooleanExtra("IS_SHOW_SWITCH_ACCOUNT_TOAST", false)) {
                SwitchAccountHelper.f18181a.e(this, p1.g.f52734a.X());
            }
        }
    }

    public final void d2() {
        NewSessionBroadcastReceiver newSessionBroadcastReceiver = new NewSessionBroadcastReceiver(new NewSessionBroadcastReceiver.a() { // from class: com.cupidapp.live.b
            @Override // com.cupidapp.live.chat.receiver.NewSessionBroadcastReceiver.a
            public final void a(Intent intent) {
                MainActivity.e2(MainActivity.this, intent);
            }
        });
        this.f11626t = newSessionBroadcastReceiver;
        newSessionBroadcastReceiver.b(this);
    }

    public final void f2() {
        V1().getAllBubbleUrlList().observe(this, new Observer() { // from class: com.cupidapp.live.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.g2(MainActivity.this, (List) obj);
            }
        });
    }

    public final void k2(String str, String str2) {
        String lowerCase = str.toLowerCase();
        s.h(lowerCase, "this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case 3138974:
                if (lowerCase.equals(IAdInterListener.AdProdType.PRODUCT_FEEDS)) {
                    MainPagerType mainPagerType = MainPagerType.Feed;
                    H1(mainPagerType.getPageIndex());
                    this.f11624r.get(mainPagerType.getPageIndex()).a1(str2);
                    return;
                }
                return;
            case 103668165:
                if (lowerCase.equals("match")) {
                    MainPagerType mainPagerType2 = MainPagerType.Match;
                    H1(mainPagerType2.getPageIndex());
                    this.f11624r.get(mainPagerType2.getPageIndex()).a1(str2);
                    return;
                }
                return;
            case 954925063:
                if (lowerCase.equals("message")) {
                    H1(MainPagerType.Chat.getPageIndex());
                    return;
                }
                return;
            case 1418606057:
                if (lowerCase.equals("liveshow")) {
                    MainPagerType mainPagerType3 = MainPagerType.Live;
                    H1(mainPagerType3.getPageIndex());
                    this.f11624r.get(mainPagerType3.getPageIndex()).a1(str2);
                    return;
                }
                return;
            case 1985941072:
                if (lowerCase.equals(com.alipay.sdk.sys.a.f4669j)) {
                    H1(MainPagerType.Setting.getPageIndex());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void m2() {
        Q1(new Function0<p>() { // from class: com.cupidapp.live.MainActivity$refreshAllTabUnreadCount$1
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
                ((FKBottomTabLayout) MainActivity.this.p1(R$id.bottomTabLayout)).j();
            }
        });
    }

    public final void n2(FKPushMessageModel fKPushMessageModel) {
        Integer taskType;
        Integer subtaskType;
        j1.j.f50237a.a(!AppApplication.f11612d.e(), fKPushMessageModel != null ? fKPushMessageModel.getPushId() : null, fKPushMessageModel != null ? Long.valueOf(fKPushMessageModel.getSendTime()) : null, fKPushMessageModel != null ? fKPushMessageModel.getSenderId() : null, (fKPushMessageModel == null || (subtaskType = fKPushMessageModel.getSubtaskType()) == null) ? null : subtaskType.toString(), (fKPushMessageModel == null || (taskType = fKPushMessageModel.getTaskType()) == null) ? null : taskType.toString(), fKPushMessageModel != null ? fKPushMessageModel.getPushMessageType() : null);
    }

    public final void o2() {
        o c4 = o.f12354i.c(this);
        this.f11629w = c4;
        if (c4 != null) {
            c4.l(new f());
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
        if (i10 == 1001) {
            ImageModel imageModel = intent != null ? (ImageModel) z0.g.a(intent, ImageModel.class) : null;
            if (i11 == -1 && imageModel != null) {
                new FKFakeChangeAvatarSuccessLayout(this).d(imageModel);
            }
        }
        FKBaseMainPagerFragment S1 = S1();
        if (S1 != null) {
            S1.onActivityResult(i10, i11, intent);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().popBackStackImmediate() || P0().b()) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            AppApplication.f11612d.h().i();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_main);
        d1(0, 0);
        r2.i.f53231b.H();
        p1.g.f52734a.M1(false);
        FKLiveUtil.f14913a.h();
        this.f11624r.clear();
        for (Class cls : kotlin.collections.s.o(FKMatchContainerFragment.class, FKLiveContainerFragment.class, FeedContainerFragment.class, ContactSessionContainerFragment.class, UserInfoNewContainerFragment.class)) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(cls.getSimpleName());
            if (findFragmentByTag == null) {
                findFragmentByTag = (Fragment) cls.newInstance();
            }
            List<FKBaseMainPagerFragment> list = this.f11624r;
            s.g(findFragmentByTag, "null cannot be cast to non-null type com.cupidapp.live.base.fragment.FKBaseMainPagerFragment");
            list.add((FKBaseMainPagerFragment) findFragmentByTag);
        }
        c2(bundle == null);
        w0.a.f54093a.b();
        f2();
        BindPushTokenUtilKt.b(this);
        com.cupidapp.live.push.d.f17892a.c(this);
        this.B = LocationUtils.f12270h.a().n(this, new Function0<p>() { // from class: com.cupidapp.live.MainActivity$onCreate$2
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
                MainActivity.this.W1();
                MainActivity.this.Y1();
                MainActivity.this.J1();
                LocationChangeHelper locationChangeHelper = LocationChangeHelper.f16770a;
                locationChangeHelper.e(true);
                locationChangeHelper.g(MainActivity.this);
            }
        }, new Function2<Integer, String, p>() { // from class: com.cupidapp.live.MainActivity$onCreate$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, String str) {
                invoke2(num, str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num, @Nullable String str) {
                MainActivity.this.Y1();
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.MainActivity$onCreate$4
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
                MainActivity.this.Y1();
            }
        });
        R1();
        b2();
        a2();
        v2("onCreate");
        P1();
        d2();
        o2();
        T1();
        z0(new e());
        V1().callMyMessageBubbleApi();
        V1().callAllBubbleUrlApi();
        s2();
        V1().getAbTest();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ConsultFloatWindowHelper.f13810b.i();
        FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodOther, false, true, 2, null);
        FKLiveUtil.f14913a.p();
        LocationUtils.f12270h.a().h(this.B);
        this.B = null;
        NewSessionBroadcastReceiver newSessionBroadcastReceiver = this.f11626t;
        if (newSessionBroadcastReceiver != null) {
            newSessionBroadcastReceiver.c(this);
        }
        FKPointerDialog fKPointerDialog = this.A;
        if (fKPointerDialog != null) {
            fKPointerDialog.g(false);
        }
        super.onDestroy();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RouterUrlJumperSelectMainTabEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        H1(event.getType().getPageIndex());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
        }
        String action = intent != null ? intent.getAction() : null;
        if (action != null && action.hashCode() == 632856144 && action.equals("main_switch_tab")) {
            String stringExtra = intent.getStringExtra("param_tab_name");
            if (stringExtra != null) {
                k2(stringExtra, intent.getStringExtra("param_sub_tab_name"));
                return;
            }
            return;
        }
        v2("onNewIntent");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f11632z = false;
        FKBaseMainPagerFragment S1 = S1();
        if (S1 != null) {
            S1.V0();
        }
        t2();
        o oVar = this.f11629w;
        if (oVar != null) {
            oVar.n();
        }
        this.C.g();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        s.i(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).b(Integer.valueOf(savedInstanceState.getInt("CURRENT_TAB_POSITION")));
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f11632z = true;
        if (!(S1() instanceof ContactSessionContainerFragment)) {
            p2();
            EventBus.c().o(new CloseTwoLevelFloorEvent());
        }
        FKBaseMainPagerFragment S1 = S1();
        if (S1 != null) {
            S1.W0();
        }
        GrpcIM.INSTANCE.connect();
        ((RelativeLayout) p1(R$id.mainRootDrawerLayout)).post(new Runnable() { // from class: com.cupidapp.live.c
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.j2(MainActivity.this);
            }
        });
        p1.g gVar = p1.g.f52734a;
        if (gVar.q() == null) {
            R1();
        }
        if (gVar.t()) {
            gVar.e2(false);
            O1();
        } else {
            m2();
        }
        o0.f12367a.f(this);
        o oVar = this.f11629w;
        if (oVar != null) {
            oVar.m();
        }
        r2();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        s.i(outState, "outState");
        super.c1(outState);
        outState.putInt("CURRENT_TAB_POSITION", Z1());
    }

    @Nullable
    public View p1(int i10) {
        Map<Integer, View> map = this.E;
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

    public final void p2() {
        int i10 = R$id.bottomTabLayout;
        ((FKBottomTabLayout) p1(i10)).animate().translationY(0.0f).setDuration(100L);
        ((FKBottomTabLayout) p1(i10)).setVisibility(0);
        p1(R$id.shadowView).setVisibility(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if ((r0 != null && r0.b2()) == false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q2(final com.cupidapp.live.maskparty.model.MaskPartyRecommendModel r6) {
        /*
            r5 = this;
            com.cupidapp.live.appdialog.model.BottomTabName$a r0 = com.cupidapp.live.appdialog.model.BottomTabName.Companion
            int r1 = r5.Z1()
            com.cupidapp.live.appdialog.model.BottomTabName r0 = r0.a(r1)
            if (r0 != 0) goto Ld
            return
        Ld:
            com.cupidapp.live.maskparty.view.FakeMaskPartyLayout$a r1 = com.cupidapp.live.maskparty.view.FakeMaskPartyLayout.f16374h
            boolean r1 = r1.a()
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L44
            java.util.List r1 = r6.getCandidateTab()
            java.lang.String r0 = r0.getTabName()
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L44
            boolean r0 = r5.f11632z
            if (r0 == 0) goto L44
            com.cupidapp.live.base.fragment.FKBaseMainPagerFragment r0 = r5.S1()
            boolean r1 = r0 instanceof com.cupidapp.live.chat.fragment.ContactSessionContainerFragment
            if (r1 == 0) goto L35
            com.cupidapp.live.chat.fragment.ContactSessionContainerFragment r0 = (com.cupidapp.live.chat.fragment.ContactSessionContainerFragment) r0
            goto L36
        L35:
            r0 = r2
        L36:
            if (r0 == 0) goto L40
            boolean r0 = r0.b2()
            if (r0 != r3) goto L40
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L44
            goto L45
        L44:
            r3 = 0
        L45:
            com.cupidapp.live.base.network.NetworkClient r0 = com.cupidapp.live.base.network.NetworkClient.f11868a
            z2.a r0 = r0.z()
            java.lang.String r1 = r6.getMatchUserId()
            int r4 = r6.getType()
            io.reactivex.Observable r0 = r0.s(r1, r3, r4)
            com.cupidapp.live.base.network.i r1 = new com.cupidapp.live.base.network.i
            r1.<init>()
            io.reactivex.Observable r0 = r0.flatMap(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Observable r0 = r0.observeOn(r1)
            com.cupidapp.live.MainActivity$showMaskPartyRecommendDialog$$inlined$handle$default$1 r1 = new com.cupidapp.live.MainActivity$showMaskPartyRecommendDialog$$inlined$handle$default$1
            r1.<init>()
            com.cupidapp.live.base.network.e r6 = new com.cupidapp.live.base.network.e
            r6.<init>(r1)
            com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2 r1 = new com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2
            r1.<init>(r2, r5)
            com.cupidapp.live.base.network.e r2 = new com.cupidapp.live.base.network.e
            r2.<init>(r1)
            io.reactivex.disposables.Disposable r6 = r0.subscribe(r6, r2)
            java.lang.String r0 = "disposed"
            if (r6 == 0) goto L8a
            kotlin.jvm.internal.s.h(r6, r0)
            r5.H(r6)
        L8a:
            kotlin.jvm.internal.s.h(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.MainActivity.q2(com.cupidapp.live.maskparty.model.MaskPartyRecommendModel):void");
    }

    public final void r2() {
        t2();
        g gVar = new g(this.f11630x, this.f11631y);
        this.f11628v = gVar;
        gVar.start();
    }

    public final void s2() {
        i.d(this.C, 6, 1, new Function0<p>() { // from class: com.cupidapp.live.MainActivity$startSearchHideCountDownTimer$1
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
                MainActivity.this.Y1();
            }
        }, null, 8, null);
    }

    public final void t2() {
        CountDownTimer countDownTimer = this.f11628v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f11628v = null;
    }

    public final void u2() {
        H1(MainPagerType.Match.getPageIndex());
        FKBaseMainPagerFragment S1 = S1();
        FKMatchContainerFragment fKMatchContainerFragment = S1 instanceof FKMatchContainerFragment ? (FKMatchContainerFragment) S1 : null;
        if (fKMatchContainerFragment != null) {
            fKMatchContainerFragment.O1(FKMatchContainerFragment.MatchTabType.Match);
        }
    }

    public final void v2(String str) {
        Serializable serializableExtra = getIntent().getSerializableExtra("pushModel");
        FKPushMessageModel fKPushMessageModel = serializableExtra instanceof FKPushMessageModel ? (FKPushMessageModel) serializableExtra : null;
        if (fKPushMessageModel != null) {
            com.cupidapp.live.base.utils.j.f12332a.a("urlRouterHandleUrl", str + " GRPC pushMessageModel: " + GsonUtil.f12000a.b().toJson(fKPushMessageModel));
            if (K1(fKPushMessageModel.getUserId())) {
                com.cupidapp.live.push.d.f17892a.h(this, fKPushMessageModel);
                j.a.b(com.cupidapp.live.base.router.j.f12156c, this, fKPushMessageModel.getUrl(), null, 4, null);
            }
        } else if (com.cupidapp.live.base.web.c.f13063a.b(getIntent().getData())) {
            fKPushMessageModel = FKPushMessageModel.Companion.a(getIntent().getData());
            com.cupidapp.live.base.utils.j.f12332a.a("urlRouterHandleUrl", str + " push通道 pushMessageModel: " + GsonUtil.f12000a.b().toJson(fKPushMessageModel));
            if (K1(fKPushMessageModel != null ? fKPushMessageModel.getUserId() : null)) {
                com.cupidapp.live.push.d.f17892a.h(this, fKPushMessageModel);
                j.a.b(com.cupidapp.live.base.router.j.f12156c, this, fKPushMessageModel != null ? fKPushMessageModel.getUrl() : null, null, 4, null);
                n2(fKPushMessageModel);
            }
        } else {
            FKPushMessageModel.Companion companion = FKPushMessageModel.Companion;
            Bundle extras = getIntent().getExtras();
            Object obj = extras != null ? extras.get("pushModel") : null;
            fKPushMessageModel = companion.b(obj instanceof String ? (String) obj : null);
            if (fKPushMessageModel != null) {
                com.cupidapp.live.base.utils.j.f12332a.a("urlRouterHandleUrl", str + " Oppo push通道 pushMessageModel: " + GsonUtil.f12000a.b().toJson(fKPushMessageModel));
                if (K1(fKPushMessageModel.getUserId())) {
                    com.cupidapp.live.push.d.f17892a.h(this, fKPushMessageModel);
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, this, fKPushMessageModel.getUrl(), null, 4, null);
                    n2(fKPushMessageModel);
                }
            } else {
                Uri data = getIntent().getData();
                if (data == null) {
                    return;
                }
                if (E0()) {
                    getIntent().setData(null);
                    return;
                }
                j.a.b(com.cupidapp.live.base.router.j.f12156c, this, data.toString(), null, 4, null);
            }
        }
        if (com.cupidapp.live.liveshow.helper.a.f15073a.b(fKPushMessageModel) && Z1() != MainPagerType.Live.getPageIndex()) {
            AppApplication.f11612d.h().j().post(new Runnable() { // from class: com.cupidapp.live.f
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.w2(MainActivity.this);
                }
            });
        }
        getIntent().setData(null);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RefreshAllTabUnreadCountEvent event) {
        s.i(event, "event");
        m2();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull BottomTabVisibilityEvent event) {
        s.i(event, "event");
        if (event.getVisible()) {
            if (p1(R$id.shadowView).getVisibility() == 4) {
                p2();
            }
        } else {
            int i10 = R$id.shadowView;
            if (p1(i10).getVisibility() != 4) {
                p1(i10).setVisibility(4);
                ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).animate().translationY(h.c(this, 56.0f)).setDuration(100L).withEndAction(new Runnable() { // from class: com.cupidapp.live.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.h2(MainActivity.this);
                    }
                });
            }
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RefreshSpecifyTabUnreadCountEvent event) {
        s.i(event, "event");
        int i10 = b.f11633a[event.getType().ordinal()];
        if (i10 == 1) {
            FKBottomTabLayout bottomTabLayout = (FKBottomTabLayout) p1(R$id.bottomTabLayout);
            s.h(bottomTabLayout, "bottomTabLayout");
            FKBottomTabLayout.l(bottomTabLayout, false, 1, null);
            return;
        }
        if (i10 == 2) {
            FKBaseMainPagerFragment S1 = S1();
            if (S1 != null) {
                S1.f1();
            }
            ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).o();
            return;
        }
        if (i10 == 3) {
            ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).u(false);
            return;
        }
        if (i10 != 4) {
            if (i10 != 5) {
                return;
            }
            ((FKBottomTabLayout) p1(R$id.bottomTabLayout)).v();
            return;
        }
        FKBaseMainPagerFragment S12 = S1();
        if (S12 != null) {
            S12.f1();
        }
        int i11 = R$id.bottomTabLayout;
        FKBottomTabLayout bottomTabLayout2 = (FKBottomTabLayout) p1(i11);
        s.h(bottomTabLayout2, "bottomTabLayout");
        FKBottomTabLayout.t(bottomTabLayout2, false, 1, null);
        FKBottomTabLayout bottomTabLayout3 = (FKBottomTabLayout) p1(i11);
        s.h(bottomTabLayout3, "bottomTabLayout");
        FKBottomTabLayout.g(bottomTabLayout3, false, null, 3, null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull HandleClipboardJumpEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        q1.b.f53003a.d(this, (RelativeLayout) p1(R$id.mainRootDrawerLayout), new Function1<String, p>() { // from class: com.cupidapp.live.MainActivity$onEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String token) {
                s.i(token, "token");
                Observable<Result<ActivityJumpModel>> v2 = NetworkClient.f11868a.A().v(token);
                final MainActivity mainActivity = MainActivity.this;
                Disposable disposed = v2.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ActivityJumpModel, p>() { // from class: com.cupidapp.live.MainActivity$onEvent$2$invoke$$inlined$handle$default$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(ActivityJumpModel activityJumpModel) {
                        m2444invoke(activityJumpModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2444invoke(ActivityJumpModel activityJumpModel) {
                        q1.b.f53003a.c(MainActivity.this);
                        j.a.b(com.cupidapp.live.base.router.j.f12156c, MainActivity.this, activityJumpModel.getActivityJumpUrl(), null, 4, null);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, mainActivity)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (mainActivity != null) {
                        mainActivity.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
            }
        });
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull StartCacheSplashAdDataEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        Disposable disposed = NetworkClient.f11868a.x().a().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FKStartupMediaResult, p>() { // from class: com.cupidapp.live.MainActivity$onEvent$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FKStartupMediaResult fKStartupMediaResult) {
                m2443invoke(fKStartupMediaResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2443invoke(FKStartupMediaResult fKStartupMediaResult) {
                SplashAdSelectHelper.f18415a.S(MainActivity.this, fKStartupMediaResult.getSplashAdNew(), false, null, new Function1<SplashAdRequestModel, p>() { // from class: com.cupidapp.live.MainActivity$onEvent$3$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(SplashAdRequestModel splashAdRequestModel) {
                        invoke2(splashAdRequestModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable SplashAdRequestModel splashAdRequestModel) {
                        if (splashAdRequestModel != null && splashAdRequestModel.isNotHuaweiJHSplashAd()) {
                            FKStartupAdFragment.f18400m.b(splashAdRequestModel);
                        }
                    }
                });
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }
}
