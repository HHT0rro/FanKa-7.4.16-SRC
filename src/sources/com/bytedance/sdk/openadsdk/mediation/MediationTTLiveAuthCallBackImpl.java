package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationTTLiveAuthCallBackImpl implements TTLiveAuthCallback {

    /* renamed from: m, reason: collision with root package name */
    private Bridge f11239m;

    public MediationTTLiveAuthCallBackImpl(Bridge bridge) {
        this.f11239m = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onAuth(TTLiveToken tTLiveToken) {
        if (this.f11239m == null || tTLiveToken == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8520, tTLiveToken.name);
        create.add(8521, tTLiveToken.accessToken);
        create.add(8522, tTLiveToken.openId);
        create.add(8523, tTLiveToken.expireAt);
        create.add(8524, tTLiveToken.refreshToken);
        this.f11239m.call(8527, create.build(), null);
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onFailed(Throwable th) {
        if (this.f11239m == null || th == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8014, th);
        this.f11239m.call(8528, create.build(), null);
    }
}
