package com.bytedance.sdk.openadsdk.ej.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej implements ComplianceInfo {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11185m;

    public ej(Bridge bridge) {
        this.f11185m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppName() {
        return (String) this.f11185m.values().objectValue(250001, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppVersion() {
        return (String) this.f11185m.values().objectValue(250002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getDeveloperName() {
        return (String) this.f11185m.values().objectValue(250003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getFunctionDescUrl() {
        return (String) this.f11185m.values().objectValue(250007, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPermissionUrl() {
        return (String) this.f11185m.values().objectValue(250005, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.f11185m.values().objectValue(250006, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPrivacyUrl() {
        return (String) this.f11185m.values().objectValue(250004, String.class);
    }
}
