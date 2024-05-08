package com.alibaba.security.realidentity.http;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RpHttpResponse implements Serializable {
    private final String responseBody;
    private final boolean successful;

    public RpHttpResponse(boolean z10, String str) {
        this.successful = z10;
        this.responseBody = str;
    }

    public static RpHttpResponse create(boolean z10, String str) {
        return new RpHttpResponse(z10, str);
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public boolean isSuccessful() {
        return this.successful;
    }
}
