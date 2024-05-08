package com.tencent.cloud.huiyansdkface.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.internal.midi.MidiConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        Objects.requireNonNull(source, "source == null");
        this.source = source;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(byte b4) throws IOException {
        return indexOf(b4, 0L, Long.MAX_VALUE);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(byte b4, long j10) throws IOException {
        return indexOf(b4, j10, Long.MAX_VALUE);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(byte b4, long j10, long j11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j10), Long.valueOf(j11)));
        }
        while (j10 < j11) {
            long indexOf = this.buffer.indexOf(b4, j10, j11);
            if (indexOf == -1) {
                Buffer buffer = this.buffer;
                long j12 = buffer.size;
                if (j12 >= j11 || this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    break;
                }
                j10 = Math.max(j10, j12);
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(ByteString byteString, long j10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(byteString, j10);
            if (indexOf != -1) {
                return indexOf;
            }
            Buffer buffer = this.buffer;
            long j11 = buffer.size;
            if (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, (j11 - byteString.size()) + 1);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.buffer.indexOfElement(byteString, j10);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            Buffer buffer = this.buffer;
            long j11 = buffer.size;
            if (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, j11);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.tencent.cloud.huiyansdkface.okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.buffer.size, ZipUtils.UPPER_UNIXTIME_BOUND);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                Buffer buffer = realBufferedSource.buffer;
                if (buffer.size == 0 && realBufferedSource.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                Util.checkOffsetAndCount(bArr.length, i10, i11);
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                Buffer buffer = realBufferedSource.buffer;
                if (buffer.size == 0 && realBufferedSource.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.read(bArr, i10, i11);
            }

            public String toString() {
                return ((Object) RealBufferedSource.this) + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean rangeEquals(long j10, ByteString byteString) throws IOException {
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || i10 < 0 || i11 < 0 || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            long j11 = i12 + j10;
            if (!request(1 + j11) || this.buffer.getByte(j11) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer = this.buffer;
        if (buffer.size == 0 && this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        long j10 = i11;
        Util.checkOffsetAndCount(bArr.length, i10, j10);
        Buffer buffer = this.buffer;
        if (buffer.size == 0 && this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i10, (int) Math.min(j10, this.buffer.size));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer2 = this.buffer;
        if (buffer2.size == 0 && this.source.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.buffer.read(buffer, Math.min(j10, this.buffer.size));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        Buffer buffer;
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j10 = 0;
        while (true) {
            long read = this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            buffer = this.buffer;
            if (read == -1) {
                break;
            }
            long completeSegmentByteCount = buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j10 += completeSegmentByteCount;
                sink.write(this.buffer, completeSegmentByteCount);
            }
        }
        if (buffer.size() <= 0) {
            return j10;
        }
        long size = j10 + this.buffer.size();
        Buffer buffer2 = this.buffer;
        sink.write(buffer2, buffer2.size());
        return size;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte readByte() throws IOException {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte[] readByteArray(long j10) throws IOException {
        require(j10);
        return this.buffer.readByteArray(j10);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public ByteString readByteString(long j10) throws IOException {
        require(j10);
        return this.buffer.readByteString(j10);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readDecimalLong() throws IOException {
        byte b4;
        require(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!request(i11)) {
                break;
            }
            b4 = this.buffer.getByte(i10);
            if ((b4 < 48 || b4 > 57) && !(i10 == 0 && b4 == 45)) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b4)));
        }
        return this.buffer.readDecimalLong();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void readFully(Buffer buffer, long j10) throws IOException {
        try {
            require(j10);
            this.buffer.readFully(buffer, j10);
        } catch (EOFException e2) {
            buffer.writeAll(this.buffer);
            throw e2;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e2) {
            int i10 = 0;
            while (true) {
                Buffer buffer = this.buffer;
                long j10 = buffer.size;
                if (j10 <= 0) {
                    throw e2;
                }
                int read = buffer.read(bArr, i10, (int) j10);
                if (read == -1) {
                    throw new AssertionError();
                }
                i10 += read;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L4a
            com.tencent.cloud.huiyansdkface.okio.Buffer r3 = r6.buffer
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            com.tencent.cloud.huiyansdkface.okio.Buffer r0 = r6.buffer
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readInt() throws IOException {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readLong() throws IOException {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readLongLe() throws IOException {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public short readShort() throws IOException {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readString(long j10, Charset charset) throws IOException {
        require(j10);
        if (charset != null) {
            return this.buffer.readString(j10, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8(long j10) throws IOException {
        require(j10);
        return this.buffer.readUtf8(j10);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        long j10;
        require(1L);
        byte b4 = this.buffer.getByte(0L);
        if ((b4 & MidiConstants.STATUS_PITCH_BEND) == 192) {
            j10 = 2;
        } else {
            if ((b4 & 240) != 224) {
                if ((b4 & 248) == 240) {
                    j10 = 4;
                }
                return this.buffer.readUtf8CodePoint();
            }
            j10 = 3;
        }
        require(j10);
        return this.buffer.readUtf8CodePoint();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.buffer.readUtf8Line(indexOf);
        }
        long j10 = this.buffer.size;
        if (j10 != 0) {
            return readUtf8(j10);
        }
        return null;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8LineStrict(long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long indexOf = indexOf((byte) 10, 0L, j11);
        if (indexOf != -1) {
            return this.buffer.readUtf8Line(indexOf);
        }
        if (j11 < Long.MAX_VALUE && request(j11) && this.buffer.getByte(j11 - 1) == 13 && request(1 + j11) && this.buffer.getByte(j11) == 10) {
            return this.buffer.readUtf8Line(j11);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), j10) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean request(long j10) throws IOException {
        Buffer buffer;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            buffer = this.buffer;
            if (buffer.size >= j10) {
                return true;
            }
        } while (this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void require(long j10) throws IOException {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int select(Options options) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int selectPrefix = this.buffer.selectPrefix(options, true);
            if (selectPrefix == -1) {
                return -1;
            }
            if (selectPrefix != -2) {
                this.buffer.skip(options.byteStrings[selectPrefix].size());
                return selectPrefix;
            }
        } while (this.source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void skip(long j10) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            Buffer buffer = this.buffer;
            if (buffer.size == 0 && this.source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j10, this.buffer.size());
            this.buffer.skip(min);
            j10 -= min;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + ((Object) this.source) + ")";
    }
}
