package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface MediationBaseManager {
    List<MediationAdLoadInfo> getAdLoadInfo();

    MediationAdEcpmInfo getBestEcpm();

    List<MediationAdEcpmInfo> getCacheList();

    List<MediationAdEcpmInfo> getMultiBiddingEcpm();

    MediationAdEcpmInfo getShowEcpm();

    boolean isReady();
}
