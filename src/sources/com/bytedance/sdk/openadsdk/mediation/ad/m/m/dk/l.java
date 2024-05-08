package com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l implements Bridge {
    private final IMediationSplashRequestInfo dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11284m = a.f52238b;

    public l(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.dk = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo = this.dk;
        if (iMediationSplashRequestInfo == null) {
            return null;
        }
        switch (i10) {
            case 267001:
                return (T) iMediationSplashRequestInfo.getAdnName();
            case 267002:
                return (T) iMediationSplashRequestInfo.getAdnSlotId();
            case 267003:
                return (T) iMediationSplashRequestInfo.getAppId();
            case 267004:
                return (T) iMediationSplashRequestInfo.getAppkey();
            default:
                m(i10, valueSet, cls);
                return null;
        }
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11284m;
    }
}
