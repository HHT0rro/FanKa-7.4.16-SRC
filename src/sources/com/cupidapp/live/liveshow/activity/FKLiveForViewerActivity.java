package com.cupidapp.live.liveshow.activity;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.router.jumper.ShowFansGroupEvent;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.consult.helper.ConsultFloatWindowHelper;
import com.cupidapp.live.liveshow.adapter.FKLiveForViewerPagerAdapter;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindowUtil;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowNextListResult;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.SendGiftResult;
import com.cupidapp.live.liveshow.view.FKViewPager2ContainerLayout;
import com.cupidapp.live.liveshow.view.dialog.LiveHeatCountDesDialog;
import com.cupidapp.live.liveshow.view.horn.FKLiveHornEvent;
import com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment;
import com.cupidapp.live.profile.event.UpdateLiveShowEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;
import z0.h;
import z0.t;
import z0.y;

/* compiled from: FKLiveForViewerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForViewerActivity extends FKBaseLiveActivity implements com.cupidapp.live.liveshow.adapter.a {

    @NotNull
    public static final a G = new a(null);

    @Nullable
    public FKLiveForViewerPagerAdapter A;
    public int B;
    public int C;
    public boolean D;

    /* renamed from: z */
    @Nullable
    public FKLiveForViewerViewModel f14772z;

    @NotNull
    public Map<Integer, View> F = new LinkedHashMap();

    @NotNull
    public AtomicInteger E = new AtomicInteger((int) (Math.random() * 10000));

    /* compiled from: FKLiveForViewerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, FKLiveForViewerViewModel fKLiveForViewerViewModel, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = true;
            }
            aVar.a(context, fKLiveForViewerViewModel, z10);
        }

        public final void a(@Nullable Context context, @NotNull FKLiveForViewerViewModel liveForViewerModel, boolean z10) {
            s.i(liveForViewerModel, "liveForViewerModel");
            Intent intent = new Intent(context, (Class<?>) FKLiveForViewerActivity.class);
            z0.g.c(intent, liveForViewerModel);
            intent.putExtra("OPEN_MINI_WINDOW", z10);
            if (liveForViewerModel.getNeedNewTask()) {
                intent.addFlags(268435456);
            }
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: FKLiveForViewerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.base.activity.g {
        public b() {
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            List<Fragment> fragments = FKLiveForViewerActivity.this.getSupportFragmentManager().getFragments();
            s.h(fragments, "supportFragmentManager.fragments");
            boolean z10 = false;
            for (Fragment fragment : fragments) {
                if ((fragment instanceof FKBaseFragment) && ((FKBaseFragment) fragment).onBackPressed()) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    /* compiled from: FKLiveForViewerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.liveshow.view.b {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.view.b
        public void a(boolean z10) {
            FKLiveForViewerFragment V1 = FKLiveForViewerActivity.this.V1();
            if (V1 != null) {
                V1.c2(z10);
            }
        }

        @Override // com.cupidapp.live.liveshow.view.b
        public void b(float f10) {
            FKLiveForViewerFragment V1 = FKLiveForViewerActivity.this.V1();
            if (V1 != null) {
                V1.K1(f10);
            }
        }
    }

    public static final boolean P1(FKLiveForViewerActivity this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            ((FrameLayout) this$0.F1(R$id.liveWebContainerLayout)).performClick();
            return this$0.m1();
        }
        if (this$0.u1()) {
            return true;
        }
        this$0.b2();
        return false;
    }

    @Override // com.cupidapp.live.liveshow.adapter.a
    public void C(@NotNull List<String> liveShowIds, @Nullable String str, @NotNull final Function1<? super LiveShowNextListResult, p> successCallback, @NotNull final Function0<p> failCallback) {
        LiveshowOpenSource openSource;
        s.i(liveShowIds, "liveShowIds");
        s.i(successCallback, "successCallback");
        s.i(failCallback, "failCallback");
        u2.a r10 = NetworkClient.f11868a.r();
        FKLiveForViewerViewModel fKLiveForViewerViewModel = this.f14772z;
        Disposable disposed = r10.l0(liveShowIds, (fKLiveForViewerViewModel == null || (openSource = fKLiveForViewerViewModel.getOpenSource()) == null) ? null : openSource.getValue(), str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowNextListResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity$refreshRecommendNextLiveShowList$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowNextListResult liveShowNextListResult) {
                m2601invoke(liveShowNextListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2601invoke(LiveShowNextListResult liveShowNextListResult) {
                Function1.this.invoke(liveShowNextListResult);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity$refreshRecommendNextLiveShowList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                failCallback.invoke();
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Nullable
    public View F1(int i10) {
        Map<Integer, View> map = this.F;
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

    public final void O1() {
        ((FrameLayout) F1(R$id.liveWebContainerLayout)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.liveshow.activity.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean P1;
                P1 = FKLiveForViewerActivity.P1(FKLiveForViewerActivity.this, view, motionEvent);
                return P1;
            }
        });
        z0(new b());
        ConstraintLayout clearScreenPromptLayout = (ConstraintLayout) F1(R$id.clearScreenPromptLayout);
        s.h(clearScreenPromptLayout, "clearScreenPromptLayout");
        y.d(clearScreenPromptLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity$bindClickEvent$3
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
                ((FKSVGAImageView) FKLiveForViewerActivity.this.F1(R$id.clearScreenSVGAImageView)).K();
                ((ConstraintLayout) FKLiveForViewerActivity.this.F1(R$id.clearScreenPromptLayout)).setVisibility(8);
            }
        });
    }

    public final void Q1() {
        if (h.g(this) == NetworkStateConstants.MOBILE) {
            com.cupidapp.live.base.view.h.f12779a.j(this, R$string.use_mobile_to_watch_live, R$mipmap.icon_mobile);
        }
    }

    public final void R1(boolean z10) {
        ((FKViewPager2ContainerLayout) F1(R$id.viewPagerContainerLayout)).f(z10);
    }

    public final void S1(LiveShowModel liveShowModel) {
        List o10 = kotlin.collections.s.o(liveShowModel);
        FKLiveForViewerViewModel fKLiveForViewerViewModel = this.f14772z;
        this.A = new FKLiveForViewerPagerAdapter(this, o10, this, false, fKLiveForViewerViewModel != null ? fKLiveForViewerViewModel.getLiveRoomSensor() : null, 8, null);
        int i10 = R$id.liveShowForViewerViewPager;
        ((ViewPager2) F1(i10)).setAdapter(this.A);
        ((ViewPager2) F1(i10)).setCurrentItem(View.LAST_APP_AUTOFILL_ID, false);
    }

    public final void T1() {
        Z1();
        EventBus.c().o(new FKLiveHornEvent());
        finish();
    }

    public final MiniWindowCloseMethod U1() {
        LiveInRoomSensorModel liveRoomSensor;
        FKLiveForViewerViewModel fKLiveForViewerViewModel = this.f14772z;
        if (s.d((fKLiveForViewerViewModel == null || (liveRoomSensor = fKLiveForViewerViewModel.getLiveRoomSensor()) == null) ? null : liveRoomSensor.getEnterSource(), "LiveShowEnterMiniLive")) {
            return MiniWindowCloseMethod.CloseMethodClickMiniLive;
        }
        return MiniWindowCloseMethod.CloseMethodEnterLive;
    }

    public final FKLiveForViewerFragment V1() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("f" + this.C);
        FKLiveForViewerFragment fKLiveForViewerFragment = findFragmentByTag instanceof FKLiveForViewerFragment ? (FKLiveForViewerFragment) findFragmentByTag : null;
        j.f12332a.a("getCurrentFragment", "fragment: " + ((Object) fKLiveForViewerFragment));
        return fKLiveForViewerFragment;
    }

    @Nullable
    public final FKLiveForViewerViewModel W1() {
        return this.f14772z;
    }

    public final void X1() {
        ((FKViewPager2ContainerLayout) F1(R$id.viewPagerContainerLayout)).setClearScreenListener(new c());
    }

    public final void Y1() {
        int i10 = R$id.liveShowForViewerViewPager;
        View childAt = ((ViewPager2) F1(i10)).getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager != null) {
            layoutManager.setItemPrefetchEnabled(false);
        }
        View childAt2 = ((ViewPager2) F1(i10)).getChildAt(0);
        RecyclerView recyclerView2 = childAt2 instanceof RecyclerView ? (RecyclerView) childAt2 : null;
        if (recyclerView2 != null) {
            recyclerView2.setItemViewCacheSize(0);
        }
        ((ViewPager2) F1(i10)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity$initViewPager$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i11) {
                int i12;
                int i13;
                int i14;
                FKLiveForViewerPagerAdapter fKLiveForViewerPagerAdapter;
                int i15;
                if (i11 == 0) {
                    i12 = FKLiveForViewerActivity.this.B;
                    i13 = FKLiveForViewerActivity.this.C;
                    if (i12 == i13) {
                        return;
                    }
                    FKLiveForViewerActivity fKLiveForViewerActivity = FKLiveForViewerActivity.this;
                    i14 = fKLiveForViewerActivity.C;
                    fKLiveForViewerActivity.B = i14;
                    fKLiveForViewerPagerAdapter = FKLiveForViewerActivity.this.A;
                    if (fKLiveForViewerPagerAdapter != null) {
                        i15 = FKLiveForViewerActivity.this.C;
                        fKLiveForViewerPagerAdapter.m(i15);
                    }
                    ((FKViewPager2ContainerLayout) FKLiveForViewerActivity.this.F1(R$id.viewPagerContainerLayout)).i();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i11) {
                boolean z10;
                FKLiveForViewerPagerAdapter fKLiveForViewerPagerAdapter;
                z10 = FKLiveForViewerActivity.this.D;
                if (z10) {
                    fKLiveForViewerPagerAdapter = FKLiveForViewerActivity.this.A;
                    if (fKLiveForViewerPagerAdapter != null) {
                        fKLiveForViewerPagerAdapter.m(i11);
                    }
                    FKLiveForViewerActivity.this.D = false;
                }
                FKLiveForViewerActivity.this.C = i11;
            }
        });
    }

    public final void Z1() {
        LiveInRoomSensorModel liveRoomSensor;
        FKLiveForViewerViewModel fKLiveForViewerViewModel = this.f14772z;
        if (((fKLiveForViewerViewModel == null || (liveRoomSensor = fKLiveForViewerViewModel.getLiveRoomSensor()) == null) ? null : liveRoomSensor.getScene()) == SensorScene.Match) {
            setResult(-1);
        }
    }

    public final void a2(@NotNull String giftId, int i10, @NotNull final Function0<p> noBalanceCallback, @NotNull final Function1<? super Boolean, p> sendCallback) {
        String itemId;
        s.i(giftId, "giftId");
        s.i(noBalanceCallback, "noBalanceCallback");
        s.i(sendCallback, "sendCallback");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = a.C0826a.f(NetworkClient.f11868a.r(), itemId, giftId, Integer.valueOf(this.E.incrementAndGet()), false, null, i10, null, null, 216, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SendGiftResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity$sendGiftToCurrentLiveShow$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SendGiftResult sendGiftResult) {
                m2602invoke(sendGiftResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2602invoke(SendGiftResult sendGiftResult) {
                p1.g.f52734a.W1(sendGiftResult.getBalance());
                Function1.this.invoke(Boolean.TRUE);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity$sendGiftToCurrentLiveShow$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                String a10 = com.cupidapp.live.base.network.j.f12008a.a(it);
                boolean z10 = false;
                if (a10 != null && t.q(a10) == RequestErrorCode.InsufficientBalance.getValue()) {
                    z10 = true;
                }
                if (z10) {
                    noBalanceCallback.invoke();
                    return Boolean.TRUE;
                }
                Function1<Boolean, p> function1 = sendCallback;
                Boolean bool = Boolean.FALSE;
                function1.invoke(bool);
                return bool;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if ((r0 != null && r0.isRemoteConnect()) != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b2() {
        /*
            r4 = this;
            com.cupidapp.live.liveshow.constants.FKLiveConstantsData r0 = com.cupidapp.live.liveshow.constants.FKLiveConstantsData.INSTANCE
            com.cupidapp.live.liveshow.model.LiveShowModel r1 = r0.getRemoteConnectLiveShow()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L12
            boolean r1 = r1.isStreamer()
            if (r1 != r3) goto L12
            r1 = 1
            goto L13
        L12:
            r1 = 0
        L13:
            if (r1 != 0) goto L26
            com.cupidapp.live.liveshow.model.LiveShowModel r0 = r0.getRemoteConnectLiveShow()
            if (r0 == 0) goto L23
            boolean r0 = r0.isRemoteConnect()
            if (r0 != r3) goto L23
            r0 = 1
            goto L24
        L23:
            r0 = 0
        L24:
            if (r0 == 0) goto L27
        L26:
            r2 = 1
        L27:
            int r0 = com.cupidapp.live.R$id.liveShowForViewerViewPager
            android.view.View r0 = r4.F1(r0)
            androidx.viewpager2.widget.ViewPager2 r0 = (androidx.viewpager2.widget.ViewPager2) r0
            r1 = r2 ^ 1
            r0.setUserInputEnabled(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity.b2():void");
    }

    public final void c2() {
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.d1().c(), Boolean.TRUE)) {
            ((ConstraintLayout) F1(R$id.clearScreenPromptLayout)).setVisibility(0);
            FKSVGAImageView clearScreenSVGAImageView = (FKSVGAImageView) F1(R$id.clearScreenSVGAImageView);
            s.h(clearScreenSVGAImageView, "clearScreenSVGAImageView");
            FKSVGAImageView.F(clearScreenSVGAImageView, "clear_screen_guide.svga", null, null, 6, null);
            gVar.d1().d(Boolean.FALSE);
            return;
        }
        ((ConstraintLayout) F1(R$id.clearScreenPromptLayout)).setVisibility(8);
    }

    public final void d2(@Nullable String str, boolean z10) {
        B1(str, z10);
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity
    @Nullable
    public FrameLayout o1() {
        return (FrameLayout) F1(R$id.liveShowForViewerTopRankLayout);
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 200) {
            FKLiveMiniWindowUtil fKLiveMiniWindowUtil = FKLiveMiniWindowUtil.f15095a;
            FKLiveForViewerFragment V1 = V1();
            FKLiveMiniWindowUtil.g(fKLiveMiniWindowUtil, this, V1 != null ? V1.S1() : null, false, 4, null);
            T1();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (P0().b()) {
            return;
        }
        if (getIntent().getBooleanExtra("OPEN_MINI_WINDOW", true)) {
            FKLiveMiniWindow a10 = FKLiveMiniWindow.f15074m.a();
            FKLiveForViewerFragment V1 = V1();
            a10.U(this, V1 != null ? V1.S1() : null, new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity$onBackPressed$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(boolean z10) {
                    FKLiveForViewerActivity.this.T1();
                }
            });
            return;
        }
        T1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
    
        if (((r3 == null || (r3 = r3.getLiveRoomSensor()) == null) ? null : r3.getSensorPosition()) == com.cupidapp.live.base.sensorslog.SensorPosition.LiveShowRoom) goto L87;
     */
    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r13) {
        /*
            r12 = this;
            super.onCreate(r13)
            r13 = 2131558494(0x7f0d005e, float:1.8742305E38)
            r12.setContentView(r13)
            r13 = 1
            r12.y1(r13)
            r12.D = r13
            android.content.Intent r0 = r12.getIntent()
            java.lang.String r1 = "intent"
            kotlin.jvm.internal.s.h(r0, r1)
            java.lang.Class<com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel> r1 = com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel.class
            java.io.Serializable r0 = z0.g.a(r0, r1)
            com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel r0 = (com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel) r0
            r12.f14772z = r0
            com.cupidapp.live.liveshow.constants.FKLiveConstantsData r1 = com.cupidapp.live.liveshow.constants.FKLiveConstantsData.INSTANCE
            r2 = 0
            if (r0 == 0) goto L32
            com.cupidapp.live.liveshow.model.LiveShowModel r0 = r0.getLiveShow()
            if (r0 == 0) goto L32
            java.lang.String r0 = r0.getStrategyId()
            goto L33
        L32:
            r0 = r2
        L33:
            r1.setFkLiveStrategyId(r0)
            com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel r0 = r12.f14772z
            if (r0 != 0) goto L3f
            r12.finish()
            goto Led
        L3f:
            com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow$a r0 = com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow.f15074m
            com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow r3 = r0.a()
            boolean r3 = r3.H()
            r4 = 0
            if (r3 == 0) goto L82
            com.cupidapp.live.liveshow.model.LiveShowModel r3 = r1.getLiveShowModel()
            if (r3 == 0) goto L57
            java.lang.String r3 = r3.getItemId()
            goto L58
        L57:
            r3 = r2
        L58:
            com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel r5 = r12.f14772z
            if (r5 == 0) goto L67
            com.cupidapp.live.liveshow.model.LiveShowModel r5 = r5.getLiveShow()
            if (r5 == 0) goto L67
            java.lang.String r5 = r5.getItemId()
            goto L68
        L67:
            r5 = r2
        L68:
            boolean r3 = kotlin.jvm.internal.s.d(r3, r5)
            if (r3 != 0) goto L6f
            goto L96
        L6f:
            com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel r3 = r12.f14772z
            if (r3 == 0) goto L78
            com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel r3 = r3.getLiveRoomSensor()
            goto L79
        L78:
            r3 = r2
        L79:
            if (r3 != 0) goto L7c
            goto L98
        L7c:
            java.lang.String r5 = "LiveShowEnterMiniLive"
            r3.setEnterSource(r5)
            goto L98
        L82:
            com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel r3 = r12.f14772z
            if (r3 == 0) goto L91
            com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel r3 = r3.getLiveRoomSensor()
            if (r3 == 0) goto L91
            com.cupidapp.live.base.sensorslog.SensorPosition r3 = r3.getSensorPosition()
            goto L92
        L91:
            r3 = r2
        L92:
            com.cupidapp.live.base.sensorslog.SensorPosition r5 = com.cupidapp.live.base.sensorslog.SensorPosition.LiveShowRoom
            if (r3 != r5) goto L98
        L96:
            r9 = 1
            goto L99
        L98:
            r9 = 0
        L99:
            com.cupidapp.live.consult.helper.ConsultFloatWindowHelper r3 = com.cupidapp.live.consult.helper.ConsultFloatWindowHelper.f13810b
            r3.i()
            com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow r6 = r0.a()
            com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod r7 = r12.U1()
            r8 = 0
            r10 = 2
            r11 = 0
            com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow.G(r6, r7, r8, r9, r10, r11)
            com.cupidapp.live.liveshow.entity.FKLiveUtil r0 = com.cupidapp.live.liveshow.entity.FKLiveUtil.f14913a
            r0.h()
            com.cupidapp.live.liveshow.model.LiveShowResult$Companion r0 = com.cupidapp.live.liveshow.model.LiveShowResult.Companion
            com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel r3 = r12.f14772z
            kotlin.jvm.internal.s.f(r3)
            com.cupidapp.live.liveshow.model.LiveShowModel r3 = r3.getLiveShow()
            com.cupidapp.live.liveshow.model.LiveShowResult r0 = r0.a(r3)
            r1.setFkLiveShowResult(r0)
            r12.Y1()
            r12.X1()
            com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel r0 = r12.f14772z
            kotlin.jvm.internal.s.f(r0)
            com.cupidapp.live.liveshow.model.LiveShowModel r0 = r0.getLiveShow()
            r12.S1(r0)
            r12.O1()
            r12.c2()
            r12.Q1()
            com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity$a r0 = com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity.f14907e
            com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity r0 = r0.a()
            r1 = 2
            com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity.p(r0, r13, r2, r1, r2)
            com.cupidapp.live.base.network.download.LaunchDownloader r13 = com.cupidapp.live.base.network.download.LaunchDownloader.f11925a
            r13.v(r12)
        Led:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LiveShowModel liveShowModel;
        LiveInRoomSensorModel liveRoomSensor;
        super.onDestroy();
        FKLiveForViewerPagerAdapter fKLiveForViewerPagerAdapter = this.A;
        if (fKLiveForViewerPagerAdapter != null) {
            fKLiveForViewerPagerAdapter.j();
        }
        FKLiveForViewerViewModel fKLiveForViewerViewModel = this.f14772z;
        if (!s.d((fKLiveForViewerViewModel == null || (liveRoomSensor = fKLiveForViewerViewModel.getLiveRoomSensor()) == null) ? null : liveRoomSensor.getEnterSource(), "LIVE_WINDOW") || (liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel()) == null) {
            return;
        }
        EventBus.c().o(new UpdateLiveShowEvent(liveShowModel));
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowFansGroupEvent event) {
        s.i(event, "event");
        FKLiveForViewerFragment V1 = V1();
        if (V1 != null) {
            V1.u2();
        }
        FKLiveMiniProfileFragment q12 = q1();
        if (q12 != null) {
            q12.Q0();
        }
        LiveHeatCountDesDialog p12 = p1();
        if (p12 != null) {
            p12.c();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        LiveShowModel liveShow;
        boolean z10;
        LiveShowModel liveShow2;
        super.onNewIntent(intent);
        setIntent(intent);
        this.D = true;
        FKLiveForViewerViewModel fKLiveForViewerViewModel = intent != null ? (FKLiveForViewerViewModel) z0.g.a(intent, FKLiveForViewerViewModel.class) : null;
        this.f14772z = fKLiveForViewerViewModel;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        fKLiveConstantsData.setFkLiveStrategyId((fKLiveForViewerViewModel == null || (liveShow2 = fKLiveForViewerViewModel.getLiveShow()) == null) ? null : liveShow2.getStrategyId());
        FKLiveForViewerViewModel fKLiveForViewerViewModel2 = this.f14772z;
        if (fKLiveForViewerViewModel2 == null || (liveShow = fKLiveForViewerViewModel2.getLiveShow()) == null) {
            return;
        }
        m1();
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (s.d(liveShowModel != null ? liveShowModel.getItemId() : null, liveShow.getItemId())) {
            FKLiveForViewerViewModel fKLiveForViewerViewModel3 = this.f14772z;
            LiveInRoomSensorModel liveRoomSensor = fKLiveForViewerViewModel3 != null ? fKLiveForViewerViewModel3.getLiveRoomSensor() : null;
            if (liveRoomSensor != null) {
                liveRoomSensor.setEnterSource("LiveShowEnterMiniLive");
            }
            z10 = false;
        } else {
            z10 = true;
        }
        ConsultFloatWindowHelper.f13810b.i();
        FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), U1(), false, z10, 2, null);
        fKLiveConstantsData.setFkLiveShowResult(LiveShowResult.Companion.a(liveShow));
        FKLiveGrpcEntity.p(FKLiveGrpcEntity.f14907e.a(), true, null, 2, null);
        S1(liveShow);
    }
}
