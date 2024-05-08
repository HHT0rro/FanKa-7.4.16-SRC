package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class sy {
    private static com.ss.android.downloadlib.addownload.m.ej dk;

    /* renamed from: m, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.m.l f38684m;

    public static com.ss.android.downloadlib.addownload.m.ej dk() {
        return dk;
    }

    public static com.ss.android.downloadlib.addownload.m.l m() {
        return f38684m;
    }

    public static boolean m(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 7 || i10 == 8;
    }

    public static void m(com.ss.android.downloadlib.addownload.m.l lVar) {
        f38684m = lVar;
    }

    public static void m(com.ss.android.downloadlib.addownload.m.ej ejVar) {
        dk = ejVar;
    }

    public static boolean m(final com.ss.android.downloadad.api.m.dk dkVar, DownloadInfo downloadInfo, int i10, final com.ss.android.downloadlib.addownload.l.e eVar, final boolean z10, final com.ss.android.downloadlib.addownload.m.ej ejVar) {
        boolean dk2;
        if (dkVar == null) {
            com.ss.android.downloadlib.np.ej.m().m("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.np.ej.m().m("tryReverseWifi info null");
            return false;
        }
        final int id2 = downloadInfo.getId();
        if (z10) {
            dk2 = com.ss.android.downloadlib.hc.np.ej(dkVar);
        } else {
            dk2 = com.ss.android.downloadlib.hc.np.dk(dkVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(dk2 ? 1 : 0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (z10) {
            com.ss.android.downloadlib.l.m.m().m("cancel_pause_reserve_wifi_switch_status", jSONObject, dkVar);
        } else {
            com.ss.android.downloadlib.l.m.m().m("pause_reserve_wifi_switch_status", jSONObject, dkVar);
        }
        if (!dk2 || !m(i10) || DownloadUtils.isWifi(c.getContext())) {
            return false;
        }
        if (!z10 && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        m(new com.ss.android.downloadlib.addownload.m.l() { // from class: com.ss.android.downloadlib.addownload.sy.1
            @Override // com.ss.android.downloadlib.addownload.m.l
            public void dk() {
                sy.m((com.ss.android.downloadlib.addownload.m.l) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(c.getContext()).getDownloadInfo(id2);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z10) {
                    com.ss.android.downloadlib.l.m.m().m("cancel_pause_reserve_wifi_cancel", dkVar);
                } else {
                    com.ss.android.downloadlib.l.m.m().dk("pause_reserve_wifi_cancel", dkVar);
                }
                eVar.m(dkVar);
            }

            @Override // com.ss.android.downloadlib.addownload.m.l
            public void m() {
                sy.m((com.ss.android.downloadlib.addownload.m.l) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(c.getContext()).getDownloadInfo(id2);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo2);
                    if (z10) {
                        com.ss.android.downloadlib.l.m.m().m("cancel_pause_reserve_wifi_confirm", dkVar);
                    } else {
                        com.ss.android.downloadlib.l.m.m().dk("pause_reserve_wifi_confirm", dkVar);
                    }
                }
                eVar.m(dkVar);
            }
        });
        if (z10 && ejVar != null) {
            m(new com.ss.android.downloadlib.addownload.m.ej() { // from class: com.ss.android.downloadlib.addownload.sy.2
                @Override // com.ss.android.downloadlib.addownload.m.ej
                public void delete() {
                    com.ss.android.downloadlib.l.m.m().m("cancel_pause_reserve_wifi_delete", com.ss.android.downloadad.api.m.dk.this);
                    ejVar.delete();
                }
            });
        }
        if (z10) {
            TTDelegateActivity.m(dkVar, "删除");
        } else {
            TTDelegateActivity.dk(dkVar);
        }
        return true;
    }
}
