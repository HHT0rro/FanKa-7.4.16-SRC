package com.ss.android.downloadlib.ej;

import android.content.Context;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n implements com.ss.android.socialbase.appdownloader.ej.l {

    /* renamed from: m, reason: collision with root package name */
    private Context f38754m;

    public n(Context context) {
        this.f38754m = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.l
    public void m(Context context, String str) {
        com.ss.android.downloadlib.m.m().m(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.l
    public void m(int i10, int i11, String str, int i12, long j10) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.m.dk m10;
        Context context = this.f38754m;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10)) == null || downloadInfo.getStatus() == 0 || (m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo)) == null) {
            return;
        }
        if (i11 == 1) {
            com.ss.android.downloadlib.m.m(downloadInfo, m10);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.m.m().m(downloadInfo, m10.dk(), m10.ve(), m10.np(), downloadInfo.getTitle(), m10.l(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i11 == 3) {
            com.ss.android.downloadlib.l.m.m().m("download_notification", "download_notification_install", com.ss.android.downloadlib.m.dk(new JSONObject(), downloadInfo), m10);
            return;
        }
        if (i11 == 5) {
            com.ss.android.downloadlib.l.m.m().m("download_notification", "download_notification_pause", m10);
        } else if (i11 == 6) {
            com.ss.android.downloadlib.l.m.m().m("download_notification", "download_notification_continue", m10);
        } else {
            if (i11 != 7) {
                return;
            }
            com.ss.android.downloadlib.l.m.m().m("download_notification", "download_notification_click", m10);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.l
    public boolean m(int i10, boolean z10) {
        if (c.q() != null) {
            return c.q().m(z10);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.l
    public void m(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.hc.m().m(downloadInfo);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.l.m.m().m(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.l.m.m().dk(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.l
    public void m(int i10, int i11, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.f38754m;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.dk.m().m(this.f38754m, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.l
    public boolean m() {
        return com.ss.android.downloadlib.addownload.dk.m().dk();
    }
}
