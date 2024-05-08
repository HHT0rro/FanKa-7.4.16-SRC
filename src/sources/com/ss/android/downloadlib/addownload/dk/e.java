package com.ss.android.downloadlib.addownload.dk;

import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: m, reason: collision with root package name */
    private static volatile e f38564m;

    private e() {
    }

    public static e m() {
        if (f38564m == null) {
            synchronized (l.class) {
                if (f38564m == null) {
                    f38564m = new e();
                }
            }
        }
        return f38564m;
    }

    public void m(int i10, int i11, com.ss.android.downloadad.api.m.dk dkVar) {
        if (dkVar == null) {
            return;
        }
        DownloadSetting obtain = DownloadSetting.obtain(dkVar.x());
        if (obtain.optInt("report_api_hijack", 0) == 0) {
            return;
        }
        int i12 = i11 - i10;
        if (i10 <= 0 || i12 <= obtain.optInt("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i12);
            jSONObject.put("installed_version_code", i11);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().dk("api_hijack", jSONObject, dkVar);
    }
}
