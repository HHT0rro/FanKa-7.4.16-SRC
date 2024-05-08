package com.cupidapp.live.startup.splashad;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.b;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HuaweiJHSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HuaweiJHSplashAd extends FKBaseSplashAd {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f18482k = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18483f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final String f18484g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final FKAdType f18485h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18486i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public SplashView f18487j;

    /* compiled from: HuaweiJHSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            s.i(context, "context");
            HwAds.init(context);
        }
    }

    /* compiled from: HuaweiJHSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends SplashAdDisplayListener {
        public b() {
        }

        @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
        public void onAdClick() {
            com.cupidapp.live.startup.view.b f10 = HuaweiJHSplashAd.this.f();
            if (f10 != null) {
                b.a.b(f10, HuaweiJHSplashAd.this.g(), null, 2, null);
            }
        }

        @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
        public void onAdShowed() {
        }
    }

    /* compiled from: HuaweiJHSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends SplashView.SplashAdLoadListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, p> f18490b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super Boolean, ? super String, p> function2) {
            this.f18490b = function2;
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdDismissed() {
            com.cupidapp.live.startup.view.b f10 = HuaweiJHSplashAd.this.f();
            if (f10 != null) {
                f10.c0(HuaweiJHSplashAd.this.g(), SplashAdShowState.UNKNOWN);
            }
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdFailedToLoad(int i10) {
            String str = ((Object) HuaweiJHSplashAd.this.g()) + " onAdFailedToLoad fail p0:" + i10;
            com.cupidapp.live.startup.view.b f10 = HuaweiJHSplashAd.this.f();
            if (f10 != null) {
                b.a.d(f10, HuaweiJHSplashAd.this.g(), Integer.valueOf(i10), str, false, 8, null);
            }
            this.f18490b.mo1743invoke(Boolean.FALSE, str);
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdLoaded() {
            com.cupidapp.live.startup.view.b f10 = HuaweiJHSplashAd.this.f();
            if (f10 != null) {
                f10.p0(HuaweiJHSplashAd.this.g());
            }
            this.f18490b.mo1743invoke(Boolean.TRUE, null);
        }
    }

    public HuaweiJHSplashAd(@NotNull FKStartupMediaConfigModel mModel, @NotNull String mAdId) {
        s.i(mModel, "mModel");
        s.i(mAdId, "mAdId");
        this.f18483f = mModel;
        this.f18484g = mAdId;
        this.f18485h = FKAdType.HUAWEI_JH;
        this.f18486i = mModel;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        return this.f18483f.getAdvertisementBaseInfo().getPrice();
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18485h;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void j(@NotNull Function2<? super Boolean, ? super String, p> result) {
        s.i(result, "result");
        WeakReference<FragmentActivity> e2 = e();
        FragmentActivity fragmentActivity = e2 != null ? e2.get() : null;
        if (fragmentActivity == null) {
            String str = ((Object) g()) + " requestAd fail, activity = null";
            com.cupidapp.live.startup.view.b f10 = f();
            if (f10 != null) {
                b.a.d(f10, g(), -1, str, false, 8, null);
            }
            result.mo1743invoke(Boolean.FALSE, str);
            return;
        }
        f18482k.a(fragmentActivity);
        AdParam build = new AdParam.Builder().build();
        c cVar = new c(result);
        SplashView splashView = new SplashView(fragmentActivity);
        splashView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        splashView.setAudioFocusType(1);
        splashView.setAdDisplayListener(new b());
        this.f18487j = splashView;
        splashView.load(this.f18484g, 1, build, cVar);
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        s.i(adContainer, "adContainer");
        SplashView splashView = this.f18487j;
        if (splashView == null) {
            String str = ((Object) g()) + " showAd fail, splashView:" + ((Object) splashView);
            com.cupidapp.live.startup.view.b f10 = f();
            if (f10 != null) {
                f10.Q(g(), -1, str);
                return;
            }
            return;
        }
        adContainer.removeAllViews();
        adContainer.addView(splashView);
        com.cupidapp.live.startup.view.b f11 = f();
        if (f11 != null) {
            f11.P(g());
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        SplashView splashView = this.f18487j;
        if (splashView != null) {
            splashView.destroyView();
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        SplashView splashView = this.f18487j;
        if (splashView != null) {
            splashView.pauseView();
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        SplashView splashView = this.f18487j;
        if (splashView != null) {
            splashView.resumeView();
        }
    }
}
