package com.cupidapp.live.startup.splashad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.b;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.SdkConfig;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;

/* compiled from: KSSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class KSSplashAd extends FKBaseSplashAd {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f18514l = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18515f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f18516g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final String f18517h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public KsSplashScreenAd f18518i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final FKAdType f18519j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18520k;

    /* compiled from: KSSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull Context context, @Nullable String str) {
            s.i(context, "context");
            SdkConfig.Builder builder = new SdkConfig.Builder();
            if (str == null) {
                str = "978500002";
            }
            return KsAdSDK.init(context, builder.appId(str).showNotification(true).debug(false).build());
        }
    }

    /* compiled from: KSSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements KsLoadManager.SplashScreenAdListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, p> f18522b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function2<? super Boolean, ? super String, p> function2) {
            this.f18522b = function2;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i10, @Nullable String str) {
            com.cupidapp.live.startup.view.b f10 = KSSplashAd.this.f();
            if (f10 != null) {
                b.a.d(f10, KSSplashAd.this.g(), Integer.valueOf(i10), str, false, 8, null);
            }
            this.f18522b.mo1743invoke(Boolean.FALSE, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i10) {
            KSSplashAd.this.h("onRequestResult adNumber:" + i10);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
            if (ksSplashScreenAd == null) {
                String str = ((Object) KSSplashAd.this.g()) + " onSplashScreenAdLoad ad = null";
                com.cupidapp.live.startup.view.b f10 = KSSplashAd.this.f();
                if (f10 != null) {
                    b.a.d(f10, KSSplashAd.this.g(), -1, str, false, 8, null);
                }
                this.f18522b.mo1743invoke(Boolean.FALSE, str);
                return;
            }
            KSSplashAd.this.f18518i = ksSplashScreenAd;
            com.cupidapp.live.startup.view.b f11 = KSSplashAd.this.f();
            if (f11 != null) {
                f11.p0(KSSplashAd.this.g());
            }
            this.f18522b.mo1743invoke(Boolean.TRUE, null);
        }
    }

    /* compiled from: KSSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        public c() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            com.cupidapp.live.startup.view.b f10 = KSSplashAd.this.f();
            if (f10 != null) {
                b.a.b(f10, KSSplashAd.this.g(), null, 2, null);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            com.cupidapp.live.startup.view.b f10 = KSSplashAd.this.f();
            if (f10 != null) {
                f10.c0(KSSplashAd.this.g(), SplashAdShowState.COMPLETE_DISPLAY);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i10, @Nullable String str) {
            com.cupidapp.live.startup.view.b f10 = KSSplashAd.this.f();
            if (f10 != null) {
                f10.Q(KSSplashAd.this.g(), Integer.valueOf(i10), str);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            com.cupidapp.live.startup.view.b f10 = KSSplashAd.this.f();
            if (f10 != null) {
                f10.P(KSSplashAd.this.g());
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogCancel() {
            KSSplashAd.this.h("onDownloadTipsDialogCancel");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogDismiss() {
            KSSplashAd.this.h("onDownloadTipsDialogDismiss");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogShow() {
            KSSplashAd.this.h("onDownloadTipsDialogShow");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            com.cupidapp.live.startup.view.b f10 = KSSplashAd.this.f();
            if (f10 != null) {
                f10.J0(KSSplashAd.this.g());
            }
        }
    }

    public KSSplashAd(@NotNull FKStartupMediaConfigModel mModel, @Nullable String str, @NotNull String mAdId) {
        s.i(mModel, "mModel");
        s.i(mAdId, "mAdId");
        this.f18515f = mModel;
        this.f18516g = str;
        this.f18517h = mAdId;
        this.f18519j = FKAdType.KS;
        this.f18520k = mModel;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        KsSplashScreenAd ksSplashScreenAd = this.f18518i;
        int ecpm = ksSplashScreenAd != null ? ksSplashScreenAd.getECPM() : 0;
        return ecpm <= 0 ? this.f18515f.getAdvertisementBaseInfo().getPrice() : ecpm;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18519j;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void j(@NotNull Function2<? super Boolean, ? super String, p> result) {
        KsLoadManager loadManager;
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
        if (!f18514l.a(fragmentActivity, this.f18516g)) {
            String str2 = ((Object) g()) + " requestAd fail, 初始化SDK失败";
            com.cupidapp.live.startup.view.b f11 = f();
            if (f11 != null) {
                b.a.d(f11, g(), -1, str2, false, 8, null);
            }
            result.mo1743invoke(Boolean.FALSE, str2);
            return;
        }
        KsScene build = new KsScene.Builder(t.r(this.f18517h)).build();
        b bVar = new b(result);
        if (fragmentActivity.isFinishing() || (loadManager = KsAdSDK.getLoadManager()) == null) {
            return;
        }
        loadManager.loadSplashScreenAd(build, bVar);
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        s.i(adContainer, "adContainer");
        KsSplashScreenAd ksSplashScreenAd = this.f18518i;
        WeakReference<FragmentActivity> e2 = e();
        FragmentActivity fragmentActivity = e2 != null ? e2.get() : null;
        if (ksSplashScreenAd != null && fragmentActivity != null) {
            c cVar = new c();
            if (fragmentActivity.isFinishing()) {
                return;
            }
            View view = ksSplashScreenAd.getView(fragmentActivity, cVar);
            adContainer.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            adContainer.addView(view);
            return;
        }
        String str = ((Object) g()) + " showAd fail, splashScreenAd:" + ((Object) ksSplashScreenAd) + "  activity:" + ((Object) fragmentActivity);
        com.cupidapp.live.startup.view.b f10 = f();
        if (f10 != null) {
            f10.Q(g(), -1, str);
        }
    }
}
