package com.alibaba.security.common.http.ok.internal.http2;

import com.alibaba.security.common.http.ok.Headers;
import com.alibaba.security.common.http.ok.Interceptor;
import com.alibaba.security.common.http.ok.Protocol;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.ResponseBody;
import com.alibaba.security.common.http.ok.internal.Internal;
import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.connection.StreamAllocation;
import com.alibaba.security.common.http.ok.internal.http.HttpCodec;
import com.alibaba.security.common.http.ok.internal.http.HttpHeaders;
import com.alibaba.security.common.http.ok.internal.http.RealResponseBody;
import com.alibaba.security.common.http.ok.internal.http.RequestLine;
import com.alibaba.security.common.http.ok.internal.http.StatusLine;
import com.alibaba.security.common.http.okio.Buffer;
import com.alibaba.security.common.http.okio.ByteString;
import com.alibaba.security.common.http.okio.ForwardingSource;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.common.http.okio.Sink;
import com.alibaba.security.common.http.okio.Source;
import com.alibaba.security.common.http.okio.Timeout;
import com.alibaba.security.realidentity.build.cs;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Http2Codec implements HttpCodec {
    private static final String HOST = "host";
    private static final String KEEP_ALIVE = "keep-alive";
    private final Interceptor.Chain chain;
    private final Http2Connection connection;
    private final Protocol protocol;
    private Http2Stream stream;
    public final StreamAllocation streamAllocation;
    private static final String CONNECTION = "connection";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String ENCODING = "encoding";
    private static final String UPGRADE = "upgrade";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, "host", "keep-alive", PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, ":method", ":path", ":scheme", ":authority");
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, "host", "keep-alive", PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class StreamFinishingSource extends ForwardingSource {
        public long bytesRead;
        public boolean completed;

        public StreamFinishingSource(Source source) {
            super(source);
            this.completed = false;
            this.bytesRead = 0L;
        }

        private void endOfInput(IOException iOException) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            Http2Codec http2Codec = Http2Codec.this;
            http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
        }

        @Override // com.alibaba.security.common.http.okio.ForwardingSource, com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            endOfInput(null);
        }

        @Override // com.alibaba.security.common.http.okio.ForwardingSource, com.alibaba.security.common.http.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            try {
                long read = delegate().read(buffer, j10);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e2) {
                endOfInput(e2);
                throw e2;
            }
        }
    }

    public Http2Codec(RPHttpClient rPHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.chain = chain;
        this.streamAllocation = streamAllocation;
        this.connection = http2Connection;
        List<Protocol> protocols = rPHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    public static List<Header> http2HeadersList(RPRequest rPRequest) {
        Headers headers = rPRequest.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, rPRequest.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(rPRequest.url())));
        String header = rPRequest.header(cs.U);
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, rPRequest.url().scheme()));
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i10).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8.utf8())) {
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
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public Sink createRequestBody(RPRequest rPRequest, long j10) {
        return this.stream.getSink();
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation = this.streamAllocation;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), RPOkio.buffer(new StreamFinishingSource(this.stream.getSource())));
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z10) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
        if (z10 && Internal.instance.code(readHttp2HeadersList) == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public void writeRequestHeaders(RPRequest rPRequest) throws IOException {
        if (this.stream != null) {
            return;
        }
        Http2Stream newStream = this.connection.newStream(http2HeadersList(rPRequest), rPRequest.body() != null);
        this.stream = newStream;
        Timeout readTimeout = newStream.readTimeout();
        long readTimeoutMillis = this.chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        readTimeout.timeout(readTimeoutMillis, timeUnit);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), timeUnit);
    }
}
