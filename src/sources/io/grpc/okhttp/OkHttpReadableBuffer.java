package io.grpc.okhttp;

import io.grpc.internal.AbstractReadableBuffer;
import io.grpc.internal.ReadableBuffer;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import okio.Buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class OkHttpReadableBuffer extends AbstractReadableBuffer {
    private final Buffer buffer;

    public OkHttpReadableBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    private void fakeEofExceptionMethod() throws EOFException {
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.buffer.clear();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            int read = this.buffer.read(bArr, i10, i11);
            if (read == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i11 + " bytes");
            }
            i11 -= read;
            i10 += read;
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        try {
            fakeEofExceptionMethod();
            return this.buffer.readByte() & 255;
        } catch (EOFException e2) {
            throw new IndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return (int) this.buffer.size();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i10) {
        try {
            this.buffer.skip(i10);
        } catch (EOFException e2) {
            throw new IndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream outputStream, int i10) throws IOException {
        this.buffer.writeTo(outputStream, i10);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ReadableBuffer readBytes(int i10) {
        Buffer buffer = new Buffer();
        buffer.write(this.buffer, i10);
        return new OkHttpReadableBuffer(buffer);
    }
}
