package io.grpc.okhttp;

import com.google.common.base.o;
import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Settings;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import java.io.IOException;
import java.net.Socket;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class AsyncSink implements Sink {
    private boolean controlFramesExceeded;
    private int controlFramesInWrite;
    private final int maxQueuedControlFrames;
    private int queuedControlFrames;
    private final SerializingExecutor serializingExecutor;
    private Sink sink;
    private Socket socket;
    private final ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler;
    private final Object lock = new Object();
    private final Buffer buffer = new Buffer();
    private boolean writeEnqueued = false;
    private boolean flushEnqueued = false;
    private boolean closed = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class LimitControlFramesWriter extends ForwardingFrameWriter {
        public LimitControlFramesWriter(FrameWriter frameWriter) {
            super(frameWriter);
        }

        @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
        public void ackSettings(Settings settings) throws IOException {
            AsyncSink.access$908(AsyncSink.this);
            super.ackSettings(settings);
        }

        @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
        public void ping(boolean z10, int i10, int i11) throws IOException {
            if (z10) {
                AsyncSink.access$908(AsyncSink.this);
            }
            super.ping(z10, i10, i11);
        }

        @Override // io.grpc.okhttp.ForwardingFrameWriter, io.grpc.okhttp.internal.framed.FrameWriter
        public void rstStream(int i10, ErrorCode errorCode) throws IOException {
            AsyncSink.access$908(AsyncSink.this);
            super.rstStream(i10, errorCode);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public abstract class WriteRunnable implements Runnable {
        private WriteRunnable() {
        }

        public abstract void doRun() throws IOException;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (AsyncSink.this.sink != null) {
                    doRun();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e2) {
                AsyncSink.this.transportExceptionHandler.onException(e2);
            }
        }
    }

    private AsyncSink(SerializingExecutor serializingExecutor, ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler, int i10) {
        this.serializingExecutor = (SerializingExecutor) o.s(serializingExecutor, "executor");
        this.transportExceptionHandler = (ExceptionHandlingFrameWriter.TransportExceptionHandler) o.s(transportExceptionHandler, "exceptionHandler");
        this.maxQueuedControlFrames = i10;
    }

    public static /* synthetic */ int access$420(AsyncSink asyncSink, int i10) {
        int i11 = asyncSink.queuedControlFrames - i10;
        asyncSink.queuedControlFrames = i11;
        return i11;
    }

    public static /* synthetic */ int access$908(AsyncSink asyncSink) {
        int i10 = asyncSink.controlFramesInWrite;
        asyncSink.controlFramesInWrite = i10 + 1;
        return i10;
    }

    public static AsyncSink sink(SerializingExecutor serializingExecutor, ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler, int i10) {
        return new AsyncSink(serializingExecutor, transportExceptionHandler, i10);
    }

    public void becomeConnected(Sink sink, Socket socket) {
        o.y(this.sink == null, "AsyncSink's becomeConnected should only be called once.");
        this.sink = (Sink) o.s(sink, "sink");
        this.socket = (Socket) o.s(socket, "socket");
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.AsyncSink.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AsyncSink.this.sink != null && AsyncSink.this.buffer.size() > 0) {
                        AsyncSink.this.sink.write(AsyncSink.this.buffer, AsyncSink.this.buffer.size());
                    }
                } catch (IOException e2) {
                    AsyncSink.this.transportExceptionHandler.onException(e2);
                }
                AsyncSink.this.buffer.close();
                try {
                    if (AsyncSink.this.sink != null) {
                        AsyncSink.this.sink.close();
                    }
                } catch (IOException e10) {
                    AsyncSink.this.transportExceptionHandler.onException(e10);
                }
                try {
                    if (AsyncSink.this.socket != null) {
                        AsyncSink.this.socket.close();
                    }
                } catch (IOException e11) {
                    AsyncSink.this.transportExceptionHandler.onException(e11);
                }
            }
        });
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!this.closed) {
            PerfMark.startTask("AsyncSink.flush");
            try {
                synchronized (this.lock) {
                    if (this.flushEnqueued) {
                        return;
                    }
                    this.flushEnqueued = true;
                    this.serializingExecutor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncSink.2
                        public final Link link = PerfMark.linkOut();

                        @Override // io.grpc.okhttp.AsyncSink.WriteRunnable
                        public void doRun() throws IOException {
                            PerfMark.startTask("WriteRunnable.runFlush");
                            PerfMark.linkIn(this.link);
                            Buffer buffer = new Buffer();
                            try {
                                synchronized (AsyncSink.this.lock) {
                                    buffer.write(AsyncSink.this.buffer, AsyncSink.this.buffer.size());
                                    AsyncSink.this.flushEnqueued = false;
                                }
                                AsyncSink.this.sink.write(buffer, buffer.size());
                                AsyncSink.this.sink.flush();
                            } finally {
                                PerfMark.stopTask("WriteRunnable.runFlush");
                            }
                        }
                    });
                    return;
                }
            } finally {
                PerfMark.stopTask("AsyncSink.flush");
            }
        }
        throw new IOException("closed");
    }

    public FrameWriter limitControlFramesWriter(FrameWriter frameWriter) {
        return new LimitControlFramesWriter(frameWriter);
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        o.s(buffer, "source");
        if (!this.closed) {
            PerfMark.startTask("AsyncSink.write");
            try {
                synchronized (this.lock) {
                    this.buffer.write(buffer, j10);
                    int i10 = this.queuedControlFrames + this.controlFramesInWrite;
                    this.queuedControlFrames = i10;
                    boolean z10 = false;
                    this.controlFramesInWrite = 0;
                    if (!this.controlFramesExceeded && i10 > this.maxQueuedControlFrames) {
                        this.controlFramesExceeded = true;
                        z10 = true;
                    } else {
                        if (!this.writeEnqueued && !this.flushEnqueued && this.buffer.completeSegmentByteCount() > 0) {
                            this.writeEnqueued = true;
                        }
                        return;
                    }
                    if (z10) {
                        try {
                            this.socket.close();
                        } catch (IOException e2) {
                            this.transportExceptionHandler.onException(e2);
                        }
                        return;
                    }
                    this.serializingExecutor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncSink.1
                        public final Link link = PerfMark.linkOut();

                        @Override // io.grpc.okhttp.AsyncSink.WriteRunnable
                        public void doRun() throws IOException {
                            int i11;
                            PerfMark.startTask("WriteRunnable.runWrite");
                            PerfMark.linkIn(this.link);
                            Buffer buffer2 = new Buffer();
                            try {
                                synchronized (AsyncSink.this.lock) {
                                    buffer2.write(AsyncSink.this.buffer, AsyncSink.this.buffer.completeSegmentByteCount());
                                    AsyncSink.this.writeEnqueued = false;
                                    i11 = AsyncSink.this.queuedControlFrames;
                                }
                                AsyncSink.this.sink.write(buffer2, buffer2.size());
                                synchronized (AsyncSink.this.lock) {
                                    AsyncSink.access$420(AsyncSink.this, i11);
                                }
                            } finally {
                                PerfMark.stopTask("WriteRunnable.runWrite");
                            }
                        }
                    });
                    return;
                }
            } finally {
                PerfMark.stopTask("AsyncSink.write");
            }
        }
        throw new IOException("closed");
    }
}
