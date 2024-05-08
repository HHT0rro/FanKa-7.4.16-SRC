package okhttp3.internal.http;

import com.alibaba.security.realidentity.build.cs;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

/* compiled from: BridgeInterceptor.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(@NotNull CookieJar cookieJar) {
        s.i(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Cookie cookie : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            Cookie cookie2 = cookie;
            if (i10 > 0) {
                sb2.append("; ");
            }
            sb2.append(cookie2.name());
            sb2.append('=');
            sb2.append(cookie2.value());
            i10 = i11;
        }
        String sb3 = sb2.toString();
        s.h(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        s.i(chain, "chain");
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body2 = request.body();
        if (body2 != null) {
            MediaType contentType = body2.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", String.valueOf(contentLength));
                newBuilder.removeHeader(DownloadUtils.TRANSFER_ENCODING);
            } else {
                newBuilder.header(DownloadUtils.TRANSFER_ENCODING, DownloadUtils.VALUE_CHUNKED);
                newBuilder.removeHeader("Content-Length");
            }
        }
        boolean z10 = false;
        if (request.header(cs.U) == null) {
            newBuilder.header(cs.U, Util.toHostHeader$default(request.url(), false, 1, null));
        }
        if (request.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_CONNECTION) == null) {
            newBuilder.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            newBuilder.header("Accept-Encoding", "gzip");
            z10 = true;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(com.wangmai.okhttp.model.HttpHeaders.HEAD_KEY_COOKIE, cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Util.userAgent);
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z10 && p.r("gzip", Response.header$default(proceed, "Content-Encoding", null, 2, null), true) && HttpHeaders.promisesBody(proceed) && (body = proceed.body()) != null) {
            GzipSource gzipSource = new GzipSource(body.source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(Response.header$default(proceed, "Content-Type", null, 2, null), -1L, Okio.buffer(gzipSource)));
        }
        return request2.build();
    }
}
