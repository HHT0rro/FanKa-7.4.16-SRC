package com.ss.android.downloadlib.addownload.l;

import android.text.TextUtils;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n implements w {

    /* renamed from: m, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.m.l f38631m;

    public static com.ss.android.downloadlib.addownload.m.l m() {
        return f38631m;
    }

    @Override // com.ss.android.downloadlib.addownload.l.w
    public boolean m(final com.ss.android.downloadad.api.m.dk dkVar, int i10, final e eVar) {
        DownloadInfo dk;
        if (dkVar == null || dkVar.gg() || !m(dkVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(dkVar.ch())) {
            dk = com.ss.android.downloadlib.e.m(com.ss.android.downloadlib.addownload.c.getContext()).m(dkVar.ch(), null, true);
        } else {
            dk = com.ss.android.downloadlib.e.m(com.ss.android.downloadlib.addownload.c.getContext()).dk(dkVar.m());
        }
        if (dk == null) {
            return false;
        }
        long curBytes = dk.getCurBytes();
        long totalBytes = dk.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int m10 = com.ss.android.downloadlib.addownload.oa.m(dk.getId(), (int) ((curBytes * 100) / totalBytes));
            if (m10 > m(dkVar.x())) {
                f38631m = new com.ss.android.downloadlib.addownload.m.l() { // from class: com.ss.android.downloadlib.addownload.l.n.1
                    @Override // com.ss.android.downloadlib.addownload.m.l
                    public void dk() {
                        com.ss.android.downloadlib.addownload.m.l unused = n.f38631m = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", CardEventType.CLICK_ACTION_CANCEL);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.l.m.m().m("pause_optimise", jSONObject, dkVar);
                        eVar.m(dkVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.m.l
                    public void m() {
                        com.ss.android.downloadlib.addownload.m.l unused = n.f38631m = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.l.m.m().m("pause_optimise", jSONObject, dkVar);
                    }
                };
                TTDelegateActivity.dk(dkVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(m10)), "继续", "暂停");
                dkVar.q(true);
                return true;
            }
        }
        return false;
    }

    private int m(int i10) {
        return DownloadSetting.obtain(i10).optInt("pause_optimise_download_percent", 50);
    }

    private boolean m(com.ss.android.downloadad.api.m.m mVar) {
        return com.ss.android.downloadlib.hc.np.m(mVar).optInt("pause_optimise_download_percent_switch", 0) == 1 && mVar.t();
    }
}
