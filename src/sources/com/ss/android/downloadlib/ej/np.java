package com.ss.android.downloadlib.ej;

import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np implements InnerEventListener {
    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onEvent(int i10, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.m.dk m10;
        DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(i10);
        if (downloadInfo == null || (m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo)) == null) {
            return;
        }
        if (MonitorConstants.EventLabel.INSTALL_VIEW_RESULT.equals(str)) {
            jSONObject = ve.m(jSONObject);
            com.ss.android.downloadlib.m.m(jSONObject, downloadInfo);
            ve.m(jSONObject, "model_id", Long.valueOf(m10.dk()));
        }
        com.ss.android.downloadlib.l.m.m().dk(str, jSONObject, m10);
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onUnityEvent(int i10, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.m.dk m10;
        DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(i10);
        if (downloadInfo == null || (m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.l.m.m().m(str, jSONObject, m10);
    }
}
