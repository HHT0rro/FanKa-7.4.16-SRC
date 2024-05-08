package com.cupidapp.live.startup.splashad;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.b;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BDSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BDSplashAd extends FKBaseSplashAd {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f18443m = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18444f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f18445g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final String f18446h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public SplashAd f18447i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final FKAdType f18448j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18449k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f18450l;

    /* compiled from: BDSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable String str) {
            s.i(context, "context");
            BDAdConfig.Builder builder = new BDAdConfig.Builder();
            if (str == null) {
                str = "e6a25ee1";
            }
            builder.setAppsid(str).build(context).init();
            MobadsPermissionSettings.setPermissionReadDeviceID(true);
            MobadsPermissionSettings.setPermissionLocation(true);
            MobadsPermissionSettings.setPermissionStorage(true);
            MobadsPermissionSettings.setPermissionAppList(true);
        }
    }

    /* compiled from: BDSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements SplashAd.SplashAdDownloadDialogListener {
        public b() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener
        public void adDownloadWindowClose() {
            BDSplashAd.this.h("adDownloadWindowClose 下载弹窗关闭回调");
            com.cupidapp.live.startup.view.b f10 = BDSplashAd.this.f();
            if (f10 != null) {
                f10.c0(BDSplashAd.this.g(), SplashAdShowState.UNKNOWN);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener
        public void adDownloadWindowShow() {
            BDSplashAd.this.h("adDownloadWindowShow 下载弹窗展示回调");
        }

        @Override // com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener
        public void onADFunctionLpClose() {
            BDSplashAd.this.h("onADFunctionLpClose 下载广告 功能关闭回调");
        }

        @Override // com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener
        public void onADFunctionLpShow() {
            BDSplashAd.this.h("onADFunctionLpShow 下载广告 功能点击回调");
        }

        @Override // com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener
        public void onADPermissionClose() {
            BDSplashAd.this.h("onADPermissionClose 下载广告 权限弹窗关闭回调");
        }

        @Override // com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener
        public void onADPermissionShow() {
            BDSplashAd.this.h("onADPermissionShow 下载广告 权限弹窗展示回调");
        }

        @Override // com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener
        public void onADPrivacyLpClose() {
            BDSplashAd.this.h("onADPrivacyLpClose 下载广告 隐私声明关闭回调");
        }

        @Override // com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener
        public void onADPrivacyLpShow() {
            BDSplashAd.this.h("onADPrivacyLpShow 下载广告 隐私声明点击回调");
        }
    }

    /* compiled from: BDSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements SplashInteractionListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, p> f18453b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super Boolean, ? super String, p> function2) {
            this.f18453b = function2;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
            BDSplashAd.this.f18450l = true;
            com.cupidapp.live.startup.view.b f10 = BDSplashAd.this.f();
            if (f10 != null) {
                f10.p0(BDSplashAd.this.g());
            }
            this.f18453b.mo1743invoke(Boolean.TRUE, null);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
            BDSplashAd.this.h("onAdCacheFailed 广告物料缓存失败");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
            BDSplashAd.this.h("onAdCacheSuccess 广告物料缓存成功");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
            com.cupidapp.live.startup.view.b f10 = BDSplashAd.this.f();
            if (f10 != null) {
                b.a.b(f10, BDSplashAd.this.g(), null, 2, null);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
            Activity activity;
            WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
            if ((a10 == null || (activity = a10.get()) == null || !StringsKt__StringsKt.K(activity.getClass().getName(), "com.baidu.mobads.sdk.api", false, 2, null)) ? false : true) {
                BDSplashAd.this.h("onAdDismissed 百度的广告落地页正在展示中，不执行startupWillClose");
                return;
            }
            com.cupidapp.live.startup.view.b f10 = BDSplashAd.this.f();
            if (f10 != null) {
                f10.c0(BDSplashAd.this.g(), SplashAdShowState.UNKNOWN);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(@Nullable String str) {
            if (BDSplashAd.this.f18450l) {
                com.cupidapp.live.startup.view.b f10 = BDSplashAd.this.f();
                if (f10 != null) {
                    f10.Q(BDSplashAd.this.g(), null, str);
                    return;
                }
                return;
            }
            com.cupidapp.live.startup.view.b f11 = BDSplashAd.this.f();
            if (f11 != null) {
                b.a.d(f11, BDSplashAd.this.g(), null, str, false, 8, null);
            }
            this.f18453b.mo1743invoke(Boolean.FALSE, str);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
            com.cupidapp.live.startup.view.b f10 = BDSplashAd.this.f();
            if (f10 != null) {
                f10.P(BDSplashAd.this.g());
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
            BDSplashAd.this.h("onLpClosed 广告落地页关闭");
        }
    }

    public BDSplashAd(@NotNull FKStartupMediaConfigModel mModel, @Nullable String str, @NotNull String mAdId) {
        s.i(mModel, "mModel");
        s.i(mAdId, "mAdId");
        this.f18444f = mModel;
        this.f18445g = str;
        this.f18446h = mAdId;
        this.f18448j = FKAdType.BD;
        this.f18449k = mModel;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        String eCPMLevel;
        try {
            SplashAd splashAd = this.f18447i;
            int parseInt = (splashAd == null || (eCPMLevel = splashAd.getECPMLevel()) == null) ? 0 : Integer.parseInt(eCPMLevel);
            return parseInt <= 0 ? this.f18444f.getAdvertisementBaseInfo().getPrice() : parseInt;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return this.f18444f.getAdvertisementBaseInfo().getPrice();
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18448j;
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
        f18443m.a(fragmentActivity, this.f18445g);
        SplashAd splashAd = new SplashAd(fragmentActivity, this.f18446h, new RequestParameters.Builder().addExtra("timeout", "4200").addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "true").addExtra(SplashAd.KEY_FETCHAD, "false").build(), new c(result));
        this.f18447i = splashAd;
        splashAd.setDownloadDialogListener(new b());
        SplashAd splashAd2 = this.f18447i;
        if (splashAd2 != null) {
            splashAd2.load();
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        s.i(adContainer, "adContainer");
        SplashAd splashAd = this.f18447i;
        if (splashAd != null) {
            if (splashAd != null) {
                splashAd.show(adContainer);
                return;
            }
            return;
        }
        String str = ((Object) g()) + " showAd fail, mSplashAd = null";
        com.cupidapp.live.startup.view.b f10 = f();
        if (f10 != null) {
            f10.Q(g(), -1, str);
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        SplashAd splashAd = this.f18447i;
        if (splashAd != null) {
            splashAd.destroy();
        }
        this.f18447i = null;
    }
}
