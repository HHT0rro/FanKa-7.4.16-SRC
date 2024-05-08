package okio;

import com.android.internal.midi.MidiConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.l;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.text.c;
import okhttp3.internal.connection.RealConnection;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Buffer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @Nullable
    public Segment head;
    private long size;

    /* compiled from: Buffer.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class UnsafeCursor implements Closeable {

        @Nullable
        public Buffer buffer;

        @Nullable
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1L;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long expandBuffer(int i10) {
            if (!(i10 > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i10).toString());
            }
            if (i10 <= 8192) {
                Buffer buffer = this.buffer;
                if (buffer != null) {
                    if (this.readWrite) {
                        long size = buffer.size();
                        Segment writableSegment$okio = buffer.writableSegment$okio(i10);
                        int i11 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j10 = i11;
                        buffer.setSize$okio(size + j10);
                        this.segment = writableSegment$okio;
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = 8192 - i11;
                        this.end = 8192;
                        return j10;
                    }
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i10).toString());
        }

        public final int next() {
            long j10 = this.offset;
            Buffer buffer = this.buffer;
            s.f(buffer);
            if (j10 != buffer.size()) {
                long j11 = this.offset;
                return seek(j11 == -1 ? 0L : j11 + (this.end - this.start));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long j10) {
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (this.readWrite) {
                    long size = buffer.size();
                    int i10 = 1;
                    if (j10 <= size) {
                        if (j10 >= 0) {
                            long j11 = size - j10;
                            while (true) {
                                if (j11 <= 0) {
                                    break;
                                }
                                Segment segment = buffer.head;
                                s.f(segment);
                                Segment segment2 = segment.prev;
                                s.f(segment2);
                                int i11 = segment2.limit;
                                long j12 = i11 - segment2.pos;
                                if (j12 <= j11) {
                                    buffer.head = segment2.pop();
                                    SegmentPool.recycle(segment2);
                                    j11 -= j12;
                                } else {
                                    segment2.limit = i11 - ((int) j11);
                                    break;
                                }
                            }
                            this.segment = null;
                            this.offset = j10;
                            this.data = null;
                            this.start = -1;
                            this.end = -1;
                        } else {
                            throw new IllegalArgumentException(("newSize < 0: " + j10).toString());
                        }
                    } else if (j10 > size) {
                        long j13 = j10 - size;
                        boolean z10 = true;
                        while (j13 > 0) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(i10);
                            int min = (int) Math.min(j13, 8192 - writableSegment$okio.limit);
                            int i12 = writableSegment$okio.limit + min;
                            writableSegment$okio.limit = i12;
                            j13 -= min;
                            if (z10) {
                                this.segment = writableSegment$okio;
                                this.offset = size;
                                this.data = writableSegment$okio.data;
                                this.start = i12 - min;
                                this.end = i12;
                                z10 = false;
                            }
                            i10 = 1;
                        }
                    }
                    buffer.setSize$okio(j10);
                    return size;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int seek(long j10) {
            Segment segment;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j10 < -1 || j10 > buffer.size()) {
                y yVar = y.f51038a;
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j10), Long.valueOf(buffer.size())}, 2));
                s.h(format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            }
            if (j10 != -1 && j10 != buffer.size()) {
                long j11 = 0;
                long size = buffer.size();
                Segment segment2 = buffer.head;
                Segment segment3 = this.segment;
                if (segment3 != null) {
                    long j12 = this.offset;
                    int i10 = this.start;
                    s.f(segment3);
                    long j13 = j12 - (i10 - segment3.pos);
                    if (j13 > j10) {
                        segment = segment2;
                        segment2 = this.segment;
                        size = j13;
                    } else {
                        segment = this.segment;
                        j11 = j13;
                    }
                } else {
                    segment = segment2;
                }
                if (size - j10 > j10 - j11) {
                    while (true) {
                        s.f(segment);
                        int i11 = segment.limit;
                        int i12 = segment.pos;
                        if (j10 < (i11 - i12) + j11) {
                            break;
                        }
                        j11 += i11 - i12;
                        segment = segment.next;
                    }
                } else {
                    while (size > j10) {
                        s.f(segment2);
                        segment2 = segment2.prev;
                        s.f(segment2);
                        size -= segment2.limit - segment2.pos;
                    }
                    j11 = size;
                    segment = segment2;
                }
                if (this.readWrite) {
                    s.f(segment);
                    if (segment.shared) {
                        Segment unsharedCopy = segment.unsharedCopy();
                        if (buffer.head == segment) {
                            buffer.head = unsharedCopy;
                        }
                        segment = segment.push(unsharedCopy);
                        Segment segment4 = segment.prev;
                        s.f(segment4);
                        segment4.pop();
                    }
                }
                this.segment = segment;
                this.offset = j10;
                s.f(segment);
                this.data = segment.data;
                int i13 = segment.pos + ((int) (j10 - j11));
                this.start = i13;
                int i14 = segment.limit;
                this.end = i14;
                return i14 - i13;
            }
            this.segment = null;
            this.offset = j10;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return -1;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j10, long j11, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        long j12 = j10;
        if ((i10 & 4) != 0) {
            j11 = buffer.size - j12;
        }
        return buffer.copyTo(outputStream, j12, j11);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return buffer.copyTo(buffer2, j10);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return buffer.copyTo(buffer2, j10, j11);
    }

    private final ByteString digest(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i10 = segment.pos;
            messageDigest.update(bArr, i10, segment.limit - i10);
            Segment segment2 = segment.next;
            s.f(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i11 = segment2.pos;
                messageDigest.update(bArr2, i11, segment2.limit - i11);
                segment2 = segment2.next;
                s.f(segment2);
            }
        }
        byte[] digest = messageDigest.digest();
        s.h(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i10 = segment.pos;
                mac.update(bArr, i10, segment.limit - i10);
                Segment segment2 = segment.next;
                s.f(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i11 = segment2.pos;
                    mac.update(bArr2, i11, segment2.limit - i11);
                    segment2 = segment2.next;
                    s.f(segment2);
                }
            }
            byte[] doFinal = mac.doFinal();
            s.h(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = buffer.size;
        }
        return buffer.writeTo(outputStream, j10);
    }

    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m3729deprecated_getByte(long j10) {
        return getByte(j10);
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final long m3730deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        s.f(segment);
        Segment segment2 = segment.prev;
        s.f(segment2);
        if (segment2.limit < 8192 && segment2.owner) {
            size -= r3 - segment2.pos;
        }
        return size;
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            s.f(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                s.f(segment3);
                s.f(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j10) throws IOException {
        return copyTo$default(this, outputStream, j10, 0L, 4, (Object) null);
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out, long j10, long j11) throws IOException {
        s.i(out, "out");
        Util.checkOffsetAndCount(this.size, j10, j11);
        if (j11 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            s.f(segment);
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            segment = segment.next;
        }
        while (j11 > 0) {
            s.f(segment);
            int min = (int) Math.min(segment.limit - r10, j11);
            out.write(segment.data, (int) (segment.pos + j10), min);
            j11 -= min;
            segment = segment.next;
            j10 = 0;
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (!(obj instanceof Buffer)) {
                return false;
            }
            Buffer buffer = (Buffer) obj;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() != 0) {
                Segment segment = this.head;
                s.f(segment);
                Segment segment2 = buffer.head;
                s.f(segment2);
                int i10 = segment.pos;
                int i11 = segment2.pos;
                long j10 = 0;
                while (j10 < size()) {
                    long min = Math.min(segment.limit - i10, segment2.limit - i11);
                    long j11 = 0;
                    while (j11 < min) {
                        int i12 = i10 + 1;
                        int i13 = i11 + 1;
                        if (segment.data[i10] != segment2.data[i11]) {
                            return false;
                        }
                        j11++;
                        i10 = i12;
                        i11 = i13;
                    }
                    if (i10 == segment.limit) {
                        segment = segment.next;
                        s.f(segment);
                        i10 = segment.pos;
                    }
                    if (i11 == segment2.limit) {
                        segment2 = segment2.next;
                        s.f(segment2);
                        i11 = segment2.pos;
                    }
                    j10 += min;
                }
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j10) {
        Util.checkOffsetAndCount(size(), j10, 1L);
        Segment segment = this.head;
        if (segment == null) {
            s.f(null);
            throw null;
        }
        if (size() - j10 < j10) {
            long size = size();
            while (size > j10) {
                segment = segment.prev;
                s.f(segment);
                size -= segment.limit - segment.pos;
            }
            s.f(segment);
            return segment.data[(int) ((segment.pos + j10) - size)];
        }
        long j11 = 0;
        while (true) {
            long j12 = (segment.limit - segment.pos) + j11;
            if (j12 > j10) {
                s.f(segment);
                return segment.data[(int) ((segment.pos + j10) - j11)];
            }
            segment = segment.next;
            s.f(segment);
            j11 = j12;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = segment.limit;
            for (int i12 = segment.pos; i12 < i11; i12++) {
                i10 = (i10 * 31) + segment.data[i12];
            }
            segment = segment.next;
            s.f(segment);
        } while (segment != this.head);
        return i10;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString key) {
        s.i(key, "key");
        return hmac("HmacSHA1", key);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString key) {
        s.i(key, "key");
        return hmac("HmacSHA256", key);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString key) {
        s.i(key, "key");
        return hmac("HmacSHA512", key);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b4) {
        return indexOf(b4, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes) {
        s.i(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @NotNull
            public String toString() {
                return ((Object) Buffer.this) + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(@NotNull byte[] sink, int i10, int i11) {
                s.i(sink, "sink");
                return Buffer.this.read(sink, i10, i11);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer$outputStream$1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @NotNull
            public String toString() {
                return ((Object) Buffer.this) + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i10) {
                Buffer.this.writeByte(i10);
            }

            @Override // java.io.OutputStream
            public void write(@NotNull byte[] data, int i10, int i11) {
                s.i(data, "data");
                Buffer.this.write(data, i10, i11);
            }
        };
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j10, @NotNull ByteString bytes) {
        s.i(bytes, "bytes");
        return rangeEquals(j10, bytes, 0, bytes.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) throws IOException {
        s.i(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, min);
        int i10 = segment.pos + min;
        segment.pos = i10;
        this.size -= min;
        if (i10 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) throws IOException {
        s.i(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        s.i(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            s.f(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            int i12 = i10 + 1;
            byte b4 = segment.data[i10];
            setSize$okio(size() - 1);
            if (i12 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i12;
            }
            return b4;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c2 A[EDGE_INSN: B:48:0x00c2->B:42:0x00c2 BREAK  A[LOOP:0: B:4:0x0011->B:47:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b8  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input) throws IOException {
        s.i(input, "input");
        readFrom(input, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer sink, long j10) throws EOFException {
        s.i(sink, "sink");
        if (size() >= j10) {
            sink.write(this, j10);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae A[EDGE_INSN: B:39:0x00ae->B:36:0x00ae BREAK  A[LOOP:0: B:4:0x000d->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb8
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.s.f(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L18:
            if (r8 >= r9) goto L9a
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.Util.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9a:
            if (r8 != r9) goto La6
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto La8
        La6:
            r6.pos = r8
        La8:
            if (r1 != 0) goto Lae
            okio.Segment r6 = r15.head
            if (r6 != 0) goto Ld
        Lae:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lb8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            s.f(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
            int i15 = i13 + 1;
            int i16 = i14 | ((bArr[i13] & 255) << 8);
            int i17 = i15 + 1;
            int i18 = i16 | (bArr[i15] & 255);
            setSize$okio(size() - 4);
            if (i17 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i17;
            }
            return i18;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            s.f(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = segment.data;
            long j10 = (bArr[i10] & 255) << 56;
            long j11 = j10 | ((bArr[r6] & 255) << 48);
            long j12 = j11 | ((bArr[r1] & 255) << 40);
            int i12 = i10 + 1 + 1 + 1 + 1;
            long j13 = ((bArr[r6] & 255) << 32) | j12;
            long j14 = j13 | ((bArr[i12] & 255) << 24);
            long j15 = j14 | ((bArr[r8] & 255) << 16);
            long j16 = j15 | ((bArr[r1] & 255) << 8);
            int i13 = i12 + 1 + 1 + 1 + 1;
            long j17 = j16 | (bArr[r8] & 255);
            setSize$okio(size() - 8);
            if (i13 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return j17;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            s.f(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
            setSize$okio(size() - 2);
            if (i13 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return (short) i14;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        s.i(charset, "charset");
        return readString(this.size, charset);
    }

    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        s.i(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        return readString(this.size, c.f51097b);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (size() != 0) {
            byte b4 = getByte(0L);
            if ((b4 & 128) == 0) {
                i10 = b4 & Byte.MAX_VALUE;
                i11 = 1;
                i12 = 0;
            } else if ((b4 & MidiConstants.STATUS_PITCH_BEND) == 192) {
                i10 = b4 & 31;
                i11 = 2;
                i12 = 128;
            } else if ((b4 & 240) == 224) {
                i10 = b4 & 15;
                i11 = 3;
                i12 = 2048;
            } else {
                if ((b4 & 248) != 240) {
                    skip(1L);
                    return 65533;
                }
                i10 = b4 & 7;
                i11 = 4;
                i12 = 65536;
            }
            long j10 = i11;
            if (size() >= j10) {
                for (int i13 = 1; i13 < i11; i13++) {
                    long j11 = i13;
                    byte b10 = getByte(j11);
                    if ((b10 & 192) != 128) {
                        skip(j11);
                        return 65533;
                    }
                    i10 = (i10 << 6) | (b10 & Utf8.REPLACEMENT_BYTE);
                }
                skip(j10);
                if (i10 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i10 && 57343 >= i10) || i10 < i12) {
                    return 65533;
                }
                return i10;
            }
            throw new EOFException("size < " + i11 + ": " + size() + " (to read code point prefixed 0x" + Util.toHexString(b4) + ')');
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j10) {
        return this.size >= j10;
    }

    @Override // okio.BufferedSource
    public void require(long j10) throws EOFException {
        if (this.size < j10) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) {
        s.i(options, "options");
        int selectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j10) {
        this.size = j10;
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j10, segment.limit - segment.pos);
                long j11 = min;
                setSize$okio(size() - j11);
                j10 -= j11;
                int i10 = segment.pos + min;
                segment.pos = i10;
                if (i10 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int i10) {
        if (i10 >= 1 && i10 <= 8192) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            s.f(segment);
            Segment segment2 = segment.prev;
            s.f(segment2);
            return (segment2.limit + i10 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) throws IOException {
        s.i(source, "source");
        long j10 = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    @NotNull
    public final Buffer writeTo(@NotNull OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    @NotNull
    public final Buffer writeTo(@NotNull OutputStream out, long j10) throws IOException {
        s.i(out, "out");
        Util.checkOffsetAndCount(this.size, 0L, j10);
        Segment segment = this.head;
        while (j10 > 0) {
            s.f(segment);
            int min = (int) Math.min(j10, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, min);
            int i10 = segment.pos + min;
            segment.pos = i10;
            long j11 = min;
            this.size -= j11;
            j10 -= j11;
            if (i10 == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    @NotNull
    public Buffer clone() {
        return copy();
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b4, long j10) {
        return indexOf(b4, j10, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes, long j10) {
        int i10;
        int i11;
        s.i(targetBytes, "targetBytes");
        long j11 = 0;
        if (j10 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1L;
            }
            if (size() - j10 < j10) {
                j11 = size();
                while (j11 > j10) {
                    segment = segment.prev;
                    s.f(segment);
                    j11 -= segment.limit - segment.pos;
                }
                if (targetBytes.size() == 2) {
                    byte b4 = targetBytes.getByte(0);
                    byte b10 = targetBytes.getByte(1);
                    while (j11 < size()) {
                        byte[] bArr = segment.data;
                        i10 = (int) ((segment.pos + j10) - j11);
                        int i12 = segment.limit;
                        while (i10 < i12) {
                            byte b11 = bArr[i10];
                            if (b11 != b4 && b11 != b10) {
                                i10++;
                            }
                            i11 = segment.pos;
                        }
                        j11 += segment.limit - segment.pos;
                        segment = segment.next;
                        s.f(segment);
                        j10 = j11;
                    }
                    return -1L;
                }
                byte[] internalArray$okio = targetBytes.internalArray$okio();
                while (j11 < size()) {
                    byte[] bArr2 = segment.data;
                    i10 = (int) ((segment.pos + j10) - j11);
                    int i13 = segment.limit;
                    while (i10 < i13) {
                        byte b12 = bArr2[i10];
                        for (byte b13 : internalArray$okio) {
                            if (b12 == b13) {
                                i11 = segment.pos;
                            }
                        }
                        i10++;
                    }
                    j11 += segment.limit - segment.pos;
                    segment = segment.next;
                    s.f(segment);
                    j10 = j11;
                }
                return -1L;
            }
            while (true) {
                long j12 = (segment.limit - segment.pos) + j11;
                if (j12 > j10) {
                    break;
                }
                segment = segment.next;
                s.f(segment);
                j11 = j12;
            }
            if (targetBytes.size() == 2) {
                byte b14 = targetBytes.getByte(0);
                byte b15 = targetBytes.getByte(1);
                while (j11 < size()) {
                    byte[] bArr3 = segment.data;
                    i10 = (int) ((segment.pos + j10) - j11);
                    int i14 = segment.limit;
                    while (i10 < i14) {
                        byte b16 = bArr3[i10];
                        if (b16 != b14 && b16 != b15) {
                            i10++;
                        }
                        i11 = segment.pos;
                    }
                    j11 += segment.limit - segment.pos;
                    segment = segment.next;
                    s.f(segment);
                    j10 = j11;
                }
                return -1L;
            }
            byte[] internalArray$okio2 = targetBytes.internalArray$okio();
            while (j11 < size()) {
                byte[] bArr4 = segment.data;
                i10 = (int) ((segment.pos + j10) - j11);
                int i15 = segment.limit;
                while (i10 < i15) {
                    byte b17 = bArr4[i10];
                    for (byte b18 : internalArray$okio2) {
                        if (b17 == b18) {
                            i11 = segment.pos;
                        }
                    }
                    i10++;
                }
                j11 += segment.limit - segment.pos;
                segment = segment.next;
                s.f(segment);
                j10 = j11;
            }
            return -1L;
            return (i10 - i11) + j11;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j10).toString());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j10, @NotNull ByteString bytes, int i10, int i11) {
        s.i(bytes, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || size() - j10 < i11 || bytes.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (getByte(i12 + j10) != bytes.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (size() >= j10) {
            byte[] bArr = new byte[(int) j10];
            readFully(bArr);
            return bArr;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        if (j10 >= 4096) {
            ByteString snapshot = snapshot((int) j10);
            skip(j10);
            return snapshot;
        }
        return new ByteString(readByteArray(j10));
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input, long j10) throws IOException {
        s.i(input, "input");
        if (j10 >= 0) {
            readFrom(input, j10, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long j10, @NotNull Charset charset) throws EOFException {
        s.i(charset, "charset");
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (this.size < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        Segment segment = this.head;
        s.f(segment);
        int i10 = segment.pos;
        if (i10 + j10 > segment.limit) {
            return new String(readByteArray(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(segment.data, i10, i11, charset);
        int i12 = segment.pos + i11;
        segment.pos = i12;
        this.size -= j10;
        if (i12 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long j10) throws EOFException {
        return readString(j10, c.f51097b);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long j10) throws EOFException {
        if (j10 >= 0) {
            long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
            byte b4 = (byte) 10;
            long indexOf = indexOf(b4, 0L, j11);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(this, indexOf);
            }
            if (j11 < size() && getByte(j11 - 1) == ((byte) 13) && getByte(j11) == b4) {
                return BufferKt.readUtf8Line(this, j11);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0L, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeByte(int i10) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        writableSegment$okio.limit = i11 + 1;
        bArr[i11] = (byte) i10;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeDecimalLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        boolean z10 = false;
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z10 = true;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        Segment writableSegment$okio = writableSegment$okio(i10);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i11 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i10;
        setSize$okio(size() + i10);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = writableSegment$okio(i10);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        writableSegment$okio.limit += i10;
        setSize$okio(size() + i10);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeInt(int i10) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        writableSegment$okio.limit = i14 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeIntLe(int i10) {
        return writeInt(Util.reverseBytes(i10));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLong(long j10) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i10 = writableSegment$okio.limit;
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j10 >>> 48) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j10 >>> 40) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((j10 >>> 32) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((j10 >>> 24) & 255);
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((j10 >>> 16) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((j10 >>> 8) & 255);
        bArr[i17] = (byte) (j10 & 255);
        writableSegment$okio.limit = i17 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLongLe(long j10) {
        return writeLong(Util.reverseBytes(j10));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShort(int i10) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        writableSegment$okio.limit = i12 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShortLe(int i10) {
        return writeShort((int) Util.reverseBytes((short) i10));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8CodePoint(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i11 = writableSegment$okio.limit;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            writableSegment$okio.limit = i11 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i10 && 57343 >= i10) {
            writeByte(63);
        } else if (i10 < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i12 = writableSegment$okio2.limit;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            writableSegment$okio2.limit = i12 + 3;
            setSize$okio(size() + 3);
        } else if (i10 <= 1114111) {
            Segment writableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i13 = writableSegment$okio3.limit;
            bArr3[i13] = (byte) ((i10 >> 18) | 240);
            bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
            bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
            bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
            writableSegment$okio3.limit = i13 + 4;
            setSize$okio(size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i10));
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes) throws IOException {
        s.i(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, @NotNull Charset charset) {
        s.i(string, "string");
        s.i(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string) {
        s.i(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    private final void readFrom(InputStream inputStream, long j10, boolean z10) throws IOException {
        while (true) {
            if (j10 <= 0 && !z10) {
                return;
            }
            Segment writableSegment$okio = writableSegment$okio(1);
            int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j10, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (!z10) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment$okio.limit += read;
            long j11 = read;
            this.size += j11;
            j10 -= j11;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b4, long j10, long j11) {
        Segment segment;
        int i10;
        long j12 = 0;
        if (!(0 <= j10 && j11 >= j10)) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        if (j11 > size()) {
            j11 = size();
        }
        if (j10 == j11 || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - j10 < j10) {
            j12 = size();
            while (j12 > j10) {
                segment = segment.prev;
                s.f(segment);
                j12 -= segment.limit - segment.pos;
            }
            while (j12 < j11) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j11) - j12);
                i10 = (int) ((segment.pos + j10) - j12);
                while (i10 < min) {
                    if (bArr[i10] != b4) {
                        i10++;
                    }
                }
                j12 += segment.limit - segment.pos;
                segment = segment.next;
                s.f(segment);
                j10 = j12;
            }
            return -1L;
        }
        while (true) {
            long j13 = (segment.limit - segment.pos) + j12;
            if (j13 > j10) {
                break;
            }
            segment = segment.next;
            s.f(segment);
            j12 = j13;
        }
        while (j12 < j11) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j11) - j12);
            i10 = (int) ((segment.pos + j10) - j12);
            while (i10 < min2) {
                if (bArr2[i10] != b4) {
                    i10++;
                }
            }
            j12 += segment.limit - segment.pos;
            segment = segment.next;
            s.f(segment);
            j10 = j12;
        }
        return -1L;
        return (i10 - segment.pos) + j12;
    }

    @NotNull
    public final ByteString snapshot(int i10) {
        if (i10 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0L, i10);
        Segment segment = this.head;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            s.f(segment);
            int i14 = segment.limit;
            int i15 = segment.pos;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                segment = segment.next;
            } else {
                throw new AssertionError((Object) "s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i13];
        int[] iArr = new int[i13 * 2];
        Segment segment2 = this.head;
        int i16 = 0;
        while (i11 < i10) {
            s.f(segment2);
            bArr[i16] = segment2.data;
            i11 += segment2.limit - segment2.pos;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = segment2.pos;
            segment2.shared = true;
            i16++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, int i10, int i11, @NotNull Charset charset) {
        s.i(string, "string");
        s.i(charset, "charset");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (i11 >= i10) {
            if (i11 <= string.length()) {
                if (s.d(charset, c.f51097b)) {
                    return writeUtf8(string, i10, i11);
                }
                String substring = string.substring(i10, i11);
                s.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                byte[] bytes = substring.getBytes(charset);
                s.h(bytes, "(this as java.lang.String).getBytes(charset)");
                return write(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string, int i10, int i11) {
        s.i(string, "string");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (i11 >= i10) {
            if (!(i11 <= string.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
            }
            while (i10 < i11) {
                char charAt = string.charAt(i10);
                if (charAt < 128) {
                    Segment writableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = writableSegment$okio.data;
                    int i12 = writableSegment$okio.limit - i10;
                    int min = Math.min(i11, 8192 - i12);
                    int i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) charAt;
                    while (i13 < min) {
                        char charAt2 = string.charAt(i13);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i13 + i12] = (byte) charAt2;
                        i13++;
                    }
                    int i14 = writableSegment$okio.limit;
                    int i15 = (i12 + i13) - i14;
                    writableSegment$okio.limit = i14 + i15;
                    setSize$okio(size() + i15);
                    i10 = i13;
                } else {
                    if (charAt < 2048) {
                        Segment writableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = writableSegment$okio2.data;
                        int i16 = writableSegment$okio2.limit;
                        bArr2[i16] = (byte) ((charAt >> 6) | 192);
                        bArr2[i16 + 1] = (byte) ((charAt & '?') | 128);
                        writableSegment$okio2.limit = i16 + 2;
                        setSize$okio(size() + 2);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i17 = i10 + 1;
                        char charAt3 = i17 < i11 ? string.charAt(i17) : (char) 0;
                        if (charAt <= 56319 && 56320 <= charAt3 && 57343 >= charAt3) {
                            int i18 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            Segment writableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = writableSegment$okio3.data;
                            int i19 = writableSegment$okio3.limit;
                            bArr3[i19] = (byte) ((i18 >> 18) | 240);
                            bArr3[i19 + 1] = (byte) (((i18 >> 12) & 63) | 128);
                            bArr3[i19 + 2] = (byte) (((i18 >> 6) & 63) | 128);
                            bArr3[i19 + 3] = (byte) ((i18 & 63) | 128);
                            writableSegment$okio3.limit = i19 + 4;
                            setSize$okio(size() + 4);
                            i10 += 2;
                        } else {
                            writeByte(63);
                            i10 = i17;
                        }
                    } else {
                        Segment writableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i20 = writableSegment$okio4.limit;
                        bArr4[i20] = (byte) ((charAt >> '\f') | 224);
                        bArr4[i20 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                        bArr4[i20 + 2] = (byte) ((charAt & '?') | 128);
                        writableSegment$okio4.limit = i20 + 3;
                        setSize$okio(size() + 3);
                    }
                    i10++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] sink) throws EOFException {
        s.i(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int read = read(sink, i10, sink.length - i10);
            if (read == -1) {
                throw new EOFException();
            }
            i10 += read;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) throws IOException {
        s.i(source, "source");
        int remaining = source.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i10, 8192 - writableSegment$okio.limit);
            source.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i10 -= min;
            writableSegment$okio.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink) {
        s.i(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long j10) {
        s.i(out, "out");
        return copyTo(out, j10, this.size - j10);
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink, int i10, int i11) {
        s.i(sink, "sink");
        Util.checkOffsetAndCount(sink.length, i10, i11);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i11, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i12 = segment.pos;
        l.e(bArr, sink, i10, i12, i12 + min);
        segment.pos += min;
        setSize$okio(size() - min);
        if (segment.pos != segment.limit) {
            return min;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return min;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long j10, long j11) {
        s.i(out, "out");
        Util.checkOffsetAndCount(size(), j10, j11);
        if (j11 != 0) {
            out.setSize$okio(out.size() + j11);
            Segment segment = this.head;
            while (true) {
                s.f(segment);
                int i10 = segment.limit;
                int i11 = segment.pos;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= i10 - i11;
                segment = segment.next;
            }
            while (j11 > 0) {
                s.f(segment);
                Segment sharedCopy = segment.sharedCopy();
                int i12 = sharedCopy.pos + ((int) j10);
                sharedCopy.pos = i12;
                sharedCopy.limit = Math.min(i12 + ((int) j11), sharedCopy.limit);
                Segment segment2 = out.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    out.head = sharedCopy;
                } else {
                    s.f(segment2);
                    Segment segment3 = segment2.prev;
                    s.f(segment3);
                    segment3.push(sharedCopy);
                }
                j11 -= sharedCopy.limit - sharedCopy.pos;
                segment = segment.next;
                j10 = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        s.i(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString, int i10, int i11) {
        s.i(byteString, "byteString");
        byteString.write$okio(this, i10, i11);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source) {
        s.i(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source, int i10, int i11) {
        s.i(source, "source");
        long j10 = i11;
        Util.checkOffsetAndCount(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i12 - i10, 8192 - writableSegment$okio.limit);
            int i13 = i10 + min;
            l.e(source, writableSegment$okio.data, writableSegment$okio.limit, i10, i13);
            writableSegment$okio.limit += min;
            i10 = i13;
        }
        setSize$okio(size() + j10);
        return this;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j10) {
        s.i(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j10 > size()) {
            j10 = size();
        }
        sink.write(this, j10);
        return j10;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull Source source, long j10) throws IOException {
        s.i(source, "source");
        while (j10 > 0) {
            long read = source.read(this, j10);
            if (read == -1) {
                throw new EOFException();
            }
            j10 -= read;
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long j10) throws IOException {
        long j11 = j10;
        s.i(bytes, "bytes");
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j12 = 0;
        if (j11 >= 0) {
            Segment segment = this.head;
            if (segment != null) {
                if (size() - j11 < j11) {
                    long size = size();
                    while (size > j11) {
                        segment = segment.prev;
                        s.f(segment);
                        size -= segment.limit - segment.pos;
                    }
                    byte[] internalArray$okio = bytes.internalArray$okio();
                    byte b4 = internalArray$okio[0];
                    int size2 = bytes.size();
                    long size3 = (size() - size2) + 1;
                    while (size < size3) {
                        byte[] bArr = segment.data;
                        long j13 = size;
                        int min = (int) Math.min(segment.limit, (segment.pos + size3) - size);
                        for (int i10 = (int) ((segment.pos + j11) - j13); i10 < min; i10++) {
                            if (bArr[i10] == b4 && BufferKt.rangeEquals(segment, i10 + 1, internalArray$okio, 1, size2)) {
                                return (i10 - segment.pos) + j13;
                            }
                        }
                        size = j13 + (segment.limit - segment.pos);
                        segment = segment.next;
                        s.f(segment);
                        j11 = size;
                    }
                } else {
                    while (true) {
                        long j14 = (segment.limit - segment.pos) + j12;
                        if (j14 > j11) {
                            break;
                        }
                        segment = segment.next;
                        s.f(segment);
                        j12 = j14;
                    }
                    byte[] internalArray$okio2 = bytes.internalArray$okio();
                    byte b10 = internalArray$okio2[0];
                    int size4 = bytes.size();
                    long size5 = (size() - size4) + 1;
                    while (j12 < size5) {
                        byte[] bArr2 = segment.data;
                        long j15 = size5;
                        int min2 = (int) Math.min(segment.limit, (segment.pos + size5) - j12);
                        for (int i11 = (int) ((segment.pos + j11) - j12); i11 < min2; i11++) {
                            if (bArr2[i11] == b10 && BufferKt.rangeEquals(segment, i11 + 1, internalArray$okio2, 1, size4)) {
                                return (i11 - segment.pos) + j12;
                            }
                        }
                        j12 += segment.limit - segment.pos;
                        segment = segment.next;
                        s.f(segment);
                        j11 = j12;
                        size5 = j15;
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j10) {
        Segment segment;
        s.i(source, "source");
        if (source != this) {
            Util.checkOffsetAndCount(source.size(), 0L, j10);
            while (j10 > 0) {
                Segment segment2 = source.head;
                s.f(segment2);
                int i10 = segment2.limit;
                s.f(source.head);
                if (j10 < i10 - r2.pos) {
                    Segment segment3 = this.head;
                    if (segment3 != null) {
                        s.f(segment3);
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j10) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = source.head;
                            s.f(segment4);
                            segment4.writeTo(segment, (int) j10);
                            source.setSize$okio(source.size() - j10);
                            setSize$okio(size() + j10);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    s.f(segment5);
                    source.head = segment5.split((int) j10);
                }
                Segment segment6 = source.head;
                s.f(segment6);
                long j11 = segment6.limit - segment6.pos;
                source.head = segment6.pop();
                Segment segment7 = this.head;
                if (segment7 == null) {
                    this.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    s.f(segment7);
                    Segment segment8 = segment7.prev;
                    s.f(segment8);
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j11);
                setSize$okio(size() + j11);
                j10 -= j11;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}
