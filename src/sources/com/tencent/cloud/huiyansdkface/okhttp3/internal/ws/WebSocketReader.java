package com.tencent.cloud.huiyansdkface.okhttp3.internal.ws;

import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class WebSocketReader {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f42061a;

    /* renamed from: b, reason: collision with root package name */
    public final BufferedSource f42062b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameCallback f42063c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f42064d;

    /* renamed from: e, reason: collision with root package name */
    public int f42065e;

    /* renamed from: f, reason: collision with root package name */
    public long f42066f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f42067g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f42068h;

    /* renamed from: i, reason: collision with root package name */
    private final Buffer f42069i = new Buffer();

    /* renamed from: j, reason: collision with root package name */
    private final Buffer f42070j = new Buffer();

    /* renamed from: k, reason: collision with root package name */
    private final byte[] f42071k;

    /* renamed from: l, reason: collision with root package name */
    private final Buffer.UnsafeCursor f42072l;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface FrameCallback {
        void onReadClose(int i10, String str);

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z10, BufferedSource bufferedSource, FrameCallback frameCallback) {
        Objects.requireNonNull(bufferedSource, "source == null");
        Objects.requireNonNull(frameCallback, "frameCallback == null");
        this.f42061a = z10;
        this.f42062b = bufferedSource;
        this.f42063c = frameCallback;
        this.f42071k = z10 ? null : new byte[4];
        this.f42072l = z10 ? null : new Buffer.UnsafeCursor();
    }

    /* JADX WARN: Finally extract failed */
    private void b() throws IOException {
        if (this.f42064d) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.f42062b.timeout().timeoutNanos();
        this.f42062b.timeout().clearTimeout();
        try {
            int readByte = this.f42062b.readByte() & 255;
            this.f42062b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            this.f42065e = readByte & 15;
            boolean z10 = (readByte & 128) != 0;
            this.f42067g = z10;
            boolean z11 = (readByte & 8) != 0;
            this.f42068h = z11;
            if (z11 && !z10) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z12 = (readByte & 64) != 0;
            boolean z13 = (readByte & 32) != 0;
            boolean z14 = (readByte & 16) != 0;
            if (z12 || z13 || z14) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            int readByte2 = this.f42062b.readByte() & 255;
            boolean z15 = (readByte2 & 128) != 0;
            if (z15 == this.f42061a) {
                throw new ProtocolException(this.f42061a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j10 = readByte2 & 127;
            this.f42066f = j10;
            if (j10 == 126) {
                this.f42066f = this.f42062b.readShort() & 65535;
            } else if (j10 == 127) {
                long readLong = this.f42062b.readLong();
                this.f42066f = readLong;
                if (readLong < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f42066f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.f42068h && this.f42066f > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z15) {
                this.f42062b.readFully(this.f42071k);
            }
        } catch (Throwable th) {
            this.f42062b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void c() throws IOException {
        String str;
        long j10 = this.f42066f;
        if (j10 > 0) {
            this.f42062b.readFully(this.f42069i, j10);
            if (!this.f42061a) {
                this.f42069i.readAndWriteUnsafe(this.f42072l);
                this.f42072l.seek(0L);
                WebSocketProtocol.a(this.f42072l, this.f42071k);
                this.f42072l.close();
            }
        }
        switch (this.f42065e) {
            case 8:
                short s2 = 1005;
                long size = this.f42069i.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s2 = this.f42069i.readShort();
                    str = this.f42069i.readUtf8();
                    String a10 = WebSocketProtocol.a(s2);
                    if (a10 != null) {
                        throw new ProtocolException(a10);
                    }
                } else {
                    str = "";
                }
                this.f42063c.onReadClose(s2, str);
                this.f42064d = true;
                return;
            case 9:
                this.f42063c.onReadPing(this.f42069i.readByteString());
                return;
            case 10:
                this.f42063c.onReadPong(this.f42069i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f42065e));
        }
    }

    private void d() throws IOException {
        int i10 = this.f42065e;
        if (i10 != 1 && i10 != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i10));
        }
        f();
        if (i10 == 1) {
            this.f42063c.onReadMessage(this.f42070j.readUtf8());
        } else {
            this.f42063c.onReadMessage(this.f42070j.readByteString());
        }
    }

    private void e() throws IOException {
        while (!this.f42064d) {
            b();
            if (!this.f42068h) {
                return;
            } else {
                c();
            }
        }
    }

    private void f() throws IOException {
        while (!this.f42064d) {
            long j10 = this.f42066f;
            if (j10 > 0) {
                this.f42062b.readFully(this.f42070j, j10);
                if (!this.f42061a) {
                    this.f42070j.readAndWriteUnsafe(this.f42072l);
                    this.f42072l.seek(this.f42070j.size() - this.f42066f);
                    WebSocketProtocol.a(this.f42072l, this.f42071k);
                    this.f42072l.close();
                }
            }
            if (this.f42067g) {
                return;
            }
            e();
            if (this.f42065e != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f42065e));
            }
        }
        throw new IOException("closed");
    }

    public void a() throws IOException {
        b();
        if (this.f42068h) {
            c();
        } else {
            d();
        }
    }
}
