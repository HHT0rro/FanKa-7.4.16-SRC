package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.http.base.Request;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RpcInvoker extends AbsRPCInvoker {
    @Override // com.alibaba.security.realidentity.http.AbsRPCInvoker
    public void enqueue(Request request, final RetrofitHttpCallback retrofitHttpCallback) {
        HttpRequestManager.getInstance().asyncRequest(j.a.f3944a.f3894d, request.path(), request.body(), HttpMethod.valueOf(request.method()), new IHttpCallback() { // from class: com.alibaba.security.realidentity.http.RpcInvoker.1
            @Override // com.alibaba.security.realidentity.http.IHttpCallback
            public void onFailure(Exception exc) {
                RetrofitHttpCallback retrofitHttpCallback2 = retrofitHttpCallback;
                if (retrofitHttpCallback2 != null) {
                    retrofitHttpCallback2.onFailure(exc);
                }
            }

            @Override // com.alibaba.security.realidentity.http.IHttpCallback
            public void onResponse(RpHttpResponse rpHttpResponse) throws IOException {
                RetrofitHttpCallback retrofitHttpCallback2 = retrofitHttpCallback;
                if (retrofitHttpCallback2 != null) {
                    retrofitHttpCallback2.onResponse(rpHttpResponse);
                }
            }
        });
    }
}
