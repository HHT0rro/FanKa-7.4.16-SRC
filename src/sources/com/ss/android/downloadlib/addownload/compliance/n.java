package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.f;
import com.ss.android.downloadlib.addownload.c;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {

    /* renamed from: m, reason: collision with root package name */
    private final AtomicInteger f38530m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static n f38535m = new n();
    }

    private n() {
        this.f38530m = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dk() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f38530m.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb2.append("/customer/api/app/deep_link");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(@NonNull final com.ss.android.downloadlib.addownload.dk.np npVar, final String str, final byte[] bArr, final e eVar) {
        c.l().m(str, bArr, "application/json; charset=utf-8", 0, new f() { // from class: com.ss.android.downloadlib.addownload.compliance.n.2
            @Override // com.ss.android.download.api.config.f
            public void m(String str2) {
                n.this.m(npVar, str2, eVar);
            }

            @Override // com.ss.android.download.api.config.f
            public void m(Throwable th) {
                n.this.m(npVar, str, bArr, eVar);
            }
        });
    }

    public static n m() {
        return m.f38535m;
    }

    public void m(final com.ss.android.downloadlib.addownload.dk.np npVar, final e eVar) {
        if (c.l() == null) {
            com.ss.android.downloadlib.np.ej.m().m("getDownloadNetworkFactory == NULL");
            m(401, npVar);
        } else {
            com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n nVar = n.this;
                    nVar.dk(npVar, nVar.dk(), n.this.m(npVar, true, 4), eVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.ss.android.downloadlib.addownload.dk.np npVar, String str, byte[] bArr, e eVar) {
        if (this.f38530m.get() < 6) {
            this.f38530m.incrementAndGet();
            dk(npVar, str, bArr, eVar);
        } else {
            m("当前网络不佳，请稍后再试");
            this.f38530m.set(0);
            m(402, npVar);
        }
    }

    private void m(final String str) {
        com.ss.android.downloadlib.hc.m().dk().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.n.3
            @Override // java.lang.Runnable
            public void run() {
                c.ej().m(6, c.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] m(com.ss.android.downloadlib.addownload.dk.np npVar, boolean z10, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", npVar.m());
            jSONObject.put("package_name", npVar.np());
            jSONObject.put("call_scene", 50);
            if (z10) {
                jSONObject.put("sender_package_name", c.getContext().getPackageName());
                jSONObject.put("sender_version", c.oa().np);
                if (i10 > 0) {
                    jSONObject.put("store", i10);
                }
            } else {
                jSONObject.put("id", String.valueOf(npVar.dk()));
                if (npVar.dh().getDeepLink() != null) {
                    if (TextUtils.isEmpty(npVar.dh().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.np.ej.m().m("web_url is null");
                    }
                    jSONObject.put("web_url", npVar.dh().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.np.ej.m().m("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.np.ej.m().m("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@NonNull com.ss.android.downloadlib.addownload.dk.np npVar, String str, e eVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.np.ej.m().m("response content is null");
                m(404, npVar);
                eVar.m();
                return;
            }
            this.f38530m.set(0);
            np hc2 = np.hc(str);
            if (hc2.m() != 0) {
                m(403, npVar);
                eVar.m();
            } else if (TextUtils.isEmpty(hc2.dk())) {
                m(405, npVar);
                eVar.m();
            } else {
                eVar.m(hc2.dk());
            }
        } catch (Exception e2) {
            com.ss.android.downloadlib.np.ej.m().m(e2, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void m(int i10, com.ss.android.downloadlib.addownload.dk.np npVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i10));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("get_miui_market_compliance_error", jSONObject, npVar);
    }

    public void m(int i10, com.ss.android.downloadlib.addownload.dk.np npVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i10));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("get_miui_market_compliance_success", jSONObject, npVar);
    }
}
