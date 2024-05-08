package com.kwad.sdk.collector;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int anC;
    private String anB;
    private int state;

    public g(String str, int i10) {
        this.anB = str;
        this.state = i10;
    }

    private String Az() {
        int lastIndexOf;
        String str = this.anB;
        return !TextUtils.isEmpty(str) ? ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (lastIndexOf = str.lastIndexOf(".")) < str.length() + (-1)) ? str.substring(lastIndexOf + 1) : str : str;
    }

    public static JSONArray t(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        Iterator<g> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            jSONArray.put(iterator2.next().toJson());
        }
        return jSONArray;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", Az());
            jSONObject.put("state", this.state);
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
        return jSONObject;
    }
}
