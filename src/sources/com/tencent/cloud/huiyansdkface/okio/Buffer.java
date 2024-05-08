package com.tencent.cloud.huiyansdkface.okio;

import android.support.v4.media.session.PlaybackStateCompat;
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
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipUtils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.connection.RealConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Buffer implements BufferedSink, BufferedSource, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public static final int REPLACEMENT_CHARACTER = 65533;
    public Segment head;
    public long size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i10);
            }
            if (i10 > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i10);
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j10 = buffer.size;
            Segment writableSegment = buffer.writableSegment(i10);
            int i11 = 8192 - writableSegment.limit;
            writableSegment.limit = 8192;
            long j11 = i11;
            this.buffer.size = j10 + j11;
            this.segment = writableSegment;
            this.offset = j10;
            this.data = writableSegment.data;
            this.start = 8192 - i11;
            this.end = 8192;
            return j11;
        }

        public final int next() {
            long j10 = this.offset;
            if (j10 != this.buffer.size) {
                return seek(j10 == -1 ? 0L : j10 + (this.end - this.start));
            }
            throw new IllegalStateException();
        }

        public final long resizeBuffer(long j10) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j11 = buffer.size;
            if (j10 <= j11) {
                if (j10 < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j10);
                }
                long j12 = j11 - j10;
                while (true) {
                    if (j12 <= 0) {
                        break;
                    }
                    Buffer buffer2 = this.buffer;
                    Segment segment = buffer2.head.prev;
                    int i10 = segment.limit;
                    long j13 = i10 - segment.pos;
                    if (j13 > j12) {
                        segment.limit = (int) (i10 - j12);
                        break;
                    }
                    buffer2.head = segment.pop();
                    SegmentPool.recycle(segment);
                    j12 -= j13;
                }
                this.segment = null;
                this.offset = j10;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j10 > j11) {
                long j14 = j10 - j11;
                boolean z10 = true;
                while (j14 > 0) {
                    Segment writableSegment = this.buffer.writableSegment(1);
                    int min = (int) Math.min(j14, 8192 - writableSegment.limit);
                    int i11 = writableSegment.limit + min;
                    writableSegment.limit = i11;
                    j14 -= min;
                    if (z10) {
                        this.segment = writableSegment;
                        this.offset = j11;
                        this.data = writableSegment.data;
                        this.start = i11 - min;
                        this.end = i11;
                        z10 = false;
                    }
                }
            }
            this.buffer.size = j10;
            return j11;
        }

        public final int seek(long j10) {
            if (j10 >= -1) {
                Buffer buffer = this.buffer;
                long j11 = buffer.size;
                if (j10 <= j11) {
                    if (j10 == -1 || j10 == j11) {
                        this.segment = null;
                        this.offset = j10;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    long j12 = 0;
                    Segment segment = buffer.head;
                    Segment segment2 = this.segment;
                    if (segment2 != null) {
                        long j13 = this.offset - (this.start - segment2.pos);
                        if (j13 > j10) {
                            j11 = j13;
                            segment2 = segment;
                            segment = segment2;
                        } else {
                            j12 = j13;
                        }
                    } else {
                        segment2 = segment;
                    }
                    if (j11 - j10 > j10 - j12) {
                        while (true) {
                            int i10 = segment2.limit;
                            int i11 = segment2.pos;
                            if (j10 < (i10 - i11) + j12) {
                                break;
                            }
                            j12 += i10 - i11;
                            segment2 = segment2.next;
                        }
                    } else {
                        while (j11 > j10) {
                            segment = segment.prev;
                            j11 -= segment.limit - segment.pos;
                        }
                        segment2 = segment;
                        j12 = j11;
                    }
                    if (this.readWrite && segment2.shared) {
                        Segment unsharedCopy = segment2.unsharedCopy();
                        Buffer buffer2 = this.buffer;
                        if (buffer2.head == segment2) {
                            buffer2.head = unsharedCopy;
                        }
                        segment2 = segment2.push(unsharedCopy);
                        segment2.prev.pop();
                    }
                    this.segment = segment2;
                    this.offset = j10;
                    this.data = segment2.data;
                    int i12 = segment2.pos + ((int) (j10 - j12));
                    this.start = i12;
                    int i13 = segment2.limit;
                    this.end = i13;
                    return i13 - i12;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j10), Long.valueOf(this.buffer.size)));
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i10 = segment.pos;
                messageDigest.update(bArr, i10, segment.limit - i10);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i11 = segment2.pos;
                    messageDigest.update(bArr2, i11, segment2.limit - i11);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i10 = segment.pos;
                mac.update(bArr, i10, segment.limit - i10);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i11 = segment2.pos;
                    mac.update(bArr2, i11, segment2.limit - i11);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private boolean rangeEquals(Segment segment, int i10, ByteString byteString, int i11, int i12) {
        int i13 = segment.limit;
        byte[] bArr = segment.data;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i10 = segment.pos;
                i13 = segment.limit;
            }
            if (bArr[i10] != byteString.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    private void readFrom(InputStream inputStream, long j10, boolean z10) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j10 <= 0 && !z10) {
                return;
            }
            Segment writableSegment = writableSegment(1);
            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j10, 8192 - writableSegment.limit));
            if (read == -1) {
                if (!z10) {
                    throw new EOFException();
                }
                return;
            } else {
                writableSegment.limit += read;
                long j11 = read;
                this.size += j11;
                j10 -= j11;
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink, com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Buffer m2929clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                buffer.size = this.size;
                return buffer;
            }
            buffer.head.prev.push(segment.sharedCopy());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j10 = this.size;
        if (j10 == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        return (segment.limit >= 8192 || !segment.owner) ? j10 : j10 - (r3 - segment.pos);
    }

    public final Buffer copyTo(Buffer buffer, long j10, long j11) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j10, j11);
        if (j11 == 0) {
            return this;
        }
        buffer.size += j11;
        Segment segment = this.head;
        while (true) {
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            segment = segment.next;
        }
        while (j11 > 0) {
            Segment sharedCopy = segment.sharedCopy();
            int i12 = (int) (sharedCopy.pos + j10);
            sharedCopy.pos = i12;
            sharedCopy.limit = Math.min(i12 + ((int) j11), sharedCopy.limit);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer.head = sharedCopy;
            } else {
                segment2.prev.push(sharedCopy);
            }
            j11 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j10 = 0;
        }
        return this;
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    public final Buffer copyTo(OutputStream outputStream, long j10, long j11) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j10, j11);
        if (j11 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            segment = segment.next;
        }
        while (j11 > 0) {
            int min = (int) Math.min(segment.limit - r10, j11);
            outputStream.write(segment.data, (int) (segment.pos + j10), min);
            j11 -= min;
            segment = segment.next;
            j10 = 0;
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j10 = this.size;
        if (j10 != buffer.size) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i10 = segment.pos;
        int i11 = segment2.pos;
        while (j11 < this.size) {
            long min = Math.min(segment.limit - i10, segment2.limit - i11);
            int i12 = 0;
            while (i12 < min) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (segment.data[i10] != segment2.data[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == segment.limit) {
                segment = segment.next;
                i10 = segment.pos;
            }
            if (i11 == segment2.limit) {
                segment2 = segment2.next;
                i11 = segment2.pos;
            }
            j11 += min;
        }
        return true;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
    public void flush() {
    }

    public final byte getByte(long j10) {
        int i10;
        Util.checkOffsetAndCount(this.size, j10, 1L);
        long j11 = this.size;
        if (j11 - j10 <= j10) {
            long j12 = j10 - j11;
            Segment segment = this.head;
            do {
                segment = segment.prev;
                int i11 = segment.limit;
                i10 = segment.pos;
                j12 += i11 - i10;
            } while (j12 < 0);
            return segment.data[i10 + ((int) j12)];
        }
        Segment segment2 = this.head;
        while (true) {
            int i12 = segment2.limit;
            int i13 = segment2.pos;
            long j13 = i12 - i13;
            if (j10 < j13) {
                return segment2.data[i13 + ((int) j10)];
            }
            j10 -= j13;
            segment2 = segment2.next;
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
        } while (segment != this.head);
        return i10;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(byte b4) {
        return indexOf(b4, 0L, Long.MAX_VALUE);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(byte b4, long j10) {
        return indexOf(b4, j10, Long.MAX_VALUE);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(byte b4, long j10, long j11) {
        Segment segment;
        long j12 = 0;
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j10), Long.valueOf(j11)));
        }
        long j13 = this.size;
        long j14 = j11 > j13 ? j13 : j11;
        if (j10 == j14 || (segment = this.head) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                segment = segment.prev;
                j13 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j15 = (segment.limit - segment.pos) + j12;
                if (j15 >= j10) {
                    break;
                }
                segment = segment.next;
                j12 = j15;
            }
            j13 = j12;
        }
        long j16 = j10;
        while (j13 < j14) {
            byte[] bArr = segment.data;
            int min = (int) Math.min(segment.limit, (segment.pos + j14) - j13);
            for (int i10 = (int) ((segment.pos + j16) - j13); i10 < min; i10++) {
                if (bArr[i10] == b4) {
                    return (i10 - segment.pos) + j13;
                }
            }
            j13 += segment.limit - segment.pos;
            segment = segment.next;
            j16 = j13;
        }
        return -1L;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(ByteString byteString, long j10) throws IOException {
        byte[] bArr;
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        long j12 = -1;
        if (segment == null) {
            return -1L;
        }
        long j13 = this.size;
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                segment = segment.prev;
                j13 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j14 = (segment.limit - segment.pos) + j11;
                if (j14 >= j10) {
                    break;
                }
                segment = segment.next;
                j11 = j14;
            }
            j13 = j11;
        }
        byte b4 = byteString.getByte(0);
        int size = byteString.size();
        long j15 = 1 + (this.size - size);
        long j16 = j10;
        Segment segment2 = segment;
        long j17 = j13;
        while (j17 < j15) {
            byte[] bArr2 = segment2.data;
            int min = (int) Math.min(segment2.limit, (segment2.pos + j15) - j17);
            int i10 = (int) ((segment2.pos + j16) - j17);
            while (i10 < min) {
                if (bArr2[i10] == b4) {
                    bArr = bArr2;
                    if (rangeEquals(segment2, i10 + 1, byteString, 1, size)) {
                        return (i10 - segment2.pos) + j17;
                    }
                } else {
                    bArr = bArr2;
                }
                i10++;
                bArr2 = bArr;
            }
            j17 += segment2.limit - segment2.pos;
            segment2 = segment2.next;
            j16 = j17;
            j12 = -1;
        }
        return j12;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j10) {
        int i10;
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j12 = this.size;
        if (j12 - j10 < j10) {
            while (j12 > j10) {
                segment = segment.prev;
                j12 -= segment.limit - segment.pos;
            }
        } else {
            while (true) {
                long j13 = (segment.limit - segment.pos) + j11;
                if (j13 >= j10) {
                    break;
                }
                segment = segment.next;
                j11 = j13;
            }
            j12 = j11;
        }
        if (byteString.size() == 2) {
            byte b4 = byteString.getByte(0);
            byte b10 = byteString.getByte(1);
            while (j12 < this.size) {
                byte[] bArr = segment.data;
                i10 = (int) ((segment.pos + j10) - j12);
                int i11 = segment.limit;
                while (i10 < i11) {
                    byte b11 = bArr[i10];
                    if (b11 != b4 && b11 != b10) {
                        i10++;
                    }
                    return (i10 - segment.pos) + j12;
                }
                j12 += segment.limit - segment.pos;
                segment = segment.next;
                j10 = j12;
            }
            return -1L;
        }
        byte[] internalArray = byteString.internalArray();
        while (j12 < this.size) {
            byte[] bArr2 = segment.data;
            i10 = (int) ((segment.pos + j10) - j12);
            int i12 = segment.limit;
            while (i10 < i12) {
                byte b12 = bArr2[i10];
                for (byte b13 : internalArray) {
                    if (b12 == b13) {
                        return (i10 - segment.pos) + j12;
                    }
                }
                i10++;
            }
            j12 += segment.limit - segment.pos;
            segment = segment.next;
            j10 = j12;
        }
        return -1L;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.tencent.cloud.huiyansdkface.okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, ZipUtils.UPPER_UNIXTIME_BOUND);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) {
                return Buffer.this.read(bArr, i10, i11);
            }

            public String toString() {
                return ((Object) Buffer.this) + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.tencent.cloud.huiyansdkface.okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return ((Object) Buffer.this) + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i10) {
                Buffer.this.writeByte((int) ((byte) i10));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                Buffer.this.write(bArr, i10, i11);
            }
        };
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean rangeEquals(long j10, ByteString byteString) {
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        if (j10 < 0 || i10 < 0 || i11 < 0 || this.size - j10 < i11 || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (getByte(i12 + j10) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i10 = segment.pos + min;
        segment.pos = i10;
        this.size -= min;
        if (i10 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int read(byte[] bArr, int i10, int i11) {
        Util.checkOffsetAndCount(bArr.length, i10, i11);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i11, segment.limit - segment.pos);
        System.arraycopy((Object) segment.data, segment.pos, (Object) bArr, i10, min);
        int i12 = segment.pos + min;
        segment.pos = i12;
        this.size -= min;
        if (i12 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Source
    public long read(Buffer buffer, long j10) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        long j11 = this.size;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        buffer.write(this, j10);
        return j10;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j10 = this.size;
        if (j10 > 0) {
            sink.write(this, j10);
        }
        return j10;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte readByte() {
        long j10 = this.size;
        if (j10 == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        int i11 = segment.limit;
        int i12 = i10 + 1;
        byte b4 = segment.data[i10];
        this.size = j10 - 1;
        if (i12 == i11) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i12;
        }
        return b4;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte[] readByteArray(long j10) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j10);
        if (j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            byte[] bArr = new byte[(int) j10];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public ByteString readByteString(long j10) throws EOFException {
        return new ByteString(readByteArray(j10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        r1 = new com.tencent.cloud.huiyansdkface.okio.Buffer().writeDecimalLong(r3).writeByte((int) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        if (r8 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b9, code lost:
    
        r17.size -= r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bf, code lost:
    
        if (r8 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c3, code lost:
    
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a9  */
    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lc4
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L14:
            com.tencent.cloud.huiyansdkface.okio.Segment r10 = r0.head
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L1c:
            if (r12 >= r13) goto L9d
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L6a
            r14 = 57
            if (r15 > r14) goto L6a
            int r14 = 48 - r15
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3d
            if (r16 != 0) goto L36
            long r1 = (long) r14
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L36
            goto L3d
        L36:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L74
        L3d:
            com.tencent.cloud.huiyansdkface.okio.Buffer r1 = new com.tencent.cloud.huiyansdkface.okio.Buffer
            r1.<init>()
            com.tencent.cloud.huiyansdkface.okio.Buffer r1 = r1.writeDecimalLong(r3)
            com.tencent.cloud.huiyansdkface.okio.Buffer r1 = r1.writeByte(r15)
            if (r8 != 0) goto L4f
            r1.readByte()
        L4f:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6a:
            r1 = 45
            if (r15 != r1) goto L7e
            if (r7 != 0) goto L7e
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L74:
            int r12 = r12 + 1
            int r7 = r7 + 1
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L1c
        L7e:
            if (r7 == 0) goto L82
            r9 = 1
            goto L9d
        L82:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9d:
            if (r12 != r13) goto La9
            com.tencent.cloud.huiyansdkface.okio.Segment r1 = r10.pop()
            r0.head = r1
            com.tencent.cloud.huiyansdkface.okio.SegmentPool.recycle(r10)
            goto Lab
        La9:
            r10.pos = r12
        Lab:
            if (r9 != 0) goto Lb9
            com.tencent.cloud.huiyansdkface.okio.Segment r1 = r0.head
            if (r1 != 0) goto Lb2
            goto Lb9
        Lb2:
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L14
        Lb9:
            long r1 = r0.size
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.size = r1
            if (r8 == 0) goto Lc2
            goto Lc3
        Lc2:
            long r3 = -r3
        Lc3:
            return r3
        Lc4:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j10) throws IOException {
        if (j10 >= 0) {
            readFrom(inputStream, j10, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j10);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void readFully(Buffer buffer, long j10) throws EOFException {
        long j11 = this.size;
        if (j11 >= j10) {
            buffer.write(this, j10);
        } else {
            buffer.write(this, j11);
            throw new EOFException();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int read = read(bArr, i10, bArr.length - i10);
            if (read == -1) {
                throw new EOFException();
            }
            i10 += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5 A[EDGE_INSN: B:41:0x00a5->B:38:0x00a5 BREAK  A[LOOP:0: B:4:0x000b->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.tencent.cloud.huiyansdkface.okio.Segment r6 = r15.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            com.tencent.cloud.huiyansdkface.okio.Buffer r0 = new com.tencent.cloud.huiyansdkface.okio.Buffer
            r0.<init>()
            com.tencent.cloud.huiyansdkface.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            com.tencent.cloud.huiyansdkface.okio.Buffer r0 = r0.writeByte(r10)
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
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            com.tencent.cloud.huiyansdkface.okio.Segment r7 = r6.pop()
            r15.head = r7
            com.tencent.cloud.huiyansdkface.okio.SegmentPool.recycle(r6)
            goto L9f
        L9d:
            r6.pos = r8
        L9f:
            if (r1 != 0) goto La5
            com.tencent.cloud.huiyansdkface.okio.Segment r6 = r15.head
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readInt() {
        long j10 = this.size;
        if (j10 < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
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
        this.size = j10 - 4;
        if (i17 == i11) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i17;
        }
        return i18;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readLong() {
        long j10 = this.size;
        if (j10 < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        int i11 = segment.limit;
        if (i11 - i10 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        long j11 = (bArr[i10] & 255) << 56;
        long j12 = ((bArr[r11] & 255) << 48) | j11;
        long j13 = j12 | ((bArr[r6] & 255) << 40);
        long j14 = j13 | ((bArr[r11] & 255) << 32) | ((bArr[r6] & 255) << 24);
        long j15 = j14 | ((bArr[r9] & 255) << 16);
        long j16 = j15 | ((bArr[r6] & 255) << 8);
        int i12 = i10 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        long j17 = j16 | (bArr[r9] & 255);
        this.size = j10 - 8;
        if (i12 == i11) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i12;
        }
        return j17;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public short readShort() {
        long j10 = this.size;
        if (j10 < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        int i11 = segment.limit;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
        this.size = j10 - 2;
        if (i13 == i11) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i13;
        }
        return (short) i14;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readString(long j10, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        }
        if (j10 == 0) {
            return "";
        }
        Segment segment = this.head;
        int i10 = segment.pos;
        if (i10 + j10 > segment.limit) {
            return new String(readByteArray(j10), charset);
        }
        String str = new String(segment.data, i10, (int) j10, charset);
        int i11 = (int) (segment.pos + j10);
        segment.pos = i11;
        this.size -= j10;
        if (i11 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8(long j10) throws EOFException {
        return readString(j10, Util.UTF_8);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (this.size == 0) {
            throw new EOFException();
        }
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
        if (this.size < j10) {
            throw new EOFException("size < " + i11 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b4) + ")");
        }
        for (int i13 = 1; i13 < i11; i13++) {
            long j11 = i13;
            byte b10 = getByte(j11);
            if ((b10 & 192) != 128) {
                skip(j11);
                return 65533;
            }
            i10 = (i10 << 6) | (b10 & okio.Utf8.REPLACEMENT_BYTE);
        }
        skip(j10);
        if (i10 > 1114111) {
            return 65533;
        }
        if ((i10 < 55296 || i10 > 57343) && i10 >= i12) {
            return i10;
        }
        return 65533;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j10 = this.size;
        if (j10 != 0) {
            return readUtf8(j10);
        }
        return null;
    }

    public String readUtf8Line(long j10) throws EOFException {
        String readUtf8;
        long j11 = 1;
        if (j10 > 0) {
            long j12 = j10 - 1;
            if (getByte(j12) == 13) {
                readUtf8 = readUtf8(j12);
                j11 = 2;
                skip(j11);
                return readUtf8;
            }
        }
        readUtf8 = readUtf8(j10);
        skip(j11);
        return readUtf8;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8LineStrict(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long indexOf = indexOf((byte) 10, 0L, j11);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        if (j11 < size() && getByte(j11 - 1) == 13 && getByte(j11) == 10) {
            return readUtf8Line(j11);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean request(long j10) {
        return this.size >= j10;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void require(long j10) throws EOFException {
        if (this.size < j10) {
            throw new EOFException();
        }
    }

    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int selectPrefix(com.tencent.cloud.huiyansdkface.okio.Options r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 161
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Buffer.selectPrefix(com.tencent.cloud.huiyansdkface.okio.Options, boolean):int");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            if (this.head == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j10, r0.limit - r0.pos);
            long j11 = min;
            this.size -= j11;
            j10 -= j11;
            Segment segment = this.head;
            int i10 = segment.pos + min;
            segment.pos = i10;
            if (i10 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot() {
        long j10 = this.size;
        if (j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            return snapshot((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public final ByteString snapshot(int i10) {
        return i10 == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i10);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Segment writableSegment(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment != null) {
            Segment segment2 = segment.prev;
            return (segment2.limit + i10 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment take = SegmentPool.take();
        this.head = take;
        take.prev = take;
        take.next = take;
        return take;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            Segment writableSegment = writableSegment(1);
            int min = Math.min(i10, 8192 - writableSegment.limit);
            byteBuffer.get(writableSegment.data, writableSegment.limit, min);
            i10 -= min;
            writableSegment.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer write(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = i11;
        Util.checkOffsetAndCount(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            Segment writableSegment = writableSegment(1);
            int min = Math.min(i12 - i10, 8192 - writableSegment.limit);
            System.arraycopy((Object) bArr, i10, (Object) writableSegment.data, writableSegment.limit, min);
            i10 += min;
            writableSegment.limit += min;
        }
        this.size += j10;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink write(Source source, long j10) throws IOException {
        while (j10 > 0) {
            long read = source.read(this, j10);
            if (read == -1) {
                throw new EOFException();
            }
            j10 -= read;
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink
    public void write(Buffer buffer, long j10) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.size, 0L, j10);
        while (j10 > 0) {
            Segment segment = buffer.head;
            if (j10 < segment.limit - segment.pos) {
                Segment segment2 = this.head;
                Segment segment3 = segment2 != null ? segment2.prev : null;
                if (segment3 != null && segment3.owner) {
                    if ((segment3.limit + j10) - (segment3.shared ? 0 : segment3.pos) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        segment.writeTo(segment3, (int) j10);
                        buffer.size -= j10;
                        this.size += j10;
                        return;
                    }
                }
                buffer.head = segment.split((int) j10);
            }
            Segment segment4 = buffer.head;
            long j11 = segment4.limit - segment4.pos;
            buffer.head = segment4.pop();
            Segment segment5 = this.head;
            if (segment5 == null) {
                this.head = segment4;
                segment4.prev = segment4;
                segment4.next = segment4;
            } else {
                segment5.prev.push(segment4).compact();
            }
            buffer.size -= j11;
            this.size += j11;
            j10 -= j11;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeByte(int i10) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i11 = writableSegment.limit;
        writableSegment.limit = i11 + 1;
        bArr[i11] = (byte) i10;
        this.size++;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
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
        Segment writableSegment = writableSegment(i10);
        byte[] bArr = writableSegment.data;
        int i11 = writableSegment.limit + i10;
        while (j10 != 0) {
            i11--;
            bArr[i11] = DIGITS[(int) (j10 % 10)];
            j10 /= 10;
        }
        if (z10) {
            bArr[i11 - 1] = 45;
        }
        writableSegment.limit += i10;
        this.size += i10;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i10 = writableSegment.limit;
        for (int i11 = (i10 + numberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = DIGITS[(int) (15 & j10)];
            j10 >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeInt(int i10) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i11 = writableSegment.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        writableSegment.limit = i14 + 1;
        this.size += 4;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeIntLe(int i10) {
        return writeInt(Util.reverseBytesInt(i10));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeLong(long j10) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i10 = writableSegment.limit;
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
        writableSegment.limit = i17 + 1;
        this.size += 8;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeLongLe(long j10) {
        return writeLong(Util.reverseBytesLong(j10));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeShort(int i10) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i11 = writableSegment.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        writableSegment.limit = i12 + 1;
        this.size += 2;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeShortLe(int i10) {
        return writeShort((int) Util.reverseBytesShort((short) i10));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeString(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(Util.UTF_8)) {
                return writeUtf8(str, i10, i11);
            }
            byte[] bytes = str.substring(i10, i11).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public final Buffer writeTo(OutputStream outputStream, long j10) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0L, j10);
        Segment segment = this.head;
        while (j10 > 0) {
            int min = (int) Math.min(j10, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, min);
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

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeUtf8(String str, int i10, int i11) {
        int i12;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (charAt < 128) {
                Segment writableSegment = writableSegment(1);
                byte[] bArr = writableSegment.data;
                int i13 = writableSegment.limit - i10;
                int min = Math.min(i11, 8192 - i13);
                int i14 = i10 + 1;
                bArr[i10 + i13] = (byte) charAt;
                while (i14 < min) {
                    char charAt2 = str.charAt(i14);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i14 + i13] = (byte) charAt2;
                    i14++;
                }
                int i15 = writableSegment.limit;
                int i16 = (i13 + i14) - i15;
                writableSegment.limit = i15 + i16;
                this.size += i16;
                i10 = i14;
            } else {
                if (charAt < 2048) {
                    i12 = (charAt >> 6) | 192;
                } else if (charAt < 55296 || charAt > 57343) {
                    writeByte((charAt >> '\f') | 224);
                    i12 = ((charAt >> 6) & 63) | 128;
                } else {
                    int i17 = i10 + 1;
                    char charAt3 = i17 < i11 ? str.charAt(i17) : (char) 0;
                    if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        writeByte(63);
                        i10 = i17;
                    } else {
                        int i18 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                        writeByte((i18 >> 18) | 240);
                        writeByte(((i18 >> 12) & 63) | 128);
                        writeByte(((i18 >> 6) & 63) | 128);
                        writeByte((i18 & 63) | 128);
                        i10 += 2;
                    }
                }
                writeByte(i12);
                writeByte((charAt & '?') | 128);
                i10++;
            }
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i10) {
        int i11;
        int i12;
        if (i10 >= 128) {
            if (i10 < 2048) {
                i12 = (i10 >> 6) | 192;
            } else {
                if (i10 < 65536) {
                    if (i10 >= 55296 && i10 <= 57343) {
                        writeByte(63);
                        return this;
                    }
                    i11 = (i10 >> 12) | 224;
                } else {
                    if (i10 > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
                    }
                    writeByte((i10 >> 18) | 240);
                    i11 = ((i10 >> 12) & 63) | 128;
                }
                writeByte(i11);
                i12 = ((i10 >> 6) & 63) | 128;
            }
            writeByte(i12);
            i10 = (i10 & 63) | 128;
        }
        writeByte(i10);
        return this;
    }
}
