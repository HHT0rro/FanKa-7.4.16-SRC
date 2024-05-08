package com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class hc implements Bridge {
    private final MediationShakeViewListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11283m = a.f52238b;

    public hc(MediationShakeViewListener mediationShakeViewListener) {
        this.dk = mediationShakeViewListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        MediationShakeViewListener mediationShakeViewListener = this.dk;
        if (mediationShakeViewListener == null) {
            return null;
        }
        if (i10 == 270012) {
            mediationShakeViewListener.onDismissed();
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11283m;
    }
}
