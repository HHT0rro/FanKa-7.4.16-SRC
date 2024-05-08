package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationConfig implements IMediationConfig {

    /* renamed from: c, reason: collision with root package name */
    private String f11334c;
    private boolean dk;

    /* renamed from: e, reason: collision with root package name */
    private String f11335e;
    private MediationConfigUserInfoForSegment ej;

    /* renamed from: hc, reason: collision with root package name */
    private boolean f11336hc;

    /* renamed from: l, reason: collision with root package name */
    private Map<String, Object> f11337l;

    /* renamed from: m, reason: collision with root package name */
    private String f11338m;

    /* renamed from: n, reason: collision with root package name */
    private JSONObject f11339n;
    private boolean np;

    /* renamed from: oa, reason: collision with root package name */
    private boolean f11340oa;

    /* renamed from: w, reason: collision with root package name */
    private boolean f11341w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {

        /* renamed from: c, reason: collision with root package name */
        private String f11342c;
        private boolean dk;

        /* renamed from: e, reason: collision with root package name */
        private String f11343e;
        private MediationConfigUserInfoForSegment ej;

        /* renamed from: hc, reason: collision with root package name */
        private boolean f11344hc;

        /* renamed from: l, reason: collision with root package name */
        private Map<String, Object> f11345l;

        /* renamed from: m, reason: collision with root package name */
        private String f11346m;

        /* renamed from: n, reason: collision with root package name */
        private JSONObject f11347n;
        private boolean np;

        /* renamed from: oa, reason: collision with root package name */
        private boolean f11348oa;

        /* renamed from: w, reason: collision with root package name */
        private boolean f11349w;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.f11338m = this.f11346m;
            mediationConfig.dk = this.dk;
            mediationConfig.ej = this.ej;
            mediationConfig.f11337l = this.f11345l;
            mediationConfig.np = this.np;
            mediationConfig.f11339n = this.f11347n;
            mediationConfig.f11336hc = this.f11344hc;
            mediationConfig.f11335e = this.f11343e;
            mediationConfig.f11341w = this.f11349w;
            mediationConfig.f11340oa = this.f11348oa;
            mediationConfig.f11334c = this.f11342c;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f11347n = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z10) {
            this.np = z10;
            return this;
        }

        public Builder setLocalExtra(Map<String, Object> map) {
            this.f11345l = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.ej = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z10) {
            this.dk = z10;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.f11343e = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f11346m = str;
            return this;
        }

        public Builder setSupportH265(boolean z10) {
            this.f11349w = z10;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z10) {
            this.f11348oa = z10;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.f11342c = str;
            return this;
        }

        public Builder setWxInstalled(boolean z10) {
            this.f11344hc = z10;
            return this;
        }
    }

    private MediationConfig() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.f11339n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.np;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.f11337l;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.ej;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.f11335e;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.f11338m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.dk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.f11341w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.f11340oa;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.f11336hc;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.f11334c;
    }
}
