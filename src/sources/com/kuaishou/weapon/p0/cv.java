package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cv {

    /* renamed from: a, reason: collision with root package name */
    public static String f36000a = "appkey";

    /* renamed from: b, reason: collision with root package name */
    public static String f36001b = "secretkey";

    /* renamed from: c, reason: collision with root package name */
    public static String f36002c = "pver";

    /* renamed from: d, reason: collision with root package name */
    public static String f36003d = "sdkver";

    /* renamed from: e, reason: collision with root package name */
    public static String f36004e = "ksid";

    /* renamed from: f, reason: collision with root package name */
    public static String f36005f = "timestamp";

    /* renamed from: g, reason: collision with root package name */
    public static String f36006g = "sign";

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.0");
            jSONObject.put(MonitorConstants.EXTRA_DEVICE_ID, cm.b(context));
            jSONObject.put("iv", com.huawei.hms.ads.dynamicloader.b.f29144f);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            try {
                String b4 = h.a(context, "re_po_rt").b(df.f36070i, bq.f35867e);
                if (TextUtils.isEmpty(b4)) {
                    b4 = bq.f35867e;
                }
                jSONObject.put("pver", b4);
            } catch (Exception unused) {
                jSONObject.put("pver", bq.f35867e);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, 1);
            jSONObject.put("pk", bq.f35869g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.0");
            jSONObject.put(MonitorConstants.EXTRA_DEVICE_ID, cm.b(context));
            jSONObject.put("iv", com.huawei.hms.ads.dynamicloader.b.f29144f);
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap hashMap = new HashMap();
            hashMap.put(f36000a, str);
            hashMap.put(f36001b, str2);
            hashMap.put(f36005f, String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put(f36006g, b(hashMap));
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        Map d10 = d(context);
        if (d10 == null || d10.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : d10.entrySet()) {
            str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    private static String b(Map map) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(map.get(f36000a));
            sb2.append(map.get(f36001b));
            sb2.append(map.get(f36005f));
            return f.a(sb2.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(df.f36068g, bq.f35867e));
            jSONObject.put(Constants.PARAM_PLATFORM, 1);
            jSONObject.put("pk", bq.f35869g);
        } catch (Exception unused) {
        }
    }
}
