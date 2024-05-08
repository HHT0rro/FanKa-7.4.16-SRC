package com.ss.android.downloadlib.addownload.l;

import android.text.TextUtils;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej implements hc {
    private static com.ss.android.downloadlib.addownload.m.ej dk;

    /* renamed from: m, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.m.l f38621m;

    public static com.ss.android.downloadlib.addownload.m.ej dk() {
        return dk;
    }

    public static com.ss.android.downloadlib.addownload.m.l m() {
        return f38621m;
    }

    public static void m(com.ss.android.downloadlib.addownload.m.ej ejVar) {
        dk = ejVar;
    }

    @Override // com.ss.android.downloadlib.addownload.l.hc
    public boolean m(final com.ss.android.downloadad.api.m.dk dkVar, int i10, final e eVar, final com.ss.android.downloadlib.addownload.m.ej ejVar) {
        DownloadInfo dk2;
        String format;
        if (dkVar == null || !m(dkVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(dkVar.ch())) {
            dk2 = com.ss.android.downloadlib.e.m(com.ss.android.downloadlib.addownload.c.getContext()).m(dkVar.ch(), null, true);
        } else {
            dk2 = com.ss.android.downloadlib.e.m(com.ss.android.downloadlib.addownload.c.getContext()).dk(dkVar.m());
        }
        if (dk2 == null) {
            return false;
        }
        long curBytes = dk2.getCurBytes();
        long totalBytes = dk2.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        final int m10 = com.ss.android.downloadlib.addownload.oa.m(dk2.getId(), (int) ((100 * curBytes) / totalBytes));
        final int i11 = (int) (curBytes / 1048576);
        boolean z10 = m10 > m(dkVar.x());
        f38621m = new com.ss.android.downloadlib.addownload.m.l() { // from class: com.ss.android.downloadlib.addownload.l.ej.1
            @Override // com.ss.android.downloadlib.addownload.m.l
            public void dk() {
                com.ss.android.downloadlib.addownload.m.l unused = ej.f38621m = null;
                ej.this.m(m10, i11, i11, dkVar, "download_percent_cancel", CardEventType.CLICK_ACTION_CANCEL);
                eVar.m(dkVar);
            }

            @Override // com.ss.android.downloadlib.addownload.m.l
            public void m() {
                com.ss.android.downloadlib.addownload.m.l unused = ej.f38621m = null;
                ej.this.m(m10, i11, i11, dkVar, "download_percent_cancel", "confirm");
            }
        };
        String m11 = com.ss.android.downloadlib.hc.ve.m(com.ss.android.downloadlib.addownload.oa.m(dkVar.x(), curBytes, totalBytes));
        if (z10) {
            format = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", m11, com.ss.android.downloadlib.hc.ve.m(totalBytes - curBytes));
        } else {
            format = String.format("该任务已下载%s，即将下载完成，是否继续下载？", m11);
        }
        String str = format;
        if (ejVar != null) {
            m(new com.ss.android.downloadlib.addownload.m.ej() { // from class: com.ss.android.downloadlib.addownload.l.ej.2
                @Override // com.ss.android.downloadlib.addownload.m.ej
                public void delete() {
                    com.ss.android.downloadlib.addownload.m.l unused = ej.f38621m = null;
                    ej.this.m(m10, i11, i11, dkVar, "download_percent_cancel", "delete");
                    ejVar.delete();
                }
            });
        }
        TTDelegateActivity.dk(dkVar, str, "继续", "暂停", "删除");
        return true;
    }

    private int m(int i10) {
        return DownloadSetting.obtain(i10).optInt("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean m(com.ss.android.downloadad.api.m.m mVar) {
        return com.ss.android.downloadlib.hc.np.m(mVar).optInt("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && mVar.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i10, int i11, int i12, com.ss.android.downloadad.api.m.dk dkVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i10));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i11));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i12));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("pause_cancel_optimise", jSONObject, dkVar);
    }
}
