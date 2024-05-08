package com.alibaba.security.realidentity.http.base;

import com.alibaba.security.realidentity.http.model.HttpRequest;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BusinessRequest implements Serializable {
    public HttpRequest httpRequest;
    public Class<? extends HttpRequest> httpRequestCls;

    public BusinessRequest(Class<? extends HttpRequest> cls, HttpRequest httpRequest) {
        this.httpRequestCls = cls;
        this.httpRequest = httpRequest;
    }
}
