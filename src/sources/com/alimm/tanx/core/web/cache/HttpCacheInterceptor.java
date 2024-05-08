package com.alimm.tanx.core.web.cache;

import android.text.TextUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HttpCacheInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String header = request.header(WebViewCacheInterceptor.KEY_CACHE);
        Response proceed = chain.proceed(request);
        try {
            if (!TextUtils.isEmpty(header)) {
                if (header.equals(CacheType.NORMAL.ordinal() + "")) {
                    return proceed;
                }
            }
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
        return proceed.newBuilder().removeHeader("pragma").removeHeader("Cache-Control").header("Cache-Control", "max-age=3153600000").build();
    }
}
