package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Hpack;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Http2Writer implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f41968b = Logger.getLogger(Http2.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Hpack.Writer f41969a;

    /* renamed from: c, reason: collision with root package name */
    private final BufferedSink f41970c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f41971d;

    /* renamed from: e, reason: collision with root package name */
    private final Buffer f41972e;

    /* renamed from: f, reason: collision with root package name */
    private int f41973f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f41974g;

    public Http2Writer(BufferedSink bufferedSink, boolean z10) {
        this.f41970c = bufferedSink;
        this.f41971d = z10;
        Buffer buffer = new Buffer();
        this.f41972e = buffer;
        this.f41969a = new Hpack.Writer(buffer);
        this.f41973f = 16384;
    }

    private void a(int i10, long j10) throws IOException {
        while (j10 > 0) {
            int min = (int) Math.min(this.f41973f, j10);
            long j11 = min;
            j10 -= j11;
            frameHeader(i10, min, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
            this.f41970c.write(this.f41972e, j11);
        }
    }

    private static void a(BufferedSink bufferedSink, int i10) throws IOException {
        bufferedSink.writeByte((i10 >>> 16) & 255);
        bufferedSink.writeByte((i10 >>> 8) & 255);
        bufferedSink.writeByte(i10 & 255);
    }

    public void a(int i10, byte b4, Buffer buffer, int i11) throws IOException {
        frameHeader(i10, i11, (byte) 0, b4);
        if (i11 > 0) {
            this.f41970c.write(buffer, i11);
        }
    }

    public void a(boolean z10, int i10, List<Header> list) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        this.f41969a.a(list);
        long size = this.f41972e.size();
        int min = (int) Math.min(this.f41973f, size);
        long j10 = min;
        byte b4 = size == j10 ? (byte) 4 : (byte) 0;
        if (z10) {
            b4 = (byte) (b4 | 1);
        }
        frameHeader(i10, min, (byte) 1, b4);
        this.f41970c.write(this.f41972e, j10);
        if (size > j10) {
            a(i10, size - j10);
        }
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        this.f41973f = settings.d(this.f41973f);
        if (settings.c() != -1) {
            this.f41969a.a(settings.c());
        }
        frameHeader(0, 0, (byte) 4, (byte) 1);
        this.f41970c.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f41974g = true;
        this.f41970c.close();
    }

    public synchronized void connectionPreface() throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        if (this.f41971d) {
            Logger logger = f41968b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.f41854a.hex()));
            }
            this.f41970c.write(Http2.f41854a.toByteArray());
            this.f41970c.flush();
        }
    }

    public synchronized void data(boolean z10, int i10, Buffer buffer, int i11) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        a(i10, z10 ? (byte) 1 : (byte) 0, buffer, i11);
    }

    public synchronized void flush() throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        this.f41970c.flush();
    }

    public void frameHeader(int i10, int i11, byte b4, byte b10) throws IOException {
        Logger logger = f41968b;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.a(false, i10, i11, b4, b10));
        }
        int i12 = this.f41973f;
        if (i11 > i12) {
            throw Http2.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw Http2.a("reserved bit set: %s", Integer.valueOf(i10));
        }
        a(this.f41970c, i11);
        this.f41970c.writeByte(b4 & 255);
        this.f41970c.writeByte(b10 & 255);
        this.f41970c.writeInt(i10 & Integer.MAX_VALUE);
    }

    public synchronized void goAway(int i10, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        if (errorCode.f41824l == -1) {
            throw Http2.a("errorCode.httpCode == -1", new Object[0]);
        }
        frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f41970c.writeInt(i10);
        this.f41970c.writeInt(errorCode.f41824l);
        if (bArr.length > 0) {
            this.f41970c.write(bArr);
        }
        this.f41970c.flush();
    }

    public synchronized void headers(int i10, List<Header> list) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        a(false, i10, list);
    }

    public int maxDataLength() {
        return this.f41973f;
    }

    public synchronized void ping(boolean z10, int i10, int i11) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
        this.f41970c.writeInt(i10);
        this.f41970c.writeInt(i11);
        this.f41970c.flush();
    }

    public synchronized void pushPromise(int i10, int i11, List<Header> list) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        this.f41969a.a(list);
        long size = this.f41972e.size();
        int min = (int) Math.min(this.f41973f - 4, size);
        long j10 = min;
        frameHeader(i10, min + 4, (byte) 5, size == j10 ? (byte) 4 : (byte) 0);
        this.f41970c.writeInt(i11 & Integer.MAX_VALUE);
        this.f41970c.write(this.f41972e, j10);
        if (size > j10) {
            a(i10, size - j10);
        }
    }

    public synchronized void rstStream(int i10, ErrorCode errorCode) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        if (errorCode.f41824l == -1) {
            throw new IllegalArgumentException();
        }
        frameHeader(i10, 4, (byte) 3, (byte) 0);
        this.f41970c.writeInt(errorCode.f41824l);
        this.f41970c.flush();
    }

    public synchronized void settings(Settings settings) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        int i10 = 0;
        frameHeader(0, settings.b() * 6, (byte) 4, (byte) 0);
        while (i10 < 10) {
            if (settings.a(i10)) {
                this.f41970c.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                this.f41970c.writeInt(settings.b(i10));
            }
            i10++;
        }
        this.f41970c.flush();
    }

    public synchronized void synReply(boolean z10, int i10, List<Header> list) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        a(z10, i10, list);
    }

    public synchronized void synStream(boolean z10, int i10, int i11, List<Header> list) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        a(z10, i10, list);
    }

    public synchronized void windowUpdate(int i10, long j10) throws IOException {
        if (this.f41974g) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw Http2.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        }
        frameHeader(i10, 4, (byte) 8, (byte) 0);
        this.f41970c.writeInt((int) j10);
        this.f41970c.flush();
    }
}
