package com.alibaba.security.realidentity.http;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IHttpCallback {
    void onFailure(Exception exc);

    void onResponse(RpHttpResponse rpHttpResponse) throws IOException;
}
