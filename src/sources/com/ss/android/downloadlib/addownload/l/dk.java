package com.ss.android.downloadlib.addownload.l;

import android.text.TextUtils;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk implements hc {
    private static com.ss.android.downloadlib.addownload.m.ej dk;

    /* renamed from: m, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.m.l f38616m;

    public static com.ss.android.downloadlib.addownload.m.ej dk() {
        return dk;
    }

    public static com.ss.android.downloadlib.addownload.m.l m() {
        return f38616m;
    }

    public static void m(com.ss.android.downloadlib.addownload.m.ej ejVar) {
        dk = ejVar;
    }

    @Override // com.ss.android.downloadlib.addownload.l.hc
    public boolean m(final com.ss.android.downloadad.api.m.dk dkVar, int i10, final e eVar, final com.ss.android.downloadlib.addownload.m.ej ejVar) {
        DownloadInfo dk2;
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
        long m10 = com.ss.android.downloadlib.addownload.oa.m(dk2.getId(), dk2.getCurBytes(), dk2.getTotalBytes());
        long totalBytes = dk2.getTotalBytes();
        if (m10 >= 0 && totalBytes > 0) {
            if (totalBytes <= m(dkVar.x())) {
                final int i11 = (int) (m10 / 1048576);
                f38616m = new com.ss.android.downloadlib.addownload.m.l() { // from class: com.ss.android.downloadlib.addownload.l.dk.1
                    @Override // com.ss.android.downloadlib.addownload.m.l
                    public void dk() {
                        com.ss.android.downloadlib.addownload.m.l unused = dk.f38616m = null;
                        dk.this.m(i11, i11, dkVar, "apk_size_cancel", CardEventType.CLICK_ACTION_CANCEL);
                        eVar.m(dkVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.m.l
                    public void m() {
                        com.ss.android.downloadlib.addownload.m.l unused = dk.f38616m = null;
                        dk.this.m(i11, i11, dkVar, "apk_size_cancel", "confirm");
                    }
                };
                String format = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", com.ss.android.downloadlib.hc.ve.m(totalBytes - m10));
                if (ejVar != null) {
                    m(new com.ss.android.downloadlib.addownload.m.ej() { // from class: com.ss.android.downloadlib.addownload.l.dk.2
                        @Override // com.ss.android.downloadlib.addownload.m.ej
                        public void delete() {
                            com.ss.android.downloadlib.addownload.m.l unused = dk.f38616m = null;
                            dk.this.m(i11, i11, dkVar, "apk_size_cancel", "delete");
                            ejVar.delete();
                        }
                    });
                }
                TTDelegateActivity.m(dkVar, format, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int m(int i10) {
        return DownloadSetting.obtain(i10).optInt("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean m(com.ss.android.downloadad.api.m.m mVar) {
        return com.ss.android.downloadlib.hc.np.m(mVar).optInt("cancel_pause_optimise_apk_retain_switch", 0) == 1 && mVar.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i10, int i11, com.ss.android.downloadad.api.m.dk dkVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i10));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i11));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("pause_cancel_optimise", jSONObject, dkVar);
    }
}
