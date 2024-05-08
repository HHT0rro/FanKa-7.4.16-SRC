package com.cupidapp.live.startup.splashad;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.b;
import com.wangmai.appsdkdex.WMAdSdk;
import com.wangmai.appsdkdex.ads.WMAdSplashad;
import com.wangmai.common.Ilistener.XAdSplashListener;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WMSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WMSplashAd extends FKBaseSplashAd {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f18524o = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18525f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f18526g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f18527h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final String f18528i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final FKAdType f18529j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18530k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public WMAdSplashad f18531l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f18532m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f18533n;

    /* compiled from: WMSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String appId, @NotNull String appKey) {
            s.i(context, "context");
            s.i(appId, "appId");
            s.i(appKey, "appKey");
            new WMAdSdk.Builder().setToken(appId).setkey(appKey).enableCrashIntercept(true).debug(k1.a.f50625a.a()).build(context).init();
        }
    }

    /* compiled from: WMSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements XAdSplashListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, p> f18535b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function2<? super Boolean, ? super String, p> function2) {
            this.f18535b = function2;
        }

        @Override // com.wangmai.common.Ilistener.XAdSplashListener
        public void onAdDismissed() {
            WMSplashAd.this.h("onAdDismissed");
            if (WMSplashAd.this.f18533n) {
                WMSplashAd.this.t();
                return;
            }
            com.cupidapp.live.startup.view.b f10 = WMSplashAd.this.f();
            if (f10 != null) {
                f10.c0(WMSplashAd.this.g(), SplashAdShowState.UNKNOWN);
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            WMSplashAd.this.f18532m = true;
            com.cupidapp.live.startup.view.b f10 = WMSplashAd.this.f();
            if (f10 != null) {
                f10.p0(WMSplashAd.this.g());
            }
            this.f18535b.mo1743invoke(Boolean.TRUE, null);
        }

        @Override // com.wangmai.common.Ilistener.XAdSplashListener
        public void onAdZoomOut() {
            WMSplashAd.this.h("onAdZoomOut");
        }

        @Override // com.wangmai.common.Ilistener.XAdSplashListener
        public void onAdZoomOutClick() {
            WMSplashAd.this.h("onAdZoomOutClick");
        }

        @Override // com.wangmai.common.Ilistener.XAdSplashListener
        public void onAdZoomOutDismissed() {
            WMSplashAd.this.h("onAdZoomOutDismissed");
            WMSplashAd.this.t();
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            WMSplashAd.this.f18533n = true;
            com.cupidapp.live.startup.view.b f10 = WMSplashAd.this.f();
            if (f10 != null) {
                b.a.b(f10, WMSplashAd.this.g(), null, 2, null);
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            com.cupidapp.live.startup.view.b f10 = WMSplashAd.this.f();
            if (f10 != null) {
                f10.P(WMSplashAd.this.g());
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(@Nullable String str) {
            WMSplashAd.this.h("onNoAd p0:" + str);
            if (WMSplashAd.this.f18532m) {
                com.cupidapp.live.startup.view.b f10 = WMSplashAd.this.f();
                if (f10 != null) {
                    f10.Q(WMSplashAd.this.g(), null, str);
                    return;
                }
                return;
            }
            com.cupidapp.live.startup.view.b f11 = WMSplashAd.this.f();
            if (f11 != null) {
                b.a.d(f11, WMSplashAd.this.g(), null, str, false, 8, null);
            }
            this.f18535b.mo1743invoke(Boolean.FALSE, str);
        }
    }

    public WMSplashAd(@NotNull FKStartupMediaConfigModel mModel, @Nullable String str, @Nullable String str2, @NotNull String mAdId) {
        s.i(mModel, "mModel");
        s.i(mAdId, "mAdId");
        this.f18525f = mModel;
        this.f18526g = str;
        this.f18527h = str2;
        this.f18528i = mAdId;
        this.f18529j = FKAdType.WM;
        this.f18530k = mModel;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        WMAdSplashad wMAdSplashad = this.f18531l;
        int ecpm = wMAdSplashad != null ? wMAdSplashad.getECPM() : 0;
        return ecpm <= 0 ? this.f18525f.getAdvertisementBaseInfo().getPrice() : ecpm;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18529j;
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
        String str2 = this.f18526g;
        if (!(str2 == null || str2.length() == 0)) {
            String str3 = this.f18527h;
            if (!(str3 == null || str3.length() == 0)) {
                if (!(this.f18528i.length() == 0)) {
                    f18524o.a(fragmentActivity, this.f18526g, this.f18527h);
                    this.f18531l = new WMAdSplashad(fragmentActivity, this.f18528i, new b(result));
                    return;
                }
            }
        }
        FKAdType g3 = g();
        String str4 = ((Object) g3) + " requestAd fail, mAppId:" + this.f18526g + "  mAppKey:" + this.f18527h + "  mAdId:" + this.f18528i;
        com.cupidapp.live.startup.view.b f11 = f();
        if (f11 != null) {
            b.a.d(f11, g(), -1, str4, false, 8, null);
        }
        result.mo1743invoke(Boolean.FALSE, str4);
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        s.i(adContainer, "adContainer");
        WMAdSplashad wMAdSplashad = this.f18531l;
        WeakReference<FragmentActivity> e2 = e();
        FragmentActivity fragmentActivity = e2 != null ? e2.get() : null;
        if (wMAdSplashad != null && fragmentActivity != null) {
            wMAdSplashad.show(adContainer);
            return;
        }
        String str = ((Object) g()) + " showAd fail, wmAdSplashAd:" + ((Object) wMAdSplashad) + "  activity:" + ((Object) fragmentActivity);
        com.cupidapp.live.startup.view.b f10 = f();
        if (f10 != null) {
            f10.Q(g(), -1, str);
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        t();
    }

    public final void t() {
        WMAdSplashad wMAdSplashad = this.f18531l;
        if (wMAdSplashad != null) {
            wMAdSplashad.destroy();
        }
        this.f18531l = null;
    }
}
