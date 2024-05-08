package com.ss.android.downloadlib.n;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.dk.n;
import com.ss.android.socialbase.appdownloader.ej.oa;
import com.ss.android.socialbase.appdownloader.ej.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m implements oa {
    /* JADX INFO: Access modifiers changed from: private */
    public void dk(DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.m mVar) {
        com.ss.android.downloadad.api.m.dk m10 = n.m().m(downloadInfo);
        boolean m11 = com.ss.android.downloadlib.dk.n.m(m10);
        boolean dk = com.ss.android.downloadlib.dk.n.dk(m10);
        if (m11 && dk) {
            com.ss.android.downloadlib.dk.ej.m(m10, new com.ss.android.downloadlib.guide.install.m() { // from class: com.ss.android.downloadlib.n.m.3
                @Override // com.ss.android.downloadlib.guide.install.m
                public void m() {
                    mVar.m();
                }
            });
        } else {
            mVar.m();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.oa
    public void m(DownloadInfo downloadInfo, final w wVar) {
        m(downloadInfo, new com.ss.android.downloadlib.guide.install.m() { // from class: com.ss.android.downloadlib.n.m.1
            @Override // com.ss.android.downloadlib.guide.install.m
            public void m() {
                wVar.m();
            }
        });
    }

    public void m(final DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.m mVar) {
        com.ss.android.downloadad.api.m.dk m10 = n.m().m(downloadInfo);
        if (m10 != null && com.ss.android.downloadlib.dk.w.m(m10)) {
            TTDelegateActivity.m(m10, new com.ss.android.downloadlib.guide.install.m() { // from class: com.ss.android.downloadlib.n.m.2
                @Override // com.ss.android.downloadlib.guide.install.m
                public void m() {
                    m.this.dk(downloadInfo, mVar);
                }
            });
        } else {
            dk(downloadInfo, mVar);
        }
    }
}
