package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.inter.data.IInterstitialAd;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.reward.OnMetadataChangedListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class z {
    private String B;
    private OnMetadataChangedListener C;
    private Bundle D;
    private Context I;
    private String L;
    private RewardAdListener S;
    private AdListener Z;

    /* renamed from: a, reason: collision with root package name */
    private long f29538a;

    /* renamed from: b, reason: collision with root package name */
    private long f29539b;

    /* renamed from: c, reason: collision with root package name */
    private long f29540c;

    /* renamed from: d, reason: collision with root package name */
    private App f29541d;

    /* renamed from: g, reason: collision with root package name */
    private RewardVerifyConfig f29544g;

    /* renamed from: h, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.listeners.h f29545h;

    /* renamed from: i, reason: collision with root package name */
    private Integer f29546i;
    private a V = a.IDLE;

    /* renamed from: e, reason: collision with root package name */
    private List<IInterstitialAd> f29542e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private IInterstitialAd f29543f = null;

    /* renamed from: j, reason: collision with root package name */
    private IInterstitialAdStatusListener f29547j = new IInterstitialAdStatusListener() { // from class: com.huawei.hms.ads.z.1
        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClicked() {
            if (z.this.Z != null) {
                z.this.Z.onAdClicked();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClosed() {
            if (z.this.Z != null) {
                z.this.Z.onAdClosed();
            }
            if (z.this.S != null) {
                z.this.S.onRewardAdClosed();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdCompleted() {
            if (z.this.S != null) {
                z.this.S.onRewardAdCompleted();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdError(int i10, int i11) {
            if (z.this.Z != null) {
                z.this.Z.onAdFailed(dx.Code(i10));
            }
            if (z.this.S != null) {
                z.this.S.onRewardAdFailedToLoad(dx.Code(i10));
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdShown() {
            if (z.this.Z != null) {
                z.this.Z.onAdOpened();
            }
            if (z.this.S != null) {
                z.this.S.onRewardAdOpened();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onLeftApp() {
            if (z.this.Z != null) {
                z.this.Z.onAdLeave();
            }
            if (z.this.S != null) {
                z.this.S.onRewardAdLeftApp();
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onRewarded() {
            if (z.this.S != null) {
                z.this.S.onRewarded(new by(z.this.f29543f.B()));
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private INonwifiActionListener f29548k = new INonwifiActionListener() { // from class: com.huawei.hms.ads.z.2
        @Override // com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener
        public boolean Code(long j10) {
            return false;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener
        public boolean Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, long j10) {
            return false;
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        IDLE,
        LOADING
    }

    public z(Context context) {
        this.I = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i10) {
        gl.V("InterstitialAdManager", "onAdFailed, errorCode:" + i10);
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.z.4
            @Override // java.lang.Runnable
            public void run() {
                z.this.f29539b = System.currentTimeMillis();
                if (z.this.Z != null) {
                    z.this.Z.onAdFailed(dx.Code(i10));
                }
                if (z.this.f29545h != null) {
                    z.this.f29545h.Code(i10);
                }
                if (z.this.S != null) {
                    z.this.S.onRewardAdFailedToLoad(dx.Code(i10));
                }
                eo.Code(z.this.I, i10, z.this.L, 12, null, z.this.f29538a, z.this.f29539b, z.this.f29540c);
            }
        });
    }

    private void Code(Context context) {
        for (IInterstitialAd iInterstitialAd : this.f29542e) {
            if (iInterstitialAd != null && !iInterstitialAd.Z()) {
                this.f29543f = iInterstitialAd;
                iInterstitialAd.Code(this.f29544g);
                iInterstitialAd.setRewardAdListener(this.S);
                iInterstitialAd.setNonwifiActionListener(this.f29548k);
                iInterstitialAd.show(context, this.f29547j);
                return;
            }
        }
    }

    private void Code(AdParam adParam, AdSlotParam.a aVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.B);
        aVar.Code(arrayList).V(com.huawei.openalliance.ad.utils.l.I(this.I)).Code(this.I.getResources().getConfiguration().orientation != 1 ? 0 : 1).I(c.Z(this.I)).Z(c.B(this.I));
        Integer num = this.f29546i;
        if (num != null) {
            aVar.S(num);
        }
        if (adParam != null) {
            RequestOptions Code = dy.Code(adParam.V());
            App app = Code.getApp();
            if (app != null) {
                this.f29541d = app;
            }
            aVar.Code(Code).S(adParam.getGender()).V(adParam.getTargetingContentUrl()).Code(adParam.getKeywords()).Code(this.f29541d).I(adParam.I()).C(adParam.C());
            if (adParam.Code() != null) {
                aVar.Code(adParam.Code());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<IInterstitialAd>> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append((Object) (map != null ? Integer.valueOf(map.size()) : null));
        gl.V("InterstitialAdManager", sb2.toString());
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.z.5
            @Override // java.lang.Runnable
            public void run() {
                z.this.f29539b = System.currentTimeMillis();
                if (z.this.Z != null) {
                    z.this.Z.onAdLoaded();
                }
                if (z.this.S != null) {
                    z.this.S.onRewardAdLoaded();
                }
                eo.Code(z.this.I, 200, z.this.L, 12, map, z.this.f29538a, z.this.f29539b, z.this.f29540c);
            }
        });
    }

    private boolean F() {
        if (!com.huawei.openalliance.ad.utils.v.Code(this.I)) {
            AdListener adListener = this.Z;
            if (adListener != null) {
                adListener.onAdFailed(5);
            }
            RewardAdListener rewardAdListener = this.S;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdFailedToLoad(5);
            }
            return false;
        }
        if (this.V == a.LOADING) {
            gl.V("InterstitialAdManager", "waiting for request finish");
            AdListener adListener2 = this.Z;
            if (adListener2 != null) {
                adListener2.onAdFailed(4);
            }
            RewardAdListener rewardAdListener2 = this.S;
            if (rewardAdListener2 != null) {
                rewardAdListener2.onRewardAdFailedToLoad(4);
            }
            return false;
        }
        if (!TextUtils.isEmpty(this.B)) {
            return true;
        }
        gl.I("InterstitialAdManager", "empty ad ids");
        AdListener adListener3 = this.Z;
        if (adListener3 != null) {
            adListener3.onAdFailed(1);
        }
        RewardAdListener rewardAdListener3 = this.S;
        if (rewardAdListener3 != null) {
            rewardAdListener3.onRewardAdFailedToLoad(1);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Map<String, List<IInterstitialAd>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (List<IInterstitialAd> list : map.values()) {
            if (!aa.Code(list)) {
                for (IInterstitialAd iInterstitialAd : list) {
                    if (iInterstitialAd.f() || !iInterstitialAd.V()) {
                        gl.V("InterstitialAdManager", "ad is invalid, content id:" + iInterstitialAd.D());
                    } else {
                        this.f29542e.add(iInterstitialAd);
                    }
                }
            }
        }
        OnMetadataChangedListener onMetadataChangedListener = this.C;
        if (onMetadataChangedListener != null) {
            onMetadataChangedListener.onMetadataChanged();
        }
    }

    public final Bundle C() {
        Bundle bundle = this.D;
        return bundle == null ? new Bundle() : bundle;
    }

    public final AdListener Code() {
        return this.Z;
    }

    public final void Code(Activity activity) {
        gl.V("InterstitialAdManager", "show activity");
        Code((Context) activity);
    }

    public final void Code(AdListener adListener) {
        this.Z = adListener;
    }

    public final void Code(AdParam adParam) {
        this.f29538a = System.currentTimeMillis();
        gl.V("InterstitialAdManager", com.huawei.openalliance.ad.constant.g.Code);
        if (F()) {
            AdSlotParam.a aVar = new AdSlotParam.a();
            Code(adParam, aVar);
            if (this.f29541d != null && !com.huawei.openalliance.ad.utils.v.I(this.I)) {
                gl.I("InterstitialAdManager", "hms ver not support set appInfo.");
                Code(706);
                return;
            }
            com.huawei.openalliance.ad.utils.ac.Code(this.I.getApplicationContext(), aVar.V());
            this.V = a.LOADING;
            this.f29542e.clear();
            BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
            baseAdReqParam.Code(this.f29538a);
            kr.Code(this.I, "interstitial_ad_load", aVar.S(), com.huawei.openalliance.ad.utils.z.V(baseAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.z.3
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    z zVar;
                    int code;
                    z.this.f29540c = System.currentTimeMillis();
                    if (callResult.getCode() == 200) {
                        Map<String, List<AdContentData>> map = (Map) com.huawei.openalliance.ad.utils.z.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                        if (z.this.f29545h != null) {
                            z.this.f29545h.Code(map);
                        }
                        code = 204;
                        if (map != null && map.size() > 0) {
                            HashMap hashMap = new HashMap(map.size());
                            for (Map.Entry<String, List<AdContentData>> entry : map.entrySet()) {
                                String key = entry.getKey();
                                List<AdContentData> value = entry.getValue();
                                if (value != null) {
                                    ArrayList arrayList = new ArrayList(value.size());
                                    for (AdContentData adContentData : value) {
                                        if (z.this.L == null) {
                                            z.this.L = adContentData.E();
                                        }
                                        arrayList.add(new com.huawei.hms.ads.inter.data.a(adContentData));
                                    }
                                    hashMap.put(key, arrayList);
                                }
                            }
                            if (!com.huawei.openalliance.ad.utils.af.Code(hashMap)) {
                                z.this.V(hashMap);
                                if (!aa.Code(z.this.f29542e)) {
                                    z.this.Code(hashMap);
                                    z.this.V = a.IDLE;
                                }
                            }
                        }
                        zVar = z.this;
                    } else {
                        zVar = z.this;
                        code = callResult.getCode();
                    }
                    zVar.Code(code);
                    z.this.V = a.IDLE;
                }
            }, String.class);
        }
    }

    public final void Code(OnMetadataChangedListener onMetadataChangedListener) {
        if (this.C != null) {
            gl.V("InterstitialAdManager", "Update ad metadata listener.");
        }
        this.C = onMetadataChangedListener;
    }

    public final void Code(RewardAdListener rewardAdListener) {
        if (this.S != null) {
            gl.V("InterstitialAdManager", "Update rewarded video listener.");
        }
        this.S = rewardAdListener;
    }

    public final void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.f29544g = rewardVerifyConfig;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.h hVar) {
        this.f29545h = hVar;
    }

    public void Code(Integer num) {
        this.f29546i = num;
    }

    public final void Code(String str) {
        this.B = str;
    }

    public final boolean I() {
        if (aa.Code(this.f29542e)) {
            return false;
        }
        for (IInterstitialAd iInterstitialAd : this.f29542e) {
            if (iInterstitialAd != null && !iInterstitialAd.Z()) {
                return true;
            }
        }
        return false;
    }

    public final void S() {
        gl.V("InterstitialAdManager", "show");
        Code(this.I);
    }

    public final String V() {
        return this.B;
    }

    public final boolean Z() {
        return this.V == a.LOADING;
    }
}
