package com.bytedance.sdk.openadsdk.sy.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements Bridge {
    private final TTRewardVideoAd.RewardAdPlayAgainController dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11411m = a.f52238b;

    public dk(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.dk = rewardAdPlayAgainController;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        if (i10 == 122101) {
            this.dk.getPlayAgainCondition(valueSet.intValue(0), new com.bytedance.sdk.openadsdk.l.m.m.m.m.m((Bridge) valueSet.objectValue(1, Bridge.class)));
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11411m;
    }
}
