package com.alibaba.security.common.http.ok.internal.connection;

import com.alibaba.security.common.http.ok.Interceptor;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.internal.http.RealInterceptorChain;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ConnectInterceptor implements Interceptor {
    public final RPHttpClient client;

    public ConnectInterceptor(RPHttpClient rPHttpClient) {
        this.client = rPHttpClient;
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        RPRequest request = realInterceptorChain.request();
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        return realInterceptorChain.proceed(request, streamAllocation, streamAllocation.newStream(this.client, chain, !request.method().equals("GET")), streamAllocation.connection());
    }
}
