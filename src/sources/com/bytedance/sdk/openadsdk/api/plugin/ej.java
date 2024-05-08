package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej {
    private long dk;
    private long ej;

    /* renamed from: l, reason: collision with root package name */
    private Map<String, Long> f11114l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private String f11115m;

    private ej(String str, long j10) {
        this.f11115m = str;
        this.dk = j10;
        this.ej = j10;
    }

    public static ej m(String str) {
        return new ej(str, SystemClock.elapsedRealtime());
    }

    public long dk(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.ej;
        this.ej = SystemClock.elapsedRealtime();
        this.f11114l.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public long m() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.dk;
        this.f11114l.put(this.f11115m, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void m(JSONObject jSONObject, long j10) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f11114l.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j10) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
