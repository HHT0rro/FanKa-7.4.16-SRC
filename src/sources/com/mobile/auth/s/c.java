package com.mobile.auth.s;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements com.mobile.auth.g.b {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f37621a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private com.mobile.auth.g.b f37622b;

    public c(com.mobile.auth.g.b bVar) {
        this.f37622b = bVar;
    }

    public Map<String, String> a() {
        try {
            return this.f37621a;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    @Override // com.mobile.auth.g.b
    public void a(int i10, JSONObject jSONObject) {
        try {
            Map<String, String> map = this.f37621a;
            if (map != null && !map.isEmpty()) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Map.Entry<String, String> entry : this.f37621a.entrySet()) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            com.mobile.auth.g.b bVar = this.f37622b;
            if (bVar != null) {
                bVar.a(i10, jSONObject);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
