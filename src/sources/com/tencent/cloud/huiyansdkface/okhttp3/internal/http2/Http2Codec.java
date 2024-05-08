package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.alibaba.security.realidentity.build.cs;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RealResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RequestLine;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.StatusLine;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.ForwardingSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Http2Codec implements HttpCodec {

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f41858b = Util.immutableList("connection", "host", HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE, "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f41859c = Util.immutableList("connection", "host", HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE, "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    public final StreamAllocation f41860a;

    /* renamed from: d, reason: collision with root package name */
    private final Interceptor.Chain f41861d;

    /* renamed from: e, reason: collision with root package name */
    private final Http2Connection f41862e;

    /* renamed from: f, reason: collision with root package name */
    private Http2Stream f41863f;

    /* renamed from: g, reason: collision with root package name */
    private final Protocol f41864g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class StreamFinishingSource extends ForwardingSource {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41865a;

        /* renamed from: b, reason: collision with root package name */
        public long f41866b;

        public StreamFinishingSource(Source source) {
            super(source);
            this.f41865a = false;
            this.f41866b = 0L;
        }

        private void a(IOException iOException) {
            if (this.f41865a) {
                return;
            }
            this.f41865a = true;
            Http2Codec http2Codec = Http2Codec.this;
            http2Codec.f41860a.streamFinished(false, http2Codec, this.f41866b, iOException);
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSource, com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSource, com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            try {
                long read = delegate().read(buffer, j10);
                if (read > 0) {
                    this.f41866b += read;
                }
                return read;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.f41861d = chain;
        this.f41860a = streamAllocation;
        this.f41862e = http2Connection;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f41864g = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.f41827c, request.method()));
        arrayList.add(new Header(Header.f41828d, RequestLine.requestPath(request.url())));
        String header = request.header(cs.U);
        if (header != null) {
            arrayList.add(new Header(Header.f41830f, header));
        }
        arrayList.add(new Header(Header.f41829e, request.url().scheme()));
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i10).toLowerCase(Locale.US));
            if (!f41858b.contains(encodeUtf8.utf8())) {
                arrayList.add(new Header(encodeUtf8, headers.value(i10)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        StatusLine statusLine = null;
        for (int i10 = 0; i10 < size; i10++) {
            String name = headers.name(i10);
            String value = headers.value(i10);
            if (name.equals(":status")) {
                statusLine = StatusLine.parse("HTTP/1.1 " + value);
            } else if (!f41859c.contains(name)) {
                Internal.f41598a.addLenient(builder, name, value);
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol).code(statusLine.f41785b).message(statusLine.f41786c).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void cancel() {
        Http2Stream http2Stream = this.f41863f;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request request, long j10) {
        return this.f41863f.getSink();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.f41863f.getSink().close();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.f41862e.flush();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation = this.f41860a;
        streamAllocation.f41743c.responseBodyStart(streamAllocation.f41742b);
        return new RealResponseBody(response.header("Content-Type"), com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders.contentLength(response), Okio.buffer(new StreamFinishingSource(this.f41863f.getSource())));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z10) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.f41863f.takeHeaders(), this.f41864g);
        if (z10 && Internal.f41598a.code(readHttp2HeadersList) == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) throws IOException {
        if (this.f41863f != null) {
            return;
        }
        Http2Stream newStream = this.f41862e.newStream(http2HeadersList(request), request.body() != null);
        this.f41863f = newStream;
        Timeout readTimeout = newStream.readTimeout();
        long readTimeoutMillis = this.f41861d.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        readTimeout.timeout(readTimeoutMillis, timeUnit);
        this.f41863f.writeTimeout().timeout(this.f41861d.writeTimeoutMillis(), timeUnit);
    }
}
