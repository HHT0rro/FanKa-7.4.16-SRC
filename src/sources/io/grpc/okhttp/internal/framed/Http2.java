package io.grpc.okhttp.internal.framed;

import io.grpc.okhttp.internal.Protocol;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.Hpack;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipUtils;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Http2 implements Variant {
    public static final byte FLAG_ACK = 1;
    public static final byte FLAG_COMPRESSED = 32;
    public static final byte FLAG_END_HEADERS = 4;
    public static final byte FLAG_END_PUSH_PROMISE = 4;
    public static final byte FLAG_END_STREAM = 1;
    public static final byte FLAG_NONE = 0;
    public static final byte FLAG_PADDED = 8;
    public static final byte FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final byte TYPE_CONTINUATION = 9;
    public static final byte TYPE_DATA = 0;
    public static final byte TYPE_GOAWAY = 7;
    public static final byte TYPE_HEADERS = 1;
    public static final byte TYPE_PING = 6;
    public static final byte TYPE_PRIORITY = 2;
    public static final byte TYPE_PUSH_PROMISE = 5;
    public static final byte TYPE_RST_STREAM = 3;
    public static final byte TYPE_SETTINGS = 4;
    public static final byte TYPE_WINDOW_UPDATE = 8;
    private static final Logger logger = Logger.getLogger(FrameLogger.class.getName());
    private static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ContinuationSource implements Source {
        public byte flags;
        public int left;
        public int length;
        public short padding;
        private final BufferedSource source;
        public int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private void readContinuationHeader() throws IOException {
            int i10 = this.streamId;
            int readMedium = Http2.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte readByte = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(true, this.streamId, this.length, readByte, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (readByte != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i10) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            while (true) {
                int i10 = this.left;
                if (i10 == 0) {
                    this.source.skip(this.padding);
                    this.padding = (short) 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j10, i10));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class FrameLogger {
        private static final String[] TYPES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        private static final String[] FLAGS = new String[64];
        private static final String[] BINARY = new String[256];

        static {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr = BINARY;
                if (i11 >= strArr.length) {
                    break;
                }
                strArr[i11] = String.format("%8s", Integer.toBinaryString(i11)).replace(' ', '0');
                i11++;
            }
            String[] strArr2 = FLAGS;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i12 = 0; i12 < 1; i12++) {
                int i13 = iArr[i12];
                String[] strArr3 = FLAGS;
                strArr3[i13 | 8] = strArr3[i13] + "|PADDED";
            }
            String[] strArr4 = FLAGS;
            strArr4[4] = "END_HEADERS";
            strArr4[32] = "PRIORITY";
            strArr4[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i14 = 0; i14 < 3; i14++) {
                int i15 = iArr2[i14];
                for (int i16 = 0; i16 < 1; i16++) {
                    int i17 = iArr[i16];
                    String[] strArr5 = FLAGS;
                    int i18 = i17 | i15;
                    strArr5[i18] = strArr5[i17] + '|' + strArr5[i15];
                    strArr5[i18 | 8] = strArr5[i17] + '|' + strArr5[i15] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr6 = FLAGS;
                if (i10 >= strArr6.length) {
                    return;
                }
                if (strArr6[i10] == null) {
                    strArr6[i10] = BINARY[i10];
                }
                i10++;
            }
        }

        public static String formatFlags(byte b4, byte b10) {
            if (b10 == 0) {
                return "";
            }
            if (b4 != 2 && b4 != 3) {
                if (b4 == 4 || b4 == 6) {
                    return b10 == 1 ? "ACK" : BINARY[b10];
                }
                if (b4 != 7 && b4 != 8) {
                    String[] strArr = FLAGS;
                    String str = b10 < strArr.length ? strArr[b10] : BINARY[b10];
                    if (b4 != 5 || (b10 & 4) == 0) {
                        return (b4 != 0 || (b10 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return BINARY[b10];
        }

        public static String formatHeader(boolean z10, int i10, int i11, byte b4, byte b10) {
            String[] strArr = TYPES;
            String format = b4 < strArr.length ? strArr[b4] : String.format("0x%02x", Byte.valueOf(b4));
            String formatFlags = formatFlags(b4, b10);
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = z10 ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i10);
            objArr[2] = Integer.valueOf(i11);
            objArr[3] = format;
            objArr[4] = formatFlags;
            return String.format(locale, "%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lengthWithoutPadding(int i10, byte b4, short s2) throws IOException {
        if ((b4 & 8) != 0) {
            i10--;
        }
        if (s2 <= i10) {
            return (short) (i10 - s2);
        }
        throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeMedium(BufferedSink bufferedSink, int i10) throws IOException {
        bufferedSink.writeByte((i10 >>> 16) & 255);
        bufferedSink.writeByte((i10 >>> 8) & 255);
        bufferedSink.writeByte(i10 & 255);
    }

    @Override // io.grpc.okhttp.internal.framed.Variant
    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    @Override // io.grpc.okhttp.internal.framed.Variant
    public FrameReader newReader(BufferedSource bufferedSource, boolean z10) {
        return new Reader(bufferedSource, 4096, z10);
    }

    @Override // io.grpc.okhttp.internal.framed.Variant
    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z10) {
        return new Writer(bufferedSink, z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Reader implements FrameReader {
        private final boolean client;
        private final ContinuationSource continuation;
        public final Hpack.Reader hpackReader;
        private final BufferedSource source;

        public Reader(BufferedSource bufferedSource, int i10, boolean z10) {
            this.source = bufferedSource;
            this.client = z10;
            ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
            this.continuation = continuationSource;
            this.hpackReader = new Hpack.Reader(i10, continuationSource);
        }

        private void readData(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            boolean z10 = (b4 & 1) != 0;
            if (!((b4 & 32) != 0)) {
                short readByte = (b4 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
                handler.data(z10, i11, this.source, Http2.lengthWithoutPadding(i10, b4, readByte));
                this.source.skip(readByte);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }

        private void readGoAway(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            if (i10 < 8) {
                throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
            }
            if (i11 == 0) {
                int readInt = this.source.readInt();
                int readInt2 = this.source.readInt();
                int i12 = i10 - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
                if (fromHttp2 == null) {
                    throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                }
                ByteString byteString = ByteString.EMPTY;
                if (i12 > 0) {
                    byteString = this.source.readByteString(i12);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }

        private List<Header> readHeaderBlock(int i10, short s2, byte b4, int i11) throws IOException {
            ContinuationSource continuationSource = this.continuation;
            continuationSource.left = i10;
            continuationSource.length = i10;
            continuationSource.padding = s2;
            continuationSource.flags = b4;
            continuationSource.streamId = i11;
            this.hpackReader.readHeaders();
            return this.hpackReader.getAndResetHeaderList();
        }

        private void readHeaders(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            if (i11 != 0) {
                boolean z10 = (b4 & 1) != 0;
                short readByte = (b4 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
                if ((b4 & 32) != 0) {
                    readPriority(handler, i11);
                    i10 -= 5;
                }
                handler.headers(false, z10, i11, -1, readHeaderBlock(Http2.lengthWithoutPadding(i10, b4, readByte), readByte, b4, i11), HeadersMode.HTTP_20_HEADERS);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }

        private void readPing(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            if (i10 != 8) {
                throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i10));
            }
            if (i11 == 0) {
                handler.ping((b4 & 1) != 0, this.source.readInt(), this.source.readInt());
                return;
            }
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }

        private void readPriority(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            if (i10 != 5) {
                throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
            }
            if (i11 != 0) {
                readPriority(handler, i11);
                return;
            }
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }

        private void readPushPromise(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            if (i11 != 0) {
                short readByte = (b4 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
                handler.pushPromise(i11, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Http2.lengthWithoutPadding(i10 - 4, b4, readByte), readByte, b4, i11));
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }

        private void readRstStream(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            if (i10 != 4) {
                throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
            }
            if (i11 != 0) {
                int readInt = this.source.readInt();
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
                if (fromHttp2 == null) {
                    throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                }
                handler.rstStream(i11, fromHttp2);
                return;
            }
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:16:0x002e. Please report as an issue. */
        private void readSettings(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            if (i11 != 0) {
                throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b4 & 1) != 0) {
                if (i10 == 0) {
                    handler.ackSettings();
                    return;
                }
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            if (i10 % 6 != 0) {
                throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
            }
            Settings settings = new Settings();
            for (int i12 = 0; i12 < i10; i12 += 6) {
                short readShort = this.source.readShort();
                int readInt = this.source.readInt();
                switch (readShort) {
                    case 1:
                    case 6:
                        settings.set(readShort, 0, readInt);
                    case 2:
                        if (readInt != 0 && readInt != 1) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        settings.set(readShort, 0, readInt);
                    case 3:
                        readShort = 4;
                        settings.set(readShort, 0, readInt);
                    case 4:
                        readShort = 7;
                        if (readInt < 0) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        settings.set(readShort, 0, readInt);
                    case 5:
                        if (readInt < 16384 || readInt > 16777215) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                        settings.set(readShort, 0, readInt);
                        break;
                    default:
                }
            }
            handler.settings(false, settings);
            if (settings.getHeaderTableSize() >= 0) {
                this.hpackReader.headerTableSizeSetting(settings.getHeaderTableSize());
            }
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i10, byte b4, int i11) throws IOException {
            if (i10 != 4) {
                throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
            }
            long readInt = this.source.readInt() & ZipUtils.UPPER_UNIXTIME_BOUND;
            if (readInt != 0) {
                handler.windowUpdate(i11, readInt);
                return;
            }
            throw Http2.ioException("windowSizeIncrement was 0", new Object[0]);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.source.close();
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                this.source.require(9L);
                int readMedium = Http2.readMedium(this.source);
                if (readMedium < 0 || readMedium > 16384) {
                    throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
                }
                byte readByte = (byte) (this.source.readByte() & 255);
                byte readByte2 = (byte) (this.source.readByte() & 255);
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(FrameLogger.formatHeader(true, readInt, readMedium, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        readData(handler, readMedium, readByte2, readInt);
                        return true;
                    case 1:
                        readHeaders(handler, readMedium, readByte2, readInt);
                        return true;
                    case 2:
                        readPriority(handler, readMedium, readByte2, readInt);
                        return true;
                    case 3:
                        readRstStream(handler, readMedium, readByte2, readInt);
                        return true;
                    case 4:
                        readSettings(handler, readMedium, readByte2, readInt);
                        return true;
                    case 5:
                        readPushPromise(handler, readMedium, readByte2, readInt);
                        return true;
                    case 6:
                        readPing(handler, readMedium, readByte2, readInt);
                        return true;
                    case 7:
                        readGoAway(handler, readMedium, readByte2, readInt);
                        return true;
                    case 8:
                        readWindowUpdate(handler, readMedium, readByte2, readInt);
                        return true;
                    default:
                        this.source.skip(readMedium);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader
        public void readConnectionPreface() throws IOException {
            if (this.client) {
                return;
            }
            ByteString readByteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(String.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!Http2.CONNECTION_PREFACE.equals(readByteString)) {
                throw Http2.ioException("Expected a connection header but was %s", readByteString.utf8());
            }
        }

        private void readPriority(FrameReader.Handler handler, int i10) throws IOException {
            int readInt = this.source.readInt();
            handler.priority(i10, readInt & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Writer implements FrameWriter {
        private final boolean client;
        private boolean closed;
        private final Buffer hpackBuffer;
        private final Hpack.Writer hpackWriter;
        private int maxFrameSize;
        private final BufferedSink sink;

        public Writer(BufferedSink bufferedSink, boolean z10) {
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

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
        public synchronized void ackSettings(Settings settings) throws IOException {
            if (!this.closed) {
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
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

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
        public synchronized void connectionPreface() throws IOException {
            if (!this.closed) {
                if (this.client) {
                    if (Http2.logger.isLoggable(Level.FINE)) {
                        Http2.logger.fine(String.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                    }
                    this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                    this.sink.flush();
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
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

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
        public synchronized void flush() throws IOException {
            if (!this.closed) {
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public void frameHeader(int i10, int i11, byte b4, byte b10) throws IOException {
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(false, i10, i11, b4, b10));
            }
            int i12 = this.maxFrameSize;
            if (i11 > i12) {
                throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            if ((Integer.MIN_VALUE & i10) != 0) {
                throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i10));
            }
            Http2.writeMedium(this.sink, i11);
            this.sink.writeByte(b4 & 255);
            this.sink.writeByte(b10 & 255);
            this.sink.writeInt(i10 & Integer.MAX_VALUE);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
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

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
        public synchronized void headers(int i10, List<Header> list) throws IOException {
            if (!this.closed) {
                headers(false, i10, list);
            } else {
                throw new IOException("closed");
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
        public int maxDataLength() {
            return this.maxFrameSize;
        }

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
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

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
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

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
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

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
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

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
        public synchronized void synReply(boolean z10, int i10, List<Header> list) throws IOException {
            if (!this.closed) {
                headers(z10, i10, list);
            } else {
                throw new IOException("closed");
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
        public synchronized void synStream(boolean z10, boolean z11, int i10, int i11, List<Header> list) throws IOException {
            try {
                if (!z11) {
                    if (!this.closed) {
                        headers(z10, i10, list);
                    } else {
                        throw new IOException("closed");
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameWriter
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
}
