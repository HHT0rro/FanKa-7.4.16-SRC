package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class e extends com.bytedance.sdk.openadsdk.mediation.m.m.dk.l {

    /* renamed from: m, reason: collision with root package name */
    private IMediationPreloadRequestInfo f11376m;

    public e(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        super(iMediationPreloadRequestInfo);
        this.f11376m = iMediationPreloadRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.m.m.dk.l, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f11376m;
        if (iMediationPreloadRequestInfo == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i10 != 271045) {
            return (T) super.call(i10, valueSet, cls);
        }
        if (iMediationPreloadRequestInfo != null) {
            return (T) m.m(iMediationPreloadRequestInfo.getAdSlot());
        }
        return null;
    }
}
