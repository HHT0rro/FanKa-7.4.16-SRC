package com.alibaba.security.realidentity.http.base;

import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.http.IHttpCallback;
import com.alibaba.security.realidentity.http.RpHttpResponse;
import com.alibaba.security.realidentity.http.model.HttpResponse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class RetrofitHttpCallback implements IHttpCallback {
    private static final String TAG = "RetrofitHttpCallback";
    private Class<? extends HttpResponse> httpResponse = HttpResponse.class;

    private HttpResponse analyzeResponse(String str, Class<? extends HttpResponse> cls) {
        try {
            return (HttpResponse) JsonUtils.parseObject(str, (Class) cls);
        } catch (Throwable th) {
            RPLogging.e(TAG, "analyzeResponse fail ,jsonResponse is ".concat(String.valueOf(str)), th);
            return new HttpResponse() { // from class: com.alibaba.security.realidentity.http.base.RetrofitHttpCallback.1
                @Override // com.alibaba.security.realidentity.http.model.HttpResponse
                public boolean isSuccessful() {
                    return false;
                }
            };
        }
    }

    public abstract void onFailure(HttpResponse httpResponse);

    @Override // com.alibaba.security.realidentity.http.IHttpCallback
    public void onFailure(Exception exc) {
        onNetError(exc);
    }

    public abstract void onNetError(Exception exc);

    @Override // com.alibaba.security.realidentity.http.IHttpCallback
    public void onResponse(RpHttpResponse rpHttpResponse) {
        HttpResponse analyzeResponse = analyzeResponse(rpHttpResponse.getResponseBody(), this.httpResponse);
        if (analyzeResponse != null && analyzeResponse.isSuccessful()) {
            onSuccess(analyzeResponse);
        } else {
            onFailure(analyzeResponse);
        }
    }

    public abstract void onSuccess(HttpResponse httpResponse);

    public void setResponse(Class<? extends HttpResponse> cls) {
        this.httpResponse = cls;
    }
}
