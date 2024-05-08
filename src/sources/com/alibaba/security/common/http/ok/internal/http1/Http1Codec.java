package com.alibaba.security.common.http.ok.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.security.common.http.ok.Headers;
import com.alibaba.security.common.http.ok.HttpUrl;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.ResponseBody;
import com.alibaba.security.common.http.ok.internal.Internal;
import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.connection.RealConnection;
import com.alibaba.security.common.http.ok.internal.connection.StreamAllocation;
import com.alibaba.security.common.http.ok.internal.http.HttpCodec;
import com.alibaba.security.common.http.ok.internal.http.HttpHeaders;
import com.alibaba.security.common.http.ok.internal.http.RealResponseBody;
import com.alibaba.security.common.http.ok.internal.http.RequestLine;
import com.alibaba.security.common.http.ok.internal.http.StatusLine;
import com.alibaba.security.common.http.okio.Buffer;
import com.alibaba.security.common.http.okio.BufferedSink;
import com.alibaba.security.common.http.okio.BufferedSource;
import com.alibaba.security.common.http.okio.ForwardingTimeout;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.common.http.okio.Sink;
import com.alibaba.security.common.http.okio.Source;
import com.alibaba.security.common.http.okio.Timeout;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    public final RPHttpClient client;
    public final BufferedSink sink;
    public final BufferedSource source;
    public final StreamAllocation streamAllocation;
    public int state = 0;
    private long headerLimit = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public abstract class AbstractSource implements Source {
        public long bytesRead;
        public boolean closed;
        public final ForwardingTimeout timeout;

        private AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1Codec.this.source.timeout());
            this.bytesRead = 0L;
        }

        public final void endOfInput(boolean z10, IOException iOException) throws IOException {
            Http1Codec http1Codec = Http1Codec.this;
            int i10 = http1Codec.state;
            if (i10 == 6) {
                return;
            }
            if (i10 == 5) {
                http1Codec.detachTimeout(this.timeout);
                Http1Codec http1Codec2 = Http1Codec.this;
                http1Codec2.state = 6;
                StreamAllocation streamAllocation = http1Codec2.streamAllocation;
                if (streamAllocation != null) {
                    streamAllocation.streamFinished(!z10, http1Codec2, this.bytesRead, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + Http1Codec.this.state);
        }

        @Override // com.alibaba.security.common.http.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            try {
                long read = Http1Codec.this.source.read(buffer, j10);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e2) {
                endOfInput(false, e2);
                throw e2;
            }
        }

        @Override // com.alibaba.security.common.http.okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());
        }

        @Override // com.alibaba.security.common.http.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1Codec.this.sink.writeUtf8("0\r\n\r\n");
            Http1Codec.this.detachTimeout(this.timeout);
            Http1Codec.this.state = 3;
        }

        @Override // com.alibaba.security.common.http.okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1Codec.this.sink.flush();
        }

        @Override // com.alibaba.security.common.http.okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // com.alibaba.security.common.http.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            Http1Codec.this.sink.writeHexadecimalUnsignedLong(j10);
            Http1Codec.this.sink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            Http1Codec.this.sink.write(buffer, j10);
            Http1Codec.this.sink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpUrl url;

        public ChunkedSource(HttpUrl httpUrl) {
            super();
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.url = httpUrl;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1Codec.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.source.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.source.readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
                    endOfInput(true, null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // com.alibaba.security.common.http.ok.internal.http1.Http1Codec.AbstractSource, com.alibaba.security.common.http.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            if (j10 >= 0) {
                if (!this.closed) {
                    if (!this.hasMoreChunks) {
                        return -1L;
                    }
                    long j11 = this.bytesRemainingInChunk;
                    if (j11 == 0 || j11 == -1) {
                        readChunkSize();
                        if (!this.hasMoreChunks) {
                            return -1L;
                        }
                    }
                    long read = super.read(buffer, Math.min(j10, this.bytesRemainingInChunk));
                    if (read != -1) {
                        this.bytesRemainingInChunk -= read;
                        return read;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    endOfInput(false, protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout;

        public FixedLengthSink(long j10) {
            this.timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());
            this.bytesRemaining = j10;
        }

        @Override // com.alibaba.security.common.http.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining <= 0) {
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // com.alibaba.security.common.http.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1Codec.this.sink.flush();
        }

        @Override // com.alibaba.security.common.http.okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // com.alibaba.security.common.http.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(buffer.size(), 0L, j10);
                if (j10 <= this.bytesRemaining) {
                    Http1Codec.this.sink.write(buffer, j10);
                    this.bytesRemaining -= j10;
                    return;
                }
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j10);
            }
            throw new IllegalStateException("closed");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j10) throws IOException {
            super();
            this.bytesRemaining = j10;
            if (j10 == 0) {
                endOfInput(true, null);
            }
        }

        @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // com.alibaba.security.common.http.ok.internal.http1.Http1Codec.AbstractSource, com.alibaba.security.common.http.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            if (j10 >= 0) {
                if (!this.closed) {
                    long j11 = this.bytesRemaining;
                    if (j11 == 0) {
                        return -1L;
                    }
                    long read = super.read(buffer, Math.min(j11, j10));
                    if (read != -1) {
                        long j12 = this.bytesRemaining - read;
                        this.bytesRemaining = j12;
                        if (j12 == 0) {
                            endOfInput(true, null);
                        }
                        return read;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    endOfInput(false, protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        public UnknownLengthSource() {
            super();
        }

        @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // com.alibaba.security.common.http.ok.internal.http1.Http1Codec.AbstractSource, com.alibaba.security.common.http.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            if (j10 >= 0) {
                if (!this.closed) {
                    if (this.inputExhausted) {
                        return -1L;
                    }
                    long read = super.read(buffer, j10);
                    if (read != -1) {
                        return read;
                    }
                    this.inputExhausted = true;
                    endOfInput(true, null);
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
    }

    public Http1Codec(RPHttpClient rPHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = rPHttpClient;
        this.streamAllocation = streamAllocation;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    private String readHeaderLine() throws IOException {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public Sink createRequestBody(RPRequest rPRequest, long j10) {
        if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(rPRequest.header(DownloadUtils.TRANSFER_ENCODING))) {
            return newChunkedSink();
        }
        if (j10 != -1) {
            return newFixedLengthSink(j10);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long j10) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j10);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long j10) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j10);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            StreamAllocation streamAllocation = this.streamAllocation;
            if (streamAllocation != null) {
                this.state = 5;
                streamAllocation.noNewStreams();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.state);
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation = this.streamAllocation;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0L, RPOkio.buffer(newFixedLengthSource(0L)));
        }
        if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(response.header(DownloadUtils.TRANSFER_ENCODING))) {
            return new RealResponseBody(header, -1L, RPOkio.buffer(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, RPOkio.buffer(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1L, RPOkio.buffer(newUnknownLengthSource()));
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() != 0) {
                Internal.instance.addLenient(builder, readHeaderLine);
            } else {
                return builder.build();
            }
        }
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z10) throws IOException {
        int i10 = this.state;
        if (i10 != 1 && i10 != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        try {
            StatusLine parse = StatusLine.parse(readHeaderLine());
            Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
            if (z10 && parse.code == 100) {
                return null;
            }
            if (parse.code == 100) {
                this.state = 3;
                return headers;
            }
            this.state = 4;
            return headers;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + ((Object) this.streamAllocation));
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            this.sink.writeUtf8(str).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.sink.writeUtf8(headers.name(i10)).writeUtf8(": ").writeUtf8(headers.value(i10)).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            this.sink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            this.state = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    @Override // com.alibaba.security.common.http.ok.internal.http.HttpCodec
    public void writeRequestHeaders(RPRequest rPRequest) throws IOException {
        writeRequest(rPRequest.headers(), RequestLine.get(rPRequest, this.streamAllocation.connection().route().proxy().type()));
    }
}
