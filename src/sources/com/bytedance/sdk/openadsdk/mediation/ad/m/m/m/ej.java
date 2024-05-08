package com.bytedance.sdk.openadsdk.mediation.ad.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej extends MediationNativeAdAppInfo {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11289m;

    public ej(Bridge bridge) {
        this.f11289m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, Object> getAppInfoExtra() {
        return (Map) this.f11289m.call(271042, a.c(0).a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAppName() {
        return (String) this.f11289m.call(271035, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAuthorName() {
        return (String) this.f11289m.call(271036, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public long getPackageSizeBytes() {
        return ((Long) this.f11289m.call(271037, a.c(0).a(), Long.TYPE)).longValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.f11289m.call(271039, a.c(0).a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPermissionsUrl() {
        return (String) this.f11289m.call(271038, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPrivacyAgreement() {
        return (String) this.f11289m.call(271040, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getVersionName() {
        return (String) this.f11289m.call(271041, a.c(0).a(), String.class);
    }
}
