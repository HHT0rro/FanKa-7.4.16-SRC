package com.ss.android.downloadlib.addownload.l;

import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class oa implements w {
    private boolean dk(int i10) {
        return DownloadSetting.obtain(i10).optInt("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.l.w
    public boolean m(com.ss.android.downloadad.api.m.dk dkVar, int i10, e eVar) {
        if (dkVar == null || !dk(dkVar.x())) {
            return false;
        }
        if (System.currentTimeMillis() - dkVar.fh() > m(dkVar.x())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("pause_optimise", jSONObject, dkVar);
        return true;
    }

    private long m(int i10) {
        return DownloadSetting.obtain(i10).optInt("pause_optimise_mistake_click_interval", 300);
    }
}
