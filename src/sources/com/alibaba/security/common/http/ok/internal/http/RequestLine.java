package com.alibaba.security.common.http.ok.internal.http;

import com.alibaba.security.common.http.ok.HttpUrl;
import com.alibaba.security.common.http.ok.RPRequest;
import java.net.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static String get(RPRequest rPRequest, Proxy.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(rPRequest.method());
        sb2.append(' ');
        if (includeAuthorityInRequestLine(rPRequest, type)) {
            sb2.append((Object) rPRequest.url());
        } else {
            sb2.append(requestPath(rPRequest.url()));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }

    private static boolean includeAuthorityInRequestLine(RPRequest rPRequest, Proxy.Type type) {
        return !rPRequest.isHttps() && type == Proxy.Type.HTTP;
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
