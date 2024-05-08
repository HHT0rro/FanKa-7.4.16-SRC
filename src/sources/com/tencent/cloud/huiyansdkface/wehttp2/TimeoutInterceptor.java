package com.tencent.cloud.huiyansdkface.wehttp2;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TimeoutInterceptor implements Interceptor {
    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String header = request.header("__wehttp__connect_timeout__");
        String header2 = request.header("__wehttp__read_timeout__");
        String header3 = request.header("__wehttp__write_timeout__");
        if (!TextUtils.isEmpty(header)) {
            chain = chain.withConnectTimeout(Integer.valueOf(header).intValue(), TimeUnit.MILLISECONDS);
        }
        if (!TextUtils.isEmpty(header2)) {
            chain = chain.withReadTimeout(Integer.valueOf(header2).intValue(), TimeUnit.MILLISECONDS);
        }
        if (!TextUtils.isEmpty(header3)) {
            chain = chain.withWriteTimeout(Integer.valueOf(header3).intValue(), TimeUnit.MILLISECONDS);
        }
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.removeHeader("__wehttp__connect_timeout__");
        newBuilder.removeHeader("__wehttp__read_timeout__");
        newBuilder.removeHeader("__wehttp__write_timeout__");
        return chain.proceed(newBuilder.build());
    }
}
