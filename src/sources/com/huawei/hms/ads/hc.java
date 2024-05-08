package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.ku;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.R;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.SplashAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.b;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class hc implements hg {
    public AdContentData B;
    public fr C;
    public WeakReference<lq> I;
    public AdContentData L;
    public b Z;

    /* renamed from: b, reason: collision with root package name */
    public RewardVerifyConfig f29264b;

    /* renamed from: c, reason: collision with root package name */
    public int f29265c;

    /* renamed from: d, reason: collision with root package name */
    public String f29266d;

    /* renamed from: e, reason: collision with root package name */
    public Context f29267e;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<lo> f29269i;

    /* renamed from: j, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.listeners.b f29270j;

    /* renamed from: k, reason: collision with root package name */
    private SplashView.SplashAdLoadListener f29271k;

    /* renamed from: s, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.listeners.a f29279s;

    /* renamed from: t, reason: collision with root package name */
    private SplashAdDisplayListener f29280t;

    /* renamed from: u, reason: collision with root package name */
    private CountDownTimer f29281u;

    /* renamed from: v, reason: collision with root package name */
    private String f29282v;

    /* renamed from: h, reason: collision with root package name */
    private io f29268h = new ic();

    /* renamed from: l, reason: collision with root package name */
    private boolean f29272l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f29273m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f29274n = false;
    public boolean S = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f29275o = false;

    /* renamed from: p, reason: collision with root package name */
    private final String f29276p = "load_timeout_" + hashCode();

    /* renamed from: q, reason: collision with root package name */
    private boolean f29277q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f29278r = false;

    /* renamed from: w, reason: collision with root package name */
    private long f29283w = 0;

    /* renamed from: x, reason: collision with root package name */
    private long f29284x = -1;
    public long F = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f29285y = 0;
    public boolean D = false;

    /* renamed from: a, reason: collision with root package name */
    public DelayInfo f29263a = new DelayInfo();

    /* renamed from: z, reason: collision with root package name */
    private boolean f29286z = false;

    /* renamed from: com.huawei.hms.ads.hc$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass1 implements RemoteCallResultCallback<String> {
        public final /* synthetic */ int Code;

        public AnonymousClass1(int i10) {
            this.Code = i10;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, final CallResult<String> callResult) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.hc.1.1
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.f29266d = (String) callResult.getData();
                    final AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.z.V((String) callResult.getData(), AdContentData.class, new Class[0]);
                    if (adContentData != null) {
                        hc.this.F = System.currentTimeMillis();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        hc.this.S(anonymousClass1.Code);
                        hc.this.B = adContentData;
                        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.hc.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                hc hcVar = hc.this;
                                hcVar.Code(hcVar.f29267e, adContentData, anonymousClass12.Code);
                            }
                        });
                        if (hc.this.V(adContentData)) {
                            return;
                        } else {
                            hc.this.I(com.huawei.openalliance.ad.constant.ad.f32210w);
                        }
                    } else {
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        hc.this.I(anonymousClass12.Code);
                    }
                    hc.this.l();
                }
            });
        }
    }

    /* renamed from: com.huawei.hms.ads.hc$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass3 implements Runnable {
        public final /* synthetic */ AdSlotParam Code;
        public final /* synthetic */ SplashAdReqParam V;

        /* renamed from: com.huawei.hms.ads.hc$3$1, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class AnonymousClass1 implements RemoteCallResultCallback<String> {

            /* renamed from: com.huawei.hms.ads.hc$3$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
            public class RunnableC02961 implements Runnable {
                public final /* synthetic */ long Code;
                public final /* synthetic */ CallResult V;

                public RunnableC02961(long j10, CallResult callResult) {
                    this.Code = j10;
                    this.V = callResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    hc.this.f29263a.D(com.huawei.openalliance.ad.utils.v.Code() - this.Code);
                    hc.this.f29266d = (String) this.V.getData();
                    AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.z.V((String) this.V.getData(), AdContentData.class, new Class[0]);
                    if (adContentData != null) {
                        hc.this.f29282v = adContentData.E();
                    }
                    if (adContentData != null) {
                        hc.this.I(adContentData);
                    } else {
                        com.huawei.openalliance.ad.ipc.g.V(hc.this.f29267e).Code("getSpareSplashAd", String.valueOf(hc.this.C.I()), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.hc.3.1.1.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, final CallResult<String> callResult) {
                                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.hc.3.1.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        hc.this.f29266d = (String) callResult.getData();
                                        AdContentData adContentData2 = (AdContentData) com.huawei.openalliance.ad.utils.z.V((String) callResult.getData(), AdContentData.class, new Class[0]);
                                        if (adContentData2 != null) {
                                            hc.this.Code(adContentData2, 494);
                                        } else {
                                            hc.this.I((AdContentData) null);
                                        }
                                    }
                                });
                            }
                        }, String.class);
                    }
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                gl.V("AdMediator", "onDownloaded");
                hc hcVar = hc.this;
                hcVar.f29263a.Code(hcVar.f29283w, System.currentTimeMillis());
                synchronized (hc.this) {
                    gl.V("AdMediator", "onDownloaded, loadingTimeout:" + hc.this.f29272l);
                    hc hcVar2 = hc.this;
                    if (!hcVar2.S) {
                        hcVar2.S = true;
                    }
                    if (callResult.getCode() != 200) {
                        hc.this.f29263a.V(Integer.valueOf(callResult.getCode()));
                    }
                    if (hc.this.f29272l) {
                        hc.this.f29263a.I(-2);
                        hc.this.f29275o = true;
                    } else {
                        hc.this.f29272l = true;
                        com.huawei.openalliance.ad.utils.ba.Code(hc.this.f29276p);
                        gl.V("AdMediator", "cancel loadTimeoutTask");
                        hc hcVar3 = hc.this;
                        hcVar3.f29263a.Z(hcVar3.f29283w, System.currentTimeMillis());
                        com.huawei.openalliance.ad.utils.ba.Code(new RunnableC02961(com.huawei.openalliance.ad.utils.v.Code(), callResult));
                    }
                    if (hc.this.f29275o) {
                        hc.this.B((AdContentData) com.huawei.openalliance.ad.utils.z.V(callResult.getData(), AdContentData.class, new Class[0]));
                    }
                }
            }
        }

        public AnonymousClass3(AdSlotParam adSlotParam, SplashAdReqParam splashAdReqParam) {
            this.Code = adSlotParam;
            this.V = splashAdReqParam;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = hc.this.f29267e;
            if (context == null) {
                return;
            }
            kr.Code(context, com.huawei.openalliance.ad.constant.u.cf, this.Code, com.huawei.openalliance.ad.utils.z.V(this.V), new AnonymousClass1(), String.class);
        }
    }

    /* renamed from: com.huawei.hms.ads.hc$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (hc.this) {
                gl.V("AdMediator", "on load task timeout, loadingTimeout: %s", Boolean.valueOf(hc.this.f29272l));
                if (!hc.this.f29272l) {
                    hc.this.f29272l = true;
                    com.huawei.openalliance.ad.ipc.g.V(hc.this.f29267e).Code("getSpareSplashAd", String.valueOf(hc.this.C.I()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.hc.4.1
                        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.hc.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdContentData adContentData = (AdContentData) callResult.getData();
                                    if (adContentData != null) {
                                        hc.this.Code(adContentData, -2);
                                    } else {
                                        hc.this.I(-2);
                                        hc.this.e();
                                    }
                                }
                            });
                        }
                    }, AdContentData.class);
                }
            }
        }
    }

    public hc(lo loVar) {
        this.f29269i = new WeakReference<>(loVar);
        this.f29265c = loVar.getAdType();
        Context applicationContext = loVar.getContext().getApplicationContext();
        this.f29267e = applicationContext;
        this.C = fr.Code(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(AdContentData adContentData) {
        if (this.S && this.f29275o && this.f29267e != null) {
            gl.V("AdMediator", "reportSplashCostTime");
            this.f29275o = false;
            this.f29263a.Code(c());
            this.f29263a.V(this.f29283w, this.F);
            eo.Code(this.f29267e, this.f29282v, this.f29265c, adContentData, this.f29263a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        adContentData.j();
        Context context = this.f29267e;
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("updateContentOnAdLoad", com.huawei.openalliance.ad.utils.z.V(adContentData), null, null);
        }
    }

    private void Code(int i10, int i11, com.huawei.openalliance.ad.uriaction.q qVar, Long l10, com.huawei.openalliance.ad.inter.data.m mVar, int i12) {
        Code(l10, 1, true);
        kv.Code(this.f29267e, this.B, i10, i11, qVar.I(), i12, mVar, com.huawei.openalliance.ad.utils.b.Code(f()), com.huawei.openalliance.ad.utils.ay.Code(f()));
        if (this.f29286z) {
            gl.V("AdMediator", "onDoActionSucc hasShowFinish");
            return;
        }
        this.f29286z = true;
        com.huawei.openalliance.ad.utils.ax.V(this.f29267e);
        C();
    }

    private void Code(int i10, String str, Long l10) {
        Code(l10, i10, false);
        if (this.f29286z) {
            gl.V("AdMediator", str);
        } else {
            this.f29286z = true;
            com.huawei.openalliance.ad.utils.ax.V(this.f29267e);
        }
    }

    private void Code(Context context, int i10, String str, String str2, AdContentData adContentData) {
        List<String> Code;
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        if (adContentData == null) {
            adContentData = new AdContentData();
        }
        adContentData.d(this.f29265c);
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i10);
        analysisEventReport.I(str);
        analysisEventReport.S(adContentData.az());
        analysisEventReport.F(adContentData.C());
        analysisEventReport.C(adContentData.S());
        analysisEventReport.I(adContentData.aA());
        try {
            analysisEventReport.V(Integer.parseInt(str2));
        } catch (NumberFormatException e2) {
            gl.Code("AdMediator", "setShowMode error%s", e2.getClass().getSimpleName());
        }
        if (a() != null && (Code = a().Code()) != null && !Code.isEmpty()) {
            gl.Code("AdMediator", "setSlotId: %s", Code.get(0));
            analysisEventReport.Z(Code.get(0));
        }
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("rptSplashFailedEvt", com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Context context, AdContentData adContentData, int i10) {
        if (context == null) {
            return;
        }
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i10);
        if (adContentData != null) {
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.C(adContentData.S());
            analysisEventReport.I(adContentData.aA());
        }
        com.huawei.openalliance.ad.ipc.g.V(context).Code("rptStartSpareSplashAd", com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    private void Code(lq lqVar, AdContentData adContentData, lo loVar) {
        if (adContentData == null || lqVar == null || this.f29268h == null) {
            gl.I("AdMediator", "there is no splash ad or adView is null");
            return;
        }
        gl.V("AdMediator", "initOmsdkResource");
        this.f29268h.Code(this.f29267e, adContentData, loVar, true);
        lqVar.Code(this.f29268h);
    }

    private void Code(AdSlotParam adSlotParam, SplashAdReqParam splashAdReqParam) {
        com.huawei.openalliance.ad.utils.f.Code(new AnonymousClass3(adSlotParam, splashAdReqParam), f.a.SPLASH_NET, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final AdContentData adContentData, final int i10) {
        if (adContentData != null) {
            gl.V("AdMediator", "use spare ad");
            this.S = true;
            this.f29282v = adContentData.E();
            this.F = System.currentTimeMillis();
            S(i10);
            adContentData.C(true);
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.hc.5
                @Override // java.lang.Runnable
                public void run() {
                    hc hcVar = hc.this;
                    hcVar.Code(hcVar.f29267e, adContentData, i10);
                }
            });
            I(adContentData);
        }
    }

    private void Code(Long l10, int i10, boolean z10) {
        Code(l10 != null ? Long.valueOf(System.currentTimeMillis() - l10.longValue()) : null, (Integer) 100, Integer.valueOf(i10), z10);
    }

    private void Code(boolean z10) {
        this.f29277q = z10;
    }

    private void F(int i10) {
        if (this.L != null) {
            Code(this.f29267e, i10, this.f29282v, c(), this.L);
            com.huawei.openalliance.ad.inter.listeners.b bVar = this.f29270j;
            if (bVar instanceof com.huawei.openalliance.ad.inter.listeners.k) {
                bVar.Code(-6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i10) {
        if (i10 == -6) {
            Code(this.f29267e, i10, this.f29282v, c(), this.L);
        } else {
            Code(this.f29267e, i10, this.f29282v, c(), this.B);
        }
        B(i10);
    }

    private void S(AdContentData adContentData) {
        if (this.f29268h == null) {
            return;
        }
        if (adContentData != null && adContentData.h() == 9) {
            this.f29268h.Code(jn.Code(0.0f, true, jm.STANDALONE));
        } else if (adContentData != null) {
            if (adContentData.h() == 4 || adContentData.h() == 2) {
                this.f29268h.L();
            }
        }
    }

    private void m() {
        long j10 = this.f29284x;
        if (j10 <= 0) {
            j10 = com.huawei.openalliance.ad.utils.v.Code();
        }
        this.B.Z(j10);
    }

    private void n() {
        CountDownTimer countDownTimer = new CountDownTimer(2000L, 500L) { // from class: com.huawei.hms.ads.hc.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                gl.V("AdMediator", "onFinish");
                hc hcVar = hc.this;
                if (hcVar.Z != b.LOADED) {
                    hcVar.I(-10);
                    hc.this.l();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
                gl.Code("AdMediator", "onTick = %s", Long.valueOf(j10));
            }
        };
        this.f29281u = countDownTimer;
        countDownTimer.start();
    }

    private boolean o() {
        return this.f29277q;
    }

    @Override // com.huawei.hms.ads.hg
    public void B() {
        Code(11, "feedback hasShowFinish", Long.valueOf(this.F));
        lq g3 = g();
        if (g3 != null) {
            g3.D();
        }
    }

    public void B(int i10) {
        this.f29275o = true;
        this.f29263a.I(i10);
        B(this.B);
    }

    public void C() {
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.f29279s;
        if (aVar != null) {
            aVar.V();
        }
        SplashAdDisplayListener splashAdDisplayListener = this.f29280t;
        if (splashAdDisplayListener != null) {
            splashAdDisplayListener.onAdClick();
        }
        com.huawei.openalliance.ad.utils.ax.V(this.f29267e);
    }

    @Override // com.huawei.hms.ads.hg
    public void C(int i10) {
        lo f10 = f();
        if (f10 != null) {
            f10.I(i10);
        }
    }

    public lq Code(AdContentData adContentData, lo loVar) {
        if (adContentData == null) {
            return null;
        }
        lq V = loVar.V(adContentData.h());
        if (V == null) {
            return V;
        }
        V.setAdContent(adContentData);
        V.setAdMediator(this);
        if (adContentData.h() == 2 || adContentData.h() == 4) {
            V.setDisplayDuration((adContentData.am() > 0 ? adContentData.am() : 0) + (adContentData.an() >= 2000 ? adContentData.an() : this.C.V()));
        }
        Code(V, adContentData, loVar);
        return V;
    }

    @Override // com.huawei.hms.ads.hg
    public b Code() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(int i10) {
        this.f29285y = i10;
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(int i10, int i11) {
        lq g3 = g();
        if (g3 != null) {
            g3.Code(i10, i11);
        }
        if (this.f29286z) {
            return;
        }
        this.f29286z = true;
        com.huawei.openalliance.ad.utils.ax.V(this.f29267e);
        kv.Code(this.f29267e, this.B, i10, i11, (List<String>) null);
        Code(Long.valueOf(this.F), 3, false);
        L();
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(long j10) {
        this.f29284x = j10;
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.f29264b = rewardVerifyConfig;
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(SplashAdDisplayListener splashAdDisplayListener) {
        this.f29280t = splashAdDisplayListener;
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(SplashView.SplashAdLoadListener splashAdLoadListener) {
        this.f29271k = splashAdLoadListener;
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(final AdContentData adContentData) {
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.hc.2
            @Override // java.lang.Runnable
            public void run() {
                hc.this.C(adContentData);
            }
        });
        lo f10 = f();
        if (f10 != null) {
            int D = adContentData.D();
            f10.Code(adContentData.D(), adContentData.az() == null);
            f10.V();
            if (adContentData.az() == null) {
                f10.Code(adContentData, this.C.F());
                f10.Code(kt.C(adContentData.r()), kt.S(adContentData.r()), adContentData.aq(), 1 == D, f10.Code(adContentData));
            }
        }
        this.Z = b.LOADED;
        CountDownTimer countDownTimer = this.f29281u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        gl.V("AdMediator", "ad loaded");
        this.F = System.currentTimeMillis();
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.f29270j;
        if (bVar != null) {
            bVar.Code();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.f29271k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdLoaded();
        }
        m();
        D();
        if (!this.C.k()) {
            Code((Long) null, (Integer) null, (Integer) null, false);
        }
        B(200);
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(AdContentData adContentData, long j10, int i10) {
        String str;
        if (!this.C.k()) {
            gl.I("AdMediator", "onAdShowEnd - use old adshow event");
            return;
        }
        gl.V("AdMediator", "onAdShowEnd duration: %d showRatio: %d", Long.valueOf(j10), Integer.valueOf(i10));
        kv.Code(this.f29267e, adContentData, j10, i10);
        if (adContentData != null) {
            MetaData Z = adContentData.Z();
            if (Z != null) {
                if (j10 < Z.C() || i10 < Z.S()) {
                    gl.I("AdMediator", "duration or show ratio is invalid for showId %s", adContentData.B());
                    return;
                } else {
                    Code(Long.valueOf(j10), Integer.valueOf(i10), (Integer) null, false);
                    return;
                }
            }
            str = "onAdShowEnd - metaData is null";
        } else {
            str = "onAdShowEnd - content record is null";
        }
        gl.I("AdMediator", str);
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.f29279s = aVar;
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.f29270j = bVar;
    }

    public void Code(Long l10, Integer num, Integer num2, boolean z10) {
        if (o()) {
            gl.I("AdMediator", "show event already reported before, ignore this");
            return;
        }
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.f29279s;
        if (aVar != null) {
            aVar.Code();
        }
        SplashAdDisplayListener splashAdDisplayListener = this.f29280t;
        if (splashAdDisplayListener != null) {
            splashAdDisplayListener.onAdShowed();
        }
        io ioVar = this.f29268h;
        if (ioVar != null) {
            ioVar.D();
        }
        Code(true);
        ku.a aVar2 = new ku.a();
        if (z10) {
            aVar2.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar2.Code(l10).Code(num).V(num2).Code(com.huawei.openalliance.ad.utils.b.Code(f()));
        kv.Code(this.f29267e, this.B, aVar2.Code());
    }

    @Override // com.huawei.hms.ads.hg
    public boolean Code(int i10, int i11, AdContentData adContentData, Long l10, com.huawei.openalliance.ad.inter.data.m mVar, int i12) {
        boolean z10;
        gl.V("AdMediator", "onTouch");
        Context context = f() instanceof View ? ((View) f()).getContext() : this.f29267e;
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(context, adContentData, new HashMap(0));
        if (Code instanceof com.huawei.openalliance.ad.uriaction.e) {
            Code.Code(new le() { // from class: com.huawei.hms.ads.hc.8
            });
        }
        if (Code.Code()) {
            if (18 == i12 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(R.anim.hiad_open, R.anim.hiad_close);
            }
            Code(i10, i11, Code, l10, mVar, i12);
            z10 = true;
        } else {
            z10 = false;
        }
        com.huawei.openalliance.ad.inter.d.Code(this.f29267e).Code(false);
        return z10;
    }

    @Override // com.huawei.hms.ads.hg
    public void D() {
        if (this.f29278r) {
            return;
        }
        this.f29278r = true;
        kv.Code(this.f29267e, this.B);
        io ioVar = this.f29268h;
        if (ioVar != null) {
            ioVar.L();
        }
    }

    public void F() {
        Context context = this.f29267e;
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("resetDisplayDateAndCount", null, null, null);
        }
    }

    public int I() {
        return this.f29285y;
    }

    @Override // com.huawei.hms.ads.hg
    public void I(int i10) {
        gl.V("AdMediator", "ad failed:" + i10);
        if (this.f29274n) {
            gl.V("AdMediator", "ad is already failed");
            return;
        }
        this.f29274n = true;
        this.F = System.currentTimeMillis();
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.f29270j;
        if (bVar != null) {
            bVar.Code(i10);
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.f29271k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdFailedToLoad(dx.Code(i10));
        }
        com.huawei.openalliance.ad.utils.ax.V(this.f29267e);
        S(i10);
    }

    public abstract void I(AdContentData adContentData);

    @Override // com.huawei.hms.ads.hg
    public void L() {
        gl.V("AdMediator", "notifyAdDismissed");
        if (this.f29273m) {
            gl.V("AdMediator", "ad already dismissed");
            return;
        }
        this.f29273m = true;
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.f29270j;
        if (bVar != null) {
            bVar.V();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.f29271k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdDismissed();
        }
        AdContentData adContentData = this.B;
        if (adContentData != null && adContentData.aA() != 3) {
            ky.Code(this.f29267e).Code(this.B, -10);
        }
        lq g3 = g();
        if (g3 != null) {
            g3.destroyView();
        }
    }

    @Override // com.huawei.hms.ads.hg
    public void S() {
        this.f29263a.I(this.f29283w, System.currentTimeMillis());
    }

    public com.huawei.openalliance.ad.inter.listeners.b V() {
        return this.f29270j;
    }

    @Override // com.huawei.hms.ads.hg
    public void V(int i10) {
        Context context;
        gl.V("AdMediator", "toShowSpare");
        if (!this.B.al() && (context = this.f29267e) != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("getSpareSplashAd", String.valueOf(this.C.I()), new AnonymousClass1(i10), String.class);
        } else {
            I(i10);
            l();
        }
    }

    @Override // com.huawei.hms.ads.hg
    public void V(long j10) {
        this.f29283w = j10;
    }

    public boolean V(AdContentData adContentData) {
        gl.V("AdMediator", "showAdContent");
        if (this.f29264b != null) {
            gl.V("AdMediator", "set verifyConfig.");
            adContentData.p(this.f29264b.getData());
            adContentData.q(this.f29264b.getUserId());
        }
        this.D = true;
        lo f10 = f();
        if (f10 == null) {
            return false;
        }
        gl.V("AdMediator", "showAdContent, getTemplateIdV3 = %s", adContentData.az());
        if (adContentData.az() == null) {
            this.I = null;
            lq Code = Code(adContentData, f10);
            if (Code == null) {
                return false;
            }
            io ioVar = this.f29268h;
            if (ioVar != null) {
                ioVar.Z();
            }
            S(adContentData);
            f10.Code(Code, f10.Code(adContentData));
            Code.V();
            this.I = new WeakReference<>(Code);
        } else {
            if (!(f10 instanceof PPSSplashView)) {
                gl.I("AdMediator", "not PPSSplashView");
                return false;
            }
            IRemoteCreator Code2 = f.Code(this.f29267e);
            if (Code2 == null) {
                gl.V("AdMediator", "Creator is null");
                return false;
            }
            dv dvVar = new dv(f10.getContext(), this, adContentData);
            Bundle bundle = new Bundle();
            bundle.putInt("audioFocusType", f10.getAudioFocusType());
            PPSSplashView pPSSplashView = (PPSSplashView) f10;
            bundle.putInt(bg.e.S, pPSSplashView.getMediaNameResId());
            bundle.putInt(bg.e.C, pPSSplashView.getLogoResId());
            bundle.putString("content", this.f29266d);
            AdSlotParam a10 = a();
            if (a10 != null) {
                bundle.putInt("orientation", a10.V());
                bundle.putInt(bg.e.B, a10.f() != null ? a10.f().intValue() : 1);
            }
            try {
                View view = (View) ObjectWrapper.unwrap(Code2.newSplashTemplateView(bundle, dvVar));
                if (view == null) {
                    gl.I("AdMediator", "templateView is null;");
                    return false;
                }
                this.f29268h = null;
                f10.Code(view);
                Code2.bindData(ObjectWrapper.wrap(view), this.f29266d);
                n();
            } catch (Throwable th) {
                gl.I("AdMediator", "create splashTemplateView err: %s", th.getClass().getSimpleName());
                return false;
            }
        }
        return true;
    }

    @Override // com.huawei.hms.ads.hg
    public void Z() {
        Code(10, "onWhyThisAd hasShowFinish", Long.valueOf(this.F));
        lq g3 = g();
        if (g3 != null) {
            g3.F();
        }
    }

    public void Z(int i10) {
        F(i10);
    }

    @Override // com.huawei.hms.ads.hg
    public void Z(AdContentData adContentData) {
        final String jSONObject;
        if (adContentData == null) {
            return;
        }
        try {
            if (!com.huawei.openalliance.ad.utils.v.I() && !com.huawei.openalliance.ad.utils.v.L(this.f29267e)) {
                jSONObject = adContentData.S();
                com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.hc.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.hc.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.huawei.openalliance.ad.ipc.g.V(hc.this.f29267e).Code(com.huawei.openalliance.ad.constant.q.f32335r, jSONObject, null, null);
                            }
                        });
                    }
                });
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("content_id", adContentData.S());
            jSONObject2.put("templateId", adContentData.az());
            jSONObject2.put("slotid", adContentData.C());
            jSONObject2.put("apiVer", adContentData.aA());
            jSONObject = jSONObject2.toString();
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.hc.7
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.hc.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.huawei.openalliance.ad.ipc.g.V(hc.this.f29267e).Code(com.huawei.openalliance.ad.constant.q.f32335r, jSONObject, null, null);
                        }
                    });
                }
            });
        } catch (Throwable th) {
            gl.V("AdMediator", "onMaterialLoadFailed err: %s", th.getClass().getSimpleName());
        }
    }

    public AdSlotParam a() {
        lo f10 = f();
        if (f10 == null) {
            return null;
        }
        AdSlotParam adSlotParam = f10.getAdSlotParam();
        if (adSlotParam != null) {
            this.f29263a.Code(adSlotParam.Code());
        }
        return adSlotParam;
    }

    public void b() {
        AdSlotParam a10 = a();
        if (a10 == null) {
            I((AdContentData) null);
            return;
        }
        Context context = this.f29267e;
        a10.I(context != null ? com.huawei.openalliance.ad.inter.g.Code(context).I() : null);
        SplashAdReqParam splashAdReqParam = new SplashAdReqParam();
        splashAdReqParam.Code(c());
        splashAdReqParam.Code(this.f29283w);
        String B = com.huawei.openalliance.ad.utils.v.B();
        this.f29282v = B;
        a10.V(B);
        a10.Code(this.f29265c);
        Code(a10, splashAdReqParam);
    }

    public abstract String c();

    public void d() {
        int a10 = this.C.a();
        gl.V("AdMediator", "startAdLoadTimeoutTask - max load time: %d", Integer.valueOf(a10));
        com.huawei.openalliance.ad.utils.ba.Code(new AnonymousClass4(), this.f29276p, a10);
    }

    public void e() {
        L();
    }

    public lo f() {
        return this.f29269i.get();
    }

    public lq g() {
        WeakReference<lq> weakReference = this.I;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.ads.hg
    public void i() {
        gl.V("AdMediator", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.f29286z));
        if (this.f29286z) {
            return;
        }
        this.f29286z = true;
        com.huawei.openalliance.ad.utils.ax.V(this.f29267e);
        L();
    }

    @Override // com.huawei.hms.ads.hg
    public String j() {
        AdContentData adContentData = this.B;
        if (adContentData != null) {
            return adContentData.T();
        }
        return null;
    }
}
