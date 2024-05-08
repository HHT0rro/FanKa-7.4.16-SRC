package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.alibaba.security.realidentity.build.cs;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import com.tencent.cloud.huiyansdkface.okhttp3.CookieJar;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.RequestBody;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Version;
import com.tencent.cloud.huiyansdkface.okio.GzipSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import java.io.IOException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class BridgeInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final CookieJar f41756a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.f41756a = cookieJar;
    }

    private String a(List<Cookie> list) {
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

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
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
        List<Cookie> loadForRequest = this.f41756a.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_COOKIE, a(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.f41756a, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z10 && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && HttpHeaders.hasBody(proceed)) {
            GzipSource gzipSource = new GzipSource(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(proceed.header("Content-Type"), -1L, Okio.buffer(gzipSource)));
        }
        return request2.build();
    }
}
