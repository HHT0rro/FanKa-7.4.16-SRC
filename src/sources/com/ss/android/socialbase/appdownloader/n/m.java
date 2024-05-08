package com.ss.android.socialbase.appdownloader.n;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.t;
import com.ss.android.socialbase.appdownloader.hc;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {

    /* renamed from: m, reason: collision with root package name */
    private static final HashMap<String, hc.m> f38929m = new HashMap<>();

    public static boolean dk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i10 = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_ALLOW_OS_API_RANGE);
        int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_MIN_OS_API, -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i10 >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i11 = 0; i11 < split.length; i11 += 2) {
                int parseInt = Integer.parseInt(split[i11]);
                int parseInt2 = Integer.parseInt(split[i11 + 1]);
                if (i10 >= parseInt && i10 <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean ej(JSONObject jSONObject) {
        return jSONObject == null || n.m() || jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SECURITY_MODE) != 1;
    }

    public static boolean m(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && m(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return dk(jSONObject) && m(jSONObject.optJSONArray(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_REQUIREMENTS)) && ej(jSONObject);
    }

    public static boolean m(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_PACKAGE_NAMES);
                JSONArray optJSONArray = optJSONObject.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_ALLOW);
                JSONArray optJSONArray2 = optJSONObject.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_BLOCK);
                String optString2 = optJSONObject.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ALLOW_VERSION_RANGE);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(",")) {
                    if ("market".equals(str)) {
                        str = np.oa();
                    }
                    hc.m dk = dk(str);
                    if (dk != null && !(z10 = m(optJSONArray, optJSONArray2, optString2, dk))) {
                        return false;
                    }
                }
            }
        }
        return z10;
    }

    private static boolean dk(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i10).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static hc.m dk(String str) {
        HashMap<String, hc.m> hashMap = f38929m;
        if (hashMap.containsKey(str)) {
            hc.m mVar = hashMap.get(str);
            if (mVar != null) {
                return mVar;
            }
            return null;
        }
        hc.m dk = hc.dk(str);
        hashMap.put(str, dk);
        if (dk != null) {
            return dk;
        }
        return null;
    }

    private static boolean m(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull hc.m mVar) {
        String hc2 = mVar.hc();
        int n10 = mVar.n();
        String str2 = n10 + "_" + hc2;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i10 = 0; i10 < split.length; i10 += 2) {
                    int parseInt = Integer.parseInt(split[i10]);
                    int parseInt2 = Integer.parseInt(split[i10 + 1]);
                    if (n10 >= parseInt && n10 <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (dk(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !dk(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static hc.m m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                hc.m dk = dk(str);
                if (dk != null) {
                    return dk;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean m(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString(t.f36222g);
            try {
                String m10 = ej.m(jSONObject.optString("az"), optString);
                String m11 = ej.m(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(m10);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(m11);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
