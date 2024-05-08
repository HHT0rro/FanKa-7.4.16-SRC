package io.grpc.okhttp;

import com.google.common.base.o;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ExceptionHandlingFrameWriter implements FrameWriter {
    private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    private final OkHttpFrameLogger frameLogger = new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpClientTransport.class);
    private final FrameWriter frameWriter;
    private final TransportExceptionHandler transportExceptionHandler;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface TransportExceptionHandler {
        void onException(Throwable th);
    }

    public ExceptionHandlingFrameWriter(TransportExceptionHandler transportExceptionHandler, FrameWriter frameWriter) {
        this.transportExceptionHandler = (TransportExceptionHandler) o.s(transportExceptionHandler, "transportExceptionHandler");
        this.frameWriter = (FrameWriter) o.s(frameWriter, "frameWriter");
    }

    public static Level getLogLevel(Throwable th) {
        if (th.getClass().equals(IOException.class)) {
            return Level.FINE;
        }
        return Level.INFO;
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void ackSettings(Settings settings) {
        this.frameLogger.logSettingsAck(OkHttpFrameLogger.Direction.OUTBOUND);
        try {
            this.frameWriter.ackSettings(settings);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.frameWriter.close();
        } catch (IOException e2) {
            log.log(getLogLevel(e2), "Failed closing connection", (Throwable) e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void connectionPreface() {
        try {
            this.frameWriter.connectionPreface();
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void data(boolean z10, int i10, Buffer buffer, int i11) {
        this.frameLogger.logData(OkHttpFrameLogger.Direction.OUTBOUND, i10, buffer.buffer(), i11, z10);
        try {
            this.frameWriter.data(z10, i10, buffer, i11);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void flush() {
        try {
            this.frameWriter.flush();
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void goAway(int i10, ErrorCode errorCode, byte[] bArr) {
        this.frameLogger.logGoAway(OkHttpFrameLogger.Direction.OUTBOUND, i10, errorCode, ByteString.of(bArr));
        try {
            this.frameWriter.goAway(i10, errorCode, bArr);
            this.frameWriter.flush();
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void headers(int i10, List<Header> list) {
        this.frameLogger.logHeaders(OkHttpFrameLogger.Direction.OUTBOUND, i10, list, false);
        try {
            this.frameWriter.headers(i10, list);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public int maxDataLength() {
        return this.frameWriter.maxDataLength();
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void ping(boolean z10, int i10, int i11) {
        if (z10) {
            this.frameLogger.logPingAck(OkHttpFrameLogger.Direction.OUTBOUND, (4294967295L & i11) | (i10 << 32));
        } else {
            this.frameLogger.logPing(OkHttpFrameLogger.Direction.OUTBOUND, (4294967295L & i11) | (i10 << 32));
        }
        try {
            this.frameWriter.ping(z10, i10, i11);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void pushPromise(int i10, int i11, List<Header> list) {
        this.frameLogger.logPushPromise(OkHttpFrameLogger.Direction.OUTBOUND, i10, i11, list);
        try {
            this.frameWriter.pushPromise(i10, i11, list);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void rstStream(int i10, ErrorCode errorCode) {
        this.frameLogger.logRstStream(OkHttpFrameLogger.Direction.OUTBOUND, i10, errorCode);
        try {
            this.frameWriter.rstStream(i10, errorCode);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void settings(Settings settings) {
        this.frameLogger.logSettings(OkHttpFrameLogger.Direction.OUTBOUND, settings);
        try {
            this.frameWriter.settings(settings);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void synReply(boolean z10, int i10, List<Header> list) {
        try {
            this.frameWriter.synReply(z10, i10, list);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void synStream(boolean z10, boolean z11, int i10, int i11, List<Header> list) {
        try {
            this.frameWriter.synStream(z10, z11, i10, i11, list);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void windowUpdate(int i10, long j10) {
        this.frameLogger.logWindowsUpdate(OkHttpFrameLogger.Direction.OUTBOUND, i10, j10);
        try {
            this.frameWriter.windowUpdate(i10, j10);
        } catch (IOException e2) {
            this.transportExceptionHandler.onException(e2);
        }
    }
}
