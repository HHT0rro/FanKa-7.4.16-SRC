package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.d;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private JSONObject aGq = new JSONObject();

    private void put(String str, Object obj) {
        try {
            this.aGq.put(str, obj);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        put(str, jSONObject);
    }

    public final void fq(String str) {
        put(d.aFJ, str);
    }

    public final void putInt(String str, int i10) {
        put(str, Integer.valueOf(i10));
    }

    public final void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.length() <= 100) {
            put(str, str2);
        } else {
            c.d("AdExceptionCollector", "string value to long ,max is 100");
        }
    }

    public final String toString() {
        return this.aGq.toString();
    }
}
