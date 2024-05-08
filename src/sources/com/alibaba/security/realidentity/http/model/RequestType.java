package com.alibaba.security.realidentity.http.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum RequestType {
    OK_HTTP(1),
    HTTP_URL_CONNECTION(2);

    public int type;

    RequestType(int i10) {
        this.type = i10;
    }

    public static RequestType create(int i10) {
        if (i10 != 2) {
            return OK_HTTP;
        }
        return HTTP_URL_CONNECTION;
    }
}
