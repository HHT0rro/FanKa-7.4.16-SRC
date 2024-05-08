package com.tencent.cloud.huiyansdkface.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class RealBufferedSink implements BufferedSink {
    public final Buffer buffer = new Buffer();
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        Objects.requireNonNull(sink, "sink == null");
        this.sink = sink;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink, com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            Buffer buffer = this.buffer;
            long j10 = buffer.size;
            if (j10 > 0) {
                this.sink.write(buffer, j10);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.buffer, completeSegmentByteCount);
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.buffer;
        long j10 = buffer.size;
        if (j10 > 0) {
            this.sink.write(buffer, j10);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.tencent.cloud.huiyansdkface.okio.RealBufferedSink.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return ((Object) RealBufferedSink.this) + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i10) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.writeByte((int) ((byte) i10));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.write(bArr, i10, i11);
                RealBufferedSink.this.emitCompleteSegments();
            }
        };
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + ((Object) this.sink) + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        int write = this.buffer.write(byteBuffer);
        emitCompleteSegments();
        return write;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink write(ByteString byteString) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(byteString);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink write(Source source, long j10) throws IOException {
        while (j10 > 0) {
            long read = source.read(this.buffer, j10);
            if (read == -1) {
                throw new EOFException();
            }
            j10 -= read;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i10, int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr, i10, i11);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(buffer, j10);
        emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long read = source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            emitCompleteSegments();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeByte(int i10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeByte(i10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeDecimalLong(long j10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeInt(int i10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeInt(i10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeIntLe(int i10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeIntLe(i10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeLong(long j10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeLongLe(long j10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLongLe(j10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeShort(int i10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShort(i10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeShortLe(int i10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShortLe(i10);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeString(String str, int i10, int i11, Charset charset) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, i10, i11, charset);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeUtf8(String str) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i10, int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str, i10, i11);
        return emitCompleteSegments();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(i10);
        return emitCompleteSegments();
    }
}
