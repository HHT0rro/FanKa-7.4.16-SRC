package com.kwai.adclient.kscommerciallogger;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static final String[] aTA = {"cache_limit", "cache_num", "segment_name_top1", "segment_count_top1"};

    public static boolean hk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[a-z][a-z0-9]*(_{1}[a-z0-9]+)+$", str);
    }

    public static String z(JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.toString();
    }
}
