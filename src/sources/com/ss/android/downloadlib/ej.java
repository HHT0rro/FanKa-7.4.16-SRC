package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.hc.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej implements com.ss.android.socialbase.appdownloader.ej.e {

    /* renamed from: m, reason: collision with root package name */
    private static String f38736m = "ej";
    private Handler dk = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.ej.e
    public void m(DownloadInfo downloadInfo, BaseException baseException, int i10) {
        final DownloadModel m10;
        if (downloadInfo == null) {
            return;
        }
        if (i10 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.hc.n.ej(downloadInfo, jSONObject);
            m.m(jSONObject, downloadInfo);
            c.m("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.m.dk m11 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
        if (m11 == null) {
            return;
        }
        try {
            if (i10 != -1) {
                if (i10 == -3) {
                    m.m(downloadInfo, m11);
                    return;
                }
                if (i10 == 2001) {
                    m.m().m(downloadInfo, m11, 2001);
                    return;
                } else {
                    if (i10 == 11) {
                        m.m().m(downloadInfo, m11, 2000);
                        if (m11.o()) {
                            return;
                        }
                        m(downloadInfo, m11);
                        return;
                    }
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (DownloadSetting.obtain(downloadInfo.getId()).optInt("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.ej.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.c.ej().m(5, com.ss.android.downloadlib.addownload.c.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (DownloadUtils.isInsufficientSpaceError(baseException)) {
                    if (com.ss.android.downloadlib.addownload.c.sy() != null) {
                        com.ss.android.downloadlib.addownload.c.sy().m(m11.dk());
                    }
                    com.ss.android.downloadlib.l.m.m().m("download_failed_for_space", m11);
                    if (!m11.qx()) {
                        com.ss.android.downloadlib.l.m.m().m("download_can_restart", m11);
                        m(downloadInfo);
                    }
                    if ((com.ss.android.downloadlib.addownload.c.sy() == null || !com.ss.android.downloadlib.addownload.c.sy().l()) && (m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(m11.dk())) != null && m10.isShowToast()) {
                        final DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
                        if (obtain.optInt("show_no_enough_space_toast", 0) == 1) {
                            this.dk.post(new Runnable() { // from class: com.ss.android.downloadlib.ej.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.ss.android.downloadlib.addownload.c.ej().m(2, com.ss.android.downloadlib.addownload.c.getContext(), m10, obtain.optString("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), ve.m(baseException.getMessage(), com.ss.android.downloadlib.addownload.c.w().optInt(DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));
            }
            com.ss.android.downloadlib.l.m.m().dk(downloadInfo, baseException2);
            hc.m().m(downloadInfo, baseException, "");
        } catch (Exception e2) {
            com.ss.android.downloadlib.addownload.c.mj().m(e2, "onAppDownloadMonitorSend");
        }
    }

    private void m(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.m.dk dkVar) {
        final long m10 = ve.m(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, ve.m(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d10 = (totalBytes * 2.5d) + min;
        if (m10 > -1 && totalBytes > -1) {
            double d11 = m10;
            if (d11 < d10 && d10 - d11 > com.ss.android.downloadlib.addownload.l.dk()) {
                com.ss.android.downloadlib.addownload.l.m(downloadInfo.getId());
            }
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.ej.3
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                if (!ve.dk(dkVar)) {
                    long j10 = m10;
                    if (j10 <= -1 || totalBytes <= -1 || j10 >= d10) {
                        return;
                    }
                    com.ss.android.downloadlib.l.m.m().m("clean_space_install", com.ss.android.downloadlib.addownload.l.m("install_no_enough_space"), dkVar);
                    if (com.ss.android.downloadlib.addownload.l.m(downloadInfo, ((long) d10) - m10)) {
                        AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                        dkVar.hc(true);
                        return;
                    }
                    return;
                }
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            }
        });
    }

    private void m(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.hc.np.n(downloadInfo.getId())) {
            l.m().dk(new com.ss.android.downloadlib.addownload.ej.dk(downloadInfo));
        }
    }
}
