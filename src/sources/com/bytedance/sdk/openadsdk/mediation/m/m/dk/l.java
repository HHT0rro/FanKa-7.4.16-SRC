package com.bytedance.sdk.openadsdk.mediation.m.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l implements Bridge {
    private final IMediationPreloadRequestInfo dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11373m = a.f52238b;

    public l(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.dk = iMediationPreloadRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.dk;
        if (iMediationPreloadRequestInfo == null) {
            return null;
        }
        switch (i10) {
            case 271044:
                return (T) Integer.class.cast(Integer.valueOf(iMediationPreloadRequestInfo.getAdType()));
            case 271045:
                return (T) iMediationPreloadRequestInfo.getAdSlot();
            case 271046:
                return (T) iMediationPreloadRequestInfo.getPrimeRitList();
            default:
                m(i10, valueSet, cls);
                return null;
        }
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11373m;
    }
}
