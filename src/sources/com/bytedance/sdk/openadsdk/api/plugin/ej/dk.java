package com.bytedance.sdk.openadsdk.api.plugin.ej;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk {
    public static String dk() {
        String m10 = m(8);
        if (m10 == null || m10.length() != 16) {
            return null;
        }
        return m10;
    }

    private static SecureRandom ej() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    @JProtect
    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String m10 = m();
        String m11 = m(m10, 32);
        String dk = dk();
        String str2 = null;
        if (m11 != null && dk != null) {
            str2 = m.m(str, dk, m11);
        }
        return 3 + m10 + dk + str2;
    }

    @JProtect
    public static JSONObject m(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String m10 = m(jSONObject.toString());
                if (!TextUtils.isEmpty(m10)) {
                    jSONObject2.put("message", m10);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static String m() {
        String m10 = m(16);
        if (m10 == null || m10.length() != 32) {
            return null;
        }
        return m10;
    }

    public static String m(String str, int i10) {
        if (str == null || str.length() != i10) {
            return null;
        }
        int i11 = i10 / 2;
        return str.substring(i11, i10) + str.substring(0, i11);
    }

    public static String m(int i10) {
        try {
            byte[] bArr = new byte[i10];
            ej().nextBytes(bArr);
            return ej.m(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
