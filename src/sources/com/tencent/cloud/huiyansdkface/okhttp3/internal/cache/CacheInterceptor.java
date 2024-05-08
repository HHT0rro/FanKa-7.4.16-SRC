package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache;

import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheStrategy;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpMethod;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RealResponseBody;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final InternalCache f41621a;

    public CacheInterceptor(InternalCache internalCache) {
        this.f41621a = internalCache;
    }

    private static Headers a(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = headers.name(i10);
            String value = headers.value(i10);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (b(name) || !a(name) || headers2.get(name) == null)) {
                Internal.f41598a.addLenient(builder, name, value);
            }
        }
        int size2 = headers2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            String name2 = headers2.name(i11);
            if (!b(name2) && a(name2)) {
                Internal.f41598a.addLenient(builder, name2, headers2.value(i11));
            }
        }
        return builder.build();
    }

    private static Response a(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private Response a(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink buffer = Okio.buffer(body);
        return response.newBuilder().body(new RealResponseBody(response.header("Content-Type"), response.body().contentLength(), Okio.buffer(new Source() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheInterceptor.1

            /* renamed from: a, reason: collision with root package name */
            public boolean f41622a;

            @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f41622a && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f41622a = true;
                    cacheRequest.abort();
                }
                source.close();
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Source
            public long read(Buffer buffer2, long j10) throws IOException {
                try {
                    long read = source.read(buffer2, j10);
                    if (read != -1) {
                        buffer2.copyTo(buffer.buffer(), buffer2.size() - read, read);
                        buffer.emitCompleteSegments();
                        return read;
                    }
                    if (!this.f41622a) {
                        this.f41622a = true;
                        buffer.close();
                    }
                    return -1L;
                } catch (IOException e2) {
                    if (!this.f41622a) {
                        this.f41622a = true;
                        cacheRequest.abort();
                    }
                    throw e2;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Source
            public Timeout timeout() {
                return source.timeout();
            }
        }))).build();
    }

    public static boolean a(String str) {
        return (HttpHeaders.HEAD_KEY_CONNECTION.equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || DownloadUtils.TRANSFER_ENCODING.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.f41621a;
        Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).get();
        Request request = cacheStrategy.f41627a;
        Response response2 = cacheStrategy.f41628b;
        InternalCache internalCache2 = this.f41621a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response != null && response2 == null) {
            Util.closeQuietly(response.body());
        }
        if (request == null && response2 == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.f41602c).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(a(response2)).build();
        }
        try {
            Response proceed = chain.proceed(request);
            if (proceed == null && response != null) {
            }
            if (response2 != null) {
                if (proceed.code() == 304) {
                    Response build = response2.newBuilder().headers(a(response2.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(a(response2)).networkResponse(a(proceed)).build();
                    proceed.body().close();
                    this.f41621a.trackConditionalCacheHit();
                    this.f41621a.update(response2, build);
                    return build;
                }
                Util.closeQuietly(response2.body());
            }
            Response build2 = proceed.newBuilder().cacheResponse(a(response2)).networkResponse(a(proceed)).build();
            if (this.f41621a != null) {
                if (com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders.hasBody(build2) && CacheStrategy.isCacheable(build2, request)) {
                    return a(this.f41621a.put(build2), build2);
                }
                if (HttpMethod.invalidatesCache(request.method())) {
                    try {
                        this.f41621a.remove(request);
                    } catch (IOException unused) {
                    }
                }
            }
            return build2;
        } finally {
            if (response != null) {
                Util.closeQuietly(response.body());
            }
        }
    }
}
