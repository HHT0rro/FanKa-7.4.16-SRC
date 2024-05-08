package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class w extends com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.l {

    /* renamed from: m, reason: collision with root package name */
    private IMediationSplashRequestInfo f11388m;

    public w(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        super(iMediationSplashRequestInfo);
        this.f11388m = iMediationSplashRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.l, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        String str = "";
        switch (i10) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.f11388m;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    str = this.f11388m.getAdnName();
                }
                return (T) String.valueOf(str);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f11388m;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    str = this.f11388m.getAdnSlotId();
                }
                return (T) String.valueOf(str);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f11388m;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    str = this.f11388m.getAppId();
                }
                return (T) String.valueOf(str);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f11388m;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    str = this.f11388m.getAppkey();
                }
                return (T) String.valueOf(str);
            default:
                return (T) super.call(i10, valueSet, cls);
        }
    }
}
