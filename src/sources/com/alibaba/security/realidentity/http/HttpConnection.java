package com.alibaba.security.realidentity.http;

import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HttpConnection extends BaseConnection {
    private HttpURLConnection mConn;

    public HttpConnection(String str) {
        this.mConn = null;
        try {
            this.mConn = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.security.realidentity.http.BaseConnection
    public HttpURLConnection getURLConnection() {
        return this.mConn;
    }
}
