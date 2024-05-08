package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class dk {
    public static JSONObject a() {
        try {
            String str = System.getenv("LD_PRELOAD");
            String str2 = System.getenv("LD_LIBRARY_PATH");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("0", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("1", str2);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b() {
        try {
            String a10 = bk.a();
            if (TextUtils.isEmpty(a10) || a10.contains("arm64")) {
                return 0;
            }
            return !a10.contains("64") ? 1 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
