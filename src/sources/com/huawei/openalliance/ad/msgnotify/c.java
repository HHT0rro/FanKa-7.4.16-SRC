package com.huawei.openalliance.ad.msgnotify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.utils.SafeIntent;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class c {
    private static final String Code = "MsgConverter";

    public static Intent Code(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Intent intent = new Intent();
            String optString = jSONObject.optString(ax.f32277t);
            intent.setAction(jSONObject.optString(ax.f32280w));
            intent.putExtra(ax.f32277t, optString);
            JSONObject optJSONObject = jSONObject.optJSONObject(ax.f32278u);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = optJSONObject.get(next);
                    if (obj instanceof Serializable) {
                        intent.putExtra(next, (Serializable) obj);
                    }
                }
            }
            return intent;
        } catch (JSONException unused) {
            gl.I(Code, "convertMsgJsonToIntent JSONException");
            return null;
        }
    }

    public static String Code(String str, String str2, Intent intent) {
        SafeIntent safeIntent;
        Bundle extras;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && intent != null && (extras = (safeIntent = new SafeIntent(intent)).getExtras()) != null) {
            Set<String> keySet = extras.keySet();
            JSONObject jSONObject = new JSONObject();
            for (String str3 : keySet) {
                try {
                    jSONObject.putOpt(str3, extras.get(str3));
                } catch (JSONException unused) {
                    gl.I(Code, "convertMsgToJson - msg json set exception");
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(ax.f32276s, str);
                jSONObject2.put(ax.f32277t, str2);
                jSONObject2.put(ax.f32278u, jSONObject);
                jSONObject2.put(ax.f32280w, safeIntent.getAction());
                return jSONObject2.toString();
            } catch (JSONException unused2) {
                gl.I(Code, "convertMsgToJson - param json set exception");
            }
        }
        return "";
    }
}
