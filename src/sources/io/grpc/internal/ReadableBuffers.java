package io.grpc.internal;

import com.google.common.base.c;
import com.google.common.base.o;
import io.grpc.Detachable;
import io.grpc.HasByteBuffer;
import io.grpc.KnownLength;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ReadableBuffers {
    private static final ReadableBuffer EMPTY_BUFFER = new ByteArrayWrapper(new byte[0]);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ByteArrayWrapper extends AbstractReadableBuffer {
        public final byte[] bytes;
        public final int end;
        public int mark;
        public int offset;

        public ByteArrayWrapper(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public byte[] array() {
            return this.bytes;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public int arrayOffset() {
            return this.offset;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public boolean hasArray() {
            return true;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public void mark() {
            this.mark = this.offset;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public boolean markSupported() {
            return true;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public int readUnsignedByte() {
            checkReadable(1);
            byte[] bArr = this.bytes;
            int i10 = this.offset;
            this.offset = i10 + 1;
            return bArr[i10] & 255;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public int readableBytes() {
            return this.end - this.offset;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public void reset() {
            int i10 = this.mark;
            if (i10 != -1) {
                this.offset = i10;
                return;
            }
            throw new InvalidMarkException();
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void skipBytes(int i10) {
            checkReadable(i10);
            this.offset += i10;
        }

        public ByteArrayWrapper(byte[] bArr, int i10, int i11) {
            this.mark = -1;
            o.e(i10 >= 0, "offset must be >= 0");
            o.e(i11 >= 0, "length must be >= 0");
            int i12 = i11 + i10;
            o.e(i12 <= bArr.length, "offset + length exceeds array boundary");
            this.bytes = (byte[]) o.s(bArr, "bytes");
            this.offset = i10;
            this.end = i12;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(byte[] bArr, int i10, int i11) {
            System.arraycopy((Object) this.bytes, this.offset, (Object) bArr, i10, i11);
            this.offset += i11;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(ByteBuffer byteBuffer) {
            o.s(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            checkReadable(remaining);
            byteBuffer.put(this.bytes, this.offset, remaining);
            this.offset += remaining;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(OutputStream outputStream, int i10) throws IOException {
            checkReadable(i10);
            outputStream.write(this.bytes, this.offset, i10);
            this.offset += i10;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public ByteArrayWrapper readBytes(int i10) {
            checkReadable(i10);
            int i11 = this.offset;
            this.offset = i11 + i10;
            return new ByteArrayWrapper(this.bytes, i11, i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ByteReadableBufferWrapper extends AbstractReadableBuffer {
        public final ByteBuffer bytes;

        public ByteReadableBufferWrapper(ByteBuffer byteBuffer) {
            this.bytes = (ByteBuffer) o.s(byteBuffer, "bytes");
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public byte[] array() {
            return this.bytes.array();
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public int arrayOffset() {
            return this.bytes.arrayOffset() + this.bytes.position();
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public boolean byteBufferSupported() {
            return true;
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public ByteBuffer getByteBuffer() {
            return this.bytes.slice();
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public boolean hasArray() {
            return this.bytes.hasArray();
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public void mark() {
            this.bytes.mark();
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public boolean markSupported() {
            return true;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public int readUnsignedByte() {
            checkReadable(1);
            return this.bytes.get() & 255;
        }

        @Override // io.grpc.internal.ReadableBuffer
        public int readableBytes() {
            return this.bytes.remaining();
        }

        @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
        public void reset() {
            this.bytes.reset();
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void skipBytes(int i10) {
            checkReadable(i10);
            ByteBuffer byteBuffer = this.bytes;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(byte[] bArr, int i10, int i11) {
            checkReadable(i11);
            this.bytes.get(bArr, i10, i11);
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(ByteBuffer byteBuffer) {
            o.s(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            checkReadable(remaining);
            int limit = this.bytes.limit();
            ByteBuffer byteBuffer2 = this.bytes;
            byteBuffer2.limit(byteBuffer2.position() + remaining);
            byteBuffer.put(this.bytes);
            this.bytes.limit(limit);
        }

        @Override // io.grpc.internal.ReadableBuffer
        public void readBytes(OutputStream outputStream, int i10) throws IOException {
            checkReadable(i10);
            if (hasArray()) {
                outputStream.write(array(), arrayOffset(), i10);
                ByteBuffer byteBuffer = this.bytes;
                byteBuffer.position(byteBuffer.position() + i10);
            } else {
                byte[] bArr = new byte[i10];
                this.bytes.get(bArr);
                outputStream.write(bArr);
            }
        }

        @Override // io.grpc.internal.ReadableBuffer
        public ByteReadableBufferWrapper readBytes(int i10) {
            checkReadable(i10);
            ByteBuffer duplicate = this.bytes.duplicate();
            duplicate.limit(this.bytes.position() + i10);
            ByteBuffer byteBuffer = this.bytes;
            byteBuffer.position(byteBuffer.position() + i10);
            return new ByteReadableBufferWrapper(duplicate);
        }
    }

    private ReadableBuffers() {
    }

    public static ReadableBuffer empty() {
        return EMPTY_BUFFER;
    }

    public static ReadableBuffer ignoreClose(ReadableBuffer readableBuffer) {
        return new ForwardingReadableBuffer(readableBuffer) { // from class: io.grpc.internal.ReadableBuffers.1
            @Override // io.grpc.internal.ForwardingReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    public static InputStream openStream(ReadableBuffer readableBuffer, boolean z10) {
        if (!z10) {
            readableBuffer = ignoreClose(readableBuffer);
        }
        return new BufferInputStream(readableBuffer);
    }

    public static byte[] readArray(ReadableBuffer readableBuffer) {
        o.s(readableBuffer, "buffer");
        int readableBytes = readableBuffer.readableBytes();
        byte[] bArr = new byte[readableBytes];
        readableBuffer.readBytes(bArr, 0, readableBytes);
        return bArr;
    }

    public static String readAsString(ReadableBuffer readableBuffer, Charset charset) {
        o.s(charset, "charset");
        return new String(readArray(readableBuffer), charset);
    }

    public static String readAsStringUtf8(ReadableBuffer readableBuffer) {
        return readAsString(readableBuffer, c.f25961c);
    }

    public static ReadableBuffer wrap(byte[] bArr) {
        return new ByteArrayWrapper(bArr, 0, bArr.length);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class BufferInputStream extends InputStream implements KnownLength, HasByteBuffer, Detachable {
        private ReadableBuffer buffer;

        public BufferInputStream(ReadableBuffer readableBuffer) {
            this.buffer = (ReadableBuffer) o.s(readableBuffer, "buffer");
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.buffer.readableBytes();
        }

        @Override // io.grpc.HasByteBuffer
        public boolean byteBufferSupported() {
            return this.buffer.byteBufferSupported();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.buffer.close();
        }

        @Override // io.grpc.Detachable
        public InputStream detach() {
            ReadableBuffer readableBuffer = this.buffer;
            this.buffer = readableBuffer.readBytes(0);
            return new BufferInputStream(readableBuffer);
        }

        @Override // io.grpc.HasByteBuffer
        public ByteBuffer getByteBuffer() {
            return this.buffer.getByteBuffer();
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.buffer.mark();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.buffer.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.buffer.readableBytes() == 0) {
                return -1;
            }
            return this.buffer.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            this.buffer.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j10) throws IOException {
            int min = (int) Math.min(this.buffer.readableBytes(), j10);
            this.buffer.skipBytes(min);
            return min;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (this.buffer.readableBytes() == 0) {
                return -1;
            }
            int min = Math.min(this.buffer.readableBytes(), i11);
            this.buffer.readBytes(bArr, i10, min);
            return min;
        }
    }

    public static ReadableBuffer wrap(byte[] bArr, int i10, int i11) {
        return new ByteArrayWrapper(bArr, i10, i11);
    }

    public static ReadableBuffer wrap(ByteBuffer byteBuffer) {
        return new ByteReadableBufferWrapper(byteBuffer);
    }
}
