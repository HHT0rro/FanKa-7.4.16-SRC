package com.bytedance.sdk.openadsdk.mediation.m.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej implements Bridge {
    private final IMediationNativeAdTokenCallback dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11372m = a.f52238b;

    public ej(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.dk = iMediationNativeAdTokenCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        switch (i10) {
            case 270026:
                this.dk.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), new com.bytedance.sdk.openadsdk.mediation.m.m.m.ej((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 270027:
                this.dk.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11372m;
    }
}
