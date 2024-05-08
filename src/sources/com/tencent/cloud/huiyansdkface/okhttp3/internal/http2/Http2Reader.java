package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Hpack;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Http2Reader implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f41931a = Logger.getLogger(Http2.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public final Hpack.Reader f41932b;

    /* renamed from: c, reason: collision with root package name */
    private final BufferedSource f41933c;

    /* renamed from: d, reason: collision with root package name */
    private final ContinuationSource f41934d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f41935e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class ContinuationSource implements Source {

        /* renamed from: a, reason: collision with root package name */
        public int f41936a;

        /* renamed from: b, reason: collision with root package name */
        public byte f41937b;

        /* renamed from: c, reason: collision with root package name */
        public int f41938c;

        /* renamed from: d, reason: collision with root package name */
        public int f41939d;

        /* renamed from: e, reason: collision with root package name */
        public short f41940e;

        /* renamed from: f, reason: collision with root package name */
        private final BufferedSource f41941f;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.f41941f = bufferedSource;
        }

        private void a() throws IOException {
            int i10 = this.f41938c;
            int a10 = Http2Reader.a(this.f41941f);
            this.f41939d = a10;
            this.f41936a = a10;
            byte readByte = (byte) (this.f41941f.readByte() & 255);
            this.f41937b = (byte) (this.f41941f.readByte() & 255);
            Logger logger = Http2Reader.f41931a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.a(true, this.f41938c, this.f41936a, readByte, this.f41937b));
            }
            int readInt = this.f41941f.readInt() & Integer.MAX_VALUE;
            this.f41938c = readInt;
            if (readByte != 9) {
                throw Http2.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i10) {
                throw Http2.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            while (true) {
                int i10 = this.f41939d;
                if (i10 != 0) {
                    long read = this.f41941f.read(buffer, Math.min(j10, i10));
                    if (read == -1) {
                        return -1L;
                    }
                    this.f41939d = (int) (this.f41939d - read);
                    return read;
                }
                this.f41941f.skip(this.f41940e);
                this.f41940e = (short) 0;
                if ((this.f41937b & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public Timeout timeout() {
            return this.f41941f.timeout();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i10, String str, ByteString byteString, String str2, int i11, long j10);

        void data(boolean z10, int i10, BufferedSource bufferedSource, int i11) throws IOException;

        void goAway(int i10, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z10, int i10, int i11, List<Header> list);

        void ping(boolean z10, int i10, int i11);

        void priority(int i10, int i11, int i12, boolean z10);

        void pushPromise(int i10, int i11, List<Header> list) throws IOException;

        void rstStream(int i10, ErrorCode errorCode);

        void settings(boolean z10, Settings settings);

        void windowUpdate(int i10, long j10);
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z10) {
        this.f41933c = bufferedSource;
        this.f41935e = z10;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.f41934d = continuationSource;
        this.f41932b = new Hpack.Reader(4096, continuationSource);
    }

    public static int a(int i10, byte b4, short s2) throws IOException {
        if ((b4 & 8) != 0) {
            i10--;
        }
        if (s2 <= i10) {
            return (short) (i10 - s2);
        }
        throw Http2.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Integer.valueOf(i10));
    }

    public static int a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private List<Header> a(int i10, short s2, byte b4, int i11) throws IOException {
        ContinuationSource continuationSource = this.f41934d;
        continuationSource.f41939d = i10;
        continuationSource.f41936a = i10;
        continuationSource.f41940e = s2;
        continuationSource.f41937b = b4;
        continuationSource.f41938c = i11;
        this.f41932b.a();
        return this.f41932b.getAndResetHeaderList();
    }

    private void a(Handler handler, int i10) throws IOException {
        int readInt = this.f41933c.readInt();
        handler.priority(i10, readInt & Integer.MAX_VALUE, (this.f41933c.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void a(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i11 == 0) {
            throw Http2.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z10 = (b4 & 1) != 0;
        short readByte = (b4 & 8) != 0 ? (short) (this.f41933c.readByte() & 255) : (short) 0;
        if ((b4 & 32) != 0) {
            a(handler, i11);
            i10 -= 5;
        }
        handler.headers(z10, i11, -1, a(a(i10, b4, readByte), readByte, b4, i11));
    }

    private void b(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i11 == 0) {
            throw Http2.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z10 = (b4 & 1) != 0;
        if ((b4 & 32) != 0) {
            throw Http2.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short readByte = (b4 & 8) != 0 ? (short) (this.f41933c.readByte() & 255) : (short) 0;
        handler.data(z10, i11, this.f41933c, a(i10, b4, readByte));
        this.f41933c.skip(readByte);
    }

    private void c(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i10 != 5) {
            throw Http2.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw Http2.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(handler, i11);
    }

    private void d(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i10 != 4) {
            throw Http2.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw Http2.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int readInt = this.f41933c.readInt();
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
        if (fromHttp2 == null) {
            throw Http2.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        }
        handler.rstStream(i11, fromHttp2);
    }

    private void e(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i11 != 0) {
            throw Http2.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b4 & 1) != 0) {
            if (i10 != 0) {
                throw Http2.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (i10 % 6 != 0) {
            throw Http2.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
        }
        Settings settings = new Settings();
        for (int i12 = 0; i12 < i10; i12 += 6) {
            int readShort = this.f41933c.readShort() & 65535;
            int readInt = this.f41933c.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    readShort = 7;
                    if (readInt < 0) {
                        throw Http2.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    throw Http2.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                }
            } else if (readInt != 0 && readInt != 1) {
                throw Http2.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
            settings.a(readShort, readInt);
        }
        handler.settings(false, settings);
    }

    private void f(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i11 == 0) {
            throw Http2.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short readByte = (b4 & 8) != 0 ? (short) (this.f41933c.readByte() & 255) : (short) 0;
        handler.pushPromise(i11, this.f41933c.readInt() & Integer.MAX_VALUE, a(a(i10 - 4, b4, readByte), readByte, b4, i11));
    }

    private void g(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i10 != 8) {
            throw Http2.b("TYPE_PING length != 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw Http2.b("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b4 & 1) != 0, this.f41933c.readInt(), this.f41933c.readInt());
    }

    private void h(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i10 < 8) {
            throw Http2.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw Http2.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int readInt = this.f41933c.readInt();
        int readInt2 = this.f41933c.readInt();
        int i12 = i10 - 8;
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            throw Http2.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i12 > 0) {
            byteString = this.f41933c.readByteString(i12);
        }
        handler.goAway(readInt, fromHttp2, byteString);
    }

    private void i(Handler handler, int i10, byte b4, int i11) throws IOException {
        if (i10 != 4) {
            throw Http2.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
        long readInt = this.f41933c.readInt() & ZipUtils.UPPER_UNIXTIME_BOUND;
        if (readInt == 0) {
            throw Http2.b("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        handler.windowUpdate(i11, readInt);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f41933c.close();
    }

    public boolean nextFrame(boolean z10, Handler handler) throws IOException {
        try {
            this.f41933c.require(9L);
            int a10 = a(this.f41933c);
            if (a10 < 0 || a10 > 16384) {
                throw Http2.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a10));
            }
            byte readByte = (byte) (this.f41933c.readByte() & 255);
            if (z10 && readByte != 4) {
                throw Http2.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            }
            byte readByte2 = (byte) (this.f41933c.readByte() & 255);
            int readInt = this.f41933c.readInt() & Integer.MAX_VALUE;
            Logger logger = f41931a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.a(true, readInt, a10, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    b(handler, a10, readByte2, readInt);
                    return true;
                case 1:
                    a(handler, a10, readByte2, readInt);
                    return true;
                case 2:
                    c(handler, a10, readByte2, readInt);
                    return true;
                case 3:
                    d(handler, a10, readByte2, readInt);
                    return true;
                case 4:
                    e(handler, a10, readByte2, readInt);
                    return true;
                case 5:
                    f(handler, a10, readByte2, readInt);
                    return true;
                case 6:
                    g(handler, a10, readByte2, readInt);
                    return true;
                case 7:
                    h(handler, a10, readByte2, readInt);
                    return true;
                case 8:
                    i(handler, a10, readByte2, readInt);
                    return true;
                default:
                    this.f41933c.skip(a10);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.f41935e) {
            if (!nextFrame(true, handler)) {
                throw Http2.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        BufferedSource bufferedSource = this.f41933c;
        ByteString byteString = Http2.f41854a;
        ByteString readByteString = bufferedSource.readByteString(byteString.size());
        Logger logger = f41931a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
        }
        if (!byteString.equals(readByteString)) {
            throw Http2.b("Expected a connection header but was %s", readByteString.utf8());
        }
    }
}
