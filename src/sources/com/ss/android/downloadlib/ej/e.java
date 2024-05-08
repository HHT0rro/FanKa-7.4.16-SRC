package com.ss.android.downloadlib.ej;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static e f38745m = new e();
    }

    public void dk(com.ss.android.downloadad.api.m.dk dkVar) {
        if (dkVar == null) {
            return;
        }
        dk(dkVar, DownloadSetting.obtain(dkVar.x()).optInt("noti_continue_delay_secs", 5));
    }

    public void ej(@NonNull com.ss.android.downloadad.api.m.dk dkVar) {
        ej(dkVar, 5L);
    }

    public void l(@NonNull com.ss.android.downloadad.api.m.dk dkVar) {
        ej(dkVar, DownloadSetting.obtain(dkVar.x()).optInt("noti_install_delay_secs", 5));
    }

    public void n(@NonNull com.ss.android.downloadad.api.m.dk dkVar) {
        m(dkVar, DownloadSetting.obtain(dkVar.x()).optInt("noti_open_delay_secs", 5));
    }

    public void np(@NonNull com.ss.android.downloadad.api.m.dk dkVar) {
        m(dkVar, 5L);
    }

    private e() {
    }

    private void dk(@NonNull final com.ss.android.downloadad.api.m.dk dkVar, long j10) {
        final int x10 = dkVar.x();
        if (DownloadSetting.obtain(x10).optInt("notification_opt_2") != 1) {
            return;
        }
        m(x10);
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.ej.e.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(x10);
                JSONObject jSONObject = new JSONObject();
                ve.m(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.hc.n.ej(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    e.this.m(x10, dkVar, jSONObject);
                } else {
                    ve.m(jSONObject, "error_code", (Object) 1001);
                }
                com.ss.android.downloadlib.l.m.m().dk("download_notification_try_show", jSONObject, dkVar);
            }
        }, j10 * 1000);
    }

    private void ej(@NonNull final com.ss.android.downloadad.api.m.dk dkVar, long j10) {
        final int x10 = dkVar.x();
        if (DownloadSetting.obtain(x10).optInt("notification_opt_2") != 1) {
            return;
        }
        m(x10);
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.ej.e.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(x10);
                JSONObject jSONObject = new JSONObject();
                ve.m(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.hc.n.ej(downloadInfo, jSONObject);
                if (!ve.dk(dkVar)) {
                    e.this.m(x10, dkVar, jSONObject);
                } else {
                    ve.m(jSONObject, "error_code", (Object) 1002);
                }
                com.ss.android.downloadlib.l.m.m().dk("download_notification_try_show", jSONObject, dkVar);
            }
        }, j10 * 1000);
    }

    public static e m() {
        return m.f38745m;
    }

    public void m(com.ss.android.downloadad.api.m.dk dkVar) {
        dk(dkVar, 5L);
    }

    public void m(@NonNull final com.ss.android.downloadad.api.m.dk dkVar, long j10) {
        final int x10 = dkVar.x();
        if (DownloadSetting.obtain(x10).optInt("notification_opt_2") != 1) {
            return;
        }
        m(x10);
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.ej.e.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(x10);
                JSONObject jSONObject = new JSONObject();
                ve.m(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.hc.n.ej(downloadInfo, jSONObject);
                if (!ve.ej(dkVar.np())) {
                    e.this.m(x10, dkVar, jSONObject);
                } else {
                    ve.m(jSONObject, "error_code", (Object) 1003);
                }
                com.ss.android.downloadlib.l.m.m().dk("download_notification_try_show", jSONObject, dkVar);
            }
        }, j10 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i10, com.ss.android.downloadad.api.m.dk dkVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.np.l.m()) {
            ve.m(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(i10);
        if (downloadInfo == null) {
            ve.m(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (DownloadNotificationManager.getInstance().getNotificationItem(i10) != null) {
            DownloadNotificationManager.getInstance().cancelNotification(i10);
        }
        com.ss.android.socialbase.appdownloader.np.m mVar = new com.ss.android.socialbase.appdownloader.np.m(c.getContext(), i10, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        mVar.setCurBytes(downloadInfo.getCurBytes());
        mVar.setTotalBytes(downloadInfo.getTotalBytes());
        mVar.refreshStatus(downloadInfo.getStatus(), null, false, false);
        DownloadNotificationManager.getInstance().addNotification(mVar);
        mVar.updateNotification(null, false);
        com.ss.android.downloadlib.l.m.m().dk("download_notification_show", jSONObject, dkVar);
    }

    public void m(int i10) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.np.ej.m().m(i10) != null || (downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(i10)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.np.ej.m().m(i10, downloadInfo.getIconUrl());
    }
}
