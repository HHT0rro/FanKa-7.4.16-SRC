package com.bytedance.sdk.openadsdk.mediation.manager.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements MediationAdLoadInfo {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11399m;

    public dk(Bridge bridge) {
        this.f11399m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdType() {
        return (String) this.f11399m.values().objectValue(271003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdnName() {
        return (String) this.f11399m.values().objectValue(271002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public int getErrCode() {
        return this.f11399m.values().intValue(271004);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getErrMsg() {
        return (String) this.f11399m.values().objectValue(271005, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getMediationRit() {
        return (String) this.f11399m.values().objectValue(271001, String.class);
    }
}
