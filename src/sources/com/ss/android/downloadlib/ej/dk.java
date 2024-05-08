package com.ss.android.downloadlib.ej;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk implements IDownloadCompleteHandler {
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo m10 = com.ss.android.socialbase.appdownloader.ej.m(c.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (m10 != null) {
            downloadInfo.setAppVersionCode(m10.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.hc.np.dk() && downloadInfo.getPackageInfo() == null;
    }
}
