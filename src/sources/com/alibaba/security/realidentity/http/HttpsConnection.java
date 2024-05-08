package com.alibaba.security.realidentity.http;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HttpsConnection extends BaseConnection {
    private HttpsURLConnection mConn;

    public HttpsConnection(String str) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            this.mConn = httpsURLConnection;
            httpsURLConnection.setDoOutput(true);
            this.mConn.setDoInput(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.security.realidentity.http.BaseConnection
    public HttpURLConnection getURLConnection() {
        return this.mConn;
    }
}
