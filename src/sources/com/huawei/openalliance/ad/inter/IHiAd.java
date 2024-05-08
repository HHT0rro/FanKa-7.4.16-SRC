package com.huawei.openalliance.ad.inter;

import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IHiAd {
    void enableSharePd(boolean z10);

    void enableUserInfo(boolean z10);

    int getAppActivateStyle();

    IAppDownloadManager getAppDownloadManager();

    ExtensionActionListener getExtensionActionListener();

    RequestOptions getRequestConfiguration();

    void informReady();

    void initGrs(String str);

    void initGrs(String str, String str2);

    void initLog(boolean z10, int i10);

    void initLog(boolean z10, int i10, String str);

    boolean isAppAutoOpenForbidden();

    boolean isAppInstalledNotify();

    boolean isEnableUserInfo();

    boolean isNewProcess();

    void onBackground();

    void onForeground();

    void setAppActivateStyle(int i10);

    void setAppAutoOpenForbidden(boolean z10);

    void setAppDownloadListener(AppDownloadListener appDownloadListener);

    void setAppInstalledNotify(boolean z10);

    void setAppMuted(boolean z10);

    void setAppVolume(float f10);

    void setApplicationCode(String str);

    void setBrand(int i10);

    void setConsent(String str);

    void setCountryCode(String str);

    void setExtensionActionListener(ExtensionActionListener extensionActionListener);

    void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager);

    void setRequestConfiguration(RequestOptions requestOptions);
}
