package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationSplashRequestInfoImpl implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private IMediationSplashRequestInfo f11238m;

    public MediationSplashRequestInfoImpl(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f11238m = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo;
        if (i10 == 8530) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f11238m;
            if (iMediationSplashRequestInfo2 != null) {
                return (T) iMediationSplashRequestInfo2.getAdnName();
            }
            return null;
        }
        if (i10 == 8532) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f11238m;
            if (iMediationSplashRequestInfo3 != null) {
                return (T) iMediationSplashRequestInfo3.getAppId();
            }
            return null;
        }
        if (i10 == 8533) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f11238m;
            if (iMediationSplashRequestInfo4 != null) {
                return (T) iMediationSplashRequestInfo4.getAppkey();
            }
            return null;
        }
        if (i10 != 8531 || (iMediationSplashRequestInfo = this.f11238m) == null) {
            return null;
        }
        return (T) iMediationSplashRequestInfo.getAdnSlotId();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
