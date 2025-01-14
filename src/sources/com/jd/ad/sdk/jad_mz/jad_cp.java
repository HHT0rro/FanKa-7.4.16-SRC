package com.jd.ad.sdk.jad_mz;

import android.app.Application;
import android.text.TextUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_xk.jad_kx;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConfigurationHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cp {
    public static void jad_an(jad_kx.jad_an jad_anVar, String str) {
        String jad_an = com.jd.ad.sdk.jad_do.jad_er.jad_an("aHR0cHM6Ly9qYW5hcGkuamQuY29tL2Fuc2RrL3YxL2luaXREYXRh");
        com.jd.ad.sdk.jad_xk.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_xk.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_ob.jad_fs.jad_cp());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        jad_kx.jad_bo jad_an2 = com.jd.ad.sdk.jad_xk.jad_bo.jad_an();
        jad_an2.jad_er = jad_an;
        jad_an2.jad_bo = jad_fsVar;
        Application jad_an3 = com.jd.ad.sdk.jad_do.jad_bo.jad_an();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aId", JADYunSdk.getAppId());
            jSONObject.put("pId", com.jd.ad.sdk.jad_ob.jad_hu.jad_an(jad_an3));
            jSONObject.put("cat", jad_an.jad_an());
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put("rid", str);
            jSONObject.put("oid", com.jd.ad.sdk.jad_ob.jad_hu.jad_bo());
            jSONObject.put("di", com.jd.ad.sdk.jad_ob.jad_hu.jad_an());
            jSONObject.put("plat", "android");
            jSONObject.put("osv", com.jd.ad.sdk.jad_ob.jad_fs.jad_bo());
            jSONObject.put("sdkv", "2.4.6");
        } catch (JSONException e2) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.AN_REQUEST_JSON_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, 2, jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()), 0);
        }
        StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("AN API Request: ");
        jad_an4.append(jSONObject.toString());
        Logger.d(jad_an4.toString());
        String ja2 = ANEProxy.ja(jSONObject.toString());
        jad_an2.jad_fs = new com.jd.ad.sdk.jad_xk.jad_er(TextUtils.isEmpty(ja2) ? null : ja2.getBytes(Charset.forName("UTF-8")));
        jad_an2.jad_hu = true;
        jad_an2.jad_jt = jad_anVar;
        jad_an2.jad_an(com.jd.ad.sdk.jad_cn.jad_bo.jad_cp);
    }
}
