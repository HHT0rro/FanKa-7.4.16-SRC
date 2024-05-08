package com.ss.android.downloadlib.n;

import com.ss.android.downloadlib.addownload.dk.n;
import com.ss.android.socialbase.appdownloader.ej.oa;
import com.ss.android.socialbase.appdownloader.ej.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk implements oa {
    @Override // com.ss.android.socialbase.appdownloader.ej.oa
    public void m(DownloadInfo downloadInfo, w wVar) {
        com.ss.android.downloadad.api.m.dk m10;
        if (downloadInfo != null && (m10 = n.m().m(downloadInfo)) != null) {
            downloadInfo.setLinkMode(m10.bz());
        }
        if (wVar != null) {
            wVar.m();
        }
    }
}
