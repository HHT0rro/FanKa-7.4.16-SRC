package com.kwad.components.offline.api.tk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IOfflineApkLoadStatusListener {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadStarted();

    void onIdle();

    void onInstalled();

    void onPaused(int i10);

    void onProgressUpdate(int i10);
}
