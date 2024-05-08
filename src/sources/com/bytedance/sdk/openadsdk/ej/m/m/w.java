package com.bytedance.sdk.openadsdk.ej.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class w extends TTCustomController implements Bridge {
    private TTCustomController dk;

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11204m;

    public w(Bridge bridge) {
        this.f11204m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        return ((Boolean) this.f11204m.call(262103, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTCustomController tTCustomController = this.dk;
        if (tTCustomController == null) {
            return null;
        }
        switch (i10) {
            case 262101:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseLocation()));
            case 262102:
                return (T) tTCustomController.getTTLocation();
            case 262103:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.alist()));
            case 262104:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUsePhoneState()));
            case 262105:
                return (T) tTCustomController.getDevImei();
            case 262106:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseWifiState()));
            case 262107:
                return (T) tTCustomController.getMacAddress();
            case 262108:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseWriteExternal()));
            case 262109:
                return (T) tTCustomController.getDevOaid();
            case 262110:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseAndroidId()));
            case 262111:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUsePermissionRecordAudio()));
            case 262112:
                return (T) tTCustomController.getAndroidId();
            default:
                m(i10, valueSet, cls);
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        return (String) this.f11204m.call(262112, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        return (String) this.f11204m.call(262105, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        return (String) this.f11204m.call(262109, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        return (String) this.f11204m.call(262107, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return (IMediationPrivacyConfig) this.f11204m.values().objectValue(262113, IMediationPrivacyConfig.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public LocationProvider getTTLocation() {
        return (LocationProvider) this.f11204m.call(262102, a.c(0).a(), LocationProvider.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return ((Boolean) this.f11204m.call(262110, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return ((Boolean) this.f11204m.call(262101, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return ((Boolean) this.f11204m.call(262111, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return ((Boolean) this.f11204m.call(262104, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return ((Boolean) this.f11204m.call(262106, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        return ((Boolean) this.f11204m.call(262108, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.f52238b;
    }

    public w(TTCustomController tTCustomController) {
        this.dk = tTCustomController;
        this.f11204m = a.f52239c;
    }
}
