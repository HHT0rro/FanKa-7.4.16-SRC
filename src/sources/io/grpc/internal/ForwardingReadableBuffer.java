package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.o;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingReadableBuffer implements ReadableBuffer {
    private final ReadableBuffer buf;

    public ForwardingReadableBuffer(ReadableBuffer readableBuffer) {
        this.buf = (ReadableBuffer) o.s(readableBuffer, "buf");
    }

    @Override // io.grpc.internal.ReadableBuffer
    public byte[] array() {
        return this.buf.array();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean byteBufferSupported() {
        return this.buf.byteBufferSupported();
    }

    @Override // io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.buf.close();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ByteBuffer getByteBuffer() {
        return this.buf.getByteBuffer();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void mark() {
        this.buf.mark();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean markSupported() {
        return this.buf.markSupported();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] bArr, int i10, int i11) {
        this.buf.readBytes(bArr, i10, i11);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readInt() {
        return this.buf.readInt();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void reset() {
        this.buf.reset();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i10) {
        this.buf.skipBytes(i10);
    }

    public String toString() {
        return j.c(this).d("delegate", this.buf).toString();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        this.buf.readBytes(byteBuffer);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream outputStream, int i10) throws IOException {
        this.buf.readBytes(outputStream, i10);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ReadableBuffer readBytes(int i10) {
        return this.buf.readBytes(i10);
    }
}
