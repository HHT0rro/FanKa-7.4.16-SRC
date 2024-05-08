package com.alibaba.security.common.http.okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RPOkio {
    public static final Logger logger = Logger.getLogger(RPOkio.class.getName());

    private RPOkio() {
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() { // from class: com.alibaba.security.common.http.okio.RPOkio.3
            @Override // com.alibaba.security.common.http.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.alibaba.security.common.http.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.alibaba.security.common.http.okio.Sink
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override // com.alibaba.security.common.http.okio.Sink
            public void write(Buffer buffer, long j10) throws IOException {
                buffer.skip(j10);
            }
        };
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() { // from class: com.alibaba.security.common.http.okio.RPOkio.4
            @Override // com.alibaba.security.common.http.okio.AsyncTimeout
            public IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.alibaba.security.common.http.okio.AsyncTimeout
            public void timedOut() {
                try {
                    Socket.this.close();
                } catch (AssertionError e2) {
                    if (RPOkio.isAndroidGetsocknameError(e2)) {
                        RPOkio.logger.log(Level.WARNING, "Failed to close timed out socket " + ((Object) Socket.this), (Throwable) e2);
                        return;
                    }
                    throw e2;
                } catch (Exception e10) {
                    RPOkio.logger.log(Level.WARNING, "Failed to close timed out socket " + ((Object) Socket.this), (Throwable) e10);
                }
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new Sink() { // from class: com.alibaba.security.common.http.okio.RPOkio.1
                @Override // com.alibaba.security.common.http.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.alibaba.security.common.http.okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // com.alibaba.security.common.http.okio.Sink
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    return "sink(" + ((Object) outputStream) + ")";
                }

                @Override // com.alibaba.security.common.http.okio.Sink
                public void write(Buffer buffer, long j10) throws IOException {
                    RPOkioUtil.checkOffsetAndCount(buffer.size, 0L, j10);
                    while (j10 > 0) {
                        Timeout.this.throwIfReached();
                        Segment segment = buffer.head;
                        int min = (int) Math.min(j10, segment.limit - segment.pos);
                        outputStream.write(segment.data, segment.pos, min);
                        int i10 = segment.pos + min;
                        segment.pos = i10;
                        long j11 = min;
                        j10 -= j11;
                        buffer.size -= j11;
                        if (i10 == segment.limit) {
                            buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    }
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new Source() { // from class: com.alibaba.security.common.http.okio.RPOkio.2
                @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                @Override // com.alibaba.security.common.http.okio.Source
                public long read(Buffer buffer, long j10) throws IOException {
                    if (j10 < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j10);
                    }
                    if (j10 == 0) {
                        return 0L;
                    }
                    try {
                        Timeout.this.throwIfReached();
                        Segment writableSegment = buffer.writableSegment(1);
                        int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j10, 8192 - writableSegment.limit));
                        if (read == -1) {
                            return -1L;
                        }
                        writableSegment.limit += read;
                        long j11 = read;
                        buffer.size += j11;
                        return j11;
                    } catch (AssertionError e2) {
                        if (RPOkio.isAndroidGetsocknameError(e2)) {
                            throw new IOException(e2);
                        }
                        throw e2;
                    }
                }

                @Override // com.alibaba.security.common.http.okio.Source
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    return "source(" + ((Object) inputStream) + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                AsyncTimeout timeout = timeout(socket);
                return timeout.sink(sink(socket.getOutputStream(), timeout));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                AsyncTimeout timeout = timeout(socket);
                return timeout.source(source(socket.getInputStream(), timeout));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }
}
