package com.ss.android.downloadlib.dk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.x;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {
    public static void dk(com.ss.android.downloadad.api.m.dk dkVar) {
        if (dkVar == null) {
            return;
        }
        String n10 = DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 ? dkVar.n() : null;
        JSONObject m10 = com.ss.android.downloadlib.hc.n.m(new JSONObject(), dkVar);
        ve.m(m10, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.l.m.m().dk("applink_click", m10, dkVar);
        com.ss.android.downloadlib.addownload.dk.hc m11 = com.ss.android.downloadlib.hc.w.m(n10, dkVar);
        if (m11.getType() == 2) {
            if (!TextUtils.isEmpty(n10)) {
                dk("dialog_by_url", m11, m10, dkVar);
            }
            m11 = com.ss.android.downloadlib.hc.w.m(c.getContext(), dkVar.np(), dkVar);
        }
        int type = m11.getType();
        if (type == 1) {
            dk("dialog_by_url", m10, dkVar);
            return;
        }
        if (type == 3) {
            m("dialog_by_package", m10, dkVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.np.ej.m().dk("AppLinkClickDialog default");
        } else {
            m("dialog_by_package", m11, m10, dkVar);
        }
    }

    public static boolean m(@NonNull com.ss.android.downloadlib.addownload.dk.np npVar) {
        boolean z10;
        DeepLink deepLink = npVar.dk.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject m10 = com.ss.android.downloadlib.hc.n.m(new JSONObject(), npVar);
        ve.m(m10, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.l.m.m().dk("applink_click", m10, npVar);
        com.ss.android.downloadlib.addownload.dk.hc m11 = com.ss.android.downloadlib.hc.w.m(openUrl, npVar);
        if (m11.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                dk("by_url", m11, m10, npVar);
            }
            m11 = com.ss.android.downloadlib.hc.w.m(c.getContext(), npVar.dk.getPackageName(), npVar);
        }
        boolean z11 = false;
        if (m(npVar.f38586m) && c.w().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = npVar.dk;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.l.m.m().m(npVar.f38586m, 0);
            z10 = true;
        } else {
            z10 = false;
        }
        int type = m11.getType();
        if (type == 1) {
            dk("by_url", m10, npVar);
        } else if (type == 3) {
            m("by_package", m10, npVar);
        } else {
            if (type != 4) {
                com.ss.android.downloadlib.np.ej.m().dk("AppLinkClick default");
            } else {
                m("by_package", m11, m10, npVar);
            }
            if (z11 && !z10 && ((com.ss.android.downloadlib.l.ej.m().dk() && !com.ss.android.downloadlib.l.ej.m().dk(npVar.f38586m, npVar.dk.getLogExtra())) || com.ss.android.downloadlib.l.ej.m().ej())) {
                com.ss.android.downloadlib.l.m.m().m(npVar.f38586m, 2);
            }
            return z11;
        }
        z11 = true;
        if (z11) {
            com.ss.android.downloadlib.l.m.m().m(npVar.f38586m, 2);
        }
        return z11;
    }

    public static void dk(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.m.m mVar) {
        ve.m(jSONObject, "applink_source", str);
        ve.m(jSONObject, "download_scene", Integer.valueOf(mVar.mj()));
        com.ss.android.downloadlib.l.m.m().dk("deeplink_url_open", jSONObject, mVar);
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1721882089:
                if (str.equals("auto_by_url")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1374618233:
                if (str.equals("by_url")) {
                    c4 = 1;
                    break;
                }
                break;
            case -129544387:
                if (str.equals("notify_by_url")) {
                    c4 = 2;
                    break;
                }
                break;
            case 829750366:
                if (str.equals("dialog_by_url")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
                if ((c.w().optInt("check_applink_mode") & 1) != 0) {
                    ve.m(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    np.m().m(new l() { // from class: com.ss.android.downloadlib.dk.m.2
                        @Override // com.ss.android.downloadlib.dk.l
                        public void m(boolean z10) {
                            com.ss.android.downloadlib.l.m.m().dk(z10 ? "deeplink_success" : "deeplink_failed", jSONObject, mVar);
                            if (z10) {
                                c.dh().m(c.getContext(), mVar.dh(), mVar.v(), mVar.li(), mVar.np(), 0);
                            }
                        }
                    });
                    return;
                } else {
                    c.dk().m(c.getContext(), mVar.dh(), mVar.v(), mVar.li(), mVar.np(), str);
                    return;
                }
            default:
                return;
        }
    }

    public static void m(@NonNull com.ss.android.downloadad.api.m.dk dkVar) {
        String n10 = dkVar.n();
        JSONObject m10 = com.ss.android.downloadlib.hc.n.m(new JSONObject(), dkVar);
        ve.m(m10, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.l.m.m().dk("applink_click", m10, dkVar);
        com.ss.android.downloadlib.addownload.dk.hc m11 = com.ss.android.downloadlib.hc.w.m(n10, dkVar);
        if (m11.getType() == 2) {
            if (!TextUtils.isEmpty(n10)) {
                dk("notify_by_url", m11, m10, dkVar);
            }
            m11 = com.ss.android.downloadlib.hc.w.m(c.getContext(), dkVar.np(), dkVar);
        }
        int type = m11.getType();
        if (type == 1) {
            dk("notify_by_url", m10, dkVar);
            return;
        }
        if (type == 3) {
            m("notify_by_package", m10, dkVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.np.ej.m().dk("AppLinkClickNotification default");
        } else {
            m("notify_by_package", m11, m10, dkVar);
        }
    }

    public static void dk(String str, @NonNull com.ss.android.downloadlib.addownload.dk.hc hcVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.m.m mVar) {
        ve.m(jSONObject, "applink_source", str);
        ve.m(jSONObject, "error_code", Integer.valueOf(hcVar.m()));
        ve.m(jSONObject, "download_scene", Integer.valueOf(mVar.mj()));
        com.ss.android.downloadlib.l.m.m().dk("deeplink_url_open_fail", jSONObject, mVar);
    }

    public static boolean m(String str, @NonNull com.ss.android.downloadad.api.m.dk dkVar) {
        if (!com.ss.android.downloadlib.addownload.w.dk(dkVar.bz())) {
            return false;
        }
        if (TextUtils.isEmpty(dkVar.n()) && TextUtils.isEmpty(str)) {
            return false;
        }
        DownloadNotificationManager.getInstance().cancelNotification(dkVar.x());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.hc.n.m(jSONObject, dkVar);
        ve.m(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.l.m.m().dk("applink_click", dkVar);
        com.ss.android.downloadlib.addownload.dk.hc m10 = com.ss.android.downloadlib.hc.w.m(dkVar, dkVar.n(), dkVar.np());
        int type = m10.getType();
        if (type == 1) {
            dk("auto_by_url", jSONObject, dkVar);
            return true;
        }
        if (type == 2) {
            dk("auto_by_url", m10, jSONObject, dkVar);
            return false;
        }
        if (type == 3) {
            m("auto_by_package", jSONObject, dkVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        m("auto_by_package", m10, jSONObject, dkVar);
        return false;
    }

    public static void m(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.m.m mVar) {
        ve.m(jSONObject, "applink_source", str);
        ve.m(jSONObject, "download_scene", Integer.valueOf(mVar.mj()));
        com.ss.android.downloadlib.l.m.m().dk("deeplink_app_open", jSONObject, mVar);
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1282070764:
                if (str.equals("notify_by_package")) {
                    c4 = 0;
                    break;
                }
                break;
            case -441514770:
                if (str.equals("auto_by_package")) {
                    c4 = 1;
                    break;
                }
                break;
            case -185950114:
                if (str.equals("by_package")) {
                    c4 = 2;
                    break;
                }
                break;
            case 368401333:
                if (str.equals("dialog_by_package")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
                if ((c.w().optInt("check_applink_mode") & 1) != 0) {
                    ve.m(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    np.m().m(new l() { // from class: com.ss.android.downloadlib.dk.m.1
                        @Override // com.ss.android.downloadlib.dk.l
                        public void m(boolean z10) {
                            com.ss.android.downloadlib.l.m.m().dk(z10 ? "deeplink_success" : "deeplink_failed", jSONObject, mVar);
                            if (z10) {
                                c.dh().m(c.getContext(), mVar.dh(), mVar.v(), mVar.li(), mVar.np(), 0);
                            }
                        }
                    });
                    return;
                } else {
                    c.dk().m(c.getContext(), mVar.dh(), mVar.v(), mVar.li(), mVar.np(), str);
                    return;
                }
            default:
                return;
        }
    }

    public static void m(String str, @NonNull com.ss.android.downloadlib.addownload.dk.hc hcVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.m.m mVar) {
        ve.m(jSONObject, "applink_source", str);
        ve.m(jSONObject, "error_code", Integer.valueOf(hcVar.m()));
        ve.m(jSONObject, "download_scene", Integer.valueOf(mVar.mj()));
        com.ss.android.downloadlib.l.m.m().dk("deeplink_app_open_fail", jSONObject, mVar);
    }

    public static boolean m(@NonNull com.ss.android.downloadlib.addownload.dk.np npVar, int i10) {
        JSONObject jSONObject = new JSONObject();
        ve.m(jSONObject, "download_scene", Integer.valueOf(npVar.mj()));
        com.ss.android.downloadlib.l.m.m().dk("market_click_open", jSONObject, npVar);
        com.ss.android.downloadlib.addownload.dk.hc m10 = com.ss.android.downloadlib.hc.w.m(c.getContext(), npVar, npVar.dk.getPackageName());
        String m11 = ve.m(m10.dk(), "open_market");
        int type = m10.getType();
        if (type == 5) {
            m(m11, jSONObject, npVar, true);
        } else {
            if (type == 6) {
                ve.m(jSONObject, "error_code", Integer.valueOf(m10.m()));
                ve.m(jSONObject, "download_scene", Integer.valueOf(npVar.mj()));
                com.ss.android.downloadlib.l.m.m().dk("market_open_failed", jSONObject, npVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.l.m.m().m(npVar.f38586m, i10);
        return true;
    }

    public static void m(final String str, @Nullable final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.dk.np npVar, boolean z10) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e2) {
                com.ss.android.downloadlib.np.ej.m().m(e2, "onMarketSuccess");
                return;
            }
        }
        ve.m(jSONObject, "applink_source", str);
        ve.m(jSONObject, "download_scene", Integer.valueOf(npVar.mj()));
        if (z10) {
            com.ss.android.downloadlib.l.m.m().dk("market_open_success", jSONObject, npVar);
        }
        if ((c.w().optInt("check_applink_mode") & 4) != 0) {
            np.m().dk(new l() { // from class: com.ss.android.downloadlib.dk.m.3
                @Override // com.ss.android.downloadlib.dk.l
                public void m(boolean z11) {
                    if (!z11 && !"open_market".equals(String.this)) {
                        m.m(com.ss.android.downloadlib.hc.w.m(c.getContext(), Uri.parse("market://details?id=" + npVar.np())), npVar, false);
                    }
                    com.ss.android.downloadlib.l.m.m().m(z11 ? "market_delay_success" : "market_delay_failed", jSONObject, npVar);
                    if (z11) {
                        x dh = c.dh();
                        Context context = c.getContext();
                        com.ss.android.downloadlib.addownload.dk.np npVar2 = npVar;
                        DownloadModel downloadModel = npVar2.dk;
                        dh.m(context, downloadModel, npVar2.f38585l, npVar2.ej, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.download.api.config.ej dk = c.dk();
            Context context = c.getContext();
            DownloadModel downloadModel = npVar.dk;
            dk.m(context, downloadModel, npVar.f38585l, npVar.ej, downloadModel.getPackageName(), str);
        }
        com.ss.android.downloadad.api.m.dk dkVar = new com.ss.android.downloadad.api.m.dk(npVar.dk, npVar.ej, npVar.f38585l);
        dkVar.np(2);
        dkVar.n(System.currentTimeMillis());
        dkVar.e(4);
        dkVar.w(2);
        com.ss.android.downloadlib.addownload.dk.n.m().m(dkVar);
    }

    public static void m(com.ss.android.downloadlib.addownload.dk.hc hcVar, com.ss.android.downloadlib.addownload.dk.np npVar, boolean z10) {
        String m10 = ve.m(hcVar.dk(), "open_market");
        JSONObject jSONObject = new JSONObject();
        ve.m(jSONObject, "ttdownloader_type", "backup");
        int type = hcVar.getType();
        if (type == 5) {
            m(m10, jSONObject, npVar, z10);
        } else {
            if (type != 6) {
                return;
            }
            ve.m(jSONObject, "error_code", Integer.valueOf(hcVar.m()));
            ve.m(jSONObject, "download_scene", Integer.valueOf(npVar.mj()));
            com.ss.android.downloadlib.l.m.m().dk("market_open_failed", jSONObject, npVar);
        }
    }

    public static boolean m(long j10) {
        return com.ss.android.downloadlib.addownload.dk.n.m().l(j10) == null;
    }
}
