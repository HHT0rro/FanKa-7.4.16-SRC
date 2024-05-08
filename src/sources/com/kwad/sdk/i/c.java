package com.kwad.sdk.i;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable unused) {
            j.Jm();
        }
    }

    public static void putValue(JSONObject jSONObject, String str, List<k> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<k> iterator2 = list.iterator2();
                    while (iterator2.hasNext()) {
                        jSONArray.put(iterator2.next().toJson());
                    }
                    jSONObject.put(str, jSONArray);
                }
            } catch (Throwable unused) {
                j.Jm();
            }
        }
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
            j.Jm();
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j10) {
        try {
            jSONObject.put(str, j10);
        } catch (Throwable unused) {
            j.Jm();
        }
    }
}
