package com.cupidapp.live.base.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.layout.NonageDialog;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.event.InvalidEvent;
import com.cupidapp.live.base.network.event.JumpToWebEvent;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.router.jumper.OpenSuperBoostBuyAlertEvent;
import com.cupidapp.live.base.sensorslog.NoAdReason;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.FKAlertLayout;
import com.cupidapp.live.base.view.SnackbarMsgEvent;
import com.cupidapp.live.base.view.ToastMessageEvent;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.base.web.activity.CloseWebEvent;
import com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.activity.ChatLookSnapImageActivity;
import com.cupidapp.live.consult.activity.BaseConsultActivity;
import com.cupidapp.live.consult.activity.ConsultAnchorActivity;
import com.cupidapp.live.consult.activity.ConsultStartLiveActivity;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel;
import com.cupidapp.live.liveshow.activity.FKBaseLiveActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKStartLiveShowActivity;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.login.activity.CompleteInfoAgeActivity;
import com.cupidapp.live.login.activity.CompleteInfoAlbumActivity;
import com.cupidapp.live.login.activity.CompleteInfoAvatarActivity;
import com.cupidapp.live.login.activity.CompleteInfoCutAvatarActivity;
import com.cupidapp.live.login.activity.CompleteInfoNickNameActivity;
import com.cupidapp.live.login.activity.CompleteInfoWelcomeActivity;
import com.cupidapp.live.login.activity.InputPassWordActivity;
import com.cupidapp.live.login.activity.InputPhoneNumberActivity;
import com.cupidapp.live.login.activity.InputVerificationCodeActivity;
import com.cupidapp.live.login.activity.SignInActivity;
import com.cupidapp.live.maskparty.activity.ChatLookImageActivity;
import com.cupidapp.live.maskparty.activity.ChatPhoneAlbumActivity;
import com.cupidapp.live.maskparty.activity.ChatPreviewImageActivity;
import com.cupidapp.live.maskparty.activity.MaskPartyChatActivity;
import com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity;
import com.cupidapp.live.maskparty.activity.MaskPartyMatchActivity;
import com.cupidapp.live.match.activity.FKMatchSuccessActivity;
import com.cupidapp.live.match.event.FKMatchUserNotifyEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.util.AppTopTipPopup;
import com.cupidapp.live.startup.activity.FKStartupActivity;
import com.cupidapp.live.startup.activity.StartupIsShowAdType;
import com.cupidapp.live.startup.helper.SplashAdSelectHelper;
import com.cupidapp.live.tourist.activity.AbnormalModeType;
import com.cupidapp.live.tourist.activity.FKTouristMainActivity;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.model.MarketPopInfoModel;
import com.cupidapp.live.voiceparty.activity.VoicePartyActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import j1.m;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKBaseActivity extends AppCompatActivity implements com.cupidapp.live.base.network.g {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f11750o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public static long f11751p;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public FKBaseFragment f11757i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11758j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public ImageView f11759k;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11762n = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final CompositeDisposable f11752d = new CompositeDisposable();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final i f11753e = new i();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final h f11754f = new h();

    /* renamed from: g, reason: collision with root package name */
    public int f11755g = R$anim.anim_activity_common_show_by_end;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Integer f11756h = Integer.valueOf(R$anim.anim_activity_common_end);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public final Lazy f11760l = kotlin.c.b(new Function0<NonageDialog>() { // from class: com.cupidapp.live.base.activity.FKBaseActivity$nonageDialog$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final NonageDialog invoke() {
            return new NonageDialog();
        }
    });

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f11761m = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.base.activity.FKBaseActivity$mPurchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            FKBaseActivity fKBaseActivity = FKBaseActivity.this;
            Lifecycle lifecycle = fKBaseActivity.getLifecycle();
            s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(fKBaseActivity, lifecycle);
        }
    });

    /* compiled from: FKBaseActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(a aVar, Context context, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = R$anim.anim_activity_common_start;
            }
            if ((i12 & 4) != 0) {
                i11 = R$anim.anim_activity_common_hide_by_start;
            }
            aVar.b(context, i10, i11);
        }

        public final long a() {
            return FKBaseActivity.f11751p;
        }

        public final void b(@Nullable Context context, int i10, int i11) {
            if (context instanceof FragmentActivity) {
                ((FragmentActivity) context).overridePendingTransition(i10, i11);
            }
        }

        public final void d(long j10) {
            FKBaseActivity.f11751p = j10;
        }
    }

    public static final void N0(FKBaseActivity this$0) {
        s.i(this$0, "this$0");
        i3.a aVar = i3.a.f49713a;
        if (aVar.b()) {
            return;
        }
        if (z0.h.r(this$0)) {
            SensorPosition Q0 = this$0.Q0();
            SensorPosition sensorPosition = SensorPosition.Startup;
            if (Q0 == sensorPosition) {
                aVar.a(sensorPosition);
                return;
            }
            SensorPosition sensorPosition2 = SensorPosition.DynPosition;
            sensorPosition2.setValue(this$0.Q0().getValue());
            aVar.a(sensorPosition2);
            return;
        }
        aVar.c();
    }

    public static /* synthetic */ void g1(FKBaseActivity fKBaseActivity, FKBaseFragment fKBaseFragment, boolean z10, int i10, boolean z11, boolean z12, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNextFragment");
        }
        fKBaseActivity.f1(fKBaseFragment, z10, i10, (i11 & 8) != 0 ? true : z11, (i11 & 16) != 0 ? false : z12);
    }

    public static final void i1(FKBaseActivity this$0) {
        s.i(this$0, "this$0");
        if (this$0.f11758j) {
            com.cupidapp.live.base.utils.f fVar = com.cupidapp.live.base.utils.f.f12314a;
            Window window = this$0.getWindow();
            s.h(window, "window");
            List<Rect> b4 = fVar.b(window);
            if (b4 != null) {
                for (Rect rect : b4) {
                    int l10 = z0.h.l(this$0) / 2;
                    if (rect.left < l10 - z0.h.c(this$0, 45.0f) && rect.right > l10 + z0.h.c(this$0, 45.0f)) {
                        this$0.W0();
                        ImageView imageView = this$0.f11759k;
                        ViewParent parent = imageView != null ? imageView.getParent() : null;
                        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup != null) {
                            viewGroup.removeView(this$0.f11759k);
                        }
                        View decorView = this$0.getWindow().getDecorView();
                        s.g(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
                        ((ViewGroup) decorView).addView(this$0.f11759k);
                        return;
                    }
                }
            }
        }
    }

    public final boolean E0() {
        return (this instanceof FKBaseLiveActivity) || (this instanceof FKStartLiveShowActivity) || (this instanceof SignInActivity) || Y0() || X0() || (this instanceof BaseConsultActivity) || (this instanceof ConsultStartLiveActivity);
    }

    public final boolean G0() {
        return (this instanceof ChatDetailActivity) || (this instanceof ChatPhoneAlbumActivity) || (this instanceof ChatPreviewImageActivity) || (this instanceof ChatLookImageActivity) || (this instanceof ChatLookSnapImageActivity);
    }

    @Override // com.cupidapp.live.base.network.g
    public void H(@NotNull Disposable disposable) {
        s.i(disposable, "disposable");
        this.f11752d.add(disposable);
    }

    public final boolean H0() {
        return I0() || J0() || G0() || K0();
    }

    public final boolean I0() {
        return (this instanceof FKBaseLiveActivity) || (this instanceof FKStartLiveShowActivity) || ((this instanceof MainActivity) && ((MainActivity) this).Z1() == MainActivity.MainPagerType.Live.getPageIndex()) || (this instanceof BaseConsultActivity) || (this instanceof ConsultStartLiveActivity);
    }

    public final boolean J0() {
        return (this instanceof MaskPartyChatActivity) || (this instanceof MaskPartyMatchActivity) || (this instanceof ChatPreviewImageActivity) || (this instanceof ChatPhoneAlbumActivity) || (this instanceof ChatLookImageActivity) || (this instanceof MaskPartyLookSnapImageActivity);
    }

    public final boolean K0() {
        return this instanceof VoicePartyActivity;
    }

    public final void M0() {
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.cupidapp.live.base.activity.k
                @Override // java.lang.Runnable
                public final void run() {
                    FKBaseActivity.N0(FKBaseActivity.this);
                }
            });
        }
    }

    @NotNull
    public final h O0() {
        return this.f11754f;
    }

    @NotNull
    public final i P0() {
        return this.f11753e;
    }

    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.Unknown;
    }

    @Nullable
    public final FKBaseFragment R0() {
        return this.f11757i;
    }

    public final PurchaseDialogManager S0() {
        return (PurchaseDialogManager) this.f11761m.getValue();
    }

    public boolean T0() {
        return true;
    }

    public final NonageDialog U0() {
        return (NonageDialog) this.f11760l.getValue();
    }

    public final void V0() {
        FKAlertLayout.a aVar = FKAlertLayout.f12456d;
        View findViewById = findViewById(16908290);
        s.h(findViewById, "findViewById(android.R.id.content)");
        aVar.c((ViewGroup) findViewById);
    }

    public final void W0() {
        if (this.f11759k == null) {
            ImageView imageView = new ImageView(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, z0.h.m(imageView.getContext()));
            layoutParams.gravity = 49;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(0, z0.h.c(imageView, 3.0f), 0, z0.h.c(imageView, 10.0f));
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R$mipmap.icon_finka_watermark);
            this.f11759k = imageView;
        }
    }

    public final boolean X0() {
        return (this instanceof CompleteInfoNickNameActivity) || (this instanceof CompleteInfoAgeActivity) || (this instanceof CompleteInfoAvatarActivity) || (this instanceof CompleteInfoAlbumActivity) || (this instanceof CompleteInfoCutAvatarActivity) || (this instanceof CompleteInfoWelcomeActivity);
    }

    public final boolean Y0() {
        return (this instanceof InputPhoneNumberActivity) || (this instanceof InputVerificationCodeActivity) || (this instanceof InputPassWordActivity);
    }

    public final boolean Z0() {
        return f11751p > 0 && System.currentTimeMillis() - f11751p > 1800000;
    }

    public final boolean a1() {
        WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
        Activity activity = a10 != null ? a10.get() : null;
        if (activity instanceof FKLiveForStreamerBeautyActivity ? true : activity instanceof ConsultAnchorActivity) {
            com.cupidapp.live.base.view.h.f12779a.k(R$string.unable_jump_please_exit_current_room_try_again);
            return true;
        }
        if (activity instanceof FKLiveForViewerActivity) {
            LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
            if (!(remoteConnectLiveShow != null && remoteConnectLiveShow.isRemoteConnect())) {
                return false;
            }
            com.cupidapp.live.base.view.h.f12779a.k(R$string.unable_jump_please_exit_current_room_try_again);
            return true;
        }
        if (!(activity instanceof ConsultViewerActivity)) {
            return false;
        }
        String b4 = ConsultViewerViewModel.Companion.b();
        if (b4 == null || b4.length() == 0) {
            return false;
        }
        com.cupidapp.live.base.view.h.f12779a.k(R$string.unable_jump_please_exit_current_room_try_again);
        return true;
    }

    public final void b1() {
        ImageView imageView = this.f11759k;
        if (imageView != null) {
            View decorView = getWindow().getDecorView();
            s.g(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) decorView).removeView(imageView);
        }
        this.f11758j = false;
    }

    public final void c1(@NotNull Bundle outState) {
        s.i(outState, "outState");
        FKBaseFragment fKBaseFragment = this.f11757i;
        if (fKBaseFragment != null) {
            outState.putString("CURRENT_SHOW_FRAGMENT_SIMPLE_NAME", fKBaseFragment.getClass().getSimpleName());
        }
    }

    public final void d1(int i10, @Nullable Integer num) {
        this.f11755g = i10;
        this.f11756h = num;
    }

    public final void e1() {
        FKAlertLayout.a aVar = FKAlertLayout.f12456d;
        View findViewById = findViewById(16908290);
        s.h(findViewById, "findViewById<ViewGroup>(android.R.id.content)");
        aVar.a((ViewGroup) findViewById).e();
    }

    public final void f1(@Nullable FKBaseFragment fKBaseFragment, boolean z10, @IdRes int i10, boolean z11, boolean z12) {
        if (fKBaseFragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        s.h(beginTransaction, "supportFragmentManager.beginTransaction()");
        if (this.f11757i != null && z11) {
            if (z10) {
                beginTransaction.setCustomAnimations(R$anim.anim_activity_common_show_by_end, R$anim.anim_activity_common_end);
            } else {
                beginTransaction.setCustomAnimations(R$anim.anim_activity_common_start, R$anim.anim_activity_common_hide_by_start);
            }
        }
        FKBaseFragment fKBaseFragment2 = this.f11757i;
        if (fKBaseFragment2 != null && fKBaseFragment2.isAdded()) {
            beginTransaction.hide(fKBaseFragment2);
        }
        if (getSupportFragmentManager().findFragmentByTag(fKBaseFragment.getClass().getSimpleName()) == null && !fKBaseFragment.isAdded()) {
            beginTransaction.add(i10, fKBaseFragment, fKBaseFragment.getClass().getSimpleName());
        } else {
            beginTransaction.show(fKBaseFragment);
        }
        if (z12) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitAllowingStateLoss();
        }
        this.f11757i = fKBaseFragment;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        Integer num = this.f11756h;
        if (num != null) {
            int i10 = this.f11755g;
            s.f(num);
            overridePendingTransition(i10, num.intValue());
        }
    }

    @Override // com.cupidapp.live.base.network.g
    @Nullable
    public Context getStartApiRequestContext() {
        return this;
    }

    public final void h1() {
        if (!T0() || this.f11758j) {
            return;
        }
        this.f11758j = true;
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.cupidapp.live.base.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                FKBaseActivity.i1(FKBaseActivity.this);
            }
        }, 300L);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f11754f.b(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f11753e.b()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(R$anim.anim_activity_common_show_by_end, Integer.valueOf(R$anim.anim_activity_common_end));
        p0.c(this, false, 0, 3, null);
        M0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f11752d.dispose();
        this.f11754f.c();
        this.f11753e.c();
        super.onDestroy();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull DefaultEvent event) {
        s.i(event, "event");
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FKMatchUserNotifyEvent event) {
        s.i(event, "event");
        if (E0() || (this instanceof FKStartupActivity) || G0() || J0() || K0()) {
            return;
        }
        FKMatchSuccessActivity.a aVar = FKMatchSuccessActivity.f16495v;
        User user = event.getUser();
        boolean initiativeMatch = event.getInitiativeMatch();
        Boolean guide = event.getGuide();
        aVar.a(this, user, initiativeMatch, guide != null ? guide.booleanValue() : false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        y0.a.f54658a.c(this);
        super.onPause();
        AppApplication.f11612d.k(false);
        b1();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        s.i(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(savedInstanceState.getString("CURRENT_SHOW_FRAGMENT_SIMPLE_NAME"));
        this.f11757i = findFragmentByTag instanceof FKBaseFragment ? (FKBaseFragment) findFragmentByTag : null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        y0.a.b(y0.a.f54658a, this, null, 2, null);
        AppApplication.f11612d.k(true);
        h1();
        if (H0()) {
            AppTopTipPopup.f17896a.c();
        } else {
            AppTopTipPopup.f17896a.g();
        }
        if (X0() || Y0()) {
            return;
        }
        U0().a(this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        s.i(outState, "outState");
        super.onSaveInstanceState(outState);
        c1(outState);
    }

    public final void z0(@Nullable g gVar) {
        this.f11753e.a(gVar);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ToastMessageEvent event) {
        CharSequence text;
        s.i(event, "event");
        EventBus.c().r(event);
        if (event.getTextResId() != null && event.getTextResId().intValue() > 0) {
            text = getString(event.getTextResId().intValue());
        } else {
            text = event.getText();
        }
        com.cupidapp.live.base.view.h.f12779a.h(this, text, event.getIconType().getIconResId());
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SnackbarMsgEvent event) {
        s.i(event, "event");
        if (event.getShowInCurrentActivity() || !s.d(event.getCurrentActivityName(), getLocalClassName())) {
            EventBus.c().r(event);
            ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
            if (viewGroup != null) {
                com.cupidapp.live.base.view.g.f12778a.d(viewGroup, event.getModel());
            }
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull JumpToWebEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        com.cupidapp.live.base.router.j.f12156c.a(this, event.getJumpUrl(), new WebStyleViewModel(null, event.isShowCloseIcon(), null, 5, null));
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull InvalidEvent event) {
        s.i(event, "event");
        if (E0()) {
            return;
        }
        p1.g gVar = p1.g.f52734a;
        gVar.K3(null);
        gVar.A2(null);
        FKStartupActivity.f18306u.b(this, StartupIsShowAdType.MustNotShowing, true);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull AppEnterForegroundEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        if (!E0() && !(this instanceof FKStartupActivity)) {
            boolean s2 = z0.h.s();
            boolean z10 = SplashAdSelectHelper.f18415a.u() && !s2;
            boolean z11 = Z0() && !FKLiveMiniWindow.f15074m.a().P();
            j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
            aVar.a("FKBaseActivity", "showAd:" + z10 + "  switchMatch:" + z11 + "  isMiPhone:" + s2);
            if (!z10 && !z11) {
                aVar.a("FKBaseActivity", "AppEnterForegroundEvent 不展示广告、不跳转到翻牌子");
                if (s2) {
                    m.f50240a.f(NoAdReason.IS_MI_PHONE);
                    return;
                } else {
                    m.f50240a.f(NoAdReason.NOT_REACH_HOT_START_INTERVAL);
                    return;
                }
            }
            if (z10 && !z11) {
                aVar.a("FKBaseActivity", "AppEnterForegroundEvent 展示广告、不跳转到翻牌子");
                FKStartupActivity.f18306u.b(this, StartupIsShowAdType.MustShow, false);
                return;
            }
            if (z10 || !z11) {
                if (z10 && z11) {
                    aVar.a("FKBaseActivity", "AppEnterForegroundEvent 展示广告、跳转到翻牌子");
                    FKStartupActivity.f18306u.b(this, StartupIsShowAdType.MustShowAndStartToMain, true);
                    return;
                }
                return;
            }
            aVar.a("FKBaseActivity", "AppEnterForegroundEvent 不展示广告、跳转到翻牌子");
            if (s2) {
                m.f50240a.f(NoAdReason.IS_MI_PHONE);
            } else {
                m.f50240a.f(NoAdReason.NOT_REACH_HOT_START_INTERVAL);
            }
            if (this instanceof MainActivity) {
                com.cupidapp.live.base.fragment.b.f11807a.b();
                ((MainActivity) this).u2();
                return;
            } else {
                MainActivity.F.e("match", this, "match");
                d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_nothing));
                finish();
                return;
            }
        }
        com.cupidapp.live.base.utils.j.f12332a.a("FKBaseActivity", "AppEnterForegroundEvent Activity 不符合 -> " + ((Object) this));
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull CloseWebEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        if (s.d(Uri.parse(event.getUrl()).getQueryParameter("closeAction"), "vasMarketPop")) {
            Disposable disposed = NetworkClient.f11868a.p().b(kotlin.collections.s.m(1, 5, 9)).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MarketPopInfoModel, p>() { // from class: com.cupidapp.live.base.activity.FKBaseActivity$onEvent$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(MarketPopInfoModel marketPopInfoModel) {
                    m2456invoke(marketPopInfoModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2456invoke(MarketPopInfoModel marketPopInfoModel) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, FKBaseActivity.this, marketPopInfoModel.getUrl(), null, 4, null);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FKH5CallNativeHelper.TeenModeModel event) {
        s.i(event, "event");
        EventBus.c().r(event);
        if (event.isOpen()) {
            FKTouristMainActivity.f18670x.a(this, AbnormalModeType.TeenModeType);
        } else {
            MainActivity.a.g(MainActivity.F, this, null, null, true, Integer.valueOf(MainActivity.MainPagerType.Live.getPageIndex()), null, 38, null);
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenSuperBoostBuyAlertEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        S0().k(event.getSource());
    }
}
