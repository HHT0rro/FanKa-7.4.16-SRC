package com.cupidapp.live.startup.express;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.splashad.BDSplashAd;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBDExpressAd.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends FKBaseExpressAd {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final WeakReference<FragmentActivity> f18324b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18325c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f18326d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18327e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.startup.express.b f18328f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final FKAdType f18329g;

    /* compiled from: FKBDExpressAd.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.startup.express.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0169a implements ExpressResponse.ExpressInteractionListener {
        public C0169a() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdClick() {
            a.this.f18328f.a(a.this.i(), a.this.f18325c);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdExposed() {
            a.this.f18328f.c(a.this.i(), a.this.f18325c);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdRenderFail(@Nullable View view, @Nullable String str, int i10) {
            a.this.f18328f.e(a.this.i(), a.this.f18325c, Integer.valueOf(i10), str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdRenderSuccess(@Nullable View view, float f10, float f11) {
            j.f12332a.a("FKBDExpressAd", "onAdRenderSuccess width: " + f10 + " height: " + f11);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdUnionClick() {
            j.f12332a.a("FKBDExpressAd", "onAdUnionClick");
        }
    }

    /* compiled from: FKBDExpressAd.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements ExpressResponse.ExpressDislikeListener {
        public b() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public void onDislikeItemClick(@Nullable String str) {
            a.this.f18328f.d(a.this.i(), a.this.f18325c, str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public void onDislikeWindowClose() {
            j.f12332a.a("FKBDExpressAd", "onDislikeWindowClose");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public void onDislikeWindowShow() {
            j.f12332a.a("FKBDExpressAd", "onDislikeWindowShow");
        }
    }

    /* compiled from: FKBDExpressAd.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements BaiduNativeManager.ExpressAdListener {
        public c() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onLpClosed() {
            j.f12332a.a("FKBDExpressAd", "onLpClosed");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeFail(int i10, @Nullable String str) {
            a.this.f18328f.e(a.this.i(), a.this.f18325c, Integer.valueOf(i10), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeLoad(@Nullable List<ExpressResponse> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            ExpressResponse expressResponse = (ExpressResponse) CollectionsKt___CollectionsKt.T(list);
            if (expressResponse.isAdAvailable()) {
                a.this.f18328f.b(a.this.i(), a.this.f18325c, a.this.j(expressResponse));
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNoAd(int i10, @Nullable String str) {
            a.this.f18328f.e(a.this.i(), a.this.f18325c, Integer.valueOf(i10), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadFailed() {
            j.f12332a.a("FKBDExpressAd", "onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadSuccess() {
            j.f12332a.a("FKBDExpressAd", "onVideoDownloadSuccess");
        }
    }

    public a(@NotNull WeakReference<FragmentActivity> activity, int i10, @Nullable String str, @NotNull String adId, @NotNull com.cupidapp.live.startup.express.b listener) {
        s.i(activity, "activity");
        s.i(adId, "adId");
        s.i(listener, "listener");
        this.f18324b = activity;
        this.f18325c = i10;
        this.f18326d = str;
        this.f18327e = adId;
        this.f18328f = listener;
        this.f18329g = FKAdType.BD;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void b() {
        FragmentActivity fragmentActivity = this.f18324b.get();
        if (fragmentActivity == null) {
            return;
        }
        BDSplashAd.f18443m.a(fragmentActivity, this.f18326d);
        k();
    }

    @NotNull
    public FKAdType i() {
        return this.f18329g;
    }

    public final View j(ExpressResponse expressResponse) {
        expressResponse.setInteractionListener(new C0169a());
        expressResponse.setAdDislikeListener(new b());
        expressResponse.render();
        View expressAdView = expressResponse.getExpressAdView();
        s.h(expressAdView, "response.expressAdView");
        return expressAdView;
    }

    public final void k() {
        new BaiduNativeManager(this.f18324b.get(), this.f18327e).loadExpressAd(new RequestParameters.Builder().downloadAppConfirmPolicy(1).build(), new c());
    }
}
