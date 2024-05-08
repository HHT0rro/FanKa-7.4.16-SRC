package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationAdDislikeImpl implements Bridge, MediationAdDislike {

    /* renamed from: m, reason: collision with root package name */
    private Bridge f11227m;

    public MediationAdDislikeImpl(Bridge bridge) {
        this.f11227m = bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        if (this.f11227m != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8317, new MediationDislikeCallbackImpl(iMediationDislikeCallback));
            this.f11227m.call(6085, create.build(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        Bridge bridge = this.f11227m;
        if (bridge != null) {
            bridge.call(8184, null, null);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
