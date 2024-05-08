package com.alibaba.security.common.http.ok.internal.http2;

import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.http2.Hpack;
import com.alibaba.security.common.http.okio.Buffer;
import com.alibaba.security.common.http.okio.BufferedSink;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    public final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public Http2Writer(BufferedSink bufferedSink, boolean z10) {
        this.sink = bufferedSink;
        this.client = z10;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(buffer);
        this.maxFrameSize = 16384;
    }

    private void writeContinuationFrames(int i10, long j10) throws IOException {
        while (j10 > 0) {
            int min = (int) Math.min(this.maxFrameSize, j10);
            long j11 = min;
            j10 -= j11;
            frameHeader(i10, min, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j11);
        }
    }

    private static void writeMedium(BufferedSink bufferedSink, int i10) throws IOException {
        bufferedSink.writeByte((i10 >>> 16) & 255);
        bufferedSink.writeByte((i10 >>> 8) & 255);
        bufferedSink.writeByte(i10 & 255);
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, (byte) 4, (byte) 1);
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

    public synchronized void connectionPreface() throws IOException {
        if (!this.closed) {
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                }
                this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public synchronized void data(boolean z10, int i10, Buffer buffer, int i11) throws IOException {
        if (!this.closed) {
            dataFrame(i10, z10 ? (byte) 1 : (byte) 0, buffer, i11);
        } else {
            throw new IOException("closed");
        }
    }

    public void dataFrame(int i10, byte b4, Buffer buffer, int i11) throws IOException {
        frameHeader(i10, i11, (byte) 0, b4);
        if (i11 > 0) {
            this.sink.write(buffer, i11);
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void frameHeader(int i10, int i11, byte b4, byte b10) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.frameLog(false, i10, i11, b4, b10));
        }
        int i12 = this.maxFrameSize;
        if (i11 > i12) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i10));
        }
        writeMedium(this.sink, i11);
        this.sink.writeByte(b4 & 255);
        this.sink.writeByte(b10 & 255);
        this.sink.writeInt(i10 & Integer.MAX_VALUE);
    }

    public synchronized void goAway(int i10, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (!this.closed) {
            if (errorCode.httpCode != -1) {
                frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.sink.writeInt(i10);
                this.sink.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
            } else {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void headers(int i10, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(false, i10, list);
        } else {
            throw new IOException("closed");
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z10, int i10, int i11) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
            this.sink.writeInt(i10);
            this.sink.writeInt(i11);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void pushPromise(int i10, int i11, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize - 4, size);
            long j10 = min;
            frameHeader(i10, min + 4, (byte) 5, size == j10 ? (byte) 4 : (byte) 0);
            this.sink.writeInt(i11 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j10);
            if (size > j10) {
                writeContinuationFrames(i10, size - j10);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void rstStream(int i10, ErrorCode errorCode) throws IOException {
        if (!this.closed) {
            if (errorCode.httpCode != -1) {
                frameHeader(i10, 4, (byte) 3, (byte) 0);
                this.sink.writeInt(errorCode.httpCode);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void settings(Settings settings) throws IOException {
        if (!this.closed) {
            int i10 = 0;
            frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
            while (i10 < 10) {
                if (settings.isSet(i10)) {
                    this.sink.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                    this.sink.writeInt(settings.get(i10));
                }
                i10++;
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synReply(boolean z10, int i10, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z10, i10, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synStream(boolean z10, int i10, int i11, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z10, i10, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void windowUpdate(int i10, long j10) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j10 != 0 && j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            frameHeader(i10, 4, (byte) 8, (byte) 0);
            this.sink.writeInt((int) j10);
            this.sink.flush();
        } else {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        }
    }

    public void headers(boolean z10, int i10, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize, size);
            long j10 = min;
            byte b4 = size == j10 ? (byte) 4 : (byte) 0;
            if (z10) {
                b4 = (byte) (b4 | 1);
            }
            frameHeader(i10, min, (byte) 1, b4);
            this.sink.write(this.hpackBuffer, j10);
            if (size > j10) {
                writeContinuationFrames(i10, size - j10);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
