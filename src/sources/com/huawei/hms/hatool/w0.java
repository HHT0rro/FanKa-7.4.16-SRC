package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class w0 {
    private static void a(String str, String str2) {
        b0.a().a(new j1(str, str2));
    }

    public static boolean a() {
        String a10 = q0.a();
        if (TextUtils.isEmpty(a10)) {
            a10 = d.a(q0.i(), "Privacy_MY", "public_key_time_interval", "");
            q0.f(a10);
        }
        String m10 = q0.m();
        if (TextUtils.isEmpty(m10)) {
            m10 = d.a(q0.i(), "Privacy_MY", "public_key_time_last", "");
            q0.c(m10);
        }
        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(m10)) {
            try {
                return System.currentTimeMillis() - Long.parseLong(m10) > ((long) Integer.parseInt(a10));
            } catch (NumberFormatException e2) {
                v.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e2.getMessage());
            }
        }
        return true;
    }

    public static void b(String str, String str2) {
        n0 n0Var;
        String str3;
        String replace = "{url}/getPublicKey?keytype=4".replace(FrameworkConstant.URL_PALCEHOLDER, a1.f(str, str2));
        String f10 = q0.f();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", f10);
        try {
            n0Var = w.a(replace, new byte[0], hashMap);
        } catch (Exception e2) {
            v.e("GetPublicKey", "get pubKey response Exception :" + e2.getMessage());
            n0Var = null;
        }
        if (n0Var == null) {
            str3 = "get pubKey response is null";
        } else if (n0Var.b() == 200) {
            if (TextUtils.isEmpty(n0Var.a())) {
                return;
            }
            d(n0Var.a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + n0Var.b();
        }
        v.e("GetPublicKey", str3);
    }

    public static String c(String str, String str2) {
        String o10;
        String c4 = q0.c();
        if (TextUtils.isEmpty(c4)) {
            c4 = d.a(q0.i(), "Privacy_MY", "public_key_version", "");
            q0.g(c4);
        }
        if (!"2.0".equals(c4)) {
            a(str, str2);
            return null;
        }
        if (FrameworkConstant.DataType.STRING_MAINT.equals(str2)) {
            o10 = q0.n();
            if (TextUtils.isEmpty(o10)) {
                o10 = ua.a.d("HiAnalytics_Sdk_Public_Sp_Key", d.a(q0.i(), "Privacy_MY", "public_key_maint", ""));
                q0.d(o10);
            }
        } else {
            o10 = q0.o();
            if (TextUtils.isEmpty(o10)) {
                o10 = ua.a.d("HiAnalytics_Sdk_Public_Sp_Key", d.a(q0.i(), "Privacy_MY", "public_key_oper", ""));
                q0.e(o10);
            }
        }
        if (!TextUtils.isEmpty(o10) && !a()) {
            return o10;
        }
        a(str, str2);
        return null;
    }

    private static void d(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("publicKey");
            String optString2 = jSONObject.optString("publicKeyOM");
            String optString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String optString4 = jSONObject.optString("timeInterval");
            d.b(q0.i(), "Privacy_MY", "public_key_oper", ua.a.g("HiAnalytics_Sdk_Public_Sp_Key", optString));
            d.b(q0.i(), "Privacy_MY", "public_key_maint", ua.a.g("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            d.b(q0.i(), "Privacy_MY", "public_key_time_interval", optString4);
            d.b(q0.i(), "Privacy_MY", "public_key_version", optString3);
            d.b(q0.i(), "Privacy_MY", "public_key_time_last", str3);
            q0.e(optString);
            q0.d(optString2);
            q0.g(optString3);
            q0.c(str3);
            q0.f(optString4);
        } catch (JSONException e2) {
            v.e("GetPublicKey", "get pubKey parse json JSONException :" + e2.getMessage());
        }
    }
}
