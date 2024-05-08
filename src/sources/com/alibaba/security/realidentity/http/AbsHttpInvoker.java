package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.http.base.RetrofitInvokeHandler;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AbsHttpInvoker {
    private IHttpInvoker mHttpInvoker;

    public AbsHttpInvoker() {
        this.mHttpInvoker = null;
        this.mHttpInvoker = (IHttpInvoker) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{IHttpInvoker.class}, new RetrofitInvokeHandler(getRPCInvoker()));
    }

    public IHttpInvoker getHttpInvoker() {
        return this.mHttpInvoker;
    }

    public abstract AbsRPCInvoker getRPCInvoker();
}
