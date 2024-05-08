package com.cupidapp.live.startup.splashad;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.b;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: CSJSplash.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CSJSplash extends FKBaseSplashAd {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f18454m = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18455f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f18456g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final String f18457h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final FKAdType f18458i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18459j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public TTAdNative f18460k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public CSJSplashAd f18461l;

    /* compiled from: CSJSplash.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* compiled from: CSJSplash.kt */
        @d
        /* renamed from: com.cupidapp.live.startup.splashad.CSJSplash$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0171a implements TTAdSdk.Callback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<p> f18462a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function2<Integer, String, p> f18463b;

            /* JADX WARN: Multi-variable type inference failed */
            public C0171a(Function0<p> function0, Function2<? super Integer, ? super String, p> function2) {
                this.f18462a = function0;
                this.f18463b = function2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i10, @Nullable String str) {
                this.f18463b.mo1743invoke(Integer.valueOf(i10), str);
                j.f12332a.a("CSJSplash", "initCSJSdk fail，code = " + i10 + "，info = " + str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                this.f18462a.invoke();
                j.f12332a.a("CSJSplash", "initCSJSdk success");
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable String str, @NotNull Function0<p> success, @NotNull Function2<? super Integer, ? super String, p> fail) {
            s.i(success, "success");
            s.i(fail, "fail");
            AppApplication h10 = AppApplication.f11612d.h();
            if (TTAdSdk.isInitSuccess()) {
                success.invoke();
                return;
            }
            TTAdConfig.Builder builder = new TTAdConfig.Builder();
            if (str == null) {
                str = "5408315";
            }
            TTAdSdk.init(h10, builder.appId(str).useTextureView(true).appName("翻咔").titleBarTheme(1).debug(false).useMediation(true).directDownloadNetworkType(4).supportMultiProcess(false).build());
            TTAdSdk.start(new C0171a(success, fail));
        }
    }

    /* compiled from: CSJSplash.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TTAdNative.CSJSplashAdListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, p> f18465b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function2<? super Boolean, ? super String, p> function2) {
            this.f18465b = function2;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadFail(@Nullable CSJAdError cSJAdError) {
            CSJSplash.this.h("onSplashLoadFail 广告物料、素材加载失败或超时回调");
            FKAdType g3 = CSJSplash.this.g();
            Integer valueOf = cSJAdError != null ? Integer.valueOf(cSJAdError.getCode()) : null;
            String str = ((Object) g3) + " onSplashLoadFail code:" + ((Object) valueOf) + "  errorMsg:" + (cSJAdError != null ? cSJAdError.getMsg() : null);
            com.cupidapp.live.startup.view.b f10 = CSJSplash.this.f();
            if (f10 != null) {
                b.a.d(f10, CSJSplash.this.g(), cSJAdError != null ? Integer.valueOf(cSJAdError.getCode()) : null, str, false, 8, null);
            }
            this.f18465b.mo1743invoke(Boolean.FALSE, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadSuccess() {
            CSJSplash.this.h("onSplashLoadSuccess 广告物料、素材加载成功");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderFail(@Nullable CSJSplashAd cSJSplashAd, @Nullable CSJAdError cSJAdError) {
            FKAdType g3 = CSJSplash.this.g();
            Integer valueOf = cSJAdError != null ? Integer.valueOf(cSJAdError.getCode()) : null;
            String str = ((Object) g3) + " onSplashRenderFail code:" + ((Object) valueOf) + "  errorMsg:" + (cSJAdError != null ? cSJAdError.getMsg() : null);
            com.cupidapp.live.startup.view.b f10 = CSJSplash.this.f();
            if (f10 != null) {
                b.a.d(f10, CSJSplash.this.g(), cSJAdError != null ? Integer.valueOf(cSJAdError.getCode()) : null, str, false, 8, null);
            }
            this.f18465b.mo1743invoke(Boolean.FALSE, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderSuccess(@Nullable CSJSplashAd cSJSplashAd) {
            if (cSJSplashAd == null) {
                String str = ((Object) CSJSplash.this.g()) + " onSplashRenderSuccess p0 = null";
                com.cupidapp.live.startup.view.b f10 = CSJSplash.this.f();
                if (f10 != null) {
                    b.a.d(f10, CSJSplash.this.g(), -1, str, false, 8, null);
                }
                this.f18465b.mo1743invoke(Boolean.FALSE, str);
                return;
            }
            CSJSplash.this.f18461l = cSJSplashAd;
            com.cupidapp.live.startup.view.b f11 = CSJSplash.this.f();
            if (f11 != null) {
                f11.p0(CSJSplash.this.g());
            }
            this.f18465b.mo1743invoke(Boolean.TRUE, null);
        }
    }

    /* compiled from: CSJSplash.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements CSJSplashAd.SplashAdListener {
        public c() {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClick(@Nullable CSJSplashAd cSJSplashAd) {
            com.cupidapp.live.startup.view.b f10 = CSJSplash.this.f();
            if (f10 != null) {
                b.a.b(f10, CSJSplash.this.g(), null, 2, null);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClose(@Nullable CSJSplashAd cSJSplashAd, int i10) {
            com.cupidapp.live.startup.view.b f10 = CSJSplash.this.f();
            if (f10 != null) {
                f10.c0(CSJSplash.this.g(), SplashAdShowState.UNKNOWN);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdShow(@Nullable CSJSplashAd cSJSplashAd) {
            com.cupidapp.live.startup.view.b f10 = CSJSplash.this.f();
            if (f10 != null) {
                f10.P(CSJSplash.this.g());
            }
        }
    }

    public CSJSplash(@NotNull FKStartupMediaConfigModel mModel, @Nullable String str, @NotNull String mAdId) {
        s.i(mModel, "mModel");
        s.i(mAdId, "mAdId");
        this.f18455f = mModel;
        this.f18456g = str;
        this.f18457h = mAdId;
        this.f18458i = FKAdType.CSJ;
        this.f18459j = mModel;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        MediationAdEcpmInfo showEcpm;
        String ecpm;
        try {
            CSJSplashAd cSJSplashAd = this.f18461l;
            MediationSplashManager mediationManager = cSJSplashAd != null ? cSJSplashAd.getMediationManager() : null;
            int parseInt = (mediationManager == null || (showEcpm = mediationManager.getShowEcpm()) == null || (ecpm = showEcpm.getEcpm()) == null) ? 0 : Integer.parseInt(ecpm);
            return parseInt <= 0 ? this.f18455f.getAdvertisementBaseInfo().getPrice() : parseInt;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return this.f18455f.getAdvertisementBaseInfo().getPrice();
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18458i;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void j(@NotNull final Function2<? super Boolean, ? super String, p> result) {
        s.i(result, "result");
        WeakReference<FragmentActivity> e2 = e();
        final FragmentActivity fragmentActivity = e2 != null ? e2.get() : null;
        if (fragmentActivity == null) {
            String str = ((Object) g()) + " requestAd fail, activity = null";
            com.cupidapp.live.startup.view.b f10 = f();
            if (f10 != null) {
                b.a.d(f10, g(), -1, str, false, 8, null);
            }
            result.mo1743invoke(Boolean.FALSE, str);
            return;
        }
        f18454m.a(this.f18456g, new Function0<p>() { // from class: com.cupidapp.live.startup.splashad.CSJSplash$requestAd$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CSJSplash.this.q(fragmentActivity, result);
            }
        }, new Function2<Integer, String, p>() { // from class: com.cupidapp.live.startup.splashad.CSJSplash$requestAd$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, String str2) {
                invoke(num.intValue(), str2);
                return p.f51048a;
            }

            public final void invoke(int i10, @Nullable String str2) {
                String str3 = ((Object) CSJSplash.this.g()) + " requestAd fail, 初始化SDK失败  code:" + i10 + "  message:" + str2;
                b f11 = CSJSplash.this.f();
                if (f11 != null) {
                    b.a.d(f11, CSJSplash.this.g(), Integer.valueOf(i10), "初始化SDK失败 " + str3, false, 8, null);
                }
                result.mo1743invoke(Boolean.FALSE, str3);
            }
        });
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        s.i(adContainer, "adContainer");
        CSJSplashAd cSJSplashAd = this.f18461l;
        if (cSJSplashAd != null) {
            cSJSplashAd.setSplashAdListener(new c());
        }
        CSJSplashAd cSJSplashAd2 = this.f18461l;
        View splashView = cSJSplashAd2 != null ? cSJSplashAd2.getSplashView() : null;
        if (splashView == null) {
            String str = ((Object) g()) + " showAd fail, splashView == null";
            com.cupidapp.live.startup.view.b f10 = f();
            if (f10 != null) {
                f10.Q(g(), -1, str);
                return;
            }
            return;
        }
        adContainer.removeAllViews();
        adContainer.addView(splashView);
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        MediationSplashManager mediationManager;
        s.i(owner, "owner");
        CSJSplashAd cSJSplashAd = this.f18461l;
        if (cSJSplashAd != null && (mediationManager = cSJSplashAd.getMediationManager()) != null) {
            mediationManager.destroy();
        }
        this.f18461l = null;
    }

    public final void q(FragmentActivity fragmentActivity, Function2<? super Boolean, ? super String, p> function2) {
        this.f18460k = TTAdSdk.getAdManager().createAdNative(fragmentActivity);
        AdSlot build = new AdSlot.Builder().setCodeId(this.f18457h).setSupportDeepLink(true).setImageAcceptedSize(h.l(this), h.k(this)).build();
        TTAdNative tTAdNative = this.f18460k;
        if (tTAdNative != null) {
            tTAdNative.loadSplashAd(build, new b(function2), com.alipay.sdk.data.a.f4564a);
        }
    }
}
