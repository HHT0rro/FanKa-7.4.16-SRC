package com.kwad.components.ad.reward.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.constant.TanxAdType;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.j.b;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.components.ad.reward.widget.HandSlideView;
import com.kwad.components.ad.reward.widget.RewardPreviewTopBarView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.proxy.c;
import com.kwad.components.core.request.e;
import com.kwad.components.core.s.h;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AdRewardPreviewActivityProxy extends c implements HandSlideView.a {
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String KEY_URL = "key_langingpage_url";
    private static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    public h mCloseDialog;
    private int mCount;
    private com.kwad.components.core.s.h mCountdownHelper;
    private long mCurrentDuration;
    private View mHandSlideContainer;

    @Nullable
    private HandSlideView mHandSlideView;
    private long mLastDown;
    public KsLogoView mLogoView;
    private int mSkipCount;
    private long mStartPlayTime;
    private bm mTimerHelper;
    private RewardPreviewTopBarView mTopBarView;
    private String mUrl;
    private AdBaseFrameLayout mWebContainer;
    private boolean mHadAdClicked = false;
    private boolean mCheckExposureResult = true;
    private long mPageEnterTime = 0;
    private boolean mReportedPageShow = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        public static void a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, long j10) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoSkipToEnd(j10);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        public static void c(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify();
                try {
                    rewardAdInteractionListener.onRewardStepVerify(0, 0);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        public static void d(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        public static void e(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onPageDismiss();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        public static void f(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onAdClicked();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRequest(final int i10) {
        new l<e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.6
            @NonNull
            private static RewardCallBackRespInfo C(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: gl, reason: merged with bridge method [inline-methods] */
            public e createRequest() {
                return new e(i10, AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return C(str);
            }
        }.request(exposureRequest());
    }

    private void closeHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView != null) {
            handSlideView.destroy();
            this.mHandSlideView = null;
        }
        View view = this.mHandSlideContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private o<e, RewardCallBackRespInfo> exposureRequest() {
        return new o<e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.7
            private void a(@NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull f fVar) {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                a((RewardCallBackRespInfo) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull e eVar, int i10, String str) {
                super.onError(eVar, i10, str);
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = false;
            }
        };
    }

    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.c.b(true, AdRewardPreviewActivityProxy.this.mAdTemplate, AdRewardPreviewActivityProxy.this.mPageEnterTime);
                com.kwad.components.ad.reward.monitor.c.L(AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                com.kwad.components.ad.reward.monitor.c.K(AdRewardPreviewActivityProxy.this.mAdTemplate);
                if (!AdRewardPreviewActivityProxy.this.mAdTemplate.mPvReported) {
                    AdRewardPreviewActivityProxy.this.checkExposure();
                }
                if (!AdRewardPreviewActivityProxy.this.mHadAdClicked) {
                    AdRewardPreviewActivityProxy.this.showHandSlideMask();
                }
                a.C0516a c0516a = new a.C0516a();
                c0516a.apd = "award_view";
                b.a(true, AdRewardPreviewActivityProxy.this.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().b(c0516a));
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i10, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.c(AdRewardPreviewActivityProxy.this.mAdTemplate, i10, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdClick() {
        this.mHadAdClicked = true;
        a.C0516a c0516a = new a.C0516a();
        c0516a.apd = "award_view";
        b.a(this.mAdTemplate, (String) null, "nativePreview", new com.kwad.sdk.core.adlog.c.b().cK(72).b(c0516a).f(this.mWebContainer.getTouchCoords()), (JSONObject) null);
        closeHandSlideMask();
        a.f(mInteractionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCountdownEnd() {
        if (this.mCheckExposureResult) {
            a.c(mInteractionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEndClose() {
        a.d(mInteractionListener);
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 1, getTimerHelper().getTime(), (JSONObject) null);
        finish();
    }

    public static void launch(Activity activity, AdResultData adResultData, AdTemplate adTemplate, String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        com.kwad.components.ad.reward.monitor.c.i(true, adTemplate);
        boolean CG = d.CG();
        mInteractionListener = rewardAdInteractionListener;
        com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdRewardPreviewActivityProxy.class);
        Intent intent = new Intent(activity, (Class<?>) AdWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(KEY_URL, str);
        if (CG) {
            intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.mE().i(adResultData));
        } else {
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
        }
        try {
            activity.startActivity(intent);
            if (!CG) {
                activity.overridePendingTransition(0, 0);
            }
        } catch (Exception e2) {
            ServiceProvider.reportSdkCaughtException(e2);
            com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, PageCreateStage.ERROR_START_ACTIVITY.getStage(), e2.getMessage());
        }
        com.kwad.components.ad.reward.monitor.c.c(true, adTemplate, PageCreateStage.END_LAUNCH.getStage());
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.monitor.c.c(true, this.mAdTemplate, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCloseDialog() {
        h hVar = this.mCloseDialog;
        if (hVar == null || !hVar.isShowing()) {
            int ceil = (int) Math.ceil(((float) this.mCurrentDuration) / 1000.0f);
            this.mCloseDialog = h.a(getActivity(), this.mAdTemplate, h.h("还差" + ceil + "秒就可以获取奖励", ceil), new h.b() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.8
                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                public final void F(boolean z10) {
                    a.a(AdRewardPreviewActivityProxy.mInteractionListener, System.currentTimeMillis() - AdRewardPreviewActivityProxy.this.mStartPlayTime);
                    com.kwad.sdk.core.adlog.c.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 1, AdRewardPreviewActivityProxy.this.getTimerHelper().getTime(), (JSONObject) null);
                    AdRewardPreviewActivityProxy.this.finish();
                }

                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                public final void fR() {
                    if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                        AdRewardPreviewActivityProxy.this.mCountdownHelper.pause();
                    }
                }

                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                public final void ga() {
                    if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                        AdRewardPreviewActivityProxy.this.mCountdownHelper.resume();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView == null || handSlideView.isStarted()) {
            return;
        }
        this.mHandSlideContainer.setVisibility(0);
        this.mHandSlideView.a(this);
    }

    public void checkExposure() {
        long j10 = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate).adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j10 <= 0 || com.kwad.sdk.core.response.b.a.ag(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate)) <= 5000) {
            return;
        }
        bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.5
            @Override // java.lang.Runnable
            public final void run() {
                AdRewardPreviewActivityProxy.this.checkRequest(1);
            }
        }, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0041  */
    @Override // com.kwad.components.core.proxy.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkIntentData(@androidx.annotation.Nullable android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key_ad_result_cache_idx"
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L1f
            boolean r3 = r5.hasExtra(r0)     // Catch: java.lang.Throwable -> L39
            if (r3 == 0) goto L1f
            int r5 = r5.getIntExtra(r0, r1)     // Catch: java.lang.Throwable -> L39
            com.kwad.components.core.c.f r0 = com.kwad.components.core.c.f.mE()     // Catch: java.lang.Throwable -> L39
            com.kwad.sdk.core.response.model.AdResultData r5 = r0.d(r5, r2)     // Catch: java.lang.Throwable -> L39
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.getFirstAdTemplate()     // Catch: java.lang.Throwable -> L39
            r4.mAdTemplate = r5     // Catch: java.lang.Throwable -> L39
            goto L3d
        L1f:
            android.content.Intent r5 = r4.getIntent()     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "key_template_json"
            java.lang.String r5 = r5.getStringExtra(r0)     // Catch: java.lang.Throwable -> L39
            com.kwad.sdk.core.response.model.AdTemplate r0 = new com.kwad.sdk.core.response.model.AdTemplate     // Catch: java.lang.Throwable -> L39
            r0.<init>()     // Catch: java.lang.Throwable -> L39
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L39
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L39
            r0.parseJson(r3)     // Catch: java.lang.Throwable -> L39
            r4.mAdTemplate = r0     // Catch: java.lang.Throwable -> L39
            goto L3d
        L39:
            r5 = move-exception
            com.kwad.sdk.core.e.c.printStackTrace(r5)
        L3d:
            com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            if (r5 != 0) goto L49
            java.lang.String r5 = "reward"
            java.lang.String r0 = "show"
            com.kwad.sdk.j.a.al(r5, r0)
            return r1
        L49:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.checkIntentData(android.content.Intent):boolean");
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return R.layout.ksad_activity_reward_preview;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return TAG;
    }

    public bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bm();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.mUrl = getIntent().getStringExtra(KEY_URL);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        int i10 = dQ.adStyleInfo.adBrowseInfo.adBrowseDuration;
        int ae2 = com.kwad.sdk.core.response.b.a.ae(dQ);
        this.mCount = i10;
        this.mSkipCount = Math.min(ae2, i10);
        this.mStartPlayTime = System.currentTimeMillis();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            try {
                rewardAdInteractionListener.onVideoPlayStart();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().ei(this.mAdTemplate).bu(true).bw(true).bs(true).b(getWebErrorListener()));
        this.mAdWebView.onActivityCreate();
        this.mWebContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_preview_webview_container);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_reward_preview_logo);
        this.mLogoView = ksLogoView;
        ksLogoView.aD(this.mAdTemplate);
        this.mHandSlideContainer = findViewById(R.id.ksad_reward_preview_hand_slide_container);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        if (this.mUrl != null) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aF(dQ) && d.BR() && ag.isWifiConnected(getActivity())) {
                cVar.r(new a.C0461a(getActivity()).ao(false).ap(false).aq(this.mAdTemplate).ar(false));
            }
        }
        this.mAdWebView.loadUrl(!TextUtils.isEmpty(this.mUrl) ? this.mUrl : com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate)));
        getTimerHelper().startTiming();
        this.mWebContainer.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AdRewardPreviewActivityProxy.this.mLastDown = SystemClock.elapsedRealtime();
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - AdRewardPreviewActivityProxy.this.mLastDown;
                if (AdRewardPreviewActivityProxy.this.mLastDown > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                    AdRewardPreviewActivityProxy.this.handleAdClick();
                }
                AdRewardPreviewActivityProxy.this.mLastDown = 0L;
                return false;
            }
        });
        this.mHandSlideView = (HandSlideView) findViewById(R.id.ksad_reward_preview_hand_slide);
        com.kwad.components.core.s.h hVar = new com.kwad.components.core.s.h(this.mCount * 1000);
        this.mCountdownHelper = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.2
            @Override // com.kwad.components.core.s.h.a
            public final void onProgress(long j10, long j11) {
                com.kwad.sdk.core.e.c.d(AdRewardPreviewActivityProxy.TAG, "onProgress currentDuration: " + j10 + " , totalDuration: " + j11);
                AdRewardPreviewActivityProxy.this.mCurrentDuration = j10;
                AdRewardPreviewActivityProxy.this.mTopBarView.n(j10);
            }
        });
        this.mCountdownHelper.start();
        RewardPreviewTopBarView rewardPreviewTopBarView = (RewardPreviewTopBarView) findViewById(R.id.ksad_reward_preview_topbar);
        this.mTopBarView = rewardPreviewTopBarView;
        rewardPreviewTopBarView.setTotalCountDuration(this.mCount * 1000);
        this.mTopBarView.setRewardTips(com.kwad.sdk.core.response.b.a.bY(dQ));
        this.mTopBarView.setCloseBtnDelayShowDuration(this.mSkipCount * 1000);
        this.mTopBarView.setTopBarListener(new RewardPreviewTopBarView.a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.3
            @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
            public final void F(boolean z10) {
                if (z10) {
                    AdRewardPreviewActivityProxy.this.handleEndClose();
                } else {
                    AdRewardPreviewActivityProxy.this.showCloseDialog();
                }
            }

            @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
            public final void G(boolean z10) {
                if (z10) {
                    return;
                }
                AdRewardPreviewActivityProxy.this.handleCountdownEnd();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.j.a.al(TanxAdType.REWARD_STRING, "show");
        com.kwad.sdk.commercial.d.c.bz(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        try {
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null && ksAdWebView.canGoBack()) {
                this.mAdWebView.goBack();
                com.kwad.sdk.core.adlog.c.bM(this.mAdTemplate);
                return;
            }
            RewardPreviewTopBarView rewardPreviewTopBarView = this.mTopBarView;
            if (rewardPreviewTopBarView != null && rewardPreviewTopBarView.ke()) {
                super.onBackPressed();
                a.d(mInteractionListener);
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 11, getTimerHelper().getTime(), (JSONObject) null);
                return;
            }
            showCloseDialog();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mPageEnterTime = elapsedRealtime;
            com.kwad.components.ad.reward.monitor.c.a(true, this.mAdTemplate, elapsedRealtime);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.monitor.b.b(true, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        a.e(mInteractionListener);
        mInteractionListener = null;
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.stop();
        }
        super.onDestroy();
    }

    @Override // com.kwad.components.ad.reward.widget.HandSlideView.a
    public void onHandSlideLoopEnd() {
        closeHandSlideMask();
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        getTimerHelper().Np();
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.pause();
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        getTimerHelper().No();
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.resume();
        }
        if (this.mReportedPageShow) {
            return;
        }
        com.kwad.components.ad.reward.monitor.c.f(true, this.mAdTemplate);
        this.mReportedPageShow = true;
    }
}
