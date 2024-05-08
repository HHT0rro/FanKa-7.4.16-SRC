package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.bk;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.inno.innosdk.pb.InnoMain;
import com.mobile.auth.gatewayauth.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class dk {
    private static SharedPreferences dk;
    private static final List<Pair<String, JSONObject>> ej = new CopyOnWriteArrayList();

    /* renamed from: m, reason: collision with root package name */
    public static final Map<String, String> f11106m = new HashMap();

    public static void dk(String str, JSONObject jSONObject) {
        ej.add(new Pair<>(str, jSONObject));
    }

    private static void l(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", str);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
            return;
        }
        np(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject n(String str, JSONObject jSONObject) {
        String str2 = "5.6.0.3";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            jSONObject2.put("ad_sdk_version", "5.6.0.3");
            String m10 = l.m("com.byted.pangle.m");
            if (!TextUtils.isEmpty(m10)) {
                str2 = m10;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = f11106m;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(bk.f9900i, Build.MODEL);
            jSONObject3.put(Constant.LOGIN_ACTIVITY_VENDOR_KEY, Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put(InnoMain.INNO_KEY_OAID, map.get(InnoMain.INNO_KEY_OAID));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private static void np(final String str, final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.np.m.m().dk(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.dk.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dk.n(String.this, jSONObject));
                dk.dk(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dk(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        if (dk == null) {
            dk = TTAppContextHolder.getContext().getSharedPreferences("tt_sdk_settings_other", 0);
        }
        String format = String.format("https://%s%s", dk.getString("url_alog", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = ej;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(n((String) pair.first, (JSONObject) pair.second));
                }
                ej.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.dk.ej.m().m(true, format, com.bytedance.sdk.openadsdk.api.plugin.ej.dk.m(jSONObject).toString().getBytes());
    }

    public static void m(int i10, String str, long j10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j10));
            jSONObject.putOpt("code", Integer.valueOf(i10));
            jSONObject.putOpt("message", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        np("plugin_load_failed", jSONObject);
    }

    public static void m(String str, JSONObject jSONObject) {
        l("zeus_" + str, jSONObject);
    }

    public static void m() {
        List<Pair<String, JSONObject>> list = ej;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    l((String) pair.first, (JSONObject) pair.second);
                }
            }
            ej.clear();
        } catch (Exception unused) {
        }
    }

    public static void m(AdConfig adConfig) {
        String str;
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = f11106m;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        if (pluginUpdateConfig != 0) {
            str = pluginUpdateConfig + "";
        } else {
            str = "2";
        }
        map.put("plugin_update_conf", str);
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put(InnoMain.INNO_KEY_OAID, customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}
