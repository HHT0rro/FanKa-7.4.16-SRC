package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import java.net.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RequestLine {
    private RequestLine() {
    }

    private static boolean a(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    public static String get(Request request, Proxy.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.method());
        sb2.append(' ');
        boolean a10 = a(request, type);
        HttpUrl url = request.url();
        if (a10) {
            sb2.append((Object) url);
        } else {
            sb2.append(requestPath(url));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }

    public static String requestPath(HttpUrl httpUrl) {
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery == null) {
            return encodedPath;
        }
        return encodedPath + '?' + encodedQuery;
    }
}
