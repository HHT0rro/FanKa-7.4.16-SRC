package com.bytedance.sdk.openadsdk.hc.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ej.m.m.k;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class hc implements Bridge {
    private final TTAdNative.RewardVideoAdListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11207m = a.f52238b;

    public hc(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.dk = rewardVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.dk;
        if (rewardVideoAdListener == null) {
            return null;
        }
        switch (i10) {
            case 124101:
                this.dk.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 124102:
                this.dk.onRewardVideoAdLoad(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124103:
                this.dk.onRewardVideoCached(new k((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124104:
                rewardVideoAdListener.onRewardVideoCached();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11207m;
    }
}
