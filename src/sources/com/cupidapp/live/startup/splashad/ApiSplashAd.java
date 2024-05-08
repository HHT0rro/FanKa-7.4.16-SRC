package com.cupidapp.live.startup.splashad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.startup.helper.ADMonitorHelper;
import com.cupidapp.live.startup.model.ADClickActionType;
import com.cupidapp.live.startup.model.AdResourceModel;
import com.cupidapp.live.startup.model.ApiAdContentModel;
import com.cupidapp.live.startup.model.ApiAdModel;
import com.cupidapp.live.startup.model.AppModel;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.MonitorModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.AdSkipView;
import com.cupidapp.live.startup.view.ApiAdDisplayView;
import com.cupidapp.live.startup.view.b;
import com.google.android.material.badge.BadgeDrawable;
import f1.c;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: ApiSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ApiSplashAd extends FKBaseSplashAd implements com.cupidapp.live.startup.view.d {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18439f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final FKAdType f18440g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public ApiAdModel f18441h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18442i;

    public ApiSplashAd(@NotNull FKStartupMediaConfigModel mConfigModel, @NotNull FKAdType splashType) {
        s.i(mConfigModel, "mConfigModel");
        s.i(splashType, "splashType");
        this.f18439f = mConfigModel;
        this.f18440g = splashType;
    }

    @Override // com.cupidapp.live.startup.view.d
    public void a(boolean z10) {
        MonitorModel monitor;
        b f10 = f();
        if (f10 != null) {
            f10.P(g());
        }
        if (z10) {
            ADMonitorHelper aDMonitorHelper = ADMonitorHelper.f18414a;
            AppApplication h10 = AppApplication.f11612d.h();
            ApiAdContentModel q10 = q();
            aDMonitorHelper.b(h10, (q10 == null || (monitor = q10.getMonitor()) == null) ? null : monitor.getStart_urls());
        }
    }

    @Override // com.cupidapp.live.startup.view.d
    public void b(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        MonitorModel monitor;
        b f10 = f();
        List<String> list = null;
        if (f10 != null) {
            b.a.b(f10, g(), null, 2, null);
        }
        ApiAdContentModel q10 = q();
        ADMonitorHelper aDMonitorHelper = ADMonitorHelper.f18414a;
        AppApplication h10 = AppApplication.f11612d.h();
        if (q10 != null && (monitor = q10.getMonitor()) != null) {
            list = monitor.getRealClickUrl(h.l(this), h.k(this), num, num2, num3, num4);
        }
        aDMonitorHelper.b(h10, list);
        s(num, num2, num3, num4);
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        Integer price;
        try {
            ApiAdContentModel q10 = q();
            int intValue = (q10 == null || (price = q10.getPrice()) == null) ? 0 : price.intValue();
            return intValue <= 0 ? r().getAdvertisementBaseInfo().getPrice() : intValue;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return r().getAdvertisementBaseInfo().getPrice();
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18440g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context] */
    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void j(@NotNull final Function2<? super Boolean, ? super String, p> result) {
        s.i(result, "result");
        WeakReference<FragmentActivity> e2 = e();
        g gVar = e2 != null ? e2.get() : 0;
        if (gVar == 0) {
            String str = ((Object) g()) + " requestAd fail, activity = null";
            b f10 = f();
            if (f10 != null) {
                b.a.d(f10, g(), -1, str, false, 8, null);
            }
            result.mo1743invoke(Boolean.FALSE, str);
            return;
        }
        this.f18442i = false;
        Observable<Result<ApiAdModel>> q10 = NetworkClient.f11868a.i().q(r().getAdvertisementBaseInfo().getThirdPartySource(), r().getAdvertisementBaseInfo().getThirdPartyId(), 1, c.c(gVar));
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.startup.splashad.ApiSplashAd$requestAd$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                b f11 = ApiSplashAd.this.f();
                if (f11 != null) {
                    b.a.d(f11, ApiSplashAd.this.g(), null, it.getMessage(), false, 8, null);
                }
                result.mo1743invoke(Boolean.FALSE, it.getMessage());
                return Boolean.TRUE;
            }
        };
        g gVar2 = gVar instanceof g ? gVar : null;
        Disposable disposed = q10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ApiAdModel, p>() { // from class: com.cupidapp.live.startup.splashad.ApiSplashAd$requestAd$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ApiAdModel apiAdModel) {
                m2815invoke(apiAdModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2815invoke(ApiAdModel apiAdModel) {
                ApiSplashAd.this.f18441h = apiAdModel;
                b f11 = ApiSplashAd.this.f();
                if (f11 != null) {
                    f11.p0(ApiSplashAd.this.g());
                }
                result.mo1743invoke(Boolean.TRUE, null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar2)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar2 != null) {
                gVar2.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        ApiAdContentModel q10;
        MonitorModel monitor;
        FragmentActivity fragmentActivity;
        s.i(adContainer, "adContainer");
        ApiAdContentModel q11 = q();
        List<String> list = null;
        if (q11 != null) {
            WeakReference<FragmentActivity> e2 = e();
            if (!((e2 == null || (fragmentActivity = e2.get()) == null || !fragmentActivity.isFinishing()) ? false : true)) {
                adContainer.removeAllViews();
                Context context = adContainer.getContext();
                s.h(context, "adContainer.context");
                ApiAdDisplayView apiAdDisplayView = new ApiAdDisplayView(context);
                apiAdDisplayView.setListener(this);
                WeakReference<FragmentActivity> e10 = e();
                apiAdDisplayView.i(e10 != null ? e10.get() : null);
                apiAdDisplayView.g(q11);
                adContainer.addView(apiAdDisplayView);
                Integer displayTime = r().getAdvertisementBaseInfo().getDisplayTime();
                int intValue = displayTime != null ? displayTime.intValue() : 5;
                Context context2 = adContainer.getContext();
                s.h(context2, "adContainer.context");
                v(context2, adContainer, intValue);
                ADMonitorHelper aDMonitorHelper = ADMonitorHelper.f18414a;
                AppApplication h10 = AppApplication.f11612d.h();
                q10 = q();
                if (q10 != null && (monitor = q10.getMonitor()) != null) {
                    list = monitor.getRealImpressUrl(h.l(this), h.k(this));
                }
                aDMonitorHelper.b(h10, list);
            }
        }
        String str = ((Object) g()) + " showAd fail, mSplashAd = null";
        b f10 = f();
        if (f10 != null) {
            f10.Q(g(), -1, str);
        }
        ADMonitorHelper aDMonitorHelper2 = ADMonitorHelper.f18414a;
        AppApplication h102 = AppApplication.f11612d.h();
        q10 = q();
        if (q10 != null) {
            list = monitor.getRealImpressUrl(h.l(this), h.k(this));
        }
        aDMonitorHelper2.b(h102, list);
    }

    public final ApiAdContentModel q() {
        AdResourceModel resource;
        List<ApiAdContentModel> ads;
        ApiAdModel apiAdModel = this.f18441h;
        if (apiAdModel == null || (resource = apiAdModel.getResource()) == null || (ads = resource.getAds()) == null) {
            return null;
        }
        return (ApiAdContentModel) CollectionsKt___CollectionsKt.V(ads);
    }

    @NotNull
    public FKStartupMediaConfigModel r() {
        return this.f18439f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if ((r2.length() > 0) == true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(java.lang.Integer r7, java.lang.Integer r8, java.lang.Integer r9, java.lang.Integer r10) {
        /*
            r6 = this;
            com.cupidapp.live.startup.model.ApiAdContentModel r1 = r6.q()
            if (r1 != 0) goto L7
            return
        L7:
            java.lang.Integer r0 = r1.getActionType()
            com.cupidapp.live.startup.model.ADClickActionType r2 = com.cupidapp.live.startup.model.ADClickActionType.EXPOSURE
            int r2 = r2.getValue()
            if (r0 != 0) goto L14
            goto L1b
        L14:
            int r0 = r0.intValue()
            if (r0 != r2) goto L1b
            return
        L1b:
            r0 = 1
            r6.f18442i = r0
            java.lang.String r2 = r1.getDeeplink()
            r3 = 0
            if (r2 == 0) goto L31
            int r2 = r2.length()
            if (r2 <= 0) goto L2d
            r2 = 1
            goto L2e
        L2d:
            r2 = 0
        L2e:
            if (r2 != r0) goto L31
            goto L32
        L31:
            r0 = 0
        L32:
            if (r0 == 0) goto L63
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L5a
            java.lang.String r2 = "android.intent.action.VIEW"
            java.lang.String r3 = r1.getRealDeepLink(r7, r8, r9, r10)     // Catch: java.lang.Exception -> L5a
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Exception -> L5a
            r0.<init>(r2, r3)     // Catch: java.lang.Exception -> L5a
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r2)     // Catch: java.lang.Exception -> L5a
            java.lang.ref.WeakReference r2 = r6.e()     // Catch: java.lang.Exception -> L5a
            if (r2 == 0) goto L6b
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L5a
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2     // Catch: java.lang.Exception -> L5a
            if (r2 == 0) goto L6b
            r2.startActivity(r0)     // Catch: java.lang.Exception -> L5a
            goto L6b
        L5a:
            r0 = r6
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r0.u(r1, r2, r3, r4, r5)
            goto L6b
        L63:
            r0 = r6
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r0.u(r1, r2, r3, r4, r5)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.startup.splashad.ApiSplashAd.s(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer):void");
    }

    public final void t(ApiAdContentModel apiAdContentModel, Integer num, Integer num2, Integer num3, Integer num4) {
        FragmentActivity fragmentActivity;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(apiAdContentModel.getRealLanding(num, num2, num3, num4)));
        intent.addFlags(268435456);
        WeakReference<FragmentActivity> e2 = e();
        if (e2 == null || (fragmentActivity = e2.get()) == null) {
            return;
        }
        fragmentActivity.startActivity(intent);
    }

    public final void u(ApiAdContentModel apiAdContentModel, Integer num, Integer num2, Integer num3, Integer num4) {
        FragmentActivity fragmentActivity;
        Integer actionType = apiAdContentModel.getActionType();
        int value = ADClickActionType.WEBVIEWOPEN.getValue();
        if (actionType != null && actionType.intValue() == value) {
            j.a aVar = j.f12156c;
            WeakReference<FragmentActivity> e2 = e();
            j.a.b(aVar, e2 != null ? e2.get() : null, apiAdContentModel.getRealLanding(num, num2, num3, num4), null, 4, null);
            return;
        }
        Integer actionType2 = apiAdContentModel.getActionType();
        int value2 = ADClickActionType.DOWNLOAD.getValue();
        if (actionType2 != null && actionType2.intValue() == value2) {
            AppModel app = apiAdContentModel.getApp();
            if ((app != null ? app.getPackageName() : null) != null) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + apiAdContentModel.getApp().getPackageName()));
                    intent.addFlags(268435456);
                    WeakReference<FragmentActivity> e10 = e();
                    if (e10 == null || (fragmentActivity = e10.get()) == null) {
                        return;
                    }
                    fragmentActivity.startActivity(intent);
                    return;
                } catch (Exception unused) {
                    t(apiAdContentModel, num, num2, num3, num4);
                    return;
                }
            }
        }
        t(apiAdContentModel, num, num2, num3, num4);
    }

    public final void v(Context context, ViewGroup viewGroup, int i10) {
        AdSkipView adSkipView = new AdSkipView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h.c(this, 74.0f), h.c(this, 36.0f));
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.topMargin = h.c(this, 40.0f);
        layoutParams.rightMargin = h.c(this, 16.0f);
        adSkipView.setLayoutParams(layoutParams);
        adSkipView.c(i10, new Function0<p>() { // from class: com.cupidapp.live.startup.splashad.ApiSplashAd$useCustomCountdownButton$1
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
                b f10 = ApiSplashAd.this.f();
                if (f10 != null) {
                    f10.J0(ApiSplashAd.this.g());
                }
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.startup.splashad.ApiSplashAd$useCustomCountdownButton$2
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
                boolean z10;
                b f10;
                z10 = ApiSplashAd.this.f18442i;
                if (z10 || (f10 = ApiSplashAd.this.f()) == null) {
                    return;
                }
                f10.c0(ApiSplashAd.this.g(), SplashAdShowState.COMPLETE_DISPLAY);
            }
        });
        viewGroup.addView(adSkipView);
    }
}
