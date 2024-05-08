package com.cupidapp.live.startup.express.csj;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.express.FKBaseExpressAd;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.splashad.CSJSplash;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKCSJExpressAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKCSJExpressAd extends FKBaseExpressAd {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final WeakReference<FragmentActivity> f18341b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18342c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f18343d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18344e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.startup.express.b f18345f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public TTFeedAd f18346g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public TTAdNative f18347h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final FKAdType f18348i;

    /* renamed from: j, reason: collision with root package name */
    public final float f18349j;

    /* compiled from: FKCSJExpressAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements MediationExpressRenderListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
        public void onAdClick() {
            FKCSJExpressAd.this.f18345f.a(FKCSJExpressAd.this.q(), FKCSJExpressAd.this.f18342c);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
        public void onAdShow() {
            FKCSJExpressAd.this.f18345f.c(FKCSJExpressAd.this.q(), FKCSJExpressAd.this.f18342c);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
        public void onRenderFail(@Nullable View view, @Nullable String str, int i10) {
            FKCSJExpressAd.this.f18345f.e(FKCSJExpressAd.this.q(), FKCSJExpressAd.this.f18342c, Integer.valueOf(i10), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
        public void onRenderSuccess(@Nullable View view, float f10, float f11, boolean z10) {
            if (FKCSJExpressAd.this.f18346g != null) {
                TTFeedAd tTFeedAd = FKCSJExpressAd.this.f18346g;
                FKCSJExpressAd.this.f18345f.b(FKCSJExpressAd.this.q(), FKCSJExpressAd.this.f18342c, tTFeedAd != null ? tTFeedAd.getAdView() : null);
            }
        }
    }

    /* compiled from: FKCSJExpressAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TTAppDownloadListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j10, long j11, @Nullable String str, @Nullable String str2) {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKCSJExpressAd.this.q()) + "  DownloadListener 下载中，点击暂停");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j10, long j11, @Nullable String str, @Nullable String str2) {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKCSJExpressAd.this.q()) + "  DownloadListener 下载失败，点击重新下载 ");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j10, @Nullable String str, @Nullable String str2) {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKCSJExpressAd.this.q()) + "  DownloadListener 下载完成");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j10, long j11, @Nullable String str, @Nullable String str2) {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKCSJExpressAd.this.q()) + "  DownloadListener 下载暂停，点击继续");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKCSJExpressAd.this.q()) + "  DownloadListener onIdle");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(@Nullable String str, @Nullable String str2) {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKCSJExpressAd.this.q()) + "  DownloadListener 安装完成，点击图片打开");
        }
    }

    /* compiled from: FKCSJExpressAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements TTAdDislike.DislikeInteractionCallback {
        public c() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKCSJExpressAd.this.q()) + "  DislikeCallback  onCancel");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i10, @Nullable String str, boolean z10) {
            FKCSJExpressAd.this.f18345f.d(FKCSJExpressAd.this.q(), FKCSJExpressAd.this.f18342c, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKCSJExpressAd.this.q()) + "  DislikeCallback  onShow");
        }
    }

    public FKCSJExpressAd(@NotNull WeakReference<FragmentActivity> activity, int i10, @Nullable String str, @NotNull String adId, @NotNull com.cupidapp.live.startup.express.b listener) {
        s.i(activity, "activity");
        s.i(adId, "adId");
        s.i(listener, "listener");
        this.f18341b = activity;
        this.f18342c = i10;
        this.f18343d = str;
        this.f18344e = adId;
        this.f18345f = listener;
        this.f18348i = FKAdType.CSJ;
        this.f18349j = h.t(this, h.l(this));
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void b() {
        final FragmentActivity fragmentActivity = this.f18341b.get();
        if (fragmentActivity == null) {
            this.f18345f.e(q(), this.f18342c, -1, ((Object) q()) + " initExpressAd fail, activity = null");
            return;
        }
        CSJSplash.f18454m.a(this.f18343d, new Function0<p>() { // from class: com.cupidapp.live.startup.express.csj.FKCSJExpressAd$initExpressAd$1

            /* compiled from: FKCSJExpressAd.kt */
            @d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public static final class a implements TTAdNative.FeedAdListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FKCSJExpressAd f18353a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ FragmentActivity f18354b;

                public a(FKCSJExpressAd fKCSJExpressAd, FragmentActivity fragmentActivity) {
                    this.f18353a = fKCSJExpressAd;
                    this.f18354b = fragmentActivity;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                public void onError(int i10, @Nullable String str) {
                    this.f18353a.f18345f.e(this.f18353a.q(), this.f18353a.f18342c, Integer.valueOf(i10), str);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                public void onFeedAdLoad(@Nullable List<TTFeedAd> list) {
                    if (list == null || list.size() == 0) {
                        return;
                    }
                    this.f18353a.f18346g = list.get(0);
                    this.f18353a.n(this.f18354b);
                    TTFeedAd tTFeedAd = this.f18353a.f18346g;
                    if (tTFeedAd != null) {
                        tTFeedAd.render();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TTAdNative tTAdNative;
                AdSlot r10;
                FKCSJExpressAd.this.f18347h = TTAdSdk.getAdManager().createAdNative(fragmentActivity);
                tTAdNative = FKCSJExpressAd.this.f18347h;
                if (tTAdNative != null) {
                    r10 = FKCSJExpressAd.this.r();
                    tTAdNative.loadFeedAd(r10, new a(FKCSJExpressAd.this, fragmentActivity));
                }
            }
        }, new Function2<Integer, String, p>() { // from class: com.cupidapp.live.startup.express.csj.FKCSJExpressAd$initExpressAd$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return p.f51048a;
            }

            public final void invoke(int i10, @Nullable String str) {
                FKCSJExpressAd.this.f18345f.e(FKCSJExpressAd.this.q(), FKCSJExpressAd.this.f18342c, Integer.valueOf(i10), str);
            }
        });
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void c() {
        TTFeedAd tTFeedAd = this.f18346g;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
        this.f18346g = null;
        this.f18347h = null;
    }

    public final void n(FragmentActivity fragmentActivity) {
        TTFeedAd tTFeedAd;
        TTFeedAd tTFeedAd2 = this.f18346g;
        MediationNativeManager mediationManager = tTFeedAd2 != null ? tTFeedAd2.getMediationManager() : null;
        if (!(mediationManager != null && mediationManager.isExpress())) {
            this.f18345f.e(q(), this.f18342c, -1, ((Object) q()) + " bindAdListener isExpress:" + ((Object) (mediationManager != null ? Boolean.valueOf(mediationManager.isExpress()) : null)));
            return;
        }
        TTFeedAd tTFeedAd3 = this.f18346g;
        if (tTFeedAd3 != null) {
            tTFeedAd3.setExpressRenderListener(new a());
        }
        o(fragmentActivity);
        TTFeedAd tTFeedAd4 = this.f18346g;
        if ((tTFeedAd4 != null && tTFeedAd4.getInteractionType() == 4) && (tTFeedAd = this.f18346g) != null) {
            tTFeedAd.setDownloadListener(new b());
        }
    }

    public final void o(Activity activity) {
        TTFeedAd tTFeedAd = this.f18346g;
        if (tTFeedAd != null) {
            tTFeedAd.setDislikeCallback(activity, new c());
        }
    }

    public float p() {
        return this.f18349j;
    }

    @NotNull
    public FKAdType q() {
        return this.f18348i;
    }

    public final AdSlot r() {
        AdSlot build = new AdSlot.Builder().setCodeId(this.f18344e).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(p(), a()).setImageAcceptedSize(640, 320).build();
        s.h(build, "Builder()\n            .s…size\n            .build()");
        return build;
    }
}
