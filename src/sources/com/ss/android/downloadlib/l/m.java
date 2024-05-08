package com.ss.android.downloadlib.l;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.ej;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.dk.n;
import com.ss.android.downloadlib.addownload.dk.np;
import com.ss.android.downloadlib.addownload.dk.w;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.appdownloader.np.l;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {

    /* renamed from: com.ss.android.downloadlib.l.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0581m {

        /* renamed from: m, reason: collision with root package name */
        private static m f38788m = new m();
    }

    public static m m() {
        return C0581m.f38788m;
    }

    public void dk(long j10, int i10) {
        m(j10, i10, (DownloadInfo) null);
    }

    private m() {
    }

    public void dk(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.m.dk m10 = n.m().m(downloadInfo);
        if (m10 == null) {
            com.ss.android.downloadlib.np.ej.m().m("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (m10.ej.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.hc.n.ej(downloadInfo, jSONObject);
            com.ss.android.downloadlib.m.m(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                m10.l(baseException.getErrorCode());
                m10.m(baseException.getErrorMessage());
            }
            m10.u();
            jSONObject.put("download_failed_times", m10.s());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i10 = 1;
            jSONObject.put("has_send_download_failed_finally", m10.f38458l.get() ? 1 : 2);
            com.ss.android.downloadlib.hc.n.m(m10, jSONObject);
            if (!m10.iy()) {
                i10 = 2;
            }
            jSONObject.put("is_update_download", i10);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        m(m10.oa(), "download_failed", jSONObject, m10);
        w.m().m(m10);
    }

    public void m(long j10, int i10) {
        np np = n.m().np(j10);
        if (np.s()) {
            com.ss.android.downloadlib.np.ej.m().m("sendClickEvent ModelBox notValid");
            return;
        }
        if (np.ej.isEnableClickEvent()) {
            int i11 = 1;
            DownloadEventConfig downloadEventConfig = np.ej;
            String clickItemTag = i10 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String m10 = ve.m(np.ej.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i10));
                jSONObject.putOpt("permission_notification", Integer.valueOf(l.m() ? 1 : 2));
                if (!DownloadUtils.isNetworkConnected(c.getContext())) {
                    i11 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i11));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            m(clickItemTag, m10, jSONObject, np);
            if (!"click".equals(m10) || np.dk == null) {
                return;
            }
            ej.m().m(j10, np.dk.getLogExtra());
        }
    }

    public void m(long j10, int i10, DownloadInfo downloadInfo) {
        np np = n.m().np(j10);
        if (np.s()) {
            com.ss.android.downloadlib.np.ej.m().m("sendEvent ModelBox notValid");
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        ve.m(jSONObject, "download_scene", Integer.valueOf(np.mj()));
        if (i10 == 1) {
            str = ve.m(np.ej.getStorageDenyLabel(), "storage_deny");
        } else if (i10 == 2) {
            str = ve.m(np.ej.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.hc.n.m(downloadInfo, jSONObject);
        } else if (i10 == 3) {
            str = ve.m(np.ej.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.hc.n.dk(downloadInfo, jSONObject);
        } else if (i10 == 4) {
            str = ve.m(np.ej.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.hc.n.ej(downloadInfo, jSONObject);
        } else if (i10 == 5) {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.hc.n.m(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.m.dk(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            str = ve.m(np.ej.getClickInstallLabel(), "click_install");
        }
        m(null, str, jSONObject, 0L, 1, np);
    }

    public void dk(String str, com.ss.android.downloadad.api.m.m mVar) {
        m((String) null, str, mVar);
    }

    public void dk(String str, JSONObject jSONObject, com.ss.android.downloadad.api.m.m mVar) {
        m((String) null, str, jSONObject, mVar);
    }

    public void m(String str, int i10, np npVar) {
        m(null, str, null, i10, 0, npVar);
    }

    public void m(long j10, boolean z10, int i10) {
        np np = n.m().np(j10);
        if (np.s()) {
            com.ss.android.downloadlib.np.ej.m().m("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (np.dk.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = np.dk;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i10));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        dk(z10 ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, np);
    }

    public void m(long j10, BaseException baseException) {
        np np = n.m().np(j10);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_TIME, 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        dk("download_failed", jSONObject, np);
    }

    public void m(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.m.dk m10 = n.m().m(downloadInfo);
        if (m10 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.hc.n.ej(downloadInfo, jSONObject);
            m10.m(System.currentTimeMillis());
            m(m10.oa(), "download_resume", jSONObject, m10);
            w.m().m(m10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void m(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.m.dk dkVar) {
        m(dkVar.oa(), "install_finish", jSONObject, dkVar);
    }

    public void m(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.m.dk m10;
        if (downloadInfo == null || (m10 = n.m().m(downloadInfo)) == null || m10.ej.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.m.m(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(m10.zk()));
            jSONObject.putOpt("fail_msg", m10.bm());
            jSONObject.put("download_failed_times", m10.s());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (m10.db() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - m10.db());
            }
            if (m10.ks() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - m10.ks());
            }
            int i10 = 1;
            jSONObject.put("is_update_download", m10.iy() ? 1 : 2);
            jSONObject.put("can_show_notification", l.m() ? 1 : 2);
            if (!m10.f38458l.get()) {
                i10 = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i10);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        m(m10.oa(), "download_cancel", jSONObject, m10);
    }

    public void m(String str, com.ss.android.downloadad.api.m.m mVar) {
        m(str, (JSONObject) null, mVar);
    }

    public void m(String str, JSONObject jSONObject, long j10) {
        com.ss.android.downloadad.api.m.m l10 = n.m().l(j10);
        if (l10 != null) {
            m(str, jSONObject, l10);
            return;
        }
        np np = n.m().np(j10);
        if (np.s()) {
            com.ss.android.downloadlib.np.ej.m().m("sendUnityEvent ModelBox notValid");
        } else {
            m(str, jSONObject, np);
        }
    }

    public void m(String str, JSONObject jSONObject, com.ss.android.downloadad.api.m.m mVar) {
        JSONObject jSONObject2 = new JSONObject();
        ve.m(jSONObject2, "unity_label", str);
        m("embeded_ad", "ttdownloader_unity", ve.m(jSONObject, jSONObject2), mVar);
    }

    public void m(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        dk(str, new np(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void m(String str, long j10) {
        com.ss.android.downloadad.api.m.dk l10 = n.m().l(j10);
        if (l10 != null) {
            dk(str, l10);
        } else {
            dk(str, n.m().np(j10));
        }
    }

    public void m(String str, String str2, com.ss.android.downloadad.api.m.m mVar) {
        m(str, str2, (JSONObject) null, mVar);
    }

    public void m(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.m.m mVar) {
        m(str, str2, jSONObject, 0L, 0, mVar);
    }

    private void m(String str, String str2, JSONObject jSONObject, long j10, int i10, com.ss.android.downloadad.api.m.m mVar) {
        if (mVar == null) {
            com.ss.android.downloadlib.np.ej.m().m("onEvent data null");
            return;
        }
        if ((mVar instanceof np) && ((np) mVar).s()) {
            com.ss.android.downloadlib.np.ej.m().m("onEvent ModelBox notValid");
            return;
        }
        try {
            ej.m ej = new ej.m().m(ve.m(str, mVar.oa(), "embeded_ad")).dk(str2).dk(mVar.ej()).m(mVar.dk()).ej(mVar.l());
            if (j10 <= 0) {
                j10 = mVar.ve();
            }
            ej.m m10 = ej.dk(j10).l(mVar.w()).m(mVar.r()).m(ve.m(m(mVar), jSONObject)).dk(mVar.c()).m(mVar.q());
            if (i10 <= 0) {
                i10 = 2;
            }
            m(m10.m(i10).m(mVar.sy()).m());
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "onEvent");
        }
    }

    private JSONObject m(com.ss.android.downloadad.api.m.m mVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            ve.m(mVar.hc(), jSONObject);
            ve.m(mVar.k(), jSONObject);
            jSONObject.putOpt("download_url", mVar.m());
            jSONObject.putOpt("package_name", mVar.np());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.n.np.e());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.n.np.w());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(mVar.e()));
            if (mVar.e() == 2) {
                com.ss.android.downloadlib.hc.n.dk(jSONObject, mVar);
            }
            if (com.ss.android.socialbase.appdownloader.n.np.k()) {
                com.ss.android.downloadlib.hc.n.m(jSONObject);
            }
        } catch (Exception e2) {
            c.mj().m(e2, "getBaseJson");
        }
        return jSONObject;
    }

    private void m(com.ss.android.download.api.model.ej ejVar) {
        if (c.m() == null) {
            return;
        }
        if (ejVar.sy()) {
            c.m().m(ejVar);
        } else {
            c.m().dk(ejVar);
        }
    }
}
