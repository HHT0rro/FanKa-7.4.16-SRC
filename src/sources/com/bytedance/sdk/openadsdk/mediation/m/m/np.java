package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class np extends com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.m {

    /* renamed from: m, reason: collision with root package name */
    private IMediationAdSlot f11384m;

    public np(IMediationAdSlot iMediationAdSlot) {
        super(iMediationAdSlot);
        this.f11384m = iMediationAdSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.m, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.f11384m == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i10 == 266101) {
            return (T) new com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.ej((IMediationNativeToBannerListener) super.call(i10, null, IMediationNativeToBannerListener.class));
        }
        if (i10 == 266102) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo = (IMediationSplashRequestInfo) super.call(i10, null, IMediationSplashRequestInfo.class);
            if (iMediationSplashRequestInfo != null) {
                return (T) new w(iMediationSplashRequestInfo);
            }
            return null;
        }
        return (T) super.call(i10, valueSet, cls);
    }
}
