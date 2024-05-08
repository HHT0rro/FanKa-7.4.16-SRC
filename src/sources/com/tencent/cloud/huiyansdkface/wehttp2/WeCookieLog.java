package com.tencent.cloud.huiyansdkface.wehttp2;

import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeCookieLog implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private WeLog f42362a;

    public WeCookieLog(WeLog weLog) {
        this.f42362a = weLog;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (this.f42362a.f42387d == WeLog.Level.HEADERS || this.f42362a.f42387d == WeLog.Level.BODY) {
            Request request = chain.request();
            Headers headers = request.headers();
            for (int i10 = 0; i10 < headers.size(); i10++) {
                String name = headers.name(i10);
                if (HttpHeaders.HEAD_KEY_COOKIE.equals(name)) {
                    LogTag logTag = (LogTag) request.tag(LogTag.class);
                    WeLog.InnerLogger innerLogger = this.f42362a.f42386c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((!this.f42362a.f42385b || logTag == null) ? "" : logTag.getTag());
                    sb2.append(name);
                    sb2.append(u.bD);
                    sb2.append(headers.value(i10));
                    innerLogger.log(sb2.toString());
                }
            }
        }
        return chain.proceed(chain.request());
    }
}
