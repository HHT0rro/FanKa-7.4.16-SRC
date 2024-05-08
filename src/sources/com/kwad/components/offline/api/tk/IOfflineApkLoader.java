package com.kwad.components.offline.api.tk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IOfflineApkLoader {
    void addLoadStatusListener(IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener);

    void cancelDownload();

    void clearFileCache();

    void installApp();

    void openApp();

    void pauseDownload();

    void resumeDownload();

    void setCustomReportParam(String str);

    void startDownload();

    void stopDownload();

    void uninstallApp();
}
