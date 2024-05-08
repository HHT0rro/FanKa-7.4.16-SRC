package com.tencent.cloud.huiyansdkface.okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class WebSocketWriter {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f42073a;

    /* renamed from: b, reason: collision with root package name */
    public final Random f42074b;

    /* renamed from: c, reason: collision with root package name */
    public final BufferedSink f42075c;

    /* renamed from: d, reason: collision with root package name */
    public final Buffer f42076d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f42077e;

    /* renamed from: f, reason: collision with root package name */
    public final Buffer f42078f = new Buffer();

    /* renamed from: g, reason: collision with root package name */
    public final FrameSink f42079g = new FrameSink();

    /* renamed from: h, reason: collision with root package name */
    public boolean f42080h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f42081i;

    /* renamed from: j, reason: collision with root package name */
    private final Buffer.UnsafeCursor f42082j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class FrameSink implements Sink {

        /* renamed from: a, reason: collision with root package name */
        public int f42083a;

        /* renamed from: b, reason: collision with root package name */
        public long f42084b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f42085c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f42086d;

        public FrameSink() {
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f42086d) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.a(this.f42083a, webSocketWriter.f42078f.size(), this.f42085c, true);
            this.f42086d = true;
            WebSocketWriter.this.f42080h = false;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f42086d) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.a(this.f42083a, webSocketWriter.f42078f.size(), this.f42085c, false);
            this.f42085c = false;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public Timeout timeout() {
            return WebSocketWriter.this.f42075c.timeout();
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            if (this.f42086d) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.f42078f.write(buffer, j10);
            boolean z10 = this.f42085c && this.f42084b != -1 && WebSocketWriter.this.f42078f.size() > this.f42084b - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            long completeSegmentByteCount = WebSocketWriter.this.f42078f.completeSegmentByteCount();
            if (completeSegmentByteCount <= 0 || z10) {
                return;
            }
            WebSocketWriter.this.a(this.f42083a, completeSegmentByteCount, this.f42085c, false);
            this.f42085c = false;
        }
    }

    public WebSocketWriter(boolean z10, BufferedSink bufferedSink, Random random) {
        Objects.requireNonNull(bufferedSink, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.f42073a = z10;
        this.f42075c = bufferedSink;
        this.f42076d = bufferedSink.buffer();
        this.f42074b = random;
        this.f42081i = z10 ? new byte[4] : null;
        this.f42082j = z10 ? new Buffer.UnsafeCursor() : null;
    }

    private void b(int i10, ByteString byteString) throws IOException {
        if (this.f42077e) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.f42076d.writeByte(i10 | 128);
        if (this.f42073a) {
            this.f42076d.writeByte(size | 128);
            this.f42074b.nextBytes(this.f42081i);
            this.f42076d.write(this.f42081i);
            if (size > 0) {
                long size2 = this.f42076d.size();
                this.f42076d.write(byteString);
                this.f42076d.readAndWriteUnsafe(this.f42082j);
                this.f42082j.seek(size2);
                WebSocketProtocol.a(this.f42082j, this.f42081i);
                this.f42082j.close();
            }
        } else {
            this.f42076d.writeByte(size);
            this.f42076d.write(byteString);
        }
        this.f42075c.flush();
    }

    public Sink a(int i10, long j10) {
        if (this.f42080h) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.f42080h = true;
        FrameSink frameSink = this.f42079g;
        frameSink.f42083a = i10;
        frameSink.f42084b = j10;
        frameSink.f42085c = true;
        frameSink.f42086d = false;
        return frameSink;
    }

    public void a(int i10, long j10, boolean z10, boolean z11) throws IOException {
        if (this.f42077e) {
            throw new IOException("closed");
        }
        if (!z10) {
            i10 = 0;
        }
        if (z11) {
            i10 |= 128;
        }
        this.f42076d.writeByte(i10);
        int i11 = this.f42073a ? 128 : 0;
        if (j10 <= 125) {
            this.f42076d.writeByte(((int) j10) | i11);
        } else if (j10 <= 65535) {
            this.f42076d.writeByte(i11 | 126);
            this.f42076d.writeShort((int) j10);
        } else {
            this.f42076d.writeByte(i11 | 127);
            this.f42076d.writeLong(j10);
        }
        if (this.f42073a) {
            this.f42074b.nextBytes(this.f42081i);
            this.f42076d.write(this.f42081i);
            if (j10 > 0) {
                long size = this.f42076d.size();
                this.f42076d.write(this.f42078f, j10);
                this.f42076d.readAndWriteUnsafe(this.f42082j);
                this.f42082j.seek(size);
                WebSocketProtocol.a(this.f42082j, this.f42081i);
                this.f42082j.close();
            }
        } else {
            this.f42076d.write(this.f42078f, j10);
        }
        this.f42075c.emit();
    }

    public void a(int i10, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i10 != 0 || byteString != null) {
            if (i10 != 0) {
                WebSocketProtocol.b(i10);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i10);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            b(8, byteString2);
        } finally {
            this.f42077e = true;
        }
    }

    public void a(ByteString byteString) throws IOException {
        b(9, byteString);
    }

    public void b(ByteString byteString) throws IOException {
        b(10, byteString);
    }
}
