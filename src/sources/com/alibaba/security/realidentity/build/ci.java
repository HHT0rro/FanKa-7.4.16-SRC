package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.ClientException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: OSSAuthCredentialsProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ci extends cl {

    /* renamed from: a, reason: collision with root package name */
    private String f3342a;

    /* renamed from: b, reason: collision with root package name */
    private a f3343b;

    /* compiled from: OSSAuthCredentialsProvider.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        String a();
    }

    private ci(String str) {
        this.f3342a = str;
    }

    private void a(String str) {
        this.f3342a = str;
    }

    private void a(a aVar) {
        this.f3343b = aVar;
    }

    @Override // com.alibaba.security.realidentity.build.cl, com.alibaba.security.realidentity.build.cj
    public final cm a() throws ClientException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f3342a).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            String a10 = cv.a(httpURLConnection.getInputStream(), "utf-8");
            a aVar = this.f3343b;
            if (aVar != null) {
                a10 = aVar.a();
            }
            JSONObject jSONObject = new JSONObject(a10);
            if (jSONObject.getInt("StatusCode") == 200) {
                return new cm(jSONObject.getString("AccessKeyId"), jSONObject.getString("AccessKeySecret"), jSONObject.getString("SecurityToken"), jSONObject.getString("Expiration"));
            }
            throw new ClientException("ErrorCode: " + jSONObject.getString("ErrorCode") + "| ErrorMessage: " + jSONObject.getString("ErrorMessage"));
        } catch (Exception e2) {
            throw new ClientException(e2);
        }
    }
}
