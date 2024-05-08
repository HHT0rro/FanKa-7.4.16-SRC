package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TTAdConfig extends CSJConfig {

    /* renamed from: m, reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f11064m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {
        private CSJConfig.m dk = new CSJConfig.m();

        /* renamed from: m, reason: collision with root package name */
        private ITTLiveTokenInjectionAuth f11065m;

        public Builder allowShowNotify(boolean z10) {
            this.dk.dk(z10);
            return this;
        }

        public Builder appId(String str) {
            this.dk.m(str);
            return this;
        }

        public Builder appName(String str) {
            this.dk.dk(str);
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig(this.dk);
            tTAdConfig.setInjectionAuth(this.f11065m);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.dk.m(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.dk.l(str);
            return this;
        }

        public Builder debug(boolean z10) {
            this.dk.ej(z10);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.dk.m(iArr);
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.f11065m = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.dk.ej(str);
            return this;
        }

        public Builder paid(boolean z10) {
            this.dk.m(z10);
            return this;
        }

        public Builder setAgeGroup(int i10) {
            this.dk.l(i10);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.dk.m(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i10) {
            this.dk.ej(i10);
            return this;
        }

        public Builder supportMultiProcess(boolean z10) {
            this.dk.np(z10);
            return this;
        }

        public Builder themeStatus(int i10) {
            this.dk.dk(i10);
            return this;
        }

        public Builder titleBarTheme(int i10) {
            this.dk.m(i10);
            return this;
        }

        public Builder useMediation(boolean z10) {
            this.dk.n(z10);
            return this;
        }

        public Builder useTextureView(boolean z10) {
            this.dk.l(z10);
            return this;
        }
    }

    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.f11064m;
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f11064m = iTTLiveTokenInjectionAuth;
    }

    private TTAdConfig(CSJConfig.m mVar) {
        super(mVar);
    }
}
