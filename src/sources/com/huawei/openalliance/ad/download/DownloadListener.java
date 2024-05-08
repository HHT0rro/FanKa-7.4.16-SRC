package com.huawei.openalliance.ad.download;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.download.DownloadTask;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface DownloadListener<T extends DownloadTask> {
    void onAppInstalled(T t2);

    void onAppUnInstalled(T t2);

    void onDownloadDeleted(T t2);

    void onDownloadFail(T t2);

    void onDownloadPaused(T t2);

    void onDownloadProgress(T t2);

    void onDownloadResumed(T t2);

    void onDownloadStart(T t2);

    void onDownloadSuccess(T t2);

    void onDownloadWaiting(T t2);

    void onSilentInstallFailed(T t2);

    void onSilentInstallStart(T t2);

    void onSilentInstallSuccess(T t2);

    void onSystemInstallStart(T t2);
}
