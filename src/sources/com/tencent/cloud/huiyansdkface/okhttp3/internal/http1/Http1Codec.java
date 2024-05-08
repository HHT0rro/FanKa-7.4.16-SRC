package com.tencent.cloud.huiyansdkface.okhttp3.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RealResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RequestLine;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.StatusLine;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ForwardingTimeout;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Http1Codec implements HttpCodec {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f41787a;

    /* renamed from: b, reason: collision with root package name */
    public final StreamAllocation f41788b;

    /* renamed from: c, reason: collision with root package name */
    public final BufferedSource f41789c;

    /* renamed from: d, reason: collision with root package name */
    public final BufferedSink f41790d;

    /* renamed from: e, reason: collision with root package name */
    public int f41791e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f41792f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public abstract class AbstractSource implements Source {

        /* renamed from: a, reason: collision with root package name */
        public final ForwardingTimeout f41793a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41794b;

        /* renamed from: c, reason: collision with root package name */
        public long f41795c;

        private AbstractSource() {
            this.f41793a = new ForwardingTimeout(Http1Codec.this.f41789c.timeout());
            this.f41795c = 0L;
        }

        public final void a(boolean z10, IOException iOException) throws IOException {
            Http1Codec http1Codec = Http1Codec.this;
            int i10 = http1Codec.f41791e;
            if (i10 == 6) {
                return;
            }
            if (i10 != 5) {
                throw new IllegalStateException("state: " + Http1Codec.this.f41791e);
            }
            http1Codec.a(this.f41793a);
            Http1Codec http1Codec2 = Http1Codec.this;
            http1Codec2.f41791e = 6;
            StreamAllocation streamAllocation = http1Codec2.f41788b;
            if (streamAllocation != null) {
                streamAllocation.streamFinished(!z10, http1Codec2, this.f41795c, iOException);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            try {
                long read = Http1Codec.this.f41789c.read(buffer, j10);
                if (read > 0) {
                    this.f41795c += read;
                }
                return read;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public Timeout timeout() {
            return this.f41793a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class ChunkedSink implements Sink {

        /* renamed from: b, reason: collision with root package name */
        private final ForwardingTimeout f41798b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f41799c;

        public ChunkedSink() {
            this.f41798b = new ForwardingTimeout(Http1Codec.this.f41790d.timeout());
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f41799c) {
                return;
            }
            this.f41799c = true;
            Http1Codec.this.f41790d.writeUtf8("0\r\n\r\n");
            Http1Codec.this.a(this.f41798b);
            Http1Codec.this.f41791e = 3;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f41799c) {
                return;
            }
            Http1Codec.this.f41790d.flush();
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public Timeout timeout() {
            return this.f41798b;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            if (this.f41799c) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            Http1Codec.this.f41790d.writeHexadecimalUnsignedLong(j10);
            Http1Codec.this.f41790d.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            Http1Codec.this.f41790d.write(buffer, j10);
            Http1Codec.this.f41790d.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ChunkedSource extends AbstractSource {

        /* renamed from: f, reason: collision with root package name */
        private final HttpUrl f41801f;

        /* renamed from: g, reason: collision with root package name */
        private long f41802g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f41803h;

        public ChunkedSource(HttpUrl httpUrl) {
            super();
            this.f41802g = -1L;
            this.f41803h = true;
            this.f41801f = httpUrl;
        }

        private void a() throws IOException {
            if (this.f41802g != -1) {
                Http1Codec.this.f41789c.readUtf8LineStrict();
            }
            try {
                this.f41802g = Http1Codec.this.f41789c.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.f41789c.readUtf8LineStrict().trim();
                if (this.f41802g < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f41802g + trim + "\"");
                }
                if (this.f41802g == 0) {
                    this.f41803h = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.f41787a.cookieJar(), this.f41801f, Http1Codec.this.readHeaders());
                    a(true, null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f41794b) {
                return;
            }
            if (this.f41803h && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f41794b = true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http1.Http1Codec.AbstractSource, com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f41794b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f41803h) {
                return -1L;
            }
            long j11 = this.f41802g;
            if (j11 == 0 || j11 == -1) {
                a();
                if (!this.f41803h) {
                    return -1L;
                }
            }
            long read = super.read(buffer, Math.min(j10, this.f41802g));
            if (read != -1) {
                this.f41802g -= read;
                return read;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, protocolException);
            throw protocolException;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class FixedLengthSink implements Sink {

        /* renamed from: b, reason: collision with root package name */
        private final ForwardingTimeout f41805b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f41806c;

        /* renamed from: d, reason: collision with root package name */
        private long f41807d;

        public FixedLengthSink(long j10) {
            this.f41805b = new ForwardingTimeout(Http1Codec.this.f41790d.timeout());
            this.f41807d = j10;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f41806c) {
                return;
            }
            this.f41806c = true;
            if (this.f41807d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            Http1Codec.this.a(this.f41805b);
            Http1Codec.this.f41791e = 3;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f41806c) {
                return;
            }
            Http1Codec.this.f41790d.flush();
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public Timeout timeout() {
            return this.f41805b;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            if (this.f41806c) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer.size(), 0L, j10);
            if (j10 <= this.f41807d) {
                Http1Codec.this.f41790d.write(buffer, j10);
                this.f41807d -= j10;
                return;
            }
            throw new ProtocolException("expected " + this.f41807d + " bytes but received " + j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class FixedLengthSource extends AbstractSource {

        /* renamed from: f, reason: collision with root package name */
        private long f41809f;

        public FixedLengthSource(long j10) throws IOException {
            super();
            this.f41809f = j10;
            if (j10 == 0) {
                a(true, null);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f41794b) {
                return;
            }
            if (this.f41809f != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f41794b = true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http1.Http1Codec.AbstractSource, com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f41794b) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f41809f;
            if (j11 == 0) {
                return -1L;
            }
            long read = super.read(buffer, Math.min(j11, j10));
            if (read == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
            long j12 = this.f41809f - read;
            this.f41809f = j12;
            if (j12 == 0) {
                a(true, null);
            }
            return read;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class UnknownLengthSource extends AbstractSource {

        /* renamed from: f, reason: collision with root package name */
        private boolean f41811f;

        public UnknownLengthSource() {
            super();
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f41794b) {
                return;
            }
            if (!this.f41811f) {
                a(false, null);
            }
            this.f41794b = true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http1.Http1Codec.AbstractSource, com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f41794b) {
                throw new IllegalStateException("closed");
            }
            if (this.f41811f) {
                return -1L;
            }
            long read = super.read(buffer, j10);
            if (read != -1) {
                return read;
            }
            this.f41811f = true;
            a(true, null);
            return -1L;
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f41787a = okHttpClient;
        this.f41788b = streamAllocation;
        this.f41789c = bufferedSource;
        this.f41790d = bufferedSink;
    }

    private String a() throws IOException {
        String readUtf8LineStrict = this.f41789c.readUtf8LineStrict(this.f41792f);
        this.f41792f -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public void a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void cancel() {
        RealConnection connection = this.f41788b.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request request, long j10) {
        if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(request.header(DownloadUtils.TRANSFER_ENCODING))) {
            return newChunkedSink();
        }
        if (j10 != -1) {
            return newFixedLengthSink(j10);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.f41790d.flush();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.f41790d.flush();
    }

    public boolean isClosed() {
        return this.f41791e == 6;
    }

    public Sink newChunkedSink() {
        if (this.f41791e == 1) {
            this.f41791e = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.f41791e);
    }

    public Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.f41791e == 4) {
            this.f41791e = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException("state: " + this.f41791e);
    }

    public Sink newFixedLengthSink(long j10) {
        if (this.f41791e == 1) {
            this.f41791e = 2;
            return new FixedLengthSink(j10);
        }
        throw new IllegalStateException("state: " + this.f41791e);
    }

    public Source newFixedLengthSource(long j10) throws IOException {
        if (this.f41791e == 4) {
            this.f41791e = 5;
            return new FixedLengthSource(j10);
        }
        throw new IllegalStateException("state: " + this.f41791e);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.f41791e != 4) {
            throw new IllegalStateException("state: " + this.f41791e);
        }
        StreamAllocation streamAllocation = this.f41788b;
        if (streamAllocation == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f41791e = 5;
        streamAllocation.noNewStreams();
        return new UnknownLengthSource();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation = this.f41788b;
        streamAllocation.f41743c.responseBodyStart(streamAllocation.f41742b);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0L, Okio.buffer(newFixedLengthSource(0L)));
        }
        if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(response.header(DownloadUtils.TRANSFER_ENCODING))) {
            return new RealResponseBody(header, -1L, Okio.buffer(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        return contentLength != -1 ? new RealResponseBody(header, contentLength, Okio.buffer(newFixedLengthSource(contentLength))) : new RealResponseBody(header, -1L, Okio.buffer(newUnknownLengthSource()));
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String a10 = a();
            if (a10.length() == 0) {
                return builder.build();
            }
            Internal.f41598a.addLenient(builder, a10);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z10) throws IOException {
        int i10 = this.f41791e;
        if (i10 != 1 && i10 != 3) {
            throw new IllegalStateException("state: " + this.f41791e);
        }
        try {
            StatusLine parse = StatusLine.parse(a());
            Response.Builder headers = new Response.Builder().protocol(parse.f41784a).code(parse.f41785b).message(parse.f41786c).headers(readHeaders());
            if (z10 && parse.f41785b == 100) {
                return null;
            }
            if (parse.f41785b == 100) {
                this.f41791e = 3;
                return headers;
            }
            this.f41791e = 4;
            return headers;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + ((Object) this.f41788b));
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.f41791e != 0) {
            throw new IllegalStateException("state: " + this.f41791e);
        }
        this.f41790d.writeUtf8(str).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f41790d.writeUtf8(headers.name(i10)).writeUtf8(": ").writeUtf8(headers.value(i10)).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.f41790d.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        this.f41791e = 1;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.f41788b.connection().route().proxy().type()));
    }
}
