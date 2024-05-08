package com.bytedance.sdk.openadsdk.w.m.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements Bridge {
    private final TTFeedAd.VideoRewardListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11416m = a.f52238b;

    public dk(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.dk = videoRewardListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        if (i10 == 163101) {
            this.dk.onFeedRewardCountDown(valueSet.intValue(0));
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11416m;
    }
}
