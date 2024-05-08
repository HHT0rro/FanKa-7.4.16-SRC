package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipUtils;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Http2Writer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;

    @NotNull
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    /* compiled from: Http2Writer.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Http2Writer(@NotNull BufferedSink sink, boolean z10) {
        s.i(sink, "sink");
        this.sink = sink;
        this.client = z10;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int i10, long j10) throws IOException {
        while (j10 > 0) {
            long min = Math.min(this.maxFrameSize, j10);
            j10 -= min;
            frameHeader(i10, (int) min, 9, j10 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(@NotNull Settings peerSettings) throws IOException {
        s.i(peerSettings, "peerSettings");
        if (!this.closed) {
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        if (!this.closed) {
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.write(Http2.CONNECTION_PREFACE);
                this.sink.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public final synchronized void data(boolean z10, int i10, @Nullable Buffer buffer, int i11) throws IOException {
        if (!this.closed) {
            dataFrame(i10, z10 ? 1 : 0, buffer, i11);
        } else {
            throw new IOException("closed");
        }
    }

    public final void dataFrame(int i10, int i11, @Nullable Buffer buffer, int i12) throws IOException {
        frameHeader(i10, i12, 0, i11);
        if (i12 > 0) {
            BufferedSink bufferedSink = this.sink;
            s.f(buffer);
            bufferedSink.write(buffer, i12);
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void frameHeader(int i10, int i11, int i12, int i13) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i10, i11, i12, i13));
        }
        if (!(i11 <= this.maxFrameSize)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i11).toString());
        }
        if ((((int) 2147483648L) & i10) == 0) {
            Util.writeMedium(this.sink, i11);
            this.sink.writeByte(i12 & 255);
            this.sink.writeByte(i13 & 255);
            this.sink.writeInt(i10 & Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException(("reserved bit set: " + i10).toString());
    }

    @NotNull
    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i10, @NotNull ErrorCode errorCode, @NotNull byte[] debugData) throws IOException {
        s.i(errorCode, "errorCode");
        s.i(debugData, "debugData");
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                frameHeader(0, debugData.length + 8, 7, 0);
                this.sink.writeInt(i10);
                this.sink.writeInt(errorCode.getHttpCode());
                if (!(debugData.length == 0)) {
                    this.sink.write(debugData);
                }
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void headers(boolean z10, int i10, @NotNull List<Header> headerBlock) throws IOException {
        s.i(headerBlock, "headerBlock");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(headerBlock);
            long size = this.hpackBuffer.size();
            long min = Math.min(this.maxFrameSize, size);
            int i11 = size == min ? 4 : 0;
            if (z10) {
                i11 |= 1;
            }
            frameHeader(i10, (int) min, 1, i11);
            this.sink.write(this.hpackBuffer, min);
            if (size > min) {
                writeContinuationFrames(i10, size - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z10, int i10, int i11) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, 6, z10 ? 1 : 0);
            this.sink.writeInt(i10);
            this.sink.writeInt(i11);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void pushPromise(int i10, int i11, @NotNull List<Header> requestHeaders) throws IOException {
        s.i(requestHeaders, "requestHeaders");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(requestHeaders);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize - 4, size);
            long j10 = min;
            frameHeader(i10, min + 4, 5, size == j10 ? 4 : 0);
            this.sink.writeInt(i11 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j10);
            if (size > j10) {
                writeContinuationFrames(i10, size - j10);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void rstStream(int i10, @NotNull ErrorCode errorCode) throws IOException {
        s.i(errorCode, "errorCode");
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                frameHeader(i10, 4, 3, 0);
                this.sink.writeInt(errorCode.getHttpCode());
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void settings(@NotNull Settings settings) throws IOException {
        s.i(settings, "settings");
        if (!this.closed) {
            int i10 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i10 < 10) {
                if (settings.isSet(i10)) {
                    this.sink.writeShort(i10 != 4 ? i10 != 7 ? i10 : 4 : 3);
                    this.sink.writeInt(settings.get(i10));
                }
                i10++;
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void windowUpdate(int i10, long j10) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j10 != 0 && j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            frameHeader(i10, 4, 8, 0);
            this.sink.writeInt((int) j10);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j10).toString());
        }
    }
}
