package com.bytedance.sdk.openadsdk.mediation;

import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationPrivacyConfigImpl extends MediationPrivacyConfig implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private IMediationPrivacyConfig f11237m;

    public MediationPrivacyConfigImpl(IMediationPrivacyConfig iMediationPrivacyConfig) {
        this.f11237m = iMediationPrivacyConfig;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    @Nullable
    public List<String> getCustomAppList() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f11237m;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.getCustomAppList();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    @Nullable
    public List<String> getCustomDevImeis() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f11237m;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.getCustomDevImeis();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isCanUseOaid() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f11237m;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isCanUseOaid();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isLimitPersonalAds() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f11237m;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isLimitPersonalAds();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isProgrammaticRecommend() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f11237m;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isProgrammaticRecommend();
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8476, getCustomAppList());
        create.add(8477, getCustomDevImeis());
        create.add(8478, isCanUseOaid());
        create.add(8027, isLimitPersonalAds());
        create.add(8028, isProgrammaticRecommend());
        return create.build();
    }
}
