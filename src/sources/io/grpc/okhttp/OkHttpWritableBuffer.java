package io.grpc.okhttp;

import io.grpc.internal.WritableBuffer;
import okio.Buffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class OkHttpWritableBuffer implements WritableBuffer {
    private final Buffer buffer;
    private int readableBytes;
    private int writableBytes;

    public OkHttpWritableBuffer(Buffer buffer, int i10) {
        this.buffer = buffer;
        this.writableBytes = i10;
    }

    public Buffer buffer() {
        return this.buffer;
    }

    @Override // io.grpc.internal.WritableBuffer
    public int readableBytes() {
        return this.readableBytes;
    }

    @Override // io.grpc.internal.WritableBuffer
    public void release() {
    }

    @Override // io.grpc.internal.WritableBuffer
    public int writableBytes() {
        return this.writableBytes;
    }

    @Override // io.grpc.internal.WritableBuffer
    public void write(byte[] bArr, int i10, int i11) {
        this.buffer.write(bArr, i10, i11);
        this.writableBytes -= i11;
        this.readableBytes += i11;
    }

    @Override // io.grpc.internal.WritableBuffer
    public void write(byte b4) {
        this.buffer.writeByte((int) b4);
        this.writableBytes--;
        this.readableBytes++;
    }
}
