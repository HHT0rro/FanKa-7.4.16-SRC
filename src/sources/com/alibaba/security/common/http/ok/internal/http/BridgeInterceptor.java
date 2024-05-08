package com.alibaba.security.common.http.ok.internal.http;

import com.alibaba.security.common.http.ok.Cookie;
import com.alibaba.security.common.http.ok.CookieJar;
import com.alibaba.security.common.http.ok.Interceptor;
import com.alibaba.security.common.http.ok.MediaType;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.RequestBody;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.internal.HttpVersion;
import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.okio.GzipSource;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.realidentity.build.cs;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append("; ");
            }
            Cookie cookie = list.get(i10);
            sb2.append(cookie.name());
            sb2.append('=');
            sb2.append(cookie.value());
        }
        return sb2.toString();
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RPRequest request = chain.request();
        RPRequest.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", Long.toString(contentLength));
                newBuilder.removeHeader(DownloadUtils.TRANSFER_ENCODING);
            } else {
                newBuilder.header(DownloadUtils.TRANSFER_ENCODING, DownloadUtils.VALUE_CHUNKED);
                newBuilder.removeHeader("Content-Length");
            }
        }
        boolean z10 = false;
        if (request.header(cs.U) == null) {
            newBuilder.header(cs.U, Util.hostHeader(request.url(), false));
        }
        if (request.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_CONNECTION) == null) {
            newBuilder.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            z10 = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_COOKIE, cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", HttpVersion.userAgent());
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z10 && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && HttpHeaders.hasBody(proceed)) {
            GzipSource gzipSource = new GzipSource(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(proceed.header("Content-Type"), -1L, RPOkio.buffer(gzipSource)));
        }
        return request2.build();
    }
}
