package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface AdConfig {
    int getAgeGroup();

    String getAppId();

    String getAppName();

    TTCustomController getCustomController();

    String getData();

    int[] getDirectDownloadNetworkType();

    @Deprecated
    Object getExtra(String str);

    String getKeywords();

    IMediationConfig getMediationConfig();

    int getPluginUpdateConfig();

    int getThemeStatus();

    int getTitleBarTheme();

    boolean isAllowShowNotify();

    boolean isDebug();

    boolean isPaid();

    boolean isSupportMultiProcess();

    boolean isUseMediation();

    boolean isUseTextureView();
}
