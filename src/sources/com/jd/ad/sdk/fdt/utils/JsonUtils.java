package com.jd.ad.sdk.fdt.utils;

import android.content.Context;
import com.jd.ad.sdk.logger.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class JsonUtils {
    public static JSONObject getJSONObject(String str, Context context) {
        return new JSONObject(getJson(str, context));
    }

    public static String getJson(String str, Context context) {
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb2.toString();
            }
            sb2.append(readLine);
        }
    }

    public static JSONObject parse2JSONObject(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return new JSONObject();
    }

    public static JSONObject put(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null && obj != null) {
            try {
                if (!(obj instanceof String) && !(obj instanceof Integer) && (obj instanceof Double) && Double.isNaN(((Double) obj).doubleValue())) {
                    obj = -1;
                }
                jSONObject.put(str, obj);
                return jSONObject;
            } catch (JSONException e2) {
                Logger.w("Json error: ", e2.getMessage());
            }
        }
        return jSONObject;
    }
}
