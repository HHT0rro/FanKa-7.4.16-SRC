package com.ss.android.downloadlib.hc;

import android.view.textclassifier.ConversationAction;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.ss.android.socialbase.appdownloader.hc;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {
    public static void dk(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.m.dk m10;
        if (jSONObject == null || (m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo)) == null) {
            return;
        }
        try {
            ej(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - m10.fh()));
            jSONObject.putOpt("click_download_size", Long.valueOf(m10.iz()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            m10.gw();
            com.ss.android.downloadlib.addownload.dk.w.m().m(m10);
            jSONObject.put("click_pause_times", m10.fr());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? ShadowDrawableWrapper.COS_45 : curBytes / totalBytes);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long db2 = m10.db();
            if (db2 > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - db2);
            }
            long ks = m10.ks();
            if (ks > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - ks);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(m10.zk()));
            jSONObject.putOpt("fail_msg", m10.bm());
            jSONObject.put("download_failed_times", m10.s());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.np.l.m() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void ej(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_STATUS, Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo.getId());
                if (m10 != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(m10.fh()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(m10.iz()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        int i10 = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.np.l.m() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(DownloadUtils.isNetworkConnected(com.ss.android.downloadlib.addownload.c.getContext()) ? 1 : 2));
        if (!DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.c.getContext())) {
            i10 = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i10));
    }

    public static void m(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            ej(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
            if (m10 == null) {
                return;
            }
            jSONObject.put("is_update_download", m10.iy() ? 1 : 2);
            m(m10, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void m(com.ss.android.downloadad.api.m.dk dkVar, JSONObject jSONObject) {
        if (jSONObject == null || dkVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", dkVar.cm() ? 1 : 0);
            jSONObject.put("origin_mime_type", dkVar.i());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void m(JSONObject jSONObject, int i10) {
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = DownloadSetting.obtain(i10).optJSONArray("ah_report_config");
        if (optJSONArray != null) {
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                try {
                    String string = optJSONArray.getString(i11);
                    hc.m m10 = com.ss.android.socialbase.appdownloader.n.m.m(string);
                    if (m10 != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), m10.n() + "_" + m10.hc());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.dk.m(DownloadComponentManager.getAppContext()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject m(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.m.m mVar) {
        ve.m(jSONObject, ConversationAction.TYPE_OPEN_URL, ve.m(mVar.n(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void m(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.n.l.m());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.n.l.ej());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.n.l.l());
            int i10 = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.n.l.m(com.ss.android.downloadlib.addownload.c.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.n.l.np() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.n.l.dk());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.n.l.dk(com.ss.android.downloadlib.addownload.c.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.n.l.n()) {
                i10 = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i10));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static JSONObject dk(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.m.m mVar) {
        ve.m(jSONObject, com.ss.android.socialbase.appdownloader.n.np.oa().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(ve.dk(com.ss.android.downloadlib.addownload.c.getContext(), com.ss.android.socialbase.appdownloader.n.np.oa())));
        ve.m(jSONObject, com.ss.android.socialbase.appdownloader.n.np.oa().replaceAll("\\.", "_") + " versionName", ve.ej(com.ss.android.downloadlib.addownload.c.getContext(), com.ss.android.socialbase.appdownloader.n.np.oa()));
        return jSONObject;
    }
}
