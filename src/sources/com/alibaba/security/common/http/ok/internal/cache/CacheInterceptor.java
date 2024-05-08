package com.alibaba.security.common.http.ok.internal.cache;

import com.alibaba.security.common.http.ok.Headers;
import com.alibaba.security.common.http.ok.Interceptor;
import com.alibaba.security.common.http.ok.Protocol;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.internal.Internal;
import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.cache.CacheStrategy;
import com.alibaba.security.common.http.ok.internal.http.HttpMethod;
import com.alibaba.security.common.http.ok.internal.http.RealResponseBody;
import com.alibaba.security.common.http.okio.Buffer;
import com.alibaba.security.common.http.okio.BufferedSink;
import com.alibaba.security.common.http.okio.BufferedSource;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.common.http.okio.Sink;
import com.alibaba.security.common.http.okio.Source;
import com.alibaba.security.common.http.okio.Timeout;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CacheInterceptor implements Interceptor {
    public final InternalCache cache;

    public CacheInterceptor(InternalCache internalCache) {
        this.cache = internalCache;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink buffer = RPOkio.buffer(body);
        return response.newBuilder().body(new RealResponseBody(response.header("Content-Type"), response.body().contentLength(), RPOkio.buffer(new Source() { // from class: com.alibaba.security.common.http.ok.internal.cache.CacheInterceptor.1
            public boolean cacheRequestClosed;

            @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }

            @Override // com.alibaba.security.common.http.okio.Source
            public long read(Buffer buffer2, long j10) throws IOException {
                try {
                    long read = source.read(buffer2, j10);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            buffer.close();
                        }
                        return -1L;
                    }
                    buffer2.copyTo(buffer.buffer(), buffer2.size() - read, read);
                    buffer.emitCompleteSegments();
                    return read;
                } catch (IOException e2) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e2;
                }
            }

            @Override // com.alibaba.security.common.http.okio.Source
            public Timeout timeout() {
                return source.timeout();
            }
        }))).build();
    }

    private static Headers combine(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = headers.name(i10);
            String value = headers.value(i10);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        int size2 = headers2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            String name2 = headers2.name(i11);
            if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                Internal.instance.addLenient(builder, name2, headers2.value(i11));
            }
        }
        return builder.build();
    }

    public static boolean isContentSpecificHeader(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    public static boolean isEndToEnd(String str) {
        return (HttpHeaders.HEAD_KEY_CONNECTION.equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || DownloadUtils.TRANSFER_ENCODING.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.cache;
        Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).get();
        RPRequest rPRequest = cacheStrategy.networkRequest;
        Response response2 = cacheStrategy.cacheResponse;
        InternalCache internalCache2 = this.cache;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response != null && response2 == null) {
            Util.closeQuietly(response.body());
        }
        if (rPRequest == null && response2 == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (rPRequest == null) {
            return response2.newBuilder().cacheResponse(stripBody(response2)).build();
        }
        try {
            Response proceed = chain.proceed(rPRequest);
            if (proceed == null && response != null) {
            }
            if (response2 != null) {
                if (proceed.code() == 304) {
                    Response build = response2.newBuilder().headers(combine(response2.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(stripBody(response2)).networkResponse(stripBody(proceed)).build();
                    proceed.body().close();
                    this.cache.trackConditionalCacheHit();
                    this.cache.update(response2, build);
                    return build;
                }
                Util.closeQuietly(response2.body());
            }
            Response build2 = proceed.newBuilder().cacheResponse(stripBody(response2)).networkResponse(stripBody(proceed)).build();
            if (this.cache != null) {
                if (com.alibaba.security.common.http.ok.internal.http.HttpHeaders.hasBody(build2) && CacheStrategy.isCacheable(build2, rPRequest)) {
                    return cacheWritingResponse(this.cache.put(build2), build2);
                }
                if (HttpMethod.invalidatesCache(rPRequest.method())) {
                    try {
                        this.cache.remove(rPRequest);
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
