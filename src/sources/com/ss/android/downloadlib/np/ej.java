package com.ss.android.downloadlib.np;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.quickcard.base.Attributes;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.appdownloader.n.n;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej implements com.ss.android.download.api.dk.m {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static ej f38827m = new ej();
    }

    public static ej m() {
        return m.f38827m;
    }

    public void dk(String str) {
        dk(true, str);
    }

    public void dk(boolean z10, String str) {
        if (dk()) {
            return;
        }
        if (z10) {
            dk(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        ve.m(jSONObject, "msg", str);
        ve.m(jSONObject, Attributes.Component.STACK, m(new Throwable()));
        c.e().m("service_ttdownloader", 3, jSONObject);
    }

    @Override // com.ss.android.download.api.dk.m
    public void m(Throwable th, String str) {
        m(true, th, str);
    }

    public void m(boolean z10, Throwable th, String str) {
        if (dk()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z10) {
            dk(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        ve.m(jSONObject, "msg", str);
        ve.m(jSONObject, Attributes.Component.STACK, Log.getStackTraceString(th));
        c.e().m("service_ttdownloader", 1, jSONObject);
    }

    private void dk(Throwable th) {
        if (n.dk(c.getContext())) {
            throw new com.ss.android.downloadlib.np.m(th);
        }
    }

    private boolean dk() {
        return c.w().optInt("enable_monitor", 1) != 1;
    }

    public void m(String str) {
        m(true, str);
    }

    public void m(boolean z10, String str) {
        if (dk()) {
            return;
        }
        if (z10) {
            dk(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        ve.m(jSONObject, "msg", str);
        ve.m(jSONObject, Attributes.Component.STACK, m(new Throwable()));
        c.e().m("service_ttdownloader", 2, jSONObject);
    }

    public static String m(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}
