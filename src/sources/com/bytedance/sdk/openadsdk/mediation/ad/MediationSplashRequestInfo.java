package com.bytedance.sdk.openadsdk.mediation.ad;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {
    private String dk;
    private String ej;

    /* renamed from: l, reason: collision with root package name */
    private String f11270l;

    /* renamed from: m, reason: collision with root package name */
    private String f11271m;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.f11271m = str;
        this.dk = str2;
        this.ej = str3;
        this.f11270l = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnName() {
        return this.f11271m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnSlotId() {
        return this.dk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppId() {
        return this.ej;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppkey() {
        return this.f11270l;
    }
}
