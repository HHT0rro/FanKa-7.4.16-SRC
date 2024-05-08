package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {
    public int dk = -1;
    public String ej;

    /* renamed from: l, reason: collision with root package name */
    public String f38892l;

    /* renamed from: m, reason: collision with root package name */
    public String f38893m;
    public String np;

    public JSONObject dk() {
        JSONObject jSONObject = new JSONObject();
        m(jSONObject);
        return jSONObject;
    }

    public String m() {
        return dk().toString();
    }

    public void m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f38893m);
            jSONObject.put("error_code", String.valueOf(this.dk));
            jSONObject.put("error_msg", this.ej);
            jSONObject.put("real_device_plan", this.f38892l);
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, this.np);
        } catch (Throwable unused) {
        }
    }

    public static m m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        m mVar = new m();
        try {
            JSONObject jSONObject = new JSONObject(str);
            mVar.np = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, null);
            mVar.f38892l = jSONObject.optString("real_device_plan", null);
            mVar.ej = jSONObject.optString("error_msg", null);
            mVar.f38893m = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                mVar.dk = -1;
            } else {
                mVar.dk = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mVar;
    }
}
