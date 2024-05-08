package com.alibaba.security.realidentity.build;

import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.realidentity.http.HttpRequestManager;
import com.alibaba.security.realidentity.http.IHttpCallback;
import com.alibaba.security.realidentity.http.RpHttpResponse;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: CallPopApi.java */
@aw(a = "callPop,rpCallPop")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ar extends aq {
    private static final String ao = "ar";
    private static final int ap = 10;

    private void c(String str) {
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = str;
        a(obtain);
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "callPop";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        JSONObject jSONObject;
        HttpMethod httpMethod;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            final String string = jSONObject2.has("url") ? jSONObject2.getString("url") : null;
            String string2 = jSONObject2.has("method") ? jSONObject2.getString("method") : "";
            if (jSONObject2.has("params")) {
                jSONObject = jSONObject2.getJSONObject("params");
            } else {
                jSONObject = new JSONObject();
            }
            String jSONObject3 = jSONObject.toString();
            if (string != null) {
                if (string2 != null) {
                    string2 = string2.toUpperCase();
                }
                HttpMethod httpMethod2 = HttpMethod.GET;
                if (!httpMethod2.toString().equals(string2)) {
                    httpMethod2 = HttpMethod.PUT;
                    if (!httpMethod2.toString().equals(string2)) {
                        httpMethod2 = HttpMethod.DELETE;
                        if (!httpMethod2.toString().equals(string2)) {
                            httpMethod2 = HttpMethod.PATCH;
                            if (!httpMethod2.toString().equals(string2)) {
                                httpMethod = HttpMethod.POST;
                                HttpRequestManager.getInstance().asyncRequest(this.al, string, jSONObject3, httpMethod, new IHttpCallback() { // from class: com.alibaba.security.realidentity.build.ar.1
                                    @Override // com.alibaba.security.realidentity.http.IHttpCallback
                                    public final void onFailure(Exception exc) {
                                        RPLogging.e(ar.ao, exc);
                                        aq.a("CallPopApi request fail", exc);
                                        ar.a(ar.this, (String) null);
                                    }

                                    @Override // com.alibaba.security.realidentity.http.IHttpCallback
                                    public final void onResponse(RpHttpResponse rpHttpResponse) throws IOException {
                                        String str2;
                                        if (rpHttpResponse != null) {
                                            str2 = rpHttpResponse.getResponseBody();
                                            if (!rpHttpResponse.isSuccessful()) {
                                                RPLogging.e(ar.ao, new IOException("response is " + str2 + string));
                                                aq.a("CallPopApi request fail", new IOException("response is " + str2 + string));
                                            }
                                        } else {
                                            RPLogging.e(ar.ao, new IOException("response is null " + string));
                                            aq.a("CallPopApi request fail", new IOException("response is null " + string));
                                            str2 = null;
                                        }
                                        ar.a(ar.this, str2);
                                    }
                                });
                                return true;
                            }
                        }
                    }
                }
                httpMethod = httpMethod2;
                HttpRequestManager.getInstance().asyncRequest(this.al, string, jSONObject3, httpMethod, new IHttpCallback() { // from class: com.alibaba.security.realidentity.build.ar.1
                    @Override // com.alibaba.security.realidentity.http.IHttpCallback
                    public final void onFailure(Exception exc) {
                        RPLogging.e(ar.ao, exc);
                        aq.a("CallPopApi request fail", exc);
                        ar.a(ar.this, (String) null);
                    }

                    @Override // com.alibaba.security.realidentity.http.IHttpCallback
                    public final void onResponse(RpHttpResponse rpHttpResponse) throws IOException {
                        String str2;
                        if (rpHttpResponse != null) {
                            str2 = rpHttpResponse.getResponseBody();
                            if (!rpHttpResponse.isSuccessful()) {
                                RPLogging.e(ar.ao, new IOException("response is " + str2 + string));
                                aq.a("CallPopApi request fail", new IOException("response is " + str2 + string));
                            }
                        } else {
                            RPLogging.e(ar.ao, new IOException("response is null " + string));
                            aq.a("CallPopApi request fail", new IOException("response is null " + string));
                            str2 = null;
                        }
                        ar.a(ar.this, str2);
                    }
                });
                return true;
            }
            throw new IllegalArgumentException("url can not be null");
        } catch (Exception e2) {
            aq.a(ayVar);
            aq.a("CallPopApi params parse error", e2);
            return false;
        }
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final void b(Message message) {
        super.b(message);
        if (message.what == 10) {
            String str = (String) message.obj;
            if (TextUtils.isEmpty(str)) {
                a(aq.a(this.ak), false);
                return;
            }
            bf bfVar = new bf();
            bfVar.f3165a = 1;
            bfVar.a("response", str);
            this.ak.b(str);
            a(bfVar, true);
        }
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean b() {
        return true;
    }

    private static HttpMethod d(String str) {
        if (str != null) {
            str = str.toUpperCase();
        }
        HttpMethod httpMethod = HttpMethod.GET;
        if (httpMethod.toString().equals(str)) {
            return httpMethod;
        }
        HttpMethod httpMethod2 = HttpMethod.PUT;
        if (httpMethod2.toString().equals(str)) {
            return httpMethod2;
        }
        HttpMethod httpMethod3 = HttpMethod.DELETE;
        if (httpMethod3.toString().equals(str)) {
            return httpMethod3;
        }
        HttpMethod httpMethod4 = HttpMethod.PATCH;
        return httpMethod4.toString().equals(str) ? httpMethod4 : HttpMethod.POST;
    }

    private void c(Message message) {
        if (message.what == 10) {
            String str = (String) message.obj;
            if (TextUtils.isEmpty(str)) {
                a(aq.a(this.ak), false);
                return;
            }
            bf bfVar = new bf();
            bfVar.f3165a = 1;
            bfVar.a("response", str);
            this.ak.b(str);
            a(bfVar, true);
        }
    }

    public static /* synthetic */ void a(ar arVar, String str) {
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = str;
        arVar.a(obtain);
    }
}
