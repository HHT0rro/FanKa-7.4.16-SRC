package com.ss.android.downloadlib.ej;

import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.dk.w;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l implements com.ss.android.socialbase.appdownloader.ej.hc, IDownloadCacheSyncStatusListener {
    @Override // com.ss.android.socialbase.appdownloader.ej.hc
    public void m(DownloadInfo downloadInfo, boolean z10) {
        if (downloadInfo == null) {
            return;
        }
        m(downloadInfo, downloadInfo.getRealStatus(), z10);
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.hc
    public void m(List<DownloadInfo> list) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onStart() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onSuccess() {
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.ej.l.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.dk.n.m().dk();
                for (com.ss.android.downloadad.api.m.dk dkVar : com.ss.android.downloadlib.addownload.dk.n.m().ej().values()) {
                    int x10 = dkVar.x();
                    if (x10 != 0) {
                        DownloadSetting obtain = DownloadSetting.obtain(x10);
                        if (obtain.optInt("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(x10)) != null) {
                            if (ve.dk(dkVar) && !ve.ej(dkVar.np())) {
                                int spIntVal2 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT);
                                if (spIntVal2 < obtain.optInt("noti_open_restart_times", 1)) {
                                    e.m().np(dkVar);
                                    downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT, String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT);
                                if (spIntVal3 < obtain.optInt("noti_continue_restart_times", 1)) {
                                    e.m().m(dkVar);
                                    downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT, String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && DownloadUtils.isFileDownloaded(downloadInfo) && !ve.dk(dkVar) && (spIntVal = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT)) < obtain.optInt("noti_install_restart_times", 1)) {
                                e.m().ej(dkVar);
                                downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT, String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }

    @WorkerThread
    public void m(DownloadInfo downloadInfo, int i10, boolean z10) {
        com.ss.android.downloadlib.addownload.dk.n.m().dk();
        com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
        if (m10 == null) {
            return;
        }
        try {
            if (z10) {
                m10.ej(downloadInfo.getFailedResumeCount());
            } else if (m10.hr() == -1) {
                return;
            } else {
                m10.ej(-1);
            }
            w.m().m(m10);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getDownloadTime());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, i10);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
            int i11 = 1;
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, downloadInfo.getChunkCount());
            if (!z10) {
                i11 = 2;
            }
            jSONObject.put("launch_resumed", i11);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.l.m.m().m("embeded_ad", "download_uncompleted", jSONObject, m10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
