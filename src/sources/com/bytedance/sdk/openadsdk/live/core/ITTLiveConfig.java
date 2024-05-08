package com.bytedance.sdk.openadsdk.live.core;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ITTLiveConfig {
    String getAppName();

    String getChannel();

    String getECHostAppId();

    String getGeneralAppId();

    TTHostPermissionInner getHostPermission();

    ITTLiveHostAction getLiveHostAction();

    String getPartner();

    String getPartnerSecret();

    String getVersion();

    int getVersionCode();

    boolean isDebug();

    boolean isValid();
}
