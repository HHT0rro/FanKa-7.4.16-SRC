package com.ss.android.downloadlib.hc;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {
    public static void dk(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.c t2 = com.ss.android.downloadlib.addownload.c.t();
        if (t2 != null) {
            t2.m(3, str, str2, jSONObject);
        }
    }

    public static void ej(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.c t2 = com.ss.android.downloadlib.addownload.c.t();
        if (t2 != null) {
            t2.m(6, str, str2, jSONObject);
        }
    }

    public static void m(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.c t2 = com.ss.android.downloadlib.addownload.c.t();
        if (t2 != null) {
            t2.m(2, str, str2, jSONObject);
        }
    }

    public static void m(String str, String str2) {
        ej(str, str2, null);
    }

    public static void m(String str) {
        ej(null, str, null);
    }
}
