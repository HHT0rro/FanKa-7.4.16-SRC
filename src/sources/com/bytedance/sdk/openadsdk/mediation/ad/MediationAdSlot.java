package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationAdSlot implements IMediationAdSlot {

    /* renamed from: c, reason: collision with root package name */
    private boolean f11243c;
    private boolean dk;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Object> f11244e;
    private String ej;

    /* renamed from: hc, reason: collision with root package name */
    private boolean f11245hc;

    /* renamed from: k, reason: collision with root package name */
    private MediationSplashRequestInfo f11246k;

    /* renamed from: l, reason: collision with root package name */
    private int f11247l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11248m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f11249n;
    private float np;

    /* renamed from: oa, reason: collision with root package name */
    private String f11250oa;

    /* renamed from: q, reason: collision with root package name */
    private String f11251q;

    /* renamed from: r, reason: collision with root package name */
    private float f11252r;
    private float sy;
    private MediationNativeToBannerListener ve;

    /* renamed from: w, reason: collision with root package name */
    private boolean f11253w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {

        /* renamed from: c, reason: collision with root package name */
        private boolean f11254c;
        private boolean dk;

        /* renamed from: e, reason: collision with root package name */
        private String f11255e;
        private boolean ej;

        /* renamed from: hc, reason: collision with root package name */
        private boolean f11256hc;

        /* renamed from: k, reason: collision with root package name */
        private MediationSplashRequestInfo f11257k;

        /* renamed from: l, reason: collision with root package name */
        private float f11258l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f11259m;
        private boolean np;

        /* renamed from: oa, reason: collision with root package name */
        private int f11261oa;

        /* renamed from: q, reason: collision with root package name */
        private String f11262q;
        private MediationNativeToBannerListener ve;

        /* renamed from: n, reason: collision with root package name */
        private Map<String, Object> f11260n = new HashMap();

        /* renamed from: w, reason: collision with root package name */
        private String f11264w = "";
        private float sy = 80.0f;

        /* renamed from: r, reason: collision with root package name */
        private float f11263r = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.f11248m = this.f11259m;
            mediationAdSlot.dk = this.dk;
            mediationAdSlot.f11245hc = this.ej;
            mediationAdSlot.np = this.f11258l;
            mediationAdSlot.f11249n = this.np;
            mediationAdSlot.f11244e = this.f11260n;
            mediationAdSlot.f11253w = this.f11256hc;
            mediationAdSlot.f11250oa = this.f11255e;
            mediationAdSlot.ej = this.f11264w;
            mediationAdSlot.f11247l = this.f11261oa;
            mediationAdSlot.f11243c = this.f11254c;
            mediationAdSlot.ve = this.ve;
            mediationAdSlot.sy = this.sy;
            mediationAdSlot.f11252r = this.f11263r;
            mediationAdSlot.f11251q = this.f11262q;
            mediationAdSlot.f11246k = this.f11257k;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z10) {
            this.f11254c = z10;
            return this;
        }

        public Builder setBidNotify(boolean z10) {
            this.f11256hc = z10;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f11260n;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.ve = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.f11257k = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z10) {
            this.ej = z10;
            return this;
        }

        public Builder setRewardAmount(int i10) {
            this.f11261oa = i10;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f11264w = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.f11255e = str;
            return this;
        }

        public Builder setShakeViewSize(float f10, float f11) {
            this.sy = f10;
            this.f11263r = f11;
            return this;
        }

        public Builder setSplashPreLoad(boolean z10) {
            this.dk = z10;
            return this;
        }

        public Builder setSplashShakeButton(boolean z10) {
            this.f11259m = z10;
            return this;
        }

        public Builder setUseSurfaceView(boolean z10) {
            this.np = z10;
            return this;
        }

        public Builder setVolume(float f10) {
            this.f11258l = f10;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.f11262q = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.f11244e;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.f11247l;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.ej;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.f11250oa;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.f11252r;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.sy;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.np;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.f11251q;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.f11243c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.f11253w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.f11245hc;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.dk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.f11248m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.f11249n;
    }

    private MediationAdSlot() {
        this.ej = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.ve;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.f11246k;
    }
}
