package com.cupidapp.live.startup.splashad;

import android.os.Build;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.b;
import com.kuaishou.weapon.p0.g;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: GDTSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GDTSplashAd extends FKBaseSplashAd implements SplashADListener {

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public static final a f18471p = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f18472f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final String f18473g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Function2<? super Boolean, ? super String, p> f18474h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18475i;

    /* renamed from: j, reason: collision with root package name */
    public final float f18476j;

    /* renamed from: k, reason: collision with root package name */
    public float f18477k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public SplashAD f18478l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final FKAdType f18479m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18480n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f18481o;

    /* compiled from: GDTSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable String str) {
            AppApplication h10 = AppApplication.f11612d.h();
            if (str == null) {
                str = "1110569542";
            }
            GDTAdSdk.init(h10, str);
        }
    }

    public GDTSplashAd(@NotNull FKStartupMediaConfigModel mModel, @Nullable String str, @NotNull String adId) {
        s.i(mModel, "mModel");
        s.i(adId, "adId");
        this.f18472f = str;
        this.f18473g = adId;
        this.f18476j = 1000.0f;
        this.f18477k = 1000.0f;
        this.f18479m = FKAdType.GDT;
        this.f18480n = mModel;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        try {
            SplashAD splashAD = this.f18478l;
            int ecpm = splashAD != null ? splashAD.getECPM() : 0;
            return ecpm <= 0 ? p().getAdvertisementBaseInfo().getPrice() : ecpm;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return p().getAdvertisementBaseInfo().getPrice();
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18479m;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void j(@NotNull Function2<? super Boolean, ? super String, p> result) {
        s.i(result, "result");
        WeakReference<FragmentActivity> e2 = e();
        FragmentActivity fragmentActivity = e2 != null ? e2.get() : null;
        this.f18474h = result;
        if (fragmentActivity != null) {
            if (Build.VERSION.SDK_INT >= 23 && (!h.b(fragmentActivity, g.f36117c) || !h.b(fragmentActivity, g.f36124j) || !h.b(fragmentActivity, g.f36121g))) {
                q(((Object) g()) + " no permission");
                return;
            }
            f18471p.a(this.f18472f);
            SplashAD splashAD = new SplashAD(fragmentActivity, this.f18473g, this, 1500);
            this.f18478l = splashAD;
            splashAD.fetchAdOnly();
            return;
        }
        q(((Object) g()) + "  requestAd fail, activity = null");
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        s.i(adContainer, "adContainer");
        SplashAD splashAD = this.f18478l;
        if (splashAD != null && splashAD.isValid()) {
            SplashAD splashAD2 = this.f18478l;
            if (splashAD2 != null) {
                splashAD2.showAd(adContainer);
                return;
            }
            return;
        }
        b f10 = f();
        if (f10 != null) {
            f10.Q(g(), -1, ((Object) g()) + " 广告数据过期");
        }
    }

    public final void o() {
        b f10;
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd closeSplashAd canJump: " + this.f18475i + " adCountDownTime: " + this.f18477k);
        if (this.f18475i) {
            float f11 = this.f18477k;
            if (f11 <= 1.0f) {
                b f12 = f();
                if (f12 != null) {
                    f12.c0(g(), SplashAdShowState.COMPLETE_DISPLAY);
                    return;
                }
                return;
            }
            if ((f11 == this.f18476j) || (f10 = f()) == null) {
                return;
            }
            f10.J0(g());
            return;
        }
        this.f18475i = true;
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onADClicked");
        b f10 = f();
        if (f10 != null) {
            b.a.b(f10, g(), null, 2, null);
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onADDismissed");
        o();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onADExposure");
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j10) {
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onADLoaded  p0:" + j10);
        r();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onADPresent");
        b f10 = f();
        if (f10 != null) {
            f10.P(g());
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j10) {
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onADTick p0:" + j10);
        this.f18477k = ((float) j10) / 1000.0f;
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(@Nullable AdError adError) {
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onNoAD");
        if (this.f18481o) {
            b f10 = f();
            if (f10 != null) {
                FKAdType g3 = g();
                FKAdType g10 = g();
                Integer valueOf = adError != null ? Integer.valueOf(adError.getErrorCode()) : null;
                f10.Q(g3, -1, ((Object) g10) + " errorCode:" + ((Object) valueOf) + ", errorMsg:" + (adError != null ? adError.getErrorMsg() : null));
                return;
            }
            return;
        }
        FKAdType g11 = g();
        Integer valueOf2 = adError != null ? Integer.valueOf(adError.getErrorCode()) : null;
        q(((Object) g11) + " errorCode:" + ((Object) valueOf2) + ", errorMsg:" + (adError != null ? adError.getErrorMsg() : null));
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onPause");
        this.f18475i = false;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        com.cupidapp.live.startup.helper.b.f18418a.a("GDTSplashAd onResume canJump: " + this.f18475i);
        if (this.f18475i) {
            o();
        }
        this.f18475i = true;
    }

    @NotNull
    public FKStartupMediaConfigModel p() {
        return this.f18480n;
    }

    public final void q(String str) {
        this.f18481o = false;
        b f10 = f();
        if (f10 != null) {
            b.a.d(f10, g(), -1, str, false, 8, null);
        }
        Function2<? super Boolean, ? super String, p> function2 = this.f18474h;
        if (function2 != null) {
            function2.mo1743invoke(Boolean.FALSE, str);
        }
    }

    public final void r() {
        this.f18481o = true;
        b f10 = f();
        if (f10 != null) {
            f10.p0(g());
        }
        Function2<? super Boolean, ? super String, p> function2 = this.f18474h;
        if (function2 != null) {
            function2.mo1743invoke(Boolean.TRUE, null);
        }
    }
}
