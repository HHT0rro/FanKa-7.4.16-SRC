package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationNativeAppInfoImpl implements Bridge {
    private MediationValueSetBuilder dk = MediationValueSetBuilder.create();

    /* renamed from: m, reason: collision with root package name */
    private MediationNativeAdAppInfo f11316m;

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.f11316m = mediationNativeAdAppInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.f11316m;
        if (mediationNativeAdAppInfo != null) {
            this.dk.add(8505, mediationNativeAdAppInfo.getAppName());
            this.dk.add(8506, this.f11316m.getAuthorName());
            this.dk.add(8507, this.f11316m.getPackageSizeBytes());
            this.dk.add(8508, this.f11316m.getPermissionsUrl());
            this.dk.add(8509, this.f11316m.getPermissionsMap());
            this.dk.add(8510, this.f11316m.getPrivacyAgreement());
            this.dk.add(8511, this.f11316m.getVersionName());
            this.dk.add(8512, this.f11316m.getAppInfoExtra());
        }
        return this.dk.build();
    }
}
