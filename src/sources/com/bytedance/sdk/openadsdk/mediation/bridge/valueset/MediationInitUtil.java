package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationPrivacyConfigImpl;
import com.bytedance.sdk.openadsdk.mediation.MediationUserInfoForSegmentImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationCustomController;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationInitUtil {
    public static ValueSet getMediationAdSlot(IMediationConfig iMediationConfig) {
        if (iMediationConfig == null) {
            return null;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8458, iMediationConfig.getHttps());
        create.add(8459, iMediationConfig.wxAppId());
        create.add(8460, iMediationConfig.getPublisherDid());
        create.add(8461, iMediationConfig.isOpenAdnTest());
        create.add(8462, iMediationConfig.getLocalExtra());
        create.add(8463, iMediationConfig.getCustomLocalConfig());
        create.add(8464, iMediationConfig.getOpensdkVer());
        create.add(8465, iMediationConfig.isWxInstalled());
        create.add(8466, iMediationConfig.isSupportH265());
        create.add(8467, iMediationConfig.isSupportSplashZoomout());
        create.add(8310, new MediationUserInfoForSegmentImpl(iMediationConfig.getMediationConfigUserInfoForSegment()));
        return create.build();
    }

    public static ValueSet getMediationCustomController(MediationCustomController mediationCustomController) {
        if (mediationCustomController == null) {
            return null;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8311, new MediationPrivacyConfigImpl(mediationCustomController.getMediationPrivacyConfig()));
        create.add(8023, mediationCustomController.isCanUsePhoneState());
        create.add(8024, mediationCustomController.isCanUseLocation());
        create.add(8025, mediationCustomController.isCanUseWriteExternal());
        create.add(8026, mediationCustomController.alist());
        create.add(8480, mediationCustomController.isCanUseWifiState());
        create.add(8479, mediationCustomController.isCanUseAndroidId());
        create.add(8312, new MediationLocationImpl(mediationCustomController.getTTLocation()));
        create.add(8483, mediationCustomController.getTTLocation());
        create.add(8484, mediationCustomController.getDevImei());
        create.add(8485, mediationCustomController.getAndroidId());
        create.add(8486, mediationCustomController.getDevOaid());
        create.add(8487, mediationCustomController.getMacAddress());
        create.add(8549, mediationCustomController.isCanUsePermissionRecordAudio());
        return create.build();
    }
}
