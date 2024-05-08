package com.alibaba.security.common.http.okio;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Pipe {
    public final long maxBufferSize;
    public boolean sinkClosed;
    public boolean sourceClosed;
    public final Buffer buffer = new Buffer();
    private final Sink sink = new PipeSink();
    private final Source source = new PipeSource();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class PipeSink implements Sink {
        public final Timeout timeout = new Timeout();

        public PipeSink() {
        }

        @Override // com.alibaba.security.common.http.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (pipe.sinkClosed) {
                    return;
                }
                if (pipe.sourceClosed && pipe.buffer.size() > 0) {
                    throw new IOException("source is closed");
                }
                Pipe pipe2 = Pipe.this;
                pipe2.sinkClosed = true;
                pipe2.buffer.notifyAll();
            }
        }

        @Override // com.alibaba.security.common.http.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (!pipe.sinkClosed) {
                    if (pipe.sourceClosed && pipe.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }

        @Override // com.alibaba.security.common.http.okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // com.alibaba.security.common.http.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sinkClosed) {
                    throw new IllegalStateException("closed");
                }
                while (j10 > 0) {
                    Pipe pipe = Pipe.this;
                    if (!pipe.sourceClosed) {
                        long size = pipe.maxBufferSize - pipe.buffer.size();
                        if (size == 0) {
                            this.timeout.waitUntilNotified(Pipe.this.buffer);
                        } else {
                            long min = Math.min(size, j10);
                            Pipe.this.buffer.write(buffer, min);
                            j10 -= min;
                            Pipe.this.buffer.notifyAll();
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class PipeSource implements Source {
        public final Timeout timeout = new Timeout();

        public PipeSource() {
        }

        @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        @Override // com.alibaba.security.common.http.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sourceClosed) {
                    while (Pipe.this.buffer.size() == 0) {
                        Pipe pipe = Pipe.this;
                        if (pipe.sinkClosed) {
                            return -1L;
                        }
                        this.timeout.waitUntilNotified(pipe.buffer);
                    }
                    long read = Pipe.this.buffer.read(buffer, j10);
                    Pipe.this.buffer.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        @Override // com.alibaba.security.common.http.okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j10) {
        if (j10 >= 1) {
            this.maxBufferSize = j10;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j10);
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
