package com.huawei.hianalytics;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.util.DeviceUtil;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.LinkedHashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e0 {
    public static final String lmn = LogTag.get(e0.class, new Class[0]);

    public static JSONObject lmn(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_old_app_version", str2);
            jSONObject.put("_current_app_version", str);
            return jSONObject;
        } catch (JSONException unused) {
            HiLog.e(lmn, "Json Exc : app ver error");
            return null;
        }
    }

    public static JSONObject lmn(Context context) {
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        String locale2 = (configuration == null || (locale = configuration.locale) == null) ? "" : locale.toString();
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        String str2 = Build.VERSION.RELEASE;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        String systemProperty = DeviceUtil.getSystemProperty("ro.product.CustCVersion", "");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_sys_language", locale2);
            jSONObject.put("_cust_version", systemProperty);
            jSONObject.put("_manufacturer", str);
            jSONObject.put("_os", "android");
            jSONObject.put("_os_ver", str2);
            jSONObject.put("_screen_height", i10);
            jSONObject.put("_screen_width", i11);
            return jSONObject;
        } catch (JSONException unused) {
            HiLog.e(lmn, "getDeviceInfo() json Exc,A parameter error!");
            return null;
        }
    }

    public static JSONObject lmn(String str, long j10, LinkedHashMap<String, String> linkedHashMap, String str2) {
        JSONObject lmn2;
        if (linkedHashMap == null) {
            lmn2 = new JSONObject();
        } else {
            lmn2 = g0.lmn(linkedHashMap);
        }
        try {
            if ("OnPause".equals(str2)) {
                lmn2.put("_event_duration", j10);
            }
            lmn2.put("_activity_name", str);
        } catch (JSONException unused) {
            HiLog.e(lmn, "getEventContent(): JSONException");
        }
        return lmn2;
    }
}
