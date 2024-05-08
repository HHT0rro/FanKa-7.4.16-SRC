package com.ss.android.downloadlib.addownload.compliance;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class hc {
    public static void dk(String str, long j10) {
        m(str, null, j10);
    }

    public static void m(String str, long j10) {
        com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(j10);
        if (np.s()) {
            return;
        }
        np.ej.setRefer(str);
        com.ss.android.downloadlib.l.m.m().dk("lp_app_dialog_click", np);
    }

    public static void m(String str, JSONObject jSONObject, long j10) {
        com.ss.android.downloadlib.l.m.m().dk(str, jSONObject, com.ss.android.downloadlib.addownload.dk.n.m().np(j10));
    }

    public static void m(String str, com.ss.android.downloadlib.addownload.dk.np npVar) {
        com.ss.android.downloadlib.l.m.m().dk(str, npVar);
    }

    public static void m(int i10, com.ss.android.downloadlib.addownload.dk.np npVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i10));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().dk("lp_compliance_error", jSONObject, npVar);
    }

    public static void m(int i10, long j10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i10));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().dk("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.dk.n.m().np(j10));
    }
}
