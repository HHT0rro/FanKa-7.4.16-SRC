package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RetryInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public static final RetryStrategy f42307a = new RetryStrategy() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.RetryInterceptor.1
        @Override // com.tencent.cloud.huiyansdkface.wehttp2.RetryInterceptor.RetryStrategy
        public boolean needRetry(Request request, Response response, int i10) {
            return !response.isSuccessful();
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private int f42308b;

    /* renamed from: c, reason: collision with root package name */
    private RetryStrategy f42309c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface RetryStrategy {
        boolean needRetry(Request request, Response response, int i10);
    }

    public RetryInterceptor(int i10, RetryStrategy retryStrategy) {
        this.f42308b = i10;
        this.f42309c = retryStrategy;
    }

    private boolean a(Request request, Response response, int i10) {
        RetryStrategy retryStrategy = this.f42309c;
        return retryStrategy != null ? retryStrategy.needRetry(request, response, i10) : f42307a.needRetry(request, response, i10);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        int i10 = 0;
        while (a(request, proceed, i10) && i10 < this.f42308b) {
            i10++;
            proceed = chain.proceed(request);
        }
        return proceed;
    }

    public RetryInterceptor setMaxRetryCount(int i10) {
        this.f42308b = i10;
        return this;
    }

    public RetryInterceptor setRetryStrategy(RetryStrategy retryStrategy) {
        this.f42309c = retryStrategy;
        return this;
    }
}
