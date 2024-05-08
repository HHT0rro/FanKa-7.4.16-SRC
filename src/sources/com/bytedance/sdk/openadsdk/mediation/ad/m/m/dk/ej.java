package com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej implements Bridge {
    private final IMediationNativeToBannerListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11282m = a.f52238b;

    public ej(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.dk = iMediationNativeToBannerListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        if (i10 != 266013) {
            m(i10, valueSet, cls);
            return null;
        }
        return (T) this.dk.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.m.m.m.m((Bridge) valueSet.objectValue(0, Bridge.class)));
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11282m;
    }
}
