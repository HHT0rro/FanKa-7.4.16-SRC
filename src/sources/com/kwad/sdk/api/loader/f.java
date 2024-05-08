package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.realidentity.build.aq;
import com.huawei.openalliance.ad.constant.bg;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class f {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final v amj;
    private int amk;
    private String aml;
    private final String mUrl;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(a.b bVar);
    }

    public f(v vVar) {
        this.amj = vVar;
        String Am = vVar.Am();
        this.mUrl = Am;
        this.aml = Am;
    }

    private static Map<String, String> Ad() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, "zh-CN");
        hashMap.put(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
        hashMap.put("Charset", "UTF-8");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("User-Agent", RequestParamsUtils.getUserAgent());
        return hashMap;
    }

    private static HttpURLConnection cc(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    private String e(Map<String, String> map) {
        String az = g.az(this.amj.getContext());
        if (TextUtils.isEmpty(az)) {
            az = this.amj.An().getSDKVersion();
        }
        int sDKVersionCode = this.amj.An().getSDKVersionCode();
        JSONObject appInfo = this.amj.An().getAppInfo();
        JSONObject deviceInfo = this.amj.An().getDeviceInfo();
        JSONObject networkInfo = this.amj.An().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        l.putValue(jSONObject, "sdkApiVersion", BuildConfig.VERSION_NAME);
        l.putValue(jSONObject, "sdkApiVersionCode", BuildConfig.VERSION_CODE);
        l.putValue(jSONObject, bg.e.Code, az);
        l.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        l.putValue(jSONObject, ALBiometricsKeys.KEY_SDK_TYPE, 1);
        l.putValue(jSONObject, "appInfo", appInfo);
        l.putValue(jSONObject, aq.F, deviceInfo);
        l.putValue(jSONObject, "networkInfo", networkInfo);
        l.putValue(jSONObject, "sdkAbi", w.xK());
        String jSONObject2 = jSONObject.toString();
        this.amj.An().addHp(map);
        JSONObject jSONObject3 = new JSONObject();
        l.putValue(jSONObject3, "version", BuildConfig.VERSION_NAME);
        l.putValue(jSONObject3, "appId", appInfo.optString("appId"));
        l.putValue(jSONObject3, "message", this.amj.An().getRM(jSONObject2));
        this.amj.An().sR(this.mUrl, map, jSONObject3.toString());
        return jSONObject3.toString();
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> Ad = Ad();
            String e2 = e(Ad);
            HttpURLConnection cc2 = cc(this.aml);
            a(cc2, Ad);
            cc2.connect();
            new DataOutputStream(cc2.getOutputStream()).write(e2.getBytes());
            int responseCode = cc2.getResponseCode();
            if (responseCode == 200) {
                String a10 = a(cc2.getInputStream());
                a.b bVar = new a.b();
                JSONObject jSONObject = new JSONObject(a10);
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString) && !"null".equals(optString)) {
                    jSONObject.put("data", new JSONObject(this.amj.An().getRD(optString)));
                }
                bVar.parseJson(jSONObject);
                aVar.a(bVar);
            } else if (responseCode / 100 == 3) {
                if (this.amk < 21) {
                    this.aml = cc2.getHeaderField("Location");
                    this.amk++;
                    a(aVar);
                }
            } else {
                throw new RuntimeException("response code = " + responseCode);
            }
            try {
                cc2.disconnect();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:40:0x004a */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.io.InputStream r5) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r2.<init>()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
        La:
            int r3 = r5.read(r0)     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            r4 = -1
            if (r3 == r4) goto L16
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            goto La
        L16:
            java.lang.String r0 = r2.toString()     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            r5.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r5 = move-exception
            r5.printStackTrace()
        L22:
            r2.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r5 = move-exception
            r5.printStackTrace()
        L2a:
            return r0
        L2b:
            r0 = move-exception
            goto L31
        L2d:
            r0 = move-exception
            goto L4b
        L2f:
            r0 = move-exception
            r2 = r1
        L31:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L3e
            r5.close()     // Catch: java.io.IOException -> L3a
            goto L3e
        L3a:
            r5 = move-exception
            r5.printStackTrace()
        L3e:
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r5 = move-exception
            r5.printStackTrace()
        L48:
            return r1
        L49:
            r0 = move-exception
            r1 = r2
        L4b:
            if (r5 == 0) goto L55
            r5.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r5 = move-exception
            r5.printStackTrace()
        L55:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r5 = move-exception
            r5.printStackTrace()
        L5f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.f.a(java.io.InputStream):java.lang.String");
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
