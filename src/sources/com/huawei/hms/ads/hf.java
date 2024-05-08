package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hf extends hc {

    /* renamed from: f, reason: collision with root package name */
    public boolean f29287f;

    /* renamed from: h, reason: collision with root package name */
    private final int f29288h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f29289i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f29290j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f29291k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f29292l;

    public hf(lo loVar) {
        super(loVar);
        this.f29288h = hashCode();
        this.f29289i = false;
        this.f29290j = false;
        this.f29287f = false;
        this.f29291k = false;
        this.f29292l = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Context context;
        gl.V("RealtimeAdMediator", "doOnShowSloganEnd");
        this.f29290j = true;
        if (this.f29291k) {
            gl.V("RealtimeAdMediator", "Ad fails to display or loading timeout, ad dismiss");
            I(499);
            L();
        } else {
            if (this.f29287f) {
                return;
            }
            gl.V(n(), "doOnShowSloganEnd Ad has been loaded, but not shown yet");
            if (this.f29292l && (context = this.f29267e) != null) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code("getNormalSplashAd", String.valueOf(this.C.I()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.hf.3
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.hf.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                hf.this.B = (AdContentData) callResult.getData();
                                hf hfVar = hf.this;
                                AdContentData adContentData = hfVar.B;
                                String n10 = hfVar.n();
                                if (adContentData == null) {
                                    gl.V(n10, "linked loaded, do not call play");
                                    hf.this.I(-6);
                                    hf.this.L();
                                } else {
                                    gl.V(n10, "linked loaded, display normal when slogan ends");
                                    hf hfVar2 = hf.this;
                                    hfVar2.I(hfVar2.B);
                                    hf.this.Z(1202);
                                }
                            }
                        });
                    }
                }, AdContentData.class);
            } else if (this.B != null) {
                gl.V(n(), "show splash");
                I(this.B);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        AdContentData adContentData;
        gl.V("RealtimeAdMediator", "doOnReachMinSloganShowTime");
        this.f29289i = true;
        if (!this.f29287f && (adContentData = this.B) != null) {
            I(adContentData);
            return;
        }
        gl.V("RealtimeAdMediator", "doOnReachMinSloganShowTime adFailToDisplay: %s", Boolean.valueOf(this.f29291k));
        if (this.f29291k) {
            gl.V("RealtimeAdMediator", "ad fail to load when reach min slogan show time");
            I(499);
            L();
        }
    }

    @Override // com.huawei.hms.ads.hc
    public void I(AdContentData adContentData) {
        gl.V("RealtimeAdMediator", "on content loaded");
        this.B = adContentData;
        if (adContentData == null) {
            I(494);
            l();
            return;
        }
        lo f10 = f();
        if (f10 == null) {
            I(com.huawei.openalliance.ad.constant.ad.f32210w);
            l();
            return;
        }
        es esVar = new es(f10.getContext());
        if (esVar.Code()) {
            I(496);
            l();
            return;
        }
        if (this.B.h() != 12) {
            if (!this.f29289i && !this.f29290j) {
                gl.V("RealtimeAdMediator", "slogan hasn't reach min show time or end, show ad later");
                return;
            }
            if (esVar.Code()) {
                I(496);
                l();
                return;
            }
            boolean V = V(this.B);
            this.f29287f = true;
            if (V) {
                return;
            }
            V(com.huawei.openalliance.ad.constant.ad.f32210w);
            return;
        }
        if (I() == 1 && (V() instanceof com.huawei.openalliance.ad.inter.listeners.k)) {
            gl.V("RealtimeAdMediator", "on linked loaded, sloganShowEnd:" + this.f29290j);
            if (!this.f29290j) {
                com.huawei.openalliance.ad.inter.listeners.k kVar = (com.huawei.openalliance.ad.inter.listeners.k) V();
                com.huawei.openalliance.ad.inter.data.l Code = kw.Code(this.B);
                if (Code != null) {
                    gl.V(n(), "on content loaded, linkedAd loaded. ");
                    this.F = System.currentTimeMillis();
                    kVar.Code(Code);
                    this.L = this.B;
                    this.f29292l = true;
                    B(200);
                    return;
                }
            }
        }
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.hf.4
            @Override // java.lang.Runnable
            public void run() {
                hf.this.I(1200);
                hf.this.l();
            }
        });
    }

    @Override // com.huawei.hms.ads.hc
    public String c() {
        return String.valueOf(2);
    }

    @Override // com.huawei.hms.ads.hg
    public void k() {
        gl.V("RealtimeAdMediator", "start");
        lo f10 = f();
        if (f10 == null) {
            I(-4);
            L();
        } else {
            b();
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.F();
                }
            });
            f10.Code(new mb() { // from class: com.huawei.hms.ads.hf.2
                @Override // com.huawei.hms.ads.mb
                public void Code() {
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.hf.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hf.this.p();
                        }
                    });
                }

                @Override // com.huawei.hms.ads.mb
                public void V() {
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.hf.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            hf.this.o();
                        }
                    });
                }
            });
            d();
        }
    }

    @Override // com.huawei.hms.ads.hg
    public void l() {
        gl.V("RealtimeAdMediator", "onAdFailToDisplay - reachMinSloganShowTime: %s sloganShowEnd: %s", Boolean.valueOf(this.f29289i), Boolean.valueOf(this.f29290j));
        this.f29291k = true;
        if (this.f29289i || this.f29290j) {
            L();
        }
    }

    public String n() {
        return "RealtimeAdMediator" + this.f29288h;
    }
}
